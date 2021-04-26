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
import d.a.j0.a1.e.a.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f17111e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f17112f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17113g;

    /* renamed from: h  reason: collision with root package name */
    public String f17114h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, List<n>> f17115i;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HotTopicTabModel.this.f17113g = false;
            if (HotTopicTabModel.this.f17111e != null && (responsedMessage instanceof d.a.j0.a1.e.a.f.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getOrginalMessage() == null) {
                    HotTopicTabModel.this.f17111e.X(-1, null);
                    return;
                }
                HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                d.a.j0.a1.e.a.f.a aVar = (d.a.j0.a1.e.a.f.a) responsedMessage;
                if (!TextUtils.isEmpty(HotTopicTabModel.this.f17114h)) {
                    HotTopicTabModel.this.f17115i.put(HotTopicTabModel.this.f17114h, aVar.getDataList());
                }
                HotTopicTabModel.this.f17111e.X(responsedMessage.getError(), aVar);
            }
        }
    }

    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f17114h = "all";
        this.f17115i = new HashMap<>();
        A();
    }

    public final void A() {
        this.f17112f = new a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
    }

    public void B(b bVar) {
        this.f17111e = bVar;
    }

    public void C(String str) {
        this.f17114h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.A() || this.f17113g) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.f17114h);
        hotTopicTabRequest.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        this.f17113g = sendMessage;
        return sendMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f17112f);
        this.f17113g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f17112f.setTag(bdUniqueId);
        registerListener(this.f17112f);
    }

    public List<n> x() {
        return y(this.f17114h);
    }

    public List<n> y(String str) {
        return this.f17115i.get(str);
    }

    public String z() {
        return this.f17114h;
    }
}
