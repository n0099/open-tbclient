package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.k;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tieba.i;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aAI;
    private a aAD;
    private final int aAE;
    private int aAF;
    private int aAG;
    private float aAH;
    protected boolean aAJ;
    private boolean aAK;
    private boolean aAL;
    protected s aAM;
    private long aAN;
    int aAO;
    int aAP;
    private int acI;
    private int acJ;
    private float atn;
    private boolean aty;
    private BdUniqueId atz;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> ayW;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void onComplete(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aAD = aVar;
    }

    public int getLoadedWidth() {
        return this.aAO;
    }

    public int getLoadedHeight() {
        return this.aAP;
    }

    public TbImageView(Context context) {
        super(context);
        this.aAD = null;
        this.acI = i.e.img_default_100;
        this.aAE = i.e.img_loading;
        this.acJ = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aty = false;
        this.aAM = null;
        this.aAN = 0L;
        this.aAO = 0;
        this.aAP = 0;
        this.ayW = new h(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAD = null;
        this.acI = i.e.img_default_100;
        this.aAE = i.e.img_loading;
        this.acJ = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aty = false;
        this.aAM = null;
        this.aAN = 0L;
        this.aAO = 0;
        this.aAP = 0;
        this.ayW = new h(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        EU();
        this.aAH = 30.0f;
        this.aAM = new s();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Bm = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Bm = true;
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
            com.baidu.adp.widget.a.a fb = com.baidu.tbadk.imageManager.c.Ce().fb(str);
            return fb == null ? com.baidu.tbadk.imageManager.c.Ce().fa(str) : fb;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hc().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aAI == null) {
            aAI = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aAF);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!aAI.containsKey(str) || (softReference = aAI.get(str)) == null || (aVar = softReference.get()) == null || !aVar.nd()) {
            Bitmap bitmap = null;
            if (this.aAF > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = al.cq(this.aAF);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.bZ(this.aAF);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.bZ(this.aAF);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.bZ(this.aAF);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aAF));
            aAI.put(str, new SoftReference<>(aVar2));
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
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z2 = A.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        BdLog.i("startLoad:url-" + str);
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.atz)) {
            Cb();
            this.Bm = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aAM.Gp = "memory";
            this.aAM.isSuccess = true;
            this.aAM.Gq = 0L;
            invalidate();
            if (this.aAD != null) {
                this.aAD.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.atz = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bm = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.hc().W(this.mType) && this.aty) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aAN = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.hc().a(this.mUrl, this.mType, this.ayW, i2, i3, this.atz, new Object[0]);
        }
    }

    public void Cb() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.hc().a(this.mUrl, this.mType, this.ayW);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Cb();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Cb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Cb();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        EU();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aAK = true;
        Ca();
    }

    public void stopLoading() {
        this.aAK = false;
        removeCallbacks(this);
        this.atn = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Ca() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aAK) {
            this.atn += this.aAH;
            if (this.atn > 360.0f - this.aAH) {
                this.atn = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.atn, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Ca();
        }
    }

    private void EU() {
        if (this.mAutoChangeStyle) {
            this.Bc.BC = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Bc.BC = false;
        }
        int i = this.aAF;
        int i2 = this.aAK ? this.aAE : this.acI;
        if (i2 != this.aAF) {
            this.aAF = i2;
            this.Bm = true;
        }
        int i3 = this.aAG;
        this.aAG = this.acJ;
        if (this.aAG > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(al.getDrawable(this.aAG));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aAG));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.acI != i) {
            this.acI = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.acJ != i) {
            this.acJ = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.atz = bdUniqueId;
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
        this.aAL = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aAL) {
            startLoading();
            com.baidu.adp.lib.f.c.hc().a(this.mUrl, this.mType, this.ayW, this.mWidth, this.mHeight, this.atz, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Bc.BF != null) {
            return this.Bc.BF.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Bc.BF != null) {
            return this.Bc.BF.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aty = z;
    }

    public s getPerfLog() {
        return this.aAM;
    }

    public void vu() {
        if (!this.aAJ) {
            this.aAJ = true;
        } else if (this.aAM != null && this.aAM.axj) {
            this.aAM.DX();
        }
    }
}
