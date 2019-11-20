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
import com.baidu.live.k.a;
import com.baidu.live.l.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.c.b;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.c;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> dHG = new HashSet();
    private int Pw;
    private String aaL;
    private String dGv;
    private int dHA;
    private BdUniqueId dHC;
    private BdUniqueId dHD;
    private e dHE;
    private e dHF;
    private b dHy;
    private d dHz;
    private long dtM;
    private String dtO;
    private boolean dtP;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String pT;
    private boolean dHB = true;
    private com.baidu.tieba.ala.c.d dHH = new com.baidu.tieba.ala.c.d() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.c.d
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.dHz != null) {
                            AlaRankListFragment.this.dHz.gN(false);
                            if (AlaRankListFragment.this.dHA == 0) {
                                AlaRankListFragment.this.dHz.aYV();
                            }
                            AlaRankListFragment.this.dHz.aJm();
                            AlaRankListFragment.this.dHz.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.gV(AlaRankListFragment.this.dHB);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.dHA == 0) {
                        AlaRankListFragment.this.dHz.aJm();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.dun == null || alaGetRankListResponseMessage.dun.size() <= 0) {
                            if (AlaRankListFragment.this.dHz != null) {
                                AlaRankListFragment.this.dHz.aYV();
                                return;
                            }
                            return;
                        }
                        if (AlaRankListFragment.this.dHz != null) {
                            AlaRankListFragment.this.dHz.a(alaGetRankListResponseMessage.dun, alaGetRankListResponseMessage.eso, AlaRankListFragment.this);
                        }
                        if (AlaRankListFragment.this.dHz.aYU() != null && (AlaRankListFragment.this.dHz.aYU() instanceof c)) {
                            AlaRankListFragment.this.dHz.c(AlaRankListFragment.this.a((c) AlaRankListFragment.this.dHz.aYU(), alaGetRankListResponseMessage.dun));
                        }
                    } else if (obj instanceof AlaGetUserRankInfoResponseMessage) {
                        AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                        if (alaGetUserRankInfoResponseMessage.esp == null) {
                            if (AlaRankListFragment.this.dHz != null) {
                                AlaRankListFragment.this.dHz.aYV();
                            }
                        } else if (alaGetUserRankInfoResponseMessage.esp != null && AlaRankListFragment.this.dHz != null) {
                            AlaRankListFragment.this.dHz.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.esp, AlaRankListFragment.this.dHz.azf()));
                        }
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    e aXd = alaGetHourRankListResponseMessage.aXd();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.dHC != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dHC.getId()) || (AlaRankListFragment.this.dHD != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dHD.getId())) {
                            if (!((AlaRankListFragment.this.dHC != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dHC.getId()) == AlaRankListFragment.this.dHB) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dHC.getId()) {
                                    AlaRankListFragment.this.dHE = aXd;
                                    if (AlaRankListFragment.this.dHB) {
                                        AlaRankListFragment.this.dHz.aJm();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.dHE);
                                    }
                                    AlaRankListFragment.this.gV(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dHD.getId()) {
                                    AlaRankListFragment.this.dHF = aXd;
                                    if (!AlaRankListFragment.this.dHB) {
                                        AlaRankListFragment.this.dHz.aJm();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.dHF);
                                    }
                                }
                            } else if (AlaRankListFragment.this.dHz != null) {
                                AlaRankListFragment.this.dHz.gN(false);
                                AlaRankListFragment.this.dHz.aYV();
                                AlaRankListFragment.this.dHz.aJm();
                                AlaRankListFragment.this.dHz.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.gV(AlaRankListFragment.this.dHB);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a dHI = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.dtO) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.dtO) || "hour".equals(AlaRankListFragment.this.dtO) || "charm_day".equals(AlaRankListFragment.this.dtO)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.uB().ajF.Rv;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.aKM();
            }
            if ("hot".equals(AlaRankListFragment.this.dtO)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener dHJ = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.dtO)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aaL, hourRankItemData.type, AlaRankListFragment.this.dHB ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.dHA;
        alaRankListFragment.dHA = i - 1;
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
        this.dtO = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.pT = arguments.getString("user_name");
        this.dtP = arguments.getBoolean("is_from_host");
        this.Pw = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aaL = arguments.getString("feed_id");
        this.dtM = arguments.getLong("cur_live_id");
        this.dGv = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.dtO)) {
            MessageManager.getInstance().registerListener(this.dHJ);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.dtO)) {
            gX(this.dHB);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dHz = new d(getPageContext(), this.dtO, this.Pw, this.dHI, this.dtP, this.mUserId, this.pT, this.mPortrait, this.dtM);
        gV(true);
        if ("hour".equals(this.dtO)) {
            this.dHz.a(this);
        }
        return this.dHz.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.dtO)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(final boolean z) {
        if (this.dHy == null) {
            this.dHy = new b(getUniqueId(), this.dHH);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.dtO, "charm_day")) {
                    this.dHA = 2;
                    if (this.mUserId != 0) {
                        this.dHy.w(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.dHA--;
                        this.dHz.aYV();
                    }
                    this.dHy.c(this.dtO, this.mUserId, "");
                } else if (TextUtils.equals(this.dtO, "hour")) {
                    if (this.mUserId == 0) {
                        this.dHz.aYV();
                    }
                    if (z) {
                        this.dHC = BdUniqueId.gen();
                        this.dHy.a(this.dtO, this.mUserId, "", this.dHC);
                        return;
                    }
                    this.dHD = BdUniqueId.gen();
                    if (this.dHE != null && !TextUtils.isEmpty(this.dHE.wr())) {
                        this.dHy.a(this.dtO, this.mUserId, StringHelper.getHourRankPreHourString(this.dHE.wr(), -1), this.dHD);
                    }
                }
            }
        } else if (this.dHz != null) {
            this.dHz.aJm();
            this.dHz.gN(false);
            this.dHz.aYV();
            this.dHz.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.gV(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (eVar == null) {
            if (this.dHz != null) {
                this.dHz.aYV();
                this.dHz.aJm();
                this.dHz.a(new ArrayList<>(), this.dHE == null ? 0L : this.dHE.aKB(), this);
                this.dHz.ot(0);
                this.dHz.gN(false);
                this.dHz.or(8);
                this.dHz.os(8);
                this.dHz.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.gV(AlaRankListFragment.this.dHB);
                    }
                });
            }
        } else if (eVar != null && (eVar.getList() == null || eVar.getList().size() <= 0)) {
            this.dHz.aJm();
            this.dHz.os(0);
            if (eVar != null) {
                this.dHz.a(new ArrayList<>(), eVar.aKB(), this);
                this.dHz.ot(0);
                this.dHz.gN(true);
                this.dHz.or(8);
            }
            if (this.dHz != null) {
                eVar.aKD().gS(this.dHB ? false : true);
                this.dHz.c(eVar.aKD());
            }
        } else if (eVar != null && eVar.getList() != null && eVar.getList().size() > 0) {
            this.dHz.os(0);
            this.dHz.aJm();
            if (this.dHz != null) {
                this.dHz.c(eVar);
                f aKD = eVar.aKD();
                if (eVar.getList().size() == 1) {
                    this.dHz.a(new ArrayList<>(), eVar.aKB(), this);
                    this.dHz.gN(false);
                    if (aKD != null) {
                        aKD.gR(true);
                    }
                } else if (eVar.getList().size() > 1) {
                    int size = eVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(eVar.getList().get(i));
                    }
                    this.dHz.a(arrayList, eVar.aKB(), this);
                    if (aKD != null) {
                        aKD.gR(false);
                    }
                }
                this.dHz.ot(0);
                this.dHz.or(0);
                if (this.dHz != null) {
                    eVar.aKD().gS(this.dHB ? false : true);
                    this.dHz.c(aKD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(c cVar, ArrayList<c> arrayList) {
        cVar.a(cVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (cVar.dGB >= 2 && cVar.dGB < arrayList.size() + 2) {
                cVar.bV(JavaTypesHelper.toLong(arrayList.get(cVar.dGB - 2).Tx, 0L));
            }
            if (cVar.dGB < arrayList.size() && cVar.dGB >= 0) {
                cVar.bW(JavaTypesHelper.toLong(arrayList.get(cVar.dGB).Tx, 0L));
            }
            cVar.bX(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).Tx, 0L));
        }
        return cVar;
    }

    public void aKM() {
        if (!this.dtP && "hour".equals(this.dtO)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aaL, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dHy != null) {
            this.dHy.destory();
        }
        if (this.dHz != null) {
            this.dHz.release();
        }
        if ("hour".equals(this.dtO)) {
            MessageManager.getInstance().unRegisterListener(this.dHJ);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.dtO)) {
            dHG.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void aKN() {
        if (isAdded()) {
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void gW(boolean z) {
        if (isAdded()) {
            this.dHB = z;
            if (z) {
                a(this.dHE);
            } else {
                a(this.dHF);
            }
            gX(z);
        }
    }

    private void gX(boolean z) {
        if ("hour".equals(this.dtO)) {
            String str = z ? "hour" : "last_hour";
            if (!dHG.contains(str)) {
                dHG.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aaL, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dHz != null) {
            this.dHz.pC();
        }
    }
}
