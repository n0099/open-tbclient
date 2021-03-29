package com.baidu.tieba.im.forum.detail;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.b.i0.c3.w;
/* loaded from: classes3.dex */
public class ForumDetailModel extends BdBaseModel<ForumDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public ForumDetailActivity f17949e;

    /* renamed from: f  reason: collision with root package name */
    public f f17950f;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w)) {
                return;
            }
            ForumDetailModel.this.f17949e.updateLikeAndMsgStatus(((w) customResponsedMessage.getData()).l() == 1);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.b.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                if (ForumDetailModel.this.f17950f != null) {
                    ForumDetailModel.this.f17950f.onNetError(null);
                }
            } else if (responsedMessage.hasError()) {
                if (ForumDetailModel.this.f17950f != null) {
                    ForumDetailModel.this.f17950f.onNetError(responsedMessage.getErrorString());
                }
            } else {
                if (responsedMessage instanceof ForumDetailHttpResponse) {
                    ForumDetailModel.this.f17950f.onHttpResponsedMessage((ForumDetailHttpResponse) responsedMessage);
                }
                if (responsedMessage instanceof ForumDetailSocketResponse) {
                    ForumDetailModel.this.f17950f.onSocketResponsedMessage((ForumDetailSocketResponse) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.b.c.g.c {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() != 12) {
                        return;
                    }
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                            errorString = ForumDetailModel.this.f17949e.getResources().getString(R.string.neterror);
                        } else {
                            errorString = responseUpdateMaskInfoMessage.getErrorString();
                        }
                        ForumDetailModel.this.f17949e.showToast(errorString);
                        if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            ForumDetailModel.this.f17950f.onSubscrib(false);
                        } else {
                            ForumDetailModel.this.f17950f.onUnSubscrib(false);
                        }
                    } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        ForumDetailModel.this.f17950f.onSubscrib(true);
                    } else {
                        ForumDetailModel.this.f17950f.onUnSubscrib(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001151) {
                return;
            }
            ForumDetailModel.this.f17949e.showToast(R.string.delete_success);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends HttpMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002510 && ((z = httpResponsedMessage instanceof BarEmotionResponseMessage))) {
                if (httpResponsedMessage.hasError()) {
                    if (ForumDetailModel.this.f17950f != null) {
                        ForumDetailModel.this.f17950f.onNetError(httpResponsedMessage.getErrorString());
                    }
                } else if (z && httpResponsedMessage.getCmd() == 1002510) {
                    ForumDetailModel.this.f17950f.onHttpEmotionResponseMessage((BarEmotionResponseMessage) httpResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onHttpEmotionResponseMessage(BarEmotionResponseMessage barEmotionResponseMessage);

        void onHttpResponsedMessage(ForumDetailHttpResponse forumDetailHttpResponse);

        void onNetError(String str);

        void onSocketResponsedMessage(ForumDetailSocketResponse forumDetailSocketResponse);

        void onSubscrib(boolean z);

        void onUnSubscrib(boolean z);
    }

    public ForumDetailModel(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.f17949e = forumDetailActivity;
        this.f17950f = forumDetailActivity;
        x();
        y();
        u();
        z();
        v();
        w();
    }

    public void A(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MSG_FORUM_EMOTION_CMD);
        httpMessage.addParam("forum_id", str);
        sendMessage(httpMessage);
    }

    public void B(String str) {
        ForumDetailRequestMessage forumDetailRequestMessage = new ForumDetailRequestMessage();
        forumDetailRequestMessage.setForumId(d.b.b.e.m.b.f(str, 0L));
        sendMessage(forumDetailRequestMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
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

    public final void u() {
        registerListener(new d(2001151));
    }

    public final void v() {
        registerListener(new e(CmdConfigHttp.MSG_FORUM_EMOTION_CMD));
    }

    public final void w() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_FORUM_EMOTION_CMD, TbConfig.SERVER_ADDRESS + "c/e/meme/checkForumPkg");
        tbHttpMessageTask.setResponsedClass(BarEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void x() {
        registerListener(new b(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021));
    }

    public final void y() {
        registerListener(new c(104102));
    }

    public final void z() {
        registerListener(new a(2001266));
    }
}
