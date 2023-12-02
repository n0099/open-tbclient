package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.meme.list.GeneratedLoadedData;
import com.baidu.tbadk.editortools.meme.list.MemeData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gg5 {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final List<MemeData> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947792980, "Lcom/baidu/tieba/gg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947792980, "Lcom/baidu/tieba/gg5;");
                return;
            }
        }
        c = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final gg5 a(JSONObject jsonObject) {
            InterceptResult invokeL;
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonObject)) == null) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                int optInt = jsonObject.optInt("status");
                JSONArray optJSONArray = jsonObject.optJSONArray("meme_list");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null) {
                    int i = 0;
                    int length = optJSONArray.length();
                    if (length >= 0) {
                        while (true) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(i)");
                                long optLong = optJSONObject.optLong("id");
                                int optInt2 = optJSONObject.optInt("type");
                                String src = optJSONObject.optString("src");
                                int optInt3 = optJSONObject.optInt("obj_source");
                                GeneratedLoadedData generatedLoadedData = new GeneratedLoadedData();
                                Intrinsics.checkNotNullExpressionValue(src, "src");
                                jSONArray = optJSONArray;
                                arrayList.add(generatedLoadedData.copyWithoutType(new MemeData(optLong, optInt2, src, optInt3, null, 16, null)));
                            } else {
                                jSONArray = optJSONArray;
                            }
                            if (i == length) {
                                break;
                            }
                            i++;
                            optJSONArray = jSONArray;
                        }
                    }
                }
                return new gg5(optInt, arrayList);
            }
            return (gg5) invokeL.objValue;
        }
    }

    public gg5(int i, List<? extends MemeData> memeList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), memeList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(memeList, "memeList");
        this.a = i;
        this.b = memeList;
    }

    public final List<MemeData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }
}
