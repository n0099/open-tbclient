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
import com.baidu.live.data.ak;
import com.baidu.live.data.as;
import com.baidu.live.data.n;
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
    private n aDE;
    protected Context context;
    private ViewGroup faQ;
    private com.baidu.live.guardclub.l fiS;
    protected com.baidu.tieba.ala.guardclub.view.b fiT;
    private com.baidu.live.guardclub.a fiU;
    private com.baidu.tieba.ala.guardclub.view.a fiV;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fbv = BdUniqueId.gen();
    private boolean aIU = false;
    private View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aDE != null && a.this.aDE.aqe != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.Ad("");
            }
        }
    };
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener fiW = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDE != null && a.this.aDE.aqe != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aIR != null && guardClubInfoHttpResponseMessage.aIR.apl == a.this.aDE.aqe.userId) {
                    a.this.fiU = guardClubInfoHttpResponseMessage.aIR;
                    a.this.aIU = guardClubInfoHttpResponseMessage.aIU;
                    if (a.this.fiT != null) {
                        a.this.fiT.b(a.this.aIU, guardClubInfoHttpResponseMessage.aIX);
                    }
                    if (a.this.aIU) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).Ao()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aIR.id), guardClubInfoHttpResponseMessage.aIY, guardClubInfoHttpResponseMessage.aIX, guardClubInfoHttpResponseMessage.aIS);
                    }
                }
            }
        }
    };
    CustomMessageListener fiX = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.Ad((String) customResponsedMessage.getData());
            } else {
                a.this.Ad("");
            }
        }
    };
    CustomMessageListener fiY = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bow();
        }
    };
    HttpMessageListener fiZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.fiU != null && a.this.fiU.id == guardClubJoinHttpResponseMessage.aIZ) {
                        a.this.box();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aJc) {
                    guardClubJoinHttpResponseMessage.aJc = true;
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
        MessageManager.getInstance().registerListener(this.fal);
        MessageManager.getInstance().registerListener(this.fiW);
        MessageManager.getInstance().registerListener(this.fiX);
        MessageManager.getInstance().registerListener(this.fiY);
        MessageManager.getInstance().registerListener(this.fiZ);
    }

    protected boolean Y(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fiT == null) {
            this.fiT = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.dRF);
        }
        if (this.faQ != null && this.faQ.indexOfChild(this.fiT.getView()) >= 0) {
            this.faQ.removeView(this.fiT.getView());
        }
        this.faQ = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.fiS = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, n nVar) {
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (asVar != null && asVar.avx != null && asVar.avx.awZ) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && Y(viewGroup)) {
                this.aDE = nVar;
                this.fiU = null;
                this.fiT.reset();
                viewGroup.addView(this.fiT.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.fiT != null && this.fiT.getView() != null) {
            this.fiT.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Aw() {
        this.fiU = null;
        if (this.fiV != null) {
            this.fiV.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fal);
        MessageManager.getInstance().unRegisterListener(this.fiW);
        MessageManager.getInstance().unRegisterListener(this.fiX);
        MessageManager.getInstance().unRegisterListener(this.fiY);
        MessageManager.getInstance().unRegisterListener(this.fiZ);
        if (this.fiT != null) {
            this.fiT.onDestroy();
        }
        if (this.fiV != null) {
            this.fiV.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ad(String str) {
        if (this.context != null && this.aDE != null && this.aDE.aqe != null && this.aDE.mLiveInfo != null) {
            long j = this.aDE.aqe.userId;
            long j2 = this.aDE.mLiveInfo.live_id;
            long j3 = this.aDE.mLiveInfo.room_id;
            String str2 = this.aDE.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aIU);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bov();
        } else if (fVar.aJj > 0) {
            de(str, str2);
        }
    }

    private void bov() {
        this.fiV = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.fiV.a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0472a
            public void onConfirm() {
                if (a.this.bow()) {
                    a.this.fiV.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0472a
            public void onCancel() {
                a.this.fiV.dismiss();
            }
        });
        ak Au = com.baidu.live.guardclub.g.As().Au();
        this.fiV.az(0, Au != null ? Au.auX : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void de(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ak Au = com.baidu.live.guardclub.g.As().Au();
        if (Au != null && Au.auV > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.tH().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a cG = com.baidu.tieba.ala.guardclub.model.a.cG(jSONArray.optJSONObject(i));
                            if (cG != null && cG.date.equals(b)) {
                                if (cG.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(cG);
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
                            com.baidu.live.c.tH().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.flI = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.flI >= Au.auV) {
                        z3 = true;
                    } else {
                        aVar2.flI++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.fiV = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.fiV.a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0472a
                    public void onConfirm() {
                        a.this.fiV.dismiss();
                        if (a.this.fiS != null) {
                            a.this.fiS.Ay();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0472a
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
                this.fiV.az(1, Au.auW);
            }
            com.baidu.live.c.tH().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bow() {
        long j;
        if (this.fiU == null) {
            return false;
        }
        ak Au = com.baidu.live.guardclub.g.As().Au();
        if (Au == null || Au.auQ <= 0) {
            j = 1000;
        } else {
            j = Au.auQ;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            pK(this.fiU.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void pK(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cf(i);
        cVar.a(this.fiU);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void box() {
        if (this.aDE != null && this.aDE.aqe != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ab(this.aDE.aqe.userId);
            bVar.setParams();
            bVar.setTag(this.fbv);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.faQ == null || this.fiT == null || this.faQ.indexOfChild(this.fiT.getView()) < 0) ? false : true;
    }
}
