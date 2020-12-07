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
    private static Set<String> gKW = new HashSet();
    private String Ov;
    private int aLE;
    private String bdh;
    private String gJd;
    private f gKO;
    private g gKP;
    private int gKQ;
    private BdUniqueId gKS;
    private BdUniqueId gKT;
    private p gKU;
    private p gKV;
    private long ggZ;
    private String ghb;
    private boolean ghc;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gKR = true;
    private n gKX = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gKP != null) {
                            AlaRankListFragment.this.gKP.dG(false);
                            if (AlaRankListFragment.this.gKQ == 0) {
                                AlaRankListFragment.this.gKP.cps();
                            }
                            AlaRankListFragment.this.gKP.Yb();
                            AlaRankListFragment.this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.mE(AlaRankListFragment.this.gKR);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gKQ == 0) {
                        AlaRankListFragment.this.gKP.Yb();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.giP == null || alaGetRankListResponseMessage.giP.size() <= 0) {
                            if (AlaRankListFragment.this.gKP != null) {
                                AlaRankListFragment.this.gKP.cps();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gKP != null) {
                            AlaRankListFragment.this.gKP.a(alaGetRankListResponseMessage.giP, alaGetRankListResponseMessage.hHz, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gKP.cpr() != null && (AlaRankListFragment.this.gKP.cpr() instanceof h)) {
                                AlaRankListFragment.this.gKP.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gKP.cpr(), alaGetRankListResponseMessage.giP));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hHB == null) {
                        if (AlaRankListFragment.this.gKP != null) {
                            AlaRankListFragment.this.gKP.cps();
                        }
                    } else if (AlaRankListFragment.this.gKP != null) {
                        AlaRankListFragment.this.gKP.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hHB, AlaRankListFragment.this.gKP.bIC()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p clO = alaGetHourRankListResponseMessage.clO();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gKS != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKS.getId()) || (AlaRankListFragment.this.gKT != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKT.getId())) {
                            if (!((AlaRankListFragment.this.gKS != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKS.getId()) == AlaRankListFragment.this.gKR) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKS.getId()) {
                                    AlaRankListFragment.this.gKU = clO;
                                    if (AlaRankListFragment.this.gKR) {
                                        AlaRankListFragment.this.gKP.Yb();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gKU);
                                    }
                                    AlaRankListFragment.this.mE(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gKT.getId()) {
                                    AlaRankListFragment.this.gKV = clO;
                                    if (!AlaRankListFragment.this.gKR) {
                                        AlaRankListFragment.this.gKP.Yb();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gKV);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gKP != null) {
                                AlaRankListFragment.this.gKP.dG(false);
                                AlaRankListFragment.this.gKP.cps();
                                AlaRankListFragment.this.gKP.Yb();
                                AlaRankListFragment.this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.mE(AlaRankListFragment.this.gKR);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gKY = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.ghb) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.ghb)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.RB().brA.aNN;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bVH();
            } else if ("hour".equals(AlaRankListFragment.this.ghb) || "charm_day".equals(AlaRankListFragment.this.ghb)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bVH();
            }
            if ("hot".equals(AlaRankListFragment.this.ghb)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gKZ = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.ghb)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.bdh, hourRankItemData.type, AlaRankListFragment.this.gKR ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gKQ;
        alaRankListFragment.gKQ = i - 1;
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
        this.ghb = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Ov = arguments.getString("user_name");
        this.ghc = arguments.getBoolean("is_from_host");
        this.aLE = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.bdh = arguments.getString("feed_id");
        this.ggZ = arguments.getLong("cur_live_id");
        this.gJd = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.ghb)) {
            MessageManager.getInstance().registerListener(this.gKZ);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.ghb)) {
            mG(this.gKR);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gKP = new g(getPageContext(), this.ghb, this.aLE, this.gKY, this.ghc, this.mUserId, this.Ov, this.mPortrait, this.ggZ);
        mE(true);
        if ("hour".equals(this.ghb)) {
            this.gKP.a(this);
        }
        return this.gKP.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ghb)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(final boolean z) {
        if (this.gKO == null) {
            this.gKO = new f(getUniqueId(), this.gKX);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.ghb, "charm_day")) {
                    this.gKQ = 2;
                    if (this.mUserId != 0) {
                        this.gKO.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gKQ--;
                        this.gKP.cps();
                    }
                    this.gKO.e(this.ghb, this.mUserId, "");
                } else if (TextUtils.equals(this.ghb, "hour")) {
                    if (this.mUserId == 0) {
                        this.gKP.cps();
                    }
                    if (z) {
                        this.gKS = BdUniqueId.gen();
                        this.gKO.a(this.ghb, this.mUserId, "", this.gKS);
                        return;
                    }
                    this.gKT = BdUniqueId.gen();
                    if (this.gKU != null && !TextUtils.isEmpty(this.gKU.Wu())) {
                        this.gKO.a(this.ghb, this.mUserId, StringHelper.getHourRankPreHourString(this.gKU.Wu(), -1), this.gKT);
                    }
                }
            }
        } else if (this.gKP != null) {
            this.gKP.Yb();
            this.gKP.dG(false);
            this.gKP.cps();
            this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
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
            if (this.gKP != null) {
                this.gKP.cps();
                this.gKP.Yb();
                this.gKP.a(new ArrayList<>(), this.gKU == null ? 0L : this.gKU.bVe(), this);
                this.gKP.xN(0);
                this.gKP.dG(false);
                this.gKP.xM(8);
                this.gKP.gV(8);
                this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.mE(AlaRankListFragment.this.gKR);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gKP.Yb();
            this.gKP.gV(0);
            this.gKP.a(new ArrayList<>(), pVar.bVe(), this);
            this.gKP.xN(0);
            this.gKP.dG(true);
            this.gKP.xM(8);
            if (this.gKP != null) {
                pVar.bVg().mz(this.gKR ? false : true);
                this.gKP.c(pVar.bVg());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gKP.gV(0);
            this.gKP.Yb();
            if (this.gKP != null) {
                this.gKP.c(pVar);
                r bVg = pVar.bVg();
                if (pVar.getList().size() == 1) {
                    this.gKP.a(new ArrayList<>(), pVar.bVe(), this);
                    this.gKP.dG(false);
                    if (bVg != null) {
                        bVg.by(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gKP.a(arrayList, pVar.bVe(), this);
                    if (bVg != null) {
                        bVg.by(false);
                    }
                }
                this.gKP.xN(0);
                this.gKP.xM(0);
                if (this.gKP != null) {
                    pVar.bVg().mz(this.gKR ? false : true);
                    this.gKP.c(bVg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aJa >= 2 && hVar.aJa < arrayList.size() + 2) {
                hVar.fg(JavaTypesHelper.toLong(arrayList.get(hVar.aJa - 2).gIM, 0L));
            }
            if (hVar.aJa < arrayList.size() && hVar.aJa >= 0) {
                hVar.fh(JavaTypesHelper.toLong(arrayList.get(hVar.aJa).gIM, 0L));
            }
            hVar.aL(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gIM, 0L));
        }
        return hVar;
    }

    public void bVH() {
        if (!this.ghc && "hour".equals(this.ghb)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bdh, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gKO != null) {
            this.gKO.destory();
        }
        if (this.gKP != null) {
            this.gKP.release();
        }
        if ("hour".equals(this.ghb)) {
            MessageManager.getInstance().unRegisterListener(this.gKZ);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.ghb)) {
            gKW.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVI() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mF(boolean z) {
        if (isAdded()) {
            this.gKR = z;
            if (z) {
                a(this.gKU);
            } else {
                a(this.gKV);
            }
            mG(z);
        }
    }

    private void mG(boolean z) {
        if ("hour".equals(this.ghb)) {
            String str = z ? "hour" : "last_hour";
            if (!gKW.contains(str)) {
                gKW.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bdh, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gKP != null) {
            this.gKP.HO();
        }
    }
}
