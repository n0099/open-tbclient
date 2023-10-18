package com.baidu.tbadk.util.gson;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.at5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.huawei.hms.framework.common.ExceptionCode;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tbadk/util/gson/KotlinReflectiveTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "enableDefaultValues", "", "(Z)V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Adapter", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final Class<Metadata> c;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    public /* synthetic */ KotlinReflectiveTypeAdapterFactory(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u007f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001bR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/tbadk/util/gson/KotlinReflectiveTypeAdapterFactory$Adapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/google/gson/TypeAdapter;", "delegateAdapter", "innerAdapters", "", "Lkotlin/reflect/KParameter;", "kClass", "Lkotlin/reflect/KClass;", "primaryConstructor", "Lkotlin/reflect/KFunction;", "constructorParameterDefaultsMap", "invalidReadParameters", "", "constructorMap", "", "(Lcom/google/gson/TypeAdapter;Ljava/util/Map;Lkotlin/reflect/KClass;Lkotlin/reflect/KFunction;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;)V", ExceptionCode.READ, "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TypeAdapter<T> a;
        public final Map<KParameter, TypeAdapter<?>> b;
        public final KClass<T> c;
        public final KFunction<T> d;
        public final Map<KParameter, Object> e;
        public final Set<KParameter> f;
        public final Map<String, KParameter> g;

        public Adapter(TypeAdapter<T> delegateAdapter, Map<KParameter, ? extends TypeAdapter<?>> innerAdapters, KClass<T> kClass, KFunction<? extends T> primaryConstructor, Map<KParameter, ? extends Object> constructorParameterDefaultsMap, Set<? extends KParameter> invalidReadParameters, Map<String, ? extends KParameter> constructorMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {delegateAdapter, innerAdapters, kClass, primaryConstructor, constructorParameterDefaultsMap, invalidReadParameters, constructorMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(delegateAdapter, "delegateAdapter");
            Intrinsics.checkNotNullParameter(innerAdapters, "innerAdapters");
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(primaryConstructor, "primaryConstructor");
            Intrinsics.checkNotNullParameter(constructorParameterDefaultsMap, "constructorParameterDefaultsMap");
            Intrinsics.checkNotNullParameter(invalidReadParameters, "invalidReadParameters");
            Intrinsics.checkNotNullParameter(constructorMap, "constructorMap");
            this.a = delegateAdapter;
            this.b = innerAdapters;
            this.c = kClass;
            this.d = primaryConstructor;
            this.e = constructorParameterDefaultsMap;
            this.f = invalidReadParameters;
            this.g = constructorMap;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader reader) {
            InterceptResult invokeL;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, reader)) == null) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                if (!this.c.isAbstract()) {
                    if (!this.c.isSealed()) {
                        if (!this.f.isEmpty()) {
                            Set<KParameter> set = this.f;
                            ArrayList arrayList = new ArrayList();
                            for (T t : set) {
                                if (((KParameter) t).getName() != null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    arrayList.add(t);
                                }
                            }
                            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, StringUtil.ARRAY_ELEMENT_SEPARATOR, null, null, 0, null, KotlinReflectiveTypeAdapterFactory$Adapter$read$3$names$2.INSTANCE, 30, null);
                            throw new IllegalArgumentException(("Transient constructor parameters must provide a default value. (" + joinToString$default + ')').toString());
                        } else if (reader.peek() == JsonToken.NULL) {
                            reader.nextNull();
                            return null;
                        } else {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            reader.beginObject();
                            while (reader.hasNext()) {
                                KParameter kParameter = this.g.get(reader.nextName());
                                if (kParameter != null) {
                                    if (linkedHashMap.put(kParameter, ((TypeAdapter) MapsKt__MapsKt.getValue(this.b, kParameter)).read(reader)) == null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        throw new IllegalArgumentException((this.c.getSimpleName() + " declares multiple JSON fields named " + kParameter.getName()).toString());
                                    }
                                } else {
                                    reader.skipValue();
                                }
                            }
                            reader.endObject();
                            for (Map.Entry<KParameter, Object> entry : this.e.entrySet()) {
                                KParameter key = entry.getKey();
                                Object value = entry.getValue();
                                if (linkedHashMap.get(key) == null) {
                                    if (value instanceof Holder) {
                                        linkedHashMap.put(key, ((TypeAdapter) MapsKt__MapsKt.getValue(this.b, key)).fromJson(((Holder) value).getValue()));
                                    } else {
                                        linkedHashMap.put(key, value);
                                    }
                                }
                            }
                            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                KParameter kParameter2 = (KParameter) entry2.getKey();
                                if (entry2.getValue() == null && !kParameter2.getType().isMarkedNullable()) {
                                    Map<String, KParameter> map = this.g;
                                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                    for (Map.Entry<String, KParameter> entry3 : map.entrySet()) {
                                        if (Intrinsics.areEqual(entry3.getValue(), kParameter2)) {
                                            linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                                        }
                                    }
                                    ArrayList arrayList2 = new ArrayList(linkedHashMap2.size());
                                    for (Map.Entry entry4 : linkedHashMap2.entrySet()) {
                                        arrayList2.add((String) entry4.getKey());
                                    }
                                    String str = (String) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
                                    if (str == null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        throw new IllegalArgumentException((this.c.getSimpleName() + " declares Non-null value '" + kParameter2.getName() + "' (JSON name '" + str + "') was null").toString());
                                    }
                                }
                            }
                            return this.d.callBy(linkedHashMap);
                        }
                    }
                    throw new IllegalArgumentException(("Cannot deserialize sealed class '" + this.c.getSimpleName() + '\'').toString());
                }
                throw new IllegalArgumentException(("Cannot deserialize abstract class '" + this.c.getSimpleName() + '\'').toString());
            }
            return (T) invokeL.objValue;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter writer, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writer, t) == null) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (t == null) {
                    writer.nullValue();
                } else {
                    this.a.write(writer, t);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @JvmStatic
        public final KotlinReflectiveTypeAdapterFactory a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                return new KotlinReflectiveTypeAdapterFactory(z, null);
            }
            return (KotlinReflectiveTypeAdapterFactory) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1998213328, "Lcom/baidu/tbadk/util/gson/KotlinReflectiveTypeAdapterFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1998213328, "Lcom/baidu/tbadk/util/gson/KotlinReflectiveTypeAdapterFactory;");
                return;
            }
        }
        b = new a(null);
        c = Metadata.class;
    }

    public KotlinReflectiveTypeAdapterFactory(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = z;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        InterceptResult invokeLL;
        KFunction kFunction;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gson, type)) == null) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(type, "type");
            Class<? super T> rawType = type.getRawType();
            Intrinsics.checkNotNullExpressionValue(rawType, "type.rawType");
            if (rawType.isLocalClass() || rawType.isInterface() || rawType.isEnum() || rawType.isAnnotationPresent(JsonAdapter.class) || !rawType.isAnnotationPresent(c)) {
                return null;
            }
            KClass d = at5.d(type);
            boolean z = true;
            if (!d.isInner()) {
                KFunction primaryConstructor = KClasses.getPrimaryConstructor(d);
                if (primaryConstructor != null) {
                    if (!primaryConstructor.getParameters().isEmpty()) {
                        kFunction = primaryConstructor;
                    } else {
                        kFunction = null;
                    }
                    if (kFunction != null) {
                        KCallablesJvm.setAccessible(kFunction, true);
                        Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor(kFunction);
                        Intrinsics.checkNotNull(javaConstructor);
                        Class<T> declaringClass = javaConstructor.getDeclaringClass();
                        Intrinsics.checkNotNullExpressionValue(declaringClass, "primaryConstructor.javaC…structor!!.declaringClass");
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        for (KParameter kParameter : kFunction.getParameters()) {
                            List<String> b2 = at5.b(kParameter, declaringClass);
                            if (b2.isEmpty() ^ z) {
                                TypeAdapter<T> adapter = gson.getAdapter(at5.c(type, kParameter));
                                Intrinsics.checkNotNullExpressionValue(adapter, "gson.getAdapter(type.res…ParameterType(parameter))");
                                linkedHashMap.put(kParameter, adapter);
                            }
                            if (!kParameter.isOptional()) {
                                if (this.a) {
                                    obj = at5.a(kParameter);
                                } else {
                                    obj = null;
                                }
                                linkedHashMap2.put(kParameter, obj);
                                if (b2.isEmpty()) {
                                    linkedHashSet.add(kParameter);
                                }
                            }
                            for (String str : b2) {
                                linkedHashMap3.put(str, kParameter);
                            }
                            z = true;
                        }
                        TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, type);
                        Intrinsics.checkNotNullExpressionValue(delegateAdapter, "gson.getDelegateAdapter(this, type)");
                        return new Adapter(delegateAdapter, linkedHashMap, d, kFunction, linkedHashMap2, linkedHashSet, linkedHashMap3);
                    }
                }
                return null;
            }
            throw new IllegalArgumentException(("Cannot serialize inner class " + rawType.getName()).toString());
        }
        return (TypeAdapter) invokeLL.objValue;
    }
}
