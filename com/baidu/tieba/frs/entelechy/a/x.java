package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    /* renamed from: aM */
    public y onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        y yVar = new y(inflate);
        al.j(yVar.dsY, R.color.cp_cont_b);
        al.j(yVar.fyh, R.color.cp_cont_h);
        al.c(yVar.fyg, (int) R.drawable.icon_news_list_prompt);
        al.c(yVar.fyi, (int) R.drawable.icon_index_category_arrow_r);
        al.l(yVar.fyj, R.color.cp_bg_line_b);
        al.l(yVar.fyk, R.color.cp_bg_line_b);
        al.k(inflate, R.drawable.home_thread_card_item_bg);
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
                TiebaStatic.log(new am("c12587").bT("fid", x.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.agM().putLong("frs_video_activity_tip" + x.this.mForumId, System.currentTimeMillis());
                if (lVar != null && !StringUtils.isNull(lVar.url)) {
                    com.baidu.tbadk.browser.a.ag(x.this.mContext, lVar.url);
                }
            }
        });
        yVar.dsY.setText(lVar != null ? lVar.text : "");
        if (dd(com.baidu.tbadk.core.sharedPref.b.agM().getLong("frs_video_activity_tip" + this.mForumId, 0L))) {
            yVar.fyg.setVisibility(0);
        } else {
            yVar.fyg.setVisibility(8);
        }
        return yVar.getView();
    }

    private boolean dd(long j) {
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
