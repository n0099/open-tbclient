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
    private boolean gbZ;
    private d gca;
    private AlaNewSquareSubListModel gcb;
    private TbPageContext mTbPageContext;
    private boolean gcc = false;
    private BdListView.e VQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gcb != null) {
                z = a.this.gcb.isHasMore();
            }
            if (a.this.gca != null) {
                if (!z) {
                    a.this.gca.bJU();
                    return;
                }
                a.this.gcb.bKZ();
                a.this.gca.bLa();
            }
        }
    };
    private AlaNewSquareSubListModel.a gaI = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void lq(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gca != null) {
                a.this.gca.completePullRefresh();
                a.this.gca.hideLoadingView();
                a.this.gca.setData(a.this.gcb.getDatas());
                a.this.gca.tD(a.this.gcb.getLiveCount());
                a.this.gca.bO(a.this.gcb.getSortTypeList());
                if (a.this.gcb != null && a.this.gcb.getPn() == 0 && a.this.gca.getListView() != null) {
                    a.this.gca.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.gcb.getDatas()) == 0) {
                    a.this.gca.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gca.tC(8);
                    return;
                }
                a.this.gca.SK();
                a.this.gca.tC(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ay(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gca != null) {
                a.this.gca.completePullRefresh();
                a.this.gca.hideLoadingView();
                d dVar = a.this.gca;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.gca.tC(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i gcd = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            a.this.a(a.this.mTbPageContext, bwVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.gcb != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gcb.setSortType(cVar.type);
                a.this.gcb.setLat(cVar.lat);
                a.this.gcb.setLng(cVar.lng);
                a.this.gcb.lt(cVar.gbQ);
                a.this.gcb.refreshData();
            }
        }
    };
    private f.c gce = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gcb != null) {
                a.this.gcb.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gbZ = z;
        this.gcb = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gcb.a(this.gaI);
        this.gca = new d(this.mTbPageContext);
        this.gca.a(this.gcd);
        this.gca.setListPullRefreshListener(this.gce);
        this.gca.b(this.VQ);
        this.gca.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gcc = str.equals("16:9");
            }
            this.gca.a(this.gbZ, list, str2, str3, this.gcc, false);
            this.gcb.setEntryName(str2);
            this.gcb.setLabelName(str3);
            this.gcb.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.gcb.ls(this.gcc);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gcb.refreshData();
    }

    public View getRootView() {
        return this.gca.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gca != null) {
            this.gca.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.bih() != null && bwVar.biB() != null) {
            aq u = new aq("c12116").u("obj_id", bwVar.biB().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                u.dK("locate_type", this.entryName);
            }
            TiebaStatic.log(u);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bih().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.biB());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.gcb.bKS()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.biB());
        alaLiveInfoCoreData.userName = bwVar.bih().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.gcb != null) {
            this.gcb.onDestroy();
            this.gcb = null;
        }
        if (this.gca != null) {
            this.gca.onDestroy();
            this.gca = null;
        }
    }
}
