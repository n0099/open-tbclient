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
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> arM;
    private int WY;
    private int WZ;
    private float akA;
    private boolean akL;
    private BdUniqueId akM;
    private n arH;
    private final int arI;
    private int arJ;
    private int arK;
    private float arL;
    protected boolean arN;
    private boolean arO;
    private boolean arP;
    protected z arQ;
    private long arR;
    int arS;
    int arT;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> arU;
    private boolean mAutoChangeStyle;
    private int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    private int mType;
    private String mUrl;
    private int mWidth;

    public void setEvent(n nVar) {
        this.arH = nVar;
    }

    public int getLoadedWidth() {
        return this.arS;
    }

    public int getLoadedHeight() {
        return this.arT;
    }

    public TbImageView(Context context) {
        super(context);
        this.arH = null;
        this.WY = u.img_default_100;
        this.arI = u.img_loading;
        this.WZ = s.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.akL = false;
        this.arQ = null;
        this.arR = 0L;
        this.arS = 0;
        this.arT = 0;
        this.arU = new m(this);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arH = null;
        this.WY = u.img_default_100;
        this.arI = u.img_loading;
        this.WZ = s.cp_bg_line_c;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.akL = false;
        this.arQ = null;
        this.arR = 0L;
        this.arS = 0;
        this.arT = 0;
        this.arU = new m(this);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Dt();
        this.arL = 30.0f;
        this.arQ = new z();
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
            com.baidu.adp.widget.a.a er = com.baidu.tbadk.imageManager.e.zs().er(str);
            return er == null ? com.baidu.tbadk.imageManager.e.zs().eq(str) : er;
        }
        return (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (arM == null) {
            arM = new HashMap<>();
        }
        String valueOf = String.valueOf(this.arJ);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m411getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (!arM.containsKey(str) || (softReference = arM.get(str)) == null || (aVar = softReference.get()) == null || !aVar.mA()) {
            Bitmap bitmap = null;
            if (this.arJ > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                        bitmap = ba.cg(this.arJ);
                        if (bitmap == null) {
                            bitmap = com.baidu.tbadk.core.util.c.bO(this.arJ);
                        }
                    } else {
                        bitmap = com.baidu.tbadk.core.util.c.bO(this.arJ);
                    }
                } else {
                    bitmap = com.baidu.tbadk.core.util.c.bO(this.arJ);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.arJ));
            arM.put(str, new SoftReference<>(aVar2));
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
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.akM)) {
            zq();
            this.BN = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.arQ.Gw = "memory";
            this.arQ.isSuccess = true;
            this.arQ.Gx = 0L;
            invalidate();
            if (this.arH != null) {
                this.arH.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.akM = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.BN = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.d.hB().X(this.mType) && this.akL) {
            invalidate();
        } else {
            if (z) {
                startLoading();
            }
            this.arR = System.currentTimeMillis();
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, this.arU, i2, i3, this.akM, new Object[0]);
        }
    }

    public void zq() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, this.arU);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zq();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        zq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            zq();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Dt();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.arO = true;
        zp();
    }

    public void stopLoading() {
        this.arO = false;
        removeCallbacks(this);
        this.akA = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void zp() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.arO) {
            this.akA += this.arL;
            if (this.akA > 360.0f - this.arL) {
                this.akA = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.akA, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            zp();
        }
    }

    private void Dt() {
        if (this.mAutoChangeStyle) {
            this.BA.Cd = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        } else {
            this.BA.Cd = false;
        }
        int i = this.arJ;
        int i2 = this.arO ? this.arI : this.WY;
        if (i2 != this.arJ) {
            this.arJ = i2;
            this.BN = true;
        }
        int i3 = this.arK;
        this.arK = this.WZ;
        if (this.arK > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ba.getDrawable(this.arK));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.arK));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.WY != i) {
            this.WY = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.WZ != i) {
            this.WZ = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.akM = bdUniqueId;
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
        this.arP = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.arP) {
            startLoading();
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, this.mType, this.arU, this.mWidth, this.mHeight, this.akM, new Object[0]);
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
        this.akL = z;
    }

    public z getPerfLog() {
        return this.arQ;
    }

    public void tK() {
        if (!this.arN) {
            this.arN = true;
        } else if (this.arQ != null && this.arQ.apl) {
            this.arQ.CD();
        }
    }
}
