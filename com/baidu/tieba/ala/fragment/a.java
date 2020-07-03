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
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.f.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import com.baidu.tieba.ala.view.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a implements d, AlaRankListHeaderView.a, AlaRankListHeaderView.b {
    private static Set<String> fFx = new HashSet();
    private String Mt;
    private String aMu;
    private int ayf;
    private BaseActivity boL;
    private String fEi;
    private String fFo;
    private com.baidu.tieba.ala.f.d fFp;
    private com.baidu.tieba.ala.view.d fFq;
    private int fFr;
    private BdUniqueId fFt;
    private BdUniqueId fFu;
    private m fFv;
    private m fFw;
    private long ffd;
    private String fff;
    private boolean ffg;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fFs = true;
    private j fFy = new j() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.fff)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.fFq != null) {
                            a.this.fFq.jS(false);
                            if (a.this.fFr == 0) {
                                a.this.fFq.bMS();
                            }
                            a.this.fFq.btN();
                            a.this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.kd(a.this.fFs);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.fFr == 0) {
                        a.this.fFq.btN();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.fgO == null || alaGetRankListResponseMessage.fgO.size() <= 0) {
                            if (a.this.fFq != null) {
                                a.this.fFq.bMS();
                                return;
                            }
                            return;
                        } else if (a.this.fFq != null) {
                            a.this.fFq.a(alaGetRankListResponseMessage.fgO, alaGetRankListResponseMessage.gwg, a.this);
                            if (a.this.fFq.bMR() != null && (a.this.fFq.bMR() instanceof g)) {
                                a.this.fFq.c(a.this.a((g) a.this.fFq.bMR(), alaGetRankListResponseMessage.fgO));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gwi == null) {
                        if (a.this.fFq != null) {
                            a.this.fFq.bMS();
                        }
                    } else if (a.this.fFq != null) {
                        a.this.fFq.c(a.this.a(alaGetUserRankInfoResponseMessage.gwi, a.this.fFq.bkO()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.fff)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bKG = alaGetHourRankListResponseMessage.bKG();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.fFt != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fFt.getId()) || (a.this.fFu != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fFu.getId())) {
                            if (!((a.this.fFt != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fFt.getId()) == a.this.fFs) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fFt.getId()) {
                                    a.this.fFv = bKG;
                                    if (a.this.fFs) {
                                        a.this.fFq.btN();
                                        a.this.a(a.this.fFv);
                                    }
                                    a.this.kd(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fFu.getId()) {
                                    a.this.fFw = bKG;
                                    if (!a.this.fFs) {
                                        a.this.fFq.btN();
                                        a.this.a(a.this.fFw);
                                    }
                                }
                            } else if (a.this.fFq != null) {
                                a.this.fFq.jS(false);
                                a.this.fFq.bMS();
                                a.this.fFq.btN();
                                a.this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.kd(a.this.fFs);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a fFz = new d.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.boL);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.fff) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.fff)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.v.a.Hm().aZp.aAh;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.bwS();
            } else if ("hour".equals(a.this.fff) || "charm_day".equals(a.this.fff)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.bwS();
            }
            if ("hot".equals(a.this.fff)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.boL.setResult(-1, intent);
            a.this.boL.finish();
        }
    };
    CustomMessageListener fFA = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.fff)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aMu, hourRankItemData.type, a.this.fFs ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fFr;
        aVar.fFr = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.boL = baseActivity;
        this.fff = str;
        this.mUserId = j;
        this.Mt = str2;
        this.ffg = z;
        this.ayf = i;
        this.mPortrait = str3;
        this.aMu = str5;
        this.ffd = j2;
        this.fEi = str6;
        this.otherParams = str4;
        this.fFo = str7;
        if ("hour".equals(this.fff)) {
            MessageManager.getInstance().registerListener(this.fFA);
        }
        bwR();
    }

    public View bwR() {
        this.fFq = new com.baidu.tieba.ala.view.d(this.boL.getPageContext(), this.fff, this.ayf, this.fFz, this.ffg, this.mUserId, this.Mt, this.mPortrait, this.ffd);
        kd(true);
        if ("hour".equals(this.fff)) {
            this.fFq.a(this);
        }
        return this.fFq.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(final boolean z) {
        if (this.fFp == null) {
            this.fFp = new com.baidu.tieba.ala.f.d(this.boL.getUniqueId(), this.fFy);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.fff, "charm_day")) {
                    this.fFr = 2;
                    if (this.mUserId != 0) {
                        this.fFp.y(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fFr--;
                        this.fFq.bMS();
                    }
                    this.fFp.f(this.fff, this.mUserId, "");
                } else if (TextUtils.equals(this.fff, "hour")) {
                    if (this.mUserId == 0) {
                        this.fFq.bMS();
                    }
                    if (z) {
                        this.fFt = BdUniqueId.gen();
                        this.fFp.a(this.fff, this.mUserId, "", this.fFt);
                        return;
                    }
                    this.fFu = BdUniqueId.gen();
                    if (this.fFv != null && !TextUtils.isEmpty(this.fFv.Ji())) {
                        this.fFp.a(this.fff, this.mUserId, StringHelper.getHourRankPreHourString(this.fFv.Ji(), -1), this.fFu);
                    }
                }
            }
        } else if (this.fFq != null) {
            this.fFq.btN();
            this.fFq.jS(false);
            this.fFq.bMS();
            this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.kd(z);
                    } else {
                        a.this.boL.getPageContext().showToast(a.this.boL.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar == null) {
            if (this.fFq != null) {
                this.fFq.bMS();
                this.fFq.btN();
                this.fFq.a(new ArrayList<>(), this.fFv == null ? 0L : this.fFv.bwI(), this);
                this.fFq.sy(0);
                this.fFq.jS(false);
                this.fFq.sw(8);
                this.fFq.sx(8);
                this.fFq.l(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.kd(a.this.fFs);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.fFq.btN();
            this.fFq.sx(0);
            this.fFq.a(new ArrayList<>(), mVar.bwI(), this);
            this.fFq.sy(0);
            this.fFq.jS(true);
            this.fFq.sw(8);
            if (this.fFq != null) {
                mVar.bwK().ka(this.fFs ? false : true);
                this.fFq.c(mVar.bwK());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.fFq.sx(0);
            this.fFq.btN();
            if (this.fFq != null) {
                this.fFq.c(mVar);
                n bwK = mVar.bwK();
                if (mVar.getList().size() == 1) {
                    this.fFq.a(new ArrayList<>(), mVar.bwI(), this);
                    this.fFq.jS(false);
                    if (bwK != null) {
                        bwK.jZ(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.fFq.a(arrayList, mVar.bwI(), this);
                    if (bwK != null) {
                        bwK.jZ(false);
                    }
                }
                this.fFq.sy(0);
                this.fFq.sw(0);
                if (this.fFq != null) {
                    mVar.bwK().ka(this.fFs ? false : true);
                    this.fFq.c(bwK);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.fEo >= 2 && gVar.fEo < arrayList.size() + 2) {
                gVar.du(JavaTypesHelper.toLong(arrayList.get(gVar.fEo - 2).point, 0L));
            }
            if (gVar.fEo < arrayList.size() && gVar.fEo >= 0) {
                gVar.dv(JavaTypesHelper.toLong(arrayList.get(gVar.fEo).point, 0L));
            }
            gVar.dw(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void bwS() {
        if (!this.ffg && "hour".equals(this.fff)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aMu, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void bwT() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void ke(boolean z) {
        this.fFs = z;
        if (z) {
            a(this.fFv);
        } else {
            a(this.fFw);
        }
        kf(z);
    }

    private void kf(boolean z) {
        if ("hour".equals(this.fff)) {
            String str = z ? "hour" : "last_hour";
            if (!fFx.contains(str)) {
                fFx.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aMu, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.fFq.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fFo;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String CI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
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
        if (this.fFp != null) {
            this.fFp.destory();
        }
        if (this.fFq != null) {
            this.fFq.release();
        }
        if ("hour".equals(this.fff)) {
            MessageManager.getInstance().unRegisterListener(this.fFA);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
