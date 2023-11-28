package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.util.gson.Holder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
/* loaded from: classes5.dex */
public final class dv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.util.gson.KotlinReflectiveTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken<T>):com.google.gson.TypeAdapter<T>] */
    public static final /* synthetic */ Object a(KParameter kParameter) {
        return e(kParameter);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.util.gson.KotlinReflectiveTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken<T>):com.google.gson.TypeAdapter<T>] */
    public static final /* synthetic */ KClass d(TypeToken typeToken) {
        return h(typeToken);
    }

    public static final <T> KClass<T> h(TypeToken<T> typeToken) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, typeToken)) == null) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType != null) {
                return JvmClassMappingKt.getKotlinClass(rawType);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T of com.baidu.tbadk.util.gson.KotlinReflectiveTypeAdapterFactoryKt.toKClass>");
        }
        return (KClass) invokeL.objValue;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.util.gson.KotlinReflectiveTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken<T>):com.google.gson.TypeAdapter<T>] */
    public static final /* synthetic */ List b(KParameter kParameter, Class cls) {
        return f(kParameter, cls);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.util.gson.KotlinReflectiveTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken<T>):com.google.gson.TypeAdapter<T>] */
    public static final /* synthetic */ TypeToken c(TypeToken typeToken, KParameter kParameter) {
        return g(typeToken, kParameter);
    }

    public static final Object e(KParameter kParameter) {
        InterceptResult invokeL;
        KClass kClass;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kParameter)) == null) {
            if (kParameter.getType().isMarkedNullable()) {
                return null;
            }
            KClassifier classifier = kParameter.getType().getClassifier();
            if (classifier instanceof KClass) {
                kClass = (KClass) classifier;
            } else {
                kClass = null;
            }
            if (kClass == null) {
                return null;
            }
            if (!KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Collection.class)) && !KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Object[].class))) {
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    return "";
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    return Boolean.FALSE;
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    return (byte) 0;
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    return (char) 0;
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    return Double.valueOf(0.0d);
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    return Float.valueOf(0.0f);
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    return 0;
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    return 0L;
                }
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    return (short) 0;
                }
                return Holder.OBJECT;
            }
            return Holder.ARRAY;
        }
        return invokeL.objValue;
    }

    public static final <T> List<String> f(KParameter kParameter, Class<T> cls) {
        InterceptResult invokeLL;
        Field field;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, kParameter, cls)) == null) {
            String name = kParameter.getName();
            if (name == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            SerializedName serializedName = null;
            try {
                field = cls.getDeclaredField(name);
            } catch (NoSuchFieldException unused) {
                field = null;
            }
            if (field != null) {
                serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
            }
            if (field != null && !Modifier.isTransient(field.getModifiers())) {
                if (serializedName != null) {
                    return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt__CollectionsJVMKt.listOf(serializedName.value()), (Object[]) serializedName.alternate());
                }
                return CollectionsKt__CollectionsJVMKt.listOf(name);
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    public static final TypeToken<?> g(TypeToken<?> typeToken, KParameter kParameter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, typeToken, kParameter)) == null) {
            TypeToken<?> resolveParameterType = TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), typeToken.getRawType(), ReflectJvmMapping.getJavaType(kParameter.getType())));
            Intrinsics.checkNotNullExpressionValue(resolveParameterType, "resolveParameterType");
            return resolveParameterType;
        }
        return (TypeToken) invokeLL.objValue;
    }
}
