package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cg;
import com.baidu.tieba.e35;
import com.baidu.tieba.h35;
import com.baidu.tieba.rm;
import com.baidu.tieba.tm;
import com.baidu.tieba.wu5;
import com.baidu.tieba.xf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ConstrainImageLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public xf<TbImageView> b;
    public int c;
    public int d;
    public boolean e;
    public wu5 f;
    public String g;
    public Paint h;
    public Paint i;
    public Paint j;
    public double k;
    public int l;
    public boolean m;
    public rm n;
    public Bitmap o;
    public boolean p;
    public int q;
    public MediaData r;
    public int s;
    public c t;
    public ViewGroup.OnHierarchyChangeListener u;
    public TbImageView.h v;

    /* loaded from: classes3.dex */
    public interface c {
        void a(TbImageView tbImageView, int i, int i2);
    }

    public void setForeColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) && (view3 instanceof TbImageView)) {
                ((TbImageView) view3).setPlaceHolder(2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) && (view3 instanceof TbImageView) && this.a.b != null) {
                TbImageView tbImageView = (TbImageView) view3;
                tbImageView.H();
                this.a.b.e(tbImageView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConstrainImageLayout a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

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
        public void b(TbImageView tbImageView, Canvas canvas) {
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && tbImageView != null && tbImageView.getImageMatrix() != null) {
                if (this.a.e) {
                    i = 13;
                } else {
                    i = 14;
                }
                tm A = TbImageMemoryCache.v().A(cg.h().g(tbImageView.getUrl(), i));
                int i3 = 0;
                if (A != null) {
                    i3 = A.r();
                    i2 = A.m();
                } else {
                    i2 = 0;
                }
                if (i3 != 0 && i2 != 0) {
                    int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    float f9 = 0.0f;
                    if (tbImageView.B() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                        float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                        if (i3 * height > width * i2) {
                            f6 = height / i2;
                            float f10 = i3;
                            float f11 = smartCropCenterPointWidthRatio * f10 * f6;
                            float f12 = width;
                            float f13 = 0.5f * f12;
                            if (f11 < f13) {
                                f8 = 0.0f;
                            } else {
                                float f14 = f10 * f6;
                                if (f14 - f11 < f13) {
                                    f8 = f12 - f14;
                                } else {
                                    f8 = f13 - f11;
                                }
                            }
                            f9 = f8;
                        } else {
                            float f15 = width / i3;
                            float f16 = i2;
                            float f17 = smartCropCenterPointHeightRatio * f16 * f15;
                            float f18 = height;
                            float f19 = 0.5f * f18;
                            if (f17 < f19) {
                                f6 = f15;
                            } else {
                                float f20 = f16 * f15;
                                if (f20 - f17 < f19) {
                                    f7 = f18 - f20;
                                    f6 = f15;
                                } else {
                                    float f21 = f19 - f17;
                                    f6 = f15;
                                    f7 = f21;
                                }
                                imageMatrix.setScale(f6, f6);
                                imageMatrix.postTranslate(f9, f7);
                            }
                        }
                        f7 = 0.0f;
                        imageMatrix.setScale(f6, f6);
                        imageMatrix.postTranslate(f9, f7);
                    } else if (tbImageView.z() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i3 * height > width * i2) {
                            f4 = height;
                            f5 = i2;
                        } else {
                            f4 = width;
                            f5 = i3;
                        }
                        float f22 = f4 / f5;
                        imageMatrix.setScale(f22, f22);
                        imageMatrix.postTranslate(0.0f, 0.0f);
                    } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i3 * height > width * i2) {
                            f = height / i2;
                            f3 = (width - (i3 * f)) * 0.5f;
                            f2 = 0.0f;
                        } else {
                            f = width / i3;
                            f2 = (height - (i2 * f)) * 0.5f;
                            f3 = 0.0f;
                        }
                        imageMatrix.setScale(f, f);
                        if (this.a.m && i2 > i3) {
                            imageMatrix.postTranslate(f3, 0.0f);
                        } else {
                            imageMatrix.postTranslate(f3, f2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ ConstrainImageLayout d;

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
            this.d = constrainImageLayout;
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a = i;
                this.b = z;
                this.c = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || this.d.f == null) {
                return;
            }
            wu5 wu5Var = this.d.f;
            int i = this.a;
            if (this.b && this.c) {
                z = true;
            } else {
                z = false;
            }
            wu5Var.a(view2, i, z);
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
        this.d = -1;
        this.e = false;
        this.m = false;
        this.p = false;
        this.q = 0;
        this.s = 3;
        this.u = new a(this);
        this.v = new b(this);
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            k();
            if (!StringUtils.isNull(this.g) && (childCount = getChildCount()) > 0 && getChildAt(childCount - 1) != null && this.g != null) {
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
                RectF e = e(tbImageView);
                if (e == null) {
                    return;
                }
                d(canvas, e, e35.B(R.string.J_X11));
            }
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int childCount = getChildCount() - i;
            if (childCount > 0) {
                removeViews(i, childCount);
            } else if (childCount < 0) {
                int abs = Math.abs(childCount);
                for (int i2 = 0; i2 < abs; i2++) {
                    TbImageView b2 = this.b.b();
                    b2.setContentDescription(getResources().getString(R.string.editor_image));
                    b2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    b2.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                    b2.setPageId(this.a);
                    addView(b2);
                }
            }
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
        this.d = -1;
        this.e = false;
        this.m = false;
        this.p = false;
        this.q = 0;
        this.s = 3;
        this.u = new a(this);
        this.v = new b(this);
        f();
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
        this.d = -1;
        this.e = false;
        this.m = false;
        this.p = false;
        this.q = 0;
        this.s = 3;
        this.u = new a(this);
        this.v = new b(this);
        f();
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

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    public void setExtraCenterText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.g = str;
        }
    }

    public void setFixedImageHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.l = i;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.e = z;
        }
    }

    public void setImageClickListener(wu5 wu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, wu5Var) == null) {
            if (wu5Var == null) {
                setClickable(false);
            } else {
                this.f = wu5Var;
            }
        }
    }

    public void setImageMaxChildCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i > 0) {
                this.d = i;
            } else {
                this.d = -1;
            }
        }
    }

    public void setImagePadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.c = i;
        }
    }

    public void setImageViewObjectPool(xf<TbImageView> xfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, xfVar) == null) {
            this.b = xfVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void setPreloadSizeReadyCallback(rm rmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rmVar) == null) {
            this.n = rmVar;
        }
    }

    public void setSingleImageRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.k = d2;
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.p = z;
        }
    }

    public void setTbImageViewConfiguration(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.t = cVar;
        }
    }

    public final void c() {
        int childCount;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (childCount = getChildCount()) <= 0) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) instanceof TbImageView) {
                ((TbImageView) getChildAt(i)).setPlaceHolder(2);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tbImageView.H();
                }
            }
        }
    }

    public final void d(Canvas canvas, RectF rectF, float[] fArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF, fArr) != null) || rectF == null) {
            return;
        }
        Bitmap bitmap = this.o;
        if (bitmap == null || bitmap.isRecycled()) {
            int i = (int) (rectF.right - rectF.left);
            int i2 = (int) (rectF.bottom - rectF.top);
            this.o = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.o);
            canvas2.drawARGB(0, 0, 0, 0);
            float f = i2;
            RectF rectF2 = new RectF(-fArr[0], 0.0f, i, f);
            this.i.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f, SkinManager.getColor(R.color.CAM_X0601), SkinManager.getColor(R.color.CAM_X0606), Shader.TileMode.CLAMP));
            canvas2.drawPath(h35.a(rectF2, fArr), this.i);
        }
        canvas.drawBitmap(this.o, rectF.left, rectF.top, this.h);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        int i3 = ((int) rectF.bottom) - dimenPixelSize;
        int measureText = (((int) rectF.right) - dimenPixelSize2) - ((int) this.j.measureText(this.g));
        float[] E = e35.E(R.array.S_O_X001);
        this.j.setShadowLayer(E[1], E[2], E[3], (int) E[0]);
        canvas.drawText(this.g, measureText, i3, this.j);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setOnHierarchyChangeListener(this.u);
            Paint paint = new Paint();
            this.j = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.j.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.T_X09));
            this.j.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
            Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            float f = fontMetrics.ascent;
            float f2 = fontMetrics.top;
            Paint paint2 = new Paint();
            this.h = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.i = paint3;
            paint3.setAntiAlias(true);
            this.i.setColor(-16777216);
            setLayerType(1, null);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.s != TbadkCoreApplication.getInst().getSkinType()) {
            this.s = TbadkCoreApplication.getInst().getSkinType();
            c();
            this.j.setColor(SkinManager.getColor(R.color.CAM_X0101));
            invalidate();
        }
    }

    public final void j(TbImageView tbImageView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{tbImageView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.f != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof d) {
                    ((d) onClickListener).a(i, z, z2);
                } else {
                    tbImageView.setOnClickListener(new d(this, i, z, z2));
                }
            } else if (this.f == null && tbImageView != null) {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.n == null || getChildCount() <= 0) {
            return;
        }
        View childAt = getChildAt(0);
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        if (width > 0 && height > 0) {
            if (getChildCount() == 1) {
                this.n.a(1, childAt.getWidth(), childAt.getHeight());
            } else {
                this.n.a(2, childAt.getWidth(), childAt.getHeight());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int i6 = (this.c + measuredWidth) * i5;
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
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            if (childCount <= 0) {
                return;
            }
            int max = Math.max(childCount, this.d);
            int size = View.MeasureSpec.getSize(i);
            int i7 = this.c;
            int i8 = size - ((max - 1) * i7);
            if (this.p) {
                if (childCount == 1) {
                    if (this.q == 0) {
                        this.q = (int) ((size - (i7 * 2)) / 3.0f);
                    }
                    MediaData mediaData = this.r;
                    if (mediaData != null && (i3 = mediaData.picWidth) > 0 && (i4 = mediaData.picHeight) > 0) {
                        if (i3 * 2 <= i4) {
                            int i9 = this.q;
                            i5 = this.c;
                            i3 = ((int) (i9 * 1.5f)) + i5;
                            i6 = i9 * 2;
                        } else if (i4 * 2 <= i3) {
                            int i10 = this.q;
                            i5 = this.c;
                            i3 = (i10 * 2) + i5;
                            i6 = (int) (i10 * 1.5f);
                        } else {
                            int i11 = this.q;
                            if (i3 < i11) {
                                if (i4 < i11) {
                                    if (i3 < i4) {
                                        i4 = (i4 * i11) / i3;
                                    } else {
                                        i3 = (i3 * i11) / i4;
                                        i4 = i11;
                                    }
                                } else {
                                    if (i4 >= i11 && i4 < i11 * 2) {
                                        i4 = (i4 * i11) / i3;
                                    }
                                    i4 = 0;
                                    i3 = 0;
                                }
                                i3 = i11;
                            } else {
                                if (i3 >= i11 && i3 < i11 * 2) {
                                    if (i4 < i11) {
                                        i3 = (i3 * i11) / i4;
                                    } else if (i4 < i11 || i4 >= i11 * 2) {
                                        i4 = (this.q * 2) + this.c;
                                        MediaData mediaData2 = this.r;
                                        i3 = (mediaData2.picWidth * i4) / mediaData2.picHeight;
                                    }
                                } else {
                                    MediaData mediaData3 = this.r;
                                    int i12 = mediaData3.picHeight;
                                    int i13 = this.q;
                                    if (i12 >= i13) {
                                        if (i12 >= i13 && i12 < i13 * 2) {
                                            i11 = (i13 * 2) + this.c;
                                            i4 = (i12 * i11) / mediaData3.picWidth;
                                        } else {
                                            MediaData mediaData4 = this.r;
                                            int i14 = mediaData4.picWidth;
                                            int i15 = mediaData4.picHeight;
                                            if (i14 < i15) {
                                                i11 = (this.q * 2) + this.c;
                                                i3 = (i14 * i11) / i15;
                                            } else {
                                                i11 = (this.q * 2) + this.c;
                                                i4 = (i15 * i11) / i14;
                                            }
                                        }
                                        i3 = i11;
                                    }
                                    i4 = 0;
                                    i3 = 0;
                                }
                                i4 = i11;
                            }
                        }
                        i4 = i6 + i5;
                    } else {
                        i3 = this.c + (this.q * 2);
                        i4 = i3;
                    }
                    int[] handleSinglePicSize = HomeGroupUbsUIHelper.handleSinglePicSize(this.r);
                    if (handleSinglePicSize[0] > 0 && handleSinglePicSize[1] > 0) {
                        i3 = handleSinglePicSize[0];
                        i4 = handleSinglePicSize[1];
                    }
                } else {
                    i4 = i8 / max;
                    int i16 = this.l;
                    if (i16 > 0) {
                        i3 = i4;
                        i4 = i16;
                    } else {
                        i3 = i4;
                    }
                }
            } else {
                i3 = i8 / max;
                double d2 = this.k;
                if (d2 > 0.0d) {
                    i4 = (int) ((i3 * d2) + 0.5d);
                } else {
                    i4 = i3;
                }
                int i17 = this.l;
                if (i17 > 0) {
                    i4 = i17;
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

    public void setUrls(List<MediaData> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, list, i) == null) {
            setUrls(list, i, false);
        }
    }

    public void setUrls(List<MediaData> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            setUrls(list, i, z, true);
        }
    }

    public void setUrls(List<MediaData> list, int i, boolean z, boolean z2) {
        int count;
        int i2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048604, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.b == null || (count = ListUtils.getCount(list)) <= 0) {
            return;
        }
        if (count == 1) {
            this.r = (MediaData) ListUtils.getItem(list, 0);
        }
        i(count);
        int childCount = getChildCount();
        if (this.e) {
            i2 = 13;
        } else {
            i2 = 14;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            MediaData mediaData = list.get(i3);
            if ((childAt instanceof TbImageView) && mediaData != null) {
                TbImageView tbImageView = (TbImageView) childAt;
                if (i3 == childCount - 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                j(tbImageView, i + i3, z, z3);
                if (z3 && z && z2) {
                    tbImageView.setLongIconSupport(false);
                    tbImageView.setGifIconSupport(false);
                } else {
                    tbImageView.setLongIconSupport(true);
                    tbImageView.setGifIconSupport(true);
                }
                String thumbnailsUrl = ThreadCardUtils.getThumbnailsUrl(mediaData);
                if (!StringHelper.equals(thumbnailsUrl, tbImageView.getUrl())) {
                    tbImageView.H();
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
                tbImageView.N(thumbnailsUrl, i2, false);
            }
        }
    }
}
