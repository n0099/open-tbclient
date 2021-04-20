package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabRequest;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.i0.a1.e.a.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f16839e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f16840f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16841g;

    /* renamed from: h  reason: collision with root package name */
    public String f16842h;
    public final HashMap<String, List<n>> i;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HotTopicTabModel.this.f16841g = false;
            if (HotTopicTabModel.this.f16839e != null && (responsedMessage instanceof d.b.i0.a1.e.a.f.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getOrginalMessage() == null) {
                    HotTopicTabModel.this.f16839e.s(-1, null);
                    return;
                }
                HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                d.b.i0.a1.e.a.f.a aVar = (d.b.i0.a1.e.a.f.a) responsedMessage;
                if (!TextUtils.isEmpty(HotTopicTabModel.this.f16842h)) {
                    HotTopicTabModel.this.i.put(HotTopicTabModel.this.f16842h, aVar.getDataList());
                }
                HotTopicTabModel.this.f16839e.s(responsedMessage.getError(), aVar);
            }
        }
    }

    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f16842h = "all";
        this.i = new HashMap<>();
        A();
    }

    public final void A() {
        this.f16840f = new a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
    }

    public void B(b bVar) {
        this.f16839e = bVar;
    }

    public void C(String str) {
        this.f16842h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.A() || this.f16841g) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.f16842h);
        hotTopicTabRequest.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        this.f16841g = sendMessage;
        return sendMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f16840f);
        this.f16841g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f16840f.setTag(bdUniqueId);
        registerListener(this.f16840f);
    }

    public List<n> x() {
        return y(this.f16842h);
    }

    public List<n> y(String str) {
        return this.i.get(str);
    }

    public String z() {
        return this.f16842h;
    }
}
