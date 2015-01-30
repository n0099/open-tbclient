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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.performanceLog.v;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> ajq;
    private int LA;
    private int Lz;
    private float aaf;
    private boolean aaq;
    private BdUniqueId aar;
    private p ajl;
    private final int ajm;
    private int ajn;
    private int ajo;
    private float ajp;
    protected boolean ajr;
    private boolean ajs;
    private boolean ajt;
    protected v aju;
    private long ajv;
    int ajw;
    int ajx;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> ajy;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    public void setEvent(p pVar) {
        this.ajl = pVar;
    }

    public int getLoadedWidth() {
        return this.ajw;
    }

    public int getLoadedHeight() {
        return this.ajx;
    }

    public TbImageView(Context context) {
        super(context);
        this.ajl = null;
        this.Lz = com.baidu.tieba.v.img_default_100;
        this.ajm = com.baidu.tieba.v.img_loading;
        this.LA = t.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aaq = true;
        this.aju = null;
        this.ajv = 0L;
        this.ajw = 0;
        this.ajx = 0;
        this.ajy = new o(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajl = null;
        this.Lz = com.baidu.tieba.v.img_default_100;
        this.ajm = com.baidu.tieba.v.img_loading;
        this.LA = t.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aaq = true;
        this.aju = null;
        this.ajv = 0L;
        this.ajw = 0;
        this.ajx = 0;
        this.ajy = new o(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Ad();
        this.ajp = 30.0f;
        this.aju = new v();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.qZ = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.qZ = true;
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
            com.baidu.adp.widget.a.a en = com.baidu.tbadk.imageManager.e.we().en(str);
            return en == null ? com.baidu.tbadk.imageManager.e.we().em(str) : en;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (ajq == null) {
            ajq = new HashMap<>();
        }
        String valueOf = String.valueOf(this.ajn);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m255getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!ajq.containsKey(str) || (softReference = ajq.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jk()) {
            Bitmap bitmap = null;
            if (this.ajn > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                        bitmap = bc.ce(this.ajn);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.d.bN(this.ajn);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.d.bN(this.ajn);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.d.bN(this.ajn);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.ajn));
            ajq.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.aar)) {
            vW();
            this.qZ = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aju.vC = "memory";
            this.aju.isSuccess = true;
            this.aju.vD = 0L;
            invalidate();
            if (this.ajl != null) {
                this.ajl.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.aar = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.qZ = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ec().W(this.mType) && this.aaq) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.ajv = System.currentTimeMillis();
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, this.ajy, i2, i3, this.aar, new Object[0]);
        }
    }

    public void vW() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, this.ajy);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vW();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        vW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            vW();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Ad();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.ajs = true;
        vV();
    }

    public void stopLoading() {
        this.ajs = false;
        removeCallbacks(this);
        this.aaf = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void vV() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ajs) {
            this.aaf += this.ajp;
            if (this.aaf > 360.0f - this.ajp) {
                this.aaf = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aaf, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            vV();
        }
    }

    private void Ad() {
        if (this.mAutoChangeStyle) {
            this.qM.rq = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        } else {
            this.qM.rq = false;
        }
        int i = this.ajn;
        int i2 = this.ajs ? this.ajm : this.Lz;
        if (i2 != this.ajn) {
            this.ajn = i2;
            this.qZ = true;
        }
        int i3 = this.ajo;
        this.ajo = this.LA;
        if (this.ajo > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(bc.getDrawable(this.ajo));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.ajo));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.Lz != i) {
            this.Lz = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.LA != i) {
            this.LA = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aar = bdUniqueId;
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
        this.ajt = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.ajt) {
            startLoading();
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, this.ajy, this.mWidth, this.mHeight, this.aar, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.qM.rt != null) {
            return this.qM.rt.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.qM.rt != null) {
            return this.qM.rt.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aaq = z;
    }

    public v getPerfLog() {
        return this.aju;
    }

    public void qF() {
        if (!this.ajr) {
            this.ajr = true;
        } else if (this.aju != null && this.aju.agL) {
            this.aju.zr();
        }
    }
}
