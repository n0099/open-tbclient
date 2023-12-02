package com.baidu.tieba.forum.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.ar6;
import com.baidu.tieba.bi7;
import com.baidu.tieba.bj7;
import com.baidu.tieba.br6;
import com.baidu.tieba.cp5;
import com.baidu.tieba.er6;
import com.baidu.tieba.forum.controller.ForumButtonController;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.tab.FrsFeedFragment;
import com.baidu.tieba.forum.tab.FrsTabPageAdapter;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.oi7;
import com.baidu.tieba.qdb;
import com.baidu.tieba.ri7;
import com.baidu.tieba.s87;
import com.baidu.tieba.t4b;
import com.baidu.tieba.tua;
import com.baidu.tieba.vdb;
import com.baidu.tieba.wh7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.FrsBottom;
import tbclient.ItemInfo;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0014J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002J\u0006\u0010(\u001a\u00020\u0014J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/tieba/forum/controller/ForumButtonController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "buttonLayout", "Landroid/view/View;", "forumViewModel", "Lcom/baidu/tieba/forum/viewmodel/ForumViewModel;", "mUegForwardCheckController", "Lcom/baidu/tieba/ueg/UegForwardCheckController;", "mWriteBottomSheetController", "Lcom/baidu/tieba/write/WriteBottomSheetController;", "refreshView", "Lcom/baidu/tbadk/widget/FRSRefreshButton;", "writeView", "Lcom/baidu/tbadk/widget/OvalActionButton;", "addWriteClickStat", "", "fid", "", "fname", "getWriteTitle", "handleEditModeEvent", "inEditMode", "", "hideRefreshIcon", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "openWrite", "forumWriteData", "Lcom/baidu/tieba/frs/ForumWriteData;", "showRefreshIcon", "showWriteTab", "showWriteThreadView", "startOpenWrite", "startRefresh", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ForumButtonController extends wh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public OvalActionButton c;
    public FRSRefreshButton d;
    public View e;
    public ForumViewModel f;
    public t4b g;
    public qdb h;

    /* loaded from: classes5.dex */
    public static final class a extends er6<s87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumButtonController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumButtonController forumButtonController, Class<s87> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumButtonController, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumButtonController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(s87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.a(), this.b.s())) {
                    this.b.u(event.c());
                }
            }
        }
    }

    public ForumButtonController(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
    }

    public static final void w(ForumButtonController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.D();
        }
    }

    public static final void x(ForumButtonController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            bi7.g(this$0.b).V();
            this$0.E();
        }
    }

    public final void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            cp5.b(this.b, statisticItem);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("fname", str2);
            statisticItem.addParam("obj_param1", "100465_3");
            TiebaStatic.log(statisticItem);
        }
    }

    public static final void y(ForumButtonController this$0, oi7 oi7Var) {
        String str;
        String str2;
        FrsBottom e;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        FrsBottom e2;
        FrsBottomSmartBgColor frsBottomSmartBgColor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, oi7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            OvalActionButton ovalActionButton = null;
            if (oi7Var != null && (e2 = oi7Var.e()) != null && (frsBottomSmartBgColor2 = e2.frs_smart_bg_color) != null) {
                str = frsBottomSmartBgColor2.post_button_color;
            } else {
                str = null;
            }
            int f = tua.f(str);
            if (oi7Var != null && (e = oi7Var.e()) != null && (frsBottomSmartBgColor = e.frs_smart_bg_color) != null) {
                str2 = frsBottomSmartBgColor.post_button_shadow_color;
            } else {
                str2 = null;
            }
            int f2 = tua.f(str2);
            if (!tua.e(f) && !tua.e(f2)) {
                OvalActionButton ovalActionButton2 = this$0.c;
                if (ovalActionButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("writeView");
                    ovalActionButton2 = null;
                }
                ovalActionButton2.setStartAndEndColor(f, f);
                OvalActionButton ovalActionButton3 = this$0.c;
                if (ovalActionButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("writeView");
                } else {
                    ovalActionButton = ovalActionButton3;
                }
                ovalActionButton.setColor(f2);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FRSRefreshButton fRSRefreshButton = this.d;
            if (fRSRefreshButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshView");
                fRSRefreshButton = null;
            }
            fRSRefreshButton.f();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bi7.m(this.b).M();
        }
    }

    public final FragmentActivity s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FRSRefreshButton fRSRefreshButton = this.d;
            if (fRSRefreshButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshView");
                fRSRefreshButton = null;
            }
            fRSRefreshButton.b();
        }
    }

    public final void B(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumWriteData) == null) {
            ForumViewModel forumViewModel = this.f;
            ItemInfo itemInfo = null;
            if (forumViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
                forumViewModel = null;
            }
            bj7 value = forumViewModel.g().getValue();
            if (value != null) {
                itemInfo = value.c();
            }
            if (this.h == null) {
                this.h = new qdb(this.b, "frs", 2, "2");
            }
            qdb qdbVar = this.h;
            if (qdbVar != null) {
                qdbVar.j(forumWriteData);
                qdbVar.l(t());
                qdbVar.k(itemInfo);
                qdbVar.m();
            }
        }
    }

    public final void z(ForumWriteData forumWriteData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, forumWriteData) == null) {
            String str = forumWriteData.forumId;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            WriteActivityConfig.newInstance(this.b).setType(9).setForumWriteData(forumWriteData).setFrom("frs").setTitle(t()).setCallFrom("2").setStatisticFrom(2).setIsWriteTest(true).setFromArticle(vdb.n).send();
        }
    }

    public final void C() {
        ForumWriteData b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.b, LoginDialogData.FRS_PUBLISH_RESULT_PAGE))) {
            return;
        }
        t4b t4bVar = this.g;
        boolean z = false;
        int i = 1;
        if (t4bVar != null && t4bVar.c()) {
            z = true;
        }
        if (z) {
            return;
        }
        ForumViewModel forumViewModel = this.f;
        if (forumViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
            forumViewModel = null;
        }
        bj7 value = forumViewModel.g().getValue();
        if (value != null && (b = value.b()) != null) {
            ForumTabItem B = bi7.m(this.b).B();
            if (B != null) {
                int tabId = B.getTabId();
                FrsTabInfoData frsTabInfoData = b.frsTabInfo;
                if (frsTabInfoData != null) {
                    frsTabInfoData.selectedTabId = tabId;
                }
            }
            if (UbsABTestHelper.isNewWrite()) {
                z(b);
            } else {
                B(b);
            }
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_WRITE_TEST_ICON_CLICK).param("obj_type", 2);
            if (UbsABTestHelper.isNewWrite()) {
                i = 2;
            }
            TiebaStatic.log(param.param("obj_source", i));
        }
    }

    public final void D() {
        String f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        C();
        ForumViewModel forumViewModel = this.f;
        ForumViewModel forumViewModel2 = null;
        if (forumViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
            forumViewModel = null;
        }
        ri7 value = forumViewModel.c().getValue();
        if (value != null) {
            String valueOf = String.valueOf(value.e());
            ForumViewModel forumViewModel3 = this.f;
            if (forumViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
            } else {
                forumViewModel2 = forumViewModel3;
            }
            ri7 value2 = forumViewModel2.c().getValue();
            if (value2 != null && (f = value2.f()) != null) {
                q(valueOf, f.toString());
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.i(i);
            FRSRefreshButton fRSRefreshButton = this.d;
            if (fRSRefreshButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshView");
                fRSRefreshButton = null;
            }
            fRSRefreshButton.d(i);
        }
    }

    public final void u(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            View view2 = this.e;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
                view2 = null;
            }
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            view2.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.wh7
    public void k(Bundle bundle, final ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            ViewModel viewModel = new ViewModelProvider(this.b).get(ForumViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
            this.f = (ForumViewModel) viewModel;
            OvalActionButton ovalActionButton = binding.k;
            Intrinsics.checkNotNullExpressionValue(ovalActionButton, "binding.frsPostForumButton");
            this.c = ovalActionButton;
            FRSRefreshButton fRSRefreshButton = binding.l;
            Intrinsics.checkNotNullExpressionValue(fRSRefreshButton, "binding.frsRefreshForumButton");
            this.d = fRSRefreshButton;
            FrameLayout frameLayout = binding.j;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frsForumButtonLayout");
            this.e = frameLayout;
            OvalActionButton ovalActionButton2 = this.c;
            FRSRefreshButton fRSRefreshButton2 = null;
            if (ovalActionButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("writeView");
                ovalActionButton2 = null;
            }
            ovalActionButton2.setIsCircle(true);
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity instanceof TbPageContextSupport) {
                this.g = new t4b(((TbPageContextSupport) fragmentActivity).getPageContext());
            }
            this.h = new qdb(this.b, "frs", 2, "2");
            OvalActionButton ovalActionButton3 = this.c;
            if (ovalActionButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("writeView");
                ovalActionButton3 = null;
            }
            ovalActionButton3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ph7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ForumButtonController.w(ForumButtonController.this, view2);
                    }
                }
            });
            FRSRefreshButton fRSRefreshButton3 = this.d;
            if (fRSRefreshButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshView");
            } else {
                fRSRefreshButton2 = fRSRefreshButton3;
            }
            fRSRefreshButton2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ForumButtonController.x(ForumButtonController.this, view2);
                    }
                }
            });
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(s87.class)), new a(this, s87.class));
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.uh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        ForumButtonController.y(ForumButtonController.this, (oi7) obj);
                    }
                }
            });
            binding.u.addOnPageChangeListener(new ViewPager.OnPageChangeListener(binding, this) { // from class: com.baidu.tieba.forum.controller.ForumButtonController$onCreate$5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ActivityForumBinding a;
                public final /* synthetic */ ForumButtonController b;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {binding, this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = binding;
                    this.b = this;
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    FrsTabPageAdapter frsTabPageAdapter;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                        PagerAdapter adapter = this.a.u.getAdapter();
                        Fragment fragment = null;
                        if (adapter instanceof FrsTabPageAdapter) {
                            frsTabPageAdapter = (FrsTabPageAdapter) adapter;
                        } else {
                            frsTabPageAdapter = null;
                        }
                        if (frsTabPageAdapter != null) {
                            fragment = frsTabPageAdapter.getItem(i);
                        }
                        if (fragment instanceof FrsFeedFragment) {
                            this.b.A();
                        } else {
                            this.b.v();
                        }
                    }
                }
            });
        }
    }

    public final String t() {
        InterceptResult invokeV;
        ActivityConfig a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ForumViewModel forumViewModel = this.f;
            String str = null;
            if (forumViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
                forumViewModel = null;
            }
            bj7 value = forumViewModel.g().getValue();
            if (value != null && (a2 = value.a()) != null) {
                str = a2.addthread_text;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
