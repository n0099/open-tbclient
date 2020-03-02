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
    private BlueCircleProgressDialog aDa;
    private com.baidu.live.tieba.model.a fkf;
    private m fkg;
    private a.InterfaceC0099a fkh = new a.InterfaceC0099a() { // from class: com.baidu.tieba.ala.liveroom.share.c.1
    };
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void c(m mVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (mVar != null && mVar.XQ != null && mVar.mLiveInfo != null) {
            this.fkg = mVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(mVar.XQ.userId + "", mVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                n nVar = new n();
                if (this.mPageContext != null) {
                    nVar.activity = this.mPageContext.getPageActivity();
                }
                nVar.Yq = this.fkg;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, nVar));
            }
        }
    }

    private void bqr() {
        if (this.aDa != null) {
            this.aDa.setDialogVisiable(false);
        }
    }

    public void pK() {
        bqr();
        if (this.fkf != null) {
            this.fkf.zX();
        }
    }

    public void onDestroy() {
        bqr();
        if (this.fkf != null) {
            this.fkf.zX();
            this.fkf.onDestroy();
        }
    }
}
