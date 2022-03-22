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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ConstrainImageLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.f.k.b<TbImageView> f30802b;

    /* renamed from: c  reason: collision with root package name */
    public int f30803c;

    /* renamed from: d  reason: collision with root package name */
    public int f30804d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30805e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.e1.j.d f30806f;

    /* renamed from: g  reason: collision with root package name */
    public String f30807g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f30808h;
    public Paint i;
    public Paint j;
    public double k;
    public int l;
    public boolean m;
    public c.a.d.o.c.b n;
    public Bitmap o;
    public boolean p;
    public int q;
    public MediaData r;
    public int s;
    public c t;
    public ViewGroup.OnHierarchyChangeListener u;
    public TbImageView.h v;

    /* loaded from: classes5.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConstrainImageLayout a;

        public a(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = constrainImageLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) && (view2 instanceof TbImageView)) {
                ((TbImageView) view2).setPlaceHolder(2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof TbImageView) && this.a.f30802b != null) {
                TbImageView tbImageView = (TbImageView) view2;
                tbImageView.F();
                this.a.f30802b.e(tbImageView);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConstrainImageLayout a;

        public b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = constrainImageLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            c.a.d.o.d.a m = c.a.o0.b0.c.k().m(c.a.d.f.l.d.h().g(tbImageView.getUrl(), this.a.f30805e ? 13 : 14));
            int i2 = 0;
            if (m != null) {
                i2 = m.r();
                i = m.m();
            } else {
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            float f10 = 0.0f;
            if (tbImageView.z() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                if (i2 * height > width * i) {
                    f7 = height / i;
                    float f11 = i2;
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
                    float f16 = width / i2;
                    float f17 = i;
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
            } else if (tbImageView.x() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f5 = height;
                    f6 = i;
                } else {
                    f5 = width;
                    f6 = i2;
                }
                float f23 = f5 / f6;
                imageMatrix.setScale(f23, f23);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f2 = height / i;
                    f4 = (width - (i2 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i2;
                    f3 = (height - (i * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (this.a.m && i > i2) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(TbImageView tbImageView, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30809b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f30810c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ConstrainImageLayout f30811d;

        public d(ConstrainImageLayout constrainImageLayout, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainImageLayout, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30811d = constrainImageLayout;
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a = i;
                this.f30809b = z;
                this.f30810c = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f30811d.f30806f == null) {
                return;
            }
            this.f30811d.f30806f.a(view, this.a, this.f30809b && this.f30810c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30804d = -1;
        this.f30805e = false;
        this.m = false;
        this.p = false;
        this.q = 0;
        this.s = 3;
        this.u = new a(this);
        this.v = new b(this);
        g();
    }

    public final void c() {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) instanceof TbImageView) {
                ((TbImageView) getChildAt(i)).setPlaceHolder(2);
            }
        }
    }

    public final void d(Canvas canvas, RectF rectF, float[] fArr) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF, fArr) == null) || rectF == null) {
            return;
        }
        Bitmap bitmap = this.o;
        if (bitmap == null || bitmap.isRecycled()) {
            int i3 = (int) (rectF.right - rectF.left);
            int i4 = (int) (rectF.bottom - rectF.top);
            this.o = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.o);
            canvas2.drawARGB(0, 0, 0, 0);
            float f2 = i4;
            RectF rectF2 = new RectF(-fArr[0], 0.0f, i3, f2);
            if (UbsABTestHelper.showNewUI()) {
                i = SkinManager.getColor(R.color.CAM_X0601);
                i2 = SkinManager.getColor(R.color.CAM_X0606);
            } else {
                i = 0;
                i2 = Integer.MIN_VALUE;
            }
            this.i.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f2, i, i2, Shader.TileMode.CLAMP));
            canvas2.drawPath(c.a.o0.r.v.d.a.a(rectF2, fArr), this.i);
        }
        canvas.drawBitmap(this.o, rectF.left, rectF.top, this.f30808h);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        int i5 = ((int) rectF.bottom) - dimenPixelSize;
        int measureText = (((int) rectF.right) - dimenPixelSize2) - ((int) this.j.measureText(this.f30807g));
        float[] B = c.a.o0.r.v.a.B(R.array.S_O_X001);
        this.j.setShadowLayer(B[1], B[2], B[3], (int) B[0]);
        canvas.drawText(this.f30807g, measureText, i5, this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            l();
            if (StringUtils.isNull(this.f30807g) || (childCount = getChildCount()) <= 0 || getChildAt(childCount - 1) == null || this.f30807g == null) {
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
            d(canvas, e2, c.a.o0.r.v.a.y(R.string.J_X11));
        }
    }

    public final RectF e(TbImageView tbImageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbImageView)) == null) {
            if (tbImageView == null) {
                return null;
            }
            return new RectF(tbImageView.getLeft(), tbImageView.getTop(), tbImageView.getRight(), tbImageView.getBottom());
        }
        return (RectF) invokeL.objValue;
    }

    public final String f(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaData)) == null) {
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
        return (String) invokeL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setOnHierarchyChangeListener(this.u);
            Paint paint = new Paint();
            this.j = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.j.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
            this.j.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
            Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            float f2 = fontMetrics.ascent;
            float f3 = fontMetrics.top;
            Paint paint2 = new Paint();
            this.f30808h = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.i = paint3;
            paint3.setAntiAlias(true);
            this.i.setColor(-16777216);
            setLayerType(1, null);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.s == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.s = TbadkCoreApplication.getInst().getSkinType();
        c();
        this.j.setColor(SkinManager.getColor(R.color.CAM_X0101));
        invalidate();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tbImageView.F();
                }
            }
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int childCount = getChildCount() - i;
            if (childCount > 0) {
                removeViews(i, childCount);
            } else if (childCount < 0) {
                int abs = Math.abs(childCount);
                for (int i2 = 0; i2 < abs; i2++) {
                    TbImageView b2 = this.f30802b.b();
                    b2.setContentDescription(getResources().getString(R.string.obfuscated_res_0x7f0f051b));
                    b2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    b2.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                    b2.setPageId(this.a);
                    addView(b2);
                }
            }
        }
    }

    public final void k(TbImageView tbImageView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{tbImageView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.f30806f != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i, z, z2));
                }
            } else if (this.f30806f != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.n == null || getChildCount() <= 0) {
            return;
        }
        View childAt = getChildAt(0);
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (getChildCount() == 1) {
            this.n.a(1, childAt.getWidth(), childAt.getHeight());
        } else {
            this.n.a(2, childAt.getWidth(), childAt.getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int i6 = (this.f30803c + measuredWidth) * i5;
                    childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            if (childCount <= 0) {
                return;
            }
            int max = Math.max(childCount, this.f30804d);
            int size = View.MeasureSpec.getSize(i);
            int i7 = this.f30803c;
            int i8 = size - ((max - 1) * i7);
            if (!this.p) {
                i3 = i8 / max;
                double d2 = this.k;
                i4 = d2 > 0.0d ? (int) ((i3 * d2) + 0.5d) : i3;
                int i9 = this.l;
                if (i9 > 0) {
                    i4 = i9;
                }
            } else if (childCount == 1) {
                if (this.q == 0) {
                    this.q = (int) ((size - (i7 * 2)) / 3.0f);
                }
                MediaData mediaData = this.r;
                if (mediaData == null || (i3 = mediaData.picWidth) <= 0 || (i4 = mediaData.picHeight) <= 0) {
                    i3 = this.f30803c + (this.q * 2);
                    i4 = i3;
                } else {
                    if (i3 * 2 <= i4) {
                        int i10 = this.q;
                        i5 = this.f30803c;
                        i3 = ((int) (i10 * 1.5f)) + i5;
                        i6 = i10 * 2;
                    } else if (i4 * 2 <= i3) {
                        int i11 = this.q;
                        i5 = this.f30803c;
                        i3 = (i11 * 2) + i5;
                        i6 = (int) (i11 * 1.5f);
                    } else {
                        int i12 = this.q;
                        if (i3 < i12) {
                            if (i4 >= i12) {
                                if (i4 >= i12 && i4 < i12 * 2) {
                                    i4 = (i4 * i12) / i3;
                                }
                                i4 = 0;
                                i3 = 0;
                            } else if (i3 < i4) {
                                i4 = (i4 * i12) / i3;
                            } else {
                                i3 = (i3 * i12) / i4;
                                i4 = i12;
                            }
                            i3 = i12;
                        } else {
                            if (i3 < i12 || i3 >= i12 * 2) {
                                MediaData mediaData2 = this.r;
                                int i13 = mediaData2.picHeight;
                                int i14 = this.q;
                                if (i13 >= i14) {
                                    if (i13 >= i14 && i13 < i14 * 2) {
                                        i12 = (i14 * 2) + this.f30803c;
                                        i4 = (i13 * i12) / mediaData2.picWidth;
                                    } else {
                                        MediaData mediaData3 = this.r;
                                        int i15 = mediaData3.picWidth;
                                        int i16 = mediaData3.picHeight;
                                        if (i15 < i16) {
                                            i12 = (this.q * 2) + this.f30803c;
                                            i3 = (i15 * i12) / i16;
                                        } else {
                                            i12 = (this.q * 2) + this.f30803c;
                                            i4 = (i16 * i12) / i15;
                                        }
                                    }
                                    i3 = i12;
                                }
                                i4 = 0;
                                i3 = 0;
                            } else if (i4 < i12) {
                                i3 = (i3 * i12) / i4;
                            } else if (i4 < i12 || i4 >= i12 * 2) {
                                i4 = (this.q * 2) + this.f30803c;
                                MediaData mediaData4 = this.r;
                                i3 = (mediaData4.picWidth * i4) / mediaData4.picHeight;
                            }
                            i4 = i12;
                        }
                    }
                    i4 = i6 + i5;
                }
                int[] handleSinglePicSize = HomeGroupUbsUIHelper.handleSinglePicSize(this.r);
                if (handleSinglePicSize[0] > 0 && handleSinglePicSize[1] > 0) {
                    i3 = handleSinglePicSize[0];
                    i4 = handleSinglePicSize[1];
                }
            } else {
                i4 = i8 / max;
                int i17 = this.l;
                if (i17 > 0) {
                    i3 = i4;
                    i4 = i17;
                } else {
                    i3 = i4;
                }
            }
            setMeasuredDimension(size, i4);
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                if (childAt != null) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                }
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.m = z;
        }
    }

    public void setExtraCenterText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f30807g = str;
        }
    }

    public void setFixedImageHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.l = i;
        }
    }

    public void setForeColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f30805e = z;
        }
    }

    public void setImageClickListener(c.a.o0.e1.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            if (dVar == null) {
                setClickable(false);
            } else {
                this.f30806f = dVar;
            }
        }
    }

    public void setImageMaxChildCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            if (i > 0) {
                this.f30804d = i;
            } else {
                this.f30804d = -1;
            }
        }
    }

    public void setImagePadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.f30803c = i;
        }
    }

    public void setImageViewObjectPool(c.a.d.f.k.b<TbImageView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f30802b = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void setPreloadSizeReadyCallback(c.a.d.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void setSingleImageRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.k = d2;
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.p = z;
        }
    }

    public void setTbImageViewConfiguration(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.t = cVar;
        }
    }

    public void setUrls(List<MediaData> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, list, i) == null) {
            setUrls(list, i, false);
        }
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            setUrls(list, i, z, true);
        }
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f30802b == null || (count = ListUtils.getCount(list)) <= 0) {
            return;
        }
        if (count == 1) {
            this.r = (MediaData) ListUtils.getItem(list, 0);
        }
        j(count);
        int childCount = getChildCount();
        int i2 = this.f30805e ? 13 : 14;
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            MediaData mediaData = list.get(i3);
            if ((childAt instanceof TbImageView) && mediaData != null) {
                TbImageView tbImageView = (TbImageView) childAt;
                boolean z3 = i3 == childCount + (-1);
                k(tbImageView, i + i3, z, z3);
                if (z3 && z && z2) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                String f2 = f(mediaData);
                if (!StringHelper.equals(f2, tbImageView.getUrl())) {
                    tbImageView.F();
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
                tbImageView.setOnDrawListener(this.v);
                c cVar = this.t;
                if (cVar != null) {
                    cVar.a(tbImageView, i3, childCount);
                }
                tbImageView.J(f2, i2, false);
            }
            i3++;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30804d = -1;
        this.f30805e = false;
        this.m = false;
        this.p = false;
        this.q = 0;
        this.s = 3;
        this.u = new a(this);
        this.v = new b(this);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30804d = -1;
        this.f30805e = false;
        this.m = false;
        this.p = false;
        this.q = 0;
        this.s = 3;
        this.u = new a(this);
        this.v = new b(this);
        g();
    }
}
