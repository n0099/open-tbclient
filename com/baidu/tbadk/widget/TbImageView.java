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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aEp;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aCG;
    private a aEk;
    private final int aEl;
    private int aEm;
    private int aEn;
    private float aEo;
    protected boolean aEq;
    private boolean aEr;
    private boolean aEs;
    protected u aEt;
    private int aEu;
    private long aEv;
    int aEw;
    int aEx;
    private int afa;
    private int afb;
    private CustomMessageListener ahi;
    private float awD;
    private boolean awR;
    private BdUniqueId awS;
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

        void t(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aEk = aVar;
    }

    public int getLoadedWidth() {
        return this.aEw;
    }

    public int getLoadedHeight() {
        return this.aEx;
    }

    public TbImageView(Context context) {
        super(context);
        this.aEk = null;
        this.afa = t.f.img_default_100;
        this.aEl = t.f.img_loading;
        this.afb = t.d.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.awR = false;
        this.aEt = null;
        this.aEu = 3;
        this.aEv = 0L;
        this.aEw = 0;
        this.aEx = 0;
        this.aCG = new d(this);
        this.ahi = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEk = null;
        this.afa = t.f.img_default_100;
        this.aEl = t.f.img_loading;
        this.afb = t.d.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.awR = false;
        this.aEt = null;
        this.aEu = 3;
        this.aEv = 0L;
        this.aEw = 0;
        this.aEx = 0;
        this.aCG = new d(this);
        this.ahi = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        GQ();
        this.aEo = 30.0f;
        this.aEt = new u();
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
            com.baidu.adp.widget.a.a fH = com.baidu.tbadk.imageManager.c.Ed().fH(str);
            return fH == null ? com.baidu.tbadk.imageManager.c.Ed().fG(str) : fH;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hl().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aEp == null) {
            aEp = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aEm);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aEu != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.BC = true;
            this.aEu = TbadkCoreApplication.m411getInst().getSkinType();
        }
        if (!aEp.containsKey(str) || (softReference = aEp.get(str)) == null || (aVar = softReference.get()) == null || !aVar.mT()) {
            Bitmap bitmap = null;
            if (this.aEm > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = ar.cO(this.aEm);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aEm);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aEm);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aEm);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aEm));
            aEp.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.awS)) {
            Ea();
            this.BC = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aEt.Hl = "memory";
            this.aEt.isSuccess = true;
            this.aEt.Hm = 0L;
            invalidate();
            if (this.aEk != null) {
                this.aEk.t(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.awS = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.BC = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hl().ai(this.mType) && this.awR) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aEv = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.hl().a(this.mUrl, this.mType, this.aCG, i2, i3, this.awS, new Object[0]);
        }
    }

    public void Ea() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hl().a(this.mUrl, this.mType, this.aCG);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.ahi.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.ahi);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ea();
        MessageManager.getInstance().unRegisterListener(this.ahi);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ea();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ea();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        GQ();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aEr = true;
        DZ();
    }

    public void stopLoading() {
        this.aEr = false;
        removeCallbacks(this);
        this.awD = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DZ() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aEr) {
            this.awD += this.aEo;
            if (this.awD > 360.0f - this.aEo) {
                this.awD = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.awD, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DZ();
        }
    }

    private void GQ() {
        if (this.mAutoChangeStyle) {
            this.Bs.BS = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Bs.BS = false;
        }
        int i = this.aEm;
        int i2 = this.aEr ? this.aEl : this.afa;
        if (i2 != this.aEm) {
            this.aEm = i2;
            this.BC = true;
        }
        int i3 = this.aEn;
        this.aEn = this.afb;
        if (this.aEn > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ar.getDrawable(this.aEn));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aEn));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.afa != i) {
            this.afa = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.afb != i) {
            this.afb = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.awS = bdUniqueId;
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
        this.aEs = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aEs) {
            startLoading();
            com.baidu.adp.lib.g.c.hl().a(this.mUrl, this.mType, this.aCG, this.mWidth, this.mHeight, this.awS, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Bs.BV != null) {
            return this.Bs.BV.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Bs.BV != null) {
            return this.Bs.BV.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.awR = z;
    }

    public u getPerfLog() {
        return this.aEt;
    }

    public void wQ() {
        if (!this.aEq) {
            this.aEq = true;
        } else if (this.aEt != null && this.aEt.aAD) {
            this.aEt.FR();
        }
    }
}
