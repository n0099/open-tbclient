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
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoRenameResponseMessage;
/* loaded from: classes3.dex */
public class d {
    private String aEX;
    private com.baidu.live.guardclub.a aOG;
    private long aul;
    private boolean avR;
    private GuardClubInfoActivity fwW;
    private boolean fwX;
    private e fwY;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fpc = BdUniqueId.gen();
    private View.OnClickListener fwZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bun();
        }
    };
    private HttpMessageListener fwI = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fwY != null) {
                    d.this.fwY.buq();
                }
            } else if (d.this.fwY != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fpc && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aOG != null) {
                d.this.aOG = guardClubInfoHttpResponseMessage.aOG;
                d.this.fwY.a(guardClubInfoHttpResponseMessage.aOG, guardClubInfoHttpResponseMessage.aOH, guardClubInfoHttpResponseMessage.aOI, guardClubInfoHttpResponseMessage.aOJ, guardClubInfoHttpResponseMessage.aOL);
            }
        }
    };
    HttpMessageListener fwL = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aOG != null && d.this.aOG.id == guardClubJoinHttpResponseMessage.aOO) {
                        d.this.bun();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aOR) {
                    guardClubJoinHttpResponseMessage.aOR = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener fxa = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aOG;
                if (aVar != null && d.this.aOG != null && d.this.aOG.id == aVar.id) {
                    if (d.this.fwY != null) {
                        d.this.fwY.BO(aVar.aOu);
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
    private HttpMessageListener aYS = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).Fu() != null) {
                    d.this.bun();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.fwW = guardClubInfoActivity;
        this.aul = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aEX = str;
        this.avR = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fwX = z4;
        this.isTranslucent = z5;
        this.fwY = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.fwZ);
        MessageManager.getInstance().registerListener(this.fwI);
        MessageManager.getInstance().registerListener(this.fwL);
        MessageManager.getInstance().registerListener(this.aYS);
        MessageManager.getInstance().registerListener(this.fxa);
        bun();
    }

    public View getView() {
        return this.fwY.getView();
    }

    public void yL() {
        if (this.fwY != null) {
            this.fwY.yL();
        }
    }

    public void bun() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.aul);
            bVar.setParams();
            bVar.setTag(this.fpc);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fwY != null) {
            this.fwY.buq();
        }
    }

    public void onDestroy() {
        this.fwY.onDestory();
        if (this.fwI != null) {
            MessageManager.getInstance().unRegisterListener(this.fwI);
        }
        if (this.fwL != null) {
            MessageManager.getInstance().unRegisterListener(this.fwL);
        }
        if (this.aYS != null) {
            MessageManager.getInstance().unRegisterListener(this.aYS);
        }
        if (this.fxa != null) {
            MessageManager.getInstance().unRegisterListener(this.fxa);
        }
    }
}
