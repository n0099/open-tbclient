package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.c, com.baidu.tieba.hottopic.b.b> {
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.hottopic.b.b a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.b(LayoutInflater.from(this.mContext).inflate(i.g.hot_topic_topicinfo_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.c cVar, com.baidu.tieba.hottopic.b.b bVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (cVar != null) {
            a(bVar);
            a(bVar, cVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.b bVar, com.baidu.tieba.hottopic.data.c cVar) {
        if (bVar != null && cVar != null && !StringUtils.isNull(cVar.boF)) {
            bVar.bpD.setSingleLine();
            cVar.boF = cVar.boF.trim();
            StringBuilder sb = new StringBuilder();
            if (cVar.boF.length() > 14) {
                String substring = cVar.boF.substring(1, 10);
                sb.append(cVar.boF.charAt(0));
                sb.append(substring);
                sb.append("...");
                sb.append(cVar.boF.charAt(cVar.boF.length() - 1));
                bVar.bpD.setText(sb);
            } else {
                bVar.bpD.setText(cVar.boF);
            }
            bVar.bpE.setText(TbadkCoreApplication.m411getInst().getString(i.h.hot_topic_info_threadCount).replace("%s", as.v(cVar.postNum)));
            bVar.bpF.setMaxLines(3);
            if (StringUtils.isNull(cVar.boY)) {
                bVar.bpF.setVisibility(8);
                return;
            }
            bVar.bpF.setVisibility(0);
            bVar.bpF.setEllipsize(TextUtils.TruncateAt.END);
            bVar.bpF.setText(cVar.boY);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.b bVar) {
        if (bVar != null) {
            an.j(bVar.getView(), i.c.cp_bg_line_d);
            an.b(bVar.bpD, i.c.cp_cont_b, 1);
            an.b(bVar.bpE, i.c.cp_cont_e, 1);
            an.b(bVar.bpF, i.c.cp_cont_b, 1);
            an.j(bVar.aDQ, i.c.cp_bg_line_c);
        }
    }
}
