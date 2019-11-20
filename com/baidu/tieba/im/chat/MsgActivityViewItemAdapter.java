package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes3.dex */
public class MsgActivityViewItemAdapter extends e<MsgActivityView> {
    public MsgActivityViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgActivityView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        MsgActivityView byi = aVar.byi();
        byi.setPosition(i);
        byi.setData(chatMessage);
        byi.a(this.gyD);
        byi.setOnItemViewLongClickListener(this.gyE);
        byi.da(this.dGu);
        byi.cZ(chatMessage.getCacheData().getLastMsgTime());
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public e.a<MsgActivityView> b(ViewGroup viewGroup) {
        MsgActivityView msgActivityView = new MsgActivityView(this.mPageContext);
        return new a(msgActivityView.getConvertView(), msgActivityView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends e.a<MsgActivityView> {
        public a(View view, MsgActivityView msgActivityView) {
            super(view, msgActivityView);
        }
    }
}
