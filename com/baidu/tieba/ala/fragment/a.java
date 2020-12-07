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
    private static Set<String> gKW = new HashSet();
    private String Ov;
    private int aLE;
    private BaseActivity bQN;
    private String bdh;
    private String gJd;
    private String gKN;
    private f gKO;
    private g gKP;
    private int gKQ;
    private BdUniqueId gKS;
    private BdUniqueId gKT;
    private p gKU;
    private p gKV;
    private long ggZ;
    private String ghb;
    private boolean ghc;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gKR = true;
    private n gKX = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.ghb)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gKP != null) {
                            a.this.gKP.dG(false);
                            if (a.this.gKQ == 0) {
                                a.this.gKP.cps();
                            }
                            a.this.gKP.Yb();
                            a.this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.mE(a.this.gKR);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gKQ == 0) {
                        a.this.gKP.Yb();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.giP == null || alaGetRankListResponseMessage.giP.size() <= 0) {
                            if (a.this.gKP != null) {
                                a.this.gKP.cps();
                                return;
                            }
                            return;
                        } else if (a.this.gKP != null) {
                            a.this.gKP.a(alaGetRankListResponseMessage.giP, alaGetRankListResponseMessage.hHz, a.this);
                            if (a.this.gKP.cpr() != null && (a.this.gKP.cpr() instanceof h)) {
                                a.this.gKP.c(a.this.a((h) a.this.gKP.cpr(), alaGetRankListResponseMessage.giP));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hHB == null) {
                        if (a.this.gKP != null) {
                            a.this.gKP.cps();
                        }
                    } else if (a.this.gKP != null) {
                        a.this.gKP.c(a.this.a(alaGetUserRankInfoResponseMessage.hHB, a.this.gKP.bIC()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.ghb)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p clO = alaGetHourRankListResponseMessage.clO();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gKS != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKS.getId()) || (a.this.gKT != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKT.getId())) {
                            if (!((a.this.gKS != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKS.getId()) == a.this.gKR) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKS.getId()) {
                                    a.this.gKU = clO;
                                    if (a.this.gKR) {
                                        a.this.gKP.Yb();
                                        a.this.a(a.this.gKU);
                                    }
                                    a.this.mE(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gKT.getId()) {
                                    a.this.gKV = clO;
                                    if (!a.this.gKR) {
                                        a.this.gKP.Yb();
                                        a.this.a(a.this.gKV);
                                    }
                                }
                            } else if (a.this.gKP != null) {
                                a.this.gKP.dG(false);
                                a.this.gKP.cps();
                                a.this.gKP.Yb();
                                a.this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.mE(a.this.gKR);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gKY = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bQN);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.ghb) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.ghb)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.RB().brA.aNN;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bVH();
            } else if ("hour".equals(a.this.ghb) || "charm_day".equals(a.this.ghb)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bVH();
            }
            if ("hot".equals(a.this.ghb)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bQN.setResult(-1, intent);
            a.this.bQN.finish();
        }
    };
    CustomMessageListener gKZ = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.ghb)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.bdh, hourRankItemData.type, a.this.gKR ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gKQ;
        aVar.gKQ = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bQN = baseActivity;
        this.ghb = str;
        this.mUserId = j;
        this.Ov = str2;
        this.ghc = z;
        this.aLE = i;
        this.mPortrait = str3;
        this.bdh = str5;
        this.ggZ = j2;
        this.gJd = str6;
        this.otherParams = str4;
        this.gKN = str7;
        if ("hour".equals(this.ghb)) {
            MessageManager.getInstance().registerListener(this.gKZ);
        }
        bVG();
    }

    public View bVG() {
        this.gKP = new g(this.bQN.getPageContext(), this.ghb, this.aLE, this.gKY, this.ghc, this.mUserId, this.Ov, this.mPortrait, this.ggZ);
        mE(true);
        if ("hour".equals(this.ghb)) {
            this.gKP.a(this);
        }
        return this.gKP.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(final boolean z) {
        if (this.gKO == null) {
            this.gKO = new f(this.bQN.getUniqueId(), this.gKX);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.ghb, "charm_day")) {
                    this.gKQ = 2;
                    if (this.mUserId != 0) {
                        this.gKO.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gKQ--;
                        this.gKP.cps();
                    }
                    this.gKO.e(this.ghb, this.mUserId, "");
                } else if (TextUtils.equals(this.ghb, "hour")) {
                    if (this.mUserId == 0) {
                        this.gKP.cps();
                    }
                    if (z) {
                        this.gKS = BdUniqueId.gen();
                        this.gKO.a(this.ghb, this.mUserId, "", this.gKS);
                        return;
                    }
                    this.gKT = BdUniqueId.gen();
                    if (this.gKU != null && !TextUtils.isEmpty(this.gKU.Wu())) {
                        this.gKO.a(this.ghb, this.mUserId, StringHelper.getHourRankPreHourString(this.gKU.Wu(), -1), this.gKT);
                    }
                }
            }
        } else if (this.gKP != null) {
            this.gKP.Yb();
            this.gKP.dG(false);
            this.gKP.cps();
            this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
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
            if (this.gKP != null) {
                this.gKP.cps();
                this.gKP.Yb();
                this.gKP.a(new ArrayList<>(), this.gKU == null ? 0L : this.gKU.bVe(), this);
                this.gKP.xN(0);
                this.gKP.dG(false);
                this.gKP.xM(8);
                this.gKP.gV(8);
                this.gKP.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mE(a.this.gKR);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gKP.Yb();
            this.gKP.gV(0);
            this.gKP.a(new ArrayList<>(), pVar.bVe(), this);
            this.gKP.xN(0);
            this.gKP.dG(true);
            this.gKP.xM(8);
            if (this.gKP != null) {
                pVar.bVg().mz(this.gKR ? false : true);
                this.gKP.c(pVar.bVg());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gKP.gV(0);
            this.gKP.Yb();
            if (this.gKP != null) {
                this.gKP.c(pVar);
                r bVg = pVar.bVg();
                if (pVar.getList().size() == 1) {
                    this.gKP.a(new ArrayList<>(), pVar.bVe(), this);
                    this.gKP.dG(false);
                    if (bVg != null) {
                        bVg.by(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gKP.a(arrayList, pVar.bVe(), this);
                    if (bVg != null) {
                        bVg.by(false);
                    }
                }
                this.gKP.xN(0);
                this.gKP.xM(0);
                if (this.gKP != null) {
                    pVar.bVg().mz(this.gKR ? false : true);
                    this.gKP.c(bVg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aJa >= 2 && hVar.aJa < arrayList.size() + 2) {
                hVar.fg(JavaTypesHelper.toLong(arrayList.get(hVar.aJa - 2).gIM, 0L));
            }
            if (hVar.aJa < arrayList.size() && hVar.aJa >= 0) {
                hVar.fh(JavaTypesHelper.toLong(arrayList.get(hVar.aJa).gIM, 0L));
            }
            hVar.aL(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gIM, 0L));
        }
        return hVar;
    }

    public void bVH() {
        if (!this.ghc && "hour".equals(this.ghb)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bdh, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVI() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mF(boolean z) {
        this.gKR = z;
        if (z) {
            a(this.gKU);
        } else {
            a(this.gKV);
        }
        mG(z);
    }

    private void mG(boolean z) {
        if ("hour".equals(this.ghb)) {
            String str = z ? "hour" : "last_hour";
            if (!gKW.contains(str)) {
                gKW.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bdh, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gKP.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gKN;
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
        if (this.gKO != null) {
            this.gKO.destory();
        }
        if (this.gKP != null) {
            this.gKP.release();
        }
        if ("hour".equals(this.ghb)) {
            MessageManager.getInstance().unRegisterListener(this.gKZ);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
