package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class b extends ViewGroup {
    private boolean aXt;
    private Paint bCm;
    private int bGA;
    private int bGB;
    private String bGC;
    private Paint bGD;
    private int bGE;
    private int bGF;
    private int bGG;
    private Bitmap bGH;
    private ViewGroup.OnHierarchyChangeListener bGI;
    protected BdUniqueId bGo;
    private double bGt;
    private d bGu;
    protected com.baidu.adp.lib.e.b<TbImageView> bGy;
    private int bGz;
    private TbImageView.b mOnDrawListener;

    public b(Context context) {
        super(context);
        this.bGA = -1;
        this.aXt = false;
        this.bGB = d.C0108d.common_color_10082;
        this.bGE = 0;
        this.bGI = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.bGy != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    b.this.bGy.ar(tbImageView);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.b.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                float f;
                int i2 = 0;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    com.baidu.adp.widget.a.a gx = com.baidu.tbadk.imageManager.c.Mb().gx(com.baidu.adp.lib.f.c.nl().g(tbImageView.getUrl(), b.this.aXt ? 13 : 14));
                    if (gx != null) {
                        i2 = gx.getWidth();
                        i = gx.getHeight();
                    } else {
                        i = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        if (i2 * height > width * i) {
                            f = height / i;
                        } else {
                            f = width / i2;
                        }
                        imageMatrix.setScale(f, f);
                        imageMatrix.postTranslate(0.0f, 0.0f);
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
        setOnHierarchyChangeListener(this.bGI);
        this.bCm = new Paint();
        this.bCm.setColor(aj.getColor(d.C0108d.cp_cont_i));
        this.bCm.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize26));
        this.bCm.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.bCm.getFontMetrics();
        this.bGE = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.bGF = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.bGD = new Paint();
        this.bGD.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0108d.black_alpha40));
        this.bGD.setAntiAlias(true);
        this.bGH = aj.fQ(d.f.icon_image_home_n);
    }

    public void setImageClickListener(d dVar) {
        this.bGu = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bGy = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aXt = z;
    }

    public void setForeColorId(int i) {
        this.bGB = i;
    }

    public void setExtraCenterText(String str) {
        this.bGC = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.bGA = i;
        } else {
            this.bGA = -1;
        }
    }

    public void reset() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.reset();
            }
        }
    }

    public void i(List<MediaData> list, int i) {
        b(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.bGt = d;
    }

    public void b(List<MediaData> list, int i, boolean z) {
        int F;
        if (this.bGy != null && (F = v.F(list)) > 0) {
            iN(F);
            int childCount = getChildCount();
            int i2 = this.aXt ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                MediaData mediaData = list.get(i3);
                if ((childAt instanceof TbImageView) && mediaData != null) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    a(tbImageView, i + i3, z, z2);
                    if (z2 && z) {
                        tbImageView.setLongIconSupport(false);
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setLongIconSupport(true);
                        tbImageView.setGifIconSupport(true);
                    }
                    String a2 = a(mediaData);
                    if (!am.equals(a2, tbImageView.getUrl())) {
                        tbImageView.reset();
                    }
                    boolean isLongPic = mediaData.isLongPic();
                    tbImageView.setScaleType(isLongPic ? ImageView.ScaleType.MATRIX : ImageView.ScaleType.CENTER_CROP);
                    tbImageView.setIsLongPic(isLongPic);
                    tbImageView.setForegroundColor(0);
                    tbImageView.setOnDrawListener(this.mOnDrawListener);
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.bGu != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        }
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean bGK;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.bGK = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.bGu != null) {
                b.this.bGu.f(view, this.currentIndex, this.hasMore && this.bGK);
            }
        }
    }

    public void setImagePadding(int i) {
        this.bGz = i;
    }

    private void iN(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView nj = this.bGy.nj();
                nj.setContentDescription(getResources().getString(d.j.editor_image));
                nj.setScaleType(ImageView.ScaleType.CENTER_CROP);
                nj.setDefaultBg(aj.getDrawable(d.C0108d.common_color_10220));
                nj.setPageId(this.bGo);
                addView(nj);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.bGA);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.bGz)) / max;
            int i4 = this.bGt > 0.0d ? (int) ((i3 * this.bGt) + 0.5d) : i3;
            if (this.bGG > 0) {
                i4 = this.bGG;
            }
            setMeasuredDimension(size, i4);
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int i6 = (this.bGz + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.bGC) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.bGC != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int s = measuredWidth - l.s(getContext(), d.e.tbds20);
        int s2 = measuredHeight - l.s(getContext(), d.e.tbds20);
        int measureText = (int) this.bCm.measureText(this.bGC);
        int i = 0;
        if (this.bGH != null) {
            i = this.bGH.getWidth();
        }
        return new RectF(s - ((i + measureText) + l.s(getContext(), d.e.tbds20)), s2 - l.s(getContext(), d.e.tbds48), s, s2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int s = l.s(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, s, s, this.bGD);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.bCm.measureText(this.bGC)) / 2);
            int i = ((this.bGE / 2) + centerY) - this.bGF;
            if (this.bGH != null) {
                int width = this.bGH.getWidth();
                int height = this.bGH.getHeight();
                int s2 = ((int) rectF.left) + l.s(getContext(), d.e.tbds10);
                canvas.drawBitmap(this.bGH, s2, centerY - (height / 2), (Paint) null);
                centerX = width + s2;
            }
            canvas.drawText(this.bGC, centerX, i, this.bCm);
        }
    }

    public void onChangeSkinType() {
        this.bCm.setColor(aj.getColor(d.C0108d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.bGG = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGo = bdUniqueId;
    }
}
