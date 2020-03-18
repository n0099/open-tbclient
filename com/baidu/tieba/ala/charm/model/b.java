package com.baidu.tieba.ala.charm.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.data.h;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
/* loaded from: classes3.dex */
public class b extends BdBaseModel<ALaCharmCardActivity> {
    private NetMessageListener exA;
    private h exy;
    private a exz;

    /* loaded from: classes3.dex */
    public interface a {
        void ad(int i, String str);

        void c(h hVar);
    }

    public b(TbPageContext<ALaCharmCardActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.exA = new NetMessageListener(1021008, 602004) { // from class: com.baidu.tieba.ala.charm.model.b.1
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof OnlineListHttpResponseMessage)) {
                    int error = responsedMessage.getError();
                    h hVar = null;
                    if (responsedMessage instanceof OnlineListHttpResponseMessage) {
                        hVar = ((OnlineListHttpResponseMessage) responsedMessage).bee();
                    }
                    if (error == 0) {
                        b.this.exy = hVar;
                        if (b.this.exz != null) {
                            b.this.exz.c(b.this.exy);
                        }
                    } else if (b.this.exz != null) {
                        b.this.exz.ad(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        this.exz = aVar;
        MessageManager.getInstance().registerListener(this.exA);
        com.baidu.live.tieba.f.a.a.a(1021008, "ala/live/getAudienceInfo", OnlineListHttpResponseMessage.class, false, true, true, true);
    }

    public void s(String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021008);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void t(String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021008);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.exA);
        MessageManager.getInstance().unRegisterTask(1021008);
        cancelMessage();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
