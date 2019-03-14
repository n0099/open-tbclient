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
    private Bitmap aaE;
    private int[] cAA;
    private TbRichTextView.h cAB;
    private com.baidu.adp.lib.e.b<ImageView> cAs;
    private com.baidu.adp.lib.e.b<GifView> cAt;
    private com.baidu.tbadk.widget.richText.a cAu;
    private ArrayList<TbRichTextImageInfo> cAv;
    private int cAw;
    private String cAx;
    private RectF cAy;
    private int cAz;
    private Paint czS;
    private int czT;
    private Paint mBitmapPaint;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private int mSize;
    private Paint textPaint;

    public GridImageLayout(Context context) {
        super(context);
        this.cAs = null;
        this.cAt = null;
        this.Rl = 0;
        this.cAA = new int[]{d.g.grid_image_0, d.g.grid_image_1, d.g.grid_image_2, d.g.grid_image_3, d.g.grid_image_4, d.g.grid_image_5, d.g.grid_image_6, d.g.grid_image_7, d.g.grid_image_8, d.g.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cAB != null && GridImageLayout.this.cAv != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cAB.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAs = null;
        this.cAt = null;
        this.Rl = 0;
        this.cAA = new int[]{d.g.grid_image_0, d.g.grid_image_1, d.g.grid_image_2, d.g.grid_image_3, d.g.grid_image_4, d.g.grid_image_5, d.g.grid_image_6, d.g.grid_image_7, d.g.grid_image_8, d.g.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cAB != null && GridImageLayout.this.cAv != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cAB.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cAs = null;
        this.cAt = null;
        this.Rl = 0;
        this.cAA = new int[]{d.g.grid_image_0, d.g.grid_image_1, d.g.grid_image_2, d.g.grid_image_3, d.g.grid_image_4, d.g.grid_image_5, d.g.grid_image_6, d.g.grid_image_7, d.g.grid_image_8, d.g.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cAB != null && GridImageLayout.this.cAv != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cAB.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    private void init() {
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.czS = new Paint();
        this.czS.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.Rl = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.czT = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.cAz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAB = hVar;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.cAu = aVar;
        if (this.cAu != null) {
            this.cAw = this.cAu.cCo;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.e.b<ImageView> bVar, com.baidu.adp.lib.e.b<GifView> bVar2) {
        this.cAs = bVar;
        this.cAt = bVar2;
    }

    public void clearData() {
        this.cAv = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!v.T(arrayList) && !y(arrayList) && this.cAu != null) {
            this.cAv = arrayList;
            this.mSize = arrayList.size();
            this.cAx = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            ase();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!ap.isEmpty(this.cAx) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.cAy == null) {
                    this.cAy = new RectF();
                }
                this.cAy.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.cAy, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
            }
        }
    }

    private void a(Canvas canvas, RectF rectF, float f) {
        if (rectF != null) {
            if (this.aaE == null || this.aaE.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.aaE = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.aaE);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-f, 0.0f, i, i2);
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawRoundRect(rectF2, f, f, this.mBitmapPaint);
            }
            canvas.drawBitmap(this.aaE, rectF.left, rectF.top, this.czS);
            canvas.drawText(this.cAx, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.cAx)) / 2), (((int) rectF.centerY()) + (this.Rl / 2)) - this.czT, this.textPaint);
        }
    }

    private boolean y(ArrayList<TbRichTextImageInfo> arrayList) {
        return v.c(this.cAv, arrayList);
    }

    private void ase() {
        if (!v.T(this.cAv)) {
            removeAllViews();
            if (this.mSize == 1) {
                asf();
            } else {
                asg();
            }
        }
    }

    private void asf() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!v.T(this.cAv) && (tbRichTextImageInfo = this.cAv.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.asW()) {
                    a(0, f, tbRichTextImageInfo);
                } else {
                    b(0, f, tbRichTextImageInfo);
                }
            }
        }
    }

    private void asg() {
        if (!v.T(this.cAv)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.cAv.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (height > 0) {
                            float f = (width * 1.0f) / height;
                            if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.asW()) {
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
        if (tbRichTextImageInfo != null && this.cAu != null) {
            GifView gifView = null;
            if (this.cAt != null) {
                gifView = this.cAt.jA();
            }
            if (gifView == null || gifView.getParent() != null) {
                gifView = new GifView(getContext());
            }
            gifView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            gifView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
            gifView.setBorderSurroundContent(true);
            gifView.setDrawCorner(true);
            gifView.setDrawBorder(true);
            gifView.setRadius(this.cAz);
            gifView.setOnClickListener(this.mOnClickListener);
            gifView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            gifView.setIsLongPic(tbRichTextImageInfo.asW());
            if (i == 8 && !ap.isEmpty(this.cAx)) {
                gifView.setLongIconSupport(false);
                gifView.setGifIconSupport(false);
            } else {
                gifView.setLongIconSupport(true);
                gifView.setGifIconSupport(true);
            }
            if (this.cAu.cCc) {
                gifView.setSupportNoImage(true);
            }
            gifView.setDefaultNoImageDay(al.hu(d.f.icon_click));
            String asS = tbRichTextImageInfo.asS();
            if (StringUtils.isNull(asS)) {
                if (this.cAu.asv()) {
                    asS = this.cAu.mIsFromCDN ? tbRichTextImageInfo.asO() : tbRichTextImageInfo.asQ();
                }
                if (StringUtils.isNull(asS)) {
                    asS = this.cAu.mIsFromCDN ? tbRichTextImageInfo.asR() : tbRichTextImageInfo.Nx();
                }
            }
            gifView.setShowStaticDrawable(false);
            gifView.ad(asS, 38);
            a(gifView, i, f, tbRichTextImageInfo.asW());
        }
    }

    private void b(int i, float f, TbRichTextImageInfo tbRichTextImageInfo) {
        if (tbRichTextImageInfo != null && this.cAu != null) {
            TbImageView tbImageView = null;
            if (this.cAs != null) {
                tbImageView = this.cAs.jA();
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
                tbImageView2.setRadius(this.cAz);
                tbImageView2.setOnClickListener(this.mOnClickListener);
                tbImageView2.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                tbImageView2.setIsLongPic(tbRichTextImageInfo.asW());
                if (i == 8 && !ap.isEmpty(this.cAx)) {
                    tbImageView2.setLongIconSupport(false);
                    tbImageView2.setGifIconSupport(false);
                } else {
                    tbImageView2.setLongIconSupport(true);
                    tbImageView2.setGifIconSupport(true);
                }
                if (this.cAu.cCc) {
                    tbImageView2.setSupportNoImage(true);
                }
                tbImageView2.startLoad(this.cAu.asv() ? tbRichTextImageInfo.asO() : tbRichTextImageInfo.asR(), this.cAu.mIsFromCDN ? 13 : 14, false);
                if (!tbRichTextImageInfo.asT()) {
                    tbImageView2.setAdjustViewBounds(false);
                }
                a(tbImageView, i, f, tbRichTextImageInfo.asW());
            }
        }
    }

    private void a(ImageView imageView, int i, float f, boolean z) {
        int i2;
        int i3;
        if (imageView != null && this.cAu != null) {
            int i4 = this.cAu.cCn - (this.cAw * 2);
            if (this.mSize == 1) {
                if (z) {
                    i2 = i4 / 3;
                    i3 = ((i4 * 2) / 3) + this.cAw;
                } else {
                    i2 = ((i4 * 2) / 3) + this.cAw;
                    i3 = ((i4 * 2) / 3) + this.cAw;
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
            imageView.setId(this.cAA[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int ap = ap(i2, i3 - 1);
            int ap2 = ap(i4, i3);
            if (ap2 >= 0) {
                layoutParams.addRule(3, ap2);
                layoutParams.topMargin = this.cAw;
            }
            if (ap >= 0) {
                layoutParams.addRule(1, ap);
                layoutParams.leftMargin = this.cAw;
            }
            p(imageView, i);
        }
    }

    private int ap(int i, int i2) {
        if (aq(i, i2)) {
            return this.cAA[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
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
