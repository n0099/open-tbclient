package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.c.c;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d implements com.baidu.tieba.c.c {
    private EnterForumModel hcz;
    private c.a hdx;
    private final EnterForumModel.b hcM = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.hdx != null) {
                if (aVar == null || !aVar.isOk || aVar.hfG == null || aVar.hfG.bQY() == null) {
                    d.this.hdx.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bRu = aVar.hfG.bQY().bRu();
                if (w.getCount(bRu) > 0) {
                    Iterator<f> it = bRu.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.bRt();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.hdx.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hdy = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.hcz.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.hcz.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.hcz.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.hcz = null;
        this.hcz = new EnterForumModel(null);
        this.hcz.a(this.hcM);
        MessageManager.getInstance().registerListener(this.hdy);
    }

    @Override // com.baidu.tieba.c.c
    public void bPA() {
        if (this.hdx != null && this.hcz != null) {
            this.hcz.mu(true);
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hdx = aVar;
    }
}
