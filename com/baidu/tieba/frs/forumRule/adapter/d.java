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
    private ForumRulesShowActivity juU;
    private boolean juV;
    private int juW;
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        this.juV = false;
        this.juW = 0;
        this.juU = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public ForumRuleDetailSelfVH e(ViewGroup viewGroup) {
        ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.juU).inflate(R.layout.forum_rules_user_area, viewGroup, false));
        this.Wo = forumRuleDetailSelfVH;
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
        if (bVar.cHd() != null) {
            forumRuleDetailSelfVH.ffU.setDefaultResource(R.drawable.img_default_100);
            forumRuleDetailSelfVH.ffU.startLoad(bVar.cHd().portrait, 12, false);
            forumRuleDetailSelfVH.eIO.setText(bVar.cHd().name_show);
            forumRuleDetailSelfVH.zu(bVar.cHd().user_level.intValue());
            forumRuleDetailSelfVH.jva.setVisibility(0);
        }
        forumRuleDetailSelfVH.juZ.setText(R.string.bawu_member_bazhu_tip);
        forumRuleDetailSelfVH.juZ.setVisibility(0);
        forumRuleDetailSelfVH.Kw(Config.BAWU_TYPE_MANAGER);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            forumRuleDetailSelfVH.Kx(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailSelfVH.gDo.setText(bVar.cGX());
        }
        b(forumRuleDetailSelfVH, bVar);
        forumRuleDetailSelfVH.Ky(bVar.getPreface());
    }

    private void b(ForumRuleDetailSelfVH forumRuleDetailSelfVH, final com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (bVar.cHc()) {
            forumRuleDetailSelfVH.jvc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.juV) {
                        d.this.cGW();
                    } else {
                        d.this.b(bVar);
                    }
                }
            });
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                forumRuleDetailSelfVH.jvc.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.cGX()) && bVar.cHa() == 0) {
                long KD = com.baidu.tieba.frs.forumRule.d.a.KD(bVar.cGX());
                int gu = com.baidu.tieba.frs.forumRule.d.a.gu(Long.valueOf(StringUtils.isNull(bVar.cHe()) ? "0" : bVar.cHe()).longValue() - KD);
                if (gu < 0) {
                    gu = com.baidu.tieba.frs.forumRule.d.a.gu((System.currentTimeMillis() / 1000) - KD);
                }
                forumRuleDetailSelfVH.jvc.setVisibility(0);
                if (gu >= 7) {
                    this.juV = false;
                    return;
                }
                forumRuleDetailSelfVH.jvc.setUseDisableState(true);
                this.juV = true;
                this.juW = 7 - gu;
            } else {
                forumRuleDetailSelfVH.zv(bVar.cHa());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (this.juU != null && bVar != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(bVar.getTitle());
            forumRuleBaseData.setPreface(bVar.getPreface());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bVar.cGZ().size(); i++) {
                ForumRule forumRule = bVar.cGZ().get(i);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(this.juU, bVar.cGY().forum_id + "", bVar.cGY().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.cGY().avatar, bVar.cHd().user_level.intValue(), 25053)));
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGW() {
        if (this.juU != null) {
            String format = String.format(this.juU.getString(R.string.forum_rules_later_days_edit), this.juW + "");
            if (this.juU.cGV() != null) {
                new BdTopToast(this.juU).zn(false).UN(format).aR(this.juU.cGV().getRootView());
            }
        }
    }
}
