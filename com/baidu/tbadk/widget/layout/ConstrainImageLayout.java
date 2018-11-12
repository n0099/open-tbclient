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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private int PZ;
    private boolean aAQ;
    protected BdUniqueId bag;
    private double bkQ;
    private c bkR;
    private com.baidu.adp.widget.a.b bkT;
    protected com.baidu.adp.lib.e.b<TbImageView> bkW;
    private int bkX;
    private int bkY;
    private int bkZ;
    private String bla;
    private Paint blb;
    private int blc;
    private int bld;
    private Bitmap ble;
    protected boolean blf;
    private ViewGroup.OnHierarchyChangeListener blg;
    private TbImageView.b mOnDrawListener;
    private Paint textPaint;

    public ConstrainImageLayout(Context context) {
        super(context);
        this.bkY = -1;
        this.aAQ = false;
        this.bkZ = e.d.common_color_10082;
        this.PZ = 0;
        this.blf = false;
        this.blg = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bkW != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bkW.t(tbImageView);
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
                float f5;
                float f6;
                float f7 = 0.0f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a hP = com.baidu.tbadk.imageManager.c.Mq().hP(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), ConstrainImageLayout.this.aAQ ? 13 : 14));
                    if (hP != null) {
                        int width = hP.getWidth();
                        i = hP.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                            float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                            if (i2 * height > width2 * i) {
                                f5 = height / i;
                                float f8 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f8 < width2 * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i2 * f5) - f8 < width2 * 0.5f) {
                                    f6 = width2 - (i2 * f5);
                                } else {
                                    f6 = (width2 * 0.5f) - f8;
                                }
                            } else {
                                f5 = width2 / i2;
                                float f9 = i * smartCropCenterPointHeightRatio * f5;
                                if (f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i * f5) - f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = height - (i * f5);
                                } else {
                                    float f10 = (height * 0.5f) - f9;
                                    f6 = 0.0f;
                                    f7 = f10;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f6, f7);
                        } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f11 = height / i;
                                f2 = f11;
                                f3 = (width2 - (i2 * f11)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f12 = width2 / i2;
                                f = (height - (i * f12)) * 0.5f;
                                f2 = f12;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (ConstrainImageLayout.this.blf && i > i2) {
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
        this.bkY = -1;
        this.aAQ = false;
        this.bkZ = e.d.common_color_10082;
        this.PZ = 0;
        this.blf = false;
        this.blg = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bkW != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bkW.t(tbImageView);
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
                float f5;
                float f6;
                float f7 = 0.0f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a hP = com.baidu.tbadk.imageManager.c.Mq().hP(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), ConstrainImageLayout.this.aAQ ? 13 : 14));
                    if (hP != null) {
                        int width = hP.getWidth();
                        i = hP.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                            float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                            if (i2 * height > width2 * i) {
                                f5 = height / i;
                                float f8 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f8 < width2 * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i2 * f5) - f8 < width2 * 0.5f) {
                                    f6 = width2 - (i2 * f5);
                                } else {
                                    f6 = (width2 * 0.5f) - f8;
                                }
                            } else {
                                f5 = width2 / i2;
                                float f9 = i * smartCropCenterPointHeightRatio * f5;
                                if (f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i * f5) - f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = height - (i * f5);
                                } else {
                                    float f10 = (height * 0.5f) - f9;
                                    f6 = 0.0f;
                                    f7 = f10;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f6, f7);
                        } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f11 = height / i;
                                f2 = f11;
                                f3 = (width2 - (i2 * f11)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f12 = width2 / i2;
                                f = (height - (i * f12)) * 0.5f;
                                f2 = f12;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (ConstrainImageLayout.this.blf && i > i2) {
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
        this.bkY = -1;
        this.aAQ = false;
        this.bkZ = e.d.common_color_10082;
        this.PZ = 0;
        this.blf = false;
        this.blg = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bkW != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bkW.t(tbImageView);
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
                float f5;
                float f6;
                float f7 = 0.0f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a hP = com.baidu.tbadk.imageManager.c.Mq().hP(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), ConstrainImageLayout.this.aAQ ? 13 : 14));
                    if (hP != null) {
                        int width = hP.getWidth();
                        i2 = hP.getHeight();
                        i22 = width;
                    } else {
                        i2 = 0;
                        i22 = 0;
                    }
                    if (i22 != 0 && i2 != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                            float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                            if (i22 * height > width2 * i2) {
                                f5 = height / i2;
                                float f8 = i22 * smartCropCenterPointWidthRatio * f5;
                                if (f8 < width2 * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i22 * f5) - f8 < width2 * 0.5f) {
                                    f6 = width2 - (i22 * f5);
                                } else {
                                    f6 = (width2 * 0.5f) - f8;
                                }
                            } else {
                                f5 = width2 / i22;
                                float f9 = i2 * smartCropCenterPointHeightRatio * f5;
                                if (f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i2 * f5) - f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = height - (i2 * f5);
                                } else {
                                    float f10 = (height * 0.5f) - f9;
                                    f6 = 0.0f;
                                    f7 = f10;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f6, f7);
                        } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i22 * height > width2 * i2) {
                                f4 = height / i2;
                            } else {
                                f4 = width2 / i22;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i22 * height > width2 * i2) {
                                float f11 = height / i2;
                                f2 = f11;
                                f3 = (width2 - (i22 * f11)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f12 = width2 / i22;
                                f = (height - (i2 * f12)) * 0.5f;
                                f2 = f12;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (ConstrainImageLayout.this.blf && i2 > i22) {
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
        setOnHierarchyChangeListener(this.blg);
        this.textPaint = new Paint();
        this.textPaint.setColor(al.getColor(e.d.cp_cont_i));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(e.C0200e.tbfontsize26));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.PZ = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.blc = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.blb = new Paint();
        this.blb.setColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha40));
        this.blb.setAntiAlias(true);
        this.ble = al.dA(e.f.icon_image_home_n);
    }

    public void setImageClickListener(c cVar) {
        if (cVar == null) {
            setClickable(false);
        } else {
            this.bkR = cVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bkW = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aAQ = z;
    }

    public void setForeColorId(int i) {
        this.bkZ = i;
    }

    public void setExtraCenterText(String str) {
        this.bla = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.bkY = i;
        } else {
            this.bkY = -1;
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
        this.bkQ = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        setUrls(list, i, z, true);
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int H;
        if (this.bkW != null && (H = v.H(list)) > 0) {
            gs(H);
            int childCount = getChildCount();
            int i2 = this.aAQ ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                MediaData mediaData = list.get(i3);
                if ((childAt instanceof TbImageView) && mediaData != null) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z3 = i3 == childCount + (-1);
                    a(tbImageView, i + i3, z, z3);
                    if (z3 && z && z2) {
                        tbImageView.setLongIconSupport(false);
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setLongIconSupport(true);
                        tbImageView.setGifIconSupport(true);
                    }
                    String a2 = a(mediaData);
                    if (!ao.equals(a2, tbImageView.getUrl())) {
                        tbImageView.reset();
                    }
                    boolean isLongPic = mediaData.isLongPic();
                    boolean isSmartCrop = mediaData.isSmartCrop();
                    tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
                    tbImageView.setIsLongPic(isLongPic);
                    tbImageView.setIsSmartCrop(isSmartCrop);
                    tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
                    tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
                    tbImageView.setForegroundColor(0);
                    tbImageView.setOnDrawListener(this.mOnDrawListener);
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.blf = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.bkR != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.bkR == null && tbImageView != null) {
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
        private boolean bli;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.bli = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.bkR != null) {
                ConstrainImageLayout.this.bkR.b(view, this.currentIndex, this.hasMore && this.bli);
            }
        }
    }

    public void setImagePadding(int i) {
        this.bkX = i;
    }

    private void gs(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView jy = this.bkW.jy();
                jy.setContentDescription(getResources().getString(e.j.editor_image));
                jy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                jy.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                jy.setPageId(this.bag);
                addView(jy);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.bkY);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.bkX)) / max;
            int i4 = this.bkQ > 0.0d ? (int) ((i3 * this.bkQ) + 0.5d) : i3;
            if (this.bld > 0) {
                i4 = this.bld;
            }
            setMeasuredDimension(size, i4);
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, AiAppsFileUtils.GB), View.MeasureSpec.makeMeasureSpec(i4, AiAppsFileUtils.GB));
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
                int i6 = (this.bkX + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        QA();
        if (!StringUtils.isNull(this.bla) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.bla != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private void QA() {
        if (this.bkT != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width > 0 && height > 0) {
                if (getChildCount() == 1) {
                    this.bkT.k(1, childAt.getWidth(), childAt.getHeight());
                } else {
                    this.bkT.k(2, childAt.getWidth(), childAt.getHeight());
                }
            }
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int h = measuredWidth - l.h(getContext(), e.C0200e.tbds20);
        int h2 = measuredHeight - l.h(getContext(), e.C0200e.tbds20);
        int measureText = (int) this.textPaint.measureText(this.bla);
        int i = 0;
        if (this.ble != null) {
            i = this.ble.getWidth();
        }
        return new RectF(h - ((i + measureText) + l.h(getContext(), e.C0200e.tbds20)), h2 - l.h(getContext(), e.C0200e.tbds48), h, h2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int h = l.h(getContext(), e.C0200e.ds60);
            canvas.drawRoundRect(rectF, h, h, this.blb);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.bla)) / 2);
            int i = ((this.PZ / 2) + centerY) - this.blc;
            if (this.ble != null) {
                int width = this.ble.getWidth();
                int height = this.ble.getHeight();
                int h2 = ((int) rectF.left) + l.h(getContext(), e.C0200e.tbds10);
                canvas.drawBitmap(this.ble, h2, centerY - (height / 2), (Paint) null);
                centerX = width + h2;
            }
            canvas.drawText(this.bla, centerX, i, this.textPaint);
        }
    }

    public void onChangeSkinType() {
        this.textPaint.setColor(al.getColor(e.d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.bld = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bag = bdUniqueId;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.bkT = bVar;
    }
}
