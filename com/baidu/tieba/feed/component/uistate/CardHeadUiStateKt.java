package com.baidu.tieba.feed.component.uistate;

import android.view.View;
import com.baidu.tieba.cb7;
import com.baidu.tieba.i47;
import com.baidu.tieba.jb7;
import com.baidu.tieba.u57;
import com.baidu.tieba.x37;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007\"&\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"OnHeadImageClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "Lcom/baidu/tieba/feed/component/uistate/CardHeadUiState;", "", "OnTagClick", "Lcom/baidu/tieba/feed/data/EnableDegradeData;", "cardHeadTagClickStat", "uiState", "Lcom/baidu/tieba/feed/component/uistate/CardUiState;", "data", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardHeadUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function3<View, String, x37, Unit> a;
    public static final Function3<View, u57, x37, Unit> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1064336012, "Lcom/baidu/tieba/feed/component/uistate/CardHeadUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1064336012, "Lcom/baidu/tieba/feed/component/uistate/CardHeadUiStateKt;");
                return;
            }
        }
        a = CardHeadUiStateKt$OnHeadImageClick$1.INSTANCE;
        b = CardHeadUiStateKt$OnTagClick$1.INSTANCE;
    }

    public static final void c(i47 uiState, u57 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, uiState, data) == null) {
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            Intrinsics.checkNotNullParameter(data, "data");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(uiState.h());
            linkedHashMap.putAll(data.E());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("get_position", String.valueOf(uiState.k() + 1));
            jb7.a.c(new cb7("head_tag_click", linkedHashMap, linkedHashMap2, uiState.f()));
        }
    }
}
