package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareSuccessReplyToServerModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public HttpMessageListener f13370e = new a(this, CmdConfigHttp.CMD_SHARE_SUCCESS_REPLY_SERVER);

    /* loaded from: classes3.dex */
    public static class ShareSuccessReplySeverResponseMessage extends JsonHttpResponsedMessage {
        public CustomDialogData mActDialogData;

        public ShareSuccessReplySeverResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            JSONObject optJSONObject;
            super.decodeLogicInBackGround(i, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error < 0 || jSONObject == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.mActDialogData = d.b.i0.d2.b.a(optJSONObject);
        }

        public CustomDialogData getActivityDialogData() {
            return this.mActDialogData;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(ShareSuccessReplyToServerModel shareSuccessReplyToServerModel, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            b bVar;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003383 || !(httpResponsedMessage instanceof ShareSuccessReplySeverResponseMessage) || httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getExtra() == null || (bVar = (b) httpResponsedMessage.getOrginalMessage().getExtra()) == null) {
                return;
            }
            ShareSuccessReplySeverResponseMessage shareSuccessReplySeverResponseMessage = (ShareSuccessReplySeverResponseMessage) httpResponsedMessage;
            if (shareSuccessReplySeverResponseMessage.getActivityDialogData() != null) {
                bVar.b(shareSuccessReplySeverResponseMessage.getActivityDialogData());
            } else {
                bVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b(CustomDialogData customDialogData);
    }

    public ShareSuccessReplyToServerModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f13370e.setTag(getUniqueId());
        this.f13370e.setSelfListener(true);
        registerListener(this.f13370e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f13370e);
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SHARE_SUCCESS_REPLY_SERVER, TbConfig.SERVER_ADDRESS + TbConfig.URL_SHARE_SUCCESS_TO_REPLY_SERVER);
        tbHttpMessageTask.setResponsedClass(ShareSuccessReplySeverResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s(String str, int i, b bVar) {
        if (str == null) {
            return;
        }
        int i2 = 0;
        if (i == 2) {
            i2 = 2;
        } else if (i == 3) {
            i2 = 1;
        } else if (i == 4) {
            i2 = 3;
        } else if (i == 6) {
            i2 = 5;
        } else if (i == 8) {
            i2 = 4;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_SUCCESS_REPLY_SERVER);
        httpMessage.addParam(PbChosenActivityConfig.KEY_SHARE_URL, str);
        httpMessage.addParam(DI.TB.SHARE_CHANNEL, i2);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }
}
