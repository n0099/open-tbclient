package com.baidu.tieba.frs;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tieba.bba;
import com.baidu.tieba.bf7;
import com.baidu.tieba.bi;
import com.baidu.tieba.ch7;
import com.baidu.tieba.dl7;
import com.baidu.tieba.dw7;
import com.baidu.tieba.fl7;
import com.baidu.tieba.frs.aggregation.VideoAggregationActivity;
import com.baidu.tieba.gaa;
import com.baidu.tieba.hg7;
import com.baidu.tieba.j35;
import com.baidu.tieba.lk7;
import com.baidu.tieba.mk6;
import com.baidu.tieba.mk7;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity;
import com.baidu.tieba.vm7;
import com.baidu.tieba.wn6;
import com.baidu.tieba.xl7;
import com.baidu.tieba.xm7;
import com.baidu.tieba.yl7;
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
                absDelegateAdapterList.add(new FrsSchoolRecommendAdapter(null, j35.c, null));
                absDelegateAdapterList.add(new lk7(null, wn6.g, true));
                absDelegateAdapterList.add(new mk7(null, bba.d, null));
                absDelegateAdapterList.add(new xl7(null, dw7.e, null));
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
                    if (!bi.isEmpty(str2)) {
                        str2 = URLDecoder.decode(str2);
                    }
                    String str3 = paramPair.get("portrait");
                    if (!bi.isEmpty(str3)) {
                        str3 = URLDecoder.decode(str3);
                    }
                    String str4 = paramPair.get("videoUrl");
                    if (!bi.isEmpty(str4)) {
                        str4 = URLDecoder.decode(str4);
                    }
                    String str5 = paramPair.get("thumbnailUrl");
                    if (!bi.isEmpty(str5)) {
                        str5 = URLDecoder.decode(str5);
                    }
                    String str6 = paramPair.get("title");
                    if (!bi.isEmpty(str6)) {
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
                    videoItemData.video_duration = JavaTypesHelper.toInt(paramPair.get(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
                    videoItemData.play_count = JavaTypesHelper.toInt(paramPair.get("postNum"), 0);
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
                if (!(data instanceof hg7)) {
                    return;
                }
                hg7 hg7Var = (hg7) data;
                hg7Var.a(new yl7(hg7Var.c(), hg7Var.d()));
                for (FrsTabInfo frsTabInfo : hg7Var.f()) {
                    if (frsTabInfo.tab_id.intValue() > 100) {
                        if (mk6.e(frsTabInfo.tab_url)) {
                            vm7 vm7Var = new vm7(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            hg7Var.a(vm7Var);
                            if (hg7Var.getContext() == null) {
                                continue;
                            } else {
                                FragmentTabStructure fragmentTabStructure = vm7Var.getFragmentTabStructure();
                                if (fragmentTabStructure == null) {
                                    return;
                                }
                                fragmentTabStructure.frag.setArguments(new Bundle());
                            }
                        } else {
                            xm7 xm7Var = new xm7(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            hg7Var.a(xm7Var);
                            if (hg7Var.getContext() == null) {
                                continue;
                            } else {
                                FragmentTabStructure fragmentTabStructure2 = xm7Var.getFragmentTabStructure();
                                if (fragmentTabStructure2 == null) {
                                    return;
                                }
                                fragmentTabStructure2.frag.setArguments(new Bundle());
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
                ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new fl7(null, gaa.c, true));
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
                return new CustomResponsedMessage<>(2016468, new dl7());
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
        bf7.a.set(new ch7());
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
