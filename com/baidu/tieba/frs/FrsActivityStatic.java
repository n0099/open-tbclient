package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean aMg = true;
    public static boolean aMh = true;
    public static boolean aMi = true;
    public static final CustomMessageListener aMj = new ah(2012111);
    private static final CustomMessageListener aMk = new ai(2012112);

    static {
        KP();
        KQ();
        GA();
        MessageManager.getInstance().registerListener(aMj);
        MessageManager.getInstance().registerListener(aMk);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.S(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.e.apo();
    }

    private static void KP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new aj());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void KQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new ak());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void GA() {
        com.baidu.tbadk.core.util.bi.tO().a(new al());
    }

    public static boolean KR() {
        return !TbadkCoreApplication.m411getInst().isMIUIRom() && TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx();
    }
}
