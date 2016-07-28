package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean cHW;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cHW = false;
    }

    public void eU(boolean z) {
        this.cHW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public ap.a<MsgrightView> a(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.EA);
        return new a(msgrightView.ac(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView alo = aVar.alo();
        alo.kw(this.cHN);
        alo.eU(this.cHW);
        chatMessage.getCacheData().setIs_left(0);
        alo.a(this.cHE);
        alo.setOnItemViewLongClickListener(this.cHF);
        alo.setPosition(i);
        alo.bt(this.mCurrentTime);
        alo.bs(chatMessage.getCacheData().getLastMsgTime());
        alo.a(viewGroup, chatMessage);
        alo.b(viewGroup, chatMessage);
        this.EA.getLayoutMode().af(false);
        this.EA.getLayoutMode().w(view);
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
