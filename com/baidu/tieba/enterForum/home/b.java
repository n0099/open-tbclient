package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.c.a;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.c.a {
    private EnterForumModel drY;
    private a.InterfaceC0205a dsr;
    private final EnterForumModel.b dsl = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.dsr != null) {
                if (aVar == null || !aVar.dsM || aVar.dsN == null || aVar.dsN.awc() == null) {
                    b.this.dsr.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> awi = aVar.dsN.awc().awi();
                if (v.H(awi) > 0) {
                    Iterator<f> it = awi.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.dsr.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dss = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.drY.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.drY.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.drY.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.drY = null;
        this.drY = new EnterForumModel(null);
        this.drY.a(this.dsl);
        MessageManager.getInstance().registerListener(this.dss);
    }

    @Override // com.baidu.tieba.c.a
    public void asq() {
        if (this.dsr != null && this.drY != null) {
            this.drY.gg(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0205a interfaceC0205a) {
        this.dsr = interfaceC0205a;
    }
}
