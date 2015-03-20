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
    public static boolean aJO = true;
    public static boolean aJP = true;
    public static boolean aJQ = true;
    public static final CustomMessageListener aJR = new ah(2012111);
    private static final CustomMessageListener aJS = new ai(2012112);

    static {
        JD();
        JE();
        Fz();
        MessageManager.getInstance().registerListener(aJR);
        MessageManager.getInstance().registerListener(aJS);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.R(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.e.anh();
    }

    private static void JD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new aj());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void JE() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new ak());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fz() {
        com.baidu.tbadk.core.util.bk.tl().a(new al());
    }

    public static boolean JF() {
        return !TbadkCoreApplication.m411getInst().isMIUIRom() && TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && com.baidu.tbadk.coreExtra.messageCenter.c.vq().vH();
    }
}
