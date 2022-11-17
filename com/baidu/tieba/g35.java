package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public boolean B;
    public long C;
    public ActivityPrizeData D;
    public t25 E;
    public int F;
    public int G;
    public int H;
    public String I;
    public int J;
    public String K;
    public long L;
    public long M;
    public boolean N;
    public x25 O;
    public String P;
    public boolean Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public int V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public int a;
    public String a0;
    public int b;
    public String b0;
    public String c;
    public String c0;
    public String d;
    public String d0;
    public String e;
    public int e0;
    public String f;
    public HashMap<Long, String> f0;
    public String g;
    public String g0;
    public String h;
    public String h0;
    public String i;
    public int i0;
    public String j;
    public final VideoPreloadData j0;
    public long k;
    public int k0;
    public int l;
    public n25 l0;
    public long m;
    public int m0;
    public int n;
    public int n0;
    public int o;
    public int o0;
    public int p;
    public int p0;
    public String q;
    public int q0;
    public String r;
    public int r0;
    public String s;
    public int s0;
    public int t;
    public String t0;
    public int u;
    public String v;
    public String w;
    public String x;
    public int y;
    public int z;

    public g35() {
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
        this.p = 0;
        this.t = 2;
        this.v = "";
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.J = 0;
        this.N = false;
        this.f0 = new HashMap<>();
        this.j0 = new VideoPreloadData();
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.T;
        }
        return (String) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.S;
        }
        return (String) invokeV.objValue;
    }

    public t25 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.E;
        }
        return (t25) invokeV.objValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.A;
        }
        return invokeV.longValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.z;
        }
        return invokeV.intValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h0;
        }
        return (String) invokeV.objValue;
    }

    public x25 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.O;
        }
        return (x25) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.P;
        }
        return (String) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.r0;
        }
        return invokeV.intValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.q0;
        }
        return invokeV.intValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.o0;
        }
        return invokeV.intValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.n0;
        }
        return invokeV.intValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.p0;
        }
        return invokeV.intValue;
    }

    public long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.k;
        }
        return invokeV.longValue;
    }

    public VideoPreloadData Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j0;
        }
        return (VideoPreloadData) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.N;
        }
        return invokeV.booleanValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.i0;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.G;
        }
        return invokeV.intValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.g0;
        }
        return (String) invokeV.objValue;
    }

    public ActivityPrizeData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.D;
        }
        return (ActivityPrizeData) invokeV.objValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.m0;
        }
        return invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.t0;
        }
        return (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.Q;
        }
        return invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.s0;
        }
        return invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.C;
        }
        return invokeV.longValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.L;
        }
        return invokeV.longValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.M;
        }
        return invokeV.longValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public n25 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.l0;
        }
        return (n25) invokeV.objValue;
    }

    public HashMap<Long, String> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.f0;
        }
        return (HashMap) invokeV.objValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.t == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public void f0(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("Android_perf_fps_duration");
            this.b = jSONObject.optInt("Android_start_stat_instant_upload");
            TbSingleton tbSingleton = TbSingleton.getInstance();
            if (this.b == 1) {
                z = true;
            } else {
                z = false;
            }
            tbSingleton.isStartStatUploadImmediately = z;
            this.c = jSONObject.optString("drop_pic");
            this.d = jSONObject.optString("drop_pic_md5");
            this.e = jSONObject.optString("drop_pic_num");
            this.f = jSONObject.optString("drop_bg_color_day");
            this.g = jSONObject.optString("drop_bg_color_night");
            this.h = jSONObject.optString("apply_vip_live_room_pid");
            this.q = jSONObject.optString("max_cache");
            this.r = jSONObject.optString("frs_max_cache");
            this.s = jSONObject.optString("frs_pn");
            this.i = jSONObject.optString("tail_link");
            this.j = jSONObject.optString("bubble_link");
            this.k = jSONObject.optLong("use_duration");
            jSONObject.optInt("xiaoying_time");
            jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            jSONObject.optString("url_analyze_text");
            this.l = jSONObject.optInt("new_resign", 0);
            this.m = jSONObject.optLong("personalized_cache_seconds", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT);
            this.n = jSONObject.optInt("personalized_max_count", 300);
            this.o = jSONObject.optInt("index_preload_not_see_thread_num", 3);
            jSONObject.optString("info_icon_url");
            jSONObject.optLong("info_time_stamp", 0L);
            jSONObject.optString("info_target_url");
            this.t = jSONObject.optInt("localvideo_open", 2);
            this.u = jSONObject.optInt("card_show_statistic", 200);
            this.v = jSONObject.optString("clean_smart_frs_cookie");
            he5.b().h(jSONObject.optInt("statlog_path_max", 3));
            this.p = jSONObject.optInt("photo_cache_num", 60);
            this.w = jSONObject.optString("ueg_voice_warning");
            this.x = jSONObject.optString("nickname_activity_link");
            this.y = jSONObject.optInt("android_tab_show", 55);
            this.z = jSONObject.optInt("ribao_switch", 0);
            this.A = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.C = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            if (jSONObject.optInt("android_pasteboard_delaytime", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.B = z2;
            this.j0.parserJson(jSONObject.optString("ios_video_preload_config"));
            qy4.k().u("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.B);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                ActivityPrizeData activityPrizeData = new ActivityPrizeData();
                this.D = activityPrizeData;
                activityPrizeData.parse(optJSONObject);
                qy4 k = qy4.k();
                k.y("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("interest_board_config");
            if (optJSONObject2 != null) {
                n25 n25Var = new n25();
                this.l0 = n25Var;
                n25Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject3 != null) {
                t25 t25Var = new t25();
                this.E = t25Var;
                t25Var.a(optJSONObject3);
            }
            dc7.f(jSONObject.optInt("android_max_stranger"));
            TiebaPlusConfigData tiebaPlusConfigData = new TiebaPlusConfigData();
            if (jSONObject.optInt("switch_open") == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            tiebaPlusConfigData.setSwitchOpen(z3);
            tiebaPlusConfigData.setJumpUrl(jSONObject.optString("tiebaplus_jumpurl"));
            TbSingleton.getInstance().setTiebaPlusConfigData(tiebaPlusConfigData);
            this.F = jSONObject.optInt("style_ab_switch", 0);
            this.G = jSONObject.optInt("abstract_ab_switch", 0);
            this.s0 = jSONObject.optInt("android_baiduid_forward_switch", 0);
            this.H = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.I = optString;
            if (!xi.isEmpty(optString)) {
                qy4.k().y("key_baidu_password_re", this.I);
            }
            String optString2 = jSONObject.optString("redpacket_pop", "");
            this.K = optString2;
            if (!xi.isEmpty(optString2)) {
                qy4.k().y("key_redpacket_pop", this.K);
            }
            this.J = jSONObject.optInt("android_show_ba_concern", 0);
            qy4.k().w("key_concern_tab_tips_switch", this.J);
            this.L = jSONObject.optInt("dialog_pull_time", 60) * StringHelper.MS_TO_MIN;
            this.M = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            if (jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.N = z4;
            String optString3 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString3)) {
                if (this.O == null) {
                    this.O = new x25();
                }
                this.O.parserJson(optString3);
                qy4.k().y("shake_data", optString3);
            }
            this.P = jSONObject.optString("share_panel_text", "");
            qy4.k().w("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 0);
            if (optInt == 0) {
                this.Q = false;
            } else if (optInt == 1) {
                this.Q = true;
            }
            qy4.k().u("audit_package_switch", this.Q);
            this.R = jSONObject.optString("profile_swan_app_key");
            qy4.k().y("profile_swan_app_key", this.R);
            this.S = jSONObject.optString("android_mission_system_entrance_url");
            qy4.k().y("index_activity_abtest_url", this.S);
            this.T = jSONObject.optString("android_mission_system_entrance_icon");
            qy4.k().y("index_activity_abtest_icon_url", this.T);
            this.U = jSONObject.optString("obj_source");
            qy4.k().y("index_activity_abtest_obj_source", this.U);
            this.g0 = jSONObject.optString("namoaixud_sign_link");
            this.V = jSONObject.optInt("home_page_style_ab_test", 0);
            qy4.k().w("index_activity_abtest_switch_json", this.V);
            this.h0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            qy4.k().y("key_ubs_sample_id", this.h0);
            tb5.h("multi_process_sample_id", this.h0);
            o25.c(jSONObject.optString("js_whitelist"));
            zd5.f().j(jSONObject.optString("stat_keys_list"));
            this.W = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            qy4.k().y("ala_game_frs_live_tab_video_url", this.W);
            this.X = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            qy4.k().y("ala_personal_income_detail_url", this.X);
            this.Y = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            qy4.k().y("ala_personal_privilege_detail_url", this.Y);
            this.Z = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            qy4.k().y("ala_personal_exp_detail_url", this.Z);
            String optString4 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString4)) {
                JSONObject jSONObject2 = new JSONObject(optString4);
                this.a0 = jSONObject2.optString("go_url", TbConfig.TIEBA_ADDRESS + "f?kw=百度直播");
                qy4.k().y("show_live_forum_url", this.a0);
                this.b0 = jSONObject2.optString("forum_name", "百度直播");
                qy4.k().y("show_live_forum_name", this.b0);
            }
            String optString5 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString5)) {
                JSONObject jSONObject3 = new JSONObject(optString5);
                this.c0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                this.d0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                qy4.k().y("ala_my_live_privilege_mark_detail_url", this.c0);
                qy4.k().y("ala_my_live_privilege_effect_detail_url", this.d0);
            }
            String optString6 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString6)) {
                this.e0 = new JSONObject(optString6).optInt("ucenter_display");
                qy4.k().w("baidu_financial_display", this.e0);
            }
            String optString7 = jSONObject.optString("live_bar");
            g0(optString7);
            qy4.k().y("ala_live_bar_map_str", optString7);
            qy4.k().w("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
            qy4.k().w("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            qy4.k().w("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            if (jSONObject.optInt("is_vivo_test_uid") == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            qy4.k().u("key_show_vivo_badge", z5);
            this.i0 = jSONObject.optInt("video_red_icon_interval");
            new n15().n(jSONObject);
            y25 y25Var = new y25();
            y25Var.e(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(y25Var);
            String optString8 = jSONObject.optString("BackMechanism_sid1");
            String optString9 = jSONObject.optString("BackMechanism_sid2");
            qy4.k().y("key_pb_back_sid1", optString8);
            qy4.k().y("key_pb_back_sid2", optString9);
            this.k0 = jSONObject.optInt("video_works_progress_bar_waiting_time");
            qy4.k().w("key_video_works_progress_bar_waiting_time", this.k0);
            this.m0 = jSONObject.optInt("works_add_topic_max_num");
            this.n0 = jSONObject.optInt("thread_image_width_limit");
            this.o0 = jSONObject.optInt("thread_image_height_limit");
            this.p0 = jSONObject.optInt("image_upload_concurrency");
            this.q0 = jSONObject.optInt("image_chunk_size");
            this.r0 = jSONObject.optInt("image_upload_retry");
            int optInt2 = jSONObject.optInt("launch_protect_onelevel_limit");
            if (optInt2 > 0) {
                qy4.k().w("key_first_level_safe_mode_continuous_crash_time", optInt2);
            }
            int optInt3 = jSONObject.optInt("launch_protect_twolevel_limit");
            if (optInt3 > 0) {
                qy4.k().w("key_second_level_safe_mode_continuous_crash_time", optInt3);
            }
            qy4.k().y("key_sync_task_switch", jSONObject.optString("android_sync_task_switch"));
            int optInt4 = jSONObject.optInt("video_ad_play_flag", 0);
            if (optInt4 == 1 || optInt4 == 2 || optInt4 == 3) {
                qy4.k().w("auto_play_video_switch", optInt4);
            }
            TbSingleton.getInstance().mAdFloatTipsAppLimitCount = jSONObject.optInt("app_install_tip_num", 2);
            TbSingleton.getInstance().mAdFloatTipsDayLimitCount = jSONObject.optInt("daily_install_tip_num", 1);
            lr5.h().o(jSONObject.optJSONObject("motivational_video_guide"));
            this.t0 = jSONObject.optString("world_cup_sponsor_flag");
            qy4.k().y("world_cup_sponsor_flag", this.t0);
            String optString10 = jSONObject.optString("ios_lite_mode_info");
            if (!StringUtils.isNull(optString10)) {
                int optInt5 = new JSONObject(optString10).optInt("themeIsBlack", 0);
                n9 g = n9.g();
                if (optInt5 == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                g.r(z6);
                WindowGreySwitch.setNewValue(optInt5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = qy4.k().q("ala_live_bar_map_str", "");
                if (StringUtils.isNull(str)) {
                    return;
                }
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("id", 0L);
                        this.f0.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                    }
                }
            }
        }
    }
}
