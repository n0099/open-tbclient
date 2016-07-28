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
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aDl;
    private static Method aDu;
    private static Method aDv;
    private static Method aDw;
    private static Method aDx;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBq;
    private a aDe;
    private int aDf;
    private int aDg;
    private final int aDh;
    private int aDi;
    private int aDj;
    private float aDk;
    protected boolean aDm;
    private boolean aDn;
    private boolean aDo;
    protected u aDp;
    private int aDq;
    private long aDr;
    int aDs;
    int aDt;
    private int aaU;
    private int aaV;
    private CustomMessageListener adE;
    private BdUniqueId afi;
    private float auQ;
    private boolean ave;
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
        this.aDe = aVar;
    }

    public int getLoadedWidth() {
        return this.aDs;
    }

    public int getLoadedHeight() {
        return this.aDt;
    }

    public TbImageView(Context context) {
        super(context);
        this.aDe = null;
        this.aaU = u.d.transparent;
        this.aDf = u.f.img_default_100;
        this.aDg = this.aaU;
        this.aDh = u.f.img_loading;
        this.aaV = u.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ave = false;
        this.aDp = null;
        this.aDq = 3;
        this.aDr = 0L;
        this.aDs = 0;
        this.aDt = 0;
        this.aBq = new d(this);
        this.adE = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDe = null;
        this.aaU = u.d.transparent;
        this.aDf = u.f.img_default_100;
        this.aDg = this.aaU;
        this.aDh = u.f.img_loading;
        this.aaV = u.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.ave = false;
        this.aDp = null;
        this.aDq = 3;
        this.aDr = 0L;
        this.aDs = 0;
        this.aDt = 0;
        this.aBq = new d(this);
        this.adE = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Gk();
        this.aDk = 30.0f;
        this.aDp = new com.baidu.tbadk.performanceLog.u();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.sP = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.sP = true;
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
            com.baidu.adp.widget.a.a fQ = com.baidu.tbadk.imageManager.c.CP().fQ(str);
            return fQ == null ? com.baidu.tbadk.imageManager.c.CP().fP(str) : fQ;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aDl == null) {
            aDl = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aDi);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m10getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aDq != TbadkCoreApplication.m10getInst().getSkinType()) {
            this.sP = true;
            this.aDq = TbadkCoreApplication.m10getInst().getSkinType();
        }
        if (!aDl.containsKey(str) || (softReference = aDl.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jb()) {
            Bitmap bitmap = null;
            if (this.aDi > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m10getInst().getSkinType() == 1) {
                        bitmap = av.cA(this.aDi);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aDi);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aDi);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aDi);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aDi));
            aDl.put(str, new SoftReference<>(aVar2));
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
        this.aDg = this.aaU;
        if (TextUtils.isEmpty(str)) {
            this.aDg = this.aDf;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.afi;
        if (!z3) {
            CM();
            this.sP = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aDp.ym = "memory";
            this.aDp.isSuccess = true;
            this.aDp.yn = 0L;
            invalidate();
            if (this.aDe != null) {
                this.aDe.t(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.afi = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.sP = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.dF().Y(this.mType) && this.ave) {
            invalidate();
        } else if (z3 && !i.fq()) {
            this.aDp.ym = "memory";
            this.aDp.isSuccess = false;
            this.aDp.yn = 0L;
            this.aDg = this.aDf;
            invalidate();
            if (this.aDe != null) {
                this.aDe.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aDr = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, this.aBq, i2, i3, this.afi, new Object[0]);
        }
    }

    public void CM() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, this.aBq);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> s = l.s(getContext());
        if (s != null) {
            this.adE.setTag(s.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.adE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CM();
        MessageManager.getInstance().unRegisterListener(this.adE);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CM();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Gk();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aDn = true;
        CL();
    }

    public void stopLoading() {
        this.aDn = false;
        removeCallbacks(this);
        this.auQ = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void CL() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aDn) {
            this.auQ += this.aDk;
            if (this.auQ > 360.0f - this.aDk) {
                this.auQ = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.auQ, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            CL();
        }
    }

    private void Gk() {
        if (this.mAutoChangeStyle) {
            this.sF.tg = TbadkCoreApplication.m10getInst().getSkinType() == 1;
        } else {
            this.sF.tg = false;
        }
        int i = this.aDi;
        int i2 = this.aDn ? this.aDh : this.aDg;
        if (i2 != this.aDi) {
            this.aDi = i2;
            this.sP = true;
        }
        int i3 = this.aDj;
        this.aDj = this.aaV;
        if (this.aDj > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(av.getDrawable(this.aDj));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aDj));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aaU != i) {
            this.aaU = i;
            this.aDg = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aDf = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aaV != i) {
            this.aaV = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.afi = bdUniqueId;
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
        this.aDo = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aDo) {
            startLoading();
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, this.mType, this.aBq, this.mWidth, this.mHeight, this.afi, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.sF.tj != null) {
            return this.sF.tj.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.sF.tj != null) {
            return this.sF.tj.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.ave = z;
    }

    public com.baidu.tbadk.performanceLog.u getPerfLog() {
        return this.aDp;
    }

    public void uS() {
        if (!this.aDm) {
            this.aDm = true;
        } else if (this.aDp != null && this.aDp.azb) {
            this.aDp.EP();
        }
    }
}
