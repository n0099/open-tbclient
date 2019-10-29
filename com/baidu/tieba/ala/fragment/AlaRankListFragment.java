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
import com.baidu.live.k.a;
import com.baidu.live.l.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.c.b;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.c;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> dIx = new HashSet();
    private int Qc;
    private String abe;
    private String dHm;
    private b dIp;
    private d dIq;
    private int dIr;
    private BdUniqueId dIt;
    private BdUniqueId dIu;
    private e dIv;
    private e dIw;
    private long duD;
    private String duF;
    private boolean duG;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String qt;
    private boolean dIs = true;
    private com.baidu.tieba.ala.c.d dIy = new com.baidu.tieba.ala.c.d() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.c.d
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.dIq != null) {
                            AlaRankListFragment.this.dIq.gN(false);
                            if (AlaRankListFragment.this.dIr == 0) {
                                AlaRankListFragment.this.dIq.aYX();
                            }
                            AlaRankListFragment.this.dIq.aJo();
                            AlaRankListFragment.this.dIq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.gV(AlaRankListFragment.this.dIs);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.dIr == 0) {
                        AlaRankListFragment.this.dIq.aJo();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.dve == null || alaGetRankListResponseMessage.dve.size() <= 0) {
                            if (AlaRankListFragment.this.dIq != null) {
                                AlaRankListFragment.this.dIq.aYX();
                                return;
                            }
                            return;
                        }
                        if (AlaRankListFragment.this.dIq != null) {
                            AlaRankListFragment.this.dIq.a(alaGetRankListResponseMessage.dve, alaGetRankListResponseMessage.etg, AlaRankListFragment.this);
                        }
                        if (AlaRankListFragment.this.dIq.aYW() != null && (AlaRankListFragment.this.dIq.aYW() instanceof c)) {
                            AlaRankListFragment.this.dIq.c(AlaRankListFragment.this.a((c) AlaRankListFragment.this.dIq.aYW(), alaGetRankListResponseMessage.dve));
                        }
                    } else if (obj instanceof AlaGetUserRankInfoResponseMessage) {
                        AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                        if (alaGetUserRankInfoResponseMessage.eth == null) {
                            if (AlaRankListFragment.this.dIq != null) {
                                AlaRankListFragment.this.dIq.aYX();
                            }
                        } else if (alaGetUserRankInfoResponseMessage.eth != null && AlaRankListFragment.this.dIq != null) {
                            AlaRankListFragment.this.dIq.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.eth, AlaRankListFragment.this.dIq.azh()));
                        }
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    e aXf = alaGetHourRankListResponseMessage.aXf();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.dIt != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dIt.getId()) || (AlaRankListFragment.this.dIu != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dIu.getId())) {
                            if (!((AlaRankListFragment.this.dIt != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dIt.getId()) == AlaRankListFragment.this.dIs) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dIt.getId()) {
                                    AlaRankListFragment.this.dIv = aXf;
                                    if (AlaRankListFragment.this.dIs) {
                                        AlaRankListFragment.this.dIq.aJo();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.dIv);
                                    }
                                    AlaRankListFragment.this.gV(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.dIu.getId()) {
                                    AlaRankListFragment.this.dIw = aXf;
                                    if (!AlaRankListFragment.this.dIs) {
                                        AlaRankListFragment.this.dIq.aJo();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.dIw);
                                    }
                                }
                            } else if (AlaRankListFragment.this.dIq != null) {
                                AlaRankListFragment.this.dIq.gN(false);
                                AlaRankListFragment.this.dIq.aYX();
                                AlaRankListFragment.this.dIq.aJo();
                                AlaRankListFragment.this.dIq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.gV(AlaRankListFragment.this.dIs);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a dIz = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.duF) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.duF) || "hour".equals(AlaRankListFragment.this.duF) || "charm_day".equals(AlaRankListFragment.this.duF)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.uA().ajX.RY;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.aKO();
            }
            if ("hot".equals(AlaRankListFragment.this.duF)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener dIA = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.duF)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.abe, hourRankItemData.type, AlaRankListFragment.this.dIs ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.dIr;
        alaRankListFragment.dIr = i - 1;
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
        this.duF = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.qt = arguments.getString("user_name");
        this.duG = arguments.getBoolean("is_from_host");
        this.Qc = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.abe = arguments.getString("feed_id");
        this.duD = arguments.getLong("cur_live_id");
        this.dHm = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.duF)) {
            MessageManager.getInstance().registerListener(this.dIA);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.duF)) {
            gX(this.dIs);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dIq = new d(getPageContext(), this.duF, this.Qc, this.dIz, this.duG, this.mUserId, this.qt, this.mPortrait, this.duD);
        gV(true);
        if ("hour".equals(this.duF)) {
            this.dIq.a(this);
        }
        return this.dIq.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.duF)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(final boolean z) {
        if (this.dIp == null) {
            this.dIp = new b(getUniqueId(), this.dIy);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.duF, "charm_day")) {
                    this.dIr = 2;
                    if (this.mUserId != 0) {
                        this.dIp.w(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.dIr--;
                        this.dIq.aYX();
                    }
                    this.dIp.c(this.duF, this.mUserId, "");
                } else if (TextUtils.equals(this.duF, "hour")) {
                    if (this.mUserId == 0) {
                        this.dIq.aYX();
                    }
                    if (z) {
                        this.dIt = BdUniqueId.gen();
                        this.dIp.a(this.duF, this.mUserId, "", this.dIt);
                        return;
                    }
                    this.dIu = BdUniqueId.gen();
                    if (this.dIv != null && !TextUtils.isEmpty(this.dIv.wq())) {
                        this.dIp.a(this.duF, this.mUserId, StringHelper.getHourRankPreHourString(this.dIv.wq(), -1), this.dIu);
                    }
                }
            }
        } else if (this.dIq != null) {
            this.dIq.aJo();
            this.dIq.gN(false);
            this.dIq.aYX();
            this.dIq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.gV(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (eVar == null) {
            if (this.dIq != null) {
                this.dIq.aYX();
                this.dIq.aJo();
                this.dIq.a(new ArrayList<>(), this.dIv == null ? 0L : this.dIv.aKD(), this);
                this.dIq.ou(0);
                this.dIq.gN(false);
                this.dIq.os(8);
                this.dIq.ot(8);
                this.dIq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.gV(AlaRankListFragment.this.dIs);
                    }
                });
            }
        } else if (eVar != null && (eVar.getList() == null || eVar.getList().size() <= 0)) {
            this.dIq.aJo();
            this.dIq.ot(0);
            if (eVar != null) {
                this.dIq.a(new ArrayList<>(), eVar.aKD(), this);
                this.dIq.ou(0);
                this.dIq.gN(true);
                this.dIq.os(8);
            }
            if (this.dIq != null) {
                eVar.aKF().gS(this.dIs ? false : true);
                this.dIq.c(eVar.aKF());
            }
        } else if (eVar != null && eVar.getList() != null && eVar.getList().size() > 0) {
            this.dIq.ot(0);
            this.dIq.aJo();
            if (this.dIq != null) {
                this.dIq.c(eVar);
                f aKF = eVar.aKF();
                if (eVar.getList().size() == 1) {
                    this.dIq.a(new ArrayList<>(), eVar.aKD(), this);
                    this.dIq.gN(false);
                    if (aKF != null) {
                        aKF.gR(true);
                    }
                } else if (eVar.getList().size() > 1) {
                    int size = eVar.getList().size();
                    ArrayList<c> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(eVar.getList().get(i));
                    }
                    this.dIq.a(arrayList, eVar.aKD(), this);
                    if (aKF != null) {
                        aKF.gR(false);
                    }
                }
                this.dIq.ou(0);
                this.dIq.os(0);
                if (this.dIq != null) {
                    eVar.aKF().gS(this.dIs ? false : true);
                    this.dIq.c(aKF);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(c cVar, ArrayList<c> arrayList) {
        cVar.a(cVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (cVar.dHs >= 2 && cVar.dHs < arrayList.size() + 2) {
                cVar.bW(JavaTypesHelper.toLong(arrayList.get(cVar.dHs - 2).TS, 0L));
            }
            if (cVar.dHs < arrayList.size() && cVar.dHs >= 0) {
                cVar.bX(JavaTypesHelper.toLong(arrayList.get(cVar.dHs).TS, 0L));
            }
            cVar.bY(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).TS, 0L));
        }
        return cVar;
    }

    public void aKO() {
        if (!this.duG && "hour".equals(this.duF)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.abe, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dIp != null) {
            this.dIp.destory();
        }
        if (this.dIq != null) {
            this.dIq.release();
        }
        if ("hour".equals(this.duF)) {
            MessageManager.getInstance().unRegisterListener(this.dIA);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.duF)) {
            dIx.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void aKP() {
        if (isAdded()) {
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void gW(boolean z) {
        if (isAdded()) {
            this.dIs = z;
            if (z) {
                a(this.dIv);
            } else {
                a(this.dIw);
            }
            gX(z);
        }
    }

    private void gX(boolean z) {
        if ("hour".equals(this.duF)) {
            String str = z ? "hour" : "last_hour";
            if (!dIx.contains(str)) {
                dIx.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.abe, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dIq != null) {
            this.dIq.pC();
        }
    }
}
