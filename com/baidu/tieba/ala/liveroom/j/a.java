package com.baidu.tieba.ala.liveroom.j;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.af;
import com.baidu.live.data.i;
import com.baidu.live.data.z;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.guardclub.m;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.f;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.view.a;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private i aaj;
    private ViewGroup dYe;
    private InterfaceC0362a efO;
    protected b efP;
    private com.baidu.tieba.ala.guardclub.model.c efQ;
    private com.baidu.tieba.ala.guardclub.view.a efR;
    private boolean isHost;
    protected TbPageContext mTbPageContext;
    private String otherParams;
    private BdUniqueId dFi = BdUniqueId.gen();
    private boolean dKS = false;
    private View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aaj != null && a.this.aaj.OR != null && ViewHelper.checkUpIsLogin(a.this.mTbPageContext.getPageActivity())) {
                a.this.tJ("");
            }
        }
    };
    CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.a.4
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
    private HttpMessageListener dKp = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.j.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aaj != null && a.this.aaj.OR != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.dKm != null && guardClubInfoHttpResponseMessage.dKm.Of == a.this.aaj.OR.userId) {
                    a.this.efQ = guardClubInfoHttpResponseMessage.dKm;
                    a.this.dKS = guardClubInfoHttpResponseMessage.dKS;
                    if (a.this.efP != null) {
                        a.this.efP.b(a.this.dKS, guardClubInfoHttpResponseMessage.dNv);
                    }
                    if (a.this.dKS) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.guardclub.model.d) && ((com.baidu.tieba.ala.guardclub.model.d) httpResponsedMessage.getOrginalMessage()).aLz()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.dKm.id), guardClubInfoHttpResponseMessage.dNw, guardClubInfoHttpResponseMessage.dNv, guardClubInfoHttpResponseMessage.dKP);
                    }
                }
            }
        }
    };
    CustomMessageListener efS = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.j.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.tJ((String) customResponsedMessage.getData());
            } else {
                a.this.tJ("");
            }
        }
    };
    CustomMessageListener efT = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.liveroom.j.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aRX();
        }
    };
    HttpMessageListener dKq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.j.a.8
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
                    if (a.this.efQ != null && a.this.efQ.id == guardClubJoinHttpResponseMessage.dNz) {
                        a.this.aLg();
                    }
                } else if (!guardClubJoinHttpResponseMessage.dNC) {
                    guardClubJoinHttpResponseMessage.dNC = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0362a {
        void aPA();
    }

    public a(TbPageContext tbPageContext, boolean z, String str) {
        this.mTbPageContext = tbPageContext;
        this.isHost = z;
        this.otherParams = str;
        MessageManager.getInstance().registerListener(this.dEz);
        MessageManager.getInstance().registerListener(this.dKp);
        MessageManager.getInstance().registerListener(this.efS);
        MessageManager.getInstance().registerListener(this.efT);
        MessageManager.getInstance().registerListener(this.dKq);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ac(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.efP == null) {
            this.efP = new b(getPageContext(), this.isHost, this.cze);
        }
        if (this.dYe != null && this.dYe.indexOfChild(this.efP.getView()) >= 0) {
            this.dYe.removeView(this.efP.getView());
        }
        this.dYe = viewGroup;
        return true;
    }

    public void a(InterfaceC0362a interfaceC0362a) {
        this.efO = interfaceC0362a;
    }

    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, i iVar) {
        af afVar = com.baidu.live.l.a.uB().aku;
        if (afVar != null && afVar.TO != null && afVar.TO.UT) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ac(viewGroup)) {
                this.aaj = iVar;
                viewGroup.addView(this.efP.getView(), layoutParams);
            }
        }
    }

    public void c(ViewGroup viewGroup, i iVar) {
        af afVar = com.baidu.live.l.a.uB().aku;
        if (afVar != null && afVar.TO != null && afVar.TO.UT) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ac(viewGroup)) {
                this.aaj = iVar;
                this.efQ = null;
                this.efP.reset();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
                layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
                layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                viewGroup.addView(this.efP.getView(), layoutParams);
            }
        }
    }

    public void setVisible(int i) {
        if (this.efP != null && this.efP.getView() != null) {
            this.efP.getView().setVisibility(i);
        }
    }

    public void aRV() {
        this.efQ = null;
        if (this.efR != null) {
            this.efR.dismiss();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dEz);
        MessageManager.getInstance().unRegisterListener(this.dKp);
        MessageManager.getInstance().unRegisterListener(this.efS);
        MessageManager.getInstance().unRegisterListener(this.efT);
        MessageManager.getInstance().unRegisterListener(this.dKq);
        if (this.efP != null) {
            this.efP.onDestroy();
        }
        if (this.efR != null) {
            this.efR.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(String str) {
        if (this.mTbPageContext != null && this.aaj != null && this.aaj.OR != null && this.aaj.mLiveInfo != null) {
            long j = this.aaj.OR.userId;
            long j2 = this.aaj.mLiveInfo.live_id;
            long j3 = this.aaj.mLiveInfo.room_id;
            String str2 = this.aaj.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mTbPageContext.getPageActivity(), j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.dKS);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, k kVar, String str2) {
        if (z) {
            aRW();
        } else if (kVar.dNR > 0) {
            cp(str, str2);
        }
    }

    private void aRW() {
        this.efR = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
        this.efR.a(new a.InterfaceC0349a() { // from class: com.baidu.tieba.ala.liveroom.j.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0349a
            public void onConfirm() {
                if (a.this.aRX()) {
                    a.this.efR.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0349a
            public void onCancel() {
                a.this.efR.dismiss();
            }
        });
        z aLx = m.aLv().aLx();
        this.efR.S(0, aLx != null ? aLx.Ts : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cp(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        z aLx = m.aLv().aLx();
        if (aLx != null && aLx.Tq > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.i.b(new Date());
            String string = com.baidu.live.c.np().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a bK = com.baidu.tieba.ala.guardclub.model.a.bK(jSONArray.optJSONObject(i));
                            if (bK != null && bK.date.equals(b)) {
                                if (bK.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(bK);
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
                            com.baidu.live.c.np().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.dNf = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dNf >= aLx.Tq) {
                        z3 = true;
                    } else {
                        aVar2.dNf++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.efR = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
                this.efR.a(new a.InterfaceC0349a() { // from class: com.baidu.tieba.ala.liveroom.j.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0349a
                    public void onConfirm() {
                        a.this.efR.dismiss();
                        if (a.this.efO != null) {
                            a.this.efO.aPA();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0349a
                    public void onCancel() {
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb = new StringBuilder(str2);
                            if (str2.contains("?")) {
                                sb.append("&");
                            } else {
                                sb.append("?");
                            }
                            sb.append("source=2");
                            BrowserHelper.startInternalWebActivity(a.this.mTbPageContext.getPageActivity(), sb.toString());
                        }
                    }
                });
                this.efR.S(1, aLx.Tr);
            }
            com.baidu.live.c.np().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRX() {
        long j;
        if (this.efQ == null) {
            return false;
        }
        z aLx = m.aLv().aLx();
        if (aLx == null || aLx.Tl <= 0) {
            j = 1000;
        } else {
            j = aLx.Tl;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            mG(this.efQ.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void mG(int i) {
        f fVar = new f();
        fVar.mP(i);
        fVar.a(this.efQ);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void aLg() {
        if (this.aaj != null && this.aaj.OR != null) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.bZ(this.aaj.OR.userId);
            dVar.setParams();
            dVar.setTag(this.dFi);
            MessageManager.getInstance().sendMessage(dVar);
        }
    }
}
