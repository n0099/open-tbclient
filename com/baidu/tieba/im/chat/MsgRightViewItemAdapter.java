package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean cTC;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cTC = false;
    }

    public void fq(boolean z) {
        this.cTC = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public ap.a<MsgrightView> a(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.GM);
        return new a(msgrightView.aX(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView aqd = aVar.aqd();
        aqd.kZ(this.cTt);
        aqd.fq(this.cTC);
        chatMessage.getCacheData().setIs_left(0);
        aqd.a(this.cTk);
        aqd.setOnItemViewLongClickListener(this.cTl);
        aqd.setPosition(i);
        aqd.bP(this.mCurrentTime);
        aqd.bO(chatMessage.getCacheData().getLastMsgTime());
        aqd.a(viewGroup, chatMessage);
        aqd.b(viewGroup, chatMessage);
        this.GM.getLayoutMode().ah(false);
        this.GM.getLayoutMode().x(view);
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
