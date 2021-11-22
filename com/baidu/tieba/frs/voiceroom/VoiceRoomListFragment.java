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
import b.a.q0.h.b.b.a;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.d3.c;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.view.ToastUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b(\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onChangeSkinType", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "()V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestRoomList", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter;", "adapter", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment$Binding;", "binding", "subscribeUi", "(Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter;Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment$Binding;)V", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment$Binding;", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "pullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "viewModel", "<init>", "Binding", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class VoiceRoomListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50078h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f50079e;

    /* renamed from: f  reason: collision with root package name */
    public g f50080f;

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f50081g;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C1763a f50084e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final View f50085a;

        /* renamed from: b  reason: collision with root package name */
        public final NavigationBar f50086b;

        /* renamed from: c  reason: collision with root package name */
        public final BdSwipeRefreshLayout f50087c;

        /* renamed from: d  reason: collision with root package name */
        public final RecyclerView f50088d;

        /* renamed from: com.baidu.tieba.frs.voiceroom.VoiceRoomListFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1763a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1763a() {
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

            public final a a(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    View findViewById = view.findViewById(f1.nav_bar);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.nav_bar)");
                    View findViewById2 = view.findViewById(f1.refresh_layout);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById2, "root.findViewById(R.id.refresh_layout)");
                    View findViewById3 = view.findViewById(f1.voice_room_list);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById3, "root.findViewById(R.id.voice_room_list)");
                    return new a(view, (NavigationBar) findViewById, (BdSwipeRefreshLayout) findViewById2, (RecyclerView) findViewById3);
                }
                return (a) invokeL.objValue;
            }

            public /* synthetic */ C1763a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
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
            f50084e = new C1763a(null);
        }

        public a(View view, NavigationBar navigationBar, BdSwipeRefreshLayout bdSwipeRefreshLayout, RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, navigationBar, bdSwipeRefreshLayout, recyclerView};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f50085a = view;
            this.f50086b = navigationBar;
            this.f50087c = bdSwipeRefreshLayout;
            this.f50088d = recyclerView;
        }

        public final NavigationBar a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50086b : (NavigationBar) invokeV.objValue;
        }

        public final BdSwipeRefreshLayout b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50087c : (BdSwipeRefreshLayout) invokeV.objValue;
        }

        public final RecyclerView c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50088d : (RecyclerView) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        return Intrinsics.areEqual(this.f50085a, aVar.f50085a) && Intrinsics.areEqual(this.f50086b, aVar.f50086b) && Intrinsics.areEqual(this.f50087c, aVar.f50087c) && Intrinsics.areEqual(this.f50088d, aVar.f50088d);
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                View view = this.f50085a;
                int hashCode = (view != null ? view.hashCode() : 0) * 31;
                NavigationBar navigationBar = this.f50086b;
                int hashCode2 = (hashCode + (navigationBar != null ? navigationBar.hashCode() : 0)) * 31;
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f50087c;
                int hashCode3 = (hashCode2 + (bdSwipeRefreshLayout != null ? bdSwipeRefreshLayout.hashCode() : 0)) * 31;
                RecyclerView recyclerView = this.f50088d;
                return hashCode3 + (recyclerView != null ? recyclerView.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Binding(root=" + this.f50085a + ", navBar=" + this.f50086b + ", refreshLayout=" + this.f50087c + ", voiceRoomList=" + this.f50088d + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceRoomListFragment f50089e;

        public b(VoiceRoomListFragment voiceRoomListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRoomListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50089e = voiceRoomListFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public final void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f50089e.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724218152, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-724218152, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment;");
                return;
            }
        }
        f50078h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(VoiceRoomListFragment.class), "viewModel", "getViewModel()Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;"))};
    }

    public VoiceRoomListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50081g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(VoiceRoomListViewModel.class), new VoiceRoomListFragment$$special$$inlined$viewModels$2(new VoiceRoomListFragment$$special$$inlined$viewModels$1(this)), null);
    }

    public final VoiceRoomListViewModel g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Lazy lazy = this.f50081g;
            KProperty kProperty = f50078h[0];
            return (VoiceRoomListViewModel) lazy.getValue();
        }
        return (VoiceRoomListViewModel) invokeV.objValue;
    }

    public final void h() {
        Bundle it;
        Frs$From f2;
        long d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (it = getArguments()) == null) {
            return;
        }
        VoiceRoomListViewModel g2 = g();
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        f2 = c.f(it);
        long callFrom = f2.getCallFrom();
        d2 = c.d(it);
        g2.requestRoomList(pageContext, callFrom, d2);
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: androidx.lifecycle.Observer<T>, androidx.lifecycle.Observer<? super b.a.q0.h.b.b.a<java.util.List<com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper>>> */
    public final void i(final VoiceRoomListAdapter voiceRoomListAdapter, final a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceRoomListAdapter, aVar) == null) {
            LiveData<b.a.q0.h.b.b.a<List<VoiceRoomWrapper>>> roomList = g().getRoomList();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkExpressionValueIsNotNull(viewLifecycleOwner, "viewLifecycleOwner");
            roomList.observe(viewLifecycleOwner, new Observer<T>(voiceRoomListAdapter, aVar) { // from class: com.baidu.tieba.frs.voiceroom.VoiceRoomListFragment$subscribeUi$$inlined$observe$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ VoiceRoomListAdapter f50082a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ VoiceRoomListFragment.a f50083b;

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
                    this.f50082a = voiceRoomListAdapter;
                    this.f50083b = aVar;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(T t) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, t) == null) {
                        a aVar2 = (a) t;
                        if (aVar2 instanceof a.c) {
                            this.f50082a.submitList((List) ((a.c) aVar2).a());
                            this.f50083b.b().setRefreshing(false);
                        } else if (aVar2 instanceof a.C0697a) {
                            ToastUtil.show(((a.C0697a) aVar2).a());
                            this.f50083b.b().setRefreshing(false);
                        } else if (aVar2 instanceof a.b) {
                            this.f50083b.b().setRefreshing(true);
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
            a aVar = this.f50079e;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            aVar.a().onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(aVar.a(), c1.CAM_X0209);
            SkinManager.setBackgroundColor(aVar.b(), c1.CAM_X0209);
            g gVar = this.f50080f;
            if (gVar != null) {
                gVar.C(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(g1.fragment_voice_room_list, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "inflater.inflate(R.layou…m_list, container, false)");
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
            Bundle it = getArguments();
            if (it != null) {
                VoiceRoomStat voiceRoomStat = VoiceRoomStat.f50093a;
                VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.PAGE_ENTER;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                f2 = c.f(it);
                d2 = c.d(it);
                Long valueOf = Long.valueOf(d2);
                e2 = c.e(it);
                voiceRoomStat.c(statType, f2, null, null, valueOf, e2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            a a2 = a.f50084e.a(view);
            this.f50079e = a2;
            if (a2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            a2.a().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            a aVar = this.f50079e;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            aVar.a().setCenterTextTitle(getResources().getString(i1.frs_voice_room_list));
            g gVar = new g(getPageContext());
            this.f50080f = gVar;
            if (gVar != null) {
                gVar.a(new b(this));
            }
            a aVar2 = this.f50079e;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            aVar2.b().setProgressView(this.f50080f);
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            VoiceRoomListAdapter voiceRoomListAdapter = new VoiceRoomListAdapter(pageContext, getArguments());
            a aVar3 = this.f50079e;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            aVar3.c().setAdapter(voiceRoomListAdapter);
            DeviderLineDecoration deviderLineDecoration = new DeviderLineDecoration();
            deviderLineDecoration.setDividerHeight(getResources().getDimensionPixelSize(d1.M_H_X003));
            a aVar4 = this.f50079e;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            aVar4.c().addItemDecoration(deviderLineDecoration);
            a aVar5 = this.f50079e;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            i(voiceRoomListAdapter, aVar5);
        }
    }
}
