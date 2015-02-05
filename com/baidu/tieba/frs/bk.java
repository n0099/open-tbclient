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
public class bk extends bh<com.baidu.tbadk.core.data.m> implements View.OnClickListener {
    private ArrayList<LiveBroadcastCard> aEN;

    /* JADX INFO: Access modifiers changed from: protected */
    public bk(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aEN = new ArrayList<>();
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View a = com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.frs_live_view_pager_div, viewGroup, false);
        bo boVar = new bo(null);
        boVar.aEZ = (TextView) a.findViewById(com.baidu.tieba.w.live_title);
        boVar.aEW = (ChildViewPager) a.findViewById(com.baidu.tieba.w.live_title_child);
        boVar.aEY = (IndicatorView) a.findViewById(com.baidu.tieba.w.live_tab_indicator);
        boVar.aEX = (TextView) a.findViewById(com.baidu.tieba.w.live_show_all);
        boVar.aFa = a.findViewById(com.baidu.tieba.w.live_title_card_line);
        boVar.aFb = a.findViewById(com.baidu.tieba.w.middle_layout);
        boVar.aFc = (ImageView) a.findViewById(com.baidu.tieba.w.live_arrow);
        boVar.aFd = (RelativeLayout) a.findViewById(com.baidu.tieba.w.frs_live_upItem);
        a.setTag(boVar);
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.m mVar) {
        int Gq;
        int Gq2;
        super.b(i, view, viewGroup, mVar);
        bo boVar = (bo) view.getTag();
        bn bnVar = new bn(this, mVar.mJ());
        boVar.aEW.setAdapter(new db(P(bnVar.Gs())));
        boVar.aEW.setCurrentItem(bnVar.Gr(), false);
        IndicatorView indicatorView = boVar.aEY;
        boVar.aEW.setOnPageChangeListener(new bl(this, bnVar, boVar.aEW, indicatorView));
        boVar.aEW.setOnSingleTouchListener(new bm(this, bnVar, mVar));
        Gq = bnVar.Gq();
        if (Gq > 1) {
            if (boVar.aEY.getVisibility() != 0) {
                boVar.aEY.setVisibility(0);
            }
            IndicatorView indicatorView2 = boVar.aEY;
            Gq2 = bnVar.Gq();
            indicatorView2.setCount(Gq2);
            boVar.aEY.setPosition(0.0f);
        } else if (boVar.aEY.getVisibility() != 8) {
            boVar.aEY.setVisibility(8);
        }
        boVar.aEX.setTag(Integer.valueOf(i));
        boVar.aFc.setTag(Integer.valueOf(i));
        boVar.aFd.setTag(Integer.valueOf(i));
        boVar.aFd.setOnClickListener(this);
        com.baidu.tbadk.core.util.bc.i(boVar.aFd, com.baidu.tieba.v.bg_live_card_up);
        com.baidu.tbadk.core.util.bc.b(boVar.aEZ, com.baidu.tieba.t.cp_cont_c, 1);
        com.baidu.tbadk.core.util.bc.i(boVar.aFb, com.baidu.tieba.v.live_frs_list_item_recommend_bottom_bg);
        com.baidu.tbadk.core.util.bc.b(boVar.aEX, com.baidu.tieba.t.cp_cont_c, 1);
        com.baidu.tbadk.core.util.bc.i(boVar.aFa, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.c(boVar.aFc, com.baidu.tieba.v.icon_frs_ba_arrows_live);
        boVar.aEY.setSelector(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.dot_live_s));
        boVar.aEY.setDrawable(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.dot_live_n));
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<LiveBroadcastCard> P(List<LiveCardData> list) {
        LiveBroadcastCard liveBroadcastCard;
        if (list != null) {
            int size = this.aEN.size();
            int size2 = list.size();
            for (int i = 0; i < size2; i++) {
                if (size > i) {
                    liveBroadcastCard = this.aEN.get(i);
                } else {
                    liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_live_view_pager_item, null);
                    this.aEN.add(liveBroadcastCard);
                }
                LiveBroadcastCard liveBroadcastCard2 = liveBroadcastCard;
                liveBroadcastCard2.setListCard(true);
                liveBroadcastCard2.setData(list.get(i));
                liveBroadcastCard2.setStatisticsKey("forum_live_ck");
                liveBroadcastCard2.onChangeSkinType(this.aEa.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            }
        }
        return this.aEN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.frs_live_upItem) {
            com.baidu.tbadk.core.i.A(this.mContext, "all_live_read");
            if (this.aEF != null && this.aEF.aeI() != null && !TextUtils.isEmpty(this.aEF.aeI().getId()) && this.aEF.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, this.aEF.aeI().getId(), this.aEF.getUserData().getIsManager())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bo);
    }
}
