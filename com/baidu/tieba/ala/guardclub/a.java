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
import com.baidu.live.data.ah;
import com.baidu.live.data.ap;
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
/* loaded from: classes3.dex */
public class a implements com.baidu.live.guardclub.h {
    private com.baidu.live.data.m ald;
    protected Context context;
    private com.baidu.live.guardclub.l eDO;
    protected com.baidu.tieba.ala.guardclub.view.b eDP;
    private com.baidu.live.guardclub.a eDQ;
    private com.baidu.tieba.ala.guardclub.view.a eDR;
    private ViewGroup ewe;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId ewI = BdUniqueId.gen();
    private boolean aqa = false;
    private View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ald != null && a.this.ald.XQ != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.yt("");
            }
        }
    };
    CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener eDS = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.ald != null && a.this.ald.XQ != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.apX != null && guardClubInfoHttpResponseMessage.apX.WZ == a.this.ald.XQ.userId) {
                    a.this.eDQ = guardClubInfoHttpResponseMessage.apX;
                    a.this.aqa = guardClubInfoHttpResponseMessage.aqa;
                    if (a.this.eDP != null) {
                        a.this.eDP.b(a.this.aqa, guardClubInfoHttpResponseMessage.aqd);
                    }
                    if (a.this.aqa) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).vD()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.apX.id), guardClubInfoHttpResponseMessage.aqe, guardClubInfoHttpResponseMessage.aqd, guardClubInfoHttpResponseMessage.apY);
                    }
                }
            }
        }
    };
    CustomMessageListener eDT = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.yt((String) customResponsedMessage.getData());
            } else {
                a.this.yt("");
            }
        }
    };
    CustomMessageListener eDU = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bfa();
        }
    };
    HttpMessageListener eDV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.eDQ != null && a.this.eDQ.id == guardClubJoinHttpResponseMessage.aqf) {
                        a.this.bfb();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aqi) {
                    guardClubJoinHttpResponseMessage.aqi = true;
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
        MessageManager.getInstance().registerListener(this.evL);
        MessageManager.getInstance().registerListener(this.eDS);
        MessageManager.getInstance().registerListener(this.eDT);
        MessageManager.getInstance().registerListener(this.eDU);
        MessageManager.getInstance().registerListener(this.eDV);
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eDP == null) {
            this.eDP = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.dri);
        }
        if (this.ewe != null && this.ewe.indexOfChild(this.eDP.getView()) >= 0) {
            this.ewe.removeView(this.eDP.getView());
        }
        this.ewe = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.eDO = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.baidu.live.data.m mVar) {
        ap apVar = com.baidu.live.v.a.zl().axC;
        if (apVar != null && apVar.acV != null && apVar.acV.aez) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && X(viewGroup)) {
                this.ald = mVar;
                this.eDQ = null;
                this.eDP.reset();
                viewGroup.addView(this.eDP.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.eDP != null && this.eDP.getView() != null) {
            this.eDP.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void vL() {
        this.eDQ = null;
        if (this.eDR != null) {
            this.eDR.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.evL);
        MessageManager.getInstance().unRegisterListener(this.eDS);
        MessageManager.getInstance().unRegisterListener(this.eDT);
        MessageManager.getInstance().unRegisterListener(this.eDU);
        MessageManager.getInstance().unRegisterListener(this.eDV);
        if (this.eDP != null) {
            this.eDP.onDestroy();
        }
        if (this.eDR != null) {
            this.eDR.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(String str) {
        if (this.context != null && this.ald != null && this.ald.XQ != null && this.ald.mLiveInfo != null) {
            long j = this.ald.XQ.userId;
            long j2 = this.ald.mLiveInfo.live_id;
            long j3 = this.ald.mLiveInfo.room_id;
            String str2 = this.ald.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aqa);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            beZ();
        } else if (fVar.aqp > 0) {
            cR(str, str2);
        }
    }

    private void beZ() {
        this.eDR = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.eDR.a(new a.InterfaceC0437a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0437a
            public void onConfirm() {
                if (a.this.bfa()) {
                    a.this.eDR.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0437a
            public void onCancel() {
                a.this.eDR.dismiss();
            }
        });
        ah vJ = com.baidu.live.guardclub.g.vH().vJ();
        this.eDR.ak(0, vJ != null ? vJ.acs : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cR(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ah vJ = com.baidu.live.guardclub.g.vH().vJ();
        if (vJ != null && vJ.acq > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.pr().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a cv = com.baidu.tieba.ala.guardclub.model.a.cv(jSONArray.optJSONObject(i));
                            if (cv != null && cv.date.equals(b)) {
                                if (cv.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(cv);
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
                            com.baidu.live.c.pr().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.eGI = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.eGI >= vJ.acq) {
                        z3 = true;
                    } else {
                        aVar2.eGI++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.eDR = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.eDR.a(new a.InterfaceC0437a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0437a
                    public void onConfirm() {
                        a.this.eDR.dismiss();
                        if (a.this.eDO != null) {
                            a.this.eDO.vN();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0437a
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
                this.eDR.ak(1, vJ.acr);
            }
            com.baidu.live.c.pr().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfa() {
        long j;
        if (this.eDQ == null) {
            return false;
        }
        ah vJ = com.baidu.live.guardclub.g.vH().vJ();
        if (vJ == null || vJ.acj <= 0) {
            j = 1000;
        } else {
            j = vJ.acj;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            po(this.eDQ.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void po(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.bQ(i);
        cVar.a(this.eDQ);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bfb() {
        if (this.ald != null && this.ald.XQ != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.D(this.ald.XQ.userId);
            bVar.setParams();
            bVar.setTag(this.ewI);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
