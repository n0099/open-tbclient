package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListHttpResponseMessage;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListSocketResponseMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean bQB = true;
    public static boolean bQC = true;
    public static final CustomMessageListener bQD = new au(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bQE = new av(CmdConfigCustom.MSG_READ);

    static {
        abi();
        abj();
        abk();
        abl();
        MessageManager.getInstance().registerListener(bQD);
        MessageManager.getInstance().registerListener(bQE);
        a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, a.aG(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.bjO();
        aw awVar = new aw();
        awVar.setSelfExecute(true);
        awVar.setPriority(4);
        awVar.execute(new Void[0]);
    }

    private static void abi() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new ax());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void abj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new ay());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void abk() {
        com.baidu.tbadk.core.util.bi.vx().a(new az());
    }

    private static void abl() {
        a.a(309387, ForumHeadVideoListSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, a.aG(TbConfig.FRS_HEAD_VIDEO_LIST, 309387));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ForumHeadVideoListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
