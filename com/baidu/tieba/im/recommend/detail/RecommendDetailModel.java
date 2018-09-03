package com.baidu.tieba.im.recommend.detail;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.f;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailModel extends BdBaseModel<RecommendDetailActivity> {
    private a eAN;
    private boolean eAO;
    private com.baidu.adp.framework.listener.a eAP;
    private CustomMessageListener eAQ;
    private boolean eqK;
    private TbPageContext<RecommendDetailActivity> mContext;
    private long mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void a(UserInfoBigVip userInfoBigVip, boolean z);

        void hQ(boolean z);

        void hR(boolean z);

        void md(String str);
    }

    public RecommendDetailModel(TbPageContext<RecommendDetailActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.eqK = false;
        this.eAO = false;
        this.eAP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                RecommendDetailModel.this.eAO = true;
                if (RecommendDetailModel.this.mContext != null && RecommendDetailModel.this.eAN != null) {
                    if (responsedMessage == null) {
                        RecommendDetailModel.this.eAN.md(RecommendDetailModel.this.mContext.getString(f.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            RecommendDetailModel.this.eAN.md(RecommendDetailModel.this.mContext.getString(f.j.neterror));
                        } else {
                            RecommendDetailModel.this.eAN.md(responsedMessage.getErrorString());
                        }
                    } else {
                        if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                            RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                            if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.eqK = true;
                                RecommendDetailModel.this.eAN.a(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                            }
                        }
                        if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                            RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                            if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.eqK = true;
                                RecommendDetailModel.this.eAN.a(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                            }
                        }
                    }
                }
            }
        };
        this.eAQ = new CustomMessageListener(2001306) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                    RecommendDetailModel.this.aNd();
                    return;
                }
                UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
                if (RecommendDetailModel.this.eAN != null && userInfoBigVip != null) {
                    RecommendDetailModel.this.eqK = true;
                    RecommendDetailModel.this.eAN.a(userInfoBigVip, false);
                }
                RecommendDetailModel.this.aNd();
            }
        };
        this.mContext = tbPageContext;
        this.eAN = aVar;
        MessageManager.getInstance().registerListener(this.eAP);
        MessageManager.getInstance().registerListener(this.eAQ);
        aJZ();
    }

    public void cl(long j) {
        this.mUserId = j;
        sendMessage(new CustomMessage(2001306, Long.valueOf(this.mUserId)));
    }

    private void aJZ() {
        registerListener(new c(104102) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                        if (requestUpdateMaskInfoMessage.getMaskType() == 6 && RecommendDetailModel.this.mContext != null && RecommendDetailModel.this.eAN != null) {
                            if (responseUpdateMaskInfoMessage.getError() != 0) {
                                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                                    RecommendDetailModel.this.mContext.showToast(f.j.neterror);
                                } else {
                                    RecommendDetailModel.this.mContext.showToast(responseUpdateMaskInfoMessage.getErrorString());
                                }
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    RecommendDetailModel.this.eAN.hQ(false);
                                } else {
                                    RecommendDetailModel.this.eAN.hR(false);
                                }
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                RecommendDetailModel.this.eAN.hQ(true);
                            } else {
                                RecommendDetailModel.this.eAN.hR(true);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNd() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId(this.mUserId);
        sendMessage(recommendDetailRequestMessage);
    }

    public void hS(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(6);
        requestUpdateMaskInfoMessage.setG_id(this.mUserId);
        sendMessage(requestUpdateMaskInfoMessage);
    }

    public boolean aNe() {
        return this.eqK;
    }

    public boolean aNf() {
        return this.eAO;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eAQ);
        MessageManager.getInstance().unRegisterListener(this.eAP);
    }
}
