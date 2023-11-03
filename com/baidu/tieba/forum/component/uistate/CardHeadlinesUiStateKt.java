package com.baidu.tieba.forum.component.uistate;

import android.content.Context;
import com.baidu.tieba.ye7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"OnRootClick", "Lkotlin/Function2;", "Landroid/content/Context;", "Lcom/baidu/tieba/forum/component/uistate/CardHeadlinesUiState;", "", "forum_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CardHeadlinesUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<Context, ye7, Unit> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1177285604, "Lcom/baidu/tieba/forum/component/uistate/CardHeadlinesUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1177285604, "Lcom/baidu/tieba/forum/component/uistate/CardHeadlinesUiStateKt;");
                return;
            }
        }
        a = CardHeadlinesUiStateKt$OnRootClick$1.INSTANCE;
    }
}
