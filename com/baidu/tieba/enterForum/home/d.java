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
/* loaded from: classes21.dex */
public class d implements com.baidu.tieba.c.c {
    private EnterForumModel hCt;
    private c.a hDo;
    private final EnterForumModel.b hCG = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.hDo != null) {
                if (aVar == null || !aVar.isOk || aVar.hFp == null || aVar.hFp.chM() == null) {
                    d.this.hDo.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> cii = aVar.hFp.chM().cii();
                if (y.getCount(cii) > 0) {
                    Iterator<f> it = cii.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.cih();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.hDo.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hDp = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.hCt.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.hCt.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.hCt.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.hCt = null;
        this.hCt = new EnterForumModel(null);
        this.hCt.a(this.hCG);
        MessageManager.getInstance().registerListener(this.hDp);
    }

    @Override // com.baidu.tieba.c.c
    public void cgo() {
        if (this.hDo != null && this.hCt != null) {
            this.hCt.nL(true);
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hDo = aVar;
    }
}
