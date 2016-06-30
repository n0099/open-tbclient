package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean cFh;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cFh = false;
    }

    public void eT(boolean z) {
        this.cFh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public ap.a<MsgrightView> a(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.Ea);
        return new a(msgrightView.ac(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView akE = aVar.akE();
        akE.kq(this.cEY);
        akE.eT(this.cFh);
        chatMessage.getCacheData().setIs_left(0);
        akE.a(this.cEP);
        akE.setOnItemViewLongClickListener(this.cEQ);
        akE.setPosition(i);
        akE.by(this.mCurrentTime);
        akE.bx(chatMessage.getCacheData().getLastMsgTime());
        akE.a(viewGroup, chatMessage);
        akE.b(viewGroup, chatMessage);
        this.Ea.getLayoutMode().ad(false);
        this.Ea.getLayoutMode().w(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ap.a<MsgrightView> {
        public a(View view, MsgrightView msgrightView) {
            super(view, msgrightView);
        }
    }
}
