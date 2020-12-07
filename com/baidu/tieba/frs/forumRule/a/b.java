package com.baidu.tieba.frs.forumRule.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.forumRule.c.a, c> {
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
    /* renamed from: bp */
    public c c(ViewGroup viewGroup) {
        c cVar = new c(LayoutInflater.from(this.mContext).inflate(R.layout.forum_rules_bottom, viewGroup, false));
        a(cVar);
        this.Wx = cVar;
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.forumRule.c.a aVar, c cVar) {
        if (aVar != null) {
            a(cVar, aVar);
        }
        return view;
    }

    private void a(c cVar, com.baidu.tieba.frs.forumRule.c.a aVar) {
        if (cVar != null) {
            cVar.jhg.setDefaultBgResource(R.drawable.img_default_100);
            cVar.jhg.startLoad(aVar.getAvatar(), 10, false);
            cVar.jhi.setText(aVar.boT() + TbadkApplication.getInst().getResources().getString(R.string.forum_rules_bar_management_group));
            cVar.jhk.setDefaultBgResource(R.drawable.img_default_100);
            cVar.jhk.startLoad(aVar.getPortrait(), 12, false);
            cVar.jhl.setText(aVar.getName_show());
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                cVar.KU(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                cVar.jhm.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.cGB()));
                cVar.jhj.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.cGB()));
            }
            cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(c cVar) {
        if (cVar != null) {
            cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
