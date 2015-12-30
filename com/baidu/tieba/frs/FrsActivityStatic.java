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
    public static boolean bex = true;
    public static boolean bey = true;
    public static final CustomMessageListener bez = new au(CmdConfigCustom.MSG_NEW);
    private static final CustomMessageListener beA = new av(CmdConfigCustom.MSG_READ);

    static {
        Nu();
        Nv();
        HQ();
        MessageManager.getInstance().registerListener(bez);
        MessageManager.getInstance().registerListener(beA);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.ak(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aGc();
    }

    private static void Nu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new aw());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Nv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new ax());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void HQ() {
        com.baidu.tbadk.core.util.bf.vn().a(new ay());
    }

    public static void j(TbPageContext<?> tbPageContext) {
        TiebaStatic.log("c10103");
        if (tbPageContext != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = PluginPackageManager.ls().getPluginConfig("com.baidu.tieba.pluginHomework");
            if (pluginConfig == null) {
                UtilHelper.showToast(tbPageContext.getPageActivity(), n.j.plugin_config_not_found);
                return;
            }
            boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_HOMEWORK);
            if (PluginPackageManager.ls().bw("com.baidu.tieba.pluginHomework")) {
                if (PluginPackageManager.ls().bx("com.baidu.tieba.pluginHomework")) {
                    com.baidu.tbadk.coreExtra.e.a.a(tbPageContext, n.j.plugin_homework_not_install, new az(tbPageContext), new ba());
                    return;
                } else if (PluginPackageManager.ls().by("com.baidu.tieba.pluginHomework")) {
                    a(tbPageContext, pluginConfig, true);
                    return;
                } else if (appResponseToCmd) {
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterHomeWorkMessage(tbPageContext.getPageActivity()));
                    return;
                } else {
                    UtilHelper.showToast(tbPageContext.getPageActivity(), n.j.plugin_config_not_found);
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
                UtilHelper.showToast(tbPageContext.getPageActivity(), n.j.plugin_config_not_found);
                return;
            }
            if (z) {
                format = String.format(tbPageContext.getPageActivity().getString(n.j.plugin_update_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(n.j.download_update);
            } else {
                format = String.format(tbPageContext.getPageActivity().getString(n.j.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f));
                string = TbadkCoreApplication.m411getInst().getString(n.j.download);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cF(format);
            aVar.a(string, new bb(tbPageContext, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.j.cancel), new bc());
            aVar.b(tbPageContext);
            aVar.tf();
        }
    }
}
