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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private int Nf;
    protected BdUniqueId aRF;
    private Paint aXM;
    private boolean atn;
    protected boolean bcA;
    private ViewGroup.OnHierarchyChangeListener bcB;
    private double bcm;
    private c bcn;
    protected com.baidu.adp.lib.e.b<TbImageView> bcr;
    private int bcs;
    private int bct;
    private int bcu;
    private String bcv;
    private Paint bcw;
    private int bcx;
    private int bcy;
    private Bitmap bcz;
    private TbImageView.b mOnDrawListener;

    public ConstrainImageLayout(Context context) {
        super(context);
        this.bct = -1;
        this.atn = false;
        this.bcu = d.C0142d.common_color_10082;
        this.Nf = 0;
        this.bcA = false;
        this.bcB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bcr != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bcr.p(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a hi = com.baidu.tbadk.imageManager.c.IV().hi(com.baidu.adp.lib.f.c.ig().f(tbImageView.getUrl(), ConstrainImageLayout.this.atn ? 13 : 14));
                    if (hi != null) {
                        int width = hi.getWidth();
                        i = hi.getHeight();
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
                            if (ConstrainImageLayout.this.bcA && i > i2) {
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
        this.bct = -1;
        this.atn = false;
        this.bcu = d.C0142d.common_color_10082;
        this.Nf = 0;
        this.bcA = false;
        this.bcB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bcr != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bcr.p(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a hi = com.baidu.tbadk.imageManager.c.IV().hi(com.baidu.adp.lib.f.c.ig().f(tbImageView.getUrl(), ConstrainImageLayout.this.atn ? 13 : 14));
                    if (hi != null) {
                        int width = hi.getWidth();
                        i = hi.getHeight();
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
                            if (ConstrainImageLayout.this.bcA && i > i2) {
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
        this.bct = -1;
        this.atn = false;
        this.bcu = d.C0142d.common_color_10082;
        this.Nf = 0;
        this.bcA = false;
        this.bcB = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bcr != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bcr.p(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a hi = com.baidu.tbadk.imageManager.c.IV().hi(com.baidu.adp.lib.f.c.ig().f(tbImageView.getUrl(), ConstrainImageLayout.this.atn ? 13 : 14));
                    if (hi != null) {
                        int width = hi.getWidth();
                        i2 = hi.getHeight();
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
                            if (ConstrainImageLayout.this.bcA && i2 > i22) {
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
        setOnHierarchyChangeListener(this.bcB);
        this.aXM = new Paint();
        this.aXM.setColor(am.getColor(d.C0142d.cp_cont_i));
        this.aXM.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize26));
        this.aXM.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aXM.getFontMetrics();
        this.Nf = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.bcx = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.bcw = new Paint();
        this.bcw.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0142d.black_alpha40));
        this.bcw.setAntiAlias(true);
        this.bcz = am.cR(d.f.icon_image_home_n);
    }

    public void setImageClickListener(c cVar) {
        if (cVar == null) {
            setClickable(false);
        } else {
            this.bcn = cVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bcr = bVar;
    }

    public void setFromCDN(boolean z) {
        this.atn = z;
    }

    public void setForeColorId(int i) {
        this.bcu = i;
    }

    public void setExtraCenterText(String str) {
        this.bcv = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.bct = i;
        } else {
            this.bct = -1;
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
        this.bcm = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        int z2;
        if (this.bcr != null && (z2 = w.z(list)) > 0) {
            fJ(z2);
            int childCount = getChildCount();
            int i2 = this.atn ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                MediaData mediaData = list.get(i3);
                if ((childAt instanceof TbImageView) && mediaData != null) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z3 = i3 == childCount + (-1);
                    a(tbImageView, i + i3, z, z3);
                    if (z3 && z) {
                        tbImageView.setLongIconSupport(false);
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setLongIconSupport(true);
                        tbImageView.setGifIconSupport(true);
                    }
                    String a2 = a(mediaData);
                    if (!ap.equals(a2, tbImageView.getUrl())) {
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
        this.bcA = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.bcn != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).a(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.bcn == null && tbImageView != null) {
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
        private boolean bcD;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.bcD = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.bcn != null) {
                ConstrainImageLayout.this.bcn.c(view, this.currentIndex, this.hasMore && this.bcD);
            }
        }
    }

    public void setImagePadding(int i) {
        this.bcs = i;
    }

    private void fJ(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView ie = this.bcr.ie();
                ie.setContentDescription(getResources().getString(d.k.editor_image));
                ie.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ie.setDefaultBg(am.getDrawable(d.C0142d.common_color_10220));
                ie.setPageId(this.aRF);
                addView(ie);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.bct);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.bcs)) / max;
            int i4 = this.bcm > 0.0d ? (int) ((i3 * this.bcm) + 0.5d) : i3;
            if (this.bcy > 0) {
                i4 = this.bcy;
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
                int i6 = (this.bcs + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.bcv) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.bcv != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int e = measuredWidth - l.e(getContext(), d.e.tbds20);
        int e2 = measuredHeight - l.e(getContext(), d.e.tbds20);
        int measureText = (int) this.aXM.measureText(this.bcv);
        int i = 0;
        if (this.bcz != null) {
            i = this.bcz.getWidth();
        }
        return new RectF(e - ((i + measureText) + l.e(getContext(), d.e.tbds20)), e2 - l.e(getContext(), d.e.tbds48), e, e2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int e = l.e(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, e, e, this.bcw);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.aXM.measureText(this.bcv)) / 2);
            int i = ((this.Nf / 2) + centerY) - this.bcx;
            if (this.bcz != null) {
                int width = this.bcz.getWidth();
                int height = this.bcz.getHeight();
                int e2 = ((int) rectF.left) + l.e(getContext(), d.e.tbds10);
                canvas.drawBitmap(this.bcz, e2, centerY - (height / 2), (Paint) null);
                centerX = width + e2;
            }
            canvas.drawText(this.bcv, centerX, i, this.aXM);
        }
    }

    public void onChangeSkinType() {
        this.aXM.setColor(am.getColor(d.C0142d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.bcy = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aRF = bdUniqueId;
    }
}
