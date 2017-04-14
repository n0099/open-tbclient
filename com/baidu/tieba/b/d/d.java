package com.baidu.tieba.b.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private boolean bpV;
    private List<Runnable> bpW;
    private ArrayList<h> bpX;
    private a bpY;
    private Handler handler;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bpV = false;
        this.handler = new Handler();
        this.bpW = new ArrayList();
        this.bpX = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.bpY = aVar;
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
            Sd();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<h> arrayList) {
        boolean z;
        if (!x.q(arrayList)) {
            if (arrayList.get(0) != x.c(this.bpX, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.bpX = arrayList;
            int size = this.bpX.size();
            if (this.bpY != null) {
                this.bpY.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                h hVar = this.bpX.get(i);
                if (hVar != null) {
                    if (i != 0) {
                        hVar.setRotateRadius((-1.5f) - i);
                        hVar.setWriteEndCallBack(new e(this, hVar, i));
                        a(hVar, false);
                        hVar.setClickable(false);
                    } else {
                        hVar.setRotateRadius(0.0f);
                        a(hVar, true);
                        if (this.bpY != null) {
                            this.bpY.k(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(hVar, 0);
                    }
                }
            }
        }
    }

    public void RZ() {
        for (Runnable runnable : this.bpW) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void onPause() {
        if (this.bpX != null) {
            Iterator<h> it = this.bpX.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onPause();
                }
            }
        }
    }

    public void onResume() {
        if (this.bpX != null) {
            Iterator<h> it = this.bpX.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onResume();
                }
            }
        }
    }

    public void Sa() {
        this.bpV = false;
        RZ();
        int size = this.bpX.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.bpX.get(i);
            if (hVar != null) {
                f fVar = new f(this, i, hVar);
                this.handler.postDelayed(fVar, i * 110);
                this.bpW.add(fVar);
            }
        }
    }

    public void Sb() {
        if (gG(3)) {
            this.bpV = false;
            RZ();
            int size = this.bpX.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bpX.get(i);
                if (hVar != null) {
                    g gVar = new g(this, i, hVar);
                    this.handler.postDelayed(gVar, ((size - i) - 1) * 110);
                    this.bpW.add(gVar);
                }
            }
        }
    }

    public boolean gG(int i) {
        Iterator<h> it = this.bpX.iterator();
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
        if (onClickListener != null && this.bpX != null) {
            Iterator<h> it = this.bpX.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void Sc() {
        if (this.bpX != null) {
            Iterator<h> it = this.bpX.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.Sc();
                }
            }
        }
    }

    public void Sd() {
        if (this.bpX != null) {
            RZ();
            int size = this.bpX.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bpX.get(i);
                if (hVar != null) {
                    if (this.bpY != null) {
                        if (i == 0) {
                            this.bpY.k(i, true);
                        } else {
                            this.bpY.k(i, false);
                            hVar.setClickable(false);
                        }
                    }
                    hVar.wz();
                }
            }
            this.bpV = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.bpV = z;
    }

    public boolean Se() {
        return this.bpV;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> bqc;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.bqc = new ArrayList<>();
            this.mSkinType = 3;
            Sf();
        }

        public void Sf() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.bqc.clear();
                removeAllViews();
                return;
            }
            int size = i - this.bqc.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView be = be(getContext());
                        be.setVisibility(8);
                        addView(be, 0);
                        this.bqc.add(be);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.bqc.size() > 0) {
                            removeView(this.bqc.get(0));
                            this.bqc.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView be(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int g = k.g(context, w.f.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(g, g));
            tbImageView.setImageResource(w.g.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void k(int i, boolean z) {
            ImageView imageView = (ImageView) x.c(this.bqc, i);
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
