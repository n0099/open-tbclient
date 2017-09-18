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
import com.baidu.adp.base.e;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.l.l;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.b.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aNU;
    private static Method aOf;
    private static Method aOg;
    private static Method aOh;
    private static Method aOi;
    private float aEU;
    protected boolean aFh;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aLQ;
    protected a aNN;
    protected int aNO;
    protected int aNP;
    private final int aNQ;
    private int aNR;
    private int aNS;
    private float aNT;
    protected boolean aNV;
    private boolean aNW;
    private com.baidu.tieba.pb.a.c aNX;
    private boolean aNY;
    private b aNZ;
    protected l aOa;
    private int aOb;
    protected long aOc;
    int aOd;
    int aOe;
    private boolean aOj;
    private final com.baidu.tieba.pb.a.c aOk;
    protected int ajw;
    private int ajx;
    private CustomMessageListener anu;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected boolean rw;

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
        this.aNZ = bVar;
    }

    public void setEvent(a aVar) {
        this.aNN = aVar;
    }

    public int getLoadedWidth() {
        return this.aOd;
    }

    public int getLoadedHeight() {
        return this.aOe;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aNZ != null) {
            this.aNZ.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aNN = null;
        this.ajw = d.e.transparent;
        this.aNO = d.g.img_default_100;
        this.aNP = this.ajw;
        this.aNQ = d.g.img_loading;
        this.ajx = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFh = false;
        this.aOa = null;
        this.aOb = 3;
        this.aOc = 0L;
        this.aOd = 0;
        this.aOe = 0;
        this.aOj = false;
        this.aOk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNX != null) {
                    TbImageView.this.aNX.bf(view);
                    return TbImageView.this.aNX.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNY) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNX != null) {
                        TbImageView.this.aNX.bf(view);
                        return TbImageView.this.aNX.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fK().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLQ, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLQ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i);
                if (aVar == null) {
                    TbImageView.this.aNP = TbImageView.this.aNO;
                } else {
                    TbImageView.this.rw = aVar.isGif();
                }
                if (TbImageView.this.aNN != null) {
                    if (aVar != null) {
                        TbImageView.this.aOd = aVar.getWidth();
                        TbImageView.this.aOe = aVar.getHeight();
                    }
                    TbImageView.this.aNN.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gx != null) {
                        TbImageView.this.aOa.Gz = aVar.Gx.Gz;
                        TbImageView.this.aOa.isSuccess = aVar.Gx.GB;
                        TbImageView.this.aOa.GA = aVar.Gx.GA;
                    }
                } else {
                    TbImageView.this.aOa.Gz = "net";
                    TbImageView.this.aOa.isSuccess = false;
                    TbImageView.this.aOa.GA = System.currentTimeMillis() - TbImageView.this.aOc;
                }
                TbImageView.this.wy();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.aNN != null) {
                    TbImageView.this.aNN.onCancel();
                }
            }
        };
        this.anu = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fK().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HV();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOf, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOg, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOh, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOi, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HV() {
                if (TbImageView.aOf == null) {
                    Method unused = TbImageView.aOf = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOg == null) {
                    Method unused2 = TbImageView.aOg = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOh == null) {
                    Method unused3 = TbImageView.aOh = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOi == null) {
                    Method unused4 = TbImageView.aOi = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNN = null;
        this.ajw = d.e.transparent;
        this.aNO = d.g.img_default_100;
        this.aNP = this.ajw;
        this.aNQ = d.g.img_loading;
        this.ajx = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFh = false;
        this.aOa = null;
        this.aOb = 3;
        this.aOc = 0L;
        this.aOd = 0;
        this.aOe = 0;
        this.aOj = false;
        this.aOk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNX != null) {
                    TbImageView.this.aNX.bf(view);
                    return TbImageView.this.aNX.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNY) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNX != null) {
                        TbImageView.this.aNX.bf(view);
                        return TbImageView.this.aNX.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fK().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLQ, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLQ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i2);
                if (aVar == null) {
                    TbImageView.this.aNP = TbImageView.this.aNO;
                } else {
                    TbImageView.this.rw = aVar.isGif();
                }
                if (TbImageView.this.aNN != null) {
                    if (aVar != null) {
                        TbImageView.this.aOd = aVar.getWidth();
                        TbImageView.this.aOe = aVar.getHeight();
                    }
                    TbImageView.this.aNN.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gx != null) {
                        TbImageView.this.aOa.Gz = aVar.Gx.Gz;
                        TbImageView.this.aOa.isSuccess = aVar.Gx.GB;
                        TbImageView.this.aOa.GA = aVar.Gx.GA;
                    }
                } else {
                    TbImageView.this.aOa.Gz = "net";
                    TbImageView.this.aOa.isSuccess = false;
                    TbImageView.this.aOa.GA = System.currentTimeMillis() - TbImageView.this.aOc;
                }
                TbImageView.this.wy();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.aNN != null) {
                    TbImageView.this.aNN.onCancel();
                }
            }
        };
        this.anu = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fK().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HV();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOf, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOg, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOh, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOi, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HV() {
                if (TbImageView.aOf == null) {
                    Method unused = TbImageView.aOf = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOg == null) {
                    Method unused2 = TbImageView.aOg = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOh == null) {
                    Method unused3 = TbImageView.aOh = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOi == null) {
                    Method unused4 = TbImageView.aOi = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HQ();
        this.aNT = 30.0f;
        this.aOa = new l();
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

    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getBdImage() {
        com.baidu.adp.widget.a.a aVar;
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                aVar = null;
            } else {
                String str = (String) tag;
                com.baidu.adp.widget.a.a go = com.baidu.tbadk.imageManager.c.Ev().go(str);
                aVar = go == null ? com.baidu.tbadk.imageManager.c.Ev().gn(str) : go;
            }
        } else {
            aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fK().a(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            this.rw = aVar.isGif();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aNU == null) {
            aNU = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aNR);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aOb != TbadkCoreApplication.getInst().getSkinType()) {
            this.Bk = true;
            this.aOb = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aNU.containsKey(str) || (softReference = aNU.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kP()) {
            Bitmap bitmap = null;
            if (this.aNR > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = aj.cT(this.aNR);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aNR);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aNR);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aNR);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aNR));
            aNU.put(str, new SoftReference<>(aVar2));
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
        h W = i.W(getContext());
        if (W != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : W.getUniqueId();
            z2 = W.isScroll();
            bdUniqueId = uniqueId;
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        h W = i.W(getContext());
        if (W != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : W.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aNP = this.ajw;
        if (TextUtils.isEmpty(str)) {
            this.aNP = this.aNO;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            Eq();
            this.Bk = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aOa.Gz = "memory";
            this.aOa.isSuccess = true;
            this.aOa.GA = 0L;
            invalidate();
            if (this.aNN != null) {
                this.aNN.t(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bk = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fK().al(this.mType) && this.aFh) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hi()) {
            this.aOa.Gz = "memory";
            this.aOa.isSuccess = false;
            this.aOa.GA = 0L;
            this.aNP = this.aNO;
            invalidate();
            if (this.aNN != null) {
                this.aNN.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aOc = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, this.mType, this.aLQ, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void Eq() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, this.mType, this.aLQ);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> Y = i.Y(getContext());
        if (this.mPageId != null) {
            this.aOj = true;
        }
        if (Y != null) {
            this.anu.setTag(this.mPageId != null ? this.mPageId : Y.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.anu);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aOj = false;
        Eq();
        MessageManager.getInstance().unRegisterListener(this.anu);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Eq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Eq();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HQ();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aNW = true;
        Ep();
    }

    public void stopLoading() {
        this.aNW = false;
        removeCallbacks(this);
        this.aEU = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Ep() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNW) {
            this.aEU += this.aNT;
            if (this.aEU > 360.0f - this.aNT) {
                this.aEU = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aEU, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Ep();
        }
    }

    private void HQ() {
        if (this.mAutoChangeStyle) {
            this.Ba.BA = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.Ba.BA = false;
        }
        int i = this.aNR;
        int i2 = this.aNW ? this.aNQ : this.aNP;
        if (i2 != this.aNR) {
            this.aNR = i2;
            this.Bk = true;
        }
        int i3 = this.aNS;
        this.aNS = this.ajx;
        if (this.aNS > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aj.getDrawable(this.aNS));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aNS));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.ajw != i) {
            this.ajw = i;
            this.aNP = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aNO = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.ajx != i) {
            this.ajx = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aOj && this.mPageId != null) {
            this.anu.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.anu);
            this.aOj = true;
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
        super.setOnTouchListener(this.aOk);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aOk);
        this.aNX = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aNY = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aNY) {
            startLoading();
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, this.mType, this.aLQ, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
        this.aFh = z;
    }

    public l getPerfLog() {
        return this.aOa;
    }

    public void wy() {
        if (!this.aNV) {
            this.aNV = true;
        } else if (this.aOa != null && this.aOa.aJC) {
            this.aOa.Gr();
        }
    }
}
