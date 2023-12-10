package com.baidu.tieba.forum.controller;

import androidx.fragment.app.FragmentActivity;
import com.baidu.tieba.xh7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"1\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"ForumActivityControllerMap", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentActivity;", "", "Lkotlin/reflect/KClass;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "getForumActivityControllerMap", "()Lkotlin/jvm/functions/Function1;", "forum_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumActivityControllerMapKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function1<FragmentActivity, Map<KClass<? extends xh7>, xh7>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1504092597, "Lcom/baidu/tieba/forum/controller/ForumActivityControllerMapKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1504092597, "Lcom/baidu/tieba/forum/controller/ForumActivityControllerMapKt;");
                return;
            }
        }
        a = ForumActivityControllerMapKt$ForumActivityControllerMap$1.INSTANCE;
    }

    public static final Function1<FragmentActivity, Map<KClass<? extends xh7>, xh7>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (Function1) invokeV.objValue;
    }
}
