package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fu2 extends gu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] A;
    public ArrayList<nu2> z;

    public fu2() {
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
        this.A = new int[]{0, 0, 0, 0};
    }

    @Override // com.baidu.tieba.gu2, com.baidu.tieba.k32, com.baidu.tieba.tx2
    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has("points") && (jSONArray2 = jSONObject.getJSONArray("points")) != null && jSONArray2.length() > 0) {
            int length = jSONArray2.length();
            this.z = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2 != null) {
                    nu2 nu2Var = new nu2();
                    nu2Var.a(jSONObject2);
                    if (nu2Var.isValid()) {
                        this.z.add(nu2Var);
                    }
                }
            }
        }
        if (jSONObject.has(CriusAttrConstants.PADDING) && (jSONArray = jSONObject.getJSONArray(CriusAttrConstants.PADDING)) != null && jSONArray.length() > 0) {
            int min = Math.min(jSONArray.length(), 4);
            for (int i2 = 0; i2 < min; i2++) {
                this.A[i2] = ll3.g(jSONArray.optInt(i2));
            }
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.tieba.tx2
    public boolean isValid() {
        InterceptResult invokeV;
        ArrayList<nu2> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.b) && (arrayList = this.z) != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
