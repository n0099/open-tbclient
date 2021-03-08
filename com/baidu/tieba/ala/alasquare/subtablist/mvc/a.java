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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import com.baidu.tieba.ala.alasquare.subtablist.view.c;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private String entryName;
    private boolean gKM;
    private c gKN;
    private AlaNewSquareSubListModel gKO;
    private TbPageContext mTbPageContext;
    private boolean gKP = false;
    private BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gKO != null) {
                z = a.this.gKO.isHasMore();
            }
            if (a.this.gKN != null) {
                if (!z) {
                    a.this.gKN.bRD();
                    return;
                }
                a.this.gKO.bSJ();
                a.this.gKN.bSK();
            }
        }
    };
    private AlaNewSquareSubListModel.a gJv = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mK(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gKN != null) {
                a.this.gKN.completePullRefresh();
                a.this.gKN.hideLoadingView();
                a.this.gKN.setData(a.this.gKO.getDatas());
                a.this.gKN.tV(a.this.gKO.getLiveCount());
                a.this.gKN.cl(a.this.gKO.getSortTypeList());
                if (a.this.gKO != null && a.this.gKO.getPn() == 0 && a.this.gKN.getListView() != null) {
                    a.this.gKN.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.gKO.getDatas()) == 0) {
                    a.this.gKN.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gKN.tU(8);
                    return;
                }
                a.this.gKN.Xc();
                a.this.gKN.tU(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aJ(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gKN != null) {
                a.this.gKN.completePullRefresh();
                a.this.gKN.hideLoadingView();
                c cVar = a.this.gKN;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                cVar.a(str, a.this.mOnClickListener, true);
                a.this.gKN.tU(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private g gKQ = new g() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(int i, String str, cb cbVar) {
            a.this.a(a.this.mTbPageContext, cbVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(com.baidu.tieba.ala.alasquare.subtablist.b.c cVar) {
            if (a.this.gKO != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gKO.setSortType(cVar.type);
                a.this.gKO.setLat(cVar.lat);
                a.this.gKO.setLng(cVar.lng);
                a.this.gKO.mN(cVar.gKD);
                a.this.gKO.refreshData();
            }
        }
    };
    private f.c gKR = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gKO != null) {
                a.this.gKO.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gKM = z;
        this.gKO = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gKO.a(this.gJv);
        this.gKN = new c(this.mTbPageContext);
        this.gKN.a(this.gKQ);
        this.gKN.setListPullRefreshListener(this.gKR);
        this.gKN.b(this.Yb);
        this.gKN.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gKP = str.equals("16:9");
            }
            this.gKN.a(this.gKM, list, str2, str3, this.gKP, false);
            this.gKO.setEntryName(str2);
            this.gKO.setLabelName(str3);
            this.gKO.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.gKO.mM(this.gKP);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gKO.refreshData();
    }

    public View getRootView() {
        return this.gKN.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gKN != null) {
            this.gKN.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, cb cbVar, String str) {
        if (tbPageContext != null && cbVar != null && cbVar.bnS() != null && cbVar.bol() != null) {
            ar v = new ar("c12116").v("obj_id", cbVar.bol().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                v.dR("locate_type", this.entryName);
            }
            TiebaStatic.log(v);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnS().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (cb cbVar2 : this.gKO.bSC()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData W(cb cbVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
        alaLiveInfoCoreData.userName = cbVar.bnS().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.gKO != null) {
            this.gKO.onDestroy();
            this.gKO = null;
        }
        if (this.gKN != null) {
            this.gKN.onDestroy();
            this.gKN = null;
        }
    }
}
