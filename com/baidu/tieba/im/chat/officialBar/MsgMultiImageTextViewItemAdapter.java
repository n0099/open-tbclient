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
    /* renamed from: bv */
    public e.a<MsgMultiImageTextView> b(ViewGroup viewGroup) {
        MsgMultiImageTextView msgMultiImageTextView = new MsgMultiImageTextView(this.mPageContext);
        return new a(msgMultiImageTextView.getConvertView(), msgMultiImageTextView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgMultiImageTextView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        MsgMultiImageTextView byi = aVar.byi();
        byi.setOnItemViewLongClickListener(this.gyE);
        byi.setPosition(i);
        byi.da(this.dGu);
        byi.cZ(chatMessage.getCacheData().getLastMsgTime());
        byi.a(this.mPageContext, chatMessage, viewGroup);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        com.baidu.tieba.im.b.a.bEg().a(chatMessage, this.mPageContext.getPageActivity());
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
