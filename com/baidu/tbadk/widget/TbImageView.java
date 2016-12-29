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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aGb;
    private static Method aGk;
    private static Method aGl;
    private static Method aGm;
    private static Method aGn;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEe;
    private a aFU;
    private int aFV;
    private int aFW;
    private final int aFX;
    private int aFY;
    private int aFZ;
    private float aGa;
    protected boolean aGc;
    private boolean aGd;
    private boolean aGe;
    protected u aGf;
    private int aGg;
    private long aGh;
    int aGi;
    int aGj;
    private int adG;
    private int adH;
    private CustomMessageListener agL;
    private float axO;
    private boolean ayc;
    private BdUniqueId ayd;
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
        this.aFU = aVar;
    }

    public int getLoadedWidth() {
        return this.aGi;
    }

    public int getLoadedHeight() {
        return this.aGj;
    }

    public TbImageView(Context context) {
        super(context);
        this.aFU = null;
        this.adG = r.d.transparent;
        this.aFV = r.f.img_default_100;
        this.aFW = this.adG;
        this.aFX = r.f.img_loading;
        this.adH = r.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ayc = false;
        this.aGf = null;
        this.aGg = 3;
        this.aGh = 0L;
        this.aGi = 0;
        this.aGj = 0;
        this.aEe = new d(this);
        this.agL = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFU = null;
        this.adG = r.d.transparent;
        this.aFV = r.f.img_default_100;
        this.aFW = this.adG;
        this.aFX = r.f.img_loading;
        this.adH = r.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ayc = false;
        this.aGf = null;
        this.aGg = 3;
        this.aGh = 0L;
        this.aGi = 0;
        this.aGj = 0;
        this.aEe = new d(this);
        this.agL = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Hc();
        this.aGa = 30.0f;
        this.aGf = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.vg = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.vg = true;
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
            com.baidu.adp.widget.a.a fW = com.baidu.tbadk.imageManager.c.DX().fW(str);
            return fW == null ? com.baidu.tbadk.imageManager.c.DX().fV(str) : fW;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aGb == null) {
            aGb = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aFY);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aGg != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.vg = true;
            this.aGg = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aGb.containsKey(str) || (softReference = aGb.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jW()) {
            Bitmap bitmap = null;
            if (this.aFY > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = ar.cQ(this.aFY);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aFY);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aFY);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aFY);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aFY));
            aGb.put(str, new SoftReference<>(aVar2));
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
        this.aFW = this.adG;
        if (TextUtils.isEmpty(str)) {
            this.aFW = this.aFV;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.ayd;
        if (!z3) {
            DU();
            this.vg = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aGf.Az = "memory";
            this.aGf.isSuccess = true;
            this.aGf.AA = 0L;
            invalidate();
            if (this.aFU != null) {
                this.aFU.v(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.ayd = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.vg = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().am(this.mType) && this.ayc) {
            invalidate();
        } else if (z3 && !i.gm()) {
            this.aGf.Az = "memory";
            this.aGf.isSuccess = false;
            this.aGf.AA = 0L;
            this.aFW = this.aFV;
            invalidate();
            if (this.aFU != null) {
                this.aFU.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aGh = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEe, i2, i3, this.ayd, new Object[0]);
        }
    }

    public void DU() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEe);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.agL.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.agL);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DU();
        MessageManager.getInstance().unRegisterListener(this.agL);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DU();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Hc();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aGd = true;
        DT();
    }

    public void stopLoading() {
        this.aGd = false;
        removeCallbacks(this);
        this.axO = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aGd) {
            this.axO += this.aGa;
            if (this.axO > 360.0f - this.aGa) {
                this.axO = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.axO, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DT();
        }
    }

    private void Hc() {
        if (this.mAutoChangeStyle) {
            this.uW.vw = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.uW.vw = false;
        }
        int i = this.aFY;
        int i2 = this.aGd ? this.aFX : this.aFW;
        if (i2 != this.aFY) {
            this.aFY = i2;
            this.vg = true;
        }
        int i3 = this.aFZ;
        this.aFZ = this.adH;
        if (this.aFZ > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ar.getDrawable(this.aFZ));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aFZ));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.adG != i) {
            this.adG = i;
            this.aFW = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aFV = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.adH != i) {
            this.adH = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ayd = bdUniqueId;
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
        this.aGe = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aGe) {
            startLoading();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEe, this.mWidth, this.mHeight, this.ayd, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.uW.vz != null) {
            return this.uW.vz.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.uW.vz != null) {
            return this.uW.vz.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.ayc = z;
    }

    public u getPerfLog() {
        return this.aGf;
    }

    public void vW() {
        if (!this.aGc) {
            this.aGc = true;
        } else if (this.aGf != null && this.aGf.aBW) {
            this.aGf.FO();
        }
    }
}
