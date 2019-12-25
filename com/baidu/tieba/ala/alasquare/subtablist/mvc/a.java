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
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private boolean enZ;
    private String entryName;
    private d eoa;
    private AlaNewSquareSubListModel eob;
    private TbPageContext mTbPageContext;
    private boolean eoc = false;
    private BdListView.e Ac = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.eob != null) {
                z = a.this.eob.isHasMore();
            }
            if (a.this.eoa != null) {
                if (!z) {
                    a.this.eoa.aZG();
                    return;
                }
                a.this.eob.baM();
                a.this.eoa.baN();
            }
        }
    };
    private AlaNewSquareSubListModel.a emS = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void hN(boolean z) {
            if (a.this.mTbPageContext != null && a.this.eoa != null) {
                a.this.eoa.completePullRefresh();
                a.this.eoa.hideLoadingView();
                a.this.eoa.setData(a.this.eob.getDatas());
                a.this.eoa.ox(a.this.eob.getLiveCount());
                a.this.eoa.bn(a.this.eob.getSortTypeList());
                if (a.this.eob != null && a.this.eob.getPn() == 0 && a.this.eoa.getListView() != null) {
                    a.this.eoa.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.eob.getDatas()) == 0) {
                    a.this.eoa.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.eoa.ow(8);
                    return;
                }
                a.this.eoa.aZK();
                a.this.eoa.ow(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ad(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.eoa != null) {
                a.this.eoa.completePullRefresh();
                a.this.eoa.hideLoadingView();
                d dVar = a.this.eoa;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.eoa.ow(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private h eod = new h() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(c cVar) {
            if (a.this.eob != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.eob.setSortType(cVar.type);
                a.this.eob.setLat(cVar.lat);
                a.this.eob.setLng(cVar.lng);
                a.this.eob.hQ(cVar.enQ);
                a.this.eob.refreshData();
            }
        }
    };
    private g.c eoe = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.eob != null) {
                a.this.eob.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.enZ = z;
        this.eob = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.eob.a(this.emS);
        this.eoa = new d(this.mTbPageContext);
        this.eoa.a(this.eod);
        this.eoa.setListPullRefreshListener(this.eoe);
        this.eoa.b(this.Ac);
        this.eoa.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.eoc = str.equals("16:9");
            }
            this.eoa.a(this.enZ, list, str2, str3, this.eoc, false);
            this.eob.setEntryName(str2);
            this.eob.setLabelName(str3);
            this.eob.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.eob.hP(this.eoc);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.eob.refreshData();
    }

    public View getRootView() {
        return this.eoa.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.eoa != null) {
            this.eoa.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.azE() != null && bjVar.azX() != null) {
            an s = new an("c12116").s("obj_id", bjVar.azX().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.cp("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.azX());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.eob.baD()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(Q(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData Q(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.azX());
        alaLiveInfoCoreData.userName = bjVar.azE().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.eob != null) {
            this.eob.onDestroy();
            this.eob = null;
        }
        if (this.eoa != null) {
            this.eoa.onDestroy();
            this.eoa = null;
        }
    }
}
