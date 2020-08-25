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
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.charm.view.CharmItemView;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private String aAE;
    private boolean bbH;
    private CommonEmptyView bgl;
    private PbListView fPV;
    private ALaCharmCardActivity fQe;
    private com.baidu.tieba.ala.charm.view.g fQf;
    private View fQg;
    private String fQh;
    private View.OnClickListener fQi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private TextView fmc;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.fQe = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bbH = z;
        this.aAE = str3;
        this.fQh = str5;
        this.mRootView = this.fQe.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.bgl = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.g.toLogin_text);
            String string = this.fQe.getString(a.i.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.fQi);
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(0);
        }
        this.fQf = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fQf);
        this.mListView.setEmptyView(this.bgl);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.fQf.getItem(i));
            }
        });
        this.fmc = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.fPV == null) {
            this.fPV = new PbListView(this.fQe);
            this.fPV.setTextColor(this.fQe.getResources().getColor(a.d.sdk_cp_cont_j));
            this.fPV.setSkinType(0);
            this.fPV.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.fPV.createView();
        }
    }

    public void a(List<j> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bbH) {
            dP(j);
        }
        this.fQf.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<j> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bbH && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.fQe.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.e.sdk_ds128) + paddingBottom);
            this.fQg = this.mRootView.findViewById(a.g.layout_bottom);
            this.fQg.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.g.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.fRR.setData(alaLiveUserInfoData);
            charmItemView.fRN.setTextColor(1728053247);
            charmItemView.fRQ.setVisibility(8);
            if (!TextUtils.isEmpty(this.fQh)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        j jVar = list.get(i);
                        if (jVar != null && jVar.aDE != null && String.valueOf(jVar.aDE.userId).equals(this.fQh)) {
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
                                d.this.fQg.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.fQg.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void kU(boolean z) {
        if (z) {
            this.bgl.reset();
            this.bgl.setTitle(a.i.online_empty_text);
            this.bgl.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bgl.setVisibility(0);
            this.bgl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.age();
                }
            });
            return;
        }
        this.bgl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        if (jVar != null && jVar.aDE != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.fQe.getPageContext().getPageActivity(), jVar.aDE.userId + "", jVar.aDE.userName, jVar.aDE.portrait, jVar.aDE.sex, jVar.aDE.levelId, null, null, 0L, jVar.aDE.fansCount, jVar.aDE.fansCount, jVar.aDE.userStatus, this.mGroupId, this.mLiveId, this.bbH, this.aAE, null, jVar.aDE.userName, this.mOtherParams)));
        }
    }

    public void dO(long j) {
        if (this.fmc != null) {
            this.fmc.setText(String.format(this.fQe.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void dP(long j) {
        ((TextView) this.mRootView.findViewById(a.g.tv_value_total)).setText(String.format(this.fQe.getString(a.i.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bgl.reset();
        this.bgl.setTitle(a.i.sdk_net_fail_tip);
        this.bgl.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bgl.setVisibility(0);
    }

    public void bFW() {
        this.bgl.setVisibility(8);
    }

    public void au(String str, boolean z) {
        this.mListView.setNextPage(this.fPV);
        this.fPV.endLoadDataWithNoMore(str);
        if (z) {
            this.fPV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.age();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void age() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }
}
