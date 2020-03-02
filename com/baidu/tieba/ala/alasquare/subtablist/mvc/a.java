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
    private d etA;
    private AlaNewSquareSubListModel etB;
    private boolean etz;
    private TbPageContext mTbPageContext;
    private boolean etC = false;
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.etB != null) {
                z = a.this.etB.isHasMore();
            }
            if (a.this.etA != null) {
                if (!z) {
                    a.this.etA.bct();
                    return;
                }
                a.this.etB.bdy();
                a.this.etA.bdz();
            }
        }
    };
    private AlaNewSquareSubListModel.a esh = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ie(boolean z) {
            if (a.this.mTbPageContext != null && a.this.etA != null) {
                a.this.etA.completePullRefresh();
                a.this.etA.hideLoadingView();
                a.this.etA.setData(a.this.etB.getDatas());
                a.this.etA.oP(a.this.etB.getLiveCount());
                a.this.etA.bn(a.this.etB.getSortTypeList());
                if (a.this.etB != null && a.this.etB.getPn() == 0 && a.this.etA.getListView() != null) {
                    a.this.etA.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.etB.getDatas()) == 0) {
                    a.this.etA.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.etA.oO(8);
                    return;
                }
                a.this.etA.bcx();
                a.this.etA.oO(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ag(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.etA != null) {
                a.this.etA.completePullRefresh();
                a.this.etA.hideLoadingView();
                d dVar = a.this.etA;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.etA.oO(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i etD = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.etB != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.etB.setSortType(cVar.type);
                a.this.etB.setLat(cVar.lat);
                a.this.etB.setLng(cVar.lng);
                a.this.etB.ih(cVar.etq);
                a.this.etB.refreshData();
            }
        }
    };
    private g.c etE = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.etB != null) {
                a.this.etB.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.etz = z;
        this.etB = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.etB.a(this.esh);
        this.etA = new d(this.mTbPageContext);
        this.etA.a(this.etD);
        this.etA.setListPullRefreshListener(this.etE);
        this.etA.b(this.Az);
        this.etA.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.etC = str.equals("16:9");
            }
            this.etA.a(this.etz, list, str2, str3, this.etC, false);
            this.etB.setEntryName(str2);
            this.etB.setLabelName(str3);
            this.etB.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.etB.ig(this.etC);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.etB.refreshData();
    }

    public View getRootView() {
        return this.etA.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.etA != null) {
            this.etA.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
            an s = new an("c12116").s("obj_id", bjVar.aCH().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.cy("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCo().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.etB.bdp()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
        alaLiveInfoCoreData.userName = bjVar.aCo().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.etB != null) {
            this.etB.onDestroy();
            this.etB = null;
        }
        if (this.etA != null) {
            this.etA.onDestroy();
            this.etA = null;
        }
    }
}
