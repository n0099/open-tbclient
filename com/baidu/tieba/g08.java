package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.PeiwanLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.view.LoadingUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.module.frs.FrsService;
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
/* loaded from: classes6.dex */
public class g08 {
    public static /* synthetic */ Interceptable $ic;
    public static g08 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends g08 {
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

    /* loaded from: classes6.dex */
    public class b extends ju5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g08 g08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var};
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
        @Override // com.baidu.tieba.ju5
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
                        PeiwanLog.getInstance().i(TbConfig.API_CLICK_FRS_GAMEPLAY_CARD, jSONObject.optString("logid"));
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

    /* loaded from: classes6.dex */
    public class c implements ot5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ LiveFuseForumData b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Uri h;
        public final /* synthetic */ g08 i;

        public c(g08 g08Var, TbPageContext tbPageContext, LiveFuseForumData liveFuseForumData, int i, boolean z, String str, String str2, String str3, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var, tbPageContext, liveFuseForumData, Integer.valueOf(i), Boolean.valueOf(z), str, str2, str3, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = g08Var;
            this.a = tbPageContext;
            this.b = liveFuseForumData;
            this.c = i;
            this.d = z;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ot5
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
                if (tbPageContext != null) {
                    if (z) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.getPageActivity(), "GameAudioListPage", null)));
                        this.i.l(this.b, this.c, "", this.d, this.e, this.f);
                        return;
                    } else if (j == 0) {
                        BdUtilHelper.showToast(tbPageContext.getPageActivity(), "当前没有可用房间");
                        this.i.l(this.b, this.c, "", this.d, this.e, this.f);
                        return;
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c15374");
                        statisticItem.addParam("uid", BdStatisticsManager.getInstance().getUid());
                        statisticItem.addParam(TiebaStatic.Params.FROM_SOURCE, this.g);
                        statisticItem.addParam("room_id", j);
                        TiebaStatic.log(statisticItem);
                        Uri j2 = this.i.j(this.h, "room_id", String.valueOf(j));
                        if (j2 == null) {
                            ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(this.a, j);
                        } else {
                            ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(this.a, j2.toString());
                        }
                        this.i.l(this.b, this.c, String.valueOf(j), this.d, this.e, this.f);
                        return;
                    }
                }
                this.i.l(this.b, this.c, "", this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ju5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g08 g08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var};
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
        @Override // com.baidu.tieba.ju5
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

    /* loaded from: classes6.dex */
    public class e implements ot5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public e(g08 g08Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var, tbPageContext};
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
        @Override // com.baidu.tieba.ot5
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
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "网络请求失败");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947740218, "Lcom/baidu/tieba/g08;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947740218, "Lcom/baidu/tieba/g08;");
                return;
            }
        }
        a = new a();
    }

    public g08() {
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

    public static g08 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return a;
        }
        return (g08) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ g08(a aVar) {
        this();
    }

    public final JSONObject f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void c(TbPageContext tbPageContext, LiveFuseForumData liveFuseForumData, String str, int i, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, liveFuseForumData, str, Integer.valueOf(i), Boolean.valueOf(z), str2, str3}) == null) && liveFuseForumData != null && !TextUtils.isEmpty(str)) {
            if (liveFuseForumData.type.intValue() == 2) {
                if (str.contains("room_id")) {
                    h(tbPageContext, str, liveFuseForumData, i, z, str2, str3);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                    i(tbPageContext, str);
                    l(liveFuseForumData, i, "", z, str2, str3);
                } else {
                    UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
                    l(liveFuseForumData, i, "", z, str2, str3);
                }
            } else if (liveFuseForumData.type.intValue() == 3) {
                h(tbPageContext, str, liveFuseForumData, i, z, str2, str3);
            } else if (liveFuseForumData.type.intValue() == 4) {
                i(tbPageContext, str);
                l(liveFuseForumData, i, "", z, str2, str3);
            } else {
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
            }
        }
    }

    public final int e(int i, LiveFuseForumData liveFuseForumData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, liveFuseForumData)) == null) {
            if (i == 1) {
                if (liveFuseForumData.type.intValue() == 1) {
                    return 1;
                }
                if (liveFuseForumData.type.intValue() == 2) {
                    return 3;
                }
                if (liveFuseForumData.type.intValue() == 7) {
                    return 5;
                }
            } else if (i == 2) {
                if (liveFuseForumData.type.intValue() == 1) {
                    return 2;
                }
                if (liveFuseForumData.type.intValue() == 2) {
                    return 4;
                }
            }
            return 0;
        }
        return invokeIL.intValue;
    }

    public final void h(TbPageContext tbPageContext, String str, LiveFuseForumData liveFuseForumData, int i, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbPageContext, str, liveFuseForumData, Integer.valueOf(i), Boolean.valueOf(z), str2, str3}) == null) {
            LoadingUtil.show("跳转中...");
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return;
            }
            String queryParameter = parse.getQueryParameter("source");
            StatisticItem statisticItem = new StatisticItem("c15373");
            statisticItem.addParam("uid", BdStatisticsManager.getInstance().getUid());
            statisticItem.addParam(TiebaStatic.Params.FROM_SOURCE, queryParameter);
            TiebaStatic.log(statisticItem);
            nu5.b(new b(this), new c(this, tbPageContext, liveFuseForumData, i, z, str2, str3, queryParameter, parse));
        }
    }

    public final void i(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, tbPageContext, str) != null) || !g()) {
            return;
        }
        LoadingUtil.show("跳转中...");
        nu5.b(new d(this), new e(this, tbPageContext));
    }

    public final Uri j(Uri uri, String str, String str2) {
        InterceptResult invokeLLL;
        Uri.Builder buildUpon;
        Set<String> queryParameterNames;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, uri, str, str2)) == null) {
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

    public final void k(String str, String str2, String str3, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, str4) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("fid", str3);
            statisticItem.addParam("fname", str4);
            JSONObject f = f(str2);
            if (f != null) {
                if (f.optBoolean("is_yy_game")) {
                    str5 = "3";
                } else {
                    str5 = "2";
                }
                statisticItem.param("obj_param1", str5).param(TiebaStatic.Params.OBJ_PARAM2, f.optString(TiebaStatic.YYParams.YYLIVEID)).param("liveid", f.optString("liveid")).param("hdid", TbadkCoreApplication.getInst().getHdid()).param(TiebaStatic.YYParams.YYSID, f.optString(TiebaStatic.YYParams.YYSID)).param(TiebaStatic.YYParams.YYSSID, f.optString(TiebaStatic.YYParams.YYSSID)).param("yyuid", f.optString("yyuid")).param("template_id", f.optString("template_id")).param(TiebaStatic.YYParams.YYLIVEID, f.optString(TiebaStatic.YYParams.YYLIVEID)).param("vid", f.optString("vid"));
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void l(LiveFuseForumData liveFuseForumData, int i, String str, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{liveFuseForumData, Integer.valueOf(i), str, Boolean.valueOf(z), str2, str3}) == null) {
            StatisticItem param = new StatisticItem("c14702").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", e(i, liveFuseForumData)).param("fid", str2).param("obj_param1", !z ? 1 : 0);
            if (ListUtils.getCount(liveFuseForumData.title) > 0) {
                param.param("obj_name", (String) ListUtils.getItem(liveFuseForumData.title, 0));
            }
            if (!str.isEmpty()) {
                param.param(TiebaStatic.Params.OBJ_TO, str);
            }
            param.eventStat();
            String str4 = liveFuseForumData.schema;
            if (str4 != null && str4.startsWith("bdtiebalive")) {
                k("c14709", liveFuseForumData.yyext, str2, str3);
            }
        }
    }
}
