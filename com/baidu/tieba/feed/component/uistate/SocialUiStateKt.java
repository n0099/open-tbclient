package com.baidu.tieba.feed.component.uistate;

import android.content.Context;
import com.baidu.tieba.b67;
import com.baidu.tieba.c67;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\"&\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\")\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\")\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"onCommentClickImpl", "Lkotlin/Function3;", "Landroid/content/Context;", "Lcom/baidu/tieba/feed/data/SocialMeta;", "Lcom/baidu/tieba/feed/data/StatData;", "", "onPraiseClickImpl", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", AdvanceSetting.NETWORK_TYPE, "", "onShareClickImpl", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialUiStateKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function1<b67, Unit> a;
    public static final Function3<Context, b67, c67, Boolean> b;
    public static final Function1<b67, Unit> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1290592873, "Lcom/baidu/tieba/feed/component/uistate/SocialUiStateKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1290592873, "Lcom/baidu/tieba/feed/component/uistate/SocialUiStateKt;");
                return;
            }
        }
        a = SocialUiStateKt$onShareClickImpl$1.INSTANCE;
        b = SocialUiStateKt$onCommentClickImpl$1.INSTANCE;
        c = SocialUiStateKt$onPraiseClickImpl$1.INSTANCE;
    }
}
