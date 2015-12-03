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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tieba.n;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aBR;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAj;
    private a aBM;
    private final int aBN;
    private int aBO;
    private int aBP;
    private float aBQ;
    protected boolean aBS;
    private boolean aBT;
    private boolean aBU;
    protected s aBV;
    private int aBW;
    private long aBX;
    int aBY;
    int aBZ;
    private int adU;
    private int adV;
    private CustomMessageListener afH;
    private float aui;
    private boolean auw;
    private BdUniqueId aux;
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
        this.aBM = aVar;
    }

    public int getLoadedWidth() {
        return this.aBY;
    }

    public int getLoadedHeight() {
        return this.aBZ;
    }

    public TbImageView(Context context) {
        super(context);
        this.aBM = null;
        this.adU = n.e.img_default_100;
        this.aBN = n.e.img_loading;
        this.adV = n.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.auw = false;
        this.aBV = null;
        this.aBW = 3;
        this.aBX = 0L;
        this.aBY = 0;
        this.aBZ = 0;
        this.aAj = new d(this);
        this.afH = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBM = null;
        this.adU = n.e.img_default_100;
        this.aBN = n.e.img_loading;
        this.adV = n.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.auw = false;
        this.aBV = null;
        this.aBW = 3;
        this.aBX = 0L;
        this.aBY = 0;
        this.aBZ = 0;
        this.aAj = new d(this);
        this.afH = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        FJ();
        this.aBQ = 30.0f;
        this.aBV = new s();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Bs = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Bs = true;
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
            com.baidu.adp.widget.a.a fF = com.baidu.tbadk.imageManager.c.CX().fF(str);
            return fF == null ? com.baidu.tbadk.imageManager.c.CX().fE(str) : fF;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aBR == null) {
            aBR = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aBO);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aBW != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.Bs = true;
            this.aBW = TbadkCoreApplication.m411getInst().getSkinType();
        }
        if (!aBR.containsKey(str) || (softReference = aBR.get(str)) == null || (aVar = softReference.get()) == null || !aVar.nh()) {
            Bitmap bitmap = null;
            if (this.aBO > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = as.cE(this.aBO);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.cn(this.aBO);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.cn(this.aBO);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.cn(this.aBO);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aBO));
            aBR.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.aux)) {
            CU();
            this.Bs = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aBV.GI = "memory";
            this.aBV.isSuccess = true;
            this.aBV.GJ = 0L;
            invalidate();
            if (this.aBM != null) {
                this.aBM.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.aux = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bs = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hd().X(this.mType) && this.auw) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aBX = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, this.aAj, i2, i3, this.aux, new Object[0]);
        }
    }

    public void CU() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, this.aAj);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.afH.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.afH);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CU();
        MessageManager.getInstance().unRegisterListener(this.afH);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CU();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        FJ();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aBT = true;
        CT();
    }

    public void stopLoading() {
        this.aBT = false;
        removeCallbacks(this);
        this.aui = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void CT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aBT) {
            this.aui += this.aBQ;
            if (this.aui > 360.0f - this.aBQ) {
                this.aui = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aui, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            CT();
        }
    }

    private void FJ() {
        if (this.mAutoChangeStyle) {
            this.Bi.BI = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Bi.BI = false;
        }
        int i = this.aBO;
        int i2 = this.aBT ? this.aBN : this.adU;
        if (i2 != this.aBO) {
            this.aBO = i2;
            this.Bs = true;
        }
        int i3 = this.aBP;
        this.aBP = this.adV;
        if (this.aBP > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(as.getDrawable(this.aBP));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aBP));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.adU != i) {
            this.adU = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.adV != i) {
            this.adV = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aux = bdUniqueId;
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
        this.aBU = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aBU) {
            startLoading();
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, this.aAj, this.mWidth, this.mHeight, this.aux, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Bi.BL != null) {
            return this.Bi.BL.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Bi.BL != null) {
            return this.Bi.BL.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.auw = z;
    }

    public s getPerfLog() {
        return this.aBV;
    }

    public void vY() {
        if (!this.aBS) {
            this.aBS = true;
        } else if (this.aBV != null && this.aBV.ayl) {
            this.aBV.EL();
        }
    }
}
