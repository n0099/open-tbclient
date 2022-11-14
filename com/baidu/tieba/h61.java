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
import com.baidu.tieba.b81;
import com.baidu.tieba.d81;
import com.baidu.tieba.e81;
import com.baidu.tieba.f81;
import com.baidu.tieba.w61;
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
public class h61 {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public w61 b;
    public v61 c;
    public boolean d;
    public Map<String, q61> e;
    public Map<String, r> f;
    public Map<String, r> g;
    public Map<String, r> h;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;

        public a(h61 h61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
        public final /* synthetic */ r61 a;

        public b(h61 h61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
        public final /* synthetic */ r61 a;

        public c(h61 h61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
        public final /* synthetic */ r61 a;

        public d(h61 h61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
        public final /* synthetic */ r61 a;

        public e(h61 h61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
        public final /* synthetic */ r61 a;

        public f(h61 h61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
        public final /* synthetic */ r61 a;

        public g(h61 h61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
        public final /* synthetic */ r61 a;
        public final /* synthetic */ EditText b;

        public h(h61 h61Var, r61 r61Var, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, r61Var, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
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
    public class i implements w61.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p61 a;
        public final /* synthetic */ h61 b;

        public i(h61 h61Var, p61 p61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, p61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h61Var;
            this.a = p61Var;
        }

        @Override // com.baidu.tieba.w61.f
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
    public class j implements w61.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p61 a;
        public final /* synthetic */ h61 b;

        public j(h61 h61Var, p61 p61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, p61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h61Var;
            this.a = p61Var;
        }

        @Override // com.baidu.tieba.w61.e
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

        public k(h61 h61Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, sslErrorHandler};
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
    public class l implements b81.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public l(h61 h61Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, sslErrorHandler};
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

        @Override // com.baidu.tieba.b81.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements b81.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s61 a;
        public final /* synthetic */ SslErrorHandler b;
        public final /* synthetic */ SslError c;
        public final /* synthetic */ h61 d;

        public m(h61 h61Var, s61 s61Var, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, s61Var, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h61Var;
            this.a = s61Var;
            this.b = sslErrorHandler;
            this.c = sslError;
        }

        @Override // com.baidu.tieba.b81.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.d.u(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements b81.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public n(h61 h61Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, sslErrorHandler};
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

        @Override // com.baidu.tieba.b81.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.proceed();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements b81.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;
        public final /* synthetic */ SslError b;
        public final /* synthetic */ h61 c;

        public o(h61 h61Var, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h61Var;
            this.b = sslError;
            this.a = null;
        }

        @Override // com.baidu.tieba.b81.c
        public void a(View view2) {
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
        public final /* synthetic */ s61 a;

        public p(h61 h61Var, s61 s61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, s61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s61Var;
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
    public class q implements b81.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s61 a;

        public q(h61 h61Var, s61 s61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h61Var, s61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s61Var;
        }

        @Override // com.baidu.tieba.b81.c
        @RequiresApi(api = 26)
        public void a(View view2) {
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
        public r61 c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public r(String str, r61 r61Var) {
            this(str, null, r61Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (r61) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public r(String str, String str2, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, r61Var};
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
            this.c = r61Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947775558, "Lcom/baidu/tieba/h61;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947775558, "Lcom/baidu/tieba/h61;");
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

    public h61(Context context) {
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
            e(linearLayout, i2, R.drawable.obfuscated_res_0x7f080e02);
        }
    }

    public final void f(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            e(linearLayout, i2, R.drawable.obfuscated_res_0x7f080e01);
        }
    }

    public final void e(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d062b, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091fbd);
            textView.setTextColor(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06087c));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091fbc)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public boolean r(String str, String str2, @NonNull r61 r61Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, str2, r61Var)) == null) {
            if (this.d) {
                this.f.put(str, new r(str2, r61Var));
                return true;
            } else if (!g()) {
                r61Var.cancel();
                return false;
            } else {
                d81.a aVar = new d81.a(this.a);
                aVar.q(R.string.obfuscated_res_0x7f0f0bc7);
                aVar.j(str2);
                aVar.o(R.string.obfuscated_res_0x7f0f0bbb, new b(this, r61Var));
                aVar.n(new a(this, r61Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public boolean s(String str, String str2, @NonNull r61 r61Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, str2, r61Var)) == null) {
            if (this.d) {
                this.g.put(str, new r(str2, r61Var));
                return true;
            } else if (!g()) {
                r61Var.cancel();
                return false;
            } else {
                d81.a aVar = new d81.a(this.a);
                aVar.q(R.string.obfuscated_res_0x7f0f0bc7);
                aVar.j(str2);
                aVar.o(R.string.obfuscated_res_0x7f0f0bbb, new e(this, r61Var));
                aVar.l(R.string.obfuscated_res_0x7f0f0bb9, new d(this, r61Var));
                aVar.n(new c(this, r61Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void u(@NonNull s61 s61Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, s61Var, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            f81.a k2 = k(certificate, sslError);
            k2.v(new b81.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c37), R.color.obfuscated_res_0x7f06087a, new q(this, s61Var)));
            k2.n(new p(this, s61Var));
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
            t21.a().a(this.a, R.string.obfuscated_res_0x7f0f0c33);
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

    public final f81.a k(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, sslCertificate, sslError)) == null) {
            View n2 = n(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) n2.findViewById(R.id.obfuscated_res_0x7f091a33);
            n2.findViewById(R.id.obfuscated_res_0x7f091fbb).setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060834));
            if (sslError == null) {
                d(linearLayout, R.string.obfuscated_res_0x7f0f0c31);
            } else {
                if (sslError.hasError(3)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c3c);
                }
                if (sslError.hasError(2)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c39);
                }
                if (sslError.hasError(1)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c35);
                }
                if (sslError.hasError(0)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c3a);
                }
                if (sslError.hasError(4)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c34);
                }
                if (sslError.hasError(5)) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c38);
                }
                if (linearLayout.getChildCount() == 0) {
                    f(linearLayout, R.string.obfuscated_res_0x7f0f0c3b);
                }
            }
            f81.a aVar = new f81.a(this.a);
            aVar.y(R.string.obfuscated_res_0x7f0f0c30);
            aVar.x(n2);
            return aVar;
        }
        return (f81.a) invokeLL.objValue;
    }

