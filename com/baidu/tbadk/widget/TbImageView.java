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
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aDz;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBQ;
    protected boolean aDA;
    private boolean aDB;
    private boolean aDC;
    protected s aDD;
    private int aDE;
    private long aDF;
    int aDG;
    int aDH;
    private a aDu;
    private final int aDv;
    private int aDw;
    private int aDx;
    private float aDy;
    private int aeA;
    private int aez;
    private CustomMessageListener agu;
    private float avM;
    private boolean awa;
    private BdUniqueId awb;
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
        this.aDu = aVar;
    }

    public int getLoadedWidth() {
        return this.aDG;
    }

    public int getLoadedHeight() {
        return this.aDH;
    }

    public TbImageView(Context context) {
        super(context);
        this.aDu = null;
        this.aez = n.f.img_default_100;
        this.aDv = n.f.img_loading;
        this.aeA = n.d.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.awa = false;
        this.aDD = null;
        this.aDE = 3;
        this.aDF = 0L;
        this.aDG = 0;
        this.aDH = 0;
        this.aBQ = new d(this);
        this.agu = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDu = null;
        this.aez = n.f.img_default_100;
        this.aDv = n.f.img_loading;
        this.aeA = n.d.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.awa = false;
        this.aDD = null;
        this.aDE = 3;
        this.aDF = 0L;
        this.aDG = 0;
        this.aDH = 0;
        this.aBQ = new d(this);
        this.agu = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Fy();
        this.aDy = 30.0f;
        this.aDD = new s();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Bu = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Bu = true;
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
            com.baidu.adp.widget.a.a fJ = com.baidu.tbadk.imageManager.c.CM().fJ(str);
            return fJ == null ? com.baidu.tbadk.imageManager.c.CM().fI(str) : fJ;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aDz == null) {
            aDz = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aDw);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aDE != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.Bu = true;
            this.aDE = TbadkCoreApplication.m411getInst().getSkinType();
        }
        if (!aDz.containsKey(str) || (softReference = aDz.get(str)) == null || (aVar = softReference.get()) == null || !aVar.mF()) {
            Bitmap bitmap = null;
            if (this.aDw > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = as.cx(this.aDw);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.cg(this.aDw);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.cg(this.aDw);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.cg(this.aDw);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aDw));
            aDz.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.awb)) {
            CJ();
            this.Bu = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aDD.GZ = "memory";
            this.aDD.isSuccess = true;
            this.aDD.Ha = 0L;
            invalidate();
            if (this.aDu != null) {
                this.aDu.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.awb = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bu = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hd().X(this.mType) && this.awa) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aDF = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, this.aBQ, i2, i3, this.awb, new Object[0]);
        }
    }

    public void CJ() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, this.aBQ);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.agu.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.agu);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CJ();
        MessageManager.getInstance().unRegisterListener(this.agu);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CJ();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Fy();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aDB = true;
        CI();
    }

    public void stopLoading() {
        this.aDB = false;
        removeCallbacks(this);
        this.avM = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void CI() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aDB) {
            this.avM += this.aDy;
            if (this.avM > 360.0f - this.aDy) {
                this.avM = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.avM, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            CI();
        }
    }

    private void Fy() {
        if (this.mAutoChangeStyle) {
            this.Bk.BK = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Bk.BK = false;
        }
        int i = this.aDw;
        int i2 = this.aDB ? this.aDv : this.aez;
        if (i2 != this.aDw) {
            this.aDw = i2;
            this.Bu = true;
        }
        int i3 = this.aDx;
        this.aDx = this.aeA;
        if (this.aDx > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(as.getDrawable(this.aDx));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aDx));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aez != i) {
            this.aez = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.aeA != i) {
            this.aeA = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.awb = bdUniqueId;
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
        this.aDC = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aDC) {
            startLoading();
            com.baidu.adp.lib.g.c.hd().a(this.mUrl, this.mType, this.aBQ, this.mWidth, this.mHeight, this.awb, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Bk.BN != null) {
            return this.Bk.BN.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Bk.BN != null) {
            return this.Bk.BN.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.awa = z;
    }

    public s getPerfLog() {
        return this.aDD;
    }

    public void vI() {
        if (!this.aDA) {
            this.aDA = true;
        } else if (this.aDD != null && this.aDD.azO) {
            this.aDD.EA();
        }
    }
}
