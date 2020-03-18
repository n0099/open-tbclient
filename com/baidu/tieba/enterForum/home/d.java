package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.c.a;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d implements com.baidu.tieba.c.a {
    private EnterForumModel fVW;
    private a.InterfaceC0489a fWQ;
    private final EnterForumModel.b fWj = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.fWQ != null) {
                if (aVar == null || !aVar.isOk || aVar.fXu == null || aVar.fXu.bxN() == null) {
                    d.this.fWQ.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> byg = aVar.fXu.bxN().byg();
                if (v.getCount(byg) > 0) {
                    Iterator<f> it = byg.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.byf();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.fWQ.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fWR = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.fVW.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.fVW.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.fVW.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.fVW = null;
        this.fVW = new EnterForumModel(null);
        this.fVW.a(this.fWj);
        MessageManager.getInstance().registerListener(this.fWR);
    }

    @Override // com.baidu.tieba.c.a
    public void bwl() {
        if (this.fWQ != null && this.fVW != null) {
            this.fVW.kL(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.fWQ = interfaceC0489a;
    }
}
