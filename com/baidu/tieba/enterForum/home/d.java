package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.c.c;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class d implements com.baidu.tieba.c.c {
    private EnterForumModel ijM;
    private c.a ikI;
    private final EnterForumModel.b ijZ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.ikI != null) {
                if (aVar == null || !aVar.isOk || aVar.imI == null || aVar.imI.cqQ() == null) {
                    d.this.ikI.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> crm = aVar.imI.cqQ().crm();
                if (y.getCount(crm) > 0) {
                    Iterator<f> it = crm.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.crl();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.ikI.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ikJ = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.ijM.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.ijM.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.ijM.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.ijM = null;
        this.ijM = new EnterForumModel(null);
        this.ijM.a(this.ijZ);
        MessageManager.getInstance().registerListener(this.ikJ);
    }

    @Override // com.baidu.tieba.c.c
    public void cps() {
        if (this.ikI != null && this.ijM != null) {
            this.ijM.oR(true);
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.ikI = aVar;
    }
}
