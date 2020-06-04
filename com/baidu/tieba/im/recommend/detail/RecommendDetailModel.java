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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes13.dex */
public class RecommendDetailModel extends BdBaseModel<RecommendDetailActivity> {
    private TbPageContext<RecommendDetailActivity> dIF;
    private boolean iJA;
    private com.baidu.adp.framework.listener.a iJB;
    private CustomMessageListener iJC;
    private a iJz;
    private boolean izu;
    private long mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public interface a {
        void a(UserInfoBigVip userInfoBigVip, boolean z);

        void onFailed(String str);

        void px(boolean z);

        void py(boolean z);
    }

    public RecommendDetailModel(TbPageContext<RecommendDetailActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.izu = false;
        this.iJA = false;
        this.iJB = new com.baidu.adp.framework.listener.a(1001535, CmdConfigSocket.CMD_GET_RECOMMEND_DETAIL) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                RecommendDetailModel.this.iJA = true;
                if (RecommendDetailModel.this.dIF != null && RecommendDetailModel.this.iJz != null) {
                    if (responsedMessage == null) {
                        RecommendDetailModel.this.iJz.onFailed(RecommendDetailModel.this.dIF.getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            RecommendDetailModel.this.iJz.onFailed(RecommendDetailModel.this.dIF.getString(R.string.neterror));
                        } else {
                            RecommendDetailModel.this.iJz.onFailed(responsedMessage.getErrorString());
                        }
                    } else {
                        if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                            RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                            if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.izu = true;
                                RecommendDetailModel.this.iJz.a(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                            }
                        }
                        if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                            RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                            if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.izu = true;
                                RecommendDetailModel.this.iJz.a(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                            }
                        }
                    }
                }
            }
        };
        this.iJC = new CustomMessageListener(CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                    RecommendDetailModel.this.cpl();
                    return;
                }
                UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
                if (RecommendDetailModel.this.iJz != null && userInfoBigVip != null) {
                    RecommendDetailModel.this.izu = true;
                    RecommendDetailModel.this.iJz.a(userInfoBigVip, false);
                }
                RecommendDetailModel.this.cpl();
            }
        };
        this.dIF = tbPageContext;
        this.iJz = aVar;
        MessageManager.getInstance().registerListener(this.iJB);
        MessageManager.getInstance().registerListener(this.iJC);
        cmn();
    }

    public void eK(long j) {
        this.mUserId = j;
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL, Long.valueOf(this.mUserId)));
    }

    private void cmn() {
        registerListener(new c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                        if (requestUpdateMaskInfoMessage.getMaskType() == 6 && RecommendDetailModel.this.dIF != null && RecommendDetailModel.this.iJz != null) {
                            if (responseUpdateMaskInfoMessage.getError() != 0) {
                                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                                    RecommendDetailModel.this.dIF.showToast(R.string.neterror);
                                } else {
                                    RecommendDetailModel.this.dIF.showToast(responseUpdateMaskInfoMessage.getErrorString());
                                }
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    RecommendDetailModel.this.iJz.px(false);
                                } else {
                                    RecommendDetailModel.this.iJz.py(false);
                                }
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                RecommendDetailModel.this.iJz.px(true);
                            } else {
                                RecommendDetailModel.this.iJz.py(true);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpl() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId(this.mUserId);
        sendMessage(recommendDetailRequestMessage);
    }

    public void pz(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(6);
        requestUpdateMaskInfoMessage.setG_id(this.mUserId);
        requestUpdateMaskInfoMessage.setCallFrom(2);
        sendMessage(requestUpdateMaskInfoMessage);
    }

    public boolean cpm() {
        return this.izu;
    }

    public boolean cpn() {
        return this.iJA;
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
        MessageManager.getInstance().unRegisterListener(this.iJC);
        MessageManager.getInstance().unRegisterListener(this.iJB);
    }
}
