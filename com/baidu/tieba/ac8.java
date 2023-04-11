package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.impersonal.data.VoiceMsgContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class ac8 extends yb8<VoiceMsgContent, ChatVoiceView, ga8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int b;
    public final int c;
    public final int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac8(String name) {
        super(name);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {name};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(name, "name");
        this.b = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
        this.c = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
        this.d = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    }

    public static final boolean l(ga8 data, View it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, data, it)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Function2<View, na8<VoiceMsgContent>, Unit> d = data.d();
            if (d != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                d.invoke(it, data.c());
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.yb8
    public void f(ViewGroup container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            int i = this.b;
            int i2 = this.d;
            container.setPadding(i, i2, this.c, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yb8
    /* renamed from: k */
    public void d(ChatVoiceView chatVoiceView, final ga8 data) {
        VoiceData.VoiceModel d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, chatVoiceView, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (chatVoiceView != null) {
                chatVoiceView.i("");
                VoiceMsgContent f = data.c().f();
                if (f != null && (d = f.d()) != null) {
                    chatVoiceView.setData(d);
                }
                chatVoiceView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.vb8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) ? ac8.l(ga8.this, view2) : invokeL.booleanValue;
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yb8
    /* renamed from: m */
    public ChatVoiceView g(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ChatVoiceView chatVoiceView = new ChatVoiceView(parent.getContext(), true);
            chatVoiceView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            chatVoiceView.setId(R.id.obfuscated_res_0x7f090e41);
            chatVoiceView.setOnClickListener(chatVoiceView);
            return chatVoiceView;
        }
        return (ChatVoiceView) invokeL.objValue;
    }
}
