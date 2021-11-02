package com.baidu.tieba.card.divider;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CardGroupDividerView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f47461i;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f47462e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47463f;

    /* renamed from: g  reason: collision with root package name */
    public View f47464g;

    /* renamed from: h  reason: collision with root package name */
    public int f47465h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(984270469, "Lcom/baidu/tieba/card/divider/CardGroupDividerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(984270469, "Lcom/baidu/tieba/card/divider/CardGroupDividerView;");
                return;
            }
        }
        int i2 = R.color.CAM_X0204;
        f47461i = i2;
        j = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardGroupDividerView(Context context) {
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
        this.f47465h = j;
        a();
    }

    private void setDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            this.f47465h = i2;
            SkinManager.setBackgroundColor(this.f47464g, i2);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.card_divider_view, (ViewGroup) this, true);
            this.f47462e = findViewById(R.id.card_divider_top_margin);
            this.f47463f = (TextView) findViewById(R.id.card_divider_tv);
            this.f47464g = findViewById(R.id.bottom_line);
            onChangeSkinType();
        }
    }

    public View getBotttomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47464g : (View) invokeV.objValue;
    }

    public void hideTopMargin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f47462e.getVisibility() == 8) {
            return;
        }
        this.f47462e.setVisibility(8);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f47462e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f47463f, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f47464g, this.f47465h);
        }
    }

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.f47463f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void setTitleText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f47463f.setText(str);
        }
    }

    public void setTitleTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.f47463f.setTextSize(i2, f2);
        }
    }

    public void showCardHeaderView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            if (z) {
                showTopMargin();
            } else {
                hideTopMargin();
            }
            if (TextUtils.isEmpty(str)) {
                this.f47463f.setVisibility(8);
            } else {
                this.f47463f.setVisibility(0);
                this.f47463f.setText(str);
            }
            if (this.f47464g.getVisibility() != 0) {
                this.f47464g.setVisibility(0);
                setDividerColor(f47461i);
            }
        }
    }

    public void showNormalDividerLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hideTopMargin();
            if (this.f47463f.getVisibility() != 8) {
                this.f47463f.setVisibility(8);
            }
            if (this.f47464g.getVisibility() != 0) {
                this.f47464g.setVisibility(0);
                setDividerColor(j);
            }
        }
    }

    public void showTopMargin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f47462e.getVisibility() == 0) {
            return;
        }
        this.f47462e.setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardGroupDividerView(Context context, AttributeSet attributeSet) {
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
        this.f47465h = j;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardGroupDividerView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f47465h = j;
        a();
    }
}
