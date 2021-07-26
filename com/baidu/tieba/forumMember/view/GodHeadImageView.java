package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GodHeadImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public static final int n;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f15323e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15324f;

    /* renamed from: g  reason: collision with root package name */
    public int f15325g;

    /* renamed from: h  reason: collision with root package name */
    public int f15326h;

    /* renamed from: i  reason: collision with root package name */
    public int f15327i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes4.dex */
    public class a extends HeadImageView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodHeadImageView S0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GodHeadImageView godHeadImageView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godHeadImageView, context};
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
            this.S0 = godHeadImageView;
        }

        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.S0.f15326h == 1) {
                    int size = View.MeasureSpec.getSize(i2);
                    int size2 = View.MeasureSpec.getSize(i3);
                    i2 = View.MeasureSpec.makeMeasureSpec(size - this.S0.k, 1073741824);
                    i3 = View.MeasureSpec.makeMeasureSpec(size2 - this.S0.k, 1073741824);
                }
                super.onMeasure(i2, i3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-660147729, "Lcom/baidu/tieba/forumMember/view/GodHeadImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-660147729, "Lcom/baidu/tieba/forumMember/view/GodHeadImageView;");
                return;
            }
        }
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        o = 7;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodHeadImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f15325g = 0;
        this.f15326h = 0;
        this.f15327i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(null);
    }

    public final void c(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.GodHeadImageView);
                this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.GodHeadImageView_extra_padding, m);
                this.j = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_shape_type, this.f15327i);
                this.f15326h = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_show_type, this.f15325g);
                this.l = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_extra_radius, o);
                obtainStyledAttributes.recycle();
            }
            this.f15323e = new a(this, getContext());
            this.f15324f = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f15323e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f15323e, layoutParams);
            addView(this.f15324f, new FrameLayout.LayoutParams(-1, -1));
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f15326h;
            if (i2 == 0) {
                this.f15323e.setPadding(0, 0, 0, 0);
            } else if (i2 == 1) {
                a aVar = this.f15323e;
                int i3 = n;
                aVar.setPadding(i3, i3, 0, 0);
            }
            int i4 = this.j;
            if (i4 == 1) {
                this.f15323e.setIsRound(true);
                if (this.f15326h == 0) {
                    SkinManager.setImageResource(this.f15324f, R.drawable.pic_shen_avatar_big);
                } else {
                    SkinManager.setImageResource(this.f15324f, R.drawable.pic_shen_avatar);
                }
            } else if (i4 == 2) {
                this.f15323e.setIsRound(false);
                this.f15323e.setRadius(this.l);
                SkinManager.setImageResource(this.f15324f, R.drawable.pic_frs_shen_avatar);
            } else if (i4 != 3) {
                this.f15323e.setIsRound(false);
                this.f15323e.setRadius(this.l);
                SkinManager.setImageResource(this.f15324f, R.drawable.pic_shen_avatar_square);
            } else {
                this.f15323e.setIsRound(true);
                SkinManager.setImageResource(this.f15324f, R.drawable.browser_null_drawable);
            }
        }
    }

    public void e(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f15323e.M(str, i2, z);
        }
    }

    public void setExtraPadding(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
            return;
        }
        this.k = i2;
        this.f15323e.invalidate();
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.l = i2;
            d();
        }
    }

    public void setShapeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.j = i2;
            d();
        }
    }

    public void setShowType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f15326h = i2;
            d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f15325g = 0;
        this.f15326h = 0;
        this.f15327i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodHeadImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f15325g = 0;
        this.f15326h = 0;
        this.f15327i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(attributeSet);
    }
}
