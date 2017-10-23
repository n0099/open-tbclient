package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends e<MsgrightView> {
    private boolean dmX;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dmX = false;
    }

    public void fS(boolean z) {
        this.dmX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public e.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mH);
        return new a(msgrightView.cf(), msgrightView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView asU = aVar.asU();
        asU.mj(this.dmO);
        asU.fS(this.dmX);
        chatMessage.getCacheData().setIs_left(0);
        asU.a(this.dmE);
        asU.setOnItemViewLongClickListener(this.dmF);
        asU.setPosition(i);
        asU.bA(this.dmL);
        asU.bz(chatMessage.getCacheData().getLastMsgTime());
        asU.a(viewGroup, chatMessage);
        asU.b(viewGroup, chatMessage);
        this.mH.getLayoutMode().ah(false);
        this.mH.getLayoutMode().t(view);
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
