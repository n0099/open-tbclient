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
import com.baidu.live.data.m;
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
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private String aEr;
    private String aYC;
    private boolean bhU;
    private CommonEmptyView bmS;
    private TextView fBn;
    private PbListView gfD;
    private ALaCharmCardActivity gfM;
    private com.baidu.tieba.ala.charm.view.g gfN;
    private View gfO;
    private View.OnClickListener gfP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
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
        this.gfM = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bhU = z;
        this.aEr = str3;
        this.aYC = str5;
        this.mRootView = this.gfM.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.bmS = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.g.toLogin_text);
            String string = this.gfM.getString(a.i.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gfP);
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(0);
        }
        this.gfN = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gfN);
        this.mListView.setEmptyView(this.bmS);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gfN.getItem(i));
            }
        });
        this.fBn = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.gfD == null) {
            this.gfD = new PbListView(this.gfM);
            this.gfD.setTextColor(this.gfM.getResources().getColor(a.d.sdk_cp_cont_j));
            this.gfD.setSkinType(0);
            this.gfD.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.gfD.createView();
        }
    }

    public void a(List<m> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bhU) {
            dZ(j);
        }
        this.gfN.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<m> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bhU && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gfM.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.e.sdk_ds128) + paddingBottom);
            this.gfO = this.mRootView.findViewById(a.g.layout_bottom);
            this.gfO.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.g.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.ghz.setData(alaLiveUserInfoData);
            charmItemView.ghv.setTextColor(1728053247);
            charmItemView.ghy.setVisibility(8);
            if (!TextUtils.isEmpty(this.aYC)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        m mVar = list.get(i);
                        if (mVar != null && mVar.aHD != null && String.valueOf(mVar.aHD.userId).equals(this.aYC)) {
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
                                d.this.gfO.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gfO.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void lw(boolean z) {
        if (z) {
            this.bmS.reset();
            this.bmS.setTitle(a.i.online_empty_text);
            this.bmS.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bmS.setVisibility(0);
            this.bmS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ajz();
                }
            });
            return;
        }
        this.bmS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar != null && mVar.aHD != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.gfM.getPageContext().getPageActivity(), mVar.aHD.userId + "", mVar.aHD.userName, mVar.aHD.portrait, mVar.aHD.sex, mVar.aHD.levelId, null, null, 0L, mVar.aHD.fansCount, mVar.aHD.fansCount, mVar.aHD.userStatus, this.mGroupId, this.mLiveId, this.bhU, this.aEr, null, mVar.aHD.userName, this.mOtherParams)));
        }
    }

    public void dY(long j) {
        if (this.fBn != null) {
            this.fBn.setText(String.format(this.gfM.getString(a.i.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void dZ(long j) {
        ((TextView) this.mRootView.findViewById(a.g.tv_value_total)).setText(String.format(this.gfM.getString(a.i.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bmS.reset();
        this.bmS.setTitle(a.i.sdk_net_fail_tip);
        this.bmS.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bmS.setVisibility(0);
    }

    public void SK() {
        this.bmS.setVisibility(8);
    }

    public void ay(String str, boolean z) {
        this.mListView.setNextPage(this.gfD);
        this.gfD.endLoadDataWithNoMore(str);
        if (z) {
            this.gfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ajz();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }
}
