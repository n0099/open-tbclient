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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes10.dex */
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gSe = new HashSet();
    private String Or;
    private int aHv;
    private BaseActivity bRI;
    private String bac;
    private String gQm;
    private String gRV;
    private f gRW;
    private g gRX;
    private int gRY;
    private BdUniqueId gSa;
    private BdUniqueId gSb;
    private p gSc;
    private p gSd;
    private long gmS;
    private String gmU;
    private boolean gmV;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gRZ = true;
    private n gSf = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.gmU)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gRX != null) {
                            a.this.gRX.dI(false);
                            if (a.this.gRY == 0) {
                                a.this.gRX.cov();
                            }
                            a.this.gRX.Vq();
                            a.this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.na(a.this.gRZ);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gRY == 0) {
                        a.this.gRX.Vq();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.goH == null || alaGetRankListResponseMessage.goH.size() <= 0) {
                            if (a.this.gRX != null) {
                                a.this.gRX.cov();
                                return;
                            }
                            return;
                        } else if (a.this.gRX != null) {
                            a.this.gRX.a(alaGetRankListResponseMessage.goH, alaGetRankListResponseMessage.hOV, a.this);
                            if (a.this.gRX.cou() != null && (a.this.gRX.cou() instanceof h)) {
                                a.this.gRX.c(a.this.a((h) a.this.gRX.cou(), alaGetRankListResponseMessage.goH));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hOX == null) {
                        if (a.this.gRX != null) {
                            a.this.gRX.cov();
                        }
                    } else if (a.this.gRX != null) {
                        a.this.gRX.c(a.this.a(alaGetUserRankInfoResponseMessage.hOX, a.this.gRX.bHf()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.gmU)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p ckP = alaGetHourRankListResponseMessage.ckP();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gSa != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gSa.getId()) || (a.this.gSb != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gSb.getId())) {
                            if (!((a.this.gSa != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gSa.getId()) == a.this.gRZ) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gSa.getId()) {
                                    a.this.gSc = ckP;
                                    if (a.this.gRZ) {
                                        a.this.gRX.Vq();
                                        a.this.a(a.this.gSc);
                                    }
                                    a.this.na(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gSb.getId()) {
                                    a.this.gSd = ckP;
                                    if (!a.this.gRZ) {
                                        a.this.gRX.Vq();
                                        a.this.a(a.this.gSd);
                                    }
                                }
                            } else if (a.this.gRX != null) {
                                a.this.gRX.dI(false);
                                a.this.gRX.cov();
                                a.this.gRX.Vq();
                                a.this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.na(a.this.gRZ);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gSg = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bRI);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.gmU) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.gmU)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.af.a.OJ().bru.aJE;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bUw();
            } else if ("hour".equals(a.this.gmU) || "charm_day".equals(a.this.gmU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bUw();
            }
            if ("hot".equals(a.this.gmU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bRI.setResult(-1, intent);
            a.this.bRI.finish();
        }
    };
    CustomMessageListener gSh = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.gmU)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.bac, hourRankItemData.type, a.this.gRZ ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gRY;
        aVar.gRY = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bRI = baseActivity;
        this.gmU = str;
        this.mUserId = j;
        this.Or = str2;
        this.gmV = z;
        this.aHv = i;
        this.mPortrait = str3;
        this.bac = str5;
        this.gmS = j2;
        this.gQm = str6;
        this.otherParams = str4;
        this.gRV = str7;
        if ("hour".equals(this.gmU)) {
            MessageManager.getInstance().registerListener(this.gSh);
        }
        bUv();
    }

    public View bUv() {
        this.gRX = new g(this.bRI.getPageContext(), this.gmU, this.aHv, this.gSg, this.gmV, this.mUserId, this.Or, this.mPortrait, this.gmS);
        na(true);
        if ("hour".equals(this.gmU)) {
            this.gRX.a(this);
        }
        return this.gRX.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.gRW == null) {
            this.gRW = new f(this.bRI.getUniqueId(), this.gSf);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.gmU, "charm_day")) {
                    this.gRY = 2;
                    if (this.mUserId != 0) {
                        this.gRW.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gRY--;
                        this.gRX.cov();
                    }
                    this.gRW.e(this.gmU, this.mUserId, "");
                } else if (TextUtils.equals(this.gmU, "hour")) {
                    if (this.mUserId == 0) {
                        this.gRX.cov();
                    }
                    if (z) {
                        this.gSa = BdUniqueId.gen();
                        this.gRW.a(this.gmU, this.mUserId, "", this.gSa);
                        return;
                    }
                    this.gSb = BdUniqueId.gen();
                    if (this.gSc != null && !TextUtils.isEmpty(this.gSc.TG())) {
                        this.gRW.a(this.gmU, this.mUserId, StringHelper.getHourRankPreHourString(this.gSc.TG(), -1), this.gSb);
                    }
                }
            }
        } else if (this.gRX != null) {
            this.gRX.Vq();
            this.gRX.dI(false);
            this.gRX.cov();
            this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.na(z);
                    } else {
                        a.this.bRI.getPageContext().showToast(a.this.bRI.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gRX != null) {
                this.gRX.cov();
                this.gRX.Vq();
                this.gRX.a(new ArrayList<>(), this.gSc == null ? 0L : this.gSc.bTT(), this);
                this.gRX.wu(0);
                this.gRX.dI(false);
                this.gRX.wt(8);
                this.gRX.fp(8);
                this.gRX.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.na(a.this.gRZ);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gRX.Vq();
            this.gRX.fp(0);
            this.gRX.a(new ArrayList<>(), pVar.bTT(), this);
            this.gRX.wu(0);
            this.gRX.dI(true);
            this.gRX.wt(8);
            if (this.gRX != null) {
                pVar.bTV().mV(this.gRZ ? false : true);
                this.gRX.c(pVar.bTV());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gRX.fp(0);
            this.gRX.Vq();
            if (this.gRX != null) {
                this.gRX.c(pVar);
                r bTV = pVar.bTV();
                if (pVar.getList().size() == 1) {
                    this.gRX.a(new ArrayList<>(), pVar.bTT(), this);
                    this.gRX.dI(false);
                    if (bTV != null) {
                        bTV.br(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gRX.a(arrayList, pVar.bTT(), this);
                    if (bTV != null) {
                        bTV.br(false);
                    }
                }
                this.gRX.wu(0);
                this.gRX.wt(0);
                if (this.gRX != null) {
                    pVar.bTV().mV(this.gRZ ? false : true);
                    this.gRX.c(bTV);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aEL >= 2 && hVar.aEL < arrayList.size() + 2) {
                hVar.fg(JavaTypesHelper.toLong(arrayList.get(hVar.aEL - 2).gPU, 0L));
            }
            if (hVar.aEL < arrayList.size() && hVar.aEL >= 0) {
                hVar.fh(JavaTypesHelper.toLong(arrayList.get(hVar.aEL).gPU, 0L));
            }
            hVar.aK(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gPU, 0L));
        }
        return hVar;
    }

    public void bUw() {
        if (!this.gmV && "hour".equals(this.gmU)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bac, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bUx() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void nb(boolean z) {
        this.gRZ = z;
        if (z) {
            a(this.gSc);
        } else {
            a(this.gSd);
        }
        nc(z);
    }

    private void nc(boolean z) {
        if ("hour".equals(this.gmU)) {
            String str = z ? "hour" : "last_hour";
            if (!gSe.contains(str)) {
                gSe.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bac, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gRX.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gRV;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        if (this.gRW != null) {
            this.gRW.destory();
        }
        if (this.gRX != null) {
            this.gRX.release();
        }
        if ("hour".equals(this.gmU)) {
            MessageManager.getInstance().unRegisterListener(this.gSh);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
