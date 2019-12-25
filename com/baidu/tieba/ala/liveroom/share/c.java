package com.baidu.tieba.ala.liveroom.share;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.model.a;
/* loaded from: classes2.dex */
public class c {
    private BlueCircleProgressDialog aya;
    private com.baidu.live.tieba.model.a fdS;
    private k fdT;
    private a.InterfaceC0092a fdU = new a.InterfaceC0092a() { // from class: com.baidu.tieba.ala.liveroom.share.c.1
    };
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void c(k kVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (kVar != null && kVar.VP != null && kVar.mLiveInfo != null) {
            this.fdT = kVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(kVar.VP.userId + "", kVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, this.fdT));
            }
        }
    }

    private void bnJ() {
        if (this.aya != null) {
            this.aya.setDialogVisiable(false);
        }
    }

    public void oS() {
        bnJ();
        if (this.fdS != null) {
            this.fdS.xo();
        }
    }

    public void onDestroy() {
        bnJ();
        if (this.fdS != null) {
            this.fdS.xo();
            this.fdS.onDestroy();
        }
    }
}
