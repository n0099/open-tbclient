package com.baidu.tieba.frs.forumRule.adapter;

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
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.forumRule.b.b, ForumRuleDetailSelfVH> {
    private ForumRulesShowActivity jtU;
    private boolean jtV;
    private int jtW;
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        this.jtV = false;
        this.jtW = 0;
        this.jtU = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public ForumRuleDetailSelfVH e(ViewGroup viewGroup) {
        ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.jtU).inflate(R.layout.forum_rules_user_area, viewGroup, false));
        this.Wu = forumRuleDetailSelfVH;
        return forumRuleDetailSelfVH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.forumRule.b.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        if (bVar != null) {
            a(forumRuleDetailSelfVH, bVar);
        }
        return view;
    }

    private void a(ForumRuleDetailSelfVH forumRuleDetailSelfVH, com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (bVar.cJH() != null) {
            forumRuleDetailSelfVH.fio.setDefaultResource(R.drawable.img_default_100);
            forumRuleDetailSelfVH.fio.startLoad(bVar.cJH().portrait, 12, false);
            forumRuleDetailSelfVH.eLt.setText(bVar.cJH().name_show);
            forumRuleDetailSelfVH.AQ(bVar.cJH().user_level.intValue());
            forumRuleDetailSelfVH.jua.setVisibility(0);
        }
        forumRuleDetailSelfVH.jtZ.setText(R.string.bawu_member_bazhu_tip);
        forumRuleDetailSelfVH.jtZ.setVisibility(0);
        forumRuleDetailSelfVH.KW(Config.BAWU_TYPE_MANAGER);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            forumRuleDetailSelfVH.KX(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailSelfVH.gFk.setText(bVar.cJB());
        }
        b(forumRuleDetailSelfVH, bVar);
        forumRuleDetailSelfVH.KY(bVar.getPreface());
    }

    private void b(ForumRuleDetailSelfVH forumRuleDetailSelfVH, final com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (bVar.cJG()) {
            forumRuleDetailSelfVH.juc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.jtV) {
                        d.this.cJA();
                    } else {
                        d.this.b(bVar);
                    }
                }
            });
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                forumRuleDetailSelfVH.juc.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.cJB()) && bVar.cJE() == 0) {
                long Ld = com.baidu.tieba.frs.forumRule.d.a.Ld(bVar.cJB());
                int gp = com.baidu.tieba.frs.forumRule.d.a.gp(Long.valueOf(StringUtils.isNull(bVar.cJI()) ? "0" : bVar.cJI()).longValue() - Ld);
                if (gp < 0) {
                    gp = com.baidu.tieba.frs.forumRule.d.a.gp((System.currentTimeMillis() / 1000) - Ld);
                }
                forumRuleDetailSelfVH.juc.setVisibility(0);
                if (gp >= 7) {
                    this.jtV = false;
                    return;
                }
                forumRuleDetailSelfVH.juc.setUseDisableState(true);
                this.jtV = true;
                this.jtW = 7 - gp;
            } else {
                forumRuleDetailSelfVH.AR(bVar.cJE());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (this.jtU != null && bVar != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(bVar.getTitle());
            forumRuleBaseData.setPreface(bVar.getPreface());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bVar.cJD().size(); i++) {
                ForumRule forumRule = bVar.cJD().get(i);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(this.jtU, bVar.cJC().forum_id + "", bVar.cJC().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.cJC().avatar, bVar.cJH().user_level.intValue(), 25053)));
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJA() {
        if (this.jtU != null) {
            String format = String.format(this.jtU.getString(R.string.forum_rules_later_days_edit), this.jtW + "");
            if (this.jtU.cJz() != null) {
                new BdTopToast(this.jtU).yW(false).UY(format).aR(this.jtU.cJz().getRootView());
            }
        }
    }
}
