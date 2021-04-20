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
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import d.b.c.h.j.g.d;
import java.util.List;
/* loaded from: classes3.dex */
public class Static {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f13662a = {"android.content.res.Resources$NotFoundException", "android.view.InflateException"};

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            PluginCenter.getInstance().startRetryLaunchPlugins();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            StackTraceElement[] stackTrace;
            Plugin plugin2;
            String str;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData)) {
                return;
            }
            ExceptionData exceptionData = (ExceptionData) customResponsedMessage.getData();
            String[] strArr = Static.f13662a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                String str2 = strArr[i];
                if (exceptionData != null && (str = exceptionData.info) != null && str.contains(str2) && !exceptionData.info.contains("java.lang.OutOfMemoryError")) {
                    d.b.c.h.h.a.b().g("plugin_crash_inflate");
                    z = false;
                    break;
                }
                i++;
            }
            Throwable th = exceptionData.mExcep;
            if (th == null || th.getCause() == null || exceptionData.mExcep.getCause().getStackTrace() == null || !z || exceptionData == null || exceptionData.info == null) {
                return;
            }
            try {
                List<PluginSetting> pluginSettingsSortLoadPriorty = d.k().l().getPluginSettingsSortLoadPriorty();
                if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty() && (stackTrace = exceptionData.mExcep.getCause().getStackTrace()) != null && stackTrace.length != 0) {
                    for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                        if (pluginSetting.isPatch && pluginSetting.enable && (plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName)) != null && plugin2.getDexClassLoader() != null) {
                            for (StackTraceElement stackTraceElement : stackTrace) {
                                try {
                                    plugin2.getDexClassLoader().loadClass(stackTraceElement.getClassName());
                                    d.b.h0.r.d0.b.j().v("plugin_patch_hook_failed_count", d.b.h0.r.d0.b.j().k("plugin_patch_hook_failed_count", 0) + 1);
                                    break;
                                } catch (ClassNotFoundException unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                BdLog.e(th2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends d.b.c.c.f.b {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // d.b.c.c.f.f
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            if (customMessage == null || !(customMessage.getData() instanceof IntentConfig)) {
            }
            return customMessage;
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a(2001011));
        a();
        MessageManager.getInstance().registerListener(new b(2016301));
    }

    public static void a() {
        MessageManager.getInstance().addMessageRule(new c(0));
    }
}
