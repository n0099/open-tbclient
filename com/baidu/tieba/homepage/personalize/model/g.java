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
    final /* synthetic */ RecPersonalizePageModel cCX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(RecPersonalizePageModel recPersonalizePageModel, int i, int i2) {
        super(i, i2);
        this.cCX = recPersonalizePageModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    @Override // com.baidu.adp.framework.listener.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        RecPersonalizePageModel.a aVar;
        boolean z;
        RecPersonalizePageModel.a aVar2;
        RecPersonalizePageModel.a aVar3;
        boolean z2 = false;
        if (responsedMessage != null) {
            aVar = this.cCX.cCW;
            if (aVar != null) {
                if (responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof RecPersonalizeRequest) {
                        RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                        z = recPersonalizeRequest.getLoadType() == 1;
                        z2 = recPersonalizeRequest.getNeedForumlist() == 1;
                        if (responsedMessage.getError() == 0) {
                            aVar3 = this.cCX.cCW;
                            aVar3.s(responsedMessage.getError(), responsedMessage.getErrorString());
                        } else {
                            DataRes dataRes = null;
                            if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                                dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                                dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                            }
                            aVar2 = this.cCX.cCW;
                            aVar2.b(dataRes, z, z2);
                        }
                        if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                            if (!(responsedMessage instanceof RecPersonalizeHttpResponse)) {
                                return;
                            }
                            this.cCX.g(responsedMessage);
                            return;
                        }
                        this.cCX.f(responsedMessage);
                        return;
                    }
                }
                z = false;
                if (responsedMessage.getError() == 0) {
                }
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                }
            }
        }
    }
}
