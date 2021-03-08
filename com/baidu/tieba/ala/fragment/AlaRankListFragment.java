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
    private static Set<String> gWL = new HashSet();
    private String PP;
    private int aLA;
    private String beL;
    private String gUT;
    private f gWD;
    private g gWE;
    private int gWF;
    private BdUniqueId gWH;
    private BdUniqueId gWI;
    private p gWJ;
    private p gWK;
    private String grA;
    private boolean grB;
    private long gry;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gWG = true;
    private n gWM = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gWE != null) {
                            AlaRankListFragment.this.gWE.dQ(false);
                            if (AlaRankListFragment.this.gWF == 0) {
                                AlaRankListFragment.this.gWE.cpN();
                            }
                            AlaRankListFragment.this.gWE.Xc();
                            AlaRankListFragment.this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.nf(AlaRankListFragment.this.gWG);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gWF == 0) {
                        AlaRankListFragment.this.gWE.Xc();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.gtn == null || alaGetRankListResponseMessage.gtn.size() <= 0) {
                            if (AlaRankListFragment.this.gWE != null) {
                                AlaRankListFragment.this.gWE.cpN();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gWE != null) {
                            AlaRankListFragment.this.gWE.a(alaGetRankListResponseMessage.gtn, alaGetRankListResponseMessage.hVo, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gWE.cpM() != null && (AlaRankListFragment.this.gWE.cpM() instanceof h)) {
                                AlaRankListFragment.this.gWE.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gWE.cpM(), alaGetRankListResponseMessage.gtn));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hVq == null) {
                        if (AlaRankListFragment.this.gWE != null) {
                            AlaRankListFragment.this.gWE.cpN();
                        }
                    } else if (AlaRankListFragment.this.gWE != null) {
                        AlaRankListFragment.this.gWE.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hVq, AlaRankListFragment.this.gWE.bHD()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p cma = alaGetHourRankListResponseMessage.cma();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gWH != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWH.getId()) || (AlaRankListFragment.this.gWI != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWI.getId())) {
                            if (!((AlaRankListFragment.this.gWH != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWH.getId()) == AlaRankListFragment.this.gWG) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWH.getId()) {
                                    AlaRankListFragment.this.gWJ = cma;
                                    if (AlaRankListFragment.this.gWG) {
                                        AlaRankListFragment.this.gWE.Xc();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gWJ);
                                    }
                                    AlaRankListFragment.this.nf(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWI.getId()) {
                                    AlaRankListFragment.this.gWK = cma;
                                    if (!AlaRankListFragment.this.gWG) {
                                        AlaRankListFragment.this.gWE.Xc();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gWK);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gWE != null) {
                                AlaRankListFragment.this.gWE.dQ(false);
                                AlaRankListFragment.this.gWE.cpN();
                                AlaRankListFragment.this.gWE.Xc();
                                AlaRankListFragment.this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.nf(AlaRankListFragment.this.gWG);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gWN = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void h(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.grA) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.grA)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.Qm().bwx.aNO;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bVn();
            } else if ("hour".equals(AlaRankListFragment.this.grA) || "charm_day".equals(AlaRankListFragment.this.grA)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bVn();
            }
            if ("hot".equals(AlaRankListFragment.this.grA)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gWO = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.grA)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.beL, hourRankItemData.type, AlaRankListFragment.this.gWG ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gWF;
        alaRankListFragment.gWF = i - 1;
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
        this.grA = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.PP = arguments.getString("user_name");
        this.grB = arguments.getBoolean("is_from_host");
        this.aLA = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.beL = arguments.getString("feed_id");
        this.gry = arguments.getLong("cur_live_id");
        this.gUT = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.grA)) {
            MessageManager.getInstance().registerListener(this.gWO);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.grA)) {
            nh(this.gWG);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gWE = new g(getPageContext(), this.grA, this.aLA, this.gWN, this.grB, this.mUserId, this.PP, this.mPortrait, this.gry);
        nf(true);
        if ("hour".equals(this.grA)) {
            this.gWE.a(this);
        }
        return this.gWE.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.grA)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.gWD == null) {
            this.gWD = new f(getUniqueId(), this.gWM);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.grA, "charm_day")) {
                    this.gWF = 2;
                    if (this.mUserId != 0) {
                        this.gWD.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gWF--;
                        this.gWE.cpN();
                    }
                    this.gWD.e(this.grA, this.mUserId, "");
                } else if (TextUtils.equals(this.grA, "hour")) {
                    if (this.mUserId == 0) {
                        this.gWE.cpN();
                    }
                    if (z) {
                        this.gWH = BdUniqueId.gen();
                        this.gWD.a(this.grA, this.mUserId, "", this.gWH);
                        return;
                    }
                    this.gWI = BdUniqueId.gen();
                    if (this.gWJ != null && !TextUtils.isEmpty(this.gWJ.Vq())) {
                        this.gWD.a(this.grA, this.mUserId, StringHelper.getHourRankPreHourString(this.gWJ.Vq(), -1), this.gWI);
                    }
                }
            }
        } else if (this.gWE != null) {
            this.gWE.Xc();
            this.gWE.dQ(false);
            this.gWE.cpN();
            this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
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
            if (this.gWE != null) {
                this.gWE.cpN();
                this.gWE.Xc();
                this.gWE.a(new ArrayList<>(), this.gWJ == null ? 0L : this.gWJ.bUL(), this);
                this.gWE.wG(0);
                this.gWE.dQ(false);
                this.gWE.wF(8);
                this.gWE.fw(8);
                this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.nf(AlaRankListFragment.this.gWG);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gWE.Xc();
            this.gWE.fw(0);
            this.gWE.a(new ArrayList<>(), pVar.bUL(), this);
            this.gWE.wG(0);
            this.gWE.dQ(true);
            this.gWE.wF(8);
            if (this.gWE != null) {
                pVar.bUN().na(this.gWG ? false : true);
                this.gWE.c(pVar.bUN());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gWE.fw(0);
            this.gWE.Xc();
            if (this.gWE != null) {
                this.gWE.c(pVar);
                r bUN = pVar.bUN();
                if (pVar.getList().size() == 1) {
                    this.gWE.a(new ArrayList<>(), pVar.bUL(), this);
                    this.gWE.dQ(false);
                    if (bUN != null) {
                        bUN.bt(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gWE.a(arrayList, pVar.bUL(), this);
                    if (bUN != null) {
                        bUN.bt(false);
                    }
                }
                this.gWE.wG(0);
                this.gWE.wF(0);
                if (this.gWE != null) {
                    pVar.bUN().na(this.gWG ? false : true);
                    this.gWE.c(bUN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aHY >= 2 && hVar.aHY < arrayList.size() + 2) {
                hVar.fm(JavaTypesHelper.toLong(arrayList.get(hVar.aHY - 2).gUB, 0L));
            }
            if (hVar.aHY < arrayList.size() && hVar.aHY >= 0) {
                hVar.fn(JavaTypesHelper.toLong(arrayList.get(hVar.aHY).gUB, 0L));
            }
            hVar.aM(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gUB, 0L));
        }
        return hVar;
    }

    public void bVn() {
        if (!this.grB && "hour".equals(this.grA)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.beL, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gWD != null) {
            this.gWD.destory();
        }
        if (this.gWE != null) {
            this.gWE.release();
        }
        if ("hour".equals(this.grA)) {
            MessageManager.getInstance().unRegisterListener(this.gWO);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.grA)) {
            gWL.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVo() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ng(boolean z) {
        if (isAdded()) {
            this.gWG = z;
            if (z) {
                a(this.gWJ);
            } else {
                a(this.gWK);
            }
            nh(z);
        }
    }

    private void nh(boolean z) {
        if ("hour".equals(this.grA)) {
            String str = z ? "hour" : "last_hour";
            if (!gWL.contains(str)) {
                gWL.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.beL, str, this.otherParams);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gWE != null) {
            this.gWE.EN();
        }
    }
}
