package com.baidu.tieba.ala.liveroom.share;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.model.a;
/* loaded from: classes6.dex */
public class c {
    private BlueCircleProgressDialog aql;
    private com.baidu.live.tieba.model.a enr;
    private i ens;
    private a.InterfaceC0076a ent = new a.InterfaceC0076a() { // from class: com.baidu.tieba.ala.liveroom.share.c.1
    };
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void c(i iVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (iVar != null && iVar.OR != null && iVar.mLiveInfo != null) {
            this.ens = iVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(iVar.OR.userId + "", iVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, this.ens));
            }
        }
    }

    private void aVU() {
        if (this.aql != null) {
            this.aql.setDialogVisiable(false);
        }
    }

    public void nA() {
        aVU();
        if (this.enr != null) {
            this.enr.vq();
        }
    }

    public void onDestroy() {
        aVU();
        if (this.enr != null) {
            this.enr.vq();
            this.enr.onDestroy();
        }
    }
}
