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
    private EnterForumModel fUY;
    private a.InterfaceC0489a fVT;
    private final EnterForumModel.b fVm = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.fVT != null) {
                if (aVar == null || !aVar.isOk || aVar.fWx == null || aVar.fWx.bxF() == null) {
                    d.this.fVT.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bxX = aVar.fWx.bxF().bxX();
                if (v.getCount(bxX) > 0) {
                    Iterator<f> it = bxX.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.fVT.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fVU = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.fUY.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.fUY.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.fUY.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.fUY = null;
        this.fUY = new EnterForumModel(null);
        this.fUY.a(this.fVm);
        MessageManager.getInstance().registerListener(this.fVU);
    }

    @Override // com.baidu.tieba.c.a
    public void bwd() {
        if (this.fVT != null && this.fUY != null) {
            this.fUY.kG(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.fVT = interfaceC0489a;
    }
}
