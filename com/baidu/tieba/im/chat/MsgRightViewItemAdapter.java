package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends e<MsgrightView> {
    private boolean dhz;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dhz = false;
    }

    public void fV(boolean z) {
        this.dhz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public e.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.alI);
        return new a(msgrightView.cq(), msgrightView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView arT = aVar.arT();
        arT.lK(this.dhq);
        arT.fV(this.dhz);
        chatMessage.getCacheData().setIs_left(0);
        arT.a(this.dhg);
        arT.setOnItemViewLongClickListener(this.dhh);
        arT.setPosition(i);
        arT.bC(this.dhn);
        arT.bB(chatMessage.getCacheData().getLastMsgTime());
        arT.a(viewGroup, chatMessage);
        arT.b(viewGroup, chatMessage);
        this.alI.getLayoutMode().ah(false);
        this.alI.getLayoutMode().t(view);
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
