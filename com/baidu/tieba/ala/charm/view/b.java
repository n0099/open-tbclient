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
    private String aEz;
    private boolean bjr;
    private CommonEmptyView boq;
    private TextView fJI;
    private PbListView gpG;
    private ALaCharmCardActivity gpP;
    private String gpt;
    private String gpu;
    private String gpv;
    private int gpz;
    private a gqF;
    private View gra;
    private View grb;
    private LinearLayout grc;
    private f grd;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;
    private String mUserId;
    private String mUserName;
    private View.OnClickListener gqI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gqF != null) {
                    b.this.b(b.this.gqF.getItem(intValue));
                    if (!b.this.bjr) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String ui = com.baidu.tieba.ala.charm.g.ui(b.this.gpz);
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_HEAD);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
                            alaStaticItem.addParams("pos", (intValue + 1) + "");
                            alaStaticItem.addParams("other_params", b.this.mOtherParams);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener gqJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gqF != null && ViewHelper.checkUpIsLogin(b.this.gpP.getPageContext().getPageActivity()) && (item = b.this.gqF.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gqF.notifyDataSetChanged();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.gpP.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_detail");
                    com.baidu.live.view.a.TX().a(item.pay_userid, fVar);
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", QMStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", QMStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", QMStaticManager.FEED_ID);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        String str = "";
                        if (b.this.gpz != 2) {
                            if (b.this.gpz != 1) {
                                if (b.this.gpz == 3) {
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
                    if (!b.this.bjr) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String ui = com.baidu.tieba.ala.charm.g.ui(b.this.gpz);
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.FOLLOWCLICK_CHARMLIST);
                            alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
                            alaStaticItem2.addParams("pos", (intValue + 1) + "");
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener gpS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.bjr && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                String ui = com.baidu.tieba.ala.charm.g.ui(b.this.gpz);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_login");
                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View.OnClickListener gre = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gpP != null) {
                b.this.gpP.bOB();
            }
            if (view.getTag() == null) {
                if (!b.this.bjr) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        String ui = com.baidu.tieba.ala.charm.g.ui(b.this.gpz);
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
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
            if (!b.this.bjr) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    String ui2 = com.baidu.tieba.ala.charm.g.ui(b.this.gpz);
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui2);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                    alaStaticItem2.addParams("other_params", b.this.mOtherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, int i, String str4, String str5, String str6, String str7, String str8) {
        this.gpz = -1;
        this.gpP = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bjr = z;
        this.aEz = str3;
        this.gpz = i;
        this.mUserId = str4;
        this.mUserName = str5;
        this.gpt = str6;
        this.gpu = str7;
        this.gpv = str8;
        this.mRootView = this.gpP.getLayoutInflater().inflate(a.h.ala_charm_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.gra = this.mRootView.findViewById(a.g.toLogin_layout);
        this.grb = this.mRootView.findViewById(a.g.toLogin_text);
        this.grb.setOnClickListener(this.gpS);
        if (TbadkCoreApplication.isLogin()) {
            this.gra.setVisibility(8);
        } else {
            this.gra.setVisibility(0);
        }
        this.gqF = new a(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.gqF);
        this.mListView.setEmptyView(this.boq);
        this.fJI = (TextView) this.mRootView.findViewById(a.g.top_text);
        this.fJI.setText(com.baidu.tieba.ala.charm.g.B(aLaCharmCardActivity.getPageContext().getPageActivity(), this.gpz));
        if (this.gpG == null) {
            this.gpG = new PbListView(this.gpP);
            this.gpG.setTextColor(this.gpP.getResources().getColor(a.d.sdk_cp_cont_j));
            this.gpG.setSkinType(0);
            this.gpG.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.gpG.createView();
        }
        this.gqF.m(this.gqJ);
        this.gqF.n(this.gqI);
        this.gqF.o(this.gre);
        this.grc = (LinearLayout) this.mRootView.findViewById(a.g.bottomImproveCard_layout);
    }

    public void bOT() {
        if (!this.bjr && this.gra != null && this.gra.getVisibility() == 0) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                String ui = com.baidu.tieba.ala.charm.g.ui(this.gpz);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
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
            this.gqF.setData(arrayList);
        } else {
            this.gqF.ab(arrayList);
        }
        b(arrayList, j);
    }

    private void b(ArrayList<ALaCharmData> arrayList, long j) {
        long j2;
        long j3;
        long j4;
        if (this.gpz == 3 && !this.bjr && TbadkCoreApplication.isLogin() && this.gpP != null) {
            if (this.grd != null) {
                this.grc.removeView(this.grd.getRootView());
            }
            final int dimensionPixelSize = this.gpP.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
            final int paddingLeft = this.mListView.getPaddingLeft();
            final int paddingTop = this.mListView.getPaddingTop();
            final int paddingRight = this.mListView.getPaddingRight();
            final int paddingBottom = this.mListView.getPaddingBottom();
            this.grd = new f(this.gpP.getPageContext().getPageActivity(), this.gre);
            this.grd.lQ(this.bjr);
            this.grd.setOtherParams(this.mOtherParams);
            this.grd.ul(this.gpz);
            com.baidu.tieba.ala.charm.data.a aVar = new com.baidu.tieba.ala.charm.data.a();
            aVar.userId = this.gpt;
            aVar.userName = this.gpu;
            aVar.portrait = this.gpv;
            aVar.totalPrice = j;
            if (j <= 0) {
                aVar.type = 0;
                this.grd.a(aVar);
                this.grc.addView(this.grd.getRootView());
                this.grc.setVisibility(0);
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
                    } else if (!TextUtils.equals(arrayList.get(i3).user_id, this.gpt)) {
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
                    aVar.gqu = 1L;
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
                    aVar.gqu = j2;
                }
                this.grd.a(aVar);
                this.grc.addView(this.grd.getRootView());
                this.grc.setVisibility(0);
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
                aVar.gqu = j4;
            }
            aVar.grade = i;
            this.grd.a(aVar);
            this.grc.addView(this.grd.getRootView());
            this.grc.setVisibility(0);
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
                        b.this.grc.setVisibility(0);
                        return;
                    }
                    b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    b.this.grc.setVisibility(8);
                }
            });
        }
    }

    public void TI() {
        this.mListView.setNextPage(this.gpG);
        this.gpG.startLoadData();
    }

    public void GK(String str) {
        this.mListView.setNextPage(this.gpG);
        this.gpG.endLoadDataWithNoMore(str);
    }

    public void dj(boolean z) {
        if (z) {
            this.boq.reset();
            this.boq.setTitle(a.i.charm_empty_text);
            this.boq.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.boq.setVisibility(0);
            return;
        }
        this.boq.setVisibility(8);
    }

    public void a(BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        if (onScrollToBottomListener != null) {
            this.mListView.setOnSrollToBottomListener(onScrollToBottomListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.boq.reset();
        this.boq.setTitle(a.i.sdk_net_fail_tip);
        this.boq.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.boq.setVisibility(0);
    }

    public void TK() {
        this.boq.setVisibility(8);
    }

    public void Gh() {
        if (this.grd != null) {
            this.grd.Gh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.gpP.getPageContext().getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bjr, this.aEz, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    public void az(String str, boolean z) {
        if (this.gqF != null) {
            this.gqF.az(str, z);
        }
    }
}
