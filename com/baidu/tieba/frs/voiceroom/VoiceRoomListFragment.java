package com.baidu.tieba.frs.voiceroom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import c.a.s0.h.b.b.a;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.e3.e;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.view.ToastUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.widget.DeviderLineDecoration;
import com.baidu.tieba.frs.voiceroom.VoiceRoomListFragment;
import com.baidu.tieba.frs.voiceroom.VoiceRoomStat;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "()V", "binding", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment$Binding;", "pullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "viewModel", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "getViewModel", "()Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "requestRoomList", "subscribeUi", "adapter", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter;", "Binding", "frs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class VoiceRoomListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f43938e;

    /* renamed from: f  reason: collision with root package name */
    public g f43939f;

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f43940g;

    /* loaded from: classes12.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C1922a f43942e;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public final NavigationBar f43943b;

        /* renamed from: c  reason: collision with root package name */
        public final BdSwipeRefreshLayout f43944c;

        /* renamed from: d  reason: collision with root package name */
        public final RecyclerView f43945d;

        /* renamed from: com.baidu.tieba.frs.voiceroom.VoiceRoomListFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C1922a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1922a() {
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

            public /* synthetic */ C1922a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(View root) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, root)) == null) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    View findViewById = root.findViewById(f1.nav_bar);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.nav_bar)");
                    View findViewById2 = root.findViewById(f1.refresh_layout);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.refresh_layout)");
                    View findViewById3 = root.findViewById(f1.voice_room_list);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.voice_room_list)");
                    return new a(root, (NavigationBar) findViewById, (BdSwipeRefreshLayout) findViewById2, (RecyclerView) findViewById3);
                }
                return (a) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-188961157, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-188961157, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment$a;");
                    return;
                }
            }
            f43942e = new C1922a(null);
        }

        public a(View root, NavigationBar navBar, BdSwipeRefreshLayout refreshLayout, RecyclerView voiceRoomList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {root, navBar, refreshLayout, voiceRoomList};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(navBar, "navBar");
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            Intrinsics.checkNotNullParameter(voiceRoomList, "voiceRoomList");
            this.a = root;
            this.f43943b = navBar;
            this.f43944c = refreshLayout;
            this.f43945d = voiceRoomList;
        }

        public final NavigationBar a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43943b : (NavigationBar) invokeV.objValue;
        }

        public final BdSwipeRefreshLayout b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43944c : (BdSwipeRefreshLayout) invokeV.objValue;
        }

        public final RecyclerView c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43945d : (RecyclerView) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.f43943b, aVar.f43943b) && Intrinsics.areEqual(this.f43944c, aVar.f43944c) && Intrinsics.areEqual(this.f43945d, aVar.f43945d);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (((((this.a.hashCode() * 31) + this.f43943b.hashCode()) * 31) + this.f43944c.hashCode()) * 31) + this.f43945d.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Binding(root=" + this.a + ", navBar=" + this.f43943b + ", refreshLayout=" + this.f43944c + ", voiceRoomList=" + this.f43945d + ')';
            }
            return (String) invokeV.objValue;
        }
    }

    public VoiceRoomListFragment() {
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
        this.f43940g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(VoiceRoomListViewModel.class), new VoiceRoomListFragment$special$$inlined$viewModels$default$2(new VoiceRoomListFragment$special$$inlined$viewModels$default$1(this)), null);
    }

    public static final void j(VoiceRoomListFragment this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.k();
        }
    }

    public final VoiceRoomListViewModel i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (VoiceRoomListViewModel) this.f43940g.getValue() : (VoiceRoomListViewModel) invokeV.objValue;
    }

    public final void k() {
        Bundle arguments;
        Frs$From f2;
        long d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (arguments = getArguments()) == null) {
            return;
        }
        VoiceRoomListViewModel i2 = i();
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
        f2 = e.f(arguments);
        long callFrom = f2.getCallFrom();
        d2 = e.d(arguments);
        i2.requestRoomList(pageContext, callFrom, d2);
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: androidx.lifecycle.Observer<T>, androidx.lifecycle.Observer<? super c.a.s0.h.b.b.a<java.util.List<com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper>>> */
    public final void l(final VoiceRoomListAdapter voiceRoomListAdapter, final a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceRoomListAdapter, aVar) == null) {
            LiveData<c.a.s0.h.b.b.a<List<VoiceRoomWrapper>>> roomList = i().getRoomList();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            roomList.observe(viewLifecycleOwner, new Observer<T>(voiceRoomListAdapter, aVar) { // from class: com.baidu.tieba.frs.voiceroom.VoiceRoomListFragment$subscribeUi$$inlined$observe$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VoiceRoomListAdapter a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ VoiceRoomListFragment.a f43941b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {voiceRoomListAdapter, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = voiceRoomListAdapter;
                    this.f43941b = aVar;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(T t) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, t) == null) {
                        a aVar2 = (a) t;
                        if (aVar2 instanceof a.c) {
                            this.a.submitList((List) ((a.c) aVar2).a());
                            this.f43941b.b().setRefreshing(false);
                        } else if (aVar2 instanceof a.C0859a) {
                            ToastUtil.show(((a.C0859a) aVar2).a());
                            this.f43941b.b().setRefreshing(false);
                        } else if (aVar2 instanceof a.b) {
                            this.f43941b.b().setRefreshing(true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            a aVar = this.f43938e;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            aVar.a().onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(aVar.a(), c1.CAM_X0209);
            SkinManager.setBackgroundColor(aVar.b(), c1.CAM_X0209);
            g gVar = this.f43939f;
            if (gVar == null) {
                return;
            }
            gVar.C(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(g1.fragment_voice_room_list, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…m_list, container, false)");
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Frs$From f2;
        long d2;
        String e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStart();
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            VoiceRoomStat voiceRoomStat = VoiceRoomStat.a;
            VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.PAGE_ENTER;
            f2 = e.f(arguments);
            d2 = e.d(arguments);
            Long valueOf = Long.valueOf(d2);
            e2 = e.e(arguments);
            voiceRoomStat.c(statType, f2, null, null, valueOf, e2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, bundle);
            a a2 = a.f43942e.a(view);
            this.f43938e = a2;
            a aVar = null;
            if (a2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                a2 = null;
            }
            a2.a().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            a aVar2 = this.f43938e;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            aVar2.a().setCenterTextTitle(getResources().getString(i1.frs_voice_room_list));
            g gVar = new g(getPageContext());
            this.f43939f = gVar;
            if (gVar != null) {
                gVar.a(new f.g() { // from class: c.a.t0.e1.e3.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // c.a.s0.s.k0.f.g
                    public final void onListPullRefresh(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            VoiceRoomListFragment.j(VoiceRoomListFragment.this, z);
                        }
                    }
                });
            }
            a aVar3 = this.f43938e;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            aVar3.b().setProgressView(this.f43939f);
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            VoiceRoomListAdapter voiceRoomListAdapter = new VoiceRoomListAdapter(pageContext, getArguments());
            a aVar4 = this.f43938e;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar4 = null;
            }
            aVar4.c().setAdapter(voiceRoomListAdapter);
            DeviderLineDecoration deviderLineDecoration = new DeviderLineDecoration();
            deviderLineDecoration.setDividerHeight(getResources().getDimensionPixelSize(d1.M_H_X003));
            a aVar5 = this.f43938e;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar5 = null;
            }
            aVar5.c().addItemDecoration(deviderLineDecoration);
            a aVar6 = this.f43938e;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar6;
            }
            l(voiceRoomListAdapter, aVar);
        }
    }
}
