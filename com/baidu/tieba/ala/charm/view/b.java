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
import com.baidu.live.k.a;
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
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    private boolean agL;
    private String agM;
    private ALaCharmCardActivity dEE;
    private CommonEmptyView dEF;
    private View dEH;
    private PbListView dEI;
    private String dEs;
    private String dEt;
    private String dEu;
    private int dEy;
    private a dFd;
    private LinearLayout dFw;
    private e dFx;
    private TextView dcy;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;
    private String mUserId;
    private String mUserName;
    private View.OnClickListener dEJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dFd != null) {
                    b.this.a(b.this.dFd.getItem(intValue));
                    if (!b.this.agL) {
                        String mv = com.baidu.tieba.ala.charm.d.mv(b.this.dEy);
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_HEAD);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        alaStaticItem.addParams("other_params", b.this.mOtherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
            }
        }
    };
    private View.OnClickListener dFg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dFd != null && ViewHelper.checkUpIsLogin(b.this.dEE.getPageContext().getPageActivity()) && (item = b.this.dFd.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.dFd.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.dEE.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.wy().a(item.pay_userid, bVar);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", QMStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", QMStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", QMStaticManager.FEED_ID);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        String str = "";
                        if (b.this.dEy != 2) {
                            if (b.this.dEy != 1) {
                                if (b.this.dEy == 3) {
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
                    if (!b.this.agL) {
                        String mv = com.baidu.tieba.ala.charm.d.mv(b.this.dEy);
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.FOLLOWCLICK_CHARMLIST);
                        alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv);
                        alaStaticItem2.addParams("pos", (intValue + 1) + "");
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    }
                }
            }
        }
    };
    private View.OnClickListener dEK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.agL) {
                String mv = com.baidu.tieba.ala.charm.d.mv(b.this.dEy);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_login");
                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View.OnClickListener dFy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dEE != null) {
                b.this.dEE.aKs();
            }
            if (view.getTag() == null) {
                if (!b.this.agL) {
                    String mv = com.baidu.tieba.ala.charm.d.mv(b.this.dEy);
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                    alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv);
                    alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_rank");
                    alaStaticItem.addParams("other_params", b.this.mOtherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
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
            if (!b.this.agL) {
                String mv2 = com.baidu.tieba.ala.charm.d.mv(b.this.dEy);
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv2);
                alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                alaStaticItem2.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    };

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, int i, String str4, String str5, String str6, String str7, String str8) {
        this.dEy = -1;
        this.dEE = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.agL = z;
        this.agM = str3;
        this.dEy = i;
        this.mUserId = str4;
        this.mUserName = str5;
        this.dEs = str6;
        this.dEt = str7;
        this.dEu = str8;
        this.mRootView = this.dEE.getLayoutInflater().inflate(a.h.ala_charm_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.dEF = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.dEH = this.mRootView.findViewById(a.g.toLogin_layout);
        this.dEH.setOnClickListener(this.dEK);
        if (TbadkCoreApplication.isLogin()) {
            this.dEH.setVisibility(8);
        } else {
            this.dEH.setVisibility(0);
        }
        if (UtilHelper.getRealScreenOrientation(this.dEE.getPageContext().getPageActivity()) == 2) {
            this.dEH.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg_corners);
        } else {
            this.dEH.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg);
        }
        this.dFd = new a(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.dFd);
        this.mListView.setEmptyView(this.dEF);
        this.dcy = (TextView) this.mRootView.findViewById(a.g.top_text);
        this.dcy.setText(com.baidu.tieba.ala.charm.d.t(aLaCharmCardActivity.getPageContext().getPageActivity(), this.dEy));
        if (this.dEI == null) {
            this.dEI = new PbListView(this.dEE);
            this.dEI.setTextColor(this.dEE.getResources().getColor(a.d.sdk_cp_cont_j));
            this.dEI.setSkinType(0);
            this.dEI.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.dEI.createView();
        }
        this.dFd.m(this.dFg);
        this.dFd.n(this.dEJ);
        this.dFd.o(this.dFy);
        this.dFw = (LinearLayout) this.mRootView.findViewById(a.g.bottomImproveCard_layout);
    }

    public void aKx() {
        if (!this.agL && this.dEH != null && this.dEH.getVisibility() == 0) {
            String mv = com.baidu.tieba.ala.charm.d.mv(this.dEy);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "login_see");
            alaStaticItem.addParams("other_params", this.mOtherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
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
            this.dFd.setData(arrayList);
        } else {
            this.dFd.L(arrayList);
        }
        b(arrayList, j);
    }

    private void b(ArrayList<ALaCharmData> arrayList, long j) {
        long j2;
        long j3;
        long j4;
        if (this.dEy == 3 && !this.agL && TbadkCoreApplication.isLogin() && this.dEE != null) {
            if (this.dFx != null) {
                this.dFw.removeView(this.dFx.getRootView());
            }
            final int dimensionPixelSize = this.dEE.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
            final int paddingLeft = this.mListView.getPaddingLeft();
            final int paddingTop = this.mListView.getPaddingTop();
            final int paddingRight = this.mListView.getPaddingRight();
            final int paddingBottom = this.mListView.getPaddingBottom();
            this.dFx = new e(this.dEE.getPageContext().getPageActivity(), this.dFy);
            this.dFx.gQ(this.agL);
            this.dFx.setOtherParams(this.mOtherParams);
            this.dFx.my(this.dEy);
            com.baidu.tieba.ala.charm.data.a aVar = new com.baidu.tieba.ala.charm.data.a();
            aVar.userId = this.dEs;
            aVar.userName = this.dEt;
            aVar.portrait = this.dEu;
            aVar.totalPrice = j;
            if (j <= 0) {
                aVar.type = 0;
                this.dFx.a(aVar);
                this.dFw.addView(this.dFx.getRootView());
                this.dFw.setVisibility(0);
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
                    } else if (!TextUtils.equals(arrayList.get(i3).user_id, this.dEs)) {
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
                    aVar.dES = 1L;
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
                    aVar.dES = j2;
                }
                this.dFx.a(aVar);
                this.dFw.addView(this.dFx.getRootView());
                this.dFw.setVisibility(0);
                this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, dimensionPixelSize);
                return;
            }
            if (i == 1) {
                aVar.type = 2;
            } else {
                aVar.type = 3;
                try {
                    j3 = Long.parseLong(arrayList.get(i - 2).total_price);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    j3 = 0;
                }
                if (j > j3) {
                    j4 = 1;
                } else {
                    j4 = (j3 - j) + 1;
                }
                aVar.dES = j4;
            }
            aVar.grade = i;
            this.dFx.a(aVar);
            this.dFw.addView(this.dFx.getRootView());
            this.dFw.setVisibility(0);
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
                        b.this.dFw.setVisibility(0);
                        return;
                    }
                    b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    b.this.dFw.setVisibility(8);
                }
            });
        }
    }

    public void aKg() {
        this.mListView.setNextPage(this.dEI);
        this.dEI.startLoadData();
    }

    public void sO(String str) {
        this.mListView.setNextPage(this.dEI);
        this.dEI.endLoadDataWithNoMore(str);
    }

    public void gN(boolean z) {
        if (z) {
            this.dEF.reset();
            this.dEF.setTitle(a.i.charm_empty_text);
            this.dEF.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.dEF.setVisibility(0);
            return;
        }
        this.dEF.setVisibility(8);
    }

    public void a(BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        if (onScrollToBottomListener != null) {
            this.mListView.setOnSrollToBottomListener(onScrollToBottomListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.dEF.reset();
        this.dEF.setTitle(a.i.sdk_net_fail_tip);
        this.dEF.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.dEF.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.dEF.setVisibility(0);
    }

    public void aJm() {
        this.dEF.setVisibility(8);
    }

    public void pC() {
        if (this.dEH != null) {
            if (UtilHelper.getRealScreenOrientation(this.dEE.getPageContext().getPageActivity()) == 2) {
                this.dEH.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg_corners);
            } else {
                this.dEH.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg);
            }
        }
        if (this.dFx != null) {
            this.dFx.pC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.dEE.getPageContext().getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.agL, this.agM, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    public void T(String str, boolean z) {
        if (this.dFd != null) {
            this.dFd.T(str, z);
        }
    }
}
