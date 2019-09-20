package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
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
    private Paint Mi;
    private int Pk;
    private Bitmap YS;
    private com.baidu.adp.lib.e.b<ImageView> cKV;
    private com.baidu.adp.lib.e.b<GifView> cKW;
    private com.baidu.tbadk.widget.richText.a cKX;
    private ArrayList<TbRichTextImageInfo> cKY;
    private int cKZ;
    private Paint cKw;
    private int cKx;
    private String cLa;
    private RectF cLb;
    private int cLc;
    private int[] cLd;
    private TbRichTextView.h cLe;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private int mSize;
    private Paint textPaint;

    public GridImageLayout(Context context) {
        super(context);
        this.cKV = null;
        this.cKW = null;
        this.Pk = 0;
        this.cLd = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cLe != null && GridImageLayout.this.cKY != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cLe.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKV = null;
        this.cKW = null;
        this.Pk = 0;
        this.cLd = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cLe != null && GridImageLayout.this.cKY != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cLe.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKV = null;
        this.cKW = null;
        this.Pk = 0;
        this.cLd = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cLe != null && GridImageLayout.this.cKY != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cLe.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    private void init() {
        this.Mi = new Paint();
        this.Mi.setAntiAlias(true);
        this.Mi.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cKw = new Paint();
        this.cKw.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(am.getColor(R.color.cp_cont_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.Pk = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.cKx = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.cLc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cLe = hVar;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.cKX = aVar;
        if (this.cKX != null) {
            this.cKZ = this.cKX.cMR;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.e.b<ImageView> bVar, com.baidu.adp.lib.e.b<GifView> bVar2) {
        this.cKV = bVar;
        this.cKW = bVar2;
    }

    public void clearData() {
        this.cKY = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!v.aa(arrayList) && !B(arrayList) && this.cKX != null) {
            this.cKY = arrayList;
            this.mSize = arrayList.size();
            this.cLa = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            ayH();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!aq.isEmpty(this.cLa) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.cLb == null) {
                    this.cLb = new RectF();
                }
                this.cLb.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.cLb, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
            }
        }
    }

    private void a(Canvas canvas, RectF rectF, float f) {
        if (rectF != null) {
            if (this.YS == null || this.YS.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.YS = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.YS);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-f, 0.0f, i, i2);
                this.Mi.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawRoundRect(rectF2, f, f, this.Mi);
            }
            canvas.drawBitmap(this.YS, rectF.left, rectF.top, this.cKw);
            canvas.drawText(this.cLa, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.cLa)) / 2), (((int) rectF.centerY()) + (this.Pk / 2)) - this.cKx, this.textPaint);
        }
    }

    private boolean B(ArrayList<TbRichTextImageInfo> arrayList) {
        return v.c(this.cKY, arrayList);
    }

    private void ayH() {
        if (!v.aa(this.cKY)) {
            removeAllViews();
            if (this.mSize == 1) {
                ayI();
            } else {
                ayJ();
            }
        }
    }

    private void ayI() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!v.aa(this.cKY) && (tbRichTextImageInfo = this.cKY.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.azz()) {
                    a(0, f, tbRichTextImageInfo);
                } else {
                    b(0, f, tbRichTextImageInfo);
                }
            }
        }
    }

    private void ayJ() {
        if (!v.aa(this.cKY)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.cKY.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (height > 0) {
                            float f = (width * 1.0f) / height;
                            if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.azz()) {
                                a(i2, f, tbRichTextImageInfo);
                            } else {
                                b(i2, f, tbRichTextImageInfo);
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

    private void a(int i, float f, TbRichTextImageInfo tbRichTextImageInfo) {
        if (tbRichTextImageInfo != null && this.cKX != null) {
            GifView gifView = null;
            if (this.cKW != null) {
                gifView = this.cKW.iD();
            }
            if (gifView == null || gifView.getParent() != null) {
                gifView = new GifView(getContext());
            }
            gifView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            gifView.setBorderColor(am.getColor(R.color.black_alpha8));
            gifView.setBorderSurroundContent(true);
            gifView.setDrawCorner(true);
            gifView.setDrawBorder(true);
            gifView.setRadius(this.cLc);
            gifView.setOnClickListener(this.mOnClickListener);
            gifView.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            gifView.setIsLongPic(tbRichTextImageInfo.azz());
            if (i == 8 && !aq.isEmpty(this.cLa)) {
                gifView.setLongIconSupport(false);
                gifView.setGifIconSupport(false);
            } else {
                gifView.setLongIconSupport(true);
                gifView.setGifIconSupport(true);
            }
            if (this.cKX.cMF) {
                gifView.setSupportNoImage(true);
            }
            gifView.setDefaultNoImageDay(am.in(R.drawable.icon_click));
            String azv = tbRichTextImageInfo.azv();
            if (StringUtils.isNull(azv)) {
                if (this.cKX.ayY()) {
                    azv = this.cKX.mIsFromCDN ? tbRichTextImageInfo.azr() : tbRichTextImageInfo.azt();
                }
                if (StringUtils.isNull(azv)) {
                    azv = this.cKX.mIsFromCDN ? tbRichTextImageInfo.azu() : tbRichTextImageInfo.getSrc();
                }
            }
            gifView.setShowStaticDrawable(false);
            gifView.Z(azv, 38);
            a(gifView, i, f, tbRichTextImageInfo.azz());
        }
    }

    private void b(int i, float f, TbRichTextImageInfo tbRichTextImageInfo) {
        if (tbRichTextImageInfo != null && this.cKX != null) {
            TbImageView tbImageView = null;
            if (this.cKV != null) {
                tbImageView = this.cKV.iD();
            }
            if (tbImageView == null || tbImageView.getParent() != null) {
                tbImageView = new TbImageView(getContext());
            }
            if (tbImageView instanceof TbImageView) {
                TbImageView tbImageView2 = tbImageView;
                tbImageView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView2.setBorderColor(am.getColor(R.color.black_alpha8));
                tbImageView2.setBorderSurroundContent(true);
                tbImageView2.setDrawCorner(true);
                tbImageView2.setDrawBorder(true);
                tbImageView2.setRadius(this.cLc);
                tbImageView2.setOnClickListener(this.mOnClickListener);
                tbImageView2.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
                tbImageView2.setIsLongPic(tbRichTextImageInfo.azz());
                if (i == 8 && !aq.isEmpty(this.cLa)) {
                    tbImageView2.setLongIconSupport(false);
                    tbImageView2.setGifIconSupport(false);
                } else {
                    tbImageView2.setLongIconSupport(true);
                    tbImageView2.setGifIconSupport(true);
                }
                if (this.cKX.cMF) {
                    tbImageView2.setSupportNoImage(true);
                }
                tbImageView2.startLoad(this.cKX.ayY() ? tbRichTextImageInfo.azr() : tbRichTextImageInfo.azu(), this.cKX.mIsFromCDN ? 13 : 14, false);
                if (!tbRichTextImageInfo.azw()) {
                    tbImageView2.setAdjustViewBounds(false);
                }
                a(tbImageView, i, f, tbRichTextImageInfo.azz());
            }
        }
    }

    private void a(ImageView imageView, int i, float f, boolean z) {
        int i2;
        int i3;
        if (imageView != null && this.cKX != null) {
            int i4 = this.cKX.cMQ - (this.cKZ * 2);
            if (this.mSize == 1) {
                if (z) {
                    i2 = i4 / 3;
                    i3 = ((i4 * 2) / 3) + this.cKZ;
                } else {
                    i2 = ((i4 * 2) / 3) + this.cKZ;
                    i3 = ((i4 * 2) / 3) + this.cKZ;
                    if (f > 0.0f && f < 1.0f) {
                        i2 = (int) (i3 * f);
                    } else if (f >= 1.0f) {
                        i3 = (int) (i2 / f);
                    }
                }
            } else {
                i2 = i4 / 3;
                i3 = i4 / 3;
            }
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
            a(imageView, i, layoutParams);
            addView(imageView, layoutParams);
        }
    }

    private void a(ImageView imageView, int i, RelativeLayout.LayoutParams layoutParams) {
        if (imageView != null && layoutParams != null) {
            imageView.setId(this.cLd[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int at = at(i2, i3 - 1);
            int at2 = at(i4, i3);
            if (at2 >= 0) {
                layoutParams.addRule(3, at2);
                layoutParams.topMargin = this.cKZ;
            }
            if (at >= 0) {
                layoutParams.addRule(1, at);
                layoutParams.leftMargin = this.cKZ;
            }
            p(imageView, i);
        }
    }

    private int at(int i, int i2) {
        if (au(i, i2)) {
            return this.cLd[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private void p(View view, int i) {
        if (i >= 0 && i <= 9) {
            int i2 = 0;
            int i3 = this.mSize == 4 ? i / 2 : i / 3;
            int i4 = this.mSize == 4 ? i % 2 : i % 3;
            int i5 = i4 - 1;
            int i6 = i3 - 1;
            int i7 = i4 + 1;
            int i8 = i3 + 1;
            if (!au(i3, i5) && !au(i6, i4)) {
                i2 = 1;
            }
            if (!au(i3, i7) && !au(i6, i4)) {
                i2 |= 2;
            }
            if (!au(i3, i5) && !au(i8, i4)) {
                i2 |= 4;
            }
            if (!au(i3, i7) && !au(i8, i4)) {
                i2 |= 8;
            }
            q(view, i2);
        }
    }

    private boolean au(int i, int i2) {
        if (this.mSize == 4) {
            return i >= 0 && i < 2 && i2 >= 0 && i2 < 2;
        }
        return i >= 0 && i < 3 && i2 >= 0 && i2 < 3 && (i * 3) + i2 <= (this.mSize <= 9 ? this.mSize + (-1) : 8);
    }

    private void q(View view, int i) {
        if (view instanceof TbImageView) {
            ((TbImageView) view).setConrers(i);
        } else {
            if (view instanceof GifView) {
            }
        }
    }
}
