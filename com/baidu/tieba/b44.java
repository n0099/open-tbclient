package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b44 extends n34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947594983, "Lcom/baidu/tieba/b44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947594983, "Lcom/baidu/tieba/b44;");
                return;
            }
        }
        c = rr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b44() {
        super("ReservationGame");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.n34
    public h32 a(@NonNull JSONObject jSONObject, @NonNull lo2 lo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lo2Var)) == null) {
            if (jSONObject == null) {
                lo2Var.onFail(202, "params may be error");
                return null;
            }
            if (c) {
                Log.e("ReservationGameAction", "params is " + jSONObject.toString());
            }
            String optString = jSONObject.optString("apkId");
            int optInt = jSONObject.optInt("isReservation");
            if (TextUtils.isEmpty(optString)) {
                lo2Var.onFail(31023, "reservation apk id is empty");
                return null;
            } else if (optInt == 0) {
                lo2Var.onFail(31024, "reservation status error");
                return null;
            } else {
                String string = vj3.a().getString("reservation_apk_ids", "");
                if (optInt != 1) {
                    if (optInt == 2) {
                        if (b(string, optString)) {
                            lo2Var.onSuccess(null);
                        } else {
                            lo2Var.onFail(31025, "reservation cancel fail");
                        }
                    }
                } else {
                    d(string, optString);
                    lo2Var.onSuccess(null);
                }
                return null;
            }
        }
        return (h32) invokeLL.objValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(str.split(",")));
            boolean remove = arrayList.remove(str2);
            if (remove) {
                c(arrayList);
            }
            return remove;
        }
        return invokeLL.booleanValue;
    }

    public final void c(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuffer.append(arrayList.get(i));
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            vj3.a().putString("reservation_apk_ids", stringBuffer.toString());
        }
    }

    public final void d(String str, String str2) {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                hashSet = new HashSet();
            } else {
                hashSet = new HashSet(Arrays.asList(str.split(",")));
            }
            hashSet.add(str2);
            c(new ArrayList<>(hashSet));
        }
    }
}
