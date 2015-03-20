package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgActivityViewItemAdapter extends bd<MsgActivityView> {
    public MsgActivityViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bd
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<MsgActivityView> beVar) {
        super.a(i, view, viewGroup, chatMessage, (be) beVar);
        MsgActivityView NS = beVar.NS();
        NS.setPosition(i);
        NS.setData(chatMessage);
        NS.a(this.aXc);
        NS.setOnItemViewLongClickListener(this.aXd);
        NS.U(this.mCurrentTime);
        NS.T(chatMessage.getCacheData().getLastMsgTime());
        this.mPageContext.getLayoutMode().X(false);
        this.mPageContext.getLayoutMode().h(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public be<MsgActivityView> a(ViewGroup viewGroup) {
        MsgActivityView msgActivityView = new MsgActivityView(this.mPageContext);
        return new bb(this, msgActivityView.getConvertView(), msgActivityView);
    }
}
