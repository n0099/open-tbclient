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
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> ajn;
    private int Lw;
    private int Lx;
    private float aac;
    private boolean aan;
    private BdUniqueId aao;
    private p aji;
    private final int ajj;
    private int ajk;
    private int ajl;
    private float ajm;
    protected boolean ajo;
    private boolean ajp;
    private boolean ajq;
    protected v ajr;
    private long ajs;
    int ajt;
    int aju;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> ajv;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    public void setEvent(p pVar) {
        this.aji = pVar;
    }

    public int getLoadedWidth() {
        return this.ajt;
    }

    public int getLoadedHeight() {
        return this.aju;
    }

    public TbImageView(Context context) {
        super(context);
        this.aji = null;
        this.Lw = com.baidu.tieba.v.img_default_100;
        this.ajj = com.baidu.tieba.v.img_loading;
        this.Lx = t.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aan = true;
        this.ajr = null;
        this.ajs = 0L;
        this.ajt = 0;
        this.aju = 0;
        this.ajv = new o(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aji = null;
        this.Lw = com.baidu.tieba.v.img_default_100;
        this.ajj = com.baidu.tieba.v.img_loading;
        this.Lx = t.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aan = true;
        this.ajr = null;
        this.ajs = 0L;
        this.ajt = 0;
        this.aju = 0;
        this.ajv = new o(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        zX();
        this.ajm = 30.0f;
        this.ajr = new v();
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
            com.baidu.adp.widget.a.a ek = com.baidu.tbadk.imageManager.e.vY().ek(str);
            return ek == null ? com.baidu.tbadk.imageManager.e.vY().ej(str) : ek;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (ajn == null) {
            ajn = new HashMap<>();
        }
        String valueOf = String.valueOf(this.ajk);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m255getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!ajn.containsKey(str) || (softReference = ajn.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jd()) {
            Bitmap bitmap = null;
            if (this.ajk > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                        bitmap = bc.ce(this.ajk);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.d.bN(this.ajk);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.d.bN(this.ajk);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.d.bN(this.ajk);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.ajk));
            ajn.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.aao)) {
            vQ();
            this.qZ = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.ajr.vz = "memory";
            this.ajr.isSuccess = true;
            this.ajr.vA = 0L;
            invalidate();
            if (this.aji != null) {
                this.aji.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.aao = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.qZ = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ec().W(this.mType) && this.aan) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.ajs = System.currentTimeMillis();
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, this.ajv, i2, i3, this.aao, new Object[0]);
        }
    }

    public void vQ() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, this.ajv);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vQ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        vQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            vQ();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        zX();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.ajp = true;
        vP();
    }

    public void stopLoading() {
        this.ajp = false;
        removeCallbacks(this);
        this.aac = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void vP() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ajp) {
            this.aac += this.ajm;
            if (this.aac > 360.0f - this.ajm) {
                this.aac = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aac, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            vP();
        }
    }

    private void zX() {
        if (this.mAutoChangeStyle) {
            this.qM.rq = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        } else {
            this.qM.rq = false;
        }
        int i = this.ajk;
        int i2 = this.ajp ? this.ajj : this.Lw;
        if (i2 != this.ajk) {
            this.ajk = i2;
            this.qZ = true;
        }
        int i3 = this.ajl;
        this.ajl = this.Lx;
        if (this.ajl > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(bc.getDrawable(this.ajl));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.ajl));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.Lw != i) {
            this.Lw = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.Lx != i) {
            this.Lx = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aao = bdUniqueId;
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
        this.ajq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.ajq) {
            startLoading();
            com.baidu.adp.lib.f.d.ec().a(this.mUrl, this.mType, this.ajv, this.mWidth, this.mHeight, this.aao, new Object[0]);
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
        this.aan = z;
    }

    public v getPerfLog() {
        return this.ajr;
    }

    public void qz() {
        if (!this.ajo) {
            this.ajo = true;
        } else if (this.ajr != null && this.ajr.agI) {
            this.ajr.zl();
        }
    }
}
