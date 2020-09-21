package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends e<MsgrightView> {
    private boolean joE;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.joE = false;
    }

    public void qq(boolean z) {
        this.joE = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public e.a<MsgrightView> c(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mPageContext);
        return new a(msgrightView.getConvertView(), msgrightView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        MsgrightView cFA = aVar.cFA();
        cFA.Bl(this.jov);
        cFA.qq(this.joE);
        chatMessage.getCacheData().setIs_left(0);
        cFA.a(this.jom);
        cFA.setOnItemViewLongClickListener(this.jon);
        cFA.setPosition(i);
        cFA.fm(this.fAb);
        cFA.fl(chatMessage.getCacheData().getLastMsgTime());
        cFA.a(viewGroup, chatMessage);
        cFA.b(viewGroup, chatMessage);
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
