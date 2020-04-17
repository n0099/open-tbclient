package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes13.dex */
public class MsgActivityViewItemAdapter extends e<MsgActivityView> {
    public MsgActivityViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgActivityView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        MsgActivityView cde = aVar.cde();
        cde.setPosition(i);
        cde.setData(chatMessage);
        cde.a(this.idO);
        cde.setOnItemViewLongClickListener(this.idP);
        cde.ev(this.eJq);
        cde.eu(chatMessage.getCacheData().getLastMsgTime());
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public e.a<MsgActivityView> b(ViewGroup viewGroup) {
        MsgActivityView msgActivityView = new MsgActivityView(this.mPageContext);
        return new a(msgActivityView.getConvertView(), msgActivityView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a extends e.a<MsgActivityView> {
        public a(View view, MsgActivityView msgActivityView) {
            super(view, msgActivityView);
        }
    }
}
