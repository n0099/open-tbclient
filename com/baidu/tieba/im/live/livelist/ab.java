package com.baidu.tieba.im.live.livelist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.live.livelist.HotLiveListAdapter;
import com.baidu.tieba.im.message.RequestHotLiveListLocalMessage;
import com.baidu.tieba.im.message.ResponseHotLiveListLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(z zVar, int i) {
        super(i);
        this.a = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.model.p pVar;
        com.baidu.tieba.im.data.d hotLiveListData;
        List<LiveCardData> b;
        com.baidu.tieba.im.model.p pVar2;
        HotLiveListAdapter hotLiveListAdapter;
        HotLiveListAdapter hotLiveListAdapter2;
        HotLiveListAdapter hotLiveListAdapter3;
        HotLiveListAdapter hotLiveListAdapter4;
        ad adVar;
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseHotLiveListLocalMessage)) {
            this.a.a(com.baidu.tieba.u.neterror);
            return;
        }
        ResponseHotLiveListLocalMessage responseHotLiveListLocalMessage = (ResponseHotLiveListLocalMessage) customResponsedMessage;
        Message<?> orginalMessage = responseHotLiveListLocalMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestHotLiveListLocalMessage)) {
            int type = ((RequestHotLiveListLocalMessage) orginalMessage).getType();
            adVar = this.a.d;
            if (!adVar.b(type).equals(this.a.b())) {
                return;
            }
        }
        pVar = this.a.c;
        if (!pVar.b(this.a.b()) && (hotLiveListData = responseHotLiveListLocalMessage.getHotLiveListData()) != null && (b = hotLiveListData.b()) != null && !b.isEmpty()) {
            pVar2 = this.a.c;
            pVar2.c(this.a.b());
            hotLiveListAdapter = this.a.i;
            hotLiveListAdapter.c(true);
            hotLiveListAdapter2 = this.a.i;
            hotLiveListAdapter2.a(HotLiveListAdapter.BOTTOM_TYPE.LINE);
            hotLiveListAdapter3 = this.a.i;
            hotLiveListAdapter3.a(b);
            hotLiveListAdapter4 = this.a.i;
            hotLiveListAdapter4.notifyDataSetChanged();
        }
        this.a.a(true);
    }
}
