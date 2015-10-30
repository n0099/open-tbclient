package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean brV;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.brV = false;
    }

    public void cL(boolean z) {
        this.brV = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public ap.a<MsgrightView> a(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mPageContext);
        return new a(msgrightView.getConvertView(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView RL = aVar.RL();
        RL.gI(this.brM);
        RL.cL(this.brV);
        chatMessage.getCacheData().setIs_left(0);
        RL.a(this.brD);
        RL.setOnItemViewLongClickListener(this.brE);
        RL.setPosition(i);
        RL.aA(this.mCurrentTime);
        RL.az(chatMessage.getCacheData().getLastMsgTime());
        RL.a(viewGroup, chatMessage);
        RL.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().ad(false);
        this.mPageContext.getLayoutMode().k(view);
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
