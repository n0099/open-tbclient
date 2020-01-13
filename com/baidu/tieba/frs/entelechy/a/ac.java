package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class ac extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.n, ad> {
    private String mForumId;

    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public ad b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        ad adVar = new ad(inflate);
        am.setViewTextColor(adVar.ecE, (int) R.color.cp_cont_b);
        am.setViewTextColor(adVar.gvH, (int) R.color.cp_cont_h);
        am.setImageResource(adVar.gvG, R.drawable.icon_news_list_prompt);
        am.setImageResource(adVar.gvI, R.drawable.icon_index_category_arrow_r);
        am.setBackgroundColor(adVar.gvJ, R.color.cp_bg_line_c);
        am.setBackgroundColor(adVar.gvK, R.color.cp_bg_line_c);
        am.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.n nVar, ad adVar) {
        if (view == null || adVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12587").cp("fid", ac.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + ac.this.mForumId, System.currentTimeMillis());
                if (nVar != null && !StringUtils.isNull(nVar.url)) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(ac.this.mContext, nVar.url);
                }
            }
        });
        adVar.ecE.setText(nVar != null ? nVar.text : "");
        if (dx(com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + this.mForumId, 0L))) {
            adVar.gvG.setVisibility(0);
        } else {
            adVar.gvG.setVisibility(8);
        }
        return adVar.getView();
    }

    private boolean dx(long j) {
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
