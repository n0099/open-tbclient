package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
/* loaded from: classes4.dex */
public class FreeGiftChanceModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public int f16084e;

    /* renamed from: f  reason: collision with root package name */
    public b f16085f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f16086g;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof FreeGiftChanceHttpResponseMessage;
            if (z || (responsedMessage instanceof FreeGiftChanceSocketResponseMessage)) {
                if (z) {
                    FreeGiftChanceModel.this.f16084e = ((FreeGiftChanceHttpResponseMessage) responsedMessage).getFreeChance();
                } else if (responsedMessage instanceof FreeGiftChanceSocketResponseMessage) {
                    FreeGiftChanceModel.this.f16084e = ((FreeGiftChanceSocketResponseMessage) responsedMessage).getFreeChance();
                }
                if (FreeGiftChanceModel.this.f16085f != null) {
                    FreeGiftChanceModel.this.f16085f.a(responsedMessage.getError(), responsedMessage.getErrorString(), FreeGiftChanceModel.this.f16084e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, int i3);
    }

    public FreeGiftChanceModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.f16086g = new a(CmdConfigHttp.CMD_USER_FREE_CHANCE, 309060);
        registerListener();
        registerTask();
    }

    public void A(b bVar) {
        this.f16085f = bVar;
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
        registerListener(this.f16086g);
    }

    public final void registerTask() {
        d.a.n0.e3.d0.a.h(309060, FreeGiftChanceSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309060, CmdConfigHttp.CMD_USER_FREE_CHANCE, TbConfig.GET_USER_FREE_CHANCE, FreeGiftChanceHttpResponseMessage.class, false, false, false, false);
    }

    public void z(String str) {
        FreeGiftChanceRequest freeGiftChanceRequest = new FreeGiftChanceRequest();
        freeGiftChanceRequest.setFrom(str);
        sendMessage(freeGiftChanceRequest);
    }
}
