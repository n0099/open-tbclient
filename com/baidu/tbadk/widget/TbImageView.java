package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> abb;
    private int GV;
    private int GW;
    private boolean TK;
    private BdUniqueId TL;
    private float Tz;
    private p aaW;
    private final int aaX;
    private int aaY;
    private int aaZ;
    private float aba;
    protected boolean abc;
    private boolean abd;
    private boolean abe;
    protected com.baidu.tbadk.performanceLog.o abf;
    private long abg;
    int abh;
    int abi;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> abj;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    public void setEvent(p pVar) {
        this.aaW = pVar;
    }

    public int getLoadedWidth() {
        return this.abh;
    }

    public int getLoadedHeight() {
        return this.abi;
    }

    public TbImageView(Context context) {
        super(context);
        this.aaW = null;
        this.GV = u.img_default_100;
        this.aaX = u.img_loading;
        this.GW = s.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.TK = true;
        this.abf = null;
        this.abg = 0L;
        this.abh = 0;
        this.abi = 0;
        this.abj = new o(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaW = null;
        this.GV = u.img_default_100;
        this.aaX = u.img_loading;
        this.GW = s.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.TK = true;
        this.abf = null;
        this.abg = 0L;
        this.abh = 0;
        this.abi = 0;
        this.abj = new o(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 11) {
            CompatibleUtile.getInstance().closeViewGpu(this);
            try {
                Method method = getClass().getMethod("setLayerType", Integer.TYPE, Paint.class);
                if (method != null) {
                    method.invoke(this, 1, null);
                }
            } catch (Exception e) {
            }
        }
        vy();
        this.aba = 30.0f;
        this.abf = new com.baidu.tbadk.performanceLog.o();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.ra = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.ra = true;
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
            com.baidu.adp.widget.a.a dt = com.baidu.tbadk.imageManager.e.si().dt(str);
            return dt == null ? com.baidu.tbadk.imageManager.e.si().ds(str) : dt;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (abb == null) {
            abb = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aaY);
        String str = (this.mAutoChangeStyle && TbadkApplication.m251getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!abb.containsKey(str) || (softReference = abb.get(str)) == null || (aVar = softReference.get()) == null || !aVar.hm()) {
            Bitmap bitmap = null;
            if (this.aaY > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkApplication.m251getInst().getSkinType() == 1) {
                        bitmap = aw.bA(this.aaY);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.d.bl(this.aaY);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.d.bl(this.aaY);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.d.bl(this.aaY);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aaY));
            abb.put(str, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public void c(String str, int i, boolean z) {
        a(str, i, 0, 0, z);
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        Context context = getContext();
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        if (context != null && (context instanceof com.baidu.adp.base.i)) {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            bdUniqueId = iVar.getUniqueId();
            z2 = iVar.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        BdLog.i("startLoad:url-" + str);
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.TL)) {
            rZ();
            this.ra = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.abf.tl = "memory";
            this.abf.isSuccess = true;
            this.abf.tm = 0L;
            invalidate();
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.TL = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.ra = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.ef().J(this.mType) && this.TK) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.abg = System.currentTimeMillis();
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, this.mType, this.abj, i2, i3, this.TL, new Object[0]);
        }
    }

    public void rZ() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, this.mType, this.abj);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rZ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        rZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            rZ();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        vy();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.abd = true;
        rY();
    }

    public void stopLoading() {
        this.abd = false;
        removeCallbacks(this);
        this.Tz = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void rY() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.abd) {
            this.Tz += this.aba;
            if (this.Tz > 360.0f - this.aba) {
                this.Tz = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.Tz, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            rY();
        }
    }

    private void vy() {
        if (this.mAutoChangeStyle) {
            this.qN.rr = TbadkApplication.m251getInst().getSkinType() == 1;
        } else {
            this.qN.rr = false;
        }
        int i = this.aaY;
        int i2 = this.abd ? this.aaX : this.GV;
        if (i2 != this.aaY) {
            this.aaY = i2;
            this.ra = true;
        }
        int i3 = this.aaZ;
        this.aaZ = this.GW;
        if (this.aaZ > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aw.getDrawable(this.aaZ));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aaZ));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.GV != i) {
            this.GV = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.GW != i) {
            this.GW = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.TL = bdUniqueId;
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
        this.abe = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.abe) {
            startLoading();
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, this.mType, this.abj, this.mWidth, this.mHeight, this.TL, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.qN.ru != null) {
            return this.qN.ru.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.qN.ru != null) {
            return this.qN.ru.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.TK = z;
    }

    public com.baidu.tbadk.performanceLog.o getPerfLog() {
        return this.abf;
    }

    public void nt() {
        if (!this.abc) {
            this.abc = true;
        } else if (this.abf != null && this.abf.YY) {
            this.abf.uI();
        }
    }
}
