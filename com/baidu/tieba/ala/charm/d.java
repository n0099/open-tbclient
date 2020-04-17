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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.charm.view.CharmItemView;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private boolean aMq;
    private String aMr;
    private TextView evl;
    private ALaCharmCardActivity faA;
    private CommonEmptyView faB;
    private com.baidu.tieba.ala.charm.view.g faC;
    private View faD;
    private String faE;
    private View.OnClickListener faF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView far;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.faA = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aMq = z;
        this.aMr = str3;
        this.faE = str5;
        this.mRootView = this.faA.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.faB = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.g.toLogin_text);
            String string = this.faA.getString(a.i.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.faF);
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(0);
        }
        this.faC = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.faC);
        this.mListView.setEmptyView(this.faB);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.faC.getItem(i));
            }
        });
        this.evl = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.far == null) {
            this.far = new PbListView(this.faA);
            this.far.setTextColor(this.faA.getResources().getColor(a.d.sdk_cp_cont_j));
            this.far.setSkinType(0);
            this.far.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.far.createView();
        }
    }

    public void a(List<com.baidu.live.data.g> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.aMq) {
            dl(j);
        }
        this.faC.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<com.baidu.live.data.g> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.aMq && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.faA.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.e.sdk_ds128) + paddingBottom);
            this.faD = this.mRootView.findViewById(a.g.layout_bottom);
            this.faD.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.g.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.fcm.setData(alaLiveUserInfoData);
            charmItemView.fci.setTextColor(1728053247);
            charmItemView.fcl.setVisibility(8);
            if (!TextUtils.isEmpty(this.faE)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        com.baidu.live.data.g gVar = list.get(i);
                        if (gVar != null && gVar.aqe != null && String.valueOf(gVar.aqe.userId).equals(this.faE)) {
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
                                d.this.faD.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.faD.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void jm(boolean z) {
        if (z) {
            this.faB.reset();
            this.faB.setTitle(a.i.online_empty_text);
            this.faB.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.faB.setVisibility(0);
            this.faB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.VI();
                }
            });
            return;
        }
        this.faB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.g gVar) {
        if (gVar != null && gVar.aqe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.faA.getPageContext().getPageActivity(), gVar.aqe.userId + "", gVar.aqe.userName, gVar.aqe.portrait, gVar.aqe.sex, gVar.aqe.levelId, null, null, 0L, gVar.aqe.fansCount, gVar.aqe.fansCount, gVar.aqe.userStatus, this.mGroupId, this.mLiveId, this.aMq, this.aMr, null, gVar.aqe.userName, this.mOtherParams)));
        }
    }

    public void dk(long j) {
        if (this.evl != null) {
            this.evl.setText(String.format(this.faA.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void dl(long j) {
        ((TextView) this.mRootView.findViewById(a.g.tv_value_total)).setText(String.format(this.faA.getString(a.i.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.faB.reset();
        this.faB.setTitle(a.i.sdk_net_fail_tip);
        this.faB.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.faB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.faB.setVisibility(0);
    }

    public void blt() {
        this.faB.setVisibility(8);
    }

    public void ad(String str, boolean z) {
        this.mListView.setNextPage(this.far);
        this.far.endLoadDataWithNoMore(str);
        if (z) {
            this.far.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.VI();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }
}
