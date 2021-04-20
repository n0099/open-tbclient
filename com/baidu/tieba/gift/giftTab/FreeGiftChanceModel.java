package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.a.f;
/* loaded from: classes4.dex */
public class FreeGiftChanceModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public int f16549e;

    /* renamed from: f  reason: collision with root package name */
    public b f16550f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f16551g;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof FreeGiftChanceHttpResponseMessage;
            if (z || (responsedMessage instanceof FreeGiftChanceSocketResponseMessage)) {
                if (z) {
                    FreeGiftChanceModel.this.f16549e = ((FreeGiftChanceHttpResponseMessage) responsedMessage).getFreeChance();
                } else if (responsedMessage instanceof FreeGiftChanceSocketResponseMessage) {
                    FreeGiftChanceModel.this.f16549e = ((FreeGiftChanceSocketResponseMessage) responsedMessage).getFreeChance();
                }
                if (FreeGiftChanceModel.this.f16550f != null) {
                    FreeGiftChanceModel.this.f16550f.a(responsedMessage.getError(), responsedMessage.getErrorString(), FreeGiftChanceModel.this.f16549e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, int i2);
    }

    public FreeGiftChanceModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.f16551g = new a(CmdConfigHttp.CMD_USER_FREE_CHANCE, 309060);
        registerListener();
        registerTask();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void registerListener() {
        registerListener(this.f16551g);
    }

    public final void registerTask() {
        d.b.i0.d3.d0.a.h(309060, FreeGiftChanceSocketResponseMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309060, CmdConfigHttp.CMD_USER_FREE_CHANCE, TbConfig.GET_USER_FREE_CHANCE, FreeGiftChanceHttpResponseMessage.class, false, false, false, false);
    }

    public void v(String str) {
        FreeGiftChanceRequest freeGiftChanceRequest = new FreeGiftChanceRequest();
        freeGiftChanceRequest.setFrom(str);
        sendMessage(freeGiftChanceRequest);
    }

    public void w(b bVar) {
        this.f16550f = bVar;
    }
}
