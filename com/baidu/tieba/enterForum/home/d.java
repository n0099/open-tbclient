package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.c.a;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d implements com.baidu.tieba.c.a {
    private EnterForumModel gAQ;
    private a.InterfaceC0525a gBO;
    private final EnterForumModel.b gBd = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.gBO != null) {
                if (aVar == null || !aVar.isOk || aVar.gDY == null || aVar.gDY.bHz() == null) {
                    d.this.gBO.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<h> bHU = aVar.gDY.bHz().bHU();
                if (v.getCount(bHU) > 0) {
                    Iterator<h> it = bHU.iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.bHT();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.gBO.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gBP = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.gAQ.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.gAQ.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.gAQ.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.gAQ = null;
        this.gAQ = new EnterForumModel(null);
        this.gAQ.a(this.gBd);
        MessageManager.getInstance().registerListener(this.gBP);
    }

    @Override // com.baidu.tieba.c.a
    public void bFW() {
        if (this.gBO != null && this.gAQ != null) {
            this.gAQ.lO(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0525a interfaceC0525a) {
        this.gBO = interfaceC0525a;
    }
}
