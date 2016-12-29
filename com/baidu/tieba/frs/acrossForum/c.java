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
    private static final int bCN = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds160);
    private String aRe;
    private AcrossForumViewData aUW;
    private GifView bCO;
    private String bCQ;
    private FrsActivity bzH;
    private boolean bCP = true;
    private Runnable bCR = new d(this);
    private View.OnClickListener mOnClickListener = new f(this);
    private CustomMessageListener bCS = new g(this, CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE);

    public c(FrsActivity frsActivity, AcrossForumViewData acrossForumViewData) {
        this.bzH = frsActivity;
        this.aUW = acrossForumViewData;
    }

    public void Us() {
        if (this.bzH.Wo() != null && this.bzH.WF() != null) {
            if (this.aUW == null && this.bzH.WF().aIk() != null && this.bzH.WF().aIk().mAcrossForumIcon != null && !StringUtils.isNull(this.bzH.WF().aIk().mAcrossForumIcon.icon_url)) {
                init();
            } else {
                this.bzH.Wo().WY();
            }
        }
    }

    private void init() {
        if (this.bCO == null && this.bzH.Wo().Xv() != null) {
            this.bCQ = this.bzH.WF().aIk().getName();
            this.aRe = this.bzH.WF().aIk().getId();
            String str = this.bzH.WF().aIk().mAcrossForumIcon.icon_url;
            com.baidu.adp.lib.g.c.eA().a(str, 20, new h(this, str), 0, 0, this.bzH.getUniqueId(), "", str, true, str);
            this.bzH.registerListener(this.bCS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ym() {
        if (this.bCO != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bCO, View.TRANSLATION_X, bCN, 0.0f);
            ofFloat.addListener(new i(this));
            ofFloat.setDuration(500L).start();
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bCR);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bCR, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
