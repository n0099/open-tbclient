package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.BdToken.BdTokenController;
import com.baidu.tbadk.RobotMallConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogDataManager;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.data.JSONLikeSerializable;
import com.baidu.tbadk.data.LightEmotionData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class af5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public YYLiveConfig A;
    public a9b B;
    public NewGodData C;
    public jd5 D;
    public nc5 E;
    public uc5 F;
    public UserGrowthTaskListData G;
    public ArrayList<LightEmotionData> H;
    public VersionData a;
    public ad5 b;
    public cd5 c;
    public String d;
    public CombineDownload e;
    public od5 f;
    public ee5 g;
    public oc5 h;
    public jc5 i;
    public lc5 j;
    public hd5 k;
    public final ic5 l;
    public sd5 m;
    public id5 n;
    public bd5 o;
    public int p;
    public int q;
    public int r;
    public int s;
    public dd5 t;
    public hc5 u;
    public ABTestExtraData v;
    public JSONArray w;
    public JSONArray x;
    public JSONArray y;
    public JSONObject z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(af5 af5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af5Var};
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
                MainTabBottomDynamicIconManager.getInstance().loadImages();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;

        public b(af5 af5Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af5Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("WebPreheat", "sync返回预热H5:" + this.a);
                zy5.e(this.a);
            }
        }
    }

    public af5() {
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
        this.q = 0;
        this.a = new VersionData();
        this.b = new ad5();
        this.c = new cd5();
        this.e = new CombineDownload();
        this.f = new od5();
        this.g = new ee5();
        this.o = new bd5();
        this.t = new dd5();
        this.h = new oc5();
        this.i = new jc5();
        this.l = new ic5();
        this.u = new hc5();
        this.m = new sd5();
        this.n = new id5();
        this.v = new ABTestExtraData();
        this.C = new NewGodData();
        this.D = new jd5();
        this.j = new lc5();
        this.k = new hd5();
        this.E = new nc5();
        this.F = new uc5();
        this.H = new ArrayList<>();
    }

    public final JSONArray A(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public final JSONObject B(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                D(new JSONObject(str));
            } catch (Exception e) {
                TbLog a2 = dk.a();
                a2.e(Config.DEVICE_PART, "sync exception1: " + e.getMessage());
                BdLog.e(e.getMessage());
            }
        }
    }

    public void D(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        JSONObject jSONObject2;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            TbSingleton.getInstance().setSyncJson(jSONObject);
            YunDialogDataManager.j().o(jSONObject.optJSONArray("h5_pop_ups"));
            JSONObject optJSONObject = jSONObject.optJSONObject("h5_pop_ups_config");
            if (optJSONObject != null) {
                YunDialogDataManager.j().p(optJSONObject);
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                YunDialogManager.onShow(currentActivity, t55.c);
            }
            BdTokenController.E().M(jSONObject);
            TbSingleton.getInstance().setVoiceRoomConfig(ce5.a(jSONObject));
            TbSingleton.getInstance().setUpgradePopWindowConfig(yd5.j(jSONObject));
            TbSingleton.getInstance().setPushStrategyConfig(td5.e(jSONObject));
            TbSingleton.getInstance().setMainTabPopConfig(pd5.c(jSONObject));
            TbSingleton.getInstance().setRotMallConfig(RobotMallConfig.parseJson(jSONObject));
            this.D.a(A(jSONObject, "index_tab_info"));
            this.a.parserJson(jSONObject.optJSONObject("version"));
            this.b.b(jSONObject.optJSONObject(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            rg.g(jSONObject.optString("client_ip", null));
            this.c.f(jSONObject.optJSONObject("config"));
            this.g.f0(jSONObject.optJSONObject("wl_config"));
            TbSingleton.getInstance().setWlConfigData(this.g);
            this.o.b(jSONObject.optJSONObject("common_scheme"));
            jSONObject.optJSONObject("channel_icon_config");
            this.j.c(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            this.k.d(jSONObject.optJSONObject("home_screen_ad"));
            TbSingleton.getInstance().setHomeInsertAdData(this.k);
            lh5 lh5Var = new lh5();
            lh5Var.d(jSONObject);
            if (lh5Var.c()) {
                TbSingleton.getInstance().setHomeOperateData(lh5Var);
            }
            String optString = jSONObject.optString("new_god_data", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("new_god_data");
            boolean z8 = true;
            if (!StringUtils.isNull(optString) && optJSONObject2 != null) {
                optJSONObject2.put("portrait", o05.t().r());
                TbSingleton.getInstance().setNewGodDataJson(optJSONObject2);
                if (optJSONObject2.optInt("need_show_toast_bubble") == 1) {
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_new_god_pop_is_show"), true);
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_new_god_tip_is_show"), true);
                }
                this.C.parserJson(optString);
            }
            this.t.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.t);
            this.d = jSONObject.optString("config_version");
            this.q = jSONObject.optInt("is_uninterest");
            this.r = jSONObject.optInt("first_time_motivate");
            this.s = jSONObject.optInt("needNewUserLead");
            this.e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f.a(jSONObject.optJSONObject("mainbar"));
            jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
            this.p = jSONObject.optInt("faceshop_version");
            if (this.p > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                TbadkCoreApplication.getInst().setTempFaceShopVersion(this.p);
                TbadkCoreApplication.getInst().setFaceShopNew(true);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
            if (optJSONObject3 != null) {
                TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject3.toString());
            }
            new ye5().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            pc5.c(jSONObject.optJSONArray("scheme_whitelist"));
            UrlSchemaJumpHelper.setBlackList(A(jSONObject, UrlSchemaJumpHelper.KEY_APP_JUMP_BLACK_LIST));
            this.h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.g(jSONObject.optJSONObject("ad_adsense"));
            df5.d(jSONObject.optJSONObject("video_report_config"));
            this.l.b(jSONObject.optJSONObject("activity_switch"));
            this.u.b(B(jSONObject, "abtest_config"));
            this.v.parseJson(B(jSONObject, "new_abtest_entra"));
            this.w = A(jSONObject, "new_abtest_config");
            this.x = A(jSONObject, UbsABTestDataManager.PREF_KEY_SWITCHS);
            A(jSONObject, "outside_callback_icon");
            this.y = jSONObject.optJSONArray("windowStrategyList");
            this.z = B(jSONObject, "bear_sdk_config");
            if (B(jSONObject, "advertisement_config") != null) {
                this.E.d(B(jSONObject, "advertisement_config"));
            }
            YYLiveConfig yYLiveConfig = new YYLiveConfig();
            this.A = yYLiveConfig;
            yYLiveConfig.parseJson(B(jSONObject, "yy_live_config"));
            a9b a9bVar = new a9b();
            this.B = a9bVar;
            a9bVar.b(A(jSONObject, "yy_live_tab"));
            this.n.c(jSONObject.optJSONObject("hot_notify_config"));
            TbSingleton.getInstance().setHotNotifyConfig(this.n);
            w05.b().f(this.y);
            this.m.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton tbSingleton = TbSingleton.getInstance();
            if (jSONObject.optInt("recommend_userstatus", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            tbSingleton.setNewUser(z);
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            if (jSONObject.optInt("ala_channel_white", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            sharedPrefHelper.putBoolean("key_live_forum_enter_switch", z2);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray A = A(jSONObject, "offpack");
            if (A != null && A.length() > 0 && (jSONObject2 = A.getJSONObject(0)) != null) {
                j2a j2aVar = new j2a();
                j2aVar.e(jSONObject2.optString("mod_name"));
                if (jSONObject2.optInt("upload_offline_web_cache") == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                j2aVar.f(z6);
                if (jSONObject2.optInt("clear_offline_web_cache") == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                j2aVar.d(z7);
                if (!TextUtils.isEmpty(j2aVar.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(j2aVar);
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
            SharedPrefHelper.getInstance().putInt("key_mix_frs_ad_count", optInt);
            SharedPrefHelper.getInstance().putInt("key_mix_home_page_ad_count", optInt2);
            MessageManager.getInstance().runTask(2016552, null, jSONObject3);
            TbSingleton tbSingleton2 = TbSingleton.getInstance();
            if (jSONObject.optInt("is_yy_user", 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            tbSingleton2.setSyncYYSwitch(z3);
            JSONObject optJSONObject4 = jSONObject.optJSONObject(LowFlowsActivityConfig.LF_USER_INFO);
            if (optJSONObject4 != null) {
                String optString4 = optJSONObject4.optString(LowFlowsActivityConfig.LF_USER);
                TbSingleton.getInstance().setLFUser(optString4);
                if (!StringUtils.isNull(optString4) && "2".equals(optString4)) {
                    TbSingleton.getInstance().setLFUserTaskId(optJSONObject4.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                    TbSingleton.getInstance().setBannerText(optJSONObject4.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
                }
            }
            SharedPrefHelper.getInstance().putInt("key_personalized_rec_switch", jSONObject.optInt("personalized_rec_switch"));
            JSONObject optJSONObject5 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject5 != null) {
                MainTabBottomDynamicIconManager.getInstance().parseJson(optJSONObject5);
                SafeHandler.getInst().post(new a(this));
            }
            SharedPrefHelper.getInstance().putInt("key_work_video_guide_pop", jSONObject.optInt("videoup_guide_pop", -1));
            TbSingleton.getInstance().setVideoEventsConfig(be5.d(jSONObject));
            SharedPrefHelper.getInstance().putString("key_sync_extra_field", jSONObject.optString("extra"));
            int optInt3 = jSONObject.optInt("icon_task_flag");
            TbSingleton tbSingleton3 = TbSingleton.getInstance();
            if (optInt3 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            tbSingleton3.showStampMissionDialog = z4;
            int optInt4 = jSONObject.optInt("afSearch_tab", 0);
            a8a d = a8a.d();
            if (optInt4 == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            d.h(z5);
            int optInt5 = jSONObject.optInt("is_need_remind_live_rooms");
            TbSingleton tbSingleton4 = TbSingleton.getInstance();
            if (optInt5 != 1) {
                z8 = false;
            }
            tbSingleton4.setIsNeedRemindLiveRoom(z8);
            ri5.g().a(AgreeMaterial.O(jSONObject.optJSONObject("agree_material")));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity_guide");
            if (optJSONObject6 != null) {
                nh5 nh5Var = new nh5();
                nh5Var.f(optJSONObject6);
                TbSingleton.getInstance().mLiveActivityGuide = nh5Var;
            } else {
                TbSingleton.getInstance().mLiveActivityGuide = null;
            }
            zy5.c(jSONObject.optJSONArray("support_cache_url_list"));
            JSONArray optJSONArray = jSONObject.optJSONArray("cache_url_list");
            if (optJSONArray != null) {
                SharedPrefHelper.getInstance().putString("key_cache_url_list", optJSONArray.toString());
                SafeHandler.getInst().post(new b(this, optJSONArray));
            } else {
                SharedPrefHelper.getInstance().putString("key_cache_url_list", "");
            }
            this.F.h(jSONObject.optJSONObject("bear_sid_config"));
            E();
            JSONObject optJSONObject7 = jSONObject.optJSONObject("top_level_navi");
            if (optJSONObject7 != null) {
                SharedPrefHelper.getInstance().putString("key_home_color_header_config", optJSONObject7.toString());
            } else {
                SharedPrefHelper.getInstance().remove("key_home_color_header_config");
            }
            TbSingleton.getInstance().setColourHeaderConfig(gh5.s(optJSONObject7));
            u56.e().k(jSONObject.optJSONObject("member_guide"));
            u56.e().j(jSONObject.optJSONObject("close_ad_tips"));
            JSONArray optJSONArray2 = jSONObject.optJSONArray("interact_memes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    LightEmotionData lightEmotionData = new LightEmotionData();
                    lightEmotionData.parseJson(optJSONArray2.getJSONObject(i));
                    this.H.add(lightEmotionData);
                }
                TbSingleton.getInstance().setLightEmotionInfo(this.H);
                JSONLikeSerializable jSONLikeSerializable = new JSONLikeSerializable();
                jSONLikeSerializable.parseJsonArray(optJSONArray2);
                TbSingleton.getInstance().setLightEmotionJsonStr(jSONLikeSerializable);
            }
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) new Gson().fromJson(jSONObject.optString("user_growth_task_list"), (Class<Object>) UserGrowthTaskListData.class);
            TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            HotEventData.getInstance().parsJson(jSONObject.optJSONObject("thread_recommend_info"));
            this.G = userGrowthTaskListData;
            new hf5().b(jSONObject);
        } catch (Exception e) {
            TbLog a2 = dk.a();
            a2.e(Config.DEVICE_PART, "sync exception2: " + e.getMessage());
            BdLog.e(e.getMessage());
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.F != null) {
            SharedPrefHelper.getInstance().putString("key_server_splash_bear_sid", this.F.f());
            SharedPrefHelper.getInstance().putString("key_server_homepage_bear_sid", this.F.b());
            SharedPrefHelper.getInstance().putString("key_server_frs_bear_sid", this.F.a());
            SharedPrefHelper.getInstance().putString("key_server_pb_banner_bear_sid", this.F.c());
            SharedPrefHelper.getInstance().putString("key_server_pb_comment_bear_sid", this.F.d());
            SharedPrefHelper.getInstance().putString("key_server_picpage_bear_sid", this.F.e());
            SharedPrefHelper.getInstance().putString("key_server_videoflow_bear_sid", this.F.g());
        }
    }

    public hc5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.u;
        }
        return (hc5) invokeV.objValue;
    }

    public ABTestExtraData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.v;
        }
        return (ABTestExtraData) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.w;
        }
        return (JSONArray) invokeV.objValue;
    }

    public ic5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return (ic5) invokeV.objValue;
    }

    public jc5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return (jc5) invokeV.objValue;
    }

    public lc5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (lc5) invokeV.objValue;
    }

    public nc5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.E;
        }
        return (nc5) invokeV.objValue;
    }

    public oc5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return (oc5) invokeV.objValue;
    }

    public ad5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return (ad5) invokeV.objValue;
    }

    public CombineDownload j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return (CombineDownload) invokeV.objValue;
    }

    public bd5 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.o;
        }
        return (bd5) invokeV.objValue;
    }

    public cd5 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (cd5) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.z;
        }
        return (JSONObject) invokeV.objValue;
    }

    public id5 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (id5) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.r == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public NewGodData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.C;
        }
        return (NewGodData) invokeV.objValue;
    }

    public sd5 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.m;
        }
        return (sd5) invokeV.objValue;
    }

    public JSONArray t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.x;
        }
        return (JSONArray) invokeV.objValue;
    }

    public UserGrowthTaskListData u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.G;
        }
        return (UserGrowthTaskListData) invokeV.objValue;
    }

    public VersionData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.a;
        }
        return (VersionData) invokeV.objValue;
    }

    public ee5 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.g;
        }
        return (ee5) invokeV.objValue;
    }

    public YYLiveConfig x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.A;
        }
        return (YYLiveConfig) invokeV.objValue;
    }

    public a9b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.B;
        }
        return (a9b) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }
}
