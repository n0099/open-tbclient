package com.baidu.tbadk.pay;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b awl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.awl = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        a aVar;
        a aVar2;
        checkMessageIsBelongToCurPage = this.awl.checkMessageIsBelongToCurPage(responsedMessage);
        if (checkMessageIsBelongToCurPage) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.m411getInst().getString(i.C0057i.neterror);
                if (!StringUtils.isNull(errorString)) {
                    string = errorString;
                }
                aVar = this.awl.awj;
                if (aVar != null) {
                    aVar2 = this.awl.awj;
                    aVar2.onError(string);
                }
            } else if (!(responsedMessage instanceof PayConfigHttpProtoResponse)) {
                if (!(responsedMessage instanceof PayConfigSocketResponse)) {
                    return;
                }
                this.awl.a(((PayConfigSocketResponse) responsedMessage).getData());
            } else {
                this.awl.a(((PayConfigHttpProtoResponse) responsedMessage).getData());
            }
        }
    }
}
