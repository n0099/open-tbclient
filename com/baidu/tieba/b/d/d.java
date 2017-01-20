package com.baidu.tieba.b.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private boolean bjt;
    private List<Runnable> bju;
    private ArrayList<h> bjv;
    private a bjw;
    private Handler handler;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bjt = false;
        this.handler = new Handler();
        this.bju = new ArrayList();
        this.bjv = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.bjw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, boolean z) {
        if (hVar != null) {
            if (z) {
                hVar.setVisibility(0);
            } else {
                hVar.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8 && !gG(1)) {
            QN();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<h> arrayList) {
        boolean z;
        if (!w.s(arrayList)) {
            if (arrayList.get(0) != w.c(this.bjv, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.bjv = arrayList;
            int size = this.bjv.size();
            if (this.bjw != null) {
                this.bjw.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                h hVar = this.bjv.get(i);
                if (hVar != null) {
                    if (i != 0) {
                        hVar.setRotateRadius((-1.5f) - i);
                        hVar.setWriteEndCallBack(new e(this, hVar, i));
                        a(hVar, false);
                        hVar.setClickable(false);
                    } else {
                        hVar.setRotateRadius(0.0f);
                        a(hVar, true);
                        if (this.bjw != null) {
                            this.bjw.k(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(hVar, 0);
                    }
                }
            }
        }
    }

    public void QJ() {
        for (Runnable runnable : this.bju) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void onPause() {
        if (this.bjv != null) {
            Iterator<h> it = this.bjv.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onPause();
                }
            }
        }
    }

    public void onResume() {
        if (this.bjv != null) {
            Iterator<h> it = this.bjv.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onResume();
                }
            }
        }
    }

    public void QK() {
        this.bjt = false;
        QJ();
        int size = this.bjv.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.bjv.get(i);
            if (hVar != null) {
                f fVar = new f(this, i, hVar);
                this.handler.postDelayed(fVar, i * 110);
                this.bju.add(fVar);
            }
        }
    }

    public void QL() {
        if (gG(3)) {
            this.bjt = false;
            QJ();
            int size = this.bjv.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bjv.get(i);
                if (hVar != null) {
                    g gVar = new g(this, i, hVar);
                    this.handler.postDelayed(gVar, ((size - i) - 1) * 110);
                    this.bju.add(gVar);
                }
            }
        }
    }

    public boolean gG(int i) {
        Iterator<h> it = this.bjv.iterator();
        boolean z = true;
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                boolean z2 = next.gG(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.bjv != null) {
            Iterator<h> it = this.bjv.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void QM() {
        if (this.bjv != null) {
            Iterator<h> it = this.bjv.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.QM();
                }
            }
        }
    }

    public void QN() {
        if (this.bjv != null) {
            QJ();
            int size = this.bjv.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bjv.get(i);
                if (hVar != null) {
                    if (this.bjw != null) {
                        if (i == 0) {
                            this.bjw.k(i, true);
                        } else {
                            this.bjw.k(i, false);
                            hVar.setClickable(false);
                        }
                    }
                    hVar.vF();
                }
            }
            this.bjt = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.bjt = z;
    }

    public boolean QO() {
        return this.bjt;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> bjA;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.bjA = new ArrayList<>();
            this.mSkinType = 3;
            QP();
        }

        public void QP() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.bjA.clear();
                removeAllViews();
                return;
            }
            int size = i - this.bjA.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView aL = aL(getContext());
                        aL.setVisibility(8);
                        addView(aL, 0);
                        this.bjA.add(aL);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.bjA.size() > 0) {
                            removeView(this.bjA.get(0));
                            this.bjA.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView aL(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int e = k.e(context, r.f.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(e, e));
            tbImageView.setImageResource(r.g.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void k(int i, boolean z) {
            ImageView imageView = (ImageView) w.c(this.bjA, i);
            if (imageView != null) {
                if (z) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
        }
    }
}
