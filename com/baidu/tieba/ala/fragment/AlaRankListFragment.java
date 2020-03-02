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
import com.baidu.live.v.a;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.e.d;
import com.baidu.tieba.ala.e.j;
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
    private static Set<String> eBo = new HashSet();
    private int Yx;
    private String alG;
    private String eAa;
    private d eBg;
    private com.baidu.tieba.ala.view.d eBh;
    private int eBi;
    private BdUniqueId eBk;
    private BdUniqueId eBl;
    private m eBm;
    private m eBn;
    private long ehL;
    private String ehN;
    private boolean ehO;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String sI;
    private boolean eBj = true;
    private j eBp = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.eBh != null) {
                            AlaRankListFragment.this.eBh.ij(false);
                            if (AlaRankListFragment.this.eBi == 0) {
                                AlaRankListFragment.this.eBh.btE();
                            }
                            AlaRankListFragment.this.eBh.bcx();
                            AlaRankListFragment.this.eBh.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.it(AlaRankListFragment.this.eBj);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.eBi == 0) {
                        AlaRankListFragment.this.eBh.bcx();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.ejB == null || alaGetRankListResponseMessage.ejB.size() <= 0) {
                            if (AlaRankListFragment.this.eBh != null) {
                                AlaRankListFragment.this.eBh.btE();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.eBh != null) {
                            AlaRankListFragment.this.eBh.a(alaGetRankListResponseMessage.ejB, alaGetRankListResponseMessage.fpc, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.eBh.btD() != null && (AlaRankListFragment.this.eBh.btD() instanceof g)) {
                                AlaRankListFragment.this.eBh.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.eBh.btD(), alaGetRankListResponseMessage.ejB));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.fpe == null) {
                        if (AlaRankListFragment.this.eBh != null) {
                            AlaRankListFragment.this.eBh.btE();
                        }
                    } else if (AlaRankListFragment.this.eBh != null) {
                        AlaRankListFragment.this.eBh.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fpe, AlaRankListFragment.this.eBh.aTS()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m brz = alaGetHourRankListResponseMessage.brz();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.eBk != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBk.getId()) || (AlaRankListFragment.this.eBl != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBl.getId())) {
                            if (!((AlaRankListFragment.this.eBk != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBk.getId()) == AlaRankListFragment.this.eBj) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBk.getId()) {
                                    AlaRankListFragment.this.eBm = brz;
                                    if (AlaRankListFragment.this.eBj) {
                                        AlaRankListFragment.this.eBh.bcx();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBm);
                                    }
                                    AlaRankListFragment.this.it(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBl.getId()) {
                                    AlaRankListFragment.this.eBn = brz;
                                    if (!AlaRankListFragment.this.eBj) {
                                        AlaRankListFragment.this.eBh.bcx();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBn);
                                    }
                                }
                            } else if (AlaRankListFragment.this.eBh != null) {
                                AlaRankListFragment.this.eBh.ij(false);
                                AlaRankListFragment.this.eBh.btE();
                                AlaRankListFragment.this.eBh.bcx();
                                AlaRankListFragment.this.eBh.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.it(AlaRankListFragment.this.eBj);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a eBq = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.ehN) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.ehN) || "hour".equals(AlaRankListFragment.this.ehN) || "charm_day".equals(AlaRankListFragment.this.ehN)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.zl().awB.aan;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.beI();
            }
            if ("hot".equals(AlaRankListFragment.this.ehN)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener eBr = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.ehN)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.alG, hourRankItemData.type, AlaRankListFragment.this.eBj ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.eBi;
        alaRankListFragment.eBi = i - 1;
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
        this.ehN = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.sI = arguments.getString("user_name");
        this.ehO = arguments.getBoolean("is_from_host");
        this.Yx = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.alG = arguments.getString("feed_id");
        this.ehL = arguments.getLong("cur_live_id");
        this.eAa = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.ehN)) {
            MessageManager.getInstance().registerListener(this.eBr);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.ehN)) {
            iv(this.eBj);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eBh = new com.baidu.tieba.ala.view.d(getPageContext(), this.ehN, this.Yx, this.eBq, this.ehO, this.mUserId, this.sI, this.mPortrait, this.ehL);
        it(true);
        if ("hour".equals(this.ehN)) {
            this.eBh.a(this);
        }
        return this.eBh.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehN)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void it(final boolean z) {
        if (this.eBg == null) {
            this.eBg = new com.baidu.tieba.ala.e.d(getUniqueId(), this.eBp);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.ehN, "charm_day")) {
                    this.eBi = 2;
                    if (this.mUserId != 0) {
                        this.eBg.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.eBi--;
                        this.eBh.btE();
                    }
                    this.eBg.e(this.ehN, this.mUserId, "");
                } else if (TextUtils.equals(this.ehN, "hour")) {
                    if (this.mUserId == 0) {
                        this.eBh.btE();
                    }
                    if (z) {
                        this.eBk = BdUniqueId.gen();
                        this.eBg.a(this.ehN, this.mUserId, "", this.eBk);
                        return;
                    }
                    this.eBl = BdUniqueId.gen();
                    if (this.eBm != null && !TextUtils.isEmpty(this.eBm.AY())) {
                        this.eBg.a(this.ehN, this.mUserId, StringHelper.getHourRankPreHourString(this.eBm.AY(), -1), this.eBl);
                    }
                }
            }
        } else if (this.eBh != null) {
            this.eBh.bcx();
            this.eBh.ij(false);
            this.eBh.btE();
            this.eBh.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.it(z);
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
            if (this.eBh != null) {
                this.eBh.btE();
                this.eBh.bcx();
                this.eBh.a(new ArrayList<>(), this.eBm == null ? 0L : this.eBm.bez(), this);
                this.eBh.qZ(0);
                this.eBh.ij(false);
                this.eBh.qX(8);
                this.eBh.qY(8);
                this.eBh.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.it(AlaRankListFragment.this.eBj);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.eBh.bcx();
            this.eBh.qY(0);
            this.eBh.a(new ArrayList<>(), mVar.bez(), this);
            this.eBh.qZ(0);
            this.eBh.ij(true);
            this.eBh.qX(8);
            if (this.eBh != null) {
                mVar.beB().iq(this.eBj ? false : true);
                this.eBh.c(mVar.beB());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.eBh.qY(0);
            this.eBh.bcx();
            if (this.eBh != null) {
                this.eBh.c(mVar);
                n beB = mVar.beB();
                if (mVar.getList().size() == 1) {
                    this.eBh.a(new ArrayList<>(), mVar.bez(), this);
                    this.eBh.ij(false);
                    if (beB != null) {
                        beB.ip(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.eBh.a(arrayList, mVar.bez(), this);
                    if (beB != null) {
                        beB.ip(false);
                    }
                }
                this.eBh.qZ(0);
                this.eBh.qX(0);
                if (this.eBh != null) {
                    mVar.beB().iq(this.eBj ? false : true);
                    this.eBh.c(beB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.eAg >= 2 && gVar.eAg < arrayList.size() + 2) {
                gVar.cH(JavaTypesHelper.toLong(arrayList.get(gVar.eAg - 2).point, 0L));
            }
            if (gVar.eAg < arrayList.size() && gVar.eAg >= 0) {
                gVar.cI(JavaTypesHelper.toLong(arrayList.get(gVar.eAg).point, 0L));
            }
            gVar.cJ(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void beI() {
        if (!this.ehO && "hour".equals(this.ehN)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.alG, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eBg != null) {
            this.eBg.destory();
        }
        if (this.eBh != null) {
            this.eBh.release();
        }
        if ("hour".equals(this.ehN)) {
            MessageManager.getInstance().unRegisterListener(this.eBr);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.ehN)) {
            eBo.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void beJ() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void iu(boolean z) {
        if (isAdded()) {
            this.eBj = z;
            if (z) {
                a(this.eBm);
            } else {
                a(this.eBn);
            }
            iv(z);
        }
    }

    private void iv(boolean z) {
        if ("hour".equals(this.ehN)) {
            String str = z ? "hour" : "last_hour";
            if (!eBo.contains(str)) {
                eBo.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.alG, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.eBh != null) {
            this.eBh.sm();
        }
    }
}
