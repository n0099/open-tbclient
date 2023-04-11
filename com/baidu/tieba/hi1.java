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
import com.baidu.tieba.g8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hi1 implements nk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lk1 a;
    public String b;
    public final Context c;
    public final ci1 d;
    public g8.b e;
    public int f;
    public int g;
    public mi1 h;
    public int i;
    public ai1 j;
    public final bi1 k;

    /* loaded from: classes4.dex */
    public class a implements bi1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi1 a;

        public a(hi1 hi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hi1Var;
        }

        @Override // com.baidu.tieba.bi1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    ci1 ci1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    ci1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.bi1
        public void b(@NonNull mi1 mi1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mi1Var) != null) || g8.f().i()) {
                return;
            }
            int f = ki1.f(mi1Var, this.a.i);
            if (f == 0) {
                this.a.h = mi1Var;
                lk1 a = new tj1().a(this.a.c, ii1.a(mi1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!mi1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        di1 di1Var = new di1(a, this.a.d.g(), mi1Var);
                        di1Var.m(this.a.d);
                        a.c(di1Var);
                        a.a(di1Var);
                        di1Var.l(this.a);
                        this.a.k(!mi1Var.n());
                        this.a.n(!mi1Var.l());
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
                ci1 ci1Var = this.a.d;
                ci1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public hi1(Context context, String str, vj1 vj1Var, ci1 ci1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, vj1Var, ci1Var};
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
        this.d = ci1Var;
        if (vj1Var != null && vj1Var.a() != null && vj1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(vj1Var.a().get("launch_type"));
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

    public void l(lk1 lk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lk1Var) == null) {
            this.a = lk1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.nk1
    @Nullable
    public mi1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (mi1) invokeV.objValue;
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
            if (!g8.f().h()) {
                m(ki1.n(this.i));
                return;
            }
            ai1 ai1Var = new ai1();
            this.j = ai1Var;
            ai1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.nk1
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

    public void m(mi1 mi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mi1Var) == null) {
            if (mi1Var != null) {
                this.h = mi1Var;
                uj1 a2 = ii1.a(mi1Var);
                lk1 a3 = new tj1().a(this.c, a2);
                if (a3 == null) {
                    if (vh1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ci1 ci1Var = this.d;
                    if (ci1Var != null) {
                        ci1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (mi1Var.q()) {
                    new BaseVM(this.h).c(null);
                    ci1 ci1Var2 = this.d;
                    if (ci1Var2 != null) {
                        ci1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    ci1 ci1Var3 = this.d;
                    if (ci1Var3 != null) {
                        di1 di1Var = new di1(a3, ci1Var3.g(), mi1Var);
                        di1Var.m(this.d);
                        a3.c(di1Var);
                        a3.a(di1Var);
                        di1Var.l(this);
                        k(!mi1Var.n());
                        n(!mi1Var.l());
                        this.d.e(this);
                    }
                    g8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            g8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            ci1 ci1Var4 = this.d;
            if (ci1Var4 != null) {
                ci1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            lk1 lk1Var = this.a;
            if (viewGroup != null && lk1Var != null) {
                lk1Var.load();
                View adView = lk1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                ci1 ci1Var = this.d;
                if (ci1Var != null) {
                    ci1Var.f();
                    return;
                }
                return;
            }
            i();
            ci1 ci1Var2 = this.d;
            if (ci1Var2 != null) {
                ci1Var2.f();
            }
        }
    }
}
