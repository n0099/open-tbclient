package com.baidu.tieba.im.live.livelist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.message.ResponseFrsLiveListMessage;
import java.util.List;
/* loaded from: classes.dex */
class j extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ FrsLiveListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FrsLiveListActivity frsLiveListActivity, int i) {
        super(i);
        this.a = frsLiveListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        w wVar;
        w wVar2;
        boolean f;
        com.baidu.tieba.im.model.j jVar;
        com.baidu.tieba.im.model.j jVar2;
        com.baidu.tieba.im.model.j jVar3;
        com.baidu.tieba.im.model.j jVar4;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        w wVar7;
        w wVar8;
        w wVar9;
        w wVar10;
        this.a.e();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFrsLiveListMessage)) {
            this.a.showToast(com.baidu.tieba.x.neterror);
            return;
        }
        ResponseFrsLiveListMessage responseFrsLiveListMessage = (ResponseFrsLiveListMessage) socketResponsedMessage;
        if (responseFrsLiveListMessage.hasError()) {
            if (!TextUtils.isEmpty(responseFrsLiveListMessage.getErrorString())) {
                this.a.showToast(responseFrsLiveListMessage.getErrorString());
                return;
            } else {
                this.a.showToast(com.baidu.tieba.x.neterror);
                return;
            }
        }
        com.baidu.tieba.im.data.c frsLiveListData = responseFrsLiveListMessage.getFrsLiveListData();
        if (frsLiveListData != null) {
            List<LiveCardData> b = frsLiveListData.b();
            List<LiveCardData> c = frsLiveListData.c();
            wVar = this.a.b;
            wVar.c().d(frsLiveListData.a());
            wVar2 = this.a.b;
            wVar2.c().a(false);
            f = this.a.f();
            if (f) {
                wVar6 = this.a.b;
                wVar6.c().c();
                if (!frsLiveListData.a()) {
                    wVar7 = this.a.b;
                    wVar7.c().b(true);
                    wVar8 = this.a.b;
                    wVar8.c().a(b);
                    wVar9 = this.a.b;
                    wVar9.c().b(c);
                    wVar10 = this.a.b;
                    wVar10.b();
                    return;
                }
            }
            jVar = this.a.c;
            jVar2 = this.a.c;
            jVar.a(jVar2.c() + 20);
            jVar3 = this.a.c;
            jVar4 = this.a.c;
            jVar3.b(jVar4.d() + 1);
            wVar3 = this.a.b;
            wVar3.c().b(false);
            wVar4 = this.a.b;
            wVar4.c().a(b);
            wVar5 = this.a.b;
            wVar5.b();
        }
    }
}
