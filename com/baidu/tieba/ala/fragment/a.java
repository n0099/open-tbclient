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
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
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
    private static Set<String> fun = new HashSet();
    private String LR;
    private String aJO;
    private int avX;
    private BaseActivity bjI;
    private long eUS;
    private String eUU;
    private boolean eUV;
    private String fsX;
    private String fue;
    private com.baidu.tieba.ala.f.d fuf;
    private com.baidu.tieba.ala.view.d fug;
    private int fuh;
    private BdUniqueId fuj;
    private BdUniqueId fuk;
    private m ful;
    private m fum;
    private String mPortrait;
    private long mUserId;
    private String otherParams;
    private boolean fui = true;
    private j fuo = new j() { // from class: com.baidu.tieba.ala.fragment.a.2
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (((obj instanceof AlaGetRankListResponseMessage) || (obj instanceof AlaGetUserRankInfoResponseMessage)) && "charm_day".equals(a.this.eUU)) {
                    if (i != 0 && !StringUtils.isNull(str)) {
                        a.c(a.this);
                        if (a.this.fug != null) {
                            a.this.fug.jF(false);
                            if (a.this.fuh == 0) {
                                a.this.fug.bJN();
                            }
                            a.this.fug.bqQ();
                            a.this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    a.this.jP(a.this.fui);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a.c(a.this);
                    if (a.this.fuh == 0) {
                        a.this.fug.bqQ();
                    }
                    if (obj instanceof AlaGetRankListResponseMessage) {
                        AlaGetRankListResponseMessage alaGetRankListResponseMessage = (AlaGetRankListResponseMessage) obj;
                        if (alaGetRankListResponseMessage.eWD == null || alaGetRankListResponseMessage.eWD.size() <= 0) {
                            if (a.this.fug != null) {
                                a.this.fug.bJN();
                                return;
                            }
                            return;
                        } else if (a.this.fug != null) {
                            a.this.fug.a(alaGetRankListResponseMessage.eWD, alaGetRankListResponseMessage.gjt, a.this);
                            if (a.this.fug.bJM() != null && (a.this.fug.bJM() instanceof g)) {
                                a.this.fug.c(a.this.a((g) a.this.fug.bJM(), alaGetRankListResponseMessage.eWD));
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    AlaGetUserRankInfoResponseMessage alaGetUserRankInfoResponseMessage = (AlaGetUserRankInfoResponseMessage) obj;
                    if (alaGetUserRankInfoResponseMessage.gjv == null) {
                        if (a.this.fug != null) {
                            a.this.fug.bJN();
                        }
                    } else if (a.this.fug != null) {
                        a.this.fug.c(a.this.a(alaGetUserRankInfoResponseMessage.gjv, a.this.fug.bis()));
                    }
                } else if ((obj instanceof AlaGetHourRankListResponseMessage) && "hour".equals(a.this.eUU)) {
                    AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                    m bHC = alaGetHourRankListResponseMessage.bHC();
                    if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() != null) {
                        if ((a.this.fuj != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fuj.getId()) || (a.this.fuk != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fuk.getId())) {
                            if (!((a.this.fuj != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fuj.getId()) == a.this.fui) || i == 0 || StringUtils.isNull(str)) {
                                if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fuj.getId()) {
                                    a.this.ful = bHC;
                                    if (a.this.fui) {
                                        a.this.fug.bqQ();
                                        a.this.a(a.this.ful);
                                    }
                                    a.this.jP(false);
                                } else if (alaGetHourRankListResponseMessage.getOrginalMessage().getTag().getId() == a.this.fuk.getId()) {
                                    a.this.fum = bHC;
                                    if (!a.this.fui) {
                                        a.this.fug.bqQ();
                                        a.this.a(a.this.fum);
                                    }
                                }
                            } else if (a.this.fug != null) {
                                a.this.fug.jF(false);
                                a.this.fug.bJN();
                                a.this.fug.bqQ();
                                a.this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.2.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        a.this.jP(a.this.fui);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    };
    private d.a fup = new d.a() { // from class: com.baidu.tieba.ala.fragment.a.4
        @Override // com.baidu.tieba.ala.view.d.a
        public void g(View view, String str) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.bjI);
                return;
            }
            Intent intent = new Intent();
            if (SdkStaticKeys.RANK_TYPE_FLOWER.equals(a.this.eUU) || SdkStaticKeys.RANK_TYPE_CHARM.equals(a.this.eUU)) {
                TiebaInitialize.log(new StatisticItem("c12962"));
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                int i = com.baidu.live.v.a.Ge().aWF.axS;
                intent.putExtra("ala_live_room_gift_panel_category_id", i);
                intent.putExtra("ala_live_room_gift_panel_gift_id", i > 0 ? 10185 : -1);
                a.this.btX();
            } else if ("hour".equals(a.this.eUU) || "charm_day".equals(a.this.eUU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_gift_panel");
                a.this.btX();
            }
            if ("hot".equals(a.this.eUU)) {
                intent.putExtra("ala_live_room_show_panel_key", "ala_live_room_show_share_panel");
                TiebaInitialize.log(new StatisticItem("c12486"));
            }
            a.this.bjI.setResult(-1, intent);
            a.this.bjI.finish();
        }
    };
    CustomMessageListener fuq = new CustomMessageListener(2913104) { // from class: com.baidu.tieba.ala.fragment.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HourRankItemData) && "hour".equals(a.this.eUU)) {
                HourRankItemData hourRankItemData = (HourRankItemData) customResponsedMessage.getData();
                LogManager.getCommonLogger().doClickHourRankItemLog(a.this.aJO, hourRankItemData.type, a.this.fui ? "hour" : "last_hour", hourRankItemData.position + "", a.this.otherParams);
            }
        }
    };

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fuh;
        aVar.fuh = i - 1;
        return i;
    }

    public a(BaseActivity baseActivity, String str, int i, long j, String str2, boolean z, String str3, String str4, String str5, long j2, String str6, String str7) {
        this.bjI = baseActivity;
        this.eUU = str;
        this.mUserId = j;
        this.LR = str2;
        this.eUV = z;
        this.avX = i;
        this.mPortrait = str3;
        this.aJO = str5;
        this.eUS = j2;
        this.fsX = str6;
        this.otherParams = str4;
        this.fue = str7;
        if ("hour".equals(this.eUU)) {
            MessageManager.getInstance().registerListener(this.fuq);
        }
        btW();
    }

    public View btW() {
        this.fug = new com.baidu.tieba.ala.view.d(this.bjI.getPageContext(), this.eUU, this.avX, this.fup, this.eUV, this.mUserId, this.LR, this.mPortrait, this.eUS);
        jP(true);
        if ("hour".equals(this.eUU)) {
            this.fug.a(this);
        }
        return this.fug.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(final boolean z) {
        if (this.fuf == null) {
            this.fuf = new com.baidu.tieba.ala.f.d(this.bjI.getUniqueId(), this.fuo);
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
                if (TextUtils.equals(this.eUU, "charm_day")) {
                    this.fuh = 2;
                    if (this.mUserId != 0) {
                        this.fuf.y(SdkStaticKeys.RANK_TYPE_CHARM, this.mUserId);
                    } else {
                        this.fuh--;
                        this.fug.bJN();
                    }
                    this.fuf.e(this.eUU, this.mUserId, "");
                } else if (TextUtils.equals(this.eUU, "hour")) {
                    if (this.mUserId == 0) {
                        this.fug.bJN();
                    }
                    if (z) {
                        this.fuj = BdUniqueId.gen();
                        this.fuf.a(this.eUU, this.mUserId, "", this.fuj);
                        return;
                    }
                    this.fuk = BdUniqueId.gen();
                    if (this.ful != null && !TextUtils.isEmpty(this.ful.HV())) {
                        this.fuf.a(this.eUU, this.mUserId, StringHelper.getHourRankPreHourString(this.ful.HV(), -1), this.fuk);
                    }
                }
            }
        } else if (this.fug != null) {
            this.fug.bqQ();
            this.fug.jF(false);
            this.fug.bJN();
            this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.jP(z);
                    } else {
                        a.this.bjI.getPageContext().showToast(a.this.bjI.getResources().getString(a.i.sdk_no_network_guide));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar == null) {
            if (this.fug != null) {
                this.fug.bJN();
                this.fug.bqQ();
                this.fug.a(new ArrayList<>(), this.ful == null ? 0L : this.ful.btN(), this);
                this.fug.rZ(0);
                this.fug.jF(false);
                this.fug.rX(8);
                this.fug.rY(8);
                this.fug.k(new View.OnClickListener() { // from class: com.baidu.tieba.ala.fragment.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.jP(a.this.fui);
                    }
                });
            }
        } else if (mVar.getList() == null || mVar.getList().size() <= 0) {
            this.fug.bqQ();
            this.fug.rY(0);
            this.fug.a(new ArrayList<>(), mVar.btN(), this);
            this.fug.rZ(0);
            this.fug.jF(true);
            this.fug.rX(8);
            if (this.fug != null) {
                mVar.btP().jM(this.fui ? false : true);
                this.fug.c(mVar.btP());
            }
        } else if (mVar.getList() != null && mVar.getList().size() > 0) {
            this.fug.rY(0);
            this.fug.bqQ();
            if (this.fug != null) {
                this.fug.c(mVar);
                n btP = mVar.btP();
                if (mVar.getList().size() == 1) {
                    this.fug.a(new ArrayList<>(), mVar.btN(), this);
                    this.fug.jF(false);
                    if (btP != null) {
                        btP.jL(true);
                    }
                } else if (mVar.getList().size() > 1) {
                    int size = mVar.getList().size();
                    ArrayList<g> arrayList = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        arrayList.add(mVar.getList().get(i));
                    }
                    this.fug.a(arrayList, mVar.btN(), this);
                    if (btP != null) {
                        btP.jL(false);
                    }
                }
                this.fug.rZ(0);
                this.fug.rX(0);
                if (this.fug != null) {
                    mVar.btP().jM(this.fui ? false : true);
                    this.fug.c(btP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(g gVar, ArrayList<g> arrayList) {
        gVar.a(gVar);
        if (arrayList != null && arrayList.size() > 0) {
            if (gVar.ftd >= 2 && gVar.ftd < arrayList.size() + 2) {
                gVar.dr(JavaTypesHelper.toLong(arrayList.get(gVar.ftd - 2).point, 0L));
            }
            if (gVar.ftd < arrayList.size() && gVar.ftd >= 0) {
                gVar.ds(JavaTypesHelper.toLong(arrayList.get(gVar.ftd).point, 0L));
            }
            gVar.dt(JavaTypesHelper.toLong(arrayList.get(arrayList.size() - 1).point, 0L));
        }
        return gVar;
    }

    public void btX() {
        if (!this.eUV && "hour".equals(this.eUU)) {
            LogManager.getCommonLogger().doClickLiveAuthorRankSupportLog(this.aJO, "hour", this.otherParams);
        }
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.a
    public void btY() {
    }

    @Override // com.baidu.tieba.ala.view.AlaRankListHeaderView.b
    public void jQ(boolean z) {
        this.fui = z;
        if (z) {
            a(this.ful);
        } else {
            a(this.fum);
        }
        jR(z);
    }

    private void jR(boolean z) {
        if ("hour".equals(this.eUU)) {
            String str = z ? "hour" : "last_hour";
            if (!fun.contains(str)) {
                fun.add(str);
                LogManager.getCommonLogger().doDisplayHourRankLog(this.aJO, str, this.otherParams);
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.fug.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fue;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        if (this.fuf != null) {
            this.fuf.destory();
        }
        if (this.fug != null) {
            this.fug.release();
        }
        if ("hour".equals(this.eUU)) {
            MessageManager.getInstance().unRegisterListener(this.fuq);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
