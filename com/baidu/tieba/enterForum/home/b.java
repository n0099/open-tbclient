package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.c.a;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.c.a {
    private EnterForumModel cRY;
    private a.InterfaceC0137a cSr;
    private final EnterForumModel.b cSl = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.cSr != null) {
                if (aVar == null || !aVar.cSS || aVar.cST == null || aVar.cST.aoz() == null) {
                    b.this.cSr.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> aoE = aVar.cST.aoz().aoE();
                if (w.y(aoE) > 0) {
                    Iterator<f> it = aoE.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.cSr.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a cSs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cRY.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cRY.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cRY.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.cRY = null;
        this.cRY = new EnterForumModel(null);
        this.cRY.a(this.cSl);
        MessageManager.getInstance().registerListener(this.cSs);
    }

    @Override // com.baidu.tieba.c.a
    public void akK() {
        if (this.cSr != null && this.cRY != null) {
            this.cRY.fg(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0137a interfaceC0137a) {
        this.cSr = interfaceC0137a;
    }
}
