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

    public void fp(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public ap.a<MsgleftView> a(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.GM);
        return new a(msgleftView.aX(), msgleftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgleftView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgleftView aqd = aVar.aqd();
        aqd.kZ(this.cTt);
        aqd.fp(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
    public class a extends ap.a<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
