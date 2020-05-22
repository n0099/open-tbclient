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
    private boolean aSw;
    private String aSx;
    private CommonEmptyView aYj;
    private TextView eJS;
    private String fnM;
    private String fnN;
    private String fnO;
    private int fnS;
    private PbListView fnZ;
    private a foW;
    private ALaCharmCardActivity foi;
    private View fpr;
    private View fpt;
    private LinearLayout fpu;
    private f fpv;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;
    private String mUserId;
    private String mUserName;
    private View.OnClickListener foZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.foW != null) {
                    b.this.b(b.this.foW.getItem(intValue));
                    if (!b.this.aSw) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String pW = com.baidu.tieba.ala.charm.g.pW(b.this.fnS);
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_HEAD);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pW);
                            alaStaticItem.addParams("pos", (intValue + 1) + "");
                            alaStaticItem.addParams("other_params", b.this.mOtherParams);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fpa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.foW != null && ViewHelper.checkUpIsLogin(b.this.foi.getPageContext().getPageActivity()) && (item = b.this.foW.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.foW.notifyDataSetChanged();
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(item.pay_userid);
                    dVar.setPortrait(item.portrait);
                    dVar.setPageId(b.this.foi.getUniqueId());
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_charm_detail");
                    com.baidu.live.view.a.Jl().a(item.pay_userid, dVar);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", QMStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", QMStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", QMStaticManager.FEED_ID);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        String str = "";
                        if (b.this.fnS != 2) {
                            if (b.this.fnS != 1) {
                                if (b.this.fnS == 3) {
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
                    if (!b.this.aSw) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String pW = com.baidu.tieba.ala.charm.g.pW(b.this.fnS);
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.FOLLOWCLICK_CHARMLIST);
                            alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pW);
                            alaStaticItem2.addParams("pos", (intValue + 1) + "");
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fom = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.aSw && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                String pW = com.baidu.tieba.ala.charm.g.pW(b.this.fnS);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pW);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_login");
                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View.OnClickListener fpw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.foi != null) {
                b.this.foi.bsW();
            }
            if (view.getTag() == null) {
                if (!b.this.aSw) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                        String pW = com.baidu.tieba.ala.charm.g.pW(b.this.fnS);
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pW);
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
            if (!b.this.aSw) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    String pW2 = com.baidu.tieba.ala.charm.g.pW(b.this.fnS);
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pW2);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                    alaStaticItem2.addParams("other_params", b.this.mOtherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, int i, String str4, String str5, String str6, String str7, String str8) {
        this.fnS = -1;
        this.foi = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aSw = z;
        this.aSx = str3;
        this.fnS = i;
        this.mUserId = str4;
        this.mUserName = str5;
        this.fnM = str6;
        this.fnN = str7;
        this.fnO = str8;
        this.mRootView = this.foi.getLayoutInflater().inflate(a.h.ala_charm_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.aYj = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fpr = this.mRootView.findViewById(a.g.toLogin_layout);
        this.fpt = this.mRootView.findViewById(a.g.toLogin_text);
        this.fpt.setOnClickListener(this.fom);
        if (TbadkCoreApplication.isLogin()) {
            this.fpr.setVisibility(8);
        } else {
            this.fpr.setVisibility(0);
        }
        this.foW = new a(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.foW);
        this.mListView.setEmptyView(this.aYj);
        this.eJS = (TextView) this.mRootView.findViewById(a.g.top_text);
        this.eJS.setText(com.baidu.tieba.ala.charm.g.v(aLaCharmCardActivity.getPageContext().getPageActivity(), this.fnS));
        if (this.fnZ == null) {
            this.fnZ = new PbListView(this.foi);
            this.fnZ.setTextColor(this.foi.getResources().getColor(a.d.sdk_cp_cont_j));
            this.fnZ.setSkinType(0);
            this.fnZ.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.fnZ.createView();
        }
        this.foW.l(this.fpa);
        this.foW.m(this.foZ);
        this.foW.n(this.fpw);
        this.fpu = (LinearLayout) this.mRootView.findViewById(a.g.bottomImproveCard_layout);
    }

    public void btk() {
        if (!this.aSw && this.fpr != null && this.fpr.getVisibility() == 0) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                String pW = com.baidu.tieba.ala.charm.g.pW(this.fnS);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pW);
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
            this.foW.setData(arrayList);
        } else {
            this.foW.U(arrayList);
        }
        b(arrayList, j);
    }

    private void b(ArrayList<ALaCharmData> arrayList, long j) {
        long j2;
        long j3;
        long j4;
        if (this.fnS == 3 && !this.aSw && TbadkCoreApplication.isLogin() && this.foi != null) {
            if (this.fpv != null) {
                this.fpu.removeView(this.fpv.getRootView());
            }
            final int dimensionPixelSize = this.foi.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
            final int paddingLeft = this.mListView.getPaddingLeft();
            final int paddingTop = this.mListView.getPaddingTop();
            final int paddingRight = this.mListView.getPaddingRight();
            final int paddingBottom = this.mListView.getPaddingBottom();
            this.fpv = new f(this.foi.getPageContext().getPageActivity(), this.fpw);
            this.fpv.jI(this.aSw);
            this.fpv.setOtherParams(this.mOtherParams);
            this.fpv.pZ(this.fnS);
            com.baidu.tieba.ala.charm.data.a aVar = new com.baidu.tieba.ala.charm.data.a();
            aVar.userId = this.fnM;
            aVar.userName = this.fnN;
            aVar.portrait = this.fnO;
            aVar.totalPrice = j;
            if (j <= 0) {
                aVar.type = 0;
                this.fpv.a(aVar);
                this.fpu.addView(this.fpv.getRootView());
                this.fpu.setVisibility(0);
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
                    } else if (!TextUtils.equals(arrayList.get(i3).user_id, this.fnM)) {
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
                    aVar.foL = 1L;
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
                    aVar.foL = j2;
                }
                this.fpv.a(aVar);
                this.fpu.addView(this.fpv.getRootView());
                this.fpu.setVisibility(0);
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
                aVar.foL = j4;
            }
            aVar.grade = i;
            this.fpv.a(aVar);
            this.fpu.addView(this.fpv.getRootView());
            this.fpu.setVisibility(0);
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
                        b.this.fpu.setVisibility(0);
                        return;
                    }
                    b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    b.this.fpu.setVisibility(8);
                }
            });
        }
    }

    public void brK() {
        this.mListView.setNextPage(this.fnZ);
        this.fnZ.startLoadData();
    }

    public void Bx(String str) {
        this.mListView.setNextPage(this.fnZ);
        this.fnZ.endLoadDataWithNoMore(str);
    }

    public void jF(boolean z) {
        if (z) {
            this.aYj.reset();
            this.aYj.setTitle(a.i.charm_empty_text);
            this.aYj.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.aYj.setVisibility(0);
            return;
        }
        this.aYj.setVisibility(8);
    }

    public void a(BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        if (onScrollToBottomListener != null) {
            this.mListView.setOnSrollToBottomListener(onScrollToBottomListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aYj.reset();
        this.aYj.setTitle(a.i.sdk_net_fail_tip);
        this.aYj.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.aYj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.aYj.setVisibility(0);
    }

    public void bqO() {
        this.aYj.setVisibility(8);
    }

    public void ya() {
        if (this.fpv != null) {
            this.fpv.ya();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.foi.getPageContext().getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aSw, this.aSx, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    public void ap(String str, boolean z) {
        if (this.foW != null) {
            this.foW.ap(str, z);
        }
    }
}
