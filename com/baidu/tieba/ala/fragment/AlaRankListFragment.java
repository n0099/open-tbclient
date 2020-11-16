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
    private static Set<String> gBZ = new HashSet();
    private String NA;
    private int aIL;
    private String aZH;
    private long fYO;
    private String fYQ;
    private boolean fYR;
    private String gAg;
    private f gBR;
    private g gBS;
    private int gBT;
    private BdUniqueId gBV;
    private BdUniqueId gBW;
    private p gBX;
    private p gBY;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gBU = true;
    private n gCa = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gBS != null) {
                            AlaRankListFragment.this.gBS.ds(false);
                            if (AlaRankListFragment.this.gBT == 0) {
                                AlaRankListFragment.this.gBS.cld();
                            }
                            AlaRankListFragment.this.gBS.VB();
                            AlaRankListFragment.this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.mj(AlaRankListFragment.this.gBU);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gBT == 0) {
                        AlaRankListFragment.this.gBS.VB();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.gaE == null || alaGetRankListResponseMessage.gaE.size() <= 0) {
                            if (AlaRankListFragment.this.gBS != null) {
                                AlaRankListFragment.this.gBS.cld();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gBS != null) {
                            AlaRankListFragment.this.gBS.a(alaGetRankListResponseMessage.gaE, alaGetRankListResponseMessage.hxU, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gBS.clc() != null && (AlaRankListFragment.this.gBS.clc() instanceof h)) {
                                AlaRankListFragment.this.gBS.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gBS.clc(), alaGetRankListResponseMessage.gaE));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hxW == null) {
                        if (AlaRankListFragment.this.gBS != null) {
                            AlaRankListFragment.this.gBS.cld();
                        }
                    } else if (AlaRankListFragment.this.gBS != null) {
                        AlaRankListFragment.this.gBS.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hxW, AlaRankListFragment.this.gBS.bFb()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p chT = alaGetHourRankListResponseMessage.chT();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gBV != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gBV.getId()) || (AlaRankListFragment.this.gBW != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gBW.getId())) {
                            if (!((AlaRankListFragment.this.gBV != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gBV.getId()) == AlaRankListFragment.this.gBU) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gBV.getId()) {
                                    AlaRankListFragment.this.gBX = chT;
                                    if (AlaRankListFragment.this.gBU) {
                                        AlaRankListFragment.this.gBS.VB();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gBX);
                                    }
                                    AlaRankListFragment.this.mj(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gBW.getId()) {
                                    AlaRankListFragment.this.gBY = chT;
                                    if (!AlaRankListFragment.this.gBU) {
                                        AlaRankListFragment.this.gBS.VB();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gBY);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gBS != null) {
                                AlaRankListFragment.this.gBS.ds(false);
                                AlaRankListFragment.this.gBS.cld();
                                AlaRankListFragment.this.gBS.VB();
                                AlaRankListFragment.this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.mj(AlaRankListFragment.this.gBU);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gCb = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fYQ) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fYQ)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.aa.a.Ph().bms.aKS;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bRX();
            } else if ("hour".equals(AlaRankListFragment.this.fYQ) || "charm_day".equals(AlaRankListFragment.this.fYQ)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bRX();
            }
            if ("hot".equals(AlaRankListFragment.this.fYQ)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gCc = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fYQ)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aZH, hourRankItemData.type, AlaRankListFragment.this.gBU ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gBT;
        alaRankListFragment.gBT = i - 1;
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
        this.fYQ = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.NA = arguments.getString("user_name");
        this.fYR = arguments.getBoolean("is_from_host");
        this.aIL = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aZH = arguments.getString("feed_id");
        this.fYO = arguments.getLong("cur_live_id");
        this.gAg = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fYQ)) {
            MessageManager.getInstance().registerListener(this.gCc);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fYQ)) {
            ml(this.gBU);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gBS = new g(getPageContext(), this.fYQ, this.aIL, this.gCb, this.fYR, this.mUserId, this.NA, this.mPortrait, this.fYO);
        mj(true);
        if ("hour".equals(this.fYQ)) {
            this.gBS.a(this);
        }
        return this.gBS.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fYQ)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(final boolean z) {
        if (this.gBR == null) {
            this.gBR = new f(getUniqueId(), this.gCa);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fYQ, "charm_day")) {
                    this.gBT = 2;
                    if (this.mUserId != 0) {
                        this.gBR.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gBT--;
                        this.gBS.cld();
                    }
                    this.gBR.e(this.fYQ, this.mUserId, "");
                } else if (TextUtils.equals(this.fYQ, "hour")) {
                    if (this.mUserId == 0) {
                        this.gBS.cld();
                    }
                    if (z) {
                        this.gBV = BdUniqueId.gen();
                        this.gBR.a(this.fYQ, this.mUserId, "", this.gBV);
                        return;
                    }
                    this.gBW = BdUniqueId.gen();
                    if (this.gBX != null && !TextUtils.isEmpty(this.gBX.TU())) {
                        this.gBR.a(this.fYQ, this.mUserId, StringHelper.getHourRankPreHourString(this.gBX.TU(), -1), this.gBW);
                    }
                }
            }
        } else if (this.gBS != null) {
            this.gBS.VB();
            this.gBS.ds(false);
            this.gBS.cld();
            this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.mj(z);
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
            if (this.gBS != null) {
                this.gBS.cld();
                this.gBS.VB();
                this.gBS.a(new ArrayList<>(), this.gBX == null ? 0L : this.gBX.bRu(), this);
                this.gBS.xh(0);
                this.gBS.ds(false);
                this.gBS.xg(8);
                this.gBS.gx(8);
                this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.mj(AlaRankListFragment.this.gBU);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gBS.VB();
            this.gBS.gx(0);
            this.gBS.a(new ArrayList<>(), pVar.bRu(), this);
            this.gBS.xh(0);
            this.gBS.ds(true);
            this.gBS.xg(8);
            if (this.gBS != null) {
                pVar.bRw().me(this.gBU ? false : true);
                this.gBS.c(pVar.bRw());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gBS.gx(0);
            this.gBS.VB();
            if (this.gBS != null) {
                this.gBS.c(pVar);
                r bRw = pVar.bRw();
                if (pVar.getList().size() == 1) {
                    this.gBS.a(new ArrayList<>(), pVar.bRu(), this);
                    this.gBS.ds(false);
                    if (bRw != null) {
                        bRw.bq(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gBS.a(arrayList, pVar.bRu(), this);
                    if (bRw != null) {
                        bRw.bq(false);
                    }
                }
                this.gBS.xh(0);
                this.gBS.xg(0);
                if (this.gBS != null) {
                    pVar.bRw().me(this.gBU ? false : true);
                    this.gBS.c(bRw);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aGr >= 2 && hVar.aGr < arrayList.size() + 2) {
                hVar.eC(JavaTypesHelper.toLong(arrayList.get(hVar.aGr - 2).point, 0L));
            }
            if (hVar.aGr < arrayList.size() && hVar.aGr >= 0) {
                hVar.eD(JavaTypesHelper.toLong(arrayList.get(hVar.aGr).point, 0L));
            }
            hVar.an(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bRX() {
        if (!this.fYR && "hour".equals(this.fYQ)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aZH, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gBR != null) {
            this.gBR.destory();
        }
        if (this.gBS != null) {
            this.gBS.release();
        }
        if ("hour".equals(this.fYQ)) {
            MessageManager.getInstance().unRegisterListener(this.gCc);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fYQ)) {
            gBZ.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bRY() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mk(boolean z) {
        if (isAdded()) {
            this.gBU = z;
            if (z) {
                a(this.gBX);
            } else {
                a(this.gBY);
            }
            ml(z);
        }
    }

    private void ml(boolean z) {
        if ("hour".equals(this.fYQ)) {
            String str = z ? "hour" : "last_hour";
            if (!gBZ.contains(str)) {
                gBZ.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aZH, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gBS != null) {
            this.gBS.FZ();
        }
    }
}
