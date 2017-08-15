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
    private static Method aOB;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aOn;
    private static Method aOy;
    private static Method aOz;
    private float aFE;
    protected boolean aFR;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMm;
    private boolean aOC;
    private final com.baidu.tieba.pb.a.c aOD;
    protected a aOg;
    protected int aOh;
    protected int aOi;
    private final int aOj;
    private int aOk;
    private int aOl;
    private float aOm;
    protected boolean aOo;
    private boolean aOp;
    private com.baidu.tieba.pb.a.c aOq;
    private boolean aOr;
    private b aOs;
    protected l aOt;
    private int aOu;
    protected long aOv;
    int aOw;
    int aOx;
    protected int akd;
    private int ake;
    private CustomMessageListener aoc;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected boolean tK;

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
        this.aOs = bVar;
    }

    public void setEvent(a aVar) {
        this.aOg = aVar;
    }

    public int getLoadedWidth() {
        return this.aOw;
    }

    public int getLoadedHeight() {
        return this.aOx;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aOs != null) {
            this.aOs.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aOg = null;
        this.akd = d.e.transparent;
        this.aOh = d.g.img_default_100;
        this.aOi = this.akd;
        this.aOj = d.g.img_loading;
        this.ake = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFR = false;
        this.aOt = null;
        this.aOu = 3;
        this.aOv = 0L;
        this.aOw = 0;
        this.aOx = 0;
        this.aOC = false;
        this.aOD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOq != null) {
                    TbImageView.this.aOq.aZ(view);
                    return TbImageView.this.aOq.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOr) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOq != null) {
                        TbImageView.this.aOq.aZ(view);
                        return TbImageView.this.aOq.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fU().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aMm, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aMm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i);
                if (aVar == null) {
                    TbImageView.this.aOi = TbImageView.this.aOh;
                } else {
                    TbImageView.this.tK = aVar.isGif();
                }
                if (TbImageView.this.aOg != null) {
                    if (aVar != null) {
                        TbImageView.this.aOw = aVar.getWidth();
                        TbImageView.this.aOx = aVar.getHeight();
                    }
                    TbImageView.this.aOg.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.IE != null) {
                        TbImageView.this.aOt.IG = aVar.IE.IG;
                        TbImageView.this.aOt.isSuccess = aVar.IE.II;
                        TbImageView.this.aOt.IH = aVar.IE.IH;
                    }
                } else {
                    TbImageView.this.aOt.IG = "net";
                    TbImageView.this.aOt.isSuccess = false;
                    TbImageView.this.aOt.IH = System.currentTimeMillis() - TbImageView.this.aOv;
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
                if (TbImageView.this.aOg != null) {
                    TbImageView.this.aOg.onCancel();
                }
            }
        };
        this.aoc = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fU().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HW();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOy, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOz, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOA, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOB, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HW() {
                if (TbImageView.aOy == null) {
                    Method unused = TbImageView.aOy = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOz == null) {
                    Method unused2 = TbImageView.aOz = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOA == null) {
                    Method unused3 = TbImageView.aOA = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOB == null) {
                    Method unused4 = TbImageView.aOB = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOg = null;
        this.akd = d.e.transparent;
        this.aOh = d.g.img_default_100;
        this.aOi = this.akd;
        this.aOj = d.g.img_loading;
        this.ake = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFR = false;
        this.aOt = null;
        this.aOu = 3;
        this.aOv = 0L;
        this.aOw = 0;
        this.aOx = 0;
        this.aOC = false;
        this.aOD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOq != null) {
                    TbImageView.this.aOq.aZ(view);
                    return TbImageView.this.aOq.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOr) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOq != null) {
                        TbImageView.this.aOq.aZ(view);
                        return TbImageView.this.aOq.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fU().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aMm, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aMm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i2);
                if (aVar == null) {
                    TbImageView.this.aOi = TbImageView.this.aOh;
                } else {
                    TbImageView.this.tK = aVar.isGif();
                }
                if (TbImageView.this.aOg != null) {
                    if (aVar != null) {
                        TbImageView.this.aOw = aVar.getWidth();
                        TbImageView.this.aOx = aVar.getHeight();
                    }
                    TbImageView.this.aOg.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.IE != null) {
                        TbImageView.this.aOt.IG = aVar.IE.IG;
                        TbImageView.this.aOt.isSuccess = aVar.IE.II;
                        TbImageView.this.aOt.IH = aVar.IE.IH;
                    }
                } else {
                    TbImageView.this.aOt.IG = "net";
                    TbImageView.this.aOt.isSuccess = false;
                    TbImageView.this.aOt.IH = System.currentTimeMillis() - TbImageView.this.aOv;
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
                if (TbImageView.this.aOg != null) {
                    TbImageView.this.aOg.onCancel();
                }
            }
        };
        this.aoc = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fU().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HW();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOy, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOz, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOA, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOB, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HW() {
                if (TbImageView.aOy == null) {
                    Method unused = TbImageView.aOy = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOz == null) {
                    Method unused2 = TbImageView.aOz = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOA == null) {
                    Method unused3 = TbImageView.aOA = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOB == null) {
                    Method unused4 = TbImageView.aOB = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
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
        this.aOm = 30.0f;
        this.aOt = new l();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Dr = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Dr = true;
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
            this.tK = aVar.isGif();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (aOn == null) {
            aOn = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aOk);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aOu != TbadkCoreApplication.getInst().getSkinType()) {
            this.Dr = true;
            this.aOu = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aOn.containsKey(str) || (softReference = aOn.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kY()) {
            Bitmap bitmap = null;
            if (this.aOk > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = ai.cS(this.aOk);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aOk);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aOk);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aOk);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aOk));
            aOn.put(str, new SoftReference<>(aVar2));
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
        this.aOi = this.akd;
        if (TextUtils.isEmpty(str)) {
            this.aOi = this.aOh;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            Es();
            this.Dr = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aOt.IG = "memory";
            this.aOt.isSuccess = true;
            this.aOt.IH = 0L;
            invalidate();
            if (this.aOg != null) {
                this.aOg.t(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Dr = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fU().ao(this.mType) && this.aFR) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hr()) {
            this.aOt.IG = "memory";
            this.aOt.isSuccess = false;
            this.aOt.IH = 0L;
            this.aOi = this.aOh;
            invalidate();
            if (this.aOg != null) {
                this.aOg.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aOv = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMm, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void Es() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMm);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> aa = i.aa(getContext());
        if (this.mPageId != null) {
            this.aOC = true;
        }
        if (aa != null) {
            this.aoc.setTag(this.mPageId != null ? this.mPageId : aa.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.aoc);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aOC = false;
        Es();
        MessageManager.getInstance().unRegisterListener(this.aoc);
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
        this.aOp = true;
        Er();
    }

    public void stopLoading() {
        this.aOp = false;
        removeCallbacks(this);
        this.aFE = 0.0f;
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
        if (this.aOp) {
            this.aFE += this.aOm;
            if (this.aFE > 360.0f - this.aOm) {
                this.aFE = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aFE, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Er();
        }
    }

    private void HR() {
        if (this.mAutoChangeStyle) {
            this.Dh.DG = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.Dh.DG = false;
        }
        int i = this.aOk;
        int i2 = this.aOp ? this.aOj : this.aOi;
        if (i2 != this.aOk) {
            this.aOk = i2;
            this.Dr = true;
        }
        int i3 = this.aOl;
        this.aOl = this.ake;
        if (this.aOl > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ai.getDrawable(this.aOl));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aOl));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.akd != i) {
            this.akd = i;
            this.aOi = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aOh = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.ake != i) {
            this.ake = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aOC && this.mPageId != null) {
            this.aoc.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.aoc);
            this.aOC = true;
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
        super.setOnTouchListener(this.aOD);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aOD);
        this.aOq = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aOr = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aOr) {
            startLoading();
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMm, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.Dh.DJ != null) {
            return this.Dh.DJ.getIntrinsicWidth();
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.Dh.DJ != null) {
            return this.Dh.DJ.getIntrinsicHeight();
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aFR = z;
    }

    public l getPerfLog() {
        return this.aOt;
    }

    public void wA() {
        if (!this.aOo) {
            this.aOo = true;
        } else if (this.aOt != null && this.aOt.aKa) {
            this.aOt.Gt();
        }
    }
}
