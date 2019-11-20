package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.n, y> {
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public y b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        y yVar = new y(inflate);
        am.setViewTextColor(yVar.dCK, (int) R.color.cp_cont_b);
        am.setViewTextColor(yVar.fEf, (int) R.color.cp_cont_h);
        am.setImageResource(yVar.fEe, R.drawable.icon_news_list_prompt);
        am.setImageResource(yVar.fEg, R.drawable.icon_index_category_arrow_r);
        am.setBackgroundColor(yVar.fEh, R.color.cp_bg_line_c);
        am.setBackgroundColor(yVar.fEi, R.color.cp_bg_line_c);
        am.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.n nVar, y yVar) {
        if (view == null || yVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12587").bS("fid", x.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + x.this.mForumId, System.currentTimeMillis());
                if (nVar != null && !StringUtils.isNull(nVar.url)) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(x.this.mContext, nVar.url);
                }
            }
        });
        yVar.dCK.setText(nVar != null ? nVar.text : "");
        if (cM(com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + this.mForumId, 0L))) {
            yVar.fEe.setVisibility(0);
        } else {
            yVar.fEe.setVisibility(8);
        }
        return yVar.getView();
    }

    private boolean cM(long j) {
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
