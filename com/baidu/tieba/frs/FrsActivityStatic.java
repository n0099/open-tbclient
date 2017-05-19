package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
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
    public static boolean bNL = true;
    public static boolean bNM = true;
    public static String forumName = "";
    public static final CustomMessageListener bNN = new d(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bNO = new f(CmdConfigCustom.MSG_READ);

    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        YL();
        YG();
        YH();
        YI();
        YJ();
        YK();
        LocationModel.bhx();
        YM();
        YO();
        MessageManager.getInstance().registerListener(bNN);
        MessageManager.getInstance().registerListener(bNO);
        YN();
    }

    private static void YG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void YH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void YI() {
        com.baidu.tbadk.core.util.bb.vB().a(new i());
    }

    private static void YJ() {
        MessageManager.getInstance().registerListener(new j(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    private static void YK() {
        MessageManager.getInstance().registerListener(new k(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE));
    }

    public static void YL() {
        com.baidu.tbadk.ala.c.nH().a(1, new l());
    }

    public static void YM() {
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

    private static void YN() {
        a.c(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, a.ax(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void YO() {
        MessageManager.getInstance().registerListener(new e(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT));
    }
}
