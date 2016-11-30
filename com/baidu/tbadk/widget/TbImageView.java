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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aGH;
    private static Method aGQ;
    private static Method aGR;
    private static Method aGS;
    private static Method aGT;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEL;
    private a aGA;
    private int aGB;
    private int aGC;
    private final int aGD;
    private int aGE;
    private int aGF;
    private float aGG;
    protected boolean aGI;
    private boolean aGJ;
    private boolean aGK;
    protected u aGL;
    private int aGM;
    private long aGN;
    int aGO;
    int aGP;
    private int aen;
    private int aeo;
    private CustomMessageListener ahs;
    private boolean ayF;
    private BdUniqueId ayG;
    private float ayr;
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
        this.aGA = aVar;
    }

    public int getLoadedWidth() {
        return this.aGO;
    }

    public int getLoadedHeight() {
        return this.aGP;
    }

    public TbImageView(Context context) {
        super(context);
        this.aGA = null;
        this.aen = r.d.transparent;
        this.aGB = r.f.img_default_100;
        this.aGC = this.aen;
        this.aGD = r.f.img_loading;
        this.aeo = r.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ayF = false;
        this.aGL = null;
        this.aGM = 3;
        this.aGN = 0L;
        this.aGO = 0;
        this.aGP = 0;
        this.aEL = new d(this);
        this.ahs = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGA = null;
        this.aen = r.d.transparent;
        this.aGB = r.f.img_default_100;
        this.aGC = this.aen;
        this.aGD = r.f.img_loading;
        this.aeo = r.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ayF = false;
        this.aGL = null;
        this.aGM = 3;
        this.aGN = 0L;
        this.aGO = 0;
        this.aGP = 0;
        this.aEL = new d(this);
        this.ahs = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HG();
        this.aGG = 30.0f;
        this.aGL = new u();
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
            com.baidu.adp.widget.a.a ga = com.baidu.tbadk.imageManager.c.Ep().ga(str);
            return ga == null ? com.baidu.tbadk.imageManager.c.Ep().fZ(str) : ga;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aGH == null) {
            aGH = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aGE);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aGM != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.vg = true;
            this.aGM = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aGH.containsKey(str) || (softReference = aGH.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jW()) {
            Bitmap bitmap = null;
            if (this.aGE > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = at.cO(this.aGE);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aGE);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aGE);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aGE);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aGE));
            aGH.put(str, new SoftReference<>(aVar2));
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
        this.aGC = this.aen;
        if (TextUtils.isEmpty(str)) {
            this.aGC = this.aGB;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.ayG;
        if (!z3) {
            Em();
            this.vg = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aGL.Az = "memory";
            this.aGL.isSuccess = true;
            this.aGL.AA = 0L;
            invalidate();
            if (this.aGA != null) {
                this.aGA.v(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.ayG = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.vg = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().al(this.mType) && this.ayF) {
            invalidate();
        } else if (z3 && !i.gm()) {
            this.aGL.Az = "memory";
            this.aGL.isSuccess = false;
            this.aGL.AA = 0L;
            this.aGC = this.aGB;
            invalidate();
            if (this.aGA != null) {
                this.aGA.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aGN = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEL, i2, i3, this.ayG, new Object[0]);
        }
    }

    public void Em() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEL);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.ahs.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.ahs);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Em();
        MessageManager.getInstance().unRegisterListener(this.ahs);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Em();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Em();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HG();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aGJ = true;
        El();
    }

    public void stopLoading() {
        this.aGJ = false;
        removeCallbacks(this);
        this.ayr = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void El() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aGJ) {
            this.ayr += this.aGG;
            if (this.ayr > 360.0f - this.aGG) {
                this.ayr = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.ayr, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            El();
        }
    }

    private void HG() {
        if (this.mAutoChangeStyle) {
            this.uW.vw = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.uW.vw = false;
        }
        int i = this.aGE;
        int i2 = this.aGJ ? this.aGD : this.aGC;
        if (i2 != this.aGE) {
            this.aGE = i2;
            this.vg = true;
        }
        int i3 = this.aGF;
        this.aGF = this.aeo;
        if (this.aGF > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(at.getDrawable(this.aGF));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aGF));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aen != i) {
            this.aen = i;
            this.aGC = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aGB = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aeo != i) {
            this.aeo = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ayG = bdUniqueId;
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
        this.aGK = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aGK) {
            startLoading();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEL, this.mWidth, this.mHeight, this.ayG, new Object[0]);
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
        this.ayF = z;
    }

    public u getPerfLog() {
        return this.aGL;
    }

    public void wm() {
        if (!this.aGI) {
            this.aGI = true;
        } else if (this.aGL != null && this.aGL.aCC) {
            this.aGL.Go();
        }
    }
}
