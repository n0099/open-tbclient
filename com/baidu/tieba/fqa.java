package com.baidu.tieba;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                sb.append("\n");
            }
            return sb.toString().getBytes();
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean c(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            if (bArr == null) {
                return false;
            }
            pf pfVar = new pf();
            pfVar.b().s(str);
            pfVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
            pfVar.b().c("", bArr);
            new mf(pfVar).m(3, -1, -1);
            int i = pfVar.c().b;
            byte[] bArr2 = pfVar.c().i;
            if (bArr2 == null || i != 200) {
                return false;
            }
            try {
                if (new JSONObject(new String(bArr2, "utf-8")).optJSONObject("error").optInt("errno") != 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
