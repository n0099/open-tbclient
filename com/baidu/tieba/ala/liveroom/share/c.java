package com.baidu.tieba.ala.liveroom.share;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.l;
import com.baidu.live.data.m;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.model.a;
/* loaded from: classes2.dex */
public class c {
    private BlueCircleProgressDialog ayJ;
    private com.baidu.live.tieba.model.a fgY;
    private l fgZ;
    private a.InterfaceC0093a fha = new a.InterfaceC0093a() { // from class: com.baidu.tieba.ala.liveroom.share.c.1
    };
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void c(l lVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (lVar != null && lVar.Wf != null && lVar.mLiveInfo != null) {
            this.fgZ = lVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(lVar.Wf.userId + "", lVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                m mVar = new m();
                if (this.mPageContext != null) {
                    mVar.activity = this.mPageContext.getPageActivity();
                }
                mVar.WE = this.fgZ;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, mVar));
            }
        }
    }

    private void boJ() {
        if (this.ayJ != null) {
            this.ayJ.setDialogVisiable(false);
        }
    }

    public void oZ() {
        boJ();
        if (this.fgY != null) {
            this.fgY.xE();
        }
    }

    public void onDestroy() {
        boJ();
        if (this.fgY != null) {
            this.fgY.xE();
            this.fgY.onDestroy();
        }
    }
}
