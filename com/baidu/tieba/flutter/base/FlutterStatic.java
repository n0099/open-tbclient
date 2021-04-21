package com.baidu.tieba.flutter.base;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.flutter.base.view.FlutterDelegateStatic;
import com.baidu.tieba.flutter.base.view.FlutterEnterForumDelegateStatic;
import com.baidu.tieba.flutter.base.view.FlutterNewCategoryDelegateStatic;
import com.baidu.tieba.flutter.base.view.PageRouter;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import d.b.c.c.f.b;
import d.b.j0.d3.h0.m;
import io.flutter.embedding.android.FlutterView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FlutterStatic {
    static {
        initFlutter();
    }

    public static void initFlutter() {
        if ("MuMu".equals(Build.MODEL) && "Netease".equals(Build.MANUFACTURER)) {
            return;
        }
        registerFlutterRule();
        FlutterDelegateStatic.registerFlutterFragment();
        FlutterNewCategoryDelegateStatic.registerFlutterFragment();
        FlutterEnterForumDelegateStatic.registerFlutterFragment();
        INativeRouter iNativeRouter = new INativeRouter() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.1
            @Override // com.idlefish.flutterboost.interfaces.INativeRouter
            public void openContainer(Context context, String str, Map<String, Object> map, int i, Map<String, Object> map2) {
                PageRouter.openPageByUrl(context, Utils.assembleUrl(str, map), map);
            }
        };
        FlutterBoost.BoostLifecycleListener boostLifecycleListener = new FlutterBoost.BoostLifecycleListener() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.2
            @Override // com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener
            public void beforeCreateEngine() {
            }

            @Override // com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener
            public void onEngineCreated() {
            }

            public void onEngineDestroy() {
            }

            public void onPluginsRegistered() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921485));
            }
        };
        FlutterBoost.ConfigBuilder configBuilder = new FlutterBoost.ConfigBuilder(TbadkCoreApplication.getInst(), iNativeRouter);
        configBuilder.isDebug(isDebugMode());
        configBuilder.whenEngineStart(FlutterBoost.ConfigBuilder.FLUTTER_ACTIVITY_CREATED);
        configBuilder.renderMode(FlutterView.RenderMode.texture);
        configBuilder.lifecycleListener(boostLifecycleListener);
        FlutterBoost.instance().init(configBuilder.build());
    }

    public static boolean isDebugMode() {
        if (BdBaseApplication.getInst() == null) {
            return false;
        }
        return BdBaseApplication.getInst().isDebugMode();
    }

    public static void registerFlutterRule() {
        MessageManager.getInstance().addMessageRule(new b(0) { // from class: com.baidu.tieba.flutter.base.FlutterStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.c.c.f.f
            public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                return (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof IntentConfig)) ? customMessage : OpenFlutter.goToFlutter(customMessage);
            }
        });
        MessageManager.getInstance().registerTask(new CustomMessageTask(2002015, new CustomMessageTask.CustomRunnable<m>() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<m> run(CustomMessage<m> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    Context a2 = customMessage.getData().a();
                    String b2 = customMessage.getData().b();
                    HashMap c2 = customMessage.getData().c();
                    if (c2 == null || c2.isEmpty()) {
                        c2 = new HashMap();
                    }
                    if (a2 != null && !TextUtils.isEmpty(b2)) {
                        OpenFlutter.openFlutterPage(a2, b2, c2);
                    }
                }
                return null;
            }
        }));
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.5
            @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr != null && strArr[0] != null) {
                    String str = strArr[0];
                    if (str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
                        try {
                            Uri parse = Uri.parse(str);
                            HashMap hashMap = new HashMap();
                            String host = parse.getHost();
                            for (String str2 : parse.getQueryParameterNames()) {
                                hashMap.put(str2, parse.getQueryParameter(str2));
                            }
                            OpenFlutter.openFlutterPage(tbPageContext.getPageActivity().getBaseContext(), host, hashMap);
                            return 0;
                        } catch (Exception e2) {
                            BdLog.e(e2);
                        }
                    }
                }
                return 3;
            }
        });
    }
}
