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
    private a.InterfaceC0139a dpK;
    private EnterForumModel dpt;
    private final EnterForumModel.b dpE = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.c.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (c.this.dpK != null) {
                if (aVar == null || !aVar.dqb || aVar.dqc == null || aVar.dqc.aqj() == null) {
                    c.this.dpK.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> aqo = aVar.dqc.aqj().aqo();
                if (v.D(aqo) > 0) {
                    Iterator<f> it = aqo.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                c.this.dpK.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dpL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && c.this.dpt.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    c.this.dpt.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    c.this.dpt.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public c() {
        this.dpt = null;
        this.dpt = new EnterForumModel(null);
        this.dpt.a(this.dpE);
        MessageManager.getInstance().registerListener(this.dpL);
    }

    @Override // com.baidu.tieba.d.a
    public void and() {
        if (this.dpK != null && this.dpt != null) {
            this.dpt.fw(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0139a interfaceC0139a) {
        this.dpK = interfaceC0139a;
    }
}
