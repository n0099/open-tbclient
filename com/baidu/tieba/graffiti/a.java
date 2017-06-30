package com.baidu.tieba.graffiti;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ CommitGraffitiModel cAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CommitGraffitiModel commitGraffitiModel, int i) {
        super(i);
        this.cAS = commitGraffitiModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        t tVar;
        t tVar2;
        String str;
        t tVar3;
        String str2;
        t tVar4;
        String str3;
        String str4;
        String str5;
        int i;
        int i2;
        String str6;
        String str7;
        String str8;
        String str9;
        t tVar5;
        String str10;
        String str11;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003081 && (httpResponsedMessage instanceof ResponseCommitGraffitiMessage)) {
            tVar = this.cAS.cAP;
            if (tVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                ResponseCommitGraffitiMessage responseCommitGraffitiMessage = (ResponseCommitGraffitiMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    str7 = this.cAS.threadId;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS, str7));
                    MessageManager messageManager2 = MessageManager.getInstance();
                    str8 = this.cAS.threadId;
                    str9 = this.cAS.forumId;
                    messageManager2.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS, new q(str8, str9, null)));
                    tVar5 = this.cAS.cAP;
                    String errMsg = responseCommitGraffitiMessage.getErrMsg();
                    str10 = this.cAS.forumId;
                    str11 = this.cAS.threadId;
                    tVar5.a(errMsg, str10, str11, responseCommitGraffitiMessage.getGraffitiInfo());
                    if (responseCommitGraffitiMessage.getGraffitiInfo() != null) {
                        TiebaStatic.log(new au("c11001").Z("obj_id", String.valueOf(responseCommitGraffitiMessage.getGraffitiInfo().getGid())).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3));
                    }
                } else if (error != 224011) {
                    tVar2 = this.cAS.cAP;
                    int error2 = responseCommitGraffitiMessage.getError();
                    String errorString = responseCommitGraffitiMessage.getErrorString();
                    str = this.cAS.cAQ;
                    tVar2.a(error2, errorString, null, null, null, null, 0, 0, str);
                } else {
                    com.baidu.tbadk.coreExtra.data.q vCodeData = responseCommitGraffitiMessage.getVCodeData();
                    if (vCodeData == null || !"4".equals(vCodeData.ye()) || !responseCommitGraffitiMessage.isNeedVcode()) {
                        tVar3 = this.cAS.cAP;
                        int error3 = responseCommitGraffitiMessage.getError();
                        String errorString2 = responseCommitGraffitiMessage.getErrorString();
                        str2 = this.cAS.cAQ;
                        tVar3.a(error3, errorString2, null, null, null, null, 0, 0, str2);
                        return;
                    }
                    tVar4 = this.cAS.cAP;
                    int error4 = responseCommitGraffitiMessage.getError();
                    String errorString3 = responseCommitGraffitiMessage.getErrorString();
                    com.baidu.tbadk.coreExtra.data.q vCodeData2 = responseCommitGraffitiMessage.getVCodeData();
                    str3 = this.cAS.forumId;
                    str4 = this.cAS.threadId;
                    str5 = this.cAS.picId;
                    i = this.cAS.width;
                    i2 = this.cAS.height;
                    str6 = this.cAS.cAQ;
                    tVar4.a(error4, errorString3, vCodeData2, str3, str4, str5, i, i2, str6);
                }
            }
        }
    }
}
