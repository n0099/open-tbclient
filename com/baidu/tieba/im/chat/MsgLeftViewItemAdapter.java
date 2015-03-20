package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgLeftViewItemAdapter extends bd<MsgleftView> {
    private boolean mNeedShowName;

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mNeedShowName = true;
    }

    public void cr(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public be<MsgleftView> a(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.mPageContext);
        return new bf(this, msgleftView.getConvertView(), msgleftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bd
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<MsgleftView> beVar) {
        super.a(i, view, viewGroup, chatMessage, (be) beVar);
        MsgleftView NS = beVar.NS();
        NS.fy(this.aXl);
        NS.cr(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
