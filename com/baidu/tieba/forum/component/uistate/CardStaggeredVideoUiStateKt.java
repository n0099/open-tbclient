package com.baidu.tieba.forum.component.uistate;

import android.content.Context;
import com.baidu.tieba.bg7;
import com.baidu.tieba.l67;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"OnTagClickImpl", "Lkotlin/Function2;", "Landroid/content/Context;", "Lcom/baidu/tieba/feed/data/EnableDegradeData;", "", "onCommentClickImpl", "Lcom/baidu/tieba/forum/component/uistate/CardStaggeredVideoUiState;", "onManageClickImpl", "onSelectClickImpl", "forum_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardStaggeredVideoUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<Context, bg7, Unit> a;
    public static final Function2<Context, bg7, Unit> b;
    public static final Function2<Context, bg7, Unit> c;
    public static final Function2<Context, l67, Unit> d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1604720268, "Lcom/baidu/tieba/forum/component/uistate/CardStaggeredVideoUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1604720268, "Lcom/baidu/tieba/forum/component/uistate/CardStaggeredVideoUiStateKt;");
                return;
            }
        }
        a = CardStaggeredVideoUiStateKt$onManageClickImpl$1.INSTANCE;
        b = CardStaggeredVideoUiStateKt$onSelectClickImpl$1.INSTANCE;
        c = CardStaggeredVideoUiStateKt$onCommentClickImpl$1.INSTANCE;
        d = CardStaggeredVideoUiStateKt$OnTagClickImpl$1.INSTANCE;
    }
}
