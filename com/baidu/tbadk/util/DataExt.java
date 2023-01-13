package com.baidu.tbadk.util;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zj5;
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
/* loaded from: classes3.dex */
public final class DataExt {
    public static /* synthetic */ Interceptable $ic;
    public static final Gson GSON;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class GsonWidget {
        public static /* synthetic */ Interceptable $ic;
        public static final Type a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static final class BadNumberFix implements JsonDeserializer<Number> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @NonNull
            public final List<String> a;

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* loaded from: classes3.dex */
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

                public NumberType(String str, int i, Class... clsArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, Integer.valueOf(i), clsArr};
                        interceptable.invokeUnInit(65537, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                        return (NumberType) Enum.valueOf(NumberType.class, str);
                    }
                    return (NumberType) invokeL.objValue;
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
                    if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                        return (NumberType[]) $VALUES.clone();
                    }
                    return (NumberType[]) invokeV.objValue;
                }
            }

            public BadNumberFix() {
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
                        if (!b(asNumber.toString()) && (valueOfByType = NumberType.valueOfByType(type)) != null) {
                            int i = e.a[valueOfByType.ordinal()];
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (i == 4) {
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
                    return null;
                }
                return (Number) invokeLLL.objValue;
            }

            public final boolean b(@NonNull String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    return this.a.contains(str);
                }
                return invokeL.booleanValue;
            }
        }

        /* loaded from: classes3.dex */
        public static final class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public MapDeserializerDoubleAsIntFix() {
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

            public /* synthetic */ MapDeserializerDoubleAsIntFix(a aVar) {
                this();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.JsonDeserializer
            /* renamed from: a */
            public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jsonElement, type, jsonDeserializationContext)) == null) {
                    return (Map) b(jsonElement);
                }
                return (Map) invokeLLL.objValue;
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
        }

        /* loaded from: classes3.dex */
        public static class a extends TypeToken<Map<String, Object>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes3.dex */
    public static class a implements ExclusionStrategy {
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
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fieldAttributes)) == null) {
                zj5 zj5Var = (zj5) fieldAttributes.getAnnotation(zj5.class);
                if (zj5Var != null && !zj5Var.deserialize()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements ExclusionStrategy {
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
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fieldAttributes)) == null) {
                zj5 zj5Var = (zj5) fieldAttributes.getAnnotation(zj5.class);
                if (zj5Var != null && !zj5Var.serialize()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements ParameterizedType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class a;

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

        public c(Class cls) {
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
        @NonNull
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Type[]{this.a} : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return List.class;
            }
            return (Type) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements ParameterizedType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        @NonNull
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Type[]{GsonWidget.a} : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return List.class;
            }
            return (Type) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(988613517, "Lcom/baidu/tbadk/util/DataExt$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(988613517, "Lcom/baidu/tbadk/util/DataExt$e;");
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
        GSON = gsonBuilder.registerTypeAdapter(GsonWidget.a, new GsonWidget.MapDeserializerDoubleAsIntFix(null)).addSerializationExclusionStrategy(new b()).addDeserializationExclusionStrategy(new a()).create();
    }

    public DataExt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static <T> T toEntity(@NonNull String str, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, cls)) == null) {
            return (T) GSON.fromJson(str, (Class<Object>) cls);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    public static <T> List<T> toEntityList(@NonNull String str, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, cls)) == null) {
            return (List) Objects.requireNonNull(GSON.fromJson(str, new c(cls)));
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public static <T> T toEntity(@NonNull Map<String, Object> map, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, cls)) == null) {
            return (T) toEntity(toJson(map), cls);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    public static JSONObject toJSONObject(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Object obj;
        Object wrap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bundle)) == null) {
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
                        obj = toJSONObject((Bundle) obj);
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

    @NonNull
    public static String toJson(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bundle)) == null) {
            return toJSONObject(bundle).toString();
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static Map<String, Object> toMap(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bundle)) == null) {
            return toMap(toJson(bundle));
        }
        return (Map) invokeL.objValue;
    }

    @NonNull
    public static List<Map<String, Object>> toMapList(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return (List) Objects.requireNonNull(GSON.fromJson(str, new d()));
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public static String toJson(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            return GSON.toJson(obj);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static Map<String, Object> toMap(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) {
            return toMap(toJson(obj));
        }
        return (Map) invokeL.objValue;
    }

    @NonNull
    public static Map<String, Object> toMap(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return (Map) GSON.fromJson(str, GsonWidget.a);
        }
        return (Map) invokeL.objValue;
    }
}
