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

    public void dj(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public ap.a<MsgleftView> b(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.Nw);
        return new a(msgleftView.dM(), msgleftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgleftView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgleftView YX = aVar.YX();
        YX.iE(this.bOR);
        YX.dj(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
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
    public class a extends ap.a<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
