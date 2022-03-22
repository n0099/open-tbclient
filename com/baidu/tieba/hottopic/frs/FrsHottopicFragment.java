package com.baidu.tieba.hottopic.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.p0.f1.q0;
import c.a.p0.f1.s0;
import c.a.p0.s1.b.j;
import c.a.p0.s1.c.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes5.dex */
public class FrsHottopicFragment extends BaseFragment implements q0, d.a, s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotRanklistModel a;

    /* renamed from: b  reason: collision with root package name */
    public j f33638b;

    /* renamed from: c  reason: collision with root package name */
    public d f33639c;

    /* renamed from: d  reason: collision with root package name */
    public long f33640d;

    /* renamed from: e  reason: collision with root package name */
    public String f33641e;

    /* renamed from: f  reason: collision with root package name */
    public String f33642f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.f0.c f33643g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f33644h;
    public HotRanklistModel.b i;
    public CustomMessageListener j;

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.f33643g == null || !this.a.f33643g.isViewAttached()) {
                return;
            }
            this.a.f33643g.a(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
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
        public void a(boolean z, j jVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), jVar, Integer.valueOf(i), str}) == null) {
                this.a.d();
                this.a.N0();
                this.a.f33639c.h(false);
                if (z) {
                    this.a.f33638b = jVar;
                    d dVar = this.a.f33639c;
                    FrsHottopicFragment frsHottopicFragment = this.a;
                    dVar.e(frsHottopicFragment.L0(frsHottopicFragment.f33638b));
                    if (this.a.M0()) {
                        return;
                    }
                    this.a.f33639c.i();
                } else if (this.a.M0()) {
                } else {
                    this.a.Q0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
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
        this.f33644h = new a(this, 2921397);
        this.i = new b(this);
        this.j = new c(this, 2001624);
    }

    @Override // c.a.p0.f1.q0
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33639c.d();
        }
    }

    @Override // c.a.p0.f1.s0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.a.p0.f1.q0
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
        }
    }

    public final List<n> L0(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jVar)) == null) {
            if (jVar == null || ListUtils.isEmpty(jVar.a())) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (TopicList topicList : jVar.a()) {
                if (topicList != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.setTid(topicList.topic_tid + "");
                    threadData.setHotTopicInfo(topicList.video_info);
                    threadData.setFid(this.f33640d);
                    threadData.setFirstClassName(this.f33641e);
                    threadData.setSecondClassName(this.f33642f);
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
        return (List) invokeL.objValue;
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33639c.b() : invokeV.booleanValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f33639c.g(true);
            c.a.o0.f0.c cVar = this.f33643g;
            if (cVar != null && cVar.isViewAttached()) {
                this.f33643g.dettachView(this.f33639c.a());
            }
            MessageManager.getInstance().unRegisterListener(this.f33644h);
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (isPrimary()) {
                c.a.o0.f0.c cVar = this.f33643g;
                if (cVar != null && cVar.isViewAttached()) {
                    registerListener(this.f33644h);
                    return;
                } else {
                    MessageManager.getInstance().unRegisterListener(this.f33644h);
                    return;
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f33644h);
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f33639c.g(false);
            showLoadingView(this.f33639c.a(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027f));
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f33639c.g(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            if (this.f33643g == null) {
                c.a.o0.f0.c cVar = new c.a.o0.f0.c(getPageContext().getContext(), getNetRefreshListener());
                this.f33643g = cVar;
                cVar.e(null);
                this.f33643g.d(null);
                this.f33643g.c(null);
                this.f33643g.f();
                this.f33643g.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.f33643g.onChangeSkinType();
            this.f33643g.attachView(this.f33639c.a(), true);
            registerListener(this.f33644h);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f33639c.g(true);
            hideLoadingView(this.f33639c.a());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "4";
            tbPageTag.tabId = 401;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // c.a.p0.f1.s0
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            d dVar = this.f33639c;
            if (dVar != null) {
                dVar.c();
            }
            c.a.o0.f0.c cVar = this.f33643g;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.f33643g.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
            this.a = hotRanklistModel;
            hotRanklistModel.D(this.i);
            registerListener(this.j);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f33640d = c.a.d.f.m.b.g(arguments.getString("fid"), 0L);
                arguments.getString("from");
                this.f33641e = arguments.getString("first_class_name");
                this.f33642f = arguments.getString("second_class_name");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d032d, (ViewGroup) null);
            d dVar = new d(this, inflate, getPageContext());
            this.f33639c = dVar;
            dVar.f(getTbPageTag());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f33644h);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || M0()) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f33640d).param("obj_type", 2).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && l.z()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            O0();
        }
    }

    @Override // c.a.p0.f1.q0
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            refresh();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!l.z()) {
                Q0();
                return;
            }
            N0();
            this.f33639c.d();
            if (!M0()) {
                P0();
            } else {
                this.f33639c.h(true);
            }
            this.a.cancelLoadData();
            this.a.A("frs", "frstab", "0", this.f33640d);
        }
    }
}
