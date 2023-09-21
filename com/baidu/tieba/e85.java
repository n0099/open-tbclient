package com.baidu.tieba;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStaticClassesArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class e85 {
    public static /* synthetic */ Interceptable $ic;
    public static String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TiebaStaticClassesArray b;

        public a(boolean z, TiebaStaticClassesArray tiebaStaticClassesArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), tiebaStaticClassesArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tiebaStaticClassesArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a) {
                        MultiDexHelper.loadClass(BdBaseApplication.getInst());
                        return;
                    }
                    Log.e("TiebaStaticClassesArray", "load from dex fail ");
                    if (!this.b.loadStaticClasses()) {
                        MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688231, "Lcom/baidu/tieba/e85;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688231, "Lcom/baidu/tieba/e85;");
                return;
            }
        }
        a = new String[]{"com.baidu.tieba.livesdk.AlaLiveSdkStatic", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", "com.baidu.tieba.ad.browser.AdStatic", "com.baidu.tieba.recapp.lego.RecAppLegoStatic", "com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic", "com.baidu.tbadk.core.LaunchStatic", "com.baidu.tieba.wallet.PayStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.im.TiebaIMActivityStatic", "com.baidu.tieba.immessagecenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.videoplay.fragment.VideoChannelDelegateStatic", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic", "com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic", "com.baidu.tieba.personCenter.PersonInfoDelegateStatic", "com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic", "com.baidu.tieba.ala.livecard.Static", "com.baidu.tieba.flutter.FlutterStatic", "com.baidu.tieba.flutter.FlutterPluginStatic", "com.baidu.tieba.homepage.topic.TopicStatic", "com.baidu.tieba.quickWebView.QuickWebViewStatic", "com.baidu.tbadk.core.util.schemeaction.SchemeActionStatic", "com.baidu.tieba.hottopic.controller.HotTopicStatic", "com.baidu.tieba.myAttentionAndFans.PersonListActivityStatic", "com.baidu.tieba.sharesdk.ShareStatic", "com.baidu.tieba.feed.FeedAppStatic", "com.baidu.tbadk.mutiprocess.MutiProcessStatic", "com.baidu.tieba.write.write.WriteActivityImmediateStatic"};
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                TiebaStaticClassesArray tiebaStaticClassesArray = new TiebaStaticClassesArray();
                try {
                    Class<?> cls = Class.forName("com.baidu.tbadk.core.util.TiebaStaticArray");
                    Object newInstance = cls.newInstance();
                    Field declaredField = cls.getDeclaredField("staticClassesArray");
                    declaredField.setAccessible(true);
                    tiebaStaticClassesArray.staticClassesArray = (String[]) declaredField.get(newInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("staticClassesArray: ", "" + tiebaStaticClassesArray.staticClassesArray.length);
                long currentTimeMillis = System.currentTimeMillis();
                IdleHandlerManager.getInstance().addOrRunTask("MultiDexHelper", new a(b(), tiebaStaticClassesArray));
                Log.e("Tasks", "load from dex coast time " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String[] strArr = a;
            try {
                if (strArr.length <= 0) {
                    return false;
                }
                for (String str : strArr) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Class.forName(str);
                    Log.e("TiebaStaticClassesArray", str + " " + (System.currentTimeMillis() - currentTimeMillis));
                }
                return true;
            } catch (Throwable th) {
                BdLog.e(th, true);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
