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
/* loaded from: classes7.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fWQ = new HashSet();
    private String MY;
    private int aED;
    private String aTc;
    private String fUU;
    private e fWI;
    private f fWJ;
    private int fWK;
    private BdUniqueId fWM;
    private BdUniqueId fWN;
    private n fWO;
    private n fWP;
    private long fvC;
    private String fvE;
    private boolean fvF;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fWL = true;
    private k fWR = new k() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.fWJ != null) {
                            AlaRankListFragment.this.fWJ.kU(false);
                            if (AlaRankListFragment.this.fWK == 0) {
                                AlaRankListFragment.this.fWJ.cap();
                            }
                            AlaRankListFragment.this.fWJ.bFW();
                            AlaRankListFragment.this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.lh(AlaRankListFragment.this.fWL);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.fWK == 0) {
                        AlaRankListFragment.this.fWJ.bFW();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fxs == null || alaGetRankListResponseMessage.fxs.size() <= 0) {
                            if (AlaRankListFragment.this.fWJ != null) {
                                AlaRankListFragment.this.fWJ.cap();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.fWJ != null) {
                            AlaRankListFragment.this.fWJ.a(alaGetRankListResponseMessage.fxs, alaGetRankListResponseMessage.gOa, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.fWJ.cao() != null && (AlaRankListFragment.this.fWJ.cao() instanceof h)) {
                                AlaRankListFragment.this.fWJ.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.fWJ.cao(), alaGetRankListResponseMessage.fxs));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gOc == null) {
                        if (AlaRankListFragment.this.fWJ != null) {
                            AlaRankListFragment.this.fWJ.cap();
                        }
                    } else if (AlaRankListFragment.this.fWJ != null) {
                        AlaRankListFragment.this.fWJ.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.gOc, AlaRankListFragment.this.fWJ.bxw()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bXN = alaGetHourRankListResponseMessage.bXN();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.fWM != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWM.getId()) || (AlaRankListFragment.this.fWN != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWN.getId())) {
                            if (!((AlaRankListFragment.this.fWM != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWM.getId()) == AlaRankListFragment.this.fWL) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWM.getId()) {
                                    AlaRankListFragment.this.fWO = bXN;
                                    if (AlaRankListFragment.this.fWL) {
                                        AlaRankListFragment.this.fWJ.bFW();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fWO);
                                    }
                                    AlaRankListFragment.this.lh(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWN.getId()) {
                                    AlaRankListFragment.this.fWP = bXN;
                                    if (!AlaRankListFragment.this.fWL) {
                                        AlaRankListFragment.this.fWJ.bFW();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fWP);
                                    }
                                }
                            } else if (AlaRankListFragment.this.fWJ != null) {
                                AlaRankListFragment.this.fWJ.kU(false);
                                AlaRankListFragment.this.fWJ.cap();
                                AlaRankListFragment.this.fWJ.bFW();
                                AlaRankListFragment.this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.lh(AlaRankListFragment.this.fWL);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private f.a fWS = new f.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.f.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fvE) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fvE)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.w.a.Nk().beH.aGE;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bJE();
            } else if ("hour".equals(AlaRankListFragment.this.fvE) || "charm_day".equals(AlaRankListFragment.this.fvE)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bJE();
            }
            if ("hot".equals(AlaRankListFragment.this.fvE)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener fWT = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fvE)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aTc, hourRankItemData.type, AlaRankListFragment.this.fWL ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.fWK;
        alaRankListFragment.fWK = i - 1;
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
        this.fvE = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.MY = arguments.getString("user_name");
        this.fvF = arguments.getBoolean("is_from_host");
        this.aED = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aTc = arguments.getString("feed_id");
        this.fvC = arguments.getLong("cur_live_id");
        this.fUU = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fvE)) {
            MessageManager.getInstance().registerListener(this.fWT);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fvE)) {
            lj(this.fWL);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fWJ = new f(getPageContext(), this.fvE, this.aED, this.fWS, this.fvF, this.mUserId, this.MY, this.mPortrait, this.fvC);
        lh(true);
        if ("hour".equals(this.fvE)) {
            this.fWJ.a(this);
        }
        return this.fWJ.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fvE)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh(final boolean z) {
        if (this.fWI == null) {
            this.fWI = new e(getUniqueId(), this.fWR);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fvE, "charm_day")) {
                    this.fWK = 2;
                    if (this.mUserId != 0) {
                        this.fWI.x(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fWK--;
                        this.fWJ.cap();
                    }
                    this.fWI.e(this.fvE, this.mUserId, "");
                } else if (TextUtils.equals(this.fvE, "hour")) {
                    if (this.mUserId == 0) {
                        this.fWJ.cap();
                    }
                    if (z) {
                        this.fWM = BdUniqueId.gen();
                        this.fWI.a(this.fvE, this.mUserId, "", this.fWM);
                        return;
                    }
                    this.fWN = BdUniqueId.gen();
                    if (this.fWO != null && !TextUtils.isEmpty(this.fWO.Ph())) {
                        this.fWI.a(this.fvE, this.mUserId, StringHelper.getHourRankPreHourString(this.fWO.Ph(), -1), this.fWN);
                    }
                }
            }
        } else if (this.fWJ != null) {
            this.fWJ.bFW();
            this.fWJ.kU(false);
            this.fWJ.cap();
            this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.lh(z);
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
            if (this.fWJ != null) {
                this.fWJ.cap();
                this.fWJ.bFW();
                this.fWJ.a(new ArrayList<>(), this.fWO == null ? 0L : this.fWO.bJc(), this);
                this.fWJ.ve(0);
                this.fWJ.kU(false);
                this.fWJ.vc(8);
                this.fWJ.vd(8);
                this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.lh(AlaRankListFragment.this.fWL);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.fWJ.bFW();
            this.fWJ.vd(0);
            this.fWJ.a(new ArrayList<>(), nVar.bJc(), this);
            this.fWJ.ve(0);
            this.fWJ.kU(true);
            this.fWJ.vc(8);
            if (this.fWJ != null) {
                nVar.bJe().lc(this.fWL ? false : true);
                this.fWJ.c(nVar.bJe());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.fWJ.vd(0);
            this.fWJ.bFW();
            if (this.fWJ != null) {
                this.fWJ.c(nVar);
                o bJe = nVar.bJe();
                if (nVar.getList().size() == 1) {
                    this.fWJ.a(new ArrayList<>(), nVar.bJc(), this);
                    this.fWJ.kU(false);
                    if (bJe != null) {
                        bJe.lb(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.fWJ.a(arrayList, nVar.bJc(), this);
                    if (bJe != null) {
                        bJe.lb(false);
                    }
                }
                this.fWJ.ve(0);
                this.fWJ.vc(0);
                if (this.fWJ != null) {
                    nVar.bJe().lc(this.fWL ? false : true);
                    this.fWJ.c(bJe);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.fVa >= 2 && hVar.fVa < arrayList.size() + 2) {
                hVar.dT(JavaTypesHelper.toLong(arrayList.get(hVar.fVa - 2).point, 0L));
            }
            if (hVar.fVa < arrayList.size() && hVar.fVa >= 0) {
                hVar.dU(JavaTypesHelper.toLong(arrayList.get(hVar.fVa).point, 0L));
            }
            hVar.dV(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bJE() {
        if (!this.fvF && "hour".equals(this.fvE)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aTc, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fWI != null) {
            this.fWI.destory();
        }
        if (this.fWJ != null) {
            this.fWJ.release();
        }
        if ("hour".equals(this.fvE)) {
            MessageManager.getInstance().unRegisterListener(this.fWT);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fvE)) {
            fWQ.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bJF() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void li(boolean z) {
        if (isAdded()) {
            this.fWL = z;
            if (z) {
                a(this.fWO);
            } else {
                a(this.fWP);
            }
            lj(z);
        }
    }

    private void lj(boolean z) {
        if ("hour".equals(this.fvE)) {
            String str = z ? "hour" : "last_hour";
            if (!fWQ.contains(str)) {
                fWQ.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aTc, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fWJ != null) {
            this.fWJ.EF();
        }
    }
}
