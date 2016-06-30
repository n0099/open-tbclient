package com.baidu.tieba.graffiti;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.p;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ a ciC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.ciC = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        v vVar;
        v vVar2;
        String str;
        v vVar3;
        String str2;
        v vVar4;
        String str3;
        String str4;
        String str5;
        int i;
        int i2;
        String str6;
        String str7;
        String str8;
        String str9;
        v vVar5;
        String str10;
        String str11;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003081 && (httpResponsedMessage instanceof ResponseCommitGraffitiMessage)) {
            vVar = this.ciC.ciz;
            if (vVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                ResponseCommitGraffitiMessage responseCommitGraffitiMessage = (ResponseCommitGraffitiMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    str7 = this.ciC.threadId;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS, str7));
                    MessageManager messageManager2 = MessageManager.getInstance();
                    str8 = this.ciC.threadId;
                    str9 = this.ciC.forumId;
                    messageManager2.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS, new r(str8, str9, null)));
                    vVar5 = this.ciC.ciz;
                    String errMsg = responseCommitGraffitiMessage.getErrMsg();
                    str10 = this.ciC.forumId;
                    str11 = this.ciC.threadId;
                    vVar5.a(errMsg, str10, str11, responseCommitGraffitiMessage.getGraffitiInfo());
                    if (responseCommitGraffitiMessage.getGraffitiInfo() != null) {
                        TiebaStatic.log(new ay("c11001").ab("obj_id", String.valueOf(responseCommitGraffitiMessage.getGraffitiInfo().getGid())).s("obj_source", 3));
                    }
                } else if (error != 224011) {
                    vVar2 = this.ciC.ciz;
                    int error2 = responseCommitGraffitiMessage.getError();
                    String errorString = responseCommitGraffitiMessage.getErrorString();
                    str = this.ciC.ciA;
                    vVar2.a(error2, errorString, null, null, null, null, 0, 0, str);
                } else {
                    p vCodeData = responseCommitGraffitiMessage.getVCodeData();
                    if (vCodeData == null || !"4".equals(vCodeData.wJ()) || !responseCommitGraffitiMessage.isNeedVcode()) {
                        vVar3 = this.ciC.ciz;
                        int error3 = responseCommitGraffitiMessage.getError();
                        String errorString2 = responseCommitGraffitiMessage.getErrorString();
                        str2 = this.ciC.ciA;
                        vVar3.a(error3, errorString2, null, null, null, null, 0, 0, str2);
                        return;
                    }
                    vVar4 = this.ciC.ciz;
                    int error4 = responseCommitGraffitiMessage.getError();
                    String errorString3 = responseCommitGraffitiMessage.getErrorString();
                    p vCodeData2 = responseCommitGraffitiMessage.getVCodeData();
                    str3 = this.ciC.forumId;
                    str4 = this.ciC.threadId;
                    str5 = this.ciC.picId;
                    i = this.ciC.width;
                    i2 = this.ciC.height;
                    str6 = this.ciC.ciA;
                    vVar4.a(error4, errorString3, vCodeData2, str3, str4, str5, i, i2, str6);
                }
            }
        }
    }
}
