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
/* loaded from: classes7.dex */
public class GodHeadImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_SHAPE_FRS_PB_SQUARE = 2;
    public static final int TYPE_SHAPE_NULL = 3;
    public static final int TYPE_SHAPE_ROUND = 1;
    public static final int TYPE_SHAPE_SQUARE = 0;
    public static final int TYPE_SHOW_NORMAL = 0;
    public static final int TYPE_SHOW_SPECIAL = 1;
    public static final int m;
    public static final int n;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f50878e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f50879f;

    /* renamed from: g  reason: collision with root package name */
    public int f50880g;

    /* renamed from: h  reason: collision with root package name */
    public int f50881h;

    /* renamed from: i  reason: collision with root package name */
    public int f50882i;

    /* renamed from: j  reason: collision with root package name */
    public int f50883j;
    public int k;
    public int l;

    /* loaded from: classes7.dex */
    public class a extends HeadImageView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodHeadImageView s0;

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
            this.s0 = godHeadImageView;
        }

        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.s0.f50881h == 1) {
                    int size = View.MeasureSpec.getSize(i2);
                    int size2 = View.MeasureSpec.getSize(i3);
                    i2 = View.MeasureSpec.makeMeasureSpec(size - this.s0.k, 1073741824);
                    i3 = View.MeasureSpec.makeMeasureSpec(size2 - this.s0.k, 1073741824);
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
        this.f50880g = 0;
        this.f50881h = 0;
        this.f50882i = 1;
        this.f50883j = 1;
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
                this.f50883j = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_shape_type, this.f50882i);
                this.f50881h = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_show_type, this.f50880g);
                this.l = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_extra_radius, o);
                obtainStyledAttributes.recycle();
            }
            this.f50878e = new a(this, getContext());
            this.f50879f = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f50878e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f50878e, layoutParams);
            addView(this.f50879f, new FrameLayout.LayoutParams(-1, -1));
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f50881h;
            if (i2 == 0) {
                this.f50878e.setPadding(0, 0, 0, 0);
            } else if (i2 == 1) {
                a aVar = this.f50878e;
                int i3 = n;
                aVar.setPadding(i3, i3, 0, 0);
            }
            int i4 = this.f50883j;
            if (i4 == 1) {
                this.f50878e.setIsRound(true);
                if (this.f50881h == 0) {
                    SkinManager.setImageResource(this.f50879f, R.drawable.pic_shen_avatar_big);
                } else {
                    SkinManager.setImageResource(this.f50879f, R.drawable.pic_shen_avatar);
                }
            } else if (i4 == 2) {
                this.f50878e.setIsRound(false);
                this.f50878e.setRadius(this.l);
                SkinManager.setImageResource(this.f50879f, R.drawable.pic_frs_shen_avatar);
            } else if (i4 != 3) {
                this.f50878e.setIsRound(false);
                this.f50878e.setRadius(this.l);
                SkinManager.setImageResource(this.f50879f, R.drawable.pic_shen_avatar_square);
            } else {
                this.f50878e.setIsRound(true);
                SkinManager.setImageResource(this.f50879f, R.drawable.browser_null_drawable);
            }
        }
    }

    public void onSkinTypeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
        }
    }

    public void setExtraPadding(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.k == i2) {
            return;
        }
        this.k = i2;
        this.f50878e.invalidate();
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
            this.f50883j = i2;
            d();
        }
    }

    public void setShowType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f50881h = i2;
            d();
        }
    }

    public void startLoad(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f50878e.startLoad(str, i2, z);
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
        this.f50880g = 0;
        this.f50881h = 0;
        this.f50882i = 1;
        this.f50883j = 1;
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
        this.f50880g = 0;
        this.f50881h = 0;
        this.f50882i = 1;
        this.f50883j = 1;
        this.k = m;
        this.l = 7;
        c(attributeSet);
    }
}
