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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.l.l;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.b.a.b implements View.OnClickListener, Runnable {
    private static Method aOA;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aOm;
    private static Method aOx;
    private static Method aOy;
    private static Method aOz;
    private float aFD;
    protected boolean aFQ;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMl;
    private boolean aOB;
    private final com.baidu.tieba.pb.a.c aOC;
    protected a aOf;
    protected int aOg;
    protected int aOh;
    private final int aOi;
    private int aOj;
    private int aOk;
    private float aOl;
    protected boolean aOn;
    private boolean aOo;
    private com.baidu.tieba.pb.a.c aOp;
    private boolean aOq;
    private b aOr;
    protected l aOs;
    private int aOt;
    protected long aOu;
    int aOv;
    int aOw;
    protected int akb;
    private int akc;
    private CustomMessageListener aob;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected boolean tI;

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
        this.aOr = bVar;
    }

    public void setEvent(a aVar) {
        this.aOf = aVar;
    }

    public int getLoadedWidth() {
        return this.aOv;
    }

    public int getLoadedHeight() {
        return this.aOw;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aOr != null) {
            this.aOr.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aOf = null;
        this.akb = d.e.transparent;
        this.aOg = d.g.img_default_100;
        this.aOh = this.akb;
        this.aOi = d.g.img_loading;
        this.akc = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFQ = false;
        this.aOs = null;
        this.aOt = 3;
        this.aOu = 0L;
        this.aOv = 0;
        this.aOw = 0;
        this.aOB = false;
        this.aOC = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOp != null) {
                    TbImageView.this.aOp.aX(view);
                    return TbImageView.this.aOp.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOq) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOp != null) {
                        TbImageView.this.aOp.aX(view);
                        return TbImageView.this.aOp.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fU().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aMl, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aMl = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i);
                if (aVar == null) {
                    TbImageView.this.aOh = TbImageView.this.aOg;
                } else {
                    TbImageView.this.tI = aVar.isGif();
                }
                if (TbImageView.this.aOf != null) {
                    if (aVar != null) {
                        TbImageView.this.aOv = aVar.getWidth();
                        TbImageView.this.aOw = aVar.getHeight();
                    }
                    TbImageView.this.aOf.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.IB != null) {
                        TbImageView.this.aOs.IE = aVar.IB.IE;
                        TbImageView.this.aOs.isSuccess = aVar.IB.IG;
                        TbImageView.this.aOs.IF = aVar.IB.IF;
                    }
                } else {
                    TbImageView.this.aOs.IE = "net";
                    TbImageView.this.aOs.isSuccess = false;
                    TbImageView.this.aOs.IF = System.currentTimeMillis() - TbImageView.this.aOu;
                }
                TbImageView.this.wA();
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
                if (TbImageView.this.aOf != null) {
                    TbImageView.this.aOf.onCancel();
                }
            }
        };
        this.aob = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fU().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HW();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOx, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOy, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOz, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOA, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HW() {
                if (TbImageView.aOx == null) {
                    Method unused = TbImageView.aOx = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOy == null) {
                    Method unused2 = TbImageView.aOy = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOz == null) {
                    Method unused3 = TbImageView.aOz = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOA == null) {
                    Method unused4 = TbImageView.aOA = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOf = null;
        this.akb = d.e.transparent;
        this.aOg = d.g.img_default_100;
        this.aOh = this.akb;
        this.aOi = d.g.img_loading;
        this.akc = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFQ = false;
        this.aOs = null;
        this.aOt = 3;
        this.aOu = 0L;
        this.aOv = 0;
        this.aOw = 0;
        this.aOB = false;
        this.aOC = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOp != null) {
                    TbImageView.this.aOp.aX(view);
                    return TbImageView.this.aOp.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOq) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOp != null) {
                        TbImageView.this.aOp.aX(view);
                        return TbImageView.this.aOp.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fU().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aMl, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aMl = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i2);
                if (aVar == null) {
                    TbImageView.this.aOh = TbImageView.this.aOg;
                } else {
                    TbImageView.this.tI = aVar.isGif();
                }
                if (TbImageView.this.aOf != null) {
                    if (aVar != null) {
                        TbImageView.this.aOv = aVar.getWidth();
                        TbImageView.this.aOw = aVar.getHeight();
                    }
                    TbImageView.this.aOf.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.IB != null) {
                        TbImageView.this.aOs.IE = aVar.IB.IE;
                        TbImageView.this.aOs.isSuccess = aVar.IB.IG;
                        TbImageView.this.aOs.IF = aVar.IB.IF;
                    }
                } else {
                    TbImageView.this.aOs.IE = "net";
                    TbImageView.this.aOs.isSuccess = false;
                    TbImageView.this.aOs.IF = System.currentTimeMillis() - TbImageView.this.aOu;
                }
                TbImageView.this.wA();
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
                if (TbImageView.this.aOf != null) {
                    TbImageView.this.aOf.onCancel();
                }
            }
        };
        this.aob = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fU().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HW();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOx, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOy, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOz, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOA, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HW() {
                if (TbImageView.aOx == null) {
                    Method unused = TbImageView.aOx = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOy == null) {
                    Method unused2 = TbImageView.aOy = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOz == null) {
                    Method unused3 = TbImageView.aOz = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOA == null) {
                    Method unused4 = TbImageView.aOA = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HR();
        this.aOl = 30.0f;
        this.aOs = new l();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Dp = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Dp = true;
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
                com.baidu.adp.widget.a.a gp = com.baidu.tbadk.imageManager.c.Ex().gp(str);
                aVar = gp == null ? com.baidu.tbadk.imageManager.c.Ex().go(str) : gp;
            }
        } else {
            aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            this.tI = aVar.isGif();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aOm == null) {
            aOm = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aOj);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aOt != TbadkCoreApplication.getInst().getSkinType()) {
            this.Dp = true;
            this.aOt = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aOm.containsKey(str) || (softReference = aOm.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kY()) {
            Bitmap bitmap = null;
            if (this.aOj > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = ai.cS(this.aOj);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aOj);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aOj);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aOj);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aOj));
            aOm.put(str, new SoftReference<>(aVar2));
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
        h Y = i.Y(getContext());
        if (Y != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : Y.getUniqueId();
            z2 = Y.isScroll();
            bdUniqueId = uniqueId;
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        h Y = i.Y(getContext());
        if (Y != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : Y.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aOh = this.akb;
        if (TextUtils.isEmpty(str)) {
            this.aOh = this.aOg;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            Es();
            this.Dp = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aOs.IE = "memory";
            this.aOs.isSuccess = true;
            this.aOs.IF = 0L;
            invalidate();
            if (this.aOf != null) {
                this.aOf.t(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Dp = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fU().ao(this.mType) && this.aFQ) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hr()) {
            this.aOs.IE = "memory";
            this.aOs.isSuccess = false;
            this.aOs.IF = 0L;
            this.aOh = this.aOg;
            invalidate();
            if (this.aOf != null) {
                this.aOf.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aOu = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMl, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void Es() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMl);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> aa = i.aa(getContext());
        if (this.mPageId != null) {
            this.aOB = true;
        }
        if (aa != null) {
            this.aob.setTag(this.mPageId != null ? this.mPageId : aa.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.aob);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aOB = false;
        Es();
        MessageManager.getInstance().unRegisterListener(this.aob);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Es();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Es();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HR();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aOo = true;
        Er();
    }

    public void stopLoading() {
        this.aOo = false;
        removeCallbacks(this);
        this.aFD = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Er() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aOo) {
            this.aFD += this.aOl;
            if (this.aFD > 360.0f - this.aOl) {
                this.aFD = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aFD, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Er();
        }
    }

    private void HR() {
        if (this.mAutoChangeStyle) {
            this.Df.DE = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.Df.DE = false;
        }
        int i = this.aOj;
        int i2 = this.aOo ? this.aOi : this.aOh;
        if (i2 != this.aOj) {
            this.aOj = i2;
            this.Dp = true;
        }
        int i3 = this.aOk;
        this.aOk = this.akc;
        if (this.aOk > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ai.getDrawable(this.aOk));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aOk));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.akb != i) {
            this.akb = i;
            this.aOh = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aOg = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.akc != i) {
            this.akc = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aOB && this.mPageId != null) {
            this.aob.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.aob);
            this.aOB = true;
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
        super.setOnTouchListener(this.aOC);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aOC);
        this.aOp = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aOq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aOq) {
            startLoading();
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMl, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Df.DH != null) {
            return this.Df.DH.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Df.DH != null) {
            return this.Df.DH.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aFQ = z;
    }

    public l getPerfLog() {
        return this.aOs;
    }

    public void wA() {
        if (!this.aOn) {
            this.aOn = true;
        } else if (this.aOs != null && this.aOs.aJZ) {
            this.aOs.Gt();
        }
    }
}
