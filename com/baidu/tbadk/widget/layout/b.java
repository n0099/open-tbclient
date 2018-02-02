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
    private boolean aXA;
    private Paint bCD;
    protected BdUniqueId bGE;
    private double bGJ;
    private d bGK;
    protected com.baidu.adp.lib.e.b<TbImageView> bGO;
    private int bGP;
    private int bGQ;
    private int bGR;
    private String bGS;
    private Paint bGT;
    private int bGU;
    private int bGV;
    private int bGW;
    private Bitmap bGX;
    private ViewGroup.OnHierarchyChangeListener bGY;
    private TbImageView.b mOnDrawListener;

    public b(Context context) {
        super(context);
        this.bGQ = -1;
        this.aXA = false;
        this.bGR = d.C0108d.common_color_10082;
        this.bGU = 0;
        this.bGY = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.bGO != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    b.this.bGO.ar(tbImageView);
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
                    com.baidu.adp.widget.a.a gG = com.baidu.tbadk.imageManager.c.LR().gG(com.baidu.adp.lib.f.c.nm().g(tbImageView.getUrl(), b.this.aXA ? 13 : 14));
                    if (gG != null) {
                        i2 = gG.getWidth();
                        i = gG.getHeight();
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
        setOnHierarchyChangeListener(this.bGY);
        this.bCD = new Paint();
        this.bCD.setColor(aj.getColor(d.C0108d.cp_cont_i));
        this.bCD.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize26));
        this.bCD.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.bCD.getFontMetrics();
        this.bGU = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.bGV = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.bGT = new Paint();
        this.bGT.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0108d.black_alpha40));
        this.bGT.setAntiAlias(true);
        this.bGX = aj.fO(d.f.icon_image_home_n);
    }

    public void setImageClickListener(d dVar) {
        this.bGK = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bGO = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aXA = z;
    }

    public void setForeColorId(int i) {
        this.bGR = i;
    }

    public void setExtraCenterText(String str) {
        this.bGS = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.bGQ = i;
        } else {
            this.bGQ = -1;
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
        this.bGJ = d;
    }

    public void b(List<MediaData> list, int i, boolean z) {
        int D;
        if (this.bGO != null && (D = v.D(list)) > 0) {
            iJ(D);
            int childCount = getChildCount();
            int i2 = this.aXA ? 13 : 14;
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
        if (this.bGK != null && tbImageView != null) {
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
        private boolean bHa;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.bHa = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.bGK != null) {
                b.this.bGK.f(view, this.currentIndex, this.hasMore && this.bHa);
            }
        }
    }

    public void setImagePadding(int i) {
        this.bGP = i;
    }

    private void iJ(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView nk = this.bGO.nk();
                nk.setContentDescription(getResources().getString(d.j.editor_image));
                nk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                nk.setDefaultBg(aj.getDrawable(d.C0108d.common_color_10220));
                nk.setPageId(this.bGE);
                addView(nk);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.bGQ);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.bGP)) / max;
            int i4 = this.bGJ > 0.0d ? (int) ((i3 * this.bGJ) + 0.5d) : i3;
            if (this.bGW > 0) {
                i4 = this.bGW;
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
                int i6 = (this.bGP + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.bGS) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.bGS != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int s = measuredWidth - l.s(getContext(), d.e.tbds20);
        int s2 = measuredHeight - l.s(getContext(), d.e.tbds20);
        int measureText = (int) this.bCD.measureText(this.bGS);
        int i = 0;
        if (this.bGX != null) {
            i = this.bGX.getWidth();
        }
        return new RectF(s - ((i + measureText) + l.s(getContext(), d.e.tbds20)), s2 - l.s(getContext(), d.e.tbds48), s, s2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int s = l.s(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, s, s, this.bGT);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.bCD.measureText(this.bGS)) / 2);
            int i = ((this.bGU / 2) + centerY) - this.bGV;
            if (this.bGX != null) {
                int width = this.bGX.getWidth();
                int height = this.bGX.getHeight();
                int s2 = ((int) rectF.left) + l.s(getContext(), d.e.tbds10);
                canvas.drawBitmap(this.bGX, s2, centerY - (height / 2), (Paint) null);
                centerX = width + s2;
            }
            canvas.drawText(this.bGS, centerX, i, this.bCD);
        }
    }

    public void onChangeSkinType() {
        this.bCD.setColor(aj.getColor(d.C0108d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.bGW = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGE = bdUniqueId;
    }
}
