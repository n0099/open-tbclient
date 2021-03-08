package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
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
    private View.OnClickListener alm;
    private TbImageView.c amp;
    private Bitmap anw;
    private int fVK;
    private com.baidu.adp.lib.d.b<ImageView> fVL;
    private com.baidu.adp.lib.d.b<GifView> fVM;
    private com.baidu.tbadk.widget.richText.a fVN;
    private ArrayList<TbRichTextImageInfo> fVO;
    private int fVP;
    private String fVQ;
    private RectF fVR;
    private boolean fVS;
    private int fVT;
    private boolean fVU;
    private int[] fVV;
    private TbRichTextView.i fVW;
    private Paint fVk;
    private int fVl;
    private Paint mBitmapPaint;
    private int mImageHeight;
    private int mImageWidth;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private View.OnLongClickListener mOnLongClickListener;
    private int mSize;
    private int textHeight;
    private Paint textPaint;

    public GridImageLayout(Context context) {
        super(context);
        this.fVK = 0;
        this.fVL = null;
        this.fVM = null;
        this.textHeight = 0;
        this.fVS = true;
        this.fVU = false;
        this.fVV = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fVW != null && GridImageLayout.this.fVO != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fVW.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.alm != null) {
                    GridImageLayout.this.alm.onClick(view);
                }
            }
        };
        this.amp = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Dp = com.baidu.tbadk.imageManager.c.bCS().Dp(com.baidu.adp.lib.e.d.mw().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fVT));
                    if (Dp != null) {
                        int width = Dp.getWidth();
                        i = Dp.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f = height / i;
                            } else {
                                f = width2 / i2;
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
        this.fVK = 0;
        this.fVL = null;
        this.fVM = null;
        this.textHeight = 0;
        this.fVS = true;
        this.fVU = false;
        this.fVV = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fVW != null && GridImageLayout.this.fVO != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fVW.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.alm != null) {
                    GridImageLayout.this.alm.onClick(view);
                }
            }
        };
        this.amp = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Dp = com.baidu.tbadk.imageManager.c.bCS().Dp(com.baidu.adp.lib.e.d.mw().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fVT));
                    if (Dp != null) {
                        int width = Dp.getWidth();
                        i = Dp.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f = height / i;
                            } else {
                                f = width2 / i2;
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
        this.fVK = 0;
        this.fVL = null;
        this.fVM = null;
        this.textHeight = 0;
        this.fVS = true;
        this.fVU = false;
        this.fVV = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fVW != null && GridImageLayout.this.fVO != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fVW.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.alm != null) {
                    GridImageLayout.this.alm.onClick(view);
                }
            }
        };
        this.amp = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                int i22;
                float f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Dp = com.baidu.tbadk.imageManager.c.bCS().Dp(com.baidu.adp.lib.e.d.mw().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fVT));
                    if (Dp != null) {
                        int width = Dp.getWidth();
                        i2 = Dp.getHeight();
                        i22 = width;
                    } else {
                        i2 = 0;
                        i22 = 0;
                    }
                    if (i22 != 0 && i2 != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i22 * height > width2 * i2) {
                                f = height / i2;
                            } else {
                                f = width2 / i22;
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
        this.fVk = new Paint();
        this.fVk.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(ap.getColor(R.color.CAM_X0101));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.fVl = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.fVN = aVar;
        if (this.fVN != null) {
            this.fVP = this.fVN.fYa;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.fVL = bVar;
        this.fVM = bVar2;
    }

    public void setCornerStyle(int i) {
        this.fVK = i;
    }

    public void clearData() {
        this.fVO = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!y.isEmpty(arrayList) && !K(arrayList) && this.fVN != null) {
            this.fVO = arrayList;
            this.mSize = arrayList.size();
            this.fVQ = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            bHo();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!au.isEmpty(this.fVQ) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.fVR == null) {
                    this.fVR = new RectF();
                }
                this.fVR.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.fVR, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
            }
        }
    }

    private void a(Canvas canvas, RectF rectF, float[] fArr) {
        if (rectF != null) {
            if (this.anw == null || this.anw.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.anw = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.anw);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-fArr[0], 0.0f, i, i2);
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawPath(com.baidu.tbadk.core.elementsMaven.a.a.a(rectF2, fArr), this.mBitmapPaint);
            }
            canvas.drawBitmap(this.anw, rectF.left, rectF.top, this.fVk);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            int dimenPixelSize2 = ((int) rectF.right) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int i3 = ((int) rectF.bottom) - dimenPixelSize;
            int measureText = dimenPixelSize2 - ((int) this.textPaint.measureText(this.fVQ));
            float[] nP = com.baidu.tbadk.core.elementsMaven.a.nP(R.array.S_O_X001);
            this.textPaint.setShadowLayer(nP[1], nP[2], nP[3], (int) nP[0]);
            canvas.drawText(this.fVQ, measureText, i3, this.textPaint);
        }
    }

    private boolean K(ArrayList<TbRichTextImageInfo> arrayList) {
        return y.equalList(this.fVO, arrayList);
    }

    private void bHo() {
        if (!y.isEmpty(this.fVO)) {
            removeAllViews();
            bHr();
            if (this.mImageWidth > 0 && this.mImageHeight > 0) {
                if (this.mSize == 1) {
                    bHp();
                } else {
                    bHq();
                }
            }
        }
    }

    private void bHp() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!y.isEmpty(this.fVO) && (tbRichTextImageInfo = this.fVO.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (width > 0 && height > 0) {
                if (this.fVS && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bIb()) {
                    a(0, tbRichTextImageInfo);
                } else {
                    b(0, tbRichTextImageInfo);
                }
            }
        }
    }

    private void bHq() {
        if (!y.isEmpty(this.fVO)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.fVO.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (width > 0 && height > 0) {
                            if (this.fVS && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bIb()) {
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
        if (tbRichTextImageInfo != null && this.fVN != null) {
            GifView borrowObject = this.fVM != null ? this.fVM.borrowObject() : null;
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
                borrowObject.setOnDrawListener(this.amp);
            } else {
                borrowObject.setPlaceHolder(2);
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            borrowObject.setIsLongPic(tbRichTextImageInfo.bIb());
            if (i == 8 && !au.isEmpty(this.fVQ)) {
                borrowObject.setLongIconSupport(false);
                borrowObject.setGifIconSupport(false);
            } else {
                borrowObject.setLongIconSupport(true);
                borrowObject.setGifIconSupport(true);
            }
            if (this.fVN.fXN) {
                borrowObject.setSupportNoImage(true);
            }
            borrowObject.setDefaultNoImageDay(ap.oB(R.drawable.icon_click));
            String bHX = tbRichTextImageInfo.bHX();
            if (StringUtils.isNull(bHX)) {
                if (this.fVN.bHC()) {
                    bHX = this.fVN.mIsFromCDN ? tbRichTextImageInfo.bHT() : tbRichTextImageInfo.bHV();
                }
                if (StringUtils.isNull(bHX)) {
                    bHX = this.fVN.mIsFromCDN ? tbRichTextImageInfo.bHW() : tbRichTextImageInfo.getSrc();
                }
            }
            borrowObject.setShowStaticDrawable(false);
            this.fVT = 38;
            borrowObject.az(bHX, this.fVT);
            a(borrowObject, i);
        }
    }

    private void b(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.fVN != null) {
            ImageView borrowObject = this.fVL != null ? this.fVL.borrowObject() : null;
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
                    tbImageView.setOnDrawListener(this.amp);
                } else {
                    tbImageView.setPlaceHolder(2);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.bIb());
                if (i == 8 && !au.isEmpty(this.fVQ)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.fVN.fXN) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.fVS) {
                    str = tbRichTextImageInfo.getSrc();
                    String bHZ = tbRichTextImageInfo.bHZ();
                    if (!TextUtils.isEmpty(bHZ) && bHZ.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    this.fVT = 13;
                } else {
                    if (this.fVN.bHC()) {
                        str = this.fVN.mIsFromCDN ? tbRichTextImageInfo.bHT() : tbRichTextImageInfo.bHV();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.fVN.mIsFromCDN ? tbRichTextImageInfo.bHW() : tbRichTextImageInfo.getSrc();
                    }
                    this.fVT = this.fVN.mIsFromCDN ? 13 : 14;
                }
                tbImageView.startLoad(str, this.fVT, false);
                if (!tbRichTextImageInfo.bHY()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                a(tbImageView, i);
            }
        }
    }

    private void a(TbImageView tbImageView, int i) {
        if (tbImageView != null && this.fVN != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            a(tbImageView, i, layoutParams);
            addView(tbImageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.fVV[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int bm = bm(i2, i3 - 1);
            int bm2 = bm(i4, i3);
            if (bm2 >= 0) {
                layoutParams.addRule(3, bm2);
                layoutParams.topMargin = this.fVP;
            }
            if (bm >= 0) {
                layoutParams.addRule(1, bm);
                layoutParams.leftMargin = this.fVP;
            }
            setTransformStyle(imageView, i);
        }
    }

    public void setTransformStyle(ImageView imageView, int i) {
        if (this.mSize == 1) {
            s(imageView, 15);
        } else if (this.mSize == 2) {
            if (i == 0) {
                s(imageView, 5);
            } else if (i == 1) {
                s(imageView, 10);
            }
        } else if (this.mSize == 3) {
            if (i == 0) {
                s(imageView, 5);
            } else if (i == 2) {
                s(imageView, 10);
            }
        } else if (this.mSize == 4) {
            if (i == 0) {
                s(imageView, 1);
            } else if (i == 1) {
                s(imageView, 2);
            } else if (i == 2) {
                s(imageView, 4);
            } else if (i == 3) {
                s(imageView, 8);
            }
        } else if (this.mSize == 5) {
            if (i == 0) {
                s(imageView, 1);
            } else if (i == 2) {
                s(imageView, 2);
            } else if (i == 3) {
                s(imageView, 4);
            }
        } else if (this.mSize == 6) {
            if (i == 0) {
                s(imageView, 1);
            } else if (i == 2) {
                s(imageView, 2);
            } else if (i == 3) {
                s(imageView, 4);
            } else if (i == 5) {
                s(imageView, 8);
            }
        } else if (this.mSize == 7 || this.mSize == 8) {
            if (i == 0) {
                s(imageView, 1);
            } else if (i == 2) {
                s(imageView, 2);
            } else if (i == 6) {
                s(imageView, 4);
            }
        } else if (this.mSize >= 9) {
            if (i == 0) {
                s(imageView, 1);
            } else if (i == 2) {
                s(imageView, 2);
            } else if (i == 6) {
                s(imageView, 4);
            } else if (i == 8) {
                s(imageView, 8);
            }
        } else {
            s(imageView, 15);
        }
    }

    private int bm(int i, int i2) {
        if (bn(i, i2)) {
            return this.fVV[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean bn(int i, int i2) {
        if (this.mSize == 4) {
            return i >= 0 && i < 2 && i2 >= 0 && i2 < 2;
        }
        return i >= 0 && i < 3 && i2 >= 0 && i2 < 3 && (i * 3) + i2 <= (this.mSize <= 9 ? this.mSize + (-1) : 8);
    }

    private void s(View view, int i) {
        if (view instanceof TbImageView) {
            ((TbImageView) view).setConrers(i);
        } else {
            if (view instanceof GifView) {
            }
        }
    }

    private void bHr() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.fVN != null && !y.isEmpty(this.fVO) && (tbRichTextImageInfo = this.fVO.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                int i = (this.fVN.fXZ - (this.fVP * 2)) / 3;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
                if (this.mSize == 1) {
                    if (f >= 2.0f) {
                        this.mImageWidth = (i * 2) + this.fVP;
                        this.mImageHeight = (int) ((i * 1.5d) + this.fVP);
                        return;
                    } else if (f <= 0.5d) {
                        this.mImageWidth = (int) ((i * 1.5d) + this.fVP);
                        this.mImageHeight = (i * 2) + this.fVP;
                        return;
                    } else {
                        this.mImageWidth = (i * 2) + this.fVP;
                        this.mImageHeight = (i * 2) + this.fVP;
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
        this.fVS = z;
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
        this.fVU = z;
    }
}
