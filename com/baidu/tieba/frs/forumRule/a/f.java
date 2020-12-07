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
    private ForumRulesShowActivity jhs;
    private boolean jht;
    private int jhu;
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        this.jht = false;
        this.jhu = 0;
        this.jhs = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public g c(ViewGroup viewGroup) {
        g gVar = new g(LayoutInflater.from(this.jhs).inflate(R.layout.forum_rules_user_area, viewGroup, false));
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
        if (bVar.cGH() != null) {
            gVar.eYM.setDefaultResource(R.drawable.img_default_100);
            gVar.eYM.startLoad(bVar.cGH().portrait, 12, false);
            gVar.eBQ.setText(bVar.cGH().name_show);
            gVar.AE(bVar.cGH().user_level.intValue());
            gVar.jhy.setVisibility(0);
        }
        gVar.jhx.setText(R.string.bawu_member_bazhu_tip);
        gVar.jhx.setVisibility(0);
        gVar.KW(Config.BAWU_TYPE_MANAGER);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            gVar.KX(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            gVar.guj.setText(bVar.cGB());
        }
        b(gVar, bVar);
        gVar.KY(bVar.getPreface());
    }

    private void b(g gVar, final com.baidu.tieba.frs.forumRule.c.b bVar) {
        if (bVar.cGG()) {
            gVar.jhA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.a.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jht) {
                        f.this.cGA();
                    } else {
                        f.this.b(bVar);
                    }
                }
            });
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                gVar.jhA.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.cGB()) && bVar.cGE() == 0) {
                long Ld = com.baidu.tieba.frs.forumRule.e.a.Ld(bVar.cGB());
                int gp = com.baidu.tieba.frs.forumRule.e.a.gp(Long.valueOf(StringUtils.isNull(bVar.cGI()) ? "0" : bVar.cGI()).longValue() - Ld);
                if (gp < 0) {
                    gp = com.baidu.tieba.frs.forumRule.e.a.gp((System.currentTimeMillis() / 1000) - Ld);
                }
                gVar.jhA.setVisibility(0);
                if (gp >= 7) {
                    this.jht = false;
                    return;
                }
                gVar.jhA.setUseDisableState(true);
                this.jht = true;
                this.jhu = 7 - gp;
            } else {
                gVar.AF(bVar.cGE());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.frs.forumRule.c.b bVar) {
        if (this.jhs != null && bVar != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(bVar.getTitle());
            forumRuleBaseData.setPreface(bVar.getPreface());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bVar.cGD().size(); i++) {
                ForumRule forumRule = bVar.cGD().get(i);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(this.jhs, bVar.cGC().forum_id + "", bVar.cGC().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.cGC().avatar, bVar.cGH().user_level.intValue(), 25053)));
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGA() {
        if (this.jhs != null) {
            String format = String.format(this.jhs.getString(R.string.forum_rules_later_days_edit), this.jhu + "");
            if (this.jhs.cGz() != null) {
                new BdTopToast(this.jhs).yW(false).Vt(format).aF(this.jhs.cGz().getRootView());
            }
        }
    }
}
