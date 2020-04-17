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
    private com.baidu.live.guardclub.a aIR;
    private long apl;
    private boolean aqL;
    private String azz;
    private GuardClubInfoActivity fjk;
    private boolean fjl;
    private e fjm;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fbv = BdUniqueId.gen();
    private View.OnClickListener fjn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.box();
        }
    };
    private HttpMessageListener fiW = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fjm != null) {
                    d.this.fjm.boA();
                }
            } else if (d.this.fjm != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fbv && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aIR != null) {
                d.this.aIR = guardClubInfoHttpResponseMessage.aIR;
                d.this.fjm.a(guardClubInfoHttpResponseMessage.aIR, guardClubInfoHttpResponseMessage.aIS, guardClubInfoHttpResponseMessage.aIT, guardClubInfoHttpResponseMessage.aIU, guardClubInfoHttpResponseMessage.aIW);
            }
        }
    };
    HttpMessageListener fiZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aIR != null && d.this.aIR.id == guardClubJoinHttpResponseMessage.aIZ) {
                        d.this.box();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aJc) {
                    guardClubJoinHttpResponseMessage.aJc = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener fjo = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aIR;
                if (aVar != null && d.this.aIR != null && d.this.aIR.id == aVar.id) {
                    if (d.this.fjm != null) {
                        d.this.fjm.Ae(aVar.aIF);
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
    private HttpMessageListener aRz = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).DX() != null) {
                    d.this.box();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.fjk = guardClubInfoActivity;
        this.apl = j;
        this.liveId = j2;
        this.roomId = j3;
        this.azz = str;
        this.aqL = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fjl = z4;
        this.isTranslucent = z5;
        this.fjm = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.fjn);
        MessageManager.getInstance().registerListener(this.fiW);
        MessageManager.getInstance().registerListener(this.fiZ);
        MessageManager.getInstance().registerListener(this.aRz);
        MessageManager.getInstance().registerListener(this.fjo);
        box();
    }

    public View getView() {
        return this.fjm.getView();
    }

    public void xy() {
        if (this.fjm != null) {
            this.fjm.xy();
        }
    }

    public void box() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ab(this.apl);
            bVar.setParams();
            bVar.setTag(this.fbv);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fjm != null) {
            this.fjm.boA();
        }
    }

    public void onDestroy() {
        this.fjm.onDestory();
        if (this.fiW != null) {
            MessageManager.getInstance().unRegisterListener(this.fiW);
        }
        if (this.fiZ != null) {
            MessageManager.getInstance().unRegisterListener(this.fiZ);
        }
        if (this.aRz != null) {
            MessageManager.getInstance().unRegisterListener(this.aRz);
        }
        if (this.fjo != null) {
            MessageManager.getInstance().unRegisterListener(this.fjo);
        }
    }
}
