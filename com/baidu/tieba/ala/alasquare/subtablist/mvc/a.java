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
    private boolean eui;
    private d euj;
    private AlaNewSquareSubListModel euk;
    private TbPageContext mTbPageContext;
    private boolean eul = false;
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.euk != null) {
                z = a.this.euk.isHasMore();
            }
            if (a.this.euj != null) {
                if (!z) {
                    a.this.euj.bcy();
                    return;
                }
                a.this.euk.bdE();
                a.this.euj.bdF();
            }
        }
    };
    private AlaNewSquareSubListModel.a esQ = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ig(boolean z) {
            if (a.this.mTbPageContext != null && a.this.euj != null) {
                a.this.euj.completePullRefresh();
                a.this.euj.hideLoadingView();
                a.this.euj.setData(a.this.euk.getDatas());
                a.this.euj.oR(a.this.euk.getLiveCount());
                a.this.euj.bn(a.this.euk.getSortTypeList());
                if (a.this.euk != null && a.this.euk.getPn() == 0 && a.this.euj.getListView() != null) {
                    a.this.euj.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.euk.getDatas()) == 0) {
                    a.this.euj.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.euj.oQ(8);
                    return;
                }
                a.this.euj.bcC();
                a.this.euj.oQ(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ag(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.euj != null) {
                a.this.euj.completePullRefresh();
                a.this.euj.hideLoadingView();
                d dVar = a.this.euj;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.euj.oQ(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i eum = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            a.this.a(a.this.mTbPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.euk != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.euk.setSortType(cVar.type);
                a.this.euk.setLat(cVar.lat);
                a.this.euk.setLng(cVar.lng);
                a.this.euk.ij(cVar.etZ);
                a.this.euk.refreshData();
            }
        }
    };
    private g.c eun = new g.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (a.this.euk != null) {
                a.this.euk.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.eui = z;
        this.euk = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.euk.a(this.esQ);
        this.euj = new d(this.mTbPageContext);
        this.euj.a(this.eum);
        this.euj.setListPullRefreshListener(this.eun);
        this.euj.b(this.Az);
        this.euj.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.eul = str.equals("16:9");
            }
            this.euj.a(this.eui, list, str2, str3, this.eul, false);
            this.euk.setEntryName(str2);
            this.euk.setLabelName(str3);
            this.euk.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.euk.ii(this.eul);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.euk.refreshData();
    }

    public View getRootView() {
        return this.euj.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.euj != null) {
            this.euj.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
            an s = new an("c12116").s("obj_id", bjVar.aCK().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.cx("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCr().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.euk.bdv()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
        alaLiveInfoCoreData.userName = bjVar.aCr().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.euk != null) {
            this.euk.onDestroy();
            this.euk = null;
        }
        if (this.euj != null) {
            this.euj.onDestroy();
            this.euj = null;
        }
    }
}
