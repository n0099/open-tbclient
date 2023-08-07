package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j37;
import com.baidu.tieba.ne;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ap6 implements j37.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a extends jw5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;

        public a(String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, jSONObject};
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
            this.b = str2;
            this.c = str3;
            this.d = jSONObject;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    l45.g(this.a, this.b).g(this.c, this.d.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.jw5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public ap6() {
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

    @Override // com.baidu.tieba.j37.g
    public void a(String spaceName, String uid, String key, JSONObject value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, spaceName, uid, key, value) == null) {
            Intrinsics.checkNotNullParameter(spaceName, "spaceName");
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            nw5.b(new a(spaceName, uid, key, value), null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x001f A[SYNTHETIC] */
    @Override // com.baidu.tieba.j37.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, JSONObject> b(String spaceName, String uid) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spaceName, uid)) == null) {
            Intrinsics.checkNotNullParameter(spaceName, "spaceName");
            Intrinsics.checkNotNullParameter(uid, "uid");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                for (ne.b<String> bVar : gi.b(l45.g(spaceName, uid))) {
                    if (bVar != null) {
                        String str = bVar.a;
                        boolean z2 = false;
                        if (str != null && str.length() != 0) {
                            z = false;
                            if (!z) {
                                String str2 = bVar.b;
                                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                                    String str3 = bVar.a;
                                    Intrinsics.checkNotNullExpressionValue(str3, "element.key");
                                    linkedHashMap.put(str3, new JSONObject(bVar.b));
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return linkedHashMap;
        }
        return (Map) invokeLL.objValue;
    }
}
