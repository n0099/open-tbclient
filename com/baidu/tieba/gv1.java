package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o53;
import com.baidu.tieba.ou1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gv1 extends ev1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ou1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gv1 a;

        /* renamed from: com.baidu.tieba.gv1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0301a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k63 a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ a e;

            /* renamed from: com.baidu.tieba.gv1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class DialogInterface$OnClickListenerC0302a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0301a a;

                public DialogInterface$OnClickListenerC0302a(RunnableC0301a runnableC0301a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0301a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0301a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "cancel");
                            RunnableC0301a runnableC0301a = this.a;
                            runnableC0301a.e.a.d(runnableC0301a.c, new ly1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0301a runnableC0301a2 = this.a;
                            runnableC0301a2.e.a.d(runnableC0301a2.c, new ly1(201));
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.gv1$a$a$b */
            /* loaded from: classes6.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0301a a;

                public b(RunnableC0301a runnableC0301a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0301a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0301a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0301a runnableC0301a = this.a;
                            runnableC0301a.e.a.d(runnableC0301a.c, new ly1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0301a runnableC0301a2 = this.a;
                            runnableC0301a2.e.a.d(runnableC0301a2.c, new ly1(201));
                        }
                    }
                }
            }

            public RunnableC0301a(a aVar, k63 k63Var, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, k63Var, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = aVar;
                this.a = k63Var;
                this.b = jSONObject;
                this.c = str;
                this.d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w() != null && !this.a.w().isFinishing() && !this.a.w().isDestroyed()) {
                    o53.a aVar = new o53.a(this.e.a.i());
                    aVar.V(this.b.optString("title"));
                    aVar.x(this.b.optString("content"));
                    aVar.n(new sl3());
                    aVar.m(false);
                    if (this.b.optBoolean("showCancel", true)) {
                        aVar.E(this.b.optString("cancelColor"), R.color.obfuscated_res_0x7f060451);
                        String optString = this.b.optString("cancelText");
                        if (TextUtils.isEmpty(optString)) {
                            optString = this.e.a.i().getString(R.string.obfuscated_res_0x7f0f0149);
                        }
                        aVar.C(optString, new DialogInterface$OnClickListenerC0302a(this));
                    }
                    aVar.R(this.b.optString("confirmColor"), R.color.obfuscated_res_0x7f060452);
                    aVar.P(this.d, new b(this));
                    aVar.X();
                }
            }
        }

        public a(gv1 gv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gv1Var;
        }

        @Override // com.baidu.tieba.ou1.a
        public ly1 a(k63 k63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, k63Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.i().getString(R.string.obfuscated_res_0x7f0f0151);
                }
                ek3.e0(new RunnableC0301a(this, k63Var, jSONObject, str, optString));
                return ly1.f();
            }
            return (ly1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gv1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ly1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#showModal", false);
            return m(str, true, new a(this));
        }
        return (ly1) invokeL.objValue;
    }
}
