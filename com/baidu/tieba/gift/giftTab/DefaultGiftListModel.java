package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
import d.a.j0.r.q.i0;
import d.a.j0.r.q.j0;
import d.a.k0.u0.b.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class DefaultGiftListModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.k0.u0.b.a> f16113e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i0> f16114f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<e> f16115g;

    /* renamed from: h  reason: collision with root package name */
    public String f16116h;

    /* renamed from: i  reason: collision with root package name */
    public int f16117i;
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
                DefaultGiftListModel.this.f16113e = defaultGiftListHttpResponseMessage.getCategoryList();
                DefaultGiftListModel.this.f16114f = defaultGiftListHttpResponseMessage.getGiftList();
                DefaultGiftListModel.this.f16115g = defaultGiftListHttpResponseMessage.getGiftNumberList();
                DefaultGiftListModel.this.f16116h = defaultGiftListHttpResponseMessage.getAddFreeUrl();
                DefaultGiftListModel.this.f16117i = defaultGiftListHttpResponseMessage.getFreeChance();
                i3 = defaultGiftListHttpResponseMessage.currencyType;
                j0Var2 = defaultGiftListHttpResponseMessage.urlTitleData;
            } else if (!(responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                j0Var = null;
                i2 = 0;
                if (DefaultGiftListModel.this.j == null) {
                    DefaultGiftListModel.this.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), DefaultGiftListModel.this.f16117i, DefaultGiftListModel.this.f16116h, i2, j0Var, DefaultGiftListModel.this.f16113e, DefaultGiftListModel.this.f16114f, DefaultGiftListModel.this.f16115g);
                    return;
                }
                return;
            } else {
                DefaultGiftListSocketResponseMessage defaultGiftListSocketResponseMessage = (DefaultGiftListSocketResponseMessage) responsedMessage;
                DefaultGiftListModel.this.f16113e = defaultGiftListSocketResponseMessage.getCategoryList();
                DefaultGiftListModel.this.f16114f = defaultGiftListSocketResponseMessage.getGiftList();
                DefaultGiftListModel.this.f16115g = defaultGiftListSocketResponseMessage.getGiftNumberList();
                DefaultGiftListModel.this.f16116h = defaultGiftListSocketResponseMessage.getAddFreeUrl();
                DefaultGiftListModel.this.f16117i = defaultGiftListSocketResponseMessage.getFreeChance();
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
        void a(int i2, String str, int i3, String str2, int i4, j0 j0Var, ArrayList<d.a.k0.u0.b.a> arrayList, ArrayList<i0> arrayList2, ArrayList<e> arrayList3);
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
        d.a.k0.d3.d0.a.h(309054, DefaultGiftListSocketResponseMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309054, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, TbConfig.GET_DEFAULT_GIFT_LIST, DefaultGiftListHttpResponseMessage.class, false, false, false, false);
    }
}
