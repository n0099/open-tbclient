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
/* loaded from: classes9.dex */
public class ConstrainImageLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALIDATE_MAX_CHILD_COUNT = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canCenterStart;

    /* renamed from: e  reason: collision with root package name */
    public int f42146e;

    /* renamed from: f  reason: collision with root package name */
    public int f42147f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42148g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.f1.j.d f42149h;

    /* renamed from: i  reason: collision with root package name */
    public String f42150i;
    public c.a.d.f.k.b<TbImageView> imageObjectPool;

    /* renamed from: j  reason: collision with root package name */
    public Paint f42151j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f42152k;
    public Paint l;
    public double m;
    public BdUniqueId mPageUniqueId;
    public int n;
    public c.a.d.m.c.b o;
    public Bitmap p;
    public boolean q;
    public int r;
    public MediaData s;
    public int t;
    public c u;
    public ViewGroup.OnHierarchyChangeListener v;
    public TbImageView.h w;

    /* loaded from: classes9.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConstrainImageLayout f42153e;

        public a(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42153e = constrainImageLayout;
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
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof TbImageView) && this.f42153e.imageObjectPool != null) {
                TbImageView tbImageView = (TbImageView) view2;
                tbImageView.reset();
                this.f42153e.imageObjectPool.e(tbImageView);
            }
        }
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2;
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
            c.a.d.m.d.a m = c.a.q0.c0.c.k().m(c.a.d.f.l.d.h().g(tbImageView.getUrl(), this.a.f42148g ? 13 : 14));
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
            if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
            } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
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
                if (this.a.canCenterStart && i2 > i3) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(TbImageView tbImageView, int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f42154e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f42155f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f42156g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ConstrainImageLayout f42157h;

        public d(ConstrainImageLayout constrainImageLayout, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainImageLayout, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42157h = constrainImageLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f42154e = i2;
                this.f42155f = z;
                this.f42156g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f42157h.f42149h == null) {
                return;
            }
            this.f42157h.f42149h.a(view, this.f42154e, this.f42155f && this.f42156g);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42147f = -1;
        this.f42148g = false;
        this.canCenterStart = false;
        this.q = false;
        this.r = 0;
        this.t = 3;
        this.v = new a(this);
        this.w = new b(this);
        g();
    }

    public final void c() {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (childCount = getChildCount()) <= 0) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF, fArr) == null) || rectF == null) {
            return;
        }
        Bitmap bitmap = this.p;
        if (bitmap == null || bitmap.isRecycled()) {
            int i4 = (int) (rectF.right - rectF.left);
            int i5 = (int) (rectF.bottom - rectF.top);
            this.p = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.p);
            canvas2.drawARGB(0, 0, 0, 0);
            float f2 = i5;
            RectF rectF2 = new RectF(-fArr[0], 0.0f, i4, f2);
            if (c.a.q0.b.d.u0()) {
                i2 = SkinManager.getColor(R.color.CAM_X0601);
                i3 = SkinManager.getColor(R.color.CAM_X0606);
            } else {
                i2 = 0;
                i3 = Integer.MIN_VALUE;
            }
            this.f42152k.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f2, i2, i3, Shader.TileMode.CLAMP));
            canvas2.drawPath(c.a.q0.s.u.d.a.a(rectF2, fArr), this.f42152k);
        }
        canvas.drawBitmap(this.p, rectF.left, rectF.top, this.f42151j);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        int i6 = ((int) rectF.bottom) - dimenPixelSize;
        int measureText = (((int) rectF.right) - dimenPixelSize2) - ((int) this.l.measureText(this.f42150i));
        float[] B = c.a.q0.s.u.a.B(R.array.S_O_X001);
        this.l.setShadowLayer(B[1], B[2], B[3], (int) B[0]);
        canvas.drawText(this.f42150i, measureText, i6, this.l);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            j();
            if (StringUtils.isNull(this.f42150i) || (childCount = getChildCount()) <= 0 || getChildAt(childCount - 1) == null || this.f42150i == null) {
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
            d(canvas, e2, c.a.q0.s.u.a.y(R.string.J_X11));
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
            setOnHierarchyChangeListener(this.v);
            Paint paint = new Paint();
            this.l = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.l.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
            this.l.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
            Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            float f2 = fontMetrics.ascent;
            float f3 = fontMetrics.top;
            Paint paint2 = new Paint();
            this.f42151j = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f42152k = paint3;
            paint3.setAntiAlias(true);
            this.f42152k.setColor(-16777216);
            setLayerType(1, null);
        }
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int childCount = getChildCount() - i2;
            if (childCount > 0) {
                removeViews(i2, childCount);
            } else if (childCount < 0) {
                int abs = Math.abs(childCount);
                for (int i3 = 0; i3 < abs; i3++) {
                    TbImageView b2 = this.imageObjectPool.b();
                    b2.setContentDescription(getResources().getString(R.string.editor_image));
                    b2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    b2.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                    b2.setPageId(this.mPageUniqueId);
                    addView(b2);
                }
            }
        }
    }

    public final void i(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.f42149h != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i2, z, z2));
                }
            } else if (this.f42149h != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.o == null || getChildCount() <= 0) {
            return;
        }
        View childAt = getChildAt(0);
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (getChildCount() == 1) {
            this.o.a(1, childAt.getWidth(), childAt.getHeight());
        } else {
            this.o.a(2, childAt.getWidth(), childAt.getHeight());
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.t == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.t = TbadkCoreApplication.getInst().getSkinType();
        c();
        this.l.setColor(SkinManager.getColor(R.color.CAM_X0101));
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int i7 = (this.f42146e + measuredWidth) * i6;
                    childAt.layout(i7, 0, measuredWidth + i7, i5 - i3);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            if (childCount <= 0) {
                return;
            }
            int max = Math.max(childCount, this.f42147f);
            int size = View.MeasureSpec.getSize(i2);
            int i8 = this.f42146e;
            int i9 = size - ((max - 1) * i8);
            if (!this.q) {
                i4 = i9 / max;
                double d2 = this.m;
                i5 = d2 > 0.0d ? (int) ((i4 * d2) + 0.5d) : i4;
                int i10 = this.n;
                if (i10 > 0) {
                    i5 = i10;
                }
            } else if (childCount == 1) {
                if (this.r == 0) {
                    this.r = (int) ((size - (i8 * 2)) / 3.0f);
                }
                MediaData mediaData = this.s;
                if (mediaData == null || (i4 = mediaData.picWidth) <= 0 || (i5 = mediaData.picHeight) <= 0) {
                    i4 = this.f42146e + (this.r * 2);
                    i5 = i4;
                } else {
                    if (i4 * 2 <= i5) {
                        int i11 = this.r;
                        i6 = this.f42146e;
                        i4 = ((int) (i11 * 1.5f)) + i6;
                        i7 = i11 * 2;
                    } else if (i5 * 2 <= i4) {
                        int i12 = this.r;
                        i6 = this.f42146e;
                        i4 = (i12 * 2) + i6;
                        i7 = (int) (i12 * 1.5f);
                    } else {
                        int i13 = this.r;
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
                                MediaData mediaData2 = this.s;
                                int i14 = mediaData2.picHeight;
                                int i15 = this.r;
                                if (i14 >= i15) {
                                    if (i14 >= i15 && i14 < i15 * 2) {
                                        i13 = (i15 * 2) + this.f42146e;
                                        i5 = (i14 * i13) / mediaData2.picWidth;
                                    } else {
                                        MediaData mediaData3 = this.s;
                                        int i16 = mediaData3.picWidth;
                                        int i17 = mediaData3.picHeight;
                                        if (i16 < i17) {
                                            i13 = (this.r * 2) + this.f42146e;
                                            i4 = (i16 * i13) / i17;
                                        } else {
                                            i13 = (this.r * 2) + this.f42146e;
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
                                i5 = (this.r * 2) + this.f42146e;
                                MediaData mediaData4 = this.s;
                                i4 = (mediaData4.picWidth * i5) / mediaData4.picHeight;
                            }
                            i5 = i13;
                        }
                    }
                    i5 = i7 + i6;
                }
                int[] l = c.a.q0.b.g.b.l(this.s);
                if (l[0] > 0 && l[1] > 0) {
                    i4 = l[0];
                    i5 = l[1];
                }
            } else {
                i5 = i9 / max;
                int i18 = this.n;
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
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tbImageView.reset();
                }
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.canCenterStart = z;
        }
    }

    public void setExtraCenterText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f42150i = str;
        }
    }

    public void setFixedImageHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setForeColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f42148g = z;
        }
    }

    public void setImageClickListener(c.a.q0.f1.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            if (dVar == null) {
                setClickable(false);
            } else {
                this.f42149h = dVar;
            }
        }
    }

    public void setImageMaxChildCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (i2 > 0) {
                this.f42147f = i2;
            } else {
                this.f42147f = -1;
            }
        }
    }

    public void setImagePadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f42146e = i2;
        }
    }

    public void setImageViewObjectPool(c.a.d.f.k.b<TbImageView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.imageObjectPool = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            this.mPageUniqueId = bdUniqueId;
        }
    }

    public void setPreloadSizeReadyCallback(c.a.d.m.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            this.o = bVar;
        }
    }

    public void setSingleImageRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.m = d2;
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.q = z;
        }
    }

    public void setTbImageViewConfiguration(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.u = cVar;
        }
    }

    public void setUrls(List<MediaData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, list, i2) == null) {
            setUrls(list, i2, false);
        }
    }

    public void setUrls(List<MediaData> list, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{list, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            setUrls(list, i2, z, true);
        }
    }

    public void setUrls(List<MediaData> list, int i2, boolean z, boolean z2) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{list, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.imageObjectPool == null || (count = ListUtils.getCount(list)) <= 0) {
            return;
        }
        if (count == 1) {
            this.s = (MediaData) ListUtils.getItem(list, 0);
        }
        h(count);
        int childCount = getChildCount();
        int i3 = this.f42148g ? 13 : 14;
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            MediaData mediaData = list.get(i4);
            if ((childAt instanceof TbImageView) && mediaData != null) {
                TbImageView tbImageView = (TbImageView) childAt;
                boolean z3 = i4 == childCount + (-1);
                i(tbImageView, i2 + i4, z, z3);
                if (z3 && z && z2) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                String f2 = f(mediaData);
                if (!StringHelper.equals(f2, tbImageView.getUrl())) {
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
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setOnDrawListener(this.w);
                c cVar = this.u;
                if (cVar != null) {
                    cVar.a(tbImageView, i4, childCount);
                }
                tbImageView.startLoad(f2, i3, false);
            }
            i4++;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42147f = -1;
        this.f42148g = false;
        this.canCenterStart = false;
        this.q = false;
        this.r = 0;
        this.t = 3;
        this.v = new a(this);
        this.w = new b(this);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42147f = -1;
        this.f42148g = false;
        this.canCenterStart = false;
        this.q = false;
        this.r = 0;
        this.t = 3;
        this.v = new a(this);
        this.w = new b(this);
        g();
    }
}
