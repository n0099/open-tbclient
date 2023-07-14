package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class i0a {
    public static /* synthetic */ Interceptable $ic;
    public static i0a c;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, List<JSONObject>> a;
    public ConcurrentHashMap<String, Integer> b;

    public i0a() {
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
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public static i0a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (i0a.class) {
                    if (c == null) {
                        c = new i0a();
                    }
                }
            }
            return c;
        }
        return (i0a) invokeV.objValue;
    }

    public static JSONObject b(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadInfo)) == null) {
            if (threadInfo == null) {
                return null;
            }
            return c(threadInfo, threadInfo.fname);
        }
        return (JSONObject) invokeL.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a.put(str, new ArrayList());
        }
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return g(this.a.get(str));
        }
        return (String) invokeL.objValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Integer num = this.b.get(str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public static JSONObject c(ThreadInfo threadInfo, String str) {
        InterceptResult invokeLL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, threadInfo, str)) == null) {
            if (threadInfo == null) {
                return null;
            }
            String str2 = "" + threadInfo.tid;
            String str3 = "0";
            if (StringUtils.isNull(str2) || "0".equals(str2)) {
                str2 = "" + threadInfo.id;
            }
            if (threadInfo.video_info != null) {
                str3 = "" + threadInfo.video_info.video_duration;
            }
            StringBuilder sb = new StringBuilder();
            List<Abstract> list = threadInfo._abstract;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Abstract r6 = (Abstract) g09.d(list, i);
                    if (r6 != null && r6.type.intValue() == 0) {
                        sb.append(r6.text);
                    }
                }
            }
            String sb2 = sb.toString();
            String str4 = "" + threadInfo.author_id;
            User user = threadInfo.author;
            if (user != null && (l = user.id) != null && l.longValue() != 0) {
                str4 = "" + threadInfo.author.id;
            }
            if (StringUtils.isNull(str)) {
                str = threadInfo.fname;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", threadInfo.title);
                jSONObject.put("tid", str2);
                jSONObject.put("fname", str);
                jSONObject.put("abstract", sb2);
                jSONObject.put("author_id", str4);
                jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final String g(List<JSONObject> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            try {
                if (ListUtils.isEmpty(list)) {
                    return "";
                }
                JSONArray jSONArray = new JSONArray();
                for (JSONObject jSONObject : list) {
                    if (jSONObject != null) {
                        jSONArray.put(jSONObject);
                    }
                }
                return qi.j(jSONArray.toString().getBytes("UTF-8"));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public void h(String str, List<JSONObject> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            this.a.put(str, arrayList);
        }
    }

    public void i(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            this.b.put(str, Integer.valueOf(i));
        }
    }
}
