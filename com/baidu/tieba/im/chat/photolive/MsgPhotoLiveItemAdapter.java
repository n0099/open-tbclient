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
    /* renamed from: ba */
    public e.a<MsgPhotoLiveCardVew> onCreateViewHolder(ViewGroup viewGroup) {
        MsgPhotoLiveCardVew msgPhotoLiveCardVew = new MsgPhotoLiveCardVew(this.mPageContext);
        return new a(msgPhotoLiveCardVew.bO(), msgPhotoLiveCardVew);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgPhotoLiveCardVew> aVar) {
        super.onFillViewHolder(i, view2, viewGroup, chatMessage, aVar);
        MsgPhotoLiveCardVew aAS = aVar.aAS();
        aAS.a(this.mPageContext, chatMessage, viewGroup);
        aAS.a(this.dRD);
        aAS.setPosition(i);
        this.mPageContext.getLayoutMode().setNightMode(false);
        this.mPageContext.getLayoutMode().u(view2);
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends e.a<MsgPhotoLiveCardVew> {
        public a(View view2, MsgPhotoLiveCardVew msgPhotoLiveCardVew) {
            super(view2, msgPhotoLiveCardVew);
        }
    }
}
