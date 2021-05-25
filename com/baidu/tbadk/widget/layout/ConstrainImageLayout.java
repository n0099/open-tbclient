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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class ConstrainImageLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f13121e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.e.k.b<TbImageView> f13122f;

    /* renamed from: g  reason: collision with root package name */
    public int f13123g;

    /* renamed from: h  reason: collision with root package name */
    public int f13124h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13125i;
    public d.a.m0.b1.j.d j;
    public String k;
    public Paint l;
    public Paint m;
    public Paint n;
    public double o;
    public int p;
    public boolean q;
    public d.a.c.j.c.b r;
    public Bitmap s;
    public boolean t;
    public int u;
    public MediaData v;
    public int w;
    public c x;
    public ViewGroup.OnHierarchyChangeListener y;
    public TbImageView.g z;

    /* loaded from: classes3.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view2 instanceof TbImageView) {
                ((TbImageView) view2).setPlaceHolder(2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof TbImageView) || ConstrainImageLayout.this.f13122f == null) {
                return;
            }
            TbImageView tbImageView = (TbImageView) view2;
            tbImageView.Q();
            ConstrainImageLayout.this.f13122f.e(tbImageView);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.g {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            if (tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.a.c.j.d.a m = d.a.m0.a0.c.k().m(d.a.c.e.l.d.h().g(tbImageView.getUrl(), ConstrainImageLayout.this.f13125i ? 13 : 14));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            float f10 = 0.0f;
            if (tbImageView.K() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                if (i3 * height > width * i2) {
                    f7 = height / i2;
                    float f11 = i3;
                    float f12 = smartCropCenterPointWidthRatio * f11 * f7;
                    float f13 = width;
                    float f14 = 0.5f * f13;
                    if (f12 < f14) {
                        f9 = 0.0f;
                    } else {
                        float f15 = f11 * f7;
                        f9 = f15 - f12 < f14 ? f13 - f15 : f14 - f12;
                    }
                    f10 = f9;
                } else {
                    float f16 = width / i3;
                    float f17 = i2;
                    float f18 = smartCropCenterPointHeightRatio * f17 * f16;
                    float f19 = height;
                    float f20 = 0.5f * f19;
                    if (f18 >= f20) {
                        float f21 = f17 * f16;
                        if (f21 - f18 < f20) {
                            f8 = f19 - f21;
                            f7 = f16;
                        } else {
                            float f22 = f20 - f18;
                            f7 = f16;
                            f8 = f22;
                        }
                        imageMatrix.setScale(f7, f7);
                        imageMatrix.postTranslate(f10, f8);
                    }
                    f7 = f16;
                }
                f8 = 0.0f;
                imageMatrix.setScale(f7, f7);
                imageMatrix.postTranslate(f10, f8);
            } else if (tbImageView.I() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f5 = height;
                    f6 = i2;
                } else {
                    f5 = width;
                    f6 = i3;
                }
                float f23 = f5 / f6;
                imageMatrix.setScale(f23, f23);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f2 = height / i2;
                    f4 = (width - (i3 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i3;
                    f3 = (height - (i2 * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (ConstrainImageLayout.this.q && i2 > i3) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(TbImageView tbImageView, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f13128e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f13129f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f13130g;

        public d(int i2, boolean z, boolean z2) {
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            this.f13128e = i2;
            this.f13129f = z;
            this.f13130g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConstrainImageLayout.this.j != null) {
                ConstrainImageLayout.this.j.a(view, this.f13128e, this.f13129f && this.f13130g);
            }
        }
    }

    public ConstrainImageLayout(Context context) {
        super(context);
        this.f13124h = -1;
        this.f13125i = false;
        this.q = false;
        this.t = false;
        this.u = 0;
        this.w = 3;
        this.y = new a();
        this.z = new b();
        g();
    }

    public final void c() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2) instanceof TbImageView) {
                ((TbImageView) getChildAt(i2)).setPlaceHolder(2);
            }
        }
    }

    public final void d(Canvas canvas, RectF rectF, float[] fArr) {
        int i2;
        int i3;
        if (rectF == null) {
            return;
        }
        Bitmap bitmap = this.s;
        if (bitmap == null || bitmap.isRecycled()) {
            int i4 = (int) (rectF.right - rectF.left);
            int i5 = (int) (rectF.bottom - rectF.top);
            this.s = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.s);
            canvas2.drawARGB(0, 0, 0, 0);
            float f2 = i5;
            RectF rectF2 = new RectF(-fArr[0], 0.0f, i4, f2);
            if (d.a.m0.b.d.V()) {
                i2 = SkinManager.getColor(R.color.CAM_X0601);
                i3 = SkinManager.getColor(R.color.CAM_X0606);
            } else {
                i2 = 0;
                i3 = Integer.MIN_VALUE;
            }
            this.m.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f2, i2, i3, Shader.TileMode.CLAMP));
            canvas2.drawPath(d.a.m0.r.u.d.a.a(rectF2, fArr), this.m);
        }
        canvas.drawBitmap(this.s, rectF.left, rectF.top, this.l);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        int i6 = ((int) rectF.bottom) - dimenPixelSize;
        int measureText = (((int) rectF.right) - dimenPixelSize2) - ((int) this.n.measureText(this.k));
        float[] y = d.a.m0.r.u.a.y(R.array.S_O_X001);
        this.n.setShadowLayer(y[1], y[2], y[3], (int) y[0]);
        canvas.drawText(this.k, measureText, i6, this.n);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
        super.dispatchDraw(canvas);
        l();
        if (StringUtils.isNull(this.k) || (childCount = getChildCount()) <= 0 || getChildAt(childCount - 1) == null || this.k == null) {
            return;
        }
        TbImageView tbImageView = null;
        int childCount2 = getChildCount();
        while (true) {
            if (childCount2 <= 0) {
                break;
            } else if (getChildAt(childCount2) instanceof TbImageView) {
                tbImageView = (TbImageView) getChildAt(childCount2);
                break;
            } else {
                childCount2--;
            }
        }
        RectF e2 = e(tbImageView);
        if (e2 == null) {
            return;
        }
        d(canvas, e2, d.a.m0.r.u.a.v(R.string.J_X11));
    }

    public final RectF e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return null;
        }
        return new RectF(tbImageView.getLeft(), tbImageView.getTop(), tbImageView.getRight(), tbImageView.getBottom());
    }

    public final String f(MediaData mediaData) {
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
        return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
    }

    public final void g() {
        setOnHierarchyChangeListener(this.y);
        Paint paint = new Paint();
        this.n = paint;
        paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
        this.n.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
        this.n.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.n.getFontMetrics();
        Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        float f2 = fontMetrics.ascent;
        float f3 = fontMetrics.top;
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.m = paint3;
        paint3.setAntiAlias(true);
        this.m.setColor(-16777216);
        setLayerType(1, null);
    }

    public void h() {
        if (this.w != TbadkCoreApplication.getInst().getSkinType()) {
            this.w = TbadkCoreApplication.getInst().getSkinType();
            c();
            this.n.setColor(SkinManager.getColor(R.color.CAM_X0101));
            invalidate();
        }
    }

    public void i() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.Q();
            }
        }
    }

    public final void j(int i2) {
        int childCount = getChildCount() - i2;
        if (childCount > 0) {
            removeViews(i2, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i3 = 0; i3 < abs; i3++) {
                TbImageView b2 = this.f13122f.b();
                b2.setContentDescription(getResources().getString(R.string.editor_image));
                b2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                b2.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                b2.setPageId(this.f13121e);
                addView(b2);
            }
        }
    }

    public final void k(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        if (this.j != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof d) {
                ((d) onClickListener).a(i2, z, z2);
            } else {
                tbImageView.setOnClickListener(new d(i2, z, z2));
            }
        } else if (this.j != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void l() {
        if (this.r != null && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int width = childAt.getWidth();
            int height = childAt.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            if (getChildCount() == 1) {
                this.r.a(1, childAt.getWidth(), childAt.getHeight());
            } else {
                this.r.a(2, childAt.getWidth(), childAt.getHeight());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int i7 = (this.f13123g + measuredWidth) * i6;
                childAt.layout(i7, 0, measuredWidth + i7, i5 - i3);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int max = Math.max(childCount, this.f13124h);
        int size = View.MeasureSpec.getSize(i2);
        int i8 = this.f13123g;
        int i9 = size - ((max - 1) * i8);
        if (!this.t) {
            i4 = i9 / max;
            double d2 = this.o;
            i5 = d2 > 0.0d ? (int) ((i4 * d2) + 0.5d) : i4;
            int i10 = this.p;
            if (i10 > 0) {
                i5 = i10;
            }
        } else if (childCount == 1) {
            if (this.u == 0) {
                this.u = (int) ((size - (i8 * 2)) / 3.0f);
            }
            MediaData mediaData = this.v;
            if (mediaData == null || (i4 = mediaData.picWidth) <= 0 || (i5 = mediaData.picHeight) <= 0) {
                i4 = this.f13123g + (this.u * 2);
                i5 = i4;
            } else {
                if (i4 * 2 <= i5) {
                    int i11 = this.u;
                    i6 = this.f13123g;
                    i4 = ((int) (i11 * 1.5f)) + i6;
                    i7 = i11 * 2;
                } else if (i5 * 2 <= i4) {
                    int i12 = this.u;
                    i6 = this.f13123g;
                    i4 = (i12 * 2) + i6;
                    i7 = (int) (i12 * 1.5f);
                } else {
                    int i13 = this.u;
                    if (i4 < i13) {
                        if (i5 >= i13) {
                            if (i5 >= i13 && i5 < i13 * 2) {
                                i5 = (i5 * i13) / i4;
                            }
                            i5 = 0;
                            i4 = 0;
                        } else if (i4 < i5) {
                            i5 = (i5 * i13) / i4;
                        } else {
                            i4 = (i4 * i13) / i5;
                            i5 = i13;
                        }
                        i4 = i13;
                    } else {
                        if (i4 < i13 || i4 >= i13 * 2) {
                            MediaData mediaData2 = this.v;
                            int i14 = mediaData2.picHeight;
                            int i15 = this.u;
                            if (i14 >= i15) {
                                if (i14 >= i15 && i14 < i15 * 2) {
                                    i13 = (i15 * 2) + this.f13123g;
                                    i5 = (i14 * i13) / mediaData2.picWidth;
                                } else {
                                    MediaData mediaData3 = this.v;
                                    int i16 = mediaData3.picWidth;
                                    int i17 = mediaData3.picHeight;
                                    if (i16 < i17) {
                                        i13 = (this.u * 2) + this.f13123g;
                                        i4 = (i16 * i13) / i17;
                                    } else {
                                        i13 = (this.u * 2) + this.f13123g;
                                        i5 = (i17 * i13) / i16;
                                    }
                                }
                                i4 = i13;
                            }
                            i5 = 0;
                            i4 = 0;
                        } else if (i5 < i13) {
                            i4 = (i4 * i13) / i5;
                        } else if (i5 < i13 || i5 >= i13 * 2) {
                            i5 = (this.u * 2) + this.f13123g;
                            MediaData mediaData4 = this.v;
                            i4 = (mediaData4.picWidth * i5) / mediaData4.picHeight;
                        }
                        i5 = i13;
                    }
                }
                i5 = i7 + i6;
            }
            int[] j = d.a.m0.b.g.b.j(this.v);
            if (j[0] > 0 && j[1] > 0) {
                i4 = j[0];
                i5 = j[1];
            }
        } else {
            i5 = i9 / max;
            int i18 = this.p;
            if (i18 > 0) {
                i4 = i5;
                i5 = i18;
            } else {
                i4 = i5;
            }
        }
        setMeasuredDimension(size, i5);
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt != null) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.q = z;
    }

    public void setExtraCenterText(String str) {
        this.k = str;
    }

    public void setFixedImageHeight(int i2) {
        this.p = i2;
    }

    public void setForeColorId(int i2) {
    }

    public void setFromCDN(boolean z) {
        this.f13125i = z;
    }

    public void setImageClickListener(d.a.m0.b1.j.d dVar) {
        if (dVar == null) {
            setClickable(false);
        } else {
            this.j = dVar;
        }
    }

    public void setImageMaxChildCount(int i2) {
        if (i2 > 0) {
            this.f13124h = i2;
        } else {
            this.f13124h = -1;
        }
    }

    public void setImagePadding(int i2) {
        this.f13123g = i2;
    }

    public void setImageViewObjectPool(d.a.c.e.k.b<TbImageView> bVar) {
        this.f13122f = bVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.f13121e = bdUniqueId;
    }

    public void setPreloadSizeReadyCallback(d.a.c.j.c.b bVar) {
        this.r = bVar;
    }

    public void setSingleImageRatio(double d2) {
        this.o = d2;
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.t = z;
    }

    public void setTbImageViewConfiguration(c cVar) {
        this.x = cVar;
    }

    public void setUrls(List<MediaData> list, int i2) {
        setUrls(list, i2, false);
    }

    public void setUrls(List<MediaData> list, int i2, boolean z) {
        setUrls(list, i2, z, true);
    }

    public void setUrls(List<MediaData> list, int i2, boolean z, boolean z2) {
        int count;
        if (this.f13122f != null && (count = ListUtils.getCount(list)) > 0) {
            if (count == 1) {
                this.v = (MediaData) ListUtils.getItem(list, 0);
            }
            j(count);
            int childCount = getChildCount();
            int i3 = this.f13125i ? 13 : 14;
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                MediaData mediaData = list.get(i4);
                if ((childAt instanceof TbImageView) && mediaData != null) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z3 = i4 == childCount + (-1);
                    k(tbImageView, i2 + i4, z, z3);
                    if (z3 && z && z2) {
                        tbImageView.setLongIconSupport(false);
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setLongIconSupport(true);
                        tbImageView.setGifIconSupport(true);
                    }
                    String f2 = f(mediaData);
                    if (!StringHelper.equals(f2, tbImageView.getUrl())) {
                        tbImageView.Q();
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
                    tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                    tbImageView.setBorderSurroundContent(true);
                    tbImageView.setDrawBorder(true);
                    tbImageView.setOnDrawListener(this.z);
                    c cVar = this.x;
                    if (cVar != null) {
                        cVar.a(tbImageView, i4, childCount);
                    }
                    tbImageView.V(f2, i3, false);
                }
                i4++;
            }
        }
    }

    public ConstrainImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13124h = -1;
        this.f13125i = false;
        this.q = false;
        this.t = false;
        this.u = 0;
        this.w = 3;
        this.y = new a();
        this.z = new b();
        g();
    }

    public ConstrainImageLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13124h = -1;
        this.f13125i = false;
        this.q = false;
        this.t = false;
        this.u = 0;
        this.w = 3;
        this.y = new a();
        this.z = new b();
        g();
    }
}
