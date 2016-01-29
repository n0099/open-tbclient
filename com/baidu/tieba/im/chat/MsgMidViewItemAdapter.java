package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgMidViewItemAdapter extends ap<aq> {
    public MsgMidViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<aq> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        aVar.YX().setData(chatMessage);
        this.Nw.getLayoutMode().ac(false);
        this.Nw.getLayoutMode().x(view);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public ap.a<aq> b(ViewGroup viewGroup) {
        aq aqVar = new aq(this.Nw);
        return new a(aqVar.dM(), aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ap.a<aq> {
        public a(View view, aq aqVar) {
            super(view, aqVar);
        }
    }
}
