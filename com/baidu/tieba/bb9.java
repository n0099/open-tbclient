package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.impersonal.data.MsgGuideInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public final class bb9 extends mq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> b;

    @Override // com.baidu.tieba.mq8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "jump_to" : (String) invokeV.objValue;
    }

    public bb9(TbPageContext<BaseFragmentActivity> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.b = pageContext;
    }

    @Override // com.baidu.tieba.mq8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (Intrinsics.areEqual(abilityItem.getType(), d())) {
                return;
            }
            MsgGuideInfo a = fe9.a.a(abilityItem);
            if (a != null) {
                String content = a.getContent();
                Boolean bool = null;
                if (content != null) {
                    if (!(!StringsKt__StringsJVMKt.isBlank(content))) {
                        content = null;
                    }
                    if (content != null) {
                        bool = Boolean.valueOf(UrlManager.getInstance().dealOneLink(this.b, new String[]{content}));
                    }
                }
                if (bool != null) {
                    return;
                }
            }
            a(abilityItem, baseItem);
            Unit unit = Unit.INSTANCE;
        }
    }
}
