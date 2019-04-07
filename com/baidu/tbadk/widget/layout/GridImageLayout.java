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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GridImageLayout extends RelativeLayout {
    private int Rl;
    private Bitmap aaF;
    private RectF cAA;
    private int cAB;
    private int[] cAC;
    private TbRichTextView.h cAD;
    private com.baidu.adp.lib.e.b<ImageView> cAu;
    private com.baidu.adp.lib.e.b<GifView> cAv;
    private com.baidu.tbadk.widget.richText.a cAw;
    private ArrayList<TbRichTextImageInfo> cAx;
    private int cAy;
    private String cAz;
    private Paint czU;
    private int czV;
    private Paint mBitmapPaint;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private int mSize;
    private Paint textPaint;

    public GridImageLayout(Context context) {
        super(context);
        this.cAu = null;
        this.cAv = null;
        this.Rl = 0;
        this.cAC = new int[]{d.g.grid_image_0, d.g.grid_image_1, d.g.grid_image_2, d.g.grid_image_3, d.g.grid_image_4, d.g.grid_image_5, d.g.grid_image_6, d.g.grid_image_7, d.g.grid_image_8, d.g.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cAD != null && GridImageLayout.this.cAx != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cAD.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAu = null;
        this.cAv = null;
        this.Rl = 0;
        this.cAC = new int[]{d.g.grid_image_0, d.g.grid_image_1, d.g.grid_image_2, d.g.grid_image_3, d.g.grid_image_4, d.g.grid_image_5, d.g.grid_image_6, d.g.grid_image_7, d.g.grid_image_8, d.g.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cAD != null && GridImageLayout.this.cAx != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cAD.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cAu = null;
        this.cAv = null;
        this.Rl = 0;
        this.cAC = new int[]{d.g.grid_image_0, d.g.grid_image_1, d.g.grid_image_2, d.g.grid_image_3, d.g.grid_image_4, d.g.grid_image_5, d.g.grid_image_6, d.g.grid_image_7, d.g.grid_image_8, d.g.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cAD != null && GridImageLayout.this.cAx != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cAD.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    private void init() {
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.czU = new Paint();
        this.czU.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.Rl = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.czV = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.cAB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAD = hVar;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.cAw = aVar;
        if (this.cAw != null) {
            this.cAy = this.cAw.cCq;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.e.b<ImageView> bVar, com.baidu.adp.lib.e.b<GifView> bVar2) {
        this.cAu = bVar;
        this.cAv = bVar2;
    }

    public void clearData() {
        this.cAx = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!v.T(arrayList) && !y(arrayList) && this.cAw != null) {
            this.cAx = arrayList;
            this.mSize = arrayList.size();
            this.cAz = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            asb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!ap.isEmpty(this.cAz) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.cAA == null) {
                    this.cAA = new RectF();
                }
                this.cAA.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.cAA, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
            }
        }
    }

    private void a(Canvas canvas, RectF rectF, float f) {
        if (rectF != null) {
            if (this.aaF == null || this.aaF.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.aaF = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.aaF);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-f, 0.0f, i, i2);
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawRoundRect(rectF2, f, f, this.mBitmapPaint);
            }
            canvas.drawBitmap(this.aaF, rectF.left, rectF.top, this.czU);
            canvas.drawText(this.cAz, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.cAz)) / 2), (((int) rectF.centerY()) + (this.Rl / 2)) - this.czV, this.textPaint);
        }
    }

    private boolean y(ArrayList<TbRichTextImageInfo> arrayList) {
        return v.c(this.cAx, arrayList);
    }

    private void asb() {
        if (!v.T(this.cAx)) {
            removeAllViews();
            if (this.mSize == 1) {
                asc();
            } else {
                asd();
            }
        }
    }

    private void asc() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!v.T(this.cAx) && (tbRichTextImageInfo = this.cAx.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.asT()) {
                    a(0, f, tbRichTextImageInfo);
                } else {
                    b(0, f, tbRichTextImageInfo);
                }
            }
        }
    }

    private void asd() {
        if (!v.T(this.cAx)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.cAx.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (height > 0) {
                            float f = (width * 1.0f) / height;
                            if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.asT()) {
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
        if (tbRichTextImageInfo != null && this.cAw != null) {
            GifView gifView = null;
            if (this.cAv != null) {
                gifView = this.cAv.jA();
            }
            if (gifView == null || gifView.getParent() != null) {
                gifView = new GifView(getContext());
            }
            gifView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            gifView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
            gifView.setBorderSurroundContent(true);
            gifView.setDrawCorner(true);
            gifView.setDrawBorder(true);
            gifView.setRadius(this.cAB);
            gifView.setOnClickListener(this.mOnClickListener);
            gifView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            gifView.setIsLongPic(tbRichTextImageInfo.asT());
            if (i == 8 && !ap.isEmpty(this.cAz)) {
                gifView.setLongIconSupport(false);
                gifView.setGifIconSupport(false);
            } else {
                gifView.setLongIconSupport(true);
                gifView.setGifIconSupport(true);
            }
            if (this.cAw.cCe) {
                gifView.setSupportNoImage(true);
            }
            gifView.setDefaultNoImageDay(al.ht(d.f.icon_click));
            String asP = tbRichTextImageInfo.asP();
            if (StringUtils.isNull(asP)) {
                if (this.cAw.ass()) {
                    asP = this.cAw.mIsFromCDN ? tbRichTextImageInfo.asL() : tbRichTextImageInfo.asN();
                }
                if (StringUtils.isNull(asP)) {
                    asP = this.cAw.mIsFromCDN ? tbRichTextImageInfo.asO() : tbRichTextImageInfo.Nv();
                }
            }
            gifView.setShowStaticDrawable(false);
            gifView.ad(asP, 38);
            a(gifView, i, f, tbRichTextImageInfo.asT());
        }
    }

    private void b(int i, float f, TbRichTextImageInfo tbRichTextImageInfo) {
        if (tbRichTextImageInfo != null && this.cAw != null) {
            TbImageView tbImageView = null;
            if (this.cAu != null) {
                tbImageView = this.cAu.jA();
            }
            if (tbImageView == null || tbImageView.getParent() != null) {
                tbImageView = new TbImageView(getContext());
            }
            if (tbImageView instanceof TbImageView) {
                TbImageView tbImageView2 = tbImageView;
                tbImageView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
                tbImageView2.setBorderColor(al.getColor(d.C0277d.black_alpha8));
                tbImageView2.setBorderSurroundContent(true);
                tbImageView2.setDrawCorner(true);
                tbImageView2.setDrawBorder(true);
                tbImageView2.setRadius(this.cAB);
                tbImageView2.setOnClickListener(this.mOnClickListener);
                tbImageView2.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                tbImageView2.setIsLongPic(tbRichTextImageInfo.asT());
                if (i == 8 && !ap.isEmpty(this.cAz)) {
                    tbImageView2.setLongIconSupport(false);
                    tbImageView2.setGifIconSupport(false);
                } else {
                    tbImageView2.setLongIconSupport(true);
                    tbImageView2.setGifIconSupport(true);
                }
                if (this.cAw.cCe) {
                    tbImageView2.setSupportNoImage(true);
                }
                tbImageView2.startLoad(this.cAw.ass() ? tbRichTextImageInfo.asL() : tbRichTextImageInfo.asO(), this.cAw.mIsFromCDN ? 13 : 14, false);
                if (!tbRichTextImageInfo.asQ()) {
                    tbImageView2.setAdjustViewBounds(false);
                }
                a(tbImageView, i, f, tbRichTextImageInfo.asT());
            }
        }
    }

    private void a(ImageView imageView, int i, float f, boolean z) {
        int i2;
        int i3;
        if (imageView != null && this.cAw != null) {
            int i4 = this.cAw.cCp - (this.cAy * 2);
            if (this.mSize == 1) {
                if (z) {
                    i2 = i4 / 3;
                    i3 = ((i4 * 2) / 3) + this.cAy;
                } else {
                    i2 = ((i4 * 2) / 3) + this.cAy;
                    i3 = ((i4 * 2) / 3) + this.cAy;
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
            imageView.setId(this.cAC[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int ap = ap(i2, i3 - 1);
            int ap2 = ap(i4, i3);
            if (ap2 >= 0) {
                layoutParams.addRule(3, ap2);
                layoutParams.topMargin = this.cAy;
            }
            if (ap >= 0) {
                layoutParams.addRule(1, ap);
                layoutParams.leftMargin = this.cAy;
            }
            p(imageView, i);
        }
    }

    private int ap(int i, int i2) {
        if (aq(i, i2)) {
            return this.cAC[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
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
            if (!aq(i3, i5) && !aq(i6, i4)) {
                i2 = 1;
            }
            if (!aq(i3, i7) && !aq(i6, i4)) {
                i2 |= 2;
            }
            if (!aq(i3, i5) && !aq(i8, i4)) {
                i2 |= 4;
            }
            if (!aq(i3, i7) && !aq(i8, i4)) {
                i2 |= 8;
            }
            q(view, i2);
        }
    }

    private boolean aq(int i, int i2) {
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
