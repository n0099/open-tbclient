package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends e<MsgrightView> {
    private boolean itI;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.itI = false;
    }

    public void oL(boolean z) {
        this.itI = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public e.a<MsgrightView> b(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mPageContext);
        return new a(msgrightView.getConvertView(), msgrightView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgrightView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        MsgrightView cjK = aVar.cjK();
        cjK.xo(this.itz);
        cjK.oL(this.itI);
        chatMessage.getCacheData().setIs_left(0);
        cjK.a(this.itq);
        cjK.setOnItemViewLongClickListener(this.itr);
        cjK.setPosition(i);
        cjK.ew(this.eWd);
        cjK.ev(chatMessage.getCacheData().getLastMsgTime());
        cjK.a(viewGroup, chatMessage);
        cjK.b(viewGroup, chatMessage);
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
