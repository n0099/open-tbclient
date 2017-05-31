package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.a.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean bTx = true;
    public static boolean bTy = true;
    public static String forumName = "";
    public static final CustomMessageListener bTz = new d(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bTA = new f(CmdConfigCustom.MSG_READ);

    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        ZO();
        ZJ();
        ZK();
        ZL();
        ZM();
        ZN();
        LocationModel.biR();
        ZP();
        ZR();
        MessageManager.getInstance().registerListener(bTz);
        MessageManager.getInstance().registerListener(bTA);
        ZQ();
    }

    private static void ZJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void ZK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void ZL() {
        com.baidu.tbadk.core.util.bb.vy().a(new i());
    }

    private static void ZM() {
        MessageManager.getInstance().registerListener(new j(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    private static void ZN() {
        MessageManager.getInstance().registerListener(new k(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE));
    }

    public static void ZO() {
        b.nz().a(1, new l());
    }

    public static void ZP() {
        a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, a.aw(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        m mVar = new m();
        mVar.setSelfExecute(true);
        mVar.setPriority(4);
        mVar.execute(new Void[0]);
    }

    private static void ZQ() {
        a.c(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, a.aw(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void ZR() {
        MessageManager.getInstance().registerListener(new e(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT));
    }
}
