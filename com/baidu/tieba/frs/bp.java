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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BackupFrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.view.ChildViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bp extends bm<com.baidu.tbadk.core.data.i> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public bp(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View a = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.frs_live_view_pager_div, viewGroup, false);
        bt btVar = new bt(null);
        btVar.aCp = (TextView) a.findViewById(com.baidu.tieba.v.live_title);
        btVar.aCm = (ChildViewPager) a.findViewById(com.baidu.tieba.v.live_title_child);
        btVar.aCo = (IndicatorView) a.findViewById(com.baidu.tieba.v.live_tab_indicator);
        btVar.aCn = (TextView) a.findViewById(com.baidu.tieba.v.live_show_all);
        btVar.aCq = a.findViewById(com.baidu.tieba.v.live_title_card_line);
        btVar.aCr = a.findViewById(com.baidu.tieba.v.middle_layout);
        btVar.aCs = (ImageView) a.findViewById(com.baidu.tieba.v.live_arrow);
        btVar.aCt = (RelativeLayout) a.findViewById(com.baidu.tieba.v.frs_live_upItem);
        a.setTag(btVar);
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.i iVar) {
        int FR;
        int FR2;
        super.b(i, view, viewGroup, iVar);
        bt btVar = (bt) view.getTag();
        bs bsVar = new bs(this, iVar.jY());
        btVar.aCm.setAdapter(new de(D(bsVar.FT())));
        btVar.aCm.setCurrentItem(bsVar.FS(), false);
        IndicatorView indicatorView = btVar.aCo;
        btVar.aCm.setOnPageChangeListener(new bq(this, bsVar, btVar.aCm, indicatorView));
        btVar.aCm.setOnSingleTouchListener(new br(this, bsVar, iVar));
        FR = bsVar.FR();
        if (FR > 1) {
            if (btVar.aCo.getVisibility() != 0) {
                btVar.aCo.setVisibility(0);
            }
            IndicatorView indicatorView2 = btVar.aCo;
            FR2 = bsVar.FR();
            indicatorView2.setCount(FR2);
            btVar.aCo.setPosition(0.0f);
        } else if (btVar.aCo.getVisibility() != 8) {
            btVar.aCo.setVisibility(8);
        }
        btVar.aCn.setTag(Integer.valueOf(i));
        btVar.aCs.setTag(Integer.valueOf(i));
        btVar.aCt.setTag(Integer.valueOf(i));
        btVar.aCt.setOnClickListener(this);
        com.baidu.tbadk.core.util.aw.h(btVar.aCt, com.baidu.tieba.u.bg_live_card_up);
        com.baidu.tbadk.core.util.aw.b(btVar.aCp, com.baidu.tieba.s.cp_cont_c, 1);
        com.baidu.tbadk.core.util.aw.h(btVar.aCr, com.baidu.tieba.u.bg_live_card_middle);
        com.baidu.tbadk.core.util.aw.b(btVar.aCn, com.baidu.tieba.s.cp_cont_c, 1);
        com.baidu.tbadk.core.util.aw.h(btVar.aCq, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.aw.c(btVar.aCs, com.baidu.tieba.u.icon_frs_ba_arrows_live);
        btVar.aCo.setSelector(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.dot_live_s));
        btVar.aCo.setDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.dot_live_n));
        return view;
    }

    private ArrayList<View> D(List<LiveCardData> list) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (list != null) {
            for (LiveCardData liveCardData : list) {
                LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_live_view_pager_item, null);
                liveBroadcastCard.setListCard(true);
                liveBroadcastCard.setData(liveCardData);
                liveBroadcastCard.setStatisticsKey("forum_live_ck");
                liveBroadcastCard.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                arrayList.add(liveBroadcastCard);
            }
        }
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.frs_live_upItem) {
            com.baidu.tbadk.core.i.l(this.mContext, "all_live_read");
            if (this.aBV != null && this.aBV.zJ() != null && !TextUtils.isEmpty(this.aBV.zJ().getId()) && this.aBV.getUserData() != null) {
                if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, this.aBV.zJ().getId(), this.aBV.getUserData().getIsManager())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BackupFrsLiveListActivityConfig(this.mContext, this.aBV.zJ().getId(), this.aBV.getUserData().getIsManager())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bt);
    }
}
