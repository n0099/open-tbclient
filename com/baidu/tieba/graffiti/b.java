package com.baidu.tieba.graffiti;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ a cwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.cwa = aVar;
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
            vVar = this.cwa.cvX;
            if (vVar != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                ResponseCommitGraffitiMessage responseCommitGraffitiMessage = (ResponseCommitGraffitiMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    str7 = this.cwa.threadId;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS, str7));
                    MessageManager messageManager2 = MessageManager.getInstance();
                    str8 = this.cwa.threadId;
                    str9 = this.cwa.forumId;
                    messageManager2.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS, new r(str8, str9, null)));
                    vVar5 = this.cwa.cvX;
                    String errMsg = responseCommitGraffitiMessage.getErrMsg();
                    str10 = this.cwa.forumId;
                    str11 = this.cwa.threadId;
                    vVar5.a(errMsg, str10, str11, responseCommitGraffitiMessage.getGraffitiInfo());
                    if (responseCommitGraffitiMessage.getGraffitiInfo() != null) {
                        TiebaStatic.log(new ay("c11001").ab("obj_id", String.valueOf(responseCommitGraffitiMessage.getGraffitiInfo().getGid())).s("obj_source", 3));
                    }
                } else if (error != 224011) {
                    vVar2 = this.cwa.cvX;
                    int error2 = responseCommitGraffitiMessage.getError();
                    String errorString = responseCommitGraffitiMessage.getErrorString();
                    str = this.cwa.cvY;
                    vVar2.a(error2, errorString, null, null, null, null, 0, 0, str);
                } else {
                    com.baidu.tbadk.coreExtra.data.s vCodeData = responseCommitGraffitiMessage.getVCodeData();
                    if (vCodeData == null || !"4".equals(vCodeData.xT()) || !responseCommitGraffitiMessage.isNeedVcode()) {
                        vVar3 = this.cwa.cvX;
                        int error3 = responseCommitGraffitiMessage.getError();
                        String errorString2 = responseCommitGraffitiMessage.getErrorString();
                        str2 = this.cwa.cvY;
                        vVar3.a(error3, errorString2, null, null, null, null, 0, 0, str2);
                        return;
                    }
                    vVar4 = this.cwa.cvX;
                    int error4 = responseCommitGraffitiMessage.getError();
                    String errorString3 = responseCommitGraffitiMessage.getErrorString();
                    com.baidu.tbadk.coreExtra.data.s vCodeData2 = responseCommitGraffitiMessage.getVCodeData();
                    str3 = this.cwa.forumId;
                    str4 = this.cwa.threadId;
                    str5 = this.cwa.picId;
                    i = this.cwa.width;
                    i2 = this.cwa.height;
                    str6 = this.cwa.cvY;
                    vVar4.a(error4, errorString3, vCodeData2, str3, str4, str5, i, i2, str6);
                }
            }
        }
    }
}
