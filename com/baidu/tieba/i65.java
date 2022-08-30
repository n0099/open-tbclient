package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i65 extends g65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NestedScrollView a;
    public LinearLayout b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public TBSpecificationBtn f;
    public LinearLayout g;
    public int h;
    public Rect i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i65 a;

        public a(i65 i65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i65Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(-1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i65(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0338, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = new Rect();
        this.a = (NestedScrollView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091d88);
        this.b = (LinearLayout) this.attachedView.findViewById(R.id.obfuscated_res_0x7f0906bd);
        this.c = (TbImageView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091649);
        this.d = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091648);
        this.e = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f09164b);
        this.g = (LinearLayout) this.attachedView.findViewById(R.id.obfuscated_res_0x7f09164a);
        this.f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091647);
        rv4 rv4Var = new rv4();
        this.f.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0fbc));
        this.f.setTextSize(R.dimen.tbds42);
        this.f.setConfig(rv4Var);
        this.f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.h <= 0) {
                this.h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            NestedScrollView nestedScrollView = this.a;
            if (nestedScrollView == null) {
                return;
            }
            if (i == 0) {
                nestedScrollView.post(new a(this));
            }
            if (this.a.getLocalVisibleRect(this.i)) {
                int i2 = this.i.bottom;
                int abs = Math.abs(this.b.getTop());
                int abs2 = i2 - Math.abs(this.b.getBottom());
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i3 = this.h;
                    if (abs < i3) {
                        marginLayoutParams.topMargin = i3;
                        this.b.setLayoutParams(marginLayoutParams);
                    } else if (abs == i3) {
                        if (abs2 > i3) {
                            marginLayoutParams.topMargin = i3 + ((abs2 - i3) / 2);
                            this.b.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > i3) {
                        if (abs2 < i3) {
                            marginLayoutParams.topMargin = i3;
                        } else if (abs2 == i3) {
                            marginLayoutParams.topMargin = i3;
                        } else if (abs2 > i3) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.b.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.attachedView : (View) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null) {
            return;
        }
        this.f.setText(str);
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str == null) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.d.setText(str);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.e.setText(str);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0109, 1);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.c, R.drawable.new_pic_emotion_08);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0107, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            TBSpecificationBtn tBSpecificationBtn = this.f;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    @Override // com.baidu.tieba.g65
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.g65
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onViewDettached();
            this.c.setImageResource(0);
        }
    }
}
