package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
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
    private View.OnClickListener Mz;
    private int dHX;
    private com.baidu.adp.lib.d.b<ImageView> dHY;
    private com.baidu.adp.lib.d.b<GifView> dHZ;
    private Paint dHw;
    private int dHx;
    private com.baidu.tbadk.widget.richText.a dIa;
    private ArrayList<TbRichTextImageInfo> dIb;
    private int dIc;
    private String dId;
    private RectF dIe;
    private int dIf;
    private boolean dIg;
    private int[] dIh;
    private TbRichTextView.i dIi;
    private Paint mBitmapPaint;
    private boolean mIsHost;
    private Bitmap mMaskBitmap;
    private View.OnClickListener mOnClickListener;
    private int mSize;
    private int textHeight;
    private Paint textPaint;

    public GridImageLayout(Context context) {
        super(context);
        this.dHX = 0;
        this.dHY = null;
        this.dHZ = null;
        this.textHeight = 0;
        this.dIg = true;
        this.dIh = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.dIi != null && GridImageLayout.this.dIb != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.dIi.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.Mz != null) {
                    GridImageLayout.this.Mz.onClick(view);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHX = 0;
        this.dHY = null;
        this.dHZ = null;
        this.textHeight = 0;
        this.dIg = true;
        this.dIh = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.dIi != null && GridImageLayout.this.dIb != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.dIi.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.Mz != null) {
                    GridImageLayout.this.Mz.onClick(view);
                }
            }
        };
        init();
    }

    public GridImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dHX = 0;
        this.dHY = null;
        this.dHZ = null;
        this.textHeight = 0;
        this.dIg = true;
        this.dIh = new int[]{R.id.grid_image_0, R.id.grid_image_1, R.id.grid_image_2, R.id.grid_image_3, R.id.grid_image_4, R.id.grid_image_5, R.id.grid_image_6, R.id.grid_image_7, R.id.grid_image_8};
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.GridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GridImageLayout.this.dIi != null && GridImageLayout.this.dIb != null) {
                    int indexOfChild = GridImageLayout.this.indexOfChild(view);
                    String str = "";
                    if (view instanceof TbImageView) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                    GridImageLayout.this.dIi.a(view, str, indexOfChild, GridImageLayout.this.mIsHost, true);
                }
                if (GridImageLayout.this.Mz != null) {
                    GridImageLayout.this.Mz.onClick(view);
                }
            }
        };
        init();
    }

    private void init() {
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.dHw = new Paint();
        this.dHw.setAntiAlias(true);
        this.textPaint = new Paint();
        this.textPaint.setColor(am.getColor(R.color.cp_cont_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.dHx = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.dIf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Mz = onClickListener;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        this.dIa = aVar;
        if (this.dIa != null) {
            this.dIc = this.dIa.dJL;
        }
    }

    public void setObjectPool(com.baidu.adp.lib.d.b<ImageView> bVar, com.baidu.adp.lib.d.b<GifView> bVar2) {
        this.dHY = bVar;
        this.dHZ = bVar2;
    }

    public void setCornerStyle(int i) {
        this.dHX = i;
    }

    public void clearData() {
        this.dIb = null;
    }

    public void setData(ArrayList<TbRichTextImageInfo> arrayList) {
        if (!v.isEmpty(arrayList) && !G(arrayList) && this.dIa != null) {
            this.dIb = arrayList;
            this.mSize = arrayList.size();
            this.dId = this.mSize > 9 ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(this.mSize - 9)}) : "";
            aQR();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!aq.isEmpty(this.dId) && (childCount = getChildCount()) == 9) {
            View childAt = getChildAt(childCount - 1);
            if ((childAt instanceof TbImageView) || (childAt instanceof GifView)) {
                if (this.dIe == null) {
                    this.dIe = new RectF();
                }
                this.dIe.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                a(canvas, this.dIe, childAt instanceof TbImageView ? ((TbImageView) childAt).getRadius() : ((GifView) childAt).getRadius());
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
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.dHw);
            canvas.drawText(this.dId, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.dId)) / 2), (((int) rectF.centerY()) + (this.textHeight / 2)) - this.dHx, this.textPaint);
        }
    }

    private boolean G(ArrayList<TbRichTextImageInfo> arrayList) {
        return v.equalList(this.dIb, arrayList);
    }

    private void aQR() {
        if (!v.isEmpty(this.dIb)) {
            removeAllViews();
            if (this.mSize == 1) {
                aQS();
            } else {
                aQT();
            }
        }
    }

    private void aQS() {
        TbRichTextImageInfo tbRichTextImageInfo;
        if (!v.isEmpty(this.dIb) && (tbRichTextImageInfo = this.dIb.get(0)) != null) {
            int width = tbRichTextImageInfo.getWidth();
            int height = tbRichTextImageInfo.getHeight();
            if (height > 0) {
                float f = (width * 1.0f) / height;
                if (this.dIg && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.aRE()) {
                    a(0, f, tbRichTextImageInfo);
                } else {
                    b(0, f, tbRichTextImageInfo);
                }
            }
        }
    }

    private void aQT() {
        if (!v.isEmpty(this.dIb)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSize && i2 < 9) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.dIb.get(i2);
                    if (tbRichTextImageInfo != null) {
                        int width = tbRichTextImageInfo.getWidth();
                        int height = tbRichTextImageInfo.getHeight();
                        if (height > 0) {
                            float f = (width * 1.0f) / height;
                            if (this.dIg && TbadkCoreApplication.getInst().isGifAutoPlay() && !tbRichTextImageInfo.aRE()) {
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
        if (tbRichTextImageInfo != null && this.dIa != null) {
            GifView gifView = null;
            if (this.dHZ != null) {
                gifView = this.dHZ.borrowObject();
            }
            if (gifView == null || gifView.getParent() != null) {
                gifView = new GifView(getContext());
            }
            gifView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            gifView.setBorderColor(am.getColor(R.color.cp_border_a));
            gifView.setBorderSurroundContent(true);
            gifView.setDrawCorner(true);
            gifView.setDrawBorder(true);
            gifView.setRadius(this.dIf);
            gifView.setOnClickListener(this.mOnClickListener);
            if (this.mSize == 1) {
                gifView.setPlaceHolder(3);
            } else {
                gifView.setPlaceHolder(2);
            }
            gifView.setIsLongPic(tbRichTextImageInfo.aRE());
            if (i == 8 && !aq.isEmpty(this.dId)) {
                gifView.setLongIconSupport(false);
                gifView.setGifIconSupport(false);
            } else {
                gifView.setLongIconSupport(true);
                gifView.setGifIconSupport(true);
            }
            if (this.dIa.dJz) {
                gifView.setSupportNoImage(true);
            }
            gifView.setDefaultNoImageDay(am.kd(R.drawable.icon_click));
            String aRA = tbRichTextImageInfo.aRA();
            if (StringUtils.isNull(aRA)) {
                if (this.dIa.aRe()) {
                    aRA = this.dIa.mIsFromCDN ? tbRichTextImageInfo.aRw() : tbRichTextImageInfo.aRy();
                }
                if (StringUtils.isNull(aRA)) {
                    aRA = this.dIa.mIsFromCDN ? tbRichTextImageInfo.aRz() : tbRichTextImageInfo.getSrc();
                }
            }
            gifView.setShowStaticDrawable(false);
            gifView.af(aRA, 38);
            a(gifView, i, f, tbRichTextImageInfo.aRE());
        }
    }

    private void b(int i, float f, TbRichTextImageInfo tbRichTextImageInfo) {
        String str = null;
        if (tbRichTextImageInfo != null && this.dIa != null) {
            TbImageView borrowObject = this.dHY != null ? this.dHY.borrowObject() : null;
            if (borrowObject == null || borrowObject.getParent() != null) {
                borrowObject = new TbImageView(getContext());
            }
            if (borrowObject instanceof TbImageView) {
                TbImageView tbImageView = borrowObject;
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawCorner(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setRadius(this.dIf);
                tbImageView.setOnClickListener(this.mOnClickListener);
                if (this.mSize == 1) {
                    tbImageView.setPlaceHolder(3);
                } else {
                    tbImageView.setPlaceHolder(2);
                }
                tbImageView.setIsLongPic(tbRichTextImageInfo.aRE());
                if (i == 8 && !aq.isEmpty(this.dId)) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                if (this.dIa.dJz) {
                    tbImageView.setSupportNoImage(true);
                }
                if (!this.dIg) {
                    String src = tbRichTextImageInfo.getSrc();
                    String aRC = tbRichTextImageInfo.aRC();
                    if (!TextUtils.isEmpty(aRC) && aRC.toLowerCase().contains(".gif")) {
                        tbImageView.setIsGifPic(true);
                    } else {
                        tbImageView.setIsGifPic(false);
                    }
                    tbImageView.startLoad(src, 13, false);
                } else {
                    if (this.dIa.aRe()) {
                        str = this.dIa.mIsFromCDN ? tbRichTextImageInfo.aRw() : tbRichTextImageInfo.aRy();
                    }
                    if (StringUtils.isNull(str)) {
                        str = this.dIa.mIsFromCDN ? tbRichTextImageInfo.aRz() : tbRichTextImageInfo.getSrc();
                    }
                    tbImageView.startLoad(str, this.dIa.mIsFromCDN ? 13 : 14, false);
                }
                if (!tbRichTextImageInfo.aRB()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                a(borrowObject, i, f, tbRichTextImageInfo.aRE());
            }
        }
    }

    private void a(ImageView imageView, int i, float f, boolean z) {
        int i2;
        int i3;
        if (imageView != null && this.dIa != null) {
            int i4 = this.dIa.dJK - (this.dIc * 2);
            if (this.mSize == 1) {
                if (z) {
                    i2 = i4 / 3;
                    i3 = ((i4 * 2) / 3) + this.dIc;
                } else {
                    i2 = ((i4 * 2) / 3) + this.dIc;
                    i3 = ((i4 * 2) / 3) + this.dIc;
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
            imageView.setId(this.dIh[i]);
            int i2 = this.mSize == 4 ? i / 2 : i / 3;
            int i3 = this.mSize == 4 ? i % 2 : i % 3;
            int i4 = i2 - 1;
            int aM = aM(i2, i3 - 1);
            int aM2 = aM(i4, i3);
            if (aM2 >= 0) {
                layoutParams.addRule(3, aM2);
                layoutParams.topMargin = this.dIc;
            }
            if (aM >= 0) {
                layoutParams.addRule(1, aM);
                layoutParams.leftMargin = this.dIc;
            }
            j(imageView, 15);
        }
    }

    private int aM(int i, int i2) {
        if (aN(i, i2)) {
            return this.dIh[this.mSize == 4 ? (i * 2) + i2 : (i * 3) + i2];
        }
        return -1;
    }

    private boolean aN(int i, int i2) {
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

    public void setSupportGifPlay(boolean z) {
        this.dIg = z;
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
}
