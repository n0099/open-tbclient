package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.card.view.RecommendInfoLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomePageAlaRecommendLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonalizeStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
        public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921671, new PersonalizePageView(customMessage.getData()));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Context> {
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
        public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                StickyAppBarLayout stickyAppBarLayout = new StickyAppBarLayout(customMessage.getData());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    stickyAppBarLayout.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
                }
                stickyAppBarLayout.setId(R.id.app_bar_layout);
                return new CustomResponsedMessage<>(2921672, stickyAppBarLayout);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13315b = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.extend_forum_item, (ViewGroup) null);
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13316c = new HomePageAlaRecommendLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13317d = new CardUserInfoLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13318e = new ForumEnterLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13319f = new CardForumHeadLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13320g = new MultiImgLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13321h = new MutiImgTextLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13322i = new MutiImgSingleVerticalLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13323j = new MutiImgMutiPicLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().k = new NewGridImageLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().l = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
                TbadkCoreApplication.getInst().getPersonalizeViewData().m = new ItemCardView(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().n = new SingleLinkCardView(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().o = new MultiLinkCardView(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().p = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
                TbadkCoreApplication.getInst().getPersonalizeViewData().q = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
                TbadkCoreApplication.getInst().getPersonalizeViewData().r = new ThreadGodReplyLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().s = new ThreadCardBottomOpSegmentLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().t = new RecommendInfoLayout(TbadkCoreApplication.getInst());
                Looper.loop();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318220679, "Lcom/baidu/tieba/homepage/personalize/PersonalizeStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318220679, "Lcom/baidu/tieba/homepage/personalize/PersonalizeStatic;");
                return;
            }
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2921671, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921672, new b());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            new Thread(new c()).start();
        }
    }

    public PersonalizeStatic() {
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
}
