package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.c.a;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d implements com.baidu.tieba.c.a {
    private EnterForumModel eCq;
    private a.InterfaceC0273a eDg;
    private final EnterForumModel.b eCF = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.eDg != null) {
                if (aVar == null || !aVar.eDH || aVar.eDI == null || aVar.eDI.aVX() == null) {
                    d.this.eDg.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<com.baidu.tieba.enterForum.data.d> aWr = aVar.eDI.aVX().aWr();
                if (v.S(aWr) > 0) {
                    Iterator<com.baidu.tieba.enterForum.data.d> it = aWr.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.enterForum.data.d next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.eDg.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eDh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.eCq.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.eCq.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.eCq.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.eCq = null;
        this.eCq = new EnterForumModel(null);
        this.eCq.a(this.eCF);
        MessageManager.getInstance().registerListener(this.eDh);
    }

    @Override // com.baidu.tieba.c.a
    public void aSg() {
        if (this.eDg != null && this.eCq != null) {
            this.eCq.iz(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0273a interfaceC0273a) {
        this.eDg = interfaceC0273a;
    }
}
