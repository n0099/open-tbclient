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
    private ForumRulesShowActivity jwR;
    private boolean jwS;
    private int jwT;
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        this.jwS = false;
        this.jwT = 0;
        this.jwR = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public ForumRuleDetailSelfVH e(ViewGroup viewGroup) {
        ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.jwR).inflate(R.layout.forum_rules_user_area, viewGroup, false));
        this.XI = forumRuleDetailSelfVH;
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
        if (bVar.cHq() != null) {
            forumRuleDetailSelfVH.fht.setDefaultResource(R.drawable.img_default_100);
            forumRuleDetailSelfVH.fht.startLoad(bVar.cHq().portrait, 12, false);
            forumRuleDetailSelfVH.eKp.setText(bVar.cHq().name_show);
            forumRuleDetailSelfVH.zv(bVar.cHq().user_level.intValue());
            forumRuleDetailSelfVH.jwX.setVisibility(0);
        }
        forumRuleDetailSelfVH.jwW.setText(R.string.bawu_member_bazhu_tip);
        forumRuleDetailSelfVH.jwW.setVisibility(0);
        forumRuleDetailSelfVH.KG(Config.BAWU_TYPE_MANAGER);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            forumRuleDetailSelfVH.KH(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailSelfVH.gFl.setText(bVar.cHk());
        }
        b(forumRuleDetailSelfVH, bVar);
        forumRuleDetailSelfVH.KI(bVar.getPreface());
    }

    private void b(ForumRuleDetailSelfVH forumRuleDetailSelfVH, final com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (bVar.cHp()) {
            forumRuleDetailSelfVH.jwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.jwS) {
                        d.this.cHj();
                    } else {
                        d.this.b(bVar);
                    }
                }
            });
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                forumRuleDetailSelfVH.jwZ.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.cHk()) && bVar.cHn() == 0) {
                long KN = com.baidu.tieba.frs.forumRule.d.a.KN(bVar.cHk());
                int gu = com.baidu.tieba.frs.forumRule.d.a.gu(Long.valueOf(StringUtils.isNull(bVar.cHr()) ? "0" : bVar.cHr()).longValue() - KN);
                if (gu < 0) {
                    gu = com.baidu.tieba.frs.forumRule.d.a.gu((System.currentTimeMillis() / 1000) - KN);
                }
                forumRuleDetailSelfVH.jwZ.setVisibility(0);
                if (gu >= 7) {
                    this.jwS = false;
                    return;
                }
                forumRuleDetailSelfVH.jwZ.setUseDisableState(true);
                this.jwS = true;
                this.jwT = 7 - gu;
            } else {
                forumRuleDetailSelfVH.zw(bVar.cHn());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (this.jwR != null && bVar != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(bVar.getTitle());
            forumRuleBaseData.setPreface(bVar.getPreface());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bVar.cHm().size(); i++) {
                ForumRule forumRule = bVar.cHm().get(i);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(this.jwR, bVar.cHl().forum_id + "", bVar.cHl().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.cHl().avatar, bVar.cHq().user_level.intValue(), 25053)));
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHj() {
        if (this.jwR != null) {
            String format = String.format(this.jwR.getString(R.string.forum_rules_later_days_edit), this.jwT + "");
            if (this.jwR.cHi() != null) {
                new BdTopToast(this.jwR).zm(false).Vg(format).aR(this.jwR.cHi().getRootView());
            }
        }
    }
}
