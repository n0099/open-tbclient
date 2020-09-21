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
import com.baidu.live.data.ba;
import com.baidu.live.data.u;
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
    private u aAP;
    protected Context context;
    private com.baidu.live.guardclub.l gcK;
    protected com.baidu.tieba.ala.guardclub.view.b gcL;
    private ViewGroup gcM;
    private com.baidu.live.guardclub.a gcN;
    private com.baidu.tieba.ala.guardclub.view.a gcO;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fUp = BdUniqueId.gen();
    private boolean baw = false;
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aAP != null && a.this.aAP.aEz != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.FR("");
            }
        }
    };
    CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener gcP = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aAP != null && a.this.aAP.aEz != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bat != null && guardClubInfoHttpResponseMessage.bat.aDf == a.this.aAP.aEz.userId) {
                    a.this.gcN = guardClubInfoHttpResponseMessage.bat;
                    a.this.baw = guardClubInfoHttpResponseMessage.baw;
                    if (a.this.gcL != null) {
                        a.this.gcL.b(a.this.baw, guardClubInfoHttpResponseMessage.baz);
                    }
                    if (a.this.baw) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).IL()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bat.id), guardClubInfoHttpResponseMessage.baA, guardClubInfoHttpResponseMessage.baz, guardClubInfoHttpResponseMessage.bau);
                    }
                }
            }
        }
    };
    CustomMessageListener gcQ = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.FR((String) customResponsedMessage.getData());
            } else {
                a.this.FR("");
            }
        }
    };
    CustomMessageListener gcR = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bLg();
        }
    };
    HttpMessageListener gcS = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.gcN != null && a.this.gcN.id == guardClubJoinHttpResponseMessage.baB) {
                        a.this.bLh();
                    }
                } else if (!guardClubJoinHttpResponseMessage.baE) {
                    guardClubJoinHttpResponseMessage.baE = true;
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
        MessageManager.getInstance().registerListener(this.fTe);
        MessageManager.getInstance().registerListener(this.gcP);
        MessageManager.getInstance().registerListener(this.gcQ);
        MessageManager.getInstance().registerListener(this.gcR);
        MessageManager.getInstance().registerListener(this.gcS);
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.gcL != null && this.gcL.getView() != null) {
            this.gcL.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void IT() {
        this.gcN = null;
        if (this.gcO != null) {
            this.gcO.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fTe);
        MessageManager.getInstance().unRegisterListener(this.gcP);
        MessageManager.getInstance().unRegisterListener(this.gcQ);
        MessageManager.getInstance().unRegisterListener(this.gcR);
        MessageManager.getInstance().unRegisterListener(this.gcS);
        if (this.gcL != null) {
            this.gcL.onDestroy();
        }
        if (this.gcO != null) {
            this.gcO.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(String str) {
        if (this.context != null && this.aAP != null && this.aAP.aEz != null && this.aAP.mLiveInfo != null) {
            long j = this.aAP.aEz.userId;
            long j2 = this.aAP.mLiveInfo.live_id;
            long j3 = this.aAP.mLiveInfo.room_id;
            String str2 = this.aAP.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aAP.aEz.nickName, this.aAP.aEz.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.baw);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bLf();
        } else if (fVar.baK > 0) {
            dZ(str, str2);
        }
    }

    private void bLf() {
        this.gcO = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gcO.a(new a.InterfaceC0602a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0602a
            public void onConfirm() {
                if (a.this.bLg()) {
                    a.this.gcO.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0602a
            public void onCancel() {
                a.this.gcO.dismiss();
            }
        });
        ba IR = com.baidu.live.guardclub.g.IP().IR();
        this.gcO.aG(0, IR != null ? IR.aKp : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dZ(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ba IR = com.baidu.live.guardclub.g.IP().IR();
        if (IR != null && IR.aKn > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.c.AR().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dr = com.baidu.tieba.ala.guardclub.model.a.dr(jSONArray.optJSONObject(i));
                            if (dr != null && dr.date.equals(b)) {
                                if (dr.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dr);
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
                            com.baidu.live.c.AR().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.dgo = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dgo >= IR.aKn) {
                        z3 = true;
                    } else {
                        aVar2.dgo++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.gcO = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gcO.a(new a.InterfaceC0602a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0602a
                    public void onConfirm() {
                        a.this.gcO.dismiss();
                        if (a.this.gcK != null) {
                            a.this.gcK.IV();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0602a
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
                this.gcO.aG(1, IR.aKo);
            }
            com.baidu.live.c.AR().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLg() {
        long j;
        if (this.gcN == null) {
            return false;
        }
        ba IR = com.baidu.live.guardclub.g.IP().IR();
        if (IR == null || IR.aKi <= 0) {
            j = 1000;
        } else {
            j = IR.aKi;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            tH(this.gcN.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void tH(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eu(i);
        cVar.a(this.gcN);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bLh() {
        if (this.aAP != null && this.aAP.aEz != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.aAP.aEz.userId);
            bVar.setParams();
            bVar.setTag(this.fUp);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.gcM == null || this.gcL == null || this.gcM.indexOfChild(this.gcL.getView()) < 0) ? false : true;
    }
}
