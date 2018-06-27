package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes3.dex */
public class MsgMultiImageTextViewItemAdapter extends com.baidu.tieba.im.chat.e<MsgMultiImageTextView> {
    public MsgMultiImageTextViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public e.a<MsgMultiImageTextView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgMultiImageTextView msgMultiImageTextView = new MsgMultiImageTextView(this.mPageContext);
        return new a(msgMultiImageTextView.eC(), msgMultiImageTextView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgMultiImageTextView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgMultiImageTextView aGv = aVar.aGv();
        aGv.setOnItemViewLongClickListener(this.egL);
        aGv.setPosition(i);
        aGv.bS(this.egR);
        aGv.bR(chatMessage.getCacheData().getLastMsgTime());
        aGv.a(this.mPageContext, chatMessage, viewGroup);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        com.baidu.tieba.im.b.a.aMy().a(chatMessage, this.mPageContext.getPageActivity());
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends e.a<MsgMultiImageTextView> {
        public a(View view, MsgMultiImageTextView msgMultiImageTextView) {
            super(view, msgMultiImageTextView);
        }
    }
}
