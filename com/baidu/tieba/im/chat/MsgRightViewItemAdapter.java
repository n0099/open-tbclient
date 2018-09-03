package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends e<MsgrightView> {
    private boolean ekP;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.ekP = false;
    }

    public void hd(boolean z) {
        this.ekP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public e.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mPageContext);
        return new a(msgrightView.eB(), msgrightView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView aHs = aVar.aHs();
        aHs.nM(this.ekG);
        aHs.hd(this.ekP);
        chatMessage.getCacheData().setIs_left(0);
        aHs.a(this.ekw);
        aHs.setOnItemViewLongClickListener(this.ekx);
        aHs.setPosition(i);
        aHs.bX(this.ekD);
        aHs.bW(chatMessage.getCacheData().getLastMsgTime());
        aHs.a(viewGroup, chatMessage);
        aHs.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends e.a<MsgrightView> {
        public a(View view, MsgrightView msgrightView) {
            super(view, msgrightView);
        }
    }
}
