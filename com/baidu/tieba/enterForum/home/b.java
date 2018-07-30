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
    private EnterForumModel cSI;
    private a.InterfaceC0136a cTb;
    private final EnterForumModel.b cSV = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.cTb != null) {
                if (aVar == null || !aVar.cTD || aVar.cTE == null || aVar.cTE.aos() == null) {
                    b.this.cTb.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> aoy = aVar.cTE.aos().aoy();
                if (w.y(aoy) > 0) {
                    Iterator<f> it = aoy.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.cTb.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a cTc = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cSI.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cSI.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cSI.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.cSI = null;
        this.cSI = new EnterForumModel(null);
        this.cSI.a(this.cSV);
        MessageManager.getInstance().registerListener(this.cTc);
    }

    @Override // com.baidu.tieba.c.a
    public void akD() {
        if (this.cTb != null && this.cSI != null) {
            this.cSI.fh(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0136a interfaceC0136a) {
        this.cTb = interfaceC0136a;
    }
}
