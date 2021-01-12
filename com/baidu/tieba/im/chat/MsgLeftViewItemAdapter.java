package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgLeftViewItemAdapter extends MsgCommonItemAdapter<MsgleftView> {
    private boolean mNeedShowName;

    public MsgLeftViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mNeedShowName = true;
    }

    public void sq(boolean z) {
        this.mNeedShowName = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public MsgCommonItemAdapter.MsgViewHolder<MsgleftView> e(ViewGroup viewGroup) {
        MsgleftView msgleftView = new MsgleftView(this.mPageContext);
        return new a(msgleftView.getConvertView(), msgleftView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgleftView> msgViewHolder) {
        super.a(i, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) msgViewHolder);
        MsgleftView cSH = msgViewHolder.cSH();
        cSH.Cq(this.ksh);
        cSH.sq(this.mNeedShowName);
        chatMessage.getCacheData().setIs_left(1);
        cSH.a(this.krY);
        cSH.setOnItemViewLongClickListener(this.krZ);
        cSH.setPosition(i);
        cSH.gH(this.goc);
        cSH.gG(chatMessage.getCacheData().getLastMsgTime());
        cSH.a(viewGroup, chatMessage);
        cSH.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgleftView> {
        public a(View view, MsgleftView msgleftView) {
            super(view, msgleftView);
        }
    }
}
