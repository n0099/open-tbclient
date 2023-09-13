package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kz1;
import com.baidu.tieba.la3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements kz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c02 a;

        /* renamed from: com.baidu.tieba.c02$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0248a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hb3 a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ a e;

            /* renamed from: com.baidu.tieba.c02$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class DialogInterface$OnClickListenerC0249a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0248a a;

                public DialogInterface$OnClickListenerC0249a(RunnableC0248a runnableC0248a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0248a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0248a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "cancel");
                            RunnableC0248a runnableC0248a = this.a;
                            runnableC0248a.e.a.d(runnableC0248a.c, new h32(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0248a runnableC0248a2 = this.a;
                            runnableC0248a2.e.a.d(runnableC0248a2.c, new h32(201));
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.c02$a$a$b */
            /* loaded from: classes5.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0248a a;

                public b(RunnableC0248a runnableC0248a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0248a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0248a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0248a runnableC0248a = this.a;
                            runnableC0248a.e.a.d(runnableC0248a.c, new h32(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0248a runnableC0248a2 = this.a;
                            runnableC0248a2.e.a.d(runnableC0248a2.c, new h32(201));
                        }
                    }
                }
            }

            public RunnableC0248a(a aVar, hb3 hb3Var, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hb3Var, jSONObject, str, str2};
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
                this.a = hb3Var;
                this.b = jSONObject;
                this.c = str;
                this.d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w() != null && !this.a.w().isFinishing() && !this.a.w().isDestroyed()) {
                    la3.a aVar = new la3.a(this.e.a.getContext());
                    aVar.V(this.b.optString("title"));
                    aVar.x(this.b.optString("content"));
                    aVar.n(new pq3());
                    aVar.m(false);
                    if (this.b.optBoolean("showCancel", true)) {
                        aVar.E(this.b.optString("cancelColor"), R.color.obfuscated_res_0x7f06044f);
                        String optString = this.b.optString("cancelText");
                        if (TextUtils.isEmpty(optString)) {
                            optString = this.e.a.getContext().getString(R.string.obfuscated_res_0x7f0f013f);
                        }
                        aVar.C(optString, new DialogInterface$OnClickListenerC0249a(this));
                    }
                    aVar.R(this.b.optString("confirmColor"), R.color.obfuscated_res_0x7f060450);
                    aVar.P(this.d, new b(this));
                    aVar.X();
                }
            }
        }

        public a(c02 c02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c02Var;
        }

        @Override // com.baidu.tieba.kz1.a
        public h32 a(hb3 hb3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, hb3Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0147);
                }
                bp3.e0(new RunnableC0248a(this, hb3Var, jSONObject, str, optString));
                return h32.f();
            }
            return (h32) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c02(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (h32) invokeL.objValue;
    }
}
