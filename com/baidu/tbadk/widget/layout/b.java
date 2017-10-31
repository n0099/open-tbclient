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
    private Paint aNK;
    protected com.baidu.adp.lib.e.b<TbImageView> aPA;
    private int aPB;
    private int aPC;
    private int aPD;
    private String aPE;
    private Paint aPF;
    private int aPG;
    private int aPH;
    private int aPI;
    private Bitmap aPJ;
    private ViewGroup.OnHierarchyChangeListener aPK;
    protected BdUniqueId aPq;
    private double aPv;
    private d aPw;
    private boolean aiR;
    private TbImageView.b mOnDrawListener;

    public b(Context context) {
        super(context);
        this.aPC = -1;
        this.aiR = false;
        this.aPD = d.C0080d.common_color_10082;
        this.aPG = 0;
        this.aPK = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aPA != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    b.this.aPA.m(tbImageView);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.b.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                float f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    int loadedWidth = tbImageView.getLoadedWidth();
                    int loadedHeight = tbImageView.getLoadedHeight();
                    if (loadedWidth != 0 && loadedHeight != 0) {
                        int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        if (loadedWidth * height > width * loadedHeight) {
                            f = height / loadedHeight;
                        } else {
                            f = width / loadedWidth;
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
        setOnHierarchyChangeListener(this.aPK);
        this.aNK = new Paint();
        this.aNK.setColor(aj.getColor(d.C0080d.cp_cont_i));
        this.aNK.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize20));
        this.aNK.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aNK.getFontMetrics();
        this.aPG = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aPH = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.aPF = new Paint();
        this.aPF.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0080d.black_alpha40));
        this.aPF.setAntiAlias(true);
        this.aPJ = aj.cR(d.f.icon_image_home_n);
    }

    public void setImageClickListener(d dVar) {
        this.aPw = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aPA = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aiR = z;
    }

    public void setForeColorId(int i) {
        this.aPD = i;
    }

    public void setExtraCenterText(String str) {
        this.aPE = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aPC = i;
        } else {
            this.aPC = -1;
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
        this.aPv = d;
    }

    public void a(List<MediaData> list, int i, boolean z) {
        int u;
        if (this.aPA != null && (u = v.u(list)) > 0) {
            fI(u);
            int childCount = getChildCount();
            int i2 = this.aiR ? 13 : 14;
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
        if (this.aPw != null && tbImageView != null) {
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
        private boolean aPM;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aPM = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.aPw != null) {
                b.this.aPw.c(view, this.currentIndex, this.hasMore && this.aPM);
            }
        }
    }

    public void setImagePadding(int i) {
        this.aPB = i;
    }

    private void fI(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fH = this.aPA.fH();
                fH.setContentDescription(getResources().getString(d.j.editor_image));
                fH.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fH.setDefaultBg(aj.getDrawable(d.C0080d.common_color_10220));
                fH.setPageId(this.aPq);
                addView(fH);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aPC);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aPB)) / max;
            int i4 = this.aPv > 0.0d ? (int) ((i3 * this.aPv) + 0.5d) : i3;
            if (this.aPI > 0) {
                i4 = this.aPI;
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
                int i6 = (this.aPB + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aPE) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.aPE != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int f = measuredWidth - l.f(getContext(), d.e.ds16);
        int f2 = measuredHeight - l.f(getContext(), d.e.ds16);
        int measureText = (int) this.aNK.measureText(this.aPE);
        int i = 0;
        if (this.aPJ != null) {
            i = this.aPJ.getWidth();
        }
        return new RectF(f - ((i + measureText) + l.f(getContext(), d.e.ds24)), f2 - l.f(getContext(), d.e.ds36), f, f2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int f = l.f(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, f, f, this.aPF);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.aNK.measureText(this.aPE)) / 2);
            int i = ((this.aPG / 2) + centerY) - this.aPH;
            if (this.aPJ != null) {
                int width = this.aPJ.getWidth();
                int height = this.aPJ.getHeight();
                int f2 = ((int) rectF.left) + l.f(getContext(), d.e.ds8);
                canvas.drawBitmap(this.aPJ, f2, centerY - (height / 2), (Paint) null);
                centerX = width + f2;
            }
            canvas.drawText(this.aPE, centerX, i, this.aNK);
        }
    }

    public void onChangeSkinType() {
        this.aNK.setColor(aj.getColor(d.C0080d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aPI = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPq = bdUniqueId;
    }
}
