package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.homepage.personalize.c.g;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ g csn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i, int i2) {
        super(i, i2);
        this.csn = gVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        boolean z = false;
        if (responsedMessage == null) {
            return;
        }
        aVar = this.csn.csf;
        if (aVar != null) {
            long j = 0;
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RecPersonalizeRequest) {
                    RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                    j = recPersonalizeRequest.getRequestTagCode();
                    z = recPersonalizeRequest.getLoadType() == 1;
                }
            }
            if (responsedMessage.getError() == 0) {
                DataRes dataRes = null;
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                }
                aVar2 = this.csn.csf;
                aVar2.b(j, dataRes, z);
            } else {
                aVar3 = this.csn.csf;
                aVar3.a(j, responsedMessage.getError(), responsedMessage.getErrorString());
            }
            if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                if (!(responsedMessage instanceof RecPersonalizeHttpResponse)) {
                    return;
                }
                this.csn.j(responsedMessage);
                return;
            }
            this.csn.i(responsedMessage);
        }
    }
}
