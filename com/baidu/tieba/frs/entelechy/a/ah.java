package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes16.dex */
public class ah extends com.baidu.tieba.frs.j<com.baidu.tieba.tbadkCore.o, ai> {
    private String mForumId;

    public ah(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public ai b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        ai aiVar = new ai(inflate);
        ao.setViewTextColor(aiVar.fiS, R.color.cp_cont_b);
        ao.setViewTextColor(aiVar.hQh, R.color.cp_cont_h);
        ao.setImageResource(aiVar.hQg, R.drawable.icon_news_list_prompt);
        ao.setImageResource(aiVar.hQi, R.drawable.icon_index_category_arrow_r);
        ao.setBackgroundColor(aiVar.hQj, R.color.cp_bg_line_c);
        ao.setBackgroundColor(aiVar.hQk, R.color.cp_bg_line_c);
        ao.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.o oVar, ai aiVar) {
        if (view == null || aiVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ap("c12587").dn("fid", ah.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + ah.this.mForumId, System.currentTimeMillis());
                if (oVar != null && !StringUtils.isNull(oVar.url)) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(ah.this.mContext, oVar.url);
                }
            }
        });
        aiVar.fiS.setText(oVar != null ? oVar.text : "");
        if (ex(com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + this.mForumId, 0L))) {
            aiVar.hQg.setVisibility(0);
        } else {
            aiVar.hQg.setVisibility(8);
        }
        return aiVar.getView();
    }

    private boolean ex(long j) {
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
