package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c bmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c cVar, int i) {
        super(i);
        this.bmb = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        TbPageContext tbPageContext;
        g gVar;
        g gVar2;
        g gVar3;
        TbPageContext tbPageContext2;
        g gVar4;
        g gVar5;
        TbPageContext tbPageContext3;
        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
            if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 6) {
                    tbPageContext = this.bmb.LN;
                    if (tbPageContext != null) {
                        gVar = this.bmb.blX;
                        if (gVar != null) {
                            if (responseUpdateMaskInfoMessage.getError() != 0) {
                                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                                    tbPageContext3 = this.bmb.LN;
                                    tbPageContext3.showToast(y.neterror);
                                } else {
                                    tbPageContext2 = this.bmb.LN;
                                    tbPageContext2.showToast(responseUpdateMaskInfoMessage.getErrorString());
                                }
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    gVar5 = this.bmb.blX;
                                    gVar5.cV(false);
                                    return;
                                }
                                gVar4 = this.bmb.blX;
                                gVar4.cW(false);
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                gVar3 = this.bmb.blX;
                                gVar3.cV(true);
                            } else {
                                gVar2 = this.bmb.blX;
                                gVar2.cW(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
