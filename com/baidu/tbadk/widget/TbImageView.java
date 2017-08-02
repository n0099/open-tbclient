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
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> aMY;
    private static Method aNj;
    private static Method aNk;
    private static Method aNl;
    private static Method aNm;
    protected boolean aEA;
    private float aEn;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aKW;
    protected a aMR;
    protected int aMS;
    protected int aMT;
    private final int aMU;
    private int aMV;
    private int aMW;
    private float aMX;
    protected boolean aMZ;
    private boolean aNa;
    private com.baidu.tieba.pb.a.c aNb;
    private boolean aNc;
    private b aNd;
    protected l aNe;
    private int aNf;
    protected long aNg;
    int aNh;
    int aNi;
    private boolean aNn;
    private final com.baidu.tieba.pb.a.c aNo;
    protected int aiI;
    private int aiJ;
    private CustomMessageListener amI;
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
        this.aNd = bVar;
    }

    public void setEvent(a aVar) {
        this.aMR = aVar;
    }

    public int getLoadedWidth() {
        return this.aNh;
    }

    public int getLoadedHeight() {
        return this.aNi;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aNd != null) {
            this.aNd.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aMR = null;
        this.aiI = d.e.transparent;
        this.aMS = d.g.img_default_100;
        this.aMT = this.aiI;
        this.aMU = d.g.img_loading;
        this.aiJ = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aEA = false;
        this.aNe = null;
        this.aNf = 3;
        this.aNg = 0L;
        this.aNh = 0;
        this.aNi = 0;
        this.aNn = false;
        this.aNo = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNb != null) {
                    TbImageView.this.aNb.aX(view);
                    return TbImageView.this.aNb.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNc) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNb != null) {
                        TbImageView.this.aNb.aX(view);
                        return TbImageView.this.aNb.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aKW, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aKW = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i);
                if (aVar == null) {
                    TbImageView.this.aMT = TbImageView.this.aMS;
                } else {
                    TbImageView.this.sa = aVar.isGif();
                }
                if (TbImageView.this.aMR != null) {
                    if (aVar != null) {
                        TbImageView.this.aNh = aVar.getWidth();
                        TbImageView.this.aNi = aVar.getHeight();
                    }
                    TbImageView.this.aMR.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Hc != null) {
                        TbImageView.this.aNe.He = aVar.Hc.He;
                        TbImageView.this.aNe.isSuccess = aVar.Hc.Hg;
                        TbImageView.this.aNe.Hf = aVar.Hc.Hf;
                    }
                } else {
                    TbImageView.this.aNe.He = "net";
                    TbImageView.this.aNe.isSuccess = false;
                    TbImageView.this.aNe.Hf = System.currentTimeMillis() - TbImageView.this.aNg;
                }
                TbImageView.this.wq();
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
                if (TbImageView.this.aMR != null) {
                    TbImageView.this.aMR.onCancel();
                }
            }
        };
        this.amI = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HO();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNj, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNk, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNl, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNm, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HO() {
                if (TbImageView.aNj == null) {
                    Method unused = TbImageView.aNj = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aNk == null) {
                    Method unused2 = TbImageView.aNk = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aNl == null) {
                    Method unused3 = TbImageView.aNl = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aNm == null) {
                    Method unused4 = TbImageView.aNm = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMR = null;
        this.aiI = d.e.transparent;
        this.aMS = d.g.img_default_100;
        this.aMT = this.aiI;
        this.aMU = d.g.img_loading;
        this.aiJ = d.e.cp_bg_line_e;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aEA = false;
        this.aNe = null;
        this.aNf = 3;
        this.aNg = 0L;
        this.aNh = 0;
        this.aNi = 0;
        this.aNn = false;
        this.aNo = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNb != null) {
                    TbImageView.this.aNb.aX(view);
                    return TbImageView.this.aNb.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNc) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNb != null) {
                        TbImageView.this.aNb.aX(view);
                        return TbImageView.this.aNb.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aKW, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aKW = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                BdLog.i("imagecallback. resourceFrom-" + i2);
                if (aVar == null) {
                    TbImageView.this.aMT = TbImageView.this.aMS;
                } else {
                    TbImageView.this.sa = aVar.isGif();
                }
                if (TbImageView.this.aMR != null) {
                    if (aVar != null) {
                        TbImageView.this.aNh = aVar.getWidth();
                        TbImageView.this.aNi = aVar.getHeight();
                    }
                    TbImageView.this.aMR.t(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Hc != null) {
                        TbImageView.this.aNe.He = aVar.Hc.He;
                        TbImageView.this.aNe.isSuccess = aVar.Hc.Hg;
                        TbImageView.this.aNe.Hf = aVar.Hc.Hf;
                    }
                } else {
                    TbImageView.this.aNe.He = "net";
                    TbImageView.this.aNe.isSuccess = false;
                    TbImageView.this.aNe.Hf = System.currentTimeMillis() - TbImageView.this.aNg;
                }
                TbImageView.this.wq();
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
                if (TbImageView.this.aMR != null) {
                    TbImageView.this.aMR.onCancel();
                }
            }
        };
        this.amI = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HO();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNj, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNk, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNl, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNm, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HO() {
                if (TbImageView.aNj == null) {
                    Method unused = TbImageView.aNj = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aNk == null) {
                    Method unused2 = TbImageView.aNk = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aNl == null) {
                    Method unused3 = TbImageView.aNl = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aNm == null) {
                    Method unused4 = TbImageView.aNm = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        HJ();
        this.aMX = 30.0f;
        this.aNe = new l();
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
                com.baidu.adp.widget.a.a gk = com.baidu.tbadk.imageManager.c.Ep().gk(str);
                aVar = gk == null ? com.baidu.tbadk.imageManager.c.Ep().gj(str) : gk;
            }
        } else {
            aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, new Object[0]);
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
        if (aMY == null) {
            aMY = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aMV);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aNf != TbadkCoreApplication.getInst().getSkinType()) {
            this.BP = true;
            this.aNf = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aMY.containsKey(str) || (softReference = aMY.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kO()) {
            Bitmap bitmap = null;
            if (this.aMV > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = ai.cQ(this.aMV);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aMV);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aMV);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aMV);
                }
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.aMV));
            aMY.put(str, new SoftReference<>(aVar2));
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
        h X = i.X(getContext());
        if (X != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : X.getUniqueId();
            z2 = X.isScroll();
            bdUniqueId = uniqueId;
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        h X = i.X(getContext());
        if (X != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : X.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.aMT = this.aiI;
        if (TextUtils.isEmpty(str)) {
            this.aMT = this.aMS;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            Ek();
            this.BP = true;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aNe.He = "memory";
            this.aNe.isSuccess = true;
            this.aNe.Hf = 0L;
            invalidate();
            if (this.aMR != null) {
                this.aMR.t(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.fJ().al(this.mType) && this.aEA) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.i.hh()) {
            this.aNe.He = "memory";
            this.aNe.isSuccess = false;
            this.aNe.Hf = 0L;
            this.aMT = this.aMS;
            invalidate();
            if (this.aMR != null) {
                this.aMR.t(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aNg = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aKW, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void Ek() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aKW);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> Z = i.Z(getContext());
        if (this.mPageId != null) {
            this.aNn = true;
        }
        if (Z != null) {
            this.amI.setTag(this.mPageId != null ? this.mPageId : Z.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.amI);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aNn = false;
        Ek();
        MessageManager.getInstance().unRegisterListener(this.amI);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ek();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ek();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        HJ();
        super.onDraw(canvas);
    }

    public void startLoading() {
        this.aNa = true;
        Ej();
    }

    public void stopLoading() {
        this.aNa = false;
        removeCallbacks(this);
        this.aEn = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void Ej() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNa) {
            this.aEn += this.aMX;
            if (this.aEn > 360.0f - this.aMX) {
                this.aEn = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aEn, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            Ej();
        }
    }

    private void HJ() {
        if (this.mAutoChangeStyle) {
            this.BF.Cf = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.BF.Cf = false;
        }
        int i = this.aMV;
        int i2 = this.aNa ? this.aMU : this.aMT;
        if (i2 != this.aMV) {
            this.aMV = i2;
            this.BP = true;
        }
        int i3 = this.aMW;
        this.aMW = this.aiJ;
        if (this.aMW > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ai.getDrawable(this.aMW));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aMW));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aiI != i) {
            this.aiI = i;
            this.aMT = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aMS = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aiJ != i) {
            this.aiJ = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aNn && this.mPageId != null) {
            this.amI.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.amI);
            this.aNn = true;
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
        super.setOnTouchListener(this.aNo);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aNo);
        this.aNb = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aNc = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aNc) {
            startLoading();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aKW, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
        this.aEA = z;
    }

    public l getPerfLog() {
        return this.aNe;
    }

    public void wq() {
        if (!this.aMZ) {
            this.aMZ = true;
        } else if (this.aNe != null && this.aNe.aIK) {
            this.aNe.Gl();
        }
    }
}
