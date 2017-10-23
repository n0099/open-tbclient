package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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
    private Paint aNg;
    private int aPA;
    private int aPB;
    private int aPC;
    private Bitmap aPD;
    private ViewGroup.OnHierarchyChangeListener aPE;
    protected BdUniqueId aPk;
    private double aPp;
    private d aPq;
    protected com.baidu.adp.lib.e.b<TbImageView> aPu;
    private int aPv;
    private int aPw;
    private int aPx;
    private String aPy;
    private Paint aPz;
    private boolean aiu;

    public b(Context context) {
        super(context);
        this.aPw = -1;
        this.aiu = false;
        this.aPx = d.e.common_color_10082;
        this.aPA = 0;
        this.aPE = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aPu != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    b.this.aPu.m(tbImageView);
                }
            }
        };
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aPE);
        this.aNg = new Paint();
        this.aNg.setColor(aj.getColor(d.e.cp_cont_i));
        this.aNg.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize20));
        this.aNg.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aNg.getFontMetrics();
        this.aPA = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aPB = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.aPz = new Paint();
        this.aPz.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.e.black_alpha40));
        this.aPz.setAntiAlias(true);
        this.aPD = aj.cQ(d.g.icon_image_home_n);
    }

    public void setImageClickListener(d dVar) {
        this.aPq = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aPu = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aiu = z;
    }

    public void setForeColorId(int i) {
        this.aPx = i;
    }

    public void setExtraCenterText(String str) {
        this.aPy = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aPw = i;
        } else {
            this.aPw = -1;
        }
    }

    public void reset() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).reset();
            }
        }
    }

    public void f(List<MediaData> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aPp = d;
    }

    public void a(List<MediaData> list, int i, final boolean z) {
        int t;
        if (this.aPu != null && (t = v.t(list)) > 0) {
            fH(t);
            int childCount = getChildCount();
            int i2 = this.aiu ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                MediaData mediaData = list.get(i3);
                if ((childAt instanceof TbImageView) && mediaData != null) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    final boolean z2 = i3 == childCount + (-1);
                    if (this.aPq != null) {
                        final int i4 = i + i3;
                        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (b.this.aPq != null) {
                                    b.this.aPq.c(view, i4, z && z2);
                                }
                            }
                        });
                    }
                    tbImageView.setForegroundColor(0);
                    if (z2 && z) {
                        tbImageView.setLongIconSupport(false);
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setLongIconSupport(true);
                        tbImageView.setGifIconSupport(true);
                    }
                    String thumbnails_url = mediaData.getThumbnails_url();
                    if (TextUtils.isEmpty(thumbnails_url)) {
                        thumbnails_url = mediaData.getSmallUrl();
                    }
                    if (TextUtils.isEmpty(thumbnails_url)) {
                        thumbnails_url = mediaData.getPicUrl();
                    }
                    if (TextUtils.isEmpty(thumbnails_url)) {
                        thumbnails_url = mediaData.getSrc_pic();
                    }
                    if (!am.equals(thumbnails_url, tbImageView.getUrl())) {
                        tbImageView.reset();
                    }
                    tbImageView.setIsLongPic(mediaData.isLongPic());
                    tbImageView.c(thumbnails_url, i2, false);
                }
                i3++;
            }
        }
    }

    public void setImagePadding(int i) {
        this.aPv = i;
    }

    private void fH(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fH = this.aPu.fH();
                fH.setContentDescription(getResources().getString(d.l.editor_image));
                fH.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fH.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
                fH.setPageId(this.aPk);
                addView(fH);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aPw);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aPv)) / max;
            int i4 = this.aPp > 0.0d ? (int) ((i3 * this.aPp) + 0.5d) : i3;
            if (this.aPC > 0) {
                i4 = this.aPC;
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
                int i6 = (this.aPv + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aPy) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.aPy != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int f = measuredWidth - l.f(getContext(), d.f.ds16);
        int f2 = measuredHeight - l.f(getContext(), d.f.ds16);
        int measureText = (int) this.aNg.measureText(this.aPy);
        int i = 0;
        if (this.aPD != null) {
            i = this.aPD.getWidth();
        }
        return new RectF(f - ((i + measureText) + l.f(getContext(), d.f.ds24)), f2 - l.f(getContext(), d.f.ds36), f, f2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int f = l.f(getContext(), d.f.ds60);
            canvas.drawRoundRect(rectF, f, f, this.aPz);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.aNg.measureText(this.aPy)) / 2);
            int i = ((this.aPA / 2) + centerY) - this.aPB;
            if (this.aPD != null) {
                int width = this.aPD.getWidth();
                int height = this.aPD.getHeight();
                int f2 = ((int) rectF.left) + l.f(getContext(), d.f.ds8);
                canvas.drawBitmap(this.aPD, f2, centerY - (height / 2), (Paint) null);
                centerX = width + f2;
            }
            canvas.drawText(this.aPy, centerX, i, this.aNg);
        }
    }

    public void onChangeSkinType() {
        this.aNg.setColor(aj.getColor(d.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aPC = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPk = bdUniqueId;
    }
}
