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
    private boolean gzG;
    private d gzH;
    private AlaNewSquareSubListModel gzI;
    private TbPageContext mTbPageContext;
    private boolean gzJ = false;
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gzI != null) {
                z = a.this.gzI.isHasMore();
            }
            if (a.this.gzH != null) {
                if (!z) {
                    a.this.gzH.bSa();
                    return;
                }
                a.this.gzI.bTf();
                a.this.gzH.bTg();
            }
        }
    };
    private AlaNewSquareSubListModel.a gyp = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mn(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gzH != null) {
                a.this.gzH.completePullRefresh();
                a.this.gzH.hideLoadingView();
                a.this.gzH.setData(a.this.gzI.getDatas());
                a.this.gzH.vi(a.this.gzI.getLiveCount());
                a.this.gzH.cj(a.this.gzI.getSortTypeList());
                if (a.this.gzI != null && a.this.gzI.getPn() == 0 && a.this.gzH.getListView() != null) {
                    a.this.gzH.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.gzI.getDatas()) == 0) {
                    a.this.gzH.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gzH.vh(8);
                    return;
                }
                a.this.gzH.Yb();
                a.this.gzH.vh(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aC(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gzH != null) {
                a.this.gzH.completePullRefresh();
                a.this.gzH.hideLoadingView();
                d dVar = a.this.gzH;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.gzH.vh(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i gzK = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, by byVar) {
            a.this.a(a.this.mTbPageContext, byVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.gzI != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gzI.setSortType(cVar.type);
                a.this.gzI.setLat(cVar.lat);
                a.this.gzI.setLng(cVar.lng);
                a.this.gzI.mq(cVar.gzx);
                a.this.gzI.refreshData();
            }
        }
    };
    private f.c gzL = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gzI != null) {
                a.this.gzI.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gzG = z;
        this.gzI = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gzI.a(this.gyp);
        this.gzH = new d(this.mTbPageContext);
        this.gzH.a(this.gzK);
        this.gzH.setListPullRefreshListener(this.gzL);
        this.gzH.b(this.WQ);
        this.gzH.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gzJ = str.equals("16:9");
            }
            this.gzH.a(this.gzG, list, str2, str3, this.gzJ, false);
            this.gzI.setEntryName(str2);
            this.gzI.setLabelName(str3);
            this.gzI.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.gzI.mp(this.gzJ);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gzI.refreshData();
    }

    public View getRootView() {
        return this.gzH.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gzH != null) {
            this.gzH.onChangeSkinType(tbPageContext, i);
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
            for (by byVar2 : this.gzI.bSY()) {
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
        if (this.gzI != null) {
            this.gzI.onDestroy();
            this.gzI = null;
        }
        if (this.gzH != null) {
            this.gzH.onDestroy();
            this.gzH = null;
        }
    }
}
