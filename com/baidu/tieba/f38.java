package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes5.dex */
public class f38 extends c38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn d;
    public TBSpecificationBtn e;
    public ImageView f;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-853269183, "Lcom/baidu/tieba/f38$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-853269183, "Lcom/baidu/tieba/f38$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.LIKE_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.SIGN_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LogicField.SPEED_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LogicField.SERVICE_AREA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LogicField.TOP_AREA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LogicField.ROUND_CORNER_STYLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[LogicField.TOP_DIVIDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[LogicField.BANNER_AND_BOTTOM_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public f38() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.c38
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n();
            o();
            this.f = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092357);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.findViewById(R.id.obfuscated_res_0x7f090d3a).setVisibility(8);
            this.c.findViewById(R.id.obfuscated_res_0x7f092b24).setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.c38, com.baidu.tieba.e38
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i = a.a[logicField.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return (T) super.a(logicField);
                    }
                    return (T) this.f;
                }
                return (T) Collections.singletonList(this.e);
            }
            return (T) Collections.singletonList(this.d);
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c38, com.baidu.tieba.e38
    public int l(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, logicField)) == null) {
            switch (a.a[logicField.ordinal()]) {
                case 4:
                case 5:
                case 6:
                case 7:
                    return 0;
                case 8:
                    return 8;
                default:
                    return super.l(logicField);
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.k38
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.k38
    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
            this.e.setOnClickListener(onClickListener);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f092832);
            this.d = tBSpecificationBtn;
            tBSpecificationBtn.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02f4));
            this.d.setTextSize(R.dimen.T_X08);
            e65 e65Var = new e65();
            e65Var.s(R.color.CAM_X0901, R.color.CAM_X0105);
            this.d.setConfig(e65Var);
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f09287c);
            this.e = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X08);
            e65 e65Var2 = new e65();
            e65Var2.w(R.color.CAM_X0105);
            e65Var2.h(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
            e65Var2.j(R.drawable.obfuscated_res_0x7f080b79, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.e.setConfig(e65Var2);
            this.e.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1433));
        }
    }
}
