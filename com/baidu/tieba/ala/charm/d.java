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
    private String aBm;
    private String aVr;
    private boolean bej;
    private CommonEmptyView bjf;
    private PbListView fTk;
    private ALaCharmCardActivity fTt;
    private com.baidu.tieba.ala.charm.view.g fTu;
    private View fTv;
    private View.OnClickListener fTw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private TextView foZ;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.fTt = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bej = z;
        this.aBm = str3;
        this.aVr = str5;
        this.mRootView = this.fTt.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.bjf = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.g.toLogin_text);
            String string = this.fTt.getString(a.i.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.fTw);
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(0);
        }
        this.fTu = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fTu);
        this.mListView.setEmptyView(this.bjf);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.fTu.getItem(i));
            }
        });
        this.foZ = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.fTk == null) {
            this.fTk = new PbListView(this.fTt);
            this.fTk.setTextColor(this.fTt.getResources().getColor(a.d.sdk_cp_cont_j));
            this.fTk.setSkinType(0);
            this.fTk.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.fTk.createView();
        }
    }

    public void a(List<m> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bej) {
            dQ(j);
        }
        this.fTu.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<m> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bej && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.fTt.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.e.sdk_ds128) + paddingBottom);
            this.fTv = this.mRootView.findViewById(a.g.layout_bottom);
            this.fTv.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.g.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.fVg.setData(alaLiveUserInfoData);
            charmItemView.fVc.setTextColor(1728053247);
            charmItemView.fVf.setVisibility(8);
            if (!TextUtils.isEmpty(this.aVr)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        m mVar = list.get(i);
                        if (mVar != null && mVar.aEz != null && String.valueOf(mVar.aEz.userId).equals(this.aVr)) {
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
                                d.this.fTv.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.fTv.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void kY(boolean z) {
        if (z) {
            this.bjf.reset();
            this.bjf.setTitle(a.i.online_empty_text);
            this.bjf.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bjf.setVisibility(0);
            this.bjf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.agO();
                }
            });
            return;
        }
        this.bjf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar != null && mVar.aEz != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.fTt.getPageContext().getPageActivity(), mVar.aEz.userId + "", mVar.aEz.userName, mVar.aEz.portrait, mVar.aEz.sex, mVar.aEz.levelId, null, null, 0L, mVar.aEz.fansCount, mVar.aEz.fansCount, mVar.aEz.userStatus, this.mGroupId, this.mLiveId, this.bej, this.aBm, null, mVar.aEz.userName, this.mOtherParams)));
        }
    }

    public void dP(long j) {
        if (this.foZ != null) {
            this.foZ.setText(String.format(this.fTt.getString(a.i.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void dQ(long j) {
        ((TextView) this.mRootView.findViewById(a.g.tv_value_total)).setText(String.format(this.fTt.getString(a.i.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bjf.reset();
        this.bjf.setTitle(a.i.sdk_net_fail_tip);
        this.bjf.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bjf.setVisibility(0);
    }

    public void bHn() {
        this.bjf.setVisibility(8);
    }

    public void au(String str, boolean z) {
        this.mListView.setNextPage(this.fTk);
        this.fTk.endLoadDataWithNoMore(str);
        if (z) {
            this.fTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.agO();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }
}
