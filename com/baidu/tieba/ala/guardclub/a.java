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
    private com.baidu.live.data.m alp;
    protected Context context;
    private com.baidu.tieba.ala.guardclub.view.a eEA;
    private com.baidu.live.guardclub.l eEx;
    protected com.baidu.tieba.ala.guardclub.view.b eEy;
    private com.baidu.live.guardclub.a eEz;
    private ViewGroup ewN;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId exr = BdUniqueId.gen();
    private boolean aql = false;
    private View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.alp != null && a.this.alp.Ya != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.yv("");
            }
        }
    };
    CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener eEB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.alp != null && a.this.alp.Ya != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aqi != null && guardClubInfoHttpResponseMessage.aqi.Xj == a.this.alp.Ya.userId) {
                    a.this.eEz = guardClubInfoHttpResponseMessage.aqi;
                    a.this.aql = guardClubInfoHttpResponseMessage.aql;
                    if (a.this.eEy != null) {
                        a.this.eEy.b(a.this.aql, guardClubInfoHttpResponseMessage.aqo);
                    }
                    if (a.this.aql) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).vI()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aqi.id), guardClubInfoHttpResponseMessage.aqp, guardClubInfoHttpResponseMessage.aqo, guardClubInfoHttpResponseMessage.aqj);
                    }
                }
            }
        }
    };
    CustomMessageListener eEC = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.yv((String) customResponsedMessage.getData());
            } else {
                a.this.yv("");
            }
        }
    };
    CustomMessageListener eED = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bfg();
        }
    };
    HttpMessageListener eEE = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.eEz != null && a.this.eEz.id == guardClubJoinHttpResponseMessage.aqq) {
                        a.this.bfh();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aqt) {
                    guardClubJoinHttpResponseMessage.aqt = true;
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
        MessageManager.getInstance().registerListener(this.ewu);
        MessageManager.getInstance().registerListener(this.eEB);
        MessageManager.getInstance().registerListener(this.eEC);
        MessageManager.getInstance().registerListener(this.eED);
        MessageManager.getInstance().registerListener(this.eEE);
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eEy == null) {
            this.eEy = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.drJ);
        }
        if (this.ewN != null && this.ewN.indexOfChild(this.eEy.getView()) >= 0) {
            this.ewN.removeView(this.eEy.getView());
        }
        this.ewN = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.eEx = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.baidu.live.data.m mVar) {
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (apVar != null && apVar.adg != null && apVar.adg.aeJ) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && X(viewGroup)) {
                this.alp = mVar;
                this.eEz = null;
                this.eEy.reset();
                viewGroup.addView(this.eEy.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.eEy != null && this.eEy.getView() != null) {
            this.eEy.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void vQ() {
        this.eEz = null;
        if (this.eEA != null) {
            this.eEA.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ewu);
        MessageManager.getInstance().unRegisterListener(this.eEB);
        MessageManager.getInstance().unRegisterListener(this.eEC);
        MessageManager.getInstance().unRegisterListener(this.eED);
        MessageManager.getInstance().unRegisterListener(this.eEE);
        if (this.eEy != null) {
            this.eEy.onDestroy();
        }
        if (this.eEA != null) {
            this.eEA.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yv(String str) {
        if (this.context != null && this.alp != null && this.alp.Ya != null && this.alp.mLiveInfo != null) {
            long j = this.alp.Ya.userId;
            long j2 = this.alp.mLiveInfo.live_id;
            long j3 = this.alp.mLiveInfo.room_id;
            String str2 = this.alp.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.aql);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bff();
        } else if (fVar.aqA > 0) {
            cQ(str, str2);
        }
    }

    private void bff() {
        this.eEA = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.eEA.a(new a.InterfaceC0437a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0437a
            public void onConfirm() {
                if (a.this.bfg()) {
                    a.this.eEA.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0437a
            public void onCancel() {
                a.this.eEA.dismiss();
            }
        });
        ah vO = com.baidu.live.guardclub.g.vM().vO();
        this.eEA.ak(0, vO != null ? vO.acE : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cQ(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ah vO = com.baidu.live.guardclub.g.vM().vO();
        if (vO != null && vO.acC > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.pw().getString("guardclub_attenuat_daily", "");
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
                            com.baidu.live.c.pw().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.eHr = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.eHr >= vO.acC) {
                        z3 = true;
                    } else {
                        aVar2.eHr++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.eEA = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.eEA.a(new a.InterfaceC0437a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0437a
                    public void onConfirm() {
                        a.this.eEA.dismiss();
                        if (a.this.eEx != null) {
                            a.this.eEx.vS();
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
                this.eEA.ak(1, vO.acD);
            }
            com.baidu.live.c.pw().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfg() {
        long j;
        if (this.eEz == null) {
            return false;
        }
        ah vO = com.baidu.live.guardclub.g.vM().vO();
        if (vO == null || vO.acx <= 0) {
            j = 1000;
        } else {
            j = vO.acx;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            pq(this.eEz.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void pq(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.bQ(i);
        cVar.a(this.eEz);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bfh() {
        if (this.alp != null && this.alp.Ya != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.D(this.alp.Ya.userId);
            bVar.setParams();
            bVar.setTag(this.exr);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.ewN == null || this.eEy == null || this.ewN.indexOfChild(this.eEy.getView()) < 0) ? false : true;
    }
}
