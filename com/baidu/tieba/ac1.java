package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.BdBaseImageView;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tieba.pc1;
import com.baidu.tieba.ud1;
import com.baidu.tieba.wd1;
import com.baidu.tieba.xd1;
import com.baidu.tieba.yd1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class ac1 {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public pc1 b;
    public oc1 c;
    public boolean d;
    public Map<String, jc1> e;
    public Map<String, r> f;
    public Map<String, r> g;
    public Map<String, r> h;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;

        public a(ac1 ac1Var, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;

        public b(ac1 ac1Var, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;

        public c(ac1 ac1Var, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;

        public d(ac1 ac1Var, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;

        public e(ac1 ac1Var, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;

        public f(ac1 ac1Var, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;

        public g(ac1 ac1Var, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc1 a;
        public final /* synthetic */ EditText b;

        public h(ac1 ac1Var, kc1 kc1Var, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, kc1Var, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc1Var;
            this.b = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.a(this.b.getText().toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements pc1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic1 a;
        public final /* synthetic */ ac1 b;

        public i(ac1 ac1Var, ic1 ic1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, ic1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ac1Var;
            this.a = ic1Var;
        }

        @Override // com.baidu.tieba.pc1.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                this.a.setHttpAuthUsernamePassword(str, str2, str3, str4);
                this.a.a(str3, str4);
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements pc1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic1 a;
        public final /* synthetic */ ac1 b;

        public j(ac1 ac1Var, ic1 ic1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, ic1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ac1Var;
            this.a = ic1Var;
        }

        @Override // com.baidu.tieba.pc1.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.cancel();
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public k(ac1 ac1Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements ud1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public l(ac1 ac1Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // com.baidu.tieba.ud1.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements ud1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc1 a;
        public final /* synthetic */ SslErrorHandler b;
        public final /* synthetic */ SslError c;
        public final /* synthetic */ ac1 d;

        public m(ac1 ac1Var, lc1 lc1Var, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, lc1Var, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ac1Var;
            this.a = lc1Var;
            this.b = sslErrorHandler;
            this.c = sslError;
        }

        @Override // com.baidu.tieba.ud1.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.d.u(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements ud1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public n(ac1 ac1Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, sslErrorHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sslErrorHandler;
        }

        @Override // com.baidu.tieba.ud1.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.proceed();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements ud1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;
        public final /* synthetic */ SslError b;
        public final /* synthetic */ ac1 c;

        public o(ac1 ac1Var, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ac1Var;
            this.b = sslError;
            this.a = null;
        }

        @Override // com.baidu.tieba.ud1.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null) {
                    this.a = new long[5];
                }
                long[] jArr = this.a;
                System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
                long[] jArr2 = this.a;
                jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
                if (this.a[0] >= SystemClock.uptimeMillis() - 3000) {
                    this.a = null;
                    this.c.j(this.b.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc1 a;

        public p(ac1 ac1Var, lc1 lc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, lc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lc1Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @RequiresApi(api = 26)
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements ud1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc1 a;

        public q(ac1 ac1Var, lc1 lc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac1Var, lc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lc1Var;
        }

        @Override // com.baidu.tieba.ud1.c
        @RequiresApi(api = 26)
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public kc1 c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public r(String str, kc1 kc1Var) {
            this(str, null, kc1Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, kc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (kc1) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public r(String str, String str2, kc1 kc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, kc1Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = kc1Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947610266, "Lcom/baidu/tieba/ac1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947610266, "Lcom/baidu/tieba/ac1;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        i = hashSet;
        hashSet.add(".baidu.com");
        i.add(".nuomi.com");
        i.add(".nuomi.bdimg.com");
        i.add(".hao123.com");
        i.add(".qunaer.com");
        i.add(".wejianzhan.com");
    }

    public ac1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        this.a = context;
    }

    public final void d(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            e(linearLayout, i2, R.drawable.nad_ic_dialog_browser_security_good);
        }
    }

    public final void f(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            e(linearLayout, i2, R.drawable.nad_ic_dialog_browser_security_bad);
        }
    }

    public final void e(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.nad_ssl_content_header, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.ssl_header_text);
            textView.setTextColor(inflate.getContext().getResources().getColor(R.color.nad_safe_dialog_message));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(R.id.ssl_header_icon)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public boolean r(String str, String str2, @NonNull kc1 kc1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, str2, kc1Var)) == null) {
            if (this.d) {
                this.f.put(str, new r(str2, kc1Var));
                return true;
            } else if (!g()) {
                kc1Var.cancel();
                return false;
            } else {
                wd1.a aVar = new wd1.a(this.a);
                aVar.q(R.string.nad_dialog_webcall_common_title);
                aVar.j(str2);
                aVar.o(R.string.nad_dialog_positive_button_text, new b(this, kc1Var));
                aVar.n(new a(this, kc1Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public boolean s(String str, String str2, @NonNull kc1 kc1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, str2, kc1Var)) == null) {
            if (this.d) {
                this.g.put(str, new r(str2, kc1Var));
                return true;
            } else if (!g()) {
                kc1Var.cancel();
                return false;
            } else {
                wd1.a aVar = new wd1.a(this.a);
                aVar.q(R.string.nad_dialog_webcall_common_title);
                aVar.j(str2);
                aVar.o(R.string.nad_dialog_positive_button_text, new e(this, kc1Var));
                aVar.l(R.string.nad_dialog_nagtive_button_text, new d(this, kc1Var));
                aVar.n(new c(this, kc1Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void u(@NonNull lc1 lc1Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, lc1Var, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            yd1.a k2 = k(certificate, sslError);
            k2.v(new ud1.a(this.a.getText(R.string.nad_ssl_got_it), R.color.nad_safe_dialog_btn_black, new q(this, lc1Var)));
            k2.n(new p(this, lc1Var));
            k2.t();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.a;
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.e.clear();
                this.f.clear();
                this.h.clear();
                this.g.clear();
            }
        }
    }

    public final boolean h(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return false;
            }
            String host = parse.getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            for (String str2 : i) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            ClipboardManager clipboardManager = (ClipboardManager) this.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (clipboardManager != null) {
                clipboardManager.setText(str);
            }
            h51.a().a(this.a, R.string.nad_ssl_copy_error);
        }
    }

    public final String m(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, date)) == null) {
            if (date == null) {
                return "";
            }
            return DateFormat.getDateFormat(this.a).format(date);
        }
        return (String) invokeL.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.d = z;
        }
    }

    public final yd1.a k(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, sslCertificate, sslError)) == null) {
            View n2 = n(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) n2.findViewById(R.id.obfuscated_res_0x7f091c0a);
            n2.findViewById(R.id.ssl_divider).setBackgroundColor(this.a.getResources().getColor(R.color.nad_dialog_gray));
            if (sslError == null) {
                d(linearLayout, R.string.nad_ssl_certificate_is_valid);
            } else {
                if (sslError.hasError(3)) {
                    f(linearLayout, R.string.nad_ssl_untrusted);
                }
                if (sslError.hasError(2)) {
                    f(linearLayout, R.string.nad_ssl_mismatch);
                }
                if (sslError.hasError(1)) {
                    f(linearLayout, R.string.nad_ssl_expired);
                }
                if (sslError.hasError(0)) {
                    f(linearLayout, R.string.nad_ssl_not_yet_valid);
                }
                if (sslError.hasError(4)) {
                    f(linearLayout, R.string.nad_ssl_date_invalid);
                }
                if (sslError.hasError(5)) {
                    f(linearLayout, R.string.nad_ssl_invalid);
                }
                if (linearLayout.getChildCount() == 0) {
                    f(linearLayout, R.string.nad_ssl_unknown);
                }
            }
            yd1.a aVar = new yd1.a(this.a);
            aVar.y(R.string.nad_ssl_certificate);
            aVar.x(n2);
            return aVar;
        }
        return (yd1.a) invokeLL.objValue;
    }

    public synchronized void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                o(false);
                for (Map.Entry<String, jc1> entry : this.e.entrySet()) {
                    if (entry.getValue() != null) {
                        p(entry.getKey(), entry.getValue());
                    }
                }
                this.e.clear();
                for (Map.Entry<String, r> entry2 : this.f.entrySet()) {
                    r value = entry2.getValue();
                    if (value != null) {
                        r(entry2.getKey(), value.a, value.c);
                    }
                }
                this.f.clear();
                for (Map.Entry<String, r> entry3 : this.h.entrySet()) {
                    r value2 = entry3.getValue();
                    if (value2 != null) {
                        t(entry3.getKey(), value2.a, value2.b, value2.c);
                    }
                }
                this.h.clear();
                for (Map.Entry<String, r> entry4 : this.g.entrySet()) {
                    r value3 = entry4.getValue();
                    if (value3 != null) {
                        s(entry4.getKey(), value3.a, value3.c);
                    }
                }
                this.g.clear();
            }
        }
    }

    public final View n(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, sslCertificate)) == null) {
            View inflate = View.inflate(this.a, R.layout.nad_ssl_certificate, null);
            int color = this.a.getResources().getColor(R.color.nad_safe_dialog_message);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09040c);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextColor(color);
                    textView.setTextSize(14.0f);
                }
            }
            SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
            if (issuedTo != null) {
                ((TextView) inflate.findViewById(R.id.to_common)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092506)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(R.id.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(R.id.by_common)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(R.id.by_org)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(R.id.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(R.id.issued_on)).setText(m(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(R.id.expires_on)).setText(m(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void p(String str, @NonNull jc1 jc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, jc1Var) == null) {
            if (this.d) {
                this.e.put(str, jc1Var);
            }
            if (!g()) {
                return;
            }
            if (h(str)) {
                if (jc1Var != null) {
                    jc1Var.a(str, true, true);
                    return;
                }
                return;
            }
            oc1 oc1Var = new oc1(this.a, str, jc1Var);
            this.c = oc1Var;
            oc1Var.e();
        }
    }

    public void q(@NonNull ic1 ic1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, ic1Var, str, str2) == null) {
            pc1 pc1Var = new pc1(this.a, str, str2);
            this.b = pc1Var;
            pc1Var.h(new i(this, ic1Var));
            this.b.g(new j(this, ic1Var));
            this.b.i();
        }
    }

    public boolean t(String str, String str2, String str3, @NonNull kc1 kc1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, str, str2, str3, kc1Var)) == null) {
            if (this.d) {
                this.h.put(str, new r(str2, str3, kc1Var));
                return true;
            } else if (!g()) {
                kc1Var.cancel();
                return false;
            } else {
                View inflate = View.inflate(this.a, R.layout.nad_js_prompt, null);
                EditText editText = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f0927be);
                editText.setText(str3);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09170b)).setText(str2);
                wd1.a aVar = new wd1.a(this.a);
                aVar.q(R.string.nad_dialog_webcall_common_title);
                aVar.s(inflate);
                aVar.o(R.string.nad_dialog_positive_button_text, new h(this, kc1Var, editText));
                aVar.l(R.string.nad_dialog_nagtive_button_text, new g(this, kc1Var));
                aVar.n(new f(this, kc1Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void v(@NonNull lc1 lc1Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, lc1Var, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            xd1.c cVar = new xd1.c(this.a);
            cVar.A(R.string.nad_security_warning);
            cVar.z(R.string.nad_ssl_warnings_header, new o(this, sslError));
            cVar.v(new ud1.a(this.a.getText(R.string.nad_ssl_continue), R.color.nad_ssl_dialog_go_on_text_color, new n(this, sslErrorHandler)));
            cVar.v(new ud1.a(this.a.getText(R.string.nad_view_certificate), R.color.nad_safe_dialog_btn_black, new m(this, lc1Var, sslErrorHandler, sslError)));
            cVar.v(new ud1.a(this.a.getText(R.string.nad_ssl_go_back), R.color.nad_safe_dialog_btn_black, new l(this, sslErrorHandler)));
            cVar.n(new k(this, sslErrorHandler));
            cVar.t();
        }
    }
}
