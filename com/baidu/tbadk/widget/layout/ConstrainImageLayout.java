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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private d akO;
    protected boolean akP;
    private boolean akn;
    private TbImageView.c akv;
    private double fEB;
    private com.baidu.adp.widget.a.b fED;
    private boolean fEF;
    protected com.baidu.adp.lib.d.b<TbImageView> fEH;
    private int fEI;
    private int fEJ;
    private int fEK;
    private String fEL;
    private Paint fEM;
    private int fEN;
    private int fEO;
    private int fEP;
    private MediaData fEQ;
    private ViewGroup.OnHierarchyChangeListener fER;
    private a fEv;
    protected BdUniqueId fsa;
    private Paint mBitmapPaint;
    private Bitmap mMaskBitmap;
    private int mSkinType;
    private int textHeight;
    private Paint textPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(TbImageView tbImageView, int i, int i2);
    }

    public ConstrainImageLayout(Context context) {
        super(context);
        this.fEJ = -1;
        this.akn = false;
        this.fEK = R.color.common_color_10082;
        this.textHeight = 0;
        this.akP = false;
        this.fEF = false;
        this.fEP = 0;
        this.mSkinType = 3;
        this.fER = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.fEH != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.fEH.returnObject(tbImageView);
                }
            }
        };
        this.akv = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
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
                    com.baidu.adp.widget.ImageView.a DA = com.baidu.tbadk.imageManager.c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.akn ? 13 : 14));
                    if (DA != null) {
                        int width = DA.getWidth();
                        i = DA.getHeight();
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
                            if (ConstrainImageLayout.this.akP && i > i2) {
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
        this.fEJ = -1;
        this.akn = false;
        this.fEK = R.color.common_color_10082;
        this.textHeight = 0;
        this.akP = false;
        this.fEF = false;
        this.fEP = 0;
        this.mSkinType = 3;
        this.fER = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.fEH != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.fEH.returnObject(tbImageView);
                }
            }
        };
        this.akv = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
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
                    com.baidu.adp.widget.ImageView.a DA = com.baidu.tbadk.imageManager.c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.akn ? 13 : 14));
                    if (DA != null) {
                        int width = DA.getWidth();
                        i = DA.getHeight();
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
                            if (ConstrainImageLayout.this.akP && i > i2) {
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
        this.fEJ = -1;
        this.akn = false;
        this.fEK = R.color.common_color_10082;
        this.textHeight = 0;
        this.akP = false;
        this.fEF = false;
        this.fEP = 0;
        this.mSkinType = 3;
        this.fER = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    ((TbImageView) view2).setPlaceHolder(2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.fEH != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.fEH.returnObject(tbImageView);
                }
            }
        };
        this.akv = new TbImageView.c() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.2
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
                    com.baidu.adp.widget.ImageView.a DA = com.baidu.tbadk.imageManager.c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), ConstrainImageLayout.this.akn ? 13 : 14));
                    if (DA != null) {
                        int width = DA.getWidth();
                        i2 = DA.getHeight();
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
                            if (ConstrainImageLayout.this.akP && i2 > i22) {
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
        setOnHierarchyChangeListener(this.fER);
        this.textPaint = new Paint();
        this.textPaint.setColor(ap.getColor(R.color.CAM_X0101));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.fEN = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.fEM = new Paint();
        this.fEM.setAntiAlias(true);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        setLayerType(1, null);
    }

    public void setImageClickListener(d dVar) {
        if (dVar == null) {
            setClickable(false);
        } else {
            this.akO = dVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        this.fEH = bVar;
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void setForeColorId(int i) {
        this.fEK = i;
    }

    public void setExtraCenterText(String str) {
        this.fEL = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.fEJ = i;
        } else {
            this.fEJ = -1;
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
        this.fEB = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        setUrls(list, i, z, true);
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int count;
        if (this.fEH != null && (count = y.getCount(list)) > 0) {
            if (count == 1) {
                this.fEQ = (MediaData) y.getItem(list, 0);
            }
            sH(count);
            int childCount = getChildCount();
            int i2 = this.akn ? 13 : 14;
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
                    if (!au.equals(a2, tbImageView.getUrl())) {
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
                    tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
                    tbImageView.setBorderSurroundContent(true);
                    tbImageView.setDrawBorder(true);
                    tbImageView.setOnDrawListener(this.akv);
                    if (this.fEv != null) {
                        this.fEv.a(tbImageView, i3, childCount);
                    }
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.akP = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.akO != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof b) {
                ((b) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new b(i, z, z2));
            }
        } else if (this.akO == null && tbImageView != null) {
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
        private boolean akR;
        private int currentIndex;
        private boolean hasMore;

        public b(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.akR = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.akO != null) {
                ConstrainImageLayout.this.akO.b(view, this.currentIndex, this.hasMore && this.akR);
            }
        }
    }

    public void setImagePadding(int i) {
        this.fEI = i;
    }

    private void sH(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView borrowObject = this.fEH.borrowObject();
                borrowObject.setContentDescription(getResources().getString(R.string.editor_image));
                borrowObject.setScaleType(ImageView.ScaleType.CENTER_CROP);
                borrowObject.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
                borrowObject.setPageId(this.fsa);
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
            int max = Math.max(childCount, this.fEJ);
            int size = View.MeasureSpec.getSize(i);
            int i5 = size - ((max - 1) * this.fEI);
            if (this.fEF) {
                if (childCount == 1) {
                    if (this.fEP == 0) {
                        this.fEP = (int) ((size - (this.fEI * 2)) / 3.0f);
                    }
                    if (this.fEQ != null && this.fEQ.picWidth > 0 && this.fEQ.picHeight > 0) {
                        if (this.fEQ.picWidth * 2 <= this.fEQ.picHeight) {
                            i3 = this.fEI + ((int) (this.fEP * 1.5f));
                            i4 = (this.fEP * 2) + this.fEI;
                        } else if (this.fEQ.picHeight * 2 <= this.fEQ.picWidth) {
                            i3 = this.fEI + (this.fEP * 2);
                            i4 = ((int) (this.fEP * 1.5f)) + this.fEI;
                        } else if (this.fEQ.picWidth < this.fEP) {
                            if (this.fEQ.picHeight < this.fEP) {
                                if (this.fEQ.picWidth < this.fEQ.picHeight) {
                                    i3 = this.fEP;
                                    i4 = (this.fEQ.picHeight * i3) / this.fEQ.picWidth;
                                } else {
                                    i4 = this.fEP;
                                    i3 = (this.fEQ.picWidth * i4) / this.fEQ.picHeight;
                                }
                            } else if (this.fEQ.picHeight < this.fEP || this.fEQ.picHeight >= this.fEP * 2) {
                                i4 = 0;
                                i3 = 0;
                            } else {
                                i3 = this.fEP;
                                i4 = (this.fEQ.picHeight * i3) / this.fEQ.picWidth;
                            }
                        } else if (this.fEQ.picWidth >= this.fEP && this.fEQ.picWidth < this.fEP * 2) {
                            if (this.fEQ.picHeight < this.fEP) {
                                i4 = this.fEP;
                                i3 = (this.fEQ.picWidth * i4) / this.fEQ.picHeight;
                            } else if (this.fEQ.picHeight >= this.fEP && this.fEQ.picHeight < this.fEP * 2) {
                                i3 = this.fEQ.picWidth;
                                i4 = this.fEQ.picHeight;
                            } else {
                                i4 = (this.fEP * 2) + this.fEI;
                                i3 = (this.fEQ.picWidth * i4) / this.fEQ.picHeight;
                            }
                        } else if (this.fEQ.picHeight < this.fEP) {
                            i4 = 0;
                            i3 = 0;
                        } else if (this.fEQ.picHeight >= this.fEP && this.fEQ.picHeight < this.fEP * 2) {
                            i3 = this.fEI + (this.fEP * 2);
                            i4 = (this.fEQ.picHeight * i3) / this.fEQ.picWidth;
                        } else if (this.fEQ.picWidth < this.fEQ.picHeight) {
                            i4 = (this.fEP * 2) + this.fEI;
                            i3 = (this.fEQ.picWidth * i4) / this.fEQ.picHeight;
                        } else {
                            i3 = this.fEI + (this.fEP * 2);
                            i4 = (this.fEQ.picHeight * i3) / this.fEQ.picWidth;
                        }
                    } else {
                        i4 = (this.fEP * 2) + this.fEI;
                        i3 = i4;
                    }
                    int[] c = com.baidu.tbadk.a.b.a.c(this.fEQ);
                    if (c[0] > 0 && c[1] > 0) {
                        i3 = c[0];
                        i4 = c[1];
                    }
                } else {
                    i3 = i5 / max;
                    i4 = this.fEO > 0 ? this.fEO : i3;
                }
            } else {
                i3 = i5 / max;
                i4 = this.fEB > 0.0d ? (int) ((i3 * this.fEB) + 0.5d) : i3;
                if (this.fEO > 0) {
                    i4 = this.fEO;
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
                int i6 = (this.fEI + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        bEF();
        if (!StringUtils.isNull(this.fEL) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.fEL != null) {
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
                a(canvas, i, com.baidu.tbadk.core.elementsMaven.a.aD(R.string.J_X11));
            }
        }
    }

    private void bEF() {
        if (this.fED != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width > 0 && height > 0) {
                if (getChildCount() == 1) {
                    this.fED.i(1, childAt.getWidth(), childAt.getHeight());
                } else {
                    this.fED.i(2, childAt.getWidth(), childAt.getHeight());
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

    private void a(Canvas canvas, RectF rectF, float[] fArr) {
        int i;
        if (rectF != null) {
            if (this.mMaskBitmap == null || this.mMaskBitmap.isRecycled()) {
                int i2 = (int) (rectF.right - rectF.left);
                int i3 = (int) (rectF.bottom - rectF.top);
                this.mMaskBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.mMaskBitmap);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-fArr[0], 0.0f, i2, i3);
                int i4 = Integer.MIN_VALUE;
                if (com.baidu.tbadk.a.d.bhm()) {
                    i = ap.getColor(R.color.CAM_X0601);
                    i4 = ap.getColor(R.color.CAM_X0606);
                } else {
                    i = 0;
                }
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i3, i, i4, Shader.TileMode.CLAMP));
                canvas2.drawPath(com.baidu.tbadk.core.elementsMaven.a.b.a(rectF2, fArr), this.mBitmapPaint);
            }
            canvas.drawBitmap(this.mMaskBitmap, rectF.left, rectF.top, this.fEM);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            int dimenPixelSize2 = ((int) rectF.right) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int i5 = ((int) rectF.bottom) - dimenPixelSize;
            int measureText = dimenPixelSize2 - ((int) this.textPaint.measureText(this.fEL));
            float[] oJ = com.baidu.tbadk.core.elementsMaven.a.oJ(R.array.S_O_X001);
            this.textPaint.setShadowLayer(oJ[1], oJ[2], oJ[3], (int) oJ[0]);
            canvas.drawText(this.fEL, measureText, i5, this.textPaint);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bEG();
            this.textPaint.setColor(ap.getColor(R.color.CAM_X0101));
            invalidate();
        }
    }

    private void bEG() {
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
        this.fEO = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fsa = bdUniqueId;
    }

    public void setTbImageViewConfiguration(a aVar) {
        this.fEv = aVar;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.fED = bVar;
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.fEF = z;
    }
}
