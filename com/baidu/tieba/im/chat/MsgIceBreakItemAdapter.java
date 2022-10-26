package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.g87;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MsgIceBreakItemAdapter extends MsgCommonItemAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class MsgIceBreakViewHolder extends MsgCommonItemAdapter.MsgViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MsgIceBreakViewHolder(View view2, g87 g87Var) {
            super(view2, g87Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, g87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgIceBreakItemAdapter(TbPageContext tbPageContext) {
        super(tbPageContext, ChatMessage.TYPE_MSG_ICE_BREAK);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: E */
    public MsgCommonItemAdapter.MsgViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            g87 g87Var = new g87(this.a);
            return new MsgIceBreakViewHolder(g87Var.k(), g87Var);
        }
        return (MsgCommonItemAdapter.MsgViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.baidu.tieba.rn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        v(i, view2, viewGroup, (ChatMessage) obj, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view2;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View v(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, chatMessage, msgViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, chatMessage, msgViewHolder);
            g87 g87Var = (g87) msgViewHolder.a();
            g87Var.p(this.b);
            g87Var.q(chatMessage);
            g87Var.o(TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
