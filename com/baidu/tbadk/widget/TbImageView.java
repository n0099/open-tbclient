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
    private static Method aNH;
    private static Method aNI;
    private static Method aNJ;
    private static Method aNK;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.a>> aNw;
    private float aEa;
    protected boolean aEo;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aLf;
    private boolean aNA;
    private TbRichTextView.d aNB;
    protected l aNC;
    private int aND;
    protected long aNE;
    int aNF;
    int aNG;
    private boolean aNL;
    private d aNM;
    private final com.baidu.tieba.pb.a.c aNN;
    protected a aNp;
    protected int aNq;
    protected int aNr;
    private final int aNs;
    private int aNt;
    private int aNu;
    private float aNv;
    protected boolean aNx;
    private boolean aNy;
    private com.baidu.tieba.pb.a.c aNz;
    protected int aiM;
    private int aiN;
    private CustomMessageListener ams;
    protected boolean isLongPic;
    private boolean mAutoChangeStyle;
    protected int mHeight;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected boolean ry;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void s(String str, boolean z);
    }

    public void setDispatchTouchListener(TbRichTextView.d dVar) {
        this.aNB = dVar;
    }

    public void setEvent(a aVar) {
        this.aNp = aVar;
    }

    public int getLoadedWidth() {
        return this.aNF;
    }

    public int getLoadedHeight() {
        return this.aNG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.ry = aVar.isGif();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aNB != null) {
            this.aNB.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.aNp = null;
        this.aiM = d.e.transparent;
        this.aNq = d.g.img_default_100;
        this.aNr = this.aiM;
        this.aNs = d.g.img_loading;
        this.aiN = d.e.cp_bg_line_e;
        this.ry = false;
        this.isLongPic = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aEo = false;
        this.aNC = null;
        this.aND = 3;
        this.aNE = 0L;
        this.aNF = 0;
        this.aNG = 0;
        this.aNL = false;
        this.aNN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNz != null) {
                    TbImageView.this.aNz.bb(view);
                    return TbImageView.this.aNz.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNA) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNz != null) {
                        TbImageView.this.aNz.bb(view);
                        return TbImageView.this.aNz.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLf, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLf = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                } else {
                    TbImageView.this.aNr = TbImageView.this.aNq;
                }
                if (TbImageView.this.aNp != null) {
                    if (aVar != null) {
                        TbImageView.this.aNF = aVar.getWidth();
                        TbImageView.this.aNG = aVar.getHeight();
                    }
                    TbImageView.this.aNp.s(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gz != null) {
                        TbImageView.this.aNC.GB = aVar.Gz.GB;
                        TbImageView.this.aNC.isSuccess = aVar.Gz.GD;
                        TbImageView.this.aNC.GC = aVar.Gz.GC;
                    }
                } else {
                    TbImageView.this.aNC.GB = "net";
                    TbImageView.this.aNC.isSuccess = false;
                    TbImageView.this.aNC.GC = System.currentTimeMillis() - TbImageView.this.aNE;
                }
                TbImageView.this.vW();
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
                if (TbImageView.this.aNp != null) {
                    TbImageView.this.aNp.onCancel();
                }
            }
        };
        this.ams = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        Hx();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNH, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNI, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNJ, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNK, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void Hx() {
                if (TbImageView.aNH == null) {
                    Method unused = TbImageView.aNH = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aNI == null) {
                    Method unused2 = TbImageView.aNI = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aNJ == null) {
                    Method unused3 = TbImageView.aNJ = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aNK == null) {
                    Method unused4 = TbImageView.aNK = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNp = null;
        this.aiM = d.e.transparent;
        this.aNq = d.g.img_default_100;
        this.aNr = this.aiM;
        this.aNs = d.g.img_loading;
        this.aiN = d.e.cp_bg_line_e;
        this.ry = false;
        this.isLongPic = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.aEo = false;
        this.aNC = null;
        this.aND = 3;
        this.aNE = 0L;
        this.aNF = 0;
        this.aNG = 0;
        this.aNL = false;
        this.aNN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.aNz != null) {
                    TbImageView.this.aNz.bb(view);
                    return TbImageView.this.aNz.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.aNA) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.aNz != null) {
                        TbImageView.this.aNz.bb(view);
                        return TbImageView.this.aNz.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.aLf, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.aLf = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                } else {
                    TbImageView.this.aNr = TbImageView.this.aNq;
                }
                if (TbImageView.this.aNp != null) {
                    if (aVar != null) {
                        TbImageView.this.aNF = aVar.getWidth();
                        TbImageView.this.aNG = aVar.getHeight();
                    }
                    TbImageView.this.aNp.s(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gz != null) {
                        TbImageView.this.aNC.GB = aVar.Gz.GB;
                        TbImageView.this.aNC.isSuccess = aVar.Gz.GD;
                        TbImageView.this.aNC.GC = aVar.Gz.GC;
                    }
                } else {
                    TbImageView.this.aNC.GB = "net";
                    TbImageView.this.aNC.isSuccess = false;
                    TbImageView.this.aNC.GC = System.currentTimeMillis() - TbImageView.this.aNE;
                }
                TbImageView.this.vW();
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
                if (TbImageView.this.aNp != null) {
                    TbImageView.this.aNp.onCancel();
                }
            }
        };
        this.ams = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        Hx();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNH, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNI, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNJ, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.aNK, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void Hx() {
                if (TbImageView.aNH == null) {
                    Method unused = TbImageView.aNH = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.aNI == null) {
                    Method unused2 = TbImageView.aNI = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.aNJ == null) {
                    Method unused3 = TbImageView.aNJ = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.aNK == null) {
                    Method unused4 = TbImageView.aNK = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.aNM = new d(this);
        Hs();
        this.aNv = 30.0f;
        this.aNC = new l();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.Bn = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.Bn = true;
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
                com.baidu.adp.widget.ImageView.a gh = com.baidu.tbadk.imageManager.c.DT().gh(str);
                aVar = gh == null ? com.baidu.tbadk.imageManager.c.DT().gg(str) : gh;
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
        if (aNw == null) {
            aNw = new HashMap<>();
        }
        String valueOf = String.valueOf(this.aNt);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.aND != TbadkCoreApplication.getInst().getSkinType()) {
            this.Bn = true;
            this.aND = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!aNw.containsKey(str) || (softReference = aNw.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kO()) {
            Bitmap bitmap = null;
            if (this.aNt > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = aj.cQ(this.aNt);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.aNt);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.aNt);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(this.aNt);
                }
            }
            com.baidu.adp.widget.ImageView.a aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, false, String.valueOf(this.aNt));
            aNw.put(str, new SoftReference<>(aVar2));
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
        this.aNr = this.aiM;
        if (TextUtils.isEmpty(str)) {
            this.aNr = this.aNq;
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            DO();
            this.Bn = true;
            this.ry = false;
            requestLayout();
        } else if (getBdImage() != null) {
            this.aNC.GB = "memory";
            this.aNC.isSuccess = true;
            this.aNC.GC = 0L;
            invalidate();
            if (this.aNp != null) {
                this.aNp.s(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.Bn = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fJ().ao(this.mType) && this.aEo) {
            invalidate();
        } else if (z3 && !j.hh()) {
            this.aNC.GB = "memory";
            this.aNC.isSuccess = false;
            this.aNC.GC = 0L;
            this.aNr = this.aNq;
            invalidate();
            if (this.aNp != null) {
                this.aNp.s(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.aNE = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aLf, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void DO() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aLf);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (this.mPageId != null) {
            this.aNL = true;
        }
        if (Y != null) {
            this.ams.setTag(this.mPageId != null ? this.mPageId : Y.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.ams);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aNL = false;
        DO();
        MessageManager.getInstance().unRegisterListener(this.ams);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DO();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Hs();
        super.onDraw(canvas);
    }

    @Override // com.baidu.adp.b.a.b
    public void c(Canvas canvas, ImageView imageView) {
        super.c(canvas, imageView);
        if (this.aNM != null && this.Bd != null) {
            if (this.Bd.BG && isGif()) {
                this.aNM.c(canvas, getContext().getString(d.l.icon_tag_gif));
            } else if (this.Bd.BF && isLongPic()) {
                this.aNM.c(canvas, getContext().getString(d.l.icon_tag_long));
            }
        }
    }

    public void N(int i, int i2) {
        if (this.aNM != null) {
            this.aNM.R(i, i2);
        }
    }

    public boolean isGif() {
        return this.ry;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public void setIsLongPic(boolean z) {
        this.isLongPic = z;
    }

    public void startLoading() {
        this.aNy = true;
        DN();
    }

    public void stopLoading() {
        this.aNy = false;
        removeCallbacks(this);
        this.aEa = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void DN() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aNy) {
            this.aEa += this.aNv;
            if (this.aEa > 360.0f - this.aNv) {
                this.aEa = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.aEa, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            DN();
        }
    }

    private void Hs() {
        if (this.mAutoChangeStyle) {
            this.Bd.BD = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.Bd.BD = false;
        }
        int i = this.aNt;
        int i2 = this.aNy ? this.aNs : this.aiM;
        if (i2 != this.aNt) {
            this.aNt = i2;
            this.Bn = true;
        }
        this.aNu = this.aiN;
        if (this.aNu > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(aj.getDrawable(this.aNu));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.aNu));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.aiM != i) {
            this.aiM = i;
            this.aNr = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.aNq = i;
    }

    public void setDefaultBgResource(int i) {
        if (this.aiN != i) {
            this.aiN = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.aNL && this.mPageId != null) {
            this.ams.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.ams);
            this.aNL = true;
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
        this.ry = false;
        this.isLongPic = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.aNN);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.aNN);
        this.aNz = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.aNA = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.aNA) {
            startLoading();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.aLf, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.aNM != null) {
            return (int) this.aNM.gU(getContext().getString(d.l.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.aNM != null) {
            return (int) this.aNM.gT(getContext().getString(d.l.icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.aEo = z;
    }

    public l getPerfLog() {
        return this.aNC;
    }

    public void vW() {
        if (!this.aNx) {
            this.aNx = true;
        } else if (this.aNC != null && this.aNC.aIQ) {
            this.aNC.FQ();
        }
    }

    @Override // com.baidu.adp.b.a.b
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void O(int i, int i2) {
        if (this.aNM != null) {
            this.aNM.O(i, i2);
        }
    }

    public void setTagTextSize(int i) {
        if (this.aNM != null) {
            this.aNM.setTagTextSize(i);
        }
    }
}
