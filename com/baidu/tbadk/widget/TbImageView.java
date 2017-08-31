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
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aNX;
    private static Method aOi;
    private static Method aOj;
    private static Method aOk;
    private static Method aOl;
    private float aEX;
    protected boolean aFk;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aLT;
    protected a aNQ;
    protected int aNR;
    protected int aNS;
    private final int aNT;
    private int aNU;
    private int aNV;
    private float aNW;
    protected boolean aNY;
    private boolean aNZ;
    private com.baidu.tieba.pb.a.c aOa;
    private boolean aOb;
    private b aOc;
    protected l aOd;
    private int aOe;
    protected long aOf;
    int aOg;
    int aOh;
    private boolean aOm;
    private final com.baidu.tieba.pb.a.c aOn;
    protected int ajx;
    private int ajy;
    private CustomMessageListener anw;
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
        this.aOc = bVar;
    }

    public void setEvent(a aVar) {
        this.aNQ = aVar;
    }

    public int getLoadedWidth() {
        return this.aOg;
    }

    public int getLoadedHeight() {
        return this.aOh;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aOc != null) {
            this.aOc.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aNQ = null;
        this.ajx = d.e.transparent;
        this.aNR = d.g.img_default_100;
        this.aNS = this.ajx;
        this.aNT = d.g.img_loading;
        this.ajy = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFk = false;
        this.aOd = null;
        this.aOe = 3;
        this.aOf = 0L;
        this.aOg = 0;
        this.aOh = 0;
        this.aOm = false;
        this.aOn = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOa != null) {
                    TbImageView.this.aOa.bf(view);
                    return TbImageView.this.aOa.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOb) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOa != null) {
                        TbImageView.this.aOa.bf(view);
                        return TbImageView.this.aOa.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fK().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLT, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLT = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i);
                if (aVar == null) {
                    TbImageView.this.aNS = TbImageView.this.aNR;
                } else {
                    TbImageView.this.rw = aVar.isGif();
                }
                if (TbImageView.this.aNQ != null) {
                    if (aVar != null) {
                        TbImageView.this.aOg = aVar.getWidth();
                        TbImageView.this.aOh = aVar.getHeight();
                    }
                    TbImageView.this.aNQ.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gx != null) {
                        TbImageView.this.aOd.Gz = aVar.Gx.Gz;
                        TbImageView.this.aOd.isSuccess = aVar.Gx.GB;
                        TbImageView.this.aOd.GA = aVar.Gx.GA;
                    }
                } else {
                    TbImageView.this.aOd.Gz = "net";
                    TbImageView.this.aOd.isSuccess = false;
                    TbImageView.this.aOd.GA = System.currentTimeMillis() - TbImageView.this.aOf;
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
                if (TbImageView.this.aNQ != null) {
                    TbImageView.this.aNQ.onCancel();
                }
            }
        };
        this.anw = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fK().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HV();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOi, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOj, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOk, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOl, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HV() {
                if (TbImageView.aOi == null) {
                    Method unused = TbImageView.aOi = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOj == null) {
                    Method unused2 = TbImageView.aOj = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOk == null) {
                    Method unused3 = TbImageView.aOk = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOl == null) {
                    Method unused4 = TbImageView.aOl = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNQ = null;
        this.ajx = d.e.transparent;
        this.aNR = d.g.img_default_100;
        this.aNS = this.ajx;
        this.aNT = d.g.img_loading;
        this.ajy = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFk = false;
        this.aOd = null;
        this.aOe = 3;
        this.aOf = 0L;
        this.aOg = 0;
        this.aOh = 0;
        this.aOm = false;
        this.aOn = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOa != null) {
                    TbImageView.this.aOa.bf(view);
                    return TbImageView.this.aOa.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOb) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOa != null) {
                        TbImageView.this.aOa.bf(view);
                        return TbImageView.this.aOa.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fK().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLT, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLT = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i2);
                if (aVar == null) {
                    TbImageView.this.aNS = TbImageView.this.aNR;
                } else {
                    TbImageView.this.rw = aVar.isGif();
                }
                if (TbImageView.this.aNQ != null) {
                    if (aVar != null) {
                        TbImageView.this.aOg = aVar.getWidth();
                        TbImageView.this.aOh = aVar.getHeight();
                    }
                    TbImageView.this.aNQ.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gx != null) {
                        TbImageView.this.aOd.Gz = aVar.Gx.Gz;
                        TbImageView.this.aOd.isSuccess = aVar.Gx.GB;
                        TbImageView.this.aOd.GA = aVar.Gx.GA;
                    }
                } else {
                    TbImageView.this.aOd.Gz = "net";
                    TbImageView.this.aOd.isSuccess = false;
                    TbImageView.this.aOd.GA = System.currentTimeMillis() - TbImageView.this.aOf;
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
                if (TbImageView.this.aNQ != null) {
                    TbImageView.this.aNQ.onCancel();
                }
            }
        };
        this.anw = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fK().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HV();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOi, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOj, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOk, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOl, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HV() {
                if (TbImageView.aOi == null) {
                    Method unused = TbImageView.aOi = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOj == null) {
                    Method unused2 = TbImageView.aOj = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOk == null) {
                    Method unused3 = TbImageView.aOk = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOl == null) {
                    Method unused4 = TbImageView.aOl = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
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
        this.aNW = 30.0f;
        this.aOd = new l();
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
        if (aNX == null) {
            aNX = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aNU);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aOe != TbadkCoreApplication.getInst().getSkinType()) {
            this.Bk = true;
            this.aOe = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aNX.containsKey(str) || (softReference = aNX.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kP()) {
            Bitmap bitmap = null;
            if (this.aNU > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = aj.cT(this.aNU);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aNU);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aNU);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aNU);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aNU));
            aNX.put(str, new SoftReference<>(aVar2));
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
        h V = i.V(getContext());
        if (V != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : V.getUniqueId();
            z2 = V.isScroll();
            bdUniqueId = uniqueId;
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        h V = i.V(getContext());
        if (V != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : V.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aNS = this.ajx;
        if (TextUtils.isEmpty(str)) {
            this.aNS = this.aNR;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            Eq();
            this.Bk = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aOd.Gz = "memory";
            this.aOd.isSuccess = true;
            this.aOd.GA = 0L;
            invalidate();
            if (this.aNQ != null) {
                this.aNQ.t(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.fK().al(this.mType) && this.aFk) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hi()) {
            this.aOd.Gz = "memory";
            this.aOd.isSuccess = false;
            this.aOd.GA = 0L;
            this.aNS = this.aNR;
            invalidate();
            if (this.aNQ != null) {
                this.aNQ.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aOf = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, this.mType, this.aLT, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void Eq() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, this.mType, this.aLT);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> X = i.X(getContext());
        if (this.mPageId != null) {
            this.aOm = true;
        }
        if (X != null) {
            this.anw.setTag(this.mPageId != null ? this.mPageId : X.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.anw);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aOm = false;
        Eq();
        MessageManager.getInstance().unRegisterListener(this.anw);
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
        this.aNZ = true;
        Ep();
    }

    public void stopLoading() {
        this.aNZ = false;
        removeCallbacks(this);
        this.aEX = 0.0f;
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
        if (this.aNZ) {
            this.aEX += this.aNW;
            if (this.aEX > 360.0f - this.aNW) {
                this.aEX = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aEX, getWidth() / 2.0f, getHeight() / 2.0f);
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
        int i = this.aNU;
        int i2 = this.aNZ ? this.aNT : this.aNS;
        if (i2 != this.aNU) {
            this.aNU = i2;
            this.Bk = true;
        }
        int i3 = this.aNV;
        this.aNV = this.ajy;
        if (this.aNV > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aj.getDrawable(this.aNV));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aNV));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.ajx != i) {
            this.ajx = i;
            this.aNS = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aNR = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.ajy != i) {
            this.ajy = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aOm && this.mPageId != null) {
            this.anw.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.anw);
            this.aOm = true;
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
        super.setOnTouchListener(this.aOn);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aOn);
        this.aOa = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aOb = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aOb) {
            startLoading();
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, this.mType, this.aLT, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
        this.aFk = z;
    }

    public l getPerfLog() {
        return this.aOd;
    }

    public void wy() {
        if (!this.aNY) {
            this.aNY = true;
        } else if (this.aOd != null && this.aOd.aJF) {
            this.aOd.Gr();
        }
    }
}
