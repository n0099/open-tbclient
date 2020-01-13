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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private String entryName;
    private boolean epn;
    private d epo;
    private AlaNewSquareSubListModel epp;
    private TbPageContext mTbPageContext;
    private boolean epq = false;
    private BdListView.e Ah = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.epp != null) {
                z = a.this.epp.isHasMore();
            }
            if (a.this.epo != null) {
                if (!z) {
                    a.this.epo.bab();
                    return;
                }
                a.this.epp.bbh();
                a.this.epo.bbi();
            }
        }
    };
    private AlaNewSquareSubListModel.a enU = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void hX(boolean z) {
            if (a.this.mTbPageContext != null && a.this.epo != null) {
                a.this.epo.completePullRefresh();
                a.this.epo.hideLoadingView();
                a.this.epo.setData(a.this.epp.getDatas());
                a.this.epo.oy(a.this.epp.getLiveCount());
                a.this.epo.bn(a.this.epp.getSortTypeList());
                if (a.this.epp != null && a.this.epp.getPn() == 0 && a.this.epo.getListView() != null) {
                    a.this.epo.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.epp.getDatas()) == 0) {
                    a.this.epo.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.epo.ox(8);
                    return;
                }
                a.this.epo.baf();
                a.this.epo.ox(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void af(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.epo != null) {
                a.this.epo.completePullRefresh();
                a.this.epo.hideLoadingView();
                d dVar = a.this.epo;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.epo.ox(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i epr = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.epp != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.epp.setSortType(cVar.type);
                a.this.epp.setLat(cVar.lat);
                a.this.epp.setLng(cVar.lng);
                a.this.epp.ia(cVar.epe);
                a.this.epp.refreshData();
            }
        }
    };
    private g.c eps = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.epp != null) {
                a.this.epp.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.epn = z;
        this.epp = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.epp.a(this.enU);
        this.epo = new d(this.mTbPageContext);
        this.epo.a(this.epr);
        this.epo.setListPullRefreshListener(this.eps);
        this.epo.b(this.Ah);
        this.epo.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.epq = str.equals("16:9");
            }
            this.epo.a(this.epn, list, str2, str3, this.epq, false);
            this.epp.setEntryName(str2);
            this.epp.setLabelName(str3);
            this.epp.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.epp.hZ(this.epq);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.epp.refreshData();
    }

    public View getRootView() {
        return this.epo.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.epo != null) {
            this.epo.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.azX() != null && bjVar.aAq() != null) {
            an s = new an("c12116").s("obj_id", bjVar.aAq().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.cp("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azX().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.epp.baY()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(R(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData R(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
        alaLiveInfoCoreData.userName = bjVar.azX().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.epp != null) {
            this.epp.onDestroy();
            this.epp = null;
        }
        if (this.epo != null) {
            this.epo.onDestroy();
            this.epo = null;
        }
    }
}
