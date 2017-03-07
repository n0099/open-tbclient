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
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean bOa = true;
    public static boolean bOb = true;
    public static final CustomMessageListener bOc = new ai(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener bOd = new aj(CmdConfigCustom.MSG_READ);

    static {
        Zi();
        Zc();
        Zd();
        Zf();
        Ze();
        Zg();
        Zh();
        LocationModel.bio();
        Zj();
        MessageManager.getInstance().registerListener(bOc);
        MessageManager.getInstance().registerListener(bOd);
    }

    private static void Zc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new ak());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Zd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new al());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Ze() {
        a.a(309387, ForumHeadVideoListSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, a.av(TbConfig.FRS_HEAD_VIDEO_LIST, 309387));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ForumHeadVideoListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void Zf() {
        com.baidu.tbadk.core.util.bb.vQ().a(new am());
    }

    private static void Zg() {
        MessageManager.getInstance().registerListener(new an(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    private static void Zh() {
        MessageManager.getInstance().registerListener(new ao(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE));
    }

    public static void Zi() {
        com.baidu.tbadk.ala.c.nD().a(1, new ap());
    }

    public static void Zj() {
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
        aq aqVar = new aq();
        aqVar.setSelfExecute(true);
        aqVar.setPriority(4);
        aqVar.execute(new Void[0]);
    }
}
