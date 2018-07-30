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
    private boolean cvO;
    private List<Runnable> cvP;
    private ArrayList<TBGLWriteView> cvQ;
    private ShadeViewContainer cvR;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.cvO = false;
        this.handler = new Handler();
        this.cvP = new ArrayList();
        this.cvQ = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvO = false;
        this.handler = new Handler();
        this.cvP = new ArrayList();
        this.cvQ = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvO = false;
        this.handler = new Handler();
        this.cvP = new ArrayList();
        this.cvQ = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cvR = shadeViewContainer;
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
        if (i == 8 && !iO(1)) {
            ais();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!w.z(arrayList)) {
            if (arrayList.get(0) != w.d(this.cvQ, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.cvQ = arrayList;
            int size = this.cvQ.size();
            if (this.cvR != null) {
                this.cvR.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.cvQ.get(i);
                if (tBGLWriteView != null) {
                    if (i != 0) {
                        tBGLWriteView.setRotateRadius((-1.5f) - i);
                        tBGLWriteView.setWriteEndCallBack(new c.a() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteContainer.1
                            @Override // com.baidu.tieba.animation3d.b.c.a
                            public void en(boolean z2) {
                                if (z2) {
                                    tBGLWriteView.setVisibility(8);
                                    tBGLWriteView.setClickable(false);
                                    return;
                                }
                                tBGLWriteView.setVisibility(0);
                                tBGLWriteView.setClickable(true);
                                if (TBGLWriteContainer.this.cvR != null) {
                                    TBGLWriteContainer.this.cvR.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cvR != null) {
                            this.cvR.setShadeImageViewIsShow(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(tBGLWriteView, 0);
                    }
                }
            }
        }
    }

    public void Nc() {
        for (Runnable runnable : this.cvP) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean iO(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.cvQ.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            TBGLWriteView next = it.next();
            if (next != null) {
                z = next.iO(i) && z2;
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
        if (onClickListener != null && this.cvQ != null) {
            Iterator<TBGLWriteView> it = this.cvQ.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void ais() {
        if (this.cvQ != null) {
            Nc();
            int size = this.cvQ.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.cvQ.get(i);
                if (tBGLWriteView != null) {
                    if (this.cvR != null) {
                        if (i == 0) {
                            this.cvR.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cvR.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.zV();
                }
            }
            this.cvO = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.cvO = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cvV;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cvV = new ArrayList<>();
            this.mSkinType = 3;
            ait();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cvV = new ArrayList<>();
            this.mSkinType = 3;
            ait();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cvV = new ArrayList<>();
            this.mSkinType = 3;
            ait();
        }

        public void ait() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cvV.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cvV.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView bu = bu(getContext());
                        bu.setVisibility(8);
                        addView(bu, 0);
                        this.cvV.add(bu);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cvV.size() > 0) {
                            removeView(this.cvV.get(0));
                            this.cvV.remove(0);
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

        private TbImageView bu(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int f = l.f(context, d.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(f, f));
            tbImageView.setImageResource(d.f.write_shade);
            return tbImageView;
        }

        public void setShadeImageViewIsShow(int i, boolean z) {
            ImageView imageView = (ImageView) w.d(this.cvV, i);
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
