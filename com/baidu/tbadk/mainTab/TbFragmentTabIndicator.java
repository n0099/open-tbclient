package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mContentDefaultTextColor;
    public float mContentDefaultTextSize;
    public int mContentSelectTextColor;
    public float mContentSelectTextSize;
    public boolean mIsContentSelectBold;
    public ThemeColorInfo mThemeColorInfo;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f48283a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f48284b;

        /* renamed from: c  reason: collision with root package name */
        public int f48285c;

        /* renamed from: d  reason: collision with root package name */
        public int f48286d;

        /* renamed from: e  reason: collision with root package name */
        public int f48287e;

        /* renamed from: f  reason: collision with root package name */
        public TbFragmentTabIndicator f48288f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48284b = true;
            this.f48287e = R.color.common_color_10225;
        }

        public final int a(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, textView)) == null) {
                if (textView == null) {
                    return -1;
                }
                String charSequence = ((TextView) this.f48283a).getText().toString();
                if ("   ".equals(charSequence)) {
                    return 100;
                }
                return b.d(charSequence, -1);
            }
            return invokeL.intValue;
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int i3 = this.f48286d;
                if (i3 != 0) {
                    SkinManager.setBackgroundResource(this.f48283a, i3);
                }
                View view = this.f48283a;
                if (view instanceof TextView) {
                    int i4 = this.f48287e;
                    if (i4 != 0) {
                        SkinManager.setViewTextColor(view, i4, 1);
                    }
                    int a2 = a((TextView) this.f48283a);
                    if (a2 > 0 && a2 < 10) {
                        SkinManager.setBackgroundResource(this.f48283a, R.drawable.icon_news_head_prompt_one);
                    } else if (a2 >= 10 && a2 < 100) {
                        SkinManager.setBackgroundResource(this.f48283a, R.drawable.icon_news_head_prompt_two);
                    } else if (a2 >= 100) {
                        SkinManager.setBackgroundResource(this.f48283a, R.drawable.icon_news_head_prompt_more);
                    }
                }
                View view2 = this.f48283a;
                if (view2 instanceof MessageRedDotView) {
                    ((MessageRedDotView) view2).onChangeSkinType();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsContentSelectBold = false;
        this.mContentSelectTextSize = 0.0f;
        this.mContentDefaultTextSize = 0.0f;
        this.mContentSelectTextColor = 0;
        this.mContentDefaultTextColor = 0;
    }

    public void addTip(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
        }
    }

    public void addTipWrapContent(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
        }
    }

    public void checkAndStartAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public a getTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return null;
        }
        return (a) invokeL.objValue;
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    public void onTabSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void refreshIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
        }
    }

    public a removeTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return null;
        }
        return (a) invokeL.objValue;
    }

    public void setAnimationResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public void setCheckDescriptionText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public void setCompoundDrawablePadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    public void setCompoundDrawablesTopResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    public void setContentDefaultTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mContentDefaultTextColor = i2;
        }
    }

    public void setContentDefaultTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.mContentDefaultTextSize = f2;
        }
    }

    public void setContentSelectTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mContentSelectTextColor = i2;
        }
    }

    public void setContentSelectTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.mContentSelectTextSize = f2;
        }
    }

    public void setContentTvTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    public void setIconResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
        }
    }

    public void setIconViewWithText(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
        }
    }

    public void setIconViewWithoutText(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
        }
    }

    public void setIsContentSelectBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mIsContentSelectBold = z;
        }
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
        }
    }

    public void setTextColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
        }
    }

    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
        }
    }

    public void setThemeColorInfo(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, themeColorInfo) == null) {
            this.mThemeColorInfo = themeColorInfo;
        }
    }

    public void setTipPosType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
        }
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
        this.mIsContentSelectBold = false;
        this.mContentSelectTextSize = 0.0f;
        this.mContentDefaultTextSize = 0.0f;
        this.mContentSelectTextColor = 0;
        this.mContentDefaultTextColor = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i2) {
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
        this.mIsContentSelectBold = false;
        this.mContentSelectTextSize = 0.0f;
        this.mContentDefaultTextSize = 0.0f;
        this.mContentSelectTextColor = 0;
        this.mContentDefaultTextColor = 0;
    }
}
