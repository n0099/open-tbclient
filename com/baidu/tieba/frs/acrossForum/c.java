package com.baidu.tieba.frs.acrossForum;

import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private static final int bWD = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds160);
    private String aRN;
    private AcrossForumViewData aVF;
    private FrsActivity bTA;
    private GifView bWE;
    private String bWG;
    private boolean bWF = true;
    private Runnable bWH = new d(this);
    private View.OnClickListener mOnClickListener = new f(this);
    private CustomMessageListener bWI = new g(this, CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE);

    public c(FrsActivity frsActivity, AcrossForumViewData acrossForumViewData) {
        this.bTA = frsActivity;
        this.aVF = acrossForumViewData;
    }

    public void aaf() {
        if (this.bTA.abZ() != null && this.bTA.acr() != null) {
            if (this.aVF == null && this.bTA.acr().aOk() != null && this.bTA.acr().aOk().mAcrossForumIcon != null && !StringUtils.isNull(this.bTA.acr().aOk().mAcrossForumIcon.icon_url)) {
                init();
            } else {
                this.bTA.abZ().acL();
            }
        }
    }

    private void init() {
        if (this.bWE == null && this.bTA.abZ().adf() != null) {
            this.bWG = this.bTA.acr().aOk().getName();
            this.aRN = this.bTA.acr().aOk().getId();
            String str = this.bTA.acr().aOk().mAcrossForumIcon.icon_url;
            com.baidu.adp.lib.g.c.eA().a(str, 20, new h(this, str), 0, 0, this.bTA.getUniqueId(), "", str, true, str);
            this.bTA.registerListener(this.bWI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adS() {
        if (this.bWE != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bWE, View.TRANSLATION_X, bWD, 0.0f);
            ofFloat.addListener(new i(this));
            ofFloat.setDuration(500L).start();
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bWH);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bWH, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
