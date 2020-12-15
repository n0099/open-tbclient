package com.baidu.tieba.frs.forumRule.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes22.dex */
public class d implements q {
    public static BdUniqueId jhP = BdUniqueId.gen();
    private boolean isManager;
    private String jhQ;
    private String jhR;
    private int level;
    private String portrait;
    private int status;
    private String userName;

    public void a(DataRes dataRes) {
        this.userName = dataRes.bazhu.name_show;
        this.portrait = dataRes.bazhu.portrait;
        this.isManager = dataRes.is_manager.intValue() == 1;
        this.level = dataRes.bazhu.user_level.intValue();
        if (dataRes.bazhu.baijiahao_info != null) {
            this.jhQ = dataRes.bazhu.baijiahao_info.auth_desc;
        }
        this.jhR = dataRes.publish_time;
        this.status = dataRes.audit_status.intValue();
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jhP;
    }
}
