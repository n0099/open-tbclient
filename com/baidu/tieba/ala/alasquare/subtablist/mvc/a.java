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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private String entryName;
    private boolean fvQ;
    private d fvR;
    private AlaNewSquareSubListModel fvS;
    private TbPageContext mTbPageContext;
    private boolean fvT = false;
    private BdListView.e UJ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.fvS != null) {
                z = a.this.fvS.isHasMore();
            }
            if (a.this.fvR != null) {
                if (!z) {
                    a.this.fvR.btI();
                    return;
                }
                a.this.fvS.buP();
                a.this.fvR.buQ();
            }
        }
    };
    private AlaNewSquareSubListModel.a fuz = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jM(boolean z) {
            if (a.this.mTbPageContext != null && a.this.fvR != null) {
                a.this.fvR.completePullRefresh();
                a.this.fvR.hideLoadingView();
                a.this.fvR.setData(a.this.fvS.getDatas());
                a.this.fvR.qm(a.this.fvS.getLiveCount());
                a.this.fvR.bB(a.this.fvS.getSortTypeList());
                if (a.this.fvS != null && a.this.fvS.getPn() == 0 && a.this.fvR.getListView() != null) {
                    a.this.fvR.getListView().smoothScrollToPosition(0);
                }
                if (w.getCount(a.this.fvS.getDatas()) == 0) {
                    a.this.fvR.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.fvR.ql(8);
                    return;
                }
                a.this.fvR.btN();
                a.this.fvR.ql(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void an(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.fvR != null) {
                a.this.fvR.completePullRefresh();
                a.this.fvR.hideLoadingView();
                d dVar = a.this.fvR;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.fvR.ql(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i fvU = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bu buVar) {
            a.this.a(a.this.mTbPageContext, buVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.fvS != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.fvS.setSortType(cVar.type);
                a.this.fvS.setLat(cVar.lat);
                a.this.fvS.setLng(cVar.lng);
                a.this.fvS.jP(cVar.fvH);
                a.this.fvS.refreshData();
            }
        }
    };
    private f.c fvV = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.fvS != null) {
                a.this.fvS.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fvQ = z;
        this.fvS = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.fvS.a(this.fuz);
        this.fvR = new d(this.mTbPageContext);
        this.fvR.a(this.fvU);
        this.fvR.setListPullRefreshListener(this.fvV);
        this.fvR.b(this.UJ);
        this.fvR.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.fvT = str.equals("16:9");
            }
            this.fvR.a(this.fvQ, list, str2, str3, this.fvT, false);
            this.fvS.setEntryName(str2);
            this.fvS.setLabelName(str3);
            this.fvS.setSortType(w.isEmpty(list) ? "" : list.get(0));
            this.fvS.jO(this.fvT);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.fvS.refreshData();
    }

    public View getRootView() {
        return this.fvR.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.fvR != null) {
            this.fvR.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bu buVar, String str) {
        if (tbPageContext != null && buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            ao s = new ao("c12116").s("obj_id", buVar.aSJ().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.dk("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = buVar.aSp().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bu buVar2 : this.fvS.buG()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(buVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bu buVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
        alaLiveInfoCoreData.userName = buVar.aSp().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.fvS != null) {
            this.fvS.onDestroy();
            this.fvS = null;
        }
        if (this.fvR != null) {
            this.fvR.onDestroy();
            this.fvR = null;
        }
    }
}
