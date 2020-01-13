package com.baidu.tieba.ala.liveroom.l;

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
import com.baidu.live.data.ag;
import com.baidu.live.data.ao;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.f;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.view.a;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private l aiW;
    private InterfaceC0450a eYi;
    protected b eYj;
    private com.baidu.tieba.ala.guardclub.model.c eYk;
    private com.baidu.tieba.ala.guardclub.view.a eYl;
    private ViewGroup erT;
    private boolean isHost;
    protected TbPageContext mTbPageContext;
    private String otherParams;
    private BdUniqueId esx = BdUniqueId.gen();
    private boolean eAt = false;
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aiW != null && a.this.aiW.Wf != null && ViewHelper.checkUpIsLogin(a.this.mTbPageContext.getPageActivity())) {
                a.this.yH("");
            }
        }
    };
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
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
    private HttpMessageListener ezQ = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aiW != null && a.this.aiW.Wf != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.ezN != null && guardClubInfoHttpResponseMessage.ezN.Vt == a.this.aiW.Wf.userId) {
                    a.this.eYk = guardClubInfoHttpResponseMessage.ezN;
                    a.this.eAt = guardClubInfoHttpResponseMessage.eAt;
                    if (a.this.eYj != null) {
                        a.this.eYj.b(a.this.eAt, guardClubInfoHttpResponseMessage.eCO);
                    }
                    if (a.this.eAt) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.guardclub.model.d) && ((com.baidu.tieba.ala.guardclub.model.d) httpResponsedMessage.getOrginalMessage()).bdd()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.ezN.id), guardClubInfoHttpResponseMessage.eCP, guardClubInfoHttpResponseMessage.eCO, guardClubInfoHttpResponseMessage.eAq);
                    }
                }
            }
        }
    };
    CustomMessageListener eYm = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.l.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.yH((String) customResponsedMessage.getData());
            } else {
                a.this.yH("");
            }
        }
    };
    CustomMessageListener eYn = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.liveroom.l.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bks();
        }
    };
    HttpMessageListener ezR = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.l.a.8
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
                    if (a.this.eYk != null && a.this.eYk.id == guardClubJoinHttpResponseMessage.eCS) {
                        a.this.bcM();
                    }
                } else if (!guardClubJoinHttpResponseMessage.eCV) {
                    guardClubJoinHttpResponseMessage.eCV = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0450a {
        void bhJ();
    }

    public a(TbPageContext tbPageContext, boolean z, String str) {
        this.mTbPageContext = tbPageContext;
        this.isHost = z;
        this.otherParams = str;
        MessageManager.getInstance().registerListener(this.erA);
        MessageManager.getInstance().registerListener(this.ezQ);
        MessageManager.getInstance().registerListener(this.eYm);
        MessageManager.getInstance().registerListener(this.eYn);
        MessageManager.getInstance().registerListener(this.ezR);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean af(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eYj == null) {
            this.eYj = new b(getPageContext(), this.isHost, this.dmY);
        }
        if (this.erT != null && this.erT.indexOfChild(this.eYj.getView()) >= 0) {
            this.erT.removeView(this.eYj.getView());
        }
        this.erT = viewGroup;
        return true;
    }

    public void a(InterfaceC0450a interfaceC0450a) {
        this.eYi = interfaceC0450a;
    }

    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, l lVar) {
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (aoVar != null && aoVar.aaX != null && aoVar.aaX.acy) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && af(viewGroup)) {
                this.aiW = lVar;
                viewGroup.addView(this.eYj.getView(), layoutParams);
            }
        }
    }

    public void c(ViewGroup viewGroup, l lVar) {
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (aoVar != null && aoVar.aaX != null && aoVar.aaX.acy) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && af(viewGroup)) {
                this.aiW = lVar;
                this.eYk = null;
                this.eYj.reset();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
                layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
                layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                viewGroup.addView(this.eYj.getView(), layoutParams);
            }
        }
    }

    public void setVisible(int i) {
        if (this.eYj != null && this.eYj.getView() != null) {
            this.eYj.getView().setVisibility(i);
        }
    }

    public void uk() {
        this.eYk = null;
        if (this.eYl != null) {
            this.eYl.dismiss();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.erA);
        MessageManager.getInstance().unRegisterListener(this.ezQ);
        MessageManager.getInstance().unRegisterListener(this.eYm);
        MessageManager.getInstance().unRegisterListener(this.eYn);
        MessageManager.getInstance().unRegisterListener(this.ezR);
        if (this.eYj != null) {
            this.eYj.onDestroy();
        }
        if (this.eYl != null) {
            this.eYl.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(String str) {
        if (this.mTbPageContext != null && this.aiW != null && this.aiW.Wf != null && this.aiW.mLiveInfo != null) {
            long j = this.aiW.Wf.userId;
            long j2 = this.aiW.mLiveInfo.live_id;
            long j3 = this.aiW.mLiveInfo.room_id;
            String str2 = this.aiW.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mTbPageContext.getPageActivity(), j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.eAt);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, k kVar, String str2) {
        if (z) {
            bkr();
        } else if (kVar.eDj > 0) {
            cK(str, str2);
        }
    }

    private void bkr() {
        this.eYl = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
        this.eYl.a(new a.InterfaceC0426a() { // from class: com.baidu.tieba.ala.liveroom.l.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0426a
            public void onConfirm() {
                if (a.this.bks()) {
                    a.this.eYl.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0426a
            public void onCancel() {
                a.this.eYl.dismiss();
            }
        });
        ag bdb = com.baidu.tieba.ala.guardclub.l.bcZ().bdb();
        this.eYl.aj(0, bdb != null ? bdb.aaw : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cK(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ag bdb = com.baidu.tieba.ala.guardclub.l.bcZ().bdb();
        if (bdb != null && bdb.aau > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = j.b(new Date());
            String string = com.baidu.live.c.oJ().getString("guardclub_attenuat_daily", "");
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
                            com.baidu.live.c.oJ().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.eCy = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.eCy >= bdb.aau) {
                        z3 = true;
                    } else {
                        aVar2.eCy++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.eYl = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
                this.eYl.a(new a.InterfaceC0426a() { // from class: com.baidu.tieba.ala.liveroom.l.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0426a
                    public void onConfirm() {
                        a.this.eYl.dismiss();
                        if (a.this.eYi != null) {
                            a.this.eYi.bhJ();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0426a
                    public void onCancel() {
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb = new StringBuilder(str2);
                            if (str2.contains("?")) {
                                sb.append(ETAG.ITEM_SEPARATOR);
                            } else {
                                sb.append("?");
                            }
                            sb.append("source=2");
                            BrowserHelper.startInternalWebActivity(a.this.mTbPageContext.getPageActivity(), sb.toString());
                        }
                    }
                });
                this.eYl.aj(1, bdb.aav);
            }
            com.baidu.live.c.oJ().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bks() {
        long j;
        if (this.eYk == null) {
            return false;
        }
        ag bdb = com.baidu.tieba.ala.guardclub.l.bcZ().bdb();
        if (bdb == null || bdb.aap <= 0) {
            j = 1000;
        } else {
            j = bdb.aap;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            oX(this.eYk.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void oX(int i) {
        f fVar = new f();
        fVar.pg(i);
        fVar.a(this.eYk);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void bcM() {
        if (this.aiW != null && this.aiW.Wf != null) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.cz(this.aiW.Wf.userId);
            dVar.setParams();
            dVar.setTag(this.esx);
            MessageManager.getInstance().sendMessage(dVar);
        }
    }
}
