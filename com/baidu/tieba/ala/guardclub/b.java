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
    private long Vc;
    private boolean Wm;
    private String aej;
    private GuardClubInfoActivity eyA;
    private boolean eyB;
    private com.baidu.tieba.ala.guardclub.model.c eyC;
    private c eyD;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId erl = BdUniqueId.gen();
    private View.OnClickListener eyE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bcr();
        }
    };
    private HttpMessageListener eyF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (b.this.eyD != null) {
                    b.this.eyD.bcs();
                }
            } else if (b.this.eyD != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == b.this.erl && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.eyC != null) {
                b.this.eyC = guardClubInfoHttpResponseMessage.eyC;
                b.this.eyD.a(guardClubInfoHttpResponseMessage.eyC, guardClubInfoHttpResponseMessage.ezf, guardClubInfoHttpResponseMessage.eBA, guardClubInfoHttpResponseMessage.ezi, guardClubInfoHttpResponseMessage.eBC);
            }
        }
    };
    HttpMessageListener eyG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.3
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
                    if (b.this.eyC != null && b.this.eyC.id == guardClubJoinHttpResponseMessage.eBH) {
                        b.this.bcr();
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
    HttpMessageListener eyH = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.b.4
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
                com.baidu.tieba.ala.guardclub.model.c cVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).eyC;
                if (cVar != null && b.this.eyC != null && b.this.eyC.id == cVar.id) {
                    if (b.this.eyD != null) {
                        b.this.eyD.xU(cVar.eBo);
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
    private HttpMessageListener asC = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).wo() != null) {
                    b.this.bcr();
                }
            }
        }
    };

    public b(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.eyA = guardClubInfoActivity;
        this.Vc = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aej = str;
        this.Wm = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.eyB = z4;
        this.isTranslucent = z5;
        this.eyD = new c(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.eyE);
        MessageManager.getInstance().registerListener(this.eyF);
        MessageManager.getInstance().registerListener(this.eyG);
        MessageManager.getInstance().registerListener(this.asC);
        MessageManager.getInstance().registerListener(this.eyH);
        bcr();
    }

    public View getView() {
        return this.eyD.getView();
    }

    public void rC() {
        if (this.eyD != null) {
            this.eyD.rC();
        }
    }

    public void bcr() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.cu(this.Vc);
            dVar.setParams();
            dVar.setTag(this.erl);
            MessageManager.getInstance().sendMessage(dVar);
        } else if (this.eyD != null) {
            this.eyD.bcs();
        }
    }

    public void onDestroy() {
        this.eyD.onDestory();
        if (this.eyF != null) {
            MessageManager.getInstance().unRegisterListener(this.eyF);
        }
        if (this.eyG != null) {
            MessageManager.getInstance().unRegisterListener(this.eyG);
        }
        if (this.asC != null) {
            MessageManager.getInstance().unRegisterListener(this.asC);
        }
        if (this.eyH != null) {
            MessageManager.getInstance().unRegisterListener(this.eyH);
        }
    }
}
