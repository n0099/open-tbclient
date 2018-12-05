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
    private boolean cRQ;
    private List<Runnable> cRR;
    private ArrayList<TBGLWriteView> cRS;
    private ShadeViewContainer cRT;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.cRQ = false;
        this.handler = new Handler();
        this.cRR = new ArrayList();
        this.cRS = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRQ = false;
        this.handler = new Handler();
        this.cRR = new ArrayList();
        this.cRS = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cRQ = false;
        this.handler = new Handler();
        this.cRR = new ArrayList();
        this.cRS = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cRT = shadeViewContainer;
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
        if (i == 8 && !ku(1)) {
            aoZ();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!v.I(arrayList)) {
            if (arrayList.get(0) != v.d(this.cRS, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.cRS = arrayList;
            int size = this.cRS.size();
            if (this.cRT != null) {
                this.cRT.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.cRS.get(i);
                if (tBGLWriteView != null) {
                    if (i != 0) {
                        tBGLWriteView.setRotateRadius((-1.5f) - i);
                        tBGLWriteView.setWriteEndCallBack(new c.a() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteContainer.1
                            @Override // com.baidu.tieba.animation3d.b.c.a
                            public void fk(boolean z2) {
                                if (z2) {
                                    tBGLWriteView.setVisibility(8);
                                    tBGLWriteView.setClickable(false);
                                    return;
                                }
                                tBGLWriteView.setVisibility(0);
                                tBGLWriteView.setClickable(true);
                                if (TBGLWriteContainer.this.cRT != null) {
                                    TBGLWriteContainer.this.cRT.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cRT != null) {
                            this.cRT.setShadeImageViewIsShow(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(tBGLWriteView, 0);
                    }
                }
            }
        }
    }

    public void RK() {
        for (Runnable runnable : this.cRR) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean ku(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.cRS.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            TBGLWriteView next = it.next();
            if (next != null) {
                z = next.ku(i) && z2;
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
        if (onClickListener != null && this.cRS != null) {
            Iterator<TBGLWriteView> it = this.cRS.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void aoZ() {
        if (this.cRS != null) {
            RK();
            int size = this.cRS.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.cRS.get(i);
                if (tBGLWriteView != null) {
                    if (this.cRT != null) {
                        if (i == 0) {
                            this.cRT.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cRT.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.Eq();
                }
            }
            this.cRQ = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.cRQ = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cRX;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cRX = new ArrayList<>();
            this.mSkinType = 3;
            apa();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cRX = new ArrayList<>();
            this.mSkinType = 3;
            apa();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cRX = new ArrayList<>();
            this.mSkinType = 3;
            apa();
        }

        public void apa() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cRX.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cRX.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView cn2 = cn(getContext());
                        cn2.setVisibility(8);
                        addView(cn2, 0);
                        this.cRX.add(cn2);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cRX.size() > 0) {
                            removeView(this.cRX.get(0));
                            this.cRX.remove(0);
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

        private TbImageView cn(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int h = l.h(context, e.C0210e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(h, h));
            tbImageView.setImageResource(e.f.write_shade);
            return tbImageView;
        }

        public void setShadeImageViewIsShow(int i, boolean z) {
            ImageView imageView = (ImageView) v.d(this.cRX, i);
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
