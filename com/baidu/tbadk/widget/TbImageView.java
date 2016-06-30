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
    private static Method aCE;
    private static Method aCF;
    private static Method aCG;
    private static Method aCH;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aCv;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAA;
    private int aCA;
    private long aCB;
    int aCC;
    int aCD;
    private a aCo;
    private int aCp;
    private int aCq;
    private final int aCr;
    private int aCs;
    private int aCt;
    private float aCu;
    protected boolean aCw;
    private boolean aCx;
    private boolean aCy;
    protected u aCz;
    private int aal;
    private int aam;
    private CustomMessageListener acT;
    private BdUniqueId aeu;
    private float aub;
    private boolean aup;
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
        this.aCo = aVar;
    }

    public int getLoadedWidth() {
        return this.aCC;
    }

    public int getLoadedHeight() {
        return this.aCD;
    }

    public TbImageView(Context context) {
        super(context);
        this.aCo = null;
        this.aal = u.d.transparent;
        this.aCp = u.f.img_default_100;
        this.aCq = this.aal;
        this.aCr = u.f.img_loading;
        this.aam = u.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aup = false;
        this.aCz = null;
        this.aCA = 3;
        this.aCB = 0L;
        this.aCC = 0;
        this.aCD = 0;
        this.aAA = new d(this);
        this.acT = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCo = null;
        this.aal = u.d.transparent;
        this.aCp = u.f.img_default_100;
        this.aCq = this.aal;
        this.aCr = u.f.img_loading;
        this.aam = u.d.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aup = false;
        this.aCz = null;
        this.aCA = 3;
        this.aCB = 0L;
        this.aCC = 0;
        this.aCD = 0;
        this.aAA = new d(this);
        this.acT = new e(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Gh();
        this.aCu = 30.0f;
        this.aCz = new com.baidu.tbadk.performanceLog.u();
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
            com.baidu.adp.widget.a.a fS = com.baidu.tbadk.imageManager.c.CQ().fS(str);
            return fS == null ? com.baidu.tbadk.imageManager.c.CQ().fR(str) : fS;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dG().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aCv == null) {
            aCv = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aCs);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aCA != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.sk = true;
            this.aCA = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aCv.containsKey(str) || (softReference = aCv.get(str)) == null || (aVar = softReference.get()) == null || !aVar.jc()) {
            Bitmap bitmap = null;
            if (this.aCs > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = av.cA(this.aCs);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aCs);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aCs);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aCs);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aCs));
            aCv.put(str, new SoftReference<>(aVar2));
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
        this.aCq = this.aal;
        if (TextUtils.isEmpty(str)) {
            this.aCq = this.aCp;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.aeu;
        if (!z3) {
            CN();
            this.sk = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aCz.xL = "memory";
            this.aCz.isSuccess = true;
            this.aCz.xM = 0L;
            invalidate();
            if (this.aCo != null) {
                this.aCo.t(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.aeu = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.sk = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.dG().V(this.mType) && this.aup) {
            invalidate();
        } else if (z3 && !i.fr()) {
            this.aCz.xL = "memory";
            this.aCz.isSuccess = false;
            this.aCz.xM = 0L;
            this.aCq = this.aCp;
            invalidate();
            if (this.aCo != null) {
                this.aCo.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aCB = System.currentTimeMillis();
            com.baidu.adp.lib.g.c.dG().a(this.mUrl, this.mType, this.aAA, i2, i3, this.aeu, new Object[0]);
        }
    }

    public void CN() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.dG().a(this.mUrl, this.mType, this.aAA);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h<?> s = l.s(getContext());
        if (s != null) {
            this.acT.setTag(s.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.acT);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CN();
        MessageManager.getInstance().unRegisterListener(this.acT);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CN();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Gh();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aCx = true;
        CM();
    }

    public void stopLoading() {
        this.aCx = false;
        removeCallbacks(this);
        this.aub = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void CM() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aCx) {
            this.aub += this.aCu;
            if (this.aub > 360.0f - this.aCu) {
                this.aub = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aub, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            CM();
        }
    }

    private void Gh() {
        if (this.mAutoChangeStyle) {
            this.sa.sD = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.sa.sD = false;
        }
        int i = this.aCs;
        int i2 = this.aCx ? this.aCr : this.aCq;
        if (i2 != this.aCs) {
            this.aCs = i2;
            this.sk = true;
        }
        int i3 = this.aCt;
        this.aCt = this.aam;
        if (this.aCt > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(av.getDrawable(this.aCt));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aCt));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aal != i) {
            this.aal = i;
            this.aCq = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aCp = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aam != i) {
            this.aam = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aeu = bdUniqueId;
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
        this.aCy = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aCy) {
            startLoading();
            com.baidu.adp.lib.g.c.dG().a(this.mUrl, this.mType, this.aAA, this.mWidth, this.mHeight, this.aeu, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.sa.sG != null) {
            return this.sa.sG.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.sa.sG != null) {
            return this.sa.sG.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aup = z;
    }

    public com.baidu.tbadk.performanceLog.u getPerfLog() {
        return this.aCz;
    }

    public void uS() {
        if (!this.aCw) {
            this.aCw = true;
        } else if (this.aCz != null && this.aCz.ayl) {
            this.aCz.EQ();
        }
    }
}
