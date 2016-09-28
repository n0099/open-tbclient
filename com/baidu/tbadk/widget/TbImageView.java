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
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aFR;
    private static Method aGa;
    private static Method aGb;
    private static Method aGc;
    private static Method aGd;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDV;
    private a aFK;
    private int aFL;
    private int aFM;
    private final int aFN;
    private int aFO;
    private int aFP;
    private float aFQ;
    protected boolean aFS;
    private boolean aFT;
    private boolean aFU;
    protected u aFV;
    private int aFW;
    private long aFX;
    int aFY;
    int aFZ;
    private int adP;
    private int adQ;
    private CustomMessageListener agS;
    private BdUniqueId ahL;
    private float axA;
    private boolean axO;
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

        void v(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aFK = aVar;
    }

    public int getLoadedWidth() {
        return this.aFY;
    }

    public int getLoadedHeight() {
        return this.aFZ;
    }

    public TbImageView(Context context) {
        super(context);
        this.aFK = null;
        this.adP = r.d.transparent;
        this.aFL = r.f.img_default_100;
        this.aFM = this.adP;
        this.aFN = r.f.img_loading;
        this.adQ = r.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.axO = false;
        this.aFV = null;
        this.aFW = 3;
        this.aFX = 0L;
        this.aFY = 0;
        this.aFZ = 0;
        this.aDV = new d(this);
        this.agS = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFK = null;
        this.adP = r.d.transparent;
        this.aFL = r.f.img_default_100;
        this.aFM = this.adP;
        this.aFN = r.f.img_loading;
        this.adQ = r.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.axO = false;
        this.aFV = null;
        this.aFW = 3;
        this.aFX = 0L;
        this.aFY = 0;
        this.aFZ = 0;
        this.aDV = new d(this);
        this.agS = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HD();
        this.aFQ = 30.0f;
        this.aFV = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.vf = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.vf = true;
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
            com.baidu.adp.widget.a.a fX = com.baidu.tbadk.imageManager.c.Ek().fX(str);
            return fX == null ? com.baidu.tbadk.imageManager.c.Ek().fW(str) : fX;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aFR == null) {
            aFR = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aFO);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aFW != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.vf = true;
            this.aFW = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aFR.containsKey(str) || (softReference = aFR.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jW()) {
            Bitmap bitmap = null;
            if (this.aFO > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = av.cN(this.aFO);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aFO);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aFO);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aFO);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aFO));
            aFR.put(str, new SoftReference<>(aVar2));
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
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z2 = A.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aFM = this.adP;
        if (TextUtils.isEmpty(str)) {
            this.aFM = this.aFL;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.ahL;
        if (!z3) {
            Eh();
            this.vf = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aFV.Az = "memory";
            this.aFV.isSuccess = true;
            this.aFV.AA = 0L;
            invalidate();
            if (this.aFK != null) {
                this.aFK.v(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.ahL = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.vf = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().al(this.mType) && this.axO) {
            invalidate();
        } else if (z3 && !i.gm()) {
            this.aFV.Az = "memory";
            this.aFV.isSuccess = false;
            this.aFV.AA = 0L;
            this.aFM = this.aFL;
            invalidate();
            if (this.aFK != null) {
                this.aFK.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aFX = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aDV, i2, i3, this.ahL, new Object[0]);
        }
    }

    public void Eh() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aDV);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.agS.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.agS);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Eh();
        MessageManager.getInstance().unRegisterListener(this.agS);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Eh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Eh();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HD();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aFT = true;
        Eg();
    }

    public void stopLoading() {
        this.aFT = false;
        removeCallbacks(this);
        this.axA = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Eg() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aFT) {
            this.axA += this.aFQ;
            if (this.axA > 360.0f - this.aFQ) {
                this.axA = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.axA, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Eg();
        }
    }

    private void HD() {
        if (this.mAutoChangeStyle) {
            this.uV.vv = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.uV.vv = false;
        }
        int i = this.aFO;
        int i2 = this.aFT ? this.aFN : this.aFM;
        if (i2 != this.aFO) {
            this.aFO = i2;
            this.vf = true;
        }
        int i3 = this.aFP;
        this.aFP = this.adQ;
        if (this.aFP > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(av.getDrawable(this.aFP));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aFP));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.adP != i) {
            this.adP = i;
            this.aFM = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aFL = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.adQ != i) {
            this.adQ = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ahL = bdUniqueId;
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
        this.aFU = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aFU) {
            startLoading();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aDV, this.mWidth, this.mHeight, this.ahL, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.uV.vy != null) {
            return this.uV.vy.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.uV.vy != null) {
            return this.uV.vy.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.axO = z;
    }

    public u getPerfLog() {
        return this.aFV;
    }

    public void wi() {
        if (!this.aFS) {
            this.aFS = true;
        } else if (this.aFV != null && this.aFV.aBL) {
            this.aFV.Gi();
        }
    }
}
