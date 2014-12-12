package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.performanceLog.v;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aiN;
    private int Lf;
    private int Lg;
    private float ZE;
    private boolean ZP;
    private BdUniqueId ZQ;
    private p aiI;
    private final int aiJ;
    private int aiK;
    private int aiL;
    private float aiM;
    protected boolean aiO;
    private boolean aiP;
    private boolean aiQ;
    protected v aiR;
    private long aiS;
    int aiT;
    int aiU;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> aiV;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    public void setEvent(p pVar) {
        this.aiI = pVar;
    }

    public int getLoadedWidth() {
        return this.aiT;
    }

    public int getLoadedHeight() {
        return this.aiU;
    }

    public TbImageView(Context context) {
        super(context);
        this.aiI = null;
        this.Lf = com.baidu.tieba.v.img_default_100;
        this.aiJ = com.baidu.tieba.v.img_loading;
        this.Lg = t.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ZP = true;
        this.aiR = null;
        this.aiS = 0L;
        this.aiT = 0;
        this.aiU = 0;
        this.aiV = new o(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiI = null;
        this.Lf = com.baidu.tieba.v.img_default_100;
        this.aiJ = com.baidu.tieba.v.img_loading;
        this.Lg = t.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ZP = true;
        this.aiR = null;
        this.aiS = 0L;
        this.aiT = 0;
        this.aiU = 0;
        this.aiV = new o(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        zJ();
        this.aiM = 30.0f;
        this.aiR = new v();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.qU = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.qU = true;
            requestLayout();
        }
    }

    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getBdImage() {
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                return null;
            }
            String str = (String) tag;
            com.baidu.adp.widget.a.a en = com.baidu.tbadk.imageManager.e.vL().en(str);
            return en == null ? com.baidu.tbadk.imageManager.e.vL().em(str) : en;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ee().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aiN == null) {
            aiN = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aiK);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m255getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!aiN.containsKey(str) || (softReference = aiN.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jj()) {
            Bitmap bitmap = null;
            if (this.aiK > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                        bitmap = ax.bX(this.aiK);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.d.bI(this.aiK);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.d.bI(this.aiK);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.d.bI(this.aiK);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aiK));
            aiN.put(str, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public void d(String str, int i, boolean z) {
        a(str, i, 0, 0, z);
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z2 = B.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        BdLog.i("startLoad:url-" + str);
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.ZQ)) {
            vE();
            this.qU = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aiR.vw = "memory";
            this.aiR.isSuccess = true;
            this.aiR.vx = 0L;
            invalidate();
            if (this.aiI != null) {
                this.aiI.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.ZQ = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.qU = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ee().R(this.mType) && this.ZP) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aiS = System.currentTimeMillis();
            com.baidu.adp.lib.f.d.ee().a(this.mUrl, this.mType, this.aiV, i2, i3, this.ZQ, new Object[0]);
        }
    }

    public void vE() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ee().a(this.mUrl, this.mType, this.aiV);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vE();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        vE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            vE();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        zJ();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aiP = true;
        vD();
    }

    public void stopLoading() {
        this.aiP = false;
        removeCallbacks(this);
        this.ZE = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void vD() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aiP) {
            this.ZE += this.aiM;
            if (this.ZE > 360.0f - this.aiM) {
                this.ZE = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.ZE, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            vD();
        }
    }

    private void zJ() {
        if (this.mAutoChangeStyle) {
            this.qH.rk = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        } else {
            this.qH.rk = false;
        }
        int i = this.aiK;
        int i2 = this.aiP ? this.aiJ : this.Lf;
        if (i2 != this.aiK) {
            this.aiK = i2;
            this.qU = true;
        }
        int i3 = this.aiL;
        this.aiL = this.Lg;
        if (this.aiL > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ax.getDrawable(this.aiL));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aiL));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.Lf != i) {
            this.Lf = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.Lg != i) {
            this.Lg = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ZQ = bdUniqueId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.mUrl, this.mType, this.mWidth, this.mHeight, false);
        invalidate();
    }

    public void reset() {
        setTag(null);
        this.mUrl = null;
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    public void setInterceptOnClick(boolean z) {
        this.aiQ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aiQ) {
            startLoading();
            com.baidu.adp.lib.f.d.ee().a(this.mUrl, this.mType, this.aiV, this.mWidth, this.mHeight, this.ZQ, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.qH.ro != null) {
            return this.qH.ro.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.qH.ro != null) {
            return this.qH.ro.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.ZP = z;
    }

    public v getPerfLog() {
        return this.aiR;
    }

    public void qu() {
        if (!this.aiO) {
            this.aiO = true;
        } else if (this.aiR != null && this.aiR.agn) {
            this.aiR.za();
        }
    }
}
