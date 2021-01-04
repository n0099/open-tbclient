package com.baidu.tieba.frs.entelechy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class ai extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.q, FrsVideoActivityViewHolder> {
    private String mForumId;

    public ai(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public FrsVideoActivityViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
        ao.setViewTextColor(frsVideoActivityViewHolder.mTitleTv, R.color.CAM_X0105);
        ao.setViewTextColor(frsVideoActivityViewHolder.jqW, R.color.CAM_X0301);
        ao.setImageResource(frsVideoActivityViewHolder.jqV, R.drawable.icon_news_list_prompt);
        ao.setImageResource(frsVideoActivityViewHolder.jqX, R.drawable.icon_index_category_arrow_r);
        ao.setBackgroundColor(frsVideoActivityViewHolder.bRR, R.color.CAM_X0204);
        ao.setBackgroundColor(frsVideoActivityViewHolder.bRS, R.color.CAM_X0204);
        ao.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return frsVideoActivityViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final com.baidu.tieba.tbadkCore.q qVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        if (view == null || frsVideoActivityViewHolder == null) {
            return null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12587").dX("fid", ai.this.mForumId));
                com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + ai.this.mForumId, System.currentTimeMillis());
                if (qVar != null && !StringUtils.isNull(qVar.url)) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(ai.this.mContext, qVar.url);
                }
            }
        });
        frsVideoActivityViewHolder.mTitleTv.setText(qVar != null ? qVar.text : "");
        if (go(com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_TIP + this.mForumId, 0L))) {
            frsVideoActivityViewHolder.jqV.setVisibility(0);
        } else {
            frsVideoActivityViewHolder.jqV.setVisibility(8);
        }
        return frsVideoActivityViewHolder.getView();
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
