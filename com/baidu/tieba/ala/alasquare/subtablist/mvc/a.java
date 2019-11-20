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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.d;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private boolean dDb;
    private d dDc;
    private AlaNewSquareSubListModel dDd;
    private String entryName;
    private TbPageContext mTbPageContext;
    private boolean dDe = false;
    private BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (a.this.dDd != null) {
                z = a.this.dDd.isHasMore();
            }
            if (a.this.dDc != null) {
                if (!z) {
                    a.this.dDc.aJi();
                    return;
                }
                a.this.dDd.aKn();
                a.this.dDc.aKo();
            }
        }
    };
    private AlaNewSquareSubListModel.a dBU = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void gI(boolean z) {
            if (a.this.mTbPageContext != null && a.this.dDc != null) {
                a.this.dDc.completePullRefresh();
                a.this.dDc.hideLoadingView();
                a.this.dDc.setData(a.this.dDd.getDatas());
                a.this.dDc.mo(a.this.dDd.getLiveCount());
                a.this.dDc.bo(a.this.dDd.getSortTypeList());
                if (a.this.dDd != null && a.this.dDd.getPn() == 0 && a.this.dDc.getListView() != null) {
                    a.this.dDc.getListView().smoothScrollToPosition(0);
                }
                if (v.getCount(a.this.dDd.getDatas()) == 0) {
                    a.this.dDc.a(a.this.mTbPageContext.getString(R.string.no_data_text), a.this.mOnClickListener, true);
                    a.this.dDc.mn(8);
                    return;
                }
                a.this.dDc.aJm();
                a.this.dDc.mn(0);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void O(int i, String str) {
            if (a.this.mTbPageContext != null && a.this.dDc != null) {
                a.this.dDc.completePullRefresh();
                a.this.dDc.hideLoadingView();
                d dVar = a.this.dDc;
                if (TextUtils.isEmpty(str)) {
                    str = a.this.mTbPageContext.getString(R.string.no_data_text);
                }
                dVar.a(str, a.this.mOnClickListener, true);
                a.this.dDc.mn(8);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.refreshData();
        }
    };
    private h dDf = new h() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.4
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(int i, String str, bh bhVar) {
            a.this.a(a.this.mTbPageContext, bhVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(c cVar) {
            if (a.this.dDd != null && cVar != null && !StringUtils.isNull(cVar.type)) {
                a.this.dDd.setSortType(cVar.type);
                a.this.dDd.setLat(cVar.lat);
                a.this.dDd.setLng(cVar.lng);
                a.this.dDd.gL(cVar.dCS);
                a.this.dDd.refreshData();
            }
        }
    };
    private h.c dDg = new h.c() { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.a.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (a.this.dDd != null) {
                a.this.dDd.refreshData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.dDb = z;
        this.dDd = new AlaNewSquareSubListModel(this.mTbPageContext);
        this.dDd.a(this.dBU);
        this.dDc = new d(this.mTbPageContext);
        this.dDc.a(this.dDf);
        this.dDc.setListPullRefreshListener(this.dDg);
        this.dDc.b(this.xE);
        this.dDc.showLoadingView();
    }

    public void a(String str, String str2, String str3, List<String> list) {
        if (!StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.dDe = str.equals("16:9");
            }
            this.dDc.a(this.dDb, list, str2, str3, this.dDe, false);
            this.dDd.setEntryName(str2);
            this.dDd.setLabelName(str3);
            this.dDd.setSortType(v.isEmpty(list) ? "" : list.get(0));
            this.dDd.gK(this.dDe);
            this.entryName = str2;
        }
    }

    public void refreshData() {
        this.dDd.refreshData();
    }

    public View getRootView() {
        return this.dDc.getRootView();
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.dDc != null) {
            this.dDc.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bh bhVar, String str) {
        if (tbPageContext != null && bhVar != null && bhVar.aiE() != null && bhVar.aiX() != null) {
            an p = new an("c12116").p("obj_id", bhVar.aiX().live_id);
            if (!StringUtils.isNull(this.entryName)) {
                p.bS("locate_type", this.entryName);
            }
            TiebaStatic.log(p);
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bh bhVar2 : this.dDd.aKe()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_category", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
        alaLiveInfoCoreData.userName = bhVar.aiE().getUserName();
        return alaLiveInfoCoreData;
    }

    public void onDestroy() {
        if (this.dDd != null) {
            this.dDd.onDestroy();
            this.dDd = null;
        }
        if (this.dDc != null) {
            this.dDc.onDestroy();
            this.dDc = null;
        }
    }
}
