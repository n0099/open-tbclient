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
    private static Set<String> gCs = new HashSet();
    private String NA;
    private int aKw;
    private BaseActivity bNs;
    private String bbt;
    private long fZh;
    private String fZj;
    private boolean fZk;
    private String gAz;
    private String gCj;
    private f gCk;
    private g gCl;
    private int gCm;
    private BdUniqueId gCo;
    private BdUniqueId gCp;
    private p gCq;
    private p gCr;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gCn = true;
    private n gCt = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fZj)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gCl != null) {
                            a.this.gCl.dq(false);
                            if (a.this.gCm == 0) {
                                a.this.gCl.clK();
                            }
                            a.this.gCl.Wk();
                            a.this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.mi(a.this.gCn);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gCm == 0) {
                        a.this.gCl.Wk();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.gaX == null || alaGetRankListResponseMessage.gaX.size() <= 0) {
                            if (a.this.gCl != null) {
                                a.this.gCl.clK();
                                return;
                            }
                            return;
                        } else if (a.this.gCl != null) {
                            a.this.gCl.a(alaGetRankListResponseMessage.gaX, alaGetRankListResponseMessage.hyn, a.this);
                            if (a.this.gCl.clJ() != null && (a.this.gCl.clJ() instanceof h)) {
                                a.this.gCl.c(a.this.a((h) a.this.gCl.clJ(), alaGetRankListResponseMessage.gaX));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hyp == null) {
                        if (a.this.gCl != null) {
                            a.this.gCl.clK();
                        }
                    } else if (a.this.gCl != null) {
                        a.this.gCl.c(a.this.a(alaGetUserRankInfoResponseMessage.hyp, a.this.gCl.bFI()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fZj)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p ciA = alaGetHourRankListResponseMessage.ciA();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gCo != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gCo.getId()) || (a.this.gCp != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gCp.getId())) {
                            if (!((a.this.gCo != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gCo.getId()) == a.this.gCn) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gCo.getId()) {
                                    a.this.gCq = ciA;
                                    if (a.this.gCn) {
                                        a.this.gCl.Wk();
                                        a.this.a(a.this.gCq);
                                    }
                                    a.this.mi(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gCp.getId()) {
                                    a.this.gCr = ciA;
                                    if (!a.this.gCn) {
                                        a.this.gCl.Wk();
                                        a.this.a(a.this.gCr);
                                    }
                                }
                            } else if (a.this.gCl != null) {
                                a.this.gCl.dq(false);
                                a.this.gCl.clK();
                                a.this.gCl.Wk();
                                a.this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.mi(a.this.gCn);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gCu = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bNs);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fZj) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fZj)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.aa.a.PQ().bod.aMD;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bSE();
            } else if ("hour".equals(a.this.fZj) || "charm_day".equals(a.this.fZj)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bSE();
            }
            if ("hot".equals(a.this.fZj)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bNs.setResult(-1, intent);
            a.this.bNs.finish();
        }
    };
    CustomMessageListener gCv = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fZj)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.bbt, hourRankItemData.type, a.this.gCn ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gCm;
        aVar.gCm = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bNs = baseActivity;
        this.fZj = str;
        this.mUserId = j;
        this.NA = str2;
        this.fZk = z;
        this.aKw = i;
        this.mPortrait = str3;
        this.bbt = str5;
        this.fZh = j2;
        this.gAz = str6;
        this.otherParams = str4;
        this.gCj = str7;
        if ("hour".equals(this.fZj)) {
            MessageManager.getInstance().registerListener(this.gCv);
        }
        bSD();
    }

    public View bSD() {
        this.gCl = new g(this.bNs.getPageContext(), this.fZj, this.aKw, this.gCu, this.fZk, this.mUserId, this.NA, this.mPortrait, this.fZh);
        mi(true);
        if ("hour".equals(this.fZj)) {
            this.gCl.a(this);
        }
        return this.gCl.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(final boolean z) {
        if (this.gCk == null) {
            this.gCk = new f(this.bNs.getUniqueId(), this.gCt);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fZj, "charm_day")) {
                    this.gCm = 2;
                    if (this.mUserId != 0) {
                        this.gCk.A(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gCm--;
                        this.gCl.clK();
                    }
                    this.gCk.e(this.fZj, this.mUserId, "");
                } else if (TextUtils.equals(this.fZj, "hour")) {
                    if (this.mUserId == 0) {
                        this.gCl.clK();
                    }
                    if (z) {
                        this.gCo = BdUniqueId.gen();
                        this.gCk.a(this.fZj, this.mUserId, "", this.gCo);
                        return;
                    }
                    this.gCp = BdUniqueId.gen();
                    if (this.gCq != null && !TextUtils.isEmpty(this.gCq.UD())) {
                        this.gCk.a(this.fZj, this.mUserId, StringHelper.getHourRankPreHourString(this.gCq.UD(), -1), this.gCp);
                    }
                }
            }
        } else if (this.gCl != null) {
            this.gCl.Wk();
            this.gCl.dq(false);
            this.gCl.clK();
            this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.mi(z);
                    } else {
                        a.this.bNs.getPageContext().showToast(a.this.bNs.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gCl != null) {
                this.gCl.clK();
                this.gCl.Wk();
                this.gCl.a(new ArrayList<>(), this.gCq == null ? 0L : this.gCq.bSb(), this);
                this.gCl.wJ(0);
                this.gCl.dq(false);
                this.gCl.wI(8);
                this.gCl.gB(8);
                this.gCl.m(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.mi(a.this.gCn);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gCl.Wk();
            this.gCl.gB(0);
            this.gCl.a(new ArrayList<>(), pVar.bSb(), this);
            this.gCl.wJ(0);
            this.gCl.dq(true);
            this.gCl.wI(8);
            if (this.gCl != null) {
                pVar.bSd().md(this.gCn ? false : true);
                this.gCl.c(pVar.bSd());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gCl.gB(0);
            this.gCl.Wk();
            if (this.gCl != null) {
                this.gCl.c(pVar);
                r bSd = pVar.bSd();
                if (pVar.getList().size() == 1) {
                    this.gCl.a(new ArrayList<>(), pVar.bSb(), this);
                    this.gCl.dq(false);
                    if (bSd != null) {
                        bSd.bo(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gCl.a(arrayList, pVar.bSb(), this);
                    if (bSd != null) {
                        bSd.bo(false);
                    }
                }
                this.gCl.wJ(0);
                this.gCl.wI(0);
                if (this.gCl != null) {
                    pVar.bSd().md(this.gCn ? false : true);
                    this.gCl.c(bSd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aIc >= 2 && hVar.aIc < arrayList.size() + 2) {
                hVar.eC(JavaTypesHelper.toLong(arrayList.get(hVar.aIc - 2).point, 0L));
            }
            if (hVar.aIc < arrayList.size() && hVar.aIc >= 0) {
                hVar.eD(JavaTypesHelper.toLong(arrayList.get(hVar.aIc).point, 0L));
            }
            hVar.an(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return hVar;
    }

    public void bSE() {
        if (!this.fZk && "hour".equals(this.fZj)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.bbt, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bSF() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void mj(boolean z) {
        this.gCn = z;
        if (z) {
            a(this.gCq);
        } else {
            a(this.gCr);
        }
        mk(z);
    }

    private void mk(boolean z) {
        if ("hour".equals(this.fZj)) {
            String str = z ? "hour" : "last_hour";
            if (!gCs.contains(str)) {
                gCs.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.bbt, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gCl.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gCj;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.gCk != null) {
            this.gCk.destory();
        }
        if (this.gCl != null) {
            this.gCl.release();
        }
        if ("hour".equals(this.fZj)) {
            MessageManager.getInstance().unRegisterListener(this.gCv);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
