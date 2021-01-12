package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.forumRule.b.a, ForumRuleDetailBottomVH> {
    private Context mContext;
    private String mFrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public ForumRuleDetailBottomVH e(ViewGroup viewGroup) {
        ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.mContext).inflate(R.layout.forum_rules_bottom, viewGroup, false));
        a(forumRuleDetailBottomVH);
        this.Ws = forumRuleDetailBottomVH;
        return forumRuleDetailBottomVH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.forumRule.b.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (aVar != null) {
            a(forumRuleDetailBottomVH, aVar);
        }
        return view;
    }

    private void a(ForumRuleDetailBottomVH forumRuleDetailBottomVH, com.baidu.tieba.frs.forumRule.b.a aVar) {
        if (forumRuleDetailBottomVH != null) {
            forumRuleDetailBottomVH.jpc.setDefaultBgResource(R.drawable.img_default_100);
            forumRuleDetailBottomVH.jpc.startLoad(aVar.getAvatar(), 10, false);
            forumRuleDetailBottomVH.jpe.setText(aVar.bnB() + TbadkApplication.getInst().getResources().getString(R.string.forum_rules_bar_management_group));
            forumRuleDetailBottomVH.jpg.setDefaultBgResource(R.drawable.img_default_100);
            forumRuleDetailBottomVH.jpg.startLoad(aVar.getPortrait(), 12, false);
            forumRuleDetailBottomVH.jph.setText(aVar.getName_show());
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                forumRuleDetailBottomVH.JJ(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailBottomVH.jpi.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.cFK()));
                forumRuleDetailBottomVH.jpf.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.cFK()));
            }
            forumRuleDetailBottomVH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (forumRuleDetailBottomVH != null) {
            forumRuleDetailBottomVH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
