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
/* loaded from: classes3.dex */
public class a {
    private String entryName;
    private boolean etM;
    private d etN;
    private AlaNewSquareSubListModel etO;
    private TbPageContext mTbPageContext;
    private boolean etP = false;
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.etO != null) {
                z = a.this.etO.isHasMore();
            }
            if (a.this.etN != null) {
                if (!z) {
                    a.this.etN.bcu();
                    return;
                }
                a.this.etO.bdz();
                a.this.etN.bdA();
            }
        }
    };
    private AlaNewSquareSubListModel.a esu = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ie(boolean z) {
            if (a.this.mTbPageContext != null && a.this.etN != null) {
                a.this.etN.completePullRefresh();
                a.this.etN.hideLoadingView();
                a.this.etN.setData(a.this.etO.getDatas());
                a.this.etN.oP(a.this.etO.getLiveCount());
                a.this.etN.bn(a.this.etO.getSortTypeList());
                if (a.this.etO != null && a.this.etO.getPn() == 0 && a.this.etN.getListView() != null) {
                    a.this.etN.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.etO.getDatas()) == 0) {
                    a.this.etN.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.etN.oO(8);
                    return;
                }
                a.this.etN.bcy();
                a.this.etN.oO(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ag(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.etN != null) {
                a.this.etN.completePullRefresh();
                a.this.etN.hideLoadingView();
                d dVar = a.this.etN;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.etN.oO(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i etQ = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.etO != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.etO.setSortType(cVar.type);
                a.this.etO.setLat(cVar.lat);
                a.this.etO.setLng(cVar.lng);
                a.this.etO.ih(cVar.etD);
                a.this.etO.refreshData();
            }
        }
    };
    private g.c etR = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.etO != null) {
                a.this.etO.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.etM = z;
        this.etO = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.etO.a(this.esu);
        this.etN = new d(this.mTbPageContext);
        this.etN.a(this.etQ);
        this.etN.setListPullRefreshListener(this.etR);
        this.etN.b(this.Az);
        this.etN.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.etP = str.equals("16:9");
            }
            this.etN.a(this.etM, list, str2, str3, this.etP, false);
            this.etO.setEntryName(str2);
            this.etO.setLabelName(str3);
            this.etO.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.etO.ig(this.etP);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.etO.refreshData();
    }

    public View getRootView() {
        return this.etN.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.etN != null) {
            this.etN.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
            an s = new an("c12116").s("obj_id", bjVar.aCH().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.cy("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCo().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.etO.bdq()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
        alaLiveInfoCoreData.userName = bjVar.aCo().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.etO != null) {
            this.etO.onDestroy();
            this.etO = null;
        }
        if (this.etN != null) {
            this.etN.onDestroy();
            this.etN = null;
        }
    }
}
