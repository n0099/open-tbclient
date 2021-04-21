package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.a.f;
import d.b.i0.r.q.i0;
import d.b.i0.r.q.j0;
import d.b.j0.u0.b.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class DefaultGiftListModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.j0.u0.b.a> f16552e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i0> f16553f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<e> f16554g;

    /* renamed from: h  reason: collision with root package name */
    public String f16555h;
    public int i;
    public b j;
    public d.b.c.c.g.a k;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // d.b.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j0 j0Var;
            int i;
            int i2;
            j0 j0Var2;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof DefaultGiftListHttpResponseMessage;
            if (!z && !(responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                return;
            }
            if (z) {
                DefaultGiftListHttpResponseMessage defaultGiftListHttpResponseMessage = (DefaultGiftListHttpResponseMessage) responsedMessage;
                DefaultGiftListModel.this.f16552e = defaultGiftListHttpResponseMessage.getCategoryList();
                DefaultGiftListModel.this.f16553f = defaultGiftListHttpResponseMessage.getGiftList();
                DefaultGiftListModel.this.f16554g = defaultGiftListHttpResponseMessage.getGiftNumberList();
                DefaultGiftListModel.this.f16555h = defaultGiftListHttpResponseMessage.getAddFreeUrl();
                DefaultGiftListModel.this.i = defaultGiftListHttpResponseMessage.getFreeChance();
                i2 = defaultGiftListHttpResponseMessage.currencyType;
                j0Var2 = defaultGiftListHttpResponseMessage.urlTitleData;
            } else if (!(responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                j0Var = null;
                i = 0;
                if (DefaultGiftListModel.this.j == null) {
                    DefaultGiftListModel.this.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), DefaultGiftListModel.this.i, DefaultGiftListModel.this.f16555h, i, j0Var, DefaultGiftListModel.this.f16552e, DefaultGiftListModel.this.f16553f, DefaultGiftListModel.this.f16554g);
                    return;
                }
                return;
            } else {
                DefaultGiftListSocketResponseMessage defaultGiftListSocketResponseMessage = (DefaultGiftListSocketResponseMessage) responsedMessage;
                DefaultGiftListModel.this.f16552e = defaultGiftListSocketResponseMessage.getCategoryList();
                DefaultGiftListModel.this.f16553f = defaultGiftListSocketResponseMessage.getGiftList();
                DefaultGiftListModel.this.f16554g = defaultGiftListSocketResponseMessage.getGiftNumberList();
                DefaultGiftListModel.this.f16555h = defaultGiftListSocketResponseMessage.getAddFreeUrl();
                DefaultGiftListModel.this.i = defaultGiftListSocketResponseMessage.getFreeChance();
                i2 = defaultGiftListSocketResponseMessage.currencyType;
                j0Var2 = defaultGiftListSocketResponseMessage.urlTitleData;
            }
            i = i2;
            j0Var = j0Var2;
            if (DefaultGiftListModel.this.j == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, int i2, String str2, int i3, j0 j0Var, ArrayList<d.b.j0.u0.b.a> arrayList, ArrayList<i0> arrayList2, ArrayList<e> arrayList3);
    }

    public DefaultGiftListModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.k = new a(CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, 309054);
        registerTask();
        registerListener();
    }

    public void D(String str, long j) {
        DefaultGiftListRequest defaultGiftListRequest = new DefaultGiftListRequest();
        defaultGiftListRequest.setFrom(str);
        defaultGiftListRequest.setToUserId(j);
        sendMessage(defaultGiftListRequest);
    }

    public void E(b bVar) {
        this.j = bVar;
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
        registerListener(this.k);
    }

    public final void registerTask() {
        d.b.j0.d3.d0.a.h(309054, DefaultGiftListSocketResponseMessage.class, false, false);
        d.b.j0.d3.d0.a.c(309054, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, TbConfig.GET_DEFAULT_GIFT_LIST, DefaultGiftListHttpResponseMessage.class, false, false, false, false);
    }
}
