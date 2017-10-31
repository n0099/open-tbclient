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
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.i, r> {
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_video_activity_item, (ViewGroup) null);
        r rVar = new r(inflate);
        aj.i(rVar.mTitleTv, d.C0080d.cp_cont_b);
        aj.i(rVar.cEH, d.C0080d.cp_cont_h);
        aj.c(rVar.cEG, d.f.icon_news_list_prompt);
        aj.c(rVar.cEI, d.f.icon_index_category_arrow_r);
        aj.k(rVar.cEJ, d.C0080d.cp_bg_line_b);
        aj.k(rVar.cEK, d.C0080d.cp_bg_line_b);
        aj.j(inflate, d.f.home_thread_card_item_bg);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.i iVar, r rVar) {
        if (view == null || rVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ak("c12587").ac(ImageViewerConfig.FORUM_ID, q.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_tip" + q.this.mForumId, System.currentTimeMillis());
                if (iVar != null && !StringUtils.isNull(iVar.url)) {
                    com.baidu.tbadk.browser.a.P(q.this.mContext, iVar.url);
                }
            }
        });
        rVar.mTitleTv.setText(iVar != null ? iVar.text : "");
        if (bi(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_tip" + this.mForumId, 0L))) {
            rVar.cEG.setVisibility(0);
        } else {
            rVar.cEG.setVisibility(8);
        }
        return rVar.getView();
    }

    private boolean bi(long j) {
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
