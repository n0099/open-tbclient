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
/* loaded from: classes4.dex */
public class fw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<DialogStrategiesData> c;
    public static volatile fw4 d;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Map<String, List<DialogStrategiesData>> a;
    public final Set<String> b;

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<DialogStrategiesData> list);
    }

    /* loaded from: classes4.dex */
    public class a extends nj5<List<DialogStrategiesData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw4 a;

        public a(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj5
        /* renamed from: a */
        public List<DialogStrategiesData> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.i();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements si5<List<DialogStrategiesData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fw4 c;

        public b(fw4 fw4Var, c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw4Var, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fw4Var;
            this.a = cVar;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.si5
        /* renamed from: a */
        public void onReturnDataInUI(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                return;
            }
            this.c.k(list);
            if (this.a != null) {
                List<DialogStrategiesData> list2 = (List) this.c.a.get(this.b);
                c cVar = this.a;
                if (ListUtils.isEmpty(list2)) {
                    list2 = fw4.c;
                }
                cVar.a(list2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778534, "Lcom/baidu/tieba/fw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778534, "Lcom/baidu/tieba/fw4;");
                return;
            }
        }
        c = Collections.emptyList();
    }

    public fw4() {
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

    public static fw4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (d == null) {
                synchronized (fw4.class) {
                    if (d == null) {
                        d = new fw4();
                    }
                }
            }
            return d;
        }
        return (fw4) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return "key_yun_dialog_strategies@" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public void e(@NonNull String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (this.a == null) {
                this.a = new LinkedHashMap();
            }
            List<DialogStrategiesData> list = this.a.get(str);
            if (list == null && this.a.isEmpty()) {
                rj5.b(new a(this), new b(this, cVar, str));
            } else if (cVar != null) {
                if (ListUtils.isEmpty(list)) {
                    list = c;
                }
                cVar.a(list);
            }
        }
    }

    public final void h(Map<String, List<DialogStrategiesData>> map, List<DialogStrategiesData> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, list, str) != null) || map == null) {
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

    public final List<DialogStrategiesData> i() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            df<String> i = iv4.i("tb.dialog_strategies_data", TbadkCoreApplication.getCurrentAccount(), g());
            if (i != null) {
                str = i.get(g());
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

    public void j(JSONArray jSONArray) {
        df<String> i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONArray) != null) || (i = iv4.i("tb.dialog_strategies_data", TbadkCoreApplication.getCurrentAccount(), g())) == null) {
            return;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            kw4.a.a(jSONArray.toString());
            try {
                k(DataExt.toEntityList(jSONArray.toString(), DialogStrategiesData.class));
                return;
            } catch (Exception e) {
                BdLog.e(e);
                return;
            }
        }
        i.remove(g());
        k(Collections.emptyList());
    }

    public final void k(List<DialogStrategiesData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            try {
                if (!ListUtils.isEmpty(list)) {
                    if (this.a == null) {
                        this.a = new LinkedHashMap();
                    }
                    this.a.clear();
                    for (DialogStrategiesData dialogStrategiesData : list) {
                        List<String> dialogTime = dialogStrategiesData.getDialogTime();
                        if (!ListUtils.isEmpty(dialogTime)) {
                            this.b.addAll(dialogTime);
                        }
                    }
                    for (String str : this.b) {
                        h(this.a, list, str);
                    }
                    return;
                }
                if (this.a != null) {
                    this.a.clear();
                }
                this.b.clear();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
