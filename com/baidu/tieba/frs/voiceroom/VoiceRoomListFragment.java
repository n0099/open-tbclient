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
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.widget.DeviderLineDecoration;
import com.baidu.tieba.R;
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
import com.repackage.am4;
import com.repackage.av4;
import com.repackage.bv4;
import com.repackage.js6;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "()V", "binding", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListFragment$Binding;", "pullView", "Lcom/baidu/tbadk/core/view/TbListViewPullView;", "viewModel", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "getViewModel", "()Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", NativeConstants.TYPE_VIEW, "requestRoomList", "subscribeUi", "adapter", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter;", "Binding", "frs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceRoomListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public bv4 b;
    public final Lazy c;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0213a e;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;
        public final NavigationBar b;
        public final BdSwipeRefreshLayout c;
        public final RecyclerView d;

        /* renamed from: com.baidu.tieba.frs.voiceroom.VoiceRoomListFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0213a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0213a() {
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

            public /* synthetic */ C0213a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(View root) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, root)) == null) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    View findViewById = root.findViewById(R.id.obfuscated_res_0x7f0915ff);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.nav_bar)");
                    View findViewById2 = root.findViewById(R.id.obfuscated_res_0x7f091b7b);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.refresh_layout)");
                    View findViewById3 = root.findViewById(R.id.obfuscated_res_0x7f0925a8);
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
            e = new C0213a(null);
        }

        public a(View root, NavigationBar navBar, BdSwipeRefreshLayout refreshLayout, RecyclerView voiceRoomList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {root, navBar, refreshLayout, voiceRoomList};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            this.b = navBar;
            this.c = refreshLayout;
            this.d = voiceRoomList;
        }

        public final NavigationBar a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (NavigationBar) invokeV.objValue;
        }

        public final BdSwipeRefreshLayout b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (BdSwipeRefreshLayout) invokeV.objValue;
        }

        public final RecyclerView c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (RecyclerView) invokeV.objValue;
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
                    return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Binding(root=" + this.a + ", navBar=" + this.b + ", refreshLayout=" + this.c + ", voiceRoomList=" + this.d + ')';
            }
            return (String) invokeV.objValue;
        }
    }

    public VoiceRoomListFragment() {
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
        this.c = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(VoiceRoomListViewModel.class), new VoiceRoomListFragment$special$$inlined$viewModels$default$2(new VoiceRoomListFragment$special$$inlined$viewModels$default$1(this)), null);
    }

    public static final void s1(VoiceRoomListFragment this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.t1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            a aVar = this.a;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            aVar.a().onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(aVar.a(), R.color.CAM_X0209);
            SkinManager.setBackgroundColor(aVar.b(), R.color.CAM_X0209);
            bv4 bv4Var = this.b;
            if (bv4Var == null) {
                return;
            }
            bv4Var.H(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            t1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d02e5, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…m_list, container, false)");
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Frs$From f;
        long d;
        String e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onStart();
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            VoiceRoomStat voiceRoomStat = VoiceRoomStat.a;
            VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.PAGE_ENTER;
            f = js6.f(arguments);
            d = js6.d(arguments);
            Long valueOf = Long.valueOf(d);
            e = js6.e(arguments);
            voiceRoomStat.c(statType, f, null, null, valueOf, e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            a a2 = a.e.a(view2);
            this.a = a2;
            a aVar = null;
            if (a2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                a2 = null;
            }
            a2.a().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            a aVar2 = this.a;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            aVar2.a().setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0766));
            bv4 bv4Var = new bv4(getPageContext());
            this.b = bv4Var;
            if (bv4Var != null) {
                bv4Var.f(new av4.g() { // from class: com.repackage.fs6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.repackage.av4.g
                    public final void e(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            VoiceRoomListFragment.s1(VoiceRoomListFragment.this, z);
                        }
                    }
                });
            }
            a aVar3 = this.a;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            aVar3.b().setProgressView(this.b);
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            VoiceRoomListAdapter voiceRoomListAdapter = new VoiceRoomListAdapter(pageContext, getArguments());
            a aVar4 = this.a;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar4 = null;
            }
            aVar4.c().setAdapter(voiceRoomListAdapter);
            DeviderLineDecoration deviderLineDecoration = new DeviderLineDecoration();
            deviderLineDecoration.a(getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            a aVar5 = this.a;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar5 = null;
            }
            aVar5.c().addItemDecoration(deviderLineDecoration);
            a aVar6 = this.a;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar6;
            }
            u1(voiceRoomListAdapter, aVar);
        }
    }

    public final VoiceRoomListViewModel r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (VoiceRoomListViewModel) this.c.getValue() : (VoiceRoomListViewModel) invokeV.objValue;
    }

    public final void t1() {
        Bundle arguments;
        Frs$From f;
        long d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (arguments = getArguments()) == null) {
            return;
        }
        VoiceRoomListViewModel r1 = r1();
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
        f = js6.f(arguments);
        long callFrom = f.getCallFrom();
        d = js6.d(arguments);
        r1.c(pageContext, callFrom, d);
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: androidx.lifecycle.Observer<T>, androidx.lifecycle.Observer<? super com.repackage.am4<java.util.List<com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper>>> */
    public final void u1(final VoiceRoomListAdapter voiceRoomListAdapter, final a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, voiceRoomListAdapter, aVar) == null) {
            LiveData<am4<List<VoiceRoomWrapper>>> b = r1().b();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            b.observe(viewLifecycleOwner, new Observer<T>(voiceRoomListAdapter, aVar, this) { // from class: com.baidu.tieba.frs.voiceroom.VoiceRoomListFragment$subscribeUi$$inlined$observe$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VoiceRoomListAdapter a;
                public final /* synthetic */ VoiceRoomListFragment.a b;
                public final /* synthetic */ VoiceRoomListFragment c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {voiceRoomListAdapter, aVar, this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = voiceRoomListAdapter;
                    this.b = aVar;
                    this.c = this;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(T t) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, t) == null) {
                        am4 am4Var = (am4) t;
                        if (am4Var instanceof am4.c) {
                            this.a.submitList((List) ((am4.c) am4Var).a());
                            this.b.b().setRefreshing(false);
                        } else if (am4Var instanceof am4.a) {
                            this.c.showToast(((am4.a) am4Var).a());
                            this.b.b().setRefreshing(false);
                        } else if (am4Var instanceof am4.b) {
                            this.b.b().setRefreshing(true);
                        }
                    }
                }
            });
        }
    }
}
