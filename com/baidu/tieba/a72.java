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
import com.baidu.tieba.b73;
import com.baidu.tieba.e13;
import com.baidu.tieba.e63;
import com.baidu.tieba.f63;
import com.baidu.tieba.g72;
import com.baidu.tieba.t62;
import com.baidu.tieba.us2;
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
/* loaded from: classes3.dex */
public class a72 extends d72 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppRoundedImageView G0;
    public BdBaseImageView H0;
    public TextView I0;
    public um3 J0;
    public long[] K0;
    public String L0;
    public String M0;
    public String N0;
    public Button O0;
    public RecyclerView P0;
    public SwanAppWebPopWindow Q0;

    @Override // com.baidu.tieba.d72
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d72
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d72
    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        /* loaded from: classes3.dex */
        public class a extends e13.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.baidu.tieba.a72$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0211a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

                public RunnableC0211a(a aVar, String str) {
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
                        b73.a aVar = new b73.a(this.b.a.a.c0);
                        aVar.U(R.string.obfuscated_res_0x7f0f014e);
                        aVar.x(this.a);
                        aVar.n(new fn3());
                        aVar.m(false);
                        aVar.O(R.string.obfuscated_res_0x7f0f011a, null);
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

            @Override // com.baidu.tieba.e13.a
            public void c(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.a.c0.runOnUiThread(new RunnableC0211a(this, str));
                }
            }
        }

        public n(a72 a72Var) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            e13.e().g(new a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class a implements gs3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ a72 c;

        /* renamed from: com.baidu.tieba.a72$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class DialogInterface$OnClickListenerC0210a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0210a(a aVar) {
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
                    SwanAppActivity w = w73.K().w();
                    if (w != null && Build.VERSION.SDK_INT >= 21) {
                        w.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }
        }

        public a(a72 a72Var, kg3 kg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, kg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a72Var;
            this.a = kg3Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gs3
        /* renamed from: a */
        public void run(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.a.putInt(this.b, 1);
                } else {
                    this.a.putInt(this.b, 0);
                }
                b73.a aVar = new b73.a(this.c.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f137d);
                aVar.v(R.string.obfuscated_res_0x7f0f137c);
                aVar.n(new fn3());
                aVar.O(R.string.obfuscated_res_0x7f0f011a, new DialogInterface$OnClickListenerC0210a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gs3 c;
        public final /* synthetic */ a72 d;

        /* loaded from: classes3.dex */
        public class a implements t62.b {
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

            @Override // com.baidu.tieba.t62.b
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (z) {
                        this.a.c.run(Boolean.TRUE);
                        return;
                    }
                    Activity activity = this.a.d.c0;
                    if (activity != null && !activity.isDestroyed()) {
                        t62.b(this.a.d.c0, R.string.obfuscated_res_0x7f0f137d, str);
                    }
                }
            }
        }

        public b(a72 a72Var, kg3 kg3Var, String str, gs3 gs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, kg3Var, str, gs3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a72Var;
            this.a = kg3Var;
            this.b = str;
            this.c = gs3Var;
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
                    x73 b0 = x73.b0();
                    if (b0 == null) {
                        return;
                    }
                    t62.a(b0, this.d.c0, new a(this));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements f63.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppRelatedSwanListAdapter a;
        public final /* synthetic */ a72 b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e63 a;
            public final /* synthetic */ e b;

            public a(e eVar, e63 e63Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, e63Var};
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
                this.a = e63Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.P0.setVisibility(0);
                    this.b.a.l(this.a);
                }
            }
        }

        public e(a72 a72Var, SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, swanAppRelatedSwanListAdapter};
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
            this.a = swanAppRelatedSwanListAdapter;
        }

        @Override // com.baidu.tieba.f63.b
        public void a(e63 e63Var) {
            List<e63.a> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, e63Var) == null) && e63Var != null && (list = e63Var.a) != null && list.size() > 0) {
                rl3.e0(new a(this, e63Var));
                SwanAppRelatedSwanListAdapter.k("aboutrelated", null, "show");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements t62.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        /* loaded from: classes3.dex */
        public class a implements qm3<Boolean> {
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
            @Override // com.baidu.tieba.qm3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        u42.d(this.a.a.getContext());
                    } else {
                        fr2.h().a(this.a.a.c0, null);
                    }
                }
            }
        }

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

        @Override // com.baidu.tieba.t62.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    t62.c(this.a.c0, str);
                } else if (u42.a()) {
                    u42.d(this.a.getContext());
                } else {
                    fr2.h().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FullScreenFloatView a;
        public final /* synthetic */ a72 b;

        /* loaded from: classes3.dex */
        public class a implements qm3<Boolean> {
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
            @Override // com.baidu.tieba.qm3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    if (bool.booleanValue()) {
                        u42.c(this.a.b.getContext(), true);
                    } else {
                        fr2.h().a(this.a.b.c0, null);
                    }
                }
            }
        }

        public j(a72 a72Var) {
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
            this.b = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.c0 == null) {
                return;
            }
            if (a72.R0) {
                if (xb2.f()) {
                    u42.d(this.b.getContext());
                    return;
                }
                if (this.a == null) {
                    this.a = kt2.U().n(this.b.c0);
                }
                int i = 0;
                if (this.b.b2()) {
                    if (u42.a()) {
                        u42.c(this.b.getContext(), false);
                        return;
                    } else {
                        fr2.h().f(new a(this));
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
            } else if (this.b.b2()) {
                this.b.B3();
            } else {
                u42.d(this.b.getContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;
        public final /* synthetic */ x73 b;
        public final /* synthetic */ a72 c;

        /* loaded from: classes3.dex */
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

        public l(a72 a72Var, us2 us2Var, x73 x73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, us2Var, x73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a72Var;
            this.a = us2Var;
            this.b = x73Var;
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
            sb.append(re2.U().r0());
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
            sb.append(zz1.c(this.b.b));
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
            b73.a aVar = new b73.a(this.c.c0);
            aVar.V(this.c.c0.getResources().getString(R.string.obfuscated_res_0x7f0f01cb));
            aVar.x(sb.toString());
            aVar.n(new fn3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f011a, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        /* loaded from: classes3.dex */
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

        public m(a72 a72Var) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c0 == null) {
                return;
            }
            String e = bh3.c().e(1);
            String string = this.a.c0.getResources().getString(R.string.obfuscated_res_0x7f0f00ed);
            b73.a aVar = new b73.a(this.a.c0);
            aVar.V(string);
            aVar.x(e);
            aVar.n(new fn3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f011a, new a(this));
            aVar.X();
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public y52 a;
        public final /* synthetic */ a72 b;

        /* loaded from: classes3.dex */
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
                    y52.g(1);
                    this.a.a = new y52(er2.c());
                    this.a.a.h();
                }
            }
        }

        /* loaded from: classes3.dex */
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
                    y52.g(2);
                    System.exit(0);
                }
            }
        }

        /* loaded from: classes3.dex */
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
                    y52.g(0);
                }
            }
        }

        public o(a72 a72Var) {
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
            this.b = a72Var;
        }

        public final void b() {
            y52 y52Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (y52Var = this.a) != null) {
                y52Var.i();
                this.a = null;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                b73.a aVar = new b73.a(this.b.c0);
                aVar.U(R.string.obfuscated_res_0x7f0f0150);
                aVar.v(R.string.obfuscated_res_0x7f0f013c);
                aVar.n(new fn3());
                aVar.m(true);
                if (y52.e() == 0) {
                    aVar.O(R.string.obfuscated_res_0x7f0f013d, new a(this));
                }
                if (y52.e() != 2) {
                    aVar.H(R.string.obfuscated_res_0x7f0f013b, new b(this));
                }
                if (y52.e() != 0) {
                    aVar.B(R.string.obfuscated_res_0x7f0f13a8, new c(this));
                }
                aVar.X();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ View b;
        public final /* synthetic */ a72 c;

        public c(a72 a72Var, View.OnLongClickListener onLongClickListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, onLongClickListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a72Var;
            this.a = onLongClickListener;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mi3.d().g();
                this.a.onLongClick(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ long b;
        public final /* synthetic */ a72 c;

        public d(a72 a72Var, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a72Var;
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

    /* loaded from: classes3.dex */
    public class g implements rj2 {
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

        @Override // com.baidu.tieba.rj2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
                p73 f = p73.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0113);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.rj2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p73 f = p73.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f1413);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.rj2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                p73 f = p73.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0114);
                f.l(2);
                f.G();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements qj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ a72 b;

        public h(a72 a72Var, String str) {
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

        @Override // com.baidu.tieba.qj2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p73 f = p73.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f1413);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.qj2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
                p73 f = p73.f(this.b.getContext(), R.string.obfuscated_res_0x7f0f015c);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.qj2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ve2.t();
                if (nx2.k(this.b.getActivity())) {
                    nx2.p("aboutconcern", this.a);
                    return;
                }
                Context context = this.b.getContext();
                p73 g = p73.g(context, er2.l0().f(context));
                g.l(2);
                g.q(2);
                g.G();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public i(a72 a72Var) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppPropertyWindow a;
        public final /* synthetic */ a72 b;

        public k(a72 a72Var) {
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
            this.b = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = kt2.U().J(this.b.c0);
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

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public p(a72 a72Var) {
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.f3();
            this.a.m3("click", "baozhang");
        }
    }

    /* loaded from: classes3.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public q(a72 a72Var) {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.i3();
            return true;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568013, "Lcom/baidu/tieba/a72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568013, "Lcom/baidu/tieba/a72;");
                return;
            }
        }
        R0 = ho1.a;
    }

    public a72() {
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

    public static a72 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new a72();
        }
        return (a72) invokeV.objValue;
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || x73.b0() == null) {
            return;
        }
        t62.a(x73.b0(), this.c0, new f(this));
    }

    public final void j3() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && a0() && (swanAppWebPopWindow = this.Q0) != null) {
            swanAppWebPopWindow.r();
        }
    }

    @Override // com.baidu.tieba.d72
    public void m2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !b2()) {
            return;
        }
        p3();
        this.g0.r(er2.M().a());
    }

    @Override // com.baidu.tieba.d72, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            j3();
        }
    }

    @Override // com.baidu.tieba.d72
    public void X1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            Y1(view2);
            if (!b2()) {
                M2(false);
            }
            D2(true);
            w2(-1);
            F2(-16777216);
            y2(null);
            A2(true);
        }
    }

    public final void l3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            g gVar = new g(this);
            sh2 l2 = sh2.l();
            l2.n(3);
            h2.c(str, gVar, l2.k());
            m3("click", "aboutmove");
        }
    }

    public final void o3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            ol3.M(this.H0, this.I0, String.valueOf(i2));
        }
    }

    public final boolean r3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, pMSAppInfo)) == null) {
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

    public final boolean s3(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, pMSAppInfo)) == null) {
            if (w73.K().k() == 0 && pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.brandsInfo)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.w0(bundle);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0092, viewGroup, false);
            X1(inflate);
            q3(inflate);
            if (W1()) {
                inflate = Z1(inflate);
            }
            return G1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (R0) {
                Log.d("SwanAppAboutFragment", "startAboutFragment");
            }
            g72 V = kt2.U().V();
            if (V == null) {
                p73.f(getContext(), R.string.obfuscated_res_0x7f0f01a6).G();
                return;
            }
            g72.b i2 = V.i("navigateTo");
            i2.n(g72.g, g72.i);
            i2.k("running_info", null).a();
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (ve2.n(w73.K().getAppId())) {
                this.O0.setText(R.string.obfuscated_res_0x7f0f13c1);
                this.O0.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f06090c));
                this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811f9);
                return;
            }
            this.O0.setText(R.string.obfuscated_res_0x7f0f138d);
            this.O0.setTextColor(-1);
            this.O0.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811f7);
        }
    }

    @Override // com.baidu.tieba.d72
    public void P2() {
        g72 V;
        f72 f72Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (V = kt2.U().V()) == null || (f72Var = (f72) V.n(f72.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, f72Var.w3());
        kt2.U().u(new yh2("sharebtn", hashMap));
        m3("click", "aboutshare");
    }

    public final void f3() {
        SwanAppActivity activity;
        x73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (activity = kt2.U().getActivity()) == null || (b0 = x73.b0()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.z()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + b0.O());
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.t0(R.string.obfuscated_res_0x7f0f1337);
        swanAppWebPopWindow2.p0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
        swanAppWebPopWindow2.q0();
        swanAppWebPopWindow2.o0();
        swanAppWebPopWindow2.v0();
    }

    public final void g3() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (activity = kt2.U().getActivity()) == null || x73.b0() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.Q0;
        if (swanAppWebPopWindow != null && swanAppWebPopWindow.z()) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.N0);
        this.Q0 = swanAppWebPopWindow2;
        swanAppWebPopWindow2.u0(N(R.string.obfuscated_res_0x7f0f1365));
        swanAppWebPopWindow2.r0(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07069a));
        swanAppWebPopWindow2.p0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
        swanAppWebPopWindow2.o0();
        swanAppWebPopWindow2.v0();
        m3("click", "servicenote");
    }

    public final void w3() {
        x73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (b0 = x73.b0()) == null) {
            return;
        }
        long[] jArr = this.K0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.K0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.K0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.K0 = new long[5];
            if (b0.w0()) {
                y3();
            } else {
                A3();
            }
        }
    }

    @NonNull
    public final String e3(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
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

    public final void h3() {
        x73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (b0 = x73.b0()) == null) {
            return;
        }
        us2.a W = b0.W();
        String J = W.J();
        String F = W.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = rl3.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new u83());
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

    public final void i3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.c0 == null) {
            return;
        }
        String str = w73.K().q().W().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            sl3.b(this.c0).c("");
            p73.f(this.c0, R.string.obfuscated_res_0x7f0f1430).G();
            return;
        }
        String e3 = e3(str, xx2.b(rl3.n()));
        int i2 = R.string.obfuscated_res_0x7f0f1431;
        if (e3.length() > 4000) {
            i2 = R.string.obfuscated_res_0x7f0f1432;
        } else {
            str = e3;
        }
        sl3.b(this.c0).c(str);
        p73.f(this.c0, i2).G();
    }

    public final void k3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (w33.H()) {
                if (R0) {
                    Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
                }
                p73.f(getContext(), R.string.obfuscated_res_0x7f0f012e).G();
                return;
            }
            String e2 = rl3.n().e();
            SwanFavorDataManager.h().b(str, new h(this, e2));
            nx2.p("aboutconcern", e2);
        }
    }

    public final void n3(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            String b2 = b72.b();
            kg3 a2 = b72.a();
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f0904cb);
            button.setVisibility(0);
            if (a2.getInt(b2, -1) == 1) {
                button.setText(R.string.obfuscated_res_0x7f0f137a);
            } else {
                button.setText(R.string.obfuscated_res_0x7f0f137b);
            }
            button.setOnClickListener(new b(this, a2, b2, new a(this, a2, b2)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09019e) {
                w3();
            } else if (id == R.id.obfuscated_res_0x7f0918d8) {
                h3();
            } else if (id == R.id.obfuscated_res_0x7f090469) {
                SchemeRouter.invoke(getContext(), this.L0);
                m3("click", "brand");
            } else if (id == R.id.obfuscated_res_0x7f090165) {
                g3();
            } else if (id == R.id.obfuscated_res_0x7f092050) {
                P2();
            } else if (id == R.id.obfuscated_res_0x7f09011e) {
                u3();
            }
        }
    }

    public final void m3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            af3 af3Var = new af3();
            if (!TextUtils.isEmpty(str)) {
                af3Var.b = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                af3Var.e = str2;
            }
            D1(af3Var);
        }
    }

    @Override // com.baidu.tieba.d72, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            um3 um3Var = this.J0;
            if (um3Var != null) {
                um3Var.c();
            }
            K2(1);
            ee4 ee4Var = this.g0;
            if (ee4Var != null && ee4Var.i()) {
                this.g0.B(er2.M().a());
            }
            if (this.O0 != null) {
                C3();
            }
        }
    }

    public void p3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (activity = getActivity()) != null && this.g0 == null) {
            ee4 ee4Var = new ee4(activity, this.f0, 13, er2.K(), new gn3());
            this.g0 = ee4Var;
            ee4Var.p(rl3.P());
            new nx2(this.g0, this).z();
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            String O = w73.K().q().O();
            if (TextUtils.isEmpty(O)) {
                return;
            }
            if (ve2.n(O)) {
                l3(O);
            } else {
                k3(O);
            }
            C3();
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            String g2 = qk3.g(this.c0);
            p73.g(AppRuntime.getAppContext(), g2).F();
            x42.k("SwanAppAboutFragment", "showExtraInfo\n" + g2);
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            this.P0.setLayoutManager(linearLayoutManager);
            SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
            this.P0.setAdapter(swanAppRelatedSwanListAdapter);
            f63.c(new e(this, swanAppRelatedSwanListAdapter));
        }
    }

    public final void q3(View view2) {
        x73 b0;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, view2) == null) && (b0 = x73.b0()) != null && b0.W() != null) {
            us2.a W = b0.W();
            this.G0 = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f09019e);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ad);
            textView.setText(W.K());
            if (W.G() == 0) {
                an3.a(textView, new i(this));
            }
            k13.h().l().f(textView);
            TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090195);
            textView2.setText(W.e1());
            Button button = (Button) view2.findViewById(R.id.obfuscated_res_0x7f092050);
            button.setOnClickListener(this);
            Button button2 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09011e);
            this.O0 = button2;
            button2.setOnClickListener(this);
            C3();
            if (er2.y0().d()) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            if (!er2.t().b()) {
                this.O0.setVisibility(8);
            }
            g72 V = kt2.U().V();
            if (V == null) {
                return;
            }
            if (V.n(fr2.c().a()) != null) {
                button.setVisibility(8);
                this.O0.setVisibility(8);
            }
            wm4.b().a(textView2);
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f092031)).setText(W.s1());
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f092186)).setText(W.t1());
            String G = er2.o().G();
            this.N0 = G;
            if (!TextUtils.isEmpty(G)) {
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f090165);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.P0 = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091d70);
            PMSAppInfo f0 = W.f0();
            if (s3(f0)) {
                x3(view2, f0.brandsInfo);
            }
            this.I0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901a2);
            this.H0 = (BdBaseImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901a1);
            this.G0.setImageBitmap(rl3.i(W, "SwanAppAboutFragment", false));
            this.G0.setOnClickListener(this);
            SwanAppBearInfo k1 = W.k1();
            if (k1 != null && k1.isValid()) {
                this.J0 = new um3(this.c0, view2, k1, R.id.obfuscated_res_0x7f0903b7);
            }
            o3(W.getType());
            ((Button) view2.findViewById(R.id.obfuscated_res_0x7f0918d8)).setVisibility(8);
            if (R0 || kt2.U().N()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09016d)).inflate();
                if (b2() && (inflate instanceof Button)) {
                    Button button3 = (Button) inflate;
                    if (W.m0()) {
                        i2 = R.string.obfuscated_res_0x7f0f0118;
                    } else {
                        i2 = R.string.obfuscated_res_0x7f0f01a4;
                    }
                    button3.setText(i2);
                }
                inflate.setOnClickListener(new j(this));
                if (!b2()) {
                    ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09016e)).inflate().setOnClickListener(new k(this));
                }
                if (b2()) {
                    ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090170)).inflate().setOnClickListener(new l(this, W, b0));
                }
                if (b2()) {
                    View inflate2 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090172)).inflate();
                    if (inflate2 instanceof Button) {
                        Button button4 = (Button) inflate2;
                        button4.setText(R.string.obfuscated_res_0x7f0f00ed);
                        button4.setOnClickListener(new m(this));
                    }
                }
                if (e13.e().f()) {
                    View inflate3 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09016f)).inflate();
                    if (inflate3 instanceof Button) {
                        Button button5 = (Button) inflate3;
                        button5.setText(R.string.obfuscated_res_0x7f0f014e);
                        button5.setOnClickListener(new n(this));
                    }
                }
                View inflate4 = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090171)).inflate();
                if (inflate4 instanceof Button) {
                    ((Button) inflate4).setText(R.string.obfuscated_res_0x7f0f0150);
                }
                inflate4.setOnClickListener(new o(this));
                if (!b2()) {
                    n3(view2);
                }
            }
            if (r3(f0)) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902b6);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new p(this));
            }
            if (!b2()) {
                v3(this.G0, 2000L, new q(this));
            }
        }
    }

    public final void v3(View view2, long j2, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{view2, Long.valueOf(j2), onLongClickListener}) == null) && view2 != null && onLongClickListener != null && j2 > 0) {
            view2.setOnTouchListener(new d(this, new c(this, onLongClickListener, view2), j2));
        }
    }

    public final void x3(View view2, String str) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, view2, str) == null) {
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
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090469);
                        linearLayout.setOnClickListener(this);
                        linearLayout.setVisibility(0);
                        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f090467)).setText(this.M0);
                        SwanAppRelatedSwanListAdapter.k("brand", null, "show");
                        z3();
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
