package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.c.c;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class d implements com.baidu.tieba.c.c {
    private EnterForumModel hij;
    private c.a hjh;
    private final EnterForumModel.b hiw = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.hjh != null) {
                if (aVar == null || !aVar.isOk || aVar.hlq == null || aVar.hlq.bUk() == null) {
                    d.this.hjh.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bUH = aVar.hlq.bUk().bUH();
                if (x.getCount(bUH) > 0) {
                    Iterator<f> it = bUH.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.bUG();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.hjh.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hji = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.hij.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.hij.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.hij.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.hij = null;
        this.hij = new EnterForumModel(null);
        this.hij.a(this.hiw);
        MessageManager.getInstance().registerListener(this.hji);
    }

    @Override // com.baidu.tieba.c.c
    public void bSM() {
        if (this.hjh != null && this.hij != null) {
            this.hij.mZ(true);
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hjh = aVar;
    }
}
