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
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private String aEz;
    private String aZZ;
    private boolean bjr;
    private CommonEmptyView boq;
    private TextView fJI;
    private PbListView gpG;
    private ALaCharmCardActivity gpP;
    private com.baidu.tieba.ala.charm.view.g gpQ;
    private View gpR;
    private View.OnClickListener gpS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
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
        this.gpP = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bjr = z;
        this.aEz = str3;
        this.aZZ = str5;
        this.mRootView = this.gpP.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.g.toLogin_text);
            String string = this.gpP.getString(a.i.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gpS);
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(0);
        }
        this.gpQ = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gpQ);
        this.mListView.setEmptyView(this.boq);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gpQ.getItem(i));
            }
        });
        this.fJI = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.gpG == null) {
            this.gpG = new PbListView(this.gpP);
            this.gpG.setTextColor(this.gpP.getResources().getColor(a.d.sdk_cp_cont_j));
            this.gpG.setSkinType(0);
            this.gpG.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.gpG.createView();
        }
    }

    public void a(List<p> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bjr) {
            eb(j);
        }
        this.gpQ.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<p> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bjr && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gpP.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.e.sdk_ds128) + paddingBottom);
            this.gpR = this.mRootView.findViewById(a.g.layout_bottom);
            this.gpR.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.g.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.grC.setData(alaLiveUserInfoData);
            charmItemView.gry.setTextColor(1728053247);
            charmItemView.grB.setVisibility(8);
            if (!TextUtils.isEmpty(this.aZZ)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        p pVar = list.get(i);
                        if (pVar != null && pVar.aIe != null && String.valueOf(pVar.aIe.userId).equals(this.aZZ)) {
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
                                d.this.gpR.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gpR.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void dj(boolean z) {
        if (z) {
            this.boq.reset();
            this.boq.setTitle(a.i.online_empty_text);
            this.boq.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.boq.setVisibility(0);
            this.boq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.alt();
                }
            });
            return;
        }
        this.boq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar != null && pVar.aIe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.gpP.getPageContext().getPageActivity(), pVar.aIe.userId + "", pVar.aIe.userName, pVar.aIe.portrait, pVar.aIe.sex, pVar.aIe.levelId, null, null, 0L, pVar.aIe.fansCount, pVar.aIe.fansCount, pVar.aIe.userStatus, this.mGroupId, this.mLiveId, this.bjr, this.aEz, null, pVar.aIe.userName, this.mOtherParams)));
        }
    }

    public void ea(long j) {
        if (this.fJI != null) {
            this.fJI.setText(String.format(this.gpP.getString(a.i.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void eb(long j) {
        ((TextView) this.mRootView.findViewById(a.g.tv_value_total)).setText(String.format(this.gpP.getString(a.i.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.boq.reset();
        this.boq.setTitle(a.i.sdk_net_fail_tip);
        this.boq.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.boq.setVisibility(0);
    }

    public void TK() {
        this.boq.setVisibility(8);
    }

    public void aA(String str, boolean z) {
        this.mListView.setNextPage(this.gpG);
        this.gpG.endLoadDataWithNoMore(str);
        if (z) {
            this.gpG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.alt();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }
}
