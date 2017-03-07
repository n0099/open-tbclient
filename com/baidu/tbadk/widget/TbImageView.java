package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aKn;
    private static Method aKw;
    private static Method aKx;
    private static Method aKy;
    private static Method aKz;
    private float aCg;
    private boolean aCt;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIr;
    private a aKg;
    private int aKh;
    private int aKi;
    private final int aKj;
    private int aKk;
    private int aKl;
    private float aKm;
    protected boolean aKo;
    private boolean aKp;
    private boolean aKq;
    protected u aKr;
    private int aKs;
    private long aKt;
    int aKu;
    int aKv;
    private int aig;
    private int aih;
    private CustomMessageListener alq;
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
        this.aKg = aVar;
    }

    public int getLoadedWidth() {
        return this.aKu;
    }

    public int getLoadedHeight() {
        return this.aKv;
    }

    public TbImageView(Context context) {
        super(context);
        this.aKg = null;
        this.aig = w.e.transparent;
        this.aKh = w.g.img_default_100;
        this.aKi = this.aig;
        this.aKj = w.g.img_loading;
        this.aih = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCt = false;
        this.aKr = null;
        this.aKs = 3;
        this.aKt = 0L;
        this.aKu = 0;
        this.aKv = 0;
        this.aIr = new e(this);
        this.alq = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKg = null;
        this.aig = w.e.transparent;
        this.aKh = w.g.img_default_100;
        this.aKi = this.aig;
        this.aKj = w.g.img_loading;
        this.aih = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCt = false;
        this.aKr = null;
        this.aKs = 3;
        this.aKt = 0L;
        this.aKu = 0;
        this.aKv = 0;
        this.aIr = new e(this);
        this.alq = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Ht();
        this.aKm = 30.0f;
        this.aKr = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Cl = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Cl = true;
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
            com.baidu.adp.widget.a.a fI = com.baidu.tbadk.imageManager.c.El().fI(str);
            return fI == null ? com.baidu.tbadk.imageManager.c.El().fH(str) : fI;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fG().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aKn == null) {
            aKn = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aKk);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aKs != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.Cl = true;
            this.aKs = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aKn.containsKey(str) || (softReference = aKn.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kO()) {
            Bitmap bitmap = null;
            if (this.aKk > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = aq.cL(this.aKk);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aKk);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aKk);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aKk);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aKk));
            aKn.put(str, new SoftReference<>(aVar2));
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
        j Y = k.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
            z2 = Y.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        j Y = k.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aKi = this.aig;
        if (TextUtils.isEmpty(str)) {
            this.aKi = this.aKh;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            Ei();
            this.Cl = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aKr.HC = "memory";
            this.aKr.isSuccess = true;
            this.aKr.HD = 0L;
            invalidate();
            if (this.aKg != null) {
                this.aKg.v(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Cl = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fG().am(this.mType) && this.aCt) {
            invalidate();
        } else if (z3 && !i.he()) {
            this.aKr.HC = "memory";
            this.aKr.isSuccess = false;
            this.aKr.HD = 0L;
            this.aKi = this.aKh;
            invalidate();
            if (this.aKg != null) {
                this.aKg.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aKt = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fG().a(this.mUrl, this.mType, this.aIr, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void Ei() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fG().a(this.mUrl, this.mType, this.aIr);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.g<?> aa = k.aa(getContext());
        if (aa != null) {
            this.alq.setTag(aa.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.alq);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ei();
        MessageManager.getInstance().unRegisterListener(this.alq);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ei();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ei();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Ht();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aKp = true;
        Eh();
    }

    public void stopLoading() {
        this.aKp = false;
        removeCallbacks(this);
        this.aCg = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Eh() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKp) {
            this.aCg += this.aKm;
            if (this.aCg > 360.0f - this.aKm) {
                this.aCg = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aCg, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Eh();
        }
    }

    private void Ht() {
        if (this.mAutoChangeStyle) {
            this.Cb.CB = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.Cb.CB = false;
        }
        int i = this.aKk;
        int i2 = this.aKp ? this.aKj : this.aKi;
        if (i2 != this.aKk) {
            this.aKk = i2;
            this.Cl = true;
        }
        int i3 = this.aKl;
        this.aKl = this.aih;
        if (this.aKl > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aq.getDrawable(this.aKl));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aKl));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aig != i) {
            this.aig = i;
            this.aKi = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aKh = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aih != i) {
            this.aih = i;
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
        this.aKq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aKq) {
            startLoading();
            com.baidu.adp.lib.f.c.fG().a(this.mUrl, this.mType, this.aIr, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Cb.CE != null) {
            return this.Cb.CE.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Cb.CE != null) {
            return this.Cb.CE.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aCt = z;
    }

    public u getPerfLog() {
        return this.aKr;
    }

    public void wn() {
        if (!this.aKo) {
            this.aKo = true;
        } else if (this.aKr != null && this.aKr.aGg) {
            this.aKr.Gc();
        }
    }
}
