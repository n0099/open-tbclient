package com.baidu.tieba.feed.widget.uistate;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lz6;
import com.baidu.tieba.o37;
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
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"'\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"DefaultOnAttentionClick", "Lkotlin/Function2;", "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiState;", "Lcom/baidu/tbadk/TbPageContext;", "", "getDefaultOnAttentionClick", "()Lkotlin/jvm/functions/Function2;", "DefaultOnAttentionListenerRegister", "Lkotlin/Function3;", "", "DefaultOnStat", "Lkotlin/Function1;", "Lcom/baidu/tieba/feed/data/StatData;", "lib-components_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PersonAttentionUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<o37, TbPageContext<?>, Unit> a;
    public static final Function3<o37, TbPageContext<?>, Object, Unit> b;
    public static final Function1<lz6, Unit> c;
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

    public static final Function2<o37, TbPageContext<?>, Unit> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return (Function2) invokeV.objValue;
    }
}
