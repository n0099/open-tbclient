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
    private a.InterfaceC0205a doS;
    private EnterForumModel doz;
    private final EnterForumModel.b doM = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.doS != null) {
                if (aVar == null || !aVar.dpn || aVar.dpo == null || aVar.dpo.auP() == null) {
                    b.this.doS.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> auV = aVar.dpo.auP().auV();
                if (v.H(auV) > 0) {
                    Iterator<f> it = auV.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.doS.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a doT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.doz.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.doz.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.doz.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.doz = null;
        this.doz = new EnterForumModel(null);
        this.doz.a(this.doM);
        MessageManager.getInstance().registerListener(this.doT);
    }

    @Override // com.baidu.tieba.c.a
    public void ard() {
        if (this.doS != null && this.doz != null) {
            this.doz.gb(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0205a interfaceC0205a) {
        this.doS = interfaceC0205a;
    }
}
