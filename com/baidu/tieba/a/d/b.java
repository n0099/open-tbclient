package com.baidu.tieba.a.d;

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
    private boolean aNu;
    private List<Runnable> aNv;
    private ArrayList<f> aNw;
    private a aNx;
    private Handler handler;
    private Context mContext;

    public b(Context context) {
        super(context);
        this.aNu = false;
        this.handler = new Handler();
        this.aNv = new ArrayList();
        this.aNw = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.aNx = aVar;
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

    public void setWriteViewList(ArrayList<f> arrayList) {
        boolean z;
        if (!y.s(arrayList)) {
            if (arrayList.get(0) != y.c(this.aNw, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.aNw = arrayList;
            int size = this.aNw.size();
            if (this.aNx != null) {
                this.aNx.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                f fVar = this.aNw.get(i);
                if (fVar != null) {
                    if (i != 0) {
                        fVar.setRotateRadius((-1.5f) - i);
                        fVar.setWriteEndCallBack(new c(this, fVar, i));
                        a(fVar, true);
                    } else {
                        fVar.setRotateRadius(0.0f);
                        a(fVar, true);
                        if (this.aNx != null) {
                            this.aNx.j(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(fVar, 0);
                    }
                }
            }
        }
    }

    public void JB() {
        for (Runnable runnable : this.aNv) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void JC() {
        this.aNu = false;
        JB();
        int size = this.aNw.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.aNw.get(i);
            if (fVar != null) {
                d dVar = new d(this, i, fVar);
                this.handler.postDelayed(dVar, i * 110);
                this.aNv.add(dVar);
            }
        }
    }

    public void JD() {
        if (fr(3)) {
            this.aNu = false;
            JB();
            int size = this.aNw.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aNw.get(i);
                if (fVar != null) {
                    e eVar = new e(this, i, fVar);
                    this.handler.postDelayed(eVar, ((size - i) - 1) * 110);
                    this.aNv.add(eVar);
                }
            }
        }
    }

    public boolean fr(int i) {
        Iterator<f> it = this.aNw.iterator();
        boolean z = true;
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                boolean z2 = next.fr(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.aNw != null) {
            Iterator<f> it = this.aNw.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void JE() {
        if (this.aNw != null) {
            Iterator<f> it = this.aNw.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.JE();
                }
            }
        }
    }

    public void JF() {
        if (this.aNw != null) {
            int size = this.aNw.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.aNw.get(i);
                if (fVar != null) {
                    if (this.aNx != null) {
                        if (i == 0) {
                            this.aNx.j(i, true);
                        } else {
                            this.aNx.j(i, false);
                        }
                    }
                    fVar.uF();
                }
            }
            this.aNu = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.aNu = z;
    }

    public boolean JG() {
        return this.aNu;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> aNB;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.aNB = new ArrayList<>();
            this.mSkinType = 3;
            JH();
        }

        public void JH() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.aNB.clear();
                removeAllViews();
                return;
            }
            int size = i - this.aNB.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView an = an(getContext());
                        an.setVisibility(8);
                        addView(an, 0);
                        this.aNB.add(an);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.aNB.size() > 0) {
                            removeView(this.aNB.get(0));
                            this.aNB.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView an(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int c = k.c(context, t.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(c, c));
            tbImageView.setImageResource(t.f.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void j(int i, boolean z) {
            ImageView imageView = (ImageView) y.c(this.aNB, i);
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
