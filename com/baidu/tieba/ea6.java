package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.dt3;
import com.baidu.tieba.ou3;
import com.baidu.tieba.zs3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ea6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "ea6";
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public fa6 a;
    public List<js1> b;
    public final CustomMessageListener c;

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs1 a;
        public final /* synthetic */ ea6 b;

        /* loaded from: classes5.dex */
        public class a extends GetUserInfoCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
                    this.a.a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                    this.a.a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                    this.a.b.a.b = SapiAccountManager.getInstance().getSession().bduss;
                    this.a.b.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.a.b.a.a = getUserInfoResult.displayname;
                    this.a.b.a.g = getUserInfoResult.uid;
                    this.a.b.a.f = getUserInfoResult.portraitHttps;
                    jk3.a().putString("bd_box_display_name", this.a.b.a.a);
                    jk3.a().putString("bd_box_uid", this.a.b.a.g);
                    jk3.a().putString("bd_box_avatar_url", this.a.b.a.f);
                    jk3.a().putString("bd_box_bduss", this.a.b.a.b);
                    jk3.a().putString("bd_box_ptoken", this.a.b.a.h);
                    this.a.a.onResult(0);
                    this.a.b.v(true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ea6 ea6Var, int i, hs1 hs1Var) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var, Integer.valueOf(i), hs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ea6Var;
            this.a = hs1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new a(this), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ea6 ea6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() != 1) {
                    if (num.intValue() != 2) {
                        return;
                    }
                    this.a.v(SapiAccountManager.getInstance().isLogin());
                    return;
                }
                this.a.r(TbadkCoreApplication.getInst());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea6 a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public b(ea6 ea6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) != null) {
                return;
            }
            this.a.v(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                if (getUserInfoResult != null) {
                    this.a.a.f = getUserInfoResult.portraitHttps;
                }
                this.a.v(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs1 a;
        public final /* synthetic */ ea6 b;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public d(ea6 ea6Var, hs1 hs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var, hs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ea6Var;
            this.a = hs1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
                this.a.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                this.a.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                this.b.a.b = SapiAccountManager.getInstance().getSession().bduss;
                this.b.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.b.a.a = getUserInfoResult.displayname;
                this.b.a.g = getUserInfoResult.uid;
                this.b.a.f = getUserInfoResult.portraitHttps;
                jk3.a().putString("bd_box_display_name", this.b.a.a);
                jk3.a().putString("bd_box_uid", this.b.a.g);
                jk3.a().putString("bd_box_avatar_url", this.b.a.f);
                jk3.a().putString("bd_box_bduss", this.b.a.b);
                jk3.a().putString("bd_box_ptoken", this.b.a.h);
                this.b.m();
                this.a.onResult(0);
                this.b.v(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea6 a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public e(ea6 ea6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048582, this, getUserInfoResult) != null) {
                return;
            }
            this.a.a.b = SapiAccountManager.getInstance().getSession().bduss;
            this.a.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
            this.a.a.a = getUserInfoResult.displayname;
            this.a.a.g = getUserInfoResult.uid;
            this.a.a.f = getUserInfoResult.portraitHttps;
            jk3.a().putString("bd_box_display_name", this.a.a.a);
            jk3.a().putString("bd_box_uid", this.a.a.g);
            jk3.a().putString("bd_box_avatar_url", this.a.a.f);
            jk3.a().putString("bd_box_bduss", this.a.a.b);
            jk3.a().putString("bd_box_ptoken", this.a.a.h);
        }
    }

    /* loaded from: classes5.dex */
    public class f extends AddressManageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zs3.d b;

        public f(ea6 ea6Var, String str, zs3.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, addressManageResult) == null) {
                if (!"0".equals(this.a) && this.b != null) {
                    if (addressManageResult.getResultCode() == 0) {
                        this.b.a(addressManageResult.map.get("addrId"));
                        return;
                    }
                    if (ea6.e) {
                        Log.d(ea6.d, String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                    }
                    this.b.failed();
                } else if (ea6.e) {
                    Log.d(ea6.d, String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends InvoiceBuildCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ou3.d b;

        public g(ea6 ea6Var, String str, ou3.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, invoiceBuildResult) == null) {
                if (!"0".equals(this.a) && this.b != null) {
                    if (invoiceBuildResult.getResultCode() == 0) {
                        this.b.a(invoiceBuildResult.map.get("invoice_id"), this.a);
                        return;
                    }
                    if (ea6.e) {
                        Log.d(ea6.d, String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                    }
                    this.b.failed();
                } else if (ea6.e) {
                    Log.d(ea6.d, String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends GetOpenBdussCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dt3.c a;
        public final /* synthetic */ ea6 b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, openBdussResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public h(ea6 ea6Var, dt3.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ea6Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openBdussResult) != null) {
                return;
            }
            this.b.a.c = openBdussResult.openBduss;
            this.b.a.d = openBdussResult.unionid;
            this.b.a.e = openBdussResult.tplStokenMap;
            jk3.a().putString("bd_box_open_bduss", this.b.a.c);
            jk3.a().putString("bd_box_union_id", this.b.a.d);
            jk3.a().putString("bd_box_stoken", np3.s(this.b.a.e));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, this.b.a.c);
                jSONObject.put("unionid", this.b.a.d);
                JSONObject jSONObject2 = new JSONObject();
                for (String str : this.b.a.e.keySet()) {
                    jSONObject2.put(str, this.b.a.e.get(str));
                }
                jSONObject.put("stokenmap", jSONObject2);
                jSONObject.put("uid", this.b.a.g);
                jSONObject.put("bduss", this.b.a.b);
                jSONObject.put("displayname", this.b.a.a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.a.a(jSONObject.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public static final ea6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-839475702, "Lcom/baidu/tieba/ea6$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-839475702, "Lcom/baidu/tieba/ea6$i;");
                    return;
                }
            }
            a = new ea6(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947727663, "Lcom/baidu/tieba/ea6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947727663, "Lcom/baidu/tieba/ea6;");
                return;
            }
        }
        e = fs1.a;
    }

    public static ea6 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return i.a;
        }
        return (ea6) invokeV.objValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            fa6 fa6Var = this.a;
            if (fa6Var != null && TextUtils.isEmpty(fa6Var.b)) {
                o();
            }
            return SapiAccountManager.getInstance().isLogin();
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    public ea6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this, 2921537);
        this.b = new ArrayList();
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            fa6 fa6Var = this.a;
            if (fa6Var == null) {
                if (!e) {
                    return "";
                }
                throw new NullPointerException("AccountInfo is null");
            }
            if (TextUtils.isEmpty(fa6Var.f)) {
                o();
            }
            return this.a.f;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            fa6 fa6Var = this.a;
            if (fa6Var == null) {
                if (!e) {
                    return "";
                }
                throw new NullPointerException("AccountInfo is null");
            }
            if (TextUtils.isEmpty(fa6Var.b)) {
                o();
            }
            return this.a.b;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            fa6 fa6Var = this.a;
            if (fa6Var == null) {
                if (!e) {
                    return "";
                }
                throw new NullPointerException("AccountInfo is null");
            }
            if (TextUtils.isEmpty(fa6Var.a)) {
                o();
            }
            return this.a.a;
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            fa6 fa6Var = this.a;
            if (fa6Var == null) {
                if (!e) {
                    return "";
                }
                throw new NullPointerException("AccountInfo is null");
            }
            if (TextUtils.isEmpty(fa6Var.g)) {
                o();
            }
            return this.a.g;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ ea6(a aVar) {
        this();
    }

    public void f(js1 js1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, js1Var) == null) {
            this.b.add(js1Var);
        }
    }

    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            w();
            r(context);
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            for (js1 js1Var : this.b) {
                if (js1Var != null) {
                    js1Var.a(z);
                }
            }
        }
    }

    public void x(hs1 hs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hs1Var) == null) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(this, hs1Var), SapiAccountManager.getInstance().getSession().bduss);
        }
    }

    public void g(Context context, String str, zs3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, dVar) == null) {
            AddressManageDTO addressManageDTO = new AddressManageDTO();
            addressManageDTO.type = str;
            addressManageDTO.sweepLightLoading = true;
            PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new f(this, str, dVar));
        }
    }

    public void h(Context context, String str, ou3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, dVar) == null) {
            InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
            invoiceBuildDTO.TYPE = str;
            PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new g(this, str, dVar));
        }
    }

    public void n(String str, ArrayList<String> arrayList, dt3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, arrayList, cVar) == null) {
            if (this.a == null) {
                if (!e) {
                    return;
                }
                throw new NullPointerException("AccountInfo is null");
            }
            GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
            getOpenBdussDTO.clientId = str;
            getOpenBdussDTO.targetTplList.addAll(arrayList);
            SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new h(this, cVar));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                SapiAccountManager.getInstance().getConfignation();
            } catch (Exception unused) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
            }
            try {
                SapiAccountManager.getInstance().isLogin();
                if (SapiAccountManager.getInstance().isLogin()) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new e(this), SapiAccountManager.getInstance().getSession().bduss);
                }
            } catch (NullPointerException unused2) {
            }
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, context) == null) && this.a == null) {
            fa6 fa6Var = new fa6();
            this.a = fa6Var;
            fa6Var.f = jk3.a().getString("bd_box_avatar_url", "");
            this.a.b = jk3.a().getString("bd_box_bduss", "");
            this.a.h = jk3.a().getString("bd_box_ptoken", "");
            this.a.g = jk3.a().getString("bd_box_uid", "");
            this.a.c = jk3.a().getString("bd_box_open_bduss", "");
            this.a.d = jk3.a().getString("bd_box_union_id", "");
            this.a.e = np3.t(jk3.a().getString("bd_box_stoken", ""));
            this.a.a = jk3.a().getString("bd_box_display_name", "");
        }
    }

    public void t(Context context, Bundle bundle, hs1 hs1Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, context, bundle, hs1Var) == null) {
            if (this.a == null) {
                this.a = new fa6();
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true, -1);
            loginActivityConfig.getIntent().putExtra("close", true);
            if (bundle != null && (i2 = bundle.getInt("key_login_mode", 1)) > 1) {
                if (i2 == 4) {
                    i2 = 1;
                }
                loginActivityConfig.setIsFromAiapp(true);
                loginActivityConfig.setThirdPartyLoginForResult(i2, "");
            }
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
            MessageManager.getInstance().registerListener(new c(this, 2921362, hs1Var));
        }
    }

    public void u(hs1 hs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hs1Var) == null) {
            SapiAccountManager.getInstance().logout();
            v(false);
            this.a = new fa6();
            jk3.a().putString("bd_box_display_name", "");
            jk3.a().putString("bd_box_uid", "");
            jk3.a().putString("bd_box_avatar_url", "");
            jk3.a().putString("bd_box_bduss", "");
            jk3.a().putString("bd_box_ptoken", "");
            if (hs1Var != null) {
                hs1Var.onResult(0);
            }
        }
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, getUserInfoResult) == null) {
            if (getUserInfoResult != null) {
                try {
                    jk3.a().putString("host_account_info_string", getUserInfoResult.toString());
                    if (this.a == null) {
                        this.a = new fa6();
                    }
                    this.a.b = SapiAccountManager.getInstance().getSession().bduss;
                    this.a.h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.a.a = getUserInfoResult.displayname;
                    this.a.g = getUserInfoResult.uid;
                    this.a.f = getUserInfoResult.portraitHttps;
                    jk3.a().putString("bd_box_display_name", this.a.a);
                    jk3.a().putString("bd_box_uid", this.a.g);
                    jk3.a().putString("bd_box_avatar_url", this.a.f);
                    jk3.a().putString("bd_box_bduss", this.a.b);
                    jk3.a().putString("bd_box_ptoken", this.a.h);
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(this), this.a.b);
                    return;
                } catch (Exception e2) {
                    if (e) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            u(null);
        }
    }
}
