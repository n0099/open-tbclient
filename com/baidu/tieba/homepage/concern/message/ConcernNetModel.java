package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipReqMessage;
import d.a.c.a.f;
import d.a.c.e.p.k;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public d f16966e;

    /* renamed from: f  reason: collision with root package name */
    public c f16967f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16968g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f16969h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f16970i;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || ConcernNetModel.this.f16966e == null) {
                return;
            }
            boolean z = false;
            ConcernNetModel.this.f16968g = false;
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ConcernPageRequestMessage) {
                    z = k.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                }
            }
            if (responsedMessage.getError() != 0) {
                ConcernNetModel.this.f16966e.a(responsedMessage.getError(), responsedMessage.getErrorString());
                return;
            }
            DataRes dataRes = null;
            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
            }
            ConcernNetModel.this.f16966e.b(dataRes, z);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
            boolean isShowRedNotify;
            if (responsedMessage == null || ConcernNetModel.this.f16967f == null || responsedMessage.getError() != 0) {
                return;
            }
            if (responsedMessage instanceof CheckRedNotifyHttpResMessage) {
                CheckRedNotifyHttpResMessage checkRedNotifyHttpResMessage = (CheckRedNotifyHttpResMessage) responsedMessage;
                if (checkRedNotifyHttpResMessage != null) {
                    isShowRedNotify = checkRedNotifyHttpResMessage.isShowRedNotify();
                }
                isShowRedNotify = false;
            } else {
                if ((responsedMessage instanceof CheckRedNotifySocketResMessage) && (checkRedNotifySocketResMessage = (CheckRedNotifySocketResMessage) responsedMessage) != null) {
                    isShowRedNotify = checkRedNotifySocketResMessage.isShowRedNotify();
                }
                isShowRedNotify = false;
            }
            ConcernNetModel.this.f16967f.a(false);
            if (isShowRedNotify && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                ConcernNetModel.this.sendMessage(new ConcernUnreadTipReqMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2, String str);

        void b(DataRes dataRes, boolean z);
    }

    public ConcernNetModel(f<BaseFragmentActivity> fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f16968g = false;
        this.f16969h = new a(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
        this.f16970i = new b(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476);
        setUniqueId(bdUniqueId);
        x();
        y();
        registerListener(this.f16969h);
        registerListener(this.f16970i);
    }

    public void A(d dVar) {
        this.f16966e = dVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f16968g) {
            return true;
        }
        this.f16968g = true;
        sendMessage(new ConcernPageRequestMessage());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f16968g = false;
        cancelMessage();
        return false;
    }

    public void v(boolean z) {
        CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
        checkRedNotifyReqMessage.setTag(getUniqueId());
        checkRedNotifyReqMessage.reqUnreadTipAfterFinish = z;
        sendMessage(checkRedNotifyReqMessage);
    }

    public void w(String str, d.a.i0.z0.c cVar) {
        if (this.f16968g) {
            return;
        }
        this.f16968g = true;
        ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
        concernPageRequestMessage.setPageTag(str);
        concernPageRequestMessage.setTag(getUniqueId());
        concernPageRequestMessage.setAdInfo(cVar);
        sendMessage(concernPageRequestMessage);
    }

    public final void x() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, d.a.j0.d3.d0.a.a(TbConfig.URL_CONCERN_PAGE, 309474));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, d.a.j0.d3.d0.a.a(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, 309476));
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public final void y() {
        d.a.i0.v0.b bVar = new d.a.i0.v0.b(309474);
        bVar.setResponsedClass(ConcernPageSocketResMessage.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
        d.a.i0.v0.b bVar2 = new d.a.i0.v0.b(309476);
        bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
        bVar2.g(true);
        MessageManager.getInstance().registerTask(bVar2);
    }

    public void z(c cVar) {
        this.f16967f = cVar;
    }
}
