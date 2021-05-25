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
    public TbPageContext<RecommendDetailActivity> f17333e;

    /* renamed from: f  reason: collision with root package name */
    public d f17334f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17335g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17336h;

    /* renamed from: i  reason: collision with root package name */
    public long f17337i;
    public d.a.c.c.g.a j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RecommendDetailModel.this.f17336h = true;
            if (RecommendDetailModel.this.f17333e == null || RecommendDetailModel.this.f17334f == null) {
                return;
            }
            if (responsedMessage == null) {
                RecommendDetailModel.this.f17334f.onFailed(RecommendDetailModel.this.f17333e.getString(R.string.neterror));
            } else if (responsedMessage.getError() != 0) {
                if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    RecommendDetailModel.this.f17334f.onFailed(RecommendDetailModel.this.f17333e.getString(R.string.neterror));
                } else {
                    RecommendDetailModel.this.f17334f.onFailed(responsedMessage.getErrorString());
                }
            } else {
                if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                    RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                    if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                        RecommendDetailModel.this.f17335g = true;
                        RecommendDetailModel.this.f17334f.onSuccess(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                    }
                }
                if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                    RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                    if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                        RecommendDetailModel.this.f17335g = true;
                        RecommendDetailModel.this.f17334f.onSuccess(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.c {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() != 6 || RecommendDetailModel.this.f17333e == null || RecommendDetailModel.this.f17334f == null) {
                        return;
                    }
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                            RecommendDetailModel.this.f17333e.showToast(R.string.neterror);
                        } else {
                            RecommendDetailModel.this.f17333e.showToast(responseUpdateMaskInfoMessage.getErrorString());
                        }
                        if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            RecommendDetailModel.this.f17334f.onAcceptMsg(false);
                        } else {
                            RecommendDetailModel.this.f17334f.onUnAcceptMsg(false);
                        }
                    } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        RecommendDetailModel.this.f17334f.onAcceptMsg(true);
                    } else {
                        RecommendDetailModel.this.f17334f.onUnAcceptMsg(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                RecommendDetailModel.this.B();
                return;
            }
            UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
            if (RecommendDetailModel.this.f17334f != null && userInfoBigVip != null) {
                RecommendDetailModel.this.f17335g = true;
                RecommendDetailModel.this.f17334f.onSuccess(userInfoBigVip, false);
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
        this.f17335g = false;
        this.f17336h = false;
        this.j = new a(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
        this.k = new c(2001306);
        this.f17333e = tbPageContext;
        this.f17334f = dVar;
        MessageManager.getInstance().registerListener(this.j);
        MessageManager.getInstance().registerListener(this.k);
        z();
    }

    public void A(long j) {
        this.f17337i = j;
        sendMessage(new CustomMessage(2001306, Long.valueOf(j)));
    }

    public final void B() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId(this.f17337i);
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
        requestUpdateMaskInfoMessage.setG_id(this.f17337i);
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
        return this.f17335g;
    }

    public boolean y() {
        return this.f17336h;
    }

    public final void z() {
        registerListener(new b(104102));
    }
}
