package com.baidu.tieba.ala.guardclub;

import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoRenameResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
/* loaded from: classes6.dex */
public class b {
    private long Of;
    private boolean Pr;
    private String WE;
    private GuardClubInfoActivity dKk;
    private boolean dKl;
    private com.baidu.tieba.ala.guardclub.model.c dKm;
    private c dKn;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId dFi = BdUniqueId.gen();
    private View.OnClickListener dKo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aLg();
        }
    };
    private HttpMessageListener dKp = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (b.this.dKn != null) {
                    b.this.dKn.aLi();
                }
            } else if (b.this.dKn != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == b.this.dFi && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.dKm != null) {
                b.this.dKm = guardClubInfoHttpResponseMessage.dKm;
                b.this.dKn.a(guardClubInfoHttpResponseMessage.dKm, guardClubInfoHttpResponseMessage.dKP, guardClubInfoHttpResponseMessage.dNs, guardClubInfoHttpResponseMessage.dKS, guardClubInfoHttpResponseMessage.dNu);
            }
        }
    };
    HttpMessageListener dKq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.3
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
                    if (b.this.dKm != null && b.this.dKm.id == guardClubJoinHttpResponseMessage.dNz) {
                        b.this.aLg();
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
    HttpMessageListener dKr = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021142) {
                if (!(httpResponsedMessage instanceof GuardClubInfoRenameResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = "修改真爱团名称失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString, 0);
                    return;
                }
                com.baidu.tieba.ala.guardclub.model.c cVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).dKm;
                if (cVar != null && b.this.dKm != null && b.this.dKm.id == cVar.id) {
                    if (b.this.dKn != null) {
                        b.this.dKn.tj(cVar.dNg);
                        return;
                    }
                    return;
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = "修改真爱团名称失败";
                }
                BdUtilHelper.getCustomToast().showToast(errorString2, 0);
            }
        }
    };
    private HttpMessageListener aky = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).ut() != null) {
                    b.this.aLg();
                }
            }
        }
    };

    public b(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.dKk = guardClubInfoActivity;
        this.Of = j;
        this.liveId = j2;
        this.roomId = j3;
        this.WE = str;
        this.Pr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.dKl = z4;
        this.isTranslucent = z5;
        this.dKn = new c(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.dKo);
        MessageManager.getInstance().registerListener(this.dKp);
        MessageManager.getInstance().registerListener(this.dKq);
        MessageManager.getInstance().registerListener(this.aky);
        MessageManager.getInstance().registerListener(this.dKr);
        aLg();
    }

    public View getView() {
        return this.dKn.getView();
    }

    public void qa() {
        if (this.dKn != null) {
            this.dKn.qa();
        }
    }

    public void aLg() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.bZ(this.Of);
            dVar.setParams();
            dVar.setTag(this.dFi);
            MessageManager.getInstance().sendMessage(dVar);
        } else if (this.dKn != null) {
            this.dKn.aLi();
        }
    }

    public void onDestroy() {
        this.dKn.onDestory();
        if (this.dKp != null) {
            MessageManager.getInstance().unRegisterListener(this.dKp);
        }
        if (this.dKq != null) {
            MessageManager.getInstance().unRegisterListener(this.dKq);
        }
        if (this.aky != null) {
            MessageManager.getInstance().unRegisterListener(this.aky);
        }
        if (this.dKr != null) {
            MessageManager.getInstance().unRegisterListener(this.dKr);
        }
    }
}
