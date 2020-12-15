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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes22.dex */
public class ai extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.q, aj> {
    private String mForumId;

    public ai(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public aj c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        aj ajVar = new aj(inflate);
        ap.setViewTextColor(ajVar.gfR, R.color.CAM_X0105);
        ap.setViewTextColor(ajVar.jex, R.color.CAM_X0301);
        ap.setImageResource(ajVar.jew, R.drawable.icon_news_list_prompt);
        ap.setImageResource(ajVar.jey, R.drawable.icon_index_category_arrow_r);
        ap.setBackgroundColor(ajVar.bNe, R.color.CAM_X0204);
        ap.setBackgroundColor(ajVar.bNf, R.color.CAM_X0204);
        ap.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.q qVar, aj ajVar) {
        if (view == null || ajVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c12587").dY("fid", ai.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + ai.this.mForumId, System.currentTimeMillis());
                if (qVar != null && !StringUtils.isNull(qVar.url)) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(ai.this.mContext, qVar.url);
                }
            }
        });
        ajVar.gfR.setText(qVar != null ? qVar.text : "");
        if (go(com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + this.mForumId, 0L))) {
            ajVar.jew.setVisibility(0);
        } else {
            ajVar.jew.setVisibility(8);
        }
        return ajVar.getView();
    }

    private boolean go(long j) {
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
