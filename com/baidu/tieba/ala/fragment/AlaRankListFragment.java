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
    private static Set<String> eBn = new HashSet();
    private int Yx;
    private String alG;
    private d eBf;
    private com.baidu.tieba.ala.view.d eBg;
    private int eBh;
    private BdUniqueId eBj;
    private BdUniqueId eBk;
    private m eBl;
    private m eBm;
    private long ehK;
    private String ehM;
    private boolean ehN;
    private String ezZ;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String sI;
    private boolean eBi = true;
    private j eBo = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.eBg != null) {
                            AlaRankListFragment.this.eBg.ij(false);
                            if (AlaRankListFragment.this.eBh == 0) {
                                AlaRankListFragment.this.eBg.btC();
                            }
                            AlaRankListFragment.this.eBg.bcv();
                            AlaRankListFragment.this.eBg.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.it(AlaRankListFragment.this.eBi);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.eBh == 0) {
                        AlaRankListFragment.this.eBg.bcv();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.ejA == null || alaGetRankListResponseMessage.ejA.size() <= 0) {
                            if (AlaRankListFragment.this.eBg != null) {
                                AlaRankListFragment.this.eBg.btC();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.eBg != null) {
                            AlaRankListFragment.this.eBg.a(alaGetRankListResponseMessage.ejA, alaGetRankListResponseMessage.fpb, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.eBg.btB() != null && (AlaRankListFragment.this.eBg.btB() instanceof g)) {
                                AlaRankListFragment.this.eBg.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.eBg.btB(), alaGetRankListResponseMessage.ejA));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.fpd == null) {
                        if (AlaRankListFragment.this.eBg != null) {
                            AlaRankListFragment.this.eBg.btC();
                        }
                    } else if (AlaRankListFragment.this.eBg != null) {
                        AlaRankListFragment.this.eBg.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fpd, AlaRankListFragment.this.eBg.aTQ()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m brx = alaGetHourRankListResponseMessage.brx();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.eBj != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBj.getId()) || (AlaRankListFragment.this.eBk != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBk.getId())) {
                            if (!((AlaRankListFragment.this.eBj != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBj.getId()) == AlaRankListFragment.this.eBi) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBj.getId()) {
                                    AlaRankListFragment.this.eBl = brx;
                                    if (AlaRankListFragment.this.eBi) {
                                        AlaRankListFragment.this.eBg.bcv();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBl);
                                    }
                                    AlaRankListFragment.this.it(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBk.getId()) {
                                    AlaRankListFragment.this.eBm = brx;
                                    if (!AlaRankListFragment.this.eBi) {
                                        AlaRankListFragment.this.eBg.bcv();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBm);
                                    }
                                }
                            } else if (AlaRankListFragment.this.eBg != null) {
                                AlaRankListFragment.this.eBg.ij(false);
                                AlaRankListFragment.this.eBg.btC();
                                AlaRankListFragment.this.eBg.bcv();
                                AlaRankListFragment.this.eBg.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.it(AlaRankListFragment.this.eBi);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a eBp = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.ehM) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.ehM) || "hour".equals(AlaRankListFragment.this.ehM) || "charm_day".equals(AlaRankListFragment.this.ehM)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.zj().awA.aan;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.beG();
            }
            if ("hot".equals(AlaRankListFragment.this.ehM)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener eBq = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.ehM)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.alG, hourRankItemData.type, AlaRankListFragment.this.eBi ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.eBh;
        alaRankListFragment.eBh = i - 1;
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
        this.ehM = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.sI = arguments.getString("user_name");
        this.ehN = arguments.getBoolean("is_from_host");
        this.Yx = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.alG = arguments.getString("feed_id");
        this.ehK = arguments.getLong("cur_live_id");
        this.ezZ = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.ehM)) {
            MessageManager.getInstance().registerListener(this.eBq);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.ehM)) {
            iv(this.eBi);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eBg = new com.baidu.tieba.ala.view.d(getPageContext(), this.ehM, this.Yx, this.eBp, this.ehN, this.mUserId, this.sI, this.mPortrait, this.ehK);
        it(true);
        if ("hour".equals(this.ehM)) {
            this.eBg.a(this);
        }
        return this.eBg.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.ehM)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void it(final boolean z) {
        if (this.eBf == null) {
            this.eBf = new com.baidu.tieba.ala.e.d(getUniqueId(), this.eBo);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.ehM, "charm_day")) {
                    this.eBh = 2;
                    if (this.mUserId != 0) {
                        this.eBf.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.eBh--;
                        this.eBg.btC();
                    }
                    this.eBf.e(this.ehM, this.mUserId, "");
                } else if (TextUtils.equals(this.ehM, "hour")) {
                    if (this.mUserId == 0) {
                        this.eBg.btC();
                    }
                    if (z) {
                        this.eBj = BdUniqueId.gen();
                        this.eBf.a(this.ehM, this.mUserId, "", this.eBj);
                        return;
                    }
                    this.eBk = BdUniqueId.gen();
                    if (this.eBl != null && !TextUtils.isEmpty(this.eBl.AW())) {
                        this.eBf.a(this.ehM, this.mUserId, StringHelper.getHourRankPreHourString(this.eBl.AW(), -1), this.eBk);
                    }
                }
            }
        } else if (this.eBg != null) {
            this.eBg.bcv();
            this.eBg.ij(false);
            this.eBg.btC();
            this.eBg.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
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
            if (this.eBg != null) {
                this.eBg.btC();
                this.eBg.bcv();
                this.eBg.a(new ArrayList<>(), this.eBl == null ? 0L : this.eBl.bex(), this);
                this.eBg.qZ(0);
                this.eBg.ij(false);
                this.eBg.qX(8);
                this.eBg.qY(8);
                this.eBg.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.it(AlaRankListFragment.this.eBi);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.eBg.bcv();
            this.eBg.qY(0);
            this.eBg.a(new ArrayList<>(), mVar.bex(), this);
            this.eBg.qZ(0);
            this.eBg.ij(true);
            this.eBg.qX(8);
            if (this.eBg != null) {
                mVar.bez().iq(this.eBi ? false : true);
                this.eBg.c(mVar.bez());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.eBg.qY(0);
            this.eBg.bcv();
            if (this.eBg != null) {
                this.eBg.c(mVar);
                n bez = mVar.bez();
                if (mVar.getList().size() == 1) {
                    this.eBg.a(new ArrayList<>(), mVar.bex(), this);
                    this.eBg.ij(false);
                    if (bez != null) {
                        bez.ip(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.eBg.a(arrayList, mVar.bex(), this);
                    if (bez != null) {
                        bez.ip(false);
                    }
                }
                this.eBg.qZ(0);
                this.eBg.qX(0);
                if (this.eBg != null) {
                    mVar.bez().iq(this.eBi ? false : true);
                    this.eBg.c(bez);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.eAf >= 2 && gVar.eAf < arrayList.size() + 2) {
                gVar.cH(JavaTypesHelper.toLong(arrayList.get(gVar.eAf - 2).point, 0L));
            }
            if (gVar.eAf < arrayList.size() && gVar.eAf >= 0) {
                gVar.cI(JavaTypesHelper.toLong(arrayList.get(gVar.eAf).point, 0L));
            }
            gVar.cJ(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void beG() {
        if (!this.ehN && "hour".equals(this.ehM)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.alG, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eBf != null) {
            this.eBf.destory();
        }
        if (this.eBg != null) {
            this.eBg.release();
        }
        if ("hour".equals(this.ehM)) {
            MessageManager.getInstance().unRegisterListener(this.eBq);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.ehM)) {
            eBn.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void beH() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void iu(boolean z) {
        if (isAdded()) {
            this.eBi = z;
            if (z) {
                a(this.eBl);
            } else {
                a(this.eBm);
            }
            iv(z);
        }
    }

    private void iv(boolean z) {
        if ("hour".equals(this.ehM)) {
            String str = z ? "hour" : "last_hour";
            if (!eBn.contains(str)) {
                eBn.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.alG, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.eBg != null) {
            this.eBg.sm();
        }
    }
}
