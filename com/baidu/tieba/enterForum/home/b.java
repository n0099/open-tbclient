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
    private EnterForumModel dhR;
    private a.InterfaceC0195a dik;
    private final EnterForumModel.b die = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.dik != null) {
                if (aVar == null || !aVar.diK || aVar.diL == null || aVar.diL.atd() == null) {
                    b.this.dik.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> atj = aVar.diL.atd().atj();
                if (v.H(atj) > 0) {
                    Iterator<f> it = atj.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.dik.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dil = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.dhR.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.dhR.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.dhR.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.dhR = null;
        this.dhR = new EnterForumModel(null);
        this.dhR.a(this.die);
        MessageManager.getInstance().registerListener(this.dil);
    }

    @Override // com.baidu.tieba.c.a
    public void apr() {
        if (this.dik != null && this.dhR != null) {
            this.dhR.ga(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0195a interfaceC0195a) {
        this.dik = interfaceC0195a;
    }
}
