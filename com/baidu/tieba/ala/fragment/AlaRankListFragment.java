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
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.f.d;
import com.baidu.tieba.ala.f.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fun = new HashSet();
    private String LR;
    private String aJO;
    private int avX;
    private long eUS;
    private String eUU;
    private boolean eUV;
    private String fsX;
    private d fuf;
    private com.baidu.tieba.ala.view.d fug;
    private int fuh;
    private BdUniqueId fuj;
    private BdUniqueId fuk;
    private m ful;
    private m fum;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fui = true;
    private j fuo = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.fug != null) {
                            AlaRankListFragment.this.fug.jF(false);
                            if (AlaRankListFragment.this.fuh == 0) {
                                AlaRankListFragment.this.fug.bJN();
                            }
                            AlaRankListFragment.this.fug.bqQ();
                            AlaRankListFragment.this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.jP(AlaRankListFragment.this.fui);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.fuh == 0) {
                        AlaRankListFragment.this.fug.bqQ();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.eWD == null || alaGetRankListResponseMessage.eWD.size() <= 0) {
                            if (AlaRankListFragment.this.fug != null) {
                                AlaRankListFragment.this.fug.bJN();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.fug != null) {
                            AlaRankListFragment.this.fug.a(alaGetRankListResponseMessage.eWD, alaGetRankListResponseMessage.gjt, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.fug.bJM() != null && (AlaRankListFragment.this.fug.bJM() instanceof g)) {
                                AlaRankListFragment.this.fug.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.fug.bJM(), alaGetRankListResponseMessage.eWD));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gjv == null) {
                        if (AlaRankListFragment.this.fug != null) {
                            AlaRankListFragment.this.fug.bJN();
                        }
                    } else if (AlaRankListFragment.this.fug != null) {
                        AlaRankListFragment.this.fug.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.gjv, AlaRankListFragment.this.fug.bis()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bHC = alaGetHourRankListResponseMessage.bHC();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.fuj != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fuj.getId()) || (AlaRankListFragment.this.fuk != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fuk.getId())) {
                            if (!((AlaRankListFragment.this.fuj != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fuj.getId()) == AlaRankListFragment.this.fui) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fuj.getId()) {
                                    AlaRankListFragment.this.ful = bHC;
                                    if (AlaRankListFragment.this.fui) {
                                        AlaRankListFragment.this.fug.bqQ();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.ful);
                                    }
                                    AlaRankListFragment.this.jP(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fuk.getId()) {
                                    AlaRankListFragment.this.fum = bHC;
                                    if (!AlaRankListFragment.this.fui) {
                                        AlaRankListFragment.this.fug.bqQ();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fum);
                                    }
                                }
                            } else if (AlaRankListFragment.this.fug != null) {
                                AlaRankListFragment.this.fug.jF(false);
                                AlaRankListFragment.this.fug.bJN();
                                AlaRankListFragment.this.fug.bqQ();
                                AlaRankListFragment.this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.jP(AlaRankListFragment.this.fui);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a fup = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.eUU) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.eUU)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.v.a.Ge().aWF.axS;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.btX();
            } else if ("hour".equals(AlaRankListFragment.this.eUU) || "charm_day".equals(AlaRankListFragment.this.eUU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.btX();
            }
            if ("hot".equals(AlaRankListFragment.this.eUU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener fuq = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.eUU)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aJO, hourRankItemData.type, AlaRankListFragment.this.fui ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.fuh;
        alaRankListFragment.fuh = i - 1;
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
        this.eUU = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.LR = arguments.getString("user_name");
        this.eUV = arguments.getBoolean("is_from_host");
        this.avX = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aJO = arguments.getString("feed_id");
        this.eUS = arguments.getLong("cur_live_id");
        this.fsX = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.eUU)) {
            MessageManager.getInstance().registerListener(this.fuq);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.eUU)) {
            jR(this.fui);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fug = new com.baidu.tieba.ala.view.d(getPageContext(), this.eUU, this.avX, this.fup, this.eUV, this.mUserId, this.LR, this.mPortrait, this.eUS);
        jP(true);
        if ("hour".equals(this.eUU)) {
            this.fug.a(this);
        }
        return this.fug.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eUU)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(final boolean z) {
        if (this.fuf == null) {
            this.fuf = new com.baidu.tieba.ala.f.d(getUniqueId(), this.fuo);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.eUU, "charm_day")) {
                    this.fuh = 2;
                    if (this.mUserId != 0) {
                        this.fuf.y(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fuh--;
                        this.fug.bJN();
                    }
                    this.fuf.e(this.eUU, this.mUserId, "");
                } else if (TextUtils.equals(this.eUU, "hour")) {
                    if (this.mUserId == 0) {
                        this.fug.bJN();
                    }
                    if (z) {
                        this.fuj = BdUniqueId.gen();
                        this.fuf.a(this.eUU, this.mUserId, "", this.fuj);
                        return;
                    }
                    this.fuk = BdUniqueId.gen();
                    if (this.ful != null && !TextUtils.isEmpty(this.ful.HV())) {
                        this.fuf.a(this.eUU, this.mUserId, StringHelper.getHourRankPreHourString(this.ful.HV(), -1), this.fuk);
                    }
                }
            }
        } else if (this.fug != null) {
            this.fug.bqQ();
            this.fug.jF(false);
            this.fug.bJN();
            this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.jP(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar == null) {
            if (this.fug != null) {
                this.fug.bJN();
                this.fug.bqQ();
                this.fug.a(new ArrayList<>(), this.ful == null ? 0L : this.ful.btN(), this);
                this.fug.rZ(0);
                this.fug.jF(false);
                this.fug.rX(8);
                this.fug.rY(8);
                this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.jP(AlaRankListFragment.this.fui);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.fug.bqQ();
            this.fug.rY(0);
            this.fug.a(new ArrayList<>(), mVar.btN(), this);
            this.fug.rZ(0);
            this.fug.jF(true);
            this.fug.rX(8);
            if (this.fug != null) {
                mVar.btP().jM(this.fui ? false : true);
                this.fug.c(mVar.btP());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.fug.rY(0);
            this.fug.bqQ();
            if (this.fug != null) {
                this.fug.c(mVar);
                n btP = mVar.btP();
                if (mVar.getList().size() == 1) {
                    this.fug.a(new ArrayList<>(), mVar.btN(), this);
                    this.fug.jF(false);
                    if (btP != null) {
                        btP.jL(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.fug.a(arrayList, mVar.btN(), this);
                    if (btP != null) {
                        btP.jL(false);
                    }
                }
                this.fug.rZ(0);
                this.fug.rX(0);
                if (this.fug != null) {
                    mVar.btP().jM(this.fui ? false : true);
                    this.fug.c(btP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.ftd >= 2 && gVar.ftd < arrayList.size() + 2) {
                gVar.dr(JavaTypesHelper.toLong(arrayList.get(gVar.ftd - 2).point, 0L));
            }
            if (gVar.ftd < arrayList.size() && gVar.ftd >= 0) {
                gVar.ds(JavaTypesHelper.toLong(arrayList.get(gVar.ftd).point, 0L));
            }
            gVar.dt(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void btX() {
        if (!this.eUV && "hour".equals(this.eUU)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aJO, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fuf != null) {
            this.fuf.destory();
        }
        if (this.fug != null) {
            this.fug.release();
        }
        if ("hour".equals(this.eUU)) {
            MessageManager.getInstance().unRegisterListener(this.fuq);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.eUU)) {
            fun.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void btY() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void jQ(boolean z) {
        if (isAdded()) {
            this.fui = z;
            if (z) {
                a(this.ful);
            } else {
                a(this.fum);
            }
            jR(z);
        }
    }

    private void jR(boolean z) {
        if ("hour".equals(this.eUU)) {
            String str = z ? "hour" : "last_hour";
            if (!fun.contains(str)) {
                fun.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aJO, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fug != null) {
            this.fug.ya();
        }
    }
}
