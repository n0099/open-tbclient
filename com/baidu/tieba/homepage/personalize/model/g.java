package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ RecPersonalizePageModel czo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(RecPersonalizePageModel recPersonalizePageModel, int i, int i2) {
        super(i, i2);
        this.czo = recPersonalizePageModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        RecPersonalizePageModel.a aVar;
        RecPersonalizePageModel.a aVar2;
        RecPersonalizePageModel.a aVar3;
        boolean z = false;
        if (responsedMessage == null) {
            return;
        }
        aVar = this.czo.czg;
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
                aVar2 = this.czo.czg;
                aVar2.b(j, dataRes, z);
            } else {
                aVar3 = this.czo.czg;
                aVar3.a(j, responsedMessage.getError(), responsedMessage.getErrorString());
            }
            if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                if (!(responsedMessage instanceof RecPersonalizeHttpResponse)) {
                    return;
                }
                this.czo.h(responsedMessage);
                return;
            }
            this.czo.g(responsedMessage);
        }
    }
}
