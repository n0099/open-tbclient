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
    private BlueCircleProgressDialog aqD;
    private com.baidu.live.tieba.model.a eoj;
    private i eok;
    private a.InterfaceC0076a eol = new a.InterfaceC0076a() { // from class: com.baidu.tieba.ala.liveroom.share.c.1
    };
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void c(i iVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (iVar != null && iVar.Ps != null && iVar.mLiveInfo != null) {
            this.eok = iVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(iVar.Ps.userId + "", iVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, this.eok));
            }
        }
    }

    private void aVW() {
        if (this.aqD != null) {
            this.aqD.setDialogVisiable(false);
        }
    }

    public void nA() {
        aVW();
        if (this.eoj != null) {
            this.eoj.vp();
        }
    }

    public void onDestroy() {
        aVW();
        if (this.eoj != null) {
            this.eoj.vp();
            this.eoj.onDestroy();
        }
    }
}
