package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.frs.live.PhotoLiveBroadcastCard;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bh extends bc<com.baidu.tbadk.core.data.l, bk> implements View.OnClickListener {
    private ArrayList<View> aWz;

    /* JADX INFO: Access modifiers changed from: protected */
    public bh(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aWz = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: h */
    public bk a(ViewGroup viewGroup) {
        return new bk(LayoutInflater.from(this.mContext).inflate(i.g.frs_live_view_pager_div, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.l lVar, bk bkVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tbadk.core.data.l) bkVar);
        a aVar = new a(lVar.rL());
        dd ddVar = new dd(V(aVar.LP()));
        bkVar.aWJ.setAdapter(ddVar);
        bkVar.aWJ.setCurrentItem(aVar.LO(), false);
        bkVar.aWJ.setOnPageChangeListener(new bi(this, aVar, bkVar.aWL, ddVar, bkVar.aWJ));
        bkVar.aWJ.setOnSingleTouchListener(new bj(this, aVar, lVar));
        if (aVar.LN() > 1) {
            if (bkVar.aWL.getVisibility() != 0) {
                bkVar.aWL.setVisibility(0);
            }
            bkVar.aWL.setCount(aVar.LN());
            bkVar.aWL.setPosition(0.0f);
        } else if (bkVar.aWL.getVisibility() != 8) {
            bkVar.aWL.setVisibility(8);
        }
        bkVar.aWK.setTag(Integer.valueOf(i));
        bkVar.aWP.setTag(Integer.valueOf(i));
        bkVar.aWQ.setTag(Integer.valueOf(i));
        bkVar.aWQ.setOnClickListener(this);
        com.baidu.tbadk.core.util.al.i(bkVar.aWQ, i.e.frs_item_control_btn_bg);
        com.baidu.tbadk.core.util.al.b(bkVar.aWM, i.c.cp_cont_c, 1);
        com.baidu.tbadk.core.util.al.i(bkVar.aWO, i.e.frs_item_control_btn_bg);
        com.baidu.tbadk.core.util.al.b(bkVar.aWK, i.c.cp_cont_c, 1);
        com.baidu.tbadk.core.util.al.i(bkVar.aWN, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.c(bkVar.aWP, i.e.icon_frs_ba_arrows);
        bkVar.aWL.setSelector(com.baidu.tbadk.core.util.al.getDrawable(i.e.dot_live_s));
        bkVar.aWL.setDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.dot_live_n));
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private List<LiveCardData> aWG;
        private List<LiveCardData> aWH;
        private final boolean aWI;

        public a(List<LiveCardData> list) {
            this.aWG = list;
            if (list != null && list.size() > 1) {
                this.aWI = true;
            } else {
                this.aWI = false;
            }
            this.aWH = W(this.aWG);
        }

        private List<LiveCardData> W(List<LiveCardData> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
                if (this.aWI && list.size() >= 1) {
                    arrayList.add(0, list.get(list.size() - 1));
                    arrayList.add(list.get(0));
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fl(int i) {
            if (this.aWI) {
                int size = this.aWH.size();
                if (i == 0) {
                    return size - 2;
                }
                if (i == size - 1) {
                    return 1;
                }
                return i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fm(int i) {
            if (this.aWI) {
                return i - 1;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int LN() {
            if (this.aWG == null) {
                return 0;
            }
            return this.aWG.size();
        }

        public int LO() {
            return this.aWI ? 1 : 0;
        }

        public List<LiveCardData> LP() {
            return this.aWH;
        }
    }

    private ArrayList<View> V(List<LiveCardData> list) {
        if (list != null) {
            this.aWz.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LiveCardData liveCardData = list.get(i);
                if (liveCardData.getType() == 33) {
                    PhotoLiveBroadcastCard photoLiveBroadcastCard = (PhotoLiveBroadcastCard) LayoutInflater.from(this.mContext).inflate(i.g.frs_photolive_view_pager_item, (ViewGroup) null);
                    this.aWz.add(photoLiveBroadcastCard);
                    photoLiveBroadcastCard.setData(list.get(i));
                    photoLiveBroadcastCard.onChangeSkinType(this.aSJ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
                } else {
                    LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) LayoutInflater.from(this.mContext).inflate(i.g.frs_live_view_pager_item, (ViewGroup) null);
                    this.aWz.add(liveBroadcastCard);
                    liveBroadcastCard.setListCard(true);
                    liveBroadcastCard.setData(liveCardData);
                    liveBroadcastCard.setStatisticsKey("forum_live_ck");
                    liveBroadcastCard.onChangeSkinType(this.aSJ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
                }
            }
        }
        return this.aWz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.frs_live_upItem && this.aSJ.checkUpIsLogin()) {
            TiebaStatic.log("all_live_read");
            TiebaStatic.eventStat(this.mContext, "frs_broadcast_detail", "click", 1, new Object[0]);
            if (this.aUy != null && this.aUy.acG() != null && !TextUtils.isEmpty(this.aUy.acG().getId()) && this.aUy.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsLiveListActivityConfig(this.mContext, this.aUy.acG().getId(), this.aUy.getUserData().getIsManager())));
            }
        }
    }
}
