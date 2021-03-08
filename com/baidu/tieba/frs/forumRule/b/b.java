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
    private int jxg;
    private boolean jxh;
    private d jxi;
    private a jxj;
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
            this.jxg = dataRes.audit_status.intValue();
            this.audit_opinion = dataRes.audit_opinion;
            this.jxh = dataRes.is_manager.intValue() == 1;
            this.forum_rule_id = dataRes.forum_rule_id;
            this.publish_time = dataRes.publish_time;
            this.bazhu = dataRes.bazhu;
            this.cur_time = dataRes.cur_time;
            this.jxi = new d();
            this.jxi.a(dataRes);
            this.jxj = new a();
            this.jxj.a(dataRes);
        }
    }

    public ForumInfo cHl() {
        return this.forum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPreface() {
        return this.preface;
    }

    public List<ForumRule> cHm() {
        return this.rules;
    }

    public int cHn() {
        return this.jxg;
    }

    public String cHo() {
        return this.audit_opinion;
    }

    public boolean cHp() {
        return this.jxh;
    }

    public String cHk() {
        return this.publish_time;
    }

    public BawuRoleInfoPub cHq() {
        return this.bazhu;
    }

    public void a(ForumInfo forumInfo) {
        this.forum = forumInfo;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public void ri(boolean z) {
        this.jxh = z;
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub) {
        this.bazhu = bawuRoleInfoPub;
    }

    public String cHr() {
        return this.cur_time;
    }

    public a cHs() {
        return this.jxj;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
