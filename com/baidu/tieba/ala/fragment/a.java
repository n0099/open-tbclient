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
/* loaded from: classes10.dex */
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> gWL = new HashSet();
    private String PP;
    private int aLA;
    private BaseActivity bXa;
    private String beL;
    private String gUT;
    private String gWC;
    private f gWD;
    private g gWE;
    private int gWF;
    private BdUniqueId gWH;
    private BdUniqueId gWI;
    private p gWJ;
    private p gWK;
    private String grA;
    private boolean grB;
    private long gry;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean gWG = true;
    private n gWM = new n() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.grA)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.gWE != null) {
                            a.this.gWE.dQ(false);
                            if (a.this.gWF == 0) {
                                a.this.gWE.cpN();
                            }
                            a.this.gWE.Xc();
                            a.this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.nf(a.this.gWG);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.gWF == 0) {
                        a.this.gWE.Xc();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.gtn == null || alaGetRankListResponseMessage.gtn.size() <= 0) {
                            if (a.this.gWE != null) {
                                a.this.gWE.cpN();
                                return;
                            }
                            return;
                        } else if (a.this.gWE != null) {
                            a.this.gWE.a(alaGetRankListResponseMessage.gtn, alaGetRankListResponseMessage.hVo, a.this);
                            if (a.this.gWE.cpM() != null && (a.this.gWE.cpM() instanceof h)) {
                                a.this.gWE.c(a.this.a((h) a.this.gWE.cpM(), alaGetRankListResponseMessage.gtn));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.hVq == null) {
                        if (a.this.gWE != null) {
                            a.this.gWE.cpN();
                        }
                    } else if (a.this.gWE != null) {
                        a.this.gWE.c(a.this.a(alaGetUserRankInfoResponseMessage.hVq, a.this.gWE.bHD()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.grA)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    p cma = alaGetHourRankListResponseMessage.cma();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.gWH != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gWH.getId()) || (a.this.gWI != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gWI.getId())) {
                            if (!((a.this.gWH != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gWH.getId()) == a.this.gWG) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gWH.getId()) {
                                    a.this.gWJ = cma;
                                    if (a.this.gWG) {
                                        a.this.gWE.Xc();
                                        a.this.a(a.this.gWJ);
                                    }
                                    a.this.nf(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.gWI.getId()) {
                                    a.this.gWK = cma;
                                    if (!a.this.gWG) {
                                        a.this.gWE.Xc();
                                        a.this.a(a.this.gWK);
                                    }
                                }
                            } else if (a.this.gWE != null) {
                                a.this.gWE.dQ(false);
                                a.this.gWE.cpN();
                                a.this.gWE.Xc();
                                a.this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.nf(a.this.gWG);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private g.a gWN = new g.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.g.a
        public void h(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bXa);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.grA) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.grA)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.ae.a.Qm().bwx.aNO;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bVn();
            } else if ("hour".equals(a.this.grA) || "charm_day".equals(a.this.grA)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bVn();
            }
            if ("hot".equals(a.this.grA)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bXa.setResult(-1, intent);
            a.this.bXa.finish();
        }
    };
    CustomMessageListener gWO = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.grA)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.beL, hourRankItemData.type, a.this.gWG ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.gWF;
        aVar.gWF = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bXa = baseActivity;
        this.grA = str;
        this.mUserId = j;
        this.PP = str2;
        this.grB = z;
        this.aLA = i;
        this.mPortrait = str3;
        this.beL = str5;
        this.gry = j2;
        this.gUT = str6;
        this.otherParams = str4;
        this.gWC = str7;
        if ("hour".equals(this.grA)) {
            MessageManager.getInstance().registerListener(this.gWO);
        }
        createView();
    }

    public final View createView() {
        this.gWE = new g(this.bXa.getPageContext(), this.grA, this.aLA, this.gWN, this.grB, this.mUserId, this.PP, this.mPortrait, this.gry);
        nf(true);
        if ("hour".equals(this.grA)) {
            this.gWE.a(this);
        }
        return this.gWE.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(final boolean z) {
        if (this.gWD == null) {
            this.gWD = new f(this.bXa.getUniqueId(), this.gWM);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.grA, "charm_day")) {
                    this.gWF = 2;
                    if (this.mUserId != 0) {
                        this.gWD.z(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.gWF--;
                        this.gWE.cpN();
                    }
                    this.gWD.e(this.grA, this.mUserId, "");
                } else if (TextUtils.equals(this.grA, "hour")) {
                    if (this.mUserId == 0) {
                        this.gWE.cpN();
                    }
                    if (z) {
                        this.gWH = BdUniqueId.gen();
                        this.gWD.a(this.grA, this.mUserId, "", this.gWH);
                        return;
                    }
                    this.gWI = BdUniqueId.gen();
                    if (this.gWJ != null && !TextUtils.isEmpty(this.gWJ.Vq())) {
                        this.gWD.a(this.grA, this.mUserId, StringHelper.getHourRankPreHourString(this.gWJ.Vq(), -1), this.gWI);
                    }
                }
            }
        } else if (this.gWE != null) {
            this.gWE.Xc();
            this.gWE.dQ(false);
            this.gWE.cpN();
            this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.nf(z);
                    } else {
                        a.this.bXa.getPageContext().showToast(a.this.bXa.getResources().getString(a.h.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar == null) {
            if (this.gWE != null) {
                this.gWE.cpN();
                this.gWE.Xc();
                this.gWE.a(new ArrayList<>(), this.gWJ == null ? 0L : this.gWJ.bUL(), this);
                this.gWE.wG(0);
                this.gWE.dQ(false);
                this.gWE.wF(8);
                this.gWE.fw(8);
                this.gWE.n(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.nf(a.this.gWG);
                    }
                });
            }
        } else if (pVar.getList() == null || pVar.getList().size() <= 0) {
            this.gWE.Xc();
            this.gWE.fw(0);
            this.gWE.a(new ArrayList<>(), pVar.bUL(), this);
            this.gWE.wG(0);
            this.gWE.dQ(true);
            this.gWE.wF(8);
            if (this.gWE != null) {
                pVar.bUN().na(this.gWG ? false : true);
                this.gWE.c(pVar.bUN());
            }
        } else if (pVar.getList() != null && pVar.getList().size() > 0) {
            this.gWE.fw(0);
            this.gWE.Xc();
            if (this.gWE != null) {
                this.gWE.c(pVar);
                r bUN = pVar.bUN();
                if (pVar.getList().size() == 1) {
                    this.gWE.a(new ArrayList<>(), pVar.bUL(), this);
                    this.gWE.dQ(false);
                    if (bUN != null) {
                        bUN.bt(true);
                    }
                } else if (pVar.getList().size() > 1) {
                    int size = pVar.getList().size();
                    ArrayList<h> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(pVar.getList().get(i));
                    }
                    this.gWE.a(arrayList, pVar.bUL(), this);
                    if (bUN != null) {
                        bUN.bt(false);
                    }
                }
                this.gWE.wG(0);
                this.gWE.wF(0);
                if (this.gWE != null) {
                    pVar.bUN().na(this.gWG ? false : true);
                    this.gWE.c(bUN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h a(h hVar, ArrayList<h> arrayList) {
        hVar.a(hVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (hVar.aHY >= 2 && hVar.aHY < arrayList.size() + 2) {
                hVar.fm(JavaTypesHelper.toLong(arrayList.get(hVar.aHY - 2).gUB, 0L));
            }
            if (hVar.aHY < arrayList.size() && hVar.aHY >= 0) {
                hVar.fn(JavaTypesHelper.toLong(arrayList.get(hVar.aHY).gUB, 0L));
            }
            hVar.aM(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).gUB, 0L));
        }
        return hVar;
    }

    public void bVn() {
        if (!this.grB && "hour".equals(this.grA)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.beL, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bVo() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ng(boolean z) {
        this.gWG = z;
        if (z) {
            a(this.gWJ);
        } else {
            a(this.gWK);
        }
        nh(z);
    }

    private void nh(boolean z) {
        if ("hour".equals(this.grA)) {
            String str = z ? "hour" : "last_hour";
            if (!gWL.contains(str)) {
                gWL.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.beL, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gWE.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gWC;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        if (this.gWD != null) {
            this.gWD.destory();
        }
        if (this.gWE != null) {
            this.gWE.release();
        }
        if ("hour".equals(this.grA)) {
            MessageManager.getInstance().unRegisterListener(this.gWO);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
