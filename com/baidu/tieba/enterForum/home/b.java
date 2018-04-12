package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d.a;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.d.a {
    private EnterForumModel cHM;
    private a.InterfaceC0124a cIf;
    private final EnterForumModel.b cHZ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (b.this.cIf != null) {
                if (aVar == null || !aVar.cIG || aVar.cIH == null || aVar.cIH.akt() == null) {
                    b.this.cIf.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> aky = aVar.cIH.akt().aky();
                if (v.v(aky) > 0) {
                    Iterator<f> it = aky.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                b.this.cIf.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a cIg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && b.this.cHM.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    b.this.cHM.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    b.this.cHM.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public b() {
        this.cHM = null;
        this.cHM = new EnterForumModel(null);
        this.cHM.a(this.cHZ);
        MessageManager.getInstance().registerListener(this.cIg);
    }

    @Override // com.baidu.tieba.d.a
    public void ahc() {
        if (this.cIf != null && this.cHM != null) {
            this.cHM.fb(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0124a interfaceC0124a) {
        this.cIf = interfaceC0124a;
    }
}
