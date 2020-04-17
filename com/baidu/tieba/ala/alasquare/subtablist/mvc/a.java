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
    private boolean eXD;
    private d eXE;
    private AlaNewSquareSubListModel eXF;
    private String entryName;
    private TbPageContext mTbPageContext;
    private boolean eXG = false;
    private BdListView.e TQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.eXF != null) {
                z = a.this.eXF.isHasMore();
            }
            if (a.this.eXE != null) {
                if (!z) {
                    a.this.eXE.blp();
                    return;
                }
                a.this.eXF.bmv();
                a.this.eXE.bmw();
            }
        }
    };
    private AlaNewSquareSubListModel.a eWm = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jg(boolean z) {
            if (a.this.mTbPageContext != null && a.this.eXE != null) {
                a.this.eXE.completePullRefresh();
                a.this.eXE.hideLoadingView();
                a.this.eXE.setData(a.this.eXF.getDatas());
                a.this.eXE.pk(a.this.eXF.getLiveCount());
                a.this.eXE.bx(a.this.eXF.getSortTypeList());
                if (a.this.eXF != null && a.this.eXF.getPn() == 0 && a.this.eXE.getListView() != null) {
                    a.this.eXE.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.eXF.getDatas()) == 0) {
                    a.this.eXE.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.eXE.pj(8);
                    return;
                }
                a.this.eXE.blt();
                a.this.eXE.pj(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void av(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.eXE != null) {
                a.this.eXE.completePullRefresh();
                a.this.eXE.hideLoadingView();
                d dVar = a.this.eXE;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.eXE.pj(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i eXH = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.eXF != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.eXF.setSortType(cVar.type);
                a.this.eXF.setLat(cVar.lat);
                a.this.eXF.setLng(cVar.lng);
                a.this.eXF.jj(cVar.eXu);
                a.this.eXF.refreshData();
            }
        }
    };
    private g.c eXI = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.eXF != null) {
                a.this.eXF.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.eXD = z;
        this.eXF = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.eXF.a(this.eWm);
        this.eXE = new d(this.mTbPageContext);
        this.eXE.a(this.eXH);
        this.eXE.setListPullRefreshListener(this.eXI);
        this.eXE.b(this.TQ);
        this.eXE.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.eXG = str.equals("16:9");
            }
            this.eXE.a(this.eXD, list, str2, str3, this.eXG, false);
            this.eXF.setEntryName(str2);
            this.eXF.setLabelName(str3);
            this.eXF.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.eXF.ji(this.eXG);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.eXF.refreshData();
    }

    public View getRootView() {
        return this.eXE.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.eXE != null) {
            this.eXE.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aKE() != null && bjVar.aKX() != null) {
            an t = new an("c12116").t("obj_id", bjVar.aKX().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                t.cI("locate_type", this.entryName);
            }
            TiebaStatic.log(t);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.eXF.bmm()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
        alaLiveInfoCoreData.userName = bjVar.aKE().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.eXF != null) {
            this.eXF.onDestroy();
            this.eXF = null;
        }
        if (this.eXE != null) {
            this.eXE.onDestroy();
            this.eXE = null;
        }
    }
}
