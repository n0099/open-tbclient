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
    private static Set<String> eBX = new HashSet();
    private int YH;
    private String alR;
    private String eAJ;
    private d eBP;
    private com.baidu.tieba.ala.view.d eBQ;
    private int eBR;
    private BdUniqueId eBT;
    private BdUniqueId eBU;
    private m eBV;
    private m eBW;
    private long eio;
    private String eiq;
    private boolean eir;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String sI;
    private boolean eBS = true;
    private j eBY = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.eBQ != null) {
                            AlaRankListFragment.this.eBQ.il(false);
                            if (AlaRankListFragment.this.eBR == 0) {
                                AlaRankListFragment.this.eBQ.btK();
                            }
                            AlaRankListFragment.this.eBQ.bcC();
                            AlaRankListFragment.this.eBQ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.iv(AlaRankListFragment.this.eBS);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.eBR == 0) {
                        AlaRankListFragment.this.eBQ.bcC();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.eke == null || alaGetRankListResponseMessage.eke.size() <= 0) {
                            if (AlaRankListFragment.this.eBQ != null) {
                                AlaRankListFragment.this.eBQ.btK();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.eBQ != null) {
                            AlaRankListFragment.this.eBQ.a(alaGetRankListResponseMessage.eke, alaGetRankListResponseMessage.fpP, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.eBQ.btJ() != null && (AlaRankListFragment.this.eBQ.btJ() instanceof g)) {
                                AlaRankListFragment.this.eBQ.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.eBQ.btJ(), alaGetRankListResponseMessage.eke));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.fpR == null) {
                        if (AlaRankListFragment.this.eBQ != null) {
                            AlaRankListFragment.this.eBQ.btK();
                        }
                    } else if (AlaRankListFragment.this.eBQ != null) {
                        AlaRankListFragment.this.eBQ.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fpR, AlaRankListFragment.this.eBQ.aTX()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m brF = alaGetHourRankListResponseMessage.brF();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.eBT != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBT.getId()) || (AlaRankListFragment.this.eBU != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBU.getId())) {
                            if (!((AlaRankListFragment.this.eBT != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBT.getId()) == AlaRankListFragment.this.eBS) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBT.getId()) {
                                    AlaRankListFragment.this.eBV = brF;
                                    if (AlaRankListFragment.this.eBS) {
                                        AlaRankListFragment.this.eBQ.bcC();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBV);
                                    }
                                    AlaRankListFragment.this.iv(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.eBU.getId()) {
                                    AlaRankListFragment.this.eBW = brF;
                                    if (!AlaRankListFragment.this.eBS) {
                                        AlaRankListFragment.this.eBQ.bcC();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.eBW);
                                    }
                                }
                            } else if (AlaRankListFragment.this.eBQ != null) {
                                AlaRankListFragment.this.eBQ.il(false);
                                AlaRankListFragment.this.eBQ.btK();
                                AlaRankListFragment.this.eBQ.bcC();
                                AlaRankListFragment.this.eBQ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.iv(AlaRankListFragment.this.eBS);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a eBZ = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.eiq) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.eiq) || "hour".equals(AlaRankListFragment.this.eiq) || "charm_day".equals(AlaRankListFragment.this.eiq)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.zs().awM.aax;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.beO();
            }
            if ("hot".equals(AlaRankListFragment.this.eiq)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener eCa = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.eiq)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.alR, hourRankItemData.type, AlaRankListFragment.this.eBS ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.eBR;
        alaRankListFragment.eBR = i - 1;
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
        this.eiq = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.sI = arguments.getString("user_name");
        this.eir = arguments.getBoolean("is_from_host");
        this.YH = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.alR = arguments.getString("feed_id");
        this.eio = arguments.getLong("cur_live_id");
        this.eAJ = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.eiq)) {
            MessageManager.getInstance().registerListener(this.eCa);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.eiq)) {
            ix(this.eBS);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eBQ = new com.baidu.tieba.ala.view.d(getPageContext(), this.eiq, this.YH, this.eBZ, this.eir, this.mUserId, this.sI, this.mPortrait, this.eio);
        iv(true);
        if ("hour".equals(this.eiq)) {
            this.eBQ.a(this);
        }
        return this.eBQ.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.eiq)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(final boolean z) {
        if (this.eBP == null) {
            this.eBP = new com.baidu.tieba.ala.e.d(getUniqueId(), this.eBY);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.eiq, "charm_day")) {
                    this.eBR = 2;
                    if (this.mUserId != 0) {
                        this.eBP.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.eBR--;
                        this.eBQ.btK();
                    }
                    this.eBP.e(this.eiq, this.mUserId, "");
                } else if (TextUtils.equals(this.eiq, "hour")) {
                    if (this.mUserId == 0) {
                        this.eBQ.btK();
                    }
                    if (z) {
                        this.eBT = BdUniqueId.gen();
                        this.eBP.a(this.eiq, this.mUserId, "", this.eBT);
                        return;
                    }
                    this.eBU = BdUniqueId.gen();
                    if (this.eBV != null && !TextUtils.isEmpty(this.eBV.Bf())) {
                        this.eBP.a(this.eiq, this.mUserId, StringHelper.getHourRankPreHourString(this.eBV.Bf(), -1), this.eBU);
                    }
                }
            }
        } else if (this.eBQ != null) {
            this.eBQ.bcC();
            this.eBQ.il(false);
            this.eBQ.btK();
            this.eBQ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.iv(z);
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
            if (this.eBQ != null) {
                this.eBQ.btK();
                this.eBQ.bcC();
                this.eBQ.a(new ArrayList<>(), this.eBV == null ? 0L : this.eBV.beF(), this);
                this.eBQ.rb(0);
                this.eBQ.il(false);
                this.eBQ.qZ(8);
                this.eBQ.ra(8);
                this.eBQ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.iv(AlaRankListFragment.this.eBS);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.eBQ.bcC();
            this.eBQ.ra(0);
            this.eBQ.a(new ArrayList<>(), mVar.beF(), this);
            this.eBQ.rb(0);
            this.eBQ.il(true);
            this.eBQ.qZ(8);
            if (this.eBQ != null) {
                mVar.beH().is(this.eBS ? false : true);
                this.eBQ.c(mVar.beH());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.eBQ.ra(0);
            this.eBQ.bcC();
            if (this.eBQ != null) {
                this.eBQ.c(mVar);
                n beH = mVar.beH();
                if (mVar.getList().size() == 1) {
                    this.eBQ.a(new ArrayList<>(), mVar.beF(), this);
                    this.eBQ.il(false);
                    if (beH != null) {
                        beH.ir(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.eBQ.a(arrayList, mVar.beF(), this);
                    if (beH != null) {
                        beH.ir(false);
                    }
                }
                this.eBQ.rb(0);
                this.eBQ.qZ(0);
                if (this.eBQ != null) {
                    mVar.beH().is(this.eBS ? false : true);
                    this.eBQ.c(beH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.eAP >= 2 && gVar.eAP < arrayList.size() + 2) {
                gVar.cH(JavaTypesHelper.toLong(arrayList.get(gVar.eAP - 2).point, 0L));
            }
            if (gVar.eAP < arrayList.size() && gVar.eAP >= 0) {
                gVar.cI(JavaTypesHelper.toLong(arrayList.get(gVar.eAP).point, 0L));
            }
            gVar.cJ(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void beO() {
        if (!this.eir && "hour".equals(this.eiq)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.alR, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eBP != null) {
            this.eBP.destory();
        }
        if (this.eBQ != null) {
            this.eBQ.release();
        }
        if ("hour".equals(this.eiq)) {
            MessageManager.getInstance().unRegisterListener(this.eCa);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.eiq)) {
            eBX.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void beP() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void iw(boolean z) {
        if (isAdded()) {
            this.eBS = z;
            if (z) {
                a(this.eBV);
            } else {
                a(this.eBW);
            }
            ix(z);
        }
    }

    private void ix(boolean z) {
        if ("hour".equals(this.eiq)) {
            String str = z ? "hour" : "last_hour";
            if (!eBX.contains(str)) {
                eBX.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.alR, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.eBQ != null) {
            this.eBQ.sr();
        }
    }
}
