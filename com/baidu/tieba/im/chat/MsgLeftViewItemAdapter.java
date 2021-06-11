package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class MsgLeftViewItemAdapter extends MsgCommonItemAdapter<MsgleftView> {
    public boolean t;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgleftView> {
        public a(MsgLeftViewItemAdapter msgLeftViewItemAdapter, View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.t = true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View i0(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgleftView> msgViewHolder) {
        super.X(i2, view, viewGroup, chatMessage, msgViewHolder);
        MsgleftView b2 = msgViewHolder.b();
        b2.u(this.s);
        b2.p(this.t);
        chatMessage.getCacheData().setIs_left(1);
        b2.q(this.n);
        b2.r(this.o);
        b2.s(i2);
        b2.k(this.p);
        b2.o(chatMessage.getCacheData().getLastMsgTime());
        b2.t(viewGroup, chatMessage);
        b2.l(viewGroup, chatMessage);
        this.m.getLayoutMode().k(false);
        this.m.getLayoutMode().j(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public MsgCommonItemAdapter.MsgViewHolder<MsgleftView> Q(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.m);
        return new a(this, msgleftView.e(), msgleftView);
    }

    public void s0(boolean z) {
        this.t = z;
    }
}
