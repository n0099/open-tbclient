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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageLayout extends ViewGroup {
    private Paint Mi;
    private int Pl;
    protected boolean YG;
    private MediaData YK;
    private int YL;
    private int YM;
    private Bitmap YS;
    private boolean Yd;
    private d Yx;
    private int cJA;
    private int cJB;
    private ViewGroup.OnHierarchyChangeListener cJC;
    private a cJj;
    private double cJp;
    private com.baidu.adp.widget.a.b cJr;
    private boolean cJt;
    protected com.baidu.adp.lib.e.b<TbImageView> cJv;
    private int cJw;
    private int cJx;
    private String cJy;
    private Paint cJz;
    protected BdUniqueId cxx;
    private TbImageView.b mOnDrawListener;
    private int mSkinType;
    private Paint textPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(TbImageView tbImageView, int i);
    }

    public ConstrainImageLayout(Context context) {
        super(context);
        this.cJw = -1;
        this.Yd = false;
        this.cJx = R.color.common_color_10082;
        this.Pl = 0;
        this.YG = false;
        this.cJt = false;
        this.YL = 0;
        this.mSkinType = 3;
        this.cJC = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    int childCount = ConstrainImageLayout.this.getChildCount();
                    if (childCount <= 0) {
                        ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.cJv != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.cJv.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.atw().qH(com.baidu.adp.lib.f.c.iE().e(tbImageView.getUrl(), ConstrainImageLayout.this.Yd ? 13 : 14));
                    if (qH != null) {
                        int width = qH.getWidth();
                        i = qH.getHeight();
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
                            if (ConstrainImageLayout.this.YG && i > i2) {
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
        this.cJw = -1;
        this.Yd = false;
        this.cJx = R.color.common_color_10082;
        this.Pl = 0;
        this.YG = false;
        this.cJt = false;
        this.YL = 0;
        this.mSkinType = 3;
        this.cJC = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    int childCount = ConstrainImageLayout.this.getChildCount();
                    if (childCount <= 0) {
                        ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.cJv != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.cJv.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.atw().qH(com.baidu.adp.lib.f.c.iE().e(tbImageView.getUrl(), ConstrainImageLayout.this.Yd ? 13 : 14));
                    if (qH != null) {
                        int width = qH.getWidth();
                        i = qH.getHeight();
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
                            if (ConstrainImageLayout.this.YG && i > i2) {
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
        this.cJw = -1;
        this.Yd = false;
        this.cJx = R.color.common_color_10082;
        this.Pl = 0;
        this.YG = false;
        this.cJt = false;
        this.YL = 0;
        this.mSkinType = 3;
        this.cJC = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view2 instanceof TbImageView) {
                    int childCount = ConstrainImageLayout.this.getChildCount();
                    if (childCount <= 0) {
                        ((TbImageView) view2).setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
                if ((view2 instanceof TbImageView) && ConstrainImageLayout.this.cJv != null) {
                    TbImageView tbImageView = (TbImageView) view2;
                    tbImageView.reset();
                    ConstrainImageLayout.this.cJv.t(tbImageView);
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
                    com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.atw().qH(com.baidu.adp.lib.f.c.iE().e(tbImageView.getUrl(), ConstrainImageLayout.this.Yd ? 13 : 14));
                    if (qH != null) {
                        int width = qH.getWidth();
                        i2 = qH.getHeight();
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
                            if (ConstrainImageLayout.this.YG && i2 > i22) {
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
        setOnHierarchyChangeListener(this.cJC);
        this.textPaint = new Paint();
        this.textPaint.setColor(am.getColor(R.color.cp_btn_a));
        this.textPaint.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbfontsize52));
        this.textPaint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.Pl = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.cJA = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
        this.cJz = new Paint();
        this.cJz.setAntiAlias(true);
        this.Mi = new Paint();
        this.Mi.setAntiAlias(true);
        this.Mi.setColor(ViewCompat.MEASURED_STATE_MASK);
        setLayerType(1, null);
    }

    public void setImageClickListener(d dVar) {
        if (dVar == null) {
            setClickable(false);
        } else {
            this.Yx = dVar;
        }
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.cJv = bVar;
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setForeColorId(int i) {
        this.cJx = i;
    }

    public void setExtraCenterText(String str) {
        this.cJy = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.cJw = i;
        } else {
            this.cJw = -1;
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
        this.cJp = d;
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        setUrls(list, i, z, true);
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int Z;
        if (this.cJv != null && (Z = v.Z(list)) > 0) {
            if (Z == 1) {
                this.YK = (MediaData) v.c(list, 0);
            }
            lp(Z);
            int childCount = getChildCount();
            int i2 = this.Yd ? 13 : 14;
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
                    if (!aq.bV(a2, tbImageView.getUrl())) {
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
                    tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
                    tbImageView.setBorderSurroundContent(true);
                    tbImageView.setDrawBorder(true);
                    tbImageView.setOnDrawListener(this.mOnDrawListener);
                    if (this.cJj != null) {
                        this.cJj.a(tbImageView, i3);
                    }
                    tbImageView.startLoad(a2, i2, false);
                }
                i3++;
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.YG = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.Yx != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof b) {
                ((b) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new b(i, z, z2));
            }
        } else if (this.Yx == null && tbImageView != null) {
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
        private boolean Yz;
        private int currentIndex;
        private boolean hasMore;

        public b(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Yz = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.Yx != null) {
                ConstrainImageLayout.this.Yx.a(view, this.currentIndex, this.hasMore && this.Yz);
            }
        }
    }

    public void setImagePadding(int i) {
        this.YM = i;
    }

    private void lp(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView iD = this.cJv.iD();
                iD.setContentDescription(getResources().getString(R.string.editor_image));
                iD.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iD.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                iD.setPageId(this.cxx);
                addView(iD);
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
            int max = Math.max(childCount, this.cJw);
            int size = View.MeasureSpec.getSize(i);
            int i5 = size - ((max - 1) * this.YM);
            if (this.cJt) {
                if (childCount == 1) {
                    if (this.YL == 0) {
                        this.YL = (int) ((size - (this.YM * 2)) / 3.0f);
                    }
                    if (this.YK != null && this.YK.picWidth > 0 && this.YK.picHeight > 0) {
                        if (this.YK.picWidth * 2 <= this.YK.picHeight) {
                            i3 = this.YM + ((int) (this.YL * 1.5f));
                            i4 = (this.YL * 2) + this.YM;
                        } else if (this.YK.picHeight * 2 <= this.YK.picWidth) {
                            i3 = this.YM + (this.YL * 2);
                            i4 = ((int) (this.YL * 1.5f)) + this.YM;
                        } else if (this.YK.picWidth < this.YL) {
                            if (this.YK.picHeight < this.YL) {
                                if (this.YK.picWidth < this.YK.picHeight) {
                                    i3 = this.YL;
                                    i4 = (this.YK.picHeight * i3) / this.YK.picWidth;
                                } else {
                                    i4 = this.YL;
                                    i3 = (this.YK.picWidth * i4) / this.YK.picHeight;
                                }
                            } else if (this.YK.picHeight < this.YL || this.YK.picHeight >= this.YL * 2) {
                                i4 = 0;
                                i3 = 0;
                            } else {
                                i3 = this.YL;
                                i4 = (this.YK.picHeight * i3) / this.YK.picWidth;
                            }
                        } else if (this.YK.picWidth >= this.YL && this.YK.picWidth < this.YL * 2) {
                            if (this.YK.picHeight < this.YL) {
                                i4 = this.YL;
                                i3 = (this.YK.picWidth * i4) / this.YK.picHeight;
                            } else if (this.YK.picHeight >= this.YL && this.YK.picHeight < this.YL * 2) {
                                i3 = this.YK.picWidth;
                                i4 = this.YK.picHeight;
                            } else {
                                i4 = (this.YL * 2) + this.YM;
                                i3 = (this.YK.picWidth * i4) / this.YK.picHeight;
                            }
                        } else if (this.YK.picHeight < this.YL) {
                            i4 = 0;
                            i3 = 0;
                        } else if (this.YK.picHeight >= this.YL && this.YK.picHeight < this.YL * 2) {
                            i3 = this.YM + (this.YL * 2);
                            i4 = (this.YK.picHeight * i3) / this.YK.picWidth;
                        } else if (this.YK.picWidth < this.YK.picHeight) {
                            i4 = (this.YL * 2) + this.YM;
                            i3 = (this.YK.picWidth * i4) / this.YK.picHeight;
                        } else {
                            i3 = this.YM + (this.YL * 2);
                            i4 = (this.YK.picHeight * i3) / this.YK.picWidth;
                        }
                    } else {
                        i4 = (this.YL * 2) + this.YM;
                        i3 = i4;
                    }
                } else {
                    i3 = i5 / max;
                    i4 = this.cJB > 0 ? this.cJB : i3;
                }
            } else {
                i3 = i5 / max;
                i4 = this.cJp > 0.0d ? (int) ((i3 * this.cJp) + 0.5d) : i3;
                if (this.cJB > 0) {
                    i4 = this.cJB;
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
                int i6 = (this.YM + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        ayo();
        if (!StringUtils.isNull(this.cJy) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.cJy != null) {
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

    private void ayo() {
        if (this.cJr != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width > 0 && height > 0) {
                if (getChildCount() == 1) {
                    this.cJr.j(1, childAt.getWidth(), childAt.getHeight());
                } else {
                    this.cJr.j(2, childAt.getWidth(), childAt.getHeight());
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
            if (this.YS == null || this.YS.isRecycled()) {
                int i = (int) (rectF.right - rectF.left);
                int i2 = (int) (rectF.bottom - rectF.top);
                this.YS = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.YS);
                canvas2.drawARGB(0, 0, 0, 0);
                RectF rectF2 = new RectF(-f, 0.0f, i, i2);
                this.Mi.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i2, 0, Integer.MIN_VALUE, Shader.TileMode.CLAMP));
                canvas2.drawRoundRect(rectF2, f, f, this.Mi);
            }
            canvas.drawBitmap(this.YS, rectF.left, rectF.top, this.cJz);
            canvas.drawText(this.cJy, ((int) rectF.centerX()) - (((int) this.textPaint.measureText(this.cJy)) / 2), (((int) rectF.centerY()) + (this.Pl / 2)) - this.cJA, this.textPaint);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            alb();
            this.textPaint.setColor(am.getColor(R.color.cp_btn_a));
            invalidate();
        }
    }

    private void alb() {
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
        this.cJB = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cxx = bdUniqueId;
    }

    public void setTbImageViewConfiguration(a aVar) {
        this.cJj = aVar;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.cJr = bVar;
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.cJt = z;
    }
}
