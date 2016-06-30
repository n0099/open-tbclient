package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgLeftViewItemAdapter extends ap<MsgleftView> {
    private boolean mNeedShowName;

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mNeedShowName = true;
    }

    public void eS(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public ap.a<MsgleftView> a(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.Ea);
        return new a(msgleftView.ac(), msgleftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgleftView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgleftView akE = aVar.akE();
        akE.kq(this.cEY);
        akE.eS(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
    public class a extends ap.a<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
