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
import com.baidu.tieba.p8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gk1 implements mm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public km1 a;
    public String b;
    public final Context c;
    public final bk1 d;
    public p8.b e;
    public int f;
    public int g;
    public lk1 h;
    public int i;
    public zj1 j;
    public final ak1 k;

    /* loaded from: classes6.dex */
    public class a implements ak1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk1 a;

        public a(gk1 gk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gk1Var;
        }

        @Override // com.baidu.tieba.ak1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    bk1 bk1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    bk1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ak1
        public void b(@NonNull lk1 lk1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lk1Var) != null) || p8.f().i()) {
                return;
            }
            int f = jk1.f(lk1Var, this.a.i);
            if (f == 0) {
                this.a.h = lk1Var;
                km1 a = new sl1().a(this.a.c, hk1.a(lk1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!lk1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        ck1 ck1Var = new ck1(a, this.a.d.g(), lk1Var);
                        ck1Var.m(this.a.d);
                        a.c(ck1Var);
                        a.a(ck1Var);
                        ck1Var.l(this.a);
                        this.a.k(!lk1Var.n());
                        this.a.n(!lk1Var.l());
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
                bk1 bk1Var = this.a.d;
                bk1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public gk1(Context context, String str, ul1 ul1Var, bk1 bk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, ul1Var, bk1Var};
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
        this.d = bk1Var;
        if (ul1Var != null && ul1Var.a() != null && ul1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(ul1Var.a().get("launch_type"));
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

    public void l(km1 km1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, km1Var) == null) {
            this.a = km1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.mm1
    @Nullable
    public lk1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (lk1) invokeV.objValue;
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
            if (!p8.f().h()) {
                m(jk1.n(this.i));
                return;
            }
            zj1 zj1Var = new zj1();
            this.j = zj1Var;
            zj1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.mm1
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

    public void m(lk1 lk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lk1Var) == null) {
            if (lk1Var != null) {
                this.h = lk1Var;
                tl1 a2 = hk1.a(lk1Var);
                km1 a3 = new sl1().a(this.c, a2);
                if (a3 == null) {
                    if (uj1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    bk1 bk1Var = this.d;
                    if (bk1Var != null) {
                        bk1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (lk1Var.q()) {
                    new BaseVM(this.h).c(null);
                    bk1 bk1Var2 = this.d;
                    if (bk1Var2 != null) {
                        bk1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    bk1 bk1Var3 = this.d;
                    if (bk1Var3 != null) {
                        ck1 ck1Var = new ck1(a3, bk1Var3.g(), lk1Var);
                        ck1Var.m(this.d);
                        a3.c(ck1Var);
                        a3.a(ck1Var);
                        ck1Var.l(this);
                        k(!lk1Var.n());
                        n(!lk1Var.l());
                        this.d.e(this);
                    }
                    p8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            p8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            bk1 bk1Var4 = this.d;
            if (bk1Var4 != null) {
                bk1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            km1 km1Var = this.a;
            if (viewGroup != null && km1Var != null) {
                km1Var.load();
                View adView = km1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                bk1 bk1Var = this.d;
                if (bk1Var != null) {
                    bk1Var.f();
                    return;
                }
                return;
            }
            i();
            bk1 bk1Var2 = this.d;
            if (bk1Var2 != null) {
                bk1Var2.f();
            }
        }
    }
}
