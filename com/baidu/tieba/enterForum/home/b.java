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
    private EnterForumModel dgM;
    private a.InterfaceC0170a dhf;
    private final EnterForumModel.b dgZ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.dhf != null) {
                if (aVar == null || !aVar.dhF || aVar.dhG == null || aVar.dhG.atD() == null) {
                    b.this.dhf.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> atJ = aVar.dhG.atD().atJ();
                if (v.I(atJ) > 0) {
                    Iterator<f> it = atJ.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.dhf.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dhg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.dgM.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.dgM.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.dgM.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.dgM = null;
        this.dgM = new EnterForumModel(null);
        this.dgM.a(this.dgZ);
        MessageManager.getInstance().registerListener(this.dhg);
    }

    @Override // com.baidu.tieba.c.a
    public void apP() {
        if (this.dhf != null && this.dgM != null) {
            this.dgM.fQ(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0170a interfaceC0170a) {
        this.dhf = interfaceC0170a;
    }
}
