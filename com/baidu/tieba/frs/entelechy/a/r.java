package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.k;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class r extends com.baidu.adp.widget.ListView.a<k, s> {
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public s onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_video_activity_item, (ViewGroup) null);
        s sVar = new s(inflate);
        aj.r(sVar.mTitleTv, d.C0108d.cp_cont_b);
        aj.r(sVar.dDv, d.C0108d.cp_cont_h);
        aj.c(sVar.dDu, d.f.icon_news_list_prompt);
        aj.c(sVar.dDw, d.f.icon_index_category_arrow_r);
        aj.t(sVar.dDx, d.C0108d.cp_bg_line_b);
        aj.t(sVar.dDy, d.C0108d.cp_bg_line_b);
        aj.s(inflate, d.f.home_thread_card_item_bg);
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, final k kVar, s sVar) {
        if (view == null || sVar == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ak("c12587").ab(ImageViewerConfig.FORUM_ID, r.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_tip" + r.this.mForumId, System.currentTimeMillis());
                if (kVar != null && !StringUtils.isNull(kVar.url)) {
                    com.baidu.tbadk.browser.a.S(r.this.mContext, kVar.url);
                }
            }
        });
        sVar.mTitleTv.setText(kVar != null ? kVar.text : "");
        if (bz(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_tip" + this.mForumId, 0L))) {
            sVar.dDu.setVisibility(0);
        } else {
            sVar.dDu.setVisibility(8);
        }
        return sVar.getView();
    }

    private boolean bz(long j) {
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
