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
    private static Method aOC;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aOo;
    private static Method aOz;
    private float aFF;
    protected boolean aFS;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMn;
    private boolean aOD;
    private final com.baidu.tieba.pb.a.c aOE;
    protected a aOh;
    protected int aOi;
    protected int aOj;
    private final int aOk;
    private int aOl;
    private int aOm;
    private float aOn;
    protected boolean aOp;
    private boolean aOq;
    private com.baidu.tieba.pb.a.c aOr;
    private boolean aOs;
    private b aOt;
    protected l aOu;
    private int aOv;
    protected long aOw;
    int aOx;
    int aOy;
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
        this.aOt = bVar;
    }

    public void setEvent(a aVar) {
        this.aOh = aVar;
    }

    public int getLoadedWidth() {
        return this.aOx;
    }

    public int getLoadedHeight() {
        return this.aOy;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aOt != null) {
            this.aOt.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aOh = null;
        this.akd = d.e.transparent;
        this.aOi = d.g.img_default_100;
        this.aOj = this.akd;
        this.aOk = d.g.img_loading;
        this.ake = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFS = false;
        this.aOu = null;
        this.aOv = 3;
        this.aOw = 0L;
        this.aOx = 0;
        this.aOy = 0;
        this.aOD = false;
        this.aOE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOr != null) {
                    TbImageView.this.aOr.aY(view);
                    return TbImageView.this.aOr.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOs) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOr != null) {
                        TbImageView.this.aOr.aY(view);
                        return TbImageView.this.aOr.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fU().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aMn, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aMn = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i);
                if (aVar == null) {
                    TbImageView.this.aOj = TbImageView.this.aOi;
                } else {
                    TbImageView.this.tK = aVar.isGif();
                }
                if (TbImageView.this.aOh != null) {
                    if (aVar != null) {
                        TbImageView.this.aOx = aVar.getWidth();
                        TbImageView.this.aOy = aVar.getHeight();
                    }
                    TbImageView.this.aOh.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.IE != null) {
                        TbImageView.this.aOu.IG = aVar.IE.IG;
                        TbImageView.this.aOu.isSuccess = aVar.IE.II;
                        TbImageView.this.aOu.IH = aVar.IE.IH;
                    }
                } else {
                    TbImageView.this.aOu.IG = "net";
                    TbImageView.this.aOu.isSuccess = false;
                    TbImageView.this.aOu.IH = System.currentTimeMillis() - TbImageView.this.aOw;
                }
                TbImageView.this.wB();
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
                if (TbImageView.this.aOh != null) {
                    TbImageView.this.aOh.onCancel();
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
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOz, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOA, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOB, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOC, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HW() {
                if (TbImageView.aOz == null) {
                    Method unused = TbImageView.aOz = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOA == null) {
                    Method unused2 = TbImageView.aOA = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOB == null) {
                    Method unused3 = TbImageView.aOB = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOC == null) {
                    Method unused4 = TbImageView.aOC = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOh = null;
        this.akd = d.e.transparent;
        this.aOi = d.g.img_default_100;
        this.aOj = this.akd;
        this.aOk = d.g.img_loading;
        this.ake = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aFS = false;
        this.aOu = null;
        this.aOv = 3;
        this.aOw = 0L;
        this.aOx = 0;
        this.aOy = 0;
        this.aOD = false;
        this.aOE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aOr != null) {
                    TbImageView.this.aOr.aY(view);
                    return TbImageView.this.aOr.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aOs) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aOr != null) {
                        TbImageView.this.aOr.aY(view);
                        return TbImageView.this.aOr.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fU().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aMn, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aMn = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i2);
                if (aVar == null) {
                    TbImageView.this.aOj = TbImageView.this.aOi;
                } else {
                    TbImageView.this.tK = aVar.isGif();
                }
                if (TbImageView.this.aOh != null) {
                    if (aVar != null) {
                        TbImageView.this.aOx = aVar.getWidth();
                        TbImageView.this.aOy = aVar.getHeight();
                    }
                    TbImageView.this.aOh.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.IE != null) {
                        TbImageView.this.aOu.IG = aVar.IE.IG;
                        TbImageView.this.aOu.isSuccess = aVar.IE.II;
                        TbImageView.this.aOu.IH = aVar.IE.IH;
                    }
                } else {
                    TbImageView.this.aOu.IG = "net";
                    TbImageView.this.aOu.isSuccess = false;
                    TbImageView.this.aOu.IH = System.currentTimeMillis() - TbImageView.this.aOw;
                }
                TbImageView.this.wB();
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
                if (TbImageView.this.aOh != null) {
                    TbImageView.this.aOh.onCancel();
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
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOz, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOA, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOB, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aOC, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HW() {
                if (TbImageView.aOz == null) {
                    Method unused = TbImageView.aOz = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aOA == null) {
                    Method unused2 = TbImageView.aOA = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aOB == null) {
                    Method unused3 = TbImageView.aOB = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aOC == null) {
                    Method unused4 = TbImageView.aOC = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
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
        this.aOn = 30.0f;
        this.aOu = new l();
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
                com.baidu.adp.widget.a.a gt = com.baidu.tbadk.imageManager.c.Ex().gt(str);
                aVar = gt == null ? com.baidu.tbadk.imageManager.c.Ex().gs(str) : gt;
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
        if (aOo == null) {
            aOo = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aOl);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aOv != TbadkCoreApplication.getInst().getSkinType()) {
            this.Dr = true;
            this.aOv = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aOo.containsKey(str) || (softReference = aOo.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kX()) {
            Bitmap bitmap = null;
            if (this.aOl > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = ai.cS(this.aOl);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aOl);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aOl);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aOl);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aOl));
            aOo.put(str, new SoftReference<>(aVar2));
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
        this.aOj = this.akd;
        if (TextUtils.isEmpty(str)) {
            this.aOj = this.aOi;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            Es();
            this.Dr = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aOu.IG = "memory";
            this.aOu.isSuccess = true;
            this.aOu.IH = 0L;
            invalidate();
            if (this.aOh != null) {
                this.aOh.t(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.fU().ao(this.mType) && this.aFS) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hr()) {
            this.aOu.IG = "memory";
            this.aOu.isSuccess = false;
            this.aOu.IH = 0L;
            this.aOj = this.aOi;
            invalidate();
            if (this.aOh != null) {
                this.aOh.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aOw = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMn, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void Es() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMn);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> aa = i.aa(getContext());
        if (this.mPageId != null) {
            this.aOD = true;
        }
        if (aa != null) {
            this.aoc.setTag(this.mPageId != null ? this.mPageId : aa.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.aoc);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aOD = false;
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
        this.aOq = true;
        Er();
    }

    public void stopLoading() {
        this.aOq = false;
        removeCallbacks(this);
        this.aFF = 0.0f;
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
        if (this.aOq) {
            this.aFF += this.aOn;
            if (this.aFF > 360.0f - this.aOn) {
                this.aFF = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aFF, getWidth() / 2.0f, getHeight() / 2.0f);
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
        int i = this.aOl;
        int i2 = this.aOq ? this.aOk : this.aOj;
        if (i2 != this.aOl) {
            this.aOl = i2;
            this.Dr = true;
        }
        int i3 = this.aOm;
        this.aOm = this.ake;
        if (this.aOm > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ai.getDrawable(this.aOm));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aOm));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.akd != i) {
            this.akd = i;
            this.aOj = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aOi = i;
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
        if (!this.aOD && this.mPageId != null) {
            this.aoc.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.aoc);
            this.aOD = true;
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
        super.setOnTouchListener(this.aOE);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aOE);
        this.aOr = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aOs = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aOs) {
            startLoading();
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, this.mType, this.aMn, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
        this.aFS = z;
    }

    public l getPerfLog() {
        return this.aOu;
    }

    public void wB() {
        if (!this.aOp) {
            this.aOp = true;
        } else if (this.aOu != null && this.aOu.aKb) {
            this.aOu.Gt();
        }
    }
}
