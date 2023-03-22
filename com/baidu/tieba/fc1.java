package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadExpressNaBaseView a;
    public final Context b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-809148712, "Lcom/baidu/tieba/fc1$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-809148712, "Lcom/baidu/tieba/fc1$a;");
                    return;
                }
            }
            int[] iArr = new int[AdOperator.TYPE.values().length];
            a = iArr;
            try {
                iArr[AdOperator.TYPE.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdOperator.TYPE.CHECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public fc1(NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nadExpressNaBaseView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nadExpressNaBaseView;
        this.b = nadExpressNaBaseView.getContext();
    }

    public final boolean a(AdBaseModel adBaseModel, int i) {
        InterceptResult invokeLI;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, adBaseModel, i)) == null) {
            if (adBaseModel == null || (adOperator = adBaseModel.h) == null) {
                return false;
            }
            int i2 = a.a[adOperator.a.ordinal()];
            if (i2 != 1) {
                if (i2 != 2 || i != 2) {
                    return false;
                }
                return true;
            }
            yp0 yp0Var = adBaseModel.i;
            if (yp0Var != null && yp0Var.k) {
                if (i != 3) {
                    return false;
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                return true;
            }
        }
        return invokeLI.booleanValue;
    }

    public final void b(View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, f) != null) || view2 == null) {
            return;
        }
        t41.a(view2.getContext(), view2, f);
    }

    public ec1 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        AdOperator adOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) {
            ec1 operateBar = this.a.getOperateBar();
            if (!ec1.d(adBaseModel) || (adOperator = adBaseModel.h) == null) {
                return null;
            }
            if (operateBar != null && a(adBaseModel, operateBar.a)) {
                return operateBar;
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.nad_feed_ad_operate_view);
            relativeLayout.removeAllViews();
            AdOperator.TYPE type = adOperator.a;
            AdOperator.TYPE type2 = AdOperator.TYPE.DOWNLOAD;
            if (type == type2) {
                fp0 fp0Var = adBaseModel.l;
                if (fp0Var == null || !fp0Var.e) {
                    return null;
                }
                int i = R.layout.nad_operate_app_info_view;
                xp0 xp0Var = adBaseModel.p;
                if (xp0Var != null && xp0Var.b(type2) != 0) {
                    i = adBaseModel.p.b(AdOperator.TYPE.DOWNLOAD);
                }
                yp0 yp0Var = adBaseModel.i;
                if (yp0Var != null && yp0Var.k) {
                    View inflate = LayoutInflater.from(this.b).inflate(i, (ViewGroup) relativeLayout, true);
                    b(inflate.findViewById(R.id.nad_feed_ad_operate_progress_button), 6.0f);
                    return new gc1(3, inflate);
                }
                View inflate2 = LayoutInflater.from(this.b).inflate(R.layout.nad_operate_download, (ViewGroup) relativeLayout, true);
                b(inflate2.findViewById(R.id.nad_feed_ad_operate_progress_button), 6.0f);
                return new ic1(1, inflate2);
            }
            AdOperator.TYPE type3 = AdOperator.TYPE.CHECK;
            if (type != type3) {
                return null;
            }
            int i2 = R.layout.nad_operate_command;
            xp0 xp0Var2 = adBaseModel.p;
            if (xp0Var2 != null && xp0Var2.b(type3) != 0) {
                i2 = adBaseModel.p.b(AdOperator.TYPE.CHECK);
            }
            View inflate3 = LayoutInflater.from(this.b).inflate(i2, (ViewGroup) relativeLayout, true);
            b(inflate3.findViewById(R.id.nad_feed_ad_operate_command_button), 6.0f);
            return new hc1(2, inflate3);
        }
        return (ec1) invokeL.objValue;
    }
}
