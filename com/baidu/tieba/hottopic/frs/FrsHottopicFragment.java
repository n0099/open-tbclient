package com.baidu.tieba.hottopic.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.da7;
import com.baidu.tieba.ga5;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.jl6;
import com.baidu.tieba.la7;
import com.baidu.tieba.ll6;
import com.baidu.tieba.xg;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes4.dex */
public class FrsHottopicFragment extends BaseFragment implements jl6, la7.a, ll6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotRanklistModel a;
    public da7 b;
    public la7 c;
    public long d;
    public String e;
    public String f;
    public ga5 g;
    public CustomMessageListener h;
    public HotRanklistModel.b i;
    public CustomMessageListener j;

    @Override // com.baidu.tieba.ll6
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jl6
    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsHottopicFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsHottopicFragment frsHottopicFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHottopicFragment, Integer.valueOf(i)};
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
            this.a = frsHottopicFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && this.a.g != null && this.a.g.isViewAttached()) {
                this.a.g.a(num.intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements HotRanklistModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsHottopicFragment a;

        public b(FrsHottopicFragment frsHottopicFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHottopicFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsHottopicFragment;
        }

        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.b
        public void a(boolean z, da7 da7Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), da7Var, Integer.valueOf(i), str}) == null) {
                this.a.n();
                this.a.I1();
                this.a.c.h(false);
                if (!z) {
                    if (!this.a.H1()) {
                        this.a.L1();
                        return;
                    }
                    return;
                }
                this.a.b = da7Var;
                la7 la7Var = this.a.c;
                FrsHottopicFragment frsHottopicFragment = this.a;
                la7Var.e(frsHottopicFragment.G1(frsHottopicFragment.b));
                if (!this.a.H1()) {
                    this.a.c.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsHottopicFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsHottopicFragment frsHottopicFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHottopicFragment, Integer.valueOf(i)};
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
            this.a = frsHottopicFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 401) {
                this.a.refresh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    public FrsHottopicFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2921397);
        this.i = new b(this);
        this.j = new c(this, 2001624);
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.g(true);
            ga5 ga5Var = this.g;
            if (ga5Var != null && ga5Var.isViewAttached()) {
                this.g.dettachView(this.c.a());
            }
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (isPrimary()) {
                ga5 ga5Var = this.g;
                if (ga5Var != null && ga5Var.isViewAttached()) {
                    registerListener(this.h);
                    return;
                } else {
                    MessageManager.getInstance().unRegisterListener(this.h);
                    return;
                }
            }
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.d).param("obj_type", 2).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                L1();
                return;
            }
            I1();
            this.c.d();
            if (!H1()) {
                K1();
            } else {
                this.c.h(true);
            }
            this.a.cancelLoadData();
            this.a.I("frs", "frstab", "0", this.d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            la7 la7Var = this.c;
            if (la7Var != null) {
                la7Var.c();
            }
            ga5 ga5Var = this.g;
            if (ga5Var != null && ga5Var.isViewAttached()) {
                this.g.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.jl6
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            refresh();
        }
    }

    public final boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.b();
        }
        return invokeV.booleanValue;
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.g(false);
            showLoadingView(this.c.a(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
        }
    }

    @Override // com.baidu.tieba.ll6
    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "4";
            tbPageTag.tabId = 401;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.g(true);
            hideLoadingView(this.c.a());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !H1()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            J1();
        }
    }

    @Override // com.baidu.tieba.jl6
    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.c.d();
        }
    }

    public final List<xn> G1(da7 da7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, da7Var)) == null) {
            if (da7Var != null && !ListUtils.isEmpty(da7Var.a())) {
                ArrayList arrayList = new ArrayList();
                for (TopicList topicList : da7Var.a()) {
                    if (topicList != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.setTid(topicList.topic_tid + "");
                        threadData.setHotTopicInfo(topicList.video_info);
                        threadData.setFid(this.d);
                        threadData.setFirstClassName(this.e);
                        threadData.setSecondClassName(this.f);
                        threadData.setTopicUrl(topicList.topic_h5_url);
                        MetaData metaData = new MetaData();
                        metaData.setUserName(topicList.topic_name);
                        threadData.setAuthor(metaData);
                        threadData.setLast_time_int(topicList.update_time.longValue());
                        threadData.setTitle(topicList.topic_desc);
                        threadData.setTopicUserName(topicList.topic_user_name);
                        threadData.setIsTopicThread();
                        ArrayList<MediaData> arrayList2 = new ArrayList<>();
                        List<Media> list = topicList.media;
                        if (list != null) {
                            for (int i = 0; i < list.size(); i++) {
                                MediaData mediaData = new MediaData();
                                mediaData.parserProtobuf(list.get(i));
                                arrayList2.add(mediaData);
                            }
                        }
                        threadData.setMedias(arrayList2);
                        arrayList.add(threadData);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.g(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            if (this.g == null) {
                ga5 ga5Var = new ga5(getPageContext().getContext(), getNetRefreshListener());
                this.g = ga5Var;
                ga5Var.e(null);
                this.g.d(null);
                this.g.c(null);
                this.g.f();
                this.g.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.g.onChangeSkinType();
            this.g.attachView(this.c.a(), true);
            registerListener(this.h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
            this.a = hotRanklistModel;
            hotRanklistModel.L(this.i);
            registerListener(this.j);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.d = xg.g(arguments.getString("fid"), 0L);
                arguments.getString("from");
                this.e = arguments.getString("first_class_name");
                this.f = arguments.getString("second_class_name");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d032e, (ViewGroup) null);
            la7 la7Var = new la7(this, inflate, getPageContext());
            this.c = la7Var;
            la7Var.f(getTbPageTag());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
