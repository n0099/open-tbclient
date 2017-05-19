package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ao<MsgrightView> {
    private boolean cKf;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cKf = false;
    }

    public void fc(boolean z) {
        this.cKf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public ao.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.ajr);
        return new a(msgrightView.cf(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView alq = aVar.alq();
        alq.kW(this.cJW);
        alq.fc(this.cKf);
        chatMessage.getCacheData().setIs_left(0);
        alq.a(this.cJM);
        alq.setOnItemViewLongClickListener(this.cJN);
        alq.setPosition(i);
        alq.bj(this.cJT);
        alq.bi(chatMessage.getCacheData().getLastMsgTime());
        alq.a(viewGroup, chatMessage);
        alq.b(viewGroup, chatMessage);
        this.ajr.getLayoutMode().ai(false);
        this.ajr.getLayoutMode().t(view);
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
