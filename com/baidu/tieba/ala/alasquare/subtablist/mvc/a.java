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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import com.baidu.tieba.ala.alasquare.subtablist.view.c;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private String entryName;
    private boolean gGf;
    private c gGg;
    private AlaNewSquareSubListModel gGh;
    private TbPageContext mTbPageContext;
    private boolean gGi = false;
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.gGh != null) {
                z = a.this.gGh.isHasMore();
            }
            if (a.this.gGg != null) {
                if (!z) {
                    a.this.gGg.bQM();
                    return;
                }
                a.this.gGh.bRT();
                a.this.gGg.bRU();
            }
        }
    };
    private AlaNewSquareSubListModel.a gEO = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mG(boolean z) {
            if (a.this.mTbPageContext != null && a.this.gGg != null) {
                a.this.gGg.completePullRefresh();
                a.this.gGg.hideLoadingView();
                a.this.gGg.setData(a.this.gGh.getDatas());
                a.this.gGg.tN(a.this.gGh.getLiveCount());
                a.this.gGg.cq(a.this.gGh.getSortTypeList());
                if (a.this.gGh != null && a.this.gGh.getPn() == 0 && a.this.gGg.getListView() != null) {
                    a.this.gGg.getListView().smoothScrollToPosition(0);
                }
                if (x.getCount(a.this.gGh.getDatas()) == 0) {
                    a.this.gGg.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.gGg.tM(8);
                    return;
                }
                a.this.gGg.Vq();
                a.this.gGg.tM(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aF(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.gGg != null) {
                a.this.gGg.completePullRefresh();
                a.this.gGg.hideLoadingView();
                c cVar = a.this.gGg;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                cVar.a(str, a.this.mOnClickListener, true);
                a.this.gGg.tM(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private g gGj = new g() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(int i, String str, bz bzVar) {
            a.this.a(a.this.mTbPageContext, bzVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(com.baidu.tieba.ala.alasquare.subtablist.b.c cVar) {
            if (a.this.gGh != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.gGh.setSortType(cVar.type);
                a.this.gGh.setLat(cVar.lat);
                a.this.gGh.setLng(cVar.lng);
                a.this.gGh.mJ(cVar.gFW);
                a.this.gGh.refreshData();
            }
        }
    };
    private f.c gGk = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.gGh != null) {
                a.this.gGh.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gGf = z;
        this.gGh = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.gGh.a(this.gEO);
        this.gGg = new c(this.mTbPageContext);
        this.gGg.a(this.gGj);
        this.gGg.setListPullRefreshListener(this.gGk);
        this.gGg.b(this.WL);
        this.gGg.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.gGi = str.equals("16:9");
            }
            this.gGg.a(this.gGf, list, str2, str3, this.gGi, false);
            this.gGh.setEntryName(str2);
            this.gGh.setLabelName(str3);
            this.gGh.setSortType(x.isEmpty(list) ? "" : list.get(0));
            this.gGh.mI(this.gGi);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.gGh.refreshData();
    }

    public View getRootView() {
        return this.gGg.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.gGg != null) {
            this.gGg.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bz bzVar, String str) {
        if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            aq w = new aq("c12116").w("obj_id", bzVar.bnQ().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                w.dW("locate_type", this.entryName);
            }
            TiebaStatic.log(w);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.bnx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bz bzVar2 : this.gGh.bRM()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
        alaLiveInfoCoreData.userName = bzVar.bnx().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.gGh != null) {
            this.gGh.onDestroy();
            this.gGh = null;
        }
        if (this.gGg != null) {
            this.gGg.onDestroy();
            this.gGg = null;
        }
    }
}
