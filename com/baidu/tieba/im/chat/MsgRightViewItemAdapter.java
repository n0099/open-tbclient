package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends bd<MsgrightView> {
    private boolean baq;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.baq = false;
    }

    public void cB(boolean z) {
        this.baq = z;
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
        MsgrightView Pu = beVar.Pu();
        Pu.fR(this.bah);
        Pu.cB(this.baq);
        chatMessage.getCacheData().setIs_left(0);
        Pu.a(this.aZY);
        Pu.setOnItemViewLongClickListener(this.aZZ);
        Pu.setPosition(i);
        Pu.V(this.mCurrentTime);
        Pu.U(chatMessage.getCacheData().getLastMsgTime());
        Pu.a(viewGroup, chatMessage);
        Pu.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().ab(false);
        this.mPageContext.getLayoutMode().j(view);
        return view;
    }
}
