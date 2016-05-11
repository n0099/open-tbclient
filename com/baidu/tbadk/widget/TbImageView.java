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
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aBV;
    private static Method aCe;
    private static Method aCf;
    private static Method aCg;
    private static Method aCh;
    private int ZU;
    private int ZV;
    private a aBO;
    private int aBP;
    private int aBQ;
    private final int aBR;
    private int aBS;
    private int aBT;
    private float aBU;
    protected boolean aBW;
    private boolean aBX;
    private boolean aBY;
    protected u aBZ;
    private int aCa;
    private long aCb;
    int aCc;
    int aCd;
    private CustomMessageListener acy;
    private BdUniqueId atA;
    private float atl;
    private boolean atz;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> azI;
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
        this.aBO = aVar;
    }

    public int getLoadedWidth() {
        return this.aCc;
    }

    public int getLoadedHeight() {
        return this.aCd;
    }

    public TbImageView(Context context) {
        super(context);
        this.aBO = null;
        this.ZU = t.d.transparent;
        this.aBP = t.f.img_default_100;
        this.aBQ = this.ZU;
        this.aBR = t.f.img_loading;
        this.ZV = t.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.atz = false;
        this.aBZ = null;
        this.aCa = 3;
        this.aCb = 0L;
        this.aCc = 0;
        this.aCd = 0;
        this.azI = new d(this);
        this.acy = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBO = null;
        this.ZU = t.d.transparent;
        this.aBP = t.f.img_default_100;
        this.aBQ = this.ZU;
        this.aBR = t.f.img_loading;
        this.ZV = t.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.atz = false;
        this.aBZ = null;
        this.aCa = 3;
        this.aCb = 0L;
        this.aCc = 0;
        this.aCd = 0;
        this.azI = new d(this);
        this.acy = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Ge();
        this.aBU = 30.0f;
        this.aBZ = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.sk = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.sk = true;
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
            com.baidu.adp.widget.a.a fM = com.baidu.tbadk.imageManager.c.CH().fM(str);
            return fM == null ? com.baidu.tbadk.imageManager.c.CH().fL(str) : fM;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aBV == null) {
            aBV = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aBS);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m11getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aCa != TbadkCoreApplication.m11getInst().getSkinType()) {
            this.sk = true;
            this.aCa = TbadkCoreApplication.m11getInst().getSkinType();
        }
        if (!aBV.containsKey(str) || (softReference = aBV.get(str)) == null || (aVar = softReference.get()) == null || !aVar.iZ()) {
            Bitmap bitmap = null;
            if (this.aBS > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
                        bitmap = at.cA(this.aBS);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aBS);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aBS);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aBS);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aBS));
            aBV.put(str, new SoftReference<>(aVar2));
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
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z2 = q.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aBQ = this.ZU;
        if (TextUtils.isEmpty(str)) {
            this.aBQ = this.aBP;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.atA;
        if (!z3) {
            CE();
            this.sk = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aBZ.xJ = "memory";
            this.aBZ.isSuccess = true;
            this.aBZ.xK = 0L;
            invalidate();
            if (this.aBO != null) {
                this.aBO.t(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.atA = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.sk = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.dF().V(this.mType) && this.atz) {
            invalidate();
        } else if (z3 && !i.fq()) {
            this.aBZ.xJ = "memory";
            this.aBZ.isSuccess = false;
            this.aBZ.xK = 0L;
            this.aBQ = this.aBP;
            invalidate();
            if (this.aBO != null) {
                this.aBO.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aCb = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, this.azI, i2, i3, this.atA, new Object[0]);
        }
    }

    public void CE() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, this.azI);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> s = l.s(getContext());
        if (s != null) {
            this.acy.setTag(s.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.acy);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CE();
        MessageManager.getInstance().unRegisterListener(this.acy);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CE();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Ge();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aBX = true;
        CD();
    }

    public void stopLoading() {
        this.aBX = false;
        removeCallbacks(this);
        this.atl = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void CD() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aBX) {
            this.atl += this.aBU;
            if (this.atl > 360.0f - this.aBU) {
                this.atl = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.atl, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            CD();
        }
    }

    private void Ge() {
        if (this.mAutoChangeStyle) {
            this.sa.sC = TbadkCoreApplication.m11getInst().getSkinType() == 1;
        } else {
            this.sa.sC = false;
        }
        int i = this.aBS;
        int i2 = this.aBX ? this.aBR : this.aBQ;
        if (i2 != this.aBS) {
            this.aBS = i2;
            this.sk = true;
        }
        int i3 = this.aBT;
        this.aBT = this.ZV;
        if (this.aBT > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(at.getDrawable(this.aBT));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aBT));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.ZU != i) {
            this.ZU = i;
            this.aBQ = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aBP = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.ZV != i) {
            this.ZV = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.atA = bdUniqueId;
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
        this.aBY = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aBY) {
            startLoading();
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, this.azI, this.mWidth, this.mHeight, this.atA, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.sa.sF != null) {
            return this.sa.sF.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.sa.sF != null) {
            return this.sa.sF.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.atz = z;
    }

    public u getPerfLog() {
        return this.aBZ;
    }

    public void uR() {
        if (!this.aBW) {
            this.aBW = true;
        } else if (this.aBZ != null && this.aBZ.axv) {
            this.aBZ.EG();
        }
    }
}
