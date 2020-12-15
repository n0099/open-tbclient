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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private String entryName;
    private boolean gzI;
    private d gzJ;
    private AlaNewSquareSubListModel gzK;
    private TbPageContext mTbPageContext;
    private boolean gzL = false;
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gzK != null) {
                z = a.this.gzK.isHasMore();
            }
            if (a.this.gzJ != null) {
                if (!z) {
                    a.this.gzJ.bSb();
                    return;
                }
                a.this.gzK.bTg();
                a.this.gzJ.bTh();
            }
        }
    };
    private AlaNewSquareSubListModel.a gyr = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mn(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gzJ != null) {
                a.this.gzJ.completePullRefresh();
                a.this.gzJ.hideLoadingView();
                a.this.gzJ.setData(a.this.gzK.getDatas());
                a.this.gzJ.vi(a.this.gzK.getLiveCount());
                a.this.gzJ.cj(a.this.gzK.getSortTypeList());
                if (a.this.gzK != null && a.this.gzK.getPn() == 0 && a.this.gzJ.getListView() != null) {
                    a.this.gzJ.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.gzK.getDatas()) == 0) {
                    a.this.gzJ.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gzJ.vh(8);
                    return;
                }
                a.this.gzJ.Yb();
                a.this.gzJ.vh(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aC(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gzJ != null) {
                a.this.gzJ.completePullRefresh();
                a.this.gzJ.hideLoadingView();
                d dVar = a.this.gzJ;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.gzJ.vh(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i gzM = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, by byVar) {
            a.this.a(a.this.mTbPageContext, byVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.gzK != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gzK.setSortType(cVar.type);
                a.this.gzK.setLat(cVar.lat);
                a.this.gzK.setLng(cVar.lng);
                a.this.gzK.mq(cVar.gzz);
                a.this.gzK.refreshData();
            }
        }
    };
    private f.c gzN = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gzK != null) {
                a.this.gzK.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gzI = z;
        this.gzK = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gzK.a(this.gyr);
        this.gzJ = new d(this.mTbPageContext);
        this.gzJ.a(this.gzM);
        this.gzJ.setListPullRefreshListener(this.gzN);
        this.gzJ.b(this.WQ);
        this.gzJ.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gzL = str.equals("16:9");
            }
            this.gzJ.a(this.gzI, list, str2, str3, this.gzL, false);
            this.gzK.setEntryName(str2);
            this.gzK.setLabelName(str3);
            this.gzK.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.gzK.mp(this.gzL);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gzK.refreshData();
    }

    public View getRootView() {
        return this.gzJ.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gzJ != null) {
            this.gzJ.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, by byVar, String str) {
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            ar w = new ar("c12116").w("obj_id", byVar.bpj().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                w.dY("locate_type", this.entryName);
            }
            TiebaStatic.log(w);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (by byVar2 : this.gzK.bSZ()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(byVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(by byVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
        alaLiveInfoCoreData.userName = byVar.boP().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.gzK != null) {
            this.gzK.onDestroy();
            this.gzK = null;
        }
        if (this.gzJ != null) {
            this.gzJ.onDestroy();
            this.gzJ = null;
        }
    }
}
