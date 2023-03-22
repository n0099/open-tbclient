package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes3.dex */
public final class c87 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947628711, "Lcom/baidu/tieba/c87;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947628711, "Lcom/baidu/tieba/c87;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a.a(str) : invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a.b(str) : invokeL.booleanValue;
    }

    @JvmStatic
    public static final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            a.c();
        }
    }

    @JvmStatic
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.d() : invokeV.booleanValue;
    }

    @JvmStatic
    public static final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            a.e();
        }
    }

    /* loaded from: classes3.dex */
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
        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return m35.m().i(m35.q("forum_group_feed_card_has_show"), false);
            }
            return invokeV.booleanValue;
        }

        @JvmStatic
        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                m35.m().w(m35.q("forum_group_feed_card_has_show"), true);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
            r2 = com.baidu.tieba.d87.j();
         */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(String str) {
            InterceptResult invokeL;
            boolean z;
            int j;
            String h;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z || j <= 0) {
                    return false;
                }
                String valueOf = String.valueOf(StringHelper.getyyyyMMddTimeForNow());
                h = d87.h();
                Intrinsics.checkNotNullExpressionValue(h, "feedCardHasShowArrayStr()");
                List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) h, new String[]{"_"}, false, 0, 6, (Object) null);
                if (split$default.size() > 1 && Intrinsics.areEqual(valueOf, split$default.get(0))) {
                    int i = 0;
                    for (String str2 : split$default) {
                        if (Intrinsics.areEqual(str2, str)) {
                            i++;
                        }
                    }
                    if (i >= j) {
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @JvmStatic
        public final void f(String str) {
            boolean z;
            String h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return;
                }
                String valueOf = String.valueOf(StringHelper.getyyyyMMddTimeForNow());
                h = d87.h();
                Intrinsics.checkNotNullExpressionValue(h, "feedCardHasShowArrayStr()");
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) h, new String[]{"_"}, false, 0, 6, (Object) null));
                if (mutableList.isEmpty()) {
                    mutableList.add(valueOf);
                } else if (mutableList.size() == 1) {
                    mutableList.clear();
                    mutableList.add(valueOf);
                } else if (!Intrinsics.areEqual(valueOf, mutableList.get(0))) {
                    mutableList.clear();
                    mutableList.add(valueOf);
                }
                mutableList.add(str);
                d87.l(CollectionsKt___CollectionsKt.joinToString$default(mutableList, "_", null, null, 0, null, null, 62, null));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
            r2 = com.baidu.tieba.d87.i();
         */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean b(String str) {
            InterceptResult invokeL;
            boolean z;
            int i;
            String g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z || i <= 0) {
                    return false;
                }
                String valueOf = String.valueOf(StringHelper.getyyyyMMddTimeForNow());
                g = d87.g();
                Intrinsics.checkNotNullExpressionValue(g, "entranceGuideHasShowArrayStr()");
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) g, new String[]{"_"}, false, 0, 6, (Object) null));
                if (mutableList.isEmpty()) {
                    mutableList.add(valueOf);
                    mutableList.add(str);
                    d87.k(CollectionsKt___CollectionsKt.joinToString$default(mutableList, "_", null, null, 0, null, null, 62, null));
                    return true;
                } else if (mutableList.size() == 1) {
                    mutableList.clear();
                    mutableList.add(valueOf);
                    mutableList.add(str);
                    d87.k(CollectionsKt___CollectionsKt.joinToString$default(mutableList, "_", null, null, 0, null, null, 62, null));
                    return true;
                } else if (Intrinsics.areEqual(valueOf, mutableList.get(0))) {
                    if (mutableList.contains(str) || mutableList.size() - 1 >= i) {
                        return false;
                    }
                    mutableList.add(str);
                    d87.k(CollectionsKt___CollectionsKt.joinToString$default(mutableList, "_", null, null, 0, null, null, 62, null));
                    return true;
                } else {
                    mutableList.clear();
                    mutableList.add(valueOf);
                    mutableList.add(str);
                    d87.k(CollectionsKt___CollectionsKt.joinToString$default(mutableList, "_", null, null, 0, null, null, 62, null));
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        @JvmStatic
        public final void c() {
            int i;
            String g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                String valueOf = String.valueOf(StringHelper.getyyyyMMddTimeForNow());
                g = d87.g();
                Intrinsics.checkNotNullExpressionValue(g, "entranceGuideHasShowArrayStr()");
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) g, new String[]{"_"}, false, 0, 6, (Object) null));
                if (mutableList.isEmpty()) {
                    mutableList.add(valueOf);
                } else if (mutableList.size() == 1) {
                    mutableList.clear();
                    mutableList.add(valueOf);
                }
                for (i = d87.i(); -1 < i; i--) {
                    mutableList.add(String.valueOf(i));
                }
                d87.k(CollectionsKt___CollectionsKt.joinToString$default(mutableList, "_", null, null, 0, null, null, 62, null));
            }
        }
    }
}
