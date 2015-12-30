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
    private HotTopicActivity bGr;
    private g.a<RelateForumItemData, com.baidu.tieba.hottopic.b.f> bGs;

    public p(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bGs = new q(this);
        this.bGr = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    /* renamed from: P */
    public com.baidu.tieba.hottopic.b.f c(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.f(LayoutInflater.from(this.mContext).inflate(n.h.hot_topic_relate_forum_recommendinfo, viewGroup, false));
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
        as.b(fVar.bIP, n.d.cp_cont_b, 1);
        as.b(fVar.bIR, n.d.cp_cont_c, 1);
        as.b(fVar.bIS, n.d.cp_cont_c, 1);
        as.b(fVar.bIT, n.d.cp_cont_d, 1);
        as.i((View) fVar.bIU, n.f.btn_appdownload);
        as.i(fVar.bIM, n.f.list_item_selector);
    }

    private void a(com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        if (relateForumItemData != null && !StringUtils.isNull(relateForumItemData.forumName)) {
            if (!StringUtils.isNull(relateForumItemData.forumAvatar)) {
                fVar.bIN.d(relateForumItemData.forumAvatar, 10, false);
            }
            if (!StringUtils.isNull(relateForumItemData.forumName)) {
                fVar.bIP.setSingleLine();
                fVar.bIP.setText(ax.d(relateForumItemData.forumName.trim(), 14, "..."));
            }
            fVar.bIR.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.j.forum_list_attention_tv)) + " " + aK(relateForumItemData.followNum));
            fVar.bIS.setText(String.valueOf(TbadkCoreApplication.m411getInst().getString(n.j.forum_list_thread_tv)) + " " + aK(relateForumItemData.postNum));
            relateForumItemData.forumAbstract = relateForumItemData.forumAbstract.trim();
            if (!StringUtils.isNull(relateForumItemData.forumAbstract)) {
                fVar.bIT.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                fVar.bIT.setText(relateForumItemData.forumAbstract);
            }
            a(fVar, relateForumItemData.isLiked);
            b(fVar, relateForumItemData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.g
    public void a(int i, com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        if (fVar != null && relateForumItemData != null && i != fVar.ahf) {
            a(fVar);
            a(fVar, relateForumItemData.isLiked);
            fVar.ahf = i;
        }
    }

    private void a(com.baidu.tieba.hottopic.b.f fVar, boolean z) {
        if (z) {
            fVar.bIU.setEnabled(false);
            as.b(fVar.bIU, n.d.cp_cont_e, 1);
            fVar.bIU.setText(TbadkCoreApplication.m411getInst().getString(n.j.relate_forum_is_followed));
            fVar.bIU.setBackgroundDrawable(null);
            return;
        }
        as.b(fVar.bIU, n.d.cp_cont_i, 1);
        fVar.bIU.setText(TbadkCoreApplication.m411getInst().getString(n.j.forum_list_attention_tv));
        as.i((View) fVar.bIU, n.f.btn_appdownload);
        fVar.bIU.setEnabled(true);
    }

    private void b(com.baidu.tieba.hottopic.b.f fVar, RelateForumItemData relateForumItemData) {
        if (relateForumItemData != null) {
            String valueOf = String.valueOf(relateForumItemData.forumId);
            String str = relateForumItemData.forumName;
            a(this.bGs);
            fVar.bIU.setClickable(true);
            fVar.bIU.setOnClickListener(new r(this, str, valueOf));
        }
    }

    private String aK(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }
}
