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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
    private boolean fAX;
    private d fAY;
    private AlaNewSquareSubListModel fAZ;
    private TbPageContext mTbPageContext;
    private boolean fBa = false;
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.fAZ != null) {
                z = a.this.fAZ.isHasMore();
            }
            if (a.this.fAY != null) {
                if (!z) {
                    a.this.fAY.bwS();
                    return;
                }
                a.this.fAZ.bxZ();
                a.this.fAY.bya();
            }
        }
    };
    private AlaNewSquareSubListModel.a fzG = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void kq(boolean z) {
            if (a.this.mTbPageContext != null && a.this.fAY != null) {
                a.this.fAY.completePullRefresh();
                a.this.fAY.hideLoadingView();
                a.this.fAY.setData(a.this.fAZ.getDatas());
                a.this.fAY.qB(a.this.fAZ.getLiveCount());
                a.this.fAY.bF(a.this.fAZ.getSortTypeList());
                if (a.this.fAZ != null && a.this.fAZ.getPn() == 0 && a.this.fAY.getListView() != null) {
                    a.this.fAY.getListView().smoothScrollToPosition(0);
                }
                if (x.getCount(a.this.fAZ.getDatas()) == 0) {
                    a.this.fAY.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.fAY.qA(8);
                    return;
                }
                a.this.fAY.bwX();
                a.this.fAY.qA(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ao(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.fAY != null) {
                a.this.fAY.completePullRefresh();
                a.this.fAY.hideLoadingView();
                d dVar = a.this.fAY;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.fAY.qA(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private i fBb = new i() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bv bvVar) {
            a.this.a(a.this.mTbPageContext, bvVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
            if (a.this.fAZ != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.fAZ.setSortType(cVar.type);
                a.this.fAZ.setLat(cVar.lat);
                a.this.fAZ.setLng(cVar.lng);
                a.this.fAZ.kt(cVar.fAO);
                a.this.fAZ.refreshData();
            }
        }
    };
    private f.c fBc = new f.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (a.this.fAZ != null) {
                a.this.fAZ.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fAX = z;
        this.fAZ = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.fAZ.a(this.fzG);
        this.fAY = new d(this.mTbPageContext);
        this.fAY.a(this.fBb);
        this.fAY.setListPullRefreshListener(this.fBc);
        this.fAY.b(this.UC);
        this.fAY.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.fBa = str.equals("16:9");
            }
            this.fAY.a(this.fAX, list, str2, str3, this.fBa, false);
            this.fAZ.setEntryName(str2);
            this.fAZ.setLabelName(str3);
            this.fAZ.setSortType(x.isEmpty(list) ? "" : list.get(0));
            this.fAZ.ks(this.fBa);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.fAZ.refreshData();
    }

    public View getRootView() {
        return this.fAY.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.fAY != null) {
            this.fAY.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bv bvVar, String str) {
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            ap t = new ap("c12116").t("obj_id", bvVar.aWF().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                t.dn("locate_type", this.entryName);
            }
            TiebaStatic.log(t);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bv bvVar2 : this.fAZ.bxQ()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bvVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bv bvVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
        alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.fAZ != null) {
            this.fAZ.onDestroy();
            this.fAZ = null;
        }
        if (this.fAY != null) {
            this.fAY.onDestroy();
            this.fAY = null;
        }
    }
}
