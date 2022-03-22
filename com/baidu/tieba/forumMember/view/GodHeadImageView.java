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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public static final int j;
    public static int k;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32228b;

    /* renamed from: c  reason: collision with root package name */
    public int f32229c;

    /* renamed from: d  reason: collision with root package name */
    public int f32230d;

    /* renamed from: e  reason: collision with root package name */
    public int f32231e;

    /* renamed from: f  reason: collision with root package name */
    public int f32232f;

    /* renamed from: g  reason: collision with root package name */
    public int f32233g;

    /* renamed from: h  reason: collision with root package name */
    public int f32234h;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.S0 = godHeadImageView;
        }

        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.S0.f32230d == 1) {
                    int size = View.MeasureSpec.getSize(i);
                    int size2 = View.MeasureSpec.getSize(i2);
                    i = View.MeasureSpec.makeMeasureSpec(size - this.S0.f32233g, 1073741824);
                    i2 = View.MeasureSpec.makeMeasureSpec(size2 - this.S0.f32233g, 1073741824);
                }
                super.onMeasure(i, i2);
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
        i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702df);
        j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
        k = 7;
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
        this.f32229c = 0;
        this.f32230d = 0;
        this.f32231e = 1;
        this.f32232f = 1;
        this.f32233g = i;
        this.f32234h = 7;
        c(null);
    }

    public final void c(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0401f9, R.attr.obfuscated_res_0x7f0401fa, R.attr.obfuscated_res_0x7f040550, R.attr.obfuscated_res_0x7f04055b});
                this.f32233g = obtainStyledAttributes.getDimensionPixelSize(0, i);
                this.f32232f = obtainStyledAttributes.getInteger(2, this.f32231e);
                this.f32230d = obtainStyledAttributes.getInteger(3, this.f32229c);
                this.f32234h = obtainStyledAttributes.getInteger(1, k);
                obtainStyledAttributes.recycle();
            }
            this.a = new a(this, getContext());
            this.f32228b = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.a, layoutParams);
            addView(this.f32228b, new FrameLayout.LayoutParams(-1, -1));
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f32230d;
            if (i2 == 0) {
                this.a.setPadding(0, 0, 0, 0);
            } else if (i2 == 1) {
                a aVar = this.a;
                int i3 = j;
                aVar.setPadding(i3, i3, 0, 0);
            }
            int i4 = this.f32232f;
            if (i4 == 1) {
                this.a.setIsRound(true);
                if (this.f32230d == 0) {
                    SkinManager.setImageResource(this.f32228b, R.drawable.pic_shen_avatar_big);
                } else {
                    SkinManager.setImageResource(this.f32228b, R.drawable.pic_shen_avatar);
                }
            } else if (i4 == 2) {
                this.a.setIsRound(false);
                this.a.setRadius(this.f32234h);
                SkinManager.setImageResource(this.f32228b, R.drawable.pic_frs_shen_avatar);
            } else if (i4 != 3) {
                this.a.setIsRound(false);
                this.a.setRadius(this.f32234h);
                SkinManager.setImageResource(this.f32228b, R.drawable.pic_shen_avatar_square);
            } else {
                this.a.setIsRound(true);
                SkinManager.setImageResource(this.f32228b, R.drawable.obfuscated_res_0x7f080331);
            }
        }
    }

    public void e(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.a.J(str, i2, z);
        }
    }

    public void setExtraPadding(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f32233g == i2) {
            return;
        }
        this.f32233g = i2;
        this.a.invalidate();
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f32234h = i2;
            d();
        }
    }

    public void setShapeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f32232f = i2;
            d();
        }
    }

    public void setShowType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f32230d = i2;
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
        this.f32229c = 0;
        this.f32230d = 0;
        this.f32231e = 1;
        this.f32232f = 1;
        this.f32233g = i;
        this.f32234h = 7;
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
        this.f32229c = 0;
        this.f32230d = 0;
        this.f32231e = 1;
        this.f32232f = 1;
        this.f32233g = i;
        this.f32234h = 7;
        c(attributeSet);
    }
}
