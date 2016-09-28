package com.baidu.tieba.b.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private boolean aXJ;
    private List<Runnable> aXK;
    private ArrayList<f> aXL;
    private a aXM;
    private Handler handler;
    private Context mContext;

    public b(Context context) {
        super(context);
        this.aXJ = false;
        this.handler = new Handler();
        this.aXK = new ArrayList();
        this.aXL = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.aXM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, boolean z) {
        if (fVar != null) {
            if (z) {
                fVar.setVisibility(0);
            } else {
                fVar.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!gf(1)) {
            NF();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<f> arrayList) {
        boolean z;
        if (!y.t(arrayList)) {
            if (arrayList.get(0) != y.c(this.aXL, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.aXL = arrayList;
            int size = this.aXL.size();
            if (this.aXM != null) {
                this.aXM.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                f fVar = this.aXL.get(i);
                if (fVar != null) {
                    if (i != 0) {
                        fVar.setRotateRadius((-1.5f) - i);
                        fVar.setWriteEndCallBack(new c(this, fVar, i));
                        a(fVar, false);
                        fVar.setClickable(false);
                    } else {
                        fVar.setRotateRadius(0.0f);
                        a(fVar, true);
                        if (this.aXM != null) {
                            this.aXM.l(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(fVar, 0);
                    }
                }
            }
        }
    }

    public void NB() {
        for (Runnable runnable : this.aXK) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void NC() {
        this.aXJ = false;
        NB();
        int size = this.aXL.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.aXL.get(i);
            if (fVar != null) {
                d dVar = new d(this, i, fVar);
                this.handler.postDelayed(dVar, i * 110);
                this.aXK.add(dVar);
            }
        }
    }

    public void ND() {
        if (gf(3)) {
            this.aXJ = false;
            NB();
            int size = this.aXL.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aXL.get(i);
                if (fVar != null) {
                    e eVar = new e(this, i, fVar);
                    this.handler.postDelayed(eVar, ((size - i) - 1) * 110);
                    this.aXK.add(eVar);
                }
            }
        }
    }

    public boolean gf(int i) {
        Iterator<f> it = this.aXL.iterator();
        boolean z = true;
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                boolean z2 = next.gf(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.aXL != null) {
            Iterator<f> it = this.aXL.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void NE() {
        if (this.aXL != null) {
            Iterator<f> it = this.aXL.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.NE();
                }
            }
        }
    }

    public void NF() {
        if (this.aXL != null) {
            int size = this.aXL.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aXL.get(i);
                if (fVar != null) {
                    if (this.aXM != null) {
                        if (i == 0) {
                            this.aXM.l(i, true);
                        } else {
                            this.aXM.l(i, false);
                            fVar.setClickable(false);
                        }
                    }
                    fVar.vX();
                }
            }
            this.aXJ = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.aXJ = z;
    }

    public boolean NG() {
        return this.aXJ;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> aXQ;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.aXQ = new ArrayList<>();
            this.mSkinType = 3;
            NH();
        }

        public void NH() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.aXQ.clear();
                removeAllViews();
                return;
            }
            int size = i - this.aXQ.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView az = az(getContext());
                        az.setVisibility(8);
                        addView(az, 0);
                        this.aXQ.add(az);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.aXQ.size() > 0) {
                            removeView(this.aXQ.get(0));
                            this.aXQ.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView az(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int e = k.e(context, r.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(e, e));
            tbImageView.setImageResource(r.f.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void l(int i, boolean z) {
            ImageView imageView = (ImageView) y.c(this.aXQ, i);
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
