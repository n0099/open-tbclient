package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.c.a;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0205a drI;
    private EnterForumModel drp;
    private final EnterForumModel.b drC = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.drI != null) {
                if (aVar == null || !aVar.dsd || aVar.dse == null || aVar.dse.avE() == null) {
                    b.this.drI.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> avK = aVar.dse.avE().avK();
                if (v.H(avK) > 0) {
                    Iterator<f> it = avK.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.drI.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a drJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.drp.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.drp.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.drp.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.drp = null;
        this.drp = new EnterForumModel(null);
        this.drp.a(this.drC);
        MessageManager.getInstance().registerListener(this.drJ);
    }

    @Override // com.baidu.tieba.c.a
    public void arS() {
        if (this.drI != null && this.drp != null) {
            this.drp.gd(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0205a interfaceC0205a) {
        this.drI = interfaceC0205a;
    }
}
