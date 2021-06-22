package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
import d.a.n0.r.q.i0;
import d.a.n0.r.q.j0;
import d.a.o0.v0.b.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class DefaultGiftListModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.o0.v0.b.a> f16160e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i0> f16161f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<e> f16162g;

    /* renamed from: h  reason: collision with root package name */
    public String f16163h;

    /* renamed from: i  reason: collision with root package name */
    public int f16164i;
    public b j;
    public d.a.c.c.g.a k;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j0 j0Var;
            int i2;
            int i3;
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
                DefaultGiftListModel.this.f16160e = defaultGiftListHttpResponseMessage.getCategoryList();
                DefaultGiftListModel.this.f16161f = defaultGiftListHttpResponseMessage.getGiftList();
                DefaultGiftListModel.this.f16162g = defaultGiftListHttpResponseMessage.getGiftNumberList();
                DefaultGiftListModel.this.f16163h = defaultGiftListHttpResponseMessage.getAddFreeUrl();
                DefaultGiftListModel.this.f16164i = defaultGiftListHttpResponseMessage.getFreeChance();
                i3 = defaultGiftListHttpResponseMessage.currencyType;
                j0Var2 = defaultGiftListHttpResponseMessage.urlTitleData;
            } else if (!(responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                j0Var = null;
                i2 = 0;
                if (DefaultGiftListModel.this.j == null) {
                    DefaultGiftListModel.this.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), DefaultGiftListModel.this.f16164i, DefaultGiftListModel.this.f16163h, i2, j0Var, DefaultGiftListModel.this.f16160e, DefaultGiftListModel.this.f16161f, DefaultGiftListModel.this.f16162g);
                    return;
                }
                return;
            } else {
                DefaultGiftListSocketResponseMessage defaultGiftListSocketResponseMessage = (DefaultGiftListSocketResponseMessage) responsedMessage;
                DefaultGiftListModel.this.f16160e = defaultGiftListSocketResponseMessage.getCategoryList();
                DefaultGiftListModel.this.f16161f = defaultGiftListSocketResponseMessage.getGiftList();
                DefaultGiftListModel.this.f16162g = defaultGiftListSocketResponseMessage.getGiftNumberList();
                DefaultGiftListModel.this.f16163h = defaultGiftListSocketResponseMessage.getAddFreeUrl();
                DefaultGiftListModel.this.f16164i = defaultGiftListSocketResponseMessage.getFreeChance();
                i3 = defaultGiftListSocketResponseMessage.currencyType;
                j0Var2 = defaultGiftListSocketResponseMessage.urlTitleData;
            }
            i2 = i3;
            j0Var = j0Var2;
            if (DefaultGiftListModel.this.j == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, int i3, String str2, int i4, j0 j0Var, ArrayList<d.a.o0.v0.b.a> arrayList, ArrayList<i0> arrayList2, ArrayList<e> arrayList3);
    }

    public DefaultGiftListModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.k = new a(CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, 309054);
        registerTask();
        registerListener();
    }

    public void H(String str, long j) {
        DefaultGiftListRequest defaultGiftListRequest = new DefaultGiftListRequest();
        defaultGiftListRequest.setFrom(str);
        defaultGiftListRequest.setToUserId(j);
        sendMessage(defaultGiftListRequest);
    }

    public void I(b bVar) {
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
        d.a.o0.e3.d0.a.h(309054, DefaultGiftListSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309054, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, TbConfig.GET_DEFAULT_GIFT_LIST, DefaultGiftListHttpResponseMessage.class, false, false, false, false);
    }
}
