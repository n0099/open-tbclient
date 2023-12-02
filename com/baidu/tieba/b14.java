package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gp2;
import com.baidu.tieba.o53;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.util.Date;
/* loaded from: classes5.dex */
public class b14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static b14 c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public class d implements z04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ b14 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.a;
                    dVar.a.a(Boolean.valueOf(dVar.b.n()));
                }
            }
        }

        public d(b14 b14Var, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b14Var, dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b14Var;
            this.a = dl3Var;
        }

        @Override // com.baidu.tieba.z04
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.b.r();
                ek3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements gp2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ dl3 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ b14 d;

        @Override // com.baidu.tieba.gp2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(b14 b14Var, File file, dl3 dl3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b14Var, file, dl3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = b14Var;
            this.a = file;
            this.b = dl3Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.gp2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.a(Boolean.FALSE);
                this.d.a = this.c;
            }
        }

        @Override // com.baidu.tieba.gp2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File k = this.d.k();
                if (k.exists()) {
                    nm4.j(k);
                }
                boolean U = nm4.U(this.a.getAbsolutePath(), k.getAbsolutePath());
                if (U) {
                    this.d.r();
                    Date date = new Date();
                    this.d.q(yi3.e(date, "'debug'-HH:mm:ss"), date.getTime());
                }
                nm4.j(this.a);
                this.b.a(Boolean.valueOf(U));
                this.d.a = this.c;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ b14 b;

        public b(b14 b14Var, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b14Var, dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b14Var;
            this.a = dl3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(Boolean.valueOf(this.b.n()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends i14 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b14 b14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.i14
        @NonNull
        public File a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b14.m().k();
            }
            return (File) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i14
        public void b(@NonNull String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                b14.m().q(str, j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947592100, "Lcom/baidu/tieba/b14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947592100, "Lcom/baidu/tieba/b14;");
                return;
            }
        }
        b = vm1.a;
    }

    public b14() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (b && j23.v()) {
            z = true;
        } else {
            z = false;
        }
        this.a = z;
    }

    public static b14 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c == null) {
                synchronized (b14.class) {
                    if (c == null) {
                        c = new b14();
                    }
                }
            }
            return c;
        }
        return (b14) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ye3.a().getLong("swan-game-sconsole-version-code", -1L);
        }
        return invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = ye3.a().getString("swan-game-sconsole-version-name", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return nm4.E(l());
        }
        return (String) invokeV.objValue;
    }

    public final File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new File(f(), "debugGameSconsole.zip");
        }
        return (File) invokeV.objValue;
    }

    public final File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new File(f(), "swan-game-sconsole.html");
        }
        return (File) invokeV.objValue;
    }

    public final File j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new File(k(), "swan-game-sconsole.js");
        }
        return (File) invokeV.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new File(f(), UriUtil.LOCAL_RESOURCE_SCHEME);
        }
        return (File) invokeV.objValue;
    }

    public final File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new File(k(), "swan-game-sconsole.version");
        }
        return (File) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (j().exists() && h().exists()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j) == null) {
            File l = l();
            if (l.exists()) {
                nm4.j(l);
            }
            ye3.a().putString("swan-game-sconsole-version-name", str);
            ye3.a().putLong("swan-game-sconsole-version-code", j);
        }
    }

    public void c(String str, dl3<Boolean> dl3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, dl3Var) != null) || !b) {
            return;
        }
        boolean z = this.a;
        this.a = true;
        gp2.d dVar = new gp2.d();
        dVar.a = str;
        File g = g();
        new rd2().e(dVar, g.getAbsolutePath(), new a(this, g, dl3Var, z));
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, activity, onClickListener) == null) {
            o53.a aVar = new o53.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f018a);
            aVar.v(R.string.obfuscated_res_0x7f0f01f5);
            aVar.n(new sl3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f01d9, onClickListener);
            aVar.X();
        }
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(a34.d(), "game_core_console");
            if (b && this.a) {
                file = new File(file, "debug");
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return h().toURI().toURL().toString();
            } catch (Exception e) {
                if (b) {
                    Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e);
                    return "";
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void o(@NonNull dl3<Boolean> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dl3Var) == null) {
            if (b && this.a) {
                ek3.e0(new b(this, dl3Var));
            } else {
                ud4.g(new kh4(e(), d()), new h14(new c(this), new d(this, dl3Var)));
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            File j = j();
            File h = h();
            if (!h.exists() && j.exists()) {
                String format = String.format("%s%s%s", UriUtil.LOCAL_RESOURCE_SCHEME, File.separator, "swan-game-sconsole.js");
                String D = nm4.D(rp2.c(), "aigames/sConsole.html");
                if (D != null) {
                    nm4.N(String.format(D, format), h);
                }
            }
        }
    }
}
