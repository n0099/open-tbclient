package com.baidu.tieba.b.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private boolean aXf;
    private List<Runnable> aXg;
    private ArrayList<f> aXh;
    private a aXi;
    private Handler handler;
    private Context mContext;

    public b(Context context) {
        super(context);
        this.aXf = false;
        this.handler = new Handler();
        this.aXg = new ArrayList();
        this.aXh = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.aXi = aVar;
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
        if (!ga(1)) {
            Ne();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<f> arrayList) {
        boolean z;
        if (!y.t(arrayList)) {
            if (arrayList.get(0) != y.c(this.aXh, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.aXh = arrayList;
            int size = this.aXh.size();
            if (this.aXi != null) {
                this.aXi.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                f fVar = this.aXh.get(i);
                if (fVar != null) {
                    if (i != 0) {
                        fVar.setRotateRadius((-1.5f) - i);
                        fVar.setWriteEndCallBack(new c(this, fVar, i));
                        a(fVar, false);
                        fVar.setClickable(false);
                    } else {
                        fVar.setRotateRadius(0.0f);
                        a(fVar, true);
                        if (this.aXi != null) {
                            this.aXi.l(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(fVar, 0);
                    }
                }
            }
        }
    }

    public void Na() {
        for (Runnable runnable : this.aXg) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void Nb() {
        this.aXf = false;
        Na();
        int size = this.aXh.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.aXh.get(i);
            if (fVar != null) {
                d dVar = new d(this, i, fVar);
                this.handler.postDelayed(dVar, i * 110);
                this.aXg.add(dVar);
            }
        }
    }

    public void Nc() {
        if (ga(3)) {
            this.aXf = false;
            Na();
            int size = this.aXh.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aXh.get(i);
                if (fVar != null) {
                    e eVar = new e(this, i, fVar);
                    this.handler.postDelayed(eVar, ((size - i) - 1) * 110);
                    this.aXg.add(eVar);
                }
            }
        }
    }

    public boolean ga(int i) {
        Iterator<f> it = this.aXh.iterator();
        boolean z = true;
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                boolean z2 = next.ga(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.aXh != null) {
            Iterator<f> it = this.aXh.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void Nd() {
        if (this.aXh != null) {
            Iterator<f> it = this.aXh.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.Nd();
                }
            }
        }
    }

    public void Ne() {
        if (this.aXh != null) {
            int size = this.aXh.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aXh.get(i);
                if (fVar != null) {
                    if (this.aXi != null) {
                        if (i == 0) {
                            this.aXi.l(i, true);
                        } else {
                            this.aXi.l(i, false);
                            fVar.setClickable(false);
                        }
                    }
                    fVar.vJ();
                }
            }
            this.aXf = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.aXf = z;
    }

    public boolean Nf() {
        return this.aXf;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> aXm;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.aXm = new ArrayList<>();
            this.mSkinType = 3;
            Ng();
        }

        public void Ng() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.aXm.clear();
                removeAllViews();
                return;
            }
            int size = i - this.aXm.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView aB = aB(getContext());
                        aB.setVisibility(8);
                        addView(aB, 0);
                        this.aXm.add(aB);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.aXm.size() > 0) {
                            removeView(this.aXm.get(0));
                            this.aXm.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView aB(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int e = k.e(context, t.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(e, e));
            tbImageView.setImageResource(t.f.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void l(int i, boolean z) {
            ImageView imageView = (ImageView) y.c(this.aXm, i);
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
