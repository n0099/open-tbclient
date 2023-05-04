package com.baidu.tieba.feed.component.uistate;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.tieba.oz6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\")\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"OnVideoClick", "Lkotlin/Function3;", "Landroid/content/Context;", "Landroid/graphics/Rect;", "Lcom/baidu/tieba/feed/data/VideoSchemaData;", "", "getOnVideoClick", "()Lkotlin/jvm/functions/Function3;", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardVideoUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function3<Context, Rect, oz6, Unit> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(607226329, "Lcom/baidu/tieba/feed/component/uistate/CardVideoUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(607226329, "Lcom/baidu/tieba/feed/component/uistate/CardVideoUiStateKt;");
                return;
            }
        }
        a = CardVideoUiStateKt$OnVideoClick$1.INSTANCE;
    }

    public static final Function3<Context, Rect, oz6, Unit> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (Function3) invokeV.objValue;
    }
}
