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
    private boolean cUG;
    private List<Runnable> cUH;
    private ArrayList<TBGLWriteView> cUI;
    private ShadeViewContainer cUJ;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.cUG = false;
        this.handler = new Handler();
        this.cUH = new ArrayList();
        this.cUI = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUG = false;
        this.handler = new Handler();
        this.cUH = new ArrayList();
        this.cUI = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cUG = false;
        this.handler = new Handler();
        this.cUH = new ArrayList();
        this.cUI = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cUJ = shadeViewContainer;
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
            apP();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!v.I(arrayList)) {
            if (arrayList.get(0) != v.d(this.cUI, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.cUI = arrayList;
            int size = this.cUI.size();
            if (this.cUJ != null) {
                this.cUJ.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.cUI.get(i);
                if (tBGLWriteView != null) {
                    if (i != 0) {
                        tBGLWriteView.setRotateRadius((-1.5f) - i);
                        tBGLWriteView.setWriteEndCallBack(new c.a() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteContainer.1
                            @Override // com.baidu.tieba.animation3d.b.c.a
                            public void fm(boolean z2) {
                                if (z2) {
                                    tBGLWriteView.setVisibility(8);
                                    tBGLWriteView.setClickable(false);
                                    return;
                                }
                                tBGLWriteView.setVisibility(0);
                                tBGLWriteView.setClickable(true);
                                if (TBGLWriteContainer.this.cUJ != null) {
                                    TBGLWriteContainer.this.cUJ.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cUJ != null) {
                            this.cUJ.setShadeImageViewIsShow(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(tBGLWriteView, 0);
                    }
                }
            }
        }
    }

    public void RM() {
        for (Runnable runnable : this.cUH) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean kG(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.cUI.iterator();
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
        if (onClickListener != null && this.cUI != null) {
            Iterator<TBGLWriteView> it = this.cUI.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void apP() {
        if (this.cUI != null) {
            RM();
            int size = this.cUI.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.cUI.get(i);
                if (tBGLWriteView != null) {
                    if (this.cUJ != null) {
                        if (i == 0) {
                            this.cUJ.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cUJ.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.Eq();
                }
            }
            this.cUG = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.cUG = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cUN;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cUN = new ArrayList<>();
            this.mSkinType = 3;
            apQ();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cUN = new ArrayList<>();
            this.mSkinType = 3;
            apQ();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cUN = new ArrayList<>();
            this.mSkinType = 3;
            apQ();
        }

        public void apQ() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cUN.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cUN.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView cn2 = cn(getContext());
                        cn2.setVisibility(8);
                        addView(cn2, 0);
                        this.cUN.add(cn2);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cUN.size() > 0) {
                            removeView(this.cUN.get(0));
                            this.cUN.remove(0);
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
            ImageView imageView = (ImageView) v.d(this.cUN, i);
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
