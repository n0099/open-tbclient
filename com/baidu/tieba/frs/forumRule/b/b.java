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
    private int juj;
    private boolean juk;
    private d jul;
    private a jum;
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
            this.juj = dataRes.audit_status.intValue();
            this.audit_opinion = dataRes.audit_opinion;
            this.juk = dataRes.is_manager.intValue() == 1;
            this.forum_rule_id = dataRes.forum_rule_id;
            this.publish_time = dataRes.publish_time;
            this.bazhu = dataRes.bazhu;
            this.cur_time = dataRes.cur_time;
            this.jul = new d();
            this.jul.a(dataRes);
            this.jum = new a();
            this.jum.a(dataRes);
        }
    }

    public ForumInfo cJC() {
        return this.forum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPreface() {
        return this.preface;
    }

    public List<ForumRule> cJD() {
        return this.rules;
    }

    public int cJE() {
        return this.juj;
    }

    public String cJF() {
        return this.audit_opinion;
    }

    public boolean cJG() {
        return this.juk;
    }

    public String cJB() {
        return this.publish_time;
    }

    public BawuRoleInfoPub cJH() {
        return this.bazhu;
    }

    public void a(ForumInfo forumInfo) {
        this.forum = forumInfo;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public void rc(boolean z) {
        this.juk = z;
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub) {
        this.bazhu = bawuRoleInfoPub;
    }

    public String cJI() {
        return this.cur_time;
    }

    public a cJJ() {
        return this.jum;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
