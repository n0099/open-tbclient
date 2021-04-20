package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class MsgRightViewItemAdapter extends MsgCommonItemAdapter<MsgrightView> {
    public boolean t;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgrightView> {
        public a(MsgRightViewItemAdapter msgRightViewItemAdapter, View view, MsgrightView msgrightView) {
            super(view, msgrightView);
        }
    }

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.t = false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View l0(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgrightView> msgViewHolder) {
        super.X(i, view, viewGroup, chatMessage, msgViewHolder);
        MsgrightView b2 = msgViewHolder.b();
        b2.w(this.s);
        b2.n(this.t);
        chatMessage.getCacheData().setIs_left(0);
        b2.r(this.n);
        b2.s(this.o);
        b2.u(i);
        b2.k(this.p);
        b2.o(chatMessage.getCacheData().getLastMsgTime());
        b2.v(viewGroup, chatMessage);
        b2.l(viewGroup, chatMessage);
        this.m.getLayoutMode().k(false);
        this.m.getLayoutMode().j(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: r0 */
    public MsgCommonItemAdapter.MsgViewHolder<MsgrightView> R(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.m);
        return new a(this, msgrightView.e(), msgrightView);
    }

    public void s0(boolean z) {
        this.t = z;
    }
}
