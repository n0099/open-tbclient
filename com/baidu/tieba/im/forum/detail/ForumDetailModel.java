package com.baidu.tieba.im.forum.detail;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes13.dex */
public class ForumDetailModel extends BdBaseModel<ForumDetailActivity> {
    private ForumDetailActivity iyJ;
    private a iyK;

    /* loaded from: classes13.dex */
    public interface a {
        void Gv(String str);

        void a(BarEmotionResponseMessage barEmotionResponseMessage);

        void a(ForumDetailHttpResponse forumDetailHttpResponse);

        void a(ForumDetailSocketResponse forumDetailSocketResponse);

        void oW(boolean z);

        void oX(boolean z);
    }

    public ForumDetailModel(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.iyJ = forumDetailActivity;
        this.iyK = forumDetailActivity;
        cmd();
        cme();
        cmf();
        cmc();
        cmg();
        cmh();
    }

    private void cmc() {
        registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    ForumDetailModel.this.iyJ.pa(((u) customResponsedMessage.getData()).isLike() == 1);
                }
            }
        });
    }

    private void cmd() {
        registerListener(new com.baidu.adp.framework.listener.a(1002509, CmdConfigSocket.CMD_FORUM_DETAIL) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage == null) {
                    if (ForumDetailModel.this.iyK != null) {
                        ForumDetailModel.this.iyK.Gv(null);
                    }
                } else if (responsedMessage.hasError()) {
                    if (ForumDetailModel.this.iyK != null) {
                        ForumDetailModel.this.iyK.Gv(responsedMessage.getErrorString());
                    }
                } else {
                    if (responsedMessage instanceof ForumDetailHttpResponse) {
                        ForumDetailModel.this.iyK.a((ForumDetailHttpResponse) responsedMessage);
                    }
                    if (responsedMessage instanceof ForumDetailSocketResponse) {
                        ForumDetailModel.this.iyK.a((ForumDetailSocketResponse) responsedMessage);
                    }
                }
            }
        });
    }

    private void cme() {
        registerListener(new c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                String errorString;
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                        if (requestUpdateMaskInfoMessage.getMaskType() == 12) {
                            if (responseUpdateMaskInfoMessage.getError() != 0) {
                                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                                    errorString = ForumDetailModel.this.iyJ.getResources().getString(R.string.neterror);
                                } else {
                                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                                }
                                ForumDetailModel.this.iyJ.showToast(errorString);
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    ForumDetailModel.this.iyK.oW(false);
                                } else {
                                    ForumDetailModel.this.iyK.oX(false);
                                }
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                ForumDetailModel.this.iyK.oW(true);
                            } else {
                                ForumDetailModel.this.iyK.oX(true);
                            }
                        }
                    }
                }
            }
        });
    }

    private void cmf() {
        registerListener(new CustomMessageListener(CmdConfigCustom.CMD_DEL_OFFICIAL_DB) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001151) {
                    ForumDetailModel.this.iyJ.showToast(R.string.delete_success);
                }
            }
        });
    }

    public void sendMessage(String str) {
        ForumDetailRequestMessage forumDetailRequestMessage = new ForumDetailRequestMessage();
        forumDetailRequestMessage.setForumId(b.toLong(str, 0L));
        sendMessage(forumDetailRequestMessage);
    }

    public void Gw(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpMessage httpMessage = new HttpMessage(1002510);
            httpMessage.addParam("forum_id", str);
            sendMessage(httpMessage);
        }
    }

    private void cmg() {
        registerListener(new HttpMessageListener(1002510) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002510 && (httpResponsedMessage instanceof BarEmotionResponseMessage)) {
                    if (httpResponsedMessage.hasError()) {
                        if (ForumDetailModel.this.iyK != null) {
                            ForumDetailModel.this.iyK.Gv(httpResponsedMessage.getErrorString());
                        }
                    } else if ((httpResponsedMessage instanceof BarEmotionResponseMessage) && httpResponsedMessage.getCmd() == 1002510) {
                        ForumDetailModel.this.iyK.a((BarEmotionResponseMessage) httpResponsedMessage);
                    }
                }
            }
        });
    }

    private void cmh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002510, TbConfig.SERVER_ADDRESS + Config.EMOTION_FORUM_DETAIL);
        tbHttpMessageTask.setResponsedClass(BarEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1002510);
        return false;
    }

    public void subscribeBar(boolean z, String str) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(12);
        requestUpdateMaskInfoMessage.setList(str);
        sendMessage(requestUpdateMaskInfoMessage);
    }
}
