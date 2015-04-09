package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends bd<MsgrightView> {
    private boolean aXK;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.aXK = false;
    }

    public void cq(boolean z) {
        this.aXK = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public be<MsgrightView> a(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mPageContext);
        return new bj(this, msgrightView.getConvertView(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bd
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<MsgrightView> beVar) {
        super.a(i, view, viewGroup, chatMessage, (be) beVar);
        MsgrightView Of = beVar.Of();
        Of.fA(this.aXB);
        Of.cq(this.aXK);
        chatMessage.getCacheData().setIs_left(0);
        Of.a(this.aXs);
        Of.setOnItemViewLongClickListener(this.aXt);
        Of.setPosition(i);
        Of.U(this.mCurrentTime);
        Of.T(chatMessage.getCacheData().getLastMsgTime());
        Of.a(viewGroup, chatMessage);
        Of.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().X(false);
        this.mPageContext.getLayoutMode().h(view);
        return view;
    }
}
