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
    private boolean cLj;
    private List<Runnable> cLk;
    private ArrayList<TBGLWriteView> cLl;
    private ShadeViewContainer cLm;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.cLj = false;
        this.handler = new Handler();
        this.cLk = new ArrayList();
        this.cLl = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLj = false;
        this.handler = new Handler();
        this.cLk = new ArrayList();
        this.cLl = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLj = false;
        this.handler = new Handler();
        this.cLk = new ArrayList();
        this.cLl = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cLm = shadeViewContainer;
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
        if (i == 8 && !ke(1)) {
            ann();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!v.I(arrayList)) {
            if (arrayList.get(0) != v.d(this.cLl, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.cLl = arrayList;
            int size = this.cLl.size();
            if (this.cLm != null) {
                this.cLm.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.cLl.get(i);
                if (tBGLWriteView != null) {
                    if (i != 0) {
                        tBGLWriteView.setRotateRadius((-1.5f) - i);
                        tBGLWriteView.setWriteEndCallBack(new c.a() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteContainer.1
                            @Override // com.baidu.tieba.animation3d.b.c.a
                            public void fj(boolean z2) {
                                if (z2) {
                                    tBGLWriteView.setVisibility(8);
                                    tBGLWriteView.setClickable(false);
                                    return;
                                }
                                tBGLWriteView.setVisibility(0);
                                tBGLWriteView.setClickable(true);
                                if (TBGLWriteContainer.this.cLm != null) {
                                    TBGLWriteContainer.this.cLm.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cLm != null) {
                            this.cLm.setShadeImageViewIsShow(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(tBGLWriteView, 0);
                    }
                }
            }
        }
    }

    public void QE() {
        for (Runnable runnable : this.cLk) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean ke(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.cLl.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            TBGLWriteView next = it.next();
            if (next != null) {
                z = next.ke(i) && z2;
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
        if (onClickListener != null && this.cLl != null) {
            Iterator<TBGLWriteView> it = this.cLl.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void ann() {
        if (this.cLl != null) {
            QE();
            int size = this.cLl.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.cLl.get(i);
                if (tBGLWriteView != null) {
                    if (this.cLm != null) {
                        if (i == 0) {
                            this.cLm.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cLm.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.Dm();
                }
            }
            this.cLj = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.cLj = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cLq;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cLq = new ArrayList<>();
            this.mSkinType = 3;
            ano();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cLq = new ArrayList<>();
            this.mSkinType = 3;
            ano();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cLq = new ArrayList<>();
            this.mSkinType = 3;
            ano();
        }

        public void ano() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cLq.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cLq.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView cj = cj(getContext());
                        cj.setVisibility(8);
                        addView(cj, 0);
                        this.cLq.add(cj);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cLq.size() > 0) {
                            removeView(this.cLq.get(0));
                            this.cLq.remove(0);
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

        private TbImageView cj(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int h = l.h(context, e.C0200e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(h, h));
            tbImageView.setImageResource(e.f.write_shade);
            return tbImageView;
        }

        public void setShadeImageViewIsShow(int i, boolean z) {
            ImageView imageView = (ImageView) v.d(this.cLq, i);
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
