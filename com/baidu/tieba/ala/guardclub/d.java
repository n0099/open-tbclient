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
    private com.baidu.live.guardclub.a aIX;
    private long aps;
    private boolean aqR;
    private String azF;
    private GuardClubInfoActivity fjp;
    private boolean fjq;
    private e fjr;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fbA = BdUniqueId.gen();
    private View.OnClickListener fjs = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bov();
        }
    };
    private HttpMessageListener fjb = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fjr != null) {
                    d.this.fjr.boy();
                }
            } else if (d.this.fjr != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fbA && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aIX != null) {
                d.this.aIX = guardClubInfoHttpResponseMessage.aIX;
                d.this.fjr.a(guardClubInfoHttpResponseMessage.aIX, guardClubInfoHttpResponseMessage.aIY, guardClubInfoHttpResponseMessage.aIZ, guardClubInfoHttpResponseMessage.aJa, guardClubInfoHttpResponseMessage.aJc);
            }
        }
    };
    HttpMessageListener fje = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aIX != null && d.this.aIX.id == guardClubJoinHttpResponseMessage.aJf) {
                        d.this.bov();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aJi) {
                    guardClubJoinHttpResponseMessage.aJi = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener fjt = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aIX;
                if (aVar != null && d.this.aIX != null && d.this.aIX.id == aVar.id) {
                    if (d.this.fjr != null) {
                        d.this.fjr.Ah(aVar.aIL);
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
    private HttpMessageListener aRE = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).DW() != null) {
                    d.this.bov();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.fjp = guardClubInfoActivity;
        this.aps = j;
        this.liveId = j2;
        this.roomId = j3;
        this.azF = str;
        this.aqR = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fjq = z4;
        this.isTranslucent = z5;
        this.fjr = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.fjs);
        MessageManager.getInstance().registerListener(this.fjb);
        MessageManager.getInstance().registerListener(this.fje);
        MessageManager.getInstance().registerListener(this.aRE);
        MessageManager.getInstance().registerListener(this.fjt);
        bov();
    }

    public View getView() {
        return this.fjr.getView();
    }

    public void xx() {
        if (this.fjr != null) {
            this.fjr.xx();
        }
    }

    public void bov() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ab(this.aps);
            bVar.setParams();
            bVar.setTag(this.fbA);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fjr != null) {
            this.fjr.boy();
        }
    }

    public void onDestroy() {
        this.fjr.onDestory();
        if (this.fjb != null) {
            MessageManager.getInstance().unRegisterListener(this.fjb);
        }
        if (this.fje != null) {
            MessageManager.getInstance().unRegisterListener(this.fje);
        }
        if (this.aRE != null) {
            MessageManager.getInstance().unRegisterListener(this.aRE);
        }
        if (this.fjt != null) {
            MessageManager.getInstance().unRegisterListener(this.fjt);
        }
    }
}
