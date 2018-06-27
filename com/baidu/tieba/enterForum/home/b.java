package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.c.a;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.c.a {
    private EnterForumModel cPW;
    private a.InterfaceC0138a cQp;
    private final EnterForumModel.b cQj = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.cQp != null) {
                if (aVar == null || !aVar.cQQ || aVar.cQR == null || aVar.cQR.anT() == null) {
                    b.this.cQp.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> anZ = aVar.cQR.anT().anZ();
                if (w.z(anZ) > 0) {
                    Iterator<f> it = anZ.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.cQp.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a cQq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cPW.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cPW.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cPW.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.cPW = null;
        this.cPW = new EnterForumModel(null);
        this.cPW.a(this.cQj);
        MessageManager.getInstance().registerListener(this.cQq);
    }

    @Override // com.baidu.tieba.c.a
    public void ake() {
        if (this.cQp != null && this.cPW != null) {
            this.cPW.fg(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0138a interfaceC0138a) {
        this.cQp = interfaceC0138a;
    }
}
