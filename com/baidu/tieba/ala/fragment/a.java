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
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.f.e;
import com.baidu.tieba.ala.f.k;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fKS = new HashSet();
    private String Ms;
    private String aNP;
    private int azs;
    private BaseActivity bpg;
    private String fJD;
    private String fKJ;
    private e fKK;
    private f fKL;
    private int fKM;
    private BdUniqueId fKO;
    private BdUniqueId fKP;
    private n fKQ;
    private n fKR;
    private long fkg;
    private String fki;
    private boolean fkj;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fKN = true;
    private k fKT = new k() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fki)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.fKL != null) {
                            a.this.fKL.kw(false);
                            if (a.this.fKM == 0) {
                                a.this.fKL.bQe();
                            }
                            a.this.fKL.bwX();
                            a.this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.kH(a.this.fKN);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.fKM == 0) {
                        a.this.fKL.bwX();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.flW == null || alaGetRankListResponseMessage.flW.size() <= 0) {
                            if (a.this.fKL != null) {
                                a.this.fKL.bQe();
                                return;
                            }
                            return;
                        } else if (a.this.fKL != null) {
                            a.this.fKL.a(alaGetRankListResponseMessage.flW, alaGetRankListResponseMessage.gBD, a.this);
                            if (a.this.fKL.bQd() != null && (a.this.fKL.bQd() instanceof h)) {
                                a.this.fKL.c(a.this.a((h) a.this.fKL.bQd(), alaGetRankListResponseMessage.flW));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gBF == null) {
                        if (a.this.fKL != null) {
                            a.this.fKL.bQe();
                        }
                    } else if (a.this.fKL != null) {
                        a.this.fKL.c(a.this.a(alaGetUserRankInfoResponseMessage.gBF, a.this.fKL.boJ()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fki)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bNN = alaGetHourRankListResponseMessage.bNN();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.fKO != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fKO.getId()) || (a.this.fKP != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fKP.getId())) {
                            if (!((a.this.fKO != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fKO.getId()) == a.this.fKN) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fKO.getId()) {
                                    a.this.fKQ = bNN;
                                    if (a.this.fKN) {
                                        a.this.fKL.bwX();
                                        a.this.a(a.this.fKQ);
                                    }
                                    a.this.kH(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fKP.getId()) {
                                    a.this.fKR = bNN;
                                    if (!a.this.fKN) {
                                        a.this.fKL.bwX();
                                        a.this.a(a.this.fKR);
                                    }
                                }
                            } else if (a.this.fKL != null) {
                                a.this.fKL.kw(false);
                                a.this.fKL.bQe();
                                a.this.fKL.bwX();
                                a.this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.kH(a.this.fKN);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private f.a fKU = new f.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.f.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bpg);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fki) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fki)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.v.a.Hs().aZn.aBu;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bAj();
            } else if ("hour".equals(a.this.fki) || "charm_day".equals(a.this.fki)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bAj();
            }
            if ("hot".equals(a.this.fki)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bpg.setResult(-1, intent);
            a.this.bpg.finish();
        }
    };
    CustomMessageListener fKV = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fki)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aNP, hourRankItemData.type, a.this.fKN ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fKM;
        aVar.fKM = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bpg = baseActivity;
        this.fki = str;
        this.mUserId = j;
        this.Ms = str2;
        this.fkj = z;
        this.azs = i;
        this.mPortrait = str3;
        this.aNP = str5;
        this.fkg = j2;
        this.fJD = str6;
        this.otherParams = str4;
        this.fKJ = str7;
        if ("hour".equals(this.fki)) {
            MessageManager.getInstance().registerListener(this.fKV);
        }
        bAi();
    }

    public View bAi() {
        this.fKL = new f(this.bpg.getPageContext(), this.fki, this.azs, this.fKU, this.fkj, this.mUserId, this.Ms, this.mPortrait, this.fkg);
        kH(true);
        if ("hour".equals(this.fki)) {
            this.fKL.a(this);
        }
        return this.fKL.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(final boolean z) {
        if (this.fKK == null) {
            this.fKK = new e(this.bpg.getUniqueId(), this.fKT);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fki, "charm_day")) {
                    this.fKM = 2;
                    if (this.mUserId != 0) {
                        this.fKK.w(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fKM--;
                        this.fKL.bQe();
                    }
                    this.fKK.f(this.fki, this.mUserId, "");
                } else if (TextUtils.equals(this.fki, "hour")) {
                    if (this.mUserId == 0) {
                        this.fKL.bQe();
                    }
                    if (z) {
                        this.fKO = BdUniqueId.gen();
                        this.fKK.a(this.fki, this.mUserId, "", this.fKO);
                        return;
                    }
                    this.fKP = BdUniqueId.gen();
                    if (this.fKQ != null && !TextUtils.isEmpty(this.fKQ.Jp())) {
                        this.fKK.a(this.fki, this.mUserId, StringHelper.getHourRankPreHourString(this.fKQ.Jp(), -1), this.fKP);
                    }
                }
            }
        } else if (this.fKL != null) {
            this.fKL.bwX();
            this.fKL.kw(false);
            this.fKL.bQe();
            this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.kH(z);
                    } else {
                        a.this.bpg.getPageContext().showToast(a.this.bpg.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar == null) {
            if (this.fKL != null) {
                this.fKL.bQe();
                this.fKL.bwX();
                this.fKL.a(new ArrayList<>(), this.fKQ == null ? 0L : this.fKQ.bzZ(), this);
                this.fKL.sQ(0);
                this.fKL.kw(false);
                this.fKL.sO(8);
                this.fKL.sP(8);
                this.fKL.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.kH(a.this.fKN);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.fKL.bwX();
            this.fKL.sP(0);
            this.fKL.a(new ArrayList<>(), nVar.bzZ(), this);
            this.fKL.sQ(0);
            this.fKL.kw(true);
            this.fKL.sO(8);
            if (this.fKL != null) {
                nVar.bAb().kE(this.fKN ? false : true);
                this.fKL.c(nVar.bAb());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.fKL.sP(0);
            this.fKL.bwX();
            if (this.fKL != null) {
                this.fKL.c(nVar);
                o bAb = nVar.bAb();
                if (nVar.getList().size() == 1) {
                    this.fKL.a(new ArrayList<>(), nVar.bzZ(), this);
                    this.fKL.kw(false);
                    if (bAb != null) {
                        bAb.kD(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.fKL.a(arrayList, nVar.bzZ(), this);
                    if (bAb != null) {
                        bAb.kD(false);
                    }
                }
                this.fKL.sQ(0);
                this.fKL.sO(0);
                if (this.fKL != null) {
                    nVar.bAb().kE(this.fKN ? false : true);
                    this.fKL.c(bAb);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.fJJ >= 2 && hVar.fJJ < arrayList.size() + 2) {
                hVar.dI(JavaTypesHelper.toLong(arrayList.get(hVar.fJJ - 2).point, 0L));
            }
            if (hVar.fJJ < arrayList.size() && hVar.fJJ >= 0) {
                hVar.dJ(JavaTypesHelper.toLong(arrayList.get(hVar.fJJ).point, 0L));
            }
            hVar.dK(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bAj() {
        if (!this.fkj && "hour".equals(this.fki)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aNP, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bAk() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void kI(boolean z) {
        this.fKN = z;
        if (z) {
            a(this.fKQ);
        } else {
            a(this.fKR);
        }
        kJ(z);
    }

    private void kJ(boolean z) {
        if ("hour".equals(this.fki)) {
            String str = z ? "hour" : "last_hour";
            if (!fKS.contains(str)) {
                fKS.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aNP, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.fKL.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fKJ;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Dj() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
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
        if (this.fKK != null) {
            this.fKK.destory();
        }
        if (this.fKL != null) {
            this.fKL.release();
        }
        if ("hour".equals(this.fki)) {
            MessageManager.getInstance().unRegisterListener(this.fKV);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
