package com.baidu.tieba.feed.component.uistate;

import android.content.Context;
import com.baidu.tieba.m67;
import com.baidu.tieba.x87;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"#\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"handleClick", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", "getHandleClick", "()Lkotlin/jvm/functions/Function2;", "sendStatData", "Lkotlin/Function1;", "Lcom/baidu/tieba/feed/data/StatData;", "getSendStatData", "()Lkotlin/jvm/functions/Function1;", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function1<m67, Unit> a;
    public static final Function2<Context, String, Unit> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1823104012, "Lcom/baidu/tieba/feed/component/uistate/CardUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1823104012, "Lcom/baidu/tieba/feed/component/uistate/CardUiStateKt;");
                return;
            }
        }
        a = new CardUiStateKt$sendStatData$1(x87.a);
        b = CardUiStateKt$handleClick$1.INSTANCE;
    }

    public static final Function2<Context, String, Unit> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (Function2) invokeV.objValue;
    }

    public static final Function1<m67, Unit> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (Function1) invokeV.objValue;
    }
}
