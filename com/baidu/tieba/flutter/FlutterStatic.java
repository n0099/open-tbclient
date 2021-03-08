package com.baidu.tieba.flutter;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.b;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.tieba.flutter.view.FlutterDelegateStatic;
import com.baidu.tieba.flutter.view.FlutterEnterForumDelegateStatic;
import com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic;
import com.baidu.tieba.flutter.view.PageRouter;
import com.baidu.tieba.tbadkCore.data.m;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class FlutterStatic {
    static {
        initFlutter();
    }

    public static void initFlutter() {
        if (!"MuMu".equals(Build.MODEL) || !"Netease".equals(Build.MANUFACTURER)) {
            registerFlutterRule();
            FlutterDelegateStatic.registerFlutterFragment();
            FlutterNewCategoryDelegateStatic.registerFlutterFragment();
            FlutterEnterForumDelegateStatic.registerFlutterFragment();
            INativeRouter iNativeRouter = new INativeRouter() { // from class: com.baidu.tieba.flutter.FlutterStatic.1
                @Override // com.idlefish.flutterboost.interfaces.INativeRouter
                public void openContainer(Context context, String str, Map<String, Object> map, int i, Map<String, Object> map2) {
                    PageRouter.openPageByUrl(context, Utils.assembleUrl(str, map), map);
                }
            };
            FlutterBoost.instance().init(new FlutterBoost.ConfigBuilder(TbadkCoreApplication.getInst(), iNativeRouter).isDebug(isDebugMode()).whenEngineStart(FlutterBoost.ConfigBuilder.FLUTTER_ACTIVITY_CREATED).renderMode(FlutterView.RenderMode.texture).lifecycleListener(new FlutterBoost.BoostLifecycleListener() { // from class: com.baidu.tieba.flutter.FlutterStatic.2
                @Override // com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener
                public void beforeCreateEngine() {
                }

                @Override // com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener
                public void onEngineCreated() {
                }

                public void onPluginsRegistered() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921485));
                }

                public void onEngineDestroy() {
                }
            }).build());
        }
    }

    public static boolean isDebugMode() {
        if (BdBaseApplication.getInst() == null) {
            return false;
        }
        return BdBaseApplication.getInst().isDebugMode();
    }

    private static void registerFlutterRule() {
        MessageManager.getInstance().addMessageRule(new b(0) { // from class: com.baidu.tieba.flutter.FlutterStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.b.f
            public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof IntentConfig)) {
                    return OpenFlutter.goToFlutter(customMessage);
                }
                return customMessage;
            }
        });
        MessageManager.getInstance().registerTask(new CustomMessageTask(2002015, new CustomMessageTask.CustomRunnable<m>() { // from class: com.baidu.tieba.flutter.FlutterStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<m> run(CustomMessage<m> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    Context context = customMessage.getData().getContext();
                    String pageName = customMessage.getData().getPageName();
                    HashMap params = customMessage.getData().getParams();
                    if (params == null || params.isEmpty()) {
                        params = new HashMap();
                    }
                    if (context != null && !TextUtils.isEmpty(pageName) && params != null && !params.isEmpty()) {
                        OpenFlutter.openFlutterPage(context, pageName, params);
                    }
                }
                return null;
            }
        }));
        bf.bsY().a(new bf.a() { // from class: com.baidu.tieba.flutter.FlutterStatic.5
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith("flt://")) {
                    try {
                        Uri parse = Uri.parse(str);
                        HashMap hashMap = new HashMap();
                        String host = parse.getHost();
                        for (String str2 : parse.getQueryParameterNames()) {
                            hashMap.put(str2, parse.getQueryParameter(str2));
                        }
                        OpenFlutter.openFlutterPage(tbPageContext.getPageActivity().getBaseContext(), host, hashMap);
                        return 0;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return 3;
                    }
                }
                return 3;
            }
        });
    }
}
