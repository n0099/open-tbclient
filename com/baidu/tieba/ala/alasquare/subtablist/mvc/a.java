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
    private boolean gJd;
    private c gJe;
    private AlaNewSquareSubListModel gJf;
    private TbPageContext mTbPageContext;
    private boolean gJg = false;
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gJf != null) {
                z = a.this.gJf.isHasMore();
            }
            if (a.this.gJe != null) {
                if (!z) {
                    a.this.gJe.bRx();
                    return;
                }
                a.this.gJf.bSD();
                a.this.gJe.bSE();
            }
        }
    };
    private AlaNewSquareSubListModel.a gHM = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mK(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gJe != null) {
                a.this.gJe.completePullRefresh();
                a.this.gJe.hideLoadingView();
                a.this.gJe.setData(a.this.gJf.getDatas());
                a.this.gJe.tT(a.this.gJf.getLiveCount());
                a.this.gJe.cl(a.this.gJf.getSortTypeList());
                if (a.this.gJf != null && a.this.gJf.getPn() == 0 && a.this.gJe.getListView() != null) {
                    a.this.gJe.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.gJf.getDatas()) == 0) {
                    a.this.gJe.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gJe.tS(8);
                    return;
                }
                a.this.gJe.WZ();
                a.this.gJe.tS(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aJ(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gJe != null) {
                a.this.gJe.completePullRefresh();
                a.this.gJe.hideLoadingView();
                c cVar = a.this.gJe;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                cVar.a(str, a.this.mOnClickListener, true);
                a.this.gJe.tS(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private g gJh = new g() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(int i, String str, cb cbVar) {
            a.this.a(a.this.mTbPageContext, cbVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(com.baidu.tieba.ala.alasquare.subtablist.b.c cVar) {
            if (a.this.gJf != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gJf.setSortType(cVar.type);
                a.this.gJf.setLat(cVar.lat);
                a.this.gJf.setLng(cVar.lng);
                a.this.gJf.mN(cVar.gIU);
                a.this.gJf.refreshData();
            }
        }
    };
    private f.c gJi = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gJf != null) {
                a.this.gJf.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gJd = z;
        this.gJf = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gJf.a(this.gHM);
        this.gJe = new c(this.mTbPageContext);
        this.gJe.a(this.gJh);
        this.gJe.setListPullRefreshListener(this.gJi);
        this.gJe.b(this.WH);
        this.gJe.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gJg = str.equals("16:9");
            }
            this.gJe.a(this.gJd, list, str2, str3, this.gJg, false);
            this.gJf.setEntryName(str2);
            this.gJf.setLabelName(str3);
            this.gJf.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.gJf.mM(this.gJg);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gJf.refreshData();
    }

    public View getRootView() {
        return this.gJe.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gJe != null) {
            this.gJe.onChangeSkinType(tbPageContext, i);
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
            for (cb cbVar2 : this.gJf.bSw()) {
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
        if (this.gJf != null) {
            this.gJf.onDestroy();
            this.gJf = null;
        }
        if (this.gJe != null) {
            this.gJe.onDestroy();
            this.gJe = null;
        }
    }
}
