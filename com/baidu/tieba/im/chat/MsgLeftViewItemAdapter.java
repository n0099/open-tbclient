package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgLeftViewItemAdapter extends ap<MsgleftView> {
    private boolean mNeedShowName;

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mNeedShowName = true;
    }

    public void cK(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public ap.a<MsgleftView> a(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.mPageContext);
        return new a(msgleftView.getConvertView(), msgleftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgleftView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgleftView RP = aVar.RP();
        RP.gI(this.brB);
        RP.cK(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
        RP.a(this.brs);
        RP.setOnItemViewLongClickListener(this.brt);
        RP.setPosition(i);
        RP.as(this.mCurrentTime);
        RP.ar(chatMessage.getCacheData().getLastMsgTime());
        RP.a(viewGroup, chatMessage);
        RP.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().ad(false);
        this.mPageContext.getLayoutMode().k(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ap.a<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
