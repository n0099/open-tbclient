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
    private static Set<String> gwE = new HashSet();
    private String NA;
    private int aJw;
    private String baa;
    private long fTr;
    private String fTt;
    private boolean fTu;
    private String guL;
    private BdUniqueId gwA;
    private BdUniqueId gwB;
    private p gwC;
    private p gwD;
    private f gww;
    private g gwx;
    private int gwy;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gwz = true;
    private n gwF = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gwx != null) {
                            AlaRankListFragment.this.gwx.dj(false);
                            if (AlaRankListFragment.this.gwy == 0) {
                                AlaRankListFragment.this.gwx.cji();
                            }
                            AlaRankListFragment.this.gwx.TK();
                            AlaRankListFragment.this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.lZ(AlaRankListFragment.this.gwz);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gwy == 0) {
                        AlaRankListFragment.this.gwx.TK();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fVg == null || alaGetRankListResponseMessage.fVg.size() <= 0) {
                            if (AlaRankListFragment.this.gwx != null) {
                                AlaRankListFragment.this.gwx.cji();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gwx != null) {
                            AlaRankListFragment.this.gwx.a(alaGetRankListResponseMessage.fVg, alaGetRankListResponseMessage.hsq, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gwx.cjh() != null && (AlaRankListFragment.this.gwx.cjh() instanceof h)) {
                                AlaRankListFragment.this.gwx.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gwx.cjh(), alaGetRankListResponseMessage.fVg));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hss == null) {
                        if (AlaRankListFragment.this.gwx != null) {
                            AlaRankListFragment.this.gwx.cji();
                        }
                    } else if (AlaRankListFragment.this.gwx != null) {
                        AlaRankListFragment.this.gwx.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hss, AlaRankListFragment.this.gwx.bDj()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p cfY = alaGetHourRankListResponseMessage.cfY();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gwA != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gwA.getId()) || (AlaRankListFragment.this.gwB != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gwB.getId())) {
                            if (!((AlaRankListFragment.this.gwA != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gwA.getId()) == AlaRankListFragment.this.gwz) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gwA.getId()) {
                                    AlaRankListFragment.this.gwC = cfY;
                                    if (AlaRankListFragment.this.gwz) {
                                        AlaRankListFragment.this.gwx.TK();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gwC);
                                    }
                                    AlaRankListFragment.this.lZ(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gwB.getId()) {
                                    AlaRankListFragment.this.gwD = cfY;
                                    if (!AlaRankListFragment.this.gwz) {
                                        AlaRankListFragment.this.gwx.TK();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gwD);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gwx != null) {
                                AlaRankListFragment.this.gwx.dj(false);
                                AlaRankListFragment.this.gwx.cji();
                                AlaRankListFragment.this.gwx.TK();
                                AlaRankListFragment.this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.lZ(AlaRankListFragment.this.gwz);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gwG = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fTt) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fTt)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.z.a.Pq().bmJ.aLD;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bQe();
            } else if ("hour".equals(AlaRankListFragment.this.fTt) || "charm_day".equals(AlaRankListFragment.this.fTt)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bQe();
            }
            if ("hot".equals(AlaRankListFragment.this.fTt)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gwH = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fTt)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.baa, hourRankItemData.type, AlaRankListFragment.this.gwz ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gwy;
        alaRankListFragment.gwy = i - 1;
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
        this.fTt = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.NA = arguments.getString("user_name");
        this.fTu = arguments.getBoolean("is_from_host");
        this.aJw = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.baa = arguments.getString("feed_id");
        this.fTr = arguments.getLong("cur_live_id");
        this.guL = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fTt)) {
            MessageManager.getInstance().registerListener(this.gwH);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fTt)) {
            mb(this.gwz);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gwx = new g(getPageContext(), this.fTt, this.aJw, this.gwG, this.fTu, this.mUserId, this.NA, this.mPortrait, this.fTr);
        lZ(true);
        if ("hour".equals(this.fTt)) {
            this.gwx.a(this);
        }
        return this.gwx.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fTt)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(final boolean z) {
        if (this.gww == null) {
            this.gww = new f(getUniqueId(), this.gwF);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fTt, "charm_day")) {
                    this.gwy = 2;
                    if (this.mUserId != 0) {
                        this.gww.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gwy--;
                        this.gwx.cji();
                    }
                    this.gww.e(this.fTt, this.mUserId, "");
                } else if (TextUtils.equals(this.fTt, "hour")) {
                    if (this.mUserId == 0) {
                        this.gwx.cji();
                    }
                    if (z) {
                        this.gwA = BdUniqueId.gen();
                        this.gww.a(this.fTt, this.mUserId, "", this.gwA);
                        return;
                    }
                    this.gwB = BdUniqueId.gen();
                    if (this.gwC != null && !TextUtils.isEmpty(this.gwC.RV())) {
                        this.gww.a(this.fTt, this.mUserId, StringHelper.getHourRankPreHourString(this.gwC.RV(), -1), this.gwB);
                    }
                }
            }
        } else if (this.gwx != null) {
            this.gwx.TK();
            this.gwx.dj(false);
            this.gwx.cji();
            this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.lZ(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gwx != null) {
                this.gwx.cji();
                this.gwx.TK();
                this.gwx.a(new ArrayList<>(), this.gwC == null ? 0L : this.gwC.bPB(), this);
                this.gwx.ww(0);
                this.gwx.dj(false);
                this.gwx.wv(8);
                this.gwx.gr(8);
                this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.lZ(AlaRankListFragment.this.gwz);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gwx.TK();
            this.gwx.gr(0);
            this.gwx.a(new ArrayList<>(), pVar.bPB(), this);
            this.gwx.ww(0);
            this.gwx.dj(true);
            this.gwx.wv(8);
            if (this.gwx != null) {
                pVar.bPD().lU(this.gwz ? false : true);
                this.gwx.c(pVar.bPD());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gwx.gr(0);
            this.gwx.TK();
            if (this.gwx != null) {
                this.gwx.c(pVar);
                r bPD = pVar.bPD();
                if (pVar.getList().size() == 1) {
                    this.gwx.a(new ArrayList<>(), pVar.bPB(), this);
                    this.gwx.dj(false);
                    if (bPD != null) {
                        bPD.bn(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gwx.a(arrayList, pVar.bPB(), this);
                    if (bPD != null) {
                        bPD.bn(false);
                    }
                }
                this.gwx.ww(0);
                this.gwx.wv(0);
                if (this.gwx != null) {
                    pVar.bPD().lU(this.gwz ? false : true);
                    this.gwx.c(bPD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aHl >= 2 && hVar.aHl < arrayList.size() + 2) {
                hVar.eg(JavaTypesHelper.toLong(arrayList.get(hVar.aHl - 2).point, 0L));
            }
            if (hVar.aHl < arrayList.size() && hVar.aHl >= 0) {
                hVar.eh(JavaTypesHelper.toLong(arrayList.get(hVar.aHl).point, 0L));
            }
            hVar.ab(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bQe() {
        if (!this.fTu && "hour".equals(this.fTt)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.baa, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gww != null) {
            this.gww.destory();
        }
        if (this.gwx != null) {
            this.gwx.release();
        }
        if ("hour".equals(this.fTt)) {
            MessageManager.getInstance().unRegisterListener(this.gwH);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fTt)) {
            gwE.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bQf() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ma(boolean z) {
        if (isAdded()) {
            this.gwz = z;
            if (z) {
                a(this.gwC);
            } else {
                a(this.gwD);
            }
            mb(z);
        }
    }

    private void mb(boolean z) {
        if ("hour".equals(this.fTt)) {
            String str = z ? "hour" : "last_hour";
            if (!gwE.contains(str)) {
                gwE.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.baa, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gwx != null) {
            this.gwx.Gh();
        }
    }
}