    public synchronized void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                o(false);
                for (Map.Entry<String, q61> entry : this.e.entrySet()) {
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
            View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d062a, null);
            int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f06087c);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0903c8);
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
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922b6)).setText(issuedTo.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922b9)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922bb)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09049d)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09049f)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0904a1)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090fbb)).setText(m(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090980)).setText(m(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void p(String str, @NonNull q61 q61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, q61Var) == null) {
            if (this.d) {
                this.e.put(str, q61Var);
            }
            if (!g()) {
                return;
            }
            if (h(str)) {
                if (q61Var != null) {
                    q61Var.a(str, true, true);
                    return;
                }
                return;
            }
            v61 v61Var = new v61(this.a, str, q61Var);
            this.c = v61Var;
            v61Var.e();
        }
    }

    public void q(@NonNull p61 p61Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, p61Var, str, str2) == null) {
            w61 w61Var = new w61(this.a, str, str2);
            this.b = w61Var;
            w61Var.h(new i(this, p61Var));
            this.b.g(new j(this, p61Var));
            this.b.i();
        }
    }

    public boolean t(String str, String str2, String str3, @NonNull r61 r61Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, str, str2, str3, r61Var)) == null) {
            if (this.d) {
                this.h.put(str, new r(str2, str3, r61Var));
                return true;
            } else if (!g()) {
                r61Var.cancel();
                return false;
            } else {
                View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d0607, null);
                EditText editText = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f092537);
                editText.setText(str3);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09154d)).setText(str2);
                d81.a aVar = new d81.a(this.a);
                aVar.q(R.string.obfuscated_res_0x7f0f0bc7);
                aVar.s(inflate);
                aVar.o(R.string.obfuscated_res_0x7f0f0bbb, new h(this, r61Var, editText));
                aVar.l(R.string.obfuscated_res_0x7f0f0bb9, new g(this, r61Var));
                aVar.n(new f(this, r61Var));
                aVar.t();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void v(@NonNull s61 s61Var, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, s61Var, sslErrorHandler, sslError) == null) {
            if (!g()) {
                sslErrorHandler.cancel();
                return;
            }
            e81.c cVar = new e81.c(this.a);
            cVar.A(R.string.obfuscated_res_0x7f0f0c2c);
            cVar.z(R.string.obfuscated_res_0x7f0f0c3d, new o(this, sslError));
            cVar.v(new b81.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c32), R.color.obfuscated_res_0x7f06087d, new n(this, sslErrorHandler)));
            cVar.v(new b81.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c60), R.color.obfuscated_res_0x7f06087a, new m(this, s61Var, sslErrorHandler, sslError)));
            cVar.v(new b81.a(this.a.getText(R.string.obfuscated_res_0x7f0f0c36), R.color.obfuscated_res_0x7f06087a, new l(this, sslErrorHandler)));
            cVar.n(new k(this, sslErrorHandler));
            cVar.t();
        }
    }
}
