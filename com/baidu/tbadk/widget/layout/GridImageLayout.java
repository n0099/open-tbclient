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
    private View.OnClickListener ags;
    private TbImageView.c ahi;
    private Paint eAP;
    private int eAQ;
    private int eBA;
    private int[] eBB;
    private TbRichTextView.i eBC;
    private int eBq;
    private com.baidu.adp.lib.d.b<ImageView> eBr;
    private com.baidu.adp.lib.d.b<GifView> eBs;
    private com.baidu.tbadk.widget.richText.a eBt;
    private ArrayList<TbRichTextImageInfo> eBu;
    private int eBv;
    private String eBw;
    private RectF eBx;
    private int eBy;
    private boolean eBz;
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
        this.eBq = 0;
        this.eBr = null;
        this.eBs = null;
        this.textHeight = 0;
        this.eBz = true;
        this.eBB = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.eBC != null && GridImageLayout.this.eBu != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.eBC.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.ags != null) {
                    GridImageLayout.this.ags.onClick(view);
                }
            }
        };
        this.ahi = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yv = com.baidu.tbadk.imageManager.c.bet().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.eBA));
                    if (yv != null) {
                        i = yv.getWidth();
                        i2 = yv.getHeight();
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
        this.eBq = 0;
        this.eBr = null;
        this.eBs = null;
        this.textHeight = 0;
        this.eBz = true;
        this.eBB = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.eBC != null && GridImageLayout.this.eBu != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.eBC.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.ags != null) {
                    GridImageLayout.this.ags.onClick(view);
                }
            }
        };
        this.ahi = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yv = com.baidu.tbadk.imageManager.c.bet().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.eBA));
                    if (yv != null) {
                        i = yv.getWidth();
                        i2 = yv.getHeight();
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
        this.eBq = 0;
        this.eBr = null;
        this.eBs = null;
        this.textHeight = 0;
        this.eBz = true;
        this.eBB = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.eBC != null && GridImageLayout.this.eBu != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.eBC.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.ags != null) {
                    GridImageLayout.this.ags.onClick(view);
                }
            }
        };
        this.ahi = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                float f;
                int i22 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yv = com.baidu.tbadk.imageManager.c.bet().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), GridImageLayout.this.eBA));
                    if (yv != null) {
                        i2 = yv.getWidth();
                        i22 = yv.getHeight();
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
        this.eAP = new Paint();
        this.eAP.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(am.getColor(R.color.cp_cont_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.eAQ = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.eBy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.eBt = aVar;
        if (this.eBt != null) {
            this.eBv = this.eBt.eDf;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.eBr = bVar;
        this.eBs = bVar2;
    }

    public void setCornerStyle(int i) {
        this.eBq = i;
    }

    public void clearData() {
        this.eBu = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!v.isEmpty(arrayList) && !I(arrayList) && this.eBt != null) {
            this.eBu = arrayList;
            this.mSize = arrayList.size();
            this.eBw = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            bib();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!aq.isEmpty(this.eBw) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.eBx == null) {
                    this.eBx = new RectF();
                }
                this.eBx.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.eBx, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
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
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.eAP);
            canvas.drawText(this.eBw, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.eBw)) / 2), (((int) rectF.centerY()) + (this.textHeight / 2)) - this.eAQ, this.textPaint);
        }
    }

    private boolean I(ArrayList<TbRichTextImageInfo> arrayList) {
        return v.equalList(this.eBu, arrayList);
    }

    private void bib() {
        if (!v.isEmpty(this.eBu)) {
            removeAllViews();
            bie();
            if (this.mImageWidth > 0 && this.mImageHeight > 0) {
                if (this.mSize == 1) {
                    bic();
                } else {
                    bid();
                }
            }
        }
    }

    private void bic() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!v.isEmpty(this.eBu) && (tbRichTextImageInfo = this.eBu.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (width > 0 && height > 0) {
                if (this.eBz && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.biO()) {
                    a(0, tbRichTextImageInfo);
                } else {
                    b(0, tbRichTextImageInfo);
                }
            }
        }
    }

    private void bid() {
        if (!v.isEmpty(this.eBu)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.eBu.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (width > 0 && height > 0) {
                            if (this.eBz && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.biO()) {
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
        if (tbRichTextImageInfo != null && this.eBt != null) {
            GifView borrowObject = this.eBs != null ? this.eBs.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new GifView(getContext());
            }
            borrowObject.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            borrowObject.setBorderColor(am.getColor(R.color.cp_border_a));
            borrowObject.setBorderSurroundContent(true);
            borrowObject.setDrawCorner(true);
            borrowObject.setDrawBorder(true);
            borrowObject.setRadius(this.eBy);
            borrowObject.setOnClickListener(this.mOnClickListener);
            if (this.mOnLongClickListener != null) {
                borrowObject.setOnLongClickListener(this.mOnLongClickListener);
            }
            borrowObject.setOnDrawListener(null);
            if (this.mSize == 1) {
                borrowObject.setPlaceHolder(3);
                borrowObject.setScaleType(ImageView.ScaleType.MATRIX);
                borrowObject.setOnDrawListener(this.ahi);
            } else {
                borrowObject.setPlaceHolder(2);
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            borrowObject.setIsLongPic(tbRichTextImageInfo.biO());
            if (i == 8 && !aq.isEmpty(this.eBw)) {
                borrowObject.setLongIconSupport(false);
                borrowObject.setGifIconSupport(false);
            } else {
                borrowObject.setLongIconSupport(true);
                borrowObject.setGifIconSupport(true);
            }
            if (this.eBt.eCT) {
                borrowObject.setSupportNoImage(true);
            }
            borrowObject.setDefaultNoImageDay(am.lb(R.drawable.icon_click));
            String biK = tbRichTextImageInfo.biK();
            if (StringUtils.isNull(biK)) {
                if (this.eBt.bip()) {
                    biK = this.eBt.mIsFromCDN ? tbRichTextImageInfo.biG() : tbRichTextImageInfo.biI();
                }
                if (StringUtils.isNull(biK)) {
                    biK = this.eBt.mIsFromCDN ? tbRichTextImageInfo.biJ() : tbRichTextImageInfo.getSrc();
                }
            }
            borrowObject.setShowStaticDrawable(false);
            this.eBA = 38;
            borrowObject.ao(biK, this.eBA);
            b(borrowObject, i);
        }
    }

    private void b(int i, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.eBt != null) {
            ImageView borrowObject = this.eBr != null ? this.eBr.borrowObject() : null;
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
                tbImageView.setRadius(this.eBy);
                tbImageView.setOnClickListener(this.mOnClickListener);
                if (this.mOnLongClickListener != null) {
                    tbImageView.setOnLongClickListener(this.mOnLongClickListener);
                }
                tbImageView.setOnDrawListener(null);
                if (this.mSize == 1) {
                    tbImageView.setPlaceHolder(3);
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setOnDrawListener(this.ahi);
                } else {
                    tbImageView.setPlaceHolder(2);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.biO());
                if (i == 8 && !aq.isEmpty(this.eBw)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.eBt.eCT) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.eBz) {
                    str = tbRichTextImageInfo.getSrc();
                    String biM = tbRichTextImageInfo.biM();
                    if (!TextUtils.isEmpty(biM) && biM.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    this.eBA = 13;
                } else {
                    if (this.eBt.bip()) {
                        str = this.eBt.mIsFromCDN ? tbRichTextImageInfo.biG() : tbRichTextImageInfo.biI();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.eBt.mIsFromCDN ? tbRichTextImageInfo.biJ() : tbRichTextImageInfo.getSrc();
                    }
                    this.eBA = this.eBt.mIsFromCDN ? 13 : 14;
                }
                tbImageView.startLoad(str, this.eBA, false);
                if (!tbRichTextImageInfo.biL()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                b(tbImageView, i);
            }
        }
    }

    private void b(TbImageView tbImageView, int i) {
        if (tbImageView != null && this.eBt != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            a(tbImageView, i, layoutParams);
            addView(tbImageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.eBB[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int aZ = aZ(i2, i3 - 1);
            int aZ2 = aZ(i4, i3);
            if (aZ2 >= 0) {
                layoutParams.addRule(3, aZ2);
                layoutParams.topMargin = this.eBv;
            }
            if (aZ >= 0) {
                layoutParams.addRule(1, aZ);
                layoutParams.leftMargin = this.eBv;
            }
            j(imageView, 15);
        }
    }

    private int aZ(int i, int i2) {
        if (ba(i, i2)) {
            return this.eBB[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean ba(int i, int i2) {
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

    private void bie() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (this.eBt != null && !v.isEmpty(this.eBu) && (tbRichTextImageInfo = this.eBu.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                int i = (this.eBt.eDe - (this.eBv * 2)) / 3;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
                if (this.mSize == 1) {
                    if (f >= 2.0f) {
                        this.mImageWidth = (i * 2) + this.eBv;
                        this.mImageHeight = (int) ((i * 1.5d) + this.eBv);
                        return;
                    } else if (f <= 0.5d) {
                        this.mImageWidth = (int) ((i * 1.5d) + this.eBv);
                        this.mImageHeight = (i * 2) + this.eBv;
                        return;
                    } else {
                        this.mImageWidth = (i * 2) + this.eBv;
                        this.mImageHeight = (i * 2) + this.eBv;
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
        this.eBz = z;
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
