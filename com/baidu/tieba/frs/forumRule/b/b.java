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
    private int jpD;
    private boolean jpE;
    private d jpF;
    private a jpG;
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
            this.jpD = dataRes.audit_status.intValue();
            this.audit_opinion = dataRes.audit_opinion;
            this.jpE = dataRes.is_manager.intValue() == 1;
            this.forum_rule_id = dataRes.forum_rule_id;
            this.publish_time = dataRes.publish_time;
            this.bazhu = dataRes.bazhu;
            this.cur_time = dataRes.cur_time;
            this.jpF = new d();
            this.jpF.a(dataRes);
            this.jpG = new a();
            this.jpG.a(dataRes);
        }
    }

    public ForumInfo cFL() {
        return this.forum;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPreface() {
        return this.preface;
    }

    public List<ForumRule> cFM() {
        return this.rules;
    }

    public int cFN() {
        return this.jpD;
    }

    public String cFO() {
        return this.audit_opinion;
    }

    public boolean cFP() {
        return this.jpE;
    }

    public String cFK() {
        return this.publish_time;
    }

    public BawuRoleInfoPub cFQ() {
        return this.bazhu;
    }

    public void a(ForumInfo forumInfo) {
        this.forum = forumInfo;
    }

    public void setPreface(String str) {
        this.preface = str;
    }

    public void qY(boolean z) {
        this.jpE = z;
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub) {
        this.bazhu = bawuRoleInfoPub;
    }

    public String cFR() {
        return this.cur_time;
    }

    public a cFS() {
        return this.jpG;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}
