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
    private View.OnClickListener akt;
    private TbImageView.b alw;
    private int fMY;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private Paint fMy;
    private int fMz;
    private com.baidu.adp.lib.d.b<GifView> fNa;
    private com.baidu.tbadk.widget.richText.a fNb;
    private ArrayList<TbRichTextImageInfo> fNc;
    private int fNd;
    private String fNe;
    private RectF fNf;
    private boolean fNg;
    private int fNh;
    private boolean fNi;
    private int[] fNj;
    private TbRichTextView.i fNk;
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
        this.fMY = 0;
        this.fMZ = null;
        this.fNa = null;
        this.textHeight = 0;
        this.fNg = true;
        this.fNi = false;
        this.fNj = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fNk != null && GridImageLayout.this.fNc != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fNk.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.akt != null) {
                    GridImageLayout.this.akt.onClick(view);
                }
            }
        };
        this.alw = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ei = com.baidu.tbadk.imageManager.c.bDV().Ei(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fNh));
                    if (Ei != null) {
                        i = Ei.getWidth();
                        i2 = Ei.getHeight();
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

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMY = 0;
        this.fMZ = null;
        this.fNa = null;
        this.textHeight = 0;
        this.fNg = true;
        this.fNi = false;
        this.fNj = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fNk != null && GridImageLayout.this.fNc != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fNk.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.akt != null) {
                    GridImageLayout.this.akt.onClick(view);
                }
            }
        };
        this.alw = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ei = com.baidu.tbadk.imageManager.c.bDV().Ei(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fNh));
                    if (Ei != null) {
                        i = Ei.getWidth();
                        i2 = Ei.getHeight();
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

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMY = 0;
        this.fMZ = null;
        this.fNa = null;
        this.textHeight = 0;
        this.fNg = true;
        this.fNi = false;
        this.fNj = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.fNk != null && GridImageLayout.this.fNc != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.fNk.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.akt != null) {
                    GridImageLayout.this.akt.onClick(view);
                }
            }
        };
        this.alw = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                float f;
                int i22 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ei = com.baidu.tbadk.imageManager.c.bDV().Ei(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.fNh));
                    if (Ei != null) {
                        i2 = Ei.getWidth();
                        i22 = Ei.getHeight();
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

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    private void init() {
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.fMy = new Paint();
        this.fMy.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(ap.getColor(R.color.CAM_X0101));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.fMz = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.fNb = aVar;
        if (this.fNb != null) {
            this.fNd = this.fNb.fPp;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.fMZ = bVar;
        this.fNa = bVar2;
    }

    public void setCornerStyle(int i) {
        this.fMY = i;
    }

    public void clearData() {
        this.fNc = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!y.isEmpty(arrayList) && !P(arrayList) && this.fNb != null) {
            this.fNc = arrayList;
            this.mSize = arrayList.size();
            this.fNe = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            bIn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!au.isEmpty(this.fNe) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.fNf == null) {
                    this.fNf = new RectF();
                }
                this.fNf.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.fNf, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
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
                canvas2.drawPath(com.baidu.tbadk.core.elementsMaven.a.a.a(rectF2, fArr), this.mBitmapPaint);
            }
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.fMy);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            int dimenPixelSize2 = ((int) rectF.right) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int i3 = ((int) rectF.bottom) - dimenPixelSize;
            int measureText = dimenPixelSize2 - ((int) this.textPaint.measureText(this.fNe));
            float[] ph = com.baidu.tbadk.core.elementsMaven.a.ph(R.array.S_O_X001);
            this.textPaint.setShadowLayer(ph[1], ph[2], ph[3], (int) ph[0]);
            canvas.drawText(this.fNe, measureText, i3, this.textPaint);
        }
    }

    private boolean P(ArrayList<TbRichTextImageInfo> arrayList) {
        return y.equalList(this.fNc, arrayList);
    }

    private void bIn() {
        if (!y.isEmpty(this.fNc)) {
            removeAllViews();
            bIq();
            if (this.mImageWidth > 0 && this.mImageHeight > 0) {
                if (this.mSize == 1) {
                    bIo();
                } else {
                    bIp();
                }
            }
        }
    }

    private void bIo() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!y.isEmpty(this.fNc) && (tbRichTextImageInfo = this.fNc.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (width > 0 && height > 0) {
                if (this.fNg && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bJc()) {
                    a(0, tbRichTextImageInfo);
                } else {
                    b(0, tbRichTextImageInfo);
                }
            }
        }
    }

    private void bIp() {
        if (!y.isEmpty(this.fNc)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.fNc.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (width > 0 && height > 0) {
                            if (this.fNg && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bJc()) {
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
        if (tbRichTextImageInfo != null && this.fNb != null) {
            GifView borrowObject = this.fNa != null ? this.fNa.borrowObject() : null;
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
                borrowObject.setOnDrawListener(this.alw);
            } else {
                borrowObject.setPlaceHolder(2);
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            borrowObject.setIsLongPic(tbRichTextImageInfo.bJc());
            if (i == 8 && !au.isEmpty(this.fNe)) {
                borrowObject.setLongIconSupport(false);
                borrowObject.setGifIconSupport(false);
            } else {
                borrowObject.setLongIconSupport(true);
                borrowObject.setGifIconSupport(true);
            }
            if (this.fNb.fPc) {
                borrowObject.setSupportNoImage(true);
            }
            borrowObject.setDefaultNoImageDay(ap.pS(R.drawable.icon_click));
            String bIY = tbRichTextImageInfo.bIY();
            if (StringUtils.isNull(bIY)) {
                if (this.fNb.bIB()) {
                    bIY = this.fNb.mIsFromCDN ? tbRichTextImageInfo.bIU() : tbRichTextImageInfo.bIW();
                }
                if (StringUtils.isNull(bIY)) {
                    bIY = this.fNb.mIsFromCDN ? tbRichTextImageInfo.bIX() : tbRichTextImageInfo.getSrc();
                }
            }
            borrowObject.setShowStaticDrawable(false);
            this.fNh = 38;
            borrowObject.av(bIY, this.fNh);
            a(borrowObject, i);
        }
    }

    private void b(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.fNb != null) {
            ImageView borrowObject = this.fMZ != null ? this.fMZ.borrowObject() : null;
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
                    tbImageView.setOnDrawListener(this.alw);
                } else {
                    tbImageView.setPlaceHolder(2);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.bJc());
                if (i == 8 && !au.isEmpty(this.fNe)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.fNb.fPc) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.fNg) {
                    str = tbRichTextImageInfo.getSrc();
                    String bJa = tbRichTextImageInfo.bJa();
                    if (!TextUtils.isEmpty(bJa) && bJa.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    this.fNh = 13;
                } else {
                    if (this.fNb.bIB()) {
                        str = this.fNb.mIsFromCDN ? tbRichTextImageInfo.bIU() : tbRichTextImageInfo.bIW();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.fNb.mIsFromCDN ? tbRichTextImageInfo.bIX() : tbRichTextImageInfo.getSrc();
                    }
                    this.fNh = this.fNb.mIsFromCDN ? 13 : 14;
                }
                tbImageView.startLoad(str, this.fNh, false);
                if (!tbRichTextImageInfo.bIZ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                a(tbImageView, i);
            }
        }
    }

    private void a(TbImageView tbImageView, int i) {
        if (tbImageView != null && this.fNb != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            a(tbImageView, i, layoutParams);
            addView(tbImageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.fNj[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int br = br(i2, i3 - 1);
            int br2 = br(i4, i3);
            if (br2 >= 0) {
                layoutParams.addRule(3, br2);
                layoutParams.topMargin = this.fNd;
            }
            if (br >= 0) {
                layoutParams.addRule(1, br);
                layoutParams.leftMargin = this.fNd;
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

    private int br(int i, int i2) {
        if (bs(i, i2)) {
            return this.fNj[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean bs(int i, int i2) {
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

    private void bIq() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.fNb != null && !y.isEmpty(this.fNc) && (tbRichTextImageInfo = this.fNc.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                int i = (this.fNb.fPo - (this.fNd * 2)) / 3;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
                if (this.mSize == 1) {
                    if (f >= 2.0f) {
                        this.mImageWidth = (i * 2) + this.fNd;
                        this.mImageHeight = (int) ((i * 1.5d) + this.fNd);
                        return;
                    } else if (f <= 0.5d) {
                        this.mImageWidth = (int) ((i * 1.5d) + this.fNd);
                        this.mImageHeight = (i * 2) + this.fNd;
                        return;
                    } else {
                        this.mImageWidth = (i * 2) + this.fNd;
                        this.mImageHeight = (i * 2) + this.fNd;
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
        this.fNg = z;
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
        this.fNi = z;
    }
}
