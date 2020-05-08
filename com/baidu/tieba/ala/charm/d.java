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
    private boolean aMw;
    private String aMx;
    private TextView evq;
    private ALaCharmCardActivity faF;
    private CommonEmptyView faG;
    private com.baidu.tieba.ala.charm.view.g faH;
    private View faI;
    private String faJ;
    private View.OnClickListener faK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private PbListView faw;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;

    public d(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, String str4, String str5) {
        this.faF = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aMw = z;
        this.aMx = str3;
        this.faJ = str5;
        this.mRootView = this.faF.getLayoutInflater().inflate(a.h.online_list_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.faG = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        if (TbadkCoreApplication.isLogin()) {
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(8);
        } else {
            str4 = TextUtils.isEmpty(str4) ? "主播" : str4;
            TextView textView = (TextView) this.mRootView.findViewById(a.g.toLogin_text);
            String string = this.faF.getString(a.i.online_toLogin);
            Object[] objArr = new Object[1];
            objArr[0] = str4.length() > 5 ? str4.substring(0, 5) + StringHelper.STRING_MORE : str4;
            textView.setText(String.format(string, objArr));
            textView.setOnClickListener(this.faK);
            this.mRootView.findViewById(a.g.toLogin_layout).setVisibility(0);
        }
        this.faH = new com.baidu.tieba.ala.charm.view.g(aLaCharmCardActivity.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.faH);
        this.mListView.setEmptyView(this.faG);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.a(d.this.faH.getItem(i));
            }
        });
        this.evq = (TextView) this.mRootView.findViewById(a.g.top_text);
        if (this.faw == null) {
            this.faw = new PbListView(this.faF);
            this.faw.setTextColor(this.faF.getResources().getColor(a.d.sdk_cp_cont_j));
            this.faw.setSkinType(0);
            this.faw.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.faw.createView();
        }
    }

    public void a(List<com.baidu.live.data.g> list, AlaLiveUserInfoData alaLiveUserInfoData, long j) {
        if (this.aMw) {
            dl(j);
        }
        this.faH.setData(list);
        a(list, alaLiveUserInfoData);
    }

    private void a(List<com.baidu.live.data.g> list, AlaLiveUserInfoData alaLiveUserInfoData) {
        final int i;
        int i2 = 0;
        if (TbadkCoreApplication.isLogin() && !this.aMw && alaLiveUserInfoData != null) {
            final int paddingBottom = this.mListView.getPaddingBottom();
            final int dimensionPixelSize = this.faF.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128);
            this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getRight(), this.mListView.getResources().getDimensionPixelOffset(a.e.sdk_ds128) + paddingBottom);
            this.faI = this.mRootView.findViewById(a.g.layout_bottom);
            this.faI.setVisibility(0);
            CharmItemView charmItemView = (CharmItemView) this.mRootView.findViewById(a.g.item_bottom);
            charmItemView.setData(2, alaLiveUserInfoData.rank, alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.totalPrice, 0L);
            charmItemView.fcr.setData(alaLiveUserInfoData);
            charmItemView.fcn.setTextColor(1728053247);
            charmItemView.fcq.setVisibility(8);
            if (!TextUtils.isEmpty(this.faJ)) {
                if (list != null) {
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        com.baidu.live.data.g gVar = list.get(i);
                        if (gVar != null && gVar.aqk != null && String.valueOf(gVar.aqk.userId).equals(this.faJ)) {
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
                                d.this.faI.setVisibility(8);
                                return;
                            }
                            d.this.mListView.setPadding(d.this.mListView.getPaddingLeft(), d.this.mListView.getPaddingTop(), d.this.mListView.getPaddingRight(), paddingBottom + dimensionPixelSize);
                            d.this.faI.setVisibility(0);
                        }
                    });
                }
            }
        }
    }

    public void jm(boolean z) {
        if (z) {
            this.faG.reset();
            this.faG.setTitle(a.i.online_empty_text);
            this.faG.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.faG.setVisibility(0);
            this.faG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.VH();
                }
            });
            return;
        }
        this.faG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.g gVar) {
        if (gVar != null && gVar.aqk != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.faF.getPageContext().getPageActivity(), gVar.aqk.userId + "", gVar.aqk.userName, gVar.aqk.portrait, gVar.aqk.sex, gVar.aqk.levelId, null, null, 0L, gVar.aqk.fansCount, gVar.aqk.fansCount, gVar.aqk.userStatus, this.mGroupId, this.mLiveId, this.aMw, this.aMx, null, gVar.aqk.userName, this.mOtherParams)));
        }
    }

    public void dk(long j) {
        if (this.evq != null) {
            this.evq.setText(String.format(this.faF.getString(a.i.online_count), i.numFormatOverWanNaForAudienceNum(j)));
        }
    }

    private void dl(long j) {
        ((TextView) this.mRootView.findViewById(a.g.tv_value_total)).setText(String.format(this.faF.getString(a.i.charm_host_total_value), StringHelper.formatValue(j)));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void l(View.OnClickListener onClickListener) {
        this.faG.reset();
        this.faG.setTitle(a.i.sdk_net_fail_tip);
        this.faG.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.faG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.faG.setVisibility(0);
    }

    public void blr() {
        this.faG.setVisibility(8);
    }

    public void ad(String str, boolean z) {
        this.mListView.setNextPage(this.faw);
        this.faw.endLoadDataWithNoMore(str);
        if (z) {
            this.faw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.VH();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
    }
}
