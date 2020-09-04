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
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.f.e;
import com.baidu.tieba.ala.f.k;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fWU = new HashSet();
    private String MY;
    private int aEF;
    private String aTe;
    private String fUY;
    private e fWM;
    private f fWN;
    private int fWO;
    private BdUniqueId fWQ;
    private BdUniqueId fWR;
    private n fWS;
    private n fWT;
    private long fvG;
    private String fvI;
    private boolean fvJ;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fWP = true;
    private k fWV = new k() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.fWN != null) {
                            AlaRankListFragment.this.fWN.kW(false);
                            if (AlaRankListFragment.this.fWO == 0) {
                                AlaRankListFragment.this.fWN.caq();
                            }
                            AlaRankListFragment.this.fWN.bFX();
                            AlaRankListFragment.this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.lj(AlaRankListFragment.this.fWP);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.fWO == 0) {
                        AlaRankListFragment.this.fWN.bFX();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fxw == null || alaGetRankListResponseMessage.fxw.size() <= 0) {
                            if (AlaRankListFragment.this.fWN != null) {
                                AlaRankListFragment.this.fWN.caq();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.fWN != null) {
                            AlaRankListFragment.this.fWN.a(alaGetRankListResponseMessage.fxw, alaGetRankListResponseMessage.gOe, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.fWN.cap() != null && (AlaRankListFragment.this.fWN.cap() instanceof h)) {
                                AlaRankListFragment.this.fWN.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.fWN.cap(), alaGetRankListResponseMessage.fxw));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gOg == null) {
                        if (AlaRankListFragment.this.fWN != null) {
                            AlaRankListFragment.this.fWN.caq();
                        }
                    } else if (AlaRankListFragment.this.fWN != null) {
                        AlaRankListFragment.this.fWN.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.gOg, AlaRankListFragment.this.fWN.bxx()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bXO = alaGetHourRankListResponseMessage.bXO();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.fWQ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWQ.getId()) || (AlaRankListFragment.this.fWR != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWR.getId())) {
                            if (!((AlaRankListFragment.this.fWQ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWQ.getId()) == AlaRankListFragment.this.fWP) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWQ.getId()) {
                                    AlaRankListFragment.this.fWS = bXO;
                                    if (AlaRankListFragment.this.fWP) {
                                        AlaRankListFragment.this.fWN.bFX();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fWS);
                                    }
                                    AlaRankListFragment.this.lj(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fWR.getId()) {
                                    AlaRankListFragment.this.fWT = bXO;
                                    if (!AlaRankListFragment.this.fWP) {
                                        AlaRankListFragment.this.fWN.bFX();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fWT);
                                    }
                                }
                            } else if (AlaRankListFragment.this.fWN != null) {
                                AlaRankListFragment.this.fWN.kW(false);
                                AlaRankListFragment.this.fWN.caq();
                                AlaRankListFragment.this.fWN.bFX();
                                AlaRankListFragment.this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.lj(AlaRankListFragment.this.fWP);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private f.a fWW = new f.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.f.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fvI) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fvI)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.w.a.Nk().beJ.aGG;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bJF();
            } else if ("hour".equals(AlaRankListFragment.this.fvI) || "charm_day".equals(AlaRankListFragment.this.fvI)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bJF();
            }
            if ("hot".equals(AlaRankListFragment.this.fvI)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener fWX = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fvI)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aTe, hourRankItemData.type, AlaRankListFragment.this.fWP ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.fWO;
        alaRankListFragment.fWO = i - 1;
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
        this.fvI = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.MY = arguments.getString("user_name");
        this.fvJ = arguments.getBoolean("is_from_host");
        this.aEF = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aTe = arguments.getString("feed_id");
        this.fvG = arguments.getLong("cur_live_id");
        this.fUY = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fvI)) {
            MessageManager.getInstance().registerListener(this.fWX);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fvI)) {
            ll(this.fWP);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fWN = new f(getPageContext(), this.fvI, this.aEF, this.fWW, this.fvJ, this.mUserId, this.MY, this.mPortrait, this.fvG);
        lj(true);
        if ("hour".equals(this.fvI)) {
            this.fWN.a(this);
        }
        return this.fWN.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fvI)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(final boolean z) {
        if (this.fWM == null) {
            this.fWM = new e(getUniqueId(), this.fWV);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fvI, "charm_day")) {
                    this.fWO = 2;
                    if (this.mUserId != 0) {
                        this.fWM.x(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fWO--;
                        this.fWN.caq();
                    }
                    this.fWM.e(this.fvI, this.mUserId, "");
                } else if (TextUtils.equals(this.fvI, "hour")) {
                    if (this.mUserId == 0) {
                        this.fWN.caq();
                    }
                    if (z) {
                        this.fWQ = BdUniqueId.gen();
                        this.fWM.a(this.fvI, this.mUserId, "", this.fWQ);
                        return;
                    }
                    this.fWR = BdUniqueId.gen();
                    if (this.fWS != null && !TextUtils.isEmpty(this.fWS.Ph())) {
                        this.fWM.a(this.fvI, this.mUserId, StringHelper.getHourRankPreHourString(this.fWS.Ph(), -1), this.fWR);
                    }
                }
            }
        } else if (this.fWN != null) {
            this.fWN.bFX();
            this.fWN.kW(false);
            this.fWN.caq();
            this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.lj(z);
                    } else {
                        AlaRankListFragment.this.getPageContext().showToast(AlaRankListFragment.this.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar == null) {
            if (this.fWN != null) {
                this.fWN.caq();
                this.fWN.bFX();
                this.fWN.a(new ArrayList<>(), this.fWS == null ? 0L : this.fWS.bJd(), this);
                this.fWN.ve(0);
                this.fWN.kW(false);
                this.fWN.vc(8);
                this.fWN.vd(8);
                this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.lj(AlaRankListFragment.this.fWP);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.fWN.bFX();
            this.fWN.vd(0);
            this.fWN.a(new ArrayList<>(), nVar.bJd(), this);
            this.fWN.ve(0);
            this.fWN.kW(true);
            this.fWN.vc(8);
            if (this.fWN != null) {
                nVar.bJf().le(this.fWP ? false : true);
                this.fWN.c(nVar.bJf());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.fWN.vd(0);
            this.fWN.bFX();
            if (this.fWN != null) {
                this.fWN.c(nVar);
                o bJf = nVar.bJf();
                if (nVar.getList().size() == 1) {
                    this.fWN.a(new ArrayList<>(), nVar.bJd(), this);
                    this.fWN.kW(false);
                    if (bJf != null) {
                        bJf.ld(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.fWN.a(arrayList, nVar.bJd(), this);
                    if (bJf != null) {
                        bJf.ld(false);
                    }
                }
                this.fWN.ve(0);
                this.fWN.vc(0);
                if (this.fWN != null) {
                    nVar.bJf().le(this.fWP ? false : true);
                    this.fWN.c(bJf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.fVe >= 2 && hVar.fVe < arrayList.size() + 2) {
                hVar.dT(JavaTypesHelper.toLong(arrayList.get(hVar.fVe - 2).point, 0L));
            }
            if (hVar.fVe < arrayList.size() && hVar.fVe >= 0) {
                hVar.dU(JavaTypesHelper.toLong(arrayList.get(hVar.fVe).point, 0L));
            }
            hVar.dV(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bJF() {
        if (!this.fvJ && "hour".equals(this.fvI)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aTe, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fWM != null) {
            this.fWM.destory();
        }
        if (this.fWN != null) {
            this.fWN.release();
        }
        if ("hour".equals(this.fvI)) {
            MessageManager.getInstance().unRegisterListener(this.fWX);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fvI)) {
            fWU.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bJG() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void lk(boolean z) {
        if (isAdded()) {
            this.fWP = z;
            if (z) {
                a(this.fWS);
            } else {
                a(this.fWT);
            }
            ll(z);
        }
    }

    private void ll(boolean z) {
        if ("hour".equals(this.fvI)) {
            String str = z ? "hour" : "last_hour";
            if (!fWU.contains(str)) {
                fWU.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aTe, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fWN != null) {
            this.fWN.EF();
        }
    }
}
