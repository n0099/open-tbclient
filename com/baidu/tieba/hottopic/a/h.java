package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.f, com.baidu.tieba.hottopic.b.d> {
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public com.baidu.tieba.hottopic.b.d b(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.d(LayoutInflater.from(this.mContext).inflate(t.h.hot_topic_topicinfo_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.f fVar, com.baidu.tieba.hottopic.b.d dVar) {
        if (fVar != null) {
            a(dVar);
            a(dVar, fVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.f fVar) {
        if (dVar != null && fVar != null && !StringUtils.isNull(fVar.Wm)) {
            if (!TextUtils.isEmpty(fVar.bLe)) {
                int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getContext());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.bLY.getLayoutParams();
                layoutParams.height = K / 2;
                dVar.bLY.setLayoutParams(layoutParams);
                dVar.bLY.setEvent(new i(this, dVar));
                dVar.bLY.d(fVar.bLe, 10, false);
            } else {
                dVar.bLY.setVisibility(8);
            }
            dVar.bLZ.setSingleLine();
            fVar.Wm = fVar.Wm.trim();
            dVar.bLZ.setEllipsize(TextUtils.TruncateAt.END);
            dVar.bLZ.setText(aw.d(fVar.Wm, 14, "..."));
            dVar.bMa.setText(TbadkCoreApplication.m411getInst().getString(t.j.hot_topic_info_threadCount).replace("%s", aw.E(fVar.postNum)));
            dVar.bMb.setMaxLines(3);
            if (StringUtils.isNull(fVar.bLd)) {
                dVar.bMb.setVisibility(8);
            } else {
                dVar.bMb.setVisibility(0);
                dVar.bMb.setEllipsize(TextUtils.TruncateAt.END);
                dVar.bMb.setText(aw.d(fVar.bLd, 72, "..."));
            }
            if (fVar.bLh > 0 && fVar.bLh <= 20) {
                dVar.bMc.setVisibility(0);
                dVar.bMg.setText(String.valueOf(fVar.Wm.trim()) + this.mContext.getResources().getString(t.j.hot_topic_cur_rank) + fVar.bLh);
                dVar.bMd.setOnClickListener(new j(this, fVar));
                return;
            }
            dVar.aIj.setVisibility(8);
            dVar.bMc.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar) {
        if (dVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (dVar.ahU != this.mSkinType) {
                dVar.ahU = this.mSkinType;
                ar.l(dVar.getView(), t.d.cp_bg_line_d);
                ar.b(dVar.bLZ, t.d.cp_cont_b, 1);
                ar.b(dVar.bMa, t.d.cp_cont_e, 1);
                ar.b(dVar.bMb, t.d.cp_cont_b, 1);
                ar.l(dVar.aIj, t.d.cp_bg_line_c);
                ar.b(dVar.bMg, t.d.cp_cont_b, 1);
                ar.b(dVar.bMh, t.d.cp_cont_c, 1);
                ar.k(dVar.bMe, t.f.icon_hot_rank);
                ar.k(dVar.bMf, t.f.icon_recomment_arrow);
                ar.k(dVar.bMd, t.f.hot_topic_ranklist_bg);
            }
        }
    }
}
