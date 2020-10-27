package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes22.dex */
public class ah extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.p, ai> {
    private String mForumId;

    public ah(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public ai c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        ai aiVar = new ai(inflate);
        ap.setViewTextColor(aiVar.fSh, R.color.cp_cont_b);
        ap.setViewTextColor(aiVar.iMP, R.color.cp_cont_h);
        ap.setImageResource(aiVar.iMO, R.drawable.icon_news_list_prompt);
        ap.setImageResource(aiVar.iMQ, R.drawable.icon_index_category_arrow_r);
        ap.setBackgroundColor(aiVar.bEa, R.color.cp_bg_line_c);
        ap.setBackgroundColor(aiVar.bEb, R.color.cp_bg_line_c);
        ap.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.p pVar, ai aiVar) {
        if (view == null || aiVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12587").dR("fid", ah.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + ah.this.mForumId, System.currentTimeMillis());
                if (pVar != null && !StringUtils.isNull(pVar.url)) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(ah.this.mContext, pVar.url);
                }
            }
        });
        aiVar.fSh.setText(pVar != null ? pVar.text : "");
        if (fl(com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + this.mForumId, 0L))) {
            aiVar.iMO.setVisibility(0);
        } else {
            aiVar.iMO.setVisibility(8);
        }
        return aiVar.getView();
    }

    private boolean fl(long j) {
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
