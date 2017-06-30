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
    public static boolean cbF = true;
    public static boolean cbG = true;
    public static String forumName = "";
    public static final CustomMessageListener cbH = new d(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener cbI = new f(CmdConfigCustom.MSG_READ);

    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        adF();
        adA();
        adB();
        adC();
        adD();
        adE();
        LocationModel.bnf();
        adG();
        adI();
        MessageManager.getInstance().registerListener(cbH);
        MessageManager.getInstance().registerListener(cbI);
        adH();
    }

    private static void adA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void adB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void adC() {
        com.baidu.tbadk.core.util.be.vP().a(new i());
    }

    private static void adD() {
        MessageManager.getInstance().registerListener(new j(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    private static void adE() {
        MessageManager.getInstance().registerListener(new k(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE));
    }

    public static void adF() {
        b.nv().a(1, new l());
    }

    public static void adG() {
        a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, a.ax(TbConfig.FRS_ADDRESS, 301001));
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

    private static void adH() {
        a.c(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, a.ax(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void adI() {
        MessageManager.getInstance().registerListener(new e(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT));
    }
}
