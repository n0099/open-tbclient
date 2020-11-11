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
    private boolean grQ;
    private d grR;
    private AlaNewSquareSubListModel grS;
    private TbPageContext mTbPageContext;
    private boolean grT = false;
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.grS != null) {
                z = a.this.grS.isHasMore();
            }
            if (a.this.grR != null) {
                if (!z) {
                    a.this.grR.bOW();
                    return;
                }
                a.this.grS.bQb();
                a.this.grR.bQc();
            }
        }
    };
    private AlaNewSquareSubListModel.a gqz = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void lR(boolean z) {
            if (a.this.mTbPageContext != null && a.this.grR != null) {
                a.this.grR.completePullRefresh();
                a.this.grR.hideLoadingView();
                a.this.grR.setData(a.this.grS.getDatas());
                a.this.grR.ug(a.this.grS.getLiveCount());
                a.this.grR.cf(a.this.grS.getSortTypeList());
                if (a.this.grS != null && a.this.grS.getPn() == 0 && a.this.grR.getListView() != null) {
                    a.this.grR.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.grS.getDatas()) == 0) {
                    a.this.grR.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.grR.uf(8);
                    return;
                }
                a.this.grR.Wk();
                a.this.grR.uf(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aE(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.grR != null) {
                a.this.grR.completePullRefresh();
                a.this.grR.hideLoadingView();
                d dVar = a.this.grR;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.grR.uf(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i grU = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            a.this.a(a.this.mTbPageContext, bwVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.grS != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.grS.setSortType(cVar.type);
                a.this.grS.setLat(cVar.lat);
                a.this.grS.setLng(cVar.lng);
                a.this.grS.lU(cVar.grH);
                a.this.grS.refreshData();
            }
        }
    };
    private f.c grV = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.grS != null) {
                a.this.grS.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.grQ = z;
        this.grS = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.grS.a(this.gqz);
        this.grR = new d(this.mTbPageContext);
        this.grR.a(this.grU);
        this.grR.setListPullRefreshListener(this.grV);
        this.grR.b(this.VR);
        this.grR.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.grT = str.equals("16:9");
            }
            this.grR.a(this.grQ, list, str2, str3, this.grT, false);
            this.grS.setEntryName(str2);
            this.grS.setLabelName(str3);
            this.grS.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.grS.lT(this.grT);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.grS.refreshData();
    }

    public View getRootView() {
        return this.grR.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.grR != null) {
            this.grR.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.bmA() != null && bwVar.bmU() != null) {
            aq w = new aq("c12116").w("obj_id", bwVar.bmU().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                w.dR("locate_type", this.entryName);
            }
            TiebaStatic.log(w);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bmA().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.grS.bPU()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
        alaLiveInfoCoreData.userName = bwVar.bmA().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.grS != null) {
            this.grS.onDestroy();
            this.grS = null;
        }
        if (this.grR != null) {
            this.grR.onDestroy();
            this.grR = null;
        }
    }
}
