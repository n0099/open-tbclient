package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ad5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Double> a;
    public List<Integer> b;

    public ad5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)})) == null) {
            if (!ListUtils.isEmpty(this.a) && !ListUtils.isEmpty(this.b)) {
                for (int i = 0; i < this.a.size(); i++) {
                    if (d <= this.a.get(i).doubleValue()) {
                        return b(i);
                    }
                    if (i == this.a.size() - 1) {
                        return b(i + 1);
                    }
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public final int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < this.b.size()) {
                return this.b.get(i).intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("divide");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.a = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        double optDouble = optJSONArray.optDouble(i);
                        if (!Double.isNaN(optDouble)) {
                            this.a.add(Double.valueOf(optDouble));
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("threshold");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.b = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.b.add(Integer.valueOf(optJSONArray2.optInt(i2)));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
