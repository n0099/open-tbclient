package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e97 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e97 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ArrayList<FunAdHistoryData>> a;

    public e97() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.clear();
        this.a.putAll(d());
    }

    public static e97 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (e97.class) {
                    if (b == null) {
                        b = new e97();
                    }
                }
            }
            return b;
        }
        return (e97) invokeV.objValue;
    }

    public void a(String str, FunAdHistoryData funAdHistoryData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, funAdHistoryData) == null) && UbsABTestHelper.isDuplicateRemovalFunAdABTest() && !TextUtils.isEmpty(str) && funAdHistoryData != null) {
            ArrayList<FunAdHistoryData> c = c(str);
            if (c == null) {
                c = new ArrayList<>();
            }
            c.add(funAdHistoryData);
            g(c);
            g97.e().a(str);
            j(str);
        }
    }

    public final ArrayList<FunAdHistoryData> b(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList<FunAdHistoryData> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
                try {
                    funAdHistoryData.parserJson(jSONArray.getJSONObject(i));
                    arrayList.add(funAdHistoryData);
                } catch (JSONException e) {
                    BdLog.detailException(e);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void i(ArrayList<FunAdHistoryData> arrayList) {
        FunAdHistoryData next;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, arrayList) != null) || arrayList == null) {
            return;
        }
        Iterator<FunAdHistoryData> it = arrayList.iterator();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        while (it.hasNext() && (next = it.next()) != null && currentTimeMillis - next.getShowTime() > 86400) {
            it.remove();
        }
    }

    public ArrayList<FunAdHistoryData> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                return this.a.get(str);
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void g(ArrayList<FunAdHistoryData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, arrayList) != null) || arrayList == null) {
            return;
        }
        h(arrayList);
        i(arrayList);
    }

    public final void h(ArrayList<FunAdHistoryData> arrayList) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, arrayList) != null) || arrayList == null || (size = arrayList.size()) <= 600) {
            return;
        }
        ListUtils.removeSubList(arrayList, 0, size - 600);
    }

    public final Map<String, ArrayList<FunAdHistoryData>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap hashMap = new HashMap();
            for (String str : g97.e().c()) {
                if (!TextUtils.isEmpty(str)) {
                    ArrayList<FunAdHistoryData> e = e(str);
                    if (e == null) {
                        e = new ArrayList<>();
                    }
                    hashMap.put(str, e);
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public final ArrayList<FunAdHistoryData> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            JSONArray jSONArray = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SharedPreferences g = g97.g();
            String string = g.getString(str + "_fun_ad_history_key_suffix", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException e) {
                BdLog.detailException(e);
            }
            return b(jSONArray);
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void j(String str) {
        ArrayList<FunAdHistoryData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || this.a == null || TextUtils.isEmpty(str) || !this.a.containsKey(str) || (arrayList = this.a.get(str)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FunAdHistoryData> it = arrayList.iterator();
        while (it.hasNext()) {
            JSONObject json = it.next().toJson();
            if (json != null) {
                jSONArray.put(json);
            }
        }
        SharedPreferences g = g97.g();
        EditorHelper.putString(g, str + "_fun_ad_history_key_suffix", jSONArray.toString());
    }
}
