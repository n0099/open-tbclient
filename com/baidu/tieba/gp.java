package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class gp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ls b;
    public js c;
    public String d;
    public ns e;
    public ms f;
    public final WeakReference<Context> g;
    public gs h;
    public final Context i;
    public hs j;
    public ks k;

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "1.7.14" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ls
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            }
        }

        public a(gp gpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gpVar};
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

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public boolean b;
        public String c;
        public ns d;
        public ms e;
        public ls f;
        public gs g;
        public js h;
        public hs i;
        public ks j;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = false;
            this.c = "";
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.a = context;
        }

        public gp a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gp gpVar = new gp(this.a);
                gpVar.a = this.b;
                if (TextUtils.isEmpty(this.c)) {
                    gpVar.d = this.c;
                }
                ls lsVar = this.f;
                if (lsVar != null) {
                    gpVar.b = lsVar;
                }
                ns nsVar = this.d;
                if (nsVar != null) {
                    gpVar.e = nsVar;
                }
                ms msVar = this.e;
                if (msVar != null) {
                    gpVar.f = msVar;
                }
                hs hsVar = this.i;
                if (hsVar != null) {
                    gpVar.j = hsVar;
                }
                gs gsVar = this.g;
                if (gsVar != null) {
                    gpVar.h = gsVar;
                }
                js jsVar = this.h;
                if (jsVar != null) {
                    gpVar.c = jsVar;
                }
                ks ksVar = this.j;
                if (ksVar != null) {
                    gpVar.k = ksVar;
                }
                return gpVar;
            }
            return (gp) invokeV.objValue;
        }

        public b b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b c(ms msVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msVar)) == null) {
                this.e = msVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(hs hsVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hsVar)) == null) {
                this.i = hsVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(js jsVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsVar)) == null) {
                this.h = jsVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(ls lsVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, lsVar)) == null) {
                this.f = lsVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b g(ns nsVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, nsVar)) == null) {
                this.d = nsVar;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public gp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new a(this);
        this.c = new iu();
        this.d = "";
        this.h = gs.c();
        this.j = new eu();
        this.k = new nu();
        this.i = context.getApplicationContext();
        this.g = new WeakReference<>(context);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (Context) invokeV.objValue;
    }

    public ks j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k;
        }
        return (ks) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public ms l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (ms) invokeV.objValue;
    }

    public hs m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (hs) invokeV.objValue;
    }

    public js n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (js) invokeV.objValue;
    }

    public WeakReference<Context> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (WeakReference) invokeV.objValue;
    }

    public ls p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (ls) invokeV.objValue;
    }

    public gs r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (gs) invokeV.objValue;
    }

    public ns s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return (ns) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }
}
