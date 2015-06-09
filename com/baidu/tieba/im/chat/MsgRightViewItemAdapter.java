package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends bd<MsgrightView> {
    private boolean bas;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bas = false;
    }

    public void cB(boolean z) {
        this.bas = z;
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
        MsgrightView Pv = beVar.Pv();
        Pv.fR(this.bai);
        Pv.cB(this.bas);
        chatMessage.getCacheData().setIs_left(0);
        Pv.a(this.aZZ);
        Pv.setOnItemViewLongClickListener(this.baa);
        Pv.setPosition(i);
        Pv.V(this.mCurrentTime);
        Pv.U(chatMessage.getCacheData().getLastMsgTime());
        Pv.a(viewGroup, chatMessage);
        Pv.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().ab(false);
        this.mPageContext.getLayoutMode().j(view);
        return view;
    }
}
