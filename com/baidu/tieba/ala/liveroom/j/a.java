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
import com.baidu.live.data.ac;
import com.baidu.live.data.ak;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
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
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.f;
import com.baidu.tieba.ala.guardclub.view.a;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private k aio;
    private InterfaceC0446a eVI;
    protected b eVJ;
    private com.baidu.tieba.ala.guardclub.model.c eVK;
    private com.baidu.tieba.ala.guardclub.view.a eVL;
    private ViewGroup eqG;
    private boolean isHost;
    protected TbPageContext mTbPageContext;
    private String otherParams;
    private BdUniqueId erl = BdUniqueId.gen();
    private boolean ezi = false;
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aio != null && a.this.aio.VP != null && ViewHelper.checkUpIsLogin(a.this.mTbPageContext.getPageActivity())) {
                a.this.yy("");
            }
        }
    };
    CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.a.4
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
    private HttpMessageListener eyF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.j.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aio != null && a.this.aio.VP != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.eyC != null && guardClubInfoHttpResponseMessage.eyC.Vc == a.this.aio.VP.userId) {
                    a.this.eVK = guardClubInfoHttpResponseMessage.eyC;
                    a.this.ezi = guardClubInfoHttpResponseMessage.ezi;
                    if (a.this.eVJ != null) {
                        a.this.eVJ.b(a.this.ezi, guardClubInfoHttpResponseMessage.eBD);
                    }
                    if (a.this.ezi) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.ala.guardclub.model.d) && ((com.baidu.tieba.ala.guardclub.model.d) httpResponsedMessage.getOrginalMessage()).bcI()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.eyC.id), guardClubInfoHttpResponseMessage.eBE, guardClubInfoHttpResponseMessage.eBD, guardClubInfoHttpResponseMessage.ezf);
                    }
                }
            }
        }
    };
    CustomMessageListener eVM = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.j.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.yy((String) customResponsedMessage.getData());
            } else {
                a.this.yy("");
            }
        }
    };
    CustomMessageListener eVN = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.liveroom.j.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bjw();
        }
    };
    HttpMessageListener eyG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.j.a.8
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
                    if (a.this.eVK != null && a.this.eVK.id == guardClubJoinHttpResponseMessage.eBH) {
                        a.this.bcr();
                    }
                } else if (!guardClubJoinHttpResponseMessage.eBK) {
                    guardClubJoinHttpResponseMessage.eBK = true;
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
    /* loaded from: classes2.dex */
    public interface InterfaceC0446a {
        void bhc();
    }

    public a(TbPageContext tbPageContext, boolean z, String str) {
        this.mTbPageContext = tbPageContext;
        this.isHost = z;
        this.otherParams = str;
        MessageManager.getInstance().registerListener(this.eqn);
        MessageManager.getInstance().registerListener(this.eyF);
        MessageManager.getInstance().registerListener(this.eVM);
        MessageManager.getInstance().registerListener(this.eVN);
        MessageManager.getInstance().registerListener(this.eyG);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ab(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eVJ == null) {
            this.eVJ = new b(getPageContext(), this.isHost, this.dmK);
        }
        if (this.eqG != null && this.eqG.indexOfChild(this.eVJ.getView()) >= 0) {
            this.eqG.removeView(this.eVJ.getView());
        }
        this.eqG = viewGroup;
        return true;
    }

    public void a(InterfaceC0446a interfaceC0446a) {
        this.eVI = interfaceC0446a;
    }

    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, k kVar) {
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (akVar != null && akVar.aaK != null && akVar.aaK.acj) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ab(viewGroup)) {
                this.aio = kVar;
                viewGroup.addView(this.eVJ.getView(), layoutParams);
            }
        }
    }

    public void c(ViewGroup viewGroup, k kVar) {
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (akVar != null && akVar.aaK != null && akVar.aaK.acj) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ab(viewGroup)) {
                this.aio = kVar;
                this.eVK = null;
                this.eVJ.reset();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
                layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
                layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                viewGroup.addView(this.eVJ.getView(), layoutParams);
            }
        }
    }

    public void setVisible(int i) {
        if (this.eVJ != null && this.eVJ.getView() != null) {
            this.eVJ.getView().setVisibility(i);
        }
    }

    public void tT() {
        this.eVK = null;
        if (this.eVL != null) {
            this.eVL.dismiss();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eqn);
        MessageManager.getInstance().unRegisterListener(this.eyF);
        MessageManager.getInstance().unRegisterListener(this.eVM);
        MessageManager.getInstance().unRegisterListener(this.eVN);
        MessageManager.getInstance().unRegisterListener(this.eyG);
        if (this.eVJ != null) {
            this.eVJ.onDestroy();
        }
        if (this.eVL != null) {
            this.eVL.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(String str) {
        if (this.mTbPageContext != null && this.aio != null && this.aio.VP != null && this.aio.mLiveInfo != null) {
            long j = this.aio.VP.userId;
            long j2 = this.aio.mLiveInfo.live_id;
            long j3 = this.aio.mLiveInfo.room_id;
            String str2 = this.aio.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mTbPageContext.getPageActivity(), j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.ezi);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.tieba.ala.guardclub.model.k kVar, String str2) {
        if (z) {
            bjv();
        } else if (kVar.eBY > 0) {
            cJ(str, str2);
        }
    }

    private void bjv() {
        this.eVL = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
        this.eVL.a(new a.InterfaceC0423a() { // from class: com.baidu.tieba.ala.liveroom.j.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0423a
            public void onConfirm() {
                if (a.this.bjw()) {
                    a.this.eVL.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0423a
            public void onCancel() {
                a.this.eVL.dismiss();
            }
        });
        ac bcG = l.bcE().bcG();
        this.eVL.ah(0, bcG != null ? bcG.aaj : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cJ(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ac bcG = l.bcE().bcG();
        if (bcG != null && bcG.aah > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = j.b(new Date());
            String string = com.baidu.live.c.oI().getString("guardclub_attenuat_daily", "");
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
                            com.baidu.live.c.oI().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.eBn = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.eBn >= bcG.aah) {
                        z3 = true;
                    } else {
                        aVar2.eBn++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.eVL = new com.baidu.tieba.ala.guardclub.view.a(this.mTbPageContext.getPageActivity());
                this.eVL.a(new a.InterfaceC0423a() { // from class: com.baidu.tieba.ala.liveroom.j.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0423a
                    public void onConfirm() {
                        a.this.eVL.dismiss();
                        if (a.this.eVI != null) {
                            a.this.eVI.bhc();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0423a
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
                this.eVL.ah(1, bcG.aai);
            }
            com.baidu.live.c.oI().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjw() {
        long j;
        if (this.eVK == null) {
            return false;
        }
        ac bcG = l.bcE().bcG();
        if (bcG == null || bcG.aab <= 0) {
            j = 1000;
        } else {
            j = bcG.aab;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            oW(this.eVK.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void oW(int i) {
        f fVar = new f();
        fVar.pf(i);
        fVar.a(this.eVK);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void bcr() {
        if (this.aio != null && this.aio.VP != null) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.cu(this.aio.VP.userId);
            dVar.setParams();
            dVar.setTag(this.erl);
            MessageManager.getInstance().sendMessage(dVar);
        }
    }
}
