package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MsgLeftViewItemAdapter extends MsgCommonItemAdapter<MsgleftView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;

    /* loaded from: classes3.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgleftView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgLeftViewItemAdapter msgLeftViewItemAdapter, View view2, MsgleftView msgleftView) {
            super(view2, msgleftView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgLeftViewItemAdapter, view2, msgleftView};
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
    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.t = true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        c0(i, view2, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view2;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View c0(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgleftView> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, chatMessage, msgViewHolder})) == null) {
            super.S(i, view2, viewGroup, chatMessage, msgViewHolder);
            MsgleftView c = msgViewHolder.c();
            c.A(this.o);
            c.u(this.t);
            c.q(this.p);
            c.setUpdateListener(this.r);
            c.z(this.q);
            c.m();
            chatMessage.getCacheData().setIs_left(1);
            c.v(this.j);
            c.w(this.k);
            c.x(i);
            c.n(this.l);
            c.t(chatMessage.getCacheData().getLastMsgTime());
            c.y(viewGroup, chatMessage);
            c.o(viewGroup, chatMessage);
            this.i.getLayoutMode().k(false);
            this.i.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.s == i) {
            return;
        }
        this.s = i;
        H();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: m0 */
    public MsgCommonItemAdapter.MsgViewHolder<MsgleftView> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            MsgleftView msgleftView = new MsgleftView(this.i);
            return new a(this, msgleftView.e(), msgleftView);
        }
        return (MsgCommonItemAdapter.MsgViewHolder) invokeL.objValue;
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.t = z;
        }
    }
}
