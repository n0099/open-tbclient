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
/* loaded from: classes4.dex */
public class d {
    private long aDf;
    private boolean aFD;
    private String aPZ;
    private com.baidu.live.guardclub.a bat;
    private GuardClubInfoActivity gdd;
    private boolean gde;
    private e gdf;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fUp = BdUniqueId.gen();
    private View.OnClickListener gdg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bLh();
        }
    };
    private HttpMessageListener gcP = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.gdf != null) {
                    d.this.gdf.bLk();
                }
            } else if (d.this.gdf != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fUp && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bat != null) {
                d.this.bat = guardClubInfoHttpResponseMessage.bat;
                d.this.gdf.a(guardClubInfoHttpResponseMessage.bat, guardClubInfoHttpResponseMessage.bau, guardClubInfoHttpResponseMessage.bav, guardClubInfoHttpResponseMessage.baw, guardClubInfoHttpResponseMessage.bay);
            }
        }
    };
    HttpMessageListener gcS = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.bat != null && d.this.bat.id == guardClubJoinHttpResponseMessage.baB) {
                        d.this.bLh();
                    }
                } else if (!guardClubJoinHttpResponseMessage.baE) {
                    guardClubJoinHttpResponseMessage.baE = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener gdh = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bat;
                if (aVar != null && d.this.bat != null && d.this.bat.id == aVar.id) {
                    if (d.this.gdf != null) {
                        d.this.gdf.FS(aVar.bag);
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
    private HttpMessageListener bmZ = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).Mn() != null) {
                    d.this.bLh();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gdd = guardClubInfoActivity;
        this.aDf = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aPZ = str;
        this.aFD = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gde = z4;
        this.isTranslucent = z5;
        this.gdf = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gdg);
        MessageManager.getInstance().registerListener(this.gcP);
        MessageManager.getInstance().registerListener(this.gcS);
        MessageManager.getInstance().registerListener(this.bmZ);
        MessageManager.getInstance().registerListener(this.gdh);
        bLh();
    }

    public View getView() {
        return this.gdf.getView();
    }

    public void FQ() {
        if (this.gdf != null) {
            this.gdf.FQ();
        }
    }

    public void bLh() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.aDf);
            bVar.setParams();
            bVar.setTag(this.fUp);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gdf != null) {
            this.gdf.bLk();
        }
    }

    public void onDestroy() {
        this.gdf.onDestory();
        if (this.gcP != null) {
            MessageManager.getInstance().unRegisterListener(this.gcP);
        }
        if (this.gcS != null) {
            MessageManager.getInstance().unRegisterListener(this.gcS);
        }
        if (this.bmZ != null) {
            MessageManager.getInstance().unRegisterListener(this.bmZ);
        }
        if (this.gdh != null) {
            MessageManager.getInstance().unRegisterListener(this.gdh);
        }
    }
}
