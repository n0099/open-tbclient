package com.baidu.tieba.im.chat.photolive;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes3.dex */
public class MsgPhotoLiveItemAdapter extends e<MsgPhotoLiveCardVew> {
    public MsgPhotoLiveItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public e.a<MsgPhotoLiveCardVew> onCreateViewHolder(ViewGroup viewGroup) {
        MsgPhotoLiveCardVew msgPhotoLiveCardVew = new MsgPhotoLiveCardVew(this.mPageContext);
        return new a(msgPhotoLiveCardVew.eR(), msgPhotoLiveCardVew);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgPhotoLiveCardVew> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgPhotoLiveCardVew bxP = aVar.bxP();
        bxP.a(this.mPageContext, chatMessage, viewGroup);
        bxP.a(this.gsy);
        bxP.setPosition(i);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends e.a<MsgPhotoLiveCardVew> {
        public a(View view, MsgPhotoLiveCardVew msgPhotoLiveCardVew) {
            super(view, msgPhotoLiveCardVew);
        }
    }
}
