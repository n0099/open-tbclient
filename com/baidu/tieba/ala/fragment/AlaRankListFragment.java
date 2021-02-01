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
/* loaded from: classes11.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gUO = new HashSet();
    private String Op;
    private int aKa;
    private String bdj;
    private String gSW;
    private f gUG;
    private g gUH;
    private int gUI;
    private BdUniqueId gUK;
    private BdUniqueId gUL;
    private p gUM;
    private p gUN;
    private long gpB;
    private String gpD;
    private boolean gpE;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gUJ = true;
    private n gUP = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gUH != null) {
                            AlaRankListFragment.this.gUH.dQ(false);
                            if (AlaRankListFragment.this.gUI == 0) {
                                AlaRankListFragment.this.gUH.cpA();
                            }
                            AlaRankListFragment.this.gUH.WZ();
                            AlaRankListFragment.this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.nf(AlaRankListFragment.this.gUJ);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gUI == 0) {
                        AlaRankListFragment.this.gUH.WZ();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.grq == null || alaGetRankListResponseMessage.grq.size() <= 0) {
                            if (AlaRankListFragment.this.gUH != null) {
                                AlaRankListFragment.this.gUH.cpA();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gUH != null) {
                            AlaRankListFragment.this.gUH.a(alaGetRankListResponseMessage.grq, alaGetRankListResponseMessage.hTr, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gUH.cpz() != null && (AlaRankListFragment.this.gUH.cpz() instanceof h)) {
                                AlaRankListFragment.this.gUH.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gUH.cpz(), alaGetRankListResponseMessage.grq));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hTt == null) {
                        if (AlaRankListFragment.this.gUH != null) {
                            AlaRankListFragment.this.gUH.cpA();
                        }
                    } else if (AlaRankListFragment.this.gUH != null) {
                        AlaRankListFragment.this.gUH.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hTt, AlaRankListFragment.this.gUH.bHz()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p clN = alaGetHourRankListResponseMessage.clN();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gUK != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUK.getId()) || (AlaRankListFragment.this.gUL != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUL.getId())) {
                            if (!((AlaRankListFragment.this.gUK != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUK.getId()) == AlaRankListFragment.this.gUJ) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUK.getId()) {
                                    AlaRankListFragment.this.gUM = clN;
                                    if (AlaRankListFragment.this.gUJ) {
                                        AlaRankListFragment.this.gUH.WZ();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gUM);
                                    }
                                    AlaRankListFragment.this.nf(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUL.getId()) {
                                    AlaRankListFragment.this.gUN = clN;
                                    if (!AlaRankListFragment.this.gUJ) {
                                        AlaRankListFragment.this.gUH.WZ();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gUN);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gUH != null) {
                                AlaRankListFragment.this.gUH.dQ(false);
                                AlaRankListFragment.this.gUH.cpA();
                                AlaRankListFragment.this.gUH.WZ();
                                AlaRankListFragment.this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.nf(AlaRankListFragment.this.gUJ);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gUQ = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void h(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.gpD) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.gpD)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.Qj().buX.aMo;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bVa();
            } else if ("hour".equals(AlaRankListFragment.this.gpD) || "charm_day".equals(AlaRankListFragment.this.gpD)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bVa();
            }
            if ("hot".equals(AlaRankListFragment.this.gpD)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gUR = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.gpD)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.bdj, hourRankItemData.type, AlaRankListFragment.this.gUJ ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gUI;
        alaRankListFragment.gUI = i - 1;
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
        this.gpD = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Op = arguments.getString("user_name");
        this.gpE = arguments.getBoolean("is_from_host");
        this.aKa = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.bdj = arguments.getString("feed_id");
        this.gpB = arguments.getLong("cur_live_id");
        this.gSW = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.gpD)) {
            MessageManager.getInstance().registerListener(this.gUR);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.gpD)) {
            nh(this.gUJ);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gUH = new g(getPageContext(), this.gpD, this.aKa, this.gUQ, this.gpE, this.mUserId, this.Op, this.mPortrait, this.gpB);
        nf(true);
        if ("hour".equals(this.gpD)) {
            this.gUH.a(this);
        }
        return this.gUH.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.gpD)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.gUG == null) {
            this.gUG = new f(getUniqueId(), this.gUP);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.gpD, "charm_day")) {
                    this.gUI = 2;
                    if (this.mUserId != 0) {
                        this.gUG.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gUI--;
                        this.gUH.cpA();
                    }
                    this.gUG.e(this.gpD, this.mUserId, "");
                } else if (TextUtils.equals(this.gpD, "hour")) {
                    if (this.mUserId == 0) {
                        this.gUH.cpA();
                    }
                    if (z) {
                        this.gUK = BdUniqueId.gen();
                        this.gUG.a(this.gpD, this.mUserId, "", this.gUK);
                        return;
                    }
                    this.gUL = BdUniqueId.gen();
                    if (this.gUM != null && !TextUtils.isEmpty(this.gUM.Vn())) {
                        this.gUG.a(this.gpD, this.mUserId, StringHelper.getHourRankPreHourString(this.gUM.Vn(), -1), this.gUL);
                    }
                }
            }
        } else if (this.gUH != null) {
            this.gUH.WZ();
            this.gUH.dQ(false);
            this.gUH.cpA();
            this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.nf(z);
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
            if (this.gUH != null) {
                this.gUH.cpA();
                this.gUH.WZ();
                this.gUH.a(new ArrayList<>(), this.gUM == null ? 0L : this.gUM.bUy(), this);
                this.gUH.wF(0);
                this.gUH.dQ(false);
                this.gUH.wE(8);
                this.gUH.fv(8);
                this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.nf(AlaRankListFragment.this.gUJ);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gUH.WZ();
            this.gUH.fv(0);
            this.gUH.a(new ArrayList<>(), pVar.bUy(), this);
            this.gUH.wF(0);
            this.gUH.dQ(true);
            this.gUH.wE(8);
            if (this.gUH != null) {
                pVar.bUA().na(this.gUJ ? false : true);
                this.gUH.c(pVar.bUA());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gUH.fv(0);
            this.gUH.WZ();
            if (this.gUH != null) {
                this.gUH.c(pVar);
                r bUA = pVar.bUA();
                if (pVar.getList().size() == 1) {
                    this.gUH.a(new ArrayList<>(), pVar.bUy(), this);
                    this.gUH.dQ(false);
                    if (bUA != null) {
                        bUA.bt(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gUH.a(arrayList, pVar.bUy(), this);
                    if (bUA != null) {
                        bUA.bt(false);
                    }
                }
                this.gUH.wF(0);
                this.gUH.wE(0);
                if (this.gUH != null) {
                    pVar.bUA().na(this.gUJ ? false : true);
                    this.gUH.c(bUA);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aGy >= 2 && hVar.aGy < arrayList.size() + 2) {
                hVar.fm(JavaTypesHelper.toLong(arrayList.get(hVar.aGy - 2).gSE, 0L));
            }
            if (hVar.aGy < arrayList.size() && hVar.aGy >= 0) {
                hVar.fn(JavaTypesHelper.toLong(arrayList.get(hVar.aGy).gSE, 0L));
            }
            hVar.aM(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gSE, 0L));
        }
        return hVar;
    }

    public void bVa() {
        if (!this.gpE && "hour".equals(this.gpD)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bdj, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gUG != null) {
            this.gUG.destory();
        }
        if (this.gUH != null) {
            this.gUH.release();
        }
        if ("hour".equals(this.gpD)) {
            MessageManager.getInstance().unRegisterListener(this.gUR);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.gpD)) {
            gUO.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVb() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ng(boolean z) {
        if (isAdded()) {
            this.gUJ = z;
            if (z) {
                a(this.gUM);
            } else {
                a(this.gUN);
            }
            nh(z);
        }
    }

    private void nh(boolean z) {
        if ("hour".equals(this.gpD)) {
            String str = z ? "hour" : "last_hour";
            if (!gUO.contains(str)) {
                gUO.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bdj, str, this.otherParams);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gUH != null) {
            this.gUH.EK();
        }
    }
}
