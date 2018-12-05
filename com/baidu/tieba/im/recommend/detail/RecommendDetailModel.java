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
import com.baidu.tieba.e;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailModel extends BdBaseModel<RecommendDetailActivity> {
    private boolean eNY;
    private a eXV;
    private boolean eXW;
    private com.baidu.adp.framework.listener.a eXX;
    private CustomMessageListener eXY;
    private TbPageContext<RecommendDetailActivity> mContext;
    private long mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void a(UserInfoBigVip userInfoBigVip, boolean z);

        void iS(boolean z);

        void iT(boolean z);

        void nH(String str);
    }

    public RecommendDetailModel(TbPageContext<RecommendDetailActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.eNY = false;
        this.eXW = false;
        this.eXX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                RecommendDetailModel.this.eXW = true;
                if (RecommendDetailModel.this.mContext != null && RecommendDetailModel.this.eXV != null) {
                    if (responsedMessage == null) {
                        RecommendDetailModel.this.eXV.nH(RecommendDetailModel.this.mContext.getString(e.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            RecommendDetailModel.this.eXV.nH(RecommendDetailModel.this.mContext.getString(e.j.neterror));
                        } else {
                            RecommendDetailModel.this.eXV.nH(responsedMessage.getErrorString());
                        }
                    } else {
                        if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                            RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                            if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.eNY = true;
                                RecommendDetailModel.this.eXV.a(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                            }
                        }
                        if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                            RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                            if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                                RecommendDetailModel.this.eNY = true;
                                RecommendDetailModel.this.eXV.a(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                            }
                        }
                    }
                }
            }
        };
        this.eXY = new CustomMessageListener(2001306) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                    RecommendDetailModel.this.aTV();
                    return;
                }
                UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
                if (RecommendDetailModel.this.eXV != null && userInfoBigVip != null) {
                    RecommendDetailModel.this.eNY = true;
                    RecommendDetailModel.this.eXV.a(userInfoBigVip, false);
                }
                RecommendDetailModel.this.aTV();
            }
        };
        this.mContext = tbPageContext;
        this.eXV = aVar;
        MessageManager.getInstance().registerListener(this.eXX);
        MessageManager.getInstance().registerListener(this.eXY);
        aQS();
    }

    public void cy(long j) {
        this.mUserId = j;
        sendMessage(new CustomMessage(2001306, Long.valueOf(this.mUserId)));
    }

    private void aQS() {
        registerListener(new c(104102) { // from class: com.baidu.tieba.im.recommend.detail.RecommendDetailModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                        if (requestUpdateMaskInfoMessage.getMaskType() == 6 && RecommendDetailModel.this.mContext != null && RecommendDetailModel.this.eXV != null) {
                            if (responseUpdateMaskInfoMessage.getError() != 0) {
                                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                                    RecommendDetailModel.this.mContext.showToast(e.j.neterror);
                                } else {
                                    RecommendDetailModel.this.mContext.showToast(responseUpdateMaskInfoMessage.getErrorString());
                                }
                                if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                    RecommendDetailModel.this.eXV.iS(false);
                                } else {
                                    RecommendDetailModel.this.eXV.iT(false);
                                }
                            } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                                RecommendDetailModel.this.eXV.iS(true);
                            } else {
                                RecommendDetailModel.this.eXV.iT(true);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTV() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId(this.mUserId);
        sendMessage(recommendDetailRequestMessage);
    }

    public void iU(boolean z) {
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

    public boolean aTW() {
        return this.eNY;
    }

    public boolean aTX() {
        return this.eXW;
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
        MessageManager.getInstance().unRegisterListener(this.eXY);
        MessageManager.getInstance().unRegisterListener(this.eXX);
    }
}
