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
    private boolean aZF;
    private List<Runnable> aZG;
    private ArrayList<f> aZH;
    private a aZI;
    private Handler handler;
    private Context mContext;

    public b(Context context) {
        super(context);
        this.aZF = false;
        this.handler = new Handler();
        this.aZG = new ArrayList();
        this.aZH = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.aZI = aVar;
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
        if (i == 8 && !ge(1)) {
            NU();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<f> arrayList) {
        boolean z;
        if (!x.t(arrayList)) {
            if (arrayList.get(0) != x.c(this.aZH, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.aZH = arrayList;
            int size = this.aZH.size();
            if (this.aZI != null) {
                this.aZI.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                f fVar = this.aZH.get(i);
                if (fVar != null) {
                    if (i != 0) {
                        fVar.setRotateRadius((-1.5f) - i);
                        fVar.setWriteEndCallBack(new c(this, fVar, i));
                        a(fVar, false);
                        fVar.setClickable(false);
                    } else {
                        fVar.setRotateRadius(0.0f);
                        a(fVar, true);
                        if (this.aZI != null) {
                            this.aZI.l(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(fVar, 0);
                    }
                }
            }
        }
    }

    public void NQ() {
        for (Runnable runnable : this.aZG) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void onPause() {
        if (this.aZH != null) {
            Iterator<f> it = this.aZH.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onPause();
                }
            }
        }
    }

    public void onResume() {
        if (this.aZH != null) {
            Iterator<f> it = this.aZH.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onResume();
                }
            }
        }
    }

    public void NR() {
        this.aZF = false;
        NQ();
        int size = this.aZH.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.aZH.get(i);
            if (fVar != null) {
                d dVar = new d(this, i, fVar);
                this.handler.postDelayed(dVar, i * 110);
                this.aZG.add(dVar);
            }
        }
    }

    public void NS() {
        if (ge(3)) {
            this.aZF = false;
            NQ();
            int size = this.aZH.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aZH.get(i);
                if (fVar != null) {
                    e eVar = new e(this, i, fVar);
                    this.handler.postDelayed(eVar, ((size - i) - 1) * 110);
                    this.aZG.add(eVar);
                }
            }
        }
    }

    public boolean ge(int i) {
        Iterator<f> it = this.aZH.iterator();
        boolean z = true;
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                boolean z2 = next.ge(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.aZH != null) {
            Iterator<f> it = this.aZH.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void NT() {
        if (this.aZH != null) {
            Iterator<f> it = this.aZH.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.NT();
                }
            }
        }
    }

    public void NU() {
        if (this.aZH != null) {
            int size = this.aZH.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aZH.get(i);
                if (fVar != null) {
                    if (this.aZI != null) {
                        if (i == 0) {
                            this.aZI.l(i, true);
                        } else {
                            this.aZI.l(i, false);
                            fVar.setClickable(false);
                        }
                    }
                    fVar.vL();
                }
            }
            this.aZF = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.aZF = z;
    }

    public boolean NV() {
        return this.aZF;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> aZM;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.aZM = new ArrayList<>();
            this.mSkinType = 3;
            NW();
        }

        public void NW() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.aZM.clear();
                removeAllViews();
                return;
            }
            int size = i - this.aZM.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView aJ = aJ(getContext());
                        aJ.setVisibility(8);
                        addView(aJ, 0);
                        this.aZM.add(aJ);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.aZM.size() > 0) {
                            removeView(this.aZM.get(0));
                            this.aZM.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView aJ(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int e = k.e(context, r.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(e, e));
            tbImageView.setImageResource(r.f.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void l(int i, boolean z) {
            ImageView imageView = (ImageView) x.c(this.aZM, i);
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
