package com.baidu.tieba;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
/* loaded from: classes3.dex */
public class CaptureStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.CaptureStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0216a implements c99 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            /* renamed from: com.baidu.tieba.CaptureStatic$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0217a extends DefaultDownloadCallback {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0216a a;

                public C0217a(C0216a c0216a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0216a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0216a;
                }

                @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                public void onDownloadCancel(PackageInfo packageInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, packageInfo) == null) {
                        e35.a(AlbumActivityConfig.FROM_WRITE, 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo_onDownloadCancel", 0, "", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.FALSE));
                        ej.P(TbadkCoreApplication.getInst(), R.string.libso_load_faild);
                    }
                }

                @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) {
                        e35.a(AlbumActivityConfig.FROM_WRITE, 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo_onDownloadError", 0, "", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.FALSE));
                        ej.P(TbadkCoreApplication.getInst(), R.string.libso_load_faild);
                    }
                }

                @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, packageInfo, errorInfo) == null) {
                        e35.a(AlbumActivityConfig.FROM_WRITE, 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo_onDownloadSuccess", 0, "", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.TRUE));
                        if (packageInfo != null && "libcbffmpeg.so".equals(packageInfo.name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, (IntentConfig) this.a.a.getData()));
                        }
                    }
                }
            }

            public C0216a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
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
            }

            @Override // com.baidu.tieba.c99
            public void a() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getData() instanceof IntentConfig)) {
                    e35.a(AlbumActivityConfig.FROM_WRITE, 100L, 0, "CaptureStatic_onArDownloadSuccess_start", 0, "", new Object[0]);
                    if (!StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libcbffmpeg.so"))) {
                        e35.a(AlbumActivityConfig.FROM_WRITE, 100L, 0, "CaptureStatic_onArDownloadSuccess_hasSo", 0, "", new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, (IntentConfig) this.a.getData()));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.TRUE));
                        return;
                    }
                    e35.a(AlbumActivityConfig.FROM_WRITE, 100L, 0, "CaptureStatic_onArDownloadSuccess_nonSo", 0, "", new Object[0]);
                    RequestParams requestParams = new RequestParams();
                    requestParams.setRunType(qm.a);
                    requestParams.setRunNode("aps");
                    requestParams.addChannel(new pm("com.baidu.tieba.soloader.libcbffmpeg", new C0217a(this)));
                    PmsManager.getInstance().execute(requestParams);
                }
            }

            @Override // com.baidu.tieba.c99
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    e35.a(AlbumActivityConfig.FROM_WRITE, 100L, 0, "CaptureStatic_onArDownloadFail", 0, "", new Object[0]);
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
                v89.b(TbadkCoreApplication.getInst(), new C0216a(this, customResponsedMessage));
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
