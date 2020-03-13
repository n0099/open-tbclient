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
    private static Set<String> eBB = new HashSet();
    private int Yx;
    private String alH;
    private String eAn;
    private m eBA;
    private d eBt;
    private com.baidu.tieba.ala.view.d eBu;
    private int eBv;
    private BdUniqueId eBx;
    private BdUniqueId eBy;
    private m eBz;
    private long ehY;
    private String eia;
    private boolean eib;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String sI;
    private boolean eBw = true;
    private j eBC = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.eBu != null) {
                            AlaRankListFragment.this.eBu.ij(false);
                            if (AlaRankListFragment.this.eBv == 0) {
                                AlaRankListFragment.this.eBu.btF();
                            }
                            AlaRankListFragment.this.eBu.bcy();
                            AlaRankListFragment.this.eBu.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.it(AlaRankListFragment.this.eBw);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.eBv == 0) {
                        AlaRankListFragment.this.eBu.bcy();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.ejO == null || alaGetRankListResponseMessage.ejO.size() <= 0) {
                            if (AlaRankListFragment.this.eBu != null) {
                                AlaRankListFragment.this.eBu.btF();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.eBu != null) {
                            AlaRankListFragment.this.eBu.a(alaGetRankListResponseMessage.ejO, alaGetRankListResponseMessage.fpp, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.eBu.btE() != null && (AlaRankListFragment.this.eBu.btE() instanceof g)) {
                                AlaRankListFragment.this.eBu.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.eBu.btE(), alaGetRankListResponseMessage.ejO));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.fpr == null) {
                        if (AlaRankListFragment.this.eBu != null) {
                            AlaRankListFragment.this.eBu.btF();
                        }
                    } else if (AlaRankListFragment.this.eBu != null) {
                        AlaRankListFragment.this.eBu.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fpr, AlaRankListFragment.this.eBu.aTT()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m brA = alaGetHourRankListResponseMessage.brA();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.eBx != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBx.getId()) || (AlaRankListFragment.this.eBy != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBy.getId())) {
                            if (!((AlaRankListFragment.this.eBx != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBx.getId()) == AlaRankListFragment.this.eBw) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBx.getId()) {
                                    AlaRankListFragment.this.eBz = brA;
                                    if (AlaRankListFragment.this.eBw) {
                                        AlaRankListFragment.this.eBu.bcy();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBz);
                                    }
                                    AlaRankListFragment.this.it(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBy.getId()) {
                                    AlaRankListFragment.this.eBA = brA;
                                    if (!AlaRankListFragment.this.eBw) {
                                        AlaRankListFragment.this.eBu.bcy();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBA);
                                    }
                                }
                            } else if (AlaRankListFragment.this.eBu != null) {
                                AlaRankListFragment.this.eBu.ij(false);
                                AlaRankListFragment.this.eBu.btF();
                                AlaRankListFragment.this.eBu.bcy();
                                AlaRankListFragment.this.eBu.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.it(AlaRankListFragment.this.eBw);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a eBD = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.eia) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.eia) || "hour".equals(AlaRankListFragment.this.eia) || "charm_day".equals(AlaRankListFragment.this.eia)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.zl().awC.aan;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.beJ();
            }
            if ("hot".equals(AlaRankListFragment.this.eia)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener eBE = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.eia)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.alH, hourRankItemData.type, AlaRankListFragment.this.eBw ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.eBv;
        alaRankListFragment.eBv = i - 1;
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
        this.eia = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.sI = arguments.getString("user_name");
        this.eib = arguments.getBoolean("is_from_host");
        this.Yx = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.alH = arguments.getString("feed_id");
        this.ehY = arguments.getLong("cur_live_id");
        this.eAn = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.eia)) {
            MessageManager.getInstance().registerListener(this.eBE);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.eia)) {
            iv(this.eBw);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eBu = new com.baidu.tieba.ala.view.d(getPageContext(), this.eia, this.Yx, this.eBD, this.eib, this.mUserId, this.sI, this.mPortrait, this.ehY);
        it(true);
        if ("hour".equals(this.eia)) {
            this.eBu.a(this);
        }
        return this.eBu.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eia)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void it(final boolean z) {
        if (this.eBt == null) {
            this.eBt = new com.baidu.tieba.ala.e.d(getUniqueId(), this.eBC);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.eia, "charm_day")) {
                    this.eBv = 2;
                    if (this.mUserId != 0) {
                        this.eBt.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.eBv--;
                        this.eBu.btF();
                    }
                    this.eBt.e(this.eia, this.mUserId, "");
                } else if (TextUtils.equals(this.eia, "hour")) {
                    if (this.mUserId == 0) {
                        this.eBu.btF();
                    }
                    if (z) {
                        this.eBx = BdUniqueId.gen();
                        this.eBt.a(this.eia, this.mUserId, "", this.eBx);
                        return;
                    }
                    this.eBy = BdUniqueId.gen();
                    if (this.eBz != null && !TextUtils.isEmpty(this.eBz.AY())) {
                        this.eBt.a(this.eia, this.mUserId, StringHelper.getHourRankPreHourString(this.eBz.AY(), -1), this.eBy);
                    }
                }
            }
        } else if (this.eBu != null) {
            this.eBu.bcy();
            this.eBu.ij(false);
            this.eBu.btF();
            this.eBu.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
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
            if (this.eBu != null) {
                this.eBu.btF();
                this.eBu.bcy();
                this.eBu.a(new ArrayList<>(), this.eBz == null ? 0L : this.eBz.beA(), this);
                this.eBu.qZ(0);
                this.eBu.ij(false);
                this.eBu.qX(8);
                this.eBu.qY(8);
                this.eBu.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.it(AlaRankListFragment.this.eBw);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.eBu.bcy();
            this.eBu.qY(0);
            this.eBu.a(new ArrayList<>(), mVar.beA(), this);
            this.eBu.qZ(0);
            this.eBu.ij(true);
            this.eBu.qX(8);
            if (this.eBu != null) {
                mVar.beC().iq(this.eBw ? false : true);
                this.eBu.c(mVar.beC());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.eBu.qY(0);
            this.eBu.bcy();
            if (this.eBu != null) {
                this.eBu.c(mVar);
                n beC = mVar.beC();
                if (mVar.getList().size() == 1) {
                    this.eBu.a(new ArrayList<>(), mVar.beA(), this);
                    this.eBu.ij(false);
                    if (beC != null) {
                        beC.ip(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.eBu.a(arrayList, mVar.beA(), this);
                    if (beC != null) {
                        beC.ip(false);
                    }
                }
                this.eBu.qZ(0);
                this.eBu.qX(0);
                if (this.eBu != null) {
                    mVar.beC().iq(this.eBw ? false : true);
                    this.eBu.c(beC);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.eAt >= 2 && gVar.eAt < arrayList.size() + 2) {
                gVar.cH(JavaTypesHelper.toLong(arrayList.get(gVar.eAt - 2).point, 0L));
            }
            if (gVar.eAt < arrayList.size() && gVar.eAt >= 0) {
                gVar.cI(JavaTypesHelper.toLong(arrayList.get(gVar.eAt).point, 0L));
            }
            gVar.cJ(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void beJ() {
        if (!this.eib && "hour".equals(this.eia)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.alH, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eBt != null) {
            this.eBt.destory();
        }
        if (this.eBu != null) {
            this.eBu.release();
        }
        if ("hour".equals(this.eia)) {
            MessageManager.getInstance().unRegisterListener(this.eBE);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.eia)) {
            eBB.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void beK() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void iu(boolean z) {
        if (isAdded()) {
            this.eBw = z;
            if (z) {
                a(this.eBz);
            } else {
                a(this.eBA);
            }
            iv(z);
        }
    }

    private void iv(boolean z) {
        if ("hour".equals(this.eia)) {
            String str = z ? "hour" : "last_hour";
            if (!eBB.contains(str)) {
                eBB.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.alH, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.eBu != null) {
            this.eBu.sm();
        }
    }
}
