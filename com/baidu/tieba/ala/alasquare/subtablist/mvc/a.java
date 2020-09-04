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
    private boolean fMt;
    private d fMu;
    private AlaNewSquareSubListModel fMv;
    private TbPageContext mTbPageContext;
    private boolean fMw = false;
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.fMv != null) {
                z = a.this.fMv.isHasMore();
            }
            if (a.this.fMu != null) {
                if (!z) {
                    a.this.fMu.bFS();
                    return;
                }
                a.this.fMv.bGZ();
                a.this.fMu.bHa();
            }
        }
    };
    private AlaNewSquareSubListModel.a fLc = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void kQ(boolean z) {
            if (a.this.mTbPageContext != null && a.this.fMu != null) {
                a.this.fMu.completePullRefresh();
                a.this.fMu.hideLoadingView();
                a.this.fMu.setData(a.this.fMv.getDatas());
                a.this.fMu.sN(a.this.fMv.getLiveCount());
                a.this.fMu.bG(a.this.fMv.getSortTypeList());
                if (a.this.fMv != null && a.this.fMv.getPn() == 0 && a.this.fMu.getListView() != null) {
                    a.this.fMu.getListView().smoothScrollToPosition(0);
                }
                if (y.getCount(a.this.fMv.getDatas()) == 0) {
                    a.this.fMu.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.fMu.sM(8);
                    return;
                }
                a.this.fMu.bFX();
                a.this.fMu.sM(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void am(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.fMu != null) {
                a.this.fMu.completePullRefresh();
                a.this.fMu.hideLoadingView();
                d dVar = a.this.fMu;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.fMu.sM(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i fMx = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            a.this.a(a.this.mTbPageContext, bwVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.fMv != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.fMv.setSortType(cVar.type);
                a.this.fMv.setLat(cVar.lat);
                a.this.fMv.setLng(cVar.lng);
                a.this.fMv.kT(cVar.fMk);
                a.this.fMv.refreshData();
            }
        }
    };
    private f.c fMy = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.fMv != null) {
                a.this.fMv.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fMt = z;
        this.fMv = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.fMv.a(this.fLc);
        this.fMu = new d(this.mTbPageContext);
        this.fMu.a(this.fMx);
        this.fMu.setListPullRefreshListener(this.fMy);
        this.fMu.b(this.Vh);
        this.fMu.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.fMw = str.equals("16:9");
            }
            this.fMu.a(this.fMt, list, str2, str3, this.fMw, false);
            this.fMv.setEntryName(str2);
            this.fMv.setLabelName(str3);
            this.fMv.setSortType(y.isEmpty(list) ? "" : list.get(0));
            this.fMv.kS(this.fMw);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.fMv.refreshData();
    }

    public View getRootView() {
        return this.fMu.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.fMu != null) {
            this.fMu.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            aq u = new aq("c12116").u("obj_id", bwVar.beY().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                u.dD("locate_type", this.entryName);
            }
            TiebaStatic.log(u);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.fMv.bGQ()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bwVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
        alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.fMv != null) {
            this.fMv.onDestroy();
            this.fMv = null;
        }
        if (this.fMu != null) {
            this.fMu.onDestroy();
            this.fMu = null;
        }
    }
}
