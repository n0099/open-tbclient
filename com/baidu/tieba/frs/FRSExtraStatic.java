package com.baidu.tieba.frs;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.a45;
import com.baidu.tieba.ap6;
import com.baidu.tieba.cd7;
import com.baidu.tieba.cn5;
import com.baidu.tieba.df7;
import com.baidu.tieba.dj7;
import com.baidu.tieba.fj7;
import com.baidu.tieba.frs.aggregation.VideoAggregationActivity;
import com.baidu.tieba.ie7;
import com.baidu.tieba.li7;
import com.baidu.tieba.mi7;
import com.baidu.tieba.ql6;
import com.baidu.tieba.st7;
import com.baidu.tieba.sx9;
import com.baidu.tieba.tg;
import com.baidu.tieba.tk7;
import com.baidu.tieba.ui;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity;
import com.baidu.tieba.vk7;
import com.baidu.tieba.ww9;
import com.baidu.tieba.xj7;
import com.baidu.tieba.yj7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class FRSExtraStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                absDelegateAdapterList.add(new FrsSchoolRecommendAdapter(null, a45.c, null));
                absDelegateAdapterList.add(new li7(null, ap6.g, true));
                absDelegateAdapterList.add(new mi7(null, sx9.d, null));
                absDelegateAdapterList.add(new xj7(null, st7.e, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Map<String, String> paramPair;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_VIDEO_MIDDLE_PAGE) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                        return 3;
                    }
                    String str2 = paramPair.get(TbEnum.SystemMessage.KEY_USER_NAME);
                    if (!ui.isEmpty(str2)) {
                        str2 = URLDecoder.decode(str2);
                    }
                    String str3 = paramPair.get("portrait");
                    if (!ui.isEmpty(str3)) {
                        str3 = URLDecoder.decode(str3);
                    }
                    String str4 = paramPair.get("videoUrl");
                    if (!ui.isEmpty(str4)) {
                        str4 = URLDecoder.decode(str4);
                    }
                    String str5 = paramPair.get("thumbnailUrl");
                    if (!ui.isEmpty(str5)) {
                        str5 = URLDecoder.decode(str5);
                    }
                    String str6 = paramPair.get("title");
                    if (!ui.isEmpty(str6)) {
                        str6 = URLDecoder.decode(str6);
                    }
                    ArrayList arrayList = new ArrayList();
                    VideoItemData videoItemData = new VideoItemData();
                    UserItemData userItemData = new UserItemData();
                    videoItemData.author_info = userItemData;
                    userItemData.user_id = paramPair.get("userId");
                    UserItemData userItemData2 = videoItemData.author_info;
                    userItemData2.user_name = str2;
                    userItemData2.portrait = str3;
                    userItemData2.is_follow = paramPair.get("hasFocus");
                    videoItemData.video_url = str4;
                    videoItemData.video_width = paramPair.get("videoWidth");
                    videoItemData.video_height = paramPair.get("videoHeight");
                    videoItemData.thumbnail_url = str5;
                    videoItemData.forum_id = paramPair.get("forumId");
                    videoItemData.thread_id = paramPair.get("threadId");
                    videoItemData.is_agreed = paramPair.get("hasAgree");
                    videoItemData.title = str6;
                    videoItemData.video_duration = tg.e(paramPair.get(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
                    videoItemData.play_count = tg.e(paramPair.get("postNum"), 0);
                    videoItemData.agree_num = paramPair.get("agreeNum");
                    videoItemData.share_num = paramPair.get("shareNum");
                    arrayList.add(videoItemData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(tbPageContext.getContext(), arrayList, null, paramPair.get("from"))));
                    return 1;
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof ie7)) {
                    return;
                }
                ie7 ie7Var = (ie7) data;
                ie7Var.a(new yj7(ie7Var.c(), ie7Var.d()));
                for (FrsTabInfo frsTabInfo : ie7Var.f()) {
                    if (frsTabInfo.tab_id.intValue() > 100) {
                        if (ql6.e(frsTabInfo.tab_url)) {
                            tk7 tk7Var = new tk7(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            ie7Var.a(tk7Var);
                            if (ie7Var.getContext() == null) {
                                continue;
                            } else {
                                cn5 b = tk7Var.b();
                                if (b == null) {
                                    return;
                                }
                                b.a.setArguments(new Bundle());
                            }
                        } else {
                            vk7 vk7Var = new vk7(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            ie7Var.a(vk7Var);
                            if (ie7Var.getContext() == null) {
                                continue;
                            } else {
                                cn5 b2 = vk7Var.b();
                                if (b2 == null) {
                                    return;
                                }
                                b2.a.setArguments(new Bundle());
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new fj7(null, ww9.c, true));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2016468, new dj7());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-961401202, "Lcom/baidu/tieba/frs/FRSExtraStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-961401202, "Lcom/baidu/tieba/frs/FRSExtraStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(VideoEasterEggActivityConfig.class, VideoEasterEggActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoAggregationActivityConfig.class, VideoAggregationActivity.class);
        ThreadData.isFRSExtraLoaded.set(true);
        cd7.a.set(new df7());
        MessageManager.getInstance().registerListener(new a(2003008));
        MessageManager.getInstance().registerTask(new CustomMessageTask(2003016, new b()));
        UrlManager.getInstance().addListener(new c());
        MessageManager.getInstance().registerListener(new d(2001616));
        a();
        b();
    }

    public FRSExtraStatic() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            MessageManager.getInstance().registerListener(new e(2003008));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016468, new f());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }
}
