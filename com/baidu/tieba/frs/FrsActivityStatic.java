package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.acrossForum.message.AcrossAwardHttpResMsg;
import com.baidu.tieba.frs.acrossForum.message.AcrossAwardSocketMsg;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListHttpResponseMessage;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListSocketResponseMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean bTg = true;
    public static boolean bTh = true;
    public static final CustomMessageListener bTi = new af(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bTj = new ag(CmdConfigCustom.MSG_READ);

    static {
        acA();
        acB();
        acD();
        acC();
        acE();
        acF();
        acG();
        MessageManager.getInstance().registerListener(bTi);
        MessageManager.getInstance().registerListener(bTj);
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
        com.baidu.tieba.tbadkCore.location.d.bmQ();
        ah ahVar = new ah();
        ahVar.setSelfExecute(true);
        ahVar.setPriority(4);
        ahVar.execute(new Void[0]);
    }

    private static void acA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new ai());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void acB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new aj());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void acC() {
        a.a(309387, ForumHeadVideoListSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, a.aF(TbConfig.FRS_HEAD_VIDEO_LIST, 309387));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ForumHeadVideoListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void acD() {
        com.baidu.tbadk.core.util.bf.vP().a(new ak());
    }

    private static void acE() {
        MessageManager.getInstance().registerListener(new al(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    private static void acF() {
        MessageManager.getInstance().registerListener(new am(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE));
    }

    private static void acG() {
        a.b(CmdConfigHttp.CMD_ACROSS_AWARD, 309425, TbConfig.ACROSS_AWARD, AcrossAwardHttpResMsg.class, AcrossAwardSocketMsg.class);
        MessageManager.getInstance().registerListener(new an(CmdConfigCustom.CMD_EXIT_APP));
    }
}
