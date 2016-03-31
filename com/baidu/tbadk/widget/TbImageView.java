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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aFK;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDE;
    private a aFD;
    private int aFE;
    private int aFF;
    private final int aFG;
    private int aFH;
    private int aFI;
    private float aFJ;
    protected boolean aFL;
    private boolean aFM;
    private boolean aFN;
    protected u aFO;
    private int aFP;
    private long aFQ;
    int aFR;
    int aFS;
    private int aev;
    private int aew;
    private CustomMessageListener agJ;
    private float axk;
    private boolean axy;
    private BdUniqueId axz;
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

        void s(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aFD = aVar;
    }

    public int getLoadedWidth() {
        return this.aFR;
    }

    public int getLoadedHeight() {
        return this.aFS;
    }

    public TbImageView(Context context) {
        super(context);
        this.aFD = null;
        this.aev = t.d.transparent;
        this.aFE = t.f.img_default_100;
        this.aFF = this.aev;
        this.aFG = t.f.img_loading;
        this.aew = t.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.axy = false;
        this.aFO = null;
        this.aFP = 3;
        this.aFQ = 0L;
        this.aFR = 0;
        this.aFS = 0;
        this.aDE = new d(this);
        this.agJ = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFD = null;
        this.aev = t.d.transparent;
        this.aFE = t.f.img_default_100;
        this.aFF = this.aev;
        this.aFG = t.f.img_loading;
        this.aew = t.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.axy = false;
        this.aFO = null;
        this.aFP = 3;
        this.aFQ = 0L;
        this.aFR = 0;
        this.aFS = 0;
        this.aDE = new d(this);
        this.agJ = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HT();
        this.aFJ = 30.0f;
        this.aFO = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.BX = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.BX = true;
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
            com.baidu.adp.widget.a.a fP = com.baidu.tbadk.imageManager.c.EO().fP(str);
            return fP == null ? com.baidu.tbadk.imageManager.c.EO().fO(str) : fP;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hr().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aFK == null) {
            aFK = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aFH);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aFP != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.BX = true;
            this.aFP = TbadkCoreApplication.m411getInst().getSkinType();
        }
        if (!aFK.containsKey(str) || (softReference = aFK.get(str)) == null || (aVar = softReference.get()) == null || !aVar.mL()) {
            Bitmap bitmap = null;
            if (this.aFH > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = at.cR(this.aFH);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aFH);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aFH);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aFH);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aFH));
            aFK.put(str, new SoftReference<>(aVar2));
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
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z2 = q.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aFF = this.aev;
        if (TextUtils.isEmpty(str)) {
            this.aFF = this.aFE;
            this.mUrl = str;
            return;
        }
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.axz)) {
            EL();
            this.BX = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aFO.Hr = "memory";
            this.aFO.isSuccess = true;
            this.aFO.Hs = 0L;
            invalidate();
            if (this.aFD != null) {
                this.aFD.s(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.axz = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.BX = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hr().ah(this.mType) && this.axy) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aFQ = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.hr().a(this.mUrl, this.mType, this.aDE, i2, i3, this.axz, new Object[0]);
        }
    }

    public void EL() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hr().a(this.mUrl, this.mType, this.aDE);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> s = l.s(getContext());
        if (s != null) {
            this.agJ.setTag(s.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.agJ);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EL();
        MessageManager.getInstance().unRegisterListener(this.agJ);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        EL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            EL();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HT();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aFM = true;
        EK();
    }

    public void stopLoading() {
        this.aFM = false;
        removeCallbacks(this);
        this.axk = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void EK() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aFM) {
            this.axk += this.aFJ;
            if (this.axk > 360.0f - this.aFJ) {
                this.axk = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.axk, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            EK();
        }
    }

    private void HT() {
        if (this.mAutoChangeStyle) {
            this.BN.Cn = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.BN.Cn = false;
        }
        int i = this.aFH;
        int i2 = this.aFM ? this.aFG : this.aFF;
        if (i2 != this.aFH) {
            this.aFH = i2;
            this.BX = true;
        }
        int i3 = this.aFI;
        this.aFI = this.aew;
        if (this.aFI > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(at.getDrawable(this.aFI));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aFI));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aev != i) {
            this.aev = i;
            this.aFF = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aFE = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aew != i) {
            this.aew = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.axz = bdUniqueId;
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
        this.aFN = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aFN) {
            startLoading();
            com.baidu.adp.lib.g.c.hr().a(this.mUrl, this.mType, this.aDE, this.mWidth, this.mHeight, this.axz, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.BN.Cq != null) {
            return this.BN.Cq.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.BN.Cq != null) {
            return this.BN.Cq.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.axy = z;
    }

    public u getPerfLog() {
        return this.aFO;
    }

    public void xi() {
        if (!this.aFL) {
            this.aFL = true;
        } else if (this.aFO != null && this.aFO.aBs) {
            this.aFO.GO();
        }
    }
}
