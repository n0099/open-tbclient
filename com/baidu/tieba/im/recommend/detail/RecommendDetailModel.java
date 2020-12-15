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
/* loaded from: classes26.dex */
public class RecommendDetailModel extends BdBaseModel<RecommendDetailActivity> {
    private TbPageContext<RecommendDetailActivity> eNx;
    private a kCh;
    private boolean kCi;
    private com.baidu.adp.framework.listener.a kCj;
    private CustomMessageListener kCk;
    private boolean krX;
    private long mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public interface a {
        void a(UserInfoBigVip userInfoBigVip, boolean z);

        void onFailed(String str);

        void sR(boolean z);

        void sS(boolean z);
    }

    public RecommendDetailModel(TbPageContext<RecommendDetailActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.krX = false;
        this.kCi = false;
        this.kCj = new com.baidu.adp.framework.listener.a(1001535, CmdConfigSocket.CMD_GET_RECOMMEND_DETAIL) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                RecommendDetailModel.this.kCi = true;
                if (RecommendDetailModel.this.eNx != null && RecommendDetailModel.this.kCh != null) {
                    if (responsedMessage == null) {
                        RecommendDetailModel.this.kCh.onFailed(RecommendDetailModel.this.eNx.getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            RecommendDetailModel.this.kCh.onFailed(RecommendDetailModel.this.eNx.getString(R.string.neterror));
                        } else {
                            RecommendDetailModel.this.kCh.onFailed(responsedMessage.getErrorString());
                        }
                    } else {
                        if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                            RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                            if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.krX = true;
                                RecommendDetailModel.this.kCh.a(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                            }
                        }
                        if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                            RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                            if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.krX = true;
                                RecommendDetailModel.this.kCh.a(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                            }
                        }
                    }
                }
            }
        };
        this.kCk = new CustomMessageListener(CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                    RecommendDetailModel.this.cZK();
                    return;
                }
                UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
                if (RecommendDetailModel.this.kCh != null && userInfoBigVip != null) {
                    RecommendDetailModel.this.krX = true;
                    RecommendDetailModel.this.kCh.a(userInfoBigVip, false);
                }
                RecommendDetailModel.this.cZK();
            }
        };
        this.eNx = tbPageContext;
        this.kCh = aVar;
        MessageManager.getInstance().registerListener(this.kCj);
        MessageManager.getInstance().registerListener(this.kCk);
        cWJ();
    }

    public void gY(long j) {
        this.mUserId = j;
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GET_RECOMMEND_DETAIL, Long.valueOf(this.mUserId)));
    }

    private void cWJ() {
        registerListener(new c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                        if (requestUpdateMaskInfoMessage.getMaskType() == 6 && RecommendDetailModel.this.eNx != null && RecommendDetailModel.this.kCh != null) {
                            if (responseUpdateMaskInfoMessage.getError() != 0) {
                                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                                    RecommendDetailModel.this.eNx.showToast(R.string.neterror);
                                } else {
                                    RecommendDetailModel.this.eNx.showToast(responseUpdateMaskInfoMessage.getErrorString());
                                }
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    RecommendDetailModel.this.kCh.sR(false);
                                } else {
                                    RecommendDetailModel.this.kCh.sS(false);
                                }
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                RecommendDetailModel.this.kCh.sR(true);
                            } else {
                                RecommendDetailModel.this.kCh.sS(true);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZK() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId(this.mUserId);
        sendMessage(recommendDetailRequestMessage);
    }

    public void sT(boolean z) {
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

    public boolean cZL() {
        return this.krX;
    }

    public boolean cZM() {
        return this.kCi;
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
        MessageManager.getInstance().unRegisterListener(this.kCk);
        MessageManager.getInstance().unRegisterListener(this.kCj);
    }
}
