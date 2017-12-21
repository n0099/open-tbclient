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
    private Paint aOz;
    protected BdUniqueId aSB;
    private double aSG;
    private d aSH;
    protected com.baidu.adp.lib.e.b<TbImageView> aSL;
    private int aSM;
    private int aSN;
    private int aSO;
    private String aSP;
    private Paint aSQ;
    private int aSR;
    private int aSS;
    private int aST;
    private Bitmap aSU;
    private ViewGroup.OnHierarchyChangeListener aSV;
    private boolean ajk;
    private TbImageView.b mOnDrawListener;

    public b(Context context) {
        super(context);
        this.aSN = -1;
        this.ajk = false;
        this.aSO = d.C0095d.common_color_10082;
        this.aSR = 0;
        this.aSV = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aSL != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    b.this.aSL.m(tbImageView);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.b.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    int loadedWidth = tbImageView.getLoadedWidth();
                    int loadedHeight = tbImageView.getLoadedHeight();
                    com.baidu.adp.widget.a.a gr = com.baidu.tbadk.imageManager.c.EA().gr(com.baidu.adp.lib.f.c.fJ().f(tbImageView.getUrl(), b.this.ajk ? 13 : 14));
                    if (gr != null) {
                        i2 = gr.getWidth();
                        i = gr.getHeight();
                    } else {
                        i = loadedHeight;
                        i2 = loadedWidth;
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
        setOnHierarchyChangeListener(this.aSV);
        this.aOz = new Paint();
        this.aOz.setColor(aj.getColor(d.C0095d.cp_cont_i));
        this.aOz.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize26));
        this.aOz.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aOz.getFontMetrics();
        this.aSR = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aSS = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.aSQ = new Paint();
        this.aSQ.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0095d.black_alpha40));
        this.aSQ.setAntiAlias(true);
        this.aSU = aj.cR(d.f.icon_image_home_n);
    }

    public void setImageClickListener(d dVar) {
        this.aSH = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aSL = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ajk = z;
    }

    public void setForeColorId(int i) {
        this.aSO = i;
    }

    public void setExtraCenterText(String str) {
        this.aSP = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aSN = i;
        } else {
            this.aSN = -1;
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

    public void f(List<MediaData> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aSG = d;
    }

    public void a(List<MediaData> list, int i, boolean z) {
        int v;
        if (this.aSL != null && (v = v.v(list)) > 0) {
            fO(v);
            int childCount = getChildCount();
            int i2 = this.ajk ? 13 : 14;
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
        if (this.aSH != null && tbImageView != null) {
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
        private boolean aSX;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aSX = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.aSH != null) {
                b.this.aSH.c(view, this.currentIndex, this.hasMore && this.aSX);
            }
        }
    }

    public void setImagePadding(int i) {
        this.aSM = i;
    }

    private void fO(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fH = this.aSL.fH();
                fH.setContentDescription(getResources().getString(d.j.editor_image));
                fH.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fH.setDefaultBg(aj.getDrawable(d.C0095d.common_color_10220));
                fH.setPageId(this.aSB);
                addView(fH);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aSN);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aSM)) / max;
            int i4 = this.aSG > 0.0d ? (int) ((i3 * this.aSG) + 0.5d) : i3;
            if (this.aST > 0) {
                i4 = this.aST;
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
                int i6 = (this.aSM + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aSP) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.aSP != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int f = measuredWidth - l.f(getContext(), d.e.tbds20);
        int f2 = measuredHeight - l.f(getContext(), d.e.tbds20);
        int measureText = (int) this.aOz.measureText(this.aSP);
        int i = 0;
        if (this.aSU != null) {
            i = this.aSU.getWidth();
        }
        return new RectF(f - ((i + measureText) + l.f(getContext(), d.e.tbds20)), f2 - l.f(getContext(), d.e.tbds48), f, f2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int f = l.f(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, f, f, this.aSQ);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.aOz.measureText(this.aSP)) / 2);
            int i = ((this.aSR / 2) + centerY) - this.aSS;
            if (this.aSU != null) {
                int width = this.aSU.getWidth();
                int height = this.aSU.getHeight();
                int f2 = ((int) rectF.left) + l.f(getContext(), d.e.tbds10);
                canvas.drawBitmap(this.aSU, f2, centerY - (height / 2), (Paint) null);
                centerX = width + f2;
            }
            canvas.drawText(this.aSP, centerX, i, this.aOz);
        }
    }

    public void onChangeSkinType() {
        this.aOz.setColor(aj.getColor(d.C0095d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aST = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSB = bdUniqueId;
    }
}
