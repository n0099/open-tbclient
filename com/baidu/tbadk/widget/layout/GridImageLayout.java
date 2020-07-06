package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GridImageLayout extends RelativeLayout {
    private View.OnClickListener ahw;
    private TbImageView.c ais;
    private Paint eKJ;
    private int eKK;
    private int eLk;
    private com.baidu.adp.lib.d.b<ImageView> eLl;
    private com.baidu.adp.lib.d.b<GifView> eLm;
    private com.baidu.tbadk.widget.richText.a eLn;
    private ArrayList<TbRichTextImageInfo> eLo;
    private int eLp;
    private String eLq;
    private RectF eLr;
    private int eLs;
    private boolean eLt;
    private int eLu;
    private int[] eLv;
    private TbRichTextView.i eLw;
    private Paint mBitmapPaint;
    private int mImageHeight;
    private int mImageWidth;
    private boolean mIsHost;
    private Bitmap mMaskBitmap;
    private View.OnClickListener mOnClickListener;
    private View.OnLongClickListener mOnLongClickListener;
    private int mSize;
    private int textHeight;
    private Paint textPaint;

    public GridImageLayout(Context context) {
        super(context);
        this.eLk = 0;
        this.eLl = null;
        this.eLm = null;
        this.textHeight = 0;
        this.eLt = true;
        this.eLv = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.eLw != null && GridImageLayout.this.eLo != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.eLw.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.ahw != null) {
                    GridImageLayout.this.ahw.onClick(view);
                }
            }
        };
        this.ais = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yO = com.baidu.tbadk.imageManager.c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.eLu));
                    if (yO != null) {
                        i = yO.getWidth();
                        i2 = yO.getHeight();
                    } else {
                        i = 0;
                    }
                    if (i != 0 && i2 != 0) {
                        int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i * height > width * i2) {
                                f = height / i2;
                            } else {
                                f = width / i;
                            }
                            imageMatrix.setScale(f, f);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLk = 0;
        this.eLl = null;
        this.eLm = null;
        this.textHeight = 0;
        this.eLt = true;
        this.eLv = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.eLw != null && GridImageLayout.this.eLo != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.eLw.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.ahw != null) {
                    GridImageLayout.this.ahw.onClick(view);
                }
            }
        };
        this.ais = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yO = com.baidu.tbadk.imageManager.c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.eLu));
                    if (yO != null) {
                        i = yO.getWidth();
                        i2 = yO.getHeight();
                    } else {
                        i = 0;
                    }
                    if (i != 0 && i2 != 0) {
                        int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i * height > width * i2) {
                                f = height / i2;
                            } else {
                                f = width / i;
                            }
                            imageMatrix.setScale(f, f);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eLk = 0;
        this.eLl = null;
        this.eLm = null;
        this.textHeight = 0;
        this.eLt = true;
        this.eLv = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.eLw != null && GridImageLayout.this.eLo != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.eLw.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.ahw != null) {
                    GridImageLayout.this.ahw.onClick(view);
                }
            }
        };
        this.ais = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                float f;
                int i22 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yO = com.baidu.tbadk.imageManager.c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.eLu));
                    if (yO != null) {
                        i2 = yO.getWidth();
                        i22 = yO.getHeight();
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0 && i22 != 0) {
                        int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width * i22) {
                                f = height / i22;
                            } else {
                                f = width / i2;
                            }
                            imageMatrix.setScale(f, f);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    private void init() {
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.eKJ = new Paint();
        this.eKJ.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(an.getColor(R.color.cp_cont_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.eKK = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.eLs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.eLn = aVar;
        if (this.eLn != null) {
            this.eLp = this.eLn.eNA;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.eLl = bVar;
        this.eLm = bVar2;
    }

    public void setCornerStyle(int i) {
        this.eLk = i;
    }

    public void clearData() {
        this.eLo = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!w.isEmpty(arrayList) && !I(arrayList) && this.eLn != null) {
            this.eLo = arrayList;
            this.mSize = arrayList.size();
            this.eLq = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            bkA();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!ar.isEmpty(this.eLq) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.eLr == null) {
                    this.eLr = new RectF();
                }
                this.eLr.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.eLr, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
            }
        }
    }

    private void a(Canvas canvas, RectF rectF, float f) {
        if (rectF != null) {
            if (this.mMaskBitmap == null || this.mMaskBitmap.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.mMaskBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.mMaskBitmap);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-f, 0.0f, i, i2);
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawRoundRect(rectF2, f, f, this.mBitmapPaint);
            }
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.eKJ);
            canvas.drawText(this.eLq, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.eLq)) / 2), (((int) rectF.centerY()) + (this.textHeight / 2)) - this.eKK, this.textPaint);
        }
    }

    private boolean I(ArrayList<TbRichTextImageInfo> arrayList) {
        return w.equalList(this.eLo, arrayList);
    }

    private void bkA() {
        if (!w.isEmpty(this.eLo)) {
            removeAllViews();
            bkD();
            if (this.mImageWidth > 0 && this.mImageHeight > 0) {
                if (this.mSize == 1) {
                    bkB();
                } else {
                    bkC();
                }
            }
        }
    }

    private void bkB() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!w.isEmpty(this.eLo) && (tbRichTextImageInfo = this.eLo.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (width > 0 && height > 0) {
                if (this.eLt && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.blp()) {
                    a(0, tbRichTextImageInfo);
                } else {
                    b(0, tbRichTextImageInfo);
                }
            }
        }
    }

    private void bkC() {
        if (!w.isEmpty(this.eLo)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.eLo.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (width > 0 && height > 0) {
                            if (this.eLt && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.blp()) {
                                a(i2, tbRichTextImageInfo);
                            } else {
                                b(i2, tbRichTextImageInfo);
                            }
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        if (tbRichTextImageInfo != null && this.eLn != null) {
            GifView borrowObject = this.eLm != null ? this.eLm.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new GifView(getContext());
            }
            borrowObject.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            borrowObject.setBorderColor(an.getColor(R.color.cp_border_a));
            borrowObject.setBorderSurroundContent(true);
            borrowObject.setDrawCorner(true);
            borrowObject.setDrawBorder(true);
            borrowObject.setRadius(this.eLs);
            borrowObject.setOnClickListener(this.mOnClickListener);
            if (this.mOnLongClickListener != null) {
                borrowObject.setOnLongClickListener(this.mOnLongClickListener);
            }
            borrowObject.setOnDrawListener(null);
            if (this.mSize == 1) {
                borrowObject.setPlaceHolder(3);
                borrowObject.setScaleType(ImageView.ScaleType.MATRIX);
                borrowObject.setOnDrawListener(this.ais);
            } else {
                borrowObject.setPlaceHolder(2);
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            borrowObject.setIsLongPic(tbRichTextImageInfo.blp());
            if (i == 8 && !ar.isEmpty(this.eLq)) {
                borrowObject.setLongIconSupport(false);
                borrowObject.setGifIconSupport(false);
            } else {
                borrowObject.setLongIconSupport(true);
                borrowObject.setGifIconSupport(true);
            }
            if (this.eLn.eNn) {
                borrowObject.setSupportNoImage(true);
            }
            borrowObject.setDefaultNoImageDay(an.lr(R.drawable.icon_click));
            String bll = tbRichTextImageInfo.bll();
            if (StringUtils.isNull(bll)) {
                if (this.eLn.bkO()) {
                    bll = this.eLn.mIsFromCDN ? tbRichTextImageInfo.blh() : tbRichTextImageInfo.blj();
                }
                if (StringUtils.isNull(bll)) {
                    bll = this.eLn.mIsFromCDN ? tbRichTextImageInfo.blk() : tbRichTextImageInfo.getSrc();
                }
            }
            borrowObject.setShowStaticDrawable(false);
            this.eLu = 38;
            borrowObject.ao(bll, this.eLu);
            b(borrowObject, i);
        }
    }

    private void b(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.eLn != null) {
            ImageView borrowObject = this.eLl != null ? this.eLl.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new TbImageView(getContext());
            }
            if (borrowObject instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) borrowObject;
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(an.getColor(R.color.cp_border_a));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawCorner(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setRadius(this.eLs);
                tbImageView.setOnClickListener(this.mOnClickListener);
                if (this.mOnLongClickListener != null) {
                    tbImageView.setOnLongClickListener(this.mOnLongClickListener);
                }
                tbImageView.setOnDrawListener(null);
                if (this.mSize == 1) {
                    tbImageView.setPlaceHolder(3);
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setOnDrawListener(this.ais);
                } else {
                    tbImageView.setPlaceHolder(2);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.blp());
                if (i == 8 && !ar.isEmpty(this.eLq)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.eLn.eNn) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.eLt) {
                    str = tbRichTextImageInfo.getSrc();
                    String bln = tbRichTextImageInfo.bln();
                    if (!TextUtils.isEmpty(bln) && bln.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    this.eLu = 13;
                } else {
                    if (this.eLn.bkO()) {
                        str = this.eLn.mIsFromCDN ? tbRichTextImageInfo.blh() : tbRichTextImageInfo.blj();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.eLn.mIsFromCDN ? tbRichTextImageInfo.blk() : tbRichTextImageInfo.getSrc();
                    }
                    this.eLu = this.eLn.mIsFromCDN ? 13 : 14;
                }
                tbImageView.startLoad(str, this.eLu, false);
                if (!tbRichTextImageInfo.blm()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                b(tbImageView, i);
            }
        }
    }

    private void b(TbImageView tbImageView, int i) {
        if (tbImageView != null && this.eLn != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            a(tbImageView, i, layoutParams);
            addView(tbImageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.eLv[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int bd = bd(i2, i3 - 1);
            int bd2 = bd(i4, i3);
            if (bd2 >= 0) {
                layoutParams.addRule(3, bd2);
                layoutParams.topMargin = this.eLp;
            }
            if (bd >= 0) {
                layoutParams.addRule(1, bd);
                layoutParams.leftMargin = this.eLp;
            }
            j(imageView, 15);
        }
    }

    private int bd(int i, int i2) {
        if (be(i, i2)) {
            return this.eLv[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean be(int i, int i2) {
        if (this.mSize == 4) {
            return i >= 0 && i < 2 && i2 >= 0 && i2 < 2;
        }
        return i >= 0 && i < 3 && i2 >= 0 && i2 < 3 && (i * 3) + i2 <= (this.mSize <= 9 ? this.mSize + (-1) : 8);
    }

    private void j(View view, int i) {
        if (view instanceof TbImageView) {
            ((TbImageView) view).setConrers(i);
        } else {
            if (view instanceof GifView) {
            }
        }
    }

    private void bkD() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.eLn != null && !w.isEmpty(this.eLo) && (tbRichTextImageInfo = this.eLo.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                int i = (this.eLn.eNz - (this.eLp * 2)) / 3;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
                if (this.mSize == 1) {
                    if (f >= 2.0f) {
                        this.mImageWidth = (i * 2) + this.eLp;
                        this.mImageHeight = (int) ((i * 1.5d) + this.eLp);
                        return;
                    } else if (f <= 0.5d) {
                        this.mImageWidth = (int) ((i * 1.5d) + this.eLp);
                        this.mImageHeight = (i * 2) + this.eLp;
                        return;
                    } else {
                        this.mImageWidth = (i * 2) + this.eLp;
                        this.mImageHeight = (i * 2) + this.eLp;
                        if (f > 0.0f && f < 1.0f) {
                            this.mImageWidth = (int) (f * this.mImageHeight);
                            return;
                        } else if (f >= 1.0f) {
                            this.mImageHeight = (int) (this.mImageWidth / f);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.mImageWidth = i;
                this.mImageHeight = i;
            }
        }
    }

    public void setSupportGifPlay(boolean z) {
        this.eLt = z;
    }

    public void onChangeSkinType() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i2)).setBorderColor(an.getColor(R.color.cp_border_a));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
