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
    private ArrayList<LiveBroadcastCard> aKN;

    /* JADX INFO: Access modifiers changed from: protected */
    public ba(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aKN = new ArrayList<>();
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
        int JM;
        int JM2;
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tbadk.core.data.m) beVar);
        bd bdVar = new bd(this, mVar.qd());
        beVar.aKW.setAdapter(new ci(S(bdVar.JO())));
        beVar.aKW.setCurrentItem(bdVar.JN(), false);
        IndicatorView indicatorView = beVar.aKY;
        beVar.aKW.setOnPageChangeListener(new bb(this, bdVar, beVar.aKW, indicatorView));
        beVar.aKW.setOnSingleTouchListener(new bc(this, bdVar, mVar));
        JM = bdVar.JM();
        if (JM > 1) {
            if (beVar.aKY.getVisibility() != 0) {
                beVar.aKY.setVisibility(0);
            }
            IndicatorView indicatorView2 = beVar.aKY;
            JM2 = bdVar.JM();
            indicatorView2.setCount(JM2);
            beVar.aKY.setPosition(0.0f);
        } else if (beVar.aKY.getVisibility() != 8) {
            beVar.aKY.setVisibility(8);
        }
        beVar.aKX.setTag(Integer.valueOf(i));
        beVar.aLc.setTag(Integer.valueOf(i));
        beVar.aLd.setTag(Integer.valueOf(i));
        beVar.aLd.setOnClickListener(this);
        com.baidu.tbadk.core.util.ba.i(beVar.aLd, com.baidu.tieba.u.bg_live_card_up);
        com.baidu.tbadk.core.util.ba.b(beVar.aKZ, com.baidu.tieba.s.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ba.i(beVar.aLb, com.baidu.tieba.u.frs_item_control_btn_bg);
        com.baidu.tbadk.core.util.ba.b(beVar.aKX, com.baidu.tieba.s.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ba.i(beVar.aLa, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.c(beVar.aLc, com.baidu.tieba.u.icon_frs_ba_arrows_live);
        beVar.aKY.setSelector(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.dot_live_s));
        beVar.aKY.setDrawable(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.dot_live_n));
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<LiveBroadcastCard> S(List<LiveCardData> list) {
        LiveBroadcastCard liveBroadcastCard;
        if (list != null) {
            int size = this.aKN.size();
            int size2 = list.size();
            for (int i = 0; i < size2; i++) {
                if (size > i) {
                    liveBroadcastCard = this.aKN.get(i);
                } else {
                    liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_live_view_pager_item, null);
                    this.aKN.add(liveBroadcastCard);
                }
                LiveBroadcastCard liveBroadcastCard2 = liveBroadcastCard;
                liveBroadcastCard2.setListCard(true);
                liveBroadcastCard2.setData(list.get(i));
                liveBroadcastCard2.setStatisticsKey("forum_live_ck");
                liveBroadcastCard2.onChangeSkinType(this.aJT.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
        return this.aKN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.frs_live_upItem) {
            com.baidu.tbadk.core.k.A(this.mContext, "all_live_read");
            TiebaStatic.eventStat(this.mContext, "frs_broadcast_detail", "click", 1, new Object[0]);
            if (this.aIV != null && this.aIV.YO() != null && !TextUtils.isEmpty(this.aIV.YO().getId()) && this.aIV.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, this.aIV.YO().getId(), this.aIV.getUserData().getIsManager())));
            }
        }
    }
}
