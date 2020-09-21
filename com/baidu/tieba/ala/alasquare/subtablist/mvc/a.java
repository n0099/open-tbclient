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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private String entryName;
    private boolean fPH;
    private d fPI;
    private AlaNewSquareSubListModel fPJ;
    private TbPageContext mTbPageContext;
    private boolean fPK = false;
    private BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.fPJ != null) {
                z = a.this.fPJ.isHasMore();
            }
            if (a.this.fPI != null) {
                if (!z) {
                    a.this.fPI.bHi();
                    return;
                }
                a.this.fPJ.bIp();
                a.this.fPI.bIq();
            }
        }
    };
    private AlaNewSquareSubListModel.a fOq = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void kS(boolean z) {
            if (a.this.mTbPageContext != null && a.this.fPI != null) {
                a.this.fPI.completePullRefresh();
                a.this.fPI.hideLoadingView();
                a.this.fPI.setData(a.this.fPJ.getDatas());
                a.this.fPI.tf(a.this.fPJ.getLiveCount());
                a.this.fPI.bL(a.this.fPJ.getSortTypeList());
                if (a.this.fPJ != null && a.this.fPJ.getPn() == 0 && a.this.fPI.getListView() != null) {
                    a.this.fPI.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.fPJ.getDatas()) == 0) {
                    a.this.fPI.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.fPI.te(8);
                    return;
                }
                a.this.fPI.bHn();
                a.this.fPI.te(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void an(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.fPI != null) {
                a.this.fPI.completePullRefresh();
                a.this.fPI.hideLoadingView();
                d dVar = a.this.fPI;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.fPI.te(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i fPL = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            a.this.a(a.this.mTbPageContext, bwVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.fPJ != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.fPJ.setSortType(cVar.type);
                a.this.fPJ.setLat(cVar.lat);
                a.this.fPJ.setLng(cVar.lng);
                a.this.fPJ.kV(cVar.fPy);
                a.this.fPJ.refreshData();
            }
        }
    };
    private f.c fPM = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.fPJ != null) {
                a.this.fPJ.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fPH = z;
        this.fPJ = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.fPJ.a(this.fOq);
        this.fPI = new d(this.mTbPageContext);
        this.fPI.a(this.fPL);
        this.fPI.setListPullRefreshListener(this.fPM);
        this.fPI.b(this.Vz);
        this.fPI.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.fPK = str.equals("16:9");
            }
            this.fPI.a(this.fPH, list, str2, str3, this.fPK, false);
            this.fPJ.setEntryName(str2);
            this.fPJ.setLabelName(str3);
            this.fPJ.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.fPJ.kU(this.fPK);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.fPJ.refreshData();
    }

    public View getRootView() {
        return this.fPI.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.fPI != null) {
            this.fPI.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.bfy() != null && bwVar.bfS() != null) {
            aq u = new aq("c12116").u("obj_id", bwVar.bfS().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                u.dF("locate_type", this.entryName);
            }
            TiebaStatic.log(u);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bfy().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.fPJ.bIg()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
        alaLiveInfoCoreData.userName = bwVar.bfy().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.fPJ != null) {
            this.fPJ.onDestroy();
            this.fPJ = null;
        }
        if (this.fPI != null) {
            this.fPI.onDestroy();
            this.fPI = null;
        }
    }
}
