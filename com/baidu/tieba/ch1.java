package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ch1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public IChannelPay b;

    /* loaded from: classes3.dex */
    public class a extends df1<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelListView b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ch1 d;

        public a(ch1 ch1Var, String str, ChannelListView channelListView, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch1Var, str, channelListView, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ch1Var;
            this.a = str;
            this.b = channelListView;
            this.c = str2;
        }

        @Override // com.baidu.tieba.df1
        public void b(Throwable th, String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                if (str != null) {
                    str2 = str;
                } else if (th != null) {
                    str2 = th.getMessage();
                } else {
                    str2 = null;
                }
                ChannelListView channelListView = this.b;
                channelListView.U(zg1.a().getString(R.string.obfuscated_res_0x7f0f0e54) + str2, str);
                jg1 jg1Var = new jg1("1");
                jg1Var.b(new SdkException("pay_platform error --> " + str, th).getStackMessage());
                mg1.e(jg1Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("exceptionCode", "0");
                if (!TextUtils.isEmpty(this.a)) {
                    hashMap.put("isFoldChannel", this.a);
                }
                ig1.c("8", hashMap);
                this.b.Y();
                this.d.f("STEP_INNER", map, this.c, this.b, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements hh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ ChannelListView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ch1 g;

        public b(ch1 ch1Var, String str, Map map, ChannelListView channelListView, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch1Var, str, map, channelListView, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ch1Var;
            this.a = str;
            this.b = map;
            this.c = channelListView;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // com.baidu.tieba.hh1
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                vg1.g("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
                if (TextUtils.equals(this.a, "DIRECT_OUTTER")) {
                    this.g.e(i, str, this.b, this.c, this.d);
                    return;
                }
                this.c.e0(i, sg1.a(i, this.e, str), "1", this.a, this.b, this.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public c(ch1 ch1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public ch1(Activity activity, IChannelPay iChannelPay) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, iChannelPay};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = iChannelPay;
    }

    public void b(Bundle bundle, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, bundle, payChannelEntity, str, channelListView) != null) || payChannelEntity == null) {
            return;
        }
        String payChannel = payChannelEntity.getPayChannel();
        String installmentPeriod = payChannelEntity.getInstallmentPeriod();
        if (TextUtils.isEmpty(payChannel)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(lf1.b, payChannel);
        if (!TextUtils.isEmpty(installmentPeriod)) {
            jSONObject.put(lf1.c, installmentPeriod);
        }
        bundle.putString("reqData", jSONObject.toString());
        lf1.j().u(bundle, new a(this, str, channelListView, payChannel));
    }

    public JSONObject c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (!TextUtils.isEmpty(map.get("payInfo"))) {
                try {
                    return new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                } catch (JSONException unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void d(Map<String, String> map, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, map, payChannelEntity, str, channelListView) == null) {
            try {
                b(wg1.a(map), payChannelEntity, str, channelListView);
            } catch (Throwable th) {
                String message = th.getMessage();
                channelListView.U("third pay error msg is " + message, null);
            }
        }
    }

    public final void e(int i, String str, Map<String, String> map, ChannelListView channelListView, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, map, channelListView, str2}) == null) {
            if (!TextUtils.isEmpty(str2) && i == 0) {
                new jf1().d(str2, new ff1(), new c(this));
            }
            channelListView.d0(i, rg1.a(map.get("orderId"), map.get("payInfo"), str), "1");
        }
    }

    public void f(String str, Map<String, String> map, String str2, ChannelListView channelListView, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, str, map, str2, channelListView, str3) == null) {
            ih1 ih1Var = new ih1();
            ih1Var.b = c(map);
            ih1Var.a = str2;
            String str4 = map.get("payOrderNo");
            mg1.f = str4;
            if (this.b != null) {
                ig1.d();
                this.b.pay(this.a, ih1Var, new b(this, str, map, channelListView, str3, str4, str2));
                vg1.g("WalletChannel->thirdPay setIsPreparePaying()");
                channelListView.setIsPreparePaying(false);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }
}
