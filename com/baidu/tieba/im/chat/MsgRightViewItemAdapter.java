package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends ap<MsgrightView> {
    private boolean bZX;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bZX = false;
    }

    public void ef(boolean z) {
        this.bZX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public ap.a<MsgrightView> b(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.DV);
        return new a(msgrightView.ac(), msgrightView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgrightView acs = aVar.acs();
        acs.iO(this.bZO);
        acs.ef(this.bZX);
        chatMessage.getCacheData().setIs_left(0);
        acs.a(this.bZF);
        acs.setOnItemViewLongClickListener(this.bZG);
        acs.setPosition(i);
        acs.aW(this.mCurrentTime);
        acs.setLastTime(chatMessage.getCacheData().getLastMsgTime());
        acs.a(viewGroup, chatMessage);
        acs.b(viewGroup, chatMessage);
        this.DV.getLayoutMode().ae(false);
        this.DV.getLayoutMode().x(view);
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
