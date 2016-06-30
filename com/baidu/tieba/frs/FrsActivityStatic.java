package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumHttpResponsedMsg;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumSocketResponsedMsg;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListHttpResponseMessage;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListSocketResponseMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean bDN = true;
    public static boolean bDO = true;
    public static final CustomMessageListener bDP = new au(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bDQ = new av(CmdConfigCustom.MSG_READ);

    static {
        VT();
        VU();
        VV();
        VW();
        VX();
        MessageManager.getInstance().registerListener(bDP);
        MessageManager.getInstance().registerListener(bDQ);
        a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, a.aF(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.bcY();
        aw awVar = new aw();
        awVar.setSelfExecute(true);
        awVar.setPriority(4);
        awVar.execute(new Void[0]);
    }

    private static void VT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new ax());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void VU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new ay());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void VV() {
        com.baidu.tbadk.core.util.bi.us().a(new az());
    }

    private static void VW() {
        a.b(CmdConfigHttp.GET_FRS_TAB_FOLLOW_POST_NUM, 309346, TbConfig.GET_FRS_TAB_FOLLOW_POST_NUM, GetFrsTabFollowPostNumHttpResponsedMsg.class, GetFrsTabFollowPostNumSocketResponsedMsg.class);
    }

    private static void VX() {
        a.a(309387, ForumHeadVideoListSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, a.aF(TbConfig.FRS_HEAD_VIDEO_LIST, 309387));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ForumHeadVideoListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
