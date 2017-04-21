package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
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
    public static boolean bQg = true;
    public static boolean bQh = true;
    public static final CustomMessageListener bQi = new ai(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bQj = new al(CmdConfigCustom.MSG_READ);

    static {
        aaE();
        aaz();
        aaA();
        aaB();
        aaC();
        aaD();
        LocationModel.bka();
        aaF();
        MessageManager.getInstance().registerListener(bQi);
        MessageManager.getInstance().registerListener(bQj);
        aaG();
        aaH();
    }

    private static void aaz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new am());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aaA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new an());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aaB() {
        com.baidu.tbadk.core.util.bb.wn().a(new ao());
    }

    private static void aaC() {
        MessageManager.getInstance().registerListener(new ap(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    private static void aaD() {
        MessageManager.getInstance().registerListener(new aq(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE));
    }

    public static void aaE() {
        com.baidu.tbadk.ala.c.oa().a(1, new ar());
    }

    public static void aaF() {
        a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, a.av(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        as asVar = new as();
        asVar.setSelfExecute(true);
        asVar.setPriority(4);
        asVar.execute(new Void[0]);
    }

    private static void aaG() {
        a.c(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, a.av(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aaH() {
        MessageManager.getInstance().registerListener(new aj(CmdConfigCustom.CMD_FRS_ADD_ADAPTER));
        MessageManager.getInstance().registerListener(new ak(CmdConfigCustom.CMD_FRS_ADD_MODEL));
        bz.abD().ic(100);
    }
}
