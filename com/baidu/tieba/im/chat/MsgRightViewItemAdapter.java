package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends bd<MsgrightView> {
    private boolean aXu;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.aXu = false;
    }

    public void cs(boolean z) {
        this.aXu = z;
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
        MsgrightView NS = beVar.NS();
        NS.fy(this.aXl);
        NS.cs(this.aXu);
        chatMessage.getCacheData().setIs_left(0);
        NS.a(this.aXc);
        NS.setOnItemViewLongClickListener(this.aXd);
        NS.setPosition(i);
        NS.U(this.mCurrentTime);
        NS.T(chatMessage.getCacheData().getLastMsgTime());
        NS.a(viewGroup, chatMessage);
        NS.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().X(false);
        this.mPageContext.getLayoutMode().h(view);
        return view;
    }
}
