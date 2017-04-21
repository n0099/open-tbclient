package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ao<MsgrightView> {
    private boolean cQc;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cQc = false;
    }

    public void fB(boolean z) {
        this.cQc = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public ao.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.ajU);
        return new a(msgrightView.cf(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView aox = aVar.aox();
        aox.lj(this.cPT);
        aox.fB(this.cQc);
        chatMessage.getCacheData().setIs_left(0);
        aox.a(this.cPJ);
        aox.setOnItemViewLongClickListener(this.cPK);
        aox.setPosition(i);
        aox.by(this.cPQ);
        aox.bx(chatMessage.getCacheData().getLastMsgTime());
        aox.a(viewGroup, chatMessage);
        aox.b(viewGroup, chatMessage);
        this.ajU.getLayoutMode().aj(false);
        this.ajU.getLayoutMode().t(view);
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
