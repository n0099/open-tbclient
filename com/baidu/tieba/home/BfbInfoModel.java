package com.baidu.tieba.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.UserBfbInfo;
/* loaded from: classes4.dex */
public class BfbInfoModel extends BdBaseModel<CreateBarGuideActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f16943e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f16944f;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BfbInfoHttpResponseMessage;
            if (z || (responsedMessage instanceof BfbInfoSocketResponseMessage)) {
                UserBfbInfo userBfbInfo = null;
                if (responsedMessage.getError() != 0) {
                    if (BfbInfoModel.this.f16943e != null) {
                        BfbInfoModel.this.f16943e.a(responsedMessage.getError(), responsedMessage.getErrorString(), null);
                        return;
                    }
                    return;
                }
                if (z) {
                    userBfbInfo = ((BfbInfoHttpResponseMessage) responsedMessage).getBfbInfo();
                } else if (responsedMessage instanceof BfbInfoSocketResponseMessage) {
                    userBfbInfo = ((BfbInfoSocketResponseMessage) responsedMessage).getBfbInfo();
                }
                if (BfbInfoModel.this.f16943e != null) {
                    BfbInfoModel.this.f16943e.a(responsedMessage.getError(), responsedMessage.getErrorString(), userBfbInfo);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, UserBfbInfo userBfbInfo);
    }

    public BfbInfoModel(CreateBarGuideActivity createBarGuideActivity) {
        super(createBarGuideActivity.getPageContext());
        this.f16944f = new a(CmdConfigHttp.CMD_GET_BFB_INFO, 309366);
        v();
        u();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new BfbInfoRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s() {
        MessageManager.getInstance().unRegisterListener(this.f16944f);
        MessageManager.getInstance().unRegisterTask(309366);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_BFB_INFO);
    }

    public final void u() {
        registerListener(this.f16944f);
    }

    public final void v() {
        d.b.i0.c3.d0.a.h(309366, BfbInfoSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309366, CmdConfigHttp.CMD_GET_BFB_INFO, TbConfig.GET_BFB_INFO, BfbInfoHttpResponseMessage.class, false, false, false, false);
    }

    public void w(b bVar) {
        this.f16943e = bVar;
    }
}
