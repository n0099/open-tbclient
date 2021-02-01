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
/* loaded from: classes11.dex */
public class d {
    private String aDB;
    private String bdi;
    private boolean bnF;
    private CommonEmptyView bwJ;
    private ALaCharmCardActivity gNH;
    private com.baidu.tieba.ala.charm.view.g gNI;
    private View gNJ;
    private View.OnClickListener gNK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView gNy;
    private TextView gel;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.gNH = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bnF = z;
        this.aDB = str3;
        this.bdi = str5;
        this.mRootView = this.gNH.getLayoutInflater().inflate(a.g.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.f.toLogin_text);
            String string = this.gNH.getString(a.h.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gNK);
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(0);
        }
        this.gNI = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext(), this.bnF);
        this.gNI.setLiveId(this.mLiveId);
        this.gNI.a(this.mListView);
        this.mListView.setAdapter((ListAdapter) this.gNI);
        this.mListView.setEmptyView(this.bwJ);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gNI.getItem(i));
            }
        });
        this.gel = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gNy == null) {
            this.gNy = new PbListView(this.gNH);
            this.gNy.setTextColor(this.gNH.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gNy.setSkinType(0);
            this.gNy.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gNy.createView();
        }
    }

    public void a(List<u> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bnF) {
            fg(j);
        }
        this.gNI.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<u> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bnF && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gNH.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.d.sdk_ds128) + paddingBottom);
            this.gNJ = this.mRootView.findViewById(a.f.layout_bottom);
            this.gNJ.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.f.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.gPv.setData(alaLiveUserInfoData);
            charmItemView.gPr.setTextColor(1728053247);
            charmItemView.gPu.setVisibility(8);
            if (!TextUtils.isEmpty(this.bdi)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        u uVar = list.get(i);
                        if (uVar != null && uVar.aId != null && String.valueOf(uVar.aId.userId).equals(this.bdi)) {
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
                                d.this.gNJ.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gNJ.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void dQ(boolean z) {
        if (z) {
            this.bwJ.reset();
            this.bwJ.setTitle(a.h.online_empty_text);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bwJ.setVisibility(0);
            this.bwJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.aoj();
                }
            });
            return;
        }
        this.bwJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar) {
        if (uVar != null && uVar.aId != null && uVar.aId.disableClick == 0) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.gNH.getPageContext().getPageActivity(), uVar.aId.userId + "", uVar.aId.userName, uVar.aId.portrait, uVar.aId.sex, uVar.aId.levelId, null, null, 0L, uVar.aId.fansCount, uVar.aId.fansCount, uVar.aId.userStatus, this.mGroupId, this.mLiveId, this.bnF, this.aDB, null, uVar.aId.userName);
            alaPersonCardActivityConfig.setOtherParams(this.mOtherParams);
            alaPersonCardActivityConfig.setExtInfo(uVar.aId.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void ff(long j) {
        if (this.gel != null) {
            this.gel.setText(String.format(this.gNH.getString(a.h.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void fg(long j) {
        ((TextView) this.mRootView.findViewById(a.f.tv_value_total)).setText(String.format(this.gNH.getString(a.h.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bwJ.reset();
        this.bwJ.setTitle(a.h.sdk_net_fail_tip);
        this.bwJ.setRefreshButton(a.h.sdk_net_refresh_btn_text, onClickListener);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bwJ.setVisibility(0);
    }

    public void WZ() {
        this.bwJ.setVisibility(8);
    }

    public void aB(String str, boolean z) {
        this.mListView.setNextPage(this.gNy);
        this.gNy.endLoadDataWithNoMore(str);
        if (z) {
            this.gNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.aoj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoj() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }

    public void t(long j, int i) {
        ArrayList<u> data = this.gNI.getData();
        if (data != null && data.size() != 0) {
            int i2 = -1;
            for (int i3 = 0; i3 < data.size(); i3++) {
                if (data.get(i3).aId.userId == j) {
                    i2 = i3;
                }
            }
            if (i2 != -1) {
                this.gNI.bE(i2, i);
            }
        }
    }
}
