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
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
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
import com.baidu.tieba.h72;
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
/* loaded from: classes3.dex */
public class a72 extends z62 {
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

    @Override // com.baidu.tieba.z62
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ve3 a;

            public a(ve3 ve3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {ve3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ve3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ae3.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, qs2 qs2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, qs2Var, forbiddenInfo) == null) {
                ve3 ve3Var = new ve3();
                ve3Var.f = forbiddenInfo.appId;
                ve3Var.g = "errormenu";
                ve3Var.b = "click";
                ve3Var.e = str;
                ve3Var.c = forbiddenInfo.launchSource;
                ve3Var.b(me3.k(qs2Var.W()));
                ve3Var.d(qs2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                nk3.j(new a(ve3Var), "SwanAppFuncClickUBC");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public a(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs2 a;
        public final /* synthetic */ a72 b;

        public b(a72 a72Var, qs2 qs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, qs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a72Var;
            this.a = qs2Var;
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

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ a72 b;

        public c(a72 a72Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a72Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.I0 != null && !TextUtils.isEmpty(this.b.I0.forbiddenDetail)) {
                ar2.u().b(this.b.getActivity(), this.a, this.b.I0.appTitle, this.b.I0.forbiddenDetail);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs2 a;
        public final /* synthetic */ a72 b;

        public d(a72 a72Var, qs2 qs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, qs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a72Var;
            this.a = qs2Var;
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

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public e(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.M0)) {
                Activity activity = this.a.c0;
                if (activity instanceof FragmentActivity) {
                    pl4 l = ((FragmentActivity) activity).l();
                    h72.d e3 = h72.e3(this.a.M0);
                    e3.a(false);
                    e3.c(l);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public f(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity activity = this.a.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (!z62.F0) {
                        return;
                    }
                    throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                }
                ((SwanAppClearCacheErrorActivity) activity).G();
                try {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    t42.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public g(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs2 a;
        public final /* synthetic */ a72 b;

        public h(a72 a72Var, qs2 qs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, qs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a72Var;
            this.a = qs2Var;
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

    /* loaded from: classes3.dex */
    public class i implements yd4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ a72 b;

        public i(a72 a72Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a72Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.yd4
        public boolean b(View view2, be4 be4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, be4Var)) == null) {
                int c = be4Var.c();
                if (c != 5) {
                    if (c != 9) {
                        if (c != 39) {
                            if (c != 46) {
                                if (c == 47) {
                                    this.b.l3(be4Var, this.a);
                                }
                            } else {
                                this.b.k3(be4Var, this.a);
                            }
                        } else {
                            this.b.n3(this.a);
                        }
                    } else {
                        this.b.j3(this.a);
                        return true;
                    }
                } else {
                    this.b.m3(this.a);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public a72() {
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

    public final boolean Z2() {
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

    public final qs2 c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() != null && (getActivity() instanceof SwanAppErrorActivity)) {
                return ((SwanAppErrorActivity) getActivity()).z();
            }
            return null;
        }
        return (qs2) invokeV.objValue;
    }

    public final boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> a2 = bk4.b().a();
            if (a2 != null && a2.contains(this.H0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null && nl3.I(forbiddenInfo.launchPath)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            e3();
            q3();
            t3();
            r3();
        }
    }

    public final void q3() {
        ae4 ae4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (ae4Var = this.g0) != null) {
            ae4Var.s(ar2.M().a());
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            j.a("menu", c3(), this.I0);
        }
    }

    @Override // com.baidu.tieba.z62, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return Z2();
        }
        return invokeL.booleanValue;
    }

    public void j3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            ar2.K().h(activity, b3(activity));
            j.a("feedback", c3(), this.I0);
        }
    }

    public void m3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            jx2.j(activity);
            j.a("daynightmode", c3(), this.I0);
        }
    }

    public void n3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                jx2.t(activity);
            }
            j.a(Headers.REFRESH, c3(), this.I0);
        }
    }

