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
    private boolean aQN;
    private List<Runnable> aQO;
    private ArrayList<f> aQP;
    private a aQQ;
    private Handler handler;
    private Context mContext;

    public b(Context context) {
        super(context);
        this.aQN = false;
        this.handler = new Handler();
        this.aQO = new ArrayList();
        this.aQP = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.aQQ = aVar;
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
        if (!fD(1)) {
            KD();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<f> arrayList) {
        boolean z;
        if (!y.t(arrayList)) {
            if (arrayList.get(0) != y.c(this.aQP, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.aQP = arrayList;
            int size = this.aQP.size();
            if (this.aQQ != null) {
                this.aQQ.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                f fVar = this.aQP.get(i);
                if (fVar != null) {
                    if (i != 0) {
                        fVar.setRotateRadius((-1.5f) - i);
                        fVar.setWriteEndCallBack(new c(this, fVar, i));
                        a(fVar, false);
                        fVar.setClickable(false);
                    } else {
                        fVar.setRotateRadius(0.0f);
                        a(fVar, true);
                        if (this.aQQ != null) {
                            this.aQQ.k(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(fVar, 0);
                    }
                }
            }
        }
    }

    public void Kz() {
        for (Runnable runnable : this.aQO) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void KA() {
        this.aQN = false;
        Kz();
        int size = this.aQP.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.aQP.get(i);
            if (fVar != null) {
                d dVar = new d(this, i, fVar);
                this.handler.postDelayed(dVar, i * 110);
                this.aQO.add(dVar);
            }
        }
    }

    public void KB() {
        if (fD(3)) {
            this.aQN = false;
            Kz();
            int size = this.aQP.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aQP.get(i);
                if (fVar != null) {
                    e eVar = new e(this, i, fVar);
                    this.handler.postDelayed(eVar, ((size - i) - 1) * 110);
                    this.aQO.add(eVar);
                }
            }
        }
    }

    public boolean fD(int i) {
        Iterator<f> it = this.aQP.iterator();
        boolean z = true;
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                boolean z2 = next.fD(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.aQP != null) {
            Iterator<f> it = this.aQP.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void KC() {
        if (this.aQP != null) {
            Iterator<f> it = this.aQP.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.KC();
                }
            }
        }
    }

    public void KD() {
        if (this.aQP != null) {
            int size = this.aQP.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aQP.get(i);
                if (fVar != null) {
                    if (this.aQQ != null) {
                        if (i == 0) {
                            this.aQQ.k(i, true);
                        } else {
                            this.aQQ.k(i, false);
                            fVar.setClickable(false);
                        }
                    }
                    fVar.uE();
                }
            }
            this.aQN = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.aQN = z;
    }

    public boolean KE() {
        return this.aQN;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> aQU;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.aQU = new ArrayList<>();
            this.mSkinType = 3;
            KF();
        }

        public void KF() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.aQU.clear();
                removeAllViews();
                return;
            }
            int size = i - this.aQU.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView ao = ao(getContext());
                        ao.setVisibility(8);
                        addView(ao, 0);
                        this.aQU.add(ao);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.aQU.size() > 0) {
                            removeView(this.aQU.get(0));
                            this.aQU.remove(0);
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

        public void k(int i, boolean z) {
            ImageView imageView = (ImageView) y.c(this.aQU, i);
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
