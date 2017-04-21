package com.baidu.tbadk.pay;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PayConfigModel aFC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PayConfigModel payConfigModel, int i, int i2) {
        super(i, i2);
        this.aFC = payConfigModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        a aVar;
        a aVar2;
        checkMessageIsBelongToCurPage = this.aFC.checkMessageIsBelongToCurPage(responsedMessage);
        if (checkMessageIsBelongToCurPage) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
                if (!StringUtils.isNull(errorString)) {
                    string = errorString;
                }
                aVar = this.aFC.aFA;
                if (aVar != null) {
                    aVar2 = this.aFC.aFA;
                    aVar2.onError(string);
                }
            } else if (!(responsedMessage instanceof ClientConfigHttpProtoResponse)) {
                if (!(responsedMessage instanceof ClientConfigSocketResponse)) {
                    return;
                }
                this.aFC.b(((ClientConfigSocketResponse) responsedMessage).getData());
            } else {
                this.aFC.b(((ClientConfigHttpProtoResponse) responsedMessage).getData());
            }
        }
    }
}
