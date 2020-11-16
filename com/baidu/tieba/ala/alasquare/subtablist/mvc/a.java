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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes4.dex */
public class a {
    private String entryName;
    private boolean grx;
    private d gry;
    private AlaNewSquareSubListModel grz;
    private TbPageContext mTbPageContext;
    private boolean grA = false;
    private BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.grz != null) {
                z = a.this.grz.isHasMore();
            }
            if (a.this.gry != null) {
                if (!z) {
                    a.this.gry.bOp();
                    return;
                }
                a.this.grz.bPu();
                a.this.gry.bPv();
            }
        }
    };
    private AlaNewSquareSubListModel.a gqg = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void lS(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gry != null) {
                a.this.gry.completePullRefresh();
                a.this.gry.hideLoadingView();
                a.this.gry.setData(a.this.grz.getDatas());
                a.this.gry.uE(a.this.grz.getLiveCount());
                a.this.gry.cf(a.this.grz.getSortTypeList());
                if (a.this.grz != null && a.this.grz.getPn() == 0 && a.this.gry.getListView() != null) {
                    a.this.gry.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.grz.getDatas()) == 0) {
                    a.this.gry.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gry.uD(8);
                    return;
                }
                a.this.gry.VB();
                a.this.gry.uD(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aC(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gry != null) {
                a.this.gry.completePullRefresh();
                a.this.gry.hideLoadingView();
                d dVar = a.this.gry;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.gry.uD(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i grB = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bx bxVar) {
            a.this.a(a.this.mTbPageContext, bxVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.grz != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.grz.setSortType(cVar.type);
                a.this.grz.setLat(cVar.lat);
                a.this.grz.setLng(cVar.lng);
                a.this.grz.lV(cVar.gro);
                a.this.grz.refreshData();
            }
        }
    };
    private f.c grC = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.grz != null) {
                a.this.grz.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.grx = z;
        this.grz = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.grz.a(this.gqg);
        this.gry = new d(this.mTbPageContext);
        this.gry.a(this.grB);
        this.gry.setListPullRefreshListener(this.grC);
        this.gry.b(this.VT);
        this.gry.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.grA = str.equals("16:9");
            }
            this.gry.a(this.grx, list, str2, str3, this.grA, false);
            this.grz.setEntryName(str2);
            this.grz.setLabelName(str3);
            this.grz.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.grz.lU(this.grA);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.grz.refreshData();
    }

    public View getRootView() {
        return this.gry.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gry != null) {
            this.gry.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bx bxVar, String str) {
        if (tbPageContext != null && bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
            ar w = new ar("c12116").w("obj_id", bxVar.blW().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                w.dR("locate_type", this.entryName);
            }
            TiebaStatic.log(w);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bxVar.blC().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bx bxVar2 : this.grz.bPn()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(bxVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bx bxVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
        alaLiveInfoCoreData.userName = bxVar.blC().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.grz != null) {
            this.grz.onDestroy();
            this.grz = null;
        }
        if (this.gry != null) {
            this.gry.onDestroy();
            this.gry = null;
        }
    }
}
