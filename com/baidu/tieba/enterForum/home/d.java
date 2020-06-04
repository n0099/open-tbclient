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
    private EnterForumModel gPQ;
    private a.InterfaceC0596a gQO;
    private final EnterForumModel.b gQd = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.gQO != null) {
                if (aVar == null || !aVar.isOk || aVar.gSX == null || aVar.gSX.bNT() == null) {
                    d.this.gQO.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<h> bOo = aVar.gSX.bNT().bOo();
                if (v.getCount(bOo) > 0) {
                    Iterator<h> it = bOo.iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.bOn();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.gQO.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gQP = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.gPQ.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.gPQ.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.gPQ.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.gPQ = null;
        this.gPQ = new EnterForumModel(null);
        this.gPQ.a(this.gQd);
        MessageManager.getInstance().registerListener(this.gQP);
    }

    @Override // com.baidu.tieba.c.a
    public void bMq() {
        if (this.gQO != null && this.gPQ != null) {
            this.gPQ.mj(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0596a interfaceC0596a) {
        this.gQO = interfaceC0596a;
    }
}
