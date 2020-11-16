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
    private w aDh;
    private ViewGroup bIc;
    protected Context context;
    private com.baidu.live.guardclub.l gEB;
    protected com.baidu.tieba.ala.guardclub.view.b gEC;
    private com.baidu.live.guardclub.a gED;
    private com.baidu.tieba.ala.guardclub.view.a gEE;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gwg = BdUniqueId.gen();
    private boolean beO = false;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aDh != null && a.this.aDh.aHk != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.GO("");
            }
        }
    };
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener gEF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDh != null && a.this.aDh.aHk != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.beL != null && guardClubInfoHttpResponseMessage.beL.anchorId == a.this.aDh.aHk.userId) {
                    a.this.gED = guardClubInfoHttpResponseMessage.beL;
                    a.this.beO = guardClubInfoHttpResponseMessage.beO;
                    if (a.this.gEC != null) {
                        a.this.gEC.b(a.this.beO, guardClubInfoHttpResponseMessage.beR);
                    }
                    if (a.this.beO) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).JS()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.beL.id), guardClubInfoHttpResponseMessage.beS, guardClubInfoHttpResponseMessage.beR, guardClubInfoHttpResponseMessage.beM);
                    }
                }
            }
        }
    };
    CustomMessageListener gEG = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.GO((String) customResponsedMessage.getData());
            } else {
                a.this.GO("");
            }
        }
    };
    CustomMessageListener gEH = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bSo();
        }
    };
    HttpMessageListener gEI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.gED != null && a.this.gED.id == guardClubJoinHttpResponseMessage.beT) {
                        a.this.bSp();
                    }
                } else if (!guardClubJoinHttpResponseMessage.beW) {
                    guardClubJoinHttpResponseMessage.beW = true;
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
        MessageManager.getInstance().registerListener(this.guV);
        MessageManager.getInstance().registerListener(this.gEF);
        MessageManager.getInstance().registerListener(this.gEG);
        MessageManager.getInstance().registerListener(this.gEH);
        MessageManager.getInstance().registerListener(this.gEI);
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gEC == null) {
            this.gEC = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.fhp);
        }
        if (this.bIc != null && this.bIc.indexOfChild(this.gEC.getView()) >= 0) {
            this.bIc.removeView(this.gEC.getView());
        }
        this.bIc = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gEB = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar != null && bnVar.aNP != null && bnVar.aNP.aQf) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ak(viewGroup)) {
                this.aDh = wVar;
                this.gED = null;
                this.gEC.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Ka() {
        this.gED = null;
        if (this.gEE != null) {
            this.gEE.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.guV);
        MessageManager.getInstance().unRegisterListener(this.gEF);
        MessageManager.getInstance().unRegisterListener(this.gEG);
        MessageManager.getInstance().unRegisterListener(this.gEH);
        MessageManager.getInstance().unRegisterListener(this.gEI);
        if (this.gEC != null) {
            this.gEC.onDestroy();
        }
        if (this.gEE != null) {
            this.gEE.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO(String str) {
        if (this.context != null && this.aDh != null && this.aDh.aHk != null && this.aDh.mLiveInfo != null) {
            long j = this.aDh.aHk.userId;
            long j2 = this.aDh.mLiveInfo.live_id;
            long j3 = this.aDh.mLiveInfo.room_id;
            String str2 = this.aDh.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aDh.aHk.nickName, this.aDh.aHk.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.beO);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bSn();
        } else if (fVar.bfd > 0) {
            em(str, str2);
        }
    }

    private void bSn() {
        this.gEE = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gEE.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0647a
            public void onConfirm() {
                if (a.this.bSo()) {
                    a.this.gEE.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0647a
            public void onCancel() {
                a.this.gEE.dismiss();
            }
        });
        bf JY = com.baidu.live.guardclub.g.JW().JY();
        this.gEE.W(0, JY != null ? JY.aNr : "");
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
        bf JY = com.baidu.live.guardclub.g.JW().JY();
        if (JY != null && JY.aNp > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.Aq().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dB = com.baidu.tieba.ala.guardclub.model.a.dB(jSONArray.optJSONObject(i));
                            if (dB != null && dB.date.equals(b)) {
                                if (dB.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dB);
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
                            com.baidu.live.d.Aq().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.dFf = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dFf >= JY.aNp) {
                        z3 = true;
                    } else {
                        aVar2.dFf++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.gEE = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gEE.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0647a
                    public void onConfirm() {
                        a.this.gEE.dismiss();
                        if (a.this.gEB != null) {
                            a.this.gEB.Kc();
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
                this.gEE.W(1, JY.aNq);
            }
            com.baidu.live.d.Aq().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bSo() {
        long j;
        if (this.gED == null) {
            return false;
        }
        bf JY = com.baidu.live.guardclub.g.JW().JY();
        if (JY == null || JY.aNk <= 0) {
            j = 1000;
        } else {
            j = JY.aNk;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            vf(this.gED.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void vf(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.ew(i);
        cVar.a(this.gED);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bSp() {
        if (this.aDh != null && this.aDh.aHk != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aDh.aHk.userId);
            bVar.setParams();
            bVar.setTag(this.gwg);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
