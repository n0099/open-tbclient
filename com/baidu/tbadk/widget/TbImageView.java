package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.g;
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aEQ;
    private static Method aEZ;
    private static Method aFa;
    private static Method aFb;
    private static Method aFc;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCU;
    private a aEJ;
    private int aEK;
    private int aEL;
    private final int aEM;
    private int aEN;
    private int aEO;
    private float aEP;
    protected boolean aER;
    private boolean aES;
    private boolean aET;
    protected u aEU;
    private int aEV;
    private long aEW;
    int aEX;
    int aEY;
    private int acQ;
    private int acR;
    private CustomMessageListener afX;
    private float awM;
    private boolean awZ;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mType;
    private String mUrl;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void v(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aEJ = aVar;
    }

    public int getLoadedWidth() {
        return this.aEX;
    }

    public int getLoadedHeight() {
        return this.aEY;
    }

    public TbImageView(Context context) {
        super(context);
        this.aEJ = null;
        this.acQ = r.e.transparent;
        this.aEK = r.g.img_default_100;
        this.aEL = this.acQ;
        this.aEM = r.g.img_loading;
        this.acR = r.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.awZ = false;
        this.aEU = null;
        this.aEV = 3;
        this.aEW = 0L;
        this.aEX = 0;
        this.aEY = 0;
        this.aCU = new d(this);
        this.afX = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEJ = null;
        this.acQ = r.e.transparent;
        this.aEK = r.g.img_default_100;
        this.aEL = this.acQ;
        this.aEM = r.g.img_loading;
        this.acR = r.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.awZ = false;
        this.aEU = null;
        this.aEV = 3;
        this.aEW = 0L;
        this.aEX = 0;
        this.aEY = 0;
        this.aCU = new d(this);
        this.afX = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        GU();
        this.aEP = 30.0f;
        this.aEU = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.uX = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.uX = true;
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
            com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.DS().fT(str);
            return fT == null ? com.baidu.tbadk.imageManager.c.DS().fS(str) : fT;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ey().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aEQ == null) {
            aEQ = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aEN);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aEV != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.uX = true;
            this.aEV = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aEQ.containsKey(str) || (softReference = aEQ.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jU()) {
            Bitmap bitmap = null;
            if (this.aEN > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = ap.cP(this.aEN);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aEN);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aEN);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aEN);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aEN));
            aEQ.put(str, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public void c(String str, int i, boolean z) {
        a(str, i, 0, 0, z);
    }

    public void a(String str, int i, boolean z, boolean z2) {
        a(str, i, 0, 0, z, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        j A = k.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z2 = A.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        j A = k.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aEL = this.acQ;
        if (TextUtils.isEmpty(str)) {
            this.aEL = this.aEK;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            DP();
            this.uX = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aEU.Ap = "memory";
            this.aEU.isSuccess = true;
            this.aEU.Aq = 0L;
            invalidate();
            if (this.aEJ != null) {
                this.aEJ.v(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.uX = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.ey().am(this.mType) && this.awZ) {
            invalidate();
        } else if (z3 && !i.gk()) {
            this.aEU.Ap = "memory";
            this.aEU.isSuccess = false;
            this.aEU.Aq = 0L;
            this.aEL = this.aEK;
            invalidate();
            if (this.aEJ != null) {
                this.aEJ.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aEW = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.ey().a(this.mUrl, this.mType, this.aCU, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void DP() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.ey().a(this.mUrl, this.mType, this.aCU);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g<?> C = k.C(getContext());
        if (C != null) {
            this.afX.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.afX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DP();
        MessageManager.getInstance().unRegisterListener(this.afX);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DP();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        GU();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aES = true;
        DO();
    }

    public void stopLoading() {
        this.aES = false;
        removeCallbacks(this);
        this.awM = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DO() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aES) {
            this.awM += this.aEP;
            if (this.awM > 360.0f - this.aEP) {
                this.awM = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.awM, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DO();
        }
    }

    private void GU() {
        if (this.mAutoChangeStyle) {
            this.uN.vn = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.uN.vn = false;
        }
        int i = this.aEN;
        int i2 = this.aES ? this.aEM : this.aEL;
        if (i2 != this.aEN) {
            this.aEN = i2;
            this.uX = true;
        }
        int i3 = this.aEO;
        this.aEO = this.acR;
        if (this.aEO > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ap.getDrawable(this.aEO));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aEO));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.acQ != i) {
            this.acQ = i;
            this.aEL = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aEK = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.acR != i) {
            this.acR = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
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
        this.aET = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aET) {
            startLoading();
            com.baidu.adp.lib.f.c.ey().a(this.mUrl, this.mType, this.aCU, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.uN.vq != null) {
            return this.uN.vq.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.uN.vq != null) {
            return this.uN.vq.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.awZ = z;
    }

    public u getPerfLog() {
        return this.aEU;
    }

    public void vQ() {
        if (!this.aER) {
            this.aER = true;
        } else if (this.aEU != null && this.aEU.aAO) {
            this.aEU.FI();
        }
    }
}
