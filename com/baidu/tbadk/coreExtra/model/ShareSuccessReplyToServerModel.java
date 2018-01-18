package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareSuccessReplyToServerModel extends BdBaseModel {
    private HttpMessageListener bhv = new HttpMessageListener(CmdConfigHttp.CMD_SHARE_SUCCESS_REPLY_SERVER) { // from class: com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003383 && (httpResponsedMessage instanceof ShareSuccessReplySeverResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getExtra() != null && (aVar = (a) httpResponsedMessage.getOrginalMessage().getExtra()) != null) {
                if (((ShareSuccessReplySeverResponseMessage) httpResponsedMessage).getActivityDialogData() != null) {
                    aVar.a(((ShareSuccessReplySeverResponseMessage) httpResponsedMessage).getActivityDialogData());
                } else {
                    aVar.He();
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void He();

        void a(CustomDialogData customDialogData);
    }

    public ShareSuccessReplyToServerModel() {
        setUniqueId(BdUniqueId.gen());
        Hd();
        this.bhv.setTag(getUniqueId());
        this.bhv.setSelfListener(true);
        registerListener(this.bhv);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void a(String str, int i, a aVar) {
        if (str != null) {
            int i2 = 0;
            switch (i) {
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 1;
                    break;
                case 4:
                    i2 = 3;
                    break;
                case 6:
                    i2 = 5;
                    break;
                case 8:
                    i2 = 4;
                    break;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_SUCCESS_REPLY_SERVER);
            httpMessage.addParam(PbChosenActivityConfig.KEY_SHARE_URL, str);
            httpMessage.addParam("share_channel", i2);
            httpMessage.setExtra(aVar);
            sendMessage(httpMessage);
        }
    }

    private void Hd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_SUCCESS_REPLY_SERVER, TbConfig.SERVER_ADDRESS + TbConfig.URL_SHARE_SUCCESS_TO_REPLY_SERVER);
        tbHttpMessageTask.setResponsedClass(ShareSuccessReplySeverResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes.dex */
    public static class ShareSuccessReplySeverResponseMessage extends JsonHttpResponsedMessage {
        private CustomDialogData mActDialogData;

        public ShareSuccessReplySeverResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            JSONObject optJSONObject;
            super.decodeLogicInBackGround(i, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error >= 0 && jSONObject != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.mActDialogData = com.baidu.tieba.pb.b.L(optJSONObject);
            }
        }

        public CustomDialogData getActivityDialogData() {
            return this.mActDialogData;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.bhv);
        return false;
    }
}
