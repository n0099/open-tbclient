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
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aKF;
    private static Method aKO;
    private static Method aKP;
    private static Method aKQ;
    private static Method aKR;
    protected boolean aCL;
    private float aCy;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIJ;
    protected int aKA;
    private final int aKB;
    private int aKC;
    private int aKD;
    private float aKE;
    protected boolean aKG;
    private boolean aKH;
    private boolean aKI;
    protected u aKJ;
    private int aKK;
    protected long aKL;
    int aKM;
    int aKN;
    protected a aKy;
    protected int aKz;
    protected int aiv;
    private int aiw;
    private CustomMessageListener listener;
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
        this.aKy = aVar;
    }

    public int getLoadedWidth() {
        return this.aKM;
    }

    public int getLoadedHeight() {
        return this.aKN;
    }

    public TbImageView(Context context) {
        super(context);
        this.aKy = null;
        this.aiv = w.e.transparent;
        this.aKz = w.g.img_default_100;
        this.aKA = this.aiv;
        this.aKB = w.g.img_loading;
        this.aiw = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCL = false;
        this.aKJ = null;
        this.aKK = 3;
        this.aKL = 0L;
        this.aKM = 0;
        this.aKN = 0;
        this.aIJ = new e(this);
        this.listener = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKy = null;
        this.aiv = w.e.transparent;
        this.aKz = w.g.img_default_100;
        this.aKA = this.aiv;
        this.aKB = w.g.img_loading;
        this.aiw = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCL = false;
        this.aKJ = null;
        this.aKK = 3;
        this.aKL = 0L;
        this.aKM = 0;
        this.aKN = 0;
        this.aIJ = new e(this);
        this.listener = new f(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HS();
        this.aKE = 30.0f;
        this.aKJ = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.BP = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.BP = true;
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
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aKF == null) {
            aKF = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aKC);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aKK != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.BP = true;
            this.aKK = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aKF.containsKey(str) || (softReference = aKF.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kT()) {
            Bitmap bitmap = null;
            if (this.aKC > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = aq.cO(this.aKC);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aKC);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aKC);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aKC);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aKC));
            aKF.put(str, new SoftReference<>(aVar2));
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
        this.aKA = this.aiv;
        if (TextUtils.isEmpty(str)) {
            this.aKA = this.aKz;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            EG();
            this.BP = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aKJ.Hf = "memory";
            this.aKJ.isSuccess = true;
            this.aKJ.Hg = 0L;
            invalidate();
            if (this.aKy != null) {
                this.aKy.v(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.BP = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fM().al(this.mType) && this.aCL) {
            invalidate();
        } else if (z3 && !i.hk()) {
            this.aKJ.Hf = "memory";
            this.aKJ.isSuccess = false;
            this.aKJ.Hg = 0L;
            this.aKA = this.aKz;
            invalidate();
            if (this.aKy != null) {
                this.aKy.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aKL = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIJ, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void EG() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIJ);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.g<?> Z = k.Z(getContext());
        if (Z != null) {
            this.listener.setTag(Z.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.listener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EG();
        MessageManager.getInstance().unRegisterListener(this.listener);
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
        this.aKH = true;
        EF();
    }

    public void stopLoading() {
        this.aKH = false;
        removeCallbacks(this);
        this.aCy = 0.0f;
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
        if (this.aKH) {
            this.aCy += this.aKE;
            if (this.aCy > 360.0f - this.aKE) {
                this.aCy = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aCy, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            EF();
        }
    }

    private void HS() {
        if (this.mAutoChangeStyle) {
            this.BF.Cf = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.BF.Cf = false;
        }
        int i = this.aKC;
        int i2 = this.aKH ? this.aKB : this.aKA;
        if (i2 != this.aKC) {
            this.aKC = i2;
            this.BP = true;
        }
        int i3 = this.aKD;
        this.aKD = this.aiw;
        if (this.aKD > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aq.getDrawable(this.aKD));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aKD));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aiv != i) {
            this.aiv = i;
            this.aKA = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aKz = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aiw != i) {
            this.aiw = i;
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
        this.aKI = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aKI) {
            startLoading();
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIJ, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.BF.Ci != null) {
            return this.BF.Ci.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.BF.Ci != null) {
            return this.BF.Ci.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aCL = z;
    }

    public u getPerfLog() {
        return this.aKJ;
    }

    public void wJ() {
        if (!this.aKG) {
            this.aKG = true;
        } else if (this.aKJ != null && this.aKJ.aGx) {
            this.aKJ.GA();
        }
    }
}
