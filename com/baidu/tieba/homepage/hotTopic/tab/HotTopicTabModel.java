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
import d.a.c.j.e.n;
import d.a.k0.a1.e.a.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f16426e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f16427f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16428g;

    /* renamed from: h  reason: collision with root package name */
    public String f16429h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, List<n>> f16430i;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HotTopicTabModel.this.f16428g = false;
            if (HotTopicTabModel.this.f16426e != null && (responsedMessage instanceof d.a.k0.a1.e.a.f.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getOrginalMessage() == null) {
                    HotTopicTabModel.this.f16426e.X(-1, null);
                    return;
                }
                HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                d.a.k0.a1.e.a.f.a aVar = (d.a.k0.a1.e.a.f.a) responsedMessage;
                if (!TextUtils.isEmpty(HotTopicTabModel.this.f16429h)) {
                    HotTopicTabModel.this.f16430i.put(HotTopicTabModel.this.f16429h, aVar.getDataList());
                }
                HotTopicTabModel.this.f16426e.X(responsedMessage.getError(), aVar);
            }
        }
    }

    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f16429h = "all";
        this.f16430i = new HashMap<>();
        A();
    }

    public final void A() {
        this.f16427f = new a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
    }

    public void B(b bVar) {
        this.f16426e = bVar;
    }

    public void C(String str) {
        this.f16429h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.A() || this.f16428g) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.f16429h);
        hotTopicTabRequest.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        this.f16428g = sendMessage;
        return sendMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f16427f);
        this.f16428g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f16427f.setTag(bdUniqueId);
        registerListener(this.f16427f);
    }

    public List<n> x() {
        return y(this.f16429h);
    }

    public List<n> y(String str) {
        return this.f16430i.get(str);
    }

    public String z() {
        return this.f16429h;
    }
}
