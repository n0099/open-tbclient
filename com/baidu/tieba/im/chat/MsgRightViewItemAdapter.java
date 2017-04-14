package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ao<MsgrightView> {
    private boolean cNL;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cNL = false;
    }

    public void fr(boolean z) {
        this.cNL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public ao.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.ajT);
        return new a(msgrightView.cf(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView anw = aVar.anw();
        anw.ld(this.cNC);
        anw.fr(this.cNL);
        chatMessage.getCacheData().setIs_left(0);
        anw.a(this.cNs);
        anw.setOnItemViewLongClickListener(this.cNt);
        anw.setPosition(i);
        anw.by(this.cNz);
        anw.bx(chatMessage.getCacheData().getLastMsgTime());
        anw.a(viewGroup, chatMessage);
        anw.b(viewGroup, chatMessage);
        this.ajT.getLayoutMode().aj(false);
        this.ajT.getLayoutMode().t(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ao.a<MsgrightView> {
        public a(View view, MsgrightView msgrightView) {
            super(view, msgrightView);
        }
    }
}
