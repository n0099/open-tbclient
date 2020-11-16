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
    private String aDE;
    private String aZG;
    private boolean bja;
    private CommonEmptyView bnY;
    private TextView fPh;
    private PbListView gvb;
    private ALaCharmCardActivity gvk;
    private com.baidu.tieba.ala.charm.view.g gvl;
    private View gvm;
    private View.OnClickListener gvn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
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
        this.gvk = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bja = z;
        this.aDE = str3;
        this.aZG = str5;
        this.mRootView = this.gvk.getLayoutInflater().inflate(a.g.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.f.toLogin_text);
            String string = this.gvk.getString(a.h.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.gvn);
            this.mRootView.findViewById(a.f.toLogin_layout).setVisibility(0);
        }
        this.gvl = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gvl);
        this.mListView.setEmptyView(this.bnY);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.gvl.getItem(i));
            }
        });
        this.fPh = (TextView) this.mRootView.findViewById(a.f.top_text);
        if (this.gvb == null) {
            this.gvb = new PbListView(this.gvk);
            this.gvb.setTextColor(this.gvk.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gvb.setSkinType(0);
            this.gvb.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gvb.createView();
        }
    }

    public void a(List<p> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.bja) {
            ex(j);
        }
        this.gvl.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<p> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.bja && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.gvk.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.d.sdk_ds128) + paddingBottom);
            this.gvm = this.mRootView.findViewById(a.f.layout_bottom);
            this.gvm.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.f.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.gwX.setData(alaLiveUserInfoData);
            charmItemView.gwT.setTextColor(1728053247);
            charmItemView.gwW.setVisibility(8);
            if (!TextUtils.isEmpty(this.aZG)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        p pVar = list.get(i);
                        if (pVar != null && pVar.aHk != null && String.valueOf(pVar.aHk.userId).equals(this.aZG)) {
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
                                d.this.gvm.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.gvm.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void ds(boolean z) {
        if (z) {
            this.bnY.reset();
            this.bnY.setTitle(a.h.online_empty_text);
            this.bnY.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bnY.setVisibility(0);
            this.bnY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.anl();
                }
            });
            return;
        }
        this.bnY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar != null && pVar.aHk != null && pVar.aHk.disableClick == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.gvk.getPageContext().getPageActivity(), pVar.aHk.userId + "", pVar.aHk.userName, pVar.aHk.portrait, pVar.aHk.sex, pVar.aHk.levelId, null, null, 0L, pVar.aHk.fansCount, pVar.aHk.fansCount, pVar.aHk.userStatus, this.mGroupId, this.mLiveId, this.bja, this.aDE, null, pVar.aHk.userName, this.mOtherParams)));
        }
    }

    public void ew(long j) {
        if (this.fPh != null) {
            this.fPh.setText(String.format(this.gvk.getString(a.h.online_count), j.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void ex(long j) {
        ((TextView) this.mRootView.findViewById(a.f.tv_value_total)).setText(String.format(this.gvk.getString(a.h.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bnY.reset();
        this.bnY.setTitle(a.h.sdk_net_fail_tip);
        this.bnY.setRefreshButton(a.h.sdk_net_refresh_btn_text, onClickListener);
        this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bnY.setVisibility(0);
    }

    public void VB() {
        this.bnY.setVisibility(8);
    }

    public void aA(String str, boolean z) {
        this.mListView.setNextPage(this.gvb);
        this.gvb.endLoadDataWithNoMore(str);
        if (z) {
            this.gvb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.anl();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }
}
