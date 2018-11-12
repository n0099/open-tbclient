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
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes3.dex */
public class ForumDetailModel extends BdBaseModel<ForumDetailActivity> {
    private ForumDetailActivity eHl;
    private a eHm;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BarEmotionResponseMessage barEmotionResponseMessage);

        void a(ForumDetailHttpResponse forumDetailHttpResponse);

        void a(ForumDetailSocketResponse forumDetailSocketResponse);

        void in(boolean z);

        void io(boolean z);

        void pz(String str);
    }

    public ForumDetailModel(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eHl = forumDetailActivity;
        this.eHm = forumDetailActivity;
        aOZ();
        aPa();
        aPb();
        aOY();
        aPc();
        aPd();
    }

    private void aOY() {
        registerListener(new CustomMessageListener(2001266) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    ForumDetailModel.this.eHl.ir(((r) customResponsedMessage.getData()).isLike() == 1);
                }
            }
        });
    }

    private void aOZ() {
        registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage == null) {
                    if (ForumDetailModel.this.eHm != null) {
                        ForumDetailModel.this.eHm.pz(null);
                    }
                } else if (responsedMessage.hasError()) {
                    if (ForumDetailModel.this.eHm != null) {
                        ForumDetailModel.this.eHm.pz(responsedMessage.getErrorString());
                    }
                } else {
                    if (responsedMessage instanceof ForumDetailHttpResponse) {
                        ForumDetailModel.this.eHm.a((ForumDetailHttpResponse) responsedMessage);
                    }
                    if (responsedMessage instanceof ForumDetailSocketResponse) {
                        ForumDetailModel.this.eHm.a((ForumDetailSocketResponse) responsedMessage);
                    }
                }
            }
        });
    }

    private void aPa() {
        registerListener(new c(104102) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.3
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
                                    errorString = ForumDetailModel.this.eHl.getResources().getString(e.j.neterror);
                                } else {
                                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                                }
                                ForumDetailModel.this.eHl.showToast(errorString);
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    ForumDetailModel.this.eHm.in(false);
                                } else {
                                    ForumDetailModel.this.eHm.io(false);
                                }
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                ForumDetailModel.this.eHm.in(true);
                            } else {
                                ForumDetailModel.this.eHm.io(true);
                            }
                        }
                    }
                }
            }
        });
    }

    private void aPb() {
        registerListener(new CustomMessageListener(2001151) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001151) {
                    ForumDetailModel.this.eHl.showToast(e.j.delete_success);
                }
            }
        });
    }

    public void lp(String str) {
        ForumDetailRequestMessage forumDetailRequestMessage = new ForumDetailRequestMessage();
        forumDetailRequestMessage.setForumId(b.d(str, 0L));
        sendMessage(forumDetailRequestMessage);
    }

    public void pA(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MSG_FORUM_EMOTION_CMD);
            httpMessage.addParam("forum_id", str);
            sendMessage(httpMessage);
        }
    }

    private void aPc() {
        registerListener(new HttpMessageListener(CmdConfigHttp.MSG_FORUM_EMOTION_CMD) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002510 && (httpResponsedMessage instanceof BarEmotionResponseMessage)) {
                    if (httpResponsedMessage.hasError()) {
                        if (ForumDetailModel.this.eHm != null) {
                            ForumDetailModel.this.eHm.pz(httpResponsedMessage.getErrorString());
                        }
                    } else if ((httpResponsedMessage instanceof BarEmotionResponseMessage) && httpResponsedMessage.getCmd() == 1002510) {
                        ForumDetailModel.this.eHm.a((BarEmotionResponseMessage) httpResponsedMessage);
                    }
                }
            }
        });
    }

    private void aPd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_FORUM_EMOTION_CMD, TbConfig.SERVER_ADDRESS + "c/e/meme/checkForumPkg");
        tbHttpMessageTask.setResponsedClass(BarEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.MSG_FORUM_EMOTION_CMD);
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
