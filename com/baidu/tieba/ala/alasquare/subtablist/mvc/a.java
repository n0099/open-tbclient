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
    private String entryName;
    private AlaNewSquareSubListModel etA;
    private boolean ety;
    private d etz;
    private TbPageContext mTbPageContext;
    private boolean etB = false;
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.etA != null) {
                z = a.this.etA.isHasMore();
            }
            if (a.this.etz != null) {
                if (!z) {
                    a.this.etz.bcr();
                    return;
                }
                a.this.etA.bdw();
                a.this.etz.bdx();
            }
        }
    };
    private AlaNewSquareSubListModel.a esg = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ie(boolean z) {
            if (a.this.mTbPageContext != null && a.this.etz != null) {
                a.this.etz.completePullRefresh();
                a.this.etz.hideLoadingView();
                a.this.etz.setData(a.this.etA.getDatas());
                a.this.etz.oP(a.this.etA.getLiveCount());
                a.this.etz.bn(a.this.etA.getSortTypeList());
                if (a.this.etA != null && a.this.etA.getPn() == 0 && a.this.etz.getListView() != null) {
                    a.this.etz.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.etA.getDatas()) == 0) {
                    a.this.etz.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.etz.oO(8);
                    return;
                }
                a.this.etz.bcv();
                a.this.etz.oO(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ag(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.etz != null) {
                a.this.etz.completePullRefresh();
                a.this.etz.hideLoadingView();
                d dVar = a.this.etz;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.etz.oO(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i etC = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.etA != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.etA.setSortType(cVar.type);
                a.this.etA.setLat(cVar.lat);
                a.this.etA.setLng(cVar.lng);
                a.this.etA.ih(cVar.etp);
                a.this.etA.refreshData();
            }
        }
    };
    private g.c etD = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.etA != null) {
                a.this.etA.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.ety = z;
        this.etA = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.etA.a(this.esg);
        this.etz = new d(this.mTbPageContext);
        this.etz.a(this.etC);
        this.etz.setListPullRefreshListener(this.etD);
        this.etz.b(this.Az);
        this.etz.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.etB = str.equals("16:9");
            }
            this.etz.a(this.ety, list, str2, str3, this.etB, false);
            this.etA.setEntryName(str2);
            this.etA.setLabelName(str3);
            this.etA.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.etA.ig(this.etB);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.etA.refreshData();
    }

    public View getRootView() {
        return this.etz.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.etz != null) {
            this.etz.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aCm() != null && bjVar.aCF() != null) {
            an s = new an("c12116").s("obj_id", bjVar.aCF().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.cy("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCm().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.etA.bdn()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
        alaLiveInfoCoreData.userName = bjVar.aCm().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.etA != null) {
            this.etA.onDestroy();
            this.etA = null;
        }
        if (this.etz != null) {
            this.etz.onDestroy();
            this.etz = null;
        }
    }
}
