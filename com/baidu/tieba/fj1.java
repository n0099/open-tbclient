package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fj1 implements ul1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sl1 a;
    public String b;
    public final Context c;
    public final aj1 d;
    public d9.b e;
    public int f;
    public int g;
    public kj1 h;
    public int i;
    public yi1 j;
    public final zi1 k;

    /* loaded from: classes4.dex */
    public class a implements zi1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fj1 a;

        public a(fj1 fj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fj1Var;
        }

        @Override // com.baidu.tieba.zi1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    aj1 aj1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    aj1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.zi1
        public void b(@NonNull kj1 kj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kj1Var) != null) || d9.f().i()) {
                return;
            }
            int f = ij1.f(kj1Var, this.a.i);
            if (f == 0) {
                this.a.h = kj1Var;
                sl1 a = new al1().a(this.a.c, gj1.a(kj1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!kj1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        bj1 bj1Var = new bj1(a, this.a.d.g(), kj1Var);
                        bj1Var.m(this.a.d);
                        a.c(bj1Var);
                        a.a(bj1Var);
                        bj1Var.l(this.a);
                        this.a.k(!kj1Var.n());
                        this.a.n(!kj1Var.l());
                        this.a.d.e(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else {
                    new BaseVM(this.a.h).c(null);
                    if (this.a.d != null) {
                        this.a.d.b("virtual order cannot show");
                        return;
                    }
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                aj1 aj1Var = this.a.d;
                aj1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public fj1(Context context, String str, cl1 cl1Var, aj1 aj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cl1Var, aj1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LoadState loadState = LoadState.INIT;
        this.i = 0;
        this.k = new a(this);
        this.c = context;
        this.b = str;
        this.d = aj1Var;
        if (cl1Var != null && cl1Var.a() != null && cl1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(cl1Var.a().get("launch_type"));
            } catch (NumberFormatException unused) {
                this.i = 0;
            }
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void l(sl1 sl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sl1Var) == null) {
            this.a = sl1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            sl1 sl1Var = this.a;
            if (viewGroup != null && sl1Var != null) {
                sl1Var.load();
                View adView = sl1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    i();
                    return;
                }
            }
            i();
        }
    }

    @Override // com.baidu.tieba.ul1
    @Nullable
    public kj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (kj1) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!d9.f().h()) {
                m(ij1.n(this.i));
                return;
            }
            yi1 yi1Var = new yi1();
            this.j = yi1Var;
            yi1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.ul1
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.h != null) {
                    jSONObject.put("source", this.h.E);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.h.F);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f);
                jSONObject.put("full_type", this.g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void m(kj1 kj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kj1Var) == null) {
            if (kj1Var != null) {
                this.h = kj1Var;
                bl1 a2 = gj1.a(kj1Var);
                sl1 a3 = new al1().a(this.c, a2);
                if (a3 == null) {
                    if (ti1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    aj1 aj1Var = this.d;
                    if (aj1Var != null) {
                        aj1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (kj1Var.q()) {
                    new BaseVM(this.h).c(null);
                    aj1 aj1Var2 = this.d;
                    if (aj1Var2 != null) {
                        aj1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    aj1 aj1Var3 = this.d;
                    if (aj1Var3 != null) {
                        bj1 bj1Var = new bj1(a3, aj1Var3.g(), kj1Var);
                        bj1Var.m(this.d);
                        a3.c(bj1Var);
                        a3.a(bj1Var);
                        bj1Var.l(this);
                        k(!kj1Var.n());
                        n(!kj1Var.l());
                        this.d.e(this);
                    }
                    d9.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            d9.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            aj1 aj1Var4 = this.d;
            if (aj1Var4 != null) {
                aj1Var4.b("本地物料null");
            }
        }
    }
}
