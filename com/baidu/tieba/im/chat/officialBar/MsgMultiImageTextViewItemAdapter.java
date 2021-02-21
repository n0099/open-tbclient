package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes8.dex */
public class MsgMultiImageTextViewItemAdapter extends MsgCommonItemAdapter<MsgMultiImageTextView> {
    public MsgMultiImageTextViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public MsgCommonItemAdapter.MsgViewHolder<MsgMultiImageTextView> e(ViewGroup viewGroup) {
        MsgMultiImageTextView msgMultiImageTextView = new MsgMultiImageTextView(this.mPageContext);
        return new a(msgMultiImageTextView.getConvertView(), msgMultiImageTextView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgMultiImageTextView> msgViewHolder) {
        super.a(i, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) msgViewHolder);
        MsgMultiImageTextView cUM = msgViewHolder.cUM();
        cUM.setOnItemViewLongClickListener(this.kAu);
        cUM.setPosition(i);
        cUM.gM(this.mCurrentTime);
        cUM.gL(chatMessage.getCacheData().getLastMsgTime());
        cUM.a(this.mPageContext, chatMessage, viewGroup);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        com.baidu.tieba.im.b.a.cYd().a(chatMessage, this.mPageContext.getPageActivity());
        com.baidu.tieba.im.b.a.cYd().b(chatMessage, this.mPageContext.getPageActivity());
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgMultiImageTextView> {
        public a(View view, MsgMultiImageTextView msgMultiImageTextView) {
            super(view, msgMultiImageTextView);
        }
    }
}
