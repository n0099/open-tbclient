package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.ca3;
import com.baidu.tieba.f43;
import com.baidu.tieba.f93;
import com.baidu.tieba.g93;
import com.baidu.tieba.ha2;
import com.baidu.tieba.u92;
import com.baidu.tieba.vv2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ba2 extends ea2 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView G0;
    public BdBaseImageView H0;
    public TextView I0;
    public vp3 J0;
    public long[] K0;
    public String L0;
    public String M0;
    public String N0;
    public Button O0;
    public RecyclerView P0;
    public SwanAppWebPopWindow Q0;

    @Override // com.baidu.tieba.ea2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        /* loaded from: classes5.dex */
        public class a extends f43.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.baidu.tieba.ba2$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0251a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

                public RunnableC0251a(a aVar, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        ca3.a aVar = new ca3.a(this.b.a.a.c0);
                        aVar.U(R.string.obfuscated_res_0x7f0f017a);
                        aVar.x(this.a);
                        aVar.n(new gq3());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f0146, null);
                        aVar.X();
                    }
                }
            }

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // com.baidu.tieba.f43.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.c0.runOnUiThread(new RunnableC0251a(this, str));
                }
            }
        }

        public n(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            f43.e().g(new a(this));
        }
    }

    /* loaded from: classes5.dex */
    public class a implements hv3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ba2 c;

        /* renamed from: com.baidu.tieba.ba2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class DialogInterface$OnClickListenerC0250a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0250a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    SwanAppActivity w = xa3.K().w();
                    if (w != null && Build.VERSION.SDK_INT >= 21) {
                        w.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public a(ba2 ba2Var, lj3 lj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, lj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ba2Var;
            this.a = lj3Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hv3
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.b, 1);
                } else {
                    this.a.putInt(this.b, 0);
                }
                ca3.a aVar = new ca3.a(this.c.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f14dc);
                aVar.v(R.string.obfuscated_res_0x7f0f14db);
                aVar.n(new gq3());
                aVar.O(R.string.obfuscated_res_0x7f0f0146, new DialogInterface$OnClickListenerC0250a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hv3 c;
        public final /* synthetic */ ba2 d;

        /* loaded from: classes5.dex */
        public class a implements u92.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.u92.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.c.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.a.d.c0;
                    if (activity != null && !activity.isDestroyed()) {
                        u92.b(this.a.d.c0, R.string.obfuscated_res_0x7f0f14dc, str);
                    }
                }
            }
        }

        public b(ba2 ba2Var, lj3 lj3Var, String str, hv3 hv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, lj3Var, str, hv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ba2Var;
            this.a = lj3Var;
            this.b = str;
            this.c = hv3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = this.a.getInt(this.b, -1);
                if (i == 1) {
                    this.c.run(Boolean.FALSE);
                } else if (i == 0) {
                    this.c.run(Boolean.TRUE);
                } else {
                    ya3 b0 = ya3.b0();
                    if (b0 == null) {
                        return;
                    }
                    u92.a(b0, this.d.c0, new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements g93.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;
        public final /* synthetic */ ba2 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f93 a;
            public final /* synthetic */ e b;

            public a(e eVar, f93 f93Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, f93Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = f93Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.P0.setVisibility(0);
                    this.b.a.m(this.a);
                }
            }
        }

        public e(ba2 ba2Var, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, swanAppRelatedSwanListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba2Var;
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // com.baidu.tieba.g93.b
        public void a(f93 f93Var) {
            List<f93.a> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f93Var) == null) && f93Var != null && (list = f93Var.a) != null && list.size() > 0) {
                so3.e0(new a(this, f93Var));
                SwanAppRelatedSwanListAdapter.l("aboutrelated", null, "show");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements u92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        /* loaded from: classes5.dex */
        public class a implements rp3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.rp3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        v72.d(this.a.a.getContext());
                    } else {
                        gu2.h().a(this.a.a.c0, null);
                    }
                }
            }
        }

        public f(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // com.baidu.tieba.u92.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    u92.c(this.a.c0, str);
                } else if (v72.a()) {
                    v72.d(this.a.getContext());
                } else {
                    gu2.h().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;
        public final /* synthetic */ ba2 b;

        /* loaded from: classes5.dex */
        public class a implements rp3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.rp3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        v72.c(this.a.b.getContext(), true);
                    } else {
                        gu2.h().a(this.a.b.c0, null);
                    }
                }
            }
        }

        public j(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.c0 == null) {
                return;
            }
            if (ba2.R0) {
                if (ye2.f()) {
                    v72.d(this.b.getContext());
                    return;
                }
                if (this.a == null) {
                    this.a = lw2.T().n(this.b.c0);
                }
                int i = 0;
                if (this.b.a2()) {
                    if (v72.a()) {
                        v72.c(this.b.getContext(), false);
                        return;
                    } else {
                        gu2.h().f(new a(this));
                        return;
                    }
                }
                if (this.a.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                FullScreenFloatView fullScreenFloatView = this.a;
                if (z) {
                    i = 8;
                }
                fullScreenFloatView.setVisibility(i);
            } else if (this.b.a2()) {
                this.b.A3();
            } else {
                v72.d(this.b.getContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv2 a;
        public final /* synthetic */ ya3 b;
        public final /* synthetic */ ba2 c;

        /* loaded from: classes5.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
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

        public l(ba2 ba2Var, vv2 vv2Var, ya3 ya3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, vv2Var, ya3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ba2Var;
            this.a = vv2Var;
            this.b = ya3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String v1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.c.c0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(sh2.U().r0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            String str = "";
            if (TextUtils.isEmpty(this.a.v1())) {
                v1 = "";
            } else {
                v1 = this.a.v1();
            }
            sb.append(v1);
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(a32.c(this.b.b));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.a.i1());
            sb.append("小程序包大小: ");
            if (!TextUtils.isEmpty(formatFileSize)) {
                str = formatFileSize;
            }
            sb.append(str);
            sb.append("(");
            sb.append(this.a.i1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            ca3.a aVar = new ca3.a(this.c.c0);
            aVar.V(this.c.c0.getResources().getString(R.string.obfuscated_res_0x7f0f01f7));
            aVar.x(sb.toString());
            aVar.n(new gq3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0146, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        /* loaded from: classes5.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
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

        public m(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            String e = ck3.c().e(1);
            String string = this.a.c0.getResources().getString(R.string.obfuscated_res_0x7f0f0119);
            ca3.a aVar = new ca3.a(this.a.c0);
            aVar.V(string);
            aVar.x(e);
            aVar.n(new gq3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0146, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z82 a;
        public final /* synthetic */ ba2 b;

        /* loaded from: classes5.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    z82.g(1);
                    this.a.a = new z82(fu2.c());
                    this.a.a.h();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public b(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    z82.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public c(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    this.a.b();
                    z82.g(0);
                }
            }
        }

        public o(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba2Var;
        }

        public final void b() {
            z82 z82Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (z82Var = this.a) != null) {
                z82Var.i();
                this.a = null;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                ca3.a aVar = new ca3.a(this.b.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f017c);
                aVar.v(R.string.obfuscated_res_0x7f0f0168);
                aVar.n(new gq3());
                aVar.m(true);
                if (z82.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f0169, new a(this));
                }
                if (z82.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f0167, new b(this));
                }
                if (z82.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f1507, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ View b;
        public final /* synthetic */ ba2 c;

        public c(ba2 ba2Var, View.OnLongClickListener onLongClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, onLongClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ba2Var;
            this.a = onLongClickListener;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nl3.d().g();
                this.a.onLongClick(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ba2 c;

        public d(ba2 ba2Var, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ba2Var;
            this.a = runnable;
            this.b = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        view2.removeCallbacks(this.a);
                        return false;
                    }
                    return false;
                }
                view2.postDelayed(this.a, this.b);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements sm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public g(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // com.baidu.tieba.sm2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
                qa3 f = qa3.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f013f);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.sm2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qa3 f = qa3.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f1572);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.sm2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                qa3 f = qa3.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0140);
                f.l(2);
                f.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements rm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ba2 b;

        public h(ba2 ba2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba2Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.rm2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qa3 f = qa3.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f1572);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.rm2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
                qa3 f = qa3.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f0188);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.rm2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                wh2.t();
                if (o03.k(this.b.getActivity())) {
                    o03.p("aboutconcern", this.a);
                    return;
                }
                Context context = this.b.getContext();
                qa3 g = qa3.g(context, fu2.l0().f(context));
                g.l(2);
                g.q(2);
                g.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public i(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;
        public final /* synthetic */ ba2 b;

        public k(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = lw2.T().J(this.b.c0);
                }
                int i = 0;
                if (this.a.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                SwanAppPropertyWindow swanAppPropertyWindow = this.a;
                if (z) {
                    i = 8;
                }
                swanAppPropertyWindow.setVisibility(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public p(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.e3();
            this.a.l3("click", "baozhang");
        }
    }

    /* loaded from: classes5.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public q(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.h3();
            return true;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638166, "Lcom/baidu/tieba/ba2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638166, "Lcom/baidu/tieba/ba2;");
                return;
            }
        }
        R0 = ir1.a;
    }

    public ba2() {
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
        this.K0 = new long[5];
    }

    public static ba2 s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new ba2();
        }
        return (ba2) invokeV.objValue;
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || ya3.b0() == null) {
            return;
        }
        u92.a(ya3.b0(), this.c0, new f(this));
    }

    public final void i3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && Z() && (swanAppWebPopWindow = this.Q0) != null) {
            swanAppWebPopWindow.q();
        }
    }

    @Override // com.baidu.tieba.ea2
    public void l2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || !a2()) {
            return;
        }
        o3();
        this.g0.r(fu2.M().a());
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            i3();
        }
    }

    @Override // com.baidu.tieba.ea2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            X1(view2);
            if (!a2()) {
                L2(false);
            }
            C2(true);
            v2(-1);
            E2(-16777216);
            x2(null);
            z2(true);
        }
    }

    public final void k3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            tk2 l2 = tk2.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            l3("click", "aboutmove");
        }
    }

    public final void n3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            po3.M(this.H0, this.I0, String.valueOf(i2));
        }
    }

    public final boolean q3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                i2 = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
            } else {
                i2 = pMSAppInfo.payProtected;
            }
            if (i2 == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean r3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, pMSAppInfo)) == null) {
            if (xa3.K().k() == 0 && pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.brandsInfo)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.v0(bundle);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0093, viewGroup, false);
            W1(inflate);
            p3(inflate);
            if (V1()) {
                inflate = Y1(inflate);
            }
            return F1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (wh2.n(xa3.K().getAppId())) {
                this.O0.setText(R.string.obfuscated_res_0x7f0f1520);
                this.O0.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060aa6));
                this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813eb);
                return;
            }
            this.O0.setText(R.string.obfuscated_res_0x7f0f14ec);
            this.O0.setTextColor(-1);
            this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813e9);
        }
    }

    @Override // com.baidu.tieba.ea2
    public void O2() {
        ha2 U;
        ga2 ga2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (U = lw2.T().U()) == null || (ga2Var = (ga2) U.n(ga2.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ga2Var.v3());
        lw2.T().u(new zk2("sharebtn", hashMap));
        l3("click", "aboutshare");
    }

    public final void e3() {
        SwanAppActivity activity;
        ya3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (activity = lw2.T().getActivity()) == null || (b0 = ya3.b0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.y()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + b0.O());
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.s0(R.string.obfuscated_res_0x7f0f1496);
        swanAppWebPopWindow2.o0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
        swanAppWebPopWindow2.p0();
        swanAppWebPopWindow2.n0();
        swanAppWebPopWindow2.u0();
    }

    public final void f3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (activity = lw2.T().getActivity()) == null || ya3.b0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.y()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.N0);
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.t0(K(R.string.obfuscated_res_0x7f0f14c4));
        swanAppWebPopWindow2.q0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070815));
        swanAppWebPopWindow2.o0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
        swanAppWebPopWindow2.n0();
        swanAppWebPopWindow2.u0();
        l3("click", "servicenote");
    }

    public final void v3() {
        ya3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || (b0 = ya3.b0()) == null) {
            return;
        }
        long[] jArr = this.K0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.K0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.K0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.K0 = new long[5];
            if (b0.w0()) {
                x3();
            } else {
                z3();
            }
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (R0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            ha2 U = lw2.T().U();
            if (U == null) {
                qa3.f(getContext(), R.string.obfuscated_res_0x7f0f01d2).G();
                return;
            }
            ha2.b i2 = U.i("navigateTo");
            i2.n(ha2.g, ha2.i);
            i2.k("running_info", null).a();
        }
    }

    @NonNull
    public final String d3(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str2.startsWith(File.separator)) {
                str2 = str2.substring(1);
            }
            return str + File.separator + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void g3() {
        ya3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (b0 = ya3.b0()) == null) {
            return;
        }
        vv2.a W = b0.W();
        String J = W.J();
        String F = W.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = so3.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new vb3());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.c0, unitedSchemeEntity);
            if (R0) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        } else if (R0) {
            Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.c0 == null) {
            return;
        }
        String str = xa3.K().q().W().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            to3.b(this.c0).c("");
            qa3.f(this.c0, R.string.obfuscated_res_0x7f0f158f).G();
            return;
        }
        String d3 = d3(str, y03.b(so3.n()));
        int i2 = R.string.obfuscated_res_0x7f0f1590;
        if (d3.length() > 4000) {
            i2 = R.string.obfuscated_res_0x7f0f1591;
        } else {
            str = d3;
        }
        to3.b(this.c0).c(str);
        qa3.f(this.c0, i2).G();
    }

    public final void j3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (x63.H()) {
                if (R0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                qa3.f(getContext(), R.string.obfuscated_res_0x7f0f015a).G();
                return;
            }
            String e2 = so3.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            o03.p("aboutconcern", e2);
        }
    }

    public final void m3(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            String b2 = ca2.b();
            lj3 a2 = ca2.a();
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f0904f5);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f14d9);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f14da);
            }
            button.setOnClickListener(new b(this, a2, b2, new a(this, a2, b2)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0901ad) {
                v3();
            } else if (id == R.id.obfuscated_res_0x7f0919d3) {
                g3();
            } else if (id == R.id.obfuscated_res_0x7f09048f) {
                SchemeRouter.invoke(getContext(), this.L0);
                l3("click", "brand");
            } else if (id == R.id.obfuscated_res_0x7f090173) {
                f3();
            } else if (id == R.id.obfuscated_res_0x7f09219c) {
                O2();
            } else if (id == R.id.obfuscated_res_0x7f09012c) {
                t3();
            }
        }
    }

    public final void l3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            bi3 bi3Var = new bi3();
            if (!TextUtils.isEmpty(str)) {
                bi3Var.b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                bi3Var.e = str2;
            }
            B1(bi3Var);
        }
    }

    public void o3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (activity = getActivity()) != null && this.g0 == null) {
            fh4 fh4Var = new fh4(activity, this.f0, 13, fu2.K(), new hq3());
            this.g0 = fh4Var;
            fh4Var.p(so3.P());
            new o03(this.g0, this).z();
        }
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            vp3 vp3Var = this.J0;
            if (vp3Var != null) {
                vp3Var.c();
            }
            J2(1);
            fh4 fh4Var = this.g0;
            if (fh4Var != null && fh4Var.i()) {
                this.g0.B(fu2.M().a());
            }
            if (this.O0 != null) {
                B3();
            }
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            String O = xa3.K().q().O();
            if (TextUtils.isEmpty(O)) {
                return;
            }
            if (wh2.n(O)) {
                k3(O);
            } else {
                j3(O);
            }
            B3();
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            String g2 = rn3.g(this.c0);
            qa3.g(AppRuntime.getAppContext(), g2).F();
            y72.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.P0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.P0.setAdapter(swanAppRelatedSwanListAdapter);
            g93.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void p3(View view2) {
        ya3 b0;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, view2) == null) && (b0 = ya3.b0()) != null && b0.W() != null) {
            vv2.a W = b0.W();
            this.G0 = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901ad);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901bc);
            textView.setText(W.K());
            if (W.G() == 0) {
                bq3.a(textView, new i(this));
            }
            l43.h().l().f(textView);
            TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901a4);
            textView2.setText(W.e1());
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09219c);
            button.setOnClickListener(this);
            Button button2 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09012c);
            this.O0 = button2;
            button2.setOnClickListener(this);
            B3();
            if (fu2.y0().d()) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            if (!fu2.t().b()) {
                this.O0.setVisibility(8);
            }
            ha2 U = lw2.T().U();
            if (U == null) {
                return;
            }
            if (U.n(gu2.c().a()) != null) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            xp4.b().a(textView2);
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f092177)).setText(W.s1());
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922d8)).setText(W.t1());
            String G = fu2.o().G();
            this.N0 = G;
            if (!TextUtils.isEmpty(G)) {
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f090173);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.P0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091e9d);
            PMSAppInfo f0 = W.f0();
            if (r3(f0)) {
                w3(view2, f0.brandsInfo);
            }
            this.I0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b1);
            this.H0 = (BdBaseImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b0);
            this.G0.setImageBitmap(so3.i(W, "SwanAppAboutFragment", false));
            this.G0.setOnClickListener(this);
            SwanAppBearInfo k1 = W.k1();
            if (k1 != null && k1.isValid()) {
                this.J0 = new vp3(this.c0, view2, k1, R.id.obfuscated_res_0x7f0903c9);
            }
            n3(W.getType());
            ((Button) view2.findViewById(R.id.obfuscated_res_0x7f0919d3)).setVisibility(8);
            if (R0 || lw2.T().M()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09017b)).inflate();
                if (a2() && (inflate instanceof Button)) {
                    Button button3 = (Button) inflate;
                    if (W.m0()) {
                        i2 = R.string.obfuscated_res_0x7f0f0144;
                    } else {
                        i2 = R.string.obfuscated_res_0x7f0f01d0;
                    }
                    button3.setText(i2);
                }
                inflate.setOnClickListener(new j(this));
                if (!a2()) {
                    ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09017c)).inflate().setOnClickListener(new k(this));
                }
                if (a2()) {
                    ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09017e)).inflate().setOnClickListener(new l(this, W, b0));
                }
                if (a2()) {
                    View inflate2 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090180)).inflate();
                    if (inflate2 instanceof Button) {
                        Button button4 = (Button) inflate2;
                        button4.setText(R.string.obfuscated_res_0x7f0f0119);
                        button4.setOnClickListener(new m(this));
                    }
                }
                if (f43.e().f()) {
                    View inflate3 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09017d)).inflate();
                    if (inflate3 instanceof Button) {
                        Button button5 = (Button) inflate3;
                        button5.setText(R.string.obfuscated_res_0x7f0f017a);
                        button5.setOnClickListener(new n(this));
                    }
                }
                View inflate4 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09017f)).inflate();
                if (inflate4 instanceof Button) {
                    ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f017c);
                }
                inflate4.setOnClickListener(new o(this));
                if (!a2()) {
                    m3(view2);
                }
            }
            if (q3(f0)) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902c2);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new p(this));
            }
            if (!a2()) {
                u3(this.G0, 2000L, new q(this));
            }
        }
    }

    public final void u3(View view2, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{view2, Long.valueOf(j2), onLongClickListener}) == null) && view2 != null && onLongClickListener != null && j2 > 0) {
            view2.setOnTouchListener(new d(this, new c(this, onLongClickListener, view2), j2));
        }
    }

    public final void w3(View view2, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, view2, str) == null) {
            if (R0) {
                Log.i("SwanAppAboutFragment", str + "");
            }
            if (!TextUtils.isEmpty(str) && view2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.L0 = jSONObject.optString("scheme");
                    this.M0 = jSONObject.optString("description");
                    if (!TextUtils.isEmpty(this.L0) && !TextUtils.isEmpty(this.M0) && (length = this.M0.length()) >= 20) {
                        if (length > 100) {
                            this.M0 = this.M0.substring(0, 100);
                        }
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09048f);
                        linearLayout.setOnClickListener(this);
                        linearLayout.setVisibility(0);
                        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f09048d)).setText(this.M0);
                        SwanAppRelatedSwanListAdapter.l("brand", null, "show");
                        y3();
                    }
                } catch (JSONException e2) {
                    if (R0) {
                        Log.i("SwanAppAboutFragment", e2.getMessage());
                    }
                }
            }
        }
    }
}
