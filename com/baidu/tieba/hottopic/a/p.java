package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.viewpager.g;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.core.view.viewpager.g<RelateForumItemData, com.baidu.tieba.hottopic.b.f> {
    private HotTopicActivity bCN;
    private g.a<RelateForumItemData, com.baidu.tieba.hottopic.b.f> bCO;

    public p(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bCO = new q(this);
        this.bCN = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    /* renamed from: U */
    public com.baidu.tieba.hottopic.b.f c(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.f(LayoutInflater.from(this.mContext).inflate(n.g.hot_topic_relate_forum_recommendinfo, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    public View a(ViewGroup viewGroup, com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        a(fVar);
        a(fVar, relateForumItemData);
        return null;
    }

    private void a(com.baidu.tieba.hottopic.b.f fVar) {
        as.b(fVar.bAL, n.c.cp_cont_b, 1);
        as.b(fVar.bFk, n.c.cp_cont_c, 1);
        as.b(fVar.bFl, n.c.cp_cont_c, 1);
        as.b(fVar.bFm, n.c.cp_cont_d, 1);
        as.i((View) fVar.bFn, n.e.btn_appdownload);
        as.i(fVar.bFg, n.e.list_item_selector);
    }

    private void a(com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        if (relateForumItemData != null && !StringUtils.isNull(relateForumItemData.forumName)) {
            if (!StringUtils.isNull(relateForumItemData.forumAvatar)) {
                fVar.bFh.d(relateForumItemData.forumAvatar, 10, false);
            }
            if (!StringUtils.isNull(relateForumItemData.forumName)) {
                fVar.bAL.setSingleLine();
                fVar.bAL.setText(ax.d(relateForumItemData.forumName.trim(), 14, "..."));
            }
            fVar.bFk.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.i.forum_list_attention_tv)) + " " + aJ(relateForumItemData.followNum));
            fVar.bFl.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.i.forum_list_thread_tv)) + " " + aJ(relateForumItemData.postNum));
            relateForumItemData.forumAbstract = relateForumItemData.forumAbstract.trim();
            if (!StringUtils.isNull(relateForumItemData.forumAbstract)) {
                fVar.bFm.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                fVar.bFm.setText(relateForumItemData.forumAbstract);
            }
            a(fVar, relateForumItemData.isLiked);
            b(fVar, relateForumItemData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    public void a(int i, com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        if (fVar != null && relateForumItemData != null && i != fVar.afY) {
            a(fVar);
            a(fVar, relateForumItemData.isLiked);
            fVar.afY = i;
        }
    }

    private void a(com.baidu.tieba.hottopic.b.f fVar, boolean z) {
        if (z) {
            fVar.bFn.setEnabled(false);
            as.b(fVar.bFn, n.c.cp_cont_e, 1);
            fVar.bFn.setText(TbadkCoreApplication.m411getInst().getString(n.i.relate_forum_is_followed));
            fVar.bFn.setBackgroundDrawable(null);
            return;
        }
        as.b(fVar.bFn, n.c.cp_cont_i, 1);
        fVar.bFn.setText(TbadkCoreApplication.m411getInst().getString(n.i.forum_list_attention_tv));
        as.i((View) fVar.bFn, n.e.btn_appdownload);
        fVar.bFn.setEnabled(true);
    }

    private void b(com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        if (relateForumItemData != null) {
            String valueOf = String.valueOf(relateForumItemData.forumId);
            String str = relateForumItemData.forumName;
            setOnItemClickListener(this.bCO);
            fVar.bFn.setClickable(true);
            fVar.bFn.setOnClickListener(new r(this, str, valueOf));
        }
    }

    private String aJ(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }
}
