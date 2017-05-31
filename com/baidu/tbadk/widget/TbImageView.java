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
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aKB;
    private static Method aKL;
    private static Method aKM;
    private static Method aKN;
    private static Method aKO;
    private float aCk;
    protected boolean aCx;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIz;
    private float aKA;
    protected boolean aKC;
    private boolean aKD;
    private com.baidu.tieba.pb.a.d aKE;
    private boolean aKF;
    protected u aKG;
    private int aKH;
    protected long aKI;
    int aKJ;
    int aKK;
    private boolean aKP;
    private final com.baidu.tieba.pb.a.d aKQ;
    protected a aKu;
    protected int aKv;
    protected int aKw;
    private final int aKx;
    private int aKy;
    private int aKz;
    protected int ahE;
    private int ahF;
    private CustomMessageListener listener;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected boolean sb;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void s(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aKu = aVar;
    }

    public int getLoadedWidth() {
        return this.aKJ;
    }

    public int getLoadedHeight() {
        return this.aKK;
    }

    public TbImageView(Context context) {
        super(context);
        this.aKu = null;
        this.ahE = w.e.transparent;
        this.aKv = w.g.img_default_100;
        this.aKw = this.ahE;
        this.aKx = w.g.img_loading;
        this.ahF = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCx = false;
        this.aKG = null;
        this.aKH = 3;
        this.aKI = 0L;
        this.aKJ = 0;
        this.aKK = 0;
        this.aKP = false;
        this.aKQ = new com.baidu.tieba.pb.a.d(new f(this));
        this.aIz = new g(this);
        this.listener = new h(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKu = null;
        this.ahE = w.e.transparent;
        this.aKv = w.g.img_default_100;
        this.aKw = this.ahE;
        this.aKx = w.g.img_loading;
        this.ahF = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aCx = false;
        this.aKG = null;
        this.aKH = 3;
        this.aKI = 0L;
        this.aKJ = 0;
        this.aKK = 0;
        this.aKP = false;
        this.aKQ = new com.baidu.tieba.pb.a.d(new f(this));
        this.aIz = new g(this);
        this.listener = new h(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        GX();
        this.aKA = 30.0f;
        this.aKG = new u();
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
        com.baidu.adp.widget.a.a aVar;
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                aVar = null;
            } else {
                String str = (String) tag;
                com.baidu.adp.widget.a.a fK = com.baidu.tbadk.imageManager.c.DH().fK(str);
                aVar = fK == null ? com.baidu.tbadk.imageManager.c.DH().fJ(str) : fK;
            }
        } else {
            aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            this.sb = aVar.ef();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aKB == null) {
            aKB = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aKy);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aKH != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.BP = true;
            this.aKH = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aKB.containsKey(str) || (softReference = aKB.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kS()) {
            Bitmap bitmap = null;
            if (this.aKy > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = aq.cM(this.aKy);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aKy);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aKy);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aKy);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aKy));
            aKB.put(str, new SoftReference<>(aVar2));
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
        this.aKw = this.ahE;
        if (TextUtils.isEmpty(str)) {
            this.aKw = this.aKv;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            DE();
            this.BP = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aKG.Hf = "memory";
            this.aKG.isSuccess = true;
            this.aKG.Hg = 0L;
            invalidate();
            if (this.aKu != null) {
                this.aKu.s(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.fM().al(this.mType) && this.aCx) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hk()) {
            this.aKG.Hf = "memory";
            this.aKG.isSuccess = false;
            this.aKG.Hg = 0L;
            this.aKw = this.aKv;
            invalidate();
            if (this.aKu != null) {
                this.aKu.s(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aKI = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIz, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void DE() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIz);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.g<?> Z = k.Z(getContext());
        if (this.mPageId != null) {
            this.aKP = true;
        }
        if (Z != null) {
            this.listener.setTag(this.mPageId != null ? this.mPageId : Z.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.listener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aKP = false;
        DE();
        MessageManager.getInstance().unRegisterListener(this.listener);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DE();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        GX();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aKD = true;
        DD();
    }

    public void stopLoading() {
        this.aKD = false;
        removeCallbacks(this);
        this.aCk = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DD() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aKD) {
            this.aCk += this.aKA;
            if (this.aCk > 360.0f - this.aKA) {
                this.aCk = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aCk, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DD();
        }
    }

    private void GX() {
        if (this.mAutoChangeStyle) {
            this.BF.Cf = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.BF.Cf = false;
        }
        int i = this.aKy;
        int i2 = this.aKD ? this.aKx : this.aKw;
        if (i2 != this.aKy) {
            this.aKy = i2;
            this.BP = true;
        }
        int i3 = this.aKz;
        this.aKz = this.ahF;
        if (this.aKz > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aq.getDrawable(this.aKz));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aKz));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.ahE != i) {
            this.ahE = i;
            this.aKw = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aKv = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.ahF != i) {
            this.ahF = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aKP && this.mPageId != null) {
            this.listener.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.listener);
            this.aKP = true;
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
        super.setOnTouchListener(this.aKQ);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.d dVar) {
        super.setOnTouchListener(this.aKQ);
        this.aKE = dVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aKF = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aKF) {
            startLoading();
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, this.mType, this.aIz, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
        this.aCx = z;
    }

    public u getPerfLog() {
        return this.aKG;
    }

    public void vT() {
        if (!this.aKC) {
            this.aKC = true;
        } else if (this.aKG != null && this.aKG.aGo) {
            this.aKG.Fy();
        }
    }
}
