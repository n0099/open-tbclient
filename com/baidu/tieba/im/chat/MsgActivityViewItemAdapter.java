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
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgActivityView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgActivityView bqd = aVar.bqd();
        bqd.setPosition(i);
        bqd.setData(chatMessage);
        bqd.a(this.gbi);
        bqd.setOnItemViewLongClickListener(this.gbj);
        bqd.cU(this.gbp);
        bqd.cT(chatMessage.getCacheData().getLastMsgTime());
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public e.a<MsgActivityView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgActivityView msgActivityView = new MsgActivityView(this.mPageContext);
        return new a(msgActivityView.fY(), msgActivityView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends e.a<MsgActivityView> {
        public a(View view, MsgActivityView msgActivityView) {
            super(view, msgActivityView);
        }
    }
}
