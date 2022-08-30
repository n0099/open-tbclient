package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ga1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ga1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public ToastLoadingView b;
    public PopupWindow c;
    public PopupWindow d;

    /* loaded from: classes4.dex */
    public class a extends i81<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ ga1 e;

        public a(ga1 ga1Var, ChannelListView channelListView, boolean z, Context context, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga1Var, channelListView, Boolean.valueOf(z), context, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ga1Var;
            this.a = channelListView;
            this.b = z;
            this.c = context;
            this.d = bundle;
        }

        @Override // com.baidu.tieba.i81
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.e.f("2", str);
                this.a.S(this.c.getString(R.string.obfuscated_res_0x7f0f15fe), null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i81
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.e.f("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.a.b0(0, x91.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")), "0");
                } else if (this.b) {
                    this.e.j(this.c, this.d, this.a);
                } else {
                    this.e.k(this.c, this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;
        public final /* synthetic */ ga1 b;

        public b(ga1 ga1Var, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga1Var, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ga1Var;
            this.a = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.c.n();
                o91 o91Var = new o91(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                o91Var.b("1");
                r91.e(o91Var);
                this.a.b0(3, "pay failed , click choose window", "0");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ ChannelListView c;
        public final /* synthetic */ ga1 d;

        public c(ga1 ga1Var, Context context, Bundle bundle, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga1Var, context, bundle, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ga1Var;
            this.a = context;
            this.b = bundle;
            this.c = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.d.c.n();
                o91 o91Var = new o91(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
                o91Var.b("2");
                r91.e(o91Var);
                this.d.i(this.a, this.b, this.c, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga1 a;

        public d(ga1 ga1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null && this.a.d.r()) {
                this.a.d.n();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public e(ga1 ga1Var, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga1Var, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b0(3, "pay failed , click error window", "0");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947787090, "Lcom/baidu/tieba/ga1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947787090, "Lcom/baidu/tieba/ga1;");
        }
    }

    public ga1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ga1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ga1.class) {
                    if (e == null) {
                        e = new ga1();
                    }
                }
            }
            return e;
        }
        return (ga1) invokeV.objValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            xa1.b(this.b);
            try {
                if (this.a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                o91 o91Var = new o91(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
                o91Var.c(jSONObject);
                r91.e(o91Var);
            } catch (JSONException e2) {
                if (aa1.d) {
                    e2.printStackTrace();
                }
            } finally {
                this.a = 0L;
            }
        }
    }

    public final View g(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity == null || activity.getWindow() == null) {
                return null;
            }
            return activity.getWindow().getDecorView().findViewById(16908290);
        }
        return (View) invokeL.objValue;
    }

    public void i(Context context, Bundle bundle, ChannelListView channelListView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, channelListView, Boolean.valueOf(z)}) == null) || context == null || bundle == null || channelListView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.b = xa1.c((ViewGroup) g((Activity) context), layoutParams, null, -1L);
        this.a = System.currentTimeMillis();
        q81.j().m(bundle, new a(this, channelListView, z, context, bundle));
    }

    public final void j(Context context, Bundle bundle, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, bundle, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d0686, null);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.c = popupWindow;
            popupWindow.w(false);
            this.c.B(false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090409)).setOnClickListener(new b(this, channelListView));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090408)).setOnClickListener(new c(this, context, bundle, channelListView));
            this.c.D(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            r91.e(new o91("102"));
        }
    }

    public final void k(Context context, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d020b, null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919f1)).setText(R.string.obfuscated_res_0x7f0f0d6f);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919f0)).setText(R.string.obfuscated_res_0x7f0f0d70);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.d = popupWindow;
            popupWindow.w(false);
            this.d.B(false);
            this.d.v(new ColorDrawable(0));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919eb)).setOnClickListener(new d(this));
            this.d.A(new e(this, channelListView));
            this.d.D(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }
}
