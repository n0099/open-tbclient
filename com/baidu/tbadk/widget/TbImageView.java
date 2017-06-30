package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.j.u;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.b.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aLQ;
    private static Method aMb;
    private static Method aMc;
    private static Method aMd;
    private static Method aMe;
    protected boolean aDB;
    private float aDo;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aJO;
    protected a aLJ;
    protected int aLK;
    protected int aLL;
    private final int aLM;
    private int aLN;
    private int aLO;
    private float aLP;
    protected boolean aLR;
    private boolean aLS;
    private com.baidu.tieba.pb.a.d aLT;
    private boolean aLU;
    private b aLV;
    protected u aLW;
    private int aLX;
    protected long aLY;
    int aLZ;
    int aMa;
    private boolean aMf;
    private final com.baidu.tieba.pb.a.d aMg;
    protected int aim;
    private int ain;
    private CustomMessageListener ame;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected boolean sa;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void t(String str, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void n(MotionEvent motionEvent);
    }

    public void setDispatchTouchListener(b bVar) {
        this.aLV = bVar;
    }

    public void setEvent(a aVar) {
        this.aLJ = aVar;
    }

    public int getLoadedWidth() {
        return this.aLZ;
    }

    public int getLoadedHeight() {
        return this.aMa;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aLV != null) {
            this.aLV.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aLJ = null;
        this.aim = w.e.transparent;
        this.aLK = w.g.img_default_100;
        this.aLL = this.aim;
        this.aLM = w.g.img_loading;
        this.ain = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aDB = false;
        this.aLW = null;
        this.aLX = 3;
        this.aLY = 0L;
        this.aLZ = 0;
        this.aMa = 0;
        this.aMf = false;
        this.aMg = new com.baidu.tieba.pb.a.d(new f(this));
        this.aJO = new g(this);
        this.ame = new h(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLJ = null;
        this.aim = w.e.transparent;
        this.aLK = w.g.img_default_100;
        this.aLL = this.aim;
        this.aLM = w.g.img_loading;
        this.ain = w.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aDB = false;
        this.aLW = null;
        this.aLX = 3;
        this.aLY = 0L;
        this.aLZ = 0;
        this.aMa = 0;
        this.aMf = false;
        this.aMg = new com.baidu.tieba.pb.a.d(new f(this));
        this.aJO = new g(this);
        this.ame = new h(this, CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE);
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Hu();
        this.aLP = 30.0f;
        this.aLW = new u();
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
                com.baidu.adp.widget.a.a ge = com.baidu.tbadk.imageManager.c.Eb().ge(str);
                aVar = ge == null ? com.baidu.tbadk.imageManager.c.Eb().gd(str) : ge;
            }
        } else {
            aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            this.sa = aVar.isGif();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aLQ == null) {
            aLQ = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aLN);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.m9getInst().getSkinType() == 1) ? String.valueOf(valueOf) + "_1" : valueOf;
        if (this.aLX != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.BP = true;
            this.aLX = TbadkCoreApplication.m9getInst().getSkinType();
        }
        if (!aLQ.containsKey(str) || (softReference = aLQ.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kQ()) {
            Bitmap bitmap = null;
            if (this.aLN > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        bitmap = as.cO(this.aLN);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aLN);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aLN);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aLN);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aLN));
            aLQ.put(str, new SoftReference<>(aVar2));
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
        this.aLL = this.aim;
        if (TextUtils.isEmpty(str)) {
            this.aLL = this.aLK;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            DY();
            this.BP = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aLW.He = "memory";
            this.aLW.isSuccess = true;
            this.aLW.Hf = 0L;
            invalidate();
            if (this.aLJ != null) {
                this.aLJ.t(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.fL().al(this.mType) && this.aDB) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hj()) {
            this.aLW.He = "memory";
            this.aLW.isSuccess = false;
            this.aLW.Hf = 0L;
            this.aLL = this.aLK;
            invalidate();
            if (this.aLJ != null) {
                this.aLJ.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aLY = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, this.aJO, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void DY() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, this.aJO);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.g<?> Z = k.Z(getContext());
        if (this.mPageId != null) {
            this.aMf = true;
        }
        if (Z != null) {
            this.ame.setTag(this.mPageId != null ? this.mPageId : Z.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.ame);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aMf = false;
        DY();
        MessageManager.getInstance().unRegisterListener(this.ame);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DY();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Hu();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aLS = true;
        DX();
    }

    public void stopLoading() {
        this.aLS = false;
        removeCallbacks(this);
        this.aDo = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DX() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aLS) {
            this.aDo += this.aLP;
            if (this.aDo > 360.0f - this.aLP) {
                this.aDo = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aDo, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DX();
        }
    }

    private void Hu() {
        if (this.mAutoChangeStyle) {
            this.BF.Cf = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        } else {
            this.BF.Cf = false;
        }
        int i = this.aLN;
        int i2 = this.aLS ? this.aLM : this.aLL;
        if (i2 != this.aLN) {
            this.aLN = i2;
            this.BP = true;
        }
        int i3 = this.aLO;
        this.aLO = this.ain;
        if (this.aLO > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(as.getDrawable(this.aLO));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aLO));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aim != i) {
            this.aim = i;
            this.aLL = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aLK = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.ain != i) {
            this.ain = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aMf && this.mPageId != null) {
            this.ame.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.ame);
            this.aMf = true;
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
        super.setOnTouchListener(this.aMg);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.d dVar) {
        super.setOnTouchListener(this.aMg);
        this.aLT = dVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aLU = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aLU) {
            startLoading();
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, this.mType, this.aJO, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
        this.aDB = z;
    }

    public u getPerfLog() {
        return this.aLW;
    }

    public void wk() {
        if (!this.aLR) {
            this.aLR = true;
        } else if (this.aLW != null && this.aLW.aHC) {
            this.aLW.FV();
        }
    }
}
