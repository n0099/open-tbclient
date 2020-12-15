package com.baidu.tieba.frs.forumRule.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes22.dex */
public class b implements q {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    private String audit_opinion;
    private BawuRoleInfoPub bazhu;
    private String cur_time;
    private ForumInfo forum;
    private Long forum_rule_id;
    private int jhJ;
    private boolean jhK;
    private d jhL;
    private a jhM;
    private String preface;
    private String publish_time;
    private List<ForumRule> rules;
    private String title;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.forum = dataRes.forum;
            this.title = dataRes.title;
            this.preface = dataRes.preface;
            this.rules = dataRes.rules;
            this.jhJ = dataRes.audit_status.intValue();
            this.audit_opinion = dataRes.audit_opinion;
            this.jhK = dataRes.is_manager.intValue() == 1;
            this.forum_rule_id = dataRes.forum_rule_id;
            this.publish_time = dataRes.publish_time;
            this.bazhu = dataRes.bazhu;
            this.cur_time = dataRes.cur_time;
            this.jhL = new d();
            this.jhL.a(dataRes);
            this.jhM = new a();
            this.jhM.a(dataRes);
        }
    }

    public ForumInfo cGD() {
        return this.forum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPreface() {
        return this.preface;
    }

    public List<ForumRule> cGE() {
        return this.rules;
    }

    public int cGF() {
        return this.jhJ;
    }

    public String cGG() {
        return this.audit_opinion;
    }

    public boolean cGH() {
        return this.jhK;
    }

    public String cGC() {
        return this.publish_time;
    }

    public BawuRoleInfoPub cGI() {
        return this.bazhu;
    }

    public void a(ForumInfo forumInfo) {
        this.forum = forumInfo;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public void qE(boolean z) {
        this.jhK = z;
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub) {
        this.bazhu = bawuRoleInfoPub;
    }

    public String cGJ() {
        return this.cur_time;
    }

    public a cGK() {
        return this.jhM;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
