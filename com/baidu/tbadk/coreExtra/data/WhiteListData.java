package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ht4;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class WhiteListData extends LinkedList<String> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HTTPS_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";
    public static final long serialVersionUID = -7967671019705518672L;
    public transient /* synthetic */ FieldHolder $fh;

    public WhiteListData() {
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

    public static WhiteListData createBySP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            WhiteListData whiteListData = new WhiteListData();
            String q = ht4.k().q("key_white_list", null);
            if (!TextUtils.isEmpty(q)) {
                whiteListData.parserJson(q);
            }
            return whiteListData;
        }
        return (WhiteListData) invokeV.objValue;
    }

    private void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        add(optString);
                    }
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
    }

    private void save(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            ht4.k().y("key_white_list", str);
        }
    }

    public boolean checkHostname(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            Iterator<String> it = iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    String lowerCase2 = next.toLowerCase();
                    if (lowerCase.startsWith(lowerCase2)) {
                        return true;
                    }
                    if (lowerCase.startsWith("http://") && lowerCase.substring(7).startsWith(lowerCase2)) {
                        return true;
                    }
                    if (lowerCase.startsWith("https://") && lowerCase.substring(8).startsWith(lowerCase2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean checkUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            Iterator<String> it = iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    String lowerCase2 = next.toLowerCase();
                    if (lowerCase.startsWith(lowerCase2)) {
                        return true;
                    }
                    if (lowerCase.startsWith("http://") && lowerCase.substring(7).startsWith(lowerCase2)) {
                        return true;
                    }
                    if (lowerCase.startsWith("https://") && lowerCase.substring(8).startsWith(lowerCase2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void saveJson(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            if (jSONArray == null) {
                save(null);
            } else {
                save(jSONArray.toString());
            }
        }
    }
}
