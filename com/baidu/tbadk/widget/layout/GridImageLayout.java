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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GridImageLayout extends RelativeLayout {
    private View.OnClickListener aju;
    private TbImageView.c akv;
    private Paint fEM;
    private int fEN;
    private int fFm;
    private com.baidu.adp.lib.d.b<ImageView> fFn;
    private com.baidu.adp.lib.d.b<GifView> fFo;
    private com.baidu.tbadk.widget.richText.a fFp;
    private ArrayList<TbRichTextImageInfo> fFq;
    private int fFr;
    private String fFs;
    private RectF fFt;
    private boolean fFu;
    private int fFv;
    private boolean fFw;
    private int[] fFx;
    private TbRichTextView.i fFy;
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
        this.fFm = 0;
        this.fFn = null;
        this.fFo = null;
        this.textHeight = 0;
        this.fFu = true;
        this.fFw = false;
        this.fFx = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fFy != null && GridImageLayout.this.fFq != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fFy.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.aju != null) {
                    GridImageLayout.this.aju.onClick(view);
                }
            }
        };
        this.akv = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a DA = com.baidu.tbadk.imageManager.c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fFv));
                    if (DA != null) {
                        i = DA.getWidth();
                        i2 = DA.getHeight();
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
        this.fFm = 0;
        this.fFn = null;
        this.fFo = null;
        this.textHeight = 0;
        this.fFu = true;
        this.fFw = false;
        this.fFx = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fFy != null && GridImageLayout.this.fFq != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fFy.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.aju != null) {
                    GridImageLayout.this.aju.onClick(view);
                }
            }
        };
        this.akv = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a DA = com.baidu.tbadk.imageManager.c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fFv));
                    if (DA != null) {
                        i = DA.getWidth();
                        i2 = DA.getHeight();
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
        this.fFm = 0;
        this.fFn = null;
        this.fFo = null;
        this.textHeight = 0;
        this.fFu = true;
        this.fFw = false;
        this.fFx = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fFy != null && GridImageLayout.this.fFq != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fFy.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.aju != null) {
                    GridImageLayout.this.aju.onClick(view);
                }
            }
        };
        this.akv = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                float f;
                int i22 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a DA = com.baidu.tbadk.imageManager.c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fFv));
                    if (DA != null) {
                        i2 = DA.getWidth();
                        i22 = DA.getHeight();
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
        this.fEM = new Paint();
        this.fEM.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(ap.getColor(R.color.CAM_X0101));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.fEN = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.fFp = aVar;
        if (this.fFp != null) {
            this.fFr = this.fFp.fHD;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.fFn = bVar;
        this.fFo = bVar2;
    }

    public void setCornerStyle(int i) {
        this.fFm = i;
    }

    public void clearData() {
        this.fFq = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!y.isEmpty(arrayList) && !P(arrayList) && this.fFp != null) {
            this.fFq = arrayList;
            this.mSize = arrayList.size();
            this.fFs = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            bEM();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!au.isEmpty(this.fFs) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.fFt == null) {
                    this.fFt = new RectF();
                }
                this.fFt.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.fFt, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
            }
        }
    }

    private void a(Canvas canvas, RectF rectF, float[] fArr) {
        if (rectF != null) {
            if (this.mMaskBitmap == null || this.mMaskBitmap.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.mMaskBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.mMaskBitmap);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-fArr[0], 0.0f, i, i2);
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawPath(com.baidu.tbadk.core.elementsMaven.a.b.a(rectF2, fArr), this.mBitmapPaint);
            }
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.fEM);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            int dimenPixelSize2 = ((int) rectF.right) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int i3 = ((int) rectF.bottom) - dimenPixelSize;
            int measureText = dimenPixelSize2 - ((int) this.textPaint.measureText(this.fFs));
            float[] oJ = com.baidu.tbadk.core.elementsMaven.a.oJ(R.array.S_O_X001);
            this.textPaint.setShadowLayer(oJ[1], oJ[2], oJ[3], (int) oJ[0]);
            canvas.drawText(this.fFs, measureText, i3, this.textPaint);
        }
    }

    private boolean P(ArrayList<TbRichTextImageInfo> arrayList) {
        return y.equalList(this.fFq, arrayList);
    }

    private void bEM() {
        if (!y.isEmpty(this.fFq)) {
            removeAllViews();
            bEP();
            if (this.mImageWidth > 0 && this.mImageHeight > 0) {
                if (this.mSize == 1) {
                    bEN();
                } else {
                    bEO();
                }
            }
        }
    }

    private void bEN() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!y.isEmpty(this.fFq) && (tbRichTextImageInfo = this.fFq.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (width > 0 && height > 0) {
                if (this.fFu && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bFC()) {
                    a(0, tbRichTextImageInfo);
                } else {
                    b(0, tbRichTextImageInfo);
                }
            }
        }
    }

    private void bEO() {
        if (!y.isEmpty(this.fFq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.fFq.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (width > 0 && height > 0) {
                            if (this.fFu && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bFC()) {
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
        if (tbRichTextImageInfo != null && this.fFp != null) {
            GifView borrowObject = this.fFo != null ? this.fFo.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new GifView(getContext());
            }
            borrowObject.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            borrowObject.setBorderColor(ap.getColor(R.color.CAM_X0401));
            borrowObject.setBorderSurroundContent(true);
            borrowObject.setDrawCorner(true);
            borrowObject.setDrawBorder(true);
            borrowObject.setRadiusById(R.string.J_X05);
            borrowObject.setOnClickListener(this.mOnClickListener);
            if (this.mOnLongClickListener != null) {
                borrowObject.setOnLongClickListener(this.mOnLongClickListener);
            }
            borrowObject.setOnDrawListener(null);
            if (this.mSize == 1) {
                borrowObject.setPlaceHolder(3);
                borrowObject.setScaleType(ImageView.ScaleType.MATRIX);
                borrowObject.setOnDrawListener(this.akv);
            } else {
                borrowObject.setPlaceHolder(2);
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            borrowObject.setIsLongPic(tbRichTextImageInfo.bFC());
            if (i == 8 && !au.isEmpty(this.fFs)) {
                borrowObject.setLongIconSupport(false);
                borrowObject.setGifIconSupport(false);
            } else {
                borrowObject.setLongIconSupport(true);
                borrowObject.setGifIconSupport(true);
            }
            if (this.fFp.fHq) {
                borrowObject.setSupportNoImage(true);
            }
            borrowObject.setDefaultNoImageDay(ap.ps(R.drawable.icon_click));
            String bFy = tbRichTextImageInfo.bFy();
            if (StringUtils.isNull(bFy)) {
                if (this.fFp.bFa()) {
                    bFy = this.fFp.mIsFromCDN ? tbRichTextImageInfo.bFu() : tbRichTextImageInfo.bFw();
                }
                if (StringUtils.isNull(bFy)) {
                    bFy = this.fFp.mIsFromCDN ? tbRichTextImageInfo.bFx() : tbRichTextImageInfo.getSrc();
                }
            }
            borrowObject.setShowStaticDrawable(false);
            this.fFv = 38;
            borrowObject.au(bFy, this.fFv);
            a(borrowObject, i);
        }
    }

    private void b(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.fFp != null) {
            ImageView borrowObject = this.fFn != null ? this.fFn.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new TbImageView(getContext());
            }
            if (borrowObject instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) borrowObject;
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawCorner(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setRadiusById(R.string.J_X05);
                tbImageView.setOnClickListener(this.mOnClickListener);
                if (this.mOnLongClickListener != null) {
                    tbImageView.setOnLongClickListener(this.mOnLongClickListener);
                }
                tbImageView.setOnDrawListener(null);
                if (this.mSize == 1) {
                    tbImageView.setPlaceHolder(3);
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setOnDrawListener(this.akv);
                } else {
                    tbImageView.setPlaceHolder(2);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.bFC());
                if (i == 8 && !au.isEmpty(this.fFs)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.fFp.fHq) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.fFu) {
                    str = tbRichTextImageInfo.getSrc();
                    String bFA = tbRichTextImageInfo.bFA();
                    if (!TextUtils.isEmpty(bFA) && bFA.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    this.fFv = 13;
                } else {
                    if (this.fFp.bFa()) {
                        str = this.fFp.mIsFromCDN ? tbRichTextImageInfo.bFu() : tbRichTextImageInfo.bFw();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.fFp.mIsFromCDN ? tbRichTextImageInfo.bFx() : tbRichTextImageInfo.getSrc();
                    }
                    this.fFv = this.fFp.mIsFromCDN ? 13 : 14;
                }
                tbImageView.startLoad(str, this.fFv, false);
                if (!tbRichTextImageInfo.bFz()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                a(tbImageView, i);
            }
        }
    }

    private void a(TbImageView tbImageView, int i) {
        if (tbImageView != null && this.fFp != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            a(tbImageView, i, layoutParams);
            addView(tbImageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.fFx[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int bp = bp(i2, i3 - 1);
            int bp2 = bp(i4, i3);
            if (bp2 >= 0) {
                layoutParams.addRule(3, bp2);
                layoutParams.topMargin = this.fFr;
            }
            if (bp >= 0) {
                layoutParams.addRule(1, bp);
                layoutParams.leftMargin = this.fFr;
            }
            setTransformStyle(imageView, i);
        }
    }

    public void setTransformStyle(ImageView imageView, int i) {
        if (this.mSize == 1) {
            p(imageView, 15);
        } else if (this.mSize == 2) {
            if (i == 0) {
                p(imageView, 5);
            } else if (i == 1) {
                p(imageView, 10);
            }
        } else if (this.mSize == 3) {
            if (i == 0) {
                p(imageView, 5);
            } else if (i == 2) {
                p(imageView, 10);
            }
        } else if (this.mSize == 4) {
            if (i == 0) {
                p(imageView, 1);
            } else if (i == 1) {
                p(imageView, 2);
            } else if (i == 2) {
                p(imageView, 4);
            } else if (i == 3) {
                p(imageView, 8);
            }
        } else if (this.mSize == 5) {
            if (i == 0) {
                p(imageView, 1);
            } else if (i == 2) {
                p(imageView, 2);
            } else if (i == 3) {
                p(imageView, 4);
            }
        } else if (this.mSize == 6) {
            if (i == 0) {
                p(imageView, 1);
            } else if (i == 2) {
                p(imageView, 2);
            } else if (i == 3) {
                p(imageView, 4);
            } else if (i == 5) {
                p(imageView, 8);
            }
        } else if (this.mSize == 7 || this.mSize == 8) {
            if (i == 0) {
                p(imageView, 1);
            } else if (i == 2) {
                p(imageView, 2);
            } else if (i == 6) {
                p(imageView, 4);
            }
        } else if (this.mSize >= 9) {
            if (i == 0) {
                p(imageView, 1);
            } else if (i == 2) {
                p(imageView, 2);
            } else if (i == 6) {
                p(imageView, 4);
            } else if (i == 8) {
                p(imageView, 8);
            }
        } else {
            p(imageView, 15);
        }
    }

    private int bp(int i, int i2) {
        if (bq(i, i2)) {
            return this.fFx[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean bq(int i, int i2) {
        if (this.mSize == 4) {
            return i >= 0 && i < 2 && i2 >= 0 && i2 < 2;
        }
        return i >= 0 && i < 3 && i2 >= 0 && i2 < 3 && (i * 3) + i2 <= (this.mSize <= 9 ? this.mSize + (-1) : 8);
    }

    private void p(View view, int i) {
        if (view instanceof TbImageView) {
            ((TbImageView) view).setConrers(i);
        } else {
            if (view instanceof GifView) {
            }
        }
    }

    private void bEP() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.fFp != null && !y.isEmpty(this.fFq) && (tbRichTextImageInfo = this.fFq.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                int i = (this.fFp.fHC - (this.fFr * 2)) / 3;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
                if (this.mSize == 1) {
                    if (f >= 2.0f) {
                        this.mImageWidth = (i * 2) + this.fFr;
                        this.mImageHeight = (int) ((i * 1.5d) + this.fFr);
                        return;
                    } else if (f <= 0.5d) {
                        this.mImageWidth = (int) ((i * 1.5d) + this.fFr);
                        this.mImageHeight = (i * 2) + this.fFr;
                        return;
                    } else {
                        this.mImageWidth = (i * 2) + this.fFr;
                        this.mImageHeight = (i * 2) + this.fFr;
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
        this.fFu = z;
    }

    public void onChangeSkinType() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i2)).setBorderColor(ap.getColor(R.color.CAM_X0401));
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

    public void setIsTransform(boolean z) {
        this.fFw = z;
    }
}
