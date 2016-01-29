package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean bPa;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bPa = false;
    }

    public void dk(boolean z) {
        this.bPa = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public ap.a<MsgrightView> b(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.Nw);
        return new a(msgrightView.dM(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView YX = aVar.YX();
        YX.iE(this.bOR);
        YX.dk(this.bPa);
        chatMessage.getCacheData().setIs_left(0);
        YX.a(this.bOI);
        YX.setOnItemViewLongClickListener(this.bOJ);
        YX.setPosition(i);
        YX.aQ(this.mCurrentTime);
        YX.aP(chatMessage.getCacheData().getLastMsgTime());
        YX.a(viewGroup, chatMessage);
        YX.b(viewGroup, chatMessage);
        this.Nw.getLayoutMode().ac(false);
        this.Nw.getLayoutMode().x(view);
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
