package com.baidu.tbadk.pay;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b axm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.axm = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        a aVar;
        a aVar2;
        checkMessageIsBelongToCurPage = this.axm.checkMessageIsBelongToCurPage(responsedMessage);
        if (checkMessageIsBelongToCurPage) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.m411getInst().getString(n.i.neterror);
                if (!StringUtils.isNull(errorString)) {
                    string = errorString;
                }
                aVar = this.axm.axk;
                if (aVar != null) {
                    aVar2 = this.axm.axk;
                    aVar2.onError(string);
                }
            } else if (!(responsedMessage instanceof ClientConfigHttpProtoResponse)) {
                if (!(responsedMessage instanceof ClientConfigSocketResponse)) {
                    return;
                }
                this.axm.b(((ClientConfigSocketResponse) responsedMessage).getData());
            } else {
                this.axm.b(((ClientConfigHttpProtoResponse) responsedMessage).getData());
            }
        }
    }
}
