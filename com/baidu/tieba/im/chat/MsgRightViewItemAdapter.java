package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ao<MsgrightView> {
    private boolean cMZ;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cMZ = false;
    }

    public void fB(boolean z) {
        this.cMZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public ao.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.FY);
        return new a(msgrightView.aX(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView aoi = aVar.aoi();
        aoi.lm(this.cMQ);
        aoi.fB(this.cMZ);
        chatMessage.getCacheData().setIs_left(0);
        aoi.a(this.cMG);
        aoi.setOnItemViewLongClickListener(this.cMH);
        aoi.setPosition(i);
        aoi.bx(this.cMN);
        aoi.bw(chatMessage.getCacheData().getLastMsgTime());
        aoi.a(viewGroup, chatMessage);
        aoi.b(viewGroup, chatMessage);
        this.FY.getLayoutMode().ai(false);
        this.FY.getLayoutMode().v(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ao.a<MsgrightView> {
        public a(View view, MsgrightView msgrightView) {
            super(view, msgrightView);
        }
    }
}
