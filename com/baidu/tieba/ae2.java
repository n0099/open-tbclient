package com.baidu.tieba;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.zd2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ae2 implements zd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zd2.b a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2 a;

        public a(ae2 ae2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    public ae2(zd2.b bVar) {
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
        this.a = bVar == null ? new zd2.b() : bVar;
    }

    public ae2 b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (e() && !TextUtils.isEmpty(str) && !d(this.a.a.get(str))) {
                yd2 query = yd2.query(str);
                if (d(query)) {
                    this.a.a.put(query.a(), query);
                }
            }
            return this;
        }
        return (ae2) invokeL.objValue;
    }

    public static boolean d(zd2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            if (aVar != null && aVar.isValid()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ae2 m(zd2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar)) == null) {
            return new ae2(bVar);
        }
        return (ae2) invokeL.objValue;
    }

    public ae2 i(int i) {
        InterceptResult invokeI;
        zd2.b bVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (e() && i != (i2 = (bVar = this.a).d) && (i2 == 0 || i2 == bVar.c)) {
                this.a.d = i;
            }
            return this;
        }
        return (ae2) invokeI.objValue;
    }

    public ae2 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (e()) {
                this.a.c = i;
            }
            return this;
        }
        return (ae2) invokeI.objValue;
    }

    public static ae2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return m(null);
        }
        return (ae2) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            zd2.b bVar = this.a;
            int i = bVar.d;
            if (i == 0) {
                return bVar.c;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.a) {
                z = this.a.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public zd2.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (zd2.b) invokeV.objValue;
    }

    public final void f() {
        String str;
        zd2.a value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.a) {
                if (!e()) {
                    return;
                }
                this.a.b = false;
                hb3 hb3Var = new hb3();
                hb3Var.a = "swan";
                hb3Var.c = "NA";
                int c = c();
                hb3Var.b = String.valueOf(c);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, zd2.a> entry : this.a.a.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.b());
                    }
                }
                hb3Var.a("purged_list", jSONArray);
                if (7 == c) {
                    hb3Var.a("history_list", h());
                    hb3Var.a("disk_size", g());
                }
                if (zd2.m0) {
                    JSONObject f = hb3Var.f();
                    if (f == null) {
                        str = StringUtil.NULL_STRING;
                    } else {
                        try {
                            str = f.toString(4);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            str = "" + hb3Var;
                        }
                    }
                    BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                Log.i("PurgerStatistic", "report event => " + readLine);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } finally {
                            jk4.d(bufferedReader);
                        }
                    }
                }
                ya3.x("1377", hb3Var);
            }
        }
    }

    @NonNull
    public final JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            int a2 = th3.a();
            int i = nb3.i();
            int b = nb3.b();
            int k = nb3.k();
            try {
                jSONObject.put(Config.DEVICE_PART, a2);
                jSONObject.put("swan_pkg", i);
                jSONObject.put("app_pkg", b);
                jSONObject.put("app_third", k);
            } catch (JSONException e) {
                if (zd2.m0) {
                    e.printStackTrace();
                    Log.i("PurgerStatistic", "queryDiskSize: e=" + e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public final JSONArray h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                Cursor m = ib2.m();
                int count = m.getCount();
                while (m.moveToNext()) {
                    String string = m.getString(m.getColumnIndex("app_id"));
                    long j = m.getLong(m.getColumnIndex("visit_time"));
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(IntentConfig.PKG_ID, string);
                        jSONObject.put("last_launch_time", j);
                        jSONArray.put(jSONObject);
                    }
                }
                if (zd2.m0) {
                    Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
                }
                if (m != null) {
                    m.close();
                }
            } catch (JSONException e) {
                if (zd2.m0) {
                    e.printStackTrace();
                    Log.i("PurgerStatistic", "queryHisList: e=" + e);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (zd2.m0) {
                Log.i("PurgerStatistic", "performReport: " + this.a);
            }
            if (e()) {
                ExecutorUtilsExt.postOnElastic(new a(this), "PurgerStatistic", 3);
            }
        }
    }
}
