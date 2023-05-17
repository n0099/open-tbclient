package com.baidu.tbadk.util;

import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.tbadk.util.gson.JavaGsonWidget;
import com.baidu.tbadk.util.gson.KotlinGsonWidget;
import com.baidu.tbadk.util.gson.KotlinReflectiveTypeAdapterFactory;
import com.baidu.tieba.es5;
import com.baidu.tieba.jx4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006¢\u0006\u0002\u0010\u0007\u001a/\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006¢\u0006\u0002\u0010\n\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00030\f\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u0004*\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u0004*\u00020\t\u001a\u0016\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b*\u00020\u000f\u001a\u0016\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b*\u00020\t\u001a\u0016\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b*\u00020\u0004\u001a\u001c\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b0\f*\u00020\u0004\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"GSON", "Lcom/google/gson/Gson;", "toEntity", ExifInterface.GPS_DIRECTION_TRUE, "", Bundle.EXTRA_KEY_CLAZZ, "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "", "", "(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "toEntityList", "", "toJSONObject", "Lorg/json/JSONObject;", "Landroid/os/Bundle;", "toJson", "toMap", "toMapList", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "DataExt")
/* loaded from: classes4.dex */
public final class DataExt {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final Gson GSON;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a implements ExclusionStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                return false;
            }
            return invokeL.booleanValue;
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

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                Intrinsics.checkNotNullParameter(f, "f");
                es5 es5Var = (es5) f.getAnnotation(es5.class);
                if (es5Var != null && !es5Var.serialize()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements ExclusionStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public b() {
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

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                Intrinsics.checkNotNullParameter(f, "f");
                es5 es5Var = (es5) f.getAnnotation(es5.class);
                if (es5Var != null && !es5Var.deserialize()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements ParameterizedType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class<T> a;

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? List.class : (Type) invokeV.objValue;
        }

        public c(Class<T> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Type[]{this.a} : (Type[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements ParameterizedType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? List.class : (Type) invokeV.objValue;
        }

        public d() {
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

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Type MAP_TYPE = JavaGsonWidget.a;
                Intrinsics.checkNotNullExpressionValue(MAP_TYPE, "MAP_TYPE");
                return new Type[]{MAP_TYPE};
            }
            return (Type[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(461363438, "Lcom/baidu/tbadk/util/DataExt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(461363438, "Lcom/baidu/tbadk/util/DataExt;");
                return;
            }
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        JavaGsonWidget.BadNumberFix.c(gsonBuilder);
        Gson create = gsonBuilder.registerTypeAdapter(JavaGsonWidget.a, new JavaGsonWidget.MapDeserializerDoubleAsIntFix()).registerTypeAdapter(KotlinGsonWidget.a, new KotlinGsonWidget.MapDeserializerDoubleAsIntFix(DataExt$GSON$1.INSTANCE)).registerTypeAdapterFactory(KotlinReflectiveTypeAdapterFactory.b.a(!jx4.e())).addSerializationExclusionStrategy(new a()).addDeserializationExclusionStrategy(new b()).create();
        Intrinsics.checkNotNullExpressionValue(create, "registerTypeAdapter(Gson…     })\n        .create()");
        GSON = create;
    }

    public static final <T> T toEntity(String str, Class<T> clazz) throws JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, clazz)) == null) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) GSON.fromJson(str, (Class<Object>) clazz);
        }
        return (T) invokeLL.objValue;
    }

    public static final <T> T toEntity(Map<String, ? extends Object> map, Class<T> clazz) throws JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, map, clazz)) == null) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) toEntity(toJson(map), clazz);
        }
        return (T) invokeLL.objValue;
    }

    public static final <T> List<T> toEntityList(String str, Class<T> clazz) throws JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, clazz)) == null) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            List<T> list = (List) GSON.fromJson(str, new c(clazz));
            if (list == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }

    public static final JSONObject toJSONObject(android.os.Bundle bundle) {
        InterceptResult invokeL;
        Object obj;
        Object wrap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            Intrinsics.checkNotNullParameter(bundle, "<this>");
            JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                try {
                    obj = bundle.get(str);
                    wrap = JSONObject.wrap(obj);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                if (wrap == null) {
                    if (obj instanceof android.os.Bundle) {
                        obj = toJSONObject((android.os.Bundle) obj);
                    } else if ((obj instanceof Serializable) || (obj instanceof Parcelable)) {
                        wrap = new JSONObject(toJson(obj));
                    }
                    jSONObject.put(str, obj);
                }
                obj = wrap;
                jSONObject.put(str, obj);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static final String toJson(android.os.Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bundle)) == null) {
            Intrinsics.checkNotNullParameter(bundle, "<this>");
            String jSONObject = toJSONObject(bundle).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "this.toJSONObject().toString()");
            return jSONObject;
        }
        return (String) invokeL.objValue;
    }

    public static final Map<String, Object> toMap(android.os.Bundle bundle) throws JsonSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bundle)) == null) {
            Intrinsics.checkNotNullParameter(bundle, "<this>");
            return toMap(toJson(bundle));
        }
        return (Map) invokeL.objValue;
    }

    public static final List<Map<String, Object>> toMapList(String str) throws JsonSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            List<Map<String, Object>> list = (List) GSON.fromJson(str, new d());
            if (list == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static final String toJson(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
            Intrinsics.checkNotNullParameter(obj, "<this>");
            String json = GSON.toJson(obj);
            Intrinsics.checkNotNullExpressionValue(json, "GSON.toJson(this)");
            return json;
        }
        return (String) invokeL.objValue;
    }

    public static final Map<String, Object> toMap(Object obj) throws JsonSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            Intrinsics.checkNotNullParameter(obj, "<this>");
            return toMap(toJson(obj));
        }
        return (Map) invokeL.objValue;
    }

    public static final Map<String, Object> toMap(String str) throws JsonSyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Object fromJson = GSON.fromJson(str, JavaGsonWidget.a);
            Intrinsics.checkNotNullExpressionValue(fromJson, "GSON.fromJson(this, JavaGsonWidget.MAP_TYPE)");
            return (Map) fromJson;
        }
        return (Map) invokeL.objValue;
    }
}
