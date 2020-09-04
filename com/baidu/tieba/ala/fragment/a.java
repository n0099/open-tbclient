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
    private static Set<String> fWU = new HashSet();
    private String MY;
    private int aEF;
    private String aTe;
    private BaseActivity buW;
    private String fUY;
    private String fWL;
    private e fWM;
    private f fWN;
    private int fWO;
    private BdUniqueId fWQ;
    private BdUniqueId fWR;
    private n fWS;
    private n fWT;
    private long fvG;
    private String fvI;
    private boolean fvJ;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fWP = true;
    private k fWV = new k() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fvI)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.fWN != null) {
                            a.this.fWN.kW(false);
                            if (a.this.fWO == 0) {
                                a.this.fWN.caq();
                            }
                            a.this.fWN.bFX();
                            a.this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.lj(a.this.fWP);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.fWO == 0) {
                        a.this.fWN.bFX();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fxw == null || alaGetRankListResponseMessage.fxw.size() <= 0) {
                            if (a.this.fWN != null) {
                                a.this.fWN.caq();
                                return;
                            }
                            return;
                        } else if (a.this.fWN != null) {
                            a.this.fWN.a(alaGetRankListResponseMessage.fxw, alaGetRankListResponseMessage.gOe, a.this);
                            if (a.this.fWN.cap() != null && (a.this.fWN.cap() instanceof h)) {
                                a.this.fWN.c(a.this.a((h) a.this.fWN.cap(), alaGetRankListResponseMessage.fxw));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gOg == null) {
                        if (a.this.fWN != null) {
                            a.this.fWN.caq();
                        }
                    } else if (a.this.fWN != null) {
                        a.this.fWN.c(a.this.a(alaGetUserRankInfoResponseMessage.gOg, a.this.fWN.bxx()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fvI)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    n bXO = alaGetHourRankListResponseMessage.bXO();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.fWQ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWQ.getId()) || (a.this.fWR != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWR.getId())) {
                            if (!((a.this.fWQ != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWQ.getId()) == a.this.fWP) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWQ.getId()) {
                                    a.this.fWS = bXO;
                                    if (a.this.fWP) {
                                        a.this.fWN.bFX();
                                        a.this.a(a.this.fWS);
                                    }
                                    a.this.lj(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fWR.getId()) {
                                    a.this.fWT = bXO;
                                    if (!a.this.fWP) {
                                        a.this.fWN.bFX();
                                        a.this.a(a.this.fWT);
                                    }
                                }
                            } else if (a.this.fWN != null) {
                                a.this.fWN.kW(false);
                                a.this.fWN.caq();
                                a.this.fWN.bFX();
                                a.this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.lj(a.this.fWP);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private f.a fWW = new f.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.f.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.buW);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fvI) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fvI)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.w.a.Nk().beJ.aGG;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bJF();
            } else if ("hour".equals(a.this.fvI) || "charm_day".equals(a.this.fvI)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bJF();
            }
            if ("hot".equals(a.this.fvI)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.buW.setResult(-1, intent);
            a.this.buW.finish();
        }
    };
    CustomMessageListener fWX = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fvI)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aTe, hourRankItemData.type, a.this.fWP ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fWO;
        aVar.fWO = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.buW = baseActivity;
        this.fvI = str;
        this.mUserId = j;
        this.MY = str2;
        this.fvJ = z;
        this.aEF = i;
        this.mPortrait = str3;
        this.aTe = str5;
        this.fvG = j2;
        this.fUY = str6;
        this.otherParams = str4;
        this.fWL = str7;
        if ("hour".equals(this.fvI)) {
            MessageManager.getInstance().registerListener(this.fWX);
        }
        bJE();
    }

    public View bJE() {
        this.fWN = new f(this.buW.getPageContext(), this.fvI, this.aEF, this.fWW, this.fvJ, this.mUserId, this.MY, this.mPortrait, this.fvG);
        lj(true);
        if ("hour".equals(this.fvI)) {
            this.fWN.a(this);
        }
        return this.fWN.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(final boolean z) {
        if (this.fWM == null) {
            this.fWM = new e(this.buW.getUniqueId(), this.fWV);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fvI, "charm_day")) {
                    this.fWO = 2;
                    if (this.mUserId != 0) {
                        this.fWM.x(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fWO--;
                        this.fWN.caq();
                    }
                    this.fWM.e(this.fvI, this.mUserId, "");
                } else if (TextUtils.equals(this.fvI, "hour")) {
                    if (this.mUserId == 0) {
                        this.fWN.caq();
                    }
                    if (z) {
                        this.fWQ = BdUniqueId.gen();
                        this.fWM.a(this.fvI, this.mUserId, "", this.fWQ);
                        return;
                    }
                    this.fWR = BdUniqueId.gen();
                    if (this.fWS != null && !TextUtils.isEmpty(this.fWS.Ph())) {
                        this.fWM.a(this.fvI, this.mUserId, StringHelper.getHourRankPreHourString(this.fWS.Ph(), -1), this.fWR);
                    }
                }
            }
        } else if (this.fWN != null) {
            this.fWN.bFX();
            this.fWN.kW(false);
            this.fWN.caq();
            this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.lj(z);
                    } else {
                        a.this.buW.getPageContext().showToast(a.this.buW.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar == null) {
            if (this.fWN != null) {
                this.fWN.caq();
                this.fWN.bFX();
                this.fWN.a(new ArrayList<>(), this.fWS == null ? 0L : this.fWS.bJd(), this);
                this.fWN.ve(0);
                this.fWN.kW(false);
                this.fWN.vc(8);
                this.fWN.vd(8);
                this.fWN.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.lj(a.this.fWP);
                    }
                });
            }
        } else if (nVar.getList() == null || nVar.getList().size() <= 0) {
            this.fWN.bFX();
            this.fWN.vd(0);
            this.fWN.a(new ArrayList<>(), nVar.bJd(), this);
            this.fWN.ve(0);
            this.fWN.kW(true);
            this.fWN.vc(8);
            if (this.fWN != null) {
                nVar.bJf().le(this.fWP ? false : true);
                this.fWN.c(nVar.bJf());
            }
        } else if (nVar.getList() != null && nVar.getList().size() > 0) {
            this.fWN.vd(0);
            this.fWN.bFX();
            if (this.fWN != null) {
                this.fWN.c(nVar);
                o bJf = nVar.bJf();
                if (nVar.getList().size() == 1) {
                    this.fWN.a(new ArrayList<>(), nVar.bJd(), this);
                    this.fWN.kW(false);
                    if (bJf != null) {
                        bJf.ld(true);
                    }
                } else if (nVar.getList().size() > 1) {
                    int size = nVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(nVar.getList().get(i));
                    }
                    this.fWN.a(arrayList, nVar.bJd(), this);
                    if (bJf != null) {
                        bJf.ld(false);
                    }
                }
                this.fWN.ve(0);
                this.fWN.vc(0);
                if (this.fWN != null) {
                    nVar.bJf().le(this.fWP ? false : true);
                    this.fWN.c(bJf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.fVe >= 2 && hVar.fVe < arrayList.size() + 2) {
                hVar.dT(JavaTypesHelper.toLong(arrayList.get(hVar.fVe - 2).point, 0L));
            }
            if (hVar.fVe < arrayList.size() && hVar.fVe >= 0) {
                hVar.dU(JavaTypesHelper.toLong(arrayList.get(hVar.fVe).point, 0L));
            }
            hVar.dV(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bJF() {
        if (!this.fvJ && "hour".equals(this.fvI)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aTe, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bJG() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void lk(boolean z) {
        this.fWP = z;
        if (z) {
            a(this.fWS);
        } else {
            a(this.fWT);
        }
        ll(z);
    }

    private void ll(boolean z) {
        if ("hour".equals(this.fvI)) {
            String str = z ? "hour" : "last_hour";
            if (!fWU.contains(str)) {
                fWU.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aTe, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.fWN.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fWL;
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
        if (this.fWM != null) {
            this.fWM.destory();
        }
        if (this.fWN != null) {
            this.fWN.release();
        }
        if ("hour".equals(this.fvI)) {
            MessageManager.getInstance().unRegisterListener(this.fWX);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
