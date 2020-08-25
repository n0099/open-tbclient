package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private String entryName;
    private boolean fMp;
    private d fMq;
    private AlaNewSquareSubListModel fMr;
    private TbPageContext mTbPageContext;
    private boolean fMs = false;
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.fMr != null) {
                z = a.this.fMr.isHasMore();
            }
            if (a.this.fMq != null) {
                if (!z) {
                    a.this.fMq.bFR();
                    return;
                }
                a.this.fMr.bGY();
                a.this.fMq.bGZ();
            }
        }
    };
    private AlaNewSquareSubListModel.a fKY = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void kO(boolean z) {
            if (a.this.mTbPageContext != null && a.this.fMq != null) {
                a.this.fMq.completePullRefresh();
                a.this.fMq.hideLoadingView();
                a.this.fMq.setData(a.this.fMr.getDatas());
                a.this.fMq.sN(a.this.fMr.getLiveCount());
                a.this.fMq.bG(a.this.fMr.getSortTypeList());
                if (a.this.fMr != null && a.this.fMr.getPn() == 0 && a.this.fMq.getListView() != null) {
                    a.this.fMq.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.fMr.getDatas()) == 0) {
                    a.this.fMq.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.fMq.sM(8);
                    return;
                }
                a.this.fMq.bFW();
                a.this.fMq.sM(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void am(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.fMq != null) {
                a.this.fMq.completePullRefresh();
                a.this.fMq.hideLoadingView();
                d dVar = a.this.fMq;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.fMq.sM(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i fMt = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            a.this.a(a.this.mTbPageContext, bwVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.fMr != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.fMr.setSortType(cVar.type);
                a.this.fMr.setLat(cVar.lat);
                a.this.fMr.setLng(cVar.lng);
                a.this.fMr.kR(cVar.fMg);
                a.this.fMr.refreshData();
            }
        }
    };
    private f.c fMu = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.fMr != null) {
                a.this.fMr.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fMp = z;
        this.fMr = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.fMr.a(this.fKY);
        this.fMq = new d(this.mTbPageContext);
        this.fMq.a(this.fMt);
        this.fMq.setListPullRefreshListener(this.fMu);
        this.fMq.b(this.Vh);
        this.fMq.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.fMs = str.equals("16:9");
            }
            this.fMq.a(this.fMp, list, str2, str3, this.fMs, false);
            this.fMr.setEntryName(str2);
            this.fMr.setLabelName(str3);
            this.fMr.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.fMr.kQ(this.fMs);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.fMr.refreshData();
    }

    public View getRootView() {
        return this.fMq.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.fMq != null) {
            this.fMq.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            aq u = new aq("c12116").u("obj_id", bwVar.beY().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                u.dD("locate_type", this.entryName);
            }
            TiebaStatic.log(u);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.fMr.bGP()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bwVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
        alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.fMr != null) {
            this.fMr.onDestroy();
            this.fMr = null;
        }
        if (this.fMq != null) {
            this.fMq.onDestroy();
            this.fMq = null;
        }
    }
}
