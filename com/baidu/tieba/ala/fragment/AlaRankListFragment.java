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
import com.baidu.live.q.a;
import com.baidu.live.r.a;
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
    private static Set<String> evS = new HashSet();
    private int Ws;
    private String aiO;
    private String edB;
    private boolean edC;
    private long edz;
    private String euD;
    private d evK;
    private com.baidu.tieba.ala.view.d evL;
    private int evM;
    private BdUniqueId evO;
    private BdUniqueId evP;
    private m evQ;
    private m evR;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private String sF;
    private boolean evN = true;
    private j evT = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.evL != null) {
                            AlaRankListFragment.this.evL.hS(false);
                            if (AlaRankListFragment.this.evM == 0) {
                                AlaRankListFragment.this.evL.bqW();
                            }
                            AlaRankListFragment.this.evL.aZK();
                            AlaRankListFragment.this.evL.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.ic(AlaRankListFragment.this.evN);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.evM == 0) {
                        AlaRankListFragment.this.evL.aZK();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.efp == null || alaGetRankListResponseMessage.efp.size() <= 0) {
                            if (AlaRankListFragment.this.evL != null) {
                                AlaRankListFragment.this.evL.bqW();
                                return;
                            }
                            return;
                        }
                        if (AlaRankListFragment.this.evL != null) {
                            AlaRankListFragment.this.evL.a(alaGetRankListResponseMessage.efp, alaGetRankListResponseMessage.fjn, AlaRankListFragment.this);
                        }
                        if (AlaRankListFragment.this.evL.bqV() != null && (AlaRankListFragment.this.evL.bqV() instanceof g)) {
                            AlaRankListFragment.this.evL.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.evL.bqV(), alaGetRankListResponseMessage.efp));
                        }
                    } else if (obj instanceof AlaGetUserRankInfoResponseMessage) {
                        AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                        if (alaGetUserRankInfoResponseMessage.fjp == null) {
                            if (AlaRankListFragment.this.evL != null) {
                                AlaRankListFragment.this.evL.bqW();
                            }
                        } else if (alaGetUserRankInfoResponseMessage.fjp != null && AlaRankListFragment.this.evL != null) {
                            AlaRankListFragment.this.evL.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.fjp, AlaRankListFragment.this.evL.aRf()));
                        }
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m boS = alaGetHourRankListResponseMessage.boS();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.evO != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.evO.getId()) || (AlaRankListFragment.this.evP != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.evP.getId())) {
                            if (!((AlaRankListFragment.this.evO != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.evO.getId()) == AlaRankListFragment.this.evN) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.evO.getId()) {
                                    AlaRankListFragment.this.evQ = boS;
                                    if (AlaRankListFragment.this.evN) {
                                        AlaRankListFragment.this.evL.aZK();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.evQ);
                                    }
                                    AlaRankListFragment.this.ic(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.evP.getId()) {
                                    AlaRankListFragment.this.evR = boS;
                                    if (!AlaRankListFragment.this.evN) {
                                        AlaRankListFragment.this.evL.aZK();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.evR);
                                    }
                                }
                            } else if (AlaRankListFragment.this.evL != null) {
                                AlaRankListFragment.this.evL.hS(false);
                                AlaRankListFragment.this.evL.bqW();
                                AlaRankListFragment.this.evL.aZK();
                                AlaRankListFragment.this.evL.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.ic(AlaRankListFragment.this.evN);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a evU = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void f(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.edB) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.edB) || "hour".equals(AlaRankListFragment.this.edB) || "charm_day".equals(AlaRankListFragment.this.edB)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = a.wA().arE.Yj;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bbY();
            }
            if ("hot".equals(AlaRankListFragment.this.edB)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener evV = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.edB)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aiO, hourRankItemData.type, AlaRankListFragment.this.evN ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.evM;
        alaRankListFragment.evM = i - 1;
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
        this.edB = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.sF = arguments.getString("user_name");
        this.edC = arguments.getBoolean("is_from_host");
        this.Ws = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aiO = arguments.getString("feed_id");
        this.edz = arguments.getLong("cur_live_id");
        this.euD = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.edB)) {
            MessageManager.getInstance().registerListener(this.evV);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.edB)) {
            ie(this.evN);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.evL = new com.baidu.tieba.ala.view.d(getPageContext(), this.edB, this.Ws, this.evU, this.edC, this.mUserId, this.sF, this.mPortrait, this.edz);
        ic(true);
        if ("hour".equals(this.edB)) {
            this.evL.a(this);
        }
        return this.evL.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.edB)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic(final boolean z) {
        if (this.evK == null) {
            this.evK = new com.baidu.tieba.ala.e.d(getUniqueId(), this.evT);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.edB, "charm_day")) {
                    this.evM = 2;
                    if (this.mUserId != 0) {
                        this.evK.y(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.evM--;
                        this.evL.bqW();
                    }
                    this.evK.e(this.edB, this.mUserId, "");
                } else if (TextUtils.equals(this.edB, "hour")) {
                    if (this.mUserId == 0) {
                        this.evL.bqW();
                    }
                    if (z) {
                        this.evO = BdUniqueId.gen();
                        this.evK.a(this.edB, this.mUserId, "", this.evO);
                        return;
                    }
                    this.evP = BdUniqueId.gen();
                    if (this.evQ != null && !TextUtils.isEmpty(this.evQ.yp())) {
                        this.evK.a(this.edB, this.mUserId, StringHelper.getHourRankPreHourString(this.evQ.yp(), -1), this.evP);
                    }
                }
            }
        } else if (this.evL != null) {
            this.evL.aZK();
            this.evL.hS(false);
            this.evL.bqW();
            this.evL.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.ic(z);
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
            if (this.evL != null) {
                this.evL.bqW();
                this.evL.aZK();
                this.evL.a(new ArrayList<>(), this.evQ == null ? 0L : this.evQ.bbN(), this);
                this.evL.qN(0);
                this.evL.hS(false);
                this.evL.qL(8);
                this.evL.qM(8);
                this.evL.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.ic(AlaRankListFragment.this.evN);
                    }
                });
            }
        } else if (mVar != null && (mVar.getList() == null || mVar.getList().size() <= 0)) {
            this.evL.aZK();
            this.evL.qM(0);
            if (mVar != null) {
                this.evL.a(new ArrayList<>(), mVar.bbN(), this);
                this.evL.qN(0);
                this.evL.hS(true);
                this.evL.qL(8);
            }
            if (this.evL != null) {
                mVar.bbP().hZ(this.evN ? false : true);
                this.evL.c(mVar.bbP());
            }
        } else if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0) {
            this.evL.qM(0);
            this.evL.aZK();
            if (this.evL != null) {
                this.evL.c(mVar);
                n bbP = mVar.bbP();
                if (mVar.getList().size() == 1) {
                    this.evL.a(new ArrayList<>(), mVar.bbN(), this);
                    this.evL.hS(false);
                    if (bbP != null) {
                        bbP.hY(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.evL.a(arrayList, mVar.bbN(), this);
                    if (bbP != null) {
                        bbP.hY(false);
                    }
                }
                this.evL.qN(0);
                this.evL.qL(0);
                if (this.evL != null) {
                    mVar.bbP().hZ(this.evN ? false : true);
                    this.evL.c(bbP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.euJ >= 2 && gVar.euJ < arrayList.size() + 2) {
                gVar.cz(JavaTypesHelper.toLong(arrayList.get(gVar.euJ - 2).aao, 0L));
            }
            if (gVar.euJ < arrayList.size() && gVar.euJ >= 0) {
                gVar.cA(JavaTypesHelper.toLong(arrayList.get(gVar.euJ).aao, 0L));
            }
            gVar.cB(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).aao, 0L));
        }
        return gVar;
    }

    public void bbY() {
        if (!this.edC && "hour".equals(this.edB)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aiO, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.evK != null) {
            this.evK.destory();
        }
        if (this.evL != null) {
            this.evL.release();
        }
        if ("hour".equals(this.edB)) {
            MessageManager.getInstance().unRegisterListener(this.evV);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.edB)) {
            evS.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bbZ() {
        if (isAdded()) {
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void id(boolean z) {
        if (isAdded()) {
            this.evN = z;
            if (z) {
                a(this.evQ);
            } else {
                a(this.evR);
            }
            ie(z);
        }
    }

    private void ie(boolean z) {
        if ("hour".equals(this.edB)) {
            String str = z ? "hour" : "last_hour";
            if (!evS.contains(str)) {
                evS.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aiO, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.evL != null) {
            this.evL.qZ();
        }
    }
}