    public static a72 i3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            a72 a72Var = new a72();
            Bundle bundle = new Bundle();
            bundle.putString("swan_error_type", str2);
            bundle.putString("swan_error_code", str);
            bundle.putString(DeepLinkItem.DEEPLINK_WEBURL_KEY, str3);
            bundle.putInt("webPermit", i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            a72Var.l1(bundle);
            return a72Var;
        }
        return (a72) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.z62
    public void X1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.X1(view2);
            Y1(view2);
            w2(-1);
            F2(-16777216);
            A2(false);
            M2(true);
            this.f0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                y2(this.I0.appTitle);
            }
        }
    }

    public final CharSequence a3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = vj4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = vj4.m(g2, str2.substring(str2.length() - 4));
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
                                String m2 = vj4.m(g2, "2205");
                                if (TextUtils.isEmpty(m2)) {
                                    return V(R.string.obfuscated_res_0x7f0f13a4);
                                }
                                return m2;
                            }
                            String m3 = vj4.m(g2, "0049");
                            if (TextUtils.isEmpty(m3)) {
                                return V(R.string.obfuscated_res_0x7f0f13a6);
                            }
                            return m3;
                        }
                        String m4 = vj4.m(g2, "app_page_banned");
                        if (TextUtils.isEmpty(m4)) {
                            return V(R.string.obfuscated_res_0x7f0f13a5);
                        }
                        return m4;
                    }
                    String m5 = vj4.m(g2, "app_need_upgrade");
                    if (TextUtils.isEmpty(m5)) {
                        return V(R.string.obfuscated_res_0x7f0f13a6);
                    }
                    return m5;
                }
                String m6 = vj4.m(g2, "app_open_failed");
                if (TextUtils.isEmpty(m6)) {
                    return V(R.string.obfuscated_res_0x7f0f13a6);
                }
                return m6;
            }
            String m7 = vj4.m(g2, "net_conn_failed");
            if (TextUtils.isEmpty(m7)) {
                return V(R.string.obfuscated_res_0x7f0f13a6);
            }
            return m7;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject b3(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ForbiddenInfo y = ((SwanAppErrorActivity) activity).y();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", y.appTitle);
                    jSONObject.put("url", y.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, y.appId);
                    jSONObject.put("errorPath", y.launchPath);
                    jSONObject.put("errorDes", y.forbiddenReason);
                } catch (JSONException e2) {
                    if (z62.F0) {
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
    public void w0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.w0(bundle);
            Bundle p = p();
            if (p == null) {
                return;
            }
            this.G0 = p.getString("swan_error_type");
            this.H0 = p.getString("swan_error_code");
            this.N0 = p.getString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
            this.O0 = p.getInt("webPermit");
            this.I0 = (ForbiddenInfo) p.getParcelable("key_forbidden_info");
            this.J0 = p.getInt("key_show_menu_notice");
            this.K0 = p.getInt("key_show_menu_privacy");
        }
    }

    public final String d3(String str, String str2) {
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
                                        str3 = getContext().getString(R.string.obfuscated_res_0x7f0f13a7);
                                    }
                                } else {
                                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f13aa);
                                }
                            } else {
                                str3 = getContext().getString(R.string.obfuscated_res_0x7f0f13ae);
                            }
                        } else {
                            str3 = getContext().getString(R.string.obfuscated_res_0x7f0f13ab);
                        }
                    } else {
                        str3 = getContext().getString(R.string.obfuscated_res_0x7f0f13ad);
                    }
                } else {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f1403);
                }
                Map<String, String> g2 = vj4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.I0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = vj4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = vj4.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void e3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.g0 == null) {
            ae4 ae4Var = new ae4(activity, this.f0, 19, ar2.K(), new cn3());
            this.g0 = ae4Var;
            ae4Var.n(new i(this, activity));
            t3();
        }
    }

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            ae4 ae4Var = this.g0;
            if (ae4Var != null && ae4Var.i()) {
                this.g0.B(ar2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                rx2.o(swanAppActionBar, this.K0 + this.J0);
            }
        }
    }

    public final String s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f13a2);
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            if (TextUtils.isEmpty(str)) {
                return string;
            }
            PMSAppInfo u = qf4.i().u(str);
            if (u != null && !TextUtils.isEmpty(u.statusDesc)) {
                return u.statusDesc;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void t3() {
        ae4 ae4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (ae4Var = this.g0) == null) {
            return;
        }
        be4 h2 = ae4Var.h(46);
        be4 h3 = this.g0.h(47);
        if (h2 != null && this.J0 > 0) {
            h3.o(1);
            h3.n(this.J0);
        }
        if (h3 != null && this.K0 > 0) {
            h3.o(1);
            h3.n(this.K0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x027c  */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f3(View view2) {
        String str;
        Activity activity;
        qs2 qs2Var;
        String str2;
        ForbiddenInfo forbiddenInfo;
        String s3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, view2) != null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09017c);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090179);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090187);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017f);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017b);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017a);
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
                    me3.w(this.I0, "offline");
                    s3 = s3();
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f08124a));
                    textView.setVisibility(8);
                    str = s3;
                    break;
                case 1:
                    me3.w(this.I0, "pageblock");
                    if (TextUtils.isEmpty(this.I0.forbiddenInformation)) {
                        s3 = getContext().getString(R.string.obfuscated_res_0x7f0f13ae);
                    } else {
                        s3 = this.I0.forbiddenInformation;
                    }
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081247));
                    if (p3(this.G0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(a3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (h3()) {
                        textView.setVisibility(8);
                    }
                    str = s3;
                    break;
                case 2:
                    me3.w(this.I0, "neterror");
                    s3 = d3(this.G0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081249));
                    if (p3(this.G0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(a3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = s3;
                    break;
                case 3:
                    me3.w(this.I0, "commonerror");
                    s3 = d3(this.G0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081248));
                    if (p3(this.G0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(a3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = s3;
                    break;
                case 4:
                    me3.w(this.I0, StickerDataChangeType.UPDATE);
                    str = d3(this.G0, "app_need_upgrade");
                    if (p3(this.G0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(a3(this.G0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    me3.w(this.I0, "lackresources");
                    String d3 = d3(this.G0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081246));
                    if (p3(this.G0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(a3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = d3;
                    break;
                case 6:
                    me3.w(this.I0, "outdisk");
                    String d32 = d3(this.G0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081246));
                    if (nl3.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (p3(this.G0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(a3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = d32;
                    break;
                case 7:
                    str = getContext().getString(R.string.obfuscated_res_0x7f0f0181);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017e);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(R.string.obfuscated_res_0x7f0f13ad);
            }
            textView6.setText(str);
            activity = this.c0;
            if (!(activity instanceof SwanAppErrorActivity)) {
                qs2Var = ((SwanAppErrorActivity) activity).z();
            } else {
                qs2Var = null;
            }
            t73 b0 = t73.b0();
            if (qs2Var == null) {
                str2 = qs2Var.H();
            } else if (b0 != null) {
                str2 = b0.O();
            } else {
                str2 = null;
            }
            forbiddenInfo = this.I0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060309));
            }
            o3(textView, qs2Var);
            textView2.setOnClickListener(new b(this, qs2Var));
            if (nl3.G() && !TextUtils.equals(this.G0, "type_network_error")) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, str2));
            }
            z = (this.O0 == 1 || TextUtils.isEmpty(this.N0)) ? false : false;
            if (!g3() && z && bk4.d()) {
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
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017e);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        activity = this.c0;
        if (!(activity instanceof SwanAppErrorActivity)) {
        }
        t73 b02 = t73.b0();
        if (qs2Var == null) {
        }
        forbiddenInfo = this.I0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060309));
        }
        o3(textView, qs2Var);
        textView2.setOnClickListener(new b(this, qs2Var));
        if (nl3.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, str2));
        }
        if (this.O0 == 1) {
        }
        if (!g3()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public void k3(be4 be4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, be4Var, activity) == null) {
            ar2.K().g(activity, be4Var);
            j.a("notice", c3(), this.I0);
        }
    }

    public void l3(be4 be4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, be4Var, activity) == null) {
            ar2.K().b(activity, be4Var);
            j.a("notice", c3(), this.I0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void o3(TextView textView, qs2 qs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, textView, qs2Var) == null) {
            if (TextUtils.equals(this.L0, "1")) {
                textView.setOnClickListener(new d(this, qs2Var));
            } else if (TextUtils.equals(this.L0, "2")) {
                textView.setOnClickListener(new e(this));
            } else if (TextUtils.equals(this.L0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.L0, "4")) {
                if (h3()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f13a6);
                textView.setOnClickListener(new h(this, qs2Var));
            }
        }
    }

    public final boolean p3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = vj4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(vj4.l(g2, substring))) {
                        this.L0 = vj4.l(g2, substring);
                        this.M0 = vj4.n(g2, substring);
                        return !TextUtils.equals(this.L0, "0");
                    }
                }
            }
            String l = vj4.l(g2, str2);
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
            this.M0 = vj4.n(g2, str2);
            return !TextUtils.equals(this.L0, "0");
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00a5, viewGroup, false);
            f3(inflate);
            X1(inflate);
            if (W1()) {
                return Z1(inflate);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
