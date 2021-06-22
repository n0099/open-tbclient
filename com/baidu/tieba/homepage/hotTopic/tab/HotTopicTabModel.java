package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabRequest;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.o0.b1.f.a.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f16481e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f16482f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16483g;

    /* renamed from: h  reason: collision with root package name */
    public String f16484h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, List<n>> f16485i;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HotTopicTabModel.this.f16483g = false;
            if (HotTopicTabModel.this.f16481e != null && (responsedMessage instanceof d.a.o0.b1.f.a.f.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getOrginalMessage() == null) {
                    HotTopicTabModel.this.f16481e.Z(-1, null);
                    return;
                }
                HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                d.a.o0.b1.f.a.f.a aVar = (d.a.o0.b1.f.a.f.a) responsedMessage;
                if (!TextUtils.isEmpty(HotTopicTabModel.this.f16484h)) {
                    HotTopicTabModel.this.f16485i.put(HotTopicTabModel.this.f16484h, aVar.getDataList());
                }
                HotTopicTabModel.this.f16481e.Z(responsedMessage.getError(), aVar);
            }
        }
    }

    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f16484h = "all";
        this.f16485i = new HashMap<>();
        E();
    }

    public List<n> B() {
        return C(this.f16484h);
    }

    public List<n> C(String str) {
        return this.f16485i.get(str);
    }

    public String D() {
        return this.f16484h;
    }

    public final void E() {
        this.f16482f = new a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
    }

    public void F(b bVar) {
        this.f16481e = bVar;
    }

    public void G(String str) {
        this.f16484h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.A() || this.f16483g) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.f16484h);
        hotTopicTabRequest.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        this.f16483g = sendMessage;
        return sendMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f16482f);
        this.f16483g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f16482f.setTag(bdUniqueId);
        registerListener(this.f16482f);
    }
}
