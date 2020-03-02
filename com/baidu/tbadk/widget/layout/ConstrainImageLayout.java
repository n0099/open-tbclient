package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private boolean NJ;
    private TbImageView.c NT;
    private d Ok;
    protected boolean Ou;
    protected BdUniqueId dBk;
    private double dLA;
    private com.baidu.adp.widget.a.b dLC;
    private boolean dLE;
    protected com.baidu.adp.lib.d.b<TbImageView> dLG;
    private int dLH;
    private int dLI;
    private int dLJ;
    private String dLK;
    private Paint dLL;
    private int dLM;
    private int dLN;
    private int dLO;
    private MediaData dLP;
    private ViewGroup.OnHierarchyChangeListener dLQ;
    private a dLu;
    private Paint mBitmapPaint;
    private Bitmap mMaskBitmap;
    private int mSkinType;
    private int textHeight;
    private Paint textPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(TbImageView tbImageView, int i);
    }

    public ConstrainImageLayout(Context context) {
        super(context);
        this.dLI = -1;
        this.NJ = false;
        this.dLJ = R.color.common_color_10082;
        this.textHeight = 0;
        this.Ou = false;
        this.dLE = false;
        this.dLO = 0;
        this.mSkinType = 3;
        this.dLQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.dLG != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.dLG.returnObject(tbImageView);
                }
            }
        };
        this.NT = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
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
                    com.baidu.adp.widget.ImageView.a vx = com.baidu.tbadk.imageManager.c.aPQ().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.NJ ? 13 : 14));
                    if (vx != null) {
                        int width = vx.getWidth();
                        i = vx.getHeight();
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
                            if (ConstrainImageLayout.this.Ou && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    public ConstrainImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLI = -1;
        this.NJ = false;
        this.dLJ = R.color.common_color_10082;
        this.textHeight = 0;
        this.Ou = false;
        this.dLE = false;
        this.dLO = 0;
        this.mSkinType = 3;
        this.dLQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.dLG != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.dLG.returnObject(tbImageView);
                }
            }
        };
        this.NT = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
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
                    com.baidu.adp.widget.ImageView.a vx = com.baidu.tbadk.imageManager.c.aPQ().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.NJ ? 13 : 14));
                    if (vx != null) {
                        int width = vx.getWidth();
                        i = vx.getHeight();
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
                            if (ConstrainImageLayout.this.Ou && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    public ConstrainImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLI = -1;
        this.NJ = false;
        this.dLJ = R.color.common_color_10082;
        this.textHeight = 0;
        this.Ou = false;
        this.dLE = false;
        this.dLO = 0;
        this.mSkinType = 3;
        this.dLQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.dLG != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.dLG.returnObject(tbImageView);
                }
            }
        };
        this.NT = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
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
                    com.baidu.adp.widget.ImageView.a vx = com.baidu.tbadk.imageManager.c.aPQ().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.NJ ? 13 : 14));
                    if (vx != null) {
                        int width = vx.getWidth();
                        i2 = vx.getHeight();
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
                            if (ConstrainImageLayout.this.Ou && i2 > i22) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.dLQ);
        this.textPaint = new Paint();
        this.textPaint.setColor(am.getColor(R.color.cp_cont_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.dLM = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.dLL = new Paint();
        this.dLL.setAntiAlias(true);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        setLayerType(1, null);
    }

    public void setImageClickListener(d dVar) {
        if (dVar == null) {
            setClickable(false);
        } else {
            this.Ok = dVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.dLG = bVar;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void setForeColorId(int i) {
        this.dLJ = i;
    }

    public void setExtraCenterText(String str) {
        this.dLK = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.dLI = i;
        } else {
            this.dLI = -1;
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
        this.dLA = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        setUrls(list, i, z, true);
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int count;
        if (this.dLG != null && (count = v.getCount(list)) > 0) {
            if (count == 1) {
                this.dLP = (MediaData) v.getItem(list, 0);
            }
            ne(count);
            int childCount = getChildCount();
            int i2 = this.NJ ? 13 : 14;
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
                    if (!aq.equals(a2, tbImageView.getUrl())) {
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
                    tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                    tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
                    tbImageView.setBorderSurroundContent(true);
                    tbImageView.setDrawBorder(true);
                    tbImageView.setOnDrawListener(this.NT);
                    if (this.dLu != null) {
                        this.dLu.a(tbImageView, i3);
                    }
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ou = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.Ok != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof b) {
                ((b) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new b(i, z, z2));
            }
        } else if (this.Ok == null && tbImageView != null) {
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
    public class b implements View.OnClickListener {
        private boolean Om;
        private int currentIndex;
        private boolean hasMore;

        public b(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Om = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.Ok != null) {
                ConstrainImageLayout.this.Ok.b(view, this.currentIndex, this.hasMore && this.Om);
            }
        }
    }

    public void setImagePadding(int i) {
        this.dLH = i;
    }

    private void ne(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView borrowObject = this.dLG.borrowObject();
                borrowObject.setContentDescription(getResources().getString(R.string.editor_image));
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
                borrowObject.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                borrowObject.setPageId(this.dBk);
                addView(borrowObject);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.dLI);
            int size = View.MeasureSpec.getSize(i);
            int i5 = size - ((max - 1) * this.dLH);
            if (this.dLE) {
                if (childCount == 1) {
                    if (this.dLO == 0) {
                        this.dLO = (int) ((size - (this.dLH * 2)) / 3.0f);
                    }
                    if (this.dLP != null && this.dLP.picWidth > 0 && this.dLP.picHeight > 0) {
                        if (this.dLP.picWidth * 2 <= this.dLP.picHeight) {
                            i3 = this.dLH + ((int) (this.dLO * 1.5f));
                            i4 = (this.dLO * 2) + this.dLH;
                        } else if (this.dLP.picHeight * 2 <= this.dLP.picWidth) {
                            i3 = this.dLH + (this.dLO * 2);
                            i4 = ((int) (this.dLO * 1.5f)) + this.dLH;
                        } else if (this.dLP.picWidth < this.dLO) {
                            if (this.dLP.picHeight < this.dLO) {
                                if (this.dLP.picWidth < this.dLP.picHeight) {
                                    i3 = this.dLO;
                                    i4 = (this.dLP.picHeight * i3) / this.dLP.picWidth;
                                } else {
                                    i4 = this.dLO;
                                    i3 = (this.dLP.picWidth * i4) / this.dLP.picHeight;
                                }
                            } else if (this.dLP.picHeight < this.dLO || this.dLP.picHeight >= this.dLO * 2) {
                                i4 = 0;
                                i3 = 0;
                            } else {
                                i3 = this.dLO;
                                i4 = (this.dLP.picHeight * i3) / this.dLP.picWidth;
                            }
                        } else if (this.dLP.picWidth >= this.dLO && this.dLP.picWidth < this.dLO * 2) {
                            if (this.dLP.picHeight < this.dLO) {
                                i4 = this.dLO;
                                i3 = (this.dLP.picWidth * i4) / this.dLP.picHeight;
                            } else if (this.dLP.picHeight >= this.dLO && this.dLP.picHeight < this.dLO * 2) {
                                i3 = this.dLP.picWidth;
                                i4 = this.dLP.picHeight;
                            } else {
                                i4 = (this.dLO * 2) + this.dLH;
                                i3 = (this.dLP.picWidth * i4) / this.dLP.picHeight;
                            }
                        } else if (this.dLP.picHeight < this.dLO) {
                            i4 = 0;
                            i3 = 0;
                        } else if (this.dLP.picHeight >= this.dLO && this.dLP.picHeight < this.dLO * 2) {
                            i3 = this.dLH + (this.dLO * 2);
                            i4 = (this.dLP.picHeight * i3) / this.dLP.picWidth;
                        } else if (this.dLP.picWidth < this.dLP.picHeight) {
                            i4 = (this.dLO * 2) + this.dLH;
                            i3 = (this.dLP.picWidth * i4) / this.dLP.picHeight;
                        } else {
                            i3 = this.dLH + (this.dLO * 2);
                            i4 = (this.dLP.picHeight * i3) / this.dLP.picWidth;
                        }
                    } else {
                        i4 = (this.dLO * 2) + this.dLH;
                        i3 = i4;
                    }
                } else {
                    i3 = i5 / max;
                    i4 = this.dLN > 0 ? this.dLN : i3;
                }
            } else {
                i3 = i5 / max;
                i4 = this.dLA > 0.0d ? (int) ((i3 * this.dLA) + 0.5d) : i3;
                if (this.dLN > 0) {
                    i4 = this.dLN;
                }
            }
            setMeasuredDimension(size, i4);
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
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
                int i6 = (this.dLH + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        aTx();
        if (!StringUtils.isNull(this.dLK) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.dLK != null) {
            TbImageView tbImageView = null;
            int childCount2 = getChildCount();
            while (true) {
                if (childCount2 <= 0) {
                    break;
                } else if (!(getChildAt(childCount2) instanceof TbImageView)) {
                    childCount2--;
                } else {
                    tbImageView = (TbImageView) getChildAt(childCount2);
                    break;
                }
            }
            RectF i = i(tbImageView);
            if (i != null) {
                a(canvas, i, tbImageView.getRadius());
            }
        }
    }

    private void aTx() {
        if (this.dLC != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width > 0 && height > 0) {
                if (getChildCount() == 1) {
                    this.dLC.h(1, childAt.getWidth(), childAt.getHeight());
                } else {
                    this.dLC.h(2, childAt.getWidth(), childAt.getHeight());
                }
            }
        }
    }

    private RectF i(TbImageView tbImageView) {
        if (tbImageView == null) {
            return null;
        }
        return new RectF(tbImageView.getLeft(), tbImageView.getTop(), tbImageView.getRight(), tbImageView.getBottom());
    }

    private void a(Canvas canvas, RectF rectF, float f) {
        if (rectF != null) {
            if (this.mMaskBitmap == null || this.mMaskBitmap.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.mMaskBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.mMaskBitmap);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-f, 0.0f, i, i2);
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawRoundRect(rectF2, f, f, this.mBitmapPaint);
            }
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.dLL);
            canvas.drawText(this.dLK, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.dLK)) / 2), (((int) rectF.centerY()) + (this.textHeight / 2)) - this.dLM, this.textPaint);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            aTy();
            this.textPaint.setColor(am.getColor(R.color.cp_cont_a));
            invalidate();
        }
    }

    private void aTy() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) instanceof TbImageView) {
                    ((TbImageView) getChildAt(i)).setPlaceHolder(2);
                }
            }
        }
    }

    public void setFixedImageHeight(int i) {
        this.dLN = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dBk = bdUniqueId;
    }

    public void setTbImageViewConfiguration(a aVar) {
        this.dLu = aVar;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.dLC = bVar;
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.dLE = z;
    }
}
