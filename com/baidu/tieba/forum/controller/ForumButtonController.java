package com.baidu.tieba.forum.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
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
import com.baidu.tieba.a9b;
import com.baidu.tieba.b87;
import com.baidu.tieba.bqa;
import com.baidu.tieba.ei7;
import com.baidu.tieba.fh7;
import com.baidu.tieba.forum.controller.ForumButtonController;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.hh7;
import com.baidu.tieba.mq6;
import com.baidu.tieba.nq6;
import com.baidu.tieba.pg7;
import com.baidu.tieba.ph7;
import com.baidu.tieba.qo5;
import com.baidu.tieba.qq6;
import com.baidu.tieba.ug7;
import com.baidu.tieba.v8b;
import com.baidu.tieba.zza;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0006\u0010\u001e\u001a\u00020\u0014J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020\u0014J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\u0014H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/baidu/tieba/forum/controller/ForumButtonController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "buttonLayout", "Landroid/view/View;", "forumViewModel", "Lcom/baidu/tieba/forum/viewmodel/ForumViewModel;", "mUegForwardCheckController", "Lcom/baidu/tieba/ueg/UegForwardCheckController;", "mWriteBottomSheetController", "Lcom/baidu/tieba/write/WriteBottomSheetController;", "refreshView", "Lcom/baidu/tbadk/widget/FRSRefreshButton;", "writeView", "Lcom/baidu/tbadk/widget/OvalActionButton;", "addWriteClickStat", "", "fid", "", "fname", "getWriteTitle", "handleEditModeEvent", "inEditMode", "", "handleRefreshBtnVisibleEvent", "showIcon", "hideRefreshIcon", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "openWrite", "forumWriteData", "Lcom/baidu/tieba/frs/ForumWriteData;", "showRefreshIcon", "showWriteTab", "showWriteThreadView", "startOpenWrite", "startRefresh", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumButtonController extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public OvalActionButton c;
    public FRSRefreshButton d;
    public View e;
    public ForumViewModel f;
    public zza g;
    public v8b h;

    /* loaded from: classes6.dex */
    public static final class a extends qq6<b87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumButtonController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumButtonController forumButtonController, Class<b87> cls) {
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
        @Override // com.baidu.tieba.qq6
        public void onEvent(b87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.a(), this.b.s())) {
                    this.b.u(event.c());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends qq6<ei7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumButtonController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumButtonController forumButtonController, Class<ei7> cls) {
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
        @Override // com.baidu.tieba.qq6
        public void onEvent(ei7 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.a(), this.b.s())) {
                    this.b.v(event.b());
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

    public static final void x(ForumButtonController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.E();
        }
    }

    public static final void y(ForumButtonController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.F();
        }
    }

    public final void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            qo5.b(this.b, statisticItem);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("fname", str2);
            statisticItem.addParam("obj_param1", "100465_3");
            TiebaStatic.log(statisticItem);
        }
    }

    public static final void z(ForumButtonController this$0, fh7 fh7Var) {
        String str;
        String str2;
        FrsBottom f;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        FrsBottom f2;
        FrsBottomSmartBgColor frsBottomSmartBgColor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, fh7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            OvalActionButton ovalActionButton = null;
            if (fh7Var != null && (f2 = fh7Var.f()) != null && (frsBottomSmartBgColor2 = f2.frs_smart_bg_color) != null) {
                str = frsBottomSmartBgColor2.post_button_color;
            } else {
                str = null;
            }
            int f3 = bqa.f(str);
            if (fh7Var != null && (f = fh7Var.f()) != null && (frsBottomSmartBgColor = f.frs_smart_bg_color) != null) {
                str2 = frsBottomSmartBgColor.post_button_shadow_color;
            } else {
                str2 = null;
            }
            int f4 = bqa.f(str2);
            if (!bqa.e(f3) && !bqa.e(f4)) {
                OvalActionButton ovalActionButton2 = this$0.c;
                if (ovalActionButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("writeView");
                    ovalActionButton2 = null;
                }
                ovalActionButton2.setStartAndEndColor(f3, f3);
                OvalActionButton ovalActionButton3 = this$0.c;
                if (ovalActionButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("writeView");
                } else {
                    ovalActionButton = ovalActionButton3;
                }
                ovalActionButton.setColor(f4);
            }
        }
    }

    public final void A(ForumWriteData forumWriteData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumWriteData) == null) {
            String str = forumWriteData.forumId;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            WriteActivityConfig.newInstance(this.b).setType(9).setForumWriteData(forumWriteData).setFrom("frs").setTitle(t()).setCallFrom("2").setStatisticFrom(2).setIsWriteTest(true).setFromArticle(a9b.n).send();
        }
    }

    public final void C(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumWriteData) == null) {
            ForumViewModel forumViewModel = this.f;
            ItemInfo itemInfo = null;
            if (forumViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
                forumViewModel = null;
            }
            ph7 value = forumViewModel.e().getValue();
            if (value != null) {
                itemInfo = value.c();
            }
            if (this.h == null) {
                this.h = new v8b(this.b, "frs", 2, "2");
            }
            v8b v8bVar = this.h;
            if (v8bVar != null) {
                v8bVar.j(forumWriteData);
                v8bVar.l(t());
                v8bVar.k(itemInfo);
                v8bVar.m();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FRSRefreshButton fRSRefreshButton = this.d;
            if (fRSRefreshButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshView");
                fRSRefreshButton = null;
            }
            fRSRefreshButton.f();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ug7.k(this.b).L();
        }
    }

    public final FragmentActivity s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            FRSRefreshButton fRSRefreshButton = this.d;
            if (fRSRefreshButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshView");
                fRSRefreshButton = null;
            }
            fRSRefreshButton.b();
        }
    }

    public final void D() {
        ForumWriteData b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.b, LoginDialogData.FRS_PUBLISH_RESULT_PAGE))) {
            return;
        }
        zza zzaVar = this.g;
        boolean z = false;
        int i = 1;
        if (zzaVar != null && zzaVar.c()) {
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
        ph7 value = forumViewModel.e().getValue();
        if (value != null && (b2 = value.b()) != null) {
            ForumTabItem A = ug7.k(this.b).A();
            if (A != null) {
                int tabId = A.getTabId();
                FrsTabInfoData frsTabInfoData = b2.frsTabInfo;
                if (frsTabInfoData != null) {
                    frsTabInfoData.selectedTabId = tabId;
                }
            }
            if (UbsABTestHelper.isNewWrite()) {
                A(b2);
            } else {
                C(b2);
            }
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_WRITE_TEST_ICON_CLICK).param("obj_type", 2);
            if (UbsABTestHelper.isNewWrite()) {
                i = 2;
            }
            TiebaStatic.log(param.param("obj_source", i));
        }
    }

    public final void E() {
        String e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        D();
        ForumViewModel forumViewModel = this.f;
        ForumViewModel forumViewModel2 = null;
        if (forumViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
            forumViewModel = null;
        }
        hh7 value = forumViewModel.c().getValue();
        if (value != null) {
            String valueOf = String.valueOf(value.d());
            ForumViewModel forumViewModel3 = this.f;
            if (forumViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
            } else {
                forumViewModel2 = forumViewModel3;
            }
            hh7 value2 = forumViewModel2.c().getValue();
            if (value2 != null && (e = value2.e()) != null) {
                r(valueOf, e.toString());
            }
        }
    }

    @Override // com.baidu.tieba.pg7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
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

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                B();
            } else {
                w();
            }
        }
    }

    @Override // com.baidu.tieba.pg7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bundle, binding) == null) {
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
                this.g = new zza(((TbPageContextSupport) fragmentActivity).getPageContext());
            }
            this.h = new v8b(this.b, "frs", 2, "2");
            OvalActionButton ovalActionButton3 = this.c;
            if (ovalActionButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("writeView");
                ovalActionButton3 = null;
            }
            ovalActionButton3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.fg7
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
            FRSRefreshButton fRSRefreshButton3 = this.d;
            if (fRSRefreshButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshView");
            } else {
                fRSRefreshButton2 = fRSRefreshButton3;
            }
            fRSRefreshButton2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ForumButtonController.y(ForumButtonController.this, view2);
                    }
                }
            });
            nq6.b().b(new mq6(f(), Reflection.getOrCreateKotlinClass(b87.class)), new a(this, b87.class));
            nq6.b().b(new mq6(f(), Reflection.getOrCreateKotlinClass(ei7.class)), new b(this, ei7.class));
            binding.w.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.tieba.forum.controller.ForumButtonController$onCreate$5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ForumButtonController a;

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
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                        this.a.w();
                    }
                }
            });
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.ng7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        ForumButtonController.z(ForumButtonController.this, (fh7) obj);
                    }
                }
            });
        }
    }

    public final String t() {
        InterceptResult invokeV;
        ActivityConfig a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ForumViewModel forumViewModel = this.f;
            String str = null;
            if (forumViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumViewModel");
                forumViewModel = null;
            }
            ph7 value = forumViewModel.e().getValue();
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
