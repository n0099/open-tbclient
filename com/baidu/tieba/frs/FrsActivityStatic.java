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
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean bay = true;
    public static boolean baz = true;
    public static final CustomMessageListener baA = new ar(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener baB = new as(CmdConfigCustom.MSG_READ);

    static {
        Nb();
        Nc();
        Ia();
        MessageManager.getInstance().registerListener(baA);
        MessageManager.getInstance().registerListener(baB);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aj(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aDP();
    }

    private static void Nb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new at());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Nc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new au());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Ia() {
        com.baidu.tbadk.core.util.bf.vD().a(new av());
    }

    public static void j(TbPageContext<?> tbPageContext) {
        TiebaStatic.log("c10103");
        if (tbPageContext != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lU().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null) {
                UtilHelper.showToast(tbPageContext.getPageActivity(), n.i.plugin_config_not_found);
                return;
            }
            boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_HOMEWORK);
            if (PluginPackageManager.lU().bt("com.baidu.tieba.pluginHomework")) {
                if (PluginPackageManager.lU().bu("com.baidu.tieba.pluginHomework")) {
                    com.baidu.tbadk.coreExtra.e.a.a(tbPageContext, n.i.plugin_homework_not_install, new aw(tbPageContext), new ax());
                    return;
                } else if (PluginPackageManager.lU().bv("com.baidu.tieba.pluginHomework")) {
                    a(tbPageContext, pluginConfig, true);
                    return;
                } else if (appResponseToCmd) {
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterHomeWorkMessage(tbPageContext.getPageActivity()));
                    return;
                } else {
                    UtilHelper.showToast(tbPageContext.getPageActivity(), n.i.plugin_config_not_found);
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
                UtilHelper.showToast(tbPageContext.getPageActivity(), n.i.plugin_config_not_found);
                return;
            }
            if (z) {
                format = String.format(tbPageContext.getPageActivity().getString(n.i.plugin_update_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(n.i.download_update);
            } else {
                format = String.format(tbPageContext.getPageActivity().getString(n.i.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(n.i.download);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cC(format);
            aVar.a(string, new ay(tbPageContext, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.i.cancel), new az());
            aVar.b(tbPageContext);
            aVar.tv();
        }
    }
}
