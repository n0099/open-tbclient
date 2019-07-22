package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.l, y> {
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public y onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        y yVar = new y(inflate);
        am.j(yVar.dvh, R.color.cp_cont_b);
        am.j(yVar.fDe, R.color.cp_cont_h);
        am.c(yVar.fDd, (int) R.drawable.icon_news_list_prompt);
        am.c(yVar.fDf, (int) R.drawable.icon_index_category_arrow_r);
        am.l(yVar.fDg, R.color.cp_bg_line_b);
        am.l(yVar.fDh, R.color.cp_bg_line_b);
        am.k(inflate, R.drawable.home_thread_card_item_bg);
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.l lVar, y yVar) {
        if (view == null || yVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12587").bT("fid", x.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.ahO().putLong("frs_video_activity_tip" + x.this.mForumId, System.currentTimeMillis());
                if (lVar != null && !StringUtils.isNull(lVar.url)) {
                    com.baidu.tbadk.browser.a.af(x.this.mContext, lVar.url);
                }
            }
        });
        yVar.dvh.setText(lVar != null ? lVar.text : "");
        if (dk(com.baidu.tbadk.core.sharedPref.b.ahO().getLong("frs_video_activity_tip" + this.mForumId, 0L))) {
            yVar.fDd.setVisibility(0);
        } else {
            yVar.fDd.setVisibility(8);
        }
        return yVar.getView();
    }

    private boolean dk(long j) {
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
