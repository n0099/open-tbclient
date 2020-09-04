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
import com.baidu.live.data.av;
import com.baidu.live.data.be;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.guardclub.h {
    private r aAj;
    protected Context context;
    private com.baidu.tieba.ala.guardclub.view.a fZA;
    private com.baidu.live.guardclub.l fZw;
    protected com.baidu.tieba.ala.guardclub.view.b fZx;
    private ViewGroup fZy;
    private com.baidu.live.guardclub.a fZz;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fRe = BdUniqueId.gen();
    private boolean aXY = false;
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aAj != null && a.this.aAj.aDG != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.Ft("");
            }
        }
    };
    CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener fZB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aAj != null && a.this.aAj.aDG != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aXV != null && guardClubInfoHttpResponseMessage.aXV.aCw == a.this.aAj.aDG.userId) {
                    a.this.fZz = guardClubInfoHttpResponseMessage.aXV;
                    a.this.aXY = guardClubInfoHttpResponseMessage.aXY;
                    if (a.this.fZx != null) {
                        a.this.fZx.b(a.this.aXY, guardClubInfoHttpResponseMessage.aYb);
                    }
                    if (a.this.aXY) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).Ii()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aXV.id), guardClubInfoHttpResponseMessage.aYc, guardClubInfoHttpResponseMessage.aYb, guardClubInfoHttpResponseMessage.aXW);
                    }
                }
            }
        }
    };
    CustomMessageListener fZC = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.Ft((String) customResponsedMessage.getData());
            } else {
                a.this.Ft("");
            }
        }
    };
    CustomMessageListener fZD = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bJW();
        }
    };
    HttpMessageListener fZE = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.fZz != null && a.this.fZz.id == guardClubJoinHttpResponseMessage.aYd) {
                        a.this.bJX();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aYg) {
                    guardClubJoinHttpResponseMessage.aYg = true;
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
        MessageManager.getInstance().registerListener(this.fPT);
        MessageManager.getInstance().registerListener(this.fZB);
        MessageManager.getInstance().registerListener(this.fZC);
        MessageManager.getInstance().registerListener(this.fZD);
        MessageManager.getInstance().registerListener(this.fZE);
    }

    protected boolean aj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fZx == null) {
            this.fZx = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.eFG);
        }
        if (this.fZy != null && this.fZy.indexOfChild(this.fZx.getView()) >= 0) {
            this.fZy.removeView(this.fZx.getView());
        }
        this.fZy = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.fZw = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, r rVar) {
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar != null && beVar.aJD != null && beVar.aJD.aLr) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && aj(viewGroup)) {
                this.aAj = rVar;
                this.fZz = null;
                this.fZx.reset();
                viewGroup.addView(this.fZx.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.fZx != null && this.fZx.getView() != null) {
            this.fZx.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Iq() {
        this.fZz = null;
        if (this.fZA != null) {
            this.fZA.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fPT);
        MessageManager.getInstance().unRegisterListener(this.fZB);
        MessageManager.getInstance().unRegisterListener(this.fZC);
        MessageManager.getInstance().unRegisterListener(this.fZD);
        MessageManager.getInstance().unRegisterListener(this.fZE);
        if (this.fZx != null) {
            this.fZx.onDestroy();
        }
        if (this.fZA != null) {
            this.fZA.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft(String str) {
        if (this.context != null && this.aAj != null && this.aAj.aDG != null && this.aAj.mLiveInfo != null) {
            long j = this.aAj.aDG.userId;
            long j2 = this.aAj.mLiveInfo.live_id;
            long j3 = this.aAj.mLiveInfo.room_id;
            String str2 = this.aAj.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aAj.aDG.nickName, this.aAj.aDG.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.aXY);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bJV();
        } else if (fVar.aYn > 0) {
            dX(str, str2);
        }
    }

    private void bJV() {
        this.fZA = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.fZA.a(new a.InterfaceC0606a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
            public void onConfirm() {
                if (a.this.bJW()) {
                    a.this.fZA.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
            public void onCancel() {
                a.this.fZA.dismiss();
            }
        });
        av Io = com.baidu.live.guardclub.g.Im().Io();
        this.fZA.aF(0, Io != null ? Io.aIZ : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dX(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        av Io = com.baidu.live.guardclub.g.Im().Io();
        if (Io != null && Io.aIX > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.AD().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dl = com.baidu.tieba.ala.guardclub.model.a.dl(jSONArray.optJSONObject(i));
                            if (dl != null && dl.date.equals(b)) {
                                if (dl.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dl);
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
                            com.baidu.live.c.AD().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.den = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.den >= Io.aIX) {
                        z3 = true;
                    } else {
                        aVar2.den++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.fZA = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.fZA.a(new a.InterfaceC0606a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
                    public void onConfirm() {
                        a.this.fZA.dismiss();
                        if (a.this.fZw != null) {
                            a.this.fZw.Is();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
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
                this.fZA.aF(1, Io.aIY);
            }
            com.baidu.live.c.AD().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJW() {
        long j;
        if (this.fZz == null) {
            return false;
        }
        av Io = com.baidu.live.guardclub.g.Im().Io();
        if (Io == null || Io.aIS <= 0) {
            j = 1000;
        } else {
            j = Io.aIS;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            to(this.fZz.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void to(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eq(i);
        cVar.a(this.fZz);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bJX() {
        if (this.aAj != null && this.aAj.aDG != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ag(this.aAj.aDG.userId);
            bVar.setParams();
            bVar.setTag(this.fRe);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.fZy == null || this.fZx == null || this.fZy.indexOfChild(this.fZx.getView()) < 0) ? false : true;
    }
}
