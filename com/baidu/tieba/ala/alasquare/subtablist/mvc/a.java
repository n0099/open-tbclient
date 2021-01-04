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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import com.baidu.tieba.ala.alasquare.subtablist.view.c;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private String entryName;
    private boolean gKL;
    private c gKM;
    private AlaNewSquareSubListModel gKN;
    private TbPageContext mTbPageContext;
    private boolean gKO = false;
    private BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gKN != null) {
                z = a.this.gKN.isHasMore();
            }
            if (a.this.gKM != null) {
                if (!z) {
                    a.this.gKM.bUD();
                    return;
                }
                a.this.gKN.bVK();
                a.this.gKM.bVL();
            }
        }
    };
    private AlaNewSquareSubListModel.a gJu = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mK(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gKM != null) {
                a.this.gKM.completePullRefresh();
                a.this.gKM.hideLoadingView();
                a.this.gKM.setData(a.this.gKN.getDatas());
                a.this.gKM.vt(a.this.gKN.getLiveCount());
                a.this.gKM.cq(a.this.gKN.getSortTypeList());
                if (a.this.gKN != null && a.this.gKN.getPn() == 0 && a.this.gKM.getListView() != null) {
                    a.this.gKM.getListView().smoothScrollToPosition(0);
                }
                if (x.getCount(a.this.gKN.getDatas()) == 0) {
                    a.this.gKM.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gKM.vs(8);
                    return;
                }
                a.this.gKM.Zi();
                a.this.gKM.vs(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aE(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gKM != null) {
                a.this.gKM.completePullRefresh();
                a.this.gKM.hideLoadingView();
                c cVar = a.this.gKM;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                cVar.a(str, a.this.mOnClickListener, true);
                a.this.gKM.vs(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private g gKP = new g() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(int i, String str, bz bzVar) {
            a.this.a(a.this.mTbPageContext, bzVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(com.baidu.tieba.ala.alasquare.subtablist.b.c cVar) {
            if (a.this.gKN != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gKN.setSortType(cVar.type);
                a.this.gKN.setLat(cVar.lat);
                a.this.gKN.setLng(cVar.lng);
                a.this.gKN.mN(cVar.gKC);
                a.this.gKN.refreshData();
            }
        }
    };
    private f.c gKQ = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gKN != null) {
                a.this.gKN.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gKL = z;
        this.gKN = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gKN.a(this.gJu);
        this.gKM = new c(this.mTbPageContext);
        this.gKM.a(this.gKP);
        this.gKM.setListPullRefreshListener(this.gKQ);
        this.gKM.b(this.WN);
        this.gKM.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gKO = str.equals("16:9");
            }
            this.gKM.a(this.gKL, list, str2, str3, this.gKO, false);
            this.gKN.setEntryName(str2);
            this.gKN.setLabelName(str3);
            this.gKN.setSortType(x.isEmpty(list) ? "" : list.get(0));
            this.gKN.mM(this.gKO);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gKN.refreshData();
    }

    public View getRootView() {
        return this.gKM.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gKM != null) {
            this.gKM.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bz bzVar, String str) {
        if (tbPageContext != null && bzVar != null && bzVar.brq() != null && bzVar.brJ() != null) {
            aq w = new aq("c12116").w("obj_id", bzVar.brJ().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                w.dX("locate_type", this.entryName);
            }
            TiebaStatic.log(w);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.brq().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bz bzVar2 : this.gKN.bVD()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
        alaLiveInfoCoreData.userName = bzVar.brq().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.gKN != null) {
            this.gKN.onDestroy();
            this.gKN = null;
        }
        if (this.gKM != null) {
            this.gKM.onDestroy();
            this.gKM = null;
        }
    }
}
