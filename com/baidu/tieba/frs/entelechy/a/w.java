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
import com.baidu.tieba.d;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.tbadkCore.l, x> {
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public x onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_video_activity_item, (ViewGroup) null);
        x xVar = new x(inflate);
        al.j(xVar.dis, d.C0277d.cp_cont_b);
        al.j(xVar.fhL, d.C0277d.cp_cont_h);
        al.c(xVar.fhK, d.f.icon_news_list_prompt);
        al.c(xVar.fhM, d.f.icon_index_category_arrow_r);
        al.l(xVar.fhN, d.C0277d.cp_bg_line_b);
        al.l(xVar.fhO, d.C0277d.cp_bg_line_b);
        al.k(inflate, d.f.home_thread_card_item_bg);
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.l lVar, x xVar) {
        if (view == null || xVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new am("c12587").bJ(ImageViewerConfig.FORUM_ID, w.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_tip" + w.this.mForumId, System.currentTimeMillis());
                if (lVar != null && !StringUtils.isNull(lVar.url)) {
                    com.baidu.tbadk.browser.a.as(w.this.mContext, lVar.url);
                }
            }
        });
        xVar.dis.setText(lVar != null ? lVar.text : "");
        if (cG(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_tip" + this.mForumId, 0L))) {
            xVar.fhK.setVisibility(0);
        } else {
            xVar.fhK.setVisibility(8);
        }
        return xVar.getView();
    }

    private boolean cG(long j) {
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
