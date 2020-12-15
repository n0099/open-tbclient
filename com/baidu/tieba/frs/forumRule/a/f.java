package com.baidu.tieba.frs.forumRule.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.view.BdTopToast;
import java.util.ArrayList;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes22.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.forumRule.c.b, g> {
    private ForumRulesShowActivity jhu;
    private boolean jhv;
    private int jhw;
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        this.jhv = false;
        this.jhw = 0;
        this.jhu = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public g c(ViewGroup viewGroup) {
        g gVar = new g(LayoutInflater.from(this.jhu).inflate(R.layout.forum_rules_user_area, viewGroup, false));
        this.Wx = gVar;
        return gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.forumRule.c.b bVar, g gVar) {
        if (bVar != null) {
            a(gVar, bVar);
        }
        return view;
    }

    private void a(g gVar, com.baidu.tieba.frs.forumRule.c.b bVar) {
        if (bVar.cGI() != null) {
            gVar.eYM.setDefaultResource(R.drawable.img_default_100);
            gVar.eYM.startLoad(bVar.cGI().portrait, 12, false);
            gVar.eBQ.setText(bVar.cGI().name_show);
            gVar.AE(bVar.cGI().user_level.intValue());
            gVar.jhA.setVisibility(0);
        }
        gVar.jhz.setText(R.string.bawu_member_bazhu_tip);
        gVar.jhz.setVisibility(0);
        gVar.KW(Config.BAWU_TYPE_MANAGER);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            gVar.KX(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            gVar.gul.setText(bVar.cGC());
        }
        b(gVar, bVar);
        gVar.KY(bVar.getPreface());
    }

    private void b(g gVar, final com.baidu.tieba.frs.forumRule.c.b bVar) {
        if (bVar.cGH()) {
            gVar.jhC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.a.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jhv) {
                        f.this.cGB();
                    } else {
                        f.this.b(bVar);
                    }
                }
            });
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                gVar.jhC.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.cGC()) && bVar.cGF() == 0) {
                long Ld = com.baidu.tieba.frs.forumRule.e.a.Ld(bVar.cGC());
                int gp = com.baidu.tieba.frs.forumRule.e.a.gp(Long.valueOf(StringUtils.isNull(bVar.cGJ()) ? "0" : bVar.cGJ()).longValue() - Ld);
                if (gp < 0) {
                    gp = com.baidu.tieba.frs.forumRule.e.a.gp((System.currentTimeMillis() / 1000) - Ld);
                }
                gVar.jhC.setVisibility(0);
                if (gp >= 7) {
                    this.jhv = false;
                    return;
                }
                gVar.jhC.setUseDisableState(true);
                this.jhv = true;
                this.jhw = 7 - gp;
            } else {
                gVar.AF(bVar.cGF());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.frs.forumRule.c.b bVar) {
        if (this.jhu != null && bVar != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(bVar.getTitle());
            forumRuleBaseData.setPreface(bVar.getPreface());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bVar.cGE().size(); i++) {
                ForumRule forumRule = bVar.cGE().get(i);
                ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData = new ForumRuleBaseData.ForumRuleItemPbData();
                forumRuleItemPbData.status = forumRule.status + "";
                forumRuleItemPbData.title = forumRule.title + "";
                forumRuleItemPbData.mContent = new ArrayList();
                if (forumRule.content != null && forumRule.content.size() > 0) {
                    for (int i2 = 0; i2 < forumRule.content.size(); i2++) {
                        PbContent pbContent = forumRule.content.get(i2);
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleBaseData.ForumRuleItemPbContentData();
                        forumRuleItemPbContentData.href = pbContent.link;
                        if (pbContent.type.intValue() == 0) {
                            forumRuleItemPbContentData.tag = "plainText";
                        } else if (pbContent.type.intValue() == 1) {
                            forumRuleItemPbContentData.tag = "a";
                        } else if (pbContent.type.intValue() == 2) {
                            forumRuleItemPbContentData.tag = "br";
                        }
                        forumRuleItemPbContentData.value = pbContent.text;
                        forumRuleItemPbData.mContent.add(forumRuleItemPbContentData);
                    }
                }
                arrayList.add(forumRuleItemPbData);
            }
            forumRuleBaseData.setPbDataList(arrayList);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(this.jhu, bVar.cGD().forum_id + "", bVar.cGD().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.cGD().avatar, bVar.cGI().user_level.intValue(), 25053)));
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGB() {
        if (this.jhu != null) {
            String format = String.format(this.jhu.getString(R.string.forum_rules_later_days_edit), this.jhw + "");
            if (this.jhu.cGA() != null) {
                new BdTopToast(this.jhu).yW(false).Vt(format).aF(this.jhu.cGA().getRootView());
            }
        }
    }
}
