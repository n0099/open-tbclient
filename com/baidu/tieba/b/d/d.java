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
    private boolean bsJ;
    private List<Runnable> bsK;
    private ArrayList<h> bsL;
    private a bsM;
    private Handler handler;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bsJ = false;
        this.handler = new Handler();
        this.bsK = new ArrayList();
        this.bsL = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.bsM = aVar;
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
        if (i == 8 && !gJ(1)) {
            SA();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<h> arrayList) {
        boolean z;
        if (!x.r(arrayList)) {
            if (arrayList.get(0) != x.c(this.bsL, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.bsL = arrayList;
            int size = this.bsL.size();
            if (this.bsM != null) {
                this.bsM.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                h hVar = this.bsL.get(i);
                if (hVar != null) {
                    if (i != 0) {
                        hVar.setRotateRadius((-1.5f) - i);
                        hVar.setWriteEndCallBack(new e(this, hVar, i));
                        a(hVar, false);
                        hVar.setClickable(false);
                    } else {
                        hVar.setRotateRadius(0.0f);
                        a(hVar, true);
                        if (this.bsM != null) {
                            this.bsM.k(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(hVar, 0);
                    }
                }
            }
        }
    }

    public void Sw() {
        for (Runnable runnable : this.bsK) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void onPause() {
        if (this.bsL != null) {
            Iterator<h> it = this.bsL.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onPause();
                }
            }
        }
    }

    public void onResume() {
        if (this.bsL != null) {
            Iterator<h> it = this.bsL.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onResume();
                }
            }
        }
    }

    public void Sx() {
        this.bsJ = false;
        Sw();
        int size = this.bsL.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.bsL.get(i);
            if (hVar != null) {
                f fVar = new f(this, i, hVar);
                this.handler.postDelayed(fVar, i * 110);
                this.bsK.add(fVar);
            }
        }
    }

    public void Sy() {
        if (gJ(3)) {
            this.bsJ = false;
            Sw();
            int size = this.bsL.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bsL.get(i);
                if (hVar != null) {
                    g gVar = new g(this, i, hVar);
                    this.handler.postDelayed(gVar, ((size - i) - 1) * 110);
                    this.bsK.add(gVar);
                }
            }
        }
    }

    public boolean gJ(int i) {
        Iterator<h> it = this.bsL.iterator();
        boolean z = true;
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                boolean z2 = next.gJ(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.bsL != null) {
            Iterator<h> it = this.bsL.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void Sz() {
        if (this.bsL != null) {
            Iterator<h> it = this.bsL.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.Sz();
                }
            }
        }
    }

    public void SA() {
        if (this.bsL != null) {
            Sw();
            int size = this.bsL.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bsL.get(i);
                if (hVar != null) {
                    if (this.bsM != null) {
                        if (i == 0) {
                            this.bsM.k(i, true);
                        } else {
                            this.bsM.k(i, false);
                            hVar.setClickable(false);
                        }
                    }
                    hVar.vN();
                }
            }
            this.bsJ = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.bsJ = z;
    }

    public boolean SB() {
        return this.bsJ;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> bsQ;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.bsQ = new ArrayList<>();
            this.mSkinType = 3;
            SC();
        }

        public void SC() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.bsQ.clear();
                removeAllViews();
                return;
            }
            int size = i - this.bsQ.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView bh = bh(getContext());
                        bh.setVisibility(8);
                        addView(bh, 0);
                        this.bsQ.add(bh);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.bsQ.size() > 0) {
                            removeView(this.bsQ.get(0));
                            this.bsQ.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView bh(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int g = k.g(context, w.f.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(g, g));
            tbImageView.setImageResource(w.g.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void k(int i, boolean z) {
            ImageView imageView = (ImageView) x.c(this.bsQ, i);
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
