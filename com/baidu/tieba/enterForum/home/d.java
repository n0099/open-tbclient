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
public class d implements com.baidu.tieba.c.a {
    private EnterForumModel eXp;
    private a.InterfaceC0295a eYn;
    private final EnterForumModel.b eXE = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.eYn != null) {
                if (aVar == null || !aVar.eYR || aVar.eYS == null || aVar.eYS.bfh() == null) {
                    d.this.eYn.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bfA = aVar.eYS.bfh().bfA();
                if (v.Z(bfA) > 0) {
                    Iterator<f> it = bfA.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.eYn.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eYo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.eXp.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.eXp.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.eXp.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.eXp = null;
        this.eXp = new EnterForumModel(null);
        this.eXp.a(this.eXE);
        MessageManager.getInstance().registerListener(this.eYo);
    }

    @Override // com.baidu.tieba.c.a
    public void bbt() {
        if (this.eYn != null && this.eXp != null) {
            this.eXp.jp(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0295a interfaceC0295a) {
        this.eYn = interfaceC0295a;
    }
}
