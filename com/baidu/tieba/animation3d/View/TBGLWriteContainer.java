package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.animation3d.b.c;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class TBGLWriteContainer extends LinearLayout {
    private boolean ctl;
    private List<Runnable> ctm;
    private ArrayList<TBGLWriteView> ctn;
    private ShadeViewContainer cto;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.ctl = false;
        this.handler = new Handler();
        this.ctm = new ArrayList();
        this.ctn = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctl = false;
        this.handler = new Handler();
        this.ctm = new ArrayList();
        this.ctn = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ctl = false;
        this.handler = new Handler();
        this.ctm = new ArrayList();
        this.ctn = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cto = shadeViewContainer;
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
        if (i == 8 && !iD(1)) {
            ahT();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!w.A(arrayList)) {
            if (arrayList.get(0) != w.d(this.ctn, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.ctn = arrayList;
            int size = this.ctn.size();
            if (this.cto != null) {
                this.cto.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.ctn.get(i);
                if (tBGLWriteView != null) {
                    if (i != 0) {
                        tBGLWriteView.setRotateRadius((-1.5f) - i);
                        tBGLWriteView.setWriteEndCallBack(new c.a() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteContainer.1
                            @Override // com.baidu.tieba.animation3d.b.c.a
                            public void em(boolean z2) {
                                if (z2) {
                                    tBGLWriteView.setVisibility(8);
                                    tBGLWriteView.setClickable(false);
                                    return;
                                }
                                tBGLWriteView.setVisibility(0);
                                tBGLWriteView.setClickable(true);
                                if (TBGLWriteContainer.this.cto != null) {
                                    TBGLWriteContainer.this.cto.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cto != null) {
                            this.cto.setShadeImageViewIsShow(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(tBGLWriteView, 0);
                    }
                }
            }
        }
    }

    public void Ng() {
        for (Runnable runnable : this.ctm) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean iD(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.ctn.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            TBGLWriteView next = it.next();
            if (next != null) {
                z = next.iD(i) && z2;
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
        if (onClickListener != null && this.ctn != null) {
            Iterator<TBGLWriteView> it = this.ctn.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void ahT() {
        if (this.ctn != null) {
            Ng();
            int size = this.ctn.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.ctn.get(i);
                if (tBGLWriteView != null) {
                    if (this.cto != null) {
                        if (i == 0) {
                            this.cto.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cto.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.Ag();
                }
            }
            this.ctl = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.ctl = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cts;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cts = new ArrayList<>();
            this.mSkinType = 3;
            ahU();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cts = new ArrayList<>();
            this.mSkinType = 3;
            ahU();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cts = new ArrayList<>();
            this.mSkinType = 3;
            ahU();
        }

        public void ahU() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cts.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cts.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView bt = bt(getContext());
                        bt.setVisibility(8);
                        addView(bt, 0);
                        this.cts.add(bt);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cts.size() > 0) {
                            removeView(this.cts.get(0));
                            this.cts.remove(0);
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

        private TbImageView bt(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int e = l.e(context, d.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(e, e));
            tbImageView.setImageResource(d.f.write_shade);
            return tbImageView;
        }

        public void setShadeImageViewIsShow(int i, boolean z) {
            ImageView imageView = (ImageView) w.d(this.cts, i);
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
