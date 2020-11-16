package com.baidu.tieba.ala.charm.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private String aDE;
    private boolean bja;
    private CommonEmptyView bnY;
    private TextView fPh;
    private String guO;
    private String guP;
    private String guQ;
    private int guU;
    private PbListView gvb;
    private ALaCharmCardActivity gvk;
    private a gwa;
    private View gwv;
    private View gww;
    private LinearLayout gwx;
    private f gwy;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;
    private String mUserId;
    private String mUserName;
    private View.OnClickListener gwd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gwa != null) {
                    ALaCharmData item = b.this.gwa.getItem(intValue);
                    if (item == null || item.disableClick == 0) {
                        b.this.b(item);
                        if (!b.this.bja) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                                String uQ = com.baidu.tieba.ala.charm.g.uQ(b.this.guU);
                                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_HEAD);
                                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ);
                                alaStaticItem.addParams("pos", (intValue + 1) + "");
                                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                            }
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener gwe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gwa != null && ViewHelper.checkUpIsLogin(b.this.gvk.getPageContext().getPageActivity()) && (item = b.this.gwa.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gwa.notifyDataSetChanged();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.gvk.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_detail");
                    com.baidu.live.view.a.VO().a(item.pay_userid, fVar);
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", QMStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", QMStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", QMStaticManager.FEED_ID);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        String str = "";
                        if (b.this.guU != 2) {
                            if (b.this.guU != 1) {
                                if (b.this.guU == 3) {
                                    str = "charm_day";
                                }
                            } else {
                                str = "charm_all";
                            }
                        } else {
                            str = "charm_week";
                        }
                        alaStaticItem.addParams("loc", str);
                        alaStaticItem.addParams("other_params", b.this.mOtherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    if (!b.this.bja) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String uQ = com.baidu.tieba.ala.charm.g.uQ(b.this.guU);
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.FOLLOWCLICK_CHARMLIST);
                            alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ);
                            alaStaticItem2.addParams("pos", (intValue + 1) + "");
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener gvn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.bja && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                String uQ = com.baidu.tieba.ala.charm.g.uQ(b.this.guU);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_login");
                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View.OnClickListener gwz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gvk != null) {
                b.this.gvk.bQu();
            }
            if (view.getTag() == null) {
                if (!b.this.bja) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        String uQ = com.baidu.tieba.ala.charm.g.uQ(b.this.guU);
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_rank");
                        alaStaticItem.addParams("other_params", b.this.mOtherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        return;
                    }
                    return;
                }
                return;
            }
            int[] iArr = (int[]) view.getTag();
            int i = iArr[0];
            int i2 = iArr[1];
            String str = "";
            if (i == 0) {
                str = "to_list";
            } else if (i == 1) {
                str = "to_list_hundred";
            } else if (i == 2) {
                str = "to_transcend";
            } else if (i == 3) {
                if (i2 <= 100) {
                    str = "to_transcend";
                } else {
                    str = "to_list_hundred";
                }
            }
            if (!b.this.bja) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    String uQ2 = com.baidu.tieba.ala.charm.g.uQ(b.this.guU);
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ2);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                    alaStaticItem2.addParams("other_params", b.this.mOtherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, int i, String str4, String str5, String str6, String str7, String str8) {
        this.guU = -1;
        this.gvk = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bja = z;
        this.aDE = str3;
        this.guU = i;
        this.mUserId = str4;
        this.mUserName = str5;
        this.guO = str6;
        this.guP = str7;
        this.guQ = str8;
        this.mRootView = this.gvk.getLayoutInflater().inflate(a.g.ala_charm_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gwv = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gww = this.mRootView.findViewById(a.f.toLogin_text);
        this.gww.setOnClickListener(this.gvn);
        if (TbadkCoreApplication.isLogin()) {
            this.gwv.setVisibility(8);
        } else {
            this.gwv.setVisibility(0);
        }
        this.gwa = new a(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.gwa);
        this.mListView.setEmptyView(this.bnY);
        this.fPh = (TextView) this.mRootView.findViewById(a.f.top_text);
        this.fPh.setText(com.baidu.tieba.ala.charm.g.B(aLaCharmCardActivity.getPageContext().getPageActivity(), this.guU));
        if (this.gvb == null) {
            this.gvb = new PbListView(this.gvk);
            this.gvb.setTextColor(this.gvk.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gvb.setSkinType(0);
            this.gvb.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gvb.createView();
        }
        this.gwa.n(this.gwe);
        this.gwa.o(this.gwd);
        this.gwa.p(this.gwz);
        this.gwx = (LinearLayout) this.mRootView.findViewById(a.f.bottomImproveCard_layout);
    }

    public void bQM() {
        if (!this.bja && this.gwv != null && this.gwv.getVisibility() == 0) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                String uQ = com.baidu.tieba.ala.charm.g.uQ(this.guU);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "login_see");
                alaStaticItem.addParams("other_params", this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    public void a(ArrayList<ALaCharmData> arrayList, boolean z, long j) {
        if (z) {
            this.gwa.setData(arrayList);
        } else {
            this.gwa.ab(arrayList);
        }
        b(arrayList, j);
    }

    private void b(ArrayList<ALaCharmData> arrayList, long j) {
        long j2;
        long j3;
        long j4;
        if (this.guU == 3 && !this.bja && TbadkCoreApplication.isLogin() && this.gvk != null) {
            if (this.gwy != null) {
                this.gwx.removeView(this.gwy.getRootView());
            }
            final int dimensionPixelSize = this.gvk.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
            final int paddingLeft = this.mListView.getPaddingLeft();
            final int paddingTop = this.mListView.getPaddingTop();
            final int paddingRight = this.mListView.getPaddingRight();
            final int paddingBottom = this.mListView.getPaddingBottom();
            this.gwy = new f(this.gvk.getPageContext().getPageActivity(), this.gwz);
            this.gwy.ma(this.bja);
            this.gwy.setOtherParams(this.mOtherParams);
            this.gwy.uT(this.guU);
            com.baidu.tieba.ala.charm.data.a aVar = new com.baidu.tieba.ala.charm.data.a();
            aVar.userId = this.guO;
            aVar.userName = this.guP;
            aVar.portrait = this.guQ;
            aVar.totalPrice = j;
            if (j <= 0) {
                aVar.type = 0;
                this.gwy.a(aVar);
                this.gwx.addView(this.gwy.getRootView());
                this.gwx.setVisibility(0);
                this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, dimensionPixelSize);
                return;
            }
            int i = 0;
            if (arrayList != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= arrayList.size()) {
                        break;
                    } else if (!TextUtils.equals(arrayList.get(i3).user_id, this.guO)) {
                        i2 = i3 + 1;
                    } else {
                        i = i3 + 1;
                        break;
                    }
                }
            }
            if (i <= 0 || i > 100) {
                aVar.type = 1;
                if (arrayList == null || arrayList.isEmpty()) {
                    aVar.gvP = 1L;
                } else {
                    long j5 = 0;
                    try {
                        j5 = Long.parseLong(arrayList.get(arrayList.size() - 1).total_price);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    if (j > j5) {
                        j2 = 1;
                    } else {
                        j2 = (j5 - j) + 1;
                    }
                    aVar.gvP = j2;
                }
                this.gwy.a(aVar);
                this.gwx.addView(this.gwy.getRootView());
                this.gwx.setVisibility(0);
                this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, dimensionPixelSize);
                return;
            }
            if (i == 1) {
                aVar.type = 2;
            } else {
                aVar.type = 3;
                long j6 = 0;
                if (arrayList == null) {
                    j3 = 0;
                } else {
                    try {
                        j3 = Long.parseLong(arrayList.get(i - 2).total_price);
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                j6 = j3;
                if (j > j6) {
                    j4 = 1;
                } else {
                    j4 = (j6 - j) + 1;
                }
                aVar.gvP = j4;
            }
            aVar.grade = i;
            this.gwy.a(aVar);
            this.gwx.addView(this.gwy.getRootView());
            this.gwx.setVisibility(0);
            this.mListView.setClipToPadding(false);
            final int i4 = i - 1;
            this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.charm.view.b.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i5) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i5, int i6, int i7) {
                    if (i4 < i5 || i4 >= i5 + i6) {
                        b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, dimensionPixelSize + paddingBottom);
                        b.this.gwx.setVisibility(0);
                        return;
                    }
                    b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    b.this.gwx.setVisibility(8);
                }
            });
        }
    }

    public void Vz() {
        this.mListView.setNextPage(this.gvb);
        this.gvb.startLoadData();
    }

    public void Gy(String str) {
        this.mListView.setNextPage(this.gvb);
        this.gvb.endLoadDataWithNoMore(str);
    }

    public void ds(boolean z) {
        if (z) {
            this.bnY.reset();
            this.bnY.setTitle(a.h.charm_empty_text);
            this.bnY.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bnY.setVisibility(0);
            return;
        }
        this.bnY.setVisibility(8);
    }

    public void a(BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        if (onScrollToBottomListener != null) {
            this.mListView.setOnSrollToBottomListener(onScrollToBottomListener);
        }
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

    public void FZ() {
        if (this.gwy != null) {
            this.gwy.FZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.gvk.getPageContext().getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bja, this.aDE, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    public void az(String str, boolean z) {
        if (this.gwa != null) {
            this.gwa.az(str, z);
        }
    }
}
