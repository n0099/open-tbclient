package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private int Ha;
    private Paint aOU;
    protected com.baidu.adp.lib.e.b<TbImageView> aTB;
    private int aTC;
    private int aTD;
    private int aTE;
    private String aTF;
    private Paint aTG;
    private int aTH;
    private int aTI;
    private Bitmap aTJ;
    protected boolean aTK;
    private ViewGroup.OnHierarchyChangeListener aTL;
    protected BdUniqueId aTr;
    private double aTw;
    private c aTx;
    private boolean akC;
    private TbImageView.b mOnDrawListener;

    public ConstrainImageLayout(Context context) {
        super(context);
        this.aTD = -1;
        this.akC = false;
        this.aTE = d.C0126d.common_color_10082;
        this.Ha = 0;
        this.aTK = false;
        this.aTL = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof TbImageView) && ConstrainImageLayout.this.aTB != null) {
                    TbImageView tbImageView = (TbImageView) view3;
                    tbImageView.reset();
                    ConstrainImageLayout.this.aTB.m(tbImageView);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.Fa().gG(com.baidu.adp.lib.f.c.fp().f(tbImageView.getUrl(), ConstrainImageLayout.this.akC ? 13 : 14));
                    if (gG != null) {
                        int width = gG.getWidth();
                        i = gG.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (ConstrainImageLayout.this.aTK && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
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

    public ConstrainImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTD = -1;
        this.akC = false;
        this.aTE = d.C0126d.common_color_10082;
        this.Ha = 0;
        this.aTK = false;
        this.aTL = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof TbImageView) && ConstrainImageLayout.this.aTB != null) {
                    TbImageView tbImageView = (TbImageView) view3;
                    tbImageView.reset();
                    ConstrainImageLayout.this.aTB.m(tbImageView);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.Fa().gG(com.baidu.adp.lib.f.c.fp().f(tbImageView.getUrl(), ConstrainImageLayout.this.akC ? 13 : 14));
                    if (gG != null) {
                        int width = gG.getWidth();
                        i = gG.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (ConstrainImageLayout.this.aTK && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
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

    public ConstrainImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTD = -1;
        this.akC = false;
        this.aTE = d.C0126d.common_color_10082;
        this.Ha = 0;
        this.aTK = false;
        this.aTL = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof TbImageView) && ConstrainImageLayout.this.aTB != null) {
                    TbImageView tbImageView = (TbImageView) view3;
                    tbImageView.reset();
                    ConstrainImageLayout.this.aTB.m(tbImageView);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i2;
                int i22;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.Fa().gG(com.baidu.adp.lib.f.c.fp().f(tbImageView.getUrl(), ConstrainImageLayout.this.akC ? 13 : 14));
                    if (gG != null) {
                        int width = gG.getWidth();
                        i2 = gG.getHeight();
                        i22 = width;
                    } else {
                        i2 = 0;
                        i22 = 0;
                    }
                    if (i22 != 0 && i2 != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i22 * height > width2 * i2) {
                                f4 = height / i2;
                            } else {
                                f4 = width2 / i22;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i22 * height > width2 * i2) {
                                float f5 = height / i2;
                                f2 = f5;
                                f3 = (width2 - (i22 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i22;
                                f = (height - (i2 * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (ConstrainImageLayout.this.aTK && i2 > i22) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
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
        setOnHierarchyChangeListener(this.aTL);
        this.aOU = new Paint();
        this.aOU.setColor(ak.getColor(d.C0126d.cp_cont_i));
        this.aOU.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize26));
        this.aOU.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aOU.getFontMetrics();
        this.Ha = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aTH = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.aTG = new Paint();
        this.aTG.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.black_alpha40));
        this.aTG.setAntiAlias(true);
        this.aTJ = ak.cN(d.f.icon_image_home_n);
    }

    public void setImageClickListener(c cVar) {
        if (cVar == null) {
            setClickable(false);
        } else {
            this.aTx = cVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aTB = bVar;
    }

    public void setFromCDN(boolean z) {
        this.akC = z;
    }

    public void setForeColorId(int i) {
        this.aTE = i;
    }

    public void setExtraCenterText(String str) {
        this.aTF = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aTD = i;
        } else {
            this.aTD = -1;
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

    public void setUrls(List<MediaData> list, int i) {
        setUrls(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aTw = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        int v;
        if (this.aTB != null && (v = v.v(list)) > 0) {
            fG(v);
            int childCount = getChildCount();
            int i2 = this.akC ? 13 : 14;
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
                    if (!an.equals(a2, tbImageView.getUrl())) {
                        tbImageView.reset();
                    }
                    boolean isLongPic = mediaData.isLongPic();
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setIsLongPic(isLongPic);
                    tbImageView.setForegroundColor(0);
                    tbImageView.setOnDrawListener(this.mOnDrawListener);
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.aTK = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.aTx != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).a(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aTx == null && tbImageView != null) {
            tbImageView.setClickable(false);
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
        private boolean aTN;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aTN = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (ConstrainImageLayout.this.aTx != null) {
                ConstrainImageLayout.this.aTx.c(view2, this.currentIndex, this.hasMore && this.aTN);
            }
        }
    }

    public void setImagePadding(int i) {
        this.aTC = i;
    }

    private void fG(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fn = this.aTB.fn();
                fn.setContentDescription(getResources().getString(d.k.editor_image));
                fn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fn.setDefaultBg(ak.getDrawable(d.C0126d.common_color_10220));
                fn.setPageId(this.aTr);
                addView(fn);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aTD);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aTC)) / max;
            int i4 = this.aTw > 0.0d ? (int) ((i3 * this.aTw) + 0.5d) : i3;
            if (this.aTI > 0) {
                i4 = this.aTI;
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
                int i6 = (this.aTC + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aTF) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.aTF != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int e = measuredWidth - l.e(getContext(), d.e.tbds20);
        int e2 = measuredHeight - l.e(getContext(), d.e.tbds20);
        int measureText = (int) this.aOU.measureText(this.aTF);
        int i = 0;
        if (this.aTJ != null) {
            i = this.aTJ.getWidth();
        }
        return new RectF(e - ((i + measureText) + l.e(getContext(), d.e.tbds20)), e2 - l.e(getContext(), d.e.tbds48), e, e2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int e = l.e(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, e, e, this.aTG);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.aOU.measureText(this.aTF)) / 2);
            int i = ((this.Ha / 2) + centerY) - this.aTH;
            if (this.aTJ != null) {
                int width = this.aTJ.getWidth();
                int height = this.aTJ.getHeight();
                int e2 = ((int) rectF.left) + l.e(getContext(), d.e.tbds10);
                canvas.drawBitmap(this.aTJ, e2, centerY - (height / 2), (Paint) null);
                centerX = width + e2;
            }
            canvas.drawText(this.aTF, centerX, i, this.aOU);
        }
    }

    public void onChangeSkinType() {
        this.aOU.setColor(ak.getColor(d.C0126d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aTI = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTr = bdUniqueId;
    }
}
