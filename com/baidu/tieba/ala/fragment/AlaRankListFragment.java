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
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.f.e;
import com.baidu.tieba.ala.f.k;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fKS = new HashSet();
    private String Ms;
    private String aNP;
    private int azs;
    private String fJD;
    private e fKK;
    private f fKL;
    private int fKM;
    private BdUniqueId fKO;
    private BdUniqueId fKP;
    private n fKQ;
    private n fKR;
    private long fkg;
    private String fki;
    private boolean fkj;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fKN = true;
    private k fKT = new k() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.fKL != null) {
                            AlaRankListFragment.this.fKL.kw(false);
                            if (AlaRankListFragment.this.fKM == 0) {
                                AlaRankListFragment.this.fKL.bQe();
                            }
                            AlaRankListFragment.this.fKL.bwX();
                            AlaRankListFragment.this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.kH(AlaRankListFragment.this.fKN);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.fKM == 0) {
                        AlaRankListFragment.this.fKL.bwX();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.flW == null || alaGetRankListResponseMessage.flW.size() <= 0) {
                            if (AlaRankListFragment.this.fKL != null) {
                                AlaRankListFragment.this.fKL.bQe();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.fKL != null) {
                            AlaRankListFragment.this.fKL.a(alaGetRankListResponseMessage.flW, alaGetRankListResponseMessage.gBD, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.fKL.bQd() != null && (AlaRankListFragment.this.fKL.bQd() instanceof h)) {
                                AlaRankListFragment.this.fKL.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.fKL.bQd(), alaGetRankListResponseMessage.flW));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gBF == null) {
                        if (AlaRankListFragment.this.fKL != null) {
                            AlaRankListFragment.this.fKL.bQe();
                        }
                    } else if (AlaRankListFragment.this.fKL != null) {
                        AlaRankListFragment.this.fKL.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.gBF, AlaRankListFragment.this.fKL.boJ()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bNN = alaGetHourRankListResponseMessage.bNN();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.fKO != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fKO.getId()) || (AlaRankListFragment.this.fKP != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fKP.getId())) {
                            if (!((AlaRankListFragment.this.fKO != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fKO.getId()) == AlaRankListFragment.this.fKN) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fKO.getId()) {
                                    AlaRankListFragment.this.fKQ = bNN;
                                    if (AlaRankListFragment.this.fKN) {
                                        AlaRankListFragment.this.fKL.bwX();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fKQ);
                                    }
                                    AlaRankListFragment.this.kH(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fKP.getId()) {
                                    AlaRankListFragment.this.fKR = bNN;
                                    if (!AlaRankListFragment.this.fKN) {
                                        AlaRankListFragment.this.fKL.bwX();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fKR);
                                    }
                                }
                            } else if (AlaRankListFragment.this.fKL != null) {
                                AlaRankListFragment.this.fKL.kw(false);
                                AlaRankListFragment.this.fKL.bQe();
                                AlaRankListFragment.this.fKL.bwX();
                                AlaRankListFragment.this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.kH(AlaRankListFragment.this.fKN);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private f.a fKU = new f.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.f.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fki) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fki)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.v.a.Hs().aZn.aBu;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bAj();
            } else if ("hour".equals(AlaRankListFragment.this.fki) || "charm_day".equals(AlaRankListFragment.this.fki)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bAj();
            }
            if ("hot".equals(AlaRankListFragment.this.fki)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener fKV = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fki)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aNP, hourRankItemData.type, AlaRankListFragment.this.fKN ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.fKM;
        alaRankListFragment.fKM = i - 1;
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
        this.fki = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Ms = arguments.getString("user_name");
        this.fkj = arguments.getBoolean("is_from_host");
        this.azs = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aNP = arguments.getString("feed_id");
        this.fkg = arguments.getLong("cur_live_id");
        this.fJD = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fki)) {
            MessageManager.getInstance().registerListener(this.fKV);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fki)) {
            kJ(this.fKN);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fKL = new f(getPageContext(), this.fki, this.azs, this.fKU, this.fkj, this.mUserId, this.Ms, this.mPortrait, this.fkg);
        kH(true);
        if ("hour".equals(this.fki)) {
            this.fKL.a(this);
        }
        return this.fKL.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fki)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(final boolean z) {
        if (this.fKK == null) {
            this.fKK = new e(getUniqueId(), this.fKT);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fki, "charm_day")) {
                    this.fKM = 2;
                    if (this.mUserId != 0) {
                        this.fKK.w(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fKM--;
                        this.fKL.bQe();
                    }
                    this.fKK.f(this.fki, this.mUserId, "");
                } else if (TextUtils.equals(this.fki, "hour")) {
                    if (this.mUserId == 0) {
                        this.fKL.bQe();
                    }
                    if (z) {
                        this.fKO = BdUniqueId.gen();
                        this.fKK.a(this.fki, this.mUserId, "", this.fKO);
                        return;
                    }
                    this.fKP = BdUniqueId.gen();
                    if (this.fKQ != null && !TextUtils.isEmpty(this.fKQ.Jp())) {
                        this.fKK.a(this.fki, this.mUserId, StringHelper.getHourRankPreHourString(this.fKQ.Jp(), -1), this.fKP);
                    }
                }
            }
        } else if (this.fKL != null) {
            this.fKL.bwX();
            this.fKL.kw(false);
            this.fKL.bQe();
            this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.kH(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar == null) {
            if (this.fKL != null) {
                this.fKL.bQe();
                this.fKL.bwX();
                this.fKL.a(new ArrayList<>(), this.fKQ == null ? 0L : this.fKQ.bzZ(), this);
                this.fKL.sQ(0);
                this.fKL.kw(false);
                this.fKL.sO(8);
                this.fKL.sP(8);
                this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.kH(AlaRankListFragment.this.fKN);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.fKL.bwX();
            this.fKL.sP(0);
            this.fKL.a(new ArrayList<>(), nVar.bzZ(), this);
            this.fKL.sQ(0);
            this.fKL.kw(true);
            this.fKL.sO(8);
            if (this.fKL != null) {
                nVar.bAb().kE(this.fKN ? false : true);
                this.fKL.c(nVar.bAb());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.fKL.sP(0);
            this.fKL.bwX();
            if (this.fKL != null) {
                this.fKL.c(nVar);
                o bAb = nVar.bAb();
                if (nVar.getList().size() == 1) {
                    this.fKL.a(new ArrayList<>(), nVar.bzZ(), this);
                    this.fKL.kw(false);
                    if (bAb != null) {
                        bAb.kD(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.fKL.a(arrayList, nVar.bzZ(), this);
                    if (bAb != null) {
                        bAb.kD(false);
                    }
                }
                this.fKL.sQ(0);
                this.fKL.sO(0);
                if (this.fKL != null) {
                    nVar.bAb().kE(this.fKN ? false : true);
                    this.fKL.c(bAb);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.fJJ >= 2 && hVar.fJJ < arrayList.size() + 2) {
                hVar.dI(JavaTypesHelper.toLong(arrayList.get(hVar.fJJ - 2).point, 0L));
            }
            if (hVar.fJJ < arrayList.size() && hVar.fJJ >= 0) {
                hVar.dJ(JavaTypesHelper.toLong(arrayList.get(hVar.fJJ).point, 0L));
            }
            hVar.dK(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bAj() {
        if (!this.fkj && "hour".equals(this.fki)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aNP, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fKK != null) {
            this.fKK.destory();
        }
        if (this.fKL != null) {
            this.fKL.release();
        }
        if ("hour".equals(this.fki)) {
            MessageManager.getInstance().unRegisterListener(this.fKV);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fki)) {
            fKS.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bAk() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void kI(boolean z) {
        if (isAdded()) {
            this.fKN = z;
            if (z) {
                a(this.fKQ);
            } else {
                a(this.fKR);
            }
            kJ(z);
        }
    }

    private void kJ(boolean z) {
        if ("hour".equals(this.fki)) {
            String str = z ? "hour" : "last_hour";
            if (!fKS.contains(str)) {
                fKS.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aNP, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fKL != null) {
            this.fKL.zc();
        }
    }
}
