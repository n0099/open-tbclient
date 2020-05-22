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
    private EnterForumModel gPF;
    private a.InterfaceC0596a gQD;
    private final EnterForumModel.b gPS = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.gQD != null) {
                if (aVar == null || !aVar.isOk || aVar.gSM == null || aVar.gSM.bNR() == null) {
                    d.this.gQD.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<h> bOm = aVar.gSM.bNR().bOm();
                if (v.getCount(bOm) > 0) {
                    Iterator<h> it = bOm.iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.bOl();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.gQD.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gQE = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.gPF.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.gPF.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.gPF.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.gPF = null;
        this.gPF = new EnterForumModel(null);
        this.gPF.a(this.gPS);
        MessageManager.getInstance().registerListener(this.gQE);
    }

    @Override // com.baidu.tieba.c.a
    public void bMo() {
        if (this.gQD != null && this.gPF != null) {
            this.gPF.mj(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0596a interfaceC0596a) {
        this.gQD = interfaceC0596a;
    }
}
