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
    private i aaB;
    private ViewGroup dYV;
    private InterfaceC0362a egF;
    protected b egG;
    private com.baidu.tieba.ala.guardclub.model.c egH;
    private com.baidu.tieba.ala.guardclub.view.a egI;
    private boolean isHost;
    protected TbPageContext mTbPageContext;
    private String otherParams;
    private BdUniqueId dFZ = BdUniqueId.gen();
    private boolean dLJ = false;
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aaB != null && a.this.aaB.Ps != null && ViewHelper.checkUpIsLogin(a.this.mTbPageContext.getPageActivity())) {
                a.this.tJ("");
            }
        }
    };
    CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.a.4
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
    private HttpMessageListener dLg = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.j.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aaB != null && a.this.aaB.Ps != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.dLd != null && guardClubInfoHttpResponseMessage.dLd.OF == a.this.aaB.Ps.userId) {
                    a.this.egH = guardClubInfoHttpResponseMessage.dLd;
                    a.this.dLJ = guardClubInfoHttpResponseMessage.dLJ;
                    if (a.this.egG != null) {
                        a.this.egG.b(a.this.dLJ, guardClubInfoHttpResponseMessage.dOm);
                    }
                    if (a.this.dLJ) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.guardclub.model.d) && ((com.baidu.tieba.ala.guardclub.model.d) httpResponsedMessage.getOrginalMessage()).aLB()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.dLd.id), guardClubInfoHttpResponseMessage.dOn, guardClubInfoHttpResponseMessage.dOm, guardClubInfoHttpResponseMessage.dLG);
                    }
                }
            }
        }
    };
    CustomMessageListener egJ = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.j.a.6
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
    CustomMessageListener egK = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.liveroom.j.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aRZ();
        }
    };
    HttpMessageListener dLh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.j.a.8
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
                    if (a.this.egH != null && a.this.egH.id == guardClubJoinHttpResponseMessage.dOq) {
                        a.this.aLi();
                    }
                } else if (!guardClubJoinHttpResponseMessage.dOt) {
                    guardClubJoinHttpResponseMessage.dOt = true;
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
        void aPC();
    }

    public a(TbPageContext tbPageContext, boolean z, String str) {
        this.mTbPageContext = tbPageContext;
        this.isHost = z;
        this.otherParams = str;
        MessageManager.getInstance().registerListener(this.dFq);
        MessageManager.getInstance().registerListener(this.dLg);
        MessageManager.getInstance().registerListener(this.egJ);
        MessageManager.getInstance().registerListener(this.egK);
        MessageManager.getInstance().registerListener(this.dLh);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ac(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.egG == null) {
            this.egG = new b(getPageContext(), this.isHost, this.czV);
        }
        if (this.dYV != null && this.dYV.indexOfChild(this.egG.getView()) >= 0) {
            this.dYV.removeView(this.egG.getView());
        }
        this.dYV = viewGroup;
        return true;
    }

    public void a(InterfaceC0362a interfaceC0362a) {
        this.egF = interfaceC0362a;
    }

    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, i iVar) {
        af afVar = com.baidu.live.l.a.uA().akM;
        if (afVar != null && afVar.Uh != null && afVar.Uh.Vm) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ac(viewGroup)) {
                this.aaB = iVar;
                viewGroup.addView(this.egG.getView(), layoutParams);
            }
        }
    }

    public void c(ViewGroup viewGroup, i iVar) {
        af afVar = com.baidu.live.l.a.uA().akM;
        if (afVar != null && afVar.Uh != null && afVar.Uh.Vm) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ac(viewGroup)) {
                this.aaB = iVar;
                this.egH = null;
                this.egG.reset();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
                layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
                layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                viewGroup.addView(this.egG.getView(), layoutParams);
            }
        }
    }

    public void setVisible(int i) {
        if (this.egG != null && this.egG.getView() != null) {
            this.egG.getView().setVisibility(i);
        }
    }

    public void aRX() {
        this.egH = null;
        if (this.egI != null) {
            this.egI.dismiss();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFq);
        MessageManager.getInstance().unRegisterListener(this.dLg);
        MessageManager.getInstance().unRegisterListener(this.egJ);
        MessageManager.getInstance().unRegisterListener(this.egK);
        MessageManager.getInstance().unRegisterListener(this.dLh);
        if (this.egG != null) {
            this.egG.onDestroy();
        }
        if (this.egI != null) {
            this.egI.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(String str) {
        if (this.mTbPageContext != null && this.aaB != null && this.aaB.Ps != null && this.aaB.mLiveInfo != null) {
            long j = this.aaB.Ps.userId;
            long j2 = this.aaB.mLiveInfo.live_id;
            long j3 = this.aaB.mLiveInfo.room_id;
            String str2 = this.aaB.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mTbPageContext.getPageActivity(), j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.dLJ);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, k kVar, String str2) {
        if (z) {
            aRY();
        } else if (kVar.dOI > 0) {
            cp(str, str2);
        }
    }

    private void aRY() {
        this.egI = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
        this.egI.a(new a.InterfaceC0349a() { // from class: com.baidu.tieba.ala.liveroom.j.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0349a
            public void onConfirm() {
                if (a.this.aRZ()) {
                    a.this.egI.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0349a
            public void onCancel() {
                a.this.egI.dismiss();
            }
        });
        z aLz = m.aLx().aLz();
        this.egI.T(0, aLz != null ? aLz.TM : "");
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
        z aLz = m.aLx().aLz();
        if (aLz != null && aLz.TK > 0) {
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
                            com.baidu.tieba.ala.guardclub.model.a bJ = com.baidu.tieba.ala.guardclub.model.a.bJ(jSONArray.optJSONObject(i));
                            if (bJ != null && bJ.date.equals(b)) {
                                if (bJ.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(bJ);
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
                aVar.dNW = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dNW >= aLz.TK) {
                        z3 = true;
                    } else {
                        aVar2.dNW++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.egI = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
                this.egI.a(new a.InterfaceC0349a() { // from class: com.baidu.tieba.ala.liveroom.j.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0349a
                    public void onConfirm() {
                        a.this.egI.dismiss();
                        if (a.this.egF != null) {
                            a.this.egF.aPC();
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
                this.egI.T(1, aLz.TL);
            }
            com.baidu.live.c.np().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRZ() {
        long j;
        if (this.egH == null) {
            return false;
        }
        z aLz = m.aLx().aLz();
        if (aLz == null || aLz.TF <= 0) {
            j = 1000;
        } else {
            j = aLz.TF;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            mH(this.egH.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void mH(int i) {
        f fVar = new f();
        fVar.mQ(i);
        fVar.a(this.egH);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void aLi() {
        if (this.aaB != null && this.aaB.Ps != null) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.ca(this.aaB.Ps.userId);
            dVar.setParams();
            dVar.setTag(this.dFZ);
            MessageManager.getInstance().sendMessage(dVar);
        }
    }
}
