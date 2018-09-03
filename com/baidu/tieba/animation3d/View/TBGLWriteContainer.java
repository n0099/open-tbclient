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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class TBGLWriteContainer extends LinearLayout {
    private boolean cvL;
    private List<Runnable> cvM;
    private ArrayList<TBGLWriteView> cvN;
    private ShadeViewContainer cvO;
    private Handler handler;
    private Context mContext;

    public TBGLWriteContainer(Context context) {
        super(context);
        this.cvL = false;
        this.handler = new Handler();
        this.cvM = new ArrayList();
        this.cvN = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvL = false;
        this.handler = new Handler();
        this.cvM = new ArrayList();
        this.cvN = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public TBGLWriteContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvL = false;
        this.handler = new Handler();
        this.cvM = new ArrayList();
        this.cvN = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(ShadeViewContainer shadeViewContainer) {
        this.cvO = shadeViewContainer;
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
        if (i == 8 && !iN(1)) {
            aiv();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<TBGLWriteView> arrayList) {
        boolean z;
        if (!w.z(arrayList)) {
            if (arrayList.get(0) != w.d(this.cvN, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.cvN = arrayList;
            int size = this.cvN.size();
            if (this.cvO != null) {
                this.cvO.setShadeCount(size);
            }
            for (final int i = 0; i < size; i++) {
                final TBGLWriteView tBGLWriteView = this.cvN.get(i);
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
                                if (TBGLWriteContainer.this.cvO != null) {
                                    TBGLWriteContainer.this.cvO.setShadeImageViewIsShow(i, true);
                                }
                            }
                        });
                        a(tBGLWriteView, false);
                        tBGLWriteView.setClickable(false);
                    } else {
                        tBGLWriteView.setRotateRadius(0.0f);
                        a(tBGLWriteView, true);
                        if (this.cvO != null) {
                            this.cvO.setShadeImageViewIsShow(0, true);
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
        for (Runnable runnable : this.cvM) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public boolean iN(int i) {
        boolean z;
        Iterator<TBGLWriteView> it = this.cvN.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            TBGLWriteView next = it.next();
            if (next != null) {
                z = next.iN(i) && z2;
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
        if (onClickListener != null && this.cvN != null) {
            Iterator<TBGLWriteView> it = this.cvN.iterator();
            while (it.hasNext()) {
                TBGLWriteView next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void aiv() {
        if (this.cvN != null) {
            Ng();
            int size = this.cvN.size();
            for (int i = 0; i < size; i++) {
                TBGLWriteView tBGLWriteView = this.cvN.get(i);
                if (tBGLWriteView != null) {
                    if (this.cvO != null) {
                        if (i == 0) {
                            this.cvO.setShadeImageViewIsShow(i, true);
                        } else {
                            this.cvO.setShadeImageViewIsShow(i, false);
                            tBGLWriteView.setClickable(false);
                        }
                    }
                    tBGLWriteView.zT();
                }
            }
            this.cvL = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.cvL = z;
    }

    /* loaded from: classes.dex */
    public static class ShadeViewContainer extends LinearLayout {
        ArrayList<TbImageView> cvS;
        private int mSkinType;

        public ShadeViewContainer(Context context) {
            super(context);
            this.cvS = new ArrayList<>();
            this.mSkinType = 3;
            aiw();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cvS = new ArrayList<>();
            this.mSkinType = 3;
            aiw();
        }

        public ShadeViewContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.cvS = new ArrayList<>();
            this.mSkinType = 3;
            aiw();
        }

        public void aiw() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.cvS.clear();
                removeAllViews();
                return;
            }
            int size = i - this.cvS.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView bu = bu(getContext());
                        bu.setVisibility(8);
                        addView(bu, 0);
                        this.cvS.add(bu);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.cvS.size() > 0) {
                            removeView(this.cvS.get(0));
                            this.cvS.remove(0);
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
            int f = l.f(context, f.e.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(f, f));
            tbImageView.setImageResource(f.C0146f.write_shade);
            return tbImageView;
        }

        public void setShadeImageViewIsShow(int i, boolean z) {
            ImageView imageView = (ImageView) w.d(this.cvS, i);
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
