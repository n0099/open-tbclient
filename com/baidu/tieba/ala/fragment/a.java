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
    private static Set<String> gwE = new HashSet();
    private String NA;
    private int aJw;
    private BaseActivity bHN;
    private String baa;
    private long fTr;
    private String fTt;
    private boolean fTu;
    private String guL;
    private BdUniqueId gwA;
    private BdUniqueId gwB;
    private p gwC;
    private p gwD;
    private String gwv;
    private f gww;
    private g gwx;
    private int gwy;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gwz = true;
    private n gwF = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fTt)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gwx != null) {
                            a.this.gwx.dj(false);
                            if (a.this.gwy == 0) {
                                a.this.gwx.cji();
                            }
                            a.this.gwx.TK();
                            a.this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.lZ(a.this.gwz);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gwy == 0) {
                        a.this.gwx.TK();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fVg == null || alaGetRankListResponseMessage.fVg.size() <= 0) {
                            if (a.this.gwx != null) {
                                a.this.gwx.cji();
                                return;
                            }
                            return;
                        } else if (a.this.gwx != null) {
                            a.this.gwx.a(alaGetRankListResponseMessage.fVg, alaGetRankListResponseMessage.hsq, a.this);
                            if (a.this.gwx.cjh() != null && (a.this.gwx.cjh() instanceof h)) {
                                a.this.gwx.c(a.this.a((h) a.this.gwx.cjh(), alaGetRankListResponseMessage.fVg));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hss == null) {
                        if (a.this.gwx != null) {
                            a.this.gwx.cji();
                        }
                    } else if (a.this.gwx != null) {
                        a.this.gwx.c(a.this.a(alaGetUserRankInfoResponseMessage.hss, a.this.gwx.bDj()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fTt)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p cfY = alaGetHourRankListResponseMessage.cfY();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gwA != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gwA.getId()) || (a.this.gwB != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gwB.getId())) {
                            if (!((a.this.gwA != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gwA.getId()) == a.this.gwz) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gwA.getId()) {
                                    a.this.gwC = cfY;
                                    if (a.this.gwz) {
                                        a.this.gwx.TK();
                                        a.this.a(a.this.gwC);
                                    }
                                    a.this.lZ(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gwB.getId()) {
                                    a.this.gwD = cfY;
                                    if (!a.this.gwz) {
                                        a.this.gwx.TK();
                                        a.this.a(a.this.gwD);
                                    }
                                }
                            } else if (a.this.gwx != null) {
                                a.this.gwx.dj(false);
                                a.this.gwx.cji();
                                a.this.gwx.TK();
                                a.this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.lZ(a.this.gwz);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gwG = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bHN);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fTt) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fTt)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.z.a.Pq().bmJ.aLD;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bQe();
            } else if ("hour".equals(a.this.fTt) || "charm_day".equals(a.this.fTt)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bQe();
            }
            if ("hot".equals(a.this.fTt)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bHN.setResult(-1, intent);
            a.this.bHN.finish();
        }
    };
    CustomMessageListener gwH = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fTt)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.baa, hourRankItemData.type, a.this.gwz ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gwy;
        aVar.gwy = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bHN = baseActivity;
        this.fTt = str;
        this.mUserId = j;
        this.NA = str2;
        this.fTu = z;
        this.aJw = i;
        this.mPortrait = str3;
        this.baa = str5;
        this.fTr = j2;
        this.guL = str6;
        this.otherParams = str4;
        this.gwv = str7;
        if ("hour".equals(this.fTt)) {
            MessageManager.getInstance().registerListener(this.gwH);
        }
        bQd();
    }

    public View bQd() {
        this.gwx = new g(this.bHN.getPageContext(), this.fTt, this.aJw, this.gwG, this.fTu, this.mUserId, this.NA, this.mPortrait, this.fTr);
        lZ(true);
        if ("hour".equals(this.fTt)) {
            this.gwx.a(this);
        }
        return this.gwx.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(final boolean z) {
        if (this.gww == null) {
            this.gww = new f(this.bHN.getUniqueId(), this.gwF);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fTt, "charm_day")) {
                    this.gwy = 2;
                    if (this.mUserId != 0) {
                        this.gww.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gwy--;
                        this.gwx.cji();
                    }
                    this.gww.e(this.fTt, this.mUserId, "");
                } else if (TextUtils.equals(this.fTt, "hour")) {
                    if (this.mUserId == 0) {
                        this.gwx.cji();
                    }
                    if (z) {
                        this.gwA = BdUniqueId.gen();
                        this.gww.a(this.fTt, this.mUserId, "", this.gwA);
                        return;
                    }
                    this.gwB = BdUniqueId.gen();
                    if (this.gwC != null && !TextUtils.isEmpty(this.gwC.RV())) {
                        this.gww.a(this.fTt, this.mUserId, StringHelper.getHourRankPreHourString(this.gwC.RV(), -1), this.gwB);
                    }
                }
            }
        } else if (this.gwx != null) {
            this.gwx.TK();
            this.gwx.dj(false);
            this.gwx.cji();
            this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.lZ(z);
                    } else {
                        a.this.bHN.getPageContext().showToast(a.this.bHN.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gwx != null) {
                this.gwx.cji();
                this.gwx.TK();
                this.gwx.a(new ArrayList<>(), this.gwC == null ? 0L : this.gwC.bPB(), this);
                this.gwx.ww(0);
                this.gwx.dj(false);
                this.gwx.wv(8);
                this.gwx.gr(8);
                this.gwx.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.lZ(a.this.gwz);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gwx.TK();
            this.gwx.gr(0);
            this.gwx.a(new ArrayList<>(), pVar.bPB(), this);
            this.gwx.ww(0);
            this.gwx.dj(true);
            this.gwx.wv(8);
            if (this.gwx != null) {
                pVar.bPD().lU(this.gwz ? false : true);
                this.gwx.c(pVar.bPD());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gwx.gr(0);
            this.gwx.TK();
            if (this.gwx != null) {
                this.gwx.c(pVar);
                r bPD = pVar.bPD();
                if (pVar.getList().size() == 1) {
                    this.gwx.a(new ArrayList<>(), pVar.bPB(), this);
                    this.gwx.dj(false);
                    if (bPD != null) {
                        bPD.bn(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gwx.a(arrayList, pVar.bPB(), this);
                    if (bPD != null) {
                        bPD.bn(false);
                    }
                }
                this.gwx.ww(0);
                this.gwx.wv(0);
                if (this.gwx != null) {
                    pVar.bPD().lU(this.gwz ? false : true);
                    this.gwx.c(bPD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aHl >= 2 && hVar.aHl < arrayList.size() + 2) {
                hVar.eg(JavaTypesHelper.toLong(arrayList.get(hVar.aHl - 2).point, 0L));
            }
            if (hVar.aHl < arrayList.size() && hVar.aHl >= 0) {
                hVar.eh(JavaTypesHelper.toLong(arrayList.get(hVar.aHl).point, 0L));
            }
            hVar.ab(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bQe() {
        if (!this.fTu && "hour".equals(this.fTt)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.baa, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bQf() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ma(boolean z) {
        this.gwz = z;
        if (z) {
            a(this.gwC);
        } else {
            a(this.gwD);
        }
        mb(z);
    }

    private void mb(boolean z) {
        if ("hour".equals(this.fTt)) {
            String str = z ? "hour" : "last_hour";
            if (!gwE.contains(str)) {
                gwE.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.baa, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gwx.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gwv;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.gww != null) {
            this.gww.destory();
        }
        if (this.gwx != null) {
            this.gwx.release();
        }
        if ("hour".equals(this.fTt)) {
            MessageManager.getInstance().unRegisterListener(this.gwH);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
