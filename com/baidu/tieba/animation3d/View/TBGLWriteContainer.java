package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.animation3d.b.c;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class TBGLWriteContainer extends LinearLayout {
    private boolean cKd;
    private List<Runnable> cKe;
    private ArrayList<TBGLWriteView> cKf;
    private ShadeViewContainer cKg;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.cKd = false;
        this.handler = new Handler();
        this.cKe = new ArrayList();
        this.cKf = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKd = false;
        this.handler = new Handler();
        this.cKe = new ArrayList();
        this.cKf = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKd = false;
        this.handler = new Handler();
        this.cKe = new ArrayList();
        this.cKf = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cKg = shadeViewContainer;
    }

    private void a(TBGLWriteView tBGLWriteView, boolean z) {
        if (tBGLWriteView != null) {
            if (z) {
                tBGLWriteView.setVisibility(0);
            } else {
                tBGLWriteView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8 && !jL(1)) {
            anL();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!v.J(arrayList)) {
            if (arrayList.get(0) != v.d(this.cKf, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.cKf = arrayList;
            int size = this.cKf.size();
            if (this.cKg != null) {
                this.cKg.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.cKf.get(i);
                if (tBGLWriteView != null) {
                    if (i != 0) {
                        tBGLWriteView.setRotateRadius((-1.5f) - i);
                        tBGLWriteView.setWriteEndCallBack(new c.a() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteContainer.1
                            @Override // com.baidu.tieba.animation3d.b.c.a
                            public void eY(boolean z2) {
                                if (z2) {
                                    tBGLWriteView.setVisibility(8);
                                    tBGLWriteView.setClickable(false);
                                    return;
                                }
                                tBGLWriteView.setVisibility(0);
                                tBGLWriteView.setClickable(true);
                                if (TBGLWriteContainer.this.cKg != null) {
                                    TBGLWriteContainer.this.cKg.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cKg != null) {
                            this.cKg.setShadeImageViewIsShow(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(tBGLWriteView, 0);
                    }
                }
            }
        }
    }

    public void Qv() {
        for (Runnable runnable : this.cKe) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean jL(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.cKf.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            TBGLWriteView next = it.next();
            if (next != null) {
                z = next.jL(i) && z2;
                if (!z) {
                    return z;
                }
            } else {
                z = z2;
            }
            z2 = z;
        }
        return z2;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.cKf != null) {
            Iterator<TBGLWriteView> it = this.cKf.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void anL() {
        if (this.cKf != null) {
            Qv();
            int size = this.cKf.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.cKf.get(i);
                if (tBGLWriteView != null) {
                    if (this.cKg != null) {
                        if (i == 0) {
                            this.cKg.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cKg.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.Df();
                }
            }
            this.cKd = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.cKd = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cKk;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cKk = new ArrayList<>();
            this.mSkinType = 3;
            anM();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cKk = new ArrayList<>();
            this.mSkinType = 3;
            anM();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cKk = new ArrayList<>();
            this.mSkinType = 3;
            anM();
        }

        public void anM() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cKk.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cKk.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView co = co(getContext());
                        co.setVisibility(8);
                        addView(co, 0);
                        this.cKk.add(co);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cKk.size() > 0) {
                            removeView(this.cKk.get(0));
                            this.cKk.remove(0);
                            size = i3;
                        } else {
                            size = i3;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView co(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int h = l.h(context, e.C0175e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(h, h));
            tbImageView.setImageResource(e.f.write_shade);
            return tbImageView;
        }

        public void setShadeImageViewIsShow(int i, boolean z) {
            ImageView imageView = (ImageView) v.d(this.cKk, i);
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
