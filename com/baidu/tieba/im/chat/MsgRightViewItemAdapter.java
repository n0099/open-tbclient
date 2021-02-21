package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgRightViewItemAdapter extends MsgCommonItemAdapter<MsgrightView> {
    private boolean kAL;

    public MsgRightViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.kAL = false;
    }

    public void sE(boolean z) {
        this.kAL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public MsgCommonItemAdapter.MsgViewHolder<MsgrightView> e(ViewGroup viewGroup) {
        MsgrightView msgrightView = new MsgrightView(this.mPageContext);
        return new a(msgrightView.getConvertView(), msgrightView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<MsgrightView> msgViewHolder) {
        super.a(i, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) msgViewHolder);
        MsgrightView cUM = msgViewHolder.cUM();
        cUM.CH(this.kAC);
        cUM.sE(this.kAL);
        chatMessage.getCacheData().setIs_left(0);
        cUM.a(this.kAt);
        cUM.setOnItemViewLongClickListener(this.kAu);
        cUM.setPosition(i);
        cUM.gM(this.mCurrentTime);
        cUM.gL(chatMessage.getCacheData().getLastMsgTime());
        cUM.a(viewGroup, chatMessage);
        cUM.b(viewGroup, chatMessage);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<MsgrightView> {
        public a(View view, MsgrightView msgrightView) {
            super(view, msgrightView);
        }
    }
}
