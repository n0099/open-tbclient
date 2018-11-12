package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.k, o> {
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public o onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.frs_video_activity_item, (ViewGroup) null);
        o oVar = new o(inflate);
        al.h(oVar.bOH, e.d.cp_cont_b);
        al.h(oVar.dKm, e.d.cp_cont_h);
        al.c(oVar.dKl, e.f.icon_news_list_prompt);
        al.c(oVar.dKn, e.f.icon_index_category_arrow_r);
        al.j(oVar.dKo, e.d.cp_bg_line_b);
        al.j(oVar.dKp, e.d.cp_bg_line_b);
        al.i(inflate, e.f.home_thread_card_item_bg);
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.k kVar, o oVar) {
        if (view == null || oVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c12587").ax(ImageViewerConfig.FORUM_ID, n.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_tip" + n.this.mForumId, System.currentTimeMillis());
                if (kVar != null && !StringUtils.isNull(kVar.url)) {
                    com.baidu.tbadk.browser.a.ae(n.this.mContext, kVar.url);
                }
            }
        });
        oVar.bOH.setText(kVar != null ? kVar.text : "");
        if (bP(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_tip" + this.mForumId, 0L))) {
            oVar.dKl.setVisibility(0);
        } else {
            oVar.dKl.setVisibility(8);
        }
        return oVar.getView();
    }

    private boolean bP(long j) {
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
