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
/* loaded from: classes4.dex */
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gKY = new HashSet();
    private String Ov;
    private int aLE;
    private BaseActivity bQN;
    private String bdh;
    private String gJf;
    private String gKP;
    private f gKQ;
    private g gKR;
    private int gKS;
    private BdUniqueId gKU;
    private BdUniqueId gKV;
    private p gKW;
    private p gKX;
    private long ghb;
    private String ghd;
    private boolean ghe;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gKT = true;
    private n gKZ = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.ghd)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gKR != null) {
                            a.this.gKR.dG(false);
                            if (a.this.gKS == 0) {
                                a.this.gKR.cpt();
                            }
                            a.this.gKR.Yb();
                            a.this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.mE(a.this.gKT);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gKS == 0) {
                        a.this.gKR.Yb();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.giR == null || alaGetRankListResponseMessage.giR.size() <= 0) {
                            if (a.this.gKR != null) {
                                a.this.gKR.cpt();
                                return;
                            }
                            return;
                        } else if (a.this.gKR != null) {
                            a.this.gKR.a(alaGetRankListResponseMessage.giR, alaGetRankListResponseMessage.hHB, a.this);
                            if (a.this.gKR.cps() != null && (a.this.gKR.cps() instanceof h)) {
                                a.this.gKR.c(a.this.a((h) a.this.gKR.cps(), alaGetRankListResponseMessage.giR));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hHD == null) {
                        if (a.this.gKR != null) {
                            a.this.gKR.cpt();
                        }
                    } else if (a.this.gKR != null) {
                        a.this.gKR.c(a.this.a(alaGetUserRankInfoResponseMessage.hHD, a.this.gKR.bIC()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.ghd)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p clP = alaGetHourRankListResponseMessage.clP();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gKU != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKU.getId()) || (a.this.gKV != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKV.getId())) {
                            if (!((a.this.gKU != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKU.getId()) == a.this.gKT) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKU.getId()) {
                                    a.this.gKW = clP;
                                    if (a.this.gKT) {
                                        a.this.gKR.Yb();
                                        a.this.a(a.this.gKW);
                                    }
                                    a.this.mE(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKV.getId()) {
                                    a.this.gKX = clP;
                                    if (!a.this.gKT) {
                                        a.this.gKR.Yb();
                                        a.this.a(a.this.gKX);
                                    }
                                }
                            } else if (a.this.gKR != null) {
                                a.this.gKR.dG(false);
                                a.this.gKR.cpt();
                                a.this.gKR.Yb();
                                a.this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.mE(a.this.gKT);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gLa = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bQN);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.ghd) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.ghd)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.RB().brA.aNN;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bVI();
            } else if ("hour".equals(a.this.ghd) || "charm_day".equals(a.this.ghd)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bVI();
            }
            if ("hot".equals(a.this.ghd)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bQN.setResult(-1, intent);
            a.this.bQN.finish();
        }
    };
    CustomMessageListener gLb = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.ghd)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.bdh, hourRankItemData.type, a.this.gKT ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gKS;
        aVar.gKS = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bQN = baseActivity;
        this.ghd = str;
        this.mUserId = j;
        this.Ov = str2;
        this.ghe = z;
        this.aLE = i;
        this.mPortrait = str3;
        this.bdh = str5;
        this.ghb = j2;
        this.gJf = str6;
        this.otherParams = str4;
        this.gKP = str7;
        if ("hour".equals(this.ghd)) {
            MessageManager.getInstance().registerListener(this.gLb);
        }
        bVH();
    }

    public View bVH() {
        this.gKR = new g(this.bQN.getPageContext(), this.ghd, this.aLE, this.gLa, this.ghe, this.mUserId, this.Ov, this.mPortrait, this.ghb);
        mE(true);
        if ("hour".equals(this.ghd)) {
            this.gKR.a(this);
        }
        return this.gKR.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(final boolean z) {
        if (this.gKQ == null) {
            this.gKQ = new f(this.bQN.getUniqueId(), this.gKZ);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.ghd, "charm_day")) {
                    this.gKS = 2;
                    if (this.mUserId != 0) {
                        this.gKQ.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gKS--;
                        this.gKR.cpt();
                    }
                    this.gKQ.e(this.ghd, this.mUserId, "");
                } else if (TextUtils.equals(this.ghd, "hour")) {
                    if (this.mUserId == 0) {
                        this.gKR.cpt();
                    }
                    if (z) {
                        this.gKU = BdUniqueId.gen();
                        this.gKQ.a(this.ghd, this.mUserId, "", this.gKU);
                        return;
                    }
                    this.gKV = BdUniqueId.gen();
                    if (this.gKW != null && !TextUtils.isEmpty(this.gKW.Wu())) {
                        this.gKQ.a(this.ghd, this.mUserId, StringHelper.getHourRankPreHourString(this.gKW.Wu(), -1), this.gKV);
                    }
                }
            }
        } else if (this.gKR != null) {
            this.gKR.Yb();
            this.gKR.dG(false);
            this.gKR.cpt();
            this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.mE(z);
                    } else {
                        a.this.bQN.getPageContext().showToast(a.this.bQN.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gKR != null) {
                this.gKR.cpt();
                this.gKR.Yb();
                this.gKR.a(new ArrayList<>(), this.gKW == null ? 0L : this.gKW.bVf(), this);
                this.gKR.xN(0);
                this.gKR.dG(false);
                this.gKR.xM(8);
                this.gKR.gV(8);
                this.gKR.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mE(a.this.gKT);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gKR.Yb();
            this.gKR.gV(0);
            this.gKR.a(new ArrayList<>(), pVar.bVf(), this);
            this.gKR.xN(0);
            this.gKR.dG(true);
            this.gKR.xM(8);
            if (this.gKR != null) {
                pVar.bVh().mz(this.gKT ? false : true);
                this.gKR.c(pVar.bVh());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gKR.gV(0);
            this.gKR.Yb();
            if (this.gKR != null) {
                this.gKR.c(pVar);
                r bVh = pVar.bVh();
                if (pVar.getList().size() == 1) {
                    this.gKR.a(new ArrayList<>(), pVar.bVf(), this);
                    this.gKR.dG(false);
                    if (bVh != null) {
                        bVh.by(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gKR.a(arrayList, pVar.bVf(), this);
                    if (bVh != null) {
                        bVh.by(false);
                    }
                }
                this.gKR.xN(0);
                this.gKR.xM(0);
                if (this.gKR != null) {
                    pVar.bVh().mz(this.gKT ? false : true);
                    this.gKR.c(bVh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aJa >= 2 && hVar.aJa < arrayList.size() + 2) {
                hVar.fg(JavaTypesHelper.toLong(arrayList.get(hVar.aJa - 2).gIO, 0L));
            }
            if (hVar.aJa < arrayList.size() && hVar.aJa >= 0) {
                hVar.fh(JavaTypesHelper.toLong(arrayList.get(hVar.aJa).gIO, 0L));
            }
            hVar.aL(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gIO, 0L));
        }
        return hVar;
    }

    public void bVI() {
        if (!this.ghe && "hour".equals(this.ghd)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bdh, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVJ() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mF(boolean z) {
        this.gKT = z;
        if (z) {
            a(this.gKW);
        } else {
            a(this.gKX);
        }
        mG(z);
    }

    private void mG(boolean z) {
        if ("hour".equals(this.ghd)) {
            String str = z ? "hour" : "last_hour";
            if (!gKY.contains(str)) {
                gKY.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bdh, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gKR.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gKP;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.gKQ != null) {
            this.gKQ.destory();
        }
        if (this.gKR != null) {
            this.gKR.release();
        }
        if ("hour".equals(this.ghd)) {
            MessageManager.getInstance().unRegisterListener(this.gLb);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
