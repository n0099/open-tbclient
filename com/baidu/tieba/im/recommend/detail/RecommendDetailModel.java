package com.baidu.tieba.im.recommend.detail;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
import com.baidu.tieba.R;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes4.dex */
public class RecommendDetailModel extends BdBaseModel<RecommendDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<RecommendDetailActivity> f18095e;

    /* renamed from: f  reason: collision with root package name */
    public d f18096f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18097g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18098h;
    public long i;
    public d.b.b.c.g.a j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RecommendDetailModel.this.f18098h = true;
            if (RecommendDetailModel.this.f18095e == null || RecommendDetailModel.this.f18096f == null) {
                return;
            }
            if (responsedMessage == null) {
                RecommendDetailModel.this.f18096f.onFailed(RecommendDetailModel.this.f18095e.getString(R.string.neterror));
            } else if (responsedMessage.getError() != 0) {
                if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    RecommendDetailModel.this.f18096f.onFailed(RecommendDetailModel.this.f18095e.getString(R.string.neterror));
                } else {
                    RecommendDetailModel.this.f18096f.onFailed(responsedMessage.getErrorString());
                }
            } else {
                if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                    RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                    if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                        RecommendDetailModel.this.f18097g = true;
                        RecommendDetailModel.this.f18096f.onSuccess(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                    }
                }
                if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                    RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                    if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                        RecommendDetailModel.this.f18097g = true;
                        RecommendDetailModel.this.f18096f.onSuccess(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.b.c.g.c {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() != 6 || RecommendDetailModel.this.f18095e == null || RecommendDetailModel.this.f18096f == null) {
                        return;
                    }
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                            RecommendDetailModel.this.f18095e.showToast(R.string.neterror);
                        } else {
                            RecommendDetailModel.this.f18095e.showToast(responseUpdateMaskInfoMessage.getErrorString());
                        }
                        if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            RecommendDetailModel.this.f18096f.onAcceptMsg(false);
                        } else {
                            RecommendDetailModel.this.f18096f.onUnAcceptMsg(false);
                        }
                    } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        RecommendDetailModel.this.f18096f.onAcceptMsg(true);
                    } else {
                        RecommendDetailModel.this.f18096f.onUnAcceptMsg(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                RecommendDetailModel.this.B();
                return;
            }
            UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
            if (RecommendDetailModel.this.f18096f != null && userInfoBigVip != null) {
                RecommendDetailModel.this.f18097g = true;
                RecommendDetailModel.this.f18096f.onSuccess(userInfoBigVip, false);
            }
            RecommendDetailModel.this.B();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onAcceptMsg(boolean z);

        void onFailed(String str);

        void onSuccess(UserInfoBigVip userInfoBigVip, boolean z);

        void onUnAcceptMsg(boolean z);
    }

    public RecommendDetailModel(TbPageContext<RecommendDetailActivity> tbPageContext, d dVar) {
        super(tbPageContext);
        this.f18097g = false;
        this.f18098h = false;
        this.j = new a(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
        this.k = new c(2001306);
        this.f18095e = tbPageContext;
        this.f18096f = dVar;
        MessageManager.getInstance().registerListener(this.j);
        MessageManager.getInstance().registerListener(this.k);
        z();
    }

    public void A(long j) {
        this.i = j;
        sendMessage(new CustomMessage(2001306, Long.valueOf(j)));
    }

    public final void B() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId(this.i);
        sendMessage(recommendDetailRequestMessage);
    }

    public void C(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(6);
        requestUpdateMaskInfoMessage.setG_id(this.i);
        requestUpdateMaskInfoMessage.setCallFrom(2);
        sendMessage(requestUpdateMaskInfoMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public boolean x() {
        return this.f18097g;
    }

    public boolean y() {
        return this.f18098h;
    }

    public final void z() {
        registerListener(new b(104102));
    }
}
