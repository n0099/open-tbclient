package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.List;
/* loaded from: classes.dex */
public class Static {
    public static final String[] fxn = {"android.content.res.Resources$NotFoundException", "android.view.InflateException"};

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.plugins.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    PluginCenter.getInstance().startRetryLaunchPlugins();
                }
            }
        });
        bCN();
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.UEXCEPTION_MESSAGE) { // from class: com.baidu.tbadk.plugins.Static.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                StackTraceElement[] stackTrace;
                Plugin plugin2;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData)) {
                    boolean z = true;
                    ExceptionData exceptionData = (ExceptionData) customResponsedMessage.getData();
                    String[] strArr = Static.fxn;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str = strArr[i];
                        if (exceptionData == null || exceptionData.info == null || !exceptionData.info.contains(str) || exceptionData.info.contains("java.lang.OutOfMemoryError")) {
                            i++;
                        } else {
                            com.baidu.adp.plugin.b.a.pD().log("plugin_crash_inflate");
                            z = false;
                            break;
                        }
                    }
                    if (exceptionData.mExcep != null && exceptionData.mExcep.getCause() != null && exceptionData.mExcep.getCause().getStackTrace() != null && z && exceptionData != null && exceptionData.info != null) {
                        try {
                            List<PluginSetting> pluginSettingsSortLoadPriorty = c.qv().qs().getPluginSettingsSortLoadPriorty();
                            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty() && (stackTrace = exceptionData.mExcep.getCause().getStackTrace()) != null && stackTrace.length != 0) {
                                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                                    if (pluginSetting.isPatch && pluginSetting.enable && (plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName)) != null && plugin2.getDexClassLoader() != null) {
                                        for (StackTraceElement stackTraceElement : stackTrace) {
                                            try {
                                                plugin2.getDexClassLoader().loadClass(stackTraceElement.getClassName());
                                                com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.PATCH_FATAL_ERROR_COUNT, com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.PATCH_FATAL_ERROR_COUNT, 0) + 1);
                                                break;
                                            } catch (ClassNotFoundException e) {
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                }
            }
        });
    }

    private static void bCN() {
        MessageManager.getInstance().addMessageRule(new com.baidu.adp.framework.b.b(0) { // from class: com.baidu.tbadk.plugins.Static.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.b.f
            public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                if (customMessage == null || !(customMessage.getData() instanceof IntentConfig)) {
                }
                return customMessage;
            }
        });
    }
}
