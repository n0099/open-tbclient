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
    private EnterForumModel fVn;
    private a.InterfaceC0489a fWi;
    private final EnterForumModel.b fVB = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.fWi != null) {
                if (aVar == null || !aVar.isOk || aVar.fWM == null || aVar.fWM.bxI() == null) {
                    d.this.fWi.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bya = aVar.fWM.bxI().bya();
                if (v.getCount(bya) > 0) {
                    Iterator<f> it = bya.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.fWi.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fWj = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.fVn.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.fVn.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.fVn.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.fVn = null;
        this.fVn = new EnterForumModel(null);
        this.fVn.a(this.fVB);
        MessageManager.getInstance().registerListener(this.fWj);
    }

    @Override // com.baidu.tieba.c.a
    public void bwg() {
        if (this.fWi != null && this.fVn != null) {
            this.fVn.kG(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.fWi = interfaceC0489a;
    }
}
