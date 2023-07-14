package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.PolyNoticeDialog;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ei1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bj1 a;
    public ij1 b;
    public fj1 c;
    public PolyNoticeDialog d;

    /* loaded from: classes5.dex */
    public class e implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj1 c;

        /* loaded from: classes5.dex */
        public class a implements gj1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.gj1
            public void onResult(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    if (6 == i) {
                        this.a.c.d.f("请点击查询按钮确认支付结果");
                        this.a.c.d.i();
                        this.a.c.d.d(true);
                    } else if (i == 0) {
                        li1.e(new ii1("108"));
                        this.a.a.d0(i, ri1.a(i, "", str), "0");
                    } else if (3 == i) {
                        li1.e(new ii1("109"));
                        this.a.a.f0();
                        e eVar = this.a;
                        eVar.c.u(eVar.a);
                    }
                }
            }
        }

        public e(cj1 cj1Var, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cj1Var;
            this.a = channelListView;
            this.b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d.g("确认小额免密支付结果");
                this.c.d.f("支付结果查询中 请稍后");
                this.c.d.h();
                this.c.d.b("关闭", "查询");
                this.c.d.d(false);
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                di1.h().f();
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i == R.id.obfuscated_res_0x7f091c9a) {
                    di1.h().f();
                    this.a.d0(6, "支付结果查询失败，请重试", "0");
                    this.c.d.dismiss();
                } else if (i == R.id.obfuscated_res_0x7f091c9c) {
                    li1.e(new ii1("111"));
                    this.c.d.d(false);
                    this.c.d.h();
                    this.c.d.f("支付结果查询中 请稍后");
                    di1.h().g(this.b, new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends ch1<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ PayChannelEntity b;
        public final /* synthetic */ ChannelListView c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cj1 e;

        public a(cj1 cj1Var, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var, bundle, payChannelEntity, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cj1Var;
            this.a = bundle;
            this.b = payChannelEntity;
            this.c = channelListView;
            this.d = str;
        }

        @Override // com.baidu.tieba.ch1
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
                String string = this.a.getString("panelType");
                String string2 = this.a.getString("tradeType");
                ui1.g("onWindowFocusChanged panelType=" + string + ", tradeType=" + string2);
                if (TextUtils.equals(string, HlsPlaylistParser.METHOD_NONE) && TextUtils.equals(string2, "DIRECTPAY")) {
                    this.c.U(qi1.c(yi1.a().getString(R.string.obfuscated_res_0x7f0f0f65) + str2), str);
                } else {
                    ChannelListView channelListView = this.c;
                    channelListView.U(yi1.a().getString(R.string.obfuscated_res_0x7f0f0f65) + str2, str);
                }
                ii1 ii1Var = new ii1("1");
                ii1Var.b(new SdkException("launchpayment error --> " + str, th).getStackMessage());
                li1.e(ii1Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ch1
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                ei1.b().d(map.get("orderInfoUrl"));
                li1.e = map.get("orderId");
                String str = map.get("logicType");
                if (TextUtils.equals(str, "PASS_CHECK")) {
                    String str2 = map.get("authId");
                    if (this.e.c != null) {
                        eh1 eh1Var = new eh1();
                        eh1Var.d("logicType", str);
                        eh1Var.d("authId", str2);
                        this.e.c.b(new zi1(eh1Var, this.a, this.b));
                    }
                } else if (TextUtils.equals(str, "RISK_BLOCK")) {
                    if (this.e.c != null) {
                        this.e.c.a();
                    }
                } else if (TextUtils.equals(str, "DIRECT_OUTTER")) {
                    this.e.o(this.b, this.c, map);
                } else if (TextUtils.equals(str, "SDK_TO_AGREEMENT")) {
                    this.e.p(this.c, map);
                } else if (TextUtils.equals(str, "SIGN_AFTER_PAY")) {
                    this.e.q(this.c, map);
                } else if (TextUtils.equals(str, "DIRECT_DRMB")) {
                    this.c.r0(map.get("orderId"), this.b);
                } else {
                    this.e.n(this.b, this.c, map, this.d);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ei1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public b(cj1 cj1Var, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.tieba.ei1.b
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a != null) {
                this.a.d0(i, ri1.a(i, "", str), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements gj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ChannelListView b;
        public final /* synthetic */ cj1 c;

        public c(cj1 cj1Var, String str, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var, str, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cj1Var;
            this.a = str;
            this.b = channelListView;
        }

        @Override // com.baidu.tieba.gj1
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (1 != i) {
                    if (6 == i) {
                        if (this.c.d != null) {
                            this.c.d.f("请点击查询按钮确认支付结果");
                            this.c.d.i();
                            this.c.d.d(true);
                            return;
                        }
                        return;
                    } else if (i == 0) {
                        li1.e(new ii1("108"));
                        this.b.d0(i, ri1.a(i, "", str), "0");
                        return;
                    } else if (3 == i) {
                        li1.e(new ii1("109"));
                        this.b.f0();
                        this.c.u(this.b);
                        return;
                    } else {
                        return;
                    }
                }
                this.c.t(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyNoticeDialog a;

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(cj1 cj1Var, PolyNoticeDialog polyNoticeDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var, polyNoticeDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyNoticeDialog;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g(EventAlias.PayEventAlias.PAY_FAIL);
                this.a.f("请确认账号余额，或选择其他支付方式");
                this.a.e("我知道了");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupWindow a;
        public final /* synthetic */ ChannelListView b;
        public final /* synthetic */ String c;

        public f(cj1 cj1Var, PopupWindow popupWindow, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var, popupWindow, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = popupWindow;
            this.b = channelListView;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PopupWindow popupWindow = this.a;
                if (popupWindow != null && popupWindow.r()) {
                    this.a.n();
                }
                this.b.d0(0, this.c, "0");
            }
        }
    }

    public cj1(bj1 bj1Var, fj1 fj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bj1Var, fj1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bj1Var;
        this.c = fj1Var;
    }

    public final void p(ChannelListView channelListView, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, channelListView, map) == null) {
            if (!TextUtils.equals(map.get(StatConstants.KEY_EXT_ERR_CODE), "0")) {
                channelListView.f0();
                u(channelListView);
                return;
            }
            String queryOrderString = channelListView.getSelectedPayChannelEntity().getQueryOrderString();
            di1.h().g(queryOrderString, new c(this, queryOrderString, channelListView));
        }
    }

    public final void q(ChannelListView channelListView, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, channelListView, map) == null) {
            String str = map.get("signUrl");
            try {
                Activity activity = (Activity) channelListView.getContext();
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("preEntrustWebId");
                this.b.a(activity, jSONObject.optString("wechatAppId"), optString);
                ei1.b().e(new b(this, channelListView));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void t(String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.d = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.d.c(new e(this, channelListView, str));
            this.d.show(((Activity) channelListView.getContext()).getFragmentManager(), "QUERY_ORDER_NOTICE_FRAGMENT_TAG");
            li1.e(new ii1(TbEnum.SystemMessage.EVENT_ID_COMMON));
        }
    }

    public final boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context.getPackageManager().getPackageInfo("com.tencent.mm", 0) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(ij1 ij1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ij1Var) == null) {
            this.b = ij1Var;
        }
    }

    public final void u(ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.c(new d(this, polyNoticeDialog));
            polyNoticeDialog.show(((Activity) channelListView.getContext()).getFragmentManager(), "PAY_FAILED_NOTICE_FRAGMENT_TAG");
        }
    }

    public void l(Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, bundle, payChannelEntity, channelListView, str) == null) {
            m(null, bundle, payChannelEntity, channelListView, str);
        }
    }

    public final void i(Map<String, String> map, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, payChannelEntity, str, channelListView) == null) {
            String str2 = map.get("extData");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (TextUtils.equals(new JSONObject(str2).optString("actionType"), "H5")) {
                        String str3 = map.get("payUrl");
                        if (!TextUtils.isEmpty(str3)) {
                            if (j(channelListView.getContext())) {
                                channelListView.setWechatH5Pay(true);
                                channelListView.setIsPreparePaying(false);
                                k((Activity) channelListView.getContext(), str3, map);
                                hi1.h("8");
                                HashMap hashMap = new HashMap();
                                hashMap.put("exceptionCode", "0");
                                if (!TextUtils.isEmpty(str)) {
                                    hashMap.put("isFoldChannel", str);
                                }
                                hi1.c("8", hashMap);
                                return;
                            }
                            hi1.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.d0(3, "wx_not_installed", "0");
                            return;
                        }
                        hi1.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-107", "调起微信H5链接无效");
                        channelListView.U("H5 no corresponding url ", null);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("exceptionCode", "3");
                        hashMap2.put("errno", null);
                        hashMap2.put("errmsg", "H5 no corresponding url");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap2.put("isFoldChannel", str);
                        }
                        hi1.c("8", hashMap2);
                        return;
                    }
                } catch (Exception e2) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("exceptionType", "119502");
                    hashMap3.put("path", "cashier/launchpayment");
                    hashMap3.put(StatConstants.KEY_EXT_ERR_CODE, TbEnum.CustomGroupId.OFFICIAL_MERGE);
                    if (!TextUtils.isEmpty(str)) {
                        hashMap3.put("isFoldChannel", str);
                    }
                    hashMap3.put(StatConstants.KEY_EXT_ERR_MSG, e2.getMessage());
                    hi1.c("8", hashMap3);
                    channelListView.U("launchpayment extData analyze failed ", null);
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("exceptionCode", "3");
                    hashMap4.put("errno", null);
                    hashMap4.put("errmsg", "launchpayment extData analyze failed");
                    if (!TextUtils.isEmpty(str)) {
                        hashMap4.put("isFoldChannel", str);
                    }
                    hi1.c("8", hashMap4);
                    return;
                }
            }
            this.a.d(map, payChannelEntity, str, channelListView);
        }
    }

    public final void k(Activity activity, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, map) == null) && activity != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, PayWebActivity.class);
            intent.putExtra("load_url", str);
            Bundle bundle = new Bundle();
            for (String str2 : map.keySet()) {
                bundle.putString(str2, map.get(str2));
            }
            intent.putExtra("launch_payment_data", bundle);
            activity.startActivityForResult(intent, 200);
        }
    }

    public void m(eh1 eh1Var, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eh1Var, bundle, payChannelEntity, channelListView, str) == null) {
            if (payChannelEntity != null && payChannelEntity.isNeedAgreementGuide() && payChannelEntity.isAlreadySigned()) {
                sj1.e(channelListView.getContext(), R.drawable.obfuscated_res_0x7f0807bb, "小额免密扣款中");
            }
            kh1.j().v(eh1Var, bundle, new a(this, bundle, payChannelEntity, channelListView, str), payChannelEntity, str);
        }
    }

    public final void n(PayChannelEntity payChannelEntity, ChannelListView channelListView, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, payChannelEntity, channelListView, map, str) == null) {
            if (map.containsKey("parentType")) {
                String str2 = map.get("parentType");
                if (TextUtils.isEmpty(str2)) {
                    i(map, payChannelEntity, str, channelListView);
                    return;
                } else if (4 == Integer.parseInt(str2)) {
                    String a2 = ri1.a(0, map.get("orderId"), "Successful payment");
                    PopupWindow popupWindow = new PopupWindow(View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d075f, null), -1, -1, true);
                    popupWindow.w(false);
                    popupWindow.y(false);
                    popupWindow.B(false);
                    popupWindow.D(channelListView, 0, 0, 0);
                    new Handler().postDelayed(new f(this, popupWindow, channelListView, a2), 2000L);
                    hi1.h("8");
                    ui1.g("WalletList->pay() 命中0单元");
                    return;
                } else {
                    i(map, payChannelEntity, str, channelListView);
                    return;
                }
            }
            i(map, payChannelEntity, str, channelListView);
        }
    }

    public final void o(PayChannelEntity payChannelEntity, ChannelListView channelListView, Map<String, String> map) {
        boolean equalsIgnoreCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, payChannelEntity, channelListView, map) == null) {
            ui1.g("processDirectOuter ------ payChannel=" + payChannelEntity.getPayChannel());
            String str = map.get("extData");
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("actionType");
                    StringBuilder sb = new StringBuilder();
                    sb.append("processWxH5Pay actionType=");
                    sb.append(optString);
                    ui1.g(sb.toString());
                    equalsIgnoreCase = "H5".equalsIgnoreCase(optString);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!equalsIgnoreCase && TextUtils.equals("BAIDU-SUPER-WECHAT-WISE", payChannelEntity.getPayChannel())) {
                    r(map, channelListView);
                    return;
                }
                this.a.f("DIRECT_OUTTER", map, payChannelEntity.getPayChannel(), channelListView, map.get("payResUrl"));
            }
            equalsIgnoreCase = false;
            if (!equalsIgnoreCase) {
            }
            this.a.f("DIRECT_OUTTER", map, payChannelEntity.getPayChannel(), channelListView, map.get("payResUrl"));
        }
    }

    public final void r(Map<String, String> map, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, map, channelListView) == null) {
            String str = map.get("orderId");
            li1.e = str;
            String str2 = map.get("extData");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if ("H5".equalsIgnoreCase(new JSONObject(str2).optString("actionType"))) {
                        String str3 = map.get("payUrl");
                        if (!TextUtils.isEmpty(str3)) {
                            if (j(channelListView.getContext())) {
                                channelListView.setWechatH5Pay(true);
                                channelListView.setIsPreparePaying(false);
                                k((Activity) channelListView.getContext(), str3, map);
                                hi1.h("8");
                                channelListView.d0(1, qi1.d(str, str3, "wx H5 paying"), "");
                            } else {
                                hi1.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                                Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                                channelListView.d0(3, qi1.d(str, str3, "wx_not_installed"), "0");
                            }
                        } else {
                            channelListView.U(qi1.d(str, str3, "H5 no corresponding url "), null);
                            hi1.b("8", null, "H5 no corresponding url");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    channelListView.U(qi1.d(str, "", "launchpayment extData analyze failed "), null);
                    hi1.b("8", null, "launchpayment extData analyze failed");
                }
            }
        }
    }
}
