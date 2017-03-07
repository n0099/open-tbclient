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
    private boolean bqc;
    private List<Runnable> bqd;
    private ArrayList<h> bqe;
    private a bqf;
    private Handler handler;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bqc = false;
        this.handler = new Handler();
        this.bqd = new ArrayList();
        this.bqe = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.bqf = aVar;
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
        if (i == 8 && !gD(1)) {
            RF();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<h> arrayList) {
        boolean z;
        if (!x.q(arrayList)) {
            if (arrayList.get(0) != x.c(this.bqe, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.bqe = arrayList;
            int size = this.bqe.size();
            if (this.bqf != null) {
                this.bqf.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                h hVar = this.bqe.get(i);
                if (hVar != null) {
                    if (i != 0) {
                        hVar.setRotateRadius((-1.5f) - i);
                        hVar.setWriteEndCallBack(new e(this, hVar, i));
                        a(hVar, false);
                        hVar.setClickable(false);
                    } else {
                        hVar.setRotateRadius(0.0f);
                        a(hVar, true);
                        if (this.bqf != null) {
                            this.bqf.k(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(hVar, 0);
                    }
                }
            }
        }
    }

    public void RB() {
        for (Runnable runnable : this.bqd) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void onPause() {
        if (this.bqe != null) {
            Iterator<h> it = this.bqe.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onPause();
                }
            }
        }
    }

    public void onResume() {
        if (this.bqe != null) {
            Iterator<h> it = this.bqe.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onResume();
                }
            }
        }
    }

    public void RC() {
        this.bqc = false;
        RB();
        int size = this.bqe.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.bqe.get(i);
            if (hVar != null) {
                f fVar = new f(this, i, hVar);
                this.handler.postDelayed(fVar, i * 110);
                this.bqd.add(fVar);
            }
        }
    }

    public void RD() {
        if (gD(3)) {
            this.bqc = false;
            RB();
            int size = this.bqe.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bqe.get(i);
                if (hVar != null) {
                    g gVar = new g(this, i, hVar);
                    this.handler.postDelayed(gVar, ((size - i) - 1) * 110);
                    this.bqd.add(gVar);
                }
            }
        }
    }

    public boolean gD(int i) {
        Iterator<h> it = this.bqe.iterator();
        boolean z = true;
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                boolean z2 = next.gD(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.bqe != null) {
            Iterator<h> it = this.bqe.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void RE() {
        if (this.bqe != null) {
            Iterator<h> it = this.bqe.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.RE();
                }
            }
        }
    }

    public void RF() {
        if (this.bqe != null) {
            RB();
            int size = this.bqe.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.bqe.get(i);
                if (hVar != null) {
                    if (this.bqf != null) {
                        if (i == 0) {
                            this.bqf.k(i, true);
                        } else {
                            this.bqf.k(i, false);
                            hVar.setClickable(false);
                        }
                    }
                    hVar.wc();
                }
            }
            this.bqc = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.bqc = z;
    }

    public boolean RG() {
        return this.bqc;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> bqj;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.bqj = new ArrayList<>();
            this.mSkinType = 3;
            RH();
        }

        public void RH() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.bqj.clear();
                removeAllViews();
                return;
            }
            int size = i - this.bqj.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView bk = bk(getContext());
                        bk.setVisibility(8);
                        addView(bk, 0);
                        this.bqj.add(bk);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.bqj.size() > 0) {
                            removeView(this.bqj.get(0));
                            this.bqj.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView bk(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int g = k.g(context, w.f.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(g, g));
            tbImageView.setImageResource(w.g.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void k(int i, boolean z) {
            ImageView imageView = (ImageView) x.c(this.bqj, i);
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
