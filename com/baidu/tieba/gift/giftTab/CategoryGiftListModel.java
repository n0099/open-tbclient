package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.a.f;
import d.a.n0.r.q.i0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class CategoryGiftListModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<i0> f16156e;

    /* renamed from: f  reason: collision with root package name */
    public b f16157f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f16158g;

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
            boolean z = responsedMessage instanceof CategoryGiftListHttpResponseMessage;
            if (z || (responsedMessage instanceof CategoryGiftListSocketResponseMessage)) {
                int i2 = 0;
                if (z) {
                    CategoryGiftListHttpResponseMessage categoryGiftListHttpResponseMessage = (CategoryGiftListHttpResponseMessage) responsedMessage;
                    CategoryGiftListModel.this.f16156e = categoryGiftListHttpResponseMessage.getGiftList();
                    i2 = categoryGiftListHttpResponseMessage.getCategoryId();
                } else if (responsedMessage instanceof CategoryGiftListSocketResponseMessage) {
                    CategoryGiftListSocketResponseMessage categoryGiftListSocketResponseMessage = (CategoryGiftListSocketResponseMessage) responsedMessage;
                    CategoryGiftListModel.this.f16156e = categoryGiftListSocketResponseMessage.getGiftList();
                    i2 = categoryGiftListSocketResponseMessage.getCategoryId();
                }
                if (CategoryGiftListModel.this.f16157f != null) {
                    CategoryGiftListModel.this.f16157f.a(responsedMessage.getError(), responsedMessage.getErrorString(), i2, CategoryGiftListModel.this.f16156e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, int i3, ArrayList<i0> arrayList);
    }

    public CategoryGiftListModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.f16158g = new a(CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, 309055);
        registerTask();
        registerListener();
    }

    public void A(b bVar) {
        this.f16157f = bVar;
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
        registerListener(this.f16158g);
    }

    public final void registerTask() {
        d.a.o0.e3.d0.a.h(309055, CategoryGiftListSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309055, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, TbConfig.GET_GIFT_LIST_BY_CATEGORY, CategoryGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void z(int i2) {
        CategoryGiftListRequest categoryGiftListRequest = new CategoryGiftListRequest();
        categoryGiftListRequest.setCategoryId(i2);
        sendMessage(categoryGiftListRequest);
    }
}
