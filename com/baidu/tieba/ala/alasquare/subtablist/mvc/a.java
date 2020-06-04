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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
    private boolean fkD;
    private d fkE;
    private AlaNewSquareSubListModel fkF;
    private TbPageContext mTbPageContext;
    private boolean fkG = false;
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.fkF != null) {
                z = a.this.fkF.isHasMore();
            }
            if (a.this.fkE != null) {
                if (!z) {
                    a.this.fkE.bqL();
                    return;
                }
                a.this.fkF.brT();
                a.this.fkE.brU();
            }
        }
    };
    private AlaNewSquareSubListModel.a fjm = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jz(boolean z) {
            if (a.this.mTbPageContext != null && a.this.fkE != null) {
                a.this.fkE.completePullRefresh();
                a.this.fkE.hideLoadingView();
                a.this.fkE.setData(a.this.fkF.getDatas());
                a.this.fkE.pN(a.this.fkF.getLiveCount());
                a.this.fkE.bs(a.this.fkF.getSortTypeList());
                if (a.this.fkF != null && a.this.fkF.getPn() == 0 && a.this.fkE.getListView() != null) {
                    a.this.fkE.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.fkF.getDatas()) == 0) {
                    a.this.fkE.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.fkE.pM(8);
                    return;
                }
                a.this.fkE.bqQ();
                a.this.fkE.pM(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void al(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.fkE != null) {
                a.this.fkE.completePullRefresh();
                a.this.fkE.hideLoadingView();
                d dVar = a.this.fkE;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.fkE.pM(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i fkH = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bk bkVar) {
            a.this.a(a.this.mTbPageContext, bkVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.fkF != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.fkF.setSortType(cVar.type);
                a.this.fkF.setLat(cVar.lat);
                a.this.fkF.setLng(cVar.lng);
                a.this.fkF.jC(cVar.fku);
                a.this.fkF.refreshData();
            }
        }
    };
    private f.c fkI = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.fkF != null) {
                a.this.fkF.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fkD = z;
        this.fkF = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.fkF.a(this.fjm);
        this.fkE = new d(this.mTbPageContext);
        this.fkE.a(this.fkH);
        this.fkE.setListPullRefreshListener(this.fkI);
        this.fkE.b(this.Uf);
        this.fkE.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.fkG = str.equals("16:9");
            }
            this.fkE.a(this.fkD, list, str2, str3, this.fkG, false);
            this.fkF.setEntryName(str2);
            this.fkF.setLabelName(str3);
            this.fkF.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.fkF.jB(this.fkG);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.fkF.refreshData();
    }

    public View getRootView() {
        return this.fkE.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.fkE != null) {
            this.fkE.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bk bkVar, String str) {
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            an s = new an("c12116").s("obj_id", bkVar.aQS().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.dh("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bk bkVar2 : this.fkF.brK()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData U(bk bkVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
        alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.fkF != null) {
            this.fkF.onDestroy();
            this.fkF = null;
        }
        if (this.fkE != null) {
            this.fkE.onDestroy();
            this.fkE = null;
        }
    }
}
