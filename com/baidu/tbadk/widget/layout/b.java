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
    private boolean aXs;
    private Paint bCv;
    private double bGB;
    private d bGC;
    protected com.baidu.adp.lib.e.b<TbImageView> bGG;
    private int bGH;
    private int bGI;
    private int bGJ;
    private String bGK;
    private Paint bGL;
    private int bGM;
    private int bGN;
    private int bGO;
    private Bitmap bGP;
    private ViewGroup.OnHierarchyChangeListener bGQ;
    protected BdUniqueId bGw;
    private TbImageView.b mOnDrawListener;

    public b(Context context) {
        super(context);
        this.bGI = -1;
        this.aXs = false;
        this.bGJ = d.C0107d.common_color_10082;
        this.bGM = 0;
        this.bGQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.bGG != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    b.this.bGG.ar(tbImageView);
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
                    com.baidu.adp.widget.a.a gy = com.baidu.tbadk.imageManager.c.LP().gy(com.baidu.adp.lib.f.c.nl().g(tbImageView.getUrl(), b.this.aXs ? 13 : 14));
                    if (gy != null) {
                        i2 = gy.getWidth();
                        i = gy.getHeight();
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
        setOnHierarchyChangeListener(this.bGQ);
        this.bCv = new Paint();
        this.bCv.setColor(aj.getColor(d.C0107d.cp_cont_i));
        this.bCv.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbfontsize26));
        this.bCv.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.bCv.getFontMetrics();
        this.bGM = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.bGN = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.bGL = new Paint();
        this.bGL.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0107d.black_alpha40));
        this.bGL.setAntiAlias(true);
        this.bGP = aj.fO(d.f.icon_image_home_n);
    }

    public void setImageClickListener(d dVar) {
        this.bGC = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bGG = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aXs = z;
    }

    public void setForeColorId(int i) {
        this.bGJ = i;
    }

    public void setExtraCenterText(String str) {
        this.bGK = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.bGI = i;
        } else {
            this.bGI = -1;
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
        this.bGB = d;
    }

    public void b(List<MediaData> list, int i, boolean z) {
        int D;
        if (this.bGG != null && (D = v.D(list)) > 0) {
            iJ(D);
            int childCount = getChildCount();
            int i2 = this.aXs ? 13 : 14;
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
        if (this.bGC != null && tbImageView != null) {
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
        private boolean bGS;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.bGS = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.bGC != null) {
                b.this.bGC.f(view, this.currentIndex, this.hasMore && this.bGS);
            }
        }
    }

    public void setImagePadding(int i) {
        this.bGH = i;
    }

    private void iJ(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView nj = this.bGG.nj();
                nj.setContentDescription(getResources().getString(d.j.editor_image));
                nj.setScaleType(ImageView.ScaleType.CENTER_CROP);
                nj.setDefaultBg(aj.getDrawable(d.C0107d.common_color_10220));
                nj.setPageId(this.bGw);
                addView(nj);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.bGI);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.bGH)) / max;
            int i4 = this.bGB > 0.0d ? (int) ((i3 * this.bGB) + 0.5d) : i3;
            if (this.bGO > 0) {
                i4 = this.bGO;
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
                int i6 = (this.bGH + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.bGK) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.bGK != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int s = measuredWidth - l.s(getContext(), d.e.tbds20);
        int s2 = measuredHeight - l.s(getContext(), d.e.tbds20);
        int measureText = (int) this.bCv.measureText(this.bGK);
        int i = 0;
        if (this.bGP != null) {
            i = this.bGP.getWidth();
        }
        return new RectF(s - ((i + measureText) + l.s(getContext(), d.e.tbds20)), s2 - l.s(getContext(), d.e.tbds48), s, s2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int s = l.s(getContext(), d.e.ds60);
            canvas.drawRoundRect(rectF, s, s, this.bGL);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.bCv.measureText(this.bGK)) / 2);
            int i = ((this.bGM / 2) + centerY) - this.bGN;
            if (this.bGP != null) {
                int width = this.bGP.getWidth();
                int height = this.bGP.getHeight();
                int s2 = ((int) rectF.left) + l.s(getContext(), d.e.tbds10);
                canvas.drawBitmap(this.bGP, s2, centerY - (height / 2), (Paint) null);
                centerX = width + s2;
            }
            canvas.drawText(this.bGK, centerX, i, this.bCv);
        }
    }

    public void onChangeSkinType() {
        this.bCv.setColor(aj.getColor(d.C0107d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.bGO = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGw = bdUniqueId;
    }
}
