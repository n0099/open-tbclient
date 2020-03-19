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
    private long Xj;
    private boolean YB;
    private String ahj;
    private com.baidu.live.guardclub.a aqi;
    private GuardClubInfoActivity eEP;
    private boolean eEQ;
    private e eER;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId exr = BdUniqueId.gen();
    private View.OnClickListener eES = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bfh();
        }
    };
    private HttpMessageListener eEB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.eER != null) {
                    d.this.eER.bfj();
                }
            } else if (d.this.eER != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.exr && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aqi != null) {
                d.this.aqi = guardClubInfoHttpResponseMessage.aqi;
                d.this.eER.a(guardClubInfoHttpResponseMessage.aqi, guardClubInfoHttpResponseMessage.aqj, guardClubInfoHttpResponseMessage.aqk, guardClubInfoHttpResponseMessage.aql, guardClubInfoHttpResponseMessage.aqn);
            }
        }
    };
    HttpMessageListener eEE = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aqi != null && d.this.aqi.id == guardClubJoinHttpResponseMessage.aqq) {
                        d.this.bfh();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aqt) {
                    guardClubJoinHttpResponseMessage.aqt = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener eET = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aqi;
                if (aVar != null && d.this.aqi != null && d.this.aqi.id == aVar.id) {
                    if (d.this.eER != null) {
                        d.this.eER.yw(aVar.apW);
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
    private HttpMessageListener axU = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).zc() != null) {
                    d.this.bfh();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.eEP = guardClubInfoActivity;
        this.Xj = j;
        this.liveId = j2;
        this.roomId = j3;
        this.ahj = str;
        this.YB = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.eEQ = z4;
        this.isTranslucent = z5;
        this.eER = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.eES);
        MessageManager.getInstance().registerListener(this.eEB);
        MessageManager.getInstance().registerListener(this.eEE);
        MessageManager.getInstance().registerListener(this.axU);
        MessageManager.getInstance().registerListener(this.eET);
        bfh();
    }

    public View getView() {
        return this.eER.getView();
    }

    public void tf() {
        if (this.eER != null) {
            this.eER.tf();
        }
    }

    public void bfh() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.D(this.Xj);
            bVar.setParams();
            bVar.setTag(this.exr);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.eER != null) {
            this.eER.bfj();
        }
    }

    public void onDestroy() {
        this.eER.onDestory();
        if (this.eEB != null) {
            MessageManager.getInstance().unRegisterListener(this.eEB);
        }
        if (this.eEE != null) {
            MessageManager.getInstance().unRegisterListener(this.eEE);
        }
        if (this.axU != null) {
            MessageManager.getInstance().unRegisterListener(this.axU);
        }
        if (this.eET != null) {
            MessageManager.getInstance().unRegisterListener(this.eET);
        }
    }
}
