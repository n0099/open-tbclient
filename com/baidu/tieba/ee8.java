package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.fe8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ee8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements fe8.c {
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

        /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.fe8.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(HashMap<String, String> hashMap) {
            String str;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            Class<?> cls = null;
            try {
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(this.a, "UTF-8"));
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
                            cls = Class.forName(hashMap.get(str));
                            if (cls == null) {
                            }
                        }
                    }
                    jSONObject.put("page", str);
                    jSONObject.put("refre", optString);
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = null;
                }
            } catch (Exception e3) {
                e = e3;
                str = null;
                jSONObject = null;
            }
            try {
                cls = Class.forName(hashMap.get(str));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (cls == null) {
                Intent intent = new Intent(this.b.getPageActivity(), cls);
                if (jSONObject != null) {
                    intent.putExtra("key_schema_params", jSONObject.toString());
                }
                this.b.getPageActivity().startActivity(intent);
            }
        }
    }

    public static int a(TbPageContext<?> tbPageContext, String[] strArr) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, strArr)) == null) {
            if (tbPageContext == null || strArr == null || strArr.length == 0 || (str = strArr[0]) == null || !str.startsWith("tiebaapp://router/portal")) {
                return 3;
            }
            try {
                fe8.c().b(new a(Uri.parse(str).getQueryParameter("params"), tbPageContext));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        return invokeLL.intValue;
    }
}
