package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ao<MsgrightView> {
    private boolean cXz;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cXz = false;
    }

    public void fH(boolean z) {
        this.cXz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public ao.a<MsgrightView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.ajP);
        return new a(msgrightView.cf(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgrightView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgrightView aqb = aVar.aqb();
        aqb.lB(this.cXq);
        aqb.fH(this.cXz);
        chatMessage.getCacheData().setIs_left(0);
        aqb.a(this.cXg);
        aqb.setOnItemViewLongClickListener(this.cXh);
        aqb.setPosition(i);
        aqb.bA(this.cXn);
        aqb.bz(chatMessage.getCacheData().getLastMsgTime());
        aqb.a(viewGroup, chatMessage);
        aqb.b(viewGroup, chatMessage);
        this.ajP.getLayoutMode().ah(false);
        this.ajP.getLayoutMode().t(view);
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
