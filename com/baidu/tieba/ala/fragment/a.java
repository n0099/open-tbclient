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
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.g.f;
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
    private static Set<String> gmz = new HashSet();
    private String Nz;
    private int aIU;
    private String aYD;
    private BaseActivity bEO;
    private long fLa;
    private String fLc;
    private boolean fLd;
    private String gkE;
    private String gmq;
    private f gmr;
    private g gms;
    private int gmt;
    private BdUniqueId gmv;
    private BdUniqueId gmw;
    private n gmx;
    private n gmy;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gmu = true;
    private com.baidu.tieba.ala.g.n gmA = new com.baidu.tieba.ala.g.n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fLc)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gms != null) {
                            a.this.gms.lw(false);
                            if (a.this.gmt == 0) {
                                a.this.gms.cgi();
                            }
                            a.this.gms.SK();
                            a.this.gms.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.lJ(a.this.gmu);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gmt == 0) {
                        a.this.gms.SK();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fMR == null || alaGetRankListResponseMessage.fMR.size() <= 0) {
                            if (a.this.gms != null) {
                                a.this.gms.cgi();
                                return;
                            }
                            return;
                        } else if (a.this.gms != null) {
                            a.this.gms.a(alaGetRankListResponseMessage.fMR, alaGetRankListResponseMessage.hgr, a.this);
                            if (a.this.gms.cgh() != null && (a.this.gms.cgh() instanceof h)) {
                                a.this.gms.c(a.this.a((h) a.this.gms.cgh(), alaGetRankListResponseMessage.fMR));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hgt == null) {
                        if (a.this.gms != null) {
                            a.this.gms.cgi();
                        }
                    } else if (a.this.gms != null) {
                        a.this.gms.c(a.this.a(alaGetUserRankInfoResponseMessage.hgt, a.this.gms.bBq()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fLc)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n ccT = alaGetHourRankListResponseMessage.ccT();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gmv != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gmv.getId()) || (a.this.gmw != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gmw.getId())) {
                            if (!((a.this.gmv != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gmv.getId()) == a.this.gmu) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gmv.getId()) {
                                    a.this.gmx = ccT;
                                    if (a.this.gmu) {
                                        a.this.gms.SK();
                                        a.this.a(a.this.gmx);
                                    }
                                    a.this.lJ(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gmw.getId()) {
                                    a.this.gmy = ccT;
                                    if (!a.this.gmu) {
                                        a.this.gms.SK();
                                        a.this.a(a.this.gmy);
                                    }
                                }
                            } else if (a.this.gms != null) {
                                a.this.gms.lw(false);
                                a.this.gms.cgi();
                                a.this.gms.SK();
                                a.this.gms.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.lJ(a.this.gmu);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gmB = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bEO);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fLc) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fLc)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.x.a.OS().blo.aKZ;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bNz();
            } else if ("hour".equals(a.this.fLc) || "charm_day".equals(a.this.fLc)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bNz();
            }
            if ("hot".equals(a.this.fLc)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bEO.setResult(-1, intent);
            a.this.bEO.finish();
        }
    };
    CustomMessageListener gmC = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fLc)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aYD, hourRankItemData.type, a.this.gmu ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gmt;
        aVar.gmt = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bEO = baseActivity;
        this.fLc = str;
        this.mUserId = j;
        this.Nz = str2;
        this.fLd = z;
        this.aIU = i;
        this.mPortrait = str3;
        this.aYD = str5;
        this.fLa = j2;
        this.gkE = str6;
        this.otherParams = str4;
        this.gmq = str7;
        if ("hour".equals(this.fLc)) {
            MessageManager.getInstance().registerListener(this.gmC);
        }
        bNy();
    }

    public View bNy() {
        this.gms = new g(this.bEO.getPageContext(), this.fLc, this.aIU, this.gmB, this.fLd, this.mUserId, this.Nz, this.mPortrait, this.fLa);
        lJ(true);
        if ("hour".equals(this.fLc)) {
            this.gms.a(this);
        }
        return this.gms.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(final boolean z) {
        if (this.gmr == null) {
            this.gmr = new f(this.bEO.getUniqueId(), this.gmA);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fLc, "charm_day")) {
                    this.gmt = 2;
                    if (this.mUserId != 0) {
                        this.gmr.x(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gmt--;
                        this.gms.cgi();
                    }
                    this.gmr.e(this.fLc, this.mUserId, "");
                } else if (TextUtils.equals(this.fLc, "hour")) {
                    if (this.mUserId == 0) {
                        this.gms.cgi();
                    }
                    if (z) {
                        this.gmv = BdUniqueId.gen();
                        this.gmr.a(this.fLc, this.mUserId, "", this.gmv);
                        return;
                    }
                    this.gmw = BdUniqueId.gen();
                    if (this.gmx != null && !TextUtils.isEmpty(this.gmx.QP())) {
                        this.gmr.a(this.fLc, this.mUserId, StringHelper.getHourRankPreHourString(this.gmx.QP(), -1), this.gmw);
                    }
                }
            }
        } else if (this.gms != null) {
            this.gms.SK();
            this.gms.lw(false);
            this.gms.cgi();
            this.gms.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.lJ(z);
                    } else {
                        a.this.bEO.getPageContext().showToast(a.this.bEO.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar == null) {
            if (this.gms != null) {
                this.gms.cgi();
                this.gms.SK();
                this.gms.a(new ArrayList<>(), this.gmx == null ? 0L : this.gmx.bMW(), this);
                this.gms.wd(0);
                this.gms.lw(false);
                this.gms.wb(8);
                this.gms.wc(8);
                this.gms.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.lJ(a.this.gmu);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.gms.SK();
            this.gms.wc(0);
            this.gms.a(new ArrayList<>(), nVar.bMW(), this);
            this.gms.wd(0);
            this.gms.lw(true);
            this.gms.wb(8);
            if (this.gms != null) {
                nVar.bMY().lE(this.gmu ? false : true);
                this.gms.c(nVar.bMY());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.gms.wc(0);
            this.gms.SK();
            if (this.gms != null) {
                this.gms.c(nVar);
                p bMY = nVar.bMY();
                if (nVar.getList().size() == 1) {
                    this.gms.a(new ArrayList<>(), nVar.bMW(), this);
                    this.gms.lw(false);
                    if (bMY != null) {
                        bMY.lD(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.gms.a(arrayList, nVar.bMW(), this);
                    if (bMY != null) {
                        bMY.lD(false);
                    }
                }
                this.gms.wd(0);
                this.gms.wb(0);
                if (this.gms != null) {
                    nVar.bMY().lE(this.gmu ? false : true);
                    this.gms.c(bMY);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aHa >= 2 && hVar.aHa < arrayList.size() + 2) {
                hVar.ee(JavaTypesHelper.toLong(arrayList.get(hVar.aHa - 2).point, 0L));
            }
            if (hVar.aHa < arrayList.size() && hVar.aHa >= 0) {
                hVar.ef(JavaTypesHelper.toLong(arrayList.get(hVar.aHa).point, 0L));
            }
            hVar.eg(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bNz() {
        if (!this.fLd && "hour".equals(this.fLc)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aYD, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bNA() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void lK(boolean z) {
        this.gmu = z;
        if (z) {
            a(this.gmx);
        } else {
            a(this.gmy);
        }
        lL(z);
    }

    private void lL(boolean z) {
        if ("hour".equals(this.fLc)) {
            String str = z ? "hour" : "last_hour";
            if (!gmz.contains(str)) {
                gmz.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aYD, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gms.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gmq;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Kx() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
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
        if (this.gmr != null) {
            this.gmr.destory();
        }
        if (this.gms != null) {
            this.gms.release();
        }
        if ("hour".equals(this.fLc)) {
            MessageManager.getInstance().unRegisterListener(this.gmC);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
