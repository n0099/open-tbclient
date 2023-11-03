package com.baidu.tieba.feed.component.uistate;

import android.view.View;
import com.baidu.tieba.k47;
import com.baidu.tieba.t57;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\"&\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"OnTagClick", "Lkotlin/Function3;", "Landroid/view/View;", "Lcom/baidu/tieba/feed/data/EnableDegradeData;", "Lcom/baidu/tieba/feed/component/uistate/CardVirtualHeadUiState;", "", "onImageClickDefault", "", "", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardVirtualHeadUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function3<View, String, k47, Boolean> a;
    public static final Function3<View, t57, k47, Unit> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19766743, "Lcom/baidu/tieba/feed/component/uistate/CardVirtualHeadUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-19766743, "Lcom/baidu/tieba/feed/component/uistate/CardVirtualHeadUiStateKt;");
                return;
            }
        }
        a = CardVirtualHeadUiStateKt$onImageClickDefault$1.INSTANCE;
        b = CardVirtualHeadUiStateKt$OnTagClick$1.INSTANCE;
    }
}
