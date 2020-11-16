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
    private static Set<String> gBZ = new HashSet();
    private String NA;
    private int aIL;
    private String aZH;
    private BaseActivity bLI;
    private long fYO;
    private String fYQ;
    private boolean fYR;
    private String gAg;
    private String gBQ;
    private f gBR;
    private g gBS;
    private int gBT;
    private BdUniqueId gBV;
    private BdUniqueId gBW;
    private p gBX;
    private p gBY;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gBU = true;
    private n gCa = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fYQ)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gBS != null) {
                            a.this.gBS.ds(false);
                            if (a.this.gBT == 0) {
                                a.this.gBS.cld();
                            }
                            a.this.gBS.VB();
                            a.this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.mj(a.this.gBU);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gBT == 0) {
                        a.this.gBS.VB();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.gaE == null || alaGetRankListResponseMessage.gaE.size() <= 0) {
                            if (a.this.gBS != null) {
                                a.this.gBS.cld();
                                return;
                            }
                            return;
                        } else if (a.this.gBS != null) {
                            a.this.gBS.a(alaGetRankListResponseMessage.gaE, alaGetRankListResponseMessage.hxU, a.this);
                            if (a.this.gBS.clc() != null && (a.this.gBS.clc() instanceof h)) {
                                a.this.gBS.c(a.this.a((h) a.this.gBS.clc(), alaGetRankListResponseMessage.gaE));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hxW == null) {
                        if (a.this.gBS != null) {
                            a.this.gBS.cld();
                        }
                    } else if (a.this.gBS != null) {
                        a.this.gBS.c(a.this.a(alaGetUserRankInfoResponseMessage.hxW, a.this.gBS.bFb()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fYQ)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p chT = alaGetHourRankListResponseMessage.chT();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gBV != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gBV.getId()) || (a.this.gBW != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gBW.getId())) {
                            if (!((a.this.gBV != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gBV.getId()) == a.this.gBU) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gBV.getId()) {
                                    a.this.gBX = chT;
                                    if (a.this.gBU) {
                                        a.this.gBS.VB();
                                        a.this.a(a.this.gBX);
                                    }
                                    a.this.mj(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gBW.getId()) {
                                    a.this.gBY = chT;
                                    if (!a.this.gBU) {
                                        a.this.gBS.VB();
                                        a.this.a(a.this.gBY);
                                    }
                                }
                            } else if (a.this.gBS != null) {
                                a.this.gBS.ds(false);
                                a.this.gBS.cld();
                                a.this.gBS.VB();
                                a.this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.mj(a.this.gBU);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gCb = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bLI);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fYQ) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fYQ)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.aa.a.Ph().bms.aKS;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bRX();
            } else if ("hour".equals(a.this.fYQ) || "charm_day".equals(a.this.fYQ)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bRX();
            }
            if ("hot".equals(a.this.fYQ)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bLI.setResult(-1, intent);
            a.this.bLI.finish();
        }
    };
    CustomMessageListener gCc = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fYQ)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aZH, hourRankItemData.type, a.this.gBU ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gBT;
        aVar.gBT = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bLI = baseActivity;
        this.fYQ = str;
        this.mUserId = j;
        this.NA = str2;
        this.fYR = z;
        this.aIL = i;
        this.mPortrait = str3;
        this.aZH = str5;
        this.fYO = j2;
        this.gAg = str6;
        this.otherParams = str4;
        this.gBQ = str7;
        if ("hour".equals(this.fYQ)) {
            MessageManager.getInstance().registerListener(this.gCc);
        }
        bRW();
    }

    public View bRW() {
        this.gBS = new g(this.bLI.getPageContext(), this.fYQ, this.aIL, this.gCb, this.fYR, this.mUserId, this.NA, this.mPortrait, this.fYO);
        mj(true);
        if ("hour".equals(this.fYQ)) {
            this.gBS.a(this);
        }
        return this.gBS.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(final boolean z) {
        if (this.gBR == null) {
            this.gBR = new f(this.bLI.getUniqueId(), this.gCa);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fYQ, "charm_day")) {
                    this.gBT = 2;
                    if (this.mUserId != 0) {
                        this.gBR.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gBT--;
                        this.gBS.cld();
                    }
                    this.gBR.e(this.fYQ, this.mUserId, "");
                } else if (TextUtils.equals(this.fYQ, "hour")) {
                    if (this.mUserId == 0) {
                        this.gBS.cld();
                    }
                    if (z) {
                        this.gBV = BdUniqueId.gen();
                        this.gBR.a(this.fYQ, this.mUserId, "", this.gBV);
                        return;
                    }
                    this.gBW = BdUniqueId.gen();
                    if (this.gBX != null && !TextUtils.isEmpty(this.gBX.TU())) {
                        this.gBR.a(this.fYQ, this.mUserId, StringHelper.getHourRankPreHourString(this.gBX.TU(), -1), this.gBW);
                    }
                }
            }
        } else if (this.gBS != null) {
            this.gBS.VB();
            this.gBS.ds(false);
            this.gBS.cld();
            this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.mj(z);
                    } else {
                        a.this.bLI.getPageContext().showToast(a.this.bLI.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gBS != null) {
                this.gBS.cld();
                this.gBS.VB();
                this.gBS.a(new ArrayList<>(), this.gBX == null ? 0L : this.gBX.bRu(), this);
                this.gBS.xh(0);
                this.gBS.ds(false);
                this.gBS.xg(8);
                this.gBS.gx(8);
                this.gBS.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mj(a.this.gBU);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gBS.VB();
            this.gBS.gx(0);
            this.gBS.a(new ArrayList<>(), pVar.bRu(), this);
            this.gBS.xh(0);
            this.gBS.ds(true);
            this.gBS.xg(8);
            if (this.gBS != null) {
                pVar.bRw().me(this.gBU ? false : true);
                this.gBS.c(pVar.bRw());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gBS.gx(0);
            this.gBS.VB();
            if (this.gBS != null) {
                this.gBS.c(pVar);
                r bRw = pVar.bRw();
                if (pVar.getList().size() == 1) {
                    this.gBS.a(new ArrayList<>(), pVar.bRu(), this);
                    this.gBS.ds(false);
                    if (bRw != null) {
                        bRw.bq(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gBS.a(arrayList, pVar.bRu(), this);
                    if (bRw != null) {
                        bRw.bq(false);
                    }
                }
                this.gBS.xh(0);
                this.gBS.xg(0);
                if (this.gBS != null) {
                    pVar.bRw().me(this.gBU ? false : true);
                    this.gBS.c(bRw);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aGr >= 2 && hVar.aGr < arrayList.size() + 2) {
                hVar.eC(JavaTypesHelper.toLong(arrayList.get(hVar.aGr - 2).point, 0L));
            }
            if (hVar.aGr < arrayList.size() && hVar.aGr >= 0) {
                hVar.eD(JavaTypesHelper.toLong(arrayList.get(hVar.aGr).point, 0L));
            }
            hVar.an(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bRX() {
        if (!this.fYR && "hour".equals(this.fYQ)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aZH, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bRY() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mk(boolean z) {
        this.gBU = z;
        if (z) {
            a(this.gBX);
        } else {
            a(this.gBY);
        }
        ml(z);
    }

    private void ml(boolean z) {
        if ("hour".equals(this.fYQ)) {
            String str = z ? "hour" : "last_hour";
            if (!gBZ.contains(str)) {
                gBZ.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aZH, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gBS.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gBQ;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.gBR != null) {
            this.gBR.destory();
        }
        if (this.gBS != null) {
            this.gBS.release();
        }
        if ("hour".equals(this.fYQ)) {
            MessageManager.getInstance().unRegisterListener(this.gCc);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
