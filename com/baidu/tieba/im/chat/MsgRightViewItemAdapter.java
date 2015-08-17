package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean bon;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bon = false;
    }

    public void cG(boolean z) {
        this.bon = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public ap.a<MsgrightView> a(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.Mr);
        return new a(msgrightView.getConvertView(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView Rg = aVar.Rg();
        Rg.gs(this.boe);
        Rg.cG(this.bon);
        chatMessage.getCacheData().setIs_left(0);
        Rg.a(this.bnV);
        Rg.setOnItemViewLongClickListener(this.bnW);
        Rg.setPosition(i);
        Rg.af(this.mCurrentTime);
        Rg.ae(chatMessage.getCacheData().getLastMsgTime());
        Rg.a(viewGroup, chatMessage);
        Rg.b(viewGroup, chatMessage);
        this.Mr.getLayoutMode().ad(false);
        this.Mr.getLayoutMode().k(view);
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
