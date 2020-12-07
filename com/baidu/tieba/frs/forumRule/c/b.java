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
    private int jhH;
    private boolean jhI;
    private d jhJ;
    private a jhK;
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
            this.jhH = dataRes.audit_status.intValue();
            this.audit_opinion = dataRes.audit_opinion;
            this.jhI = dataRes.is_manager.intValue() == 1;
            this.forum_rule_id = dataRes.forum_rule_id;
            this.publish_time = dataRes.publish_time;
            this.bazhu = dataRes.bazhu;
            this.cur_time = dataRes.cur_time;
            this.jhJ = new d();
            this.jhJ.a(dataRes);
            this.jhK = new a();
            this.jhK.a(dataRes);
        }
    }

    public ForumInfo cGC() {
        return this.forum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPreface() {
        return this.preface;
    }

    public List<ForumRule> cGD() {
        return this.rules;
    }

    public int cGE() {
        return this.jhH;
    }

    public String cGF() {
        return this.audit_opinion;
    }

    public boolean cGG() {
        return this.jhI;
    }

    public String cGB() {
        return this.publish_time;
    }

    public BawuRoleInfoPub cGH() {
        return this.bazhu;
    }

    public void a(ForumInfo forumInfo) {
        this.forum = forumInfo;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public void qE(boolean z) {
        this.jhI = z;
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub) {
        this.bazhu = bawuRoleInfoPub;
    }

    public String cGI() {
        return this.cur_time;
    }

    public a cGJ() {
        return this.jhK;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }
}
