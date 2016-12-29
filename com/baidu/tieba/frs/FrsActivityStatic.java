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
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean bzr = true;
    public static boolean bzs = true;
    public static final CustomMessageListener bzt = new aj(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bzu = new ak(CmdConfigCustom.MSG_READ);

    static {
        WN();
        WO();
        WQ();
        WP();
        WR();
        WS();
        WT();
        MessageManager.getInstance().registerListener(bzt);
        MessageManager.getInstance().registerListener(bzu);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aB(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.bgK();
        al alVar = new al();
        alVar.setSelfExecute(true);
        alVar.setPriority(4);
        alVar.execute(new Void[0]);
    }

    private static void WN() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new am());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void WO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new an());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void WP() {
        com.baidu.tieba.tbadkCore.a.a.a(309387, ForumHeadVideoListSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, com.baidu.tieba.tbadkCore.a.a.aB(TbConfig.FRS_HEAD_VIDEO_LIST, 309387));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ForumHeadVideoListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void WQ() {
        com.baidu.tbadk.core.util.bc.vz().a(new ao());
    }

    private static void WR() {
        MessageManager.getInstance().registerListener(new ap(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    private static void WS() {
        MessageManager.getInstance().registerListener(new aq(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE));
    }

    private static void WT() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigHttp.CMD_ACROSS_AWARD, 309425, TbConfig.ACROSS_AWARD, AcrossAwardHttpResMsg.class, AcrossAwardSocketMsg.class);
        MessageManager.getInstance().registerListener(new ar(CmdConfigCustom.CMD_EXIT_APP));
    }
}
