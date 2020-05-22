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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
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
    private boolean fks;
    private d fkt;
    private AlaNewSquareSubListModel fku;
    private TbPageContext mTbPageContext;
    private boolean fkv = false;
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.fku != null) {
                z = a.this.fku.isHasMore();
            }
            if (a.this.fkt != null) {
                if (!z) {
                    a.this.fkt.bqJ();
                    return;
                }
                a.this.fku.brR();
                a.this.fkt.brS();
            }
        }
    };
    private AlaNewSquareSubListModel.a fjb = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jz(boolean z) {
            if (a.this.mTbPageContext != null && a.this.fkt != null) {
                a.this.fkt.completePullRefresh();
                a.this.fkt.hideLoadingView();
                a.this.fkt.setData(a.this.fku.getDatas());
                a.this.fkt.pL(a.this.fku.getLiveCount());
                a.this.fkt.bs(a.this.fku.getSortTypeList());
                if (a.this.fku != null && a.this.fku.getPn() == 0 && a.this.fkt.getListView() != null) {
                    a.this.fkt.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.fku.getDatas()) == 0) {
                    a.this.fkt.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.fkt.pK(8);
                    return;
                }
                a.this.fkt.bqO();
                a.this.fkt.pK(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void al(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.fkt != null) {
                a.this.fkt.completePullRefresh();
                a.this.fkt.hideLoadingView();
                d dVar = a.this.fkt;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.fkt.pK(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i fkw = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bk bkVar) {
            a.this.a(a.this.mTbPageContext, bkVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.fku != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.fku.setSortType(cVar.type);
                a.this.fku.setLat(cVar.lat);
                a.this.fku.setLng(cVar.lng);
                a.this.fku.jC(cVar.fkj);
                a.this.fku.refreshData();
            }
        }
    };
    private f.c fkx = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.fku != null) {
                a.this.fku.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fks = z;
        this.fku = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.fku.a(this.fjb);
        this.fkt = new d(this.mTbPageContext);
        this.fkt.a(this.fkw);
        this.fkt.setListPullRefreshListener(this.fkx);
        this.fkt.b(this.Uf);
        this.fkt.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.fkv = str.equals("16:9");
            }
            this.fkt.a(this.fks, list, str2, str3, this.fkv, false);
            this.fku.setEntryName(str2);
            this.fku.setLabelName(str3);
            this.fku.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.fku.jB(this.fkv);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.fku.refreshData();
    }

    public View getRootView() {
        return this.fkt.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.fkt != null) {
            this.fkt.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bk bkVar, String str) {
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            an s = new an("c12116").s("obj_id", bkVar.aQS().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                s.dh("locate_type", this.entryName);
            }
            TiebaStatic.log(s);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bk bkVar2 : this.fku.brI()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData U(bk bkVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
        alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.fku != null) {
            this.fku.onDestroy();
            this.fku = null;
        }
        if (this.fkt != null) {
            this.fkt.onDestroy();
            this.fkt = null;
        }
    }
}
