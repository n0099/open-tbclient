package com.baidu.tieba;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ew1;
import com.baidu.tieba.jx2;
import com.baidu.tieba.z62;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class gw1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gw1 i;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupWindow a;
    public Timer b;
    public SwanAppActivity c;
    public z62 d;
    public ContentObserver e;
    public qk2 f;
    public ew1 g;
    public j h;

    /* loaded from: classes4.dex */
    public interface j {
        void e(boolean z);
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ gw1 c;

        /* loaded from: classes4.dex */
        public class a implements jx2.h {
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

            @Override // com.baidu.tieba.jx2.h
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(false);
                    }
                    t42.i("FavoriteGuideHelper", "add favorite result=false");
                }
            }

            @Override // com.baidu.tieba.jx2.h
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    t42.i("FavoriteGuideHelper", "add favorite result=true");
                }
            }
        }

        public b(gw1 gw1Var, ShowFavoriteGuideApi.GuideType guideType, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, guideType, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gw1Var;
            this.a = guideType;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jx2.h(this.b, new a(this));
                this.c.k();
                if (this.c.b != null) {
                    this.c.b.cancel();
                }
                ShowFavoriteGuideApi.GuideType guideType = this.a;
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    str = "flow_add";
                } else {
                    str = "flow_close_add";
                }
                ShowFavoriteGuideApi.F(guideType, str, "click");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType b;
        public final /* synthetic */ gw1 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && re2.n(this.a.a.b)) {
                    f fVar = this.a;
                    if (fVar.b == ShowFavoriteGuideApi.GuideType.NORMAL && fVar.c.h != null) {
                        this.a.c.h.e(true);
                    }
                    this.a.c.k();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(gw1 gw1Var, Handler handler, t73 t73Var, ShowFavoriteGuideApi.GuideType guideType) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, handler, t73Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gw1Var;
            this.a = t73Var;
            this.b = guideType;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                nk3.h().execute(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
        public final /* synthetic */ gw1 b;

        public a(gw1 gw1Var, ShowFavoriteGuideApi.GuideType guideType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, guideType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw1Var;
            this.a = guideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(false);
                }
                ShowFavoriteGuideApi.F(this.a, "flow_close_close", "click");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewTreeObserver a;
        public final /* synthetic */ c72 b;
        public final /* synthetic */ b72 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ t73 e;
        public final /* synthetic */ gw1 f;

        public c(gw1 gw1Var, ViewTreeObserver viewTreeObserver, c72 c72Var, b72 b72Var, String str, t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, viewTreeObserver, c72Var, b72Var, str, t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = gw1Var;
            this.a = viewTreeObserver;
            this.b = c72Var;
            this.c = b72Var;
            this.d = str;
            this.e = t73Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b72 b72Var;
            ViewTreeObserver viewTreeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.a == null && (viewTreeObserver = this.a) != null && viewTreeObserver.isAlive()) {
                    this.a.removeOnGlobalLayoutListener(this);
                } else if (this.f.d != this.b.m() || (((b72Var = this.c) != null && !TextUtils.equals(this.d, b72Var.w3())) || (!this.e.w0() && kl3.J()))) {
                    this.f.k();
                    ViewTreeObserver viewTreeObserver2 = this.a;
                    if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                        this.a.removeOnGlobalLayoutListener(this);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;
        public final /* synthetic */ gw1 b;

        public d(gw1 gw1Var, t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw1Var;
            this.a = t73Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k();
                if (this.b.h != null) {
                    this.b.h.e(re2.n(this.a.b));
                }
                if (this.b.b != null) {
                    this.b.b.cancel();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ew1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw1 a;

        public e(gw1 gw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw1Var;
        }

        @Override // com.baidu.tieba.ew1.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || i != 1) {
                return;
            }
            this.a.k();
        }

        @Override // com.baidu.tieba.ew1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends qk2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;
        public final /* synthetic */ gw1 b;

        public g(gw1 gw1Var, t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw1Var;
            this.a = t73Var;
        }

        @Override // com.baidu.tieba.qk2, com.baidu.tieba.rk2
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null && this.b.a.z()) {
                this.b.k();
            }
        }

        @Override // com.baidu.tieba.qk2, com.baidu.tieba.rk2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                t42.i("FavoriteGuideHelper", "call onActivityDestroyed");
                this.b.k();
                if (this.b.c != null && this.b.f != null) {
                    this.b.c.H0(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.qk2, com.baidu.tieba.rk2
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                t42.i("FavoriteGuideHelper", "swanId=" + this.a.b + ", nowId=" + t73.g0());
                if (!TextUtils.equals(this.a.b, t73.g0())) {
                    this.b.k();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements z62.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw1 a;

        public h(gw1 gw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw1Var;
        }

        @Override // com.baidu.tieba.z62.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw1 a;

        public i(gw1 gw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.a != null) {
                    this.a.a.r();
                    this.a.a = null;
                }
                if (this.a.e != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.a.e);
                    this.a.e = null;
                }
                if (this.a.c != null && this.a.f != null) {
                    this.a.c.H0(this.a.f);
                }
                if (this.a.d != null) {
                    this.a.d.I2(null);
                }
            }
        }
    }

    public gw1() {
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

    public static gw1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (gw1.class) {
                    if (i == null) {
                        i = new gw1();
                    }
                }
            }
            return i;
        }
        return (gw1) invokeV.objValue;
    }

    @AnyThread
    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                nl3.e0(new i(this));
            }
        }
    }

    public final void m() {
        fp1 k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g != null || (k = br2.k()) == null) {
            return;
        }
        ew1 fp1Var = k.getInstance();
        this.g = fp1Var;
        if (fp1Var != null) {
            fp1Var.a(new e(this));
        }
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && ShowFavoriteGuideApi.GuideType.parse(str) != ShowFavoriteGuideApi.GuideType.NORMAL) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void o(@NonNull Activity activity, @NonNull t73 t73Var, ShowFavoriteGuideApi.GuideType guideType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, t73Var, guideType) == null) {
            synchronized (this) {
                this.e = new f(this, null, t73Var, guideType);
                AppRuntime.getAppContext().getContentResolver().registerContentObserver(re2.d(), false, this.e);
                if (activity instanceof SwanAppActivity) {
                    SwanAppActivity swanAppActivity = (SwanAppActivity) activity;
                    this.c = swanAppActivity;
                    if (this.f != null) {
                        swanAppActivity.H0(this.f);
                    }
                    g gVar = new g(this, t73Var);
                    this.f = gVar;
                    this.c.v0(gVar);
                }
                c72 Z = this.c.Z();
                if (Z == null) {
                    return;
                }
                z62 m = Z.m();
                this.d = m;
                if (m == null) {
                    return;
                }
                m.I2(new h(this));
            }
        }
    }

    @UiThread
    public void p(@Nullable j jVar, @NonNull Activity activity, @NonNull t73 t73Var, @NonNull ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j2) {
        int i2;
        SwanAppActivity swanAppActivity;
        c72 Z;
        String w3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jVar, activity, t73Var, guideType, str, str2, Long.valueOf(j2)}) == null) {
            String str3 = str;
            this.h = jVar;
            k();
            if (t73Var.w0()) {
                m();
                ew1 ew1Var = this.g;
                if (ew1Var != null) {
                    ew1Var.b(0);
                }
            }
            o(activity, t73Var, guideType);
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS) {
                i2 = R.layout.obfuscated_res_0x7f0d00a8;
            } else {
                i2 = R.layout.obfuscated_res_0x7f0d00a7;
            }
            View inflate = LayoutInflater.from(activity).inflate(i2, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a8f);
            if (textView != null && str3 != null) {
                if (guideType.limit != -1 && str.length() > guideType.limit) {
                    str3 = str3.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
                }
                textView.setText(str3);
            }
            View findViewById = activity.findViewById(R.id.obfuscated_res_0x7f092445);
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS) {
                if (findViewById != null) {
                    int[] iArr = new int[2];
                    findViewById.getLocationOnScreen(iArr);
                    inflate.findViewById(R.id.obfuscated_res_0x7f090a8c).setPadding(0, 0, ((kl3.o(null) - iArr[0]) - (findViewById.getWidth() / 2)) - kl3.g(7.0f), 0);
                    this.a = new PopupWindow(inflate, -2, -2);
                    SwanAppActivity swanAppActivity2 = this.c;
                    if (swanAppActivity2 != null && !swanAppActivity2.isFinishing() && !this.c.isDestroyed() && findViewById.isAttachedToWindow()) {
                        try {
                            this.a.P(findViewById, 0, -kl3.g(3.0f));
                        } catch (WindowManager.BadTokenException e2) {
                            if (do1.a) {
                                Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090a8e);
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i3 = guideType.showWidth4px;
                int g2 = kl3.g(7.0f);
                int o = kl3.o(null);
                int i4 = g2 * 2;
                if (o - i3 < i4) {
                    i3 = o - i4;
                }
                layoutParams.width = i3;
                relativeLayout.setLayoutParams(layoutParams);
                nl3.X((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090a90), str2, R.drawable.obfuscated_res_0x7f080140);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090a8d);
                if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setOnClickListener(new a(this, guideType));
                }
                ((Button) inflate.findViewById(R.id.obfuscated_res_0x7f090a8b)).setOnClickListener(new b(this, guideType, activity));
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
                this.a = popupWindow;
                popupWindow.N(16);
                this.a.Q(activity.getWindow().getDecorView(), 81, 0, (int) kl3.h(50.0f));
            }
            if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && (swanAppActivity = this.c) != null && (Z = swanAppActivity.Z()) != null && findViewById != null) {
                b72 l = Z.l();
                if (l == null) {
                    w3 = "";
                } else {
                    w3 = l.w3();
                }
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                viewTreeObserver.addOnGlobalLayoutListener(new c(this, viewTreeObserver, Z, l, w3, t73Var));
            }
            if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                Timer timer = this.b;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = new Timer();
                this.b = timer2;
                timer2.schedule(new d(this, t73Var), 1000 * j2);
            }
            ShowFavoriteGuideApi.F(guideType, "", "show");
        }
    }
}
