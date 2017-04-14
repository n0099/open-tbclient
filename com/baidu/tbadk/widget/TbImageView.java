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
import com.baidu.tbadk.j.u;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aKD;
    private static Method aKM;
    private static Method aKN;
    private static Method aKO;
    private static Method aKP;
    protected boolean aCJ;
    private float aCw;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIH;
    private int aKA;
    private int aKB;
    private float aKC;
    protected boolean aKE;
    private boolean aKF;
    private boolean aKG;
    protected u aKH;
    private int aKI;
    protected long aKJ;
    int aKK;
    int aKL;
    protected a aKw;
    protected int aKx;
    protected int aKy;
    private final int aKz;
    protected int aiu;
    private int aiv;
    private CustomMessageListener alE;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void v(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aKw = aVar;
    }

    public int getLoadedWidth() {
        return this.aKK;
    }

    public int getLoadedHeight() {
        return this.aKL;
    }

    public TbImageView(Context context) {
        super(context);
        this.aKw = null;
        this.aiu = w.e.transparent;
        this.aKx = w.g.img_default_100;
        this.aKy = this.aiu;
        this.aKz = w.g.img_loading;
        this.aiv = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCJ = false;
        this.aKH = null;
        this.aKI = 3;
        this.aKJ = 0L;
        this.aKK = 0;
        this.aKL = 0;
        this.aIH = new e(this);
        this.alE = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKw = null;
        this.aiu = w.e.transparent;
        this.aKx = w.g.img_default_100;
        this.aKy = this.aiu;
        this.aKz = w.g.img_loading;
        this.aiv = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCJ = false;
        this.aKH = null;
        this.aKI = 3;
        this.aKJ = 0L;
        this.aKK = 0;
        this.aKL = 0;
        this.aIH = new e(this);
        this.alE = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HS();
        this.aKC = 30.0f;
        this.aKH = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.BM = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.BM = true;
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
            com.baidu.adp.widget.a.a fO = com.baidu.tbadk.imageManager.c.EJ().fO(str);
            return fO == null ? com.baidu.tbadk.imageManager.c.EJ().fN(str) : fO;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aKD == null) {
            aKD = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aKA);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aKI != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.BM = true;
            this.aKI = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aKD.containsKey(str) || (softReference = aKD.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kS()) {
            Bitmap bitmap = null;
            if (this.aKA > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = aq.cO(this.aKA);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aKA);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aKA);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aKA);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aKA));
            aKD.put(str, new SoftReference<>(aVar2));
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
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z2 = X.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aKy = this.aiu;
        if (TextUtils.isEmpty(str)) {
            this.aKy = this.aKx;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            EG();
            this.BM = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aKH.Hd = "memory";
            this.aKH.isSuccess = true;
            this.aKH.He = 0L;
            invalidate();
            if (this.aKw != null) {
                this.aKw.v(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.BM = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fL().al(this.mType) && this.aCJ) {
            invalidate();
        } else if (z3 && !i.hj()) {
            this.aKH.Hd = "memory";
            this.aKH.isSuccess = false;
            this.aKH.He = 0L;
            this.aKy = this.aKx;
            invalidate();
            if (this.aKw != null) {
                this.aKw.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aKJ = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, this.aIH, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void EG() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, this.aIH);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.g<?> Z = k.Z(getContext());
        if (Z != null) {
            this.alE.setTag(Z.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.alE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EG();
        MessageManager.getInstance().unRegisterListener(this.alE);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        EG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            EG();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HS();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aKF = true;
        EF();
    }

    public void stopLoading() {
        this.aKF = false;
        removeCallbacks(this);
        this.aCw = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void EF() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKF) {
            this.aCw += this.aKC;
            if (this.aCw > 360.0f - this.aKC) {
                this.aCw = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aCw, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            EF();
        }
    }

    private void HS() {
        if (this.mAutoChangeStyle) {
            this.BC.Cc = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.BC.Cc = false;
        }
        int i = this.aKA;
        int i2 = this.aKF ? this.aKz : this.aKy;
        if (i2 != this.aKA) {
            this.aKA = i2;
            this.BM = true;
        }
        int i3 = this.aKB;
        this.aKB = this.aiv;
        if (this.aKB > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aq.getDrawable(this.aKB));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aKB));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aiu != i) {
            this.aiu = i;
            this.aKy = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aKx = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aiv != i) {
            this.aiv = i;
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
        this.aKG = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aKG) {
            startLoading();
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, this.aIH, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.BC.Cf != null) {
            return this.BC.Cf.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.BC.Cf != null) {
            return this.BC.Cf.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aCJ = z;
    }

    public u getPerfLog() {
        return this.aKH;
    }

    public void wJ() {
        if (!this.aKE) {
            this.aKE = true;
        } else if (this.aKH != null && this.aKH.aGv) {
            this.aKH.GA();
        }
    }
}
