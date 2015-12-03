package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.d, com.baidu.tieba.hottopic.b.b> {
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public com.baidu.tieba.hottopic.b.b a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.b(LayoutInflater.from(this.mContext).inflate(n.g.hot_topic_topicinfo_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.d dVar, com.baidu.tieba.hottopic.b.b bVar) {
        if (dVar != null) {
            a(bVar);
            a(bVar, dVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.b bVar, com.baidu.tieba.hottopic.data.d dVar) {
        if (bVar != null && dVar != null && !StringUtils.isNull(dVar.bBb)) {
            if (!TextUtils.isEmpty(dVar.bDR)) {
                int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getContext());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.bEJ.getLayoutParams();
                layoutParams.height = K / 2;
                bVar.bEJ.setLayoutParams(layoutParams);
                bVar.bEJ.setEvent(new i(this, bVar));
                bVar.bEJ.d(dVar.bDR, 10, false);
            } else {
                bVar.bEJ.setVisibility(8);
            }
            bVar.bEK.setSingleLine();
            dVar.bBb = dVar.bBb.trim();
            StringBuilder sb = new StringBuilder();
            if (dVar.bBb.length() > 14) {
                String substring = dVar.bBb.substring(1, 10);
                sb.append(dVar.bBb.charAt(0));
                sb.append(substring);
                sb.append("...");
                sb.append(dVar.bBb.charAt(dVar.bBb.length() - 1));
                bVar.bEK.setText(sb);
            } else {
                bVar.bEK.setText(dVar.bBb);
            }
            bVar.bEL.setText(TbadkCoreApplication.m411getInst().getString(n.i.hot_topic_info_threadCount).replace("%s", ax.B(dVar.postNum)));
            bVar.bEM.setMaxLines(3);
            if (StringUtils.isNull(dVar.bDQ)) {
                bVar.bEM.setVisibility(8);
                return;
            }
            bVar.bEM.setVisibility(0);
            bVar.bEM.setEllipsize(TextUtils.TruncateAt.END);
            bVar.bEM.setText(dVar.bDQ);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.b bVar) {
        if (bVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (bVar.afY != this.mSkinType) {
                bVar.afY = this.mSkinType;
                as.j(bVar.getView(), n.c.cp_bg_line_d);
                as.b(bVar.bEK, n.c.cp_cont_b, 1);
                as.b(bVar.bEL, n.c.cp_cont_e, 1);
                as.b(bVar.bEM, n.c.cp_cont_b, 1);
                as.j(bVar.aFH, n.c.cp_bg_line_c);
            }
        }
    }
}
