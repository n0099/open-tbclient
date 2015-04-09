package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ba extends av<com.baidu.tbadk.core.data.m, be> implements View.OnClickListener {
    private ArrayList<LiveBroadcastCard> aKX;
    private FrsActivity aKd;

    /* JADX INFO: Access modifiers changed from: protected */
    public ba(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aKX = new ArrayList<>();
        this.aKd = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public be a(ViewGroup viewGroup) {
        return new be(com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.frs_live_view_pager_div, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.m mVar, be beVar) {
        int JT;
        int JT2;
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tbadk.core.data.m) beVar);
        bd bdVar = new bd(this, mVar.qd());
        beVar.aLg.setAdapter(new ci(S(bdVar.JV())));
        beVar.aLg.setCurrentItem(bdVar.JU(), false);
        IndicatorView indicatorView = beVar.aLi;
        beVar.aLg.setOnPageChangeListener(new bb(this, bdVar, beVar.aLg, indicatorView));
        beVar.aLg.setOnSingleTouchListener(new bc(this, bdVar, mVar));
        JT = bdVar.JT();
        if (JT > 1) {
            if (beVar.aLi.getVisibility() != 0) {
                beVar.aLi.setVisibility(0);
            }
            IndicatorView indicatorView2 = beVar.aLi;
            JT2 = bdVar.JT();
            indicatorView2.setCount(JT2);
            beVar.aLi.setPosition(0.0f);
        } else if (beVar.aLi.getVisibility() != 8) {
            beVar.aLi.setVisibility(8);
        }
        beVar.aLh.setTag(Integer.valueOf(i));
        beVar.aLm.setTag(Integer.valueOf(i));
        beVar.aLn.setTag(Integer.valueOf(i));
        beVar.aLn.setOnClickListener(this);
        com.baidu.tbadk.core.util.ba.i(beVar.aLn, com.baidu.tieba.u.bg_live_card_up);
        com.baidu.tbadk.core.util.ba.b(beVar.aLj, com.baidu.tieba.s.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ba.i(beVar.aLl, com.baidu.tieba.u.frs_item_control_btn_bg);
        com.baidu.tbadk.core.util.ba.b(beVar.aLh, com.baidu.tieba.s.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ba.i(beVar.aLk, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.c(beVar.aLm, com.baidu.tieba.u.icon_frs_ba_arrows_live);
        beVar.aLi.setSelector(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.dot_live_s));
        beVar.aLi.setDrawable(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.dot_live_n));
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<LiveBroadcastCard> S(List<LiveCardData> list) {
        LiveBroadcastCard liveBroadcastCard;
        if (list != null) {
            int size = this.aKX.size();
            int size2 = list.size();
            for (int i = 0; i < size2; i++) {
                if (size > i) {
                    liveBroadcastCard = this.aKX.get(i);
                } else {
                    liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_live_view_pager_item, null);
                    this.aKX.add(liveBroadcastCard);
                }
                LiveBroadcastCard liveBroadcastCard2 = liveBroadcastCard;
                liveBroadcastCard2.setListCard(true);
                liveBroadcastCard2.setData(list.get(i));
                liveBroadcastCard2.setStatisticsKey("forum_live_ck");
                liveBroadcastCard2.onChangeSkinType(this.aKd.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
        return this.aKX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.frs_live_upItem) {
            com.baidu.tbadk.core.k.A(this.mContext, "all_live_read");
            TiebaStatic.eventStat(this.mContext, "frs_broadcast_detail", "click", 1, new Object[0]);
            if (this.aJd != null && this.aJd.Za() != null && !TextUtils.isEmpty(this.aJd.Za().getId()) && this.aJd.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, this.aJd.Za().getId(), this.aJd.getUserData().getIsManager())));
            }
        }
    }
}
