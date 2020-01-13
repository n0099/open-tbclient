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
/* loaded from: classes2.dex */
public class b {
    private long Vt;
    private boolean WF;
    private String aeS;
    private GuardClubInfoActivity ezL;
    private boolean ezM;
    private com.baidu.tieba.ala.guardclub.model.c ezN;
    private c ezO;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId esx = BdUniqueId.gen();
    private View.OnClickListener ezP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bcM();
        }
    };
    private HttpMessageListener ezQ = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (b.this.ezO != null) {
                    b.this.ezO.bcN();
                }
            } else if (b.this.ezO != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == b.this.esx && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.ezN != null) {
                b.this.ezN = guardClubInfoHttpResponseMessage.ezN;
                b.this.ezO.a(guardClubInfoHttpResponseMessage.ezN, guardClubInfoHttpResponseMessage.eAq, guardClubInfoHttpResponseMessage.eCL, guardClubInfoHttpResponseMessage.eAt, guardClubInfoHttpResponseMessage.eCN);
            }
        }
    };
    HttpMessageListener ezR = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.3
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
                    if (b.this.ezN != null && b.this.ezN.id == guardClubJoinHttpResponseMessage.eCS) {
                        b.this.bcM();
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
    HttpMessageListener ezS = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.b.4
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
                com.baidu.tieba.ala.guardclub.model.c cVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).ezN;
                if (cVar != null && b.this.ezN != null && b.this.ezN.id == cVar.id) {
                    if (b.this.ezO != null) {
                        b.this.ezO.xZ(cVar.eCz);
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
    private HttpMessageListener ato = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).wF() != null) {
                    b.this.bcM();
                }
            }
        }
    };

    public b(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.ezL = guardClubInfoActivity;
        this.Vt = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aeS = str;
        this.WF = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.ezM = z4;
        this.isTranslucent = z5;
        this.ezO = new c(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.ezP);
        MessageManager.getInstance().registerListener(this.ezQ);
        MessageManager.getInstance().registerListener(this.ezR);
        MessageManager.getInstance().registerListener(this.ato);
        MessageManager.getInstance().registerListener(this.ezS);
        bcM();
    }

    public View getView() {
        return this.ezO.getView();
    }

    public void rP() {
        if (this.ezO != null) {
            this.ezO.rP();
        }
    }

    public void bcM() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.cz(this.Vt);
            dVar.setParams();
            dVar.setTag(this.esx);
            MessageManager.getInstance().sendMessage(dVar);
        } else if (this.ezO != null) {
            this.ezO.bcN();
        }
    }

    public void onDestroy() {
        this.ezO.onDestory();
        if (this.ezQ != null) {
            MessageManager.getInstance().unRegisterListener(this.ezQ);
        }
        if (this.ezR != null) {
            MessageManager.getInstance().unRegisterListener(this.ezR);
        }
        if (this.ato != null) {
            MessageManager.getInstance().unRegisterListener(this.ato);
        }
        if (this.ezS != null) {
            MessageManager.getInstance().unRegisterListener(this.ezS);
        }
    }
}
