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
    private static Set<String> fgq = new HashSet();
    private String Lz;
    private String aEh;
    private int aqR;
    private long eId;
    private String eIf;
    private boolean eIg;
    private String ffc;
    private d fgi;
    private com.baidu.tieba.ala.view.d fgj;
    private int fgk;
    private BdUniqueId fgm;
    private BdUniqueId fgn;
    private m fgo;
    private m fgp;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fgl = true;
    private j fgr = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.fgj != null) {
                            AlaRankListFragment.this.fgj.jm(false);
                            if (AlaRankListFragment.this.fgk == 0) {
                                AlaRankListFragment.this.fgj.bDv();
                            }
                            AlaRankListFragment.this.fgj.blt();
                            AlaRankListFragment.this.fgj.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.jw(AlaRankListFragment.this.fgl);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.fgk == 0) {
                        AlaRankListFragment.this.fgj.blt();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.eJQ == null || alaGetRankListResponseMessage.eJQ.size() <= 0) {
                            if (AlaRankListFragment.this.fgj != null) {
                                AlaRankListFragment.this.fgj.bDv();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.fgj != null) {
                            AlaRankListFragment.this.fgj.a(alaGetRankListResponseMessage.eJQ, alaGetRankListResponseMessage.fUk, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.fgj.bDu() != null && (AlaRankListFragment.this.fgj.bDu() instanceof g)) {
                                AlaRankListFragment.this.fgj.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.fgj.bDu(), alaGetRankListResponseMessage.eJQ));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.fUm == null) {
                        if (AlaRankListFragment.this.fgj != null) {
                            AlaRankListFragment.this.fgj.bDv();
                        }
                    } else if (AlaRankListFragment.this.fgj != null) {
                        AlaRankListFragment.this.fgj.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fUm, AlaRankListFragment.this.fgj.bch()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bBi = alaGetHourRankListResponseMessage.bBi();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.fgm != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgm.getId()) || (AlaRankListFragment.this.fgn != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgn.getId())) {
                            if (!((AlaRankListFragment.this.fgm != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgm.getId()) == AlaRankListFragment.this.fgl) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgm.getId()) {
                                    AlaRankListFragment.this.fgo = bBi;
                                    if (AlaRankListFragment.this.fgl) {
                                        AlaRankListFragment.this.fgj.blt();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fgo);
                                    }
                                    AlaRankListFragment.this.jw(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fgn.getId()) {
                                    AlaRankListFragment.this.fgp = bBi;
                                    if (!AlaRankListFragment.this.fgl) {
                                        AlaRankListFragment.this.fgj.blt();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fgp);
                                    }
                                }
                            } else if (AlaRankListFragment.this.fgj != null) {
                                AlaRankListFragment.this.fgj.jm(false);
                                AlaRankListFragment.this.fgj.bDv();
                                AlaRankListFragment.this.fgj.blt();
                                AlaRankListFragment.this.fgj.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.jw(AlaRankListFragment.this.fgl);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a fgs = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.eIf) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.eIf)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.Eo().aQp.asM;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.boe();
            } else if ("hour".equals(AlaRankListFragment.this.eIf) || "charm_day".equals(AlaRankListFragment.this.eIf)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.boe();
            }
            if ("hot".equals(AlaRankListFragment.this.eIf)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener fgt = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.eIf)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aEh, hourRankItemData.type, AlaRankListFragment.this.fgl ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.fgk;
        alaRankListFragment.fgk = i - 1;
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
        this.eIf = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Lz = arguments.getString("user_name");
        this.eIg = arguments.getBoolean("is_from_host");
        this.aqR = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aEh = arguments.getString("feed_id");
        this.eId = arguments.getLong("cur_live_id");
        this.ffc = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.eIf)) {
            MessageManager.getInstance().registerListener(this.fgt);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.eIf)) {
            jy(this.fgl);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fgj = new com.baidu.tieba.ala.view.d(getPageContext(), this.eIf, this.aqR, this.fgs, this.eIg, this.mUserId, this.Lz, this.mPortrait, this.eId);
        jw(true);
        if ("hour".equals(this.eIf)) {
            this.fgj.a(this);
        }
        return this.fgj.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eIf)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(final boolean z) {
        if (this.fgi == null) {
            this.fgi = new com.baidu.tieba.ala.f.d(getUniqueId(), this.fgr);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.eIf, "charm_day")) {
                    this.fgk = 2;
                    if (this.mUserId != 0) {
                        this.fgi.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fgk--;
                        this.fgj.bDv();
                    }
                    this.fgi.e(this.eIf, this.mUserId, "");
                } else if (TextUtils.equals(this.eIf, "hour")) {
                    if (this.mUserId == 0) {
                        this.fgj.bDv();
                    }
                    if (z) {
                        this.fgm = BdUniqueId.gen();
                        this.fgi.a(this.eIf, this.mUserId, "", this.fgm);
                        return;
                    }
                    this.fgn = BdUniqueId.gen();
                    if (this.fgo != null && !TextUtils.isEmpty(this.fgo.Gd())) {
                        this.fgi.a(this.eIf, this.mUserId, StringHelper.getHourRankPreHourString(this.fgo.Gd(), -1), this.fgn);
                    }
                }
            }
        } else if (this.fgj != null) {
            this.fgj.blt();
            this.fgj.jm(false);
            this.fgj.bDv();
            this.fgj.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
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
            if (this.fgj != null) {
                this.fgj.bDv();
                this.fgj.blt();
                this.fgj.a(new ArrayList<>(), this.fgo == null ? 0L : this.fgo.bnV(), this);
                this.fgj.ru(0);
                this.fgj.jm(false);
                this.fgj.rs(8);
                this.fgj.rt(8);
                this.fgj.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.jw(AlaRankListFragment.this.fgl);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.fgj.blt();
            this.fgj.rt(0);
            this.fgj.a(new ArrayList<>(), mVar.bnV(), this);
            this.fgj.ru(0);
            this.fgj.jm(true);
            this.fgj.rs(8);
            if (this.fgj != null) {
                mVar.bnX().jt(this.fgl ? false : true);
                this.fgj.c(mVar.bnX());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.fgj.rt(0);
            this.fgj.blt();
            if (this.fgj != null) {
                this.fgj.c(mVar);
                n bnX = mVar.bnX();
                if (mVar.getList().size() == 1) {
                    this.fgj.a(new ArrayList<>(), mVar.bnV(), this);
                    this.fgj.jm(false);
                    if (bnX != null) {
                        bnX.js(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.fgj.a(arrayList, mVar.bnV(), this);
                    if (bnX != null) {
                        bnX.js(false);
                    }
                }
                this.fgj.ru(0);
                this.fgj.rs(0);
                if (this.fgj != null) {
                    mVar.bnX().jt(this.fgl ? false : true);
                    this.fgj.c(bnX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.ffi >= 2 && gVar.ffi < arrayList.size() + 2) {
                gVar.dp(JavaTypesHelper.toLong(arrayList.get(gVar.ffi - 2).point, 0L));
            }
            if (gVar.ffi < arrayList.size() && gVar.ffi >= 0) {
                gVar.dq(JavaTypesHelper.toLong(arrayList.get(gVar.ffi).point, 0L));
            }
            gVar.dr(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void boe() {
        if (!this.eIg && "hour".equals(this.eIf)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aEh, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fgi != null) {
            this.fgi.destory();
        }
        if (this.fgj != null) {
            this.fgj.release();
        }
        if ("hour".equals(this.eIf)) {
            MessageManager.getInstance().unRegisterListener(this.fgt);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.eIf)) {
            fgq.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bof() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void jx(boolean z) {
        if (isAdded()) {
            this.fgl = z;
            if (z) {
                a(this.fgo);
            } else {
                a(this.fgp);
            }
            jy(z);
        }
    }

    private void jy(boolean z) {
        if ("hour".equals(this.eIf)) {
            String str = z ? "hour" : "last_hour";
            if (!fgq.contains(str)) {
                fgq.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aEh, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fgj != null) {
            this.fgj.wK();
        }
    }
}
