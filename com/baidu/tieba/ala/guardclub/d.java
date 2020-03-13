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
    private com.baidu.live.guardclub.a apY;
    private GuardClubInfoActivity eEt;
    private boolean eEu;
    private e eEv;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId ewV = BdUniqueId.gen();
    private View.OnClickListener eEw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bfc();
        }
    };
    private HttpMessageListener eEf = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.eEv != null) {
                    d.this.eEv.bfe();
                }
            } else if (d.this.eEv != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.ewV && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.apY != null) {
                d.this.apY = guardClubInfoHttpResponseMessage.apY;
                d.this.eEv.a(guardClubInfoHttpResponseMessage.apY, guardClubInfoHttpResponseMessage.apZ, guardClubInfoHttpResponseMessage.aqa, guardClubInfoHttpResponseMessage.aqb, guardClubInfoHttpResponseMessage.aqd);
            }
        }
    };
    HttpMessageListener eEi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.apY != null && d.this.apY.id == guardClubJoinHttpResponseMessage.aqg) {
                        d.this.bfc();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aqj) {
                    guardClubJoinHttpResponseMessage.aqj = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener eEx = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).apY;
                if (aVar != null && d.this.apY != null && d.this.apY.id == aVar.id) {
                    if (d.this.eEv != null) {
                        d.this.eEv.yv(aVar.apM);
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
    private HttpMessageListener axG = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).yX() != null) {
                    d.this.bfc();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.eEt = guardClubInfoActivity;
        this.WZ = j;
        this.liveId = j2;
        this.roomId = j3;
        this.agZ = str;
        this.Yr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.eEu = z4;
        this.isTranslucent = z5;
        this.eEv = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.eEw);
        MessageManager.getInstance().registerListener(this.eEf);
        MessageManager.getInstance().registerListener(this.eEi);
        MessageManager.getInstance().registerListener(this.axG);
        MessageManager.getInstance().registerListener(this.eEx);
        bfc();
    }

    public View getView() {
        return this.eEv.getView();
    }

    public void ta() {
        if (this.eEv != null) {
            this.eEv.ta();
        }
    }

    public void bfc() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.D(this.WZ);
            bVar.setParams();
            bVar.setTag(this.ewV);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.eEv != null) {
            this.eEv.bfe();
        }
    }

    public void onDestroy() {
        this.eEv.onDestory();
        if (this.eEf != null) {
            MessageManager.getInstance().unRegisterListener(this.eEf);
        }
        if (this.eEi != null) {
            MessageManager.getInstance().unRegisterListener(this.eEi);
        }
        if (this.axG != null) {
            MessageManager.getInstance().unRegisterListener(this.axG);
        }
        if (this.eEx != null) {
            MessageManager.getInstance().unRegisterListener(this.eEx);
        }
    }
}
