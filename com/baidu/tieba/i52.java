package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.tieba.h52;
import com.baidu.tieba.j52;
import com.baidu.tieba.k52;
import com.baidu.tieba.n43;
import com.baidu.tieba.t43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class i52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public h52 b;

    /* loaded from: classes6.dex */
    public interface r {
        void a();

        void b(String str, String str2);
    }

    /* loaded from: classes6.dex */
    public interface s {
        void a();

        void b(String str);

        void onCancel();
    }

    /* loaded from: classes6.dex */
    public interface t {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public a(i52 i52Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (sVar = this.a) != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public b(i52 i52Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && (sVar = this.a) != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public c(i52 i52Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (sVar = this.a) != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public d(i52 i52Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && (sVar = this.a) != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public e(i52 i52Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && (sVar = this.a) != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public f(i52 i52Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (sVar = this.a) != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public g(i52 i52Var, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && (sVar = this.a) != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;
        public final /* synthetic */ EditText b;

        public h(i52 i52Var, s sVar, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sVar, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
            this.b = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && (sVar = this.a) != null) {
                sVar.b(this.b.getText().toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements h52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;
        public final /* synthetic */ i52 b;

        public i(i52 i52Var, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i52Var;
            this.a = rVar;
        }

        @Override // com.baidu.tieba.h52.f
        public void a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
                r rVar = this.a;
                if (rVar != null) {
                    rVar.b(str3, str4);
                }
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements h52.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;
        public final /* synthetic */ i52 b;

        public j(i52 i52Var, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i52Var;
            this.a = rVar;
        }

        @Override // com.baidu.tieba.h52.e
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.a;
                if (rVar != null) {
                    rVar.a();
                }
                this.b.b = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SslErrorHandler a;

        public k(i52 i52Var, SslErrorHandler sslErrorHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sslErrorHandler};
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

    /* loaded from: classes6.dex */
    public class l implements n43.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public l(i52 i52Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // com.baidu.tieba.n43.c
        public void onItemClick(View view2) {
            t tVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tVar = this.a) != null) {
                tVar.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements n43.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;
        public final /* synthetic */ SslErrorHandler b;
        public final /* synthetic */ SslError c;
        public final /* synthetic */ i52 d;

        public m(i52 i52Var, t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, tVar, sslErrorHandler, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = i52Var;
            this.a = tVar;
            this.b = sslErrorHandler;
            this.c = sslError;
        }

        @Override // com.baidu.tieba.n43.c
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.d.o(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class n implements n43.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public n(i52 i52Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // com.baidu.tieba.n43.c
        public void onItemClick(View view2) {
            t tVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tVar = this.a) != null) {
                tVar.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements n43.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;
        public final /* synthetic */ SslError b;
        public final /* synthetic */ i52 c;

        public o(i52 i52Var, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sslError};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i52Var;
            this.b = sslError;
            this.a = null;
        }

        @Override // com.baidu.tieba.n43.c
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
                    this.c.g(this.b.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public p(i52 i52Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (tVar = this.a) != null) {
                tVar.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements n43.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public q(i52 i52Var, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // com.baidu.tieba.n43.c
        public void onItemClick(View view2) {
            t tVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tVar = this.a) != null) {
                tVar.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804419, "Lcom/baidu/tieba/i52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804419, "Lcom/baidu/tieba/i52;");
                return;
            }
        }
        c = am1.a;
    }

    public final boolean f() {
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

    public i52(Context context) {
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
        this.a = context;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ((ClipboardManager) this.a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(str);
            h53.f(this.a, R.string.obfuscated_res_0x7f0f01ff).G();
        }
    }

    public final String i(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) {
            if (date == null) {
                return "";
            }
            return DateFormat.getDateFormat(this.a).format(date);
        }
        return (String) invokeL.objValue;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linearLayout, i2) == null) {
            d(linearLayout, i2, R.drawable.obfuscated_res_0x7f080160);
        }
    }

    public final void e(LinearLayout linearLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, linearLayout, i2) == null) {
            d(linearLayout, i2, R.drawable.obfuscated_res_0x7f08015f);
        }
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00da, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(R.id.ssl_header_text);
            textView.setTextColor(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060461));
            textView.setText(i2);
            ((BdBaseImageView) inflate.findViewById(R.id.ssl_header_icon)).setImageResource(i3);
            linearLayout.addView(inflate);
        }
    }

    public boolean l(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, sVar)) == null) {
            if (!f()) {
                if (c) {
                    Log.e("PageDialogsHandler", "can not showJsAlert");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            t43.a aVar = new t43.a(this.a);
            aVar.U(R.string.obfuscated_res_0x7f0f0187);
            aVar.x(str2);
            aVar.O(R.string.obfuscated_res_0x7f0f0149, new b(this, sVar));
            aVar.K(new a(this, sVar));
            if (wo2.M().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void o(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, tVar, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            SslCertificate certificate = sslError.getCertificate();
            if (certificate == null) {
                return;
            }
            k52.a h2 = h(certificate, sslError);
            h2.a0(new n43.a(this.a.getText(R.string.obfuscated_res_0x7f0f014b), R.color.obfuscated_res_0x7f06045f, new q(this, tVar)));
            h2.K(new p(this, tVar));
            h2.X();
        }
    }

    public final k52.a h(SslCertificate sslCertificate, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sslCertificate, sslError)) == null) {
            View j2 = j(sslCertificate);
            LinearLayout linearLayout = (LinearLayout) j2.findViewById(R.id.obfuscated_res_0x7f091cce);
            j2.findViewById(R.id.ssl_divider).setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060417));
            if (sslError == null) {
                c(linearLayout, R.string.obfuscated_res_0x7f0f01fd);
            } else {
                if (sslError.hasError(3)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f0207);
                }
                if (sslError.hasError(2)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f0204);
                }
                if (sslError.hasError(1)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f0201);
                }
                if (sslError.hasError(0)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f0205);
                }
                if (sslError.hasError(4)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f0200);
                }
                if (sslError.hasError(5)) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f0203);
                }
                if (linearLayout.getChildCount() == 0) {
                    e(linearLayout, R.string.obfuscated_res_0x7f0f0206);
                }
            }
            k52.a aVar = new k52.a(this.a);
            aVar.d0(R.string.obfuscated_res_0x7f0f01fc);
            aVar.c0(j2);
            return aVar;
        }
        return (k52.a) invokeLL.objValue;
    }

    public final View j(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sslCertificate)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00d9, (ViewGroup) null);
            int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f060461);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090412);
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
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092600)).setText(issuedTo.getOName());
                ((TextView) inflate.findViewById(R.id.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) inflate.findViewById(R.id.by_common)).setText(issuedBy.getCName());
                ((TextView) inflate.findViewById(R.id.by_org)).setText(issuedBy.getOName());
                ((TextView) inflate.findViewById(R.id.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) inflate.findViewById(R.id.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
            ((TextView) inflate.findViewById(R.id.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    public void k(r rVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar, str, str2) == null) {
            h52 h52Var = new h52(this.a, str, str2);
            this.b = h52Var;
            h52Var.h(new i(this, rVar));
            this.b.g(new j(this, rVar));
            this.b.i();
        }
    }

    public boolean m(String str, String str2, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, sVar)) == null) {
            if (!f()) {
                if (c) {
                    Log.e("PageDialogsHandler", "can not showJsConfirm");
                }
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            t43.a aVar = new t43.a(this.a);
            aVar.U(R.string.obfuscated_res_0x7f0f0187);
            aVar.x(str2);
            aVar.O(R.string.obfuscated_res_0x7f0f0149, new e(this, sVar));
            aVar.B(R.string.obfuscated_res_0x7f0f0141, new d(this, sVar));
            aVar.K(new c(this, sVar));
            if (wo2.M().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void p(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, tVar, sslErrorHandler, sslError) == null) {
            if (!f()) {
                sslErrorHandler.cancel();
                return;
            }
            j52.c cVar = new j52.c(this.a);
            cVar.g0(R.string.obfuscated_res_0x7f0f01ef);
            cVar.f0(R.string.obfuscated_res_0x7f0f0208, new o(this, sslError));
            cVar.a0(new n43.a(this.a.getText(R.string.obfuscated_res_0x7f0f01fe), R.color.obfuscated_res_0x7f060465, new n(this, tVar)));
            cVar.a0(new n43.a(this.a.getText(R.string.obfuscated_res_0x7f0f0217), R.color.obfuscated_res_0x7f06045f, new m(this, tVar, sslErrorHandler, sslError)));
            cVar.a0(new n43.a(this.a.getText(R.string.obfuscated_res_0x7f0f0202), R.color.obfuscated_res_0x7f06045f, new l(this, tVar)));
            cVar.K(new k(this, sslErrorHandler));
            cVar.X();
        }
    }

    public boolean n(String str, String str2, String str3, s sVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, str2, str3, sVar)) == null) {
            if (!f()) {
                if (sVar != null) {
                    sVar.a();
                }
                return false;
            }
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00b9, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f09289c);
            editText.setText(str3);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091767)).setText(str2);
            t43.a aVar = new t43.a(this.a);
            aVar.U(R.string.obfuscated_res_0x7f0f0187);
            aVar.W(inflate);
            aVar.O(R.string.obfuscated_res_0x7f0f0149, new h(this, sVar, editText));
            aVar.B(R.string.obfuscated_res_0x7f0f0141, new g(this, sVar));
            aVar.K(new f(this, sVar));
            if (wo2.M().a()) {
                aVar.Y(false);
            } else {
                aVar.Y(true);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
