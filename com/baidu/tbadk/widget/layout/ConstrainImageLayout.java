package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private boolean alQ;
    private TbImageView.c alY;
    private d amr;
    protected boolean ams;
    private Bitmap anf;
    protected BdUniqueId fJu;
    private a fVM;
    private double fVS;
    private com.baidu.adp.widget.a.b fVU;
    private boolean fVW;
    protected com.baidu.adp.lib.d.b<TbImageView> fVY;
    private int fVZ;
    private int fWa;
    private String fWb;
    private Paint fWc;
    private int fWd;
    private int fWe;
    private int fWf;
    private MediaData fWg;
    private ViewGroup.OnHierarchyChangeListener fWh;
    private int imagePadding;
    private Paint mBitmapPaint;
    private int mSkinType;
    private int textHeight;
    private Paint textPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(TbImageView tbImageView, int i, int i2);
    }

    public ConstrainImageLayout(Context context) {
        super(context);
        this.fVZ = -1;
        this.alQ = false;
        this.fWa = R.color.common_color_10082;
        this.textHeight = 0;
        this.ams = false;
        this.fVW = false;
        this.fWf = 0;
        this.mSkinType = 3;
        this.fWh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.fVY != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.fVY.returnObject(tbImageView);
                }
            }
        };
        this.alY = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
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
                float f7;
                float f8;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ee = com.baidu.tbadk.imageManager.c.bGq().Ee(com.baidu.adp.lib.e.d.mx().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.alQ ? 13 : 14));
                    if (Ee != null) {
                        int width = Ee.getWidth();
                        i = Ee.getHeight();
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
                                float f9 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f9 < width2 * 0.5f) {
                                    f8 = 0.0f;
                                } else if ((i2 * f5) - f9 < width2 * 0.5f) {
                                    f8 = width2 - (i2 * f5);
                                } else {
                                    f8 = (width2 * 0.5f) - f9;
                                }
                                f6 = 0.0f;
                                f7 = f8;
                            } else {
                                f5 = width2 / i2;
                                float f10 = i * smartCropCenterPointHeightRatio * f5;
                                if (f10 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = 0.0f;
                                } else if ((i * f5) - f10 < height * 0.5f) {
                                    f6 = height - (i * f5);
                                    f7 = 0.0f;
                                } else {
                                    f6 = (height * 0.5f) - f10;
                                    f7 = 0.0f;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f7, f6);
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
                                f = height / i;
                                f3 = (width2 - (i2 * f)) * 0.5f;
                                f2 = 0.0f;
                            } else {
                                f = width2 / i2;
                                f2 = (height - (i * f)) * 0.5f;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f, f);
                            if (ConstrainImageLayout.this.ams && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f2);
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
        this.fVZ = -1;
        this.alQ = false;
        this.fWa = R.color.common_color_10082;
        this.textHeight = 0;
        this.ams = false;
        this.fVW = false;
        this.fWf = 0;
        this.mSkinType = 3;
        this.fWh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.fVY != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.fVY.returnObject(tbImageView);
                }
            }
        };
        this.alY = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
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
                float f7;
                float f8;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ee = com.baidu.tbadk.imageManager.c.bGq().Ee(com.baidu.adp.lib.e.d.mx().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.alQ ? 13 : 14));
                    if (Ee != null) {
                        int width = Ee.getWidth();
                        i = Ee.getHeight();
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
                                float f9 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f9 < width2 * 0.5f) {
                                    f8 = 0.0f;
                                } else if ((i2 * f5) - f9 < width2 * 0.5f) {
                                    f8 = width2 - (i2 * f5);
                                } else {
                                    f8 = (width2 * 0.5f) - f9;
                                }
                                f6 = 0.0f;
                                f7 = f8;
                            } else {
                                f5 = width2 / i2;
                                float f10 = i * smartCropCenterPointHeightRatio * f5;
                                if (f10 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = 0.0f;
                                } else if ((i * f5) - f10 < height * 0.5f) {
                                    f6 = height - (i * f5);
                                    f7 = 0.0f;
                                } else {
                                    f6 = (height * 0.5f) - f10;
                                    f7 = 0.0f;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f7, f6);
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
                                f = height / i;
                                f3 = (width2 - (i2 * f)) * 0.5f;
                                f2 = 0.0f;
                            } else {
                                f = width2 / i2;
                                f2 = (height - (i * f)) * 0.5f;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f, f);
                            if (ConstrainImageLayout.this.ams && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f2);
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
        this.fVZ = -1;
        this.alQ = false;
        this.fWa = R.color.common_color_10082;
        this.textHeight = 0;
        this.ams = false;
        this.fVW = false;
        this.fWf = 0;
        this.mSkinType = 3;
        this.fWh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.fVY != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.fVY.returnObject(tbImageView);
                }
            }
        };
        this.alY = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
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
                float f7;
                float f8;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ee = com.baidu.tbadk.imageManager.c.bGq().Ee(com.baidu.adp.lib.e.d.mx().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.alQ ? 13 : 14));
                    if (Ee != null) {
                        int width = Ee.getWidth();
                        i2 = Ee.getHeight();
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
                                float f9 = i22 * smartCropCenterPointWidthRatio * f5;
                                if (f9 < width2 * 0.5f) {
                                    f8 = 0.0f;
                                } else if ((i22 * f5) - f9 < width2 * 0.5f) {
                                    f8 = width2 - (i22 * f5);
                                } else {
                                    f8 = (width2 * 0.5f) - f9;
                                }
                                f6 = 0.0f;
                                f7 = f8;
                            } else {
                                f5 = width2 / i22;
                                float f10 = i2 * smartCropCenterPointHeightRatio * f5;
                                if (f10 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = 0.0f;
                                } else if ((i2 * f5) - f10 < height * 0.5f) {
                                    f6 = height - (i2 * f5);
                                    f7 = 0.0f;
                                } else {
                                    f6 = (height * 0.5f) - f10;
                                    f7 = 0.0f;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f7, f6);
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
                                f = height / i2;
                                f3 = (width2 - (i22 * f)) * 0.5f;
                                f2 = 0.0f;
                            } else {
                                f = width2 / i22;
                                f2 = (height - (i2 * f)) * 0.5f;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f, f);
                            if (ConstrainImageLayout.this.ams && i2 > i22) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f2);
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
        setOnHierarchyChangeListener(this.fWh);
        this.textPaint = new Paint();
        this.textPaint.setColor(ao.getColor(R.color.CAM_X0101));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.fWd = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.fWc = new Paint();
        this.fWc.setAntiAlias(true);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        setLayerType(1, null);
    }

    public void setImageClickListener(d dVar) {
        if (dVar == null) {
            setClickable(false);
        } else {
            this.amr = dVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.fVY = bVar;
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void setForeColorId(int i) {
        this.fWa = i;
    }

    public void setExtraCenterText(String str) {
        this.fWb = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.fVZ = i;
        } else {
            this.fVZ = -1;
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
        this.fVS = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        setUrls(list, i, z, true);
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int count;
        if (this.fVY != null && (count = x.getCount(list)) > 0) {
            if (count == 1) {
                this.fWg = (MediaData) x.getItem(list, 0);
            }
            tv(count);
            int childCount = getChildCount();
            int i2 = this.alQ ? 13 : 14;
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
                    if (!at.equals(a2, tbImageView.getUrl())) {
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
                    tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
                    tbImageView.setBorderSurroundContent(true);
                    tbImageView.setDrawBorder(true);
                    tbImageView.setOnDrawListener(this.alY);
                    if (this.fVM != null) {
                        this.fVM.a(tbImageView, i3, childCount);
                    }
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.ams = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.amr != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof b) {
                ((b) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new b(i, z, z2));
            }
        } else if (this.amr == null && tbImageView != null) {
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
        private boolean amu;
        private int currentIndex;
        private boolean hasMore;

        public b(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.amu = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.amr != null) {
                ConstrainImageLayout.this.amr.c(view, this.currentIndex, this.hasMore && this.amu);
            }
        }
    }

    public void setImagePadding(int i) {
        this.imagePadding = i;
    }

    private void tv(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView borrowObject = this.fVY.borrowObject();
                borrowObject.setContentDescription(getResources().getString(R.string.editor_image));
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
                borrowObject.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
                borrowObject.setPageId(this.fJu);
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
            int max = Math.max(childCount, this.fVZ);
            int size = View.MeasureSpec.getSize(i);
            int i5 = size - ((max - 1) * this.imagePadding);
            if (this.fVW) {
                if (childCount == 1) {
                    if (this.fWf == 0) {
                        this.fWf = (int) ((size - (this.imagePadding * 2)) / 3.0f);
                    }
                    if (this.fWg != null && this.fWg.picWidth > 0 && this.fWg.picHeight > 0) {
                        if (this.fWg.picWidth * 2 <= this.fWg.picHeight) {
                            int i6 = this.imagePadding + ((int) (this.fWf * 1.5f));
                            i3 = (this.fWf * 2) + this.imagePadding;
                            i4 = i6;
                        } else if (this.fWg.picHeight * 2 <= this.fWg.picWidth) {
                            int i7 = this.imagePadding + (this.fWf * 2);
                            i3 = ((int) (this.fWf * 1.5f)) + this.imagePadding;
                            i4 = i7;
                        } else if (this.fWg.picWidth < this.fWf) {
                            if (this.fWg.picHeight < this.fWf) {
                                if (this.fWg.picWidth < this.fWg.picHeight) {
                                    int i8 = this.fWf;
                                    i3 = (this.fWg.picHeight * i8) / this.fWg.picWidth;
                                    i4 = i8;
                                } else {
                                    i3 = this.fWf;
                                    i4 = (this.fWg.picWidth * i3) / this.fWg.picHeight;
                                }
                            } else if (this.fWg.picHeight < this.fWf || this.fWg.picHeight >= this.fWf * 2) {
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int i9 = this.fWf;
                                i3 = (this.fWg.picHeight * i9) / this.fWg.picWidth;
                                i4 = i9;
                            }
                        } else if (this.fWg.picWidth >= this.fWf && this.fWg.picWidth < this.fWf * 2) {
                            if (this.fWg.picHeight < this.fWf) {
                                i3 = this.fWf;
                                i4 = (this.fWg.picWidth * i3) / this.fWg.picHeight;
                            } else if (this.fWg.picHeight >= this.fWf && this.fWg.picHeight < this.fWf * 2) {
                                int i10 = this.fWg.picWidth;
                                i3 = this.fWg.picHeight;
                                i4 = i10;
                            } else {
                                i3 = (this.fWf * 2) + this.imagePadding;
                                i4 = (this.fWg.picWidth * i3) / this.fWg.picHeight;
                            }
                        } else if (this.fWg.picHeight < this.fWf) {
                            i3 = 0;
                            i4 = 0;
                        } else if (this.fWg.picHeight >= this.fWf && this.fWg.picHeight < this.fWf * 2) {
                            int i11 = this.imagePadding + (this.fWf * 2);
                            i3 = (this.fWg.picHeight * i11) / this.fWg.picWidth;
                            i4 = i11;
                        } else if (this.fWg.picWidth < this.fWg.picHeight) {
                            i3 = (this.fWf * 2) + this.imagePadding;
                            i4 = (this.fWg.picWidth * i3) / this.fWg.picHeight;
                        } else {
                            int i12 = this.imagePadding + (this.fWf * 2);
                            i3 = (this.fWg.picHeight * i12) / this.fWg.picWidth;
                            i4 = i12;
                        }
                    } else {
                        int i13 = this.imagePadding + (this.fWf * 2);
                        i3 = i13;
                        i4 = i13;
                    }
                    int[] c = com.baidu.tbadk.a.b.b.c(this.fWg);
                    if (c[0] > 0 && c[1] > 0) {
                        i4 = c[0];
                        i3 = c[1];
                    }
                } else {
                    int i14 = i5 / max;
                    if (this.fWe > 0) {
                        i3 = this.fWe;
                        i4 = i14;
                    } else {
                        i3 = i14;
                        i4 = i14;
                    }
                }
            } else {
                int i15 = i5 / max;
                i3 = this.fVS > 0.0d ? (int) ((i15 * this.fVS) + 0.5d) : i15;
                if (this.fWe > 0) {
                    i3 = this.fWe;
                    i4 = i15;
                } else {
                    i4 = i15;
                }
            }
            setMeasuredDimension(size, i3);
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                if (childAt != null) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
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
                int i6 = (this.imagePadding + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        bKB();
        if (!StringUtils.isNull(this.fWb) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.fWb != null) {
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
            RectF h = h(tbImageView);
            if (h != null) {
                a(canvas, h, com.baidu.tbadk.core.elementsMaven.a.aI(R.string.J_X11));
            }
        }
    }

    private void bKB() {
        if (this.fVU != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width > 0 && height > 0) {
                if (getChildCount() == 1) {
                    this.fVU.i(1, childAt.getWidth(), childAt.getHeight());
                } else {
                    this.fVU.i(2, childAt.getWidth(), childAt.getHeight());
                }
            }
        }
    }

    private RectF h(TbImageView tbImageView) {
        if (tbImageView == null) {
            return null;
        }
        return new RectF(tbImageView.getLeft(), tbImageView.getTop(), tbImageView.getRight(), tbImageView.getBottom());
    }

    private void a(Canvas canvas, RectF rectF, float[] fArr) {
        int i;
        if (rectF != null) {
            if (this.anf == null || this.anf.isRecycled()) {
                int i2 = (int) (rectF.right - rectF.left);
                int i3 = (int) (rectF.bottom - rectF.top);
                this.anf = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.anf);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-fArr[0], 0.0f, i2, i3);
                int i4 = Integer.MIN_VALUE;
                if (com.baidu.tbadk.a.d.bmF()) {
                    i = ao.getColor(R.color.CAM_X0601);
                    i4 = ao.getColor(R.color.CAM_X0606);
                } else {
                    i = 0;
                }
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i3, i, i4, Shader.TileMode.CLAMP));
                canvas2.drawPath(com.baidu.tbadk.core.elementsMaven.a.a.a(rectF2, fArr), this.mBitmapPaint);
            }
            canvas.drawBitmap(this.anf, rectF.left, rectF.top, this.fWc);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            int dimenPixelSize2 = ((int) rectF.right) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int i5 = ((int) rectF.bottom) - dimenPixelSize;
            int measureText = dimenPixelSize2 - ((int) this.textPaint.measureText(this.fWb));
            float[] ps = com.baidu.tbadk.core.elementsMaven.a.ps(R.array.S_O_X001);
            this.textPaint.setShadowLayer(ps[1], ps[2], ps[3], (int) ps[0]);
            canvas.drawText(this.fWb, measureText, i5, this.textPaint);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bKC();
            this.textPaint.setColor(ao.getColor(R.color.CAM_X0101));
            invalidate();
        }
    }

    private void bKC() {
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
        this.fWe = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fJu = bdUniqueId;
    }

    public void setTbImageViewConfiguration(a aVar) {
        this.fVM = aVar;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.fVU = bVar;
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.fVW = z;
    }
}
