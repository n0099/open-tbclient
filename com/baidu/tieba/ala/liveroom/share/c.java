package com.baidu.tieba.ala.liveroom.share;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.m;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.model.a;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private BlueCircleProgressDialog aDp;
    private com.baidu.live.tieba.model.a fkR;
    private m fkS;
    private a.InterfaceC0099a fkT = new a.InterfaceC0099a() { // from class: com.baidu.tieba.ala.liveroom.share.c.1
    };
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void c(m mVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (mVar != null && mVar.Ya != null && mVar.mLiveInfo != null) {
            this.fkS = mVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(mVar.Ya.userId + "", mVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                n nVar = new n();
                if (this.mPageContext != null) {
                    nVar.activity = this.mPageContext.getPageActivity();
                }
                nVar.YA = this.fkS;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, nVar));
            }
        }
    }

    private void bqx() {
        if (this.aDp != null) {
            this.aDp.setDialogVisiable(false);
        }
    }

    public void pP() {
        bqx();
        if (this.fkR != null) {
            this.fkR.Ae();
        }
    }

    public void onDestroy() {
        bqx();
        if (this.fkR != null) {
            this.fkR.Ae();
            this.fkR.onDestroy();
        }
    }
}
