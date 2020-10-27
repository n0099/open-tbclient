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
    private boolean gmd;
    private d gme;
    private AlaNewSquareSubListModel gmf;
    private TbPageContext mTbPageContext;
    private boolean gmg = false;
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gmf != null) {
                z = a.this.gmf.isHasMore();
            }
            if (a.this.gme != null) {
                if (!z) {
                    a.this.gme.bMw();
                    return;
                }
                a.this.gmf.bNB();
                a.this.gme.bNC();
            }
        }
    };
    private AlaNewSquareSubListModel.a gkM = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void lI(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gme != null) {
                a.this.gme.completePullRefresh();
                a.this.gme.hideLoadingView();
                a.this.gme.setData(a.this.gmf.getDatas());
                a.this.gme.tW(a.this.gmf.getLiveCount());
                a.this.gme.bY(a.this.gmf.getSortTypeList());
                if (a.this.gmf != null && a.this.gmf.getPn() == 0 && a.this.gme.getListView() != null) {
                    a.this.gme.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.gmf.getDatas()) == 0) {
                    a.this.gme.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gme.tV(8);
                    return;
                }
                a.this.gme.TK();
                a.this.gme.tV(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aA(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gme != null) {
                a.this.gme.completePullRefresh();
                a.this.gme.hideLoadingView();
                d dVar = a.this.gme;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.gme.tV(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i gmh = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            a.this.a(a.this.mTbPageContext, bwVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.gmf != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gmf.setSortType(cVar.type);
                a.this.gmf.setLat(cVar.lat);
                a.this.gmf.setLng(cVar.lng);
                a.this.gmf.lL(cVar.glU);
                a.this.gmf.refreshData();
            }
        }
    };
    private f.c gmi = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gmf != null) {
                a.this.gmf.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gmd = z;
        this.gmf = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gmf.a(this.gkM);
        this.gme = new d(this.mTbPageContext);
        this.gme.a(this.gmh);
        this.gme.setListPullRefreshListener(this.gmi);
        this.gme.b(this.VR);
        this.gme.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gmg = str.equals("16:9");
            }
            this.gme.a(this.gmd, list, str2, str3, this.gmg, false);
            this.gmf.setEntryName(str2);
            this.gmf.setLabelName(str3);
            this.gmf.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.gmf.lK(this.gmg);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gmf.refreshData();
    }

    public View getRootView() {
        return this.gme.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gme != null) {
            this.gme.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.bka() != null && bwVar.bku() != null) {
            aq w = new aq("c12116").w("obj_id", bwVar.bku().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                w.dR("locate_type", this.entryName);
            }
            TiebaStatic.log(w);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bka().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.gmf.bNu()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
        alaLiveInfoCoreData.userName = bwVar.bka().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.gmf != null) {
            this.gmf.onDestroy();
            this.gmf = null;
        }
        if (this.gme != null) {
            this.gme.onDestroy();
            this.gme = null;
        }
    }
}
