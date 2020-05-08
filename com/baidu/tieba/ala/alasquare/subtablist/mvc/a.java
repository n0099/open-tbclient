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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private boolean eXI;
    private d eXJ;
    private AlaNewSquareSubListModel eXK;
    private String entryName;
    private TbPageContext mTbPageContext;
    private boolean eXL = false;
    private BdListView.e TT = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.eXK != null) {
                z = a.this.eXK.isHasMore();
            }
            if (a.this.eXJ != null) {
                if (!z) {
                    a.this.eXJ.bln();
                    return;
                }
                a.this.eXK.bmt();
                a.this.eXJ.bmu();
            }
        }
    };
    private AlaNewSquareSubListModel.a eWr = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jg(boolean z) {
            if (a.this.mTbPageContext != null && a.this.eXJ != null) {
                a.this.eXJ.completePullRefresh();
                a.this.eXJ.hideLoadingView();
                a.this.eXJ.setData(a.this.eXK.getDatas());
                a.this.eXJ.pk(a.this.eXK.getLiveCount());
                a.this.eXJ.bx(a.this.eXK.getSortTypeList());
                if (a.this.eXK != null && a.this.eXK.getPn() == 0 && a.this.eXJ.getListView() != null) {
                    a.this.eXJ.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.eXK.getDatas()) == 0) {
                    a.this.eXJ.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.eXJ.pj(8);
                    return;
                }
                a.this.eXJ.blr();
                a.this.eXJ.pj(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void av(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.eXJ != null) {
                a.this.eXJ.completePullRefresh();
                a.this.eXJ.hideLoadingView();
                d dVar = a.this.eXJ;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.eXJ.pj(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i eXM = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.eXK != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.eXK.setSortType(cVar.type);
                a.this.eXK.setLat(cVar.lat);
                a.this.eXK.setLng(cVar.lng);
                a.this.eXK.jj(cVar.eXz);
                a.this.eXK.refreshData();
            }
        }
    };
    private g.c eXN = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.eXK != null) {
                a.this.eXK.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.eXI = z;
        this.eXK = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.eXK.a(this.eWr);
        this.eXJ = new d(this.mTbPageContext);
        this.eXJ.a(this.eXM);
        this.eXJ.setListPullRefreshListener(this.eXN);
        this.eXJ.b(this.TT);
        this.eXJ.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.eXL = str.equals("16:9");
            }
            this.eXJ.a(this.eXI, list, str2, str3, this.eXL, false);
            this.eXK.setEntryName(str2);
            this.eXK.setLabelName(str3);
            this.eXK.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.eXK.ji(this.eXL);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.eXK.refreshData();
    }

    public View getRootView() {
        return this.eXJ.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.eXJ != null) {
            this.eXJ.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aKC() != null && bjVar.aKV() != null) {
            an t = new an("c12116").t("obj_id", bjVar.aKV().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                t.cI("locate_type", this.entryName);
            }
            TiebaStatic.log(t);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKC().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKV());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.eXK.bmk()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aKV());
        alaLiveInfoCoreData.userName = bjVar.aKC().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.eXK != null) {
            this.eXK.onDestroy();
            this.eXK = null;
        }
        if (this.eXJ != null) {
            this.eXJ.onDestroy();
            this.eXJ = null;
        }
    }
}
