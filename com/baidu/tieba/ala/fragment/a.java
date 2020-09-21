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
    private static Set<String> gah = new HashSet();
    private String Nj;
    private int aFQ;
    private String aVs;
    private BaseActivity byl;
    private String fYm;
    private String fZY;
    private f fZZ;
    private long fyR;
    private String fyT;
    private boolean fyU;
    private g gaa;
    private int gab;
    private BdUniqueId gad;
    private BdUniqueId gae;
    private n gaf;
    private n gag;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gac = true;
    private com.baidu.tieba.ala.g.n gai = new com.baidu.tieba.ala.g.n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fyT)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gaa != null) {
                            a.this.gaa.kY(false);
                            if (a.this.gab == 0) {
                                a.this.gaa.ccM();
                            }
                            a.this.gaa.bHn();
                            a.this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.ll(a.this.gac);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gab == 0) {
                        a.this.gaa.bHn();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fAI == null || alaGetRankListResponseMessage.fAI.size() <= 0) {
                            if (a.this.gaa != null) {
                                a.this.gaa.ccM();
                                return;
                            }
                            return;
                        } else if (a.this.gaa != null) {
                            a.this.gaa.a(alaGetRankListResponseMessage.fAI, alaGetRankListResponseMessage.gRu, a.this);
                            if (a.this.gaa.ccL() != null && (a.this.gaa.ccL() instanceof h)) {
                                a.this.gaa.c(a.this.a((h) a.this.gaa.ccL(), alaGetRankListResponseMessage.fAI));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gRw == null) {
                        if (a.this.gaa != null) {
                            a.this.gaa.ccM();
                        }
                    } else if (a.this.gaa != null) {
                        a.this.gaa.c(a.this.a(alaGetUserRankInfoResponseMessage.gRw, a.this.gaa.byG()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fyT)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bZv = alaGetHourRankListResponseMessage.bZv();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gad != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gad.getId()) || (a.this.gae != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gae.getId())) {
                            if (!((a.this.gad != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gad.getId()) == a.this.gac) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gad.getId()) {
                                    a.this.gaf = bZv;
                                    if (a.this.gac) {
                                        a.this.gaa.bHn();
                                        a.this.a(a.this.gaf);
                                    }
                                    a.this.ll(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gae.getId()) {
                                    a.this.gag = bZv;
                                    if (!a.this.gac) {
                                        a.this.gaa.bHn();
                                        a.this.a(a.this.gag);
                                    }
                                }
                            } else if (a.this.gaa != null) {
                                a.this.gaa.kY(false);
                                a.this.gaa.ccM();
                                a.this.gaa.bHn();
                                a.this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.ll(a.this.gac);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gaj = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.byl);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fyT) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fyT)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.x.a.NN().bhy.aHV;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bKP();
            } else if ("hour".equals(a.this.fyT) || "charm_day".equals(a.this.fyT)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bKP();
            }
            if ("hot".equals(a.this.fyT)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.byl.setResult(-1, intent);
            a.this.byl.finish();
        }
    };
    CustomMessageListener gak = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fyT)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aVs, hourRankItemData.type, a.this.gac ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gab;
        aVar.gab = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.byl = baseActivity;
        this.fyT = str;
        this.mUserId = j;
        this.Nj = str2;
        this.fyU = z;
        this.aFQ = i;
        this.mPortrait = str3;
        this.aVs = str5;
        this.fyR = j2;
        this.fYm = str6;
        this.otherParams = str4;
        this.fZY = str7;
        if ("hour".equals(this.fyT)) {
            MessageManager.getInstance().registerListener(this.gak);
        }
        bKO();
    }

    public View bKO() {
        this.gaa = new g(this.byl.getPageContext(), this.fyT, this.aFQ, this.gaj, this.fyU, this.mUserId, this.Nj, this.mPortrait, this.fyR);
        ll(true);
        if ("hour".equals(this.fyT)) {
            this.gaa.a(this);
        }
        return this.gaa.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ll(final boolean z) {
        if (this.fZZ == null) {
            this.fZZ = new f(this.byl.getUniqueId(), this.gai);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fyT, "charm_day")) {
                    this.gab = 2;
                    if (this.mUserId != 0) {
                        this.fZZ.x(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gab--;
                        this.gaa.ccM();
                    }
                    this.fZZ.e(this.fyT, this.mUserId, "");
                } else if (TextUtils.equals(this.fyT, "hour")) {
                    if (this.mUserId == 0) {
                        this.gaa.ccM();
                    }
                    if (z) {
                        this.gad = BdUniqueId.gen();
                        this.fZZ.a(this.fyT, this.mUserId, "", this.gad);
                        return;
                    }
                    this.gae = BdUniqueId.gen();
                    if (this.gaf != null && !TextUtils.isEmpty(this.gaf.PK())) {
                        this.fZZ.a(this.fyT, this.mUserId, StringHelper.getHourRankPreHourString(this.gaf.PK(), -1), this.gae);
                    }
                }
            }
        } else if (this.gaa != null) {
            this.gaa.bHn();
            this.gaa.kY(false);
            this.gaa.ccM();
            this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.ll(z);
                    } else {
                        a.this.byl.getPageContext().showToast(a.this.byl.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar == null) {
            if (this.gaa != null) {
                this.gaa.ccM();
                this.gaa.bHn();
                this.gaa.a(new ArrayList<>(), this.gaf == null ? 0L : this.gaf.bKm(), this);
                this.gaa.vx(0);
                this.gaa.kY(false);
                this.gaa.vv(8);
                this.gaa.vw(8);
                this.gaa.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ll(a.this.gac);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.gaa.bHn();
            this.gaa.vw(0);
            this.gaa.a(new ArrayList<>(), nVar.bKm(), this);
            this.gaa.vx(0);
            this.gaa.kY(true);
            this.gaa.vv(8);
            if (this.gaa != null) {
                nVar.bKo().lg(this.gac ? false : true);
                this.gaa.c(nVar.bKo());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.gaa.vw(0);
            this.gaa.bHn();
            if (this.gaa != null) {
                this.gaa.c(nVar);
                p bKo = nVar.bKo();
                if (nVar.getList().size() == 1) {
                    this.gaa.a(new ArrayList<>(), nVar.bKm(), this);
                    this.gaa.kY(false);
                    if (bKo != null) {
                        bKo.lf(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.gaa.a(arrayList, nVar.bKm(), this);
                    if (bKo != null) {
                        bKo.lf(false);
                    }
                }
                this.gaa.vx(0);
                this.gaa.vv(0);
                if (this.gaa != null) {
                    nVar.bKo().lg(this.gac ? false : true);
                    this.gaa.c(bKo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aDW >= 2 && hVar.aDW < arrayList.size() + 2) {
                hVar.dV(JavaTypesHelper.toLong(arrayList.get(hVar.aDW - 2).point, 0L));
            }
            if (hVar.aDW < arrayList.size() && hVar.aDW >= 0) {
                hVar.dW(JavaTypesHelper.toLong(arrayList.get(hVar.aDW).point, 0L));
            }
            hVar.dX(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bKP() {
        if (!this.fyU && "hour".equals(this.fyT)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aVs, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bKQ() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void lm(boolean z) {
        this.gac = z;
        if (z) {
            a(this.gaf);
        } else {
            a(this.gag);
        }
        ln(z);
    }

    private void ln(boolean z) {
        if ("hour".equals(this.fyT)) {
            String str = z ? "hour" : "last_hour";
            if (!gah.contains(str)) {
                gah.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aVs, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gaa.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fZY;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Jq() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Jr() {
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
        if (this.fZZ != null) {
            this.fZZ.destory();
        }
        if (this.gaa != null) {
            this.gaa.release();
        }
        if ("hour".equals(this.fyT)) {
            MessageManager.getInstance().unRegisterListener(this.gak);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
