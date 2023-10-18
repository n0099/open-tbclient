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
import com.baidu.tieba.o3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class be1 implements hg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fg1 a;
    public String b;
    public final Context c;
    public final wd1 d;
    public o3.b e;
    public int f;
    public int g;
    public ge1 h;
    public int i;
    public ud1 j;
    public final vd1 k;

    /* loaded from: classes5.dex */
    public class a implements vd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ be1 a;

        public a(be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = be1Var;
        }

        @Override // com.baidu.tieba.vd1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    wd1 wd1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    wd1Var.a(message);
                }
            }
        }

        @Override // com.baidu.tieba.vd1
        public void b(@NonNull ge1 ge1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ge1Var) != null) || o3.f().i()) {
                return;
            }
            int f = ee1.f(ge1Var, this.a.i);
            if (f == 0) {
                this.a.h = ge1Var;
                fg1 a = new nf1().a(this.a.c, ce1.a(ge1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!ge1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        xd1 xd1Var = new xd1(a, this.a.d.f(), ge1Var);
                        xd1Var.k(this.a.d);
                        a.c(xd1Var);
                        a.b(xd1Var);
                        xd1Var.j(this.a);
                        this.a.k(!ge1Var.n());
                        this.a.n(!ge1Var.l());
                        this.a.d.d(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else {
                    new BaseVM(this.a.h).c(null);
                    if (this.a.d != null) {
                        this.a.d.a("virtual order cannot show");
                        return;
                    }
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                wd1 wd1Var = this.a.d;
                wd1Var.a("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public be1(Context context, String str, pf1 pf1Var, wd1 wd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, pf1Var, wd1Var};
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
        this.d = wd1Var;
        if (pf1Var != null && pf1Var.a() != null && pf1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(pf1Var.a().get("launch_type"));
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

    public void l(fg1 fg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fg1Var) == null) {
            this.a = fg1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.hg1
    @Nullable
    public ge1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ge1) invokeV.objValue;
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
            if (!o3.f().h()) {
                m(ee1.n(this.i));
                return;
            }
            ud1 ud1Var = new ud1();
            this.j = ud1Var;
            ud1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.hg1
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

    public void m(ge1 ge1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ge1Var) == null) {
            if (ge1Var != null) {
                this.h = ge1Var;
                of1 a2 = ce1.a(ge1Var);
                fg1 a3 = new nf1().a(this.c, a2);
                if (a3 == null) {
                    if (pd1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    wd1 wd1Var = this.d;
                    if (wd1Var != null) {
                        wd1Var.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (ge1Var.q()) {
                    new BaseVM(this.h).c(null);
                    wd1 wd1Var2 = this.d;
                    if (wd1Var2 != null) {
                        wd1Var2.a("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    wd1 wd1Var3 = this.d;
                    if (wd1Var3 != null) {
                        xd1 xd1Var = new xd1(a3, wd1Var3.f(), ge1Var);
                        xd1Var.k(this.d);
                        a3.c(xd1Var);
                        a3.b(xd1Var);
                        xd1Var.j(this);
                        k(!ge1Var.n());
                        n(!ge1Var.l());
                        this.d.d(this);
                    }
                    o3.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            o3.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            wd1 wd1Var4 = this.d;
            if (wd1Var4 != null) {
                wd1Var4.a("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            fg1 fg1Var = this.a;
            if (viewGroup != null && fg1Var != null) {
                fg1Var.load();
                View a2 = fg1Var.a();
                if (a2 != null && a2.getParent() == null) {
                    viewGroup.addView(a2);
                    return;
                }
                i();
                wd1 wd1Var = this.d;
                if (wd1Var != null) {
                    wd1Var.e();
                    return;
                }
                return;
            }
            i();
            wd1 wd1Var2 = this.d;
            if (wd1Var2 != null) {
                wd1Var2.e();
            }
        }
    }
}
