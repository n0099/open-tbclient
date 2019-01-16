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
    private boolean cVr;
    private List<Runnable> cVs;
    private ArrayList<TBGLWriteView> cVt;
    private ShadeViewContainer cVu;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.cVr = false;
        this.handler = new Handler();
        this.cVs = new ArrayList();
        this.cVt = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVr = false;
        this.handler = new Handler();
        this.cVs = new ArrayList();
        this.cVt = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVr = false;
        this.handler = new Handler();
        this.cVs = new ArrayList();
        this.cVt = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cVu = shadeViewContainer;
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
        if (i == 8 && !kG(1)) {
            aqm();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!v.I(arrayList)) {
            if (arrayList.get(0) != v.d(this.cVt, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.cVt = arrayList;
            int size = this.cVt.size();
            if (this.cVu != null) {
                this.cVu.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.cVt.get(i);
                if (tBGLWriteView != null) {
                    if (i != 0) {
                        tBGLWriteView.setRotateRadius((-1.5f) - i);
                        tBGLWriteView.setWriteEndCallBack(new c.a() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteContainer.1
                            @Override // com.baidu.tieba.animation3d.b.c.a
                            public void fp(boolean z2) {
                                if (z2) {
                                    tBGLWriteView.setVisibility(8);
                                    tBGLWriteView.setClickable(false);
                                    return;
                                }
                                tBGLWriteView.setVisibility(0);
                                tBGLWriteView.setClickable(true);
                                if (TBGLWriteContainer.this.cVu != null) {
                                    TBGLWriteContainer.this.cVu.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cVu != null) {
                            this.cVu.setShadeImageViewIsShow(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(tBGLWriteView, 0);
                    }
                }
            }
        }
    }

    public void Si() {
        for (Runnable runnable : this.cVs) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean kG(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.cVt.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            TBGLWriteView next = it.next();
            if (next != null) {
                z = next.kG(i) && z2;
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
        if (onClickListener != null && this.cVt != null) {
            Iterator<TBGLWriteView> it = this.cVt.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void aqm() {
        if (this.cVt != null) {
            Si();
            int size = this.cVt.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.cVt.get(i);
                if (tBGLWriteView != null) {
                    if (this.cVu != null) {
                        if (i == 0) {
                            this.cVu.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cVu.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.ED();
                }
            }
            this.cVr = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.cVr = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cVy;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cVy = new ArrayList<>();
            this.mSkinType = 3;
            aqn();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cVy = new ArrayList<>();
            this.mSkinType = 3;
            aqn();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cVy = new ArrayList<>();
            this.mSkinType = 3;
            aqn();
        }

        public void aqn() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cVy.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cVy.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView cn2 = cn(getContext());
                        cn2.setVisibility(8);
                        addView(cn2, 0);
                        this.cVy.add(cn2);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cVy.size() > 0) {
                            removeView(this.cVy.get(0));
                            this.cVy.remove(0);
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
            ImageView imageView = (ImageView) v.d(this.cVy, i);
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
