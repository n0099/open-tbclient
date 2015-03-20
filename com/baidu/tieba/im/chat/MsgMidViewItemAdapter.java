package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgMidViewItemAdapter extends bd<bg> {
    public MsgMidViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bd
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<bg> beVar) {
        super.a(i, view, viewGroup, chatMessage, (be) beVar);
        beVar.NS().setData(chatMessage);
        this.mPageContext.getLayoutMode().X(false);
        this.mPageContext.getLayoutMode().h(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public be<bg> a(ViewGroup viewGroup) {
        bg bgVar = new bg(this.mPageContext);
        return new bi(this, bgVar.getConvertView(), bgVar);
    }
}
