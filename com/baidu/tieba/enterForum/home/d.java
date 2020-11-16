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
/* loaded from: classes21.dex */
public class d implements com.baidu.tieba.d.c {
    private EnterForumModel ikA;
    private c.a ilw;
    private final EnterForumModel.b ikN = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.ilw != null) {
                if (aVar == null || !aVar.isOk || aVar.inx == null || aVar.inx.cqt() == null) {
                    d.this.ilw.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> cqP = aVar.inx.cqt().cqP();
                if (y.getCount(cqP) > 0) {
                    Iterator<f> it = cqP.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar());
                            transmitForumData.tabItemDatas = next.cqO();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                d.this.ilw.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ilx = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.ikA.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.ikA.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.ikA.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.ikA = null;
        this.ikA = new EnterForumModel(null);
        this.ikA.a(this.ikN);
        MessageManager.getInstance().registerListener(this.ilx);
    }

    @Override // com.baidu.tieba.d.c
    public void coT() {
        if (this.ilw != null && this.ikA != null) {
            this.ikA.oU(true);
        }
    }

    @Override // com.baidu.tieba.d.c
    public void a(c.a aVar) {
        this.ilw = aVar;
    }
}
