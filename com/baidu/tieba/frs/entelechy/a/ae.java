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
/* loaded from: classes9.dex */
public class ae extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.o, af> {
    private String mForumId;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public af b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        af afVar = new af(inflate);
        am.setViewTextColor(afVar.eTO, (int) R.color.cp_cont_b);
        am.setViewTextColor(afVar.hxh, (int) R.color.cp_cont_h);
        am.setImageResource(afVar.hxg, R.drawable.icon_news_list_prompt);
        am.setImageResource(afVar.hxi, R.drawable.icon_index_category_arrow_r);
        am.setBackgroundColor(afVar.hxj, R.color.cp_bg_line_c);
        am.setBackgroundColor(afVar.hxk, R.color.cp_bg_line_c);
        am.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.o oVar, af afVar) {
        if (view == null || afVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12587").dh("fid", ae.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + ae.this.mForumId, System.currentTimeMillis());
                if (oVar != null && !StringUtils.isNull(oVar.url)) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(ae.this.mContext, oVar.url);
                }
            }
        });
        afVar.eTO.setText(oVar != null ? oVar.text : "");
        if (eh(com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + this.mForumId, 0L))) {
            afVar.hxg.setVisibility(0);
        } else {
            afVar.hxg.setVisibility(8);
        }
        return afVar.getView();
    }

    private boolean eh(long j) {
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
