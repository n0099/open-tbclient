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
    private ArrayList<LiveBroadcastCard> aEQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public bk(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aEQ = new ArrayList<>();
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View a = com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.frs_live_view_pager_div, viewGroup, false);
        bo boVar = new bo(null);
        boVar.aFc = (TextView) a.findViewById(com.baidu.tieba.w.live_title);
        boVar.aEZ = (ChildViewPager) a.findViewById(com.baidu.tieba.w.live_title_child);
        boVar.aFb = (IndicatorView) a.findViewById(com.baidu.tieba.w.live_tab_indicator);
        boVar.aFa = (TextView) a.findViewById(com.baidu.tieba.w.live_show_all);
        boVar.aFd = a.findViewById(com.baidu.tieba.w.live_title_card_line);
        boVar.aFe = a.findViewById(com.baidu.tieba.w.middle_layout);
        boVar.aFf = (ImageView) a.findViewById(com.baidu.tieba.w.live_arrow);
        boVar.aFg = (RelativeLayout) a.findViewById(com.baidu.tieba.w.frs_live_upItem);
        a.setTag(boVar);
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.m mVar) {
        int Gw;
        int Gw2;
        super.b(i, view, viewGroup, mVar);
        bo boVar = (bo) view.getTag();
        bn bnVar = new bn(this, mVar.mQ());
        boVar.aEZ.setAdapter(new db(P(bnVar.Gy())));
        boVar.aEZ.setCurrentItem(bnVar.Gx(), false);
        IndicatorView indicatorView = boVar.aFb;
        boVar.aEZ.setOnPageChangeListener(new bl(this, bnVar, boVar.aEZ, indicatorView));
        boVar.aEZ.setOnSingleTouchListener(new bm(this, bnVar, mVar));
        Gw = bnVar.Gw();
        if (Gw > 1) {
            if (boVar.aFb.getVisibility() != 0) {
                boVar.aFb.setVisibility(0);
            }
            IndicatorView indicatorView2 = boVar.aFb;
            Gw2 = bnVar.Gw();
            indicatorView2.setCount(Gw2);
            boVar.aFb.setPosition(0.0f);
        } else if (boVar.aFb.getVisibility() != 8) {
            boVar.aFb.setVisibility(8);
        }
        boVar.aFa.setTag(Integer.valueOf(i));
        boVar.aFf.setTag(Integer.valueOf(i));
        boVar.aFg.setTag(Integer.valueOf(i));
        boVar.aFg.setOnClickListener(this);
        com.baidu.tbadk.core.util.bc.i(boVar.aFg, com.baidu.tieba.v.bg_live_card_up);
        com.baidu.tbadk.core.util.bc.b(boVar.aFc, com.baidu.tieba.t.cp_cont_c, 1);
        com.baidu.tbadk.core.util.bc.i(boVar.aFe, com.baidu.tieba.v.live_frs_list_item_recommend_bottom_bg);
        com.baidu.tbadk.core.util.bc.b(boVar.aFa, com.baidu.tieba.t.cp_cont_c, 1);
        com.baidu.tbadk.core.util.bc.i(boVar.aFd, com.baidu.tieba.t.cp_bg_line_b);
        com.baidu.tbadk.core.util.bc.c(boVar.aFf, com.baidu.tieba.v.icon_frs_ba_arrows_live);
        boVar.aFb.setSelector(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.dot_live_s));
        boVar.aFb.setDrawable(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.dot_live_n));
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<LiveBroadcastCard> P(List<LiveCardData> list) {
        LiveBroadcastCard liveBroadcastCard;
        if (list != null) {
            int size = this.aEQ.size();
            int size2 = list.size();
            for (int i = 0; i < size2; i++) {
                if (size > i) {
                    liveBroadcastCard = this.aEQ.get(i);
                } else {
                    liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_live_view_pager_item, null);
                    this.aEQ.add(liveBroadcastCard);
                }
                LiveBroadcastCard liveBroadcastCard2 = liveBroadcastCard;
                liveBroadcastCard2.setListCard(true);
                liveBroadcastCard2.setData(list.get(i));
                liveBroadcastCard2.setStatisticsKey("forum_live_ck");
                liveBroadcastCard2.onChangeSkinType(this.aEd.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            }
        }
        return this.aEQ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.frs_live_upItem) {
            com.baidu.tbadk.core.i.A(this.mContext, "all_live_read");
            if (this.aEI != null && this.aEI.aeN() != null && !TextUtils.isEmpty(this.aEI.aeN().getId()) && this.aEI.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, this.aEI.aeN().getId(), this.aEI.getUserData().getIsManager())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bo);
    }
}
