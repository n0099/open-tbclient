package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.cy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class by8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements cy8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TbPageContext b;

        public a(String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = tbPageContext;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0080 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.tieba.cy8.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(HashMap<String, String> hashMap) {
            JSONObject jSONObject;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            Class<?> cls = null;
            try {
                JSONObject jSONObject2 = new JSONObject(this.a);
                str = jSONObject2.optString("page");
                try {
                    String optString = jSONObject2.optString("refre");
                    jSONObject = jSONObject2.optJSONObject("pageParams");
                    if (jSONObject == null) {
                        try {
                            jSONObject = new JSONObject();
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (jSONObject == null) {
                            }
                        }
                    }
                    jSONObject.put("page", str);
                    jSONObject.put("refre", optString);
                    jSONObject.put("from", 1);
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = null;
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
                str = null;
            }
            if (jSONObject == null) {
                try {
                    cls = Class.forName(hashMap.get(str));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (cls == null) {
                    return;
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (cls2.isAssignableFrom(ay8.class)) {
                        try {
                            ((ay8) cls.newInstance()).dispatch(jSONObject, this.b.getPageActivity());
                            return;
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return;
                        }
                    }
                }
            }
        }
    }

    public static int a(TbPageContext<?> tbPageContext, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, strArr)) == null) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (TextUtils.isEmpty(str)) {
                    return 3;
                }
                if (!str.startsWith("tiebaapp://router/portal") && !str.startsWith("com.baidu.tieba://unidispatch/router/portal") && ((str = dj.getUrlDecode(str)) == null || !str.startsWith("com.baidu.tieba://unidispatch/router/portal"))) {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        cy8.c().b(new a(Uri.parse(str).getQueryParameter("params"), tbPageContext));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            }
            return 3;
        }
        return invokeLL.intValue;
    }
}
