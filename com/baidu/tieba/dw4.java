package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class dw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<DialogStrategiesData> c;
    public static volatile dw4 d;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Map<String, List<DialogStrategiesData>> a;
    public final Set<String> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718952, "Lcom/baidu/tieba/dw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718952, "Lcom/baidu/tieba/dw4;");
                return;
            }
        }
        c = Collections.emptyList();
    }

    public dw4() {
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
        this.b = new LinkedHashSet();
    }

    public static dw4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (dw4.class) {
                    if (d == null) {
                        d = new dw4();
                    }
                }
            }
            return d;
        }
        return (dw4) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "key_yun_dialog_strategies@" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public List<DialogStrategiesData> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a == null) {
                this.a = new LinkedHashMap();
            }
            List<DialogStrategiesData> list = this.a.get(str);
            if (list == null && this.a.isEmpty()) {
                List<DialogStrategiesData> e = e();
                if (e != null && !ListUtils.isEmpty(e)) {
                    for (DialogStrategiesData dialogStrategiesData : e) {
                        List<String> dialogTime = dialogStrategiesData.getDialogTime();
                        if (!ListUtils.isEmpty(dialogTime)) {
                            this.b.addAll(dialogTime);
                        }
                    }
                    for (String str2 : this.b) {
                        d(this.a, e, str2);
                    }
                }
                list = this.a.get(str);
            }
            if (list == null || ListUtils.isEmpty(list)) {
                return c;
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public final void g(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) {
            try {
                List<DialogStrategiesData> entityList = DataExt.toEntityList(jSONArray.toString(), DialogStrategiesData.class);
                if (!ListUtils.isEmpty(entityList)) {
                    if (this.a == null) {
                        this.a = new LinkedHashMap();
                    }
                    this.a.clear();
                    for (DialogStrategiesData dialogStrategiesData : entityList) {
                        List<String> dialogTime = dialogStrategiesData.getDialogTime();
                        if (!ListUtils.isEmpty(dialogTime)) {
                            this.b.addAll(dialogTime);
                        }
                    }
                    for (String str : this.b) {
                        d(this.a, entityList, str);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public final void d(Map<String, List<DialogStrategiesData>> map, List<DialogStrategiesData> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, map, list, str) != null) || map == null) {
            return;
        }
        for (DialogStrategiesData dialogStrategiesData : list) {
            if (map.containsKey(str)) {
                if (dialogStrategiesData.getDialogTime().contains(str)) {
                    map.get(str).add(dialogStrategiesData);
                }
            } else if (dialogStrategiesData.getDialogTime().contains(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dialogStrategiesData);
                map.put(str, arrayList);
            }
        }
    }

    public final List<DialogStrategiesData> e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cf<String> i = hv4.i("tb.dialog_strategies_data", TbadkCoreApplication.getCurrentAccount(), c());
            if (i != null) {
                str = i.get(c());
            } else {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                return c;
            }
            try {
                return DataExt.toEntityList(new JSONArray(str).toString(), DialogStrategiesData.class);
            } catch (Exception e) {
                BdLog.e(e);
                return c;
            }
        }
        return (List) invokeV.objValue;
    }

    public void f(JSONArray jSONArray) {
        cf<String> i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONArray) != null) || (i = hv4.i("tb.dialog_strategies_data", TbadkCoreApplication.getCurrentAccount(), c())) == null) {
            return;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            i.a(c(), jSONArray.toString());
            g(jSONArray);
            return;
        }
        i.remove(c());
    }
}
