package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.a.f;
import d.b.h0.r.q.i0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class CategoryGiftListModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<i0> f16540e;

    /* renamed from: f  reason: collision with root package name */
    public b f16541f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f16542g;

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
            boolean z = responsedMessage instanceof CategoryGiftListHttpResponseMessage;
            if (z || (responsedMessage instanceof CategoryGiftListSocketResponseMessage)) {
                int i = 0;
                if (z) {
                    CategoryGiftListHttpResponseMessage categoryGiftListHttpResponseMessage = (CategoryGiftListHttpResponseMessage) responsedMessage;
                    CategoryGiftListModel.this.f16540e = categoryGiftListHttpResponseMessage.getGiftList();
                    i = categoryGiftListHttpResponseMessage.getCategoryId();
                } else if (responsedMessage instanceof CategoryGiftListSocketResponseMessage) {
                    CategoryGiftListSocketResponseMessage categoryGiftListSocketResponseMessage = (CategoryGiftListSocketResponseMessage) responsedMessage;
                    CategoryGiftListModel.this.f16540e = categoryGiftListSocketResponseMessage.getGiftList();
                    i = categoryGiftListSocketResponseMessage.getCategoryId();
                }
                if (CategoryGiftListModel.this.f16541f != null) {
                    CategoryGiftListModel.this.f16541f.a(responsedMessage.getError(), responsedMessage.getErrorString(), i, CategoryGiftListModel.this.f16540e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, int i2, ArrayList<i0> arrayList);
    }

    public CategoryGiftListModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.f16542g = new a(CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, 309055);
        registerTask();
        registerListener();
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
        registerListener(this.f16542g);
    }

    public final void registerTask() {
        d.b.i0.d3.d0.a.h(309055, CategoryGiftListSocketResponseMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309055, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, TbConfig.GET_GIFT_LIST_BY_CATEGORY, CategoryGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void v(int i) {
        CategoryGiftListRequest categoryGiftListRequest = new CategoryGiftListRequest();
        categoryGiftListRequest.setCategoryId(i);
        sendMessage(categoryGiftListRequest);
    }

    public void w(b bVar) {
        this.f16541f = bVar;
    }
}
