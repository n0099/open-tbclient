package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.fv;
import com.baidu.tieba.gv;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public final class hv extends gv {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference<iv> a;
    public static Toast b;
    public static Handler c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ int c;
        public final /* synthetic */ fv.a d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.baidu.tieba.hv$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class View$OnClickListenerC0320a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0320a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    fv.a aVar;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = this.a.a.d) != null) {
                        aVar.onToastClick();
                    }
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && pv.q()) {
                    Toast unused = hv.b = new Toast(this.a.a);
                    hv.b.setView(this.a.b);
                    hv.b.setGravity(81, 0, this.a.c);
                    pv.m(hv.b, R.style.obfuscated_res_0x7f100447);
                    this.a.b.setOnClickListener(new View$OnClickListenerC0320a(this));
                    hv.b.show();
                }
            }
        }

        public b(Context context, ViewGroup viewGroup, int i, fv.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = viewGroup;
            this.c = i;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hv.c.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ int c;

        /* renamed from: com.baidu.tieba.hv$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0319a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0319a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && pv.q()) {
                    Toast unused = hv.b = new Toast(this.a.a);
                    hv.b.setView(this.a.b);
                    hv.b.setGravity(81, 0, this.a.c);
                    pv.m(hv.b, R.style.obfuscated_res_0x7f100447);
                    hv.b.show();
                }
            }
        }

        public a(Context context, ViewGroup viewGroup, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = viewGroup;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hv.c.post(new RunnableC0319a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements gv.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public c(Context context, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.tieba.gv.e
        public void a(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                iv ivVar = new iv(this.a);
                hv.j(ivVar);
                if (pv.d()) {
                    ivVar.n(2003);
                }
                ivVar.f(viewGroup);
                ivVar.e(81, 0, this.b);
                ivVar.d(this.c);
                ivVar.j(R.style.obfuscated_res_0x7f100447);
                ivVar.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements fv.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv.a a;

        public d(fv.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.fv.a
        public void onToastClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fv.a aVar = this.a;
                if (aVar != null) {
                    aVar.onToastClick();
                }
                hv.e();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306783, "Lcom/baidu/tieba/hv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306783, "Lcom/baidu/tieba/hv;");
                return;
            }
        }
        c = new Handler(Looper.getMainLooper());
    }

    public static void e() {
        iv ivVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            WeakReference<iv> weakReference = a;
            if (weakReference != null && (ivVar = weakReference.get()) != null) {
                ivVar.i();
            }
            Toast toast = b;
            if (toast != null) {
                toast.cancel();
            }
        }
    }

    public static void j(iv ivVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, ivVar) == null) {
            WeakReference<iv> weakReference = a;
            if (weakReference != null) {
                weakReference.clear();
            }
            a = new WeakReference<>(ivVar);
        }
    }

    public static void f(Context context, CharSequence charSequence, int i, String str, CharSequence charSequence2, int i2, int i3, String str2, String str3, String str4, String str5, String str6, fv.a aVar, dt dtVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, charSequence, Integer.valueOf(i), str, charSequence2, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, str6, aVar, dtVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.sdk_toast_view_margin_bottom);
            if (dtVar != null) {
                dimension = dtVar.a();
            }
            if (pv.p(context)) {
                ViewGroup a2 = gv.a(context, charSequence, str2, str3);
                gv.c(str, a2, new b(applicationContext, a2, dimension, aVar));
                return;
            }
            gv.b(context, charSequence, i, charSequence2, i2, str2, str, str3, str4, str5, str6, new c(applicationContext, dimension, i3), new d(aVar));
        }
    }

    public static void g(Context context, CharSequence charSequence, int i, String str, String str2, String str3, dt dtVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, charSequence, Integer.valueOf(i), str, str2, str3, dtVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.sdk_toast_view_margin_bottom);
            if (dtVar != null) {
                dimension = dtVar.a();
            }
            ViewGroup a2 = gv.a(context, charSequence, str, str3);
            gv.c(str2, a2, new a(applicationContext, a2, dimension));
        }
    }
}
