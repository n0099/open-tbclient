package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterHomeWorkMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean blC = true;
    public static boolean blD = true;
    public static final CustomMessageListener blE = new ax(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener blF = new az(CmdConfigCustom.MSG_READ);

    static {
        Rj();
        Rk();
        KR();
        MessageManager.getInstance().registerListener(blE);
        MessageManager.getInstance().registerListener(blF);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.au(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aUj();
        ba baVar = new ba();
        baVar.setSelfExecute(true);
        baVar.setPriority(4);
        baVar.execute(new Void[0]);
    }

    private static void Rj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new bb());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Rk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new bc());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void KR() {
        com.baidu.tbadk.core.util.bg.wM().a(new bd());
    }

    public static void j(TbPageContext<?> tbPageContext) {
        TiebaStatic.log("c10103");
        if (tbPageContext != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.ls().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null) {
                UtilHelper.showToast(tbPageContext.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_HOMEWORK);
            if (PluginPackageManager.ls().bu("com.baidu.tieba.pluginHomework")) {
                if (PluginPackageManager.ls().bv("com.baidu.tieba.pluginHomework")) {
                    com.baidu.tbadk.coreExtra.e.a.a(tbPageContext, t.j.plugin_homework_not_install, new be(tbPageContext), new bf());
                    return;
                } else if (PluginPackageManager.ls().bw("com.baidu.tieba.pluginHomework")) {
                    a(tbPageContext, pluginConfig, true);
                    return;
                } else if (appResponseToCmd) {
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterHomeWorkMessage(tbPageContext.getPageActivity()));
                    return;
                } else {
                    UtilHelper.showToast(tbPageContext.getPageActivity(), t.j.plugin_config_not_found);
                    return;
                }
            }
            a(tbPageContext, pluginConfig, false);
        }
    }

    private static void a(TbPageContext<?> tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig, boolean z) {
        String format;
        String string;
        if (tbPageContext != null) {
            if (pluginConfig == null) {
                UtilHelper.showToast(tbPageContext.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            if (z) {
                format = String.format(tbPageContext.getPageActivity().getString(t.j.plugin_update_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(t.j.download_update);
            } else {
                format = String.format(tbPageContext.getPageActivity().getString(t.j.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(t.j.download);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cC(format);
            aVar.a(string, new bg(tbPageContext, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.cancel), new ay());
            aVar.b(tbPageContext);
            aVar.up();
        }
    }
}
