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
    private a.InterfaceC0295a eXZ;
    private EnterForumModel eXf;
    private final EnterForumModel.b eXu = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.eXZ != null) {
                if (aVar == null || !aVar.eYD || aVar.eYE == null || aVar.eYE.bff() == null) {
                    d.this.eXZ.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bfy = aVar.eYE.bff().bfy();
                if (v.Z(bfy) > 0) {
                    Iterator<f> it = bfy.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.eXZ.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eYa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.eXf.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.eXf.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.eXf.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.eXf = null;
        this.eXf = new EnterForumModel(null);
        this.eXf.a(this.eXu);
        MessageManager.getInstance().registerListener(this.eYa);
    }

    @Override // com.baidu.tieba.c.a
    public void bbr() {
        if (this.eXZ != null && this.eXf != null) {
            this.eXf.jp(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0295a interfaceC0295a) {
        this.eXZ = interfaceC0295a;
    }
}
