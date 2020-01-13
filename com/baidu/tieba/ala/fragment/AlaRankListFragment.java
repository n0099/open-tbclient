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
import com.baidu.live.r.a;
import com.baidu.live.s.a;
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
/* loaded from: classes2.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> exd = new HashSet();
    private int WL;
    private String ajy;
    private long edH;
    private String edJ;
    private boolean edK;
    private String evO;
    private d ewV;
    private com.baidu.tieba.ala.view.d ewW;
    private int ewX;
    private BdUniqueId ewZ;
    private BdUniqueId exa;
    private m exb;
    private m exc;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String sG;
    private boolean ewY = true;
    private j exe = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.ewW != null) {
                            AlaRankListFragment.this.ewW.ic(false);
                            if (AlaRankListFragment.this.ewX == 0) {
                                AlaRankListFragment.this.ewW.brY();
                            }
                            AlaRankListFragment.this.ewW.baf();
                            AlaRankListFragment.this.ewW.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.im(AlaRankListFragment.this.ewY);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.ewX == 0) {
                        AlaRankListFragment.this.ewW.baf();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.efx == null || alaGetRankListResponseMessage.efx.size() <= 0) {
                            if (AlaRankListFragment.this.ewW != null) {
                                AlaRankListFragment.this.ewW.brY();
                                return;
                            }
                            return;
                        }
                        if (AlaRankListFragment.this.ewW != null) {
                            AlaRankListFragment.this.ewW.a(alaGetRankListResponseMessage.efx, alaGetRankListResponseMessage.fmy, AlaRankListFragment.this);
                        }
                        if (AlaRankListFragment.this.ewW.brX() != null && (AlaRankListFragment.this.ewW.brX() instanceof g)) {
                            AlaRankListFragment.this.ewW.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.ewW.brX(), alaGetRankListResponseMessage.efx));
                        }
                    } else if (obj instanceof AlaGetUserRankInfoResponseMessage) {
                        AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                        if (alaGetUserRankInfoResponseMessage.fmA == null) {
                            if (AlaRankListFragment.this.ewW != null) {
                                AlaRankListFragment.this.ewW.brY();
                            }
                        } else if (alaGetUserRankInfoResponseMessage.fmA != null && AlaRankListFragment.this.ewW != null) {
                            AlaRankListFragment.this.ewW.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fmA, AlaRankListFragment.this.ewW.aRz()));
                        }
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bpT = alaGetHourRankListResponseMessage.bpT();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.ewZ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.ewZ.getId()) || (AlaRankListFragment.this.exa != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.exa.getId())) {
                            if (!((AlaRankListFragment.this.ewZ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.ewZ.getId()) == AlaRankListFragment.this.ewY) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.ewZ.getId()) {
                                    AlaRankListFragment.this.exb = bpT;
                                    if (AlaRankListFragment.this.ewY) {
                                        AlaRankListFragment.this.ewW.baf();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.exb);
                                    }
                                    AlaRankListFragment.this.im(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.exa.getId()) {
                                    AlaRankListFragment.this.exc = bpT;
                                    if (!AlaRankListFragment.this.ewY) {
                                        AlaRankListFragment.this.ewW.baf();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.exc);
                                    }
                                }
                            } else if (AlaRankListFragment.this.ewW != null) {
                                AlaRankListFragment.this.ewW.ic(false);
                                AlaRankListFragment.this.ewW.brY();
                                AlaRankListFragment.this.ewW.baf();
                                AlaRankListFragment.this.ewW.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.im(AlaRankListFragment.this.ewY);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a exf = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.edJ) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.edJ) || "hour".equals(AlaRankListFragment.this.edJ) || "charm_day".equals(AlaRankListFragment.this.edJ)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.wR().asq.Yv;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bct();
            }
            if ("hot".equals(AlaRankListFragment.this.edJ)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener exg = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.edJ)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.ajy, hourRankItemData.type, AlaRankListFragment.this.ewY ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.ewX;
        alaRankListFragment.ewX = i - 1;
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
        this.edJ = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.sG = arguments.getString("user_name");
        this.edK = arguments.getBoolean("is_from_host");
        this.WL = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.ajy = arguments.getString("feed_id");
        this.edH = arguments.getLong("cur_live_id");
        this.evO = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.edJ)) {
            MessageManager.getInstance().registerListener(this.exg);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.edJ)) {
            io(this.ewY);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ewW = new com.baidu.tieba.ala.view.d(getPageContext(), this.edJ, this.WL, this.exf, this.edK, this.mUserId, this.sG, this.mPortrait, this.edH);
        im(true);
        if ("hour".equals(this.edJ)) {
            this.ewW.a(this);
        }
        return this.ewW.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edJ)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(final boolean z) {
        if (this.ewV == null) {
            this.ewV = new com.baidu.tieba.ala.e.d(getUniqueId(), this.exe);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.edJ, "charm_day")) {
                    this.ewX = 2;
                    if (this.mUserId != 0) {
                        this.ewV.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.ewX--;
                        this.ewW.brY();
                    }
                    this.ewV.e(this.edJ, this.mUserId, "");
                } else if (TextUtils.equals(this.edJ, "hour")) {
                    if (this.mUserId == 0) {
                        this.ewW.brY();
                    }
                    if (z) {
                        this.ewZ = BdUniqueId.gen();
                        this.ewV.a(this.edJ, this.mUserId, "", this.ewZ);
                        return;
                    }
                    this.exa = BdUniqueId.gen();
                    if (this.exb != null && !TextUtils.isEmpty(this.exb.yF())) {
                        this.ewV.a(this.edJ, this.mUserId, StringHelper.getHourRankPreHourString(this.exb.yF(), -1), this.exa);
                    }
                }
            }
        } else if (this.ewW != null) {
            this.ewW.baf();
            this.ewW.ic(false);
            this.ewW.brY();
            this.ewW.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.im(z);
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
            if (this.ewW != null) {
                this.ewW.brY();
                this.ewW.baf();
                this.ewW.a(new ArrayList<>(), this.exb == null ? 0L : this.exb.bci(), this);
                this.ewW.qS(0);
                this.ewW.ic(false);
                this.ewW.qQ(8);
                this.ewW.qR(8);
                this.ewW.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.im(AlaRankListFragment.this.ewY);
                    }
                });
            }
        } else if (mVar != null && (mVar.getList() == null || mVar.getList().size() <= 0)) {
            this.ewW.baf();
            this.ewW.qR(0);
            if (mVar != null) {
                this.ewW.a(new ArrayList<>(), mVar.bci(), this);
                this.ewW.qS(0);
                this.ewW.ic(true);
                this.ewW.qQ(8);
            }
            if (this.ewW != null) {
                mVar.bck().ij(this.ewY ? false : true);
                this.ewW.c(mVar.bck());
            }
        } else if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0) {
            this.ewW.qR(0);
            this.ewW.baf();
            if (this.ewW != null) {
                this.ewW.c(mVar);
                n bck = mVar.bck();
                if (mVar.getList().size() == 1) {
                    this.ewW.a(new ArrayList<>(), mVar.bci(), this);
                    this.ewW.ic(false);
                    if (bck != null) {
                        bck.ii(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.ewW.a(arrayList, mVar.bci(), this);
                    if (bck != null) {
                        bck.ii(false);
                    }
                }
                this.ewW.qS(0);
                this.ewW.qQ(0);
                if (this.ewW != null) {
                    mVar.bck().ij(this.ewY ? false : true);
                    this.ewW.c(bck);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.evU >= 2 && gVar.evU < arrayList.size() + 2) {
                gVar.cE(JavaTypesHelper.toLong(arrayList.get(gVar.evU - 2).point, 0L));
            }
            if (gVar.evU < arrayList.size() && gVar.evU >= 0) {
                gVar.cF(JavaTypesHelper.toLong(arrayList.get(gVar.evU).point, 0L));
            }
            gVar.cG(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void bct() {
        if (!this.edK && "hour".equals(this.edJ)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.ajy, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ewV != null) {
            this.ewV.destory();
        }
        if (this.ewW != null) {
            this.ewW.release();
        }
        if ("hour".equals(this.edJ)) {
            MessageManager.getInstance().unRegisterListener(this.exg);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.edJ)) {
            exd.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bcu() {
        if (isAdded()) {
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void in(boolean z) {
        if (isAdded()) {
            this.ewY = z;
            if (z) {
                a(this.exb);
            } else {
                a(this.exc);
            }
            io(z);
        }
    }

    private void io(boolean z) {
        if ("hour".equals(this.edJ)) {
            String str = z ? "hour" : "last_hour";
            if (!exd.contains(str)) {
                exd.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.ajy, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ewW != null) {
            this.ewW.rl();
        }
    }
}
