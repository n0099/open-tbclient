package com.baidu.tieba.frs.forumRule.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes2.dex */
public class b implements n {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    private String audit_opinion;
    private BawuRoleInfoPub bazhu;
    private String cur_time;
    private ForumInfo forum;
    private Long forum_rule_id;
    private a jvA;
    private int jvx;
    private boolean jvy;
    private d jvz;
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
            this.jvx = dataRes.audit_status.intValue();
            this.audit_opinion = dataRes.audit_opinion;
            this.jvy = dataRes.is_manager.intValue() == 1;
            this.forum_rule_id = dataRes.forum_rule_id;
            this.publish_time = dataRes.publish_time;
            this.bazhu = dataRes.bazhu;
            this.cur_time = dataRes.cur_time;
            this.jvz = new d();
            this.jvz.a(dataRes);
            this.jvA = new a();
            this.jvA.a(dataRes);
        }
    }

    public ForumInfo cHf() {
        return this.forum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPreface() {
        return this.preface;
    }

    public List<ForumRule> cHg() {
        return this.rules;
    }

    public int cHh() {
        return this.jvx;
    }

    public String cHi() {
        return this.audit_opinion;
    }

    public boolean cHj() {
        return this.jvy;
    }

    public String cHe() {
        return this.publish_time;
    }

    public BawuRoleInfoPub cHk() {
        return this.bazhu;
    }

    public void a(ForumInfo forumInfo) {
        this.forum = forumInfo;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public void ri(boolean z) {
        this.jvy = z;
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub) {
        this.bazhu = bawuRoleInfoPub;
    }

    public String cHl() {
        return this.cur_time;
    }

    public a cHm() {
        return this.jvA;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
