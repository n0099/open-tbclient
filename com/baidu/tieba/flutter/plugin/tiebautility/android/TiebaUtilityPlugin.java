package com.baidu.tieba.flutter.plugin.tiebautility.android;

import androidx.annotation.NonNull;
import c.a.r0.s0.a.j.a3;
import c.a.r0.s0.a.j.b3;
import c.a.r0.s0.a.j.c3;
import c.a.r0.s0.a.j.d3;
import c.a.r0.s0.a.j.e3;
import c.a.r0.s0.a.j.f3;
import c.a.r0.s0.a.j.g3;
import c.a.r0.s0.a.j.h3;
import c.a.r0.s0.a.j.i3;
import c.a.r0.s0.a.j.v2;
import c.a.r0.s0.a.j.w2;
import c.a.r0.s0.a.j.x2;
import c.a.r0.s0.a.j.y2;
import c.a.r0.s0.a.j.z2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityNotificationAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class TiebaUtilityPlugin implements FlutterPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TiebaUtilityNotificationAuto.FlutterUtilityNotification mFlutterNotification;
    public UtilityNotification mNotification;
    public final CustomMessageListener sendNotifyToFlutter;

    public TiebaUtilityPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sendNotifyToFlutter = new CustomMessageListener(this, 2921542) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.TiebaUtilityPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TiebaUtilityPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                    return;
                }
                this.this$0.mNotification.notifyFlutter((String) ((HashMap) customResponsedMessage.getData()).get("uniqueKey"), (HashMap) ((HashMap) customResponsedMessage.getData()).get("object"), (HashMap) ((HashMap) customResponsedMessage.getData()).get("data"));
            }
        };
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            this.mFlutterNotification = new TiebaUtilityNotificationAuto.FlutterUtilityNotification(flutterPluginBinding.getBinaryMessenger());
            this.mNotification = new UtilityNotification(this.mFlutterNotification);
            MessageManager.getInstance().registerListener(this.sendNotifyToFlutter);
            e3.e(flutterPluginBinding.getBinaryMessenger(), new UtilityPreference());
            x2.g(flutterPluginBinding.getBinaryMessenger(), new UtilityAppInfo());
            w2.g(flutterPluginBinding.getBinaryMessenger(), new UtilityAccount());
            f3.i(flutterPluginBinding.getBinaryMessenger(), new UtilitySettings());
            c3.d(flutterPluginBinding.getBinaryMessenger(), this.mNotification);
            g3.c(flutterPluginBinding.getBinaryMessenger(), new UtilityStatistic());
            d3.r(flutterPluginBinding.getBinaryMessenger(), new UtilityOpenPage());
            b3.k(flutterPluginBinding.getBinaryMessenger(), new UtilityMessage());
            y2.r(flutterPluginBinding.getBinaryMessenger(), new UtilityComponents());
            z2.c(flutterPluginBinding.getBinaryMessenger(), new UtilityData());
            a3.e(flutterPluginBinding.getBinaryMessenger(), new UtilityLocation());
            v2.c(flutterPluginBinding.getBinaryMessenger(), new UtilityABTest());
            h3.o(flutterPluginBinding.getBinaryMessenger(), new UtilityVideo());
            i3.d(flutterPluginBinding.getBinaryMessenger(), new UtilityVideoCreationCenter());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            MessageManager.getInstance().unRegisterListener(this.sendNotifyToFlutter);
            this.mFlutterNotification = null;
            this.mNotification = null;
            e3.e(flutterPluginBinding.getBinaryMessenger(), null);
            x2.g(flutterPluginBinding.getBinaryMessenger(), null);
            w2.g(flutterPluginBinding.getBinaryMessenger(), null);
            f3.i(flutterPluginBinding.getBinaryMessenger(), null);
            c3.d(flutterPluginBinding.getBinaryMessenger(), null);
            g3.c(flutterPluginBinding.getBinaryMessenger(), null);
            d3.r(flutterPluginBinding.getBinaryMessenger(), null);
            b3.k(flutterPluginBinding.getBinaryMessenger(), null);
            y2.r(flutterPluginBinding.getBinaryMessenger(), null);
            z2.c(flutterPluginBinding.getBinaryMessenger(), null);
            a3.e(flutterPluginBinding.getBinaryMessenger(), null);
            v2.c(flutterPluginBinding.getBinaryMessenger(), null);
            h3.o(flutterPluginBinding.getBinaryMessenger(), null);
            i3.d(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }
}
