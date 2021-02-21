package com.baidu.tieba.frs.forumRule.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes2.dex */
public class d implements n {
    public static BdUniqueId jvD = BdUniqueId.gen();
    private boolean isManager;
    private String jvE;
    private String jvF;
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
            this.jvE = dataRes.bazhu.baijiahao_info.auth_desc;
        }
        this.jvF = dataRes.publish_time;
        this.status = dataRes.audit_status.intValue();
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jvD;
    }
}
