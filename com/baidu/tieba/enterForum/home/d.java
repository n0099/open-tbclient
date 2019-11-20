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
/* loaded from: classes4.dex */
public class d implements com.baidu.tieba.c.a {
    private EnterForumModel faP;
    private a.InterfaceC0393a fbN;
    private final EnterForumModel.b fbe = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.fbN != null) {
                if (aVar == null || !aVar.fcr || aVar.fcs == null || aVar.fcs.bdD() == null) {
                    d.this.fbN.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bdW = aVar.fcs.bdD().bdW();
                if (v.getCount(bdW) > 0) {
                    Iterator<f> it = bdW.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.fbN.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fbO = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.faP.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.faP.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.faP.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.faP = null;
        this.faP = new EnterForumModel(null);
        this.faP.a(this.fbe);
        MessageManager.getInstance().registerListener(this.fbO);
    }

    @Override // com.baidu.tieba.c.a
    public void bca() {
        if (this.fbN != null && this.faP != null) {
            this.faP.jh(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0393a interfaceC0393a) {
        this.fbN = interfaceC0393a;
    }
}
