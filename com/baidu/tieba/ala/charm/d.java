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
import com.baidu.live.data.q;
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
    private String aBO;
    private String bab;
    private boolean bkm;
    private CommonEmptyView btf;
    private PbListView gKS;
    private ALaCharmCardActivity gLb;
    private com.baidu.tieba.ala.charm.view.g gLc;
    private View gLd;
    private View.OnClickListener gLe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private TextView gbW;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.gLb = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bkm = z;
        this.aBO = str3;
        this.bab = str5;
        this.mRootView = this.gLb.getLayoutInflater().inflate(a.g.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.f.toLogin_text);
            String string = this.gLb.getString(a.h.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gLe);
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(0);
        }
        this.gLc = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext(), this.bkm);
        this.gLc.setLiveId(this.mLiveId);
        this.gLc.a(this.mListView);
        this.mListView.setAdapter((ListAdapter) this.gLc);
        this.mListView.setEmptyView(this.btf);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gLc.getItem(i));
            }
        });
        this.gbW = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gKS == null) {
            this.gKS = new PbListView(this.gLb);
            this.gKS.setTextColor(this.gLb.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gKS.setSkinType(0);
            this.gKS.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gKS.createView();
        }
    }

    public void a(List<q> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bkm) {
            fa(j);
        }
        this.gLc.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<q> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bkm && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gLb.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.d.sdk_ds128) + paddingBottom);
            this.gLd = this.mRootView.findViewById(a.f.layout_bottom);
            this.gLd.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.f.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.gMP.setData(alaLiveUserInfoData);
            charmItemView.gML.setTextColor(1728053247);
            charmItemView.gMO.setVisibility(8);
            if (!TextUtils.isEmpty(this.bab)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        q qVar = list.get(i);
                        if (qVar != null && qVar.aFH != null && String.valueOf(qVar.aFH.userId).equals(this.bab)) {
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
                                d.this.gLd.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gLd.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void dI(boolean z) {
        if (z) {
            this.btf.reset();
            this.btf.setTitle(a.h.online_empty_text);
            this.btf.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.btf.setVisibility(0);
            this.btf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.anL();
                }
            });
            return;
        }
        this.btf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        if (qVar != null && qVar.aFH != null && qVar.aFH.disableClick == 0) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.gLb.getPageContext().getPageActivity(), qVar.aFH.userId + "", qVar.aFH.userName, qVar.aFH.portrait, qVar.aFH.sex, qVar.aFH.levelId, null, null, 0L, qVar.aFH.fansCount, qVar.aFH.fansCount, qVar.aFH.userStatus, this.mGroupId, this.mLiveId, this.bkm, this.aBO, null, qVar.aFH.userName);
            alaPersonCardActivityConfig.setOtherParams(this.mOtherParams);
            alaPersonCardActivityConfig.setExtInfo(qVar.aFH.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void eZ(long j) {
        if (this.gbW != null) {
            this.gbW.setText(String.format(this.gLb.getString(a.h.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void fa(long j) {
        ((TextView) this.mRootView.findViewById(a.f.tv_value_total)).setText(String.format(this.gLb.getString(a.h.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.btf.reset();
        this.btf.setTitle(a.h.sdk_net_fail_tip);
        this.btf.setRefreshButton(a.h.sdk_net_refresh_btn_text, onClickListener);
        this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btf.setVisibility(0);
    }

    public void Vq() {
        this.btf.setVisibility(8);
    }

    public void aC(String str, boolean z) {
        this.mListView.setNextPage(this.gKS);
        this.gKS.endLoadDataWithNoMore(str);
        if (z) {
            this.gKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.anL();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }

    public void t(long j, int i) {
        ArrayList<q> data = this.gLc.getData();
        if (data != null && data.size() != 0) {
            int i2 = -1;
            for (int i3 = 0; i3 < data.size(); i3++) {
                if (data.get(i3).aFH.userId == j) {
                    i2 = i3;
                }
            }
            if (i2 != -1) {
                this.gLc.bH(i2, i);
            }
        }
    }
}
