package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.k.l;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.b.a.b implements View.OnClickListener, Runnable {
    private static HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.a>> aNJ;
    private static Method aNU;
    private static Method aNV;
    private static Method aNW;
    private static Method aNX;
    protected boolean aEB;
    private float aEn;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aLs;
    protected a aNC;
    protected int aND;
    protected int aNE;
    private final int aNF;
    private int aNG;
    private int aNH;
    private float aNI;
    protected boolean aNK;
    private boolean aNL;
    private com.baidu.tieba.pb.a.c aNM;
    private boolean aNN;
    private TbRichTextView.d aNO;
    protected l aNP;
    private int aNQ;
    protected long aNR;
    int aNS;
    int aNT;
    private boolean aNY;
    private d aNZ;
    private final com.baidu.tieba.pb.a.c aOa;
    protected int aiY;
    private int aiZ;
    private CustomMessageListener amE;
    protected boolean isLongPic;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected boolean rx;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void s(String str, boolean z);
    }

    public void setDispatchTouchListener(TbRichTextView.d dVar) {
        this.aNO = dVar;
    }

    public void setEvent(a aVar) {
        this.aNC = aVar;
    }

    public int getLoadedWidth() {
        return this.aNS;
    }

    public int getLoadedHeight() {
        return this.aNT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.rx = aVar.isGif();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aNO != null) {
            this.aNO.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aNC = null;
        this.aiY = d.e.transparent;
        this.aND = d.g.img_default_100;
        this.aNE = this.aiY;
        this.aNF = d.g.img_loading;
        this.aiZ = d.e.cp_bg_line_e;
        this.rx = false;
        this.isLongPic = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aEB = false;
        this.aNP = null;
        this.aNQ = 3;
        this.aNR = 0L;
        this.aNS = 0;
        this.aNT = 0;
        this.aNY = false;
        this.aOa = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNM != null) {
                    TbImageView.this.aNM.bb(view);
                    return TbImageView.this.aNM.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNN) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNM != null) {
                        TbImageView.this.aNM.bb(view);
                        return TbImageView.this.aNM.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLs, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLs = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                } else {
                    TbImageView.this.aNE = TbImageView.this.aND;
                }
                if (TbImageView.this.aNC != null) {
                    if (aVar != null) {
                        TbImageView.this.aNS = aVar.getWidth();
                        TbImageView.this.aNT = aVar.getHeight();
                    }
                    TbImageView.this.aNC.s(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gy != null) {
                        TbImageView.this.aNP.GA = aVar.Gy.GA;
                        TbImageView.this.aNP.isSuccess = aVar.Gy.GC;
                        TbImageView.this.aNP.GB = aVar.Gy.GB;
                    }
                } else {
                    TbImageView.this.aNP.GA = "net";
                    TbImageView.this.aNP.isSuccess = false;
                    TbImageView.this.aNP.GB = System.currentTimeMillis() - TbImageView.this.aNR;
                }
                TbImageView.this.wd();
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
                if (TbImageView.this.aNC != null) {
                    TbImageView.this.aNC.onCancel();
                }
            }
        };
        this.amE = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HD();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNU, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNV, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNW, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNX, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HD() {
                if (TbImageView.aNU == null) {
                    Method unused = TbImageView.aNU = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aNV == null) {
                    Method unused2 = TbImageView.aNV = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aNW == null) {
                    Method unused3 = TbImageView.aNW = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aNX == null) {
                    Method unused4 = TbImageView.aNX = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNC = null;
        this.aiY = d.e.transparent;
        this.aND = d.g.img_default_100;
        this.aNE = this.aiY;
        this.aNF = d.g.img_loading;
        this.aiZ = d.e.cp_bg_line_e;
        this.rx = false;
        this.isLongPic = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aEB = false;
        this.aNP = null;
        this.aNQ = 3;
        this.aNR = 0L;
        this.aNS = 0;
        this.aNT = 0;
        this.aNY = false;
        this.aOa = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNM != null) {
                    TbImageView.this.aNM.bb(view);
                    return TbImageView.this.aNM.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNN) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNM != null) {
                        TbImageView.this.aNM.bb(view);
                        return TbImageView.this.aNM.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLs, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLs = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                } else {
                    TbImageView.this.aNE = TbImageView.this.aND;
                }
                if (TbImageView.this.aNC != null) {
                    if (aVar != null) {
                        TbImageView.this.aNS = aVar.getWidth();
                        TbImageView.this.aNT = aVar.getHeight();
                    }
                    TbImageView.this.aNC.s(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gy != null) {
                        TbImageView.this.aNP.GA = aVar.Gy.GA;
                        TbImageView.this.aNP.isSuccess = aVar.Gy.GC;
                        TbImageView.this.aNP.GB = aVar.Gy.GB;
                    }
                } else {
                    TbImageView.this.aNP.GA = "net";
                    TbImageView.this.aNP.isSuccess = false;
                    TbImageView.this.aNP.GB = System.currentTimeMillis() - TbImageView.this.aNR;
                }
                TbImageView.this.wd();
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
                if (TbImageView.this.aNC != null) {
                    TbImageView.this.aNC.onCancel();
                }
            }
        };
        this.amE = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HD();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNU, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNV, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNW, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNX, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HD() {
                if (TbImageView.aNU == null) {
                    Method unused = TbImageView.aNU = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aNV == null) {
                    Method unused2 = TbImageView.aNV = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aNW == null) {
                    Method unused3 = TbImageView.aNW = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aNX == null) {
                    Method unused4 = TbImageView.aNX = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.aNZ = new d(this);
        Hy();
        this.aNI = 30.0f;
        this.aNP = new l();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Bm = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Bm = true;
            requestLayout();
        }
    }

    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                aVar = null;
            } else {
                String str = (String) tag;
                com.baidu.adp.widget.ImageView.a gi = com.baidu.tbadk.imageManager.c.DZ().gi(str);
                aVar = gi == null ? com.baidu.tbadk.imageManager.c.DZ().gh(str) : gi;
            }
        } else {
            aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            e(aVar);
            f(aVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.ImageView.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.ImageView.a> softReference;
        com.baidu.adp.widget.ImageView.a aVar;
        if (aNJ == null) {
            aNJ = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aNG);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aNQ != TbadkCoreApplication.getInst().getSkinType()) {
            this.Bm = true;
            this.aNQ = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aNJ.containsKey(str) || (softReference = aNJ.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kO()) {
            Bitmap bitmap = null;
            if (this.aNG > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = aj.cR(this.aNG);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aNG);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aNG);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aNG);
                }
            }
            com.baidu.adp.widget.ImageView.a aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, false, String.valueOf(this.aNG));
            aNJ.put(str, new SoftReference<>(aVar2));
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
        this.aNE = this.aiY;
        if (TextUtils.isEmpty(str)) {
            this.aNE = this.aND;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            DU();
            this.Bm = true;
            this.rx = false;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aNP.GA = "memory";
            this.aNP.isSuccess = true;
            this.aNP.GB = 0L;
            invalidate();
            if (this.aNC != null) {
                this.aNC.s(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bm = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fJ().ao(this.mType) && this.aEB) {
            invalidate();
        } else if (z3 && !j.hh()) {
            this.aNP.GA = "memory";
            this.aNP.isSuccess = false;
            this.aNP.GB = 0L;
            this.aNE = this.aND;
            invalidate();
            if (this.aNC != null) {
                this.aNC.s(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aNR = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aLs, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void DU() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aLs);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (this.mPageId != null) {
            this.aNY = true;
        }
        if (Y != null) {
            this.amE.setTag(this.mPageId != null ? this.mPageId : Y.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.amE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aNY = false;
        DU();
        MessageManager.getInstance().unRegisterListener(this.amE);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DU();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Hy();
        super.onDraw(canvas);
    }

    @Override // com.baidu.adp.b.a.b
    public void c(Canvas canvas, ImageView imageView) {
        super.c(canvas, imageView);
        if (this.aNZ != null && this.Bc != null) {
            if (this.Bc.BF && isGif()) {
                this.aNZ.c(canvas, getContext().getString(d.l.icon_tag_gif));
            } else if (this.Bc.BE && isLongPic()) {
                this.aNZ.c(canvas, getContext().getString(d.l.icon_tag_long));
            }
        }
    }

    public void N(int i, int i2) {
        if (this.aNZ != null) {
            this.aNZ.R(i, i2);
        }
    }

    public boolean isGif() {
        return this.rx;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public void setIsLongPic(boolean z) {
        this.isLongPic = z;
    }

    public void startLoading() {
        this.aNL = true;
        DT();
    }

    public void stopLoading() {
        this.aNL = false;
        removeCallbacks(this);
        this.aEn = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNL) {
            this.aEn += this.aNI;
            if (this.aEn > 360.0f - this.aNI) {
                this.aEn = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aEn, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DT();
        }
    }

    private void Hy() {
        if (this.mAutoChangeStyle) {
            this.Bc.BC = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.Bc.BC = false;
        }
        int i = this.aNG;
        int i2 = this.aNL ? this.aNF : this.aiY;
        if (i2 != this.aNG) {
            this.aNG = i2;
            this.Bm = true;
        }
        this.aNH = this.aiZ;
        if (this.aNH > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aj.getDrawable(this.aNH));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aNH));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aiY != i) {
            this.aiY = i;
            this.aNE = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aND = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aiZ != i) {
            this.aiZ = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aNY && this.mPageId != null) {
            this.amE.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.amE);
            this.aNY = true;
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
        this.rx = false;
        this.isLongPic = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.aOa);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aOa);
        this.aNM = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aNN = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aNN) {
            startLoading();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aLs, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.aNZ != null) {
            return (int) this.aNZ.gV(getContext().getString(d.l.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.aNZ != null) {
            return (int) this.aNZ.gU(getContext().getString(d.l.icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aEB = z;
    }

    public l getPerfLog() {
        return this.aNP;
    }

    public void wd() {
        if (!this.aNK) {
            this.aNK = true;
        } else if (this.aNP != null && this.aNP.aJd) {
            this.aNP.FW();
        }
    }

    @Override // com.baidu.adp.b.a.b
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void O(int i, int i2) {
        if (this.aNZ != null) {
            this.aNZ.O(i, i2);
        }
    }

    public void setTagTextSize(int i) {
        if (this.aNZ != null) {
            this.aNZ.setTagTextSize(i);
        }
    }
}
