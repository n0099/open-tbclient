package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.d.c;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class d implements com.baidu.tieba.d.c {
    private EnterForumModel ivt;
    private c.a iwq;
    private final EnterForumModel.b ivG = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.iwq != null) {
                if (aVar == null || !aVar.isOk || aVar.iyp == null || aVar.iyp.cuH() == null) {
                    d.this.iwq.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> cvd = aVar.iyp.cuH().cvd();
                if (y.getCount(cvd) > 0) {
                    Iterator<f> it = cvd.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.cvc();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.iwq.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iwr = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.ivt.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.ivt.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.ivt.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.ivt = null;
        this.ivt = new EnterForumModel(null);
        this.ivt.a(this.ivG);
        MessageManager.getInstance().registerListener(this.iwr);
    }

    @Override // com.baidu.tieba.d.c
    public void cth() {
        if (this.iwq != null && this.ivt != null) {
            this.ivt.pq(true);
        }
    }

    @Override // com.baidu.tieba.d.c
    public void a(c.a aVar) {
        this.iwq = aVar;
    }
}
