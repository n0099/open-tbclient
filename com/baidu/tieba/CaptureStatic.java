package com.baidu.tieba;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.Anniversary18thActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.GpVideoPreviewActivityConfig;
import com.baidu.tbadk.core.atomData.TbCaptureActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.view.anniversary.Anniversary18thActivity;
import com.baidu.tieba.view.capture.TbCaptureActivity;
import com.baidu.tieba.view.clipcover.VideoCoverSelectActivity;
import com.baidu.tieba.view.cloudmusic.CloudMusicActivity;
import com.baidu.tieba.view.videoedit.TbEditVideoActivity;
import com.baidu.tieba.view.videofile.TbFileVideoActivity;
import com.baidu.tieba.view.videopreview.GpVideoPreviewActivity;
import com.baidu.tieba.view.videopreview.TbPreviewVideoActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CaptureStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.CaptureStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0215a implements b0a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;
            public final /* synthetic */ IntentConfig b;

            /* renamed from: com.baidu.tieba.CaptureStatic$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0216a extends DefaultDownloadCallback {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0215a a;

                public C0216a(C0215a c0215a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0215a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0215a;
                }

                @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                public void onDownloadCancel(PackageInfo packageInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, packageInfo) == null) {
                        zk8 defaultLog = DefaultLog.getInstance();
                        defaultLog.c("write", "打开视频编辑页4，libcbffmpeg.so下载取消:" + packageInfo);
                        d65.a("write", 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo_onDownloadCancel", 0, "", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.FALSE));
                        ri.P(TbadkCoreApplication.getInst(), R.string.libso_load_faild);
                    }
                }

                @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) {
                        zk8 defaultLog = DefaultLog.getInstance();
                        defaultLog.c("write", "打开视频编辑页4，libcbffmpeg.so下载失败:" + packageInfo + " errorInfo:" + errorInfo);
                        d65.a("write", 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo_onDownloadError", 0, "", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.FALSE));
                        ri.P(TbadkCoreApplication.getInst(), R.string.libso_load_faild);
                    }
                }

                @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, packageInfo, errorInfo) == null) {
                        zk8 defaultLog = DefaultLog.getInstance();
                        defaultLog.c("write", "打开视频编辑页4，libcbffmpeg.so下载成功:" + TbadkCoreApplication.getInst().getCurrentActivity() + " " + packageInfo + " errorInfo:" + errorInfo);
                        d65.a("write", 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo_onDownloadSuccess", 0, "", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.TRUE));
                        if (packageInfo != null && "libcbffmpeg.so".equals(packageInfo.name)) {
                            this.a.b.setContext(TbadkCoreApplication.getInst().getCurrentActivity());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, (IntentConfig) this.a.a.getData()));
                        }
                    }
                }
            }

            public C0215a(a aVar, CustomResponsedMessage customResponsedMessage, IntentConfig intentConfig) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage, intentConfig};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
                this.b = intentConfig;
            }

            @Override // com.baidu.tieba.b0a
            public void a() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getData() instanceof IntentConfig)) {
                    String str = BdBaseApplication.getInst().getResHashMap().get("libcbffmpeg.so");
                    d65.a("write", 100L, 0, "CaptureStatic_onArDownloadSuccess_start", 0, "", new Object[0]);
                    if (!StringUtils.isNull(str)) {
                        zk8 defaultLog = DefaultLog.getInstance();
                        defaultLog.c("write", "打开视频编辑页3，libcbffmpeg.so存在，打开页面:" + str);
                        d65.a("write", 100L, 0, "CaptureStatic_onArDownloadSuccess_hasSo", 0, "", new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, (IntentConfig) this.a.getData()));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.TRUE));
                        return;
                    }
                    this.b.setContext(null);
                    d65.a("write", 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo", 0, "", new Object[0]);
                    DefaultLog.getInstance().c("write", "打开视频编辑页3，libcbffmpeg.so不存在，尝试下载");
                    RequestParams requestParams = new RequestParams();
                    requestParams.setRunType(fm.a);
                    requestParams.setRunNode("aps");
                    requestParams.addChannel(new em("com.baidu.tieba.soloader.libcbffmpeg", new C0216a(this)));
                    PmsManager.getInstance().execute(requestParams);
                }
            }

            @Override // com.baidu.tieba.b0a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d65.a("write", 100L, 0, "CaptureStatic_onArDownloadFail", 0, "", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.FALSE));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921582) {
                DefaultLog.getInstance().c("write", "打开视频编辑页1，开始检测so");
                vz9.b(TbadkCoreApplication.getInst(), new C0215a(this, customResponsedMessage, (IntentConfig) customResponsedMessage.getData()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(25686741, "Lcom/baidu/tieba/CaptureStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(25686741, "Lcom/baidu/tieba/CaptureStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(TbCaptureActivityConfig.class, TbCaptureActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TbPreviewVideoActivityConfig.class, TbPreviewVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GpVideoPreviewActivityConfig.class, GpVideoPreviewActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TbFileVideoActivityConfig.class, TbFileVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TbEditVideoActivityConfig.class, TbEditVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CloudMusicActivityConfig.class, CloudMusicActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoCoverSelectActivityConfig.class, VideoCoverSelectActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(Anniversary18thActivityConfig.class, Anniversary18thActivity.class);
        MessageManager.getInstance().registerListener(2921582, new a(0));
    }

    public CaptureStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
