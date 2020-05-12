package com.baidu.tieba.ala.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.live.v.a;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.f.d;
import com.baidu.tieba.ala.f.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fgv = new HashSet();
    private String LD;
    private String aEn;
    private int aqX;
    private long eIi;
    private String eIk;
    private boolean eIl;
    private String ffh;
    private d fgn;
    private com.baidu.tieba.ala.view.d fgo;
    private int fgp;
    private BdUniqueId fgr;
    private BdUniqueId fgs;
    private m fgt;
    private m fgu;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fgq = true;
    private j fgw = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.fgo != null) {
                            AlaRankListFragment.this.fgo.jm(false);
                            if (AlaRankListFragment.this.fgp == 0) {
                                AlaRankListFragment.this.fgo.bDu();
                            }
                            AlaRankListFragment.this.fgo.blr();
                            AlaRankListFragment.this.fgo.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.jw(AlaRankListFragment.this.fgq);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.fgp == 0) {
                        AlaRankListFragment.this.fgo.blr();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.eJV == null || alaGetRankListResponseMessage.eJV.size() <= 0) {
                            if (AlaRankListFragment.this.fgo != null) {
                                AlaRankListFragment.this.fgo.bDu();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.fgo != null) {
                            AlaRankListFragment.this.fgo.a(alaGetRankListResponseMessage.eJV, alaGetRankListResponseMessage.fUp, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.fgo.bDt() != null && (AlaRankListFragment.this.fgo.bDt() instanceof g)) {
                                AlaRankListFragment.this.fgo.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.fgo.bDt(), alaGetRankListResponseMessage.eJV));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.fUr == null) {
                        if (AlaRankListFragment.this.fgo != null) {
                            AlaRankListFragment.this.fgo.bDu();
                        }
                    } else if (AlaRankListFragment.this.fgo != null) {
                        AlaRankListFragment.this.fgo.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fUr, AlaRankListFragment.this.fgo.bcf()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bBg = alaGetHourRankListResponseMessage.bBg();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.fgr != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgr.getId()) || (AlaRankListFragment.this.fgs != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgs.getId())) {
                            if (!((AlaRankListFragment.this.fgr != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgr.getId()) == AlaRankListFragment.this.fgq) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgr.getId()) {
                                    AlaRankListFragment.this.fgt = bBg;
                                    if (AlaRankListFragment.this.fgq) {
                                        AlaRankListFragment.this.fgo.blr();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fgt);
                                    }
                                    AlaRankListFragment.this.jw(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgs.getId()) {
                                    AlaRankListFragment.this.fgu = bBg;
                                    if (!AlaRankListFragment.this.fgq) {
                                        AlaRankListFragment.this.fgo.blr();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fgu);
                                    }
                                }
                            } else if (AlaRankListFragment.this.fgo != null) {
                                AlaRankListFragment.this.fgo.jm(false);
                                AlaRankListFragment.this.fgo.bDu();
                                AlaRankListFragment.this.fgo.blr();
                                AlaRankListFragment.this.fgo.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.jw(AlaRankListFragment.this.fgq);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a fgx = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.eIk) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.eIk)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.En().aQu.asS;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.boc();
            } else if ("hour".equals(AlaRankListFragment.this.eIk) || "charm_day".equals(AlaRankListFragment.this.eIk)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.boc();
            }
            if ("hot".equals(AlaRankListFragment.this.eIk)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener fgy = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.eIk)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aEn, hourRankItemData.type, AlaRankListFragment.this.fgq ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.fgp;
        alaRankListFragment.fgp = i - 1;
        return i;
    }

    public static AlaRankListFragment a(String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6) {
        AlaRankListFragment alaRankListFragment = new AlaRankListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("rank_type", str);
        bundle.putBoolean("is_from_host", z);
        bundle.putLong("user_id", j);
        bundle.putString("user_name", str2);
        bundle.putInt("list_live_type", i);
        bundle.putString("portrait", str3);
        bundle.putString(IntentConfig.OTHER_PARAMS, str4);
        bundle.putString("feed_id", str5);
        bundle.putLong("cur_live_id", j2);
        bundle.putString("cur_hour", str6);
        alaRankListFragment.setArguments(bundle);
        return alaRankListFragment;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.eIk = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.LD = arguments.getString("user_name");
        this.eIl = arguments.getBoolean("is_from_host");
        this.aqX = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aEn = arguments.getString("feed_id");
        this.eIi = arguments.getLong("cur_live_id");
        this.ffh = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.eIk)) {
            MessageManager.getInstance().registerListener(this.fgy);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.eIk)) {
            jy(this.fgq);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fgo = new com.baidu.tieba.ala.view.d(getPageContext(), this.eIk, this.aqX, this.fgx, this.eIl, this.mUserId, this.LD, this.mPortrait, this.eIi);
        jw(true);
        if ("hour".equals(this.eIk)) {
            this.fgo.a(this);
        }
        return this.fgo.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eIk)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(final boolean z) {
        if (this.fgn == null) {
            this.fgn = new com.baidu.tieba.ala.f.d(getUniqueId(), this.fgw);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.eIk, "charm_day")) {
                    this.fgp = 2;
                    if (this.mUserId != 0) {
                        this.fgn.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fgp--;
                        this.fgo.bDu();
                    }
                    this.fgn.e(this.eIk, this.mUserId, "");
                } else if (TextUtils.equals(this.eIk, "hour")) {
                    if (this.mUserId == 0) {
                        this.fgo.bDu();
                    }
                    if (z) {
                        this.fgr = BdUniqueId.gen();
                        this.fgn.a(this.eIk, this.mUserId, "", this.fgr);
                        return;
                    }
                    this.fgs = BdUniqueId.gen();
                    if (this.fgt != null && !TextUtils.isEmpty(this.fgt.Gc())) {
                        this.fgn.a(this.eIk, this.mUserId, StringHelper.getHourRankPreHourString(this.fgt.Gc(), -1), this.fgs);
                    }
                }
            }
        } else if (this.fgo != null) {
            this.fgo.blr();
            this.fgo.jm(false);
            this.fgo.bDu();
            this.fgo.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.jw(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar == null) {
            if (this.fgo != null) {
                this.fgo.bDu();
                this.fgo.blr();
                this.fgo.a(new ArrayList<>(), this.fgt == null ? 0L : this.fgt.bnT(), this);
                this.fgo.ru(0);
                this.fgo.jm(false);
                this.fgo.rs(8);
                this.fgo.rt(8);
                this.fgo.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.jw(AlaRankListFragment.this.fgq);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.fgo.blr();
            this.fgo.rt(0);
            this.fgo.a(new ArrayList<>(), mVar.bnT(), this);
            this.fgo.ru(0);
            this.fgo.jm(true);
            this.fgo.rs(8);
            if (this.fgo != null) {
                mVar.bnV().jt(this.fgq ? false : true);
                this.fgo.c(mVar.bnV());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.fgo.rt(0);
            this.fgo.blr();
            if (this.fgo != null) {
                this.fgo.c(mVar);
                n bnV = mVar.bnV();
                if (mVar.getList().size() == 1) {
                    this.fgo.a(new ArrayList<>(), mVar.bnT(), this);
                    this.fgo.jm(false);
                    if (bnV != null) {
                        bnV.js(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.fgo.a(arrayList, mVar.bnT(), this);
                    if (bnV != null) {
                        bnV.js(false);
                    }
                }
                this.fgo.ru(0);
                this.fgo.rs(0);
                if (this.fgo != null) {
                    mVar.bnV().jt(this.fgq ? false : true);
                    this.fgo.c(bnV);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.ffn >= 2 && gVar.ffn < arrayList.size() + 2) {
                gVar.dp(JavaTypesHelper.toLong(arrayList.get(gVar.ffn - 2).point, 0L));
            }
            if (gVar.ffn < arrayList.size() && gVar.ffn >= 0) {
                gVar.dq(JavaTypesHelper.toLong(arrayList.get(gVar.ffn).point, 0L));
            }
            gVar.dr(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void boc() {
        if (!this.eIl && "hour".equals(this.eIk)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aEn, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fgn != null) {
            this.fgn.destory();
        }
        if (this.fgo != null) {
            this.fgo.release();
        }
        if ("hour".equals(this.eIk)) {
            MessageManager.getInstance().unRegisterListener(this.fgy);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.eIk)) {
            fgv.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bod() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void jx(boolean z) {
        if (isAdded()) {
            this.fgq = z;
            if (z) {
                a(this.fgt);
            } else {
                a(this.fgu);
            }
            jy(z);
        }
    }

    private void jy(boolean z) {
        if ("hour".equals(this.eIk)) {
            String str = z ? "hour" : "last_hour";
            if (!fgv.contains(str)) {
                fgv.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aEn, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fgo != null) {
            this.fgo.wJ();
        }
    }
}
