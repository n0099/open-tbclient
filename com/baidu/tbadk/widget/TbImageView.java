package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.performanceLog.z;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.newwidget.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> arU;
    private int Xa;
    private int Xb;
    private float akI;
    private boolean akT;
    private BdUniqueId akU;
    private n arP;
    private final int arQ;
    private int arR;
    private int arS;
    private float arT;
    protected boolean arV;
    private boolean arW;
    private boolean arX;
    protected z arY;
    private long arZ;
    int asa;
    int asb;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> asc;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    public void setEvent(n nVar) {
        this.arP = nVar;
    }

    public int getLoadedWidth() {
        return this.asa;
    }

    public int getLoadedHeight() {
        return this.asb;
    }

    public TbImageView(Context context) {
        super(context);
        this.arP = null;
        this.Xa = u.img_default_100;
        this.arQ = u.img_loading;
        this.Xb = s.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.akT = false;
        this.arY = null;
        this.arZ = 0L;
        this.asa = 0;
        this.asb = 0;
        this.asc = new m(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arP = null;
        this.Xa = u.img_default_100;
        this.arQ = u.img_loading;
        this.Xb = s.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.akT = false;
        this.arY = null;
        this.arZ = 0L;
        this.asa = 0;
        this.asb = 0;
        this.asc = new m(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Dz();
        this.arT = 30.0f;
        this.arY = new z();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.BN = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.BN = true;
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
            com.baidu.adp.widget.a.a eu = com.baidu.tbadk.imageManager.e.zy().eu(str);
            return eu == null ? com.baidu.tbadk.imageManager.e.zy().et(str) : eu;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (arU == null) {
            arU = new HashMap<>();
        }
        String valueOf = String.valueOf(this.arR);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!arU.containsKey(str) || (softReference = arU.get(str)) == null || (aVar = softReference.get()) == null || !aVar.mA()) {
            Bitmap bitmap = null;
            if (this.arR > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = ba.cg(this.arR);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.bO(this.arR);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.bO(this.arR);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.bO(this.arR);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.arR));
            arU.put(str, new SoftReference<>(aVar2));
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
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z2 = B.isScroll();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        BdLog.i("startLoad:url-" + str);
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.akU)) {
            zw();
            this.BN = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.arY.Gy = "memory";
            this.arY.isSuccess = true;
            this.arY.Gz = 0L;
            invalidate();
            if (this.arP != null) {
                this.arP.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.akU = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.BN = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.hB().X(this.mType) && this.akT) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.arZ = System.currentTimeMillis();
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, this.asc, i2, i3, this.akU, new Object[0]);
        }
    }

    public void zw() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, this.asc);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zw();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        zw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            zw();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Dz();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.arW = true;
        zv();
    }

    public void stopLoading() {
        this.arW = false;
        removeCallbacks(this);
        this.akI = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void zv() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.arW) {
            this.akI += this.arT;
            if (this.akI > 360.0f - this.arT) {
                this.akI = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.akI, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            zv();
        }
    }

    private void Dz() {
        if (this.mAutoChangeStyle) {
            this.BA.Cd = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.BA.Cd = false;
        }
        int i = this.arR;
        int i2 = this.arW ? this.arQ : this.Xa;
        if (i2 != this.arR) {
            this.arR = i2;
            this.BN = true;
        }
        int i3 = this.arS;
        this.arS = this.Xb;
        if (this.arS > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ba.getDrawable(this.arS));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.arS));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.Xa != i) {
            this.Xa = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.Xb != i) {
            this.Xb = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.akU = bdUniqueId;
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
        this.arX = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.arX) {
            startLoading();
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, this.asc, this.mWidth, this.mHeight, this.akU, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.BA.Cg != null) {
            return this.BA.Cg.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.BA.Cg != null) {
            return this.BA.Cg.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.akT = z;
    }

    public z getPerfLog() {
        return this.arY;
    }

    public void tK() {
        if (!this.arV) {
            this.arV = true;
        } else if (this.arY != null && this.arY.apu) {
            this.arY.CJ();
        }
    }
}
