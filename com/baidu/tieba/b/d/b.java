package com.baidu.tieba.b.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private boolean aRH;
    private List<Runnable> aRI;
    private ArrayList<f> aRJ;
    private a aRK;
    private Handler handler;
    private Context mContext;

    public b(Context context) {
        super(context);
        this.aRH = false;
        this.handler = new Handler();
        this.aRI = new ArrayList();
        this.aRJ = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.aRK = aVar;
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
        if (!fC(1)) {
            KC();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<f> arrayList) {
        boolean z;
        if (!y.t(arrayList)) {
            if (arrayList.get(0) != y.c(this.aRJ, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.aRJ = arrayList;
            int size = this.aRJ.size();
            if (this.aRK != null) {
                this.aRK.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                f fVar = this.aRJ.get(i);
                if (fVar != null) {
                    if (i != 0) {
                        fVar.setRotateRadius((-1.5f) - i);
                        fVar.setWriteEndCallBack(new c(this, fVar, i));
                        a(fVar, false);
                        fVar.setClickable(false);
                    } else {
                        fVar.setRotateRadius(0.0f);
                        a(fVar, true);
                        if (this.aRK != null) {
                            this.aRK.l(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(fVar, 0);
                    }
                }
            }
        }
    }

    public void Ky() {
        for (Runnable runnable : this.aRI) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void Kz() {
        this.aRH = false;
        Ky();
        int size = this.aRJ.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.aRJ.get(i);
            if (fVar != null) {
                d dVar = new d(this, i, fVar);
                this.handler.postDelayed(dVar, i * 110);
                this.aRI.add(dVar);
            }
        }
    }

    public void KA() {
        if (fC(3)) {
            this.aRH = false;
            Ky();
            int size = this.aRJ.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aRJ.get(i);
                if (fVar != null) {
                    e eVar = new e(this, i, fVar);
                    this.handler.postDelayed(eVar, ((size - i) - 1) * 110);
                    this.aRI.add(eVar);
                }
            }
        }
    }

    public boolean fC(int i) {
        Iterator<f> it = this.aRJ.iterator();
        boolean z = true;
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                boolean z2 = next.fC(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.aRJ != null) {
            Iterator<f> it = this.aRJ.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void KB() {
        if (this.aRJ != null) {
            Iterator<f> it = this.aRJ.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.KB();
                }
            }
        }
    }

    public void KC() {
        if (this.aRJ != null) {
            int size = this.aRJ.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aRJ.get(i);
                if (fVar != null) {
                    if (this.aRK != null) {
                        if (i == 0) {
                            this.aRK.l(i, true);
                        } else {
                            this.aRK.l(i, false);
                            fVar.setClickable(false);
                        }
                    }
                    fVar.uE();
                }
            }
            this.aRH = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.aRH = z;
    }

    public boolean KD() {
        return this.aRH;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> aRO;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.aRO = new ArrayList<>();
            this.mSkinType = 3;
            KE();
        }

        public void KE() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.aRO.clear();
                removeAllViews();
                return;
            }
            int size = i - this.aRO.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView ao = ao(getContext());
                        ao.setVisibility(8);
                        addView(ao, 0);
                        this.aRO.add(ao);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.aRO.size() > 0) {
                            removeView(this.aRO.get(0));
                            this.aRO.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView ao(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int c = k.c(context, u.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(c, c));
            tbImageView.setImageResource(u.f.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void l(int i, boolean z) {
            ImageView imageView = (ImageView) y.c(this.aRO, i);
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
