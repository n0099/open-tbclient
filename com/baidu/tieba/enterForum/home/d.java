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
    private EnterForumModel gAW;
    private a.InterfaceC0546a gBU;
    private final EnterForumModel.b gBj = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.gBU != null) {
                if (aVar == null || !aVar.isOk || aVar.gEe == null || aVar.gEe.bHy() == null) {
                    d.this.gBU.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<h> bHT = aVar.gEe.bHy().bHT();
                if (v.getCount(bHT) > 0) {
                    Iterator<h> it = bHT.iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.bHS();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.gBU.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gBV = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.gAW.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.gAW.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.gAW.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.gAW = null;
        this.gAW = new EnterForumModel(null);
        this.gAW.a(this.gBj);
        MessageManager.getInstance().registerListener(this.gBV);
    }

    @Override // com.baidu.tieba.c.a
    public void bFV() {
        if (this.gBU != null && this.gAW != null) {
            this.gAW.lO(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0546a interfaceC0546a) {
        this.gBU = interfaceC0546a;
    }
}
