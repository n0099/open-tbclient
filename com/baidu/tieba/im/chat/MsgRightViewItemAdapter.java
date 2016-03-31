package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean bZs;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bZs = false;
    }

    public void dE(boolean z) {
        this.bZs = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public ap.a<MsgrightView> b(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.ND);
        return new a(msgrightView.dM(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView acq = aVar.acq();
        acq.jl(this.bZj);
        acq.dE(this.bZs);
        chatMessage.getCacheData().setIs_left(0);
        acq.a(this.bZa);
        acq.setOnItemViewLongClickListener(this.bZb);
        acq.setPosition(i);
        acq.aW(this.mCurrentTime);
        acq.aV(chatMessage.getCacheData().getLastMsgTime());
        acq.a(viewGroup, chatMessage);
        acq.b(viewGroup, chatMessage);
        this.ND.getLayoutMode().ab(false);
        this.ND.getLayoutMode().x(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ap.a<MsgrightView> {
        public a(View view, MsgrightView msgrightView) {
            super(view, msgrightView);
        }
    }
}
