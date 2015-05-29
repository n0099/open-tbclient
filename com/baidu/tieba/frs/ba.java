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
    private ArrayList<LiveBroadcastCard> aNe;

    /* JADX INFO: Access modifiers changed from: protected */
    public ba(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aNe = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public be a(ViewGroup viewGroup) {
        return new be(com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.frs_live_view_pager_div, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.m mVar, be beVar) {
        int KY;
        int KY2;
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tbadk.core.data.m) beVar);
        bd bdVar = new bd(this, mVar.qJ());
        ch chVar = new ch(V(bdVar.La()));
        beVar.aNo.setAdapter(chVar);
        beVar.aNo.setCurrentItem(bdVar.KZ(), false);
        beVar.aNo.setOnPageChangeListener(new bb(this, bdVar, beVar.aNq, chVar, beVar.aNo));
        beVar.aNo.setOnSingleTouchListener(new bc(this, bdVar, mVar));
        KY = bdVar.KY();
        if (KY > 1) {
            if (beVar.aNq.getVisibility() != 0) {
                beVar.aNq.setVisibility(0);
            }
            IndicatorView indicatorView = beVar.aNq;
            KY2 = bdVar.KY();
            indicatorView.setCount(KY2);
            beVar.aNq.setPosition(0.0f);
        } else if (beVar.aNq.getVisibility() != 8) {
            beVar.aNq.setVisibility(8);
        }
        beVar.aNp.setTag(Integer.valueOf(i));
        beVar.aNu.setTag(Integer.valueOf(i));
        beVar.aNv.setTag(Integer.valueOf(i));
        beVar.aNv.setOnClickListener(this);
        com.baidu.tbadk.core.util.ay.i(beVar.aNv, com.baidu.tieba.p.bg_live_card_up);
        com.baidu.tbadk.core.util.ay.b(beVar.aNr, com.baidu.tieba.n.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ay.i(beVar.aNt, com.baidu.tieba.p.live_frs_list_item_recommend_bottom_bg);
        com.baidu.tbadk.core.util.ay.b(beVar.aNp, com.baidu.tieba.n.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ay.i(beVar.aNs, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.c(beVar.aNu, com.baidu.tieba.p.icon_frs_ba_arrows_live);
        beVar.aNq.setSelector(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.dot_live_s));
        beVar.aNq.setDrawable(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.dot_live_n));
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<LiveBroadcastCard> V(List<LiveCardData> list) {
        if (list != null) {
            this.aNe.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_live_view_pager_item, null);
                this.aNe.add(liveBroadcastCard);
                liveBroadcastCard.setListCard(true);
                liveBroadcastCard.setData(list.get(i));
                liveBroadcastCard.setStatisticsKey("forum_live_ck");
                liveBroadcastCard.onChangeSkinType(this.aMk.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
        return this.aNe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.q.frs_live_upItem && this.aMk.checkUpIsLogin()) {
            com.baidu.tbadk.core.k.A(this.mContext, "all_live_read");
            TiebaStatic.eventStat(this.mContext, "frs_broadcast_detail", "click", 1, new Object[0]);
            if (this.aLl != null && this.aLl.aar() != null && !TextUtils.isEmpty(this.aLl.aar().getId()) && this.aLl.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, this.aLl.aar().getId(), this.aLl.getUserData().getIsManager())));
            }
        }
    }
}
