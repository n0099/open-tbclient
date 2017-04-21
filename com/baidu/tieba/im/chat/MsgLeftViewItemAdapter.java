package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgLeftViewItemAdapter extends ao<MsgleftView> {
    private boolean mNeedShowName;

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mNeedShowName = true;
    }

    public void fA(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public ao.a<MsgleftView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.ajU);
        return new a(msgleftView.cf(), msgleftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgleftView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgleftView aox = aVar.aox();
        aox.lj(this.cPT);
        aox.fA(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
    public class a extends ao.a<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
