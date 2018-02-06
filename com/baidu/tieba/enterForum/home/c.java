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
public class c implements com.baidu.tieba.d.a {
    private EnterForumModel dpF;
    private a.InterfaceC0138a dpW;
    private final EnterForumModel.b dpQ = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.c.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (c.this.dpW != null) {
                if (aVar == null || !aVar.dqn || aVar.dqo == null || aVar.dqo.aqk() == null) {
                    c.this.dpW.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> aqp = aVar.dqo.aqk().aqp();
                if (v.D(aqp) > 0) {
                    Iterator<f> it = aqp.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                c.this.dpW.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dpX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.c.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && c.this.dpF.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    c.this.dpF.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    c.this.dpF.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public c() {
        this.dpF = null;
        this.dpF = new EnterForumModel(null);
        this.dpF.a(this.dpQ);
        MessageManager.getInstance().registerListener(this.dpX);
    }

    @Override // com.baidu.tieba.d.a
    public void ane() {
        if (this.dpW != null && this.dpF != null) {
            this.dpF.fw(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0138a interfaceC0138a) {
        this.dpW = interfaceC0138a;
    }
}
