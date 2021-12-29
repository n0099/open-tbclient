package com.baidu.tieba.homepage.personalize;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.view.HomePageAlaRecommendLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PersonalizeStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                TbadkCoreApplication.getInst().getPersonalizeViewData().a = new PersonalizePageView(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13744b = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.extend_forum_item, (ViewGroup) null);
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13745c = new HomePageAlaRecommendLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13746d = new CardUserInfoLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13747e = new ForumEnterLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13748f = new CardForumHeadLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13749g = new MultiImgLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13750h = new MutiImgTextLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13751i = new MutiImgSingleVerticalLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13752j = new MutiImgMutiPicLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f13753k = new NewGridImageLayout(TbadkCoreApplication.getInst());
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
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            new Thread(new a()).start();
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
