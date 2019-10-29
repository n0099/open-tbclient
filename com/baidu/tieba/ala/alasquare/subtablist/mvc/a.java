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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private boolean dDS;
    private d dDT;
    private AlaNewSquareSubListModel dDU;
    private String entryName;
    private TbPageContext mTbPageContext;
    private boolean dDV = false;
    private BdListView.e ye = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.dDU != null) {
                z = a.this.dDU.isHasMore();
            }
            if (a.this.dDT != null) {
                if (!z) {
                    a.this.dDT.aJk();
                    return;
                }
                a.this.dDU.aKp();
                a.this.dDT.aKq();
            }
        }
    };
    private AlaNewSquareSubListModel.a dCL = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void gI(boolean z) {
            if (a.this.mTbPageContext != null && a.this.dDT != null) {
                a.this.dDT.completePullRefresh();
                a.this.dDT.hideLoadingView();
                a.this.dDT.setData(a.this.dDU.getDatas());
                a.this.dDT.mp(a.this.dDU.getLiveCount());
                a.this.dDT.bo(a.this.dDU.getSortTypeList());
                if (a.this.dDU != null && a.this.dDU.getPn() == 0 && a.this.dDT.getListView() != null) {
                    a.this.dDT.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.dDU.getDatas()) == 0) {
                    a.this.dDT.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.dDT.mo(8);
                    return;
                }
                a.this.dDT.aJo();
                a.this.dDT.mo(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void P(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.dDT != null) {
                a.this.dDT.completePullRefresh();
                a.this.dDT.hideLoadingView();
                d dVar = a.this.dDT;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.dDT.mo(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private h dDW = new h() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(int i, String str, bh bhVar) {
            a.this.a(a.this.mTbPageContext, bhVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(c cVar) {
            if (a.this.dDU != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.dDU.setSortType(cVar.type);
                a.this.dDU.setLat(cVar.lat);
                a.this.dDU.setLng(cVar.lng);
                a.this.dDU.gL(cVar.dDJ);
                a.this.dDU.refreshData();
            }
        }
    };
    private h.c dDX = new h.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (a.this.dDU != null) {
                a.this.dDU.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.dDS = z;
        this.dDU = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.dDU.a(this.dCL);
        this.dDT = new d(this.mTbPageContext);
        this.dDT.a(this.dDW);
        this.dDT.setListPullRefreshListener(this.dDX);
        this.dDT.b(this.ye);
        this.dDT.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.dDV = str.equals("16:9");
            }
            this.dDT.a(this.dDS, list, str2, str3, this.dDV, false);
            this.dDU.setEntryName(str2);
            this.dDU.setLabelName(str3);
            this.dDU.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.dDU.gK(this.dDV);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.dDU.refreshData();
    }

    public View getRootView() {
        return this.dDT.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.dDT != null) {
            this.dDT.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bh bhVar, String str) {
        if (tbPageContext != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
            an p = new an("c12116").p("obj_id", bhVar.aiZ().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                p.bS("locate_type", this.entryName);
            }
            TiebaStatic.log(p);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiG().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bh bhVar2 : this.dDU.aKg()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
        alaLiveInfoCoreData.userName = bhVar.aiG().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.dDU != null) {
            this.dDU.onDestroy();
            this.dDU = null;
        }
        if (this.dDT != null) {
            this.dDT.onDestroy();
            this.dDT = null;
        }
    }
}
