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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    private boolean asS;
    private String asT;
    private TextView dUW;
    private String evR;
    private String evS;
    private String evT;
    private int evX;
    private a ewQ;
    private ALaCharmCardActivity ewd;
    private CommonEmptyView ewe;
    private View ewg;
    private PbListView ewh;
    private LinearLayout exi;
    private e exj;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;
    private String mUserId;
    private String mUserName;
    private View.OnClickListener ewi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewQ != null) {
                    b.this.a(b.this.ewQ.getItem(intValue));
                    if (!b.this.asS) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String oY = com.baidu.tieba.ala.charm.e.oY(b.this.evX);
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_HEAD);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
                            alaStaticItem.addParams("pos", (intValue + 1) + "");
                            alaStaticItem.addParams("other_params", b.this.mOtherParams);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener ewT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewQ != null && ViewHelper.checkUpIsLogin(b.this.ewd.getPageContext().getPageActivity()) && (item = b.this.ewQ.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.ewQ.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.ewd.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.Bj().a(item.pay_userid, bVar);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", QMStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", QMStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", QMStaticManager.FEED_ID);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        String str = "";
                        if (b.this.evX != 2) {
                            if (b.this.evX != 1) {
                                if (b.this.evX == 3) {
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
                    if (!b.this.asS) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String oY = com.baidu.tieba.ala.charm.e.oY(b.this.evX);
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.FOLLOWCLICK_CHARMLIST);
                            alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
                            alaStaticItem2.addParams("pos", (intValue + 1) + "");
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener ewj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.asS && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                String oY = com.baidu.tieba.ala.charm.e.oY(b.this.evX);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_login");
                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View.OnClickListener exk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ewd != null) {
                b.this.ewd.bdQ();
            }
            if (view.getTag() == null) {
                if (!b.this.asS) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        String oY = com.baidu.tieba.ala.charm.e.oY(b.this.evX);
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
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
            if (!b.this.asS) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    String oY2 = com.baidu.tieba.ala.charm.e.oY(b.this.evX);
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY2);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                    alaStaticItem2.addParams("other_params", b.this.mOtherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, int i, String str4, String str5, String str6, String str7, String str8) {
        this.evX = -1;
        this.ewd = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.asS = z;
        this.asT = str3;
        this.evX = i;
        this.mUserId = str4;
        this.mUserName = str5;
        this.evR = str6;
        this.evS = str7;
        this.evT = str8;
        this.mRootView = this.ewd.getLayoutInflater().inflate(a.h.ala_charm_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.ewe = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.ewg = this.mRootView.findViewById(a.g.toLogin_layout);
        this.ewg.setOnClickListener(this.ewj);
        if (TbadkCoreApplication.isLogin()) {
            this.ewg.setVisibility(8);
        } else {
            this.ewg.setVisibility(0);
        }
        if (UtilHelper.getRealScreenOrientation(this.ewd.getPageContext().getPageActivity()) == 2) {
            this.ewg.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg_corners);
        } else {
            this.ewg.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg);
        }
        this.ewQ = new a(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.ewQ);
        this.mListView.setEmptyView(this.ewe);
        this.dUW = (TextView) this.mRootView.findViewById(a.g.top_text);
        this.dUW.setText(com.baidu.tieba.ala.charm.e.A(aLaCharmCardActivity.getPageContext().getPageActivity(), this.evX));
        if (this.ewh == null) {
            this.ewh = new PbListView(this.ewd);
            this.ewh.setTextColor(this.ewd.getResources().getColor(a.d.sdk_cp_cont_j));
            this.ewh.setSkinType(0);
            this.ewh.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.ewh.createView();
        }
        this.ewQ.m(this.ewT);
        this.ewQ.n(this.ewi);
        this.ewQ.o(this.exk);
        this.exi = (LinearLayout) this.mRootView.findViewById(a.g.bottomImproveCard_layout);
    }

    public void bea() {
        if (!this.asS && this.ewg != null && this.ewg.getVisibility() == 0) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                String oY = com.baidu.tieba.ala.charm.e.oY(this.evX);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
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
            this.ewQ.setData(arrayList);
        } else {
            this.ewQ.T(arrayList);
        }
        b(arrayList, j);
    }

    private void b(ArrayList<ALaCharmData> arrayList, long j) {
        long j2;
        long j3;
        long j4;
        if (this.evX == 3 && !this.asS && TbadkCoreApplication.isLogin() && this.ewd != null) {
            if (this.exj != null) {
                this.exi.removeView(this.exj.getRootView());
            }
            final int dimensionPixelSize = this.ewd.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
            final int paddingLeft = this.mListView.getPaddingLeft();
            final int paddingTop = this.mListView.getPaddingTop();
            final int paddingRight = this.mListView.getPaddingRight();
            final int paddingBottom = this.mListView.getPaddingBottom();
            this.exj = new e(this.ewd.getPageContext().getPageActivity(), this.exk);
            this.exj.im(this.asS);
            this.exj.setOtherParams(this.mOtherParams);
            this.exj.pb(this.evX);
            com.baidu.tieba.ala.charm.data.a aVar = new com.baidu.tieba.ala.charm.data.a();
            aVar.userId = this.evR;
            aVar.userName = this.evS;
            aVar.portrait = this.evT;
            aVar.totalPrice = j;
            if (j <= 0) {
                aVar.type = 0;
                this.exj.a(aVar);
                this.exi.addView(this.exj.getRootView());
                this.exi.setVisibility(0);
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
                    } else if (!TextUtils.equals(arrayList.get(i3).user_id, this.evR)) {
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
                    aVar.ewF = 1L;
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
                    aVar.ewF = j2;
                }
                this.exj.a(aVar);
                this.exi.addView(this.exj.getRootView());
                this.exi.setVisibility(0);
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
                aVar.ewF = j4;
            }
            aVar.grade = i;
            this.exj.a(aVar);
            this.exi.addView(this.exj.getRootView());
            this.exi.setVisibility(0);
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
                        b.this.exi.setVisibility(0);
                        return;
                    }
                    b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    b.this.exi.setVisibility(8);
                }
            });
        }
    }

    public void bds() {
        this.mListView.setNextPage(this.ewh);
        this.ewh.startLoadData();
    }

    public void xW(String str) {
        this.mListView.setNextPage(this.ewh);
        this.ewh.endLoadDataWithNoMore(str);
    }

    public void ij(boolean z) {
        if (z) {
            this.ewe.reset();
            this.ewe.setTitle(a.i.charm_empty_text);
            this.ewe.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.ewe.setVisibility(0);
            return;
        }
        this.ewe.setVisibility(8);
    }

    public void a(BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        if (onScrollToBottomListener != null) {
            this.mListView.setOnSrollToBottomListener(onScrollToBottomListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.ewe.reset();
        this.ewe.setTitle(a.i.sdk_net_fail_tip);
        this.ewe.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.ewe.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewe.setVisibility(0);
    }

    public void bcy() {
        this.ewe.setVisibility(8);
    }

    public void sm() {
        if (this.ewg != null) {
            if (UtilHelper.getRealScreenOrientation(this.ewd.getPageContext().getPageActivity()) == 2) {
                this.ewg.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg_corners);
            } else {
                this.ewg.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg);
            }
        }
        if (this.exj != null) {
            this.exj.sm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.ewd.getPageContext().getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.asS, this.asT, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    public void X(String str, boolean z) {
        if (this.ewQ != null) {
            this.ewQ.X(str, z);
        }
    }
}
