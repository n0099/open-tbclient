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
/* loaded from: classes10.dex */
public class a {
    private String entryName;
    private boolean gIP;
    private c gIQ;
    private AlaNewSquareSubListModel gIR;
    private TbPageContext mTbPageContext;
    private boolean gIS = false;
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gIR != null) {
                z = a.this.gIR.isHasMore();
            }
            if (a.this.gIQ != null) {
                if (!z) {
                    a.this.gIQ.bRq();
                    return;
                }
                a.this.gIR.bSw();
                a.this.gIQ.bSx();
            }
        }
    };
    private AlaNewSquareSubListModel.a gHy = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mK(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gIQ != null) {
                a.this.gIQ.completePullRefresh();
                a.this.gIQ.hideLoadingView();
                a.this.gIQ.setData(a.this.gIR.getDatas());
                a.this.gIQ.tT(a.this.gIR.getLiveCount());
                a.this.gIQ.cl(a.this.gIR.getSortTypeList());
                if (a.this.gIR != null && a.this.gIR.getPn() == 0 && a.this.gIQ.getListView() != null) {
                    a.this.gIQ.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.gIR.getDatas()) == 0) {
                    a.this.gIQ.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gIQ.tS(8);
                    return;
                }
                a.this.gIQ.WZ();
                a.this.gIQ.tS(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aJ(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gIQ != null) {
                a.this.gIQ.completePullRefresh();
                a.this.gIQ.hideLoadingView();
                c cVar = a.this.gIQ;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                cVar.a(str, a.this.mOnClickListener, true);
                a.this.gIQ.tS(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private g gIT = new g() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(int i, String str, cb cbVar) {
            a.this.a(a.this.mTbPageContext, cbVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(com.baidu.tieba.ala.alasquare.subtablist.b.c cVar) {
            if (a.this.gIR != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gIR.setSortType(cVar.type);
                a.this.gIR.setLat(cVar.lat);
                a.this.gIR.setLng(cVar.lng);
                a.this.gIR.mN(cVar.gIG);
                a.this.gIR.refreshData();
            }
        }
    };
    private f.c gIU = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gIR != null) {
                a.this.gIR.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gIP = z;
        this.gIR = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gIR.a(this.gHy);
        this.gIQ = new c(this.mTbPageContext);
        this.gIQ.a(this.gIT);
        this.gIQ.setListPullRefreshListener(this.gIU);
        this.gIQ.b(this.WH);
        this.gIQ.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gIS = str.equals("16:9");
            }
            this.gIQ.a(this.gIP, list, str2, str3, this.gIS, false);
            this.gIR.setEntryName(str2);
            this.gIR.setLabelName(str3);
            this.gIR.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.gIR.mM(this.gIS);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gIR.refreshData();
    }

    public View getRootView() {
        return this.gIQ.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gIQ != null) {
            this.gIQ.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, cb cbVar, String str) {
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            ar v = new ar("c12116").v("obj_id", cbVar.boj().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                v.dR("locate_type", this.entryName);
            }
            TiebaStatic.log(v);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (cb cbVar2 : this.gIR.bSp()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData W(cb cbVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
        alaLiveInfoCoreData.userName = cbVar.bnQ().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.gIR != null) {
            this.gIR.onDestroy();
            this.gIR = null;
        }
        if (this.gIQ != null) {
            this.gIQ.onDestroy();
            this.gIQ = null;
        }
    }
}
