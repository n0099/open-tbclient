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
    private boolean aQq;
    private boolean aYZ;
    private Paint bEx;
    private double bID;
    private d bIE;
    protected com.baidu.adp.lib.e.b<TbImageView> bII;
    private int bIJ;
    private int bIK;
    private int bIL;
    private String bIM;
    private Paint bIN;
    private int bIO;
    private int bIP;
    private int bIQ;
    private Bitmap bIR;
    protected boolean bIS;
    private ViewGroup.OnHierarchyChangeListener bIT;
    protected BdUniqueId bIy;
    private TbImageView.b mOnDrawListener;

    public b(Context context) {
        super(context);
        this.bIK = -1;
        this.aYZ = false;
        this.bIL = d.C0141d.common_color_10082;
        this.bIO = 0;
        this.aQq = false;
        this.bIS = false;
        this.bIT = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.bII != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    b.this.bII.ar(tbImageView);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.b.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mx().gP(com.baidu.adp.lib.f.c.nm().g(tbImageView.getUrl(), b.this.aYZ ? 13 : 14));
                    if (gP != null) {
                        int width = gP.getWidth();
                        i = gP.getHeight();
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
                            if (b.this.bIS && i > i2) {
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
        setOnHierarchyChangeListener(this.bIT);
        this.bEx = new Paint();
        this.bEx.setColor(aj.getColor(d.C0141d.cp_cont_i));
        this.bEx.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize26));
        this.bEx.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.bEx.getFontMetrics();
        this.bIO = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.bIP = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.bIN = new Paint();
        this.bIN.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.black_alpha40));
        this.bIN.setAntiAlias(true);
        this.bIR = aj.fO(d.f.icon_image_home_n);
    }

    public void setImageClickListener(d dVar) {
        this.bIE = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bII = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aYZ = z;
    }

    public void setForeColorId(int i) {
        this.bIL = i;
    }

    public void setExtraCenterText(String str) {
        this.bIM = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.bIK = i;
        } else {
            this.bIK = -1;
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
        c(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.bID = d;
    }

    public void c(List<MediaData> list, int i, boolean z) {
        int D;
        if (this.bII != null && (D = v.D(list)) > 0) {
            iG(D);
            int childCount = getChildCount();
            int i2 = this.aYZ ? 13 : 14;
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
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setIsLongPic(isLongPic);
                    tbImageView.setForegroundColor(0);
                    tbImageView.setOnDrawListener(this.mOnDrawListener);
                    tbImageView.startLoad(a2, i2, false);
                    tbImageView.changeGrayScaleMode(this.aQq);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.bIS = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.bIE != null && tbImageView != null) {
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
        private boolean bIV;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.bIV = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.bIE != null) {
                b.this.bIE.f(view, this.currentIndex, this.hasMore && this.bIV);
            }
        }
    }

    public void setImagePadding(int i) {
        this.bIJ = i;
    }

    private void iG(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView nk = this.bII.nk();
                nk.setContentDescription(getResources().getString(d.j.editor_image));
                nk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                nk.setDefaultBg(aj.getDrawable(d.C0141d.common_color_10220));
                nk.setPageId(this.bIy);
                addView(nk);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.bIK);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.bIJ)) / max;
            int i4 = this.bID > 0.0d ? (int) ((i3 * this.bID) + 0.5d) : i3;
            if (this.bIQ > 0) {
                i4 = this.bIQ;
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
                int i6 = (this.bIJ + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.bIM) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.bIM != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int t = measuredWidth - l.t(getContext(), d.e.tbds20);
        int t2 = measuredHeight - l.t(getContext(), d.e.tbds20);
        int measureText = (int) this.bEx.measureText(this.bIM);
        int i = 0;
        if (this.bIR != null) {
            i = this.bIR.getWidth();
        }
        return new RectF(t - ((i + measureText) + l.t(getContext(), d.e.tbds20)), t2 - l.t(getContext(), d.e.tbds48), t, t2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int t = l.t(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, t, t, this.bIN);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.bEx.measureText(this.bIM)) / 2);
            int i = ((this.bIO / 2) + centerY) - this.bIP;
            if (this.bIR != null) {
                int width = this.bIR.getWidth();
                int height = this.bIR.getHeight();
                int t2 = ((int) rectF.left) + l.t(getContext(), d.e.tbds10);
                canvas.drawBitmap(this.bIR, t2, centerY - (height / 2), (Paint) null);
                centerX = width + t2;
            }
            canvas.drawText(this.bIM, centerX, i, this.bEx);
        }
    }

    public void onChangeSkinType() {
        this.bEx.setColor(aj.getColor(d.C0141d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.bIQ = i;
    }

    public void setGrayScaleMode(boolean z) {
        this.aQq = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bIy = bdUniqueId;
    }
}
