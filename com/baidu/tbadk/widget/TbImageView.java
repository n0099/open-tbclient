package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.k;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tieba.i;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aAU;
    private a aAP;
    private final int aAQ;
    private int aAR;
    private int aAS;
    private float aAT;
    protected boolean aAV;
    private boolean aAW;
    private boolean aAX;
    protected s aAY;
    private long aAZ;
    int aBa;
    int aBb;
    private int acS;
    private int acT;
    private CustomMessageListener aeF;
    private boolean atG;
    private BdUniqueId atH;
    private float atv;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azq;
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
        this.aAP = aVar;
    }

    public int getLoadedWidth() {
        return this.aBa;
    }

    public int getLoadedHeight() {
        return this.aBb;
    }

    public TbImageView(Context context) {
        super(context);
        this.aAP = null;
        this.acS = i.e.img_default_100;
        this.aAQ = i.e.img_loading;
        this.acT = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.atG = false;
        this.aAY = null;
        this.aAZ = 0L;
        this.aBa = 0;
        this.aBb = 0;
        this.azq = new e(this);
        this.aeF = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAP = null;
        this.acS = i.e.img_default_100;
        this.aAQ = i.e.img_loading;
        this.acT = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.atG = false;
        this.aAY = null;
        this.aAZ = 0L;
        this.aBa = 0;
        this.aBb = 0;
        this.azq = new e(this);
        this.aeF = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        EN();
        this.aAT = 30.0f;
        this.aAY = new s();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Bl = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Bl = true;
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
            com.baidu.adp.widget.a.a fo = com.baidu.tbadk.imageManager.c.Cc().fo(str);
            return fo == null ? com.baidu.tbadk.imageManager.c.Cc().fn(str) : fo;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aAU == null) {
            aAU = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aAR);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!aAU.containsKey(str) || (softReference = aAU.get(str)) == null || (aVar = softReference.get()) == null || !aVar.nb()) {
            Bitmap bitmap = null;
            if (this.aAR > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = an.cw(this.aAR);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.cf(this.aAR);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.cf(this.aAR);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.cf(this.aAR);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aAR));
            aAU.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.atH)) {
            BZ();
            this.Bl = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aAY.Gq = "memory";
            this.aAY.isSuccess = true;
            this.aAY.Gr = 0L;
            invalidate();
            if (this.aAP != null) {
                this.aAP.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.atH = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bl = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.ha().W(this.mType) && this.atG) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aAZ = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, this.azq, i2, i3, this.atH, new Object[0]);
        }
    }

    public void BZ() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, this.azq);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.aeF.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.aeF);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BZ();
        MessageManager.getInstance().unRegisterListener(this.aeF);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        BZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            BZ();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        EN();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aAW = true;
        BY();
    }

    public void stopLoading() {
        this.aAW = false;
        removeCallbacks(this);
        this.atv = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void BY() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aAW) {
            this.atv += this.aAT;
            if (this.atv > 360.0f - this.aAT) {
                this.atv = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.atv, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            BY();
        }
    }

    private void EN() {
        if (this.mAutoChangeStyle) {
            this.Bb.BB = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Bb.BB = false;
        }
        int i = this.aAR;
        int i2 = this.aAW ? this.aAQ : this.acS;
        if (i2 != this.aAR) {
            this.aAR = i2;
            this.Bl = true;
        }
        int i3 = this.aAS;
        this.aAS = this.acT;
        if (this.aAS > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(an.getDrawable(this.aAS));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aAS));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.acS != i) {
            this.acS = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.acT != i) {
            this.acT = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.atH = bdUniqueId;
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
        this.aAX = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aAX) {
            startLoading();
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, this.azq, this.mWidth, this.mHeight, this.atH, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Bb.BE != null) {
            return this.Bb.BE.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Bb.BE != null) {
            return this.Bb.BE.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.atG = z;
    }

    public s getPerfLog() {
        return this.aAY;
    }

    public void vo() {
        if (!this.aAV) {
            this.aAV = true;
        } else if (this.aAY != null && this.aAY.axr) {
            this.aAY.DR();
        }
    }
}
