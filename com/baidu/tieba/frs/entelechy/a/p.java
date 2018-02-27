package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.k, q> {
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public q onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_video_activity_item, (ViewGroup) null);
        q qVar = new q(inflate);
        aj.r(qVar.mTitleTv, d.C0141d.cp_cont_b);
        aj.r(qVar.dLg, d.C0141d.cp_cont_h);
        aj.c(qVar.dLf, d.f.icon_news_list_prompt);
        aj.c(qVar.dLh, d.f.icon_index_category_arrow_r);
        aj.t(qVar.dLi, d.C0141d.cp_bg_line_b);
        aj.t(qVar.dLj, d.C0141d.cp_bg_line_b);
        aj.s(inflate, d.f.home_thread_card_item_bg);
        return qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.k kVar, q qVar) {
        if (view == null || qVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ak("c12587").ab(ImageViewerConfig.FORUM_ID, p.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_tip" + p.this.mForumId, System.currentTimeMillis());
                if (kVar != null && !StringUtils.isNull(kVar.url)) {
                    com.baidu.tbadk.browser.b.S(p.this.mContext, kVar.url);
                }
            }
        });
        qVar.mTitleTv.setText(kVar != null ? kVar.text : "");
        if (bG(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_tip" + this.mForumId, 0L))) {
            qVar.dLf.setVisibility(0);
        } else {
            qVar.dLf.setVisibility(8);
        }
        return qVar.getView();
    }

    private boolean bG(long j) {
        if (j == 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j <= 86400000) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j);
            return calendar.get(7) > calendar2.get(7);
        }
        return true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }
}
