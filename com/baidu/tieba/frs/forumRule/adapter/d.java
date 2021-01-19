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
    private ForumRulesShowActivity jpo;
    private boolean jpp;
    private int jpq;
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        this.jpp = false;
        this.jpq = 0;
        this.jpo = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public ForumRuleDetailSelfVH e(ViewGroup viewGroup) {
        ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.jpo).inflate(R.layout.forum_rules_user_area, viewGroup, false));
        this.Ws = forumRuleDetailSelfVH;
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
        if (bVar.cFQ() != null) {
            forumRuleDetailSelfVH.fdF.setDefaultResource(R.drawable.img_default_100);
            forumRuleDetailSelfVH.fdF.startLoad(bVar.cFQ().portrait, 12, false);
            forumRuleDetailSelfVH.eGI.setText(bVar.cFQ().name_show);
            forumRuleDetailSelfVH.zk(bVar.cFQ().user_level.intValue());
            forumRuleDetailSelfVH.jpu.setVisibility(0);
        }
        forumRuleDetailSelfVH.jpt.setText(R.string.bawu_member_bazhu_tip);
        forumRuleDetailSelfVH.jpt.setVisibility(0);
        forumRuleDetailSelfVH.JL(Config.BAWU_TYPE_MANAGER);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            forumRuleDetailSelfVH.JM(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailSelfVH.gAE.setText(bVar.cFK());
        }
        b(forumRuleDetailSelfVH, bVar);
        forumRuleDetailSelfVH.JN(bVar.getPreface());
    }

    private void b(ForumRuleDetailSelfVH forumRuleDetailSelfVH, final com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (bVar.cFP()) {
            forumRuleDetailSelfVH.jpw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.jpp) {
                        d.this.cFJ();
                    } else {
                        d.this.b(bVar);
                    }
                }
            });
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                forumRuleDetailSelfVH.jpw.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.cFK()) && bVar.cFN() == 0) {
                long JS = com.baidu.tieba.frs.forumRule.d.a.JS(bVar.cFK());
                int gp = com.baidu.tieba.frs.forumRule.d.a.gp(Long.valueOf(StringUtils.isNull(bVar.cFR()) ? "0" : bVar.cFR()).longValue() - JS);
                if (gp < 0) {
                    gp = com.baidu.tieba.frs.forumRule.d.a.gp((System.currentTimeMillis() / 1000) - JS);
                }
                forumRuleDetailSelfVH.jpw.setVisibility(0);
                if (gp >= 7) {
                    this.jpp = false;
                    return;
                }
                forumRuleDetailSelfVH.jpw.setUseDisableState(true);
                this.jpp = true;
                this.jpq = 7 - gp;
            } else {
                forumRuleDetailSelfVH.zl(bVar.cFN());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.frs.forumRule.b.b bVar) {
        if (this.jpo != null && bVar != null) {
            ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
            forumRuleBaseData.setTitle(bVar.getTitle());
            forumRuleBaseData.setPreface(bVar.getPreface());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bVar.cFM().size(); i++) {
                ForumRule forumRule = bVar.cFM().get(i);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(this.jpo, bVar.cFL().forum_id + "", bVar.cFL().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.cFL().avatar, bVar.cFQ().user_level.intValue(), 25053)));
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFJ() {
        if (this.jpo != null) {
            String format = String.format(this.jpo.getString(R.string.forum_rules_later_days_edit), this.jpq + "");
            if (this.jpo.cFI() != null) {
                new BdTopToast(this.jpo).yS(false).TQ(format).aR(this.jpo.cFI().getRootView());
            }
        }
    }
}
