package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.tieba.ha3;
import com.baidu.tieba.ia3;
import com.baidu.tieba.na3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ma3 f;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "PickerApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Date b;
        public final /* synthetic */ Date c;
        public final /* synthetic */ Date d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ f02 h;

        /* renamed from: com.baidu.tieba.f02$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class DialogInterface$OnCancelListenerC0272a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public DialogInterface$OnCancelListenerC0272a(a aVar) {
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

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    a aVar = this.a;
                    aVar.h.d(aVar.g, new h32(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
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

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    a aVar = this.a;
                    aVar.h.d(aVar.g, new h32(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public c(a aVar) {
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

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    dialogInterface.dismiss();
                    na3 na3Var = (na3) dialogInterface;
                    String format = String.format("%02d:%02d", Integer.valueOf(na3Var.f()), Integer.valueOf(na3Var.g()));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("value", format);
                        this.a.h.d(this.a.g, new h32(0, jSONObject));
                    } catch (JSONException unused) {
                    }
                }
            }
        }

        public a(f02 f02Var, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f02Var, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = f02Var;
            this.a = str;
            this.b = date;
            this.c = date2;
            this.d = date3;
            this.e = z;
            this.f = str2;
            this.g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                na3.a aVar = new na3.a(this.h.getContext());
                if (!TextUtils.isEmpty(this.a)) {
                    aVar.n(this.a);
                }
                aVar.p(this.b);
                aVar.m(this.c);
                aVar.o(this.d);
                aVar.l(this.e);
                aVar.c(true);
                aVar.g(this.f);
                aVar.h(R.string.obfuscated_res_0x7f0f0147, new c(this));
                aVar.d(R.string.obfuscated_res_0x7f0f013f, new b(this));
                aVar.f(new DialogInterface$OnCancelListenerC0272a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Date b;
        public final /* synthetic */ Date c;
        public final /* synthetic */ Date d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ f02 h;

        /* loaded from: classes5.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    b bVar = this.a;
                    bVar.h.d(bVar.g, new h32(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.f02$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class DialogInterface$OnClickListenerC0273b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public DialogInterface$OnClickListenerC0273b(b bVar) {
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

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    b bVar = this.a;
                    bVar.h.d(bVar.g, new h32(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public c(b bVar) {
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

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    dialogInterface.dismiss();
                    if (dialogInterface instanceof ha3) {
                        String h = ((ha3) dialogInterface).h();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("value", h);
                            this.a.h.d(this.a.g, new h32(0, jSONObject));
                        } catch (JSONException unused) {
                            b bVar = this.a;
                            bVar.h.d(bVar.g, new h32(202));
                        }
                    }
                }
            }
        }

        public b(f02 f02Var, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f02Var, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = f02Var;
            this.a = str;
            this.b = date;
            this.c = date2;
            this.d = date3;
            this.e = z;
            this.f = str2;
            this.g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ha3.a aVar = new ha3.a(this.h.getContext());
                if (!TextUtils.isEmpty(this.a)) {
                    aVar.n(this.a);
                }
                aVar.p(this.b);
                aVar.m(this.c);
                aVar.o(this.d);
                aVar.l(this.e);
                aVar.c(true);
                aVar.g(this.f);
                aVar.h(R.string.obfuscated_res_0x7f0f0147, new c(this));
                aVar.d(R.string.obfuscated_res_0x7f0f013f, new DialogInterface$OnClickListenerC0273b(this));
                aVar.f(new a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ JSONArray b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ f02 f;

        /* loaded from: classes5.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    d dVar = this.a;
                    dVar.f.K(dialogInterface, dVar.c, dVar.d);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    d dVar = this.a;
                    dVar.f.K(dialogInterface, dVar.c, dVar.d);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public c(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    dialogInterface.dismiss();
                    this.a.f.f = null;
                    try {
                        JSONArray f = ((ia3) dialogInterface).f();
                        JSONObject jSONObject = new JSONObject();
                        if (f != null && f.length() > 0) {
                            if (this.a.c) {
                                jSONObject.put("value", f.optInt(0));
                            } else {
                                jSONObject.put("value", f);
                                jSONObject.put("type", "confirm");
                            }
                        }
                        this.a.f.d(this.a.d, new h32(0, jSONObject));
                    } catch (JSONException unused) {
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.f02$d$d  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0274d implements BdMultiPicker.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public C0274d(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bdMultiPicker, jSONObject) == null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                        jSONObject2.put("type", "columnChange");
                        this.a.f.d(this.a.d, new h32(0, jSONObject2));
                    } catch (JSONException unused) {
                        d dVar = this.a;
                        dVar.f.d(dVar.d, new h32(202));
                    }
                }
            }
        }

        public d(f02 f02Var, JSONArray jSONArray, JSONArray jSONArray2, boolean z, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f02Var, jSONArray, jSONArray2, Boolean.valueOf(z), jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = f02Var;
            this.a = jSONArray;
            this.b = jSONArray2;
            this.c = z;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ia3.a aVar = new ia3.a(this.f.getContext());
                f02 f02Var = this.f;
                aVar.l(this.a);
                aVar.m(this.b);
                aVar.o(this.c);
                aVar.n(new C0274d(this));
                aVar.c(true);
                aVar.g(this.e);
                aVar.h(R.string.obfuscated_res_0x7f0f0147, new c(this));
                aVar.d(R.string.obfuscated_res_0x7f0f013f, new b(this));
                aVar.f(new a(this));
                f02Var.f = aVar.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ JSONArray b;
        public final /* synthetic */ int c;
        public final /* synthetic */ f02 d;

        public c(f02 f02Var, int i, JSONArray jSONArray, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f02Var, Integer.valueOf(i), jSONArray, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f02Var;
            this.a = i;
            this.b = jSONArray;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d.f != null) {
                ((ia3) this.d.f).k(this.a, this.b, this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f02(@NonNull iz1 iz1Var) {
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

    public h32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new h32(202);
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                h82.c("PickerApi", "parse fail");
                return h32Var;
            }
            return E((JSONObject) s.second, false);
        }
        return (h32) invokeL.objValue;
    }

    public final h32 D(JSONObject jSONObject) {
        InterceptResult invokeL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString(GetUserAttrInfoResult.KEY_DATA_FIELDS);
            String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
            Date I = I(optString, strArr, "1900-01-01");
            Date I2 = I(optString2, strArr, "2099-12-31");
            if (I != null && I2 != null && !I2.before(I)) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    h82.c("PickerApi", "callback is null");
                    return new h32(1001, "callback is null");
                }
                Date I3 = I(optString3, strArr, null);
                if (I3 == null) {
                    I3 = new Date();
                }
                if (I3.before(I)) {
                    date = I;
                } else if (I3.after(I2)) {
                    date = I2;
                } else {
                    date = I3;
                }
                bp3.e0(new b(this, optString5, I, I2, date, optBoolean, optString4, optString6));
                return new h32(0);
            }
            return new h32(202);
        }
        return (h32) invokeL.objValue;
    }

    public final h32 F(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString(GetUserAttrInfoResult.KEY_DATA_FIELDS);
            if (TextUtils.isEmpty(optString)) {
                optString = BdPlayerProgressView.DEFAULT_TIME_TEXT;
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "23:59";
            }
            Date J = J(optString);
            Date J2 = J(optString2);
            Date J3 = J(optString3);
            if (J3 == null) {
                J3 = J(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
            }
            Date date = J3;
            if (J != null && J2 != null && !J2.before(J) && date != null) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    h82.c("PickerApi", "callback is null");
                    return new h32(1001, "callback is null");
                }
                bp3.e0(new a(this, optString5, J, J2, date, optBoolean, optString4, optString6));
                return new h32(0);
            }
            return new h32(202);
        }
        return (h32) invokeL.objValue;
    }

    public final h32 E(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, z)) == null) {
            if (this.f != null) {
                return new h32(1001);
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            String str2 = null;
            if (jSONObject != null) {
                jSONArray = jSONObject.optJSONArray("array");
                jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                str2 = jSONObject.optString("cb");
                str = jSONObject.optString("title");
            } else {
                str = "";
            }
            JSONArray jSONArray3 = jSONArray;
            JSONArray jSONArray4 = jSONArray2;
            String str3 = str2;
            String str4 = str;
            if (TextUtils.isEmpty(str3)) {
                h82.c("PickerApi", "callback is null");
                return new h32(1001, "callback is null");
            }
            bp3.e0(new d(this, jSONArray3, jSONArray4, z, jSONObject, str3, str4));
            return new h32(0);
        }
        return (h32) invokeLZ.objValue;
    }

    public h32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new h32(202);
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                h82.c("PickerApi", "parse fail");
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return new h32(202);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(optJSONArray);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(optInt);
                try {
                    jSONObject.put("array", jSONArray);
                    jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, jSONArray2);
                    return E(jSONObject, true);
                } catch (JSONException unused) {
                    return new h32(1001);
                }
            }
            return new h32(202);
        }
        return (h32) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r0.equals("time") == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h32 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            char c2 = 0;
            q("#showDatePickerView", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return new h32(1001);
            }
            String optString = jSONObject.optString("mode");
            if (TextUtils.isEmpty(optString)) {
                return new h32(202);
            }
            int hashCode = optString.hashCode();
            if (hashCode != 3076014) {
                if (hashCode == 3560141) {
                }
                c2 = 65535;
            } else {
                if (optString.equals(GfhKeyValue.TYPE_DATE)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return new h32(202);
                }
                return D(jSONObject);
            }
            return F(jSONObject);
        }
        return (h32) invokeL.objValue;
    }

    public h32 M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new h32(202);
            }
            if (this.f == null) {
                return new h32(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(CriusAttrConstants.COLUMN);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int optInt2 = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h82.c("PickerApi", "callback is null");
                    return new h32(1001, "callback is null");
                }
                if (optJSONArray != null) {
                    bp3.e0(new c(this, optInt, optJSONArray, optInt2));
                    d(optString, new h32(0, jSONObject));
                }
                return new h32(0);
            } catch (JSONException unused) {
                return new h32(202);
            }
        }
        return (h32) invokeL.objValue;
    }

    public final Date I(String str, String[] strArr, String str2) {
        InterceptResult invokeLLL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, strArr, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                date = vn3.d(str, strArr);
            } else {
                date = null;
            }
            if (date == null && !TextUtils.isEmpty(str2)) {
                return vn3.d(str2, strArr);
            }
            return date;
        }
        return (Date) invokeLLL.objValue;
    }

    public final Date J(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Date();
            }
            if (!str.contains(":") || (split = str.split(":")) == null || split.length != 2) {
                return null;
            }
            try {
                Date date = new Date();
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    if (parseInt >= 0 && parseInt < 24) {
                        date.setHours(parseInt);
                    }
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt2 >= 0 && parseInt2 < 60) {
                        date.setMinutes(parseInt2);
                    }
                } catch (NumberFormatException unused) {
                }
                return date;
            } catch (NumberFormatException unused2) {
                return null;
            }
        }
        return (Date) invokeL.objValue;
    }

    public final void K(DialogInterface dialogInterface, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{dialogInterface, Boolean.valueOf(z), str}) == null) {
            dialogInterface.dismiss();
            this.f = null;
            if (z) {
                d(str, new h32(0));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "cancel");
                d(str, new h32(0, jSONObject));
            } catch (JSONException unused) {
                d(str, new h32(202));
            }
        }
    }
}
