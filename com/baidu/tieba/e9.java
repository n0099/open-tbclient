package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.abtest.ioc.CSPDataComponent;
import com.baidu.searchbox.abtest.ioc.ICSPDataService;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public a(e9 e9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                ArrayList arrayList = new ArrayList();
                for (a9 a9Var : this.a) {
                    try {
                        jSONObject.put(a9Var.c(), a9Var.e());
                        jSONObject2.put(a9Var.c(), a9Var.d());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    s8 a = s8.a(a9Var.b());
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                y10.k(jSONObject, jSONObject2, arrayList);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302009, "Lcom/baidu/tieba/e9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302009, "Lcom/baidu/tieba/e9;");
                return;
            }
        }
        b = Boolean.valueOf(AppConfig.isDebug());
    }

    public e9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    public List<a9> a(Context context) {
        InterceptResult invokeL;
        String config;
        List<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            boolean e = r8.d(context).e();
            if (b.booleanValue()) {
                Log.d("CSPDataProcessor", "getClientSampleData: is new install? " + e);
            }
            if (!e || this.a) {
                return null;
            }
            CSPDataComponent cSPDataComponent = new CSPDataComponent();
            fk1<ICSPDataService> fk1Var = cSPDataComponent.cspServiceHolder;
            if (fk1Var != null && fk1Var.get() != null) {
                try {
                    config = cSPDataComponent.cspServiceHolder.get().config();
                } catch (Exception e2) {
                    if (b.booleanValue()) {
                        Log.d("CSPDataProcessor", "getClientSampleData: process client sample data has error " + e2.getMessage());
                    }
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(config)) {
                    if (b.booleanValue()) {
                        Log.d("CSPDataProcessor", "getClientSampleData: client sample data is null, just return");
                    }
                    return null;
                }
                JSONObject jSONObject = new JSONObject(config);
                if (b.booleanValue()) {
                    Log.d("CSPDataProcessor", "getClientSampleData: client sample data: " + jSONObject);
                }
                String string = jSONObject.getString("beginVersion");
                String string2 = jSONObject.getString(SchemeDescPatchListener.END_VERSION);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    long a2 = r8.d(context).a(string + ".0");
                    long a3 = r8.d(context).a(string2 + ".0");
                    String b2 = r8.d(context).b();
                    long a4 = r8.d(context).a(b2 + ".0");
                    if (b.booleanValue()) {
                        Log.d("CSPDataProcessor", "getClientSampleData: begin version code: " + a2);
                        Log.d("CSPDataProcessor", "getClientSampleData: end version code: " + a3);
                        Log.d("CSPDataProcessor", "getClientSampleData: current version name: " + b2);
                        Log.d("CSPDataProcessor", "getClientSampleData: current version code: " + a4);
                    }
                    if (a4 >= a2 && a4 < a3) {
                        String string3 = jSONObject.getString("sample");
                        if (TextUtils.isEmpty(string3)) {
                            if (b.booleanValue()) {
                                Log.d("CSPDataProcessor", "getClientSampleData: sample is null, just return");
                            }
                            return null;
                        }
                        JSONObject jSONObject2 = new JSONObject(string3);
                        String e3 = k20.f(AppRuntime.getAppContext()).e();
                        if (b.booleanValue()) {
                            Log.d("CSPDataProcessor", "getClientSampleData: current iid: " + e3);
                        }
                        ArrayList<String> arrayList = new ArrayList();
                        if (AppConfig.isDebug() && (c = r8.d(context).c()) != null && c.size() > 0) {
                            Log.d("CSPDataProcessor", "getClientSampleData: debug force sample is " + c);
                            arrayList.addAll(c);
                        }
                        int i = 0;
                        if (arrayList.size() == 0) {
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String str = e3 + next;
                                byte[] bytes = str.getBytes();
                                long a5 = w8.a(bytes, bytes.length, i);
                                if (a5 < 0) {
                                    a5 = -a5;
                                }
                                int i2 = (int) (a5 % 100);
                                if (b.booleanValue()) {
                                    Log.d("CSPDataProcessor", "getClientSampleData: salt " + str + ", sampleValue: " + i2);
                                }
                                JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                                Iterator<String> keys2 = jSONObject3.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    JSONArray jSONArray = jSONObject3.getJSONArray(next2);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i3 = 0;
                                        while (i3 < jSONArray.length()) {
                                            JSONArray jSONArray2 = jSONArray.getJSONArray(i3);
                                            String str2 = e3;
                                            JSONObject jSONObject4 = jSONObject2;
                                            int i4 = jSONArray2.getInt(0);
                                            int i5 = jSONArray2.getInt(1);
                                            if (i2 >= i4 && i2 < i5) {
                                                if (b.booleanValue()) {
                                                    Log.d("CSPDataProcessor", "getClientSampleData: salt " + next + ", hit sid: " + next2);
                                                }
                                                arrayList.add(next2);
                                            }
                                            i3++;
                                            jSONObject2 = jSONObject4;
                                            e3 = str2;
                                        }
                                    }
                                    jSONObject2 = jSONObject2;
                                    e3 = e3;
                                    i = 0;
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            String string4 = jSONObject.getString(SapiOptions.Gray.FUN_NAME_MAPPING);
                            if (TextUtils.isEmpty(string4)) {
                                if (b.booleanValue()) {
                                    Log.d("CSPDataProcessor", "getClientSampleData: mapping data is null, just return");
                                    return null;
                                }
                                return null;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            JSONObject jSONObject5 = new JSONObject(string4);
                            if (b.booleanValue()) {
                                Log.d("CSPDataProcessor", "getClientSampleData: mapping data is " + jSONObject5);
                            }
                            for (String str3 : arrayList) {
                                JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                                if (b.booleanValue()) {
                                    Log.d("CSPDataProcessor", "getClientSampleData: sid " + str3 + " data is " + optJSONArray);
                                }
                                if (optJSONArray != null) {
                                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                        JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                                        if (optJSONObject != null) {
                                            arrayList2.add(new a9(optJSONObject.getString("key"), optJSONObject.get("data"), optJSONObject.optInt(TitanConstant.KEY_INSTANT_INIT_CLASS, 1), str3, optJSONObject.optString("version", "0")));
                                        }
                                    }
                                }
                            }
                            d9.b().g(jSONObject.getString("kvVersion"));
                            b(arrayList2);
                            return arrayList2;
                        }
                        this.a = true;
                        return null;
                    }
                    if (b.booleanValue()) {
                        Log.d("CSPDataProcessor", "getClientSampleData: not in legal version range, just return");
                        return null;
                    }
                    return null;
                }
                if (b.booleanValue()) {
                    Log.d("CSPDataProcessor", "getClientSampleData: begin version or end version has null, just return");
                    return null;
                }
                return null;
            } else if (b.booleanValue()) {
                Log.d("CSPDataProcessor", "getClientSampleData: CSPDataComponent has no implement, just return");
                return null;
            } else {
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    public void b(List<a9> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this, list), "saveLocalInfoToFileASync", 2);
        }
    }
}
