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
/* loaded from: classes11.dex */
public class d {
    private String aGB;
    private String beR;
    private boolean boZ;
    private CommonEmptyView bxT;
    private ALaCharmCardActivity gPH;
    private com.baidu.tieba.ala.charm.view.g gPI;
    private View gPJ;
    private View.OnClickListener gPK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView gPy;
    private TextView ggF;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.gPH = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.boZ = z;
        this.aGB = str3;
        this.beR = str5;
        this.mRootView = this.gPH.getLayoutInflater().inflate(a.g.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.f.toLogin_text);
            String string = this.gPH.getString(a.h.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gPK);
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(0);
        }
        this.gPI = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext(), this.boZ);
        this.gPI.setLiveId(this.mLiveId);
        this.gPI.a(this.mListView);
        this.mListView.setAdapter((ListAdapter) this.gPI);
        this.mListView.setEmptyView(this.bxT);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gPI.getItem(i));
            }
        });
        this.ggF = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gPy == null) {
            this.gPy = new PbListView(this.gPH);
            this.gPy.setTextColor(this.gPH.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gPy.setSkinType(0);
            this.gPy.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gPy.createView();
        }
    }

    public void a(List<q> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.boZ) {
            fa(j);
        }
        this.gPI.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<q> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.boZ && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gPH.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.d.sdk_ds128) + paddingBottom);
            this.gPJ = this.mRootView.findViewById(a.f.layout_bottom);
            this.gPJ.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.f.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.gRv.setData(alaLiveUserInfoData);
            charmItemView.gRr.setTextColor(1728053247);
            charmItemView.gRu.setVisibility(8);
            if (!TextUtils.isEmpty(this.beR)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        q qVar = list.get(i);
                        if (qVar != null && qVar.aKu != null && String.valueOf(qVar.aKu.userId).equals(this.beR)) {
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
                                d.this.gPJ.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gPJ.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void dM(boolean z) {
        if (z) {
            this.bxT.reset();
            this.bxT.setTitle(a.h.online_empty_text);
            this.bxT.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bxT.setVisibility(0);
            this.bxT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.arG();
                }
            });
            return;
        }
        this.bxT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        if (qVar != null && qVar.aKu != null && qVar.aKu.disableClick == 0) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.gPH.getPageContext().getPageActivity(), qVar.aKu.userId + "", qVar.aKu.userName, qVar.aKu.portrait, qVar.aKu.sex, qVar.aKu.levelId, null, null, 0L, qVar.aKu.fansCount, qVar.aKu.fansCount, qVar.aKu.userStatus, this.mGroupId, this.mLiveId, this.boZ, this.aGB, null, qVar.aKu.userName);
            alaPersonCardActivityConfig.setOtherParams(this.mOtherParams);
            alaPersonCardActivityConfig.setExtInfo(qVar.aKu.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void eZ(long j) {
        if (this.ggF != null) {
            this.ggF.setText(String.format(this.gPH.getString(a.h.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void fa(long j) {
        ((TextView) this.mRootView.findViewById(a.f.tv_value_total)).setText(String.format(this.gPH.getString(a.h.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bxT.reset();
        this.bxT.setTitle(a.h.sdk_net_fail_tip);
        this.bxT.setRefreshButton(a.h.sdk_net_refresh_btn_text, onClickListener);
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bxT.setVisibility(0);
    }

    public void Zj() {
        this.bxT.setVisibility(8);
    }

    public void aC(String str, boolean z) {
        this.mListView.setNextPage(this.gPy);
        this.gPy.endLoadDataWithNoMore(str);
        if (z) {
            this.gPy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.arG();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }

    public void t(long j, int i) {
        ArrayList<q> data = this.gPI.getData();
        if (data != null && data.size() != 0) {
            int i2 = -1;
            for (int i3 = 0; i3 < data.size(); i3++) {
                if (data.get(i3).aKu.userId == j) {
                    i2 = i3;
                }
            }
            if (i2 != -1) {
                this.gPI.bH(i2, i);
            }
        }
    }
}
