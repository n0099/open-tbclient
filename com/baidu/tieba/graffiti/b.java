package com.baidu.tieba.graffiti;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.bKt = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        q qVar;
        q qVar2;
        String str;
        q qVar3;
        String str2;
        q qVar4;
        String str3;
        String str4;
        String str5;
        int i;
        int i2;
        String str6;
        String str7;
        q qVar5;
        String str8;
        String str9;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003081 && (httpResponsedMessage instanceof ResponseCommitGraffitiMessage)) {
            qVar = this.bKt.bKq;
            if (qVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                ResponseCommitGraffitiMessage responseCommitGraffitiMessage = (ResponseCommitGraffitiMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    str7 = this.bKt.threadId;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS, str7));
                    qVar5 = this.bKt.bKq;
                    String errMsg = responseCommitGraffitiMessage.getErrMsg();
                    str8 = this.bKt.forumId;
                    str9 = this.bKt.threadId;
                    qVar5.a(errMsg, str8, str9, responseCommitGraffitiMessage.getGraffitiInfo());
                    if (responseCommitGraffitiMessage.getGraffitiInfo() != null) {
                        TiebaStatic.log(new aw("c11001").ac("obj_id", String.valueOf(responseCommitGraffitiMessage.getGraffitiInfo().getGid())).r("obj_source", 3));
                    }
                } else if (error != 224011) {
                    qVar2 = this.bKt.bKq;
                    int error2 = responseCommitGraffitiMessage.getError();
                    String errorString = responseCommitGraffitiMessage.getErrorString();
                    str = this.bKt.bKr;
                    qVar2.a(error2, errorString, null, null, null, null, 0, 0, str);
                } else {
                    n vCodeData = responseCommitGraffitiMessage.getVCodeData();
                    if (vCodeData == null || !"4".equals(vCodeData.yM()) || !responseCommitGraffitiMessage.isNeedVcode()) {
                        qVar3 = this.bKt.bKq;
                        int error3 = responseCommitGraffitiMessage.getError();
                        String errorString2 = responseCommitGraffitiMessage.getErrorString();
                        str2 = this.bKt.bKr;
                        qVar3.a(error3, errorString2, null, null, null, null, 0, 0, str2);
                        return;
                    }
                    qVar4 = this.bKt.bKq;
                    int error4 = responseCommitGraffitiMessage.getError();
                    String errorString3 = responseCommitGraffitiMessage.getErrorString();
                    n vCodeData2 = responseCommitGraffitiMessage.getVCodeData();
                    str3 = this.bKt.forumId;
                    str4 = this.bKt.threadId;
                    str5 = this.bKt.picId;
                    i = this.bKt.width;
                    i2 = this.bKt.height;
                    str6 = this.bKt.bKr;
                    qVar4.a(error4, errorString3, vCodeData2, str3, str4, str5, i, i2, str6);
                }
            }
        }
    }
}
