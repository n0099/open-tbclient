package com.baidu.tieba.frs.ar.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FrsArShareModel extends BdBaseModel {
    private final HttpMessageListener dNK;
    private a dNV;
    private String dNW;
    private String forumName;
    private boolean mIsLoading;
    private TbPageContext mPageContext;
    private String videoUrl;

    /* loaded from: classes3.dex */
    public interface a {
        void oi(String str);

        void oj(String str);
    }

    public FrsArShareModel(TbPageContext tbPageContext, a aVar, String str, String str2, String str3) {
        super(tbPageContext);
        this.dNK = new HttpMessageListener(CmdConfigHttp.CMD_FRS_AR_SHARE) { // from class: com.baidu.tieba.frs.ar.model.FrsArShareModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003391 || !(httpResponsedMessage instanceof FrsArShareResponseMessage)) {
                    FrsArShareModel.this.dNV.oi(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
                    return;
                }
                FrsArShareModel.this.mIsLoading = false;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    FrsArShareModel.this.dNV.oj(((FrsArShareResponseMessage) httpResponsedMessage).shareUrl);
                    return;
                }
                String errorString = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getResources().getString(e.j.error_unkown_try_again);
                }
                FrsArShareModel.this.dNV.oi(errorString);
            }
        };
        this.mPageContext = tbPageContext;
        this.dNV = aVar;
        registerTask();
        this.dNK.setTag(getUniqueId());
        this.dNK.setSelfListener(true);
        registerListener(this.dNK);
        this.forumName = str;
        this.dNW = str3;
        this.videoUrl = str2;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_AR_SHARE, TbConfig.SERVER_ADDRESS + "/ala/share/forumAR");
        tbHttpMessageTask.setResponsedClass(FrsArShareResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes3.dex */
    public static class FrsArShareResponseMessage extends JsonHttpResponsedMessage {
        public String shareUrl;

        public FrsArShareResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject(PbChosenActivityConfig.KEY_SHARE_URL)) != null && (optJSONObject2 = optJSONObject.optJSONObject("data")) != null) {
                this.shareUrl = optJSONObject2.optString(PbChosenActivityConfig.KEY_SHARE_URL);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.mIsLoading) {
            return false;
        }
        this.mIsLoading = true;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_AR_SHARE);
        httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.videoUrl);
        httpMessage.addParam("cover_url", this.dNW);
        httpMessage.addParam("forum_name", this.forumName);
        sendMessage(httpMessage);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_FRS_AR_SHARE);
        return false;
    }
}
