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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes3.dex */
public class ForumDetailModel extends BdBaseModel<ForumDetailActivity> {
    private ForumDetailActivity eCj;
    private a eCk;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BarEmotionResponseMessage barEmotionResponseMessage);

        void a(ForumDetailHttpResponse forumDetailHttpResponse);

        void a(ForumDetailSocketResponse forumDetailSocketResponse);

        void hu(boolean z);

        void hv(boolean z);

        void nr(String str);
    }

    public ForumDetailModel(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eCj = forumDetailActivity;
        this.eCk = forumDetailActivity;
        aIC();
        aID();
        aIE();
        aIB();
        aIF();
        aIG();
    }

    private void aIB() {
        registerListener(new CustomMessageListener(2001266) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    ForumDetailModel.this.eCj.hy(((s) customResponsedMessage.getData()).isLike() == 1);
                }
            }
        });
    }

    private void aIC() {
        registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage == null) {
                    if (ForumDetailModel.this.eCk != null) {
                        ForumDetailModel.this.eCk.nr(null);
                    }
                } else if (responsedMessage.hasError()) {
                    if (ForumDetailModel.this.eCk != null) {
                        ForumDetailModel.this.eCk.nr(responsedMessage.getErrorString());
                    }
                } else {
                    if (responsedMessage instanceof ForumDetailHttpResponse) {
                        ForumDetailModel.this.eCk.a((ForumDetailHttpResponse) responsedMessage);
                    }
                    if (responsedMessage instanceof ForumDetailSocketResponse) {
                        ForumDetailModel.this.eCk.a((ForumDetailSocketResponse) responsedMessage);
                    }
                }
            }
        });
    }

    private void aID() {
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
                                    errorString = ForumDetailModel.this.eCj.getResources().getString(d.j.neterror);
                                } else {
                                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                                }
                                ForumDetailModel.this.eCj.showToast(errorString);
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    ForumDetailModel.this.eCk.hu(false);
                                } else {
                                    ForumDetailModel.this.eCk.hv(false);
                                }
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                ForumDetailModel.this.eCk.hu(true);
                            } else {
                                ForumDetailModel.this.eCk.hv(true);
                            }
                        }
                    }
                }
            }
        });
    }

    private void aIE() {
        registerListener(new CustomMessageListener(2001151) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001151) {
                    ForumDetailModel.this.eCj.showToast(d.j.delete_success);
                }
            }
        });
    }

    public void jw(String str) {
        ForumDetailRequestMessage forumDetailRequestMessage = new ForumDetailRequestMessage();
        forumDetailRequestMessage.setForumId(b.c(str, 0L));
        sendMessage(forumDetailRequestMessage);
    }

    public void ns(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MSG_FORUM_EMOTION_CMD);
            httpMessage.addParam("forum_id", str);
            sendMessage(httpMessage);
        }
    }

    private void aIF() {
        registerListener(new HttpMessageListener(CmdConfigHttp.MSG_FORUM_EMOTION_CMD) { // from class: com.baidu.tieba.im.forum.detail.ForumDetailModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002510 && (httpResponsedMessage instanceof BarEmotionResponseMessage)) {
                    if (httpResponsedMessage.hasError()) {
                        if (ForumDetailModel.this.eCk != null) {
                            ForumDetailModel.this.eCk.nr(httpResponsedMessage.getErrorString());
                        }
                    } else if ((httpResponsedMessage instanceof BarEmotionResponseMessage) && httpResponsedMessage.getCmd() == 1002510) {
                        ForumDetailModel.this.eCk.a((BarEmotionResponseMessage) httpResponsedMessage);
                    }
                }
            }
        });
    }

    private void aIG() {
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
