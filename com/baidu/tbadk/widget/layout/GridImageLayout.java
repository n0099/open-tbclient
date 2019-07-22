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
    private int Pl;
    private Bitmap YS;
    private int cJA;
    private com.baidu.adp.lib.e.b<ImageView> cJY;
    private com.baidu.adp.lib.e.b<GifView> cJZ;
    private Paint cJz;
    private com.baidu.tbadk.widget.richText.a cKa;
    private ArrayList<TbRichTextImageInfo> cKb;
    private int cKc;
    private String cKd;
    private RectF cKe;
    private int cKf;
    private int[] cKg;
    private TbRichTextView.h cKh;
    private boolean mIsHost;
    private View.OnClickListener mOnClickListener;
    private int mSize;
    private Paint textPaint;

    public GridImageLayout(Context context) {
        super(context);
        this.cJY = null;
        this.cJZ = null;
        this.Pl = 0;
        this.cKg = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cKh != null && GridImageLayout.this.cKb != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cKh.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJY = null;
        this.cJZ = null;
        this.Pl = 0;
        this.cKg = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cKh != null && GridImageLayout.this.cKb != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cKh.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cJY = null;
        this.cJZ = null;
        this.Pl = 0;
        this.cKg = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.cKh != null && GridImageLayout.this.cKb != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.cKh.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
            }
        };
        init();
    }

    private void init() {
        this.Mi = new Paint();
        this.Mi.setAntiAlias(true);
        this.Mi.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cJz = new Paint();
        this.cJz.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(am.getColor(R.color.cp_btn_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.Pl = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.cJA = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.cKf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKh = hVar;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.cKa = aVar;
        if (this.cKa != null) {
            this.cKc = this.cKa.cLU;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.e.b<ImageView> bVar, com.baidu.adp.lib.e.b<GifView> bVar2) {
        this.cJY = bVar;
        this.cJZ = bVar2;
    }

    public void clearData() {
        this.cKb = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!v.aa(arrayList) && !B(arrayList) && this.cKa != null) {
            this.cKb = arrayList;
            this.mSize = arrayList.size();
            this.cKd = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            ayt();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!aq.isEmpty(this.cKd) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.cKe == null) {
                    this.cKe = new RectF();
                }
                this.cKe.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.cKe, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
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
            canvas.drawBitmap(this.YS, rectF.left, rectF.top, this.cJz);
            canvas.drawText(this.cKd, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.cKd)) / 2), (((int) rectF.centerY()) + (this.Pl / 2)) - this.cJA, this.textPaint);
        }
    }

    private boolean B(ArrayList<TbRichTextImageInfo> arrayList) {
        return v.c(this.cKb, arrayList);
    }

    private void ayt() {
        if (!v.aa(this.cKb)) {
            removeAllViews();
            if (this.mSize == 1) {
                ayu();
            } else {
                ayv();
            }
        }
    }

    private void ayu() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!v.aa(this.cKb) && (tbRichTextImageInfo = this.cKb.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.azl()) {
                    a(0, f, tbRichTextImageInfo);
                } else {
                    b(0, f, tbRichTextImageInfo);
                }
            }
        }
    }

    private void ayv() {
        if (!v.aa(this.cKb)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.cKb.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (height > 0) {
                            float f = (width * 1.0f) / height;
                            if (TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.azl()) {
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
        if (tbRichTextImageInfo != null && this.cKa != null) {
            GifView gifView = null;
            if (this.cJZ != null) {
                gifView = this.cJZ.iD();
            }
            if (gifView == null || gifView.getParent() != null) {
                gifView = new GifView(getContext());
            }
            gifView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            gifView.setBorderColor(am.getColor(R.color.black_alpha8));
            gifView.setBorderSurroundContent(true);
            gifView.setDrawCorner(true);
            gifView.setDrawBorder(true);
            gifView.setRadius(this.cKf);
            gifView.setOnClickListener(this.mOnClickListener);
            gifView.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            gifView.setIsLongPic(tbRichTextImageInfo.azl());
            if (i == 8 && !aq.isEmpty(this.cKd)) {
                gifView.setLongIconSupport(false);
                gifView.setGifIconSupport(false);
            } else {
                gifView.setLongIconSupport(true);
                gifView.setGifIconSupport(true);
            }
            if (this.cKa.cLI) {
                gifView.setSupportNoImage(true);
            }
            gifView.setDefaultNoImageDay(am.in(R.drawable.icon_click));
            String azh = tbRichTextImageInfo.azh();
            if (StringUtils.isNull(azh)) {
                if (this.cKa.ayK()) {
                    azh = this.cKa.mIsFromCDN ? tbRichTextImageInfo.azd() : tbRichTextImageInfo.azf();
                }
                if (StringUtils.isNull(azh)) {
                    azh = this.cKa.mIsFromCDN ? tbRichTextImageInfo.azg() : tbRichTextImageInfo.getSrc();
                }
            }
            gifView.setShowStaticDrawable(false);
            gifView.Z(azh, 38);
            a(gifView, i, f, tbRichTextImageInfo.azl());
        }
    }

    private void b(int i, float f, TbRichTextImageInfo tbRichTextImageInfo) {
        if (tbRichTextImageInfo != null && this.cKa != null) {
            TbImageView tbImageView = null;
            if (this.cJY != null) {
                tbImageView = this.cJY.iD();
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
                tbImageView2.setRadius(this.cKf);
                tbImageView2.setOnClickListener(this.mOnClickListener);
                tbImageView2.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
                tbImageView2.setIsLongPic(tbRichTextImageInfo.azl());
                if (i == 8 && !aq.isEmpty(this.cKd)) {
                    tbImageView2.setLongIconSupport(false);
                    tbImageView2.setGifIconSupport(false);
                } else {
                    tbImageView2.setLongIconSupport(true);
                    tbImageView2.setGifIconSupport(true);
                }
                if (this.cKa.cLI) {
                    tbImageView2.setSupportNoImage(true);
                }
                tbImageView2.startLoad(this.cKa.ayK() ? tbRichTextImageInfo.azd() : tbRichTextImageInfo.azg(), this.cKa.mIsFromCDN ? 13 : 14, false);
                if (!tbRichTextImageInfo.azi()) {
                    tbImageView2.setAdjustViewBounds(false);
                }
                a(tbImageView, i, f, tbRichTextImageInfo.azl());
            }
        }
    }

    private void a(ImageView imageView, int i, float f, boolean z) {
        int i2;
        int i3;
        if (imageView != null && this.cKa != null) {
            int i4 = this.cKa.cLT - (this.cKc * 2);
            if (this.mSize == 1) {
                if (z) {
                    i2 = i4 / 3;
                    i3 = ((i4 * 2) / 3) + this.cKc;
                } else {
                    i2 = ((i4 * 2) / 3) + this.cKc;
                    i3 = ((i4 * 2) / 3) + this.cKc;
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
            imageView.setId(this.cKg[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int at = at(i2, i3 - 1);
            int at2 = at(i4, i3);
            if (at2 >= 0) {
                layoutParams.addRule(3, at2);
                layoutParams.topMargin = this.cKc;
            }
            if (at >= 0) {
                layoutParams.addRule(1, at);
                layoutParams.leftMargin = this.cKc;
            }
            p(imageView, i);
        }
    }

    private int at(int i, int i2) {
        if (au(i, i2)) {
            return this.cKg[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
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
