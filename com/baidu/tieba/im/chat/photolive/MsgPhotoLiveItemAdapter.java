package com.baidu.tieba.im.chat.photolive;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class MsgPhotoLiveItemAdapter extends MsgCommonItemAdapter<MsgPhotoLiveCardVew> {

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgPhotoLiveCardVew> {
        public a(MsgPhotoLiveItemAdapter msgPhotoLiveItemAdapter, View view, MsgPhotoLiveCardVew msgPhotoLiveCardVew) {
            super(view, msgPhotoLiveCardVew);
        }
    }

    public MsgPhotoLiveItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View h0(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgPhotoLiveCardVew> msgViewHolder) {
        super.W(i2, view, viewGroup, chatMessage, msgViewHolder);
        MsgPhotoLiveCardVew b2 = msgViewHolder.b();
        b2.P(this.m, chatMessage, viewGroup);
        b2.p(this.n);
        b2.r(i2);
        this.m.getLayoutMode().k(false);
        this.m.getLayoutMode().j(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public MsgCommonItemAdapter.MsgViewHolder<MsgPhotoLiveCardVew> P(ViewGroup viewGroup) {
        MsgPhotoLiveCardVew msgPhotoLiveCardVew = new MsgPhotoLiveCardVew(this.m);
        return new a(this, msgPhotoLiveCardVew.e(), msgPhotoLiveCardVew);
    }
}
