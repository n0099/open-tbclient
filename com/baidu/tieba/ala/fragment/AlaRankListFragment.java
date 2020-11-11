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
    private static Set<String> gCs = new HashSet();
    private String NA;
    private int aKw;
    private String bbt;
    private long fZh;
    private String fZj;
    private boolean fZk;
    private String gAz;
    private f gCk;
    private g gCl;
    private int gCm;
    private BdUniqueId gCo;
    private BdUniqueId gCp;
    private p gCq;
    private p gCr;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gCn = true;
    private n gCt = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gCl != null) {
                            AlaRankListFragment.this.gCl.dq(false);
                            if (AlaRankListFragment.this.gCm == 0) {
                                AlaRankListFragment.this.gCl.clK();
                            }
                            AlaRankListFragment.this.gCl.Wk();
                            AlaRankListFragment.this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.mi(AlaRankListFragment.this.gCn);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gCm == 0) {
                        AlaRankListFragment.this.gCl.Wk();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.gaX == null || alaGetRankListResponseMessage.gaX.size() <= 0) {
                            if (AlaRankListFragment.this.gCl != null) {
                                AlaRankListFragment.this.gCl.clK();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gCl != null) {
                            AlaRankListFragment.this.gCl.a(alaGetRankListResponseMessage.gaX, alaGetRankListResponseMessage.hyn, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gCl.clJ() != null && (AlaRankListFragment.this.gCl.clJ() instanceof h)) {
                                AlaRankListFragment.this.gCl.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gCl.clJ(), alaGetRankListResponseMessage.gaX));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hyp == null) {
                        if (AlaRankListFragment.this.gCl != null) {
                            AlaRankListFragment.this.gCl.clK();
                        }
                    } else if (AlaRankListFragment.this.gCl != null) {
                        AlaRankListFragment.this.gCl.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hyp, AlaRankListFragment.this.gCl.bFI()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p ciA = alaGetHourRankListResponseMessage.ciA();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gCo != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gCo.getId()) || (AlaRankListFragment.this.gCp != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gCp.getId())) {
                            if (!((AlaRankListFragment.this.gCo != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gCo.getId()) == AlaRankListFragment.this.gCn) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gCo.getId()) {
                                    AlaRankListFragment.this.gCq = ciA;
                                    if (AlaRankListFragment.this.gCn) {
                                        AlaRankListFragment.this.gCl.Wk();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gCq);
                                    }
                                    AlaRankListFragment.this.mi(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gCp.getId()) {
                                    AlaRankListFragment.this.gCr = ciA;
                                    if (!AlaRankListFragment.this.gCn) {
                                        AlaRankListFragment.this.gCl.Wk();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gCr);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gCl != null) {
                                AlaRankListFragment.this.gCl.dq(false);
                                AlaRankListFragment.this.gCl.clK();
                                AlaRankListFragment.this.gCl.Wk();
                                AlaRankListFragment.this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.mi(AlaRankListFragment.this.gCn);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gCu = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fZj) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fZj)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.aa.a.PQ().bod.aMD;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bSE();
            } else if ("hour".equals(AlaRankListFragment.this.fZj) || "charm_day".equals(AlaRankListFragment.this.fZj)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bSE();
            }
            if ("hot".equals(AlaRankListFragment.this.fZj)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gCv = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fZj)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.bbt, hourRankItemData.type, AlaRankListFragment.this.gCn ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gCm;
        alaRankListFragment.gCm = i - 1;
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
        this.fZj = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.NA = arguments.getString("user_name");
        this.fZk = arguments.getBoolean("is_from_host");
        this.aKw = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.bbt = arguments.getString("feed_id");
        this.fZh = arguments.getLong("cur_live_id");
        this.gAz = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fZj)) {
            MessageManager.getInstance().registerListener(this.gCv);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fZj)) {
            mk(this.gCn);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gCl = new g(getPageContext(), this.fZj, this.aKw, this.gCu, this.fZk, this.mUserId, this.NA, this.mPortrait, this.fZh);
        mi(true);
        if ("hour".equals(this.fZj)) {
            this.gCl.a(this);
        }
        return this.gCl.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fZj)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(final boolean z) {
        if (this.gCk == null) {
            this.gCk = new f(getUniqueId(), this.gCt);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fZj, "charm_day")) {
                    this.gCm = 2;
                    if (this.mUserId != 0) {
                        this.gCk.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gCm--;
                        this.gCl.clK();
                    }
                    this.gCk.e(this.fZj, this.mUserId, "");
                } else if (TextUtils.equals(this.fZj, "hour")) {
                    if (this.mUserId == 0) {
                        this.gCl.clK();
                    }
                    if (z) {
                        this.gCo = BdUniqueId.gen();
                        this.gCk.a(this.fZj, this.mUserId, "", this.gCo);
                        return;
                    }
                    this.gCp = BdUniqueId.gen();
                    if (this.gCq != null && !TextUtils.isEmpty(this.gCq.UD())) {
                        this.gCk.a(this.fZj, this.mUserId, StringHelper.getHourRankPreHourString(this.gCq.UD(), -1), this.gCp);
                    }
                }
            }
        } else if (this.gCl != null) {
            this.gCl.Wk();
            this.gCl.dq(false);
            this.gCl.clK();
            this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.mi(z);
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
            if (this.gCl != null) {
                this.gCl.clK();
                this.gCl.Wk();
                this.gCl.a(new ArrayList<>(), this.gCq == null ? 0L : this.gCq.bSb(), this);
                this.gCl.wJ(0);
                this.gCl.dq(false);
                this.gCl.wI(8);
                this.gCl.gB(8);
                this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.mi(AlaRankListFragment.this.gCn);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gCl.Wk();
            this.gCl.gB(0);
            this.gCl.a(new ArrayList<>(), pVar.bSb(), this);
            this.gCl.wJ(0);
            this.gCl.dq(true);
            this.gCl.wI(8);
            if (this.gCl != null) {
                pVar.bSd().md(this.gCn ? false : true);
                this.gCl.c(pVar.bSd());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gCl.gB(0);
            this.gCl.Wk();
            if (this.gCl != null) {
                this.gCl.c(pVar);
                r bSd = pVar.bSd();
                if (pVar.getList().size() == 1) {
                    this.gCl.a(new ArrayList<>(), pVar.bSb(), this);
                    this.gCl.dq(false);
                    if (bSd != null) {
                        bSd.bo(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gCl.a(arrayList, pVar.bSb(), this);
                    if (bSd != null) {
                        bSd.bo(false);
                    }
                }
                this.gCl.wJ(0);
                this.gCl.wI(0);
                if (this.gCl != null) {
                    pVar.bSd().md(this.gCn ? false : true);
                    this.gCl.c(bSd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aIc >= 2 && hVar.aIc < arrayList.size() + 2) {
                hVar.eC(JavaTypesHelper.toLong(arrayList.get(hVar.aIc - 2).point, 0L));
            }
            if (hVar.aIc < arrayList.size() && hVar.aIc >= 0) {
                hVar.eD(JavaTypesHelper.toLong(arrayList.get(hVar.aIc).point, 0L));
            }
            hVar.an(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bSE() {
        if (!this.fZk && "hour".equals(this.fZj)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bbt, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gCk != null) {
            this.gCk.destory();
        }
        if (this.gCl != null) {
            this.gCl.release();
        }
        if ("hour".equals(this.fZj)) {
            MessageManager.getInstance().unRegisterListener(this.gCv);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fZj)) {
            gCs.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bSF() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mj(boolean z) {
        if (isAdded()) {
            this.gCn = z;
            if (z) {
                a(this.gCq);
            } else {
                a(this.gCr);
            }
            mk(z);
        }
    }

    private void mk(boolean z) {
        if ("hour".equals(this.fZj)) {
            String str = z ? "hour" : "last_hour";
            if (!gCs.contains(str)) {
                gCs.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bbt, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gCl != null) {
            this.gCl.GI();
        }
    }
}
