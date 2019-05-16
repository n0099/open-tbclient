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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private int OV;
    private boolean XJ;
    private d Yd;
    protected boolean Ym;
    private MediaData Yq;
    private int Yr;
    private int Ys;
    private Bitmap Yy;
    private a cHO;
    private double cHU;
    private com.baidu.adp.widget.a.b cHW;
    private boolean cHY;
    protected com.baidu.adp.lib.e.b<TbImageView> cIa;
    private int cIb;
    private int cIc;
    private String cId;
    private Paint cIe;
    private int cIf;
    private int cIg;
    private ViewGroup.OnHierarchyChangeListener cIh;
    protected BdUniqueId cwh;
    private Paint mBitmapPaint;
    private TbImageView.b mOnDrawListener;
    private int mSkinType;
    private Paint textPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(TbImageView tbImageView, int i);
    }

    public ConstrainImageLayout(Context context) {
        super(context);
        this.cIb = -1;
        this.XJ = false;
        this.cIc = R.color.common_color_10082;
        this.OV = 0;
        this.Ym = false;
        this.cHY = false;
        this.Yr = 0;
        this.mSkinType = 3;
        this.cIh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    int childCount = ConstrainImageLayout.this.getChildCount();
                    if (childCount <= 0) {
                        ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.get());
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < childCount; i++) {
                        if (ConstrainImageLayout.this.getChildAt(i) != view2 && (ConstrainImageLayout.this.getChildAt(i) instanceof TbImageView)) {
                            arrayList.add(Integer.valueOf(((TbImageView) ConstrainImageLayout.this.getChildAt(i)).getDefaultBgResource()));
                        }
                    }
                    ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.ap(arrayList));
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.cIa != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.cIa.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a qr = com.baidu.tbadk.imageManager.c.asp().qr(com.baidu.adp.lib.f.c.iv().e(tbImageView.getUrl(), ConstrainImageLayout.this.XJ ? 13 : 14));
                    if (qr != null) {
                        int width = qr.getWidth();
                        i = qr.getHeight();
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
                            if (ConstrainImageLayout.this.Ym && i > i2) {
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
        this.cIb = -1;
        this.XJ = false;
        this.cIc = R.color.common_color_10082;
        this.OV = 0;
        this.Ym = false;
        this.cHY = false;
        this.Yr = 0;
        this.mSkinType = 3;
        this.cIh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    int childCount = ConstrainImageLayout.this.getChildCount();
                    if (childCount <= 0) {
                        ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.get());
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < childCount; i++) {
                        if (ConstrainImageLayout.this.getChildAt(i) != view2 && (ConstrainImageLayout.this.getChildAt(i) instanceof TbImageView)) {
                            arrayList.add(Integer.valueOf(((TbImageView) ConstrainImageLayout.this.getChildAt(i)).getDefaultBgResource()));
                        }
                    }
                    ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.ap(arrayList));
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.cIa != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.cIa.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a qr = com.baidu.tbadk.imageManager.c.asp().qr(com.baidu.adp.lib.f.c.iv().e(tbImageView.getUrl(), ConstrainImageLayout.this.XJ ? 13 : 14));
                    if (qr != null) {
                        int width = qr.getWidth();
                        i = qr.getHeight();
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
                            if (ConstrainImageLayout.this.Ym && i > i2) {
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
        this.cIb = -1;
        this.XJ = false;
        this.cIc = R.color.common_color_10082;
        this.OV = 0;
        this.Ym = false;
        this.cHY = false;
        this.Yr = 0;
        this.mSkinType = 3;
        this.cIh = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    int childCount = ConstrainImageLayout.this.getChildCount();
                    if (childCount <= 0) {
                        ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.get());
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        if (ConstrainImageLayout.this.getChildAt(i2) != view2 && (ConstrainImageLayout.this.getChildAt(i2) instanceof TbImageView)) {
                            arrayList.add(Integer.valueOf(((TbImageView) ConstrainImageLayout.this.getChildAt(i2)).getDefaultBgResource()));
                        }
                    }
                    ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.ap(arrayList));
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.cIa != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.cIa.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a qr = com.baidu.tbadk.imageManager.c.asp().qr(com.baidu.adp.lib.f.c.iv().e(tbImageView.getUrl(), ConstrainImageLayout.this.XJ ? 13 : 14));
                    if (qr != null) {
                        int width = qr.getWidth();
                        i2 = qr.getHeight();
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
                            if (ConstrainImageLayout.this.Ym && i2 > i22) {
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
        setOnHierarchyChangeListener(this.cIh);
        this.textPaint = new Paint();
        this.textPaint.setColor(al.getColor(R.color.cp_btn_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.OV = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.cIf = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.cIe = new Paint();
        this.cIe.setAntiAlias(true);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        setLayerType(1, null);
    }

    public void setImageClickListener(d dVar) {
        if (dVar == null) {
            setClickable(false);
        } else {
            this.Yd = dVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.cIa = bVar;
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    public void setForeColorId(int i) {
        this.cIc = i;
    }

    public void setExtraCenterText(String str) {
        this.cId = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.cIb = i;
        } else {
            this.cIb = -1;
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
        this.cHU = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        setUrls(list, i, z, true);
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int Z;
        if (this.cIa != null && (Z = v.Z(list)) > 0) {
            if (Z == 1) {
                this.Yq = (MediaData) v.c(list, 0);
            }
            lj(Z);
            int childCount = getChildCount();
            int i2 = this.XJ ? 13 : 14;
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
                    if (!ap.equals(a2, tbImageView.getUrl())) {
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
                    tbImageView.setBorderColor(al.getColor(R.color.black_alpha8));
                    tbImageView.setBorderSurroundContent(true);
                    tbImageView.setDrawBorder(true);
                    tbImageView.setOnDrawListener(this.mOnDrawListener);
                    if (this.cHO != null) {
                        this.cHO.a(tbImageView, i3);
                    }
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ym = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.Yd != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof b) {
                ((b) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new b(i, z, z2));
            }
        } else if (this.Yd == null && tbImageView != null) {
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
        private boolean Yf;
        private int currentIndex;
        private boolean hasMore;

        public b(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Yf = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.Yd != null) {
                ConstrainImageLayout.this.Yd.a(view, this.currentIndex, this.hasMore && this.Yf);
            }
        }
    }

    public void setImagePadding(int i) {
        this.Ys = i;
    }

    private void lj(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView iu = this.cIa.iu();
                iu.setContentDescription(getResources().getString(R.string.editor_image));
                iu.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iu.setDefaultBg(al.getDrawable(R.color.common_color_10220));
                iu.setPageId(this.cwh);
                addView(iu);
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
            int max = Math.max(childCount, this.cIb);
            int size = View.MeasureSpec.getSize(i);
            int i5 = size - ((max - 1) * this.Ys);
            if (this.cHY) {
                if (childCount == 1) {
                    if (this.Yr == 0) {
                        this.Yr = (int) ((size - (this.Ys * 2)) / 3.0f);
                    }
                    if (this.Yq != null && this.Yq.picWidth > 0 && this.Yq.picHeight > 0) {
                        if (this.Yq.picWidth * 2 <= this.Yq.picHeight) {
                            i3 = this.Ys + ((int) (this.Yr * 1.5f));
                            i4 = (this.Yr * 2) + this.Ys;
                        } else if (this.Yq.picHeight * 2 <= this.Yq.picWidth) {
                            i3 = this.Ys + (this.Yr * 2);
                            i4 = ((int) (this.Yr * 1.5f)) + this.Ys;
                        } else if (this.Yq.picWidth < this.Yr) {
                            if (this.Yq.picHeight < this.Yr) {
                                if (this.Yq.picWidth < this.Yq.picHeight) {
                                    i3 = this.Yr;
                                    i4 = (this.Yq.picHeight * i3) / this.Yq.picWidth;
                                } else {
                                    i4 = this.Yr;
                                    i3 = (this.Yq.picWidth * i4) / this.Yq.picHeight;
                                }
                            } else if (this.Yq.picHeight < this.Yr || this.Yq.picHeight >= this.Yr * 2) {
                                i4 = 0;
                                i3 = 0;
                            } else {
                                i3 = this.Yr;
                                i4 = (this.Yq.picHeight * i3) / this.Yq.picWidth;
                            }
                        } else if (this.Yq.picWidth >= this.Yr && this.Yq.picWidth < this.Yr * 2) {
                            if (this.Yq.picHeight < this.Yr) {
                                i4 = this.Yr;
                                i3 = (this.Yq.picWidth * i4) / this.Yq.picHeight;
                            } else if (this.Yq.picHeight >= this.Yr && this.Yq.picHeight < this.Yr * 2) {
                                i3 = this.Yq.picWidth;
                                i4 = this.Yq.picHeight;
                            } else {
                                i4 = (this.Yr * 2) + this.Ys;
                                i3 = (this.Yq.picWidth * i4) / this.Yq.picHeight;
                            }
                        } else if (this.Yq.picHeight < this.Yr) {
                            i4 = 0;
                            i3 = 0;
                        } else if (this.Yq.picHeight >= this.Yr && this.Yq.picHeight < this.Yr * 2) {
                            i3 = this.Ys + (this.Yr * 2);
                            i4 = (this.Yq.picHeight * i3) / this.Yq.picWidth;
                        } else if (this.Yq.picWidth < this.Yq.picHeight) {
                            i4 = (this.Yr * 2) + this.Ys;
                            i3 = (this.Yq.picWidth * i4) / this.Yq.picHeight;
                        } else {
                            i3 = this.Ys + (this.Yr * 2);
                            i4 = (this.Yq.picHeight * i3) / this.Yq.picWidth;
                        }
                    } else {
                        i4 = (this.Yr * 2) + this.Ys;
                        i3 = i4;
                    }
                } else {
                    i3 = i5 / max;
                    i4 = this.cIg > 0 ? this.cIg : i3;
                }
            } else {
                i3 = i5 / max;
                i4 = this.cHU > 0.0d ? (int) ((i3 * this.cHU) + 0.5d) : i3;
                if (this.cIg > 0) {
                    i4 = this.cIg;
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
                int i6 = (this.Ys + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        axb();
        if (!StringUtils.isNull(this.cId) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.cId != null) {
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
            RectF d = d(tbImageView);
            if (d != null) {
                a(canvas, d, tbImageView.getRadius());
            }
        }
    }

    private void axb() {
        if (this.cHW != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width > 0 && height > 0) {
                if (getChildCount() == 1) {
                    this.cHW.j(1, childAt.getWidth(), childAt.getHeight());
                } else {
                    this.cHW.j(2, childAt.getWidth(), childAt.getHeight());
                }
            }
        }
    }

    private RectF d(TbImageView tbImageView) {
        if (tbImageView == null) {
            return null;
        }
        return new RectF(tbImageView.getLeft(), tbImageView.getTop(), tbImageView.getRight(), tbImageView.getBottom());
    }

    private void a(Canvas canvas, RectF rectF, float f) {
        if (rectF != null) {
            if (this.Yy == null || this.Yy.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.Yy = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.Yy);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-f, 0.0f, i, i2);
                this.mBitmapPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawRoundRect(rectF2, f, f, this.mBitmapPaint);
            }
            canvas.drawBitmap(this.Yy, rectF.left, rectF.top, this.cIe);
            canvas.drawText(this.cId, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.cId)) / 2), (((int) rectF.centerY()) + (this.OV / 2)) - this.cIf, this.textPaint);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ajW();
            this.textPaint.setColor(al.getColor(R.color.cp_btn_a));
            invalidate();
        }
    }

    private void ajW() {
        int childCount = getChildCount();
        if (childCount > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) instanceof TbImageView) {
                    int ap = com.baidu.tbadk.util.e.ap(arrayList);
                    ((TbImageView) getChildAt(i)).setDefaultBgResource(ap);
                    arrayList.add(Integer.valueOf(ap));
                }
            }
        }
    }

    public void setFixedImageHeight(int i) {
        this.cIg = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cwh = bdUniqueId;
    }

    public void setTbImageViewConfiguration(a aVar) {
        this.cHO = aVar;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.cHW = bVar;
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cHY = z;
    }
}
