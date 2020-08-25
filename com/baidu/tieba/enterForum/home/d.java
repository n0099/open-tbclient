package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.c.c;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class d implements com.baidu.tieba.c.c {
    private EnterForumModel hvi;
    private c.a hwe;
    private final EnterForumModel.b hvv = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.hwe != null) {
                if (aVar == null || !aVar.isOk || aVar.hyh == null || aVar.hyh.cew() == null) {
                    d.this.hwe.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> ceS = aVar.hyh.cew().ceS();
                if (y.getCount(ceS) > 0) {
                    Iterator<f> it = ceS.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.ceR();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.hwe.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hwf = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.hvi.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.hvi.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.hvi.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.hvi = null;
        this.hvi = new EnterForumModel(null);
        this.hvi.a(this.hvv);
        MessageManager.getInstance().registerListener(this.hwf);
    }

    @Override // com.baidu.tieba.c.c
    public void ccY() {
        if (this.hwe != null && this.hvi != null) {
            this.hvi.nD(true);
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hwe = aVar;
    }
}
