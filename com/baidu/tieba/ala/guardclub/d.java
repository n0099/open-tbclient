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
    private GuardClubInfoActivity eEf;
    private boolean eEg;
    private e eEh;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId ewH = BdUniqueId.gen();
    private View.OnClickListener eEi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.beZ();
        }
    };
    private HttpMessageListener eDR = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.eEh != null) {
                    d.this.eEh.bfb();
                }
            } else if (d.this.eEh != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.ewH && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.apX != null) {
                d.this.apX = guardClubInfoHttpResponseMessage.apX;
                d.this.eEh.a(guardClubInfoHttpResponseMessage.apX, guardClubInfoHttpResponseMessage.apY, guardClubInfoHttpResponseMessage.apZ, guardClubInfoHttpResponseMessage.aqa, guardClubInfoHttpResponseMessage.aqc);
            }
        }
    };
    HttpMessageListener eDU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                        d.this.beZ();
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
    HttpMessageListener eEj = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                    if (d.this.eEh != null) {
                        d.this.eEh.yu(aVar.apL);
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
    private HttpMessageListener axE = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).yW() != null) {
                    d.this.beZ();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.eEf = guardClubInfoActivity;
        this.WZ = j;
        this.liveId = j2;
        this.roomId = j3;
        this.agZ = str;
        this.Yr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.eEg = z4;
        this.isTranslucent = z5;
        this.eEh = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.eEi);
        MessageManager.getInstance().registerListener(this.eDR);
        MessageManager.getInstance().registerListener(this.eDU);
        MessageManager.getInstance().registerListener(this.axE);
        MessageManager.getInstance().registerListener(this.eEj);
        beZ();
    }

    public View getView() {
        return this.eEh.getView();
    }

    public void ta() {
        if (this.eEh != null) {
            this.eEh.ta();
        }
    }

    public void beZ() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.D(this.WZ);
            bVar.setParams();
            bVar.setTag(this.ewH);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.eEh != null) {
            this.eEh.bfb();
        }
    }

    public void onDestroy() {
        this.eEh.onDestory();
        if (this.eDR != null) {
            MessageManager.getInstance().unRegisterListener(this.eDR);
        }
        if (this.eDU != null) {
            MessageManager.getInstance().unRegisterListener(this.eDU);
        }
        if (this.axE != null) {
            MessageManager.getInstance().unRegisterListener(this.axE);
        }
        if (this.eEj != null) {
            MessageManager.getInstance().unRegisterListener(this.eEj);
        }
    }
}
