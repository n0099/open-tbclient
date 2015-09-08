package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.k;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tieba.i;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aCq;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aAE;
    private a aCl;
    private final int aCm;
    private int aCn;
    private int aCo;
    private float aCp;
    protected boolean aCr;
    private boolean aCs;
    private boolean aCt;
    protected s aCu;
    private long aCv;
    int aCw;
    int aCx;
    private int acS;
    private int acT;
    private float auX;
    private boolean avi;
    private BdUniqueId avj;
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
        this.aCl = aVar;
    }

    public int getLoadedWidth() {
        return this.aCw;
    }

    public int getLoadedHeight() {
        return this.aCx;
    }

    public TbImageView(Context context) {
        super(context);
        this.aCl = null;
        this.acS = i.e.img_default_100;
        this.aCm = i.e.img_loading;
        this.acT = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.avi = false;
        this.aCu = null;
        this.aCv = 0L;
        this.aCw = 0;
        this.aCx = 0;
        this.aAE = new h(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCl = null;
        this.acS = i.e.img_default_100;
        this.aCm = i.e.img_loading;
        this.acT = i.c.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.avi = false;
        this.aCu = null;
        this.aCv = 0L;
        this.aCw = 0;
        this.aCx = 0;
        this.aAE = new h(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Fe();
        this.aCp = 30.0f;
        this.aCu = new s();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Bk = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Bk = true;
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
            com.baidu.adp.widget.a.a fj = com.baidu.tbadk.imageManager.c.Cs().fj(str);
            return fj == null ? com.baidu.tbadk.imageManager.c.Cs().fi(str) : fj;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.gZ().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aCq == null) {
            aCq = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aCn);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!aCq.containsKey(str) || (softReference = aCq.get(str)) == null || (aVar = softReference.get()) == null || !aVar.na()) {
            Bitmap bitmap = null;
            if (this.aCn > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = al.cu(this.aCn);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.cd(this.aCn);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.cd(this.aCn);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.cd(this.aCn);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aCn));
            aCq.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.avj)) {
            Cp();
            this.Bk = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aCu.Gp = "memory";
            this.aCu.isSuccess = true;
            this.aCu.Gq = 0L;
            invalidate();
            if (this.aCl != null) {
                this.aCl.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.avj = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bk = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.gZ().W(this.mType) && this.avi) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.aCv = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.gZ().a(this.mUrl, this.mType, this.aAE, i2, i3, this.avj, new Object[0]);
        }
    }

    public void Cp() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.gZ().a(this.mUrl, this.mType, this.aAE);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Cp();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Cp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Cp();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Fe();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aCs = true;
        Co();
    }

    public void stopLoading() {
        this.aCs = false;
        removeCallbacks(this);
        this.auX = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Co() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aCs) {
            this.auX += this.aCp;
            if (this.auX > 360.0f - this.aCp) {
                this.auX = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.auX, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Co();
        }
    }

    private void Fe() {
        if (this.mAutoChangeStyle) {
            this.Ba.BA = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.Ba.BA = false;
        }
        int i = this.aCn;
        int i2 = this.aCs ? this.aCm : this.acS;
        if (i2 != this.aCn) {
            this.aCn = i2;
            this.Bk = true;
        }
        int i3 = this.aCo;
        this.aCo = this.acT;
        if (this.aCo > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(al.getDrawable(this.aCo));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aCo));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.acS != i) {
            this.acS = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.acT != i) {
            this.acT = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.avj = bdUniqueId;
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
        this.aCt = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aCt) {
            startLoading();
            com.baidu.adp.lib.f.c.gZ().a(this.mUrl, this.mType, this.aAE, this.mWidth, this.mHeight, this.avj, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Ba.BD != null) {
            return this.Ba.BD.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Ba.BD != null) {
            return this.Ba.BD.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.avi = z;
    }

    public s getPerfLog() {
        return this.aCu;
    }

    public void vz() {
        if (!this.aCr) {
            this.aCr = true;
        } else if (this.aCu != null && this.aCu.ayR) {
            this.aCu.Eh();
        }
    }
}
