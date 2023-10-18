package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gh0 {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<eg0> a;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg0 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ eh0 c;
        public final /* synthetic */ gh0 d;

        public a(gh0 gh0Var, eg0 eg0Var, Activity activity, eh0 eh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh0Var, eg0Var, activity, eh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gh0Var;
            this.a = eg0Var;
            this.b = activity;
            this.c = eh0Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                gh0.a();
                this.d.j();
                this.d.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_KEYBACK, this.a);
                if (dg0.b().a(this.b)) {
                    dg0.b().e(this.b, System.currentTimeMillis());
                    this.c.a();
                    return true;
                }
                this.c.b();
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh0 a;
        public final /* synthetic */ eg0 b;
        public final /* synthetic */ gh0 c;

        public b(gh0 gh0Var, eh0 eh0Var, eg0 eg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh0Var, eh0Var, eg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gh0Var;
            this.a = eh0Var;
            this.b = eg0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.j();
                dg0.b().d(false);
                this.a.a();
                this.c.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_NEGATIVE, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg0 a;
        public final /* synthetic */ gh0 b;

        public c(gh0 gh0Var, eg0 eg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh0Var, eg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gh0Var;
            this.a = eg0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j();
                dg0.b().d(false);
                this.b.g(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_POSITIVE, this.a);
                if (TextUtils.equals(this.a.q.o, "reminded_type_unopen")) {
                    oh0.h(this.a.d);
                    return;
                }
                oh0.e(this.a.h, this.a.a());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final gh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-775931654, "Lcom/baidu/tieba/gh0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-775931654, "Lcom/baidu/tieba/gh0$d;");
                    return;
                }
            }
            a = new gh0(null);
        }
    }

    public gh0() {
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
        this.a = new ArrayList();
    }

    public static /* synthetic */ int a() {
        int i = c;
        c = i + 1;
        return i;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return gy0.a().b("nad_app_quick_config").getLong("key_last_alert_dialog_show_time", 0L);
        }
        return invokeV.longValue;
    }

    public static gh0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d.a;
        }
        return (gh0) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            b = currentTimeMillis;
            h(currentTimeMillis);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c++;
        }
    }

    public /* synthetic */ gh0(a aVar) {
        this();
    }

    public static void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            gy0.a().b("nad_app_quick_config").g("key_last_alert_dialog_show_time", j);
        }
    }

    public final eg0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            eg0 eg0Var = null;
            if (tx0.g(this.a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int l = tx0.l(this.a) - 1;
            eg0 eg0Var2 = null;
            while (true) {
                if (l < 0) {
                    break;
                }
                eg0 eg0Var3 = (eg0) tx0.d(this.a, l);
                if (eg0Var3 != null) {
                    String str = eg0Var3.d;
                    boolean c2 = oh0.c(str);
                    boolean exists = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str).exists();
                    if (c2) {
                        if (exists) {
                            tx0.b(arrayList, eg0Var3);
                        } else {
                            eg0Var3.q.o = "reminded_type_unopen";
                            tx0.b(arrayList, eg0Var3);
                            eg0Var = eg0Var3;
                            break;
                        }
                    } else if (oh0.g(eg0Var3.h) && eg0Var3.c != AdDownloadStatus.NONE && TextUtils.equals(eg0Var3.q.o, "reminded_type_none") && eg0Var2 == null) {
                        eg0Var3.q.o = "reminded_type_uninstall";
                        eg0Var2 = eg0Var3;
                    }
                }
                l--;
            }
            tx0.k(this.a, arrayList);
            if (eg0Var != null) {
                return eg0Var;
            }
            return eg0Var2;
        }
        return (eg0) invokeV.objValue;
    }

    public final void g(ClogBuilder.LogType logType, ClogBuilder.Area area, eg0 eg0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, logType, area, eg0Var) != null) || eg0Var == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.u(ClogBuilder.Page.POPUP);
        if (logType != null) {
            clogBuilder.y(logType);
        }
        if (area != null) {
            clogBuilder.i(area);
        }
        if (!TextUtils.isEmpty(eg0Var.p.a)) {
            clogBuilder.p(eg0Var.p.a);
        }
        clogBuilder.k(String.valueOf(c));
        clogBuilder.l(String.valueOf(d));
        if (TextUtils.equals(eg0Var.q.o, "reminded_type_uninstall")) {
            str = "1";
        } else {
            str = "2";
        }
        clogBuilder.m(str);
        jy0.e(clogBuilder);
    }

    public void i(Activity activity, eh0 eh0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, eh0Var) == null) && dg0.b().isMainActivity(activity) && eh0Var != null) {
            if (b == 0) {
                b = e();
            }
            if (System.currentTimeMillis() - b < 600000) {
                eh0Var.a();
                return;
            }
            eg0 d2 = d();
            if (d2 == null) {
                eh0Var.a();
                return;
            }
            rh0 rh0Var = new rh0(activity);
            rh0Var.d();
            rh0Var.e(false);
            rh0Var.f(false);
            rh0Var.g(d2);
            rh0Var.j(new c(this, d2));
            rh0Var.h(new b(this, eh0Var, d2));
            rh0Var.i(new a(this, d2, activity, eh0Var));
            rh0Var.k();
            d++;
            dg0.b().d(true);
            g(ClogBuilder.LogType.FREE_SHOW, ClogBuilder.Area.DIALOG, d2);
        }
    }

    public void k(eg0 eg0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, eg0Var) == null) && eg0Var != null && (file = eg0Var.h) != null && file.exists()) {
            String str = eg0Var.p.h;
            String absolutePath = eg0Var.h.getAbsolutePath();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(absolutePath)) {
                eg0Var.q.o = "reminded_type_none";
                tx0.b(this.a, eg0Var);
            }
        }
    }
}
