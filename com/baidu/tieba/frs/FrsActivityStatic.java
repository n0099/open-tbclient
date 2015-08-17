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
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean aVs = true;
    public static boolean aVt = true;
    public static boolean aVu = true;
    public static final CustomMessageListener aVv = new aj(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener aVw = new ak(CmdConfigCustom.MSG_READ);

    static {
        LC();
        LD();
        Ho();
        MessageManager.getInstance().registerListener(aVv);
        MessageManager.getInstance().registerListener(aVw);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.Z(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aqI();
    }

    private static void LC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new al());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void LD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new am());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Ho() {
        com.baidu.tbadk.core.util.ax.uR().a(new an());
    }

    public static boolean LE() {
        return !TbadkCoreApplication.m411getInst().isMIUIRom() && TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xH();
    }

    public static void i(TbPageContext<?> tbPageContext) {
        TiebaStatic.log("c10103");
        if (tbPageContext != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.lT().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null) {
                UtilHelper.showToast(tbPageContext.getPageActivity(), i.C0057i.plugin_config_not_found);
                return;
            }
            boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_HOMEWORK);
            if (PluginPackageManager.lT().bq("com.baidu.tieba.pluginHomework")) {
                if (PluginPackageManager.lT().br("com.baidu.tieba.pluginHomework")) {
                    com.baidu.tbadk.coreExtra.util.a.a(tbPageContext, i.C0057i.plugin_homework_not_install, new ao(tbPageContext), new ap());
                    return;
                } else if (PluginPackageManager.lT().bs("com.baidu.tieba.pluginHomework")) {
                    a(tbPageContext, pluginConfig, true);
                    return;
                } else if (appResponseToCmd) {
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterHomeWorkMessage(tbPageContext.getPageActivity()));
                    return;
                } else {
                    UtilHelper.showToast(tbPageContext.getPageActivity(), i.C0057i.plugin_config_not_found);
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
                UtilHelper.showToast(tbPageContext.getPageActivity(), i.C0057i.plugin_config_not_found);
                return;
            }
            if (z) {
                format = String.format(tbPageContext.getPageActivity().getString(i.C0057i.plugin_update_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(i.C0057i.download_update);
            } else {
                format = String.format(tbPageContext.getPageActivity().getString(i.C0057i.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(i.C0057i.download);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cn(format);
            aVar.a(string, new aq(tbPageContext, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.C0057i.cancel), new ar());
            aVar.b(tbPageContext);
            aVar.sP();
        }
    }
}
