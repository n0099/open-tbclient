package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class MsgActivityViewItemAdapter extends MsgCommonItemAdapter<MsgActivityView> {

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgActivityView> {
        public a(MsgActivityViewItemAdapter msgActivityViewItemAdapter, View view, MsgActivityView msgActivityView) {
            super(view, msgActivityView);
        }
    }

    public MsgActivityViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View h0(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgActivityView> msgViewHolder) {
        super.W(i2, view, viewGroup, chatMessage, msgViewHolder);
        MsgActivityView b2 = msgViewHolder.b();
        b2.r(i2);
        b2.H(chatMessage);
        b2.p(this.n);
        b2.q(this.o);
        b2.j(this.p);
        b2.n(chatMessage.getCacheData().getLastMsgTime());
        this.m.getLayoutMode().k(false);
        this.m.getLayoutMode().j(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public MsgCommonItemAdapter.MsgViewHolder<MsgActivityView> P(ViewGroup viewGroup) {
        MsgActivityView msgActivityView = new MsgActivityView(this.m);
        return new a(this, msgActivityView.e(), msgActivityView);
    }
}
