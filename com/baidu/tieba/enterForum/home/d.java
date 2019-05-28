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
public class d implements com.baidu.tieba.c.a {
    private a.InterfaceC0292a eSY;
    private EnterForumModel eSf;
    private final EnterForumModel.b eSu = new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.d.1
        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
        public void a(EnterForumModel.a aVar) {
            if (d.this.eSY != null) {
                if (aVar == null || !aVar.eTC || aVar.eTD == null || aVar.eTD.bdd() == null) {
                    d.this.eSY.a(null, false, 1, 0);
                    return;
                }
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<f> bdw = aVar.eTD.bdd().bdw();
                if (v.Z(bdw) > 0) {
                    Iterator<f> it = bdw.iterator();
                    while (it.hasNext()) {
                        f next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.getName())) {
                            arrayList.add(new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.getName(), false, 1, next.getAvatar()));
                        }
                    }
                }
                d.this.eSY.a(arrayList, true, 1, 0);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eSZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.d.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.eSf.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    d.this.eSf.a((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.eSf.a((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public d() {
        this.eSf = null;
        this.eSf = new EnterForumModel(null);
        this.eSf.a(this.eSu);
        MessageManager.getInstance().registerListener(this.eSZ);
    }

    @Override // com.baidu.tieba.c.a
    public void aZs() {
        if (this.eSY != null && this.eSf != null) {
            this.eSf.jf(true);
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0292a interfaceC0292a) {
        this.eSY = interfaceC0292a;
    }
}
