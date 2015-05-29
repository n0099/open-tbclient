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

    public void cA(boolean z) {
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
        MsgleftView Pu = beVar.Pu();
        Pu.fR(this.bah);
        Pu.cA(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
