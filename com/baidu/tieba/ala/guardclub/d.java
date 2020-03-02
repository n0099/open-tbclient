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
    private long WZ;
    private boolean Yr;
    private String agZ;
    private com.baidu.live.guardclub.a apX;
    private GuardClubInfoActivity eEg;
    private boolean eEh;
    private e eEi;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId ewI = BdUniqueId.gen();
    private View.OnClickListener eEj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bfb();
        }
    };
    private HttpMessageListener eDS = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.eEi != null) {
                    d.this.eEi.bfd();
                }
            } else if (d.this.eEi != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.ewI && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.apX != null) {
                d.this.apX = guardClubInfoHttpResponseMessage.apX;
                d.this.eEi.a(guardClubInfoHttpResponseMessage.apX, guardClubInfoHttpResponseMessage.apY, guardClubInfoHttpResponseMessage.apZ, guardClubInfoHttpResponseMessage.aqa, guardClubInfoHttpResponseMessage.aqc);
            }
        }
    };
    HttpMessageListener eDV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.apX != null && d.this.apX.id == guardClubJoinHttpResponseMessage.aqf) {
                        d.this.bfb();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aqi) {
                    guardClubJoinHttpResponseMessage.aqi = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener eEk = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).apX;
                if (aVar != null && d.this.apX != null && d.this.apX.id == aVar.id) {
                    if (d.this.eEi != null) {
                        d.this.eEi.yu(aVar.apL);
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
    private HttpMessageListener axF = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).yX() != null) {
                    d.this.bfb();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.eEg = guardClubInfoActivity;
        this.WZ = j;
        this.liveId = j2;
        this.roomId = j3;
        this.agZ = str;
        this.Yr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.eEh = z4;
        this.isTranslucent = z5;
        this.eEi = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.eEj);
        MessageManager.getInstance().registerListener(this.eDS);
        MessageManager.getInstance().registerListener(this.eDV);
        MessageManager.getInstance().registerListener(this.axF);
        MessageManager.getInstance().registerListener(this.eEk);
        bfb();
    }

    public View getView() {
        return this.eEi.getView();
    }

    public void ta() {
        if (this.eEi != null) {
            this.eEi.ta();
        }
    }

    public void bfb() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.D(this.WZ);
            bVar.setParams();
            bVar.setTag(this.ewI);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.eEi != null) {
            this.eEi.bfd();
        }
    }

    public void onDestroy() {
        this.eEi.onDestory();
        if (this.eDS != null) {
            MessageManager.getInstance().unRegisterListener(this.eDS);
        }
        if (this.eDV != null) {
            MessageManager.getInstance().unRegisterListener(this.eDV);
        }
        if (this.axF != null) {
            MessageManager.getInstance().unRegisterListener(this.axF);
        }
        if (this.eEk != null) {
            MessageManager.getInstance().unRegisterListener(this.eEk);
        }
    }
}
