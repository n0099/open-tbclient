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
/* loaded from: classes11.dex */
public class b {
    private String aGB;
    private boolean boZ;
    private CommonEmptyView bxT;
    private ALaCharmCardActivity gPH;
    private String gPl;
    private String gPm;
    private String gPn;
    private int gPr;
    private PbListView gPy;
    private View gQT;
    private View gQU;
    private LinearLayout gQV;
    private f gQW;
    private a gQw;
    private TextView ggF;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;
    private String mUserId;
    private String mUserName;
    private View.OnClickListener gQz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gQw != null) {
                    ALaCharmData item = b.this.gQw.getItem(intValue);
                    if (item == null || item.disableClick == 0) {
                        b.this.b(item);
                        if (!b.this.boZ) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                                String vI = com.baidu.tieba.ala.charm.g.vI(b.this.gPr);
                                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_HEAD);
                                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vI);
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
    private View.OnClickListener gQA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gQw != null && ViewHelper.checkUpIsLogin(b.this.gPH.getPageContext().getPageActivity()) && (item = b.this.gQw.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gQw.notifyDataSetChanged();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.gPH.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_detail");
                    com.baidu.live.view.a.Zx().a(item.pay_userid, fVar);
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", QMStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", QMStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", QMStaticManager.FEED_ID);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        String str = "";
                        if (b.this.gPr != 2) {
                            if (b.this.gPr != 1) {
                                if (b.this.gPr == 3) {
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
                    if (!b.this.boZ) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String vI = com.baidu.tieba.ala.charm.g.vI(b.this.gPr);
                            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.FOLLOWCLICK_CHARMLIST);
                            alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vI);
                            alaStaticItem2.addParams("pos", (intValue + 1) + "");
                            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener gPK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.boZ && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                String vI = com.baidu.tieba.ala.charm.g.vI(b.this.gPr);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vI);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_login");
                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View.OnClickListener gQX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gPH != null) {
                b.this.gPH.bWK();
            }
            if (view.getTag() == null) {
                if (!b.this.boZ) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        String vI = com.baidu.tieba.ala.charm.g.vI(b.this.gPr);
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vI);
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
            if (!b.this.boZ) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    String vI2 = com.baidu.tieba.ala.charm.g.vI(b.this.gPr);
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vI2);
                    alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                    alaStaticItem2.addParams("other_params", b.this.mOtherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, int i, String str4, String str5, String str6, String str7, String str8) {
        this.gPr = -1;
        this.gPH = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.boZ = z;
        this.aGB = str3;
        this.gPr = i;
        this.mUserId = str4;
        this.mUserName = str5;
        this.gPl = str6;
        this.gPm = str7;
        this.gPn = str8;
        this.mRootView = this.gPH.getLayoutInflater().inflate(a.g.ala_charm_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gQT = this.mRootView.findViewById(a.f.toLogin_layout);
        this.gQU = this.mRootView.findViewById(a.f.toLogin_text);
        this.gQU.setOnClickListener(this.gPK);
        if (TbadkCoreApplication.isLogin()) {
            this.gQT.setVisibility(8);
        } else {
            this.gQT.setVisibility(0);
        }
        this.gQw = new a(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.gQw);
        this.mListView.setEmptyView(this.bxT);
        this.ggF = (TextView) this.mRootView.findViewById(a.f.top_text);
        this.ggF.setText(com.baidu.tieba.ala.charm.g.L(aLaCharmCardActivity.getPageContext().getPageActivity(), this.gPr));
        if (this.gPy == null) {
            this.gPy = new PbListView(this.gPH);
            this.gPy.setTextColor(this.gPH.getResources().getColor(a.c.sdk_cp_cont_j));
            this.gPy.setSkinType(0);
            this.gPy.setContainerBackgroundColorResId(a.c.sdk_transparent);
            this.gPy.createView();
        }
        this.gQw.o(this.gQA);
        this.gQw.p(this.gQz);
        this.gQw.q(this.gQX);
        this.gQV = (LinearLayout) this.mRootView.findViewById(a.f.bottomImproveCard_layout);
    }

    public void bXb() {
        if (!this.boZ && this.gQT != null && this.gQT.getVisibility() == 0) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                String vI = com.baidu.tieba.ala.charm.g.vI(this.gPr);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vI);
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
            this.gQw.setData(arrayList);
        } else {
            this.gQw.ac(arrayList);
        }
        b(arrayList, j);
    }

    private void b(ArrayList<ALaCharmData> arrayList, long j) {
        long j2;
        long j3;
        long j4;
        if (this.gPr == 3 && !this.boZ && TbadkCoreApplication.isLogin() && this.gPH != null) {
            if (this.gQW != null) {
                this.gQV.removeView(this.gQW.getRootView());
            }
            final int dimensionPixelSize = this.gPH.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds120);
            final int paddingLeft = this.mListView.getPaddingLeft();
            final int paddingTop = this.mListView.getPaddingTop();
            final int paddingRight = this.mListView.getPaddingRight();
            final int paddingBottom = this.mListView.getPaddingBottom();
            this.gQW = new f(this.gPH.getPageContext().getPageActivity(), this.gQX);
            this.gQW.mV(this.boZ);
            this.gQW.setOtherParams(this.mOtherParams);
            this.gQW.vL(this.gPr);
            com.baidu.tieba.ala.charm.data.a aVar = new com.baidu.tieba.ala.charm.data.a();
            aVar.userId = this.gPl;
            aVar.userName = this.gPm;
            aVar.portrait = this.gPn;
            aVar.totalPrice = j;
            if (j <= 0) {
                aVar.type = 0;
                this.gQW.a(aVar);
                this.gQV.addView(this.gQW.getRootView());
                this.gQV.setVisibility(0);
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
                    } else if (!TextUtils.equals(arrayList.get(i3).user_id, this.gPl)) {
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
                    aVar.gQl = 1L;
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
                    aVar.gQl = j2;
                }
                this.gQW.a(aVar);
                this.gQV.addView(this.gQW.getRootView());
                this.gQV.setVisibility(0);
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
                aVar.gQl = j4;
            }
            aVar.grade = i;
            this.gQW.a(aVar);
            this.gQV.addView(this.gQW.getRootView());
            this.gQV.setVisibility(0);
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
                        b.this.gQV.setVisibility(0);
                        return;
                    }
                    b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    b.this.gQV.setVisibility(8);
                }
            });
        }
    }

    public void Zg() {
        this.mListView.setNextPage(this.gPy);
        this.gPy.startLoadData();
    }

    public void Hm(String str) {
        this.mListView.setNextPage(this.gPy);
        this.gPy.endLoadDataWithNoMore(str);
    }

    public void dM(boolean z) {
        if (z) {
            this.bxT.reset();
            this.bxT.setTitle(a.h.charm_empty_text);
            this.bxT.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bxT.setVisibility(0);
            return;
        }
        this.bxT.setVisibility(8);
    }

    public void a(BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        if (onScrollToBottomListener != null) {
            this.mListView.setOnSrollToBottomListener(onScrollToBottomListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.bxT.reset();
        this.bxT.setTitle(a.h.sdk_net_fail_tip);
        this.bxT.setRefreshButton(a.h.sdk_net_refresh_btn_text, onClickListener);
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bxT.setVisibility(0);
    }

    public void Zi() {
        this.bxT.setVisibility(8);
    }

    public void Hp() {
        if (this.gQW != null) {
            this.gQW.Hp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.gPH.getPageContext().getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.boZ, this.aGB, null, aLaCharmData.user_name);
            alaPersonCardActivityConfig.setOtherParams(this.mOtherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void aB(String str, boolean z) {
        if (this.gQw != null) {
            this.gQw.aB(str, z);
        }
    }
}
