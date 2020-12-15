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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.h;
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.data.r;
import com.baidu.tieba.ala.g.f;
import com.baidu.tieba.ala.g.n;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gKY = new HashSet();
    private String Ov;
    private int aLE;
    private String bdh;
    private String gJf;
    private f gKQ;
    private g gKR;
    private int gKS;
    private BdUniqueId gKU;
    private BdUniqueId gKV;
    private p gKW;
    private p gKX;
    private long ghb;
    private String ghd;
    private boolean ghe;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gKT = true;
    private n gKZ = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gKR != null) {
                            AlaRankListFragment.this.gKR.dG(false);
                            if (AlaRankListFragment.this.gKS == 0) {
                                AlaRankListFragment.this.gKR.cpt();
                            }
                            AlaRankListFragment.this.gKR.Yb();
                            AlaRankListFragment.this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.mE(AlaRankListFragment.this.gKT);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gKS == 0) {
                        AlaRankListFragment.this.gKR.Yb();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.giR == null || alaGetRankListResponseMessage.giR.size() <= 0) {
                            if (AlaRankListFragment.this.gKR != null) {
                                AlaRankListFragment.this.gKR.cpt();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gKR != null) {
                            AlaRankListFragment.this.gKR.a(alaGetRankListResponseMessage.giR, alaGetRankListResponseMessage.hHB, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gKR.cps() != null && (AlaRankListFragment.this.gKR.cps() instanceof h)) {
                                AlaRankListFragment.this.gKR.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gKR.cps(), alaGetRankListResponseMessage.giR));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hHD == null) {
                        if (AlaRankListFragment.this.gKR != null) {
                            AlaRankListFragment.this.gKR.cpt();
                        }
                    } else if (AlaRankListFragment.this.gKR != null) {
                        AlaRankListFragment.this.gKR.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hHD, AlaRankListFragment.this.gKR.bIC()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p clP = alaGetHourRankListResponseMessage.clP();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gKU != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKU.getId()) || (AlaRankListFragment.this.gKV != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKV.getId())) {
                            if (!((AlaRankListFragment.this.gKU != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKU.getId()) == AlaRankListFragment.this.gKT) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKU.getId()) {
                                    AlaRankListFragment.this.gKW = clP;
                                    if (AlaRankListFragment.this.gKT) {
                                        AlaRankListFragment.this.gKR.Yb();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gKW);
                                    }
                                    AlaRankListFragment.this.mE(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKV.getId()) {
                                    AlaRankListFragment.this.gKX = clP;
                                    if (!AlaRankListFragment.this.gKT) {
                                        AlaRankListFragment.this.gKR.Yb();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gKX);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gKR != null) {
                                AlaRankListFragment.this.gKR.dG(false);
                                AlaRankListFragment.this.gKR.cpt();
                                AlaRankListFragment.this.gKR.Yb();
                                AlaRankListFragment.this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.mE(AlaRankListFragment.this.gKT);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gLa = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.ghd) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.ghd)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.RB().brA.aNN;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bVI();
            } else if ("hour".equals(AlaRankListFragment.this.ghd) || "charm_day".equals(AlaRankListFragment.this.ghd)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bVI();
            }
            if ("hot".equals(AlaRankListFragment.this.ghd)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gLb = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.ghd)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.bdh, hourRankItemData.type, AlaRankListFragment.this.gKT ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gKS;
        alaRankListFragment.gKS = i - 1;
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
        this.ghd = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Ov = arguments.getString("user_name");
        this.ghe = arguments.getBoolean("is_from_host");
        this.aLE = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.bdh = arguments.getString("feed_id");
        this.ghb = arguments.getLong("cur_live_id");
        this.gJf = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.ghd)) {
            MessageManager.getInstance().registerListener(this.gLb);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.ghd)) {
            mG(this.gKT);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gKR = new g(getPageContext(), this.ghd, this.aLE, this.gLa, this.ghe, this.mUserId, this.Ov, this.mPortrait, this.ghb);
        mE(true);
        if ("hour".equals(this.ghd)) {
            this.gKR.a(this);
        }
        return this.gKR.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ghd)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(final boolean z) {
        if (this.gKQ == null) {
            this.gKQ = new f(getUniqueId(), this.gKZ);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.ghd, "charm_day")) {
                    this.gKS = 2;
                    if (this.mUserId != 0) {
                        this.gKQ.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gKS--;
                        this.gKR.cpt();
                    }
                    this.gKQ.e(this.ghd, this.mUserId, "");
                } else if (TextUtils.equals(this.ghd, "hour")) {
                    if (this.mUserId == 0) {
                        this.gKR.cpt();
                    }
                    if (z) {
                        this.gKU = BdUniqueId.gen();
                        this.gKQ.a(this.ghd, this.mUserId, "", this.gKU);
                        return;
                    }
                    this.gKV = BdUniqueId.gen();
                    if (this.gKW != null && !TextUtils.isEmpty(this.gKW.Wu())) {
                        this.gKQ.a(this.ghd, this.mUserId, StringHelper.getHourRankPreHourString(this.gKW.Wu(), -1), this.gKV);
                    }
                }
            }
        } else if (this.gKR != null) {
            this.gKR.Yb();
            this.gKR.dG(false);
            this.gKR.cpt();
            this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.mE(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gKR != null) {
                this.gKR.cpt();
                this.gKR.Yb();
                this.gKR.a(new ArrayList<>(), this.gKW == null ? 0L : this.gKW.bVf(), this);
                this.gKR.xN(0);
                this.gKR.dG(false);
                this.gKR.xM(8);
                this.gKR.gV(8);
                this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.mE(AlaRankListFragment.this.gKT);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gKR.Yb();
            this.gKR.gV(0);
            this.gKR.a(new ArrayList<>(), pVar.bVf(), this);
            this.gKR.xN(0);
            this.gKR.dG(true);
            this.gKR.xM(8);
            if (this.gKR != null) {
                pVar.bVh().mz(this.gKT ? false : true);
                this.gKR.c(pVar.bVh());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gKR.gV(0);
            this.gKR.Yb();
            if (this.gKR != null) {
                this.gKR.c(pVar);
                r bVh = pVar.bVh();
                if (pVar.getList().size() == 1) {
                    this.gKR.a(new ArrayList<>(), pVar.bVf(), this);
                    this.gKR.dG(false);
                    if (bVh != null) {
                        bVh.by(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gKR.a(arrayList, pVar.bVf(), this);
                    if (bVh != null) {
                        bVh.by(false);
                    }
                }
                this.gKR.xN(0);
                this.gKR.xM(0);
                if (this.gKR != null) {
                    pVar.bVh().mz(this.gKT ? false : true);
                    this.gKR.c(bVh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aJa >= 2 && hVar.aJa < arrayList.size() + 2) {
                hVar.fg(JavaTypesHelper.toLong(arrayList.get(hVar.aJa - 2).gIO, 0L));
            }
            if (hVar.aJa < arrayList.size() && hVar.aJa >= 0) {
                hVar.fh(JavaTypesHelper.toLong(arrayList.get(hVar.aJa).gIO, 0L));
            }
            hVar.aL(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gIO, 0L));
        }
        return hVar;
    }

    public void bVI() {
        if (!this.ghe && "hour".equals(this.ghd)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bdh, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gKQ != null) {
            this.gKQ.destory();
        }
        if (this.gKR != null) {
            this.gKR.release();
        }
        if ("hour".equals(this.ghd)) {
            MessageManager.getInstance().unRegisterListener(this.gLb);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.ghd)) {
            gKY.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVJ() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mF(boolean z) {
        if (isAdded()) {
            this.gKT = z;
            if (z) {
                a(this.gKW);
            } else {
                a(this.gKX);
            }
            mG(z);
        }
    }

    private void mG(boolean z) {
        if ("hour".equals(this.ghd)) {
            String str = z ? "hour" : "last_hour";
            if (!gKY.contains(str)) {
                gKY.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bdh, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gKR != null) {
            this.gKR.HO();
        }
    }
}
