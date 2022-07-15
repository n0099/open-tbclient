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
import com.repackage.lx7;
/* loaded from: classes3.dex */
public class MsgRightViewItemAdapter extends MsgCommonItemAdapter<MsgrightView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public boolean u;
    public lx7 v;
    public TbPageContext<MsglistActivity<?>> w;

    /* loaded from: classes3.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgrightView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgRightViewItemAdapter msgRightViewItemAdapter, View view2, MsgrightView msgrightView) {
            super(view2, msgrightView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRightViewItemAdapter, view2, msgrightView};
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
    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.t = false;
        this.u = false;
        this.v = null;
        this.w = null;
        this.w = tbPageContext;
        l0();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        c0(i, view2, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view2;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View c0(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgrightView> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, chatMessage, msgViewHolder})) == null) {
            super.S(i, view2, viewGroup, chatMessage, msgViewHolder);
            MsgrightView c = msgViewHolder.c();
            c.E(this.o);
            c.w(this.t);
            c.t(this.p);
            c.setUpdateListener(this.r);
            c.D(this.q);
            c.v(this.u);
            c.q();
            chatMessage.getCacheData().setIs_left(0);
            c.z(this.j);
            c.A(this.k);
            c.B(i);
            c.r(this.l);
            c.x(chatMessage.getCacheData().getLastMsgTime());
            c.C(viewGroup, chatMessage);
            c.s(viewGroup, chatMessage);
            this.w.getLayoutMode().k(false);
            this.w.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            lx7 lx7Var = new lx7(this.a);
            this.v = lx7Var;
            lx7Var.b(this.w.getUniqueId());
        }
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.s == i) {
            return;
        }
        this.s = i;
        G();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: n0 */
    public MsgCommonItemAdapter.MsgViewHolder<MsgrightView> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            MsgrightView msgrightView = new MsgrightView(this.w, this.v);
            return new a(this, msgrightView.h(), msgrightView);
        }
        return (MsgCommonItemAdapter.MsgViewHolder) invokeL.objValue;
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.u = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.t = z;
        }
    }
}
