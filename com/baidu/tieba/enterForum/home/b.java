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
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0136a cYP;
    private EnterForumModel cYw;
    private final EnterForumModel.b cYJ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.cYP != null) {
                if (aVar == null || !aVar.cZq || aVar.cZr == null || aVar.cZr.aqh() == null) {
                    b.this.cYP.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> aqn = aVar.cZr.aqh().aqn();
                if (v.y(aqn) > 0) {
                    Iterator<f> it = aqn.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.cYP.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a cYQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cYw.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cYw.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cYw.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.cYw = null;
        this.cYw = new EnterForumModel(null);
        this.cYw.a(this.cYJ);
        MessageManager.getInstance().registerListener(this.cYQ);
    }

    @Override // com.baidu.tieba.c.a
    public void amq() {
        if (this.cYP != null && this.cYw != null) {
            this.cYw.fy(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0136a interfaceC0136a) {
        this.cYP = interfaceC0136a;
    }
}
