package com.baidu.tbadk.util.gson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class JavaGsonWidget {
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
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2080555308, "Lcom/baidu/tbadk/util/gson/JavaGsonWidget$BadNumberFix$NumberType;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-2080555308, "Lcom/baidu/tbadk/util/gson/JavaGsonWidget$BadNumberFix$NumberType;");
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
        @Nullable
        /* renamed from: a */
        public Number deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            InterceptResult invokeLLL;
            NumberType valueOfByType;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jsonElement, type, jsonDeserializationContext)) == null) {
                if (jsonElement.isJsonPrimitive()) {
                    Number asNumber = jsonElement.getAsJsonPrimitive().getAsNumber();
                    if (!b(asNumber.toString()) && (valueOfByType = NumberType.valueOfByType(type)) != null) {
                        int i = b.a[valueOfByType.ordinal()];
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.JsonDeserializer
        /* renamed from: a */
        public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jsonElement, type, jsonDeserializationContext)) == null) {
                return (Map) JavaGsonWidget.a(jsonElement);
            }
            return (Map) invokeLLL.objValue;
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(420642002, "Lcom/baidu/tbadk/util/gson/JavaGsonWidget$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(420642002, "Lcom/baidu/tbadk/util/gson/JavaGsonWidget$b;");
                    return;
                }
            }
            int[] iArr = new int[BadNumberFix.NumberType.values().length];
            a = iArr;
            try {
                iArr[BadNumberFix.NumberType.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BadNumberFix.NumberType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BadNumberFix.NumberType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BadNumberFix.NumberType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036432624, "Lcom/baidu/tbadk/util/gson/JavaGsonWidget;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1036432624, "Lcom/baidu/tbadk/util/gson/JavaGsonWidget;");
                return;
            }
        }
        a = new a().getType();
    }

    @Nullable
    public static Object a(JsonElement jsonElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jsonElement)) == null) {
            if (jsonElement.isJsonArray()) {
                ArrayList arrayList = new ArrayList();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(a(it.next()));
                }
                return arrayList;
            } else if (jsonElement.isJsonObject()) {
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    linkedTreeMap.put(entry.getKey(), a(entry.getValue()));
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
