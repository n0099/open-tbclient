package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bd;
import com.baidu.tieba.im.chat.be;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgMultiImageTextViewItemAdapter extends bd<MsgMultiImageTextView> {
    public MsgMultiImageTextViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public be<MsgMultiImageTextView> a(ViewGroup viewGroup) {
        MsgMultiImageTextView msgMultiImageTextView = new MsgMultiImageTextView(this.mPageContext);
        return new b(this, msgMultiImageTextView.getConvertView(), msgMultiImageTextView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bd
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<MsgMultiImageTextView> beVar) {
        super.a(i, view, viewGroup, chatMessage, (be) beVar);
        MsgMultiImageTextView NS = beVar.NS();
        NS.setOnItemViewLongClickListener(this.aXd);
        NS.setPosition(i);
        NS.U(this.mCurrentTime);
        NS.T(chatMessage.getCacheData().getLastMsgTime());
        NS.a(this.mPageContext, chatMessage, viewGroup);
        this.mPageContext.getLayoutMode().X(false);
        this.mPageContext.getLayoutMode().h(view);
        com.baidu.tieba.im.d.a.Ts().a(chatMessage, i, this.mPageContext.getPageActivity());
        return view;
    }
}
