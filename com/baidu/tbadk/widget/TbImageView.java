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
public class TbImageView extends com.baidu.adp.b.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aKO;
    private static Method aKX;
    private static Method aKY;
    private static Method aKZ;
    private static Method aLa;
    protected boolean aCK;
    private float aCx;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIM;
    protected a aKH;
    protected int aKI;
    protected int aKJ;
    private final int aKK;
    private int aKL;
    private int aKM;
    private float aKN;
    protected boolean aKP;
    private boolean aKQ;
    private boolean aKR;
    protected u aKS;
    private int aKT;
    protected long aKU;
    int aKV;
    int aKW;
    private boolean aLb;
    protected int ahN;
    private int ahO;
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
        this.aKH = aVar;
    }

    public int getLoadedWidth() {
        return this.aKV;
    }

    public int getLoadedHeight() {
        return this.aKW;
    }

    public TbImageView(Context context) {
        super(context);
        this.aKH = null;
        this.ahN = w.e.transparent;
        this.aKI = w.g.img_default_100;
        this.aKJ = this.ahN;
        this.aKK = w.g.img_loading;
        this.ahO = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCK = false;
        this.aKS = null;
        this.aKT = 3;
        this.aKU = 0L;
        this.aKV = 0;
        this.aKW = 0;
        this.aLb = false;
        this.aIM = new f(this);
        this.listener = new g(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKH = null;
        this.ahN = w.e.transparent;
        this.aKI = w.g.img_default_100;
        this.aKJ = this.ahN;
        this.aKK = w.g.img_loading;
        this.ahO = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCK = false;
        this.aKS = null;
        this.aKT = 3;
        this.aKU = 0L;
        this.aKV = 0;
        this.aKW = 0;
        this.aLb = false;
        this.aIM = new f(this);
        this.listener = new g(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Hd();
        this.aKN = 30.0f;
        this.aKS = new u();
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

    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getBdImage() {
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                return null;
            }
            String str = (String) tag;
            com.baidu.adp.widget.a.a fL = com.baidu.tbadk.imageManager.c.DN().fL(str);
            return fL == null ? com.baidu.tbadk.imageManager.c.DN().fK(str) : fL;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aKO == null) {
            aKO = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aKL);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aKT != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.BP = true;
            this.aKT = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aKO.containsKey(str) || (softReference = aKO.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kS()) {
            Bitmap bitmap = null;
            if (this.aKL > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = aq.cL(this.aKL);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aKL);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aKL);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aKL);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aKL));
            aKO.put(str, new SoftReference<>(aVar2));
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
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : X.getUniqueId();
            z2 = X.isScroll();
            bdUniqueId = uniqueId;
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : X.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aKJ = this.ahN;
        if (TextUtils.isEmpty(str)) {
            this.aKJ = this.aKI;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            DK();
            this.BP = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aKS.Hf = "memory";
            this.aKS.isSuccess = true;
            this.aKS.Hg = 0L;
            invalidate();
            if (this.aKH != null) {
                this.aKH.v(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.fM().ak(this.mType) && this.aCK) {
            invalidate();
        } else if (z3 && !i.hk()) {
            this.aKS.Hf = "memory";
            this.aKS.isSuccess = false;
            this.aKS.Hg = 0L;
            this.aKJ = this.aKI;
            invalidate();
            if (this.aKH != null) {
                this.aKH.v(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aKU = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIM, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void DK() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIM);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.g<?> Z = k.Z(getContext());
        if (this.mPageId != null) {
            this.aLb = true;
        }
        if (Z != null) {
            this.listener.setTag(this.mPageId != null ? this.mPageId : Z.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.listener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aLb = false;
        DK();
        MessageManager.getInstance().unRegisterListener(this.listener);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DK();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Hd();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aKQ = true;
        DJ();
    }

    public void stopLoading() {
        this.aKQ = false;
        removeCallbacks(this);
        this.aCx = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DJ() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKQ) {
            this.aCx += this.aKN;
            if (this.aCx > 360.0f - this.aKN) {
                this.aCx = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aCx, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DJ();
        }
    }

    private void Hd() {
        if (this.mAutoChangeStyle) {
            this.BF.Cf = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.BF.Cf = false;
        }
        int i = this.aKL;
        int i2 = this.aKQ ? this.aKK : this.aKJ;
        if (i2 != this.aKL) {
            this.aKL = i2;
            this.BP = true;
        }
        int i3 = this.aKM;
        this.aKM = this.ahO;
        if (this.aKM > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aq.getDrawable(this.aKM));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aKM));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.ahN != i) {
            this.ahN = i;
            this.aKJ = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aKI = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.ahO != i) {
            this.ahO = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aLb && this.mPageId != null) {
            this.listener.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.listener);
            this.aLb = true;
        }
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.baidu.adp.b.a.i
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
        this.aKR = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aKR) {
            startLoading();
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIM, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
        this.aCK = z;
    }

    public u getPerfLog() {
        return this.aKS;
    }

    public void vW() {
        if (!this.aKP) {
            this.aKP = true;
        } else if (this.aKS != null && this.aKS.aGB) {
            this.aKS.FE();
        }
    }
}
