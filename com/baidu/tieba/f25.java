package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.tieba.interest.InterestPanelShowManager;
import com.baidu.tieba.interest.data.RecentClientInfo;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewGodData A;
    public w05 B;
    public c05 C;
    public u05 D;
    public v05 E;
    public j05 F;
    public UserGrowthTaskListData G;
    public VersionData a;
    public o05 b;
    public p05 c;
    public String d;
    public CombineDownload e;
    public b15 f;
    public p15 g;
    public d05 h;
    public yz4 i;
    public a05 j;
    public t05 k;
    public final xz4 l;
    public d15 m;
    public int n;
    public int o;
    public int p;
    public int q;
    public q05 r;
    public wz4 s;
    public ABTestExtraData t;
    public JSONArray u;
    public JSONArray v;
    public JSONArray w;
    public JSONObject x;
    public YYLiveConfig y;
    public r79 z;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f25 f25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e95.d().g();
            }
        }
    }

    public f25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.a = new VersionData();
        this.b = new o05();
        this.c = new p05();
        this.e = new CombineDownload();
        this.f = new b15();
        this.g = new p15();
        this.r = new q05();
        this.h = new d05();
        this.i = new yz4();
        this.l = new xz4();
        this.s = new wz4();
        this.m = new d15();
        this.t = new ABTestExtraData();
        this.A = new NewGodData();
        this.B = new w05();
        this.j = new a05();
        this.k = new t05();
        this.C = new c05();
        this.D = new u05();
        this.E = new v05();
        this.F = new j05();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                B(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void B(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            TbSingleton.getInstance().setVoiceRoomConfig(n15.b(jSONObject));
            TbSingleton.getInstance().setUpgradePopWindowConfig(j15.j(jSONObject));
            TbSingleton.getInstance().setPushStrategyConfig(e15.e(jSONObject));
            TbSingleton.getInstance().setHomePageLuckyConfig(t35.j(jSONObject));
            this.B.a(y(jSONObject, "index_tab_info"));
            this.a.parserJson(jSONObject.optJSONObject("version"));
            this.b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            rh.g(jSONObject.optString("client_ip", null));
            this.c.f(jSONObject.optJSONObject("config"));
            this.g.e0(jSONObject.optJSONObject("wl_config"));
            TbSingleton.getInstance().setWlConfigData(this.g);
            jSONObject.optJSONObject("channel_icon_config");
            this.j.c(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            this.k.d(jSONObject.optJSONObject("home_screen_ad"));
            TbSingleton.getInstance().setHomeInsertAdData(this.k);
            this.E.c(jSONObject.optJSONObject("https_switch_strategy_info"));
            TbadkCoreApplication.getInst().setHttpsWhileData(this.E);
            s35 s35Var = new s35();
            s35Var.d(jSONObject);
            if (s35Var.c()) {
                TbSingleton.getInstance().setHomeOperateData(s35Var);
            }
            String optString = jSONObject.optString("new_god_data", "");
            if (!StringUtils.isNull(optString)) {
                this.A.parserJson(optString);
            }
            this.r.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.r);
            this.d = jSONObject.optString("config_version");
            this.o = jSONObject.optInt("is_uninterest");
            this.p = jSONObject.optInt("first_time_motivate");
            this.q = jSONObject.optInt("needNewUserLead");
            this.e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f.a(jSONObject.optJSONObject("mainbar"));
            jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
            this.n = jSONObject.optInt("faceshop_version");
            if (this.n > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                TbadkCoreApplication.getInst().setTempFaceShopVersion(this.n);
                TbadkCoreApplication.getInst().setFaceShopNew(true);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("lcs_strategy");
            if (optJSONObject2 != null) {
                TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject2.toString());
            }
            new d25().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            e05.c(jSONObject.optJSONArray("scheme_whitelist"));
            UrlSchemaJumpHelper.setBlackList(y(jSONObject, UrlSchemaJumpHelper.KEY_APP_JUMP_BLACK_LIST));
            this.h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.g(jSONObject.optJSONObject("ad_adsense"));
            h25.d(jSONObject.optJSONObject("video_report_config"));
            this.l.b(jSONObject.optJSONObject("activity_switch"));
            this.s.b(z(jSONObject, "abtest_config"));
            this.t.parseJson(z(jSONObject, "new_abtest_entra"));
            this.u = y(jSONObject, "new_abtest_config");
            this.v = y(jSONObject, UbsABTestDataManager.PREF_KEY_SWITCHS);
            y(jSONObject, "outside_callback_icon");
            this.w = jSONObject.optJSONArray("windowStrategyList");
            this.x = z(jSONObject, "bear_sdk_config");
            if (z(jSONObject, "advertisement_config") != null) {
                this.C.d(z(jSONObject, "advertisement_config"));
            }
            YYLiveConfig yYLiveConfig = new YYLiveConfig();
            this.y = yYLiveConfig;
            yYLiveConfig.parseJson(z(jSONObject, "yy_live_config"));
            r79 r79Var = new r79();
            this.z = r79Var;
            r79Var.b(y(jSONObject, "yy_live_tab"));
            gq4.b().f(this.w);
            this.m.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            bx4.k().u("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray y = y(jSONObject, "offpack");
            if (y != null && y.length() > 0 && (jSONObject2 = y.getJSONObject(0)) != null) {
                nc8 nc8Var = new nc8();
                nc8Var.e(jSONObject2.optString("mod_name"));
                nc8Var.f(jSONObject2.optInt("upload_offline_web_cache") == 1);
                nc8Var.d(jSONObject2.optInt("clear_offline_web_cache") == 1);
                if (!TextUtils.isEmpty(nc8Var.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(nc8Var);
                }
            }
            String optString2 = jSONObject.optString("proxy_ip");
            String optString3 = jSONObject.optString("proxy_port");
            TbadkCoreApplication.getInst().setProxyIp(optString2);
            TbadkCoreApplication.getInst().setProxyPort(optString3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_priority", jSONObject.optString("ad_sdk_priority", null));
            jSONObject3.put("12_20_0_screen_fill_Ad_experiment", jSONObject.optString("12_20_0_screen_fill_Ad_experiment", null));
            jSONObject3.put("ad_origin_config_switch", jSONObject.optString("ad_origin_config_switch", null));
            jSONObject3.put("bear_sid_type", jSONObject.optString("bear_sid_type", null));
            jSONObject3.put("screen_fill_data_result", jSONObject.optJSONObject("screen_fill_data_result"));
            int optInt = jSONObject.optInt("ad_num_competition_frs", 5);
            int optInt2 = jSONObject.optInt("ad_num_competition_personalize", 2);
            bx4.k().w("key_mix_frs_ad_count", optInt);
            bx4.k().w("key_mix_home_page_ad_count", optInt2);
            MessageManager.getInstance().runTask(2016552, null, jSONObject3);
            TbSingleton.getInstance().setSyncYYSwitch(jSONObject.optInt("is_yy_user", 1) == 1);
            JSONObject optJSONObject3 = jSONObject.optJSONObject(LowFlowsActivityConfig.LF_USER_INFO);
            if (optJSONObject3 != null) {
                String optString4 = optJSONObject3.optString(LowFlowsActivityConfig.LF_USER);
                TbSingleton.getInstance().setLFUser(optString4);
                if (!StringUtils.isNull(optString4) && "2".equals(optString4)) {
                    TbSingleton.getInstance().setLFUserTaskId(optJSONObject3.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                    TbSingleton.getInstance().setBannerText(optJSONObject3.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
                }
            }
            bx4.k().w("key_personalized_rec_switch", jSONObject.optInt("personalized_rec_switch"));
            JSONObject z = z(jSONObject, "homepage_interest_config");
            if (z != null && this.D != null) {
                this.D.e(z);
                TbSingleton.getInstance().setHomepageInterestConfig(this.D);
            }
            xe7 xe7Var = new xe7();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("recent_client_info");
            if (optJSONObject4 != null) {
                xe7Var.d(RecentClientInfo.parseJson(optJSONObject4));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("new_user_interest_board_config");
            if (optJSONObject5 != null) {
                xe7Var.c(ve7.e(optJSONObject5));
            }
            InterestPanelShowManager.a().c(xe7Var);
            JSONObject optJSONObject6 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject6 != null) {
                e95.d().h(optJSONObject6);
                gh.a().post(new a(this));
            }
            bx4.k().w("key_work_video_guide_pop", jSONObject.optInt("videoup_guide_pop", -1));
            TbSingleton.getInstance().setVideoEventsConfig(m15.e(jSONObject));
            bx4.k().y("key_sync_extra_field", jSONObject.optString("extra"));
            int optInt3 = jSONObject.optInt("icon_task_flag");
            TbSingleton.getInstance().showStampMissionDialog = optInt3 == 1;
            sf8.d().h(jSONObject.optInt("afSearch_tab", 0) == 1);
            TbSingleton.getInstance().setIsNeedRemindLiveRoom(jSONObject.optInt("is_need_remind_live_rooms") == 1);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("search_guide");
            yt7.b().a();
            if (optJSONObject7 != null && (optJSONObject = optJSONObject7.optJSONObject("pb")) != null) {
                boolean z2 = optJSONObject.optInt("is_show", 0) == 1;
                int optInt4 = optJSONObject.optInt("pos", -1);
                av7 av7Var = new av7();
                av7Var.a = z2;
                av7Var.b = optInt4;
                yt7.b().d(av7Var);
            }
            t45.g().a(AgreeMaterial.B(jSONObject.optJSONObject("agree_material")));
            JSONObject optJSONObject8 = jSONObject.optJSONObject("live_activity_guide");
            if (optJSONObject8 != null) {
                v35 v35Var = new v35();
                v35Var.f(optJSONObject8);
                TbSingleton.getInstance().mLiveActivityGuide = v35Var;
            } else {
                TbSingleton.getInstance().mLiveActivityGuide = null;
            }
            this.F.h(jSONObject.optJSONObject("bear_sid_config"));
            C();
            TbSingleton.getInstance().setColourHeaderConfig(p35.r(jSONObject));
            lo5.e().k(jSONObject.optJSONObject("member_guide"));
            lo5.e().j(jSONObject.optJSONObject("close_ad_tips"));
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) new Gson().fromJson(jSONObject.optString("user_growth_task_list"), (Class<Object>) UserGrowthTaskListData.class);
            TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            HotEventData.getInstance().parsJson(jSONObject.optJSONObject("thread_recommend_info"));
            this.G = userGrowthTaskListData;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.F == null) {
            return;
        }
        bx4.k().y("key_server_splash_bear_sid", this.F.f());
        bx4.k().y("key_server_homepage_bear_sid", this.F.b());
        bx4.k().y("key_server_frs_bear_sid", this.F.a());
        bx4.k().y("key_server_pb_banner_bear_sid", this.F.c());
        bx4.k().y("key_server_pb_comment_bear_sid", this.F.d());
        bx4.k().y("key_server_picpage_bear_sid", this.F.e());
        bx4.k().y("key_server_videoflow_bear_sid", this.F.g());
    }

    public wz4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : (wz4) invokeV.objValue;
    }

    public ABTestExtraData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : (ABTestExtraData) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : (JSONArray) invokeV.objValue;
    }

    public xz4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (xz4) invokeV.objValue;
    }

    public yz4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : (yz4) invokeV.objValue;
    }

    public a05 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (a05) invokeV.objValue;
    }

    public c05 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.C : (c05) invokeV.objValue;
    }

    public d05 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (d05) invokeV.objValue;
    }

    public o05 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (o05) invokeV.objValue;
    }

    public CombineDownload j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : (CombineDownload) invokeV.objValue;
    }

    public p05 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.c : (p05) invokeV.objValue;
    }

    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.x : (JSONObject) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p == 1 : invokeV.booleanValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.q : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o : invokeV.intValue;
    }

    public NewGodData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.A : (NewGodData) invokeV.objValue;
    }

    public d15 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.m : (d15) invokeV.objValue;
    }

    public JSONArray r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.v : (JSONArray) invokeV.objValue;
    }

    public UserGrowthTaskListData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.G : (UserGrowthTaskListData) invokeV.objValue;
    }

    public VersionData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a : (VersionData) invokeV.objValue;
    }

    public p15 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.g : (p15) invokeV.objValue;
    }

    public YYLiveConfig v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.y : (YYLiveConfig) invokeV.objValue;
    }

    public r79 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.z : (r79) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public final JSONArray y(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public final JSONObject z(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }
}
