package com.baidu.tbadk.pay;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PayConfigModel azS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PayConfigModel payConfigModel, int i, int i2) {
        super(i, i2);
        this.azS = payConfigModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        a aVar;
        a aVar2;
        checkMessageIsBelongToCurPage = this.azS.checkMessageIsBelongToCurPage(responsedMessage);
        if (checkMessageIsBelongToCurPage) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.m9getInst().getString(r.l.neterror);
                if (!StringUtils.isNull(errorString)) {
                    string = errorString;
                }
                aVar = this.azS.azQ;
                if (aVar != null) {
                    aVar2 = this.azS.azQ;
                    aVar2.onError(string);
                }
            } else if (!(responsedMessage instanceof ClientConfigHttpProtoResponse)) {
                if (!(responsedMessage instanceof ClientConfigSocketResponse)) {
                    return;
                }
                this.azS.b(((ClientConfigSocketResponse) responsedMessage).getData());
            } else {
                this.azS.b(((ClientConfigHttpProtoResponse) responsedMessage).getData());
            }
        }
    }
}
