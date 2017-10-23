package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgLeftViewItemAdapter extends e<MsgleftView> {
    private boolean mNeedShowName;

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mNeedShowName = true;
    }

    public void fR(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public e.a<MsgleftView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.mH);
        return new a(msgleftView.cf(), msgleftView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgleftView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgleftView asU = aVar.asU();
        asU.mj(this.dmO);
        asU.fR(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
    public class a extends e.a<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
