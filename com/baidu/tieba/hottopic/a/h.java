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
        if (bVar != null && cVar != null && !StringUtils.isNull(cVar.bpj)) {
            bVar.bqh.setSingleLine();
            cVar.bpj = cVar.bpj.trim();
            StringBuilder sb = new StringBuilder();
            if (cVar.bpj.length() > 14) {
                String substring = cVar.bpj.substring(1, 10);
                sb.append(cVar.bpj.charAt(0));
                sb.append(substring);
                sb.append("...");
                sb.append(cVar.bpj.charAt(cVar.bpj.length() - 1));
                bVar.bqh.setText(sb);
            } else {
                bVar.bqh.setText(cVar.bpj);
            }
            bVar.bqi.setText(TbadkCoreApplication.m411getInst().getString(i.h.hot_topic_info_threadCount).replace("%s", as.v(cVar.postNum)));
            bVar.bqj.setMaxLines(3);
            if (StringUtils.isNull(cVar.bpC)) {
                bVar.bqj.setVisibility(8);
                return;
            }
            bVar.bqj.setVisibility(0);
            bVar.bqj.setEllipsize(TextUtils.TruncateAt.END);
            bVar.bqj.setText(cVar.bpC);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.b bVar) {
        if (bVar != null) {
            an.j(bVar.getView(), i.c.cp_bg_line_d);
            an.b(bVar.bqh, i.c.cp_cont_b, 1);
            an.b(bVar.bqi, i.c.cp_cont_e, 1);
            an.b(bVar.bqj, i.c.cp_cont_b, 1);
            an.j(bVar.aCK, i.c.cp_bg_line_c);
        }
    }
}
