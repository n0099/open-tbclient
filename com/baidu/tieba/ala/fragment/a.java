package com.baidu.tieba.ala.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.HourRankItemData;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
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
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fuc = new HashSet();
    private String LR;
    private String aJO;
    private int avX;
    private BaseActivity bjI;
    private long eUH;
    private String eUJ;
    private boolean eUK;
    private String fsM;
    private String ftT;
    private com.baidu.tieba.ala.f.d ftU;
    private com.baidu.tieba.ala.view.d ftV;
    private int ftW;
    private BdUniqueId ftY;
    private BdUniqueId ftZ;
    private m fua;
    private m fub;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean ftX = true;
    private j fud = new j() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.eUJ)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.ftV != null) {
                            a.this.ftV.jF(false);
                            if (a.this.ftW == 0) {
                                a.this.ftV.bJL();
                            }
                            a.this.ftV.bqO();
                            a.this.ftV.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.jP(a.this.ftX);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.ftW == 0) {
                        a.this.ftV.bqO();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.eWs == null || alaGetRankListResponseMessage.eWs.size() <= 0) {
                            if (a.this.ftV != null) {
                                a.this.ftV.bJL();
                                return;
                            }
                            return;
                        } else if (a.this.ftV != null) {
                            a.this.ftV.a(alaGetRankListResponseMessage.eWs, alaGetRankListResponseMessage.gji, a.this);
                            if (a.this.ftV.bJK() != null && (a.this.ftV.bJK() instanceof g)) {
                                a.this.ftV.c(a.this.a((g) a.this.ftV.bJK(), alaGetRankListResponseMessage.eWs));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gjk == null) {
                        if (a.this.ftV != null) {
                            a.this.ftV.bJL();
                        }
                    } else if (a.this.ftV != null) {
                        a.this.ftV.c(a.this.a(alaGetUserRankInfoResponseMessage.gjk, a.this.ftV.biq()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.eUJ)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bHA = alaGetHourRankListResponseMessage.bHA();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.ftY != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.ftY.getId()) || (a.this.ftZ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.ftZ.getId())) {
                            if (!((a.this.ftY != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.ftY.getId()) == a.this.ftX) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.ftY.getId()) {
                                    a.this.fua = bHA;
                                    if (a.this.ftX) {
                                        a.this.ftV.bqO();
                                        a.this.a(a.this.fua);
                                    }
                                    a.this.jP(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.ftZ.getId()) {
                                    a.this.fub = bHA;
                                    if (!a.this.ftX) {
                                        a.this.ftV.bqO();
                                        a.this.a(a.this.fub);
                                    }
                                }
                            } else if (a.this.ftV != null) {
                                a.this.ftV.jF(false);
                                a.this.ftV.bJL();
                                a.this.ftV.bqO();
                                a.this.ftV.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.jP(a.this.ftX);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a fue = new d.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bjI);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.eUJ) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.eUJ)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.v.a.Ge().aWF.axS;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.btV();
            } else if ("hour".equals(a.this.eUJ) || "charm_day".equals(a.this.eUJ)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.btV();
            }
            if ("hot".equals(a.this.eUJ)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bjI.setResult(-1, intent);
            a.this.bjI.finish();
        }
    };
    CustomMessageListener fuf = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.eUJ)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aJO, hourRankItemData.type, a.this.ftX ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.ftW;
        aVar.ftW = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bjI = baseActivity;
        this.eUJ = str;
        this.mUserId = j;
        this.LR = str2;
        this.eUK = z;
        this.avX = i;
        this.mPortrait = str3;
        this.aJO = str5;
        this.eUH = j2;
        this.fsM = str6;
        this.otherParams = str4;
        this.ftT = str7;
        if ("hour".equals(this.eUJ)) {
            MessageManager.getInstance().registerListener(this.fuf);
        }
        btU();
    }

    public View btU() {
        this.ftV = new com.baidu.tieba.ala.view.d(this.bjI.getPageContext(), this.eUJ, this.avX, this.fue, this.eUK, this.mUserId, this.LR, this.mPortrait, this.eUH);
        jP(true);
        if ("hour".equals(this.eUJ)) {
            this.ftV.a(this);
        }
        return this.ftV.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(final boolean z) {
        if (this.ftU == null) {
            this.ftU = new com.baidu.tieba.ala.f.d(this.bjI.getUniqueId(), this.fud);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.eUJ, "charm_day")) {
                    this.ftW = 2;
                    if (this.mUserId != 0) {
                        this.ftU.y(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.ftW--;
                        this.ftV.bJL();
                    }
                    this.ftU.e(this.eUJ, this.mUserId, "");
                } else if (TextUtils.equals(this.eUJ, "hour")) {
                    if (this.mUserId == 0) {
                        this.ftV.bJL();
                    }
                    if (z) {
                        this.ftY = BdUniqueId.gen();
                        this.ftU.a(this.eUJ, this.mUserId, "", this.ftY);
                        return;
                    }
                    this.ftZ = BdUniqueId.gen();
                    if (this.fua != null && !TextUtils.isEmpty(this.fua.HV())) {
                        this.ftU.a(this.eUJ, this.mUserId, StringHelper.getHourRankPreHourString(this.fua.HV(), -1), this.ftZ);
                    }
                }
            }
        } else if (this.ftV != null) {
            this.ftV.bqO();
            this.ftV.jF(false);
            this.ftV.bJL();
            this.ftV.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.jP(z);
                    } else {
                        a.this.bjI.getPageContext().showToast(a.this.bjI.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar == null) {
            if (this.ftV != null) {
                this.ftV.bJL();
                this.ftV.bqO();
                this.ftV.a(new ArrayList<>(), this.fua == null ? 0L : this.fua.btL(), this);
                this.ftV.rX(0);
                this.ftV.jF(false);
                this.ftV.rV(8);
                this.ftV.rW(8);
                this.ftV.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.jP(a.this.ftX);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.ftV.bqO();
            this.ftV.rW(0);
            this.ftV.a(new ArrayList<>(), mVar.btL(), this);
            this.ftV.rX(0);
            this.ftV.jF(true);
            this.ftV.rV(8);
            if (this.ftV != null) {
                mVar.btN().jM(this.ftX ? false : true);
                this.ftV.c(mVar.btN());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.ftV.rW(0);
            this.ftV.bqO();
            if (this.ftV != null) {
                this.ftV.c(mVar);
                n btN = mVar.btN();
                if (mVar.getList().size() == 1) {
                    this.ftV.a(new ArrayList<>(), mVar.btL(), this);
                    this.ftV.jF(false);
                    if (btN != null) {
                        btN.jL(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.ftV.a(arrayList, mVar.btL(), this);
                    if (btN != null) {
                        btN.jL(false);
                    }
                }
                this.ftV.rX(0);
                this.ftV.rV(0);
                if (this.ftV != null) {
                    mVar.btN().jM(this.ftX ? false : true);
                    this.ftV.c(btN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.fsS >= 2 && gVar.fsS < arrayList.size() + 2) {
                gVar.dr(JavaTypesHelper.toLong(arrayList.get(gVar.fsS - 2).point, 0L));
            }
            if (gVar.fsS < arrayList.size() && gVar.fsS >= 0) {
                gVar.ds(JavaTypesHelper.toLong(arrayList.get(gVar.fsS).point, 0L));
            }
            gVar.dt(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void btV() {
        if (!this.eUK && "hour".equals(this.eUJ)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aJO, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void btW() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void jQ(boolean z) {
        this.ftX = z;
        if (z) {
            a(this.fua);
        } else {
            a(this.fub);
        }
        jR(z);
    }

    private void jR(boolean z) {
        if ("hour".equals(this.eUJ)) {
            String str = z ? "hour" : "last_hour";
            if (!fuc.contains(str)) {
                fuc.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aJO, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.ftV.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.ftT;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.ftU != null) {
            this.ftU.destory();
        }
        if (this.ftV != null) {
            this.ftV.release();
        }
        if ("hour".equals(this.eUJ)) {
            MessageManager.getInstance().unRegisterListener(this.fuf);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
