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
    /* renamed from: bv */
    public e.a<MsgPhotoLiveCardVew> b(ViewGroup viewGroup) {
        MsgPhotoLiveCardVew msgPhotoLiveCardVew = new MsgPhotoLiveCardVew(this.mPageContext);
        return new a(msgPhotoLiveCardVew.getConvertView(), msgPhotoLiveCardVew);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<MsgPhotoLiveCardVew> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        MsgPhotoLiveCardVew byk = aVar.byk();
        byk.a(this.mPageContext, chatMessage, viewGroup);
        byk.a(this.gzu);
        byk.setPosition(i);
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
