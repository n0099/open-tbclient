package com.baidu.tieba.ala.guardclub;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bf;
import com.baidu.live.data.bn;
import com.baidu.live.data.w;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.guardclub.view.a;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.guardclub.h {
    private w aES;
    private ViewGroup bJN;
    protected Context context;
    private com.baidu.live.guardclub.l gEU;
    protected com.baidu.tieba.ala.guardclub.view.b gEV;
    private com.baidu.live.guardclub.a gEW;
    private com.baidu.tieba.ala.guardclub.view.a gEX;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gwz = BdUniqueId.gen();
    private boolean bgC = false;
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aES != null && a.this.aES.aIV != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.Hn("");
            }
        }
    };
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                a.this.otherParams = str;
            }
        }
    };
    private HttpMessageListener gEY = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aES != null && a.this.aES.aIV != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bgz != null && guardClubInfoHttpResponseMessage.bgz.anchorId == a.this.aES.aIV.userId) {
                    a.this.gEW = guardClubInfoHttpResponseMessage.bgz;
                    a.this.bgC = guardClubInfoHttpResponseMessage.bgC;
                    if (a.this.gEV != null) {
                        a.this.gEV.b(a.this.bgC, guardClubInfoHttpResponseMessage.bgF);
                    }
                    if (a.this.bgC) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).KB()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bgz.id), guardClubInfoHttpResponseMessage.bgG, guardClubInfoHttpResponseMessage.bgF, guardClubInfoHttpResponseMessage.bgA);
                    }
                }
            }
        }
    };
    CustomMessageListener gEZ = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.Hn((String) customResponsedMessage.getData());
            } else {
                a.this.Hn("");
            }
        }
    };
    CustomMessageListener gFa = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bSV();
        }
    };
    HttpMessageListener gFb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135) {
                if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (!TextUtils.isEmpty(errorString)) {
                        BdUtilHelper.getCustomToast().showToast(errorString, 0);
                        return;
                    }
                    return;
                }
                GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (a.this.gEW != null && a.this.gEW.id == guardClubJoinHttpResponseMessage.bgH) {
                        a.this.bSW();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bgK) {
                    guardClubJoinHttpResponseMessage.bgK = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        MessageManager.getInstance().registerListener(this.gvo);
        MessageManager.getInstance().registerListener(this.gEY);
        MessageManager.getInstance().registerListener(this.gEZ);
        MessageManager.getInstance().registerListener(this.gFa);
        MessageManager.getInstance().registerListener(this.gFb);
    }

    protected boolean ao(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gEV == null) {
            this.gEV = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.fii);
        }
        if (this.bJN != null && this.bJN.indexOfChild(this.gEV.getView()) >= 0) {
            this.bJN.removeView(this.gEV.getView());
        }
        this.bJN = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gEU = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && bnVar.aPA != null && bnVar.aPA.aRQ) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ao(viewGroup)) {
                this.aES = wVar;
                this.gEW = null;
                this.gEV.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void KJ() {
        this.gEW = null;
        if (this.gEX != null) {
            this.gEX.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gvo);
        MessageManager.getInstance().unRegisterListener(this.gEY);
        MessageManager.getInstance().unRegisterListener(this.gEZ);
        MessageManager.getInstance().unRegisterListener(this.gFa);
        MessageManager.getInstance().unRegisterListener(this.gFb);
        if (this.gEV != null) {
            this.gEV.onDestroy();
        }
        if (this.gEX != null) {
            this.gEX.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn(String str) {
        if (this.context != null && this.aES != null && this.aES.aIV != null && this.aES.mLiveInfo != null) {
            long j = this.aES.aIV.userId;
            long j2 = this.aES.mLiveInfo.live_id;
            long j3 = this.aES.mLiveInfo.room_id;
            String str2 = this.aES.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aES.aIV.nickName, this.aES.aIV.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bgC);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bSU();
        } else if (fVar.bgQ > 0) {
            em(str, str2);
        }
    }

    private void bSU() {
        this.gEX = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gEX.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0647a
            public void onConfirm() {
                if (a.this.bSV()) {
                    a.this.gEX.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0647a
            public void onCancel() {
                a.this.gEX.dismiss();
            }
        });
        bf KH = com.baidu.live.guardclub.g.KF().KH();
        this.gEX.W(0, KH != null ? KH.aPc : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void em(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        bf KH = com.baidu.live.guardclub.g.KF().KH();
        if (KH != null && KH.aPa > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.AZ().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dH = com.baidu.tieba.ala.guardclub.model.a.dH(jSONArray.optJSONObject(i));
                            if (dH != null && dH.date.equals(b)) {
                                if (dH.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dH);
                            }
                        } catch (JSONException e) {
                            z = z2;
                            e = e;
                            e.printStackTrace();
                            z2 = z;
                            if (!z2) {
                            }
                            JSONArray jSONArray2 = new JSONArray();
                            while (r5.hasNext()) {
                            }
                            if (!z3) {
                            }
                            com.baidu.live.d.AZ().putString("guardclub_attenuat_daily", jSONArray2.toString());
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    z = false;
                }
            }
            if (!z2) {
                com.baidu.tieba.ala.guardclub.model.a aVar = new com.baidu.tieba.ala.guardclub.model.a();
                aVar.id = str;
                aVar.date = b;
                aVar.dGM = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dGM >= KH.aPa) {
                        z3 = true;
                    } else {
                        aVar2.dGM++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.gEX = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gEX.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0647a
                    public void onConfirm() {
                        a.this.gEX.dismiss();
                        if (a.this.gEU != null) {
                            a.this.gEU.KL();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0647a
                    public void onCancel() {
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb = new StringBuilder(str2);
                            if (str2.contains("?")) {
                                sb.append(ETAG.ITEM_SEPARATOR);
                            } else {
                                sb.append("?");
                            }
                            sb.append("source=2");
                            BrowserHelper.startInternalWebActivity(a.this.context, sb.toString());
                        }
                    }
                });
                this.gEX.W(1, KH.aPb);
            }
            com.baidu.live.d.AZ().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bSV() {
        long j;
        if (this.gEW == null) {
            return false;
        }
        bf KH = com.baidu.live.guardclub.g.KF().KH();
        if (KH == null || KH.aOV <= 0) {
            j = 1000;
        } else {
            j = KH.aOV;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            uH(this.gEW.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void uH(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eA(i);
        cVar.a(this.gEW);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bSW() {
        if (this.aES != null && this.aES.aIV != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aES.aIV.userId);
            bVar.setParams();
            bVar.setTag(this.gwz);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
