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
    private n aDK;
    protected Context context;
    private ViewGroup faV;
    private com.baidu.live.guardclub.l fiX;
    protected com.baidu.tieba.ala.guardclub.view.b fiY;
    private com.baidu.live.guardclub.a fiZ;
    private com.baidu.tieba.ala.guardclub.view.a fja;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fbA = BdUniqueId.gen();
    private boolean aJa = false;
    private View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aDK != null && a.this.aDK.aqk != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.Ag("");
            }
        }
    };
    CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener fjb = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDK != null && a.this.aDK.aqk != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aIX != null && guardClubInfoHttpResponseMessage.aIX.aps == a.this.aDK.aqk.userId) {
                    a.this.fiZ = guardClubInfoHttpResponseMessage.aIX;
                    a.this.aJa = guardClubInfoHttpResponseMessage.aJa;
                    if (a.this.fiY != null) {
                        a.this.fiY.b(a.this.aJa, guardClubInfoHttpResponseMessage.aJd);
                    }
                    if (a.this.aJa) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).An()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aIX.id), guardClubInfoHttpResponseMessage.aJe, guardClubInfoHttpResponseMessage.aJd, guardClubInfoHttpResponseMessage.aIY);
                    }
                }
            }
        }
    };
    CustomMessageListener fjc = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.Ag((String) customResponsedMessage.getData());
            } else {
                a.this.Ag("");
            }
        }
    };
    CustomMessageListener fjd = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bou();
        }
    };
    HttpMessageListener fje = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.fiZ != null && a.this.fiZ.id == guardClubJoinHttpResponseMessage.aJf) {
                        a.this.bov();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aJi) {
                    guardClubJoinHttpResponseMessage.aJi = true;
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
        MessageManager.getInstance().registerListener(this.faq);
        MessageManager.getInstance().registerListener(this.fjb);
        MessageManager.getInstance().registerListener(this.fjc);
        MessageManager.getInstance().registerListener(this.fjd);
        MessageManager.getInstance().registerListener(this.fje);
    }

    protected boolean Y(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fiY == null) {
            this.fiY = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.dRK);
        }
        if (this.faV != null && this.faV.indexOfChild(this.fiY.getView()) >= 0) {
            this.faV.removeView(this.fiY.getView());
        }
        this.faV = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.fiX = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, n nVar) {
        as asVar = com.baidu.live.v.a.En().aRB;
        if (asVar != null && asVar.avD != null && asVar.avD.axf) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && Y(viewGroup)) {
                this.aDK = nVar;
                this.fiZ = null;
                this.fiY.reset();
                viewGroup.addView(this.fiY.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.fiY != null && this.fiY.getView() != null) {
            this.fiY.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Av() {
        this.fiZ = null;
        if (this.fja != null) {
            this.fja.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.faq);
        MessageManager.getInstance().unRegisterListener(this.fjb);
        MessageManager.getInstance().unRegisterListener(this.fjc);
        MessageManager.getInstance().unRegisterListener(this.fjd);
        MessageManager.getInstance().unRegisterListener(this.fje);
        if (this.fiY != null) {
            this.fiY.onDestroy();
        }
        if (this.fja != null) {
            this.fja.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ag(String str) {
        if (this.context != null && this.aDK != null && this.aDK.aqk != null && this.aDK.mLiveInfo != null) {
            long j = this.aDK.aqk.userId;
            long j2 = this.aDK.mLiveInfo.live_id;
            long j3 = this.aDK.mLiveInfo.room_id;
            String str2 = this.aDK.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aJa);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bot();
        } else if (fVar.aJp > 0) {
            de(str, str2);
        }
    }

    private void bot() {
        this.fja = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.fja.a(new a.InterfaceC0493a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0493a
            public void onConfirm() {
                if (a.this.bou()) {
                    a.this.fja.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0493a
            public void onCancel() {
                a.this.fja.dismiss();
            }
        });
        ak At = com.baidu.live.guardclub.g.Ar().At();
        this.fja.az(0, At != null ? At.avd : "");
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
        ak At = com.baidu.live.guardclub.g.Ar().At();
        if (At != null && At.avb > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.tG().getString("guardclub_attenuat_daily", "");
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
                            com.baidu.live.c.tG().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.flN = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.flN >= At.avb) {
                        z3 = true;
                    } else {
                        aVar2.flN++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.fja = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.fja.a(new a.InterfaceC0493a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0493a
                    public void onConfirm() {
                        a.this.fja.dismiss();
                        if (a.this.fiX != null) {
                            a.this.fiX.Ax();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0493a
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
                this.fja.az(1, At.avc);
            }
            com.baidu.live.c.tG().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bou() {
        long j;
        if (this.fiZ == null) {
            return false;
        }
        ak At = com.baidu.live.guardclub.g.Ar().At();
        if (At == null || At.auW <= 0) {
            j = 1000;
        } else {
            j = At.auW;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            pK(this.fiZ.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void pK(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cf(i);
        cVar.a(this.fiZ);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bov() {
        if (this.aDK != null && this.aDK.aqk != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ab(this.aDK.aqk.userId);
            bVar.setParams();
            bVar.setTag(this.fbA);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.faV == null || this.fiY == null || this.faV.indexOfChild(this.fiY.getView()) < 0) ? false : true;
    }
}
