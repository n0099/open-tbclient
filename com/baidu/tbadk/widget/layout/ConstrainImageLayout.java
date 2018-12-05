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
    private boolean aEq;
    protected BdUniqueId bdE;
    private int boA;
    private int boB;
    private Bitmap boC;
    protected boolean boD;
    private ViewGroup.OnHierarchyChangeListener boE;
    private double boo;
    private c bop;
    private com.baidu.adp.widget.a.b bor;
    protected com.baidu.adp.lib.e.b<TbImageView> bou;
    private int bov;
    private int bow;
    private int box;
    private String boy;
    private Paint boz;
    private TbImageView.b mOnDrawListener;
    private Paint textPaint;

    public ConstrainImageLayout(Context context) {
        super(context);
        this.bow = -1;
        this.aEq = false;
        this.box = e.d.common_color_10082;
        this.PZ = 0;
        this.boD = false;
        this.boE = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bou != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bou.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a ih = com.baidu.tbadk.imageManager.c.Nu().ih(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), ConstrainImageLayout.this.aEq ? 13 : 14));
                    if (ih != null) {
                        int width = ih.getWidth();
                        i = ih.getHeight();
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
                            if (ConstrainImageLayout.this.boD && i > i2) {
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
        this.bow = -1;
        this.aEq = false;
        this.box = e.d.common_color_10082;
        this.PZ = 0;
        this.boD = false;
        this.boE = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bou != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bou.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a ih = com.baidu.tbadk.imageManager.c.Nu().ih(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), ConstrainImageLayout.this.aEq ? 13 : 14));
                    if (ih != null) {
                        int width = ih.getWidth();
                        i = ih.getHeight();
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
                            if (ConstrainImageLayout.this.boD && i > i2) {
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
        this.bow = -1;
        this.aEq = false;
        this.box = e.d.common_color_10082;
        this.PZ = 0;
        this.boD = false;
        this.boE = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.bou != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.bou.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a ih = com.baidu.tbadk.imageManager.c.Nu().ih(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), ConstrainImageLayout.this.aEq ? 13 : 14));
                    if (ih != null) {
                        int width = ih.getWidth();
                        i2 = ih.getHeight();
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
                            if (ConstrainImageLayout.this.boD && i2 > i22) {
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
        setOnHierarchyChangeListener(this.boE);
        this.textPaint = new Paint();
        this.textPaint.setColor(al.getColor(e.d.cp_cont_i));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.tbfontsize26));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.PZ = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.boA = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.boz = new Paint();
        this.boz.setColor(TbadkCoreApplication.getInst().getResources().getColor(e.d.black_alpha40));
        this.boz.setAntiAlias(true);
        this.boC = al.dO(e.f.icon_image_home_n);
    }

    public void setImageClickListener(c cVar) {
        if (cVar == null) {
            setClickable(false);
        } else {
            this.bop = cVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bou = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aEq = z;
    }

    public void setForeColorId(int i) {
        this.box = i;
    }

    public void setExtraCenterText(String str) {
        this.boy = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.bow = i;
        } else {
            this.bow = -1;
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
        this.boo = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        setUrls(list, i, z, true);
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int H;
        if (this.bou != null && (H = v.H(list)) > 0) {
            gG(H);
            int childCount = getChildCount();
            int i2 = this.aEq ? 13 : 14;
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
        this.boD = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.bop != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.bop == null && tbImageView != null) {
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
        private boolean boG;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.boG = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.bop != null) {
                ConstrainImageLayout.this.bop.b(view, this.currentIndex, this.hasMore && this.boG);
            }
        }
    }

    public void setImagePadding(int i) {
        this.bov = i;
    }

    private void gG(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView jy = this.bou.jy();
                jy.setContentDescription(getResources().getString(e.j.editor_image));
                jy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                jy.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                jy.setPageId(this.bdE);
                addView(jy);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.bow);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.bov)) / max;
            int i4 = this.boo > 0.0d ? (int) ((i3 * this.boo) + 0.5d) : i3;
            if (this.boB > 0) {
                i4 = this.boB;
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
                int i6 = (this.bov + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        RG();
        if (!StringUtils.isNull(this.boy) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.boy != null) {
            b(canvas, getBackgroundRect());
        }
    }

    private void RG() {
        if (this.bor != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width > 0 && height > 0) {
                if (getChildCount() == 1) {
                    this.bor.k(1, childAt.getWidth(), childAt.getHeight());
                } else {
                    this.bor.k(2, childAt.getWidth(), childAt.getHeight());
                }
            }
        }
    }

    private RectF getBackgroundRect() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int h = measuredWidth - l.h(getContext(), e.C0210e.tbds20);
        int h2 = measuredHeight - l.h(getContext(), e.C0210e.tbds20);
        int measureText = (int) this.textPaint.measureText(this.boy);
        int i = 0;
        if (this.boC != null) {
            i = this.boC.getWidth();
        }
        return new RectF(h - ((i + measureText) + l.h(getContext(), e.C0210e.tbds20)), h2 - l.h(getContext(), e.C0210e.tbds48), h, h2);
    }

    private void b(Canvas canvas, RectF rectF) {
        if (rectF != null) {
            int h = l.h(getContext(), e.C0210e.ds60);
            canvas.drawRoundRect(rectF, h, h, this.boz);
            int centerY = (int) rectF.centerY();
            int centerX = ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.boy)) / 2);
            int i = ((this.PZ / 2) + centerY) - this.boA;
            if (this.boC != null) {
                int width = this.boC.getWidth();
                int height = this.boC.getHeight();
                int h2 = ((int) rectF.left) + l.h(getContext(), e.C0210e.tbds10);
                canvas.drawBitmap(this.boC, h2, centerY - (height / 2), (Paint) null);
                centerX = width + h2;
            }
            canvas.drawText(this.boy, centerX, i, this.textPaint);
        }
    }

    public void onChangeSkinType() {
        this.textPaint.setColor(al.getColor(e.d.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.boB = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bdE = bdUniqueId;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.bor = bVar;
    }
}
