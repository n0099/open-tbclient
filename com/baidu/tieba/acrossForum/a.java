package com.baidu.tieba.acrossForum;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.acrossForum.message.AcrossForumRequestMsg;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a {
    private static a aUV;
    private TbPageContext Gf;
    public AcrossForumViewData aUW;
    public String aUX;
    private boolean aUY;
    private com.baidu.adp.framework.listener.a aUZ = new b(this, CmdConfigHttp.CMD_ACROSS_FORUM, 309424);

    public static a Ml() {
        if (aUV == null) {
            aUV = new a();
        }
        return aUV;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.aUZ);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (tbPageContext != null && !StringUtils.isNull(str)) {
            if (!i.fZ()) {
                tbPageContext.showToast(r.j.neterror);
                return;
            }
            this.aUX = str;
            AcrossForumRequestMsg acrossForumRequestMsg = new AcrossForumRequestMsg();
            acrossForumRequestMsg.callFrom = str;
            acrossForumRequestMsg.forumName = str2;
            MessageManager.getInstance().sendMessage(acrossForumRequestMsg);
            if (Mm()) {
                this.aUY = true;
            } else {
                try {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN, Boolean.class, 1);
                    if (runTask == null || runTask.getData() == null) {
                        this.aUY = false;
                    } else {
                        this.aUY = ((Boolean) runTask.getData()).booleanValue();
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                    this.aUY = false;
                }
            }
            if (this.aUY) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ACROSS_FORUM_VR_OPEN, tbPageContext));
                return;
            }
            this.Gf = tbPageContext;
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.across_forum_ing);
        }
    }

    public void aw(Context context) {
        if (this.aUW == null || StringUtils.isNull(this.aUW.forumName)) {
            k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.across_forum_to_frs_error);
            return;
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(this.aUW.forumName, null);
        createNormalCfg.setIsFromAcrossForum(this.aUW);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
        this.aUW = null;
    }

    public boolean Mm() {
        return StringUtils.isNull(this.aUX) || this.aUX.equals("startvr");
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.aUZ);
        this.Gf = null;
        aUV = null;
    }
}
