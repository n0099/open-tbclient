package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgMidViewItemAdapter extends ao<ap> {
    public MsgMidViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<ap> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        aVar.anC().setData(chatMessage);
        this.ajF.getLayoutMode().ah(false);
        this.ajF.getLayoutMode().t(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public ao.a<ap> onCreateViewHolder(ViewGroup viewGroup) {
        ap apVar = new ap(this.ajF);
        return new a(apVar.cg(), apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ao.a<ap> {
        public a(View view, ap apVar) {
            super(view, apVar);
        }
    }
}
