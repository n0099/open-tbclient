package com.baidu.tieba.im.live.livelist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.message.ResponseLiveGroupHistoryMessage;
import java.util.List;
/* loaded from: classes.dex */
class af extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveGroupHistoryActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(LiveGroupHistoryActivity liveGroupHistoryActivity, int i) {
        super(i);
        this.a = liveGroupHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ak akVar;
        boolean e;
        ak akVar2;
        com.baidu.tieba.im.model.r rVar;
        com.baidu.tieba.im.model.r rVar2;
        com.baidu.tieba.im.model.r rVar3;
        com.baidu.tieba.im.model.r rVar4;
        ak akVar3;
        ak akVar4;
        com.baidu.tieba.im.model.r rVar5;
        ak akVar5;
        ak akVar6;
        ak akVar7;
        ak akVar8;
        ak akVar9;
        ak akVar10;
        this.a.d();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage.getCmd() == 107005) {
            if (!(socketResponsedMessage instanceof ResponseLiveGroupHistoryMessage)) {
                this.a.showToast(com.baidu.tieba.x.neterror);
                return;
            }
            ResponseLiveGroupHistoryMessage responseLiveGroupHistoryMessage = (ResponseLiveGroupHistoryMessage) socketResponsedMessage;
            if (responseLiveGroupHistoryMessage.hasError()) {
                if (responseLiveGroupHistoryMessage.getError() > 0 && !TextUtils.isEmpty(responseLiveGroupHistoryMessage.getErrorString())) {
                    this.a.showToast(responseLiveGroupHistoryMessage.getErrorString());
                    return;
                } else {
                    this.a.showToast(com.baidu.tieba.x.neterror);
                    return;
                }
            }
            com.baidu.tieba.im.data.f liveGroupHistoryData = responseLiveGroupHistoryMessage.getLiveGroupHistoryData();
            if (liveGroupHistoryData != null) {
                LiveCardData a = liveGroupHistoryData.a();
                List<com.baidu.tieba.im.data.g> b = liveGroupHistoryData.b();
                akVar = this.a.a;
                akVar.e().a(liveGroupHistoryData.c());
                e = this.a.e();
                if (e) {
                    rVar5 = this.a.b;
                    rVar5.a(a);
                    akVar5 = this.a.a;
                    akVar5.a();
                    akVar6 = this.a.a;
                    akVar6.f().setData(a);
                    if (!liveGroupHistoryData.c()) {
                        if (b.size() == 0) {
                            akVar10 = this.a.a;
                            akVar10.b();
                            return;
                        }
                        akVar7 = this.a.a;
                        akVar7.e().b(true);
                        akVar8 = this.a.a;
                        akVar8.e().a(b);
                        akVar9 = this.a.a;
                        akVar9.c();
                        return;
                    }
                }
                akVar2 = this.a.a;
                akVar2.e().b(false);
                rVar = this.a.b;
                rVar2 = this.a.b;
                rVar.a(rVar2.b() + b.size());
                rVar3 = this.a.b;
                rVar4 = this.a.b;
                rVar3.b(rVar4.c() + 1);
                akVar3 = this.a.a;
                akVar3.e().a(b);
                akVar4 = this.a.a;
                akVar4.c();
            }
        } else {
            this.a.showToast(com.baidu.tieba.x.neterror);
        }
    }
}
