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
/* loaded from: classes11.dex */
public class AlaRankListFragment extends BaseFragment implements AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gVc = new HashSet();
    private String Op;
    private int aKa;
    private String bdj;
    private String gTk;
    private f gUU;
    private g gUV;
    private int gUW;
    private BdUniqueId gUY;
    private BdUniqueId gUZ;
    private p gVa;
    private p gVb;
    private long gpP;
    private String gpR;
    private boolean gpS;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gUX = true;
    private n gVd = new n() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.gUV != null) {
                            AlaRankListFragment.this.gUV.dQ(false);
                            if (AlaRankListFragment.this.gUW == 0) {
                                AlaRankListFragment.this.gUV.cpH();
                            }
                            AlaRankListFragment.this.gUV.WZ();
                            AlaRankListFragment.this.gUV.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.nf(AlaRankListFragment.this.gUX);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.gUW == 0) {
                        AlaRankListFragment.this.gUV.WZ();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.grE == null || alaGetRankListResponseMessage.grE.size() <= 0) {
                            if (AlaRankListFragment.this.gUV != null) {
                                AlaRankListFragment.this.gUV.cpH();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.gUV != null) {
                            AlaRankListFragment.this.gUV.a(alaGetRankListResponseMessage.grE, alaGetRankListResponseMessage.hTF, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.gUV.cpG() != null && (AlaRankListFragment.this.gUV.cpG() instanceof h)) {
                                AlaRankListFragment.this.gUV.c(AlaRankListFragment.this.a((h) AlaRankListFragment.this.gUV.cpG(), alaGetRankListResponseMessage.grE));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hTH == null) {
                        if (AlaRankListFragment.this.gUV != null) {
                            AlaRankListFragment.this.gUV.cpH();
                        }
                    } else if (AlaRankListFragment.this.gUV != null) {
                        AlaRankListFragment.this.gUV.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.hTH, AlaRankListFragment.this.gUV.bHz()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p clU = alaGetHourRankListResponseMessage.clU();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.gUY != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUY.getId()) || (AlaRankListFragment.this.gUZ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUZ.getId())) {
                            if (!((AlaRankListFragment.this.gUY != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUY.getId()) == AlaRankListFragment.this.gUX) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUY.getId()) {
                                    AlaRankListFragment.this.gVa = clU;
                                    if (AlaRankListFragment.this.gUX) {
                                        AlaRankListFragment.this.gUV.WZ();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gVa);
                                    }
                                    AlaRankListFragment.this.nf(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.gUZ.getId()) {
                                    AlaRankListFragment.this.gVb = clU;
                                    if (!AlaRankListFragment.this.gUX) {
                                        AlaRankListFragment.this.gUV.WZ();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.gVb);
                                    }
                                }
                            } else if (AlaRankListFragment.this.gUV != null) {
                                AlaRankListFragment.this.gUV.dQ(false);
                                AlaRankListFragment.this.gUV.cpH();
                                AlaRankListFragment.this.gUV.WZ();
                                AlaRankListFragment.this.gUV.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.nf(AlaRankListFragment.this.gUX);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gVe = new g.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void h(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.gpR) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.gpR)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.Qj().buX.aMo;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bVh();
            } else if ("hour".equals(AlaRankListFragment.this.gpR) || "charm_day".equals(AlaRankListFragment.this.gpR)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bVh();
            }
            if ("hot".equals(AlaRankListFragment.this.gpR)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener gVf = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.gpR)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.bdj, hourRankItemData.type, AlaRankListFragment.this.gUX ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.gUW;
        alaRankListFragment.gUW = i - 1;
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

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.gpR = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Op = arguments.getString("user_name");
        this.gpS = arguments.getBoolean("is_from_host");
        this.aKa = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.bdj = arguments.getString("feed_id");
        this.gpP = arguments.getLong("cur_live_id");
        this.gTk = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.gpR)) {
            MessageManager.getInstance().registerListener(this.gVf);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.gpR)) {
            nh(this.gUX);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gUV = new g(getPageContext(), this.gpR, this.aKa, this.gVe, this.gpS, this.mUserId, this.Op, this.mPortrait, this.gpP);
        nf(true);
        if ("hour".equals(this.gpR)) {
            this.gUV.a(this);
        }
        return this.gUV.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.gpR)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.gUU == null) {
            this.gUU = new f(getUniqueId(), this.gVd);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.gpR, "charm_day")) {
                    this.gUW = 2;
                    if (this.mUserId != 0) {
                        this.gUU.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gUW--;
                        this.gUV.cpH();
                    }
                    this.gUU.e(this.gpR, this.mUserId, "");
                } else if (TextUtils.equals(this.gpR, "hour")) {
                    if (this.mUserId == 0) {
                        this.gUV.cpH();
                    }
                    if (z) {
                        this.gUY = BdUniqueId.gen();
                        this.gUU.a(this.gpR, this.mUserId, "", this.gUY);
                        return;
                    }
                    this.gUZ = BdUniqueId.gen();
                    if (this.gVa != null && !TextUtils.isEmpty(this.gVa.Vn())) {
                        this.gUU.a(this.gpR, this.mUserId, StringHelper.getHourRankPreHourString(this.gVa.Vn(), -1), this.gUZ);
                    }
                }
            }
        } else if (this.gUV != null) {
            this.gUV.WZ();
            this.gUV.dQ(false);
            this.gUV.cpH();
            this.gUV.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.nf(z);
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
            if (this.gUV != null) {
                this.gUV.cpH();
                this.gUV.WZ();
                this.gUV.a(new ArrayList<>(), this.gVa == null ? 0L : this.gVa.bUF(), this);
                this.gUV.wF(0);
                this.gUV.dQ(false);
                this.gUV.wE(8);
                this.gUV.fv(8);
                this.gUV.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.nf(AlaRankListFragment.this.gUX);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gUV.WZ();
            this.gUV.fv(0);
            this.gUV.a(new ArrayList<>(), pVar.bUF(), this);
            this.gUV.wF(0);
            this.gUV.dQ(true);
            this.gUV.wE(8);
            if (this.gUV != null) {
                pVar.bUH().na(this.gUX ? false : true);
                this.gUV.c(pVar.bUH());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gUV.fv(0);
            this.gUV.WZ();
            if (this.gUV != null) {
                this.gUV.c(pVar);
                r bUH = pVar.bUH();
                if (pVar.getList().size() == 1) {
                    this.gUV.a(new ArrayList<>(), pVar.bUF(), this);
                    this.gUV.dQ(false);
                    if (bUH != null) {
                        bUH.bt(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gUV.a(arrayList, pVar.bUF(), this);
                    if (bUH != null) {
                        bUH.bt(false);
                    }
                }
                this.gUV.wF(0);
                this.gUV.wE(0);
                if (this.gUV != null) {
                    pVar.bUH().na(this.gUX ? false : true);
                    this.gUV.c(bUH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aGy >= 2 && hVar.aGy < arrayList.size() + 2) {
                hVar.fm(JavaTypesHelper.toLong(arrayList.get(hVar.aGy - 2).gSS, 0L));
            }
            if (hVar.aGy < arrayList.size() && hVar.aGy >= 0) {
                hVar.fn(JavaTypesHelper.toLong(arrayList.get(hVar.aGy).gSS, 0L));
            }
            hVar.aM(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gSS, 0L));
        }
        return hVar;
    }

    public void bVh() {
        if (!this.gpS && "hour".equals(this.gpR)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bdj, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gUU != null) {
            this.gUU.destory();
        }
        if (this.gUV != null) {
            this.gUV.release();
        }
        if ("hour".equals(this.gpR)) {
            MessageManager.getInstance().unRegisterListener(this.gVf);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.gpR)) {
            gVc.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVi() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ng(boolean z) {
        if (isAdded()) {
            this.gUX = z;
            if (z) {
                a(this.gVa);
            } else {
                a(this.gVb);
            }
            nh(z);
        }
    }

    private void nh(boolean z) {
        if ("hour".equals(this.gpR)) {
            String str = z ? "hour" : "last_hour";
            if (!gVc.contains(str)) {
                gVc.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bdj, str, this.otherParams);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gUV != null) {
            this.gUV.EK();
        }
    }
}
