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
import com.baidu.tieba.ey5;
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
    public static final int i;
    public static final int j;
    public static int k;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public ImageView b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    /* loaded from: classes4.dex */
    public class a extends HeadImageView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodHeadImageView T0;

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
            this.T0 = godHeadImageView;
        }

        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.T0.d == 1) {
                    int size = View.MeasureSpec.getSize(i);
                    int size2 = View.MeasureSpec.getSize(i2);
                    i = View.MeasureSpec.makeMeasureSpec(size - this.T0.g, 1073741824);
                    i2 = View.MeasureSpec.makeMeasureSpec(size2 - this.T0.g, 1073741824);
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
        i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e7);
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
        this.c = 0;
        this.d = 0;
        this.e = 1;
        this.f = 1;
        this.g = i;
        this.h = 7;
        c(null);
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
        this.c = 0;
        this.d = 0;
        this.e = 1;
        this.f = 1;
        this.g = i;
        this.h = 7;
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
        this.c = 0;
        this.d = 0;
        this.e = 1;
        this.f = 1;
        this.g = i;
        this.h = 7;
        c(attributeSet);
    }

    public void setExtraPadding(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.g != i2) {
            this.g = i2;
            this.a.invalidate();
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.h = i2;
            d();
        }
    }

    public void setShapeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f = i2;
            d();
        }
    }

    public void setShowType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.d = i2;
            d();
        }
    }

    public final void c(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ey5.GodHeadImageView);
                this.g = obtainStyledAttributes.getDimensionPixelSize(0, i);
                this.f = obtainStyledAttributes.getInteger(2, this.e);
                this.d = obtainStyledAttributes.getInteger(3, this.c);
                this.h = obtainStyledAttributes.getInteger(1, k);
                obtainStyledAttributes.recycle();
            }
            this.a = new a(this, getContext());
            this.b = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.a, layoutParams);
            addView(this.b, new FrameLayout.LayoutParams(-1, -1));
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.d;
            if (i2 != 0) {
                if (i2 == 1) {
                    a aVar = this.a;
                    int i3 = j;
                    aVar.setPadding(i3, i3, 0, 0);
                }
            } else {
                this.a.setPadding(0, 0, 0, 0);
            }
            int i4 = this.f;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        this.a.setIsRound(false);
                        this.a.setRadius(this.h);
                        SkinManager.setImageResource(this.b, R.drawable.pic_shen_avatar_square);
                        return;
                    }
                    this.a.setIsRound(true);
                    SkinManager.setImageResource(this.b, R.drawable.browser_null_drawable);
                    return;
                }
                this.a.setIsRound(false);
                this.a.setRadius(this.h);
                SkinManager.setImageResource(this.b, R.drawable.pic_frs_shen_avatar);
                return;
            }
            this.a.setIsRound(true);
            if (this.d == 0) {
                SkinManager.setImageResource(this.b, R.drawable.pic_shen_avatar_big);
            } else {
                SkinManager.setImageResource(this.b, R.drawable.pic_shen_avatar);
            }
        }
    }

    public void e(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.a.N(str, i2, z);
        }
    }
}
