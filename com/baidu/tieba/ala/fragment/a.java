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
/* loaded from: classes7.dex */
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fWQ = new HashSet();
    private String MY;
    private int aED;
    private String aTc;
    private BaseActivity buT;
    private String fUU;
    private String fWH;
    private e fWI;
    private f fWJ;
    private int fWK;
    private BdUniqueId fWM;
    private BdUniqueId fWN;
    private n fWO;
    private n fWP;
    private long fvC;
    private String fvE;
    private boolean fvF;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fWL = true;
    private k fWR = new k() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fvE)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.fWJ != null) {
                            a.this.fWJ.kU(false);
                            if (a.this.fWK == 0) {
                                a.this.fWJ.cap();
                            }
                            a.this.fWJ.bFW();
                            a.this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.lh(a.this.fWL);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.fWK == 0) {
                        a.this.fWJ.bFW();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fxs == null || alaGetRankListResponseMessage.fxs.size() <= 0) {
                            if (a.this.fWJ != null) {
                                a.this.fWJ.cap();
                                return;
                            }
                            return;
                        } else if (a.this.fWJ != null) {
                            a.this.fWJ.a(alaGetRankListResponseMessage.fxs, alaGetRankListResponseMessage.gOa, a.this);
                            if (a.this.fWJ.cao() != null && (a.this.fWJ.cao() instanceof h)) {
                                a.this.fWJ.c(a.this.a((h) a.this.fWJ.cao(), alaGetRankListResponseMessage.fxs));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gOc == null) {
                        if (a.this.fWJ != null) {
                            a.this.fWJ.cap();
                        }
                    } else if (a.this.fWJ != null) {
                        a.this.fWJ.c(a.this.a(alaGetUserRankInfoResponseMessage.gOc, a.this.fWJ.bxw()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fvE)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bXN = alaGetHourRankListResponseMessage.bXN();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.fWM != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWM.getId()) || (a.this.fWN != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWN.getId())) {
                            if (!((a.this.fWM != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWM.getId()) == a.this.fWL) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWM.getId()) {
                                    a.this.fWO = bXN;
                                    if (a.this.fWL) {
                                        a.this.fWJ.bFW();
                                        a.this.a(a.this.fWO);
                                    }
                                    a.this.lh(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWN.getId()) {
                                    a.this.fWP = bXN;
                                    if (!a.this.fWL) {
                                        a.this.fWJ.bFW();
                                        a.this.a(a.this.fWP);
                                    }
                                }
                            } else if (a.this.fWJ != null) {
                                a.this.fWJ.kU(false);
                                a.this.fWJ.cap();
                                a.this.fWJ.bFW();
                                a.this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.lh(a.this.fWL);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private f.a fWS = new f.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.f.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.buT);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fvE) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fvE)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.w.a.Nk().beH.aGE;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bJE();
            } else if ("hour".equals(a.this.fvE) || "charm_day".equals(a.this.fvE)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bJE();
            }
            if ("hot".equals(a.this.fvE)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.buT.setResult(-1, intent);
            a.this.buT.finish();
        }
    };
    CustomMessageListener fWT = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fvE)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aTc, hourRankItemData.type, a.this.fWL ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fWK;
        aVar.fWK = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.buT = baseActivity;
        this.fvE = str;
        this.mUserId = j;
        this.MY = str2;
        this.fvF = z;
        this.aED = i;
        this.mPortrait = str3;
        this.aTc = str5;
        this.fvC = j2;
        this.fUU = str6;
        this.otherParams = str4;
        this.fWH = str7;
        if ("hour".equals(this.fvE)) {
            MessageManager.getInstance().registerListener(this.fWT);
        }
        bJD();
    }

    public View bJD() {
        this.fWJ = new f(this.buT.getPageContext(), this.fvE, this.aED, this.fWS, this.fvF, this.mUserId, this.MY, this.mPortrait, this.fvC);
        lh(true);
        if ("hour".equals(this.fvE)) {
            this.fWJ.a(this);
        }
        return this.fWJ.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh(final boolean z) {
        if (this.fWI == null) {
            this.fWI = new e(this.buT.getUniqueId(), this.fWR);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fvE, "charm_day")) {
                    this.fWK = 2;
                    if (this.mUserId != 0) {
                        this.fWI.x(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fWK--;
                        this.fWJ.cap();
                    }
                    this.fWI.e(this.fvE, this.mUserId, "");
                } else if (TextUtils.equals(this.fvE, "hour")) {
                    if (this.mUserId == 0) {
                        this.fWJ.cap();
                    }
                    if (z) {
                        this.fWM = BdUniqueId.gen();
                        this.fWI.a(this.fvE, this.mUserId, "", this.fWM);
                        return;
                    }
                    this.fWN = BdUniqueId.gen();
                    if (this.fWO != null && !TextUtils.isEmpty(this.fWO.Ph())) {
                        this.fWI.a(this.fvE, this.mUserId, StringHelper.getHourRankPreHourString(this.fWO.Ph(), -1), this.fWN);
                    }
                }
            }
        } else if (this.fWJ != null) {
            this.fWJ.bFW();
            this.fWJ.kU(false);
            this.fWJ.cap();
            this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.lh(z);
                    } else {
                        a.this.buT.getPageContext().showToast(a.this.buT.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar == null) {
            if (this.fWJ != null) {
                this.fWJ.cap();
                this.fWJ.bFW();
                this.fWJ.a(new ArrayList<>(), this.fWO == null ? 0L : this.fWO.bJc(), this);
                this.fWJ.ve(0);
                this.fWJ.kU(false);
                this.fWJ.vc(8);
                this.fWJ.vd(8);
                this.fWJ.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.lh(a.this.fWL);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.fWJ.bFW();
            this.fWJ.vd(0);
            this.fWJ.a(new ArrayList<>(), nVar.bJc(), this);
            this.fWJ.ve(0);
            this.fWJ.kU(true);
            this.fWJ.vc(8);
            if (this.fWJ != null) {
                nVar.bJe().lc(this.fWL ? false : true);
                this.fWJ.c(nVar.bJe());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.fWJ.vd(0);
            this.fWJ.bFW();
            if (this.fWJ != null) {
                this.fWJ.c(nVar);
                o bJe = nVar.bJe();
                if (nVar.getList().size() == 1) {
                    this.fWJ.a(new ArrayList<>(), nVar.bJc(), this);
                    this.fWJ.kU(false);
                    if (bJe != null) {
                        bJe.lb(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.fWJ.a(arrayList, nVar.bJc(), this);
                    if (bJe != null) {
                        bJe.lb(false);
                    }
                }
                this.fWJ.ve(0);
                this.fWJ.vc(0);
                if (this.fWJ != null) {
                    nVar.bJe().lc(this.fWL ? false : true);
                    this.fWJ.c(bJe);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.fVa >= 2 && hVar.fVa < arrayList.size() + 2) {
                hVar.dT(JavaTypesHelper.toLong(arrayList.get(hVar.fVa - 2).point, 0L));
            }
            if (hVar.fVa < arrayList.size() && hVar.fVa >= 0) {
                hVar.dU(JavaTypesHelper.toLong(arrayList.get(hVar.fVa).point, 0L));
            }
            hVar.dV(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bJE() {
        if (!this.fvF && "hour".equals(this.fvE)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aTc, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bJF() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void li(boolean z) {
        this.fWL = z;
        if (z) {
            a(this.fWO);
        } else {
            a(this.fWP);
        }
        lj(z);
    }

    private void lj(boolean z) {
        if ("hour".equals(this.fvE)) {
            String str = z ? "hour" : "last_hour";
            if (!fWQ.contains(str)) {
                fWQ.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aTc, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.fWJ.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fWH;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        if (this.fWI != null) {
            this.fWI.destory();
        }
        if (this.fWJ != null) {
            this.fWJ.release();
        }
        if ("hour".equals(this.fvE)) {
            MessageManager.getInstance().unRegisterListener(this.fWT);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
