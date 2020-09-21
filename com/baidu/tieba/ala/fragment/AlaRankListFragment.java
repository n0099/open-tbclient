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
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.g.f;
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
    private static Set<String> gah = new HashSet();
    private String Nj;
    private int aFQ;
    private String aVs;
    private String fYm;
    private f fZZ;
    private long fyR;
    private String fyT;
    private boolean fyU;
    private g gaa;
    private int gab;
    private BdUniqueId gad;
    private BdUniqueId gae;
    private n gaf;
    private n gag;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gac = true;
    private com.baidu.tieba.ala.g.n gai = new com.baidu.tieba.ala.g.n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gaa != null) {
                            AlaRankListFragment.this.gaa.kY(false);
                            if (AlaRankListFragment.this.gab == 0) {
                                AlaRankListFragment.this.gaa.ccM();
                            }
                            AlaRankListFragment.this.gaa.bHn();
                            AlaRankListFragment.this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.ll(AlaRankListFragment.this.gac);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gab == 0) {
                        AlaRankListFragment.this.gaa.bHn();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fAI == null || alaGetRankListResponseMessage.fAI.size() <= 0) {
                            if (AlaRankListFragment.this.gaa != null) {
                                AlaRankListFragment.this.gaa.ccM();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gaa != null) {
                            AlaRankListFragment.this.gaa.a(alaGetRankListResponseMessage.fAI, alaGetRankListResponseMessage.gRu, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gaa.ccL() != null && (AlaRankListFragment.this.gaa.ccL() instanceof h)) {
                                AlaRankListFragment.this.gaa.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gaa.ccL(), alaGetRankListResponseMessage.fAI));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gRw == null) {
                        if (AlaRankListFragment.this.gaa != null) {
                            AlaRankListFragment.this.gaa.ccM();
                        }
                    } else if (AlaRankListFragment.this.gaa != null) {
                        AlaRankListFragment.this.gaa.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.gRw, AlaRankListFragment.this.gaa.byG()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bZv = alaGetHourRankListResponseMessage.bZv();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gad != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gad.getId()) || (AlaRankListFragment.this.gae != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gae.getId())) {
                            if (!((AlaRankListFragment.this.gad != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gad.getId()) == AlaRankListFragment.this.gac) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gad.getId()) {
                                    AlaRankListFragment.this.gaf = bZv;
                                    if (AlaRankListFragment.this.gac) {
                                        AlaRankListFragment.this.gaa.bHn();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gaf);
                                    }
                                    AlaRankListFragment.this.ll(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gae.getId()) {
                                    AlaRankListFragment.this.gag = bZv;
                                    if (!AlaRankListFragment.this.gac) {
                                        AlaRankListFragment.this.gaa.bHn();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gag);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gaa != null) {
                                AlaRankListFragment.this.gaa.kY(false);
                                AlaRankListFragment.this.gaa.ccM();
                                AlaRankListFragment.this.gaa.bHn();
                                AlaRankListFragment.this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.ll(AlaRankListFragment.this.gac);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gaj = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fyT) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fyT)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.x.a.NN().bhy.aHV;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bKP();
            } else if ("hour".equals(AlaRankListFragment.this.fyT) || "charm_day".equals(AlaRankListFragment.this.fyT)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bKP();
            }
            if ("hot".equals(AlaRankListFragment.this.fyT)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gak = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fyT)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aVs, hourRankItemData.type, AlaRankListFragment.this.gac ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gab;
        alaRankListFragment.gab = i - 1;
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
        this.fyT = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Nj = arguments.getString("user_name");
        this.fyU = arguments.getBoolean("is_from_host");
        this.aFQ = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aVs = arguments.getString("feed_id");
        this.fyR = arguments.getLong("cur_live_id");
        this.fYm = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fyT)) {
            MessageManager.getInstance().registerListener(this.gak);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fyT)) {
            ln(this.gac);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gaa = new g(getPageContext(), this.fyT, this.aFQ, this.gaj, this.fyU, this.mUserId, this.Nj, this.mPortrait, this.fyR);
        ll(true);
        if ("hour".equals(this.fyT)) {
            this.gaa.a(this);
        }
        return this.gaa.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fyT)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ll(final boolean z) {
        if (this.fZZ == null) {
            this.fZZ = new f(getUniqueId(), this.gai);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fyT, "charm_day")) {
                    this.gab = 2;
                    if (this.mUserId != 0) {
                        this.fZZ.x(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gab--;
                        this.gaa.ccM();
                    }
                    this.fZZ.e(this.fyT, this.mUserId, "");
                } else if (TextUtils.equals(this.fyT, "hour")) {
                    if (this.mUserId == 0) {
                        this.gaa.ccM();
                    }
                    if (z) {
                        this.gad = BdUniqueId.gen();
                        this.fZZ.a(this.fyT, this.mUserId, "", this.gad);
                        return;
                    }
                    this.gae = BdUniqueId.gen();
                    if (this.gaf != null && !TextUtils.isEmpty(this.gaf.PK())) {
                        this.fZZ.a(this.fyT, this.mUserId, StringHelper.getHourRankPreHourString(this.gaf.PK(), -1), this.gae);
                    }
                }
            }
        } else if (this.gaa != null) {
            this.gaa.bHn();
            this.gaa.kY(false);
            this.gaa.ccM();
            this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.ll(z);
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
            if (this.gaa != null) {
                this.gaa.ccM();
                this.gaa.bHn();
                this.gaa.a(new ArrayList<>(), this.gaf == null ? 0L : this.gaf.bKm(), this);
                this.gaa.vx(0);
                this.gaa.kY(false);
                this.gaa.vv(8);
                this.gaa.vw(8);
                this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.ll(AlaRankListFragment.this.gac);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.gaa.bHn();
            this.gaa.vw(0);
            this.gaa.a(new ArrayList<>(), nVar.bKm(), this);
            this.gaa.vx(0);
            this.gaa.kY(true);
            this.gaa.vv(8);
            if (this.gaa != null) {
                nVar.bKo().lg(this.gac ? false : true);
                this.gaa.c(nVar.bKo());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.gaa.vw(0);
            this.gaa.bHn();
            if (this.gaa != null) {
                this.gaa.c(nVar);
                p bKo = nVar.bKo();
                if (nVar.getList().size() == 1) {
                    this.gaa.a(new ArrayList<>(), nVar.bKm(), this);
                    this.gaa.kY(false);
                    if (bKo != null) {
                        bKo.lf(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.gaa.a(arrayList, nVar.bKm(), this);
                    if (bKo != null) {
                        bKo.lf(false);
                    }
                }
                this.gaa.vx(0);
                this.gaa.vv(0);
                if (this.gaa != null) {
                    nVar.bKo().lg(this.gac ? false : true);
                    this.gaa.c(bKo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aDW >= 2 && hVar.aDW < arrayList.size() + 2) {
                hVar.dV(JavaTypesHelper.toLong(arrayList.get(hVar.aDW - 2).point, 0L));
            }
            if (hVar.aDW < arrayList.size() && hVar.aDW >= 0) {
                hVar.dW(JavaTypesHelper.toLong(arrayList.get(hVar.aDW).point, 0L));
            }
            hVar.dX(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bKP() {
        if (!this.fyU && "hour".equals(this.fyT)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aVs, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fZZ != null) {
            this.fZZ.destory();
        }
        if (this.gaa != null) {
            this.gaa.release();
        }
        if ("hour".equals(this.fyT)) {
            MessageManager.getInstance().unRegisterListener(this.gak);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fyT)) {
            gah.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bKQ() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void lm(boolean z) {
        if (isAdded()) {
            this.gac = z;
            if (z) {
                a(this.gaf);
            } else {
                a(this.gag);
            }
            ln(z);
        }
    }

    private void ln(boolean z) {
        if ("hour".equals(this.fyT)) {
            String str = z ? "hour" : "last_hour";
            if (!gah.contains(str)) {
                gah.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aVs, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gaa != null) {
            this.gaa.EW();
        }
    }
}
