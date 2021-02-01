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
/* loaded from: classes11.dex */
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gUO = new HashSet();
    private String Op;
    private int aKa;
    private BaseActivity bVA;
    private String bdj;
    private String gSW;
    private String gUF;
    private f gUG;
    private g gUH;
    private int gUI;
    private BdUniqueId gUK;
    private BdUniqueId gUL;
    private p gUM;
    private p gUN;
    private long gpB;
    private String gpD;
    private boolean gpE;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gUJ = true;
    private n gUP = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.gpD)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gUH != null) {
                            a.this.gUH.dQ(false);
                            if (a.this.gUI == 0) {
                                a.this.gUH.cpA();
                            }
                            a.this.gUH.WZ();
                            a.this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.nf(a.this.gUJ);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gUI == 0) {
                        a.this.gUH.WZ();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.grq == null || alaGetRankListResponseMessage.grq.size() <= 0) {
                            if (a.this.gUH != null) {
                                a.this.gUH.cpA();
                                return;
                            }
                            return;
                        } else if (a.this.gUH != null) {
                            a.this.gUH.a(alaGetRankListResponseMessage.grq, alaGetRankListResponseMessage.hTr, a.this);
                            if (a.this.gUH.cpz() != null && (a.this.gUH.cpz() instanceof h)) {
                                a.this.gUH.c(a.this.a((h) a.this.gUH.cpz(), alaGetRankListResponseMessage.grq));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hTt == null) {
                        if (a.this.gUH != null) {
                            a.this.gUH.cpA();
                        }
                    } else if (a.this.gUH != null) {
                        a.this.gUH.c(a.this.a(alaGetUserRankInfoResponseMessage.hTt, a.this.gUH.bHz()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.gpD)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p clN = alaGetHourRankListResponseMessage.clN();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gUK != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gUK.getId()) || (a.this.gUL != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gUL.getId())) {
                            if (!((a.this.gUK != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gUK.getId()) == a.this.gUJ) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gUK.getId()) {
                                    a.this.gUM = clN;
                                    if (a.this.gUJ) {
                                        a.this.gUH.WZ();
                                        a.this.a(a.this.gUM);
                                    }
                                    a.this.nf(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gUL.getId()) {
                                    a.this.gUN = clN;
                                    if (!a.this.gUJ) {
                                        a.this.gUH.WZ();
                                        a.this.a(a.this.gUN);
                                    }
                                }
                            } else if (a.this.gUH != null) {
                                a.this.gUH.dQ(false);
                                a.this.gUH.cpA();
                                a.this.gUH.WZ();
                                a.this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.nf(a.this.gUJ);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gUQ = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void h(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bVA);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.gpD) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.gpD)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.Qj().buX.aMo;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bVa();
            } else if ("hour".equals(a.this.gpD) || "charm_day".equals(a.this.gpD)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bVa();
            }
            if ("hot".equals(a.this.gpD)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bVA.setResult(-1, intent);
            a.this.bVA.finish();
        }
    };
    CustomMessageListener gUR = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.gpD)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.bdj, hourRankItemData.type, a.this.gUJ ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gUI;
        aVar.gUI = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bVA = baseActivity;
        this.gpD = str;
        this.mUserId = j;
        this.Op = str2;
        this.gpE = z;
        this.aKa = i;
        this.mPortrait = str3;
        this.bdj = str5;
        this.gpB = j2;
        this.gSW = str6;
        this.otherParams = str4;
        this.gUF = str7;
        if ("hour".equals(this.gpD)) {
            MessageManager.getInstance().registerListener(this.gUR);
        }
        createView();
    }

    public final View createView() {
        this.gUH = new g(this.bVA.getPageContext(), this.gpD, this.aKa, this.gUQ, this.gpE, this.mUserId, this.Op, this.mPortrait, this.gpB);
        nf(true);
        if ("hour".equals(this.gpD)) {
            this.gUH.a(this);
        }
        return this.gUH.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.gUG == null) {
            this.gUG = new f(this.bVA.getUniqueId(), this.gUP);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.gpD, "charm_day")) {
                    this.gUI = 2;
                    if (this.mUserId != 0) {
                        this.gUG.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gUI--;
                        this.gUH.cpA();
                    }
                    this.gUG.e(this.gpD, this.mUserId, "");
                } else if (TextUtils.equals(this.gpD, "hour")) {
                    if (this.mUserId == 0) {
                        this.gUH.cpA();
                    }
                    if (z) {
                        this.gUK = BdUniqueId.gen();
                        this.gUG.a(this.gpD, this.mUserId, "", this.gUK);
                        return;
                    }
                    this.gUL = BdUniqueId.gen();
                    if (this.gUM != null && !TextUtils.isEmpty(this.gUM.Vn())) {
                        this.gUG.a(this.gpD, this.mUserId, StringHelper.getHourRankPreHourString(this.gUM.Vn(), -1), this.gUL);
                    }
                }
            }
        } else if (this.gUH != null) {
            this.gUH.WZ();
            this.gUH.dQ(false);
            this.gUH.cpA();
            this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.nf(z);
                    } else {
                        a.this.bVA.getPageContext().showToast(a.this.bVA.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gUH != null) {
                this.gUH.cpA();
                this.gUH.WZ();
                this.gUH.a(new ArrayList<>(), this.gUM == null ? 0L : this.gUM.bUy(), this);
                this.gUH.wF(0);
                this.gUH.dQ(false);
                this.gUH.wE(8);
                this.gUH.fv(8);
                this.gUH.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.nf(a.this.gUJ);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gUH.WZ();
            this.gUH.fv(0);
            this.gUH.a(new ArrayList<>(), pVar.bUy(), this);
            this.gUH.wF(0);
            this.gUH.dQ(true);
            this.gUH.wE(8);
            if (this.gUH != null) {
                pVar.bUA().na(this.gUJ ? false : true);
                this.gUH.c(pVar.bUA());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gUH.fv(0);
            this.gUH.WZ();
            if (this.gUH != null) {
                this.gUH.c(pVar);
                r bUA = pVar.bUA();
                if (pVar.getList().size() == 1) {
                    this.gUH.a(new ArrayList<>(), pVar.bUy(), this);
                    this.gUH.dQ(false);
                    if (bUA != null) {
                        bUA.bt(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gUH.a(arrayList, pVar.bUy(), this);
                    if (bUA != null) {
                        bUA.bt(false);
                    }
                }
                this.gUH.wF(0);
                this.gUH.wE(0);
                if (this.gUH != null) {
                    pVar.bUA().na(this.gUJ ? false : true);
                    this.gUH.c(bUA);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aGy >= 2 && hVar.aGy < arrayList.size() + 2) {
                hVar.fm(JavaTypesHelper.toLong(arrayList.get(hVar.aGy - 2).gSE, 0L));
            }
            if (hVar.aGy < arrayList.size() && hVar.aGy >= 0) {
                hVar.fn(JavaTypesHelper.toLong(arrayList.get(hVar.aGy).gSE, 0L));
            }
            hVar.aM(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gSE, 0L));
        }
        return hVar;
    }

    public void bVa() {
        if (!this.gpE && "hour".equals(this.gpD)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bdj, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVb() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ng(boolean z) {
        this.gUJ = z;
        if (z) {
            a(this.gUM);
        } else {
            a(this.gUN);
        }
        nh(z);
    }

    private void nh(boolean z) {
        if ("hour".equals(this.gpD)) {
            String str = z ? "hour" : "last_hour";
            if (!gUO.contains(str)) {
                gUO.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bdj, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gUH.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gUF;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.gUG != null) {
            this.gUG.destory();
        }
        if (this.gUH != null) {
            this.gUH.release();
        }
        if ("hour".equals(this.gpD)) {
            MessageManager.getInstance().unRegisterListener(this.gUR);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
