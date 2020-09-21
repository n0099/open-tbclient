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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GridImageLayout extends RelativeLayout {
    private View.OnClickListener aiW;
    private TbImageView.c ajZ;
    private Paint feI;
    private int feJ;
    private int ffi;
    private com.baidu.adp.lib.d.b<ImageView> ffj;
    private com.baidu.adp.lib.d.b<GifView> ffk;
    private com.baidu.tbadk.widget.richText.a ffl;
    private ArrayList<TbRichTextImageInfo> ffm;
    private int ffn;
    private String ffo;
    private RectF ffp;
    private int ffq;
    private boolean ffr;
    private int ffs;
    private int[] fft;
    private TbRichTextView.i ffu;
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
        this.ffi = 0;
        this.ffj = null;
        this.ffk = null;
        this.textHeight = 0;
        this.ffr = true;
        this.fft = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.ffu != null && GridImageLayout.this.ffm != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.ffu.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.aiW != null) {
                    GridImageLayout.this.aiW.onClick(view);
                }
            }
        };
        this.ajZ = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a CI = com.baidu.tbadk.imageManager.c.bub().CI(com.baidu.adp.lib.e.c.mR().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.ffs));
                    if (CI != null) {
                        i = CI.getWidth();
                        i2 = CI.getHeight();
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
        this.ffi = 0;
        this.ffj = null;
        this.ffk = null;
        this.textHeight = 0;
        this.ffr = true;
        this.fft = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.ffu != null && GridImageLayout.this.ffm != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.ffu.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.aiW != null) {
                    GridImageLayout.this.aiW.onClick(view);
                }
            }
        };
        this.ajZ = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a CI = com.baidu.tbadk.imageManager.c.bub().CI(com.baidu.adp.lib.e.c.mR().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.ffs));
                    if (CI != null) {
                        i = CI.getWidth();
                        i2 = CI.getHeight();
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
        this.ffi = 0;
        this.ffj = null;
        this.ffk = null;
        this.textHeight = 0;
        this.ffr = true;
        this.fft = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.ffu != null && GridImageLayout.this.ffm != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.ffu.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.aiW != null) {
                    GridImageLayout.this.aiW.onClick(view);
                }
            }
        };
        this.ajZ = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                float f;
                int i22 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a CI = com.baidu.tbadk.imageManager.c.bub().CI(com.baidu.adp.lib.e.c.mR().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.ffs));
                    if (CI != null) {
                        i2 = CI.getWidth();
                        i22 = CI.getHeight();
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
        this.feI = new Paint();
        this.feI.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(ap.getColor(R.color.cp_cont_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.feJ = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.ffq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.ffl = aVar;
        if (this.ffl != null) {
            this.ffn = this.ffl.fhy;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.ffj = bVar;
        this.ffk = bVar2;
    }

    public void setCornerStyle(int i) {
        this.ffi = i;
    }

    public void clearData() {
        this.ffm = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!y.isEmpty(arrayList) && !P(arrayList) && this.ffl != null) {
            this.ffm = arrayList;
            this.mSize = arrayList.size();
            this.ffo = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            byr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!at.isEmpty(this.ffo) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.ffp == null) {
                    this.ffp = new RectF();
                }
                this.ffp.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.ffp, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
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
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.feI);
            canvas.drawText(this.ffo, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.ffo)) / 2), (((int) rectF.centerY()) + (this.textHeight / 2)) - this.feJ, this.textPaint);
        }
    }

    private boolean P(ArrayList<TbRichTextImageInfo> arrayList) {
        return y.equalList(this.ffm, arrayList);
    }

    private void byr() {
        if (!y.isEmpty(this.ffm)) {
            removeAllViews();
            byu();
            if (this.mImageWidth > 0 && this.mImageHeight > 0) {
                if (this.mSize == 1) {
                    bys();
                } else {
                    byt();
                }
            }
        }
    }

    private void bys() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!y.isEmpty(this.ffm) && (tbRichTextImageInfo = this.ffm.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (width > 0 && height > 0) {
                if (this.ffr && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bzh()) {
                    a(0, tbRichTextImageInfo);
                } else {
                    b(0, tbRichTextImageInfo);
                }
            }
        }
    }

    private void byt() {
        if (!y.isEmpty(this.ffm)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.ffm.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (width > 0 && height > 0) {
                            if (this.ffr && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.bzh()) {
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
        if (tbRichTextImageInfo != null && this.ffl != null) {
            GifView borrowObject = this.ffk != null ? this.ffk.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new GifView(getContext());
            }
            borrowObject.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            borrowObject.setBorderColor(ap.getColor(R.color.cp_border_a));
            borrowObject.setBorderSurroundContent(true);
            borrowObject.setDrawCorner(true);
            borrowObject.setDrawBorder(true);
            borrowObject.setRadius(this.ffq);
            borrowObject.setOnClickListener(this.mOnClickListener);
            if (this.mOnLongClickListener != null) {
                borrowObject.setOnLongClickListener(this.mOnLongClickListener);
            }
            borrowObject.setOnDrawListener(null);
            if (this.mSize == 1) {
                borrowObject.setPlaceHolder(3);
                borrowObject.setScaleType(ImageView.ScaleType.MATRIX);
                borrowObject.setOnDrawListener(this.ajZ);
            } else {
                borrowObject.setPlaceHolder(2);
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            borrowObject.setIsLongPic(tbRichTextImageInfo.bzh());
            if (i == 8 && !at.isEmpty(this.ffo)) {
                borrowObject.setLongIconSupport(false);
                borrowObject.setGifIconSupport(false);
            } else {
                borrowObject.setLongIconSupport(true);
                borrowObject.setGifIconSupport(true);
            }
            if (this.ffl.fhl) {
                borrowObject.setSupportNoImage(true);
            }
            borrowObject.setDefaultNoImageDay(ap.oe(R.drawable.icon_click));
            String bzd = tbRichTextImageInfo.bzd();
            if (StringUtils.isNull(bzd)) {
                if (this.ffl.byF()) {
                    bzd = this.ffl.mIsFromCDN ? tbRichTextImageInfo.byZ() : tbRichTextImageInfo.bzb();
                }
                if (StringUtils.isNull(bzd)) {
                    bzd = this.ffl.mIsFromCDN ? tbRichTextImageInfo.bzc() : tbRichTextImageInfo.getSrc();
                }
            }
            borrowObject.setShowStaticDrawable(false);
            this.ffs = 38;
            borrowObject.as(bzd, this.ffs);
            b(borrowObject, i);
        }
    }

    private void b(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.ffl != null) {
            ImageView borrowObject = this.ffj != null ? this.ffj.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new TbImageView(getContext());
            }
            if (borrowObject instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) borrowObject;
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawCorner(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setRadius(this.ffq);
                tbImageView.setOnClickListener(this.mOnClickListener);
                if (this.mOnLongClickListener != null) {
                    tbImageView.setOnLongClickListener(this.mOnLongClickListener);
                }
                tbImageView.setOnDrawListener(null);
                if (this.mSize == 1) {
                    tbImageView.setPlaceHolder(3);
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setOnDrawListener(this.ajZ);
                } else {
                    tbImageView.setPlaceHolder(2);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.bzh());
                if (i == 8 && !at.isEmpty(this.ffo)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.ffl.fhl) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.ffr) {
                    str = tbRichTextImageInfo.getSrc();
                    String bzf = tbRichTextImageInfo.bzf();
                    if (!TextUtils.isEmpty(bzf) && bzf.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    this.ffs = 13;
                } else {
                    if (this.ffl.byF()) {
                        str = this.ffl.mIsFromCDN ? tbRichTextImageInfo.byZ() : tbRichTextImageInfo.bzb();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.ffl.mIsFromCDN ? tbRichTextImageInfo.bzc() : tbRichTextImageInfo.getSrc();
                    }
                    this.ffs = this.ffl.mIsFromCDN ? 13 : 14;
                }
                tbImageView.startLoad(str, this.ffs, false);
                if (!tbRichTextImageInfo.bze()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                b(tbImageView, i);
            }
        }
    }

    private void b(TbImageView tbImageView, int i) {
        if (tbImageView != null && this.ffl != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            a(tbImageView, i, layoutParams);
            addView(tbImageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.fft[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int bp = bp(i2, i3 - 1);
            int bp2 = bp(i4, i3);
            if (bp2 >= 0) {
                layoutParams.addRule(3, bp2);
                layoutParams.topMargin = this.ffn;
            }
            if (bp >= 0) {
                layoutParams.addRule(1, bp);
                layoutParams.leftMargin = this.ffn;
            }
            l(imageView, 15);
        }
    }

    private int bp(int i, int i2) {
        if (bq(i, i2)) {
            return this.fft[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean bq(int i, int i2) {
        if (this.mSize == 4) {
            return i >= 0 && i < 2 && i2 >= 0 && i2 < 2;
        }
        return i >= 0 && i < 3 && i2 >= 0 && i2 < 3 && (i * 3) + i2 <= (this.mSize <= 9 ? this.mSize + (-1) : 8);
    }

    private void l(View view, int i) {
        if (view instanceof TbImageView) {
            ((TbImageView) view).setConrers(i);
        } else {
            if (view instanceof GifView) {
            }
        }
    }

    private void byu() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.ffl != null && !y.isEmpty(this.ffm) && (tbRichTextImageInfo = this.ffm.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                int i = (this.ffl.fhx - (this.ffn * 2)) / 3;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
                if (this.mSize == 1) {
                    if (f >= 2.0f) {
                        this.mImageWidth = (i * 2) + this.ffn;
                        this.mImageHeight = (int) ((i * 1.5d) + this.ffn);
                        return;
                    } else if (f <= 0.5d) {
                        this.mImageWidth = (int) ((i * 1.5d) + this.ffn);
                        this.mImageHeight = (i * 2) + this.ffn;
                        return;
                    } else {
                        this.mImageWidth = (i * 2) + this.ffn;
                        this.mImageHeight = (i * 2) + this.ffn;
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
        this.ffr = z;
    }

    public void onChangeSkinType() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i2)).setBorderColor(ap.getColor(R.color.cp_border_a));
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
