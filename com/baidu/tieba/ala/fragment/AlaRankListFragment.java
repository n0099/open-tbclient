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
    private static Set<String> gWK = new HashSet();
    private String Ot;
    private int aMi;
    private String beS;
    private String gUS;
    private f gWC;
    private g gWD;
    private int gWE;
    private BdUniqueId gWG;
    private BdUniqueId gWH;
    private p gWI;
    private p gWJ;
    private String grB;
    private boolean grC;
    private long grz;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gWF = true;
    private n gWL = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gWD != null) {
                            AlaRankListFragment.this.gWD.dM(false);
                            if (AlaRankListFragment.this.gWE == 0) {
                                AlaRankListFragment.this.gWD.csn();
                            }
                            AlaRankListFragment.this.gWD.Zj();
                            AlaRankListFragment.this.gWD.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.ne(AlaRankListFragment.this.gWF);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gWE == 0) {
                        AlaRankListFragment.this.gWD.Zj();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.gto == null || alaGetRankListResponseMessage.gto.size() <= 0) {
                            if (AlaRankListFragment.this.gWD != null) {
                                AlaRankListFragment.this.gWD.csn();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gWD != null) {
                            AlaRankListFragment.this.gWD.a(alaGetRankListResponseMessage.gto, alaGetRankListResponseMessage.hTB, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gWD.csm() != null && (AlaRankListFragment.this.gWD.csm() instanceof h)) {
                                AlaRankListFragment.this.gWD.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gWD.csm(), alaGetRankListResponseMessage.gto));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hTD == null) {
                        if (AlaRankListFragment.this.gWD != null) {
                            AlaRankListFragment.this.gWD.csn();
                        }
                    } else if (AlaRankListFragment.this.gWD != null) {
                        AlaRankListFragment.this.gWD.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hTD, AlaRankListFragment.this.gWD.bKX()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p coH = alaGetHourRankListResponseMessage.coH();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gWG != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWG.getId()) || (AlaRankListFragment.this.gWH != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWH.getId())) {
                            if (!((AlaRankListFragment.this.gWG != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWG.getId()) == AlaRankListFragment.this.gWF) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWG.getId()) {
                                    AlaRankListFragment.this.gWI = coH;
                                    if (AlaRankListFragment.this.gWF) {
                                        AlaRankListFragment.this.gWD.Zj();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gWI);
                                    }
                                    AlaRankListFragment.this.ne(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gWH.getId()) {
                                    AlaRankListFragment.this.gWJ = coH;
                                    if (!AlaRankListFragment.this.gWF) {
                                        AlaRankListFragment.this.gWD.Zj();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gWJ);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gWD != null) {
                                AlaRankListFragment.this.gWD.dM(false);
                                AlaRankListFragment.this.gWD.csn();
                                AlaRankListFragment.this.gWD.Zj();
                                AlaRankListFragment.this.gWD.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.ne(AlaRankListFragment.this.gWF);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gWM = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.grB) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.grB)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.af.a.SE().bwi.aOr;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bYo();
            } else if ("hour".equals(AlaRankListFragment.this.grB) || "charm_day".equals(AlaRankListFragment.this.grB)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bYo();
            }
            if ("hot".equals(AlaRankListFragment.this.grB)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gWN = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.grB)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.beS, hourRankItemData.type, AlaRankListFragment.this.gWF ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gWE;
        alaRankListFragment.gWE = i - 1;
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
        this.grB = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Ot = arguments.getString("user_name");
        this.grC = arguments.getBoolean("is_from_host");
        this.aMi = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.beS = arguments.getString("feed_id");
        this.grz = arguments.getLong("cur_live_id");
        this.gUS = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.grB)) {
            MessageManager.getInstance().registerListener(this.gWN);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.grB)) {
            ng(this.gWF);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gWD = new g(getPageContext(), this.grB, this.aMi, this.gWM, this.grC, this.mUserId, this.Ot, this.mPortrait, this.grz);
        ne(true);
        if ("hour".equals(this.grB)) {
            this.gWD.a(this);
        }
        return this.gWD.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.grB)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(final boolean z) {
        if (this.gWC == null) {
            this.gWC = new f(getUniqueId(), this.gWL);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.grB, "charm_day")) {
                    this.gWE = 2;
                    if (this.mUserId != 0) {
                        this.gWC.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gWE--;
                        this.gWD.csn();
                    }
                    this.gWC.e(this.grB, this.mUserId, "");
                } else if (TextUtils.equals(this.grB, "hour")) {
                    if (this.mUserId == 0) {
                        this.gWD.csn();
                    }
                    if (z) {
                        this.gWG = BdUniqueId.gen();
                        this.gWC.a(this.grB, this.mUserId, "", this.gWG);
                        return;
                    }
                    this.gWH = BdUniqueId.gen();
                    if (this.gWI != null && !TextUtils.isEmpty(this.gWI.Xz())) {
                        this.gWC.a(this.grB, this.mUserId, StringHelper.getHourRankPreHourString(this.gWI.Xz(), -1), this.gWH);
                    }
                }
            }
        } else if (this.gWD != null) {
            this.gWD.Zj();
            this.gWD.dM(false);
            this.gWD.csn();
            this.gWD.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.ne(z);
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
            if (this.gWD != null) {
                this.gWD.csn();
                this.gWD.Zj();
                this.gWD.a(new ArrayList<>(), this.gWI == null ? 0L : this.gWI.bXL(), this);
                this.gWD.ya(0);
                this.gWD.dM(false);
                this.gWD.xZ(8);
                this.gWD.gW(8);
                this.gWD.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.ne(AlaRankListFragment.this.gWF);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gWD.Zj();
            this.gWD.gW(0);
            this.gWD.a(new ArrayList<>(), pVar.bXL(), this);
            this.gWD.ya(0);
            this.gWD.dM(true);
            this.gWD.xZ(8);
            if (this.gWD != null) {
                pVar.bXN().mZ(this.gWF ? false : true);
                this.gWD.c(pVar.bXN());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gWD.gW(0);
            this.gWD.Zj();
            if (this.gWD != null) {
                this.gWD.c(pVar);
                r bXN = pVar.bXN();
                if (pVar.getList().size() == 1) {
                    this.gWD.a(new ArrayList<>(), pVar.bXL(), this);
                    this.gWD.dM(false);
                    if (bXN != null) {
                        bXN.bv(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gWD.a(arrayList, pVar.bXL(), this);
                    if (bXN != null) {
                        bXN.bv(false);
                    }
                }
                this.gWD.ya(0);
                this.gWD.xZ(0);
                if (this.gWD != null) {
                    pVar.bXN().mZ(this.gWF ? false : true);
                    this.gWD.c(bXN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aJy >= 2 && hVar.aJy < arrayList.size() + 2) {
                hVar.fg(JavaTypesHelper.toLong(arrayList.get(hVar.aJy - 2).gUA, 0L));
            }
            if (hVar.aJy < arrayList.size() && hVar.aJy >= 0) {
                hVar.fh(JavaTypesHelper.toLong(arrayList.get(hVar.aJy).gUA, 0L));
            }
            hVar.aK(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gUA, 0L));
        }
        return hVar;
    }

    public void bYo() {
        if (!this.grC && "hour".equals(this.grB)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.beS, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gWC != null) {
            this.gWC.destory();
        }
        if (this.gWD != null) {
            this.gWD.release();
        }
        if ("hour".equals(this.grB)) {
            MessageManager.getInstance().unRegisterListener(this.gWN);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.grB)) {
            gWK.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bYp() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void nf(boolean z) {
        if (isAdded()) {
            this.gWF = z;
            if (z) {
                a(this.gWI);
            } else {
                a(this.gWJ);
            }
            ng(z);
        }
    }

    private void ng(boolean z) {
        if ("hour".equals(this.grB)) {
            String str = z ? "hour" : "last_hour";
            if (!gWK.contains(str)) {
                gWK.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.beS, str, this.otherParams);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gWD != null) {
            this.gWD.Hp();
        }
    }
}
