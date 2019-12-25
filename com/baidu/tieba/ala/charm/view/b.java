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
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class b {
    private boolean aoM;
    private String aoN;
    private TextView dQt;
    private String eqg;
    private String eqh;
    private String eqi;
    private int eqm;
    private ALaCharmCardActivity eqs;
    private CommonEmptyView eqt;
    private View eqv;
    private PbListView eqw;
    private e erA;
    private a erg;
    private LinearLayout erz;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private String mOtherParams;
    private View mRootView;
    private String mUserId;
    private String mUserName;
    private View.OnClickListener eqx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.erg != null) {
                    b.this.a(b.this.erg.getItem(intValue));
                    if (!b.this.aoM) {
                        String oG = com.baidu.tieba.ala.charm.e.oG(b.this.eqm);
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_HEAD);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oG);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        alaStaticItem.addParams("other_params", b.this.mOtherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
            }
        }
    };
    private View.OnClickListener erj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.erg != null && ViewHelper.checkUpIsLogin(b.this.eqs.getPageContext().getPageActivity()) && (item = b.this.erg.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.erg.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.eqs.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.yy().a(item.pay_userid, bVar);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", QMStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", QMStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", QMStaticManager.FEED_ID);
                        alaStaticItem.addParams("pos", (intValue + 1) + "");
                        String str = "";
                        if (b.this.eqm != 2) {
                            if (b.this.eqm != 1) {
                                if (b.this.eqm == 3) {
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
                    if (!b.this.aoM) {
                        String oG = com.baidu.tieba.ala.charm.e.oG(b.this.eqm);
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.FOLLOWCLICK_CHARMLIST);
                        alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oG);
                        alaStaticItem2.addParams("pos", (intValue + 1) + "");
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    }
                }
            }
        }
    };
    private View.OnClickListener eqy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.aoM) {
                String oG = com.baidu.tieba.ala.charm.e.oG(b.this.eqm);
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oG);
                alaStaticItem.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, "to_login");
                alaStaticItem.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            ViewHelper.checkUpIsLogin(view.getContext());
        }
    };
    private View.OnClickListener erB = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eqs != null) {
                b.this.eqs.bbd();
            }
            if (view.getTag() == null) {
                if (!b.this.aoM) {
                    String oG = com.baidu.tieba.ala.charm.e.oG(b.this.eqm);
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                    alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oG);
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
            if (!b.this.aoM) {
                String oG2 = com.baidu.tieba.ala.charm.e.oG(b.this.eqm);
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.CLICK_CHARMLIST_BAR);
                alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oG2);
                alaStaticItem2.addParams(SdkStaticKeys.KEY_CHARMLIST_ACTION_TYPE, str);
                alaStaticItem2.addParams("other_params", b.this.mOtherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    };

    public b(ALaCharmCardActivity aLaCharmCardActivity, String str, String str2, boolean z, String str3, int i, String str4, String str5, String str6, String str7, String str8) {
        this.eqm = -1;
        this.eqs = aLaCharmCardActivity;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aoM = z;
        this.aoN = str3;
        this.eqm = i;
        this.mUserId = str4;
        this.mUserName = str5;
        this.eqg = str6;
        this.eqh = str7;
        this.eqi = str8;
        this.mRootView = this.eqs.getLayoutInflater().inflate(a.h.ala_charm_detail_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.eqt = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.eqv = this.mRootView.findViewById(a.g.toLogin_layout);
        this.eqv.setOnClickListener(this.eqy);
        if (TbadkCoreApplication.isLogin()) {
            this.eqv.setVisibility(8);
        } else {
            this.eqv.setVisibility(0);
        }
        if (UtilHelper.getRealScreenOrientation(this.eqs.getPageContext().getPageActivity()) == 2) {
            this.eqv.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg_corners);
        } else {
            this.eqv.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg);
        }
        this.erg = new a(aLaCharmCardActivity.getPageContext(), 1);
        this.mListView.setAdapter((ListAdapter) this.erg);
        this.mListView.setEmptyView(this.eqt);
        this.dQt = (TextView) this.mRootView.findViewById(a.g.top_text);
        this.dQt.setText(com.baidu.tieba.ala.charm.e.A(aLaCharmCardActivity.getPageContext().getPageActivity(), this.eqm));
        if (this.eqw == null) {
            this.eqw = new PbListView(this.eqs);
            this.eqw.setTextColor(this.eqs.getResources().getColor(a.d.sdk_cp_cont_j));
            this.eqw.setSkinType(0);
            this.eqw.setContainerBackgroundColorResId(a.d.sdk_transparent);
            this.eqw.createView();
        }
        this.erg.n(this.erj);
        this.erg.o(this.eqx);
        this.erg.p(this.erB);
        this.erz = (LinearLayout) this.mRootView.findViewById(a.g.bottomImproveCard_layout);
    }

    public void bbn() {
        if (!this.aoM && this.eqv != null && this.eqv.getVisibility() == 0) {
            String oG = com.baidu.tieba.ala.charm.e.oG(this.eqm);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_CHARMLIST_BAR);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oG);
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
            this.erg.setData(arrayList);
        } else {
            this.erg.R(arrayList);
        }
        b(arrayList, j);
    }

    private void b(ArrayList<ALaCharmData> arrayList, long j) {
        long j2;
        long j3;
        long j4;
        if (this.eqm == 3 && !this.aoM && TbadkCoreApplication.isLogin() && this.eqs != null) {
            if (this.erA != null) {
                this.erz.removeView(this.erA.getRootView());
            }
            final int dimensionPixelSize = this.eqs.getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds120);
            final int paddingLeft = this.mListView.getPaddingLeft();
            final int paddingTop = this.mListView.getPaddingTop();
            final int paddingRight = this.mListView.getPaddingRight();
            final int paddingBottom = this.mListView.getPaddingBottom();
            this.erA = new e(this.eqs.getPageContext().getPageActivity(), this.erB);
            this.erA.hV(this.aoM);
            this.erA.setOtherParams(this.mOtherParams);
            this.erA.oJ(this.eqm);
            com.baidu.tieba.ala.charm.data.a aVar = new com.baidu.tieba.ala.charm.data.a();
            aVar.userId = this.eqg;
            aVar.userName = this.eqh;
            aVar.portrait = this.eqi;
            aVar.totalPrice = j;
            if (j <= 0) {
                aVar.type = 0;
                this.erA.a(aVar);
                this.erz.addView(this.erA.getRootView());
                this.erz.setVisibility(0);
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
                    } else if (!TextUtils.equals(arrayList.get(i3).user_id, this.eqg)) {
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
                    aVar.eqV = 1L;
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
                    aVar.eqV = j2;
                }
                this.erA.a(aVar);
                this.erz.addView(this.erA.getRootView());
                this.erz.setVisibility(0);
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
                aVar.eqV = j4;
            }
            aVar.grade = i;
            this.erA.a(aVar);
            this.erz.addView(this.erA.getRootView());
            this.erz.setVisibility(0);
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
                        b.this.erz.setVisibility(0);
                        return;
                    }
                    b.this.mListView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    b.this.erz.setVisibility(8);
                }
            });
        }
    }

    public void baF() {
        this.mListView.setNextPage(this.eqw);
        this.eqw.startLoadData();
    }

    public void xw(String str) {
        this.mListView.setNextPage(this.eqw);
        this.eqw.endLoadDataWithNoMore(str);
    }

    public void hS(boolean z) {
        if (z) {
            this.eqt.reset();
            this.eqt.setTitle(a.i.charm_empty_text);
            this.eqt.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.eqt.setVisibility(0);
            return;
        }
        this.eqt.setVisibility(8);
    }

    public void a(BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        if (onScrollToBottomListener != null) {
            this.mListView.setOnSrollToBottomListener(onScrollToBottomListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.eqt.reset();
        this.eqt.setTitle(a.i.sdk_net_fail_tip);
        this.eqt.setRefreshButton(a.i.sdk_net_refresh_btn_text, onClickListener);
        this.eqt.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eqt.setVisibility(0);
    }

    public void aZK() {
        this.eqt.setVisibility(8);
    }

    public void qZ() {
        if (this.eqv != null) {
            if (UtilHelper.getRealScreenOrientation(this.eqs.getPageContext().getPageActivity()) == 2) {
                this.eqv.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg_corners);
            } else {
                this.eqv.setBackgroundResource(a.f.ala_charm_tologin_gradient_bg);
            }
        }
        if (this.erA != null) {
            this.erA.qZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.eqs.getPageContext().getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aoM, this.aoN, null, aLaCharmData.user_name, this.mOtherParams)));
        }
    }

    public void X(String str, boolean z) {
        if (this.erg != null) {
            this.erg.X(str, z);
        }
    }
}
