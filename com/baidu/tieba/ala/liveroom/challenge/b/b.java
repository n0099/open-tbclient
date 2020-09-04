package com.baidu.tieba.ala.liveroom.challenge.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.d;
import com.baidu.live.challenge.i;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.data.al;
import com.baidu.live.data.ap;
import com.baidu.live.data.ar;
import com.baidu.live.data.as;
import com.baidu.live.data.at;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaAcceptDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaCancelRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaChallengeLatestListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaChallengeSwitchResponsedMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetChallengeInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetDirectChallengeListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaGetTargetListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaSearchTargetListResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartDirectChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaStartRandomChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaSurrenderResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.CloseChallengeResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.GetChallengeMvpToastInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.SetChallengeMvpPunishChooseResponseMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private BdUniqueId beX;
    private int brp;
    private long fvG;
    private int gqK;
    private long gqX;
    private long gqY;
    private long gqZ;
    private a gqd;
    private long gra;
    private long grb;
    private long grc;
    private long grd;
    private long grf;
    private ChallenfeInfoData.ChallengeStatus grg;
    private i.f grh;
    private boolean isHost;
    private TbPageContext mPageContext;
    private boolean gre = false;
    private boolean gri = false;
    private boolean grj = false;
    private boolean grk = false;
    private HttpMessageListener brZ = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaChallengeSwitchResponsedMessage) {
                b.this.a((AlaChallengeSwitchResponsedMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetTargetListResponseMessage) {
                b.this.a((AlaGetTargetListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaChallengeLatestListResponseMessage) {
                b.this.a((AlaChallengeLatestListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaStartDirectChallengeResponseMessage) {
                b.this.a((AlaStartDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaCancelDirectChallengeResponseMessage) {
                b.this.a((AlaCancelDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetDirectChallengeListResponseMessage) {
                b.this.a((AlaGetDirectChallengeListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaAcceptDirectChallengeResponseMessage) {
                b.this.a((AlaAcceptDirectChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaStartRandomChallengeResponseMessage) {
                b.this.a((AlaStartRandomChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaCancelRandomChallengeResponseMessage) {
                b.this.a((AlaCancelRandomChallengeResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaSurrenderResponseMessage) {
                b.this.a((AlaSurrenderResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaGetTargetInfoResponseMessage) {
                b.this.a((AlaGetTargetInfoResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof AlaSearchTargetListResponseMessage) {
                b.this.a((AlaSearchTargetListResponseMessage) httpResponsedMessage);
            } else if (httpResponsedMessage instanceof CloseChallengeResponseMessage) {
                b.this.a((CloseChallengeResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener aZw = new HttpMessageListener(1021112) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetChallengeInfoResponseMessage) {
                b.this.gri = false;
                b.this.b((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
                b.this.a((AlaGetChallengeInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable grn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.grk) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gqY);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021106, b.this.beX);
            b.this.lU(false);
            b.this.mHandler.postDelayed(this, b.this.gqY);
        }
    };
    private Runnable gro = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.4
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.grj) {
                b.this.mHandler.removeCallbacks(this);
                b.this.mHandler.postDelayed(this, b.this.gqX);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021110, b.this.beX);
            b.this.lV(false);
            b.this.mHandler.postDelayed(this, b.this.gqX);
        }
    };
    private Runnable grp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.b.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gra <= 0) {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().removeMessage(1021112, b.this.beX);
                return;
            }
            b.this.mHandler.removeCallbacks(this);
            if (b.this.gri) {
                b.this.mHandler.postDelayed(this, b.this.gqZ);
                return;
            }
            MessageManager.getInstance().removeMessage(1021112, b.this.beX);
            if (b.this.grh != null) {
                b.this.gqK = b.this.grh.BU();
            }
            b.this.gri = true;
            com.baidu.tieba.ala.liveroom.challenge.message.a aVar = new com.baidu.tieba.ala.liveroom.challenge.message.a(b.this.gra, b.this.brp, b.this.fvG, b.this.grf, b.this.gqK);
            aVar.setTag(b.this.beX);
            MessageManager.getInstance().sendMessage(aVar);
            if (b.this.isHost) {
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_REQ, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("avts_conn", b.this.brp);
                    jSONObject2.put("avts_fail", b.this.gqK);
                    jSONObject2.put("chat_id", b.this.gra);
                    jSONObject.put("pk", jSONObject2);
                } catch (JSONException e) {
                }
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
            }
            b.this.mHandler.postDelayed(this, b.this.gqZ);
        }
    };
    private Handler mHandler = new Handler();
    private Map<Long, List<Long>> grl = new HashMap();
    private Map<Long, Integer> grm = new HashMap();

    /* loaded from: classes7.dex */
    public interface a {
        void BV();

        void a(com.baidu.live.challenge.b bVar, List<d> list);

        void a(d dVar);

        void aJ(int i, String str);

        void aK(int i, String str);

        void aL(int i, String str);

        void aM(int i, String str);

        void aN(int i, String str);

        void aO(int i, String str);

        void aP(int i, String str);

        void b(int i, ap apVar, at atVar, at atVar2);

        void b(com.baidu.live.challenge.a aVar);

        void b(boolean z, com.baidu.live.challenge.a aVar);

        void bW(List<d> list);

        void c(com.baidu.live.challenge.a aVar);

        void c(boolean z, com.baidu.live.challenge.a aVar);

        void d(boolean z, com.baidu.live.challenge.a aVar);

        void j(int i, String str);

        void k(int i, String str);

        void l(int i, List<d> list);

        void n(int i, String str);

        void n(boolean z, String str);

        void o(boolean z, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        UbcStatisticItem ubcStatisticItem;
        if (alaGetChallengeInfoResponseMessage != null && this.isHost) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("avts_conn", this.brp);
                jSONObject2.put("avts_fail", this.gqK);
                if (alaGetChallengeInfoResponseMessage.bPy() != null) {
                    jSONObject2.put("chat_id", alaGetChallengeInfoResponseMessage.bPy().challengeId);
                    jSONObject2.put("chat_status", alaGetChallengeInfoResponseMessage.bPy().aIp);
                }
                jSONObject.put("pk", jSONObject2);
            } catch (JSONException e) {
            }
            if (alaGetChallengeInfoResponseMessage.hasError() || alaGetChallengeInfoResponseMessage.getError() != 0) {
                ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RESP, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
            } else {
                ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RESP, UbcStatConstant.ContentType.UBC_TYPE_PK_CHALLENGE_INFO_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
            }
            ubcStatisticItem.setContentExt(jSONObject);
            UbcStatisticManager.getInstance().logSendResponse(ubcStatisticItem, alaGetChallengeInfoResponseMessage, true);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.beX = bdUniqueId;
        this.gqX = com.baidu.live.w.a.Nk().beJ.aGp > 0 ? com.baidu.live.w.a.Nk().beJ.aGp : 1000L;
        this.gqY = com.baidu.live.w.a.Nk().beJ.aGq > 0 ? com.baidu.live.w.a.Nk().beJ.aGq : 1000L;
        this.gqZ = com.baidu.live.w.a.Nk().beJ.aGr > 0 ? com.baidu.live.w.a.Nk().beJ.aGr : 1000L;
        this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
        registerTask();
        registerListener();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public void e(long j, long j2) {
        this.fvG = j;
        this.grf = j2;
    }

    public void a(a aVar) {
        this.gqd = aVar;
    }

    public void b(i.f fVar) {
        this.grh = fVar;
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021183, "ala/challenge/getChallengeSwitch", AlaChallengeSwitchResponsedMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021105, "ala/challenge/getChallengeTargetList", AlaGetTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021182, "ala/challenge/searchChallengeTargetList", AlaSearchTargetListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021203, "ala/challenge/lastlyList", AlaChallengeLatestListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021106, "ala/challenge/startDirectChallenge", AlaStartDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021107, "ala/challenge/cancelDirectChallenge", AlaCancelDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021108, "ala/challenge/getDirectChallengerList", AlaGetDirectChallengeListResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021109, "ala/challenge/acceptDirectChallenge", AlaAcceptDirectChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021110, "ala/challenge/startRandomChallenge", AlaStartRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021111, "ala/challenge/cancelRandomChallenge", AlaCancelRandomChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021112, "ala/challenge/getChallengeInfo", AlaGetChallengeInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021115, "ala/challenge/challengeAutoFail", AlaSurrenderResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021116, "ala/challenge/getChallengeTargetInfo", AlaGetTargetInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021197, "ala/challenge/closeChallenge", CloseChallengeResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021199, "ala/challenge/getChallengeMvpToastInfo", GetChallengeMvpToastInfoResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021200, "ala/challenge/setChallengeMvpPunishChoose", SetChallengeMvpPunishChooseResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021183, this.brZ);
        MessageManager.getInstance().registerListener(1021105, this.brZ);
        MessageManager.getInstance().registerListener(1021182, this.brZ);
        MessageManager.getInstance().registerListener(1021203, this.brZ);
        MessageManager.getInstance().registerListener(1021106, this.brZ);
        MessageManager.getInstance().registerListener(1021107, this.brZ);
        MessageManager.getInstance().registerListener(1021108, this.brZ);
        MessageManager.getInstance().registerListener(1021109, this.brZ);
        MessageManager.getInstance().registerListener(1021110, this.brZ);
        MessageManager.getInstance().registerListener(1021111, this.brZ);
        MessageManager.getInstance().registerListener(1021115, this.brZ);
        MessageManager.getInstance().registerListener(1021116, this.brZ);
        MessageManager.getInstance().registerListener(1021197, this.brZ);
        MessageManager.getInstance().registerListener(this.aZw);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.brZ);
        MessageManager.getInstance().unRegisterListener(this.aZw);
    }

    private void bPI() {
        MessageManager.getInstance().removeMessage(1021183, this.beX);
        MessageManager.getInstance().removeMessage(1021105, this.beX);
        MessageManager.getInstance().removeMessage(1021182, this.beX);
        MessageManager.getInstance().removeMessage(1021203, this.beX);
        MessageManager.getInstance().removeMessage(1021106, this.beX);
        MessageManager.getInstance().removeMessage(1021107, this.beX);
        MessageManager.getInstance().removeMessage(1021108, this.beX);
        MessageManager.getInstance().removeMessage(1021109, this.beX);
        MessageManager.getInstance().removeMessage(1021110, this.beX);
        MessageManager.getInstance().removeMessage(1021111, this.beX);
        MessageManager.getInstance().removeMessage(1021116, this.beX);
    }

    private void bPJ() {
        MessageManager.getInstance().removeMessage(1021112, this.beX);
        MessageManager.getInstance().removeMessage(1021115, this.beX);
    }

    private void reset() {
        this.gra = 0L;
        this.grb = 0L;
        this.brp = 0;
        this.gqK = 0;
        this.grc = 0L;
        this.grd = 0L;
        bPM();
        bPL();
        bPN();
        this.mHandler.removeCallbacksAndMessages(null);
        bPI();
        bPJ();
    }

    public void bPK() {
        reset();
    }

    public void onDestroy() {
        reset();
        unRegisterListener();
    }

    public long BS() {
        return this.gra;
    }

    public void BL() {
        HttpMessage httpMessage = new HttpMessage(1021183);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021105);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(int i, int i2, String str) {
        HttpMessage httpMessage = new HttpMessage(1021182);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        httpMessage.addParam("query_words", str);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void fK(String str) {
        HttpMessage httpMessage = new HttpMessage(1021203);
        httpMessage.setTag(this.beX);
        httpMessage.addParam("anchor_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void W(long j) {
        HttpMessage httpMessage = new HttpMessage(1021116);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void X(long j) {
        this.gra = 0L;
        this.grb = j;
        this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        lU(true);
        this.mHandler.postDelayed(this.grn, 1000L);
    }

    public void Y(long j) {
        HttpMessage httpMessage = new HttpMessage(1021107);
        httpMessage.addParam("target_user_id", j);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
        ec(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void BM() {
        HttpMessage httpMessage = new HttpMessage(1021108);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void Z(long j) {
        HttpMessage httpMessage = new HttpMessage(1021109);
        httpMessage.addParam("challenge_user_id", j);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
        ec(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ExtraParamsManager.getBase64(String.valueOf(j)));
    }

    public void BN() {
        this.gra = 0L;
        this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_MATCHING;
        lV(true);
        this.mHandler.postDelayed(this.gro, 1000L);
    }

    public void BO() {
        HttpMessage httpMessage = new HttpMessage(1021111);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
        ec(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, null);
    }

    public void BR() {
        HttpMessage httpMessage = new HttpMessage(1021115);
        httpMessage.addParam("challenge_id", this.gra);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void BT() {
        HttpMessage httpMessage = new HttpMessage(1021197);
        httpMessage.addParam("challenge_id", this.gra);
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(long j, long j2, long j3, int i, String str) {
        HttpMessage httpMessage = new HttpMessage(1021200);
        httpMessage.addParam("challenge_id", j);
        httpMessage.addParam("punish_type", i);
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        httpMessage.addParam(AlaLiveStickerInfo.STICKER_ID, str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeSwitchResponsedMessage alaChallengeSwitchResponsedMessage) {
        if (alaChallengeSwitchResponsedMessage != null && this.gqd != null) {
            if (alaChallengeSwitchResponsedMessage.hasError() || alaChallengeSwitchResponsedMessage.getError() != 0) {
                this.gqd.n(alaChallengeSwitchResponsedMessage.getError(), alaChallengeSwitchResponsedMessage.getErrorString());
            } else {
                this.gqd.BV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetListResponseMessage alaGetTargetListResponseMessage) {
        if (this.gqd != null && alaGetTargetListResponseMessage != null) {
            if (alaGetTargetListResponseMessage.hasError() || alaGetTargetListResponseMessage.getError() != 0) {
                this.gqd.k(alaGetTargetListResponseMessage.getError(), alaGetTargetListResponseMessage.getErrorString());
            } else {
                this.gqd.a(alaGetTargetListResponseMessage.bPG(), alaGetTargetListResponseMessage.bPH());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSearchTargetListResponseMessage alaSearchTargetListResponseMessage) {
        if (this.gqd != null && alaSearchTargetListResponseMessage != null) {
            if (alaSearchTargetListResponseMessage.hasError() || alaSearchTargetListResponseMessage.getError() != 0) {
                this.gqd.k(alaSearchTargetListResponseMessage.getError(), alaSearchTargetListResponseMessage.getErrorString());
            } else {
                this.gqd.a(alaSearchTargetListResponseMessage.bPG(), alaSearchTargetListResponseMessage.bPH());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaChallengeLatestListResponseMessage alaChallengeLatestListResponseMessage) {
        if (this.gqd != null && alaChallengeLatestListResponseMessage != null) {
            if (alaChallengeLatestListResponseMessage.hasError() || alaChallengeLatestListResponseMessage.getError() != 0) {
                this.gqd.aJ(alaChallengeLatestListResponseMessage.getError(), alaChallengeLatestListResponseMessage.getErrorString());
            } else {
                this.gqd.bW(alaChallengeLatestListResponseMessage.bPx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CloseChallengeResponseMessage closeChallengeResponseMessage) {
        if (this.gqd != null && closeChallengeResponseMessage != null) {
            this.gqd.o(!closeChallengeResponseMessage.hasError() && closeChallengeResponseMessage.getError() == 0, closeChallengeResponseMessage.getErrorString());
        }
    }

    private void bPL() {
        this.grk = false;
        MessageManager.getInstance().removeMessage(1021106, this.beX);
        this.mHandler.removeCallbacks(this.grn);
        this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(boolean z) {
        this.grk = true;
        HttpMessage httpMessage = new HttpMessage(1021106);
        httpMessage.addParam("target_user_id", this.grb);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
        ec(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, ExtraParamsManager.getBase64(String.valueOf(this.grb)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartDirectChallengeResponseMessage alaStartDirectChallengeResponseMessage) {
        if (this.gqd != null) {
            this.grk = false;
            String base64 = ExtraParamsManager.getBase64(String.valueOf(this.grb));
            String str = "";
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.bPu() != null) {
                str = alaStartDirectChallengeResponseMessage.bPu().aCn + "";
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() != 0) {
                if (this.gqd != null) {
                    this.gqd.aK(alaStartDirectChallengeResponseMessage.getError(), alaStartDirectChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, alaStartDirectChallengeResponseMessage, base64, str);
                return;
            }
            if (alaStartDirectChallengeResponseMessage != null && alaStartDirectChallengeResponseMessage.getError() == 0 && alaStartDirectChallengeResponseMessage.bPu() != null && (alaStartDirectChallengeResponseMessage.bPu().isValid() || alaStartDirectChallengeResponseMessage.bPu().isTimeout())) {
                com.baidu.live.challenge.a bPu = alaStartDirectChallengeResponseMessage.bPu();
                this.gqd.b(bPu);
                bPL();
                if (bPu.BD()) {
                    ed(bPu.challengeId);
                    this.gra = bPu.challengeId;
                }
                if (alaStartDirectChallengeResponseMessage.bPu().isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_TIMEOUT, alaStartDirectChallengeResponseMessage, base64, (String) null);
                }
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT_SUCC, alaStartDirectChallengeResponseMessage, base64, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelDirectChallengeResponseMessage alaCancelDirectChallengeResponseMessage) {
        if (this.gqd != null && alaCancelDirectChallengeResponseMessage != null) {
            if (alaCancelDirectChallengeResponseMessage.hasError() || alaCancelDirectChallengeResponseMessage.getError() != 0) {
                this.gqd.aL(alaCancelDirectChallengeResponseMessage.getError(), alaCancelDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.grb)), (String) null);
                return;
            }
            boolean bPw = alaCancelDirectChallengeResponseMessage.bPw();
            com.baidu.live.challenge.a bPu = alaCancelDirectChallengeResponseMessage.bPu();
            this.gqd.b(bPw, alaCancelDirectChallengeResponseMessage.bPu());
            bPL();
            if (!bPw && bPu != null && bPu.BD()) {
                ed(bPu.challengeId);
                this.gra = bPu.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_DIRECT_SUCC, alaCancelDirectChallengeResponseMessage, ExtraParamsManager.getBase64(String.valueOf(this.grb)), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetDirectChallengeListResponseMessage alaGetDirectChallengeListResponseMessage) {
        if (this.gqd != null && alaGetDirectChallengeListResponseMessage != null) {
            if (alaGetDirectChallengeListResponseMessage.hasError() || alaGetDirectChallengeListResponseMessage.getError() != 0) {
                this.gqd.aM(alaGetDirectChallengeListResponseMessage.getError(), alaGetDirectChallengeListResponseMessage.getErrorString());
            } else {
                this.gqd.l(alaGetDirectChallengeListResponseMessage.getCount(), alaGetDirectChallengeListResponseMessage.bPE());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAcceptDirectChallengeResponseMessage alaAcceptDirectChallengeResponseMessage) {
        if (this.gqd != null && alaAcceptDirectChallengeResponseMessage != null) {
            String str = "";
            String str2 = "";
            if (alaAcceptDirectChallengeResponseMessage.bPu() != null) {
                str2 = ExtraParamsManager.getBase64(String.valueOf(alaAcceptDirectChallengeResponseMessage.bPu().aCp));
            }
            if (alaAcceptDirectChallengeResponseMessage.bPu() != null) {
                str = alaAcceptDirectChallengeResponseMessage.bPu().aCn + "";
            }
            if (alaAcceptDirectChallengeResponseMessage.hasError() || alaAcceptDirectChallengeResponseMessage.getError() != 0) {
                this.gqd.aN(alaAcceptDirectChallengeResponseMessage.getError(), alaAcceptDirectChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, alaAcceptDirectChallengeResponseMessage, str2, str);
                return;
            }
            boolean bPv = alaAcceptDirectChallengeResponseMessage.bPv();
            com.baidu.live.challenge.a bPu = alaAcceptDirectChallengeResponseMessage.bPu();
            this.gqd.c(bPv, bPu);
            if (bPv && bPu != null) {
                ed(bPu.challengeId);
                this.gra = bPu.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET_SUCC, alaAcceptDirectChallengeResponseMessage, str2, str);
        }
    }

    private void bPM() {
        this.grj = false;
        MessageManager.getInstance().removeMessage(1021110, this.beX);
        this.mHandler.removeCallbacks(this.gro);
        this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(boolean z) {
        this.grj = true;
        HttpMessage httpMessage = new HttpMessage(1021110);
        if (z) {
            httpMessage.addParam("type", "start");
        }
        httpMessage.setTag(this.beX);
        MessageManager.getInstance().sendMessage(httpMessage);
        ec(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaStartRandomChallengeResponseMessage alaStartRandomChallengeResponseMessage) {
        String str;
        String str2;
        boolean z = false;
        if (this.gqd != null) {
            this.grj = false;
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() != 0) {
                if (this.gqd != null) {
                    this.gqd.aO(alaStartRandomChallengeResponseMessage.getError(), alaStartRandomChallengeResponseMessage.getErrorString());
                }
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, (String) null, (String) null);
                return;
            }
            if (alaStartRandomChallengeResponseMessage == null || alaStartRandomChallengeResponseMessage.bPu() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = alaStartRandomChallengeResponseMessage.bPu().aCn + "";
                str = ExtraParamsManager.getBase64(alaStartRandomChallengeResponseMessage.bPu().aCp + "");
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.getError() == 0 && alaStartRandomChallengeResponseMessage.bPu() != null && alaStartRandomChallengeResponseMessage.bPu().isValid()) {
                com.baidu.live.challenge.a bPu = alaStartRandomChallengeResponseMessage.bPu();
                this.gqd.c(bPu);
                if (bPu.BD() && !BQ()) {
                    bPM();
                    ed(bPu.challengeId);
                    this.gra = bPu.challengeId;
                } else {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM, alaStartRandomChallengeResponseMessage, str, str2);
                }
                if (bPu.isTimeout()) {
                    a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOW_TIMEOUT, alaStartRandomChallengeResponseMessage, str, (String) null);
                }
            }
            if (alaStartRandomChallengeResponseMessage != null && alaStartRandomChallengeResponseMessage.bPu() != null && alaStartRandomChallengeResponseMessage.bPu().isValid()) {
                z = true;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_RANDOM_SUCC, alaStartRandomChallengeResponseMessage, str, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaCancelRandomChallengeResponseMessage alaCancelRandomChallengeResponseMessage) {
        String str;
        String str2 = null;
        if (this.gqd != null && alaCancelRandomChallengeResponseMessage != null) {
            if (alaCancelRandomChallengeResponseMessage == null || alaCancelRandomChallengeResponseMessage.bPu() == null) {
                str = null;
            } else {
                str = alaCancelRandomChallengeResponseMessage.bPu().challengeId + "";
                str2 = alaCancelRandomChallengeResponseMessage.bPu().aCn + "";
            }
            if (alaCancelRandomChallengeResponseMessage.hasError() || alaCancelRandomChallengeResponseMessage.getError() != 0) {
                this.gqd.aP(alaCancelRandomChallengeResponseMessage.getError(), alaCancelRandomChallengeResponseMessage.getErrorString());
                a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCEL_RANDOM, alaCancelRandomChallengeResponseMessage, str, str2);
                return;
            }
            boolean bPw = alaCancelRandomChallengeResponseMessage.bPw();
            com.baidu.live.challenge.a bPu = alaCancelRandomChallengeResponseMessage.bPu();
            this.gqd.d(bPw, alaCancelRandomChallengeResponseMessage.bPu());
            bPM();
            if (!bPw && bPu != null && bPu.BD()) {
                ed(bPu.challengeId);
                this.gra = bPu.challengeId;
            }
            a(UbcStatConstant.ContentType.UBC_TYPE_PK_CANCLE_RANDOM_SUCC, alaCancelRandomChallengeResponseMessage, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSurrenderResponseMessage alaSurrenderResponseMessage) {
        if (this.gqd != null && alaSurrenderResponseMessage != null) {
            this.gqd.n(!alaSurrenderResponseMessage.hasError() && alaSurrenderResponseMessage.getError() == 0, alaSurrenderResponseMessage.getErrorString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetTargetInfoResponseMessage alaGetTargetInfoResponseMessage) {
        if (this.gqd != null && alaGetTargetInfoResponseMessage != null) {
            if (alaGetTargetInfoResponseMessage.hasError() || alaGetTargetInfoResponseMessage.getError() != 0) {
                this.gqd.j(alaGetTargetInfoResponseMessage.getError(), alaGetTargetInfoResponseMessage.getErrorString());
            } else {
                this.gqd.a(alaGetTargetInfoResponseMessage.bPF());
            }
        }
    }

    public void bf(boolean z) {
        this.brp = z ? 1 : 2;
    }

    public void ed(long j) {
        this.gre = true;
        this.gra = j;
        this.mHandler.post(this.grp);
    }

    private void bPN() {
        this.gre = false;
        this.mHandler.removeCallbacks(this.grp);
        this.gri = false;
        MessageManager.getInstance().removeMessage(1021112, this.beX);
    }

    public void bPO() {
        this.mHandler.removeCallbacks(this.grp);
        this.gri = false;
        MessageManager.getInstance().removeMessage(1021112, this.beX);
    }

    public void bPP() {
        this.mHandler.post(this.grp);
    }

    private void a(ap apVar, at atVar, at atVar2, long j) {
        if (apVar == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info challenge meta is null?? logid=" + j);
        } else if (atVar != null && atVar.aIG != null && atVar.aIG.getLiveID() != this.fvG) {
            BdLog.e("CHALLENGE_TAG in challenge not current live?? ||Challenge id=" + apVar.challengeId + "||Challenge Status=" + apVar.aIp + "||Net liveId=" + atVar.aIG.getLiveID() + "||cur liveId=" + this.fvG + "||logid=" + j);
        } else {
            int i = apVar.aIp;
            this.gqd.b(i, apVar, atVar, atVar2);
            switch (i) {
                case 2:
                    this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
                    bPI();
                    break;
                case 3:
                    this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
                    break;
                case 4:
                case 5:
                    this.grg = ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL;
                    this.gra = 0L;
                    bPJ();
                    break;
            }
            if (atVar != null && atVar.aIn != null) {
                this.grc = atVar.aIn.userId;
            }
            if (atVar2 != null && atVar2.aIn != null) {
                this.grd = atVar2.aIn.userId;
            }
            if (4 == apVar.aIp || 5 == apVar.aIp) {
                bPN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetChallengeInfoResponseMessage alaGetChallengeInfoResponseMessage) {
        if (this.gqd == null || alaGetChallengeInfoResponseMessage == null || alaGetChallengeInfoResponseMessage.bPy() == null) {
            BdLog.e("CHALLENGE_TAG get Challenge Info callback, response message, meta info  null?? ");
            if (alaGetChallengeInfoResponseMessage != null) {
                BdLog.e("CHALLENGE_TAG get Challenge Info error=" + alaGetChallengeInfoResponseMessage.getError());
                return;
            }
            return;
        }
        ap bPy = alaGetChallengeInfoResponseMessage.bPy();
        at bPz = alaGetChallengeInfoResponseMessage.bPz();
        at bPA = alaGetChallengeInfoResponseMessage.bPA();
        al bPB = alaGetChallengeInfoResponseMessage.bPB();
        ar bPC = alaGetChallengeInfoResponseMessage.bPC();
        as bPD = alaGetChallengeInfoResponseMessage.bPD();
        if (bPB != null && bPB.aIj > 0 && this.gqZ != bPB.aIj) {
            this.gqZ = bPB.aIj;
        }
        a(bPy, bPz, bPA, alaGetChallengeInfoResponseMessage.getLogId());
        int i = 0;
        if (com.baidu.live.w.a.Nk().beJ != null) {
            i = com.baidu.live.w.a.Nk().beJ.aGx;
        }
        if (i == 1 && bPy != null && bPz != null && bPz.aIG != null && bPz.aIG.user_id == TbadkCoreApplication.getCurrentAccountId()) {
            if (this.grl == null) {
                this.grl = new HashMap();
            }
            long j = bPy.challengeId;
            if (bPD != null && bPD.aIF != null && !bPD.aIF.isEmpty() && (!this.grl.containsKey(Long.valueOf(j)) || this.grl.get(Long.valueOf(j)).isEmpty())) {
                this.grl.put(Long.valueOf(j), bPD.aIF);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913209, bPD.aIF));
            }
            if (bPC != null && bPy.aIp >= 3 && bPy.challengeResult == 2) {
                if ((bPC.type == 1 || bPC.type == 3) && !TextUtils.isEmpty(bPC.aID)) {
                    if (this.grm == null) {
                        this.grm = new HashMap();
                    }
                    if (!this.grm.containsKey(Long.valueOf(j))) {
                        this.grm.put(Long.valueOf(j), 0);
                    }
                    if (bPy.aIp == 3) {
                        int intValue = this.grm.get(Long.valueOf(j)).intValue();
                        if (bPC.serverTime >= bPC.startTime && bPC.serverTime <= bPC.endTime) {
                            if (intValue < 1) {
                                this.grm.put(Long.valueOf(j), 1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913210, bPC.aID));
                            }
                        } else if (bPC.serverTime > bPC.endTime && intValue < 2) {
                            this.grm.put(Long.valueOf(j), 2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                        }
                    } else if (bPy.aIp > 3) {
                        this.grm.put(Long.valueOf(j), 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913211));
                    }
                }
            }
        }
    }

    public ChallenfeInfoData.ChallengeStatus BP() {
        return this.grg;
    }

    private void ec(String str, String str2) {
        if (this.isHost) {
            UbcStatisticManager.getInstance().logSendRequest(v(str, str2, null, UbcStatisticLiveKey.KEY_ID_PK_REQ));
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(v(str, str2, str3, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
        }
    }

    private void a(String str, HttpResponsedMessage httpResponsedMessage, String str2, String str3, boolean z) {
        if (this.isHost && httpResponsedMessage != null) {
            UbcStatisticManager.getInstance().logSendResponse(a(str, str2, str3, z, UbcStatisticLiveKey.KEY_ID_PK_RESP), httpResponsedMessage, true);
        }
    }

    private UbcStatisticItem a(String str, String str2, String str3, boolean z, String str4) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str4, str, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (str2 != null) {
            try {
                jSONObject2.put("rival_uk", str2);
            } catch (JSONException e) {
            }
        }
        if (str3 != null) {
            jSONObject2.put("status", str3);
        }
        jSONObject2.put("is_matched", z);
        jSONObject.put("pk", jSONObject2);
        ubcStatisticItem.setContentExt(jSONObject);
        return ubcStatisticItem;
    }

    private UbcStatisticItem v(String str, String str2, String str3, String str4) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str4, str, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (str2 != null) {
            try {
                jSONObject2.put("rival_uk", str2);
            } catch (JSONException e) {
            }
        }
        if (str3 != null) {
            jSONObject2.put("status", str3);
        }
        jSONObject.put("pk", jSONObject2);
        ubcStatisticItem.setContentExt(jSONObject);
        return ubcStatisticItem;
    }

    public boolean BQ() {
        return this.gre;
    }
}
