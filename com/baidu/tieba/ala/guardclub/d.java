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
    private GuardClubInfoActivity fxh;
    private boolean fxi;
    private e fxj;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fpn = BdUniqueId.gen();
    private View.OnClickListener fxk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bup();
        }
    };
    private HttpMessageListener fwT = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fxj != null) {
                    d.this.fxj.bus();
                }
            } else if (d.this.fxj != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fpn && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aOG != null) {
                d.this.aOG = guardClubInfoHttpResponseMessage.aOG;
                d.this.fxj.a(guardClubInfoHttpResponseMessage.aOG, guardClubInfoHttpResponseMessage.aOH, guardClubInfoHttpResponseMessage.aOI, guardClubInfoHttpResponseMessage.aOJ, guardClubInfoHttpResponseMessage.aOL);
            }
        }
    };
    HttpMessageListener fwW = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                        d.this.bup();
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
    HttpMessageListener fxl = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                    if (d.this.fxj != null) {
                        d.this.fxj.BO(aVar.aOu);
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
                    d.this.bup();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.fxh = guardClubInfoActivity;
        this.aul = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aEX = str;
        this.avR = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fxi = z4;
        this.isTranslucent = z5;
        this.fxj = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.fxk);
        MessageManager.getInstance().registerListener(this.fwT);
        MessageManager.getInstance().registerListener(this.fwW);
        MessageManager.getInstance().registerListener(this.aYS);
        MessageManager.getInstance().registerListener(this.fxl);
        bup();
    }

    public View getView() {
        return this.fxj.getView();
    }

    public void yL() {
        if (this.fxj != null) {
            this.fxj.yL();
        }
    }

    public void bup() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.aul);
            bVar.setParams();
            bVar.setTag(this.fpn);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fxj != null) {
            this.fxj.bus();
        }
    }

    public void onDestroy() {
        this.fxj.onDestory();
        if (this.fwT != null) {
            MessageManager.getInstance().unRegisterListener(this.fwT);
        }
        if (this.fwW != null) {
            MessageManager.getInstance().unRegisterListener(this.fwW);
        }
        if (this.aYS != null) {
            MessageManager.getInstance().unRegisterListener(this.aYS);
        }
        if (this.fxl != null) {
            MessageManager.getInstance().unRegisterListener(this.fxl);
        }
    }
}
