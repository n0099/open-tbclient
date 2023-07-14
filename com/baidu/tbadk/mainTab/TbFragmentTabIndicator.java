package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import com.baidu.tieba.wg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public float c;
    public int d;
    public int e;
    public ThemeColorInfo f;

    public void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
        }
    }

    public void b(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return null;
        }
        return (a) invokeL.objValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void setAnimationResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    public void setCheckDescriptionText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void setCompoundDrawablePadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public void setCompoundDrawablesTopResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    public void setContentTvTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    public void setIconResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    public void setIconViewWithText(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
        }
    }

    public void setIconViewWithoutText(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
        }
    }

    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }

    public void setTextColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
        }
    }

    public void setTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f) == null) {
        }
    }

    public void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
        }
    }

    public void setTipPosType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public TbFragmentTabIndicator f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = true;
            this.e = R.color.common_color_10225;
        }

        public final int a(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, textView)) == null) {
                if (textView == null) {
                    return -1;
                }
                String charSequence = ((TextView) this.a).getText().toString();
                if ("   ".equals(charSequence)) {
                    return 100;
                }
                return wg.e(charSequence, -1);
            }
            return invokeL.intValue;
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                int i2 = this.d;
                if (i2 != 0) {
                    SkinManager.setBackgroundResource(this.a, i2);
                }
                View view2 = this.a;
                if (view2 instanceof TextView) {
                    int i3 = this.e;
                    if (i3 != 0) {
                        SkinManager.setViewTextColor(view2, i3, 1);
                    }
                    int a = a((TextView) this.a);
                    if (a > 0 && a < 10) {
                        SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_head_prompt_one);
                    } else if (a >= 10 && a < 100) {
                        SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_head_prompt_two);
                    } else if (a >= 100) {
                        SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_head_prompt_more);
                    }
                }
                View view3 = this.a;
                if (view3 instanceof MessageRedDotView) {
                    ((MessageRedDotView) view3).e();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbFragmentTabIndicator(Context context) {
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
        this.a = false;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
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
        this.a = false;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
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
        this.a = false;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
    }

    public void setContentDefaultTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.e = i;
        }
    }

    public void setContentDefaultTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            this.c = f;
        }
    }

    public void setContentSelectTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
        }
    }

    public void setContentSelectTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            this.b = f;
        }
    }

    public void setIsContentSelectBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.a = z;
        }
    }

    public void setThemeColorInfo(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, themeColorInfo) == null) {
            this.f = themeColorInfo;
        }
    }
}
