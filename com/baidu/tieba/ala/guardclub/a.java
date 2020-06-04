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
import com.baidu.live.data.ao;
import com.baidu.live.data.ax;
import com.baidu.live.data.q;
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
    private q aJj;
    protected Context context;
    private ViewGroup foI;
    private com.baidu.live.guardclub.l fwP;
    protected com.baidu.tieba.ala.guardclub.view.b fwQ;
    private com.baidu.live.guardclub.a fwR;
    private com.baidu.tieba.ala.guardclub.view.a fwS;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fpn = BdUniqueId.gen();
    private boolean aOJ = false;
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aJj != null && a.this.aJj.avj != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.BN("");
            }
        }
    };
    CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener fwT = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aJj != null && a.this.aJj.avj != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aOG != null && guardClubInfoHttpResponseMessage.aOG.aul == a.this.aJj.avj.userId) {
                    a.this.fwR = guardClubInfoHttpResponseMessage.aOG;
                    a.this.aOJ = guardClubInfoHttpResponseMessage.aOJ;
                    if (a.this.fwQ != null) {
                        a.this.fwQ.b(a.this.aOJ, guardClubInfoHttpResponseMessage.aOM);
                    }
                    if (a.this.aOJ) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).BD()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aOG.id), guardClubInfoHttpResponseMessage.aON, guardClubInfoHttpResponseMessage.aOM, guardClubInfoHttpResponseMessage.aOH);
                    }
                }
            }
        }
    };
    CustomMessageListener fwU = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.BN((String) customResponsedMessage.getData());
            } else {
                a.this.BN("");
            }
        }
    };
    CustomMessageListener fwV = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.buo();
        }
    };
    HttpMessageListener fwW = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.fwR != null && a.this.fwR.id == guardClubJoinHttpResponseMessage.aOO) {
                        a.this.bup();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aOR) {
                    guardClubJoinHttpResponseMessage.aOR = true;
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
        MessageManager.getInstance().registerListener(this.foe);
        MessageManager.getInstance().registerListener(this.fwT);
        MessageManager.getInstance().registerListener(this.fwU);
        MessageManager.getInstance().registerListener(this.fwV);
        MessageManager.getInstance().registerListener(this.fwW);
    }

    protected boolean af(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fwQ == null) {
            this.fwQ = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.ege);
        }
        if (this.foI != null && this.foI.indexOfChild(this.fwQ.getView()) >= 0) {
            this.foI.removeView(this.fwQ.getView());
        }
        this.foI = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.fwP = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, q qVar) {
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && axVar.aAL != null && axVar.aAL.aCu) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && af(viewGroup)) {
                this.aJj = qVar;
                this.fwR = null;
                this.fwQ.reset();
                viewGroup.addView(this.fwQ.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.fwQ != null && this.fwQ.getView() != null) {
            this.fwQ.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void BL() {
        this.fwR = null;
        if (this.fwS != null) {
            this.fwS.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.foe);
        MessageManager.getInstance().unRegisterListener(this.fwT);
        MessageManager.getInstance().unRegisterListener(this.fwU);
        MessageManager.getInstance().unRegisterListener(this.fwV);
        MessageManager.getInstance().unRegisterListener(this.fwW);
        if (this.fwQ != null) {
            this.fwQ.onDestroy();
        }
        if (this.fwS != null) {
            this.fwS.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(String str) {
        if (this.context != null && this.aJj != null && this.aJj.avj != null && this.aJj.mLiveInfo != null) {
            long j = this.aJj.avj.userId;
            long j2 = this.aJj.mLiveInfo.live_id;
            long j3 = this.aJj.mLiveInfo.room_id;
            String str2 = this.aJj.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aOJ);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bun();
        } else if (fVar.aOY > 0) {
            dC(str, str2);
        }
    }

    private void bun() {
        this.fwS = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.fwS.a(new a.InterfaceC0540a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0540a
            public void onConfirm() {
                if (a.this.buo()) {
                    a.this.fwS.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0540a
            public void onCancel() {
                a.this.fwS.dismiss();
            }
        });
        ao BJ = com.baidu.live.guardclub.g.BH().BJ();
        this.fwS.aE(0, BJ != null ? BJ.aAh : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dC(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ao BJ = com.baidu.live.guardclub.g.BH().BJ();
        if (BJ != null && BJ.aAf > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.uN().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a cN = com.baidu.tieba.ala.guardclub.model.a.cN(jSONArray.optJSONObject(i));
                            if (cN != null && cN.fzE.equals(b)) {
                                if (cN.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(cN);
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
                            com.baidu.live.c.uN().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.fzE = b;
                aVar.fzF = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.fzF >= BJ.aAf) {
                        z3 = true;
                    } else {
                        aVar2.fzF++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.fwS = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.fwS.a(new a.InterfaceC0540a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0540a
                    public void onConfirm() {
                        a.this.fwS.dismiss();
                        if (a.this.fwP != null) {
                            a.this.fwP.BN();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0540a
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
                this.fwS.aE(1, BJ.aAg);
            }
            com.baidu.live.c.uN().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buo() {
        long j;
        if (this.fwR == null) {
            return false;
        }
        ao BJ = com.baidu.live.guardclub.g.BH().BJ();
        if (BJ == null || BJ.aAa <= 0) {
            j = 1000;
        } else {
            j = BJ.aAa;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            qn(this.fwR.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void qn(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.co(i);
        cVar.a(this.fwR);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bup() {
        if (this.aJj != null && this.aJj.avj != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.aJj.avj.userId);
            bVar.setParams();
            bVar.setTag(this.fpn);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.foI == null || this.fwQ == null || this.foI.indexOfChild(this.fwQ.getView()) < 0) ? false : true;
    }
}
