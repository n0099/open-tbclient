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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GridImageLayout extends RelativeLayout {
    private TbImageView.c NU;
    private View.OnClickListener Ni;
    private int dMP;
    private com.baidu.adp.lib.d.b<ImageView> dMQ;
    private com.baidu.adp.lib.d.b<GifView> dMR;
    private com.baidu.tbadk.widget.richText.a dMS;
    private ArrayList<TbRichTextImageInfo> dMT;
    private int dMU;
    private String dMV;
    private RectF dMW;
    private int dMX;
    private boolean dMY;
    private int dMZ;
    private Paint dMo;
    private int dMp;
    private int[] dNa;
    private TbRichTextView.i dNb;
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
        this.dMP = 0;
        this.dMQ = null;
        this.dMR = null;
        this.textHeight = 0;
        this.dMY = true;
        this.dNa = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.dNb != null && GridImageLayout.this.dMT != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.dNb.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.Ni != null) {
                    GridImageLayout.this.Ni.onClick(view);
                }
            }
        };
        this.NU = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a vy = com.baidu.tbadk.imageManager.c.aPV().vy(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.dMZ));
                    if (vy != null) {
                        i = vy.getWidth();
                        i2 = vy.getHeight();
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
        this.dMP = 0;
        this.dMQ = null;
        this.dMR = null;
        this.textHeight = 0;
        this.dMY = true;
        this.dNa = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.dNb != null && GridImageLayout.this.dMT != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.dNb.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.Ni != null) {
                    GridImageLayout.this.Ni.onClick(view);
                }
            }
        };
        this.NU = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a vy = com.baidu.tbadk.imageManager.c.aPV().vy(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.dMZ));
                    if (vy != null) {
                        i = vy.getWidth();
                        i2 = vy.getHeight();
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
        this.dMP = 0;
        this.dMQ = null;
        this.dMR = null;
        this.textHeight = 0;
        this.dMY = true;
        this.dNa = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.dNb != null && GridImageLayout.this.dMT != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.dNb.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.Ni != null) {
                    GridImageLayout.this.Ni.onClick(view);
                }
            }
        };
        this.NU = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                float f;
                int i22 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a vy = com.baidu.tbadk.imageManager.c.aPV().vy(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.dMZ));
                    if (vy != null) {
                        i2 = vy.getWidth();
                        i22 = vy.getHeight();
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
        this.dMo = new Paint();
        this.dMo.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(am.getColor(R.color.cp_cont_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.dMp = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.dMX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dNb = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Ni = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.dMS = aVar;
        if (this.dMS != null) {
            this.dMU = this.dMS.dOE;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.dMQ = bVar;
        this.dMR = bVar2;
    }

    public void setCornerStyle(int i) {
        this.dMP = i;
    }

    public void clearData() {
        this.dMT = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!v.isEmpty(arrayList) && !I(arrayList) && this.dMS != null) {
            this.dMT = arrayList;
            this.mSize = arrayList.size();
            this.dMV = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            aTI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!aq.isEmpty(this.dMV) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.dMW == null) {
                    this.dMW = new RectF();
                }
                this.dMW.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.dMW, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
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
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.dMo);
            canvas.drawText(this.dMV, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.dMV)) / 2), (((int) rectF.centerY()) + (this.textHeight / 2)) - this.dMp, this.textPaint);
        }
    }

    private boolean I(ArrayList<TbRichTextImageInfo> arrayList) {
        return v.equalList(this.dMT, arrayList);
    }

    private void aTI() {
        if (!v.isEmpty(this.dMT)) {
            removeAllViews();
            aTL();
            if (this.mImageWidth > 0 && this.mImageHeight > 0) {
                if (this.mSize == 1) {
                    aTJ();
                } else {
                    aTK();
                }
            }
        }
    }

    private void aTJ() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!v.isEmpty(this.dMT) && (tbRichTextImageInfo = this.dMT.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (width > 0 && height > 0) {
                if (this.dMY && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.aUv()) {
                    a(0, tbRichTextImageInfo);
                } else {
                    b(0, tbRichTextImageInfo);
                }
            }
        }
    }

    private void aTK() {
        if (!v.isEmpty(this.dMT)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.dMT.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (width > 0 && height > 0) {
                            if (this.dMY && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.aUv()) {
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
        if (tbRichTextImageInfo != null && this.dMS != null) {
            GifView borrowObject = this.dMR != null ? this.dMR.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new GifView(getContext());
            }
            borrowObject.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            borrowObject.setBorderColor(am.getColor(R.color.cp_border_a));
            borrowObject.setBorderSurroundContent(true);
            borrowObject.setDrawCorner(true);
            borrowObject.setDrawBorder(true);
            borrowObject.setRadius(this.dMX);
            borrowObject.setOnClickListener(this.mOnClickListener);
            if (this.mOnLongClickListener != null) {
                borrowObject.setOnLongClickListener(this.mOnLongClickListener);
            }
            borrowObject.setOnDrawListener(null);
            if (this.mSize == 1) {
                borrowObject.setPlaceHolder(3);
                borrowObject.setScaleType(ImageView.ScaleType.MATRIX);
                borrowObject.setOnDrawListener(this.NU);
            } else {
                borrowObject.setPlaceHolder(2);
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            borrowObject.setIsLongPic(tbRichTextImageInfo.aUv());
            if (i == 8 && !aq.isEmpty(this.dMV)) {
                borrowObject.setLongIconSupport(false);
                borrowObject.setGifIconSupport(false);
            } else {
                borrowObject.setLongIconSupport(true);
                borrowObject.setGifIconSupport(true);
            }
            if (this.dMS.dOs) {
                borrowObject.setSupportNoImage(true);
            }
            borrowObject.setDefaultNoImageDay(am.ku(R.drawable.icon_click));
            String aUr = tbRichTextImageInfo.aUr();
            if (StringUtils.isNull(aUr)) {
                if (this.dMS.aTW()) {
                    aUr = this.dMS.mIsFromCDN ? tbRichTextImageInfo.aUn() : tbRichTextImageInfo.aUp();
                }
                if (StringUtils.isNull(aUr)) {
                    aUr = this.dMS.mIsFromCDN ? tbRichTextImageInfo.aUq() : tbRichTextImageInfo.getSrc();
                }
            }
            borrowObject.setShowStaticDrawable(false);
            this.dMZ = 38;
            borrowObject.ae(aUr, this.dMZ);
            b(borrowObject, i);
        }
    }

    private void b(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.dMS != null) {
            ImageView borrowObject = this.dMQ != null ? this.dMQ.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new TbImageView(getContext());
            }
            if (borrowObject instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) borrowObject;
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawCorner(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setRadius(this.dMX);
                tbImageView.setOnClickListener(this.mOnClickListener);
                if (this.mOnLongClickListener != null) {
                    tbImageView.setOnLongClickListener(this.mOnLongClickListener);
                }
                tbImageView.setOnDrawListener(null);
                if (this.mSize == 1) {
                    tbImageView.setPlaceHolder(3);
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setOnDrawListener(this.NU);
                } else {
                    tbImageView.setPlaceHolder(2);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.aUv());
                if (i == 8 && !aq.isEmpty(this.dMV)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.dMS.dOs) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.dMY) {
                    str = tbRichTextImageInfo.getSrc();
                    String aUt = tbRichTextImageInfo.aUt();
                    if (!TextUtils.isEmpty(aUt) && aUt.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    this.dMZ = 13;
                } else {
                    if (this.dMS.aTW()) {
                        str = this.dMS.mIsFromCDN ? tbRichTextImageInfo.aUn() : tbRichTextImageInfo.aUp();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.dMS.mIsFromCDN ? tbRichTextImageInfo.aUq() : tbRichTextImageInfo.getSrc();
                    }
                    this.dMZ = this.dMS.mIsFromCDN ? 13 : 14;
                }
                tbImageView.startLoad(str, this.dMZ, false);
                if (!tbRichTextImageInfo.aUs()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                b(tbImageView, i);
            }
        }
    }

    private void b(TbImageView tbImageView, int i) {
        if (tbImageView != null && this.dMS != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            a(tbImageView, i, layoutParams);
            addView(tbImageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.dNa[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int aR = aR(i2, i3 - 1);
            int aR2 = aR(i4, i3);
            if (aR2 >= 0) {
                layoutParams.addRule(3, aR2);
                layoutParams.topMargin = this.dMU;
            }
            if (aR >= 0) {
                layoutParams.addRule(1, aR);
                layoutParams.leftMargin = this.dMU;
            }
            j(imageView, 15);
        }
    }

    private int aR(int i, int i2) {
        if (aS(i, i2)) {
            return this.dNa[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean aS(int i, int i2) {
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

    private void aTL() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.dMS != null && !v.isEmpty(this.dMT) && (tbRichTextImageInfo = this.dMT.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                int i = (this.dMS.dOD - (this.dMU * 2)) / 3;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
                if (this.mSize == 1) {
                    if (f >= 2.0f) {
                        this.mImageWidth = (i * 2) + this.dMU;
                        this.mImageHeight = (int) ((i * 1.5d) + this.dMU);
                        return;
                    } else if (f <= 0.5d) {
                        this.mImageWidth = (int) ((i * 1.5d) + this.dMU);
                        this.mImageHeight = (i * 2) + this.dMU;
                        return;
                    } else {
                        this.mImageWidth = (i * 2) + this.dMU;
                        this.mImageHeight = (i * 2) + this.dMU;
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
        this.dMY = z;
    }

    public void onChangeSkinType() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i2)).setBorderColor(am.getColor(R.color.cp_border_a));
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
