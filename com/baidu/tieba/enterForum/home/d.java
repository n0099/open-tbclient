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
/* loaded from: classes7.dex */
public class d implements com.baidu.tieba.c.a {
    private EnterForumModel fSE;
    private a.InterfaceC0481a fTB;
    private final EnterForumModel.b fSS = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.fTB != null) {
                if (aVar == null || !aVar.isOk || aVar.fUf == null || aVar.fUf.bwb() == null) {
                    d.this.fTB.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bwu = aVar.fUf.bwb().bwu();
                if (v.getCount(bwu) > 0) {
                    Iterator<f> it = bwu.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.fTB.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fTC = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.fSE.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.fSE.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.fSE.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.fSE = null;
        this.fSE = new EnterForumModel(null);
        this.fSE.a(this.fSS);
        MessageManager.getInstance().registerListener(this.fTC);
    }

    @Override // com.baidu.tieba.c.a
    public void buz() {
        if (this.fTB != null && this.fSE != null) {
            this.fSE.kE(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0481a interfaceC0481a) {
        this.fTB = interfaceC0481a;
    }
}
