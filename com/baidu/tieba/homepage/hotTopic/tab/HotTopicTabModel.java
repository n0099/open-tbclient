package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabRequest;
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.i0.z0.e.a.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f17165e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f17166f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17167g;

    /* renamed from: h  reason: collision with root package name */
    public String f17168h;
    public final HashMap<String, List<n>> i;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HotTopicTabModel.this.f17167g = false;
            if (HotTopicTabModel.this.f17165e != null && (responsedMessage instanceof d.b.i0.z0.e.a.f.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getOrginalMessage() == null) {
                    HotTopicTabModel.this.f17165e.s(-1, null);
                    return;
                }
                HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                d.b.i0.z0.e.a.f.a aVar = (d.b.i0.z0.e.a.f.a) responsedMessage;
                if (!TextUtils.isEmpty(HotTopicTabModel.this.f17168h)) {
                    HotTopicTabModel.this.i.put(HotTopicTabModel.this.f17168h, aVar.getDataList());
                }
                HotTopicTabModel.this.f17165e.s(responsedMessage.getError(), aVar);
            }
        }
    }

    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f17168h = "all";
        this.i = new HashMap<>();
        A();
    }

    public final void A() {
        this.f17166f = new a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
    }

    public void B(b bVar) {
        this.f17165e = bVar;
    }

    public void C(String str) {
        this.f17168h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.A() || this.f17167g) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.f17168h);
        hotTopicTabRequest.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        this.f17167g = sendMessage;
        return sendMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f17166f);
        this.f17167g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f17166f.setTag(bdUniqueId);
        registerListener(this.f17166f);
    }

    public List<n> x() {
        return y(this.f17168h);
    }

    public List<n> y(String str) {
        return this.i.get(str);
    }

    public String z() {
        return this.f17168h;
    }
}
