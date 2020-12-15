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

    public void sb(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public e.a<MsgleftView> c(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.mPageContext);
        return new a(msgleftView.getConvertView(), msgleftView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgleftView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        MsgleftView cTM = aVar.cTM();
        cTM.DK(this.kkg);
        cTM.sb(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
        cTM.a(this.kjX);
        cTM.setOnItemViewLongClickListener(this.kjY);
        cTM.setPosition(i);
        cTM.gJ(this.gim);
        cTM.gI(chatMessage.getCacheData().getLastMsgTime());
        cTM.a(viewGroup, chatMessage);
        cTM.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
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
