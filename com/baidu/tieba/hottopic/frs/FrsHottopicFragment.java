package com.baidu.tieba.hottopic.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.d1.q0;
import c.a.r0.d1.s0;
import c.a.r0.p1.f;
import c.a.r0.p1.l.j;
import c.a.r0.p1.m.d;
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
/* loaded from: classes10.dex */
public class FrsHottopicFragment extends BaseFragment implements q0, d.a, s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HotRanklistModel f45645e;

    /* renamed from: f  reason: collision with root package name */
    public j f45646f;

    /* renamed from: g  reason: collision with root package name */
    public d f45647g;

    /* renamed from: h  reason: collision with root package name */
    public long f45648h;

    /* renamed from: i  reason: collision with root package name */
    public String f45649i;

    /* renamed from: j  reason: collision with root package name */
    public String f45650j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.g0.c f45651k;
    public CustomMessageListener l;
    public HotRanklistModel.b m;
    public CustomMessageListener n;

    /* loaded from: classes10.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsHottopicFragment a;

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
            this.a = frsHottopicFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.f45651k == null || !this.a.f45651k.isViewAttached()) {
                return;
            }
            this.a.f45651k.a(num.intValue());
        }
    }

    /* loaded from: classes10.dex */
    public class b implements HotRanklistModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsHottopicFragment f45652e;

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
            this.f45652e = frsHottopicFragment;
        }

        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.b
        public void loadNetDataCallback(boolean z, j jVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), jVar, Integer.valueOf(i2), str}) == null) {
                this.f45652e.hideLoadingView();
                this.f45652e.hideNetRefreshView();
                this.f45652e.f45647g.h(false);
                if (z) {
                    this.f45652e.f45646f = jVar;
                    d dVar = this.f45652e.f45647g;
                    FrsHottopicFragment frsHottopicFragment = this.f45652e;
                    dVar.e(frsHottopicFragment.n(frsHottopicFragment.f45646f));
                    if (this.f45652e.o()) {
                        return;
                    }
                    this.f45652e.f45647g.i();
                } else if (this.f45652e.o()) {
                } else {
                    this.f45652e.showNetRefreshView();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsHottopicFragment a;

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

    @Override // c.a.r0.d1.q0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    @Override // c.a.r0.d1.q0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = "4";
            tbPageTag.tabId = 401;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f45647g.g(true);
            hideLoadingView(this.f45647g.a());
        }
    }

    public final void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f45647g.g(true);
            c.a.q0.g0.c cVar = this.f45651k;
            if (cVar != null && cVar.isViewAttached()) {
                this.f45651k.dettachView(this.f45647g.a());
            }
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final List<n> n(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jVar)) == null) {
            if (jVar == null || ListUtils.isEmpty(jVar.a())) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (TopicList topicList : jVar.a()) {
                if (topicList != null) {
                    d2 d2Var = new d2();
                    d2Var.E4(topicList.topic_tid + "");
                    d2Var.R3(topicList.video_info);
                    d2Var.I3(this.f45648h);
                    d2Var.J3(this.f45649i);
                    d2Var.v4(this.f45650j);
                    d2Var.G4(topicList.topic_h5_url);
                    MetaData metaData = new MetaData();
                    metaData.setUserName(topicList.topic_name);
                    d2Var.B3(metaData);
                    d2Var.g4(topicList.update_time.longValue());
                    d2Var.F4(topicList.topic_desc);
                    d2Var.H4(topicList.topic_user_name);
                    d2Var.a4();
                    ArrayList<MediaData> arrayList2 = new ArrayList<>();
                    List<Media> list = topicList.media;
                    if (list != null) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            MediaData mediaData = new MediaData();
                            mediaData.parserProtobuf(list.get(i2));
                            arrayList2.add(mediaData);
                        }
                    }
                    d2Var.m4(arrayList2);
                    arrayList.add(d2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45647g.b() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            d dVar = this.f45647g;
            if (dVar != null) {
                dVar.c();
            }
            c.a.q0.g0.c cVar = this.f45651k;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.f45651k.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
            this.f45645e = hotRanklistModel;
            hotRanklistModel.B(this.m);
            registerListener(this.n);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f45648h = c.a.d.f.m.b.g(arguments.getString("fid"), 0L);
                arguments.getString("from");
                this.f45649i = arguments.getString("first_class_name");
                this.f45650j = arguments.getString("second_class_name");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(f.frs_hottopic_fragment, (ViewGroup) null);
            d dVar = new d(this, inflate, getPageContext());
            this.f45647g = dVar;
            dVar.f(getTbPageTag());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || o()) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.f45648h).param("obj_type", 2).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // c.a.r0.d1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && c.a.d.f.p.j.z()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrimary();
            p();
        }
    }

    @Override // c.a.r0.d1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            refresh();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (isPrimary()) {
                c.a.q0.g0.c cVar = this.f45651k;
                if (cVar != null && cVar.isViewAttached()) {
                    registerListener(this.l);
                    return;
                } else {
                    MessageManager.getInstance().unRegisterListener(this.l);
                    return;
                }
            }
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!c.a.d.f.p.j.z()) {
                showNetRefreshView();
                return;
            }
            hideNetRefreshView();
            this.f45647g.d();
            if (!o()) {
                showLoadingView();
            } else {
                this.f45647g.h(true);
            }
            this.f45645e.cancelLoadData();
            this.f45645e.y("frs", "frstab", "0", this.f45648h);
        }
    }

    @Override // c.a.r0.d1.q0
    public void scrollToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f45647g.d();
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f45647g.g(false);
            showLoadingView(this.f45647g.a(), true, getResources().getDimensionPixelSize(c.a.r0.p1.c.ds250));
        }
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f45647g.g(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            if (this.f45651k == null) {
                c.a.q0.g0.c cVar = new c.a.q0.g0.c(getPageContext().getContext(), getNetRefreshListener());
                this.f45651k = cVar;
                cVar.e(null);
                this.f45651k.d(null);
                this.f45651k.c(null);
                this.f45651k.f();
                this.f45651k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.f45651k.onChangeSkinType();
            this.f45651k.attachView(this.f45647g.a(), true);
            registerListener(this.l);
        }
    }
}
