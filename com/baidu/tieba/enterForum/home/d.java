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
    private EnterForumModel ivv;
    private c.a iws;
    private final EnterForumModel.b ivI = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.iws != null) {
                if (aVar == null || !aVar.isOk || aVar.iyr == null || aVar.iyr.cuI() == null) {
                    d.this.iws.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> cve = aVar.iyr.cuI().cve();
                if (y.getCount(cve) > 0) {
                    Iterator<f> it = cve.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.cvd();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.iws.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iwt = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.ivv.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.ivv.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.ivv.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.ivv = null;
        this.ivv = new EnterForumModel(null);
        this.ivv.a(this.ivI);
        MessageManager.getInstance().registerListener(this.iwt);
    }

    @Override // com.baidu.tieba.d.c
    public void cti() {
        if (this.iws != null && this.ivv != null) {
            this.ivv.pq(true);
        }
    }

    @Override // com.baidu.tieba.d.c
    public void a(c.a aVar) {
        this.iws = aVar;
    }
}
