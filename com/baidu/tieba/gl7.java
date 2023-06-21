package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.log.PeiwanLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.view.LoadingUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.util.PersonalChatUtil;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes5.dex */
public class gl7 {
    public static /* synthetic */ Interceptable $ic;
    public static gl7 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends gl7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends nx5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(gl7 gl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nx5
        /* renamed from: a */
        public JSONObject doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork("https://peiwan.baidu.com/peiwan/api/index/audio");
                netWork.setNeedBdussForGet(true);
                String netString = netWork.getNetString();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        JSONObject jSONObject = new JSONObject(netString);
                        PeiwanLog.getInstance().c(TbConfig.API_CLICK_FRS_GAMEPLAY_CARD, jSONObject.optString("logid"));
                        return jSONObject.optJSONObject("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return new JSONObject();
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rw5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ gl7 c;

        public c(gl7 gl7Var, TbPageContext tbPageContext, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl7Var, tbPageContext, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gl7Var;
            this.a = tbPageContext;
            this.b = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rw5
        /* renamed from: a */
        public void onReturnDataInUI(JSONObject jSONObject) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                LoadingUtil.cancel();
                boolean z = false;
                if (jSONObject != null) {
                    j = jSONObject.optLong("room_id", 0L);
                    z = jSONObject.optBoolean("have_audio_list", false);
                } else {
                    j = 0;
                }
                TbPageContext tbPageContext = this.a;
                if (tbPageContext == null) {
                    return;
                }
                if (z) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.getPageActivity(), "GameAudioListPage", null)));
                } else if (j == 0) {
                    wi.Q(tbPageContext.getPageActivity(), "当前没有可用房间");
                } else {
                    Uri g = this.c.g(this.b, "room_id", String.valueOf(j));
                    if (g == null) {
                        ((jo5) ServiceManager.getService(jo5.a.a())).b(this.a, j);
                    } else {
                        ((jo5) ServiceManager.getService(jo5.a.a())).d(this.a, g.toString());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends nx5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(gl7 gl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nx5
        /* renamed from: a */
        public JSONObject doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork("https://peiwan.baidu.com/peiwan/api/index/service");
                netWork.setNeedBdussForGet(true);
                String netString = netWork.getNetString();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        return new JSONObject(netString).optJSONObject("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements rw5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public e(gl7 gl7Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl7Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rw5
        /* renamed from: a */
        public void onReturnDataInUI(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                LoadingUtil.cancel();
                if (this.a != null && jSONObject != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("chat_god");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("user_id");
                        if (TextUtils.isEmpty(optString)) {
                            optString = "0";
                        }
                        PersonalChatUtil.jump2ChatFromPeiwan(TbadkCoreApplication.getInst().getContext(), Long.parseLong(optString), optJSONObject.optString("username"), optJSONObject.optString("avatar"));
                        return;
                    }
                    return;
                }
                wi.Q(TbadkCoreApplication.getInst(), "网络请求失败");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947797847, "Lcom/baidu/tieba/gl7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947797847, "Lcom/baidu/tieba/gl7;");
                return;
            }
        }
        a = new a();
    }

    public gl7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static gl7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return (gl7) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ gl7(a aVar) {
        this();
    }

    public void b(TbPageContext tbPageContext, LiveFuseForumData liveFuseForumData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, tbPageContext, liveFuseForumData, str) == null) && liveFuseForumData != null && !TextUtils.isEmpty(str)) {
            if (liveFuseForumData.type.intValue() == 2) {
                if (str.contains("room_id")) {
                    e(tbPageContext, str);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                    f(tbPageContext, str);
                } else {
                    UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
                }
            } else if (liveFuseForumData.type.intValue() == 3) {
                e(tbPageContext, str);
            } else if (liveFuseForumData.type.intValue() == 4) {
                f(tbPageContext, str);
            } else {
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
            }
        }
    }

    public final void e(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, str) == null) {
            LoadingUtil.show("跳转中...");
            Uri parse = Uri.parse(str);
            parse.getQueryParameter("room_id");
            rx5.b(new b(this), new c(this, tbPageContext, parse));
        }
    }

    public final void f(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, tbPageContext, str) != null) || !d()) {
            return;
        }
        LoadingUtil.show("跳转中...");
        rx5.b(new d(this), new e(this, tbPageContext));
    }

    public final Uri g(Uri uri, String str, String str2) {
        InterceptResult invokeLLL;
        Uri.Builder buildUpon;
        Set<String> queryParameterNames;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, uri, str, str2)) == null) {
            if (uri == null || (buildUpon = uri.buildUpon()) == null || (queryParameterNames = uri.getQueryParameterNames()) == null) {
                return null;
            }
            if (queryParameterNames.contains(str)) {
                buildUpon.clearQuery();
                for (String str3 : queryParameterNames) {
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.equals(str)) {
                            queryParameter = str2;
                        } else {
                            queryParameter = uri.getQueryParameter(str3);
                        }
                        buildUpon.appendQueryParameter(str3, queryParameter);
                    }
                }
            } else {
                buildUpon.appendQueryParameter(str, str2);
            }
            return buildUpon.build();
        }
        return (Uri) invokeLLL.objValue;
    }
}
