package com.baidu.tieba.ala.charm;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.charm.view.CharmItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private String aGk;
    private String bdg;
    private boolean bns;
    private CommonEmptyView btg;
    private TextView fWX;
    private PbListView gDK;
    private ALaCharmCardActivity gDT;
    private com.baidu.tieba.ala.charm.view.g gDU;
    private View gDV;
    private View.OnClickListener gDW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.gDT = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bns = z;
        this.aGk = str3;
        this.bdg = str5;
        this.mRootView = this.gDT.getLayoutInflater().inflate(a.g.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.f.toLogin_text);
            String string = this.gDT.getString(a.h.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gDW);
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(0);
        }
        this.gDU = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext(), this.bns);
        this.gDU.setLiveId(this.mLiveId);
        this.gDU.a(this.mListView);
        this.mListView.setAdapter((ListAdapter) this.gDU);
        this.mListView.setEmptyView(this.btg);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gDU.getItem(i));
            }
        });
        this.fWX = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gDK == null) {
            this.gDK = new PbListView(this.gDT);
            this.gDK.setTextColor(this.gDT.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gDK.setSkinType(0);
            this.gDK.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gDK.createView();
        }
    }

    public void a(List<p> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bns) {
            fa(j);
        }
        this.gDU.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<p> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bns && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gDT.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.d.sdk_ds128) + paddingBottom);
            this.gDV = this.mRootView.findViewById(a.f.layout_bottom);
            this.gDV.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.f.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.gFI.setData(alaLiveUserInfoData);
            charmItemView.gFE.setTextColor(1728053247);
            charmItemView.gFH.setVisibility(8);
            if (!TextUtils.isEmpty(this.bdg)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        p pVar = list.get(i);
                        if (pVar != null && pVar.aJV != null && String.valueOf(pVar.aJV.userId).equals(this.bdg)) {
                            break;
                        }
                        i2 = i + 1;
                    }
                }
                i = -1;
                if (i + 1 > 0 && i + 1 <= 100) {
                    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.charm.d.2
                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScrollStateChanged(AbsListView absListView, int i3) {
                        }

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                            if (i >= i3 && i < i3 + i4) {
                                d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom);
                                d.this.gDV.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gDV.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void dG(boolean z) {
        if (z) {
            this.btg.reset();
            this.btg.setTitle(a.h.online_empty_text);
            this.btg.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.btg.setVisibility(0);
            this.btg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.aqt();
                }
            });
            return;
        }
        this.btg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar != null && pVar.aJV != null && pVar.aJV.disableClick == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.gDT.getPageContext().getPageActivity(), pVar.aJV.userId + "", pVar.aJV.userName, pVar.aJV.portrait, pVar.aJV.sex, pVar.aJV.levelId, null, null, 0L, pVar.aJV.fansCount, pVar.aJV.fansCount, pVar.aJV.userStatus, this.mGroupId, this.mLiveId, this.bns, this.aGk, null, pVar.aJV.userName, this.mOtherParams)));
        }
    }

    public void eZ(long j) {
        if (this.fWX != null) {
            this.fWX.setText(String.format(this.gDT.getString(a.h.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void fa(long j) {
        ((TextView) this.mRootView.findViewById(a.f.tv_value_total)).setText(String.format(this.gDT.getString(a.h.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void m(View.OnClickListener onClickListener) {
        this.btg.reset();
        this.btg.setTitle(a.h.sdk_net_fail_tip);
        this.btg.setRefreshButton(a.h.sdk_net_refresh_btn_text, onClickListener);
        this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btg.setVisibility(0);
    }

    public void Yb() {
        this.btg.setVisibility(8);
    }

    public void aB(String str, boolean z) {
        this.mListView.setNextPage(this.gDK);
        this.gDK.endLoadDataWithNoMore(str);
        if (z) {
            this.gDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.aqt();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }

    public void r(long j, int i) {
        ArrayList<p> data = this.gDU.getData();
        if (data != null && data.size() != 0) {
            int i2 = -1;
            for (int i3 = 0; i3 < data.size(); i3++) {
                if (data.get(i3).aJV.userId == j) {
                    i2 = i3;
                }
            }
            if (i2 != -1) {
                this.gDU.bI(i2, i);
            }
        }
    }
}
