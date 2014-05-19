package com.baidu.tieba.im.live.livelist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.live.livelist.HotLiveListAdapter;
import com.baidu.tieba.im.message.RequestHotLiveListMessage;
import com.baidu.tieba.im.message.ResponseHotLiveListMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(z zVar, int i) {
        super(i);
        this.a = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tieba.im.model.p pVar;
        com.baidu.tieba.im.model.p pVar2;
        HotLiveListAdapter hotLiveListAdapter;
        HotLiveListAdapter hotLiveListAdapter2;
        HotLiveListAdapter hotLiveListAdapter3;
        com.baidu.tieba.im.model.p pVar3;
        com.baidu.tieba.im.model.p pVar4;
        com.baidu.tieba.im.model.p pVar5;
        HotLiveListAdapter hotLiveListAdapter4;
        HotLiveListAdapter hotLiveListAdapter5;
        com.baidu.tieba.im.model.p pVar6;
        HotLiveListAdapter hotLiveListAdapter6;
        HotLiveListAdapter hotLiveListAdapter7;
        HotLiveListAdapter hotLiveListAdapter8;
        HotLiveListAdapter hotLiveListAdapter9;
        ad adVar;
        this.a.k();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseHotLiveListMessage)) {
            this.a.a(com.baidu.tieba.u.neterror);
            return;
        }
        ResponseHotLiveListMessage responseHotLiveListMessage = (ResponseHotLiveListMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseHotLiveListMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestHotLiveListMessage)) {
            int type = ((RequestHotLiveListMessage) orginalMessage).getType();
            adVar = this.a.d;
            if (!adVar.b(type).equals(this.a.b())) {
                return;
            }
        }
        String b = this.a.b();
        pVar = this.a.c;
        pVar.a(b, true);
        if (responseHotLiveListMessage.hasError()) {
            if (!TextUtils.isEmpty(responseHotLiveListMessage.getErrorString())) {
                this.a.b(responseHotLiveListMessage.getErrorString());
                return;
            } else {
                this.a.a(com.baidu.tieba.u.neterror);
                return;
            }
        }
        com.baidu.tieba.im.data.d hotLiveListData = responseHotLiveListMessage.getHotLiveListData();
        if (hotLiveListData != null && hotLiveListData.b() != null) {
            List<LiveCardData> b2 = hotLiveListData.b();
            pVar2 = this.a.c;
            if (pVar2.d()) {
                hotLiveListAdapter9 = this.a.i;
                hotLiveListAdapter9.b(true);
            }
            if (!hotLiveListData.a()) {
                pVar6 = this.a.c;
                if (!pVar6.d()) {
                    hotLiveListAdapter6 = this.a.i;
                    hotLiveListAdapter6.a(HotLiveListAdapter.BOTTOM_TYPE.NO_MORE);
                } else if (b2.size() == 0) {
                    hotLiveListAdapter8 = this.a.i;
                    hotLiveListAdapter8.c(false);
                    this.a.m();
                    return;
                } else {
                    hotLiveListAdapter7 = this.a.i;
                    hotLiveListAdapter7.a(HotLiveListAdapter.BOTTOM_TYPE.LINE);
                }
            } else {
                hotLiveListAdapter = this.a.i;
                hotLiveListAdapter.a(HotLiveListAdapter.BOTTOM_TYPE.HAVE_MORE);
            }
            this.a.l();
            hotLiveListAdapter2 = this.a.i;
            hotLiveListAdapter2.c(true);
            hotLiveListAdapter3 = this.a.i;
            hotLiveListAdapter3.a(hotLiveListData.a());
            pVar3 = this.a.c;
            pVar3.c(b2.size());
            pVar4 = this.a.c;
            pVar5 = this.a.c;
            pVar4.d(pVar5.g() + 1);
            hotLiveListAdapter4 = this.a.i;
            hotLiveListAdapter4.a(b2);
            hotLiveListAdapter5 = this.a.i;
            hotLiveListAdapter5.notifyDataSetChanged();
        }
    }
}
