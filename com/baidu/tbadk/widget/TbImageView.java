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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tieba.i;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aAJ;
    private a aAE;
    private final int aAF;
    private int aAG;
    private int aAH;
    private float aAI;
    protected boolean aAK;
    private boolean aAL;
    private boolean aAM;
    protected s aAN;
    private long aAO;
    int aAP;
    int aAQ;
    private int acR;
    private int acS;
    private CustomMessageListener aeE;
    private boolean atF;
    private BdUniqueId atG;
    private float atu;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azf;
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
        this.aAE = aVar;
    }

    public int getLoadedWidth() {
        return this.aAP;
    }

    public int getLoadedHeight() {
        return this.aAQ;
    }

    public TbImageView(Context context) {
        super(context);
        this.aAE = null;
        this.acR = i.e.img_default_100;
        this.aAF = i.e.img_loading;
        this.acS = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.atF = false;
        this.aAN = null;
        this.aAO = 0L;
        this.aAP = 0;
        this.aAQ = 0;
        this.azf = new e(this);
        this.aeE = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAE = null;
        this.acR = i.e.img_default_100;
        this.aAF = i.e.img_loading;
        this.acS = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.atF = false;
        this.aAN = null;
        this.aAO = 0L;
        this.aAP = 0;
        this.aAQ = 0;
        this.azf = new e(this);
        this.aeE = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        ER();
        this.aAI = 30.0f;
        this.aAN = new s();
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
            com.baidu.adp.widget.a.a fo = com.baidu.tbadk.imageManager.c.Cf().fo(str);
            return fo == null ? com.baidu.tbadk.imageManager.c.Cf().fn(str) : fo;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aAJ == null) {
            aAJ = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aAG);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!aAJ.containsKey(str) || (softReference = aAJ.get(str)) == null || (aVar = softReference.get()) == null || !aVar.nb()) {
            Bitmap bitmap = null;
            if (this.aAG > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = am.cw(this.aAG);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.cf(this.aAG);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.cf(this.aAG);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.cf(this.aAG);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aAG));
            aAJ.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.atG)) {
            Cc();
            this.Bl = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aAN.Gp = "memory";
            this.aAN.isSuccess = true;
            this.aAN.Gq = 0L;
            invalidate();
            if (this.aAE != null) {
                this.aAE.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.atG = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bl = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.ha().W(this.mType) && this.atF) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aAO = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, this.azf, i2, i3, this.atG, new Object[0]);
        }
    }

    public void Cc() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, this.azf);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.aeE.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.aeE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Cc();
        MessageManager.getInstance().unRegisterListener(this.aeE);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Cc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Cc();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        ER();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aAL = true;
        Cb();
    }

    public void stopLoading() {
        this.aAL = false;
        removeCallbacks(this);
        this.atu = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Cb() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aAL) {
            this.atu += this.aAI;
            if (this.atu > 360.0f - this.aAI) {
                this.atu = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.atu, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Cb();
        }
    }

    private void ER() {
        if (this.mAutoChangeStyle) {
            this.Bb.BB = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Bb.BB = false;
        }
        int i = this.aAG;
        int i2 = this.aAL ? this.aAF : this.acR;
        if (i2 != this.aAG) {
            this.aAG = i2;
            this.Bl = true;
        }
        int i3 = this.aAH;
        this.aAH = this.acS;
        if (this.aAH > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(am.getDrawable(this.aAH));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aAH));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.acR != i) {
            this.acR = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.acS != i) {
            this.acS = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.atG = bdUniqueId;
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
        this.aAM = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aAM) {
            startLoading();
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, this.mType, this.azf, this.mWidth, this.mHeight, this.atG, new Object[0]);
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
        this.atF = z;
    }

    public s getPerfLog() {
        return this.aAN;
    }

    public void vr() {
        if (!this.aAK) {
            this.aAK = true;
        } else if (this.aAN != null && this.aAN.axq) {
            this.aAN.DU();
        }
    }
}
