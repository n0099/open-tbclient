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
public class gi1 implements mk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kk1 a;
    public String b;
    public final Context c;
    public final bi1 d;
    public g8.b e;
    public int f;
    public int g;
    public li1 h;
    public int i;
    public zh1 j;
    public final ai1 k;

    /* loaded from: classes4.dex */
    public class a implements ai1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi1 a;

        public a(gi1 gi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi1Var;
        }

        @Override // com.baidu.tieba.ai1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    bi1 bi1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    bi1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ai1
        public void b(@NonNull li1 li1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li1Var) != null) || g8.f().i()) {
                return;
            }
            int f = ji1.f(li1Var, this.a.i);
            if (f == 0) {
                this.a.h = li1Var;
                kk1 a = new sj1().a(this.a.c, hi1.a(li1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!li1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        ci1 ci1Var = new ci1(a, this.a.d.g(), li1Var);
                        ci1Var.m(this.a.d);
                        a.c(ci1Var);
                        a.a(ci1Var);
                        ci1Var.l(this.a);
                        this.a.k(!li1Var.n());
                        this.a.n(!li1Var.l());
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
                bi1 bi1Var = this.a.d;
                bi1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public gi1(Context context, String str, uj1 uj1Var, bi1 bi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, uj1Var, bi1Var};
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
        this.d = bi1Var;
        if (uj1Var != null && uj1Var.a() != null && uj1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(uj1Var.a().get("launch_type"));
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

    public void l(kk1 kk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kk1Var) == null) {
            this.a = kk1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.mk1
    @Nullable
    public li1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (li1) invokeV.objValue;
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
                m(ji1.n(this.i));
                return;
            }
            zh1 zh1Var = new zh1();
            this.j = zh1Var;
            zh1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.mk1
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

    public void m(li1 li1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, li1Var) == null) {
            if (li1Var != null) {
                this.h = li1Var;
                tj1 a2 = hi1.a(li1Var);
                kk1 a3 = new sj1().a(this.c, a2);
                if (a3 == null) {
                    if (uh1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    bi1 bi1Var = this.d;
                    if (bi1Var != null) {
                        bi1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (li1Var.q()) {
                    new BaseVM(this.h).c(null);
                    bi1 bi1Var2 = this.d;
                    if (bi1Var2 != null) {
                        bi1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    bi1 bi1Var3 = this.d;
                    if (bi1Var3 != null) {
                        ci1 ci1Var = new ci1(a3, bi1Var3.g(), li1Var);
                        ci1Var.m(this.d);
                        a3.c(ci1Var);
                        a3.a(ci1Var);
                        ci1Var.l(this);
                        k(!li1Var.n());
                        n(!li1Var.l());
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
            bi1 bi1Var4 = this.d;
            if (bi1Var4 != null) {
                bi1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            kk1 kk1Var = this.a;
            if (viewGroup != null && kk1Var != null) {
                kk1Var.load();
                View adView = kk1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                bi1 bi1Var = this.d;
                if (bi1Var != null) {
                    bi1Var.f();
                    return;
                }
                return;
            }
            i();
            bi1 bi1Var2 = this.d;
            if (bi1Var2 != null) {
                bi1Var2.f();
            }
        }
    }
}
