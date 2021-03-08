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
import com.baidu.live.data.u;
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
/* loaded from: classes10.dex */
public class d {
    private String aFb;
    private String beK;
    private boolean bpf;
    private CommonEmptyView byj;
    private ALaCharmCardActivity gPE;
    private com.baidu.tieba.ala.charm.view.g gPF;
    private View gPG;
    private View.OnClickListener gPH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView gPv;
    private TextView gfU;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.gPE = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bpf = z;
        this.aFb = str3;
        this.beK = str5;
        this.mRootView = this.gPE.getLayoutInflater().inflate(a.g.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.f.toLogin_text);
            String string = this.gPE.getString(a.h.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gPH);
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(0);
        }
        this.gPF = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext(), this.bpf);
        this.gPF.setLiveId(this.mLiveId);
        this.gPF.a(this.mListView);
        this.mListView.setAdapter((ListAdapter) this.gPF);
        this.mListView.setEmptyView(this.byj);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gPF.getItem(i));
            }
        });
        this.gfU = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gPv == null) {
            this.gPv = new PbListView(this.gPE);
            this.gPv.setTextColor(this.gPE.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gPv.setSkinType(0);
            this.gPv.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gPv.createView();
        }
    }

    public void a(List<u> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bpf) {
            fg(j);
        }
        this.gPF.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<u> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bpf && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gPE.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.d.sdk_ds128) + paddingBottom);
            this.gPG = this.mRootView.findViewById(a.f.layout_bottom);
            this.gPG.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.f.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.gRs.setData(alaLiveUserInfoData);
            charmItemView.gRo.setTextColor(1728053247);
            charmItemView.gRr.setVisibility(8);
            if (!TextUtils.isEmpty(this.beK)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        u uVar = list.get(i);
                        if (uVar != null && uVar.aJD != null && String.valueOf(uVar.aJD.userId).equals(this.beK)) {
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
                                d.this.gPG.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gPG.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void dQ(boolean z) {
        if (z) {
            this.byj.reset();
            this.byj.setTitle(a.h.online_empty_text);
            this.byj.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.byj.setVisibility(0);
            this.byj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.aom();
                }
            });
            return;
        }
        this.byj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar) {
        if (uVar != null && uVar.aJD != null && uVar.aJD.disableClick == 0) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.gPE.getPageContext().getPageActivity(), uVar.aJD.userId + "", uVar.aJD.userName, uVar.aJD.portrait, uVar.aJD.sex, uVar.aJD.levelId, null, null, 0L, uVar.aJD.fansCount, uVar.aJD.fansCount, uVar.aJD.userStatus, this.mGroupId, this.mLiveId, this.bpf, this.aFb, null, uVar.aJD.userName);
            alaPersonCardActivityConfig.setOtherParams(this.mOtherParams);
            alaPersonCardActivityConfig.setExtInfo(uVar.aJD.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void ff(long j) {
        if (this.gfU != null) {
            this.gfU.setText(String.format(this.gPE.getString(a.h.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void fg(long j) {
        ((TextView) this.mRootView.findViewById(a.f.tv_value_total)).setText(String.format(this.gPE.getString(a.h.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.byj.reset();
        this.byj.setTitle(a.h.sdk_net_fail_tip);
        this.byj.setRefreshButton(a.h.sdk_net_refresh_btn_text, onClickListener);
        this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.byj.setVisibility(0);
    }

    public void Xc() {
        this.byj.setVisibility(8);
    }

    public void aB(String str, boolean z) {
        this.mListView.setNextPage(this.gPv);
        this.gPv.endLoadDataWithNoMore(str);
        if (z) {
            this.gPv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.aom();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aom() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }

    public void t(long j, int i) {
        ArrayList<u> data = this.gPF.getData();
        if (data != null && data.size() != 0) {
            int i2 = -1;
            for (int i3 = 0; i3 < data.size(); i3++) {
                if (data.get(i3).aJD.userId == j) {
                    i2 = i3;
                }
            }
            if (i2 != -1) {
                this.gPF.bF(i2, i);
            }
        }
    }
}
