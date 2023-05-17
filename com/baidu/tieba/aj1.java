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
import com.baidu.tieba.k8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aj1 implements gl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public el1 a;
    public String b;
    public final Context c;
    public final vi1 d;
    public k8.b e;
    public int f;
    public int g;
    public fj1 h;
    public int i;
    public ti1 j;
    public final ui1 k;

    /* loaded from: classes4.dex */
    public class a implements ui1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aj1 a;

        public a(aj1 aj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aj1Var;
        }

        @Override // com.baidu.tieba.ui1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    vi1 vi1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    vi1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ui1
        public void b(@NonNull fj1 fj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fj1Var) != null) || k8.f().i()) {
                return;
            }
            int f = dj1.f(fj1Var, this.a.i);
            if (f == 0) {
                this.a.h = fj1Var;
                el1 a = new mk1().a(this.a.c, bj1.a(fj1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!fj1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        wi1 wi1Var = new wi1(a, this.a.d.g(), fj1Var);
                        wi1Var.m(this.a.d);
                        a.c(wi1Var);
                        a.a(wi1Var);
                        wi1Var.l(this.a);
                        this.a.k(!fj1Var.n());
                        this.a.n(!fj1Var.l());
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
                vi1 vi1Var = this.a.d;
                vi1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public aj1(Context context, String str, ok1 ok1Var, vi1 vi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, ok1Var, vi1Var};
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
        this.d = vi1Var;
        if (ok1Var != null && ok1Var.a() != null && ok1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(ok1Var.a().get("launch_type"));
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

    public void l(el1 el1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, el1Var) == null) {
            this.a = el1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.gl1
    @Nullable
    public fj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (fj1) invokeV.objValue;
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
            if (!k8.f().h()) {
                m(dj1.n(this.i));
                return;
            }
            ti1 ti1Var = new ti1();
            this.j = ti1Var;
            ti1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.gl1
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

    public void m(fj1 fj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fj1Var) == null) {
            if (fj1Var != null) {
                this.h = fj1Var;
                nk1 a2 = bj1.a(fj1Var);
                el1 a3 = new mk1().a(this.c, a2);
                if (a3 == null) {
                    if (oi1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    vi1 vi1Var = this.d;
                    if (vi1Var != null) {
                        vi1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (fj1Var.q()) {
                    new BaseVM(this.h).c(null);
                    vi1 vi1Var2 = this.d;
                    if (vi1Var2 != null) {
                        vi1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    vi1 vi1Var3 = this.d;
                    if (vi1Var3 != null) {
                        wi1 wi1Var = new wi1(a3, vi1Var3.g(), fj1Var);
                        wi1Var.m(this.d);
                        a3.c(wi1Var);
                        a3.a(wi1Var);
                        wi1Var.l(this);
                        k(!fj1Var.n());
                        n(!fj1Var.l());
                        this.d.e(this);
                    }
                    k8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            k8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            vi1 vi1Var4 = this.d;
            if (vi1Var4 != null) {
                vi1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            el1 el1Var = this.a;
            if (viewGroup != null && el1Var != null) {
                el1Var.load();
                View adView = el1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                vi1 vi1Var = this.d;
                if (vi1Var != null) {
                    vi1Var.f();
                    return;
                }
                return;
            }
            i();
            vi1 vi1Var2 = this.d;
            if (vi1Var2 != null) {
                vi1Var2.f();
            }
        }
    }
}
