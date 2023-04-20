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
public class ii1 implements ok1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mk1 a;
    public String b;
    public final Context c;
    public final di1 d;
    public g8.b e;
    public int f;
    public int g;
    public ni1 h;
    public int i;
    public bi1 j;
    public final ci1 k;

    /* loaded from: classes4.dex */
    public class a implements ci1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii1 a;

        public a(ii1 ii1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii1Var;
        }

        @Override // com.baidu.tieba.ci1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    di1 di1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    di1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ci1
        public void b(@NonNull ni1 ni1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni1Var) != null) || g8.f().i()) {
                return;
            }
            int f = li1.f(ni1Var, this.a.i);
            if (f == 0) {
                this.a.h = ni1Var;
                mk1 a = new uj1().a(this.a.c, ji1.a(ni1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!ni1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        ei1 ei1Var = new ei1(a, this.a.d.g(), ni1Var);
                        ei1Var.m(this.a.d);
                        a.c(ei1Var);
                        a.a(ei1Var);
                        ei1Var.l(this.a);
                        this.a.k(!ni1Var.n());
                        this.a.n(!ni1Var.l());
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
                di1 di1Var = this.a.d;
                di1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public ii1(Context context, String str, wj1 wj1Var, di1 di1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, wj1Var, di1Var};
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
        this.d = di1Var;
        if (wj1Var != null && wj1Var.a() != null && wj1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(wj1Var.a().get("launch_type"));
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

    public void l(mk1 mk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mk1Var) == null) {
            this.a = mk1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.ok1
    @Nullable
    public ni1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ni1) invokeV.objValue;
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
                m(li1.n(this.i));
                return;
            }
            bi1 bi1Var = new bi1();
            this.j = bi1Var;
            bi1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.ok1
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

    public void m(ni1 ni1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ni1Var) == null) {
            if (ni1Var != null) {
                this.h = ni1Var;
                vj1 a2 = ji1.a(ni1Var);
                mk1 a3 = new uj1().a(this.c, a2);
                if (a3 == null) {
                    if (wh1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    di1 di1Var = this.d;
                    if (di1Var != null) {
                        di1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (ni1Var.q()) {
                    new BaseVM(this.h).c(null);
                    di1 di1Var2 = this.d;
                    if (di1Var2 != null) {
                        di1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    di1 di1Var3 = this.d;
                    if (di1Var3 != null) {
                        ei1 ei1Var = new ei1(a3, di1Var3.g(), ni1Var);
                        ei1Var.m(this.d);
                        a3.c(ei1Var);
                        a3.a(ei1Var);
                        ei1Var.l(this);
                        k(!ni1Var.n());
                        n(!ni1Var.l());
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
            di1 di1Var4 = this.d;
            if (di1Var4 != null) {
                di1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            mk1 mk1Var = this.a;
            if (viewGroup != null && mk1Var != null) {
                mk1Var.load();
                View adView = mk1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                di1 di1Var = this.d;
                if (di1Var != null) {
                    di1Var.f();
                    return;
                }
                return;
            }
            i();
            di1 di1Var2 = this.d;
            if (di1Var2 != null) {
                di1Var2.f();
            }
        }
    }
}
