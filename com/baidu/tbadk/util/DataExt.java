package com.baidu.tbadk.util;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class DataExt {
    public static /* synthetic */ Interceptable $ic;
    public static final Gson a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class GsonWidget {
        public static /* synthetic */ Interceptable $ic;
        public static final Type a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes12.dex */
        public static final class BadNumberFix implements JsonDeserializer<Number> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @NonNull
            public final List<String> a;

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* loaded from: classes12.dex */
            public static final class NumberType {
                public static final /* synthetic */ NumberType[] $VALUES;
                public static /* synthetic */ Interceptable $ic;
                public static final NumberType DOUBLE;
                public static final NumberType FLOAT;
                public static final NumberType INTEGER;
                public static final NumberType LONG;
                public transient /* synthetic */ FieldHolder $fh;
                public final List<Class<?>> typeList;

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1938386023, "Lcom/baidu/tbadk/util/DataExt$GsonWidget$BadNumberFix$NumberType;")) != null) {
                        Interceptable interceptable = invokeClinit.interceptor;
                        if (interceptable != null) {
                            $ic = interceptable;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(-1938386023, "Lcom/baidu/tbadk/util/DataExt$GsonWidget$BadNumberFix$NumberType;");
                            return;
                        }
                    }
                    INTEGER = new NumberType("INTEGER", 0, Integer.TYPE, Integer.class);
                    LONG = new NumberType("LONG", 1, Long.TYPE, Long.class);
                    FLOAT = new NumberType("FLOAT", 2, Float.TYPE, Float.class);
                    NumberType numberType = new NumberType("DOUBLE", 3, Double.TYPE, Double.class);
                    DOUBLE = numberType;
                    $VALUES = new NumberType[]{INTEGER, LONG, FLOAT, numberType};
                }

                public NumberType(String str, int i2, Class... clsArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, Integer.valueOf(i2), clsArr};
                        interceptable.invokeUnInit(65537, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            String str2 = (String) objArr2[0];
                            ((Integer) objArr2[1]).intValue();
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.typeList = Arrays.asList(clsArr);
                }

                public static NumberType valueOf(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (NumberType) Enum.valueOf(NumberType.class, str) : (NumberType) invokeL.objValue;
                }

                @Nullable
                public static NumberType valueOfByType(@NonNull Type type) {
                    InterceptResult invokeL;
                    NumberType[] values;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, type)) == null) {
                        if (type instanceof Class) {
                            Class cls = (Class) type;
                            for (NumberType numberType : values()) {
                                if (numberType.typeList.contains(cls)) {
                                    return numberType;
                                }
                            }
                            return null;
                        }
                        return null;
                    }
                    return (NumberType) invokeL.objValue;
                }

                public static NumberType[] values() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (NumberType[]) $VALUES.clone() : (NumberType[]) invokeV.objValue;
                }
            }

            public BadNumberFix() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                this.a = arrayList;
                arrayList.add("");
                this.a.add(StringUtil.NULL_STRING);
                this.a.add("NULL");
            }

            @NonNull
            public static GsonBuilder c(@NonNull GsonBuilder gsonBuilder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gsonBuilder)) == null) {
                    BadNumberFix badNumberFix = new BadNumberFix();
                    for (NumberType numberType : NumberType.values()) {
                        for (Type type : numberType.typeList) {
                            gsonBuilder.registerTypeAdapter(type, badNumberFix);
                        }
                    }
                    return gsonBuilder;
                }
                return (GsonBuilder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.JsonDeserializer
            /* renamed from: a */
            public Number deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                InterceptResult invokeLLL;
                NumberType valueOfByType;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jsonElement, type, jsonDeserializationContext)) == null) {
                    if (jsonElement.isJsonPrimitive()) {
                        Number asNumber = jsonElement.getAsJsonPrimitive().getAsNumber();
                        if (b(asNumber.toString()) || (valueOfByType = NumberType.valueOfByType(type)) == null) {
                            return null;
                        }
                        int i2 = b.a[valueOfByType.ordinal()];
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 == 4) {
                                        return Double.valueOf(asNumber.doubleValue());
                                    }
                                    throw new IllegalStateException("要处理的类型出错");
                                }
                                return Float.valueOf(asNumber.floatValue());
                            }
                            return Long.valueOf(Long.parseLong(asNumber.toString()));
                        }
                        return Integer.valueOf(Integer.parseInt(asNumber.toString()));
                    }
                    return null;
                }
                return (Number) invokeLLL.objValue;
            }

            public final boolean b(@NonNull String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.a.contains(str) : invokeL.booleanValue;
            }
        }

        /* loaded from: classes12.dex */
        public static final class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public MapDeserializerDoubleAsIntFix() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.JsonDeserializer
            /* renamed from: a */
            public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jsonElement, type, jsonDeserializationContext)) == null) ? (Map) b(jsonElement) : (Map) invokeLLL.objValue;
            }

            public final Object b(JsonElement jsonElement) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonElement)) == null) {
                    if (jsonElement.isJsonArray()) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                        while (it.hasNext()) {
                            arrayList.add(b(it.next()));
                        }
                        return arrayList;
                    } else if (jsonElement.isJsonObject()) {
                        LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                            linkedTreeMap.put(entry.getKey(), b(entry.getValue()));
                        }
                        return linkedTreeMap;
                    } else if (jsonElement.isJsonPrimitive()) {
                        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                        if (asJsonPrimitive.isBoolean()) {
                            return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
                        }
                        if (asJsonPrimitive.isString()) {
                            return asJsonPrimitive.getAsString();
                        }
                        if (asJsonPrimitive.isNumber()) {
                            Number asNumber = asJsonPrimitive.getAsNumber();
                            if (asNumber.toString().indexOf(46) != -1) {
                                return Double.valueOf(asNumber.doubleValue());
                            }
                            return Long.valueOf(asNumber.longValue());
                        }
                        return null;
                    } else {
                        return null;
                    }
                }
                return invokeL.objValue;
            }

            public /* synthetic */ MapDeserializerDoubleAsIntFix(a aVar) {
                this();
            }
        }

        /* loaded from: classes12.dex */
        public static class a extends TypeToken<Map<String, Object>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(282091221, "Lcom/baidu/tbadk/util/DataExt$GsonWidget;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(282091221, "Lcom/baidu/tbadk/util/DataExt$GsonWidget;");
                    return;
                }
            }
            a = new a().getType();
        }
    }

    /* loaded from: classes12.dex */
    public static class a implements ParameterizedType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Class f41369e;

        public a(Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41369e = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Type[]{this.f41369e} : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public Type getOwnerType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? List.class : (Type) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(988613424, "Lcom/baidu/tbadk/util/DataExt$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(988613424, "Lcom/baidu/tbadk/util/DataExt$b;");
                    return;
                }
            }
            int[] iArr = new int[GsonWidget.BadNumberFix.NumberType.values().length];
            a = iArr;
            try {
                iArr[GsonWidget.BadNumberFix.NumberType.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GsonWidget.BadNumberFix.NumberType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GsonWidget.BadNumberFix.NumberType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GsonWidget.BadNumberFix.NumberType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
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
        GsonWidget.BadNumberFix.c(gsonBuilder);
        a = gsonBuilder.registerTypeAdapter(GsonWidget.a, new GsonWidget.MapDeserializerDoubleAsIntFix(null)).create();
    }

    @NonNull
    public static <T> T a(@NonNull String str, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, cls)) == null) ? (T) a.fromJson(str, (Class<Object>) cls) : (T) invokeLL.objValue;
    }

    @NonNull
    public static <T> T b(@NonNull Map<String, Object> map, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, map, cls)) == null) ? (T) a(f(map), cls) : (T) invokeLL.objValue;
    }

    @NonNull
    public static <T> List<T> c(@NonNull String str, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, cls)) == null) ? (List) Objects.requireNonNull(a.fromJson(str, new a(cls))) : (List) invokeLL.objValue;
    }

    @NonNull
    public static JSONObject d(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Object obj;
        Object wrap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                try {
                    obj = bundle.get(str);
                    wrap = JSONObject.wrap(obj);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                if (wrap == null) {
                    if (obj instanceof Bundle) {
                        obj = d((Bundle) obj);
                    } else if ((obj instanceof Serializable) || (obj instanceof Parcelable)) {
                        wrap = new JSONObject(f(obj));
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

    @NonNull
    public static String e(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bundle)) == null) ? d(bundle).toString() : (String) invokeL.objValue;
    }

    @NonNull
    public static String f(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? a.toJson(obj) : (String) invokeL.objValue;
    }

    @NonNull
    public static Map<String, Object> g(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bundle)) == null) ? i(e(bundle)) : (Map) invokeL.objValue;
    }

    @NonNull
    public static Map<String, Object> h(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? i(f(obj)) : (Map) invokeL.objValue;
    }

    @NonNull
    public static Map<String, Object> i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? (Map) a.fromJson(str, GsonWidget.a) : (Map) invokeL.objValue;
    }
}
