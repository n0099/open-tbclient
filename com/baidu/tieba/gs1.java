package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.or1;
import com.baidu.tieba.p23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gs1 extends es1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements or1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs1 a;

        /* renamed from: com.baidu.tieba.gs1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0268a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l33 a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ a e;

            /* renamed from: com.baidu.tieba.gs1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class DialogInterface$OnClickListenerC0269a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0268a a;

                public DialogInterface$OnClickListenerC0269a(RunnableC0268a runnableC0268a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0268a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0268a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "cancel");
                            RunnableC0268a runnableC0268a = this.a;
                            runnableC0268a.e.a.d(runnableC0268a.c, new lv1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0268a runnableC0268a2 = this.a;
                            runnableC0268a2.e.a.d(runnableC0268a2.c, new lv1(201));
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.gs1$a$a$b */
            /* loaded from: classes4.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0268a a;

                public b(RunnableC0268a runnableC0268a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0268a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0268a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0268a runnableC0268a = this.a;
                            runnableC0268a.e.a.d(runnableC0268a.c, new lv1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0268a runnableC0268a2 = this.a;
                            runnableC0268a2.e.a.d(runnableC0268a2.c, new lv1(201));
                        }
                    }
                }
            }

            public RunnableC0268a(a aVar, l33 l33Var, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, l33Var, jSONObject, str, str2};
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
                this.a = l33Var;
                this.b = jSONObject;
                this.c = str;
                this.d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w() == null || this.a.w().isFinishing() || this.a.w().isDestroyed()) {
                    return;
                }
                p23.a aVar = new p23.a(this.e.a.getContext());
                aVar.V(this.b.optString("title"));
                aVar.x(this.b.optString("content"));
                aVar.n(new ti3());
                aVar.m(false);
                if (this.b.optBoolean("showCancel", true)) {
                    aVar.E(this.b.optString("cancelColor"), R.color.obfuscated_res_0x7f0603dc);
                    String optString = this.b.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.e.a.getContext().getString(R.string.obfuscated_res_0x7f0f0112);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0269a(this));
                }
                aVar.R(this.b.optString("confirmColor"), R.color.obfuscated_res_0x7f0603dd);
                aVar.P(this.d, new b(this));
                aVar.X();
            }
        }

        public a(gs1 gs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs1Var;
        }

        @Override // com.baidu.tieba.or1.a
        public lv1 a(l33 l33Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l33Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f011a);
                }
                fh3.e0(new RunnableC0268a(this, l33Var, jSONObject, str, optString));
                return lv1.f();
            }
            return (lv1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gs1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public lv1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
