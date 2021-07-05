package com.baidu.tieba.frs;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.frs.aggregation.VideoAggregationActivity;
import com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity;
import com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity;
import com.baidu.tieba.frs.gameshare.GameShareCardActivity;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.professional.FrsProfessionIntroActivity;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageActivity;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import d.a.c.e.p.k;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.r1;
import d.a.s0.a0.e0.n;
import d.a.s0.h3.e0;
import d.a.s0.h3.l;
import d.a.s0.u0.a1;
import d.a.s0.u0.i0;
import java.net.URLDecoder;
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
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                absDelegateAdapterList.add(new FrsSchoolRecommendAdapter(null, r1.N3, null));
                absDelegateAdapterList.add(new d.a.s0.u0.o1.a.a(null, n.k, true));
                absDelegateAdapterList.add(new d.a.s0.u0.o1.a.b(null, e0.O3, null));
                absDelegateAdapterList.add(new d.a.s0.u0.s1.a(null, d.a.s0.x0.b.f69399i, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    if (!k.isEmpty(str2)) {
                        str2 = URLDecoder.decode(str2);
                    }
                    String str3 = paramPair.get("portrait");
                    if (!k.isEmpty(str3)) {
                        str3 = URLDecoder.decode(str3);
                    }
                    String str4 = paramPair.get("videoUrl");
                    if (!k.isEmpty(str4)) {
                        str4 = URLDecoder.decode(str4);
                    }
                    String str5 = paramPair.get("thumbnailUrl");
                    if (!k.isEmpty(str5)) {
                        str5 = URLDecoder.decode(str5);
                    }
                    String str6 = paramPair.get("title");
                    if (!k.isEmpty(str6)) {
                        str6 = URLDecoder.decode(str6);
                    }
                    VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                    VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                    videoSerializeVideoThreadInfo.author = videoAggregationAuthorData;
                    videoAggregationAuthorData.userId = paramPair.get("userId");
                    VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData2 = videoSerializeVideoThreadInfo.author;
                    videoAggregationAuthorData2.userName = str2;
                    videoAggregationAuthorData2.portrait = str3;
                    videoAggregationAuthorData2.hasFocus = "1".equals(paramPair.get("hasFocus"));
                    videoSerializeVideoThreadInfo.author.isGod = "1".equals(paramPair.get("isGod"));
                    VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                    videoSerializeVideoThreadInfo.video = videoAggregationVideoData;
                    videoAggregationVideoData.videoMd5 = paramPair.get("videoMd5");
                    VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData2 = videoSerializeVideoThreadInfo.video;
                    videoAggregationVideoData2.videoUrl = str4;
                    videoAggregationVideoData2.videoWidth = paramPair.get("videoWidth");
                    videoSerializeVideoThreadInfo.video.videoHeight = paramPair.get("videoHeight");
                    videoSerializeVideoThreadInfo.video.thumbnailUrl = str5;
                    videoSerializeVideoThreadInfo.forumId = paramPair.get(TbTitleActivityConfig.FORUM_ID);
                    videoSerializeVideoThreadInfo.threadId = paramPair.get("threadId");
                    videoSerializeVideoThreadInfo.hasAgree = "1".equals(paramPair.get("hasAgree"));
                    videoSerializeVideoThreadInfo.title = str6;
                    videoSerializeVideoThreadInfo.video.videoDuration = d.a.c.e.m.b.d(paramPair.get(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
                    videoSerializeVideoThreadInfo.postNum = d.a.c.e.m.b.d(paramPair.get("postNum"), 0);
                    videoSerializeVideoThreadInfo.agreeNum = d.a.c.e.m.b.d(paramPair.get("agreeNum"), 0);
                    videoSerializeVideoThreadInfo.disAgreeNum = d.a.c.e.m.b.d(paramPair.get("disagreeNum"), 0);
                    videoSerializeVideoThreadInfo.agreeType = d.a.c.e.m.b.d(paramPair.get("agreeType"), 0);
                    videoSerializeVideoThreadInfo.shareNum = d.a.c.e.m.b.d(paramPair.get("shareNum"), 0);
                    videoSerializeVideoThreadInfo.mVideoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(tbPageContext.getContext(), paramPair.get("from"), videoSerializeVideoThreadInfo.threadId, "", "", videoSerializeVideoThreadInfo)));
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
        public d(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (data instanceof i0) {
                    i0 i0Var = (i0) data;
                    i0Var.a(new d.a.s0.u0.t1.a(i0Var.d(), i0Var.e()));
                    for (FrsTabInfo frsTabInfo : i0Var.g()) {
                        if (frsTabInfo.tab_id.intValue() > 100) {
                            d.a.s0.u0.x1.c cVar = new d.a.s0.u0.x1.c(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            i0Var.a(cVar);
                            if (i0Var.b() == null) {
                                continue;
                            } else {
                                d.a.r0.e0.c fragmentTabStructure = cVar.getFragmentTabStructure();
                                if (fragmentTabStructure == null) {
                                    return;
                                }
                                fragmentTabStructure.f55251a.setArguments(new Bundle());
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
        public e(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new d.a.s0.u0.q1.c(null, l.f61331g, true));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2016468, new d.a.s0.u0.q1.a()) : (CustomResponsedMessage) invokeL.objValue;
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
        TbadkCoreApplication.getInst().RegisterIntent(GameShareActivityConfig.class, GameShareCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoAggregationActivityConfig.class, VideoAggregationActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoMiddlePageActivityConfig.class, VideoMiddlePageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoMiddlePageLightActivityConfig.class, VideoMiddlePageLightActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameCommentActivityConfig.class, FrsGameCommentActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameSubPbActivityConfig.class, FrsGameSubPbActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsProfessionIntroActivityConfig.class, FrsProfessionIntroActivity.class);
        b2.A3.set(true);
        d.a.s0.u0.e.f65833a.set(new a1());
        MessageManager.getInstance().registerListener(new a(2003008));
        MessageManager.getInstance().registerTask(new CustomMessageTask(2003016, new b()));
        UrlManager.getInstance().addListener(new c());
        MessageManager.getInstance().registerListener(new d(2001616));
        TbadkCoreApplication.getInst().RegisterIntent(FrsMoreFeedForumsConfig.class, FrsMoreFeedForumsActivity.class);
        a();
        b();
    }

    public FRSExtraStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
