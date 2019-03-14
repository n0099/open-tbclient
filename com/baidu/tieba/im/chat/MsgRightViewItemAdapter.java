package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends e<MsgrightView> {
    private boolean gbN;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gbN = false;
    }

    public void kI(boolean z) {
        this.gbN = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public e.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mPageContext);
        return new a(msgrightView.fY(), msgrightView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView bqg = aVar.bqg();
        bqg.tz(this.gbE);
        bqg.kI(this.gbN);
        chatMessage.getCacheData().setIs_left(0);
        bqg.a(this.gbu);
        bqg.setOnItemViewLongClickListener(this.gbv);
        bqg.setPosition(i);
        bqg.cU(this.gbB);
        bqg.cT(chatMessage.getCacheData().getLastMsgTime());
        bqg.a(viewGroup, chatMessage);
        bqg.b(viewGroup, chatMessage);
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
