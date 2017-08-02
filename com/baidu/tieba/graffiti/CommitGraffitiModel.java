package com.baidu.tieba.graffiti;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.q;
/* loaded from: classes.dex */
public class CommitGraffitiModel extends BdBaseModel {
    private h cIa;
    private String cIb;
    private final HttpMessageListener cIc;
    private String forumId;
    private int height;
    private Context mContext;
    private String picId;
    private String threadId;
    private int width;

    public CommitGraffitiModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cIc = new HttpMessageListener(CmdConfigHttp.CMD_COMMIT_GRAFFITI) { // from class: com.baidu.tieba.graffiti.CommitGraffitiModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003081 && (httpResponsedMessage instanceof ResponseCommitGraffitiMessage) && CommitGraffitiModel.this.cIa != null) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    ResponseCommitGraffitiMessage responseCommitGraffitiMessage = (ResponseCommitGraffitiMessage) httpResponsedMessage;
                    if (statusCode == 200 && error == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_COMMIT_SUCCESS, CommitGraffitiModel.this.threadId));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_VOTE_SUCCESS, new f(CommitGraffitiModel.this.threadId, CommitGraffitiModel.this.forumId, null)));
                        CommitGraffitiModel.this.cIa.a(responseCommitGraffitiMessage.getErrMsg(), CommitGraffitiModel.this.forumId, CommitGraffitiModel.this.threadId, responseCommitGraffitiMessage.getGraffitiInfo());
                        if (responseCommitGraffitiMessage.getGraffitiInfo() != null) {
                            TiebaStatic.log(new aj("c11001").aa("obj_id", String.valueOf(responseCommitGraffitiMessage.getGraffitiInfo().getGid())).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3));
                        }
                    } else if (error != 224011) {
                        CommitGraffitiModel.this.cIa.a(responseCommitGraffitiMessage.getError(), responseCommitGraffitiMessage.getErrorString(), null, null, null, null, 0, 0, CommitGraffitiModel.this.cIb);
                    } else {
                        q vCodeData = responseCommitGraffitiMessage.getVCodeData();
                        if (vCodeData == null || !"4".equals(vCodeData.yp()) || !responseCommitGraffitiMessage.isNeedVcode()) {
                            CommitGraffitiModel.this.cIa.a(responseCommitGraffitiMessage.getError(), responseCommitGraffitiMessage.getErrorString(), null, null, null, null, 0, 0, CommitGraffitiModel.this.cIb);
                        } else {
                            CommitGraffitiModel.this.cIa.a(responseCommitGraffitiMessage.getError(), responseCommitGraffitiMessage.getErrorString(), responseCommitGraffitiMessage.getVCodeData(), CommitGraffitiModel.this.forumId, CommitGraffitiModel.this.threadId, CommitGraffitiModel.this.picId, CommitGraffitiModel.this.width, CommitGraffitiModel.this.height, CommitGraffitiModel.this.cIb);
                        }
                    }
                }
            }
        };
        this.mContext = baseActivity.getActivity();
        registerListener();
    }

    private void registerListener() {
        this.cIc.setTag(getUniqueId());
        this.cIc.setSelfListener(true);
        registerListener(this.cIc);
    }

    public void a(h hVar) {
        this.cIa = hVar;
    }

    public void a(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6) {
        this.forumId = str2;
        this.threadId = str;
        this.picId = str3;
        this.width = i;
        this.height = i2;
        this.cIb = str4;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_COMMIT_GRAFFITI);
        httpMessage.addParam("tid", str);
        httpMessage.addParam("fid", str2);
        httpMessage.addParam(GraffitiVcodeActivityConfig.PIC_ID, str3);
        httpMessage.addParam("graffiti_check", str4);
        httpMessage.addParam("width", i);
        httpMessage.addParam("height", i2);
        if (!StringUtils.isNull(str5)) {
            httpMessage.addParam("vcode", str5);
        }
        if (!StringUtils.isNull(str6)) {
            httpMessage.addParam(GraffitiVcodeActivityConfig.VCODE_MD5, str6);
        }
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
