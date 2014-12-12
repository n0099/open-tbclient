package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.tbadkCore.ChildViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bl extends bi<com.baidu.tbadk.core.data.l> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public bl(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View a = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.frs_live_view_pager_div, viewGroup, false);
        bp bpVar = new bp(null);
        bpVar.aEa = (TextView) a.findViewById(com.baidu.tieba.w.live_title);
        bpVar.aDX = (ChildViewPager) a.findViewById(com.baidu.tieba.w.live_title_child);
        bpVar.aDZ = (IndicatorView) a.findViewById(com.baidu.tieba.w.live_tab_indicator);
        bpVar.aDY = (TextView) a.findViewById(com.baidu.tieba.w.live_show_all);
        bpVar.aEb = a.findViewById(com.baidu.tieba.w.live_title_card_line);
        bpVar.aEc = a.findViewById(com.baidu.tieba.w.middle_layout);
        bpVar.aEd = (ImageView) a.findViewById(com.baidu.tieba.w.live_arrow);
        bpVar.aEe = (RelativeLayout) a.findViewById(com.baidu.tieba.w.frs_live_upItem);
        a.setTag(bpVar);
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bi, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.l lVar) {
        int FZ;
        int FZ2;
        super.b(i, view, viewGroup, lVar);
        bp bpVar = (bp) view.getTag();
        bo boVar = new bo(this, lVar.mO());
        bpVar.aDX.setAdapter(new da(N(boVar.Gb())));
        bpVar.aDX.setCurrentItem(boVar.Ga(), false);
        IndicatorView indicatorView = bpVar.aDZ;
        bpVar.aDX.setOnPageChangeListener(new bm(this, boVar, bpVar.aDX, indicatorView));
        bpVar.aDX.setOnSingleTouchListener(new bn(this, boVar, lVar));
        FZ = boVar.FZ();
        if (FZ > 1) {
            if (bpVar.aDZ.getVisibility() != 0) {
                bpVar.aDZ.setVisibility(0);
            }
            IndicatorView indicatorView2 = bpVar.aDZ;
            FZ2 = boVar.FZ();
            indicatorView2.setCount(FZ2);
            bpVar.aDZ.setPosition(0.0f);
        } else if (bpVar.aDZ.getVisibility() != 8) {
            bpVar.aDZ.setVisibility(8);
        }
        bpVar.aDY.setTag(Integer.valueOf(i));
        bpVar.aEd.setTag(Integer.valueOf(i));
        bpVar.aEe.setTag(Integer.valueOf(i));
        bpVar.aEe.setOnClickListener(this);
        com.baidu.tbadk.core.util.ax.i(bpVar.aEe, com.baidu.tieba.v.bg_live_card_up);
        com.baidu.tbadk.core.util.ax.b(bpVar.aEa, com.baidu.tieba.t.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ax.i(bpVar.aEc, com.baidu.tieba.v.live_frs_list_item_recommend_bottom_bg);
        com.baidu.tbadk.core.util.ax.b(bpVar.aDY, com.baidu.tieba.t.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ax.i(bpVar.aEb, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.ax.c(bpVar.aEd, com.baidu.tieba.v.icon_frs_ba_arrows_live);
        bpVar.aDZ.setSelector(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.dot_live_s));
        bpVar.aDZ.setDrawable(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.dot_live_n));
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<View> N(List<LiveCardData> list) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (list != null) {
            for (LiveCardData liveCardData : list) {
                LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_live_view_pager_item, null);
                liveBroadcastCard.setListCard(true);
                liveBroadcastCard.setData(liveCardData);
                liveBroadcastCard.setStatisticsKey("forum_live_ck");
                liveBroadcastCard.onChangeSkinType(this.aDc.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
                arrayList.add(liveBroadcastCard);
            }
        }
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.frs_live_upItem) {
            com.baidu.tbadk.core.i.B(this.mContext, "all_live_read");
            if (this.aDH != null && this.aDH.aej() != null && !TextUtils.isEmpty(this.aDH.aej().getId()) && this.aDH.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, this.aDH.aej().getId(), this.aDH.getUserData().getIsManager())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bp);
    }
}
