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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.performanceLog.z;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aty;
    private int XL;
    private int XM;
    private float alJ;
    private boolean alU;
    private BdUniqueId alV;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> arO;
    private boolean atA;
    private boolean atB;
    protected z atC;
    private long atD;
    int atE;
    int atF;
    private n att;
    private final int atu;
    private int atv;
    private int atw;
    private float atx;
    protected boolean atz;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    public void setEvent(n nVar) {
        this.att = nVar;
    }

    public int getLoadedWidth() {
        return this.atE;
    }

    public int getLoadedHeight() {
        return this.atF;
    }

    public TbImageView(Context context) {
        super(context);
        this.att = null;
        this.XL = com.baidu.tieba.p.img_default_100;
        this.atu = com.baidu.tieba.p.img_loading;
        this.XM = com.baidu.tieba.n.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.alU = false;
        this.atC = null;
        this.atD = 0L;
        this.atE = 0;
        this.atF = 0;
        this.arO = new m(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.att = null;
        this.XL = com.baidu.tieba.p.img_default_100;
        this.atu = com.baidu.tieba.p.img_loading;
        this.XM = com.baidu.tieba.n.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.alU = false;
        this.atC = null;
        this.atD = 0L;
        this.atE = 0;
        this.atF = 0;
        this.arO = new m(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Ek();
        this.atx = 30.0f;
        this.atC = new z();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.BC = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.BC = true;
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
            com.baidu.adp.widget.a.a eL = com.baidu.tbadk.imageManager.e.Am().eL(str);
            return eL == null ? com.baidu.tbadk.imageManager.e.Am().eK(str) : eL;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hl().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aty == null) {
            aty = new HashMap<>();
        }
        String valueOf = String.valueOf(this.atv);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!aty.containsKey(str) || (softReference = aty.get(str)) == null || (aVar = softReference.get()) == null || !aVar.mT()) {
            Bitmap bitmap = null;
            if (this.atv > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = ay.ck(this.atv);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.bR(this.atv);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.bR(this.atv);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.bR(this.atv);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.atv));
            aty.put(str, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public void c(String str, int i, boolean z) {
        a(str, i, 0, 0, z);
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        com.baidu.adp.base.m B = com.baidu.adp.base.n.B(getContext());
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.alV)) {
            Ak();
            this.BC = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.atC.Go = "memory";
            this.atC.isSuccess = true;
            this.atC.Gp = 0L;
            invalidate();
            if (this.att != null) {
                this.att.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.alV = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.BC = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.hl().V(this.mType) && this.alU) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.atD = System.currentTimeMillis();
            com.baidu.adp.lib.f.d.hl().a(this.mUrl, this.mType, this.arO, i2, i3, this.alV, new Object[0]);
        }
    }

    public void Ak() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.hl().a(this.mUrl, this.mType, this.arO);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ak();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ak();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ak();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Ek();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.atA = true;
        Aj();
    }

    public void stopLoading() {
        this.atA = false;
        removeCallbacks(this);
        this.alJ = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Aj() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.atA) {
            this.alJ += this.atx;
            if (this.alJ > 360.0f - this.atx) {
                this.alJ = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.alJ, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Aj();
        }
    }

    private void Ek() {
        if (this.mAutoChangeStyle) {
            this.Bp.BS = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Bp.BS = false;
        }
        int i = this.atv;
        int i2 = this.atA ? this.atu : this.XL;
        if (i2 != this.atv) {
            this.atv = i2;
            this.BC = true;
        }
        int i3 = this.atw;
        this.atw = this.XM;
        if (this.atw > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ay.getDrawable(this.atw));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.atw));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.XL != i) {
            this.XL = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.XM != i) {
            this.XM = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.alV = bdUniqueId;
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
        this.atB = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.atB) {
            startLoading();
            com.baidu.adp.lib.f.d.hl().a(this.mUrl, this.mType, this.arO, this.mWidth, this.mHeight, this.alV, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Bp.BV != null) {
            return this.Bp.BV.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Bp.BV != null) {
            return this.Bp.BV.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.alU = z;
    }

    public z getPerfLog() {
        return this.atC;
    }

    public void uq() {
        if (!this.atz) {
            this.atz = true;
        } else if (this.atC != null && this.atC.aqw) {
            this.atC.Dv();
        }
    }
}
