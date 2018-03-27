package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d.a;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c implements com.baidu.tieba.d.a {
    private a.InterfaceC0139a dpN;
    private EnterForumModel dpw;
    private final EnterForumModel.b dpH = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.c.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (c.this.dpN != null) {
                if (aVar == null || !aVar.dqe || aVar.dqf == null || aVar.dqf.aqk() == null) {
                    c.this.dpN.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> aqp = aVar.dqf.aqk().aqp();
                if (v.D(aqp) > 0) {
                    Iterator<f> it = aqp.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                c.this.dpN.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dpO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && c.this.dpw.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    c.this.dpw.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    c.this.dpw.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public c() {
        this.dpw = null;
        this.dpw = new EnterForumModel(null);
        this.dpw.a(this.dpH);
        MessageManager.getInstance().registerListener(this.dpO);
    }

    @Override // com.baidu.tieba.d.a
    public void ane() {
        if (this.dpN != null && this.dpw != null) {
            this.dpw.fw(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0139a interfaceC0139a) {
        this.dpN = interfaceC0139a;
    }
}
