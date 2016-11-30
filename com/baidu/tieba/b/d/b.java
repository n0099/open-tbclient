package com.baidu.tieba.b.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private boolean baS;
    private List<Runnable> baT;
    private ArrayList<f> baU;
    private a baV;
    private Handler handler;
    private Context mContext;

    public b(Context context) {
        super(context);
        this.baS = false;
        this.handler = new Handler();
        this.baT = new ArrayList();
        this.baU = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.baV = aVar;
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
            OI();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<f> arrayList) {
        boolean z;
        if (!x.t(arrayList)) {
            if (arrayList.get(0) != x.c(this.baU, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.baU = arrayList;
            int size = this.baU.size();
            if (this.baV != null) {
                this.baV.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                f fVar = this.baU.get(i);
                if (fVar != null) {
                    if (i != 0) {
                        fVar.setRotateRadius((-1.5f) - i);
                        fVar.setWriteEndCallBack(new c(this, fVar, i));
                        a(fVar, false);
                        fVar.setClickable(false);
                    } else {
                        fVar.setRotateRadius(0.0f);
                        a(fVar, true);
                        if (this.baV != null) {
                            this.baV.l(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(fVar, 0);
                    }
                }
            }
        }
    }

    public void OE() {
        for (Runnable runnable : this.baT) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void onPause() {
        if (this.baU != null) {
            Iterator<f> it = this.baU.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onPause();
                }
            }
        }
    }

    public void onResume() {
        if (this.baU != null) {
            Iterator<f> it = this.baU.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onResume();
                }
            }
        }
    }

    public void OF() {
        this.baS = false;
        OE();
        int size = this.baU.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.baU.get(i);
            if (fVar != null) {
                d dVar = new d(this, i, fVar);
                this.handler.postDelayed(dVar, i * 110);
                this.baT.add(dVar);
            }
        }
    }

    public void OG() {
        if (gf(3)) {
            this.baS = false;
            OE();
            int size = this.baU.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.baU.get(i);
                if (fVar != null) {
                    e eVar = new e(this, i, fVar);
                    this.handler.postDelayed(eVar, ((size - i) - 1) * 110);
                    this.baT.add(eVar);
                }
            }
        }
    }

    public boolean gf(int i) {
        Iterator<f> it = this.baU.iterator();
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
        if (onClickListener != null && this.baU != null) {
            Iterator<f> it = this.baU.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void OH() {
        if (this.baU != null) {
            Iterator<f> it = this.baU.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.OH();
                }
            }
        }
    }

    public void OI() {
        if (this.baU != null) {
            int size = this.baU.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.baU.get(i);
                if (fVar != null) {
                    if (this.baV != null) {
                        if (i == 0) {
                            this.baV.l(i, true);
                        } else {
                            this.baV.l(i, false);
                            fVar.setClickable(false);
                        }
                    }
                    fVar.wb();
                }
            }
            this.baS = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.baS = z;
    }

    public boolean OJ() {
        return this.baS;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> baZ;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.baZ = new ArrayList<>();
            this.mSkinType = 3;
            OK();
        }

        public void OK() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.baZ.clear();
                removeAllViews();
                return;
            }
            int size = i - this.baZ.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView aL = aL(getContext());
                        aL.setVisibility(8);
                        addView(aL, 0);
                        this.baZ.add(aL);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.baZ.size() > 0) {
                            removeView(this.baZ.get(0));
                            this.baZ.remove(0);
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
            int e = k.e(context, r.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(e, e));
            tbImageView.setImageResource(r.f.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void l(int i, boolean z) {
            ImageView imageView = (ImageView) x.c(this.baZ, i);
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
