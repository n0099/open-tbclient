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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static Method aGB;
    private static Method aGC;
    private static Method aGD;
    private static Method aGE;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aGs;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEx;
    int aGA;
    private a aGl;
    private int aGm;
    private int aGn;
    private final int aGo;
    private int aGp;
    private int aGq;
    private float aGr;
    protected boolean aGt;
    private boolean aGu;
    private boolean aGv;
    protected u aGw;
    private int aGx;
    private long aGy;
    int aGz;
    private int adE;
    private int adF;
    private CustomMessageListener agt;
    private BdUniqueId aid;
    private float axX;
    private boolean ayl;
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

        void u(String str, boolean z);
    }

    public void setEvent(a aVar) {
        this.aGl = aVar;
    }

    public int getLoadedWidth() {
        return this.aGz;
    }

    public int getLoadedHeight() {
        return this.aGA;
    }

    public TbImageView(Context context) {
        super(context);
        this.aGl = null;
        this.adE = t.d.transparent;
        this.aGm = t.f.img_default_100;
        this.aGn = this.adE;
        this.aGo = t.f.img_loading;
        this.adF = t.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ayl = false;
        this.aGw = null;
        this.aGx = 3;
        this.aGy = 0L;
        this.aGz = 0;
        this.aGA = 0;
        this.aEx = new d(this);
        this.agt = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGl = null;
        this.adE = t.d.transparent;
        this.aGm = t.f.img_default_100;
        this.aGn = this.adE;
        this.aGo = t.f.img_loading;
        this.adF = t.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ayl = false;
        this.aGw = null;
        this.aGx = 3;
        this.aGy = 0L;
        this.aGz = 0;
        this.aGA = 0;
        this.aEx = new d(this);
        this.agt = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HE();
        this.aGr = 30.0f;
        this.aGw = new u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.vf = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.vf = true;
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
            com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.Ek().fT(str);
            return fT == null ? com.baidu.tbadk.imageManager.c.Ek().fS(str) : fT;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aGs == null) {
            aGs = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aGp);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aGx != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.vf = true;
            this.aGx = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aGs.containsKey(str) || (softReference = aGs.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jW()) {
            Bitmap bitmap = null;
            if (this.aGp > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = av.cN(this.aGp);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aGp);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aGp);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aGp);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aGp));
            aGs.put(str, new SoftReference<>(aVar2));
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
        this.aGn = this.adE;
        if (TextUtils.isEmpty(str)) {
            this.aGn = this.aGm;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.aid;
        if (!z3) {
            Eh();
            this.vf = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aGw.Az = "memory";
            this.aGw.isSuccess = true;
            this.aGw.AA = 0L;
            invalidate();
            if (this.aGl != null) {
                this.aGl.u(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.aid = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.vf = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().al(this.mType) && this.ayl) {
            invalidate();
        } else if (z3 && !i.gm()) {
            this.aGw.Az = "memory";
            this.aGw.isSuccess = false;
            this.aGw.AA = 0L;
            this.aGn = this.aGm;
            invalidate();
            if (this.aGl != null) {
                this.aGl.u(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aGy = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEx, i2, i3, this.aid, new Object[0]);
        }
    }

    public void Eh() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEx);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> C = l.C(getContext());
        if (C != null) {
            this.agt.setTag(C.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.agt);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Eh();
        MessageManager.getInstance().unRegisterListener(this.agt);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Eh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Eh();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HE();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aGu = true;
        Eg();
    }

    public void stopLoading() {
        this.aGu = false;
        removeCallbacks(this);
        this.axX = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Eg() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aGu) {
            this.axX += this.aGr;
            if (this.axX > 360.0f - this.aGr) {
                this.axX = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.axX, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Eg();
        }
    }

    private void HE() {
        if (this.mAutoChangeStyle) {
            this.uV.vv = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.uV.vv = false;
        }
        int i = this.aGp;
        int i2 = this.aGu ? this.aGo : this.aGn;
        if (i2 != this.aGp) {
            this.aGp = i2;
            this.vf = true;
        }
        int i3 = this.aGq;
        this.aGq = this.adF;
        if (this.aGq > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(av.getDrawable(this.aGq));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aGq));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.adE != i) {
            this.adE = i;
            this.aGn = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aGm = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.adF != i) {
            this.adF = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aid = bdUniqueId;
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
        this.aGv = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aGv) {
            startLoading();
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, this.mType, this.aEx, this.mWidth, this.mHeight, this.aid, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.uV.vy != null) {
            return this.uV.vy.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.uV.vy != null) {
            return this.uV.vy.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.ayl = z;
    }

    public u getPerfLog() {
        return this.aGw;
    }

    public void vU() {
        if (!this.aGt) {
            this.aGt = true;
        } else if (this.aGw != null && this.aGw.aCi) {
            this.aGw.Gj();
        }
    }
}
