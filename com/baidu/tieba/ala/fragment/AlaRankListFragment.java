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
/* loaded from: classes10.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gSe = new HashSet();
    private String Or;
    private int aHv;
    private String bac;
    private String gQm;
    private f gRW;
    private g gRX;
    private int gRY;
    private BdUniqueId gSa;
    private BdUniqueId gSb;
    private p gSc;
    private p gSd;
    private long gmS;
    private String gmU;
    private boolean gmV;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gRZ = true;
    private n gSf = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gRX != null) {
                            AlaRankListFragment.this.gRX.dI(false);
                            if (AlaRankListFragment.this.gRY == 0) {
                                AlaRankListFragment.this.gRX.cov();
                            }
                            AlaRankListFragment.this.gRX.Vq();
                            AlaRankListFragment.this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.na(AlaRankListFragment.this.gRZ);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gRY == 0) {
                        AlaRankListFragment.this.gRX.Vq();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.goH == null || alaGetRankListResponseMessage.goH.size() <= 0) {
                            if (AlaRankListFragment.this.gRX != null) {
                                AlaRankListFragment.this.gRX.cov();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gRX != null) {
                            AlaRankListFragment.this.gRX.a(alaGetRankListResponseMessage.goH, alaGetRankListResponseMessage.hOV, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gRX.cou() != null && (AlaRankListFragment.this.gRX.cou() instanceof h)) {
                                AlaRankListFragment.this.gRX.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gRX.cou(), alaGetRankListResponseMessage.goH));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hOX == null) {
                        if (AlaRankListFragment.this.gRX != null) {
                            AlaRankListFragment.this.gRX.cov();
                        }
                    } else if (AlaRankListFragment.this.gRX != null) {
                        AlaRankListFragment.this.gRX.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hOX, AlaRankListFragment.this.gRX.bHf()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p ckP = alaGetHourRankListResponseMessage.ckP();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gSa != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gSa.getId()) || (AlaRankListFragment.this.gSb != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gSb.getId())) {
                            if (!((AlaRankListFragment.this.gSa != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gSa.getId()) == AlaRankListFragment.this.gRZ) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gSa.getId()) {
                                    AlaRankListFragment.this.gSc = ckP;
                                    if (AlaRankListFragment.this.gRZ) {
                                        AlaRankListFragment.this.gRX.Vq();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gSc);
                                    }
                                    AlaRankListFragment.this.na(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gSb.getId()) {
                                    AlaRankListFragment.this.gSd = ckP;
                                    if (!AlaRankListFragment.this.gRZ) {
                                        AlaRankListFragment.this.gRX.Vq();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gSd);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gRX != null) {
                                AlaRankListFragment.this.gRX.dI(false);
                                AlaRankListFragment.this.gRX.cov();
                                AlaRankListFragment.this.gRX.Vq();
                                AlaRankListFragment.this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.na(AlaRankListFragment.this.gRZ);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gSg = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.gmU) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.gmU)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.af.a.OJ().bru.aJE;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bUw();
            } else if ("hour".equals(AlaRankListFragment.this.gmU) || "charm_day".equals(AlaRankListFragment.this.gmU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bUw();
            }
            if ("hot".equals(AlaRankListFragment.this.gmU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gSh = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.gmU)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.bac, hourRankItemData.type, AlaRankListFragment.this.gRZ ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gRY;
        alaRankListFragment.gRY = i - 1;
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

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.gmU = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Or = arguments.getString("user_name");
        this.gmV = arguments.getBoolean("is_from_host");
        this.aHv = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.bac = arguments.getString("feed_id");
        this.gmS = arguments.getLong("cur_live_id");
        this.gQm = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.gmU)) {
            MessageManager.getInstance().registerListener(this.gSh);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.gmU)) {
            nc(this.gRZ);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gRX = new g(getPageContext(), this.gmU, this.aHv, this.gSg, this.gmV, this.mUserId, this.Or, this.mPortrait, this.gmS);
        na(true);
        if ("hour".equals(this.gmU)) {
            this.gRX.a(this);
        }
        return this.gRX.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.gmU)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.gRW == null) {
            this.gRW = new f(getUniqueId(), this.gSf);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.gmU, "charm_day")) {
                    this.gRY = 2;
                    if (this.mUserId != 0) {
                        this.gRW.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gRY--;
                        this.gRX.cov();
                    }
                    this.gRW.e(this.gmU, this.mUserId, "");
                } else if (TextUtils.equals(this.gmU, "hour")) {
                    if (this.mUserId == 0) {
                        this.gRX.cov();
                    }
                    if (z) {
                        this.gSa = BdUniqueId.gen();
                        this.gRW.a(this.gmU, this.mUserId, "", this.gSa);
                        return;
                    }
                    this.gSb = BdUniqueId.gen();
                    if (this.gSc != null && !TextUtils.isEmpty(this.gSc.TG())) {
                        this.gRW.a(this.gmU, this.mUserId, StringHelper.getHourRankPreHourString(this.gSc.TG(), -1), this.gSb);
                    }
                }
            }
        } else if (this.gRX != null) {
            this.gRX.Vq();
            this.gRX.dI(false);
            this.gRX.cov();
            this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.na(z);
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
            if (this.gRX != null) {
                this.gRX.cov();
                this.gRX.Vq();
                this.gRX.a(new ArrayList<>(), this.gSc == null ? 0L : this.gSc.bTT(), this);
                this.gRX.wu(0);
                this.gRX.dI(false);
                this.gRX.wt(8);
                this.gRX.fp(8);
                this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.na(AlaRankListFragment.this.gRZ);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gRX.Vq();
            this.gRX.fp(0);
            this.gRX.a(new ArrayList<>(), pVar.bTT(), this);
            this.gRX.wu(0);
            this.gRX.dI(true);
            this.gRX.wt(8);
            if (this.gRX != null) {
                pVar.bTV().mV(this.gRZ ? false : true);
                this.gRX.c(pVar.bTV());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gRX.fp(0);
            this.gRX.Vq();
            if (this.gRX != null) {
                this.gRX.c(pVar);
                r bTV = pVar.bTV();
                if (pVar.getList().size() == 1) {
                    this.gRX.a(new ArrayList<>(), pVar.bTT(), this);
                    this.gRX.dI(false);
                    if (bTV != null) {
                        bTV.br(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gRX.a(arrayList, pVar.bTT(), this);
                    if (bTV != null) {
                        bTV.br(false);
                    }
                }
                this.gRX.wu(0);
                this.gRX.wt(0);
                if (this.gRX != null) {
                    pVar.bTV().mV(this.gRZ ? false : true);
                    this.gRX.c(bTV);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aEL >= 2 && hVar.aEL < arrayList.size() + 2) {
                hVar.fg(JavaTypesHelper.toLong(arrayList.get(hVar.aEL - 2).gPU, 0L));
            }
            if (hVar.aEL < arrayList.size() && hVar.aEL >= 0) {
                hVar.fh(JavaTypesHelper.toLong(arrayList.get(hVar.aEL).gPU, 0L));
            }
            hVar.aK(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gPU, 0L));
        }
        return hVar;
    }

    public void bUw() {
        if (!this.gmV && "hour".equals(this.gmU)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bac, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gRW != null) {
            this.gRW.destory();
        }
        if (this.gRX != null) {
            this.gRX.release();
        }
        if ("hour".equals(this.gmU)) {
            MessageManager.getInstance().unRegisterListener(this.gSh);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.gmU)) {
            gSe.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bUx() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void nb(boolean z) {
        if (isAdded()) {
            this.gRZ = z;
            if (z) {
                a(this.gSc);
            } else {
                a(this.gSd);
            }
            nc(z);
        }
    }

    private void nc(boolean z) {
        if ("hour".equals(this.gmU)) {
            String str = z ? "hour" : "last_hour";
            if (!gSe.contains(str)) {
                gSe.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bac, str, this.otherParams);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gRX != null) {
            this.gRX.Du();
        }
    }
}
