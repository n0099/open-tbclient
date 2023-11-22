package com.baidu.tieba.feed.widget.uistate;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n77;
import com.baidu.tieba.qd7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"$\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DefaultOnAttentionClick", "Lkotlin/Function2;", "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiState;", "Lcom/baidu/tbadk/TbPageContext;", "", "DefaultOnAttentionListenerRegister", "Lkotlin/Function3;", "", "DefaultOnStat", "Lkotlin/Function1;", "Lcom/baidu/tieba/feed/data/StatData;", "lib-components_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonAttentionUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<qd7, TbPageContext<?>, Unit> a;
    public static final Function3<qd7, TbPageContext<?>, Object, Unit> b;
    public static final Function1<n77, Unit> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1242182276, "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1242182276, "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiStateKt;");
                return;
            }
        }
        a = PersonAttentionUiStateKt$DefaultOnAttentionClick$1.INSTANCE;
        b = PersonAttentionUiStateKt$DefaultOnAttentionListenerRegister$1.INSTANCE;
        c = PersonAttentionUiStateKt$DefaultOnStat$1.INSTANCE;
    }
}
