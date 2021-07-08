package com.baidu.tieba.hottopic.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
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
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.p0.g1.c.j;
import d.a.p0.g1.d.d;
import d.a.p0.u0.p0;
import d.a.p0.u0.r0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes4.dex */
public class FrsHottopicFragment extends BaseFragment implements p0, d.a, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HotRanklistModel f17088e;

    /* renamed from: f  reason: collision with root package name */
    public j f17089f;

    /* renamed from: g  reason: collision with root package name */
    public d f17090g;

    /* renamed from: h  reason: collision with root package name */
    public long f17091h;

    /* renamed from: i  reason: collision with root package name */
    public String f17092i;
    public String j;
    public d.a.o0.d0.c k;
    public CustomMessageListener l;
    public HotRanklistModel.b m;
    public CustomMessageListener n;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsHottopicFragment f17093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsHottopicFragment frsHottopicFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHottopicFragment, Integer.valueOf(i2)};
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
            this.f17093a = frsHottopicFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f17093a.k == null || !this.f17093a.k.isViewAttached()) {
                return;
            }
            this.f17093a.k.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements HotRanklistModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsHottopicFragment f17094e;

        public b(FrsHottopicFragment frsHottopicFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHottopicFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17094e = frsHottopicFragment;
        }

        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.b
        public void loadNetDataCallback(boolean z, j jVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), jVar, Integer.valueOf(i2), str}) == null) {
                this.f17094e.l();
                this.f17094e.S0();
                this.f17094e.f17090g.h(false);
                if (z) {
                    this.f17094e.f17089f = jVar;
                    d dVar = this.f17094e.f17090g;
                    FrsHottopicFragment frsHottopicFragment = this.f17094e;
                    dVar.e(frsHottopicFragment.Q0(frsHottopicFragment.f17089f));
                    if (this.f17094e.R0()) {
                        return;
                    }
                    this.f17094e.f17090g.i();
                } else if (this.f17094e.R0()) {
                } else {
                    this.f17094e.V0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsHottopicFragment f17095a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsHottopicFragment frsHottopicFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsHottopicFragment, Integer.valueOf(i2)};
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
            this.f17095a = frsHottopicFragment;
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
                this.f17095a.refresh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    public FrsHottopicFragment() {
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
        this.l = new a(this, 2921397);
        this.m = new b(this);
        this.n = new c(this, 2001624);
    }

    @Override // d.a.p0.u0.p0
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17090g.d();
        }
    }

    @Override // d.a.p0.u0.r0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final List<n> Q0(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar)) == null) {
            if (jVar == null || ListUtils.isEmpty(jVar.a())) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (TopicList topicList : jVar.a()) {
                if (topicList != null) {
                    b2 b2Var = new b2();
                    b2Var.e4(topicList.topic_tid + "");
                    b2Var.u3(topicList.video_info);
                    b2Var.l3(this.f17091h);
                    b2Var.m3(this.f17092i);
                    b2Var.V3(this.j);
                    b2Var.g4(topicList.topic_h5_url);
                    MetaData metaData = new MetaData();
                    metaData.setUserName(topicList.topic_name);
                    b2Var.h3(metaData);
                    b2Var.H3(topicList.update_time.longValue());
                    b2Var.f4(topicList.topic_desc);
                    b2Var.h4(topicList.topic_user_name);
                    b2Var.B3();
                    ArrayList<MediaData> arrayList2 = new ArrayList<>();
                    List<Media> list = topicList.media;
                    if (list != null) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            MediaData mediaData = new MediaData();
                            mediaData.parserProtobuf(list.get(i2));
                            arrayList2.add(mediaData);
                        }
                    }
                    b2Var.M3(arrayList2);
                    arrayList.add(b2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17090g.b() : invokeV.booleanValue;
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f17090g.g(true);
            d.a.o0.d0.c cVar = this.k;
            if (cVar != null && cVar.isViewAttached()) {
                this.k.dettachView(this.f17090g.a());
            }
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (isPrimary()) {
                d.a.o0.d0.c cVar = this.k;
                if (cVar == null || !cVar.isViewAttached()) {
                    return;
                }
                MessageManager.getInstance().registerListener(this.l);
                return;
            }
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17090g.g(false);
            showLoadingView(this.f17090g.a(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f17090g.g(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            if (this.k == null) {
                d.a.o0.d0.c cVar = new d.a.o0.d0.c(getPageContext().getContext(), getNetRefreshListener());
                this.k = cVar;
                cVar.e(null);
                this.k.d(null);
                this.k.c(null);
                this.k.f();
                this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.k.onChangeSkinType();
            this.k.attachView(this.f17090g.a(), true);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "4";
            tbPageTag.tabId = 401;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f17090g.g(true);
            hideLoadingView(this.f17090g.a());
        }
    }

    @Override // d.a.p0.u0.r0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            d dVar = this.f17090g;
            if (dVar != null) {
                dVar.c();
            }
            d.a.o0.d0.c cVar = this.k;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.k.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
            this.f17088e = hotRanklistModel;
            hotRanklistModel.B(this.m);
            registerListener(this.n);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f17091h = d.a.c.e.m.b.f(arguments.getString("fid"), 0L);
                arguments.getString("from");
                this.f17092i = arguments.getString("first_class_name");
                this.j = arguments.getString("second_class_name");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
            d dVar = new d(this, inflate, getPageContext());
            this.f17090g = dVar;
            dVar.f(getTbPageTag());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || R0()) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f17091h).param("obj_type", 2).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && d.a.c.e.p.j.z()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            T0();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (!d.a.c.e.p.j.z()) {
                V0();
                return;
            }
            S0();
            this.f17090g.d();
            if (!R0()) {
                U0();
            } else {
                this.f17090g.h(true);
            }
            this.f17088e.cancelLoadData();
            this.f17088e.y("frs", "frstab", "0", this.f17091h);
        }
    }

    @Override // d.a.p0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            refresh();
        }
    }
}
