package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgLeftViewItemAdapter extends ao<MsgleftView> {
    private boolean mNeedShowName;

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mNeedShowName = true;
    }

    public void fG(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public ao.a<MsgleftView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.ajP);
        return new a(msgleftView.cf(), msgleftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgleftView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgleftView aqb = aVar.aqb();
        aqb.lB(this.cXq);
        aqb.fG(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
    public class a extends ao.a<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
