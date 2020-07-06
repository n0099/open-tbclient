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
    private static Set<String> fFx = new HashSet();
    private String Mt;
    private String aMu;
    private int ayf;
    private String fEi;
    private d fFp;
    private com.baidu.tieba.ala.view.d fFq;
    private int fFr;
    private BdUniqueId fFt;
    private BdUniqueId fFu;
    private m fFv;
    private m fFw;
    private long ffd;
    private String fff;
    private boolean ffg;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fFs = true;
    private j fFy = new j() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if ((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        AlaRankListFragment.a(AlaRankListFragment.this);
                        if (AlaRankListFragment.this.fFq != null) {
                            AlaRankListFragment.this.fFq.jS(false);
                            if (AlaRankListFragment.this.fFr == 0) {
                                AlaRankListFragment.this.fFq.bMT();
                            }
                            AlaRankListFragment.this.fFq.btO();
                            AlaRankListFragment.this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    AlaRankListFragment.this.kd(AlaRankListFragment.this.fFs);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    AlaRankListFragment.a(AlaRankListFragment.this);
                    if (AlaRankListFragment.this.fFr == 0) {
                        AlaRankListFragment.this.fFq.btO();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fgO == null || alaGetRankListResponseMessage.fgO.size() <= 0) {
                            if (AlaRankListFragment.this.fFq != null) {
                                AlaRankListFragment.this.fFq.bMT();
                                return;
                            }
                            return;
                        } else if (AlaRankListFragment.this.fFq != null) {
                            AlaRankListFragment.this.fFq.a(alaGetRankListResponseMessage.fgO, alaGetRankListResponseMessage.gwg, AlaRankListFragment.this);
                            if (AlaRankListFragment.this.fFq.bMS() != null && (AlaRankListFragment.this.fFq.bMS() instanceof g)) {
                                AlaRankListFragment.this.fFq.c(AlaRankListFragment.this.a((g) AlaRankListFragment.this.fFq.bMS(), alaGetRankListResponseMessage.fgO));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gwi == null) {
                        if (AlaRankListFragment.this.fFq != null) {
                            AlaRankListFragment.this.fFq.bMT();
                        }
                    } else if (AlaRankListFragment.this.fFq != null) {
                        AlaRankListFragment.this.fFq.c(AlaRankListFragment.this.a(alaGetUserRankInfoResponseMessage.gwi, AlaRankListFragment.this.fFq.bkP()));
                    }
                } else if (obj instanceof AlaGetHourRankListResponseMessage) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bKH = alaGetHourRankListResponseMessage.bKH();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((AlaRankListFragment.this.fFt != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fFt.getId()) || (AlaRankListFragment.this.fFu != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fFu.getId())) {
                            if (!((AlaRankListFragment.this.fFt != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fFt.getId()) == AlaRankListFragment.this.fFs) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fFt.getId()) {
                                    AlaRankListFragment.this.fFv = bKH;
                                    if (AlaRankListFragment.this.fFs) {
                                        AlaRankListFragment.this.fFq.btO();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fFv);
                                    }
                                    AlaRankListFragment.this.kd(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == AlaRankListFragment.this.fFu.getId()) {
                                    AlaRankListFragment.this.fFw = bKH;
                                    if (!AlaRankListFragment.this.fFs) {
                                        AlaRankListFragment.this.fFq.btO();
                                        AlaRankListFragment.this.a(AlaRankListFragment.this.fFw);
                                    }
                                }
                            } else if (AlaRankListFragment.this.fFq != null) {
                                AlaRankListFragment.this.fFq.jS(false);
                                AlaRankListFragment.this.fFq.bMT();
                                AlaRankListFragment.this.fFq.btO();
                                AlaRankListFragment.this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        AlaRankListFragment.this.kd(AlaRankListFragment.this.fFs);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a fFz = new d.a() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaRankListFragment.this.getBaseFragmentActivity());
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(AlaRankListFragment.this.fff) || SdkStaticKeys.RANK_TYPE_CHARM.equals(AlaRankListFragment.this.fff)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.v.a.Hm().aZp.aAh;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                AlaRankListFragment.this.bwT();
            } else if ("hour".equals(AlaRankListFragment.this.fff) || "charm_day".equals(AlaRankListFragment.this.fff)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                AlaRankListFragment.this.bwT();
            }
            if ("hot".equals(AlaRankListFragment.this.fff)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            AlaRankListFragment.this.getActivity().setResult(-1, intent);
            AlaRankListFragment.this.getActivity().finish();
        }
    };
    CustomMessageListener fFA = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(AlaRankListFragment.this.fff)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(AlaRankListFragment.this.aMu, hourRankItemData.type, AlaRankListFragment.this.fFs ? "hour" : "last_hour", hourRankItemData.position + "", AlaRankListFragment.this.otherParams);
            }
        }
    };

    static /* synthetic */ int a(AlaRankListFragment alaRankListFragment) {
        int i = alaRankListFragment.fFr;
        alaRankListFragment.fFr = i - 1;
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
        this.fff = arguments.getString("rank_type");
        this.mUserId = arguments.getLong("user_id");
        this.Mt = arguments.getString("user_name");
        this.ffg = arguments.getBoolean("is_from_host");
        this.ayf = arguments.getInt("list_live_type");
        this.mPortrait = arguments.getString("portrait");
        this.aMu = arguments.getString("feed_id");
        this.ffd = arguments.getLong("cur_live_id");
        this.fEi = arguments.getString("cur_hour");
        this.otherParams = arguments.getString(IntentConfig.OTHER_PARAMS);
        if ("hour".equals(this.fff)) {
            MessageManager.getInstance().registerListener(this.fFA);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if ("hour".equals(this.fff)) {
            kf(this.fFs);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fFq = new com.baidu.tieba.ala.view.d(getPageContext(), this.fff, this.ayf, this.fFz, this.ffg, this.mUserId, this.Mt, this.mPortrait, this.ffd);
        kd(true);
        if ("hour".equals(this.fff)) {
            this.fFq.a(this);
        }
        return this.fFq.getView();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && SdkStaticKeys.RANK_TYPE_FLOWER.equals(this.fff)) {
            TiebaInitialize.log(new StatisticItem("12960"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(final boolean z) {
        if (this.fFp == null) {
            this.fFp = new com.baidu.tieba.ala.f.d(getUniqueId(), this.fFy);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fff, "charm_day")) {
                    this.fFr = 2;
                    if (this.mUserId != 0) {
                        this.fFp.y(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fFr--;
                        this.fFq.bMT();
                    }
                    this.fFp.f(this.fff, this.mUserId, "");
                } else if (TextUtils.equals(this.fff, "hour")) {
                    if (this.mUserId == 0) {
                        this.fFq.bMT();
                    }
                    if (z) {
                        this.fFt = BdUniqueId.gen();
                        this.fFp.a(this.fff, this.mUserId, "", this.fFt);
                        return;
                    }
                    this.fFu = BdUniqueId.gen();
                    if (this.fFv != null && !TextUtils.isEmpty(this.fFv.Ji())) {
                        this.fFp.a(this.fff, this.mUserId, StringHelper.getHourRankPreHourString(this.fFv.Ji(), -1), this.fFu);
                    }
                }
            }
        } else if (this.fFq != null) {
            this.fFq.btO();
            this.fFq.jS(false);
            this.fFq.bMT();
            this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaRankListFragment.this.kd(z);
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
            if (this.fFq != null) {
                this.fFq.bMT();
                this.fFq.btO();
                this.fFq.a(new ArrayList<>(), this.fFv == null ? 0L : this.fFv.bwJ(), this);
                this.fFq.sy(0);
                this.fFq.jS(false);
                this.fFq.sw(8);
                this.fFq.sx(8);
                this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.AlaRankListFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaRankListFragment.this.kd(AlaRankListFragment.this.fFs);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.fFq.btO();
            this.fFq.sx(0);
            this.fFq.a(new ArrayList<>(), mVar.bwJ(), this);
            this.fFq.sy(0);
            this.fFq.jS(true);
            this.fFq.sw(8);
            if (this.fFq != null) {
                mVar.bwL().ka(this.fFs ? false : true);
                this.fFq.c(mVar.bwL());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.fFq.sx(0);
            this.fFq.btO();
            if (this.fFq != null) {
                this.fFq.c(mVar);
                n bwL = mVar.bwL();
                if (mVar.getList().size() == 1) {
                    this.fFq.a(new ArrayList<>(), mVar.bwJ(), this);
                    this.fFq.jS(false);
                    if (bwL != null) {
                        bwL.jZ(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.fFq.a(arrayList, mVar.bwJ(), this);
                    if (bwL != null) {
                        bwL.jZ(false);
                    }
                }
                this.fFq.sy(0);
                this.fFq.sw(0);
                if (this.fFq != null) {
                    mVar.bwL().ka(this.fFs ? false : true);
                    this.fFq.c(bwL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.fEo >= 2 && gVar.fEo < arrayList.size() + 2) {
                gVar.du(JavaTypesHelper.toLong(arrayList.get(gVar.fEo - 2).point, 0L));
            }
            if (gVar.fEo < arrayList.size() && gVar.fEo >= 0) {
                gVar.dv(JavaTypesHelper.toLong(arrayList.get(gVar.fEo).point, 0L));
            }
            gVar.dw(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void bwT() {
        if (!this.ffg && "hour".equals(this.fff)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aMu, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fFp != null) {
            this.fFp.destory();
        }
        if (this.fFq != null) {
            this.fFq.release();
        }
        if ("hour".equals(this.fff)) {
            MessageManager.getInstance().unRegisterListener(this.fFA);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if ("hour".equals(this.fff)) {
            fFx.clear();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        super.changeSkinType(0);
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bwU() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ke(boolean z) {
        if (isAdded()) {
            this.fFs = z;
            if (z) {
                a(this.fFv);
            } else {
                a(this.fFw);
            }
            kf(z);
        }
    }

    private void kf(boolean z) {
        if ("hour".equals(this.fff)) {
            String str = z ? "hour" : "last_hour";
            if (!fFx.contains(str)) {
                fFx.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aMu, str, this.otherParams);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fFq != null) {
            this.fFq.yA();
        }
    }
}
