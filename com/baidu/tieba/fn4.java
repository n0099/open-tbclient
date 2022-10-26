package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class fn4 implements en4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fn4() {
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

    public void c(String[] strArr, StringBuilder sb, Map map, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048576, this, strArr, sb, map, i) == null) && strArr != null && strArr.length > i && map != null && sb != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (i < strArr.length) {
                String str = "@" + strArr[i];
                Iterator it = map.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (str.startsWith((String) entry.getKey())) {
                            String replace = str.replace((CharSequence) entry.getKey(), "");
                            if ("@p".equals(entry.getKey())) {
                                String d = d(replace);
                                if (!StringUtils.isNull(d)) {
                                    linkedHashMap.put(entry.getValue(), d);
                                }
                            } else {
                                linkedHashMap.put(entry.getValue(), replace);
                            }
                        }
                    }
                }
                i++;
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (!StringUtils.isNull((String) entry2.getKey()) && !StringUtils.isNull((String) entry2.getValue())) {
                    String str2 = "?";
                    if (sb.toString().contains("?")) {
                        str2 = "&";
                    }
                    sb.append(str2);
                    sb.append((String) entry2.getKey());
                    sb.append("=");
                    sb.append((String) entry2.getValue());
                }
            }
        }
    }

    public final String d(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 81) {
                if (hashCode != 104) {
                    if (hashCode != 112) {
                        if (hashCode != 119) {
                            if (hashCode != 122) {
                                if (hashCode != 98) {
                                    if (hashCode == 99 && str.equals("c")) {
                                        c = 1;
                                    }
                                    c = 65535;
                                } else {
                                    if (str.equals("b")) {
                                        c = 2;
                                    }
                                    c = 65535;
                                }
                            } else {
                                if (str.equals("z")) {
                                    c = 5;
                                }
                                c = 65535;
                            }
                        } else {
                            if (str.equals("w")) {
                                c = 0;
                            }
                            c = 65535;
                        }
                    } else {
                        if (str.equals("p")) {
                            c = 4;
                        }
                        c = 65535;
                    }
                } else {
                    if (str.equals("h")) {
                        c = 3;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("Q")) {
                    c = 6;
                }
                c = 65535;
            }
            switch (c) {
                case 0:
                    return PbModel.WISE;
                case 1:
                    return ThirdPartyUtil.TYPE_WEIXIN;
                case 2:
                    return "shoubai";
                case 3:
                    return "tbShareH5";
                case 4:
                    return "pc";
                case 5:
                    return "zhongjianye";
                case 6:
                    return com.tencent.connect.common.Constants.SOURCE_QQ;
                default:
                    return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
