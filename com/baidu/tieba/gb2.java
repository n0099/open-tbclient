package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.IntentConstants;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleData;
import com.baidu.tieba.nb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class gb2 extends fb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String G0;
    public String H0;
    public ForbiddenInfo I0;
    public int J0;
    public int K0;
    public String L0;
    public String M0;
    public String N0;
    public int O0;

    @Override // com.baidu.tieba.fb2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fb2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fb2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bj3 a;

            public a(bj3 bj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bj3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bj3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gi3.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, ww2 ww2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, ww2Var, forbiddenInfo) == null) {
                bj3 bj3Var = new bj3();
                bj3Var.f = forbiddenInfo.appId;
                bj3Var.g = "errormenu";
                bj3Var.b = "click";
                bj3Var.e = str;
                bj3Var.c = forbiddenInfo.launchSource;
                bj3Var.b(si3.k(ww2Var.W()));
                bj3Var.d(ww2Var.s0().getString("ubc"));
                to3.j(new a(bj3Var), "SwanAppFuncClickUBC");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb2 a;

        public a(gb2 gb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.c0) != null) {
                activity.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww2 a;
        public final /* synthetic */ gb2 b;

        public b(gb2 gb2Var, ww2 ww2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var, ww2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gb2Var;
            this.a = ww2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("property_web_mode_degrade", true);
                SwanLauncher.j().n(this.a, bundle);
                this.b.c0.finishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gb2 b;

        public c(gb2 gb2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gb2Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.I0 != null && !TextUtils.isEmpty(this.b.I0.forbiddenDetail)) {
                gv2.u().b(this.b.getActivity(), this.a, this.b.I0.appTitle, this.b.I0.forbiddenDetail);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww2 a;
        public final /* synthetic */ gb2 b;

        public d(gb2 gb2Var, ww2 ww2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var, ww2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gb2Var;
            this.a = ww2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.c0.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb2 a;

        public e(gb2 gb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.M0)) {
                Activity activity = this.a.c0;
                if (activity instanceof FragmentActivity) {
                    vp4 k = ((FragmentActivity) activity).k();
                    nb2.d d3 = nb2.d3(this.a.M0);
                    d3.a(false);
                    d3.c(k);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb2 a;

        public f(gb2 gb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity activity = this.a.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (!fb2.F0) {
                        return;
                    }
                    throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                }
                ((SwanAppClearCacheErrorActivity) activity).F();
                try {
                    this.a.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    z82.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb2 a;

        public g(gb2 gb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww2 a;
        public final /* synthetic */ gb2 b;

        public h(gb2 gb2Var, ww2 ww2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var, ww2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gb2Var;
            this.a = ww2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.c0.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ei4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ gb2 b;

        public i(gb2 gb2Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb2Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gb2Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.ei4
        public boolean b(View view2, hi4 hi4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, hi4Var)) == null) {
                int c = hi4Var.c();
                if (c != 5) {
                    if (c != 9) {
                        if (c != 39) {
                            if (c != 46) {
                                if (c == 47) {
                                    this.b.k3(hi4Var, this.a);
                                }
                            } else {
                                this.b.j3(hi4Var, this.a);
                            }
                        } else {
                            this.b.m3(this.a);
                        }
                    } else {
                        this.b.i3(this.a);
                        return true;
                    }
                } else {
                    this.b.l3(this.a);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public gb2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo == null) {
                return false;
            }
            return forbiddenInfo.enableSliding();
        }
        return invokeV.booleanValue;
    }

    public final ww2 b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() != null && (getActivity() instanceof SwanAppErrorActivity)) {
                return ((SwanAppErrorActivity) getActivity()).y();
            }
            return null;
        }
        return (ww2) invokeV.objValue;
    }

    public final boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> a2 = ho4.b().a();
            if (a2 != null && a2.contains(this.H0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null && tp3.I(forbiddenInfo.launchPath)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fb2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d3();
            p3();
            s3();
            q3();
        }
    }

    public final void p3() {
        gi4 gi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (gi4Var = this.g0) != null) {
            gi4Var.r(gv2.M().a());
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            j.a("menu", b3(), this.I0);
        }
    }

    public void i3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            gv2.K().h(activity, a3(activity));
            j.a("feedback", b3(), this.I0);
        }
    }

    @Override // com.baidu.tieba.fb2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            return Y2();
        }
        return invokeL.booleanValue;
    }

    public void l3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            p13.j(activity);
            j.a("daynightmode", b3(), this.I0);
        }
    }

    public void m3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                p13.t(activity);
            }
            j.a(Headers.REFRESH, b3(), this.I0);
        }
    }

    public static gb2 h3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            gb2 gb2Var = new gb2();
            Bundle bundle = new Bundle();
            bundle.putString("swan_error_type", str2);
            bundle.putString("swan_error_code", str);
            bundle.putString(DeepLinkItem.DEEPLINK_WEBURL_KEY, str3);
            bundle.putInt("webPermit", i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            gb2Var.k1(bundle);
            return gb2Var;
        }
        return (gb2) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.fb2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.W1(view2);
            X1(view2);
            v2(-1);
            E2(-16777216);
            z2(false);
            L2(true);
            this.f0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                x2(this.I0.appTitle);
            }
        }
    }

    public final CharSequence Z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = bo4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = bo4.m(g2, str2.substring(str2.length() - 4));
                    if (!TextUtils.isEmpty(m)) {
                        return m;
                    }
                }
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1242268664:
                    if (str.equals("type_need_update_sdk")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -429452284:
                    if (str.equals("type_path_forbidden")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 38398066:
                    if (str.equals("type_network_error")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str.equals("type_0049")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 517347882:
                    if (str.equals("type_2205")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 731215244:
                    if (str.equals("type_normal")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 != 4) {
                                if (c2 != 5) {
                                    return "";
                                }
                                String m2 = bo4.m(g2, "2205");
                                if (TextUtils.isEmpty(m2)) {
                                    return Y(R.string.obfuscated_res_0x7f0f14dc);
                                }
                                return m2;
                            }
                            String m3 = bo4.m(g2, "0049");
                            if (TextUtils.isEmpty(m3)) {
                                return Y(R.string.obfuscated_res_0x7f0f14de);
                            }
                            return m3;
                        }
                        String m4 = bo4.m(g2, "app_page_banned");
                        if (TextUtils.isEmpty(m4)) {
                            return Y(R.string.obfuscated_res_0x7f0f14dd);
                        }
                        return m4;
                    }
                    String m5 = bo4.m(g2, "app_need_upgrade");
                    if (TextUtils.isEmpty(m5)) {
                        return Y(R.string.obfuscated_res_0x7f0f14de);
                    }
                    return m5;
                }
                String m6 = bo4.m(g2, "app_open_failed");
                if (TextUtils.isEmpty(m6)) {
                    return Y(R.string.obfuscated_res_0x7f0f14de);
                }
                return m6;
            }
            String m7 = bo4.m(g2, "net_conn_failed");
            if (TextUtils.isEmpty(m7)) {
                return Y(R.string.obfuscated_res_0x7f0f14de);
            }
            return m7;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject a3(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ForbiddenInfo x = ((SwanAppErrorActivity) activity).x();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", x.appTitle);
                    jSONObject.put("url", x.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, x.appId);
                    jSONObject.put("errorPath", x.launchPath);
                    jSONObject.put("errorDes", x.forbiddenReason);
                } catch (JSONException e2) {
                    if (fb2.F0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.v0(bundle);
            Bundle o = o();
            if (o == null) {
                return;
            }
            this.G0 = o.getString("swan_error_type");
            this.H0 = o.getString("swan_error_code");
            this.N0 = o.getString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
            this.O0 = o.getInt("webPermit");
            this.I0 = (ForbiddenInfo) o.getParcelable("key_forbidden_info");
            this.J0 = o.getInt("key_show_menu_notice");
            this.K0 = o.getInt("key_show_menu_privacy");
        }
    }

    public final String c3(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            String str3 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1242268664:
                        if (str.equals("type_need_update_sdk")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -429452284:
                        if (str.equals("type_path_forbidden")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 38398066:
                        if (str.equals("type_network_error")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 517286506:
                        if (str.equals("type_0049")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 517347882:
                        if (str.equals("type_2205")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 731215244:
                        if (str.equals("type_normal")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                if (c2 != 4) {
                                    if (c2 == 5) {
                                        str3 = getContext().getString(R.string.obfuscated_res_0x7f0f14df);
                                    }
                                } else {
                                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f14e2);
                                }
                            } else {
                                str3 = getContext().getString(R.string.obfuscated_res_0x7f0f14e6);
                            }
                        } else {
                            str3 = getContext().getString(R.string.obfuscated_res_0x7f0f14e3);
                        }
                    } else {
                        str3 = getContext().getString(R.string.obfuscated_res_0x7f0f14e5);
                    }
                } else {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f153b);
                }
                Map<String, String> g2 = bo4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.I0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = bo4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = bo4.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void d3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.g0 == null) {
            gi4 gi4Var = new gi4(activity, this.f0, 19, gv2.K(), new ir3());
            this.g0 = gi4Var;
            gi4Var.n(new i(this, activity));
            s3();
        }
    }

    @Override // com.baidu.tieba.fb2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            gi4 gi4Var = this.g0;
            if (gi4Var != null && gi4Var.i()) {
                this.g0.B(gv2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                x13.o(swanAppActionBar, this.K0 + this.J0);
            }
        }
    }

    public final String r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f14da);
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            if (TextUtils.isEmpty(str)) {
                return string;
            }
            PMSAppInfo u = wj4.i().u(str);
            if (u != null && !TextUtils.isEmpty(u.statusDesc)) {
                return u.statusDesc;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void s3() {
        gi4 gi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (gi4Var = this.g0) == null) {
            return;
        }
        hi4 h2 = gi4Var.h(46);
        hi4 h3 = this.g0.h(47);
        if (h2 != null && this.J0 > 0) {
            h3.o(1);
            h3.n(this.J0);
        }
        if (h3 != null && this.K0 > 0) {
            h3.o(1);
            h3.n(this.K0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0273  */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e3(View view2) {
        String str;
        Activity activity;
        ww2 ww2Var;
        String str2;
        ForbiddenInfo forbiddenInfo;
        String r3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, view2) != null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090186);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090183);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090191);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090189);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090185);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090184);
        String str3 = this.G0;
        boolean z = true;
        if (str3 != null) {
            char c2 = 65535;
            switch (str3.hashCode()) {
                case -1869797338:
                    if (str3.equals("type_load_v8_failed")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1242268664:
                    if (str3.equals("type_need_update_sdk")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -429452284:
                    if (str3.equals("type_path_forbidden")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 38398066:
                    if (str3.equals("type_network_error")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 157273878:
                    if (str3.equals("type_app_forbidden")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str3.equals("type_0049")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 517347882:
                    if (str3.equals("type_2205")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 731215244:
                    if (str3.equals("type_normal")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    si3.w(this.I0, "offline");
                    r3 = r3();
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081407));
                    textView.setVisibility(8);
                    str = r3;
                    break;
                case 1:
                    si3.w(this.I0, "pageblock");
                    if (TextUtils.isEmpty(this.I0.forbiddenInformation)) {
                        r3 = getContext().getString(R.string.obfuscated_res_0x7f0f14e6);
                    } else {
                        r3 = this.I0.forbiddenInformation;
                    }
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081404));
                    if (o3(this.G0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(Z2(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (g3()) {
                        textView.setVisibility(8);
                    }
                    str = r3;
                    break;
                case 2:
                    si3.w(this.I0, "neterror");
                    r3 = c3(this.G0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081406));
                    if (o3(this.G0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(Z2(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = r3;
                    break;
                case 3:
                    si3.w(this.I0, "commonerror");
                    r3 = c3(this.G0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081405));
                    if (o3(this.G0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(Z2(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = r3;
                    break;
                case 4:
                    si3.w(this.I0, StickerDataChangeType.UPDATE);
                    str = c3(this.G0, "app_need_upgrade");
                    if (o3(this.G0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(Z2(this.G0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    si3.w(this.I0, "lackresources");
                    String c3 = c3(this.G0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081403));
                    if (o3(this.G0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(Z2(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = c3;
                    break;
                case 6:
                    si3.w(this.I0, "outdisk");
                    String c32 = c3(this.G0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081403));
                    if (tp3.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (o3(this.G0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(Z2(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = c32;
                    break;
                case 7:
                    str = getContext().getString(R.string.obfuscated_res_0x7f0f01a9);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090188);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(R.string.obfuscated_res_0x7f0f14e5);
            }
            textView6.setText(str);
            activity = this.c0;
            if (!(activity instanceof SwanAppErrorActivity)) {
                ww2Var = ((SwanAppErrorActivity) activity).y();
            } else {
                ww2Var = null;
            }
            zb3 b0 = zb3.b0();
            if (ww2Var == null) {
                str2 = ww2Var.H();
            } else if (b0 != null) {
                str2 = b0.O();
            } else {
                str2 = null;
            }
            forbiddenInfo = this.I0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060425));
            }
            n3(textView, ww2Var);
            textView2.setOnClickListener(new b(this, ww2Var));
            if (tp3.G() && !TextUtils.equals(this.G0, "type_network_error")) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, str2));
            }
            z = (this.O0 == 1 || TextUtils.isEmpty(this.N0)) ? false : false;
            if (!f3() && z && ho4.d()) {
                textView5.setVisibility(0);
                textView2.setVisibility(0);
                textView4.setVisibility(8);
                return;
            }
            textView5.setVisibility(8);
            textView2.setVisibility(8);
            textView4.setVisibility(0);
        }
        str = null;
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090188);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        activity = this.c0;
        if (!(activity instanceof SwanAppErrorActivity)) {
        }
        zb3 b02 = zb3.b0();
        if (ww2Var == null) {
        }
        forbiddenInfo = this.I0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060425));
        }
        n3(textView, ww2Var);
        textView2.setOnClickListener(new b(this, ww2Var));
        if (tp3.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, str2));
        }
        if (this.O0 == 1) {
        }
        if (!f3()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public void j3(hi4 hi4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, hi4Var, activity) == null) {
            gv2.K().g(activity, hi4Var);
            j.a(TopBubbleData.NOTICE, b3(), this.I0);
        }
    }

    public void k3(hi4 hi4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, hi4Var, activity) == null) {
            gv2.K().b(activity, hi4Var);
            j.a(TopBubbleData.NOTICE, b3(), this.I0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void n3(TextView textView, ww2 ww2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, textView, ww2Var) == null) {
            if (TextUtils.equals(this.L0, "1")) {
                textView.setOnClickListener(new d(this, ww2Var));
            } else if (TextUtils.equals(this.L0, "2")) {
                textView.setOnClickListener(new e(this));
            } else if (TextUtils.equals(this.L0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.L0, "4")) {
                if (g3()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f14de);
                textView.setOnClickListener(new h(this, ww2Var));
            }
        }
    }

    public final boolean o3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = bo4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(bo4.l(g2, substring))) {
                        this.L0 = bo4.l(g2, substring);
                        this.M0 = bo4.n(g2, substring);
                        return !TextUtils.equals(this.L0, "0");
                    }
                }
            }
            String l = bo4.l(g2, str2);
            this.L0 = l;
            if (TextUtils.isEmpty(l)) {
                if (TextUtils.equals(str, "type_path_forbidden")) {
                    this.L0 = "4";
                } else if (TextUtils.equals(str, "type_2205")) {
                    this.L0 = "3";
                } else if (TextUtils.equals(str, "type_app_forbidden")) {
                    this.L0 = "0";
                } else if (TextUtils.equals(str, "type_load_v8_failed")) {
                    this.L0 = "0";
                } else {
                    this.L0 = "1";
                }
            }
            this.M0 = bo4.n(g2, str2);
            return !TextUtils.equals(this.L0, "0");
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00a7, viewGroup, false);
            e3(inflate);
            W1(inflate);
            if (V1()) {
                return Y1(inflate);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
