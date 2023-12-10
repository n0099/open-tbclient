package com.baidu.tieba.forum.controller;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.angcyo.tablayout.DslTabLayout;
import com.angcyo.tablayout.DslTabLayoutConfig;
import com.angcyo.tablayout.ViewPager1Delegate;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.ak7;
import com.baidu.tieba.ar6;
import com.baidu.tieba.br6;
import com.baidu.tieba.ci7;
import com.baidu.tieba.er6;
import com.baidu.tieba.forum.ForumLog;
import com.baidu.tieba.forum.controller.TopController;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.data.ForumTabPic;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.h5.FrsTabWebFragment;
import com.baidu.tieba.forum.h5.NewFrsTabWebFragment;
import com.baidu.tieba.forum.tab.FrsFeedFragment;
import com.baidu.tieba.forum.tab.FrsTabPageAdapter;
import com.baidu.tieba.forum.view.FrsPicTabView;
import com.baidu.tieba.forum.view.FrsTabView;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.io7;
import com.baidu.tieba.kk7;
import com.baidu.tieba.lb7;
import com.baidu.tieba.li7;
import com.baidu.tieba.ll5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mj6;
import com.baidu.tieba.ml5;
import com.baidu.tieba.pi7;
import com.baidu.tieba.r0;
import com.baidu.tieba.s87;
import com.baidu.tieba.si7;
import com.baidu.tieba.sm7;
import com.baidu.tieba.th5;
import com.baidu.tieba.uua;
import com.baidu.tieba.xh7;
import com.baidu.tieba.zn7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.FrsBottom;
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010+\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0,2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020\u0010J\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u0004\u0018\u000103J\u0006\u00104\u001a\u00020\u0010J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0014H\u0002J\u000e\u00108\u001a\u0002062\u0006\u0010\u0011\u001a\u00020\u0012J \u00109\u001a\u0002062\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010=\u001a\u00020\u0014J\u0010\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\u0010H\u0016J\u001a\u0010@\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010;2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u000206H\u0016J\b\u0010E\u001a\u000206H\u0002J\u000e\u0010F\u001a\u0002062\u0006\u0010/\u001a\u00020\u0010J\u0006\u0010G\u001a\u000206R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/baidu/tieba/forum/controller/TopController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "TAG", "", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "adapter", "Lcom/baidu/tieba/forum/tab/FrsTabPageAdapter;", "arrowIcon", "Landroid/widget/ImageView;", "containerLayout", "Landroid/view/View;", "defaultTabIndex", "", "forumData", "Lcom/baidu/tieba/forum/data/ForumData;", "isTabSelected", "", "onPageChangeListener", "com/baidu/tieba/forum/controller/TopController$onPageChangeListener$1", "Lcom/baidu/tieba/forum/controller/TopController$onPageChangeListener$1;", "publishProgressView", "Lcom/baidu/tbadk/core/view/PublishProgressView;", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "tabList", "", "Lcom/baidu/tieba/forum/tab/FrsTabFragmentData;", "tiePlusController", "Lcom/baidu/tbadk/widget/tiejia/TiePlusEventController;", "getTiePlusController", "()Lcom/baidu/tbadk/widget/tiejia/TiePlusEventController;", "topCardViewController", "Lcom/baidu/tieba/forum/controller/TopCardViewController;", "getTopCardViewController", "()Lcom/baidu/tieba/forum/controller/TopCardViewController;", "setTopCardViewController", "(Lcom/baidu/tieba/forum/controller/TopCardViewController;)V", "viewPager", "Lcom/baidu/tbadk/widget/CustomViewPager;", "generateJumpTabIndex", "", "defaultTabId", "generateTabFragmentData", "tabId", "getCurFragment", "Landroidx/fragment/app/Fragment;", "getCurTabInfo", "Lcom/baidu/tieba/forum/data/ForumTabItem;", "getFirstNewOrHotTabId", "handleEditModeEvent", "", "inEditMode", "initData", "initFragmentBundle", StateManager.KEY_STATE, "Landroid/os/Bundle;", "tabItem", "isDefaultTabSelected", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", MissionEvent.MESSAGE_DESTROY, "populateFromPagerAdapter", "setCurrentTab", "startPageRefresh", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TopController extends xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final String c;
    public View d;
    public ImageView e;
    public DslTabLayout f;
    public CustomViewPager g;
    public PublishProgressView h;
    public FrsTabPageAdapter i;
    public List<zn7> j;
    public li7 k;
    public final TiePlusEventController l;
    public si7 m;
    public int n;
    public boolean o;
    public final TopController$onPageChangeListener$1 p;

    /* loaded from: classes6.dex */
    public static final class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopController a;

        public a(TopController topController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topController;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.K();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.K();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends er6<s87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TopController topController, Class<s87> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topController, cls};
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
            this.b = topController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(s87 event) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!Intrinsics.areEqual(event.a(), this.b.z())) {
                    return;
                }
                CustomViewPager customViewPager = this.b.g;
                FrsTabPageAdapter frsTabPageAdapter = null;
                if (customViewPager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    customViewPager = null;
                }
                int currentItem = customViewPager.getCurrentItem();
                FrsTabPageAdapter frsTabPageAdapter2 = this.b.i;
                if (frsTabPageAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    frsTabPageAdapter = frsTabPageAdapter2;
                }
                List<zn7> b = frsTabPageAdapter.b();
                if (b != null && !b.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && currentItem >= 0 && currentItem < r0.z(b)) {
                    Fragment a = b.get(currentItem).a();
                    if (a instanceof FrsFeedFragment) {
                        ((FrsFeedFragment) a).g3(event.c());
                    }
                }
                this.b.E(event.c());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends er6<ak7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TopController topController, Class<ak7> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topController, cls};
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
            this.b = topController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(ak7 event) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!Intrinsics.areEqual(event.a(), this.b.z())) {
                    return;
                }
                CustomViewPager customViewPager = this.b.g;
                FrsTabPageAdapter frsTabPageAdapter = null;
                if (customViewPager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    customViewPager = null;
                }
                int currentItem = customViewPager.getCurrentItem();
                FrsTabPageAdapter frsTabPageAdapter2 = this.b.i;
                if (frsTabPageAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    frsTabPageAdapter = frsTabPageAdapter2;
                }
                List<zn7> b = frsTabPageAdapter.b();
                if (b != null && !b.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && currentItem >= 0 && currentItem < r0.z(b)) {
                    Fragment a = b.get(currentItem).a();
                    if (a instanceof FrsFeedFragment) {
                        ((FrsFeedFragment) a).i3(event);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends er6<th5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TopController topController, Class<th5> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topController, cls};
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
            this.b = topController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(th5 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                String a = event.a();
                si7 si7Var = this.b.m;
                if (si7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumData");
                    si7Var = null;
                }
                if (Intrinsics.areEqual(a, Long.valueOf(si7Var.f()).toString())) {
                    this.b.M();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.baidu.tieba.forum.controller.TopController$onPageChangeListener$1] */
    public TopController(FragmentActivity activity) {
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
        this.c = "TopController";
        this.j = new ArrayList();
        this.k = new li7(this.b);
        this.l = new TiePlusEventController(this.b, TiePlusStat.Locate.FRS);
        this.p = new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.tieba.forum.controller.TopController$onPageChangeListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TopController a;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                List list;
                ForumTabItem b2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) != null) {
                    return;
                }
                this.a.o = true;
                list = this.a.j;
                zn7 zn7Var = (zn7) ListUtils.getItem(list, i3);
                if (zn7Var == null || (b2 = zn7Var.b()) == null) {
                    return;
                }
                si7 si7Var = this.a.m;
                if (si7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumData");
                    si7Var = null;
                }
                sm7.a(b2, si7Var.f(), 2);
            }
        };
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            CustomViewPager customViewPager = this.g;
            CustomViewPager customViewPager2 = null;
            if (customViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager = null;
            }
            int currentItem = customViewPager.getCurrentItem();
            int i2 = 0;
            for (Object obj : this.j) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (((zn7) obj).b().getTabId() == i) {
                    currentItem = i2;
                }
                i2 = i3;
            }
            CustomViewPager customViewPager3 = this.g;
            if (customViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager3 = null;
            }
            if (customViewPager3.getCurrentItem() != currentItem) {
                CustomViewPager customViewPager4 = this.g;
                if (customViewPager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    customViewPager2 = customViewPager4;
                }
                customViewPager2.setCurrentItem(currentItem);
            }
        }
    }

    public static final void G(si7 forumData, TopController this$0) {
        ForumTabItem b2;
        Fragment frsTabWebFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, forumData, this$0) == null) {
            Intrinsics.checkNotNullParameter(forumData, "$forumData");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Iterator<ForumTabItem> it = forumData.o().iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                ForumTabItem next = it.next();
                Bundle bundle = new Bundle();
                bundle.putString("frs_fid", String.valueOf(forumData.f()));
                bundle.putString("frs_first_class", forumData.d());
                bundle.putString("frs_second_class", forumData.m());
                this$0.H(bundle, next, this$0.b);
                String j = forumData.j();
                if (j == null) {
                    j = "";
                }
                bundle.putString("forum_common_info", j);
                int netType = next.getNetType();
                if (netType != 1 && netType != 2 && netType != 3) {
                    if (netType != 4) {
                        if (netType != 5) {
                            io7.a("Unknown netType!!!");
                        } else {
                            ml5 a2 = ll5.a();
                            if (a2 != null) {
                                List<zn7> list = this$0.j;
                                Fragment a3 = a2.a(String.valueOf(forumData.f()), forumData.g());
                                Intrinsics.checkNotNullExpressionValue(a3, "liveTabService.createFra…                        )");
                                list.add(new zn7(next, a3));
                            }
                        }
                    } else {
                        bundle.putString("forum_id", String.valueOf(forumData.f()));
                        bundle.putString("name", forumData.g());
                        if (mj6.e(next.getTabUrl())) {
                            frsTabWebFragment = new NewFrsTabWebFragment();
                            frsTabWebFragment.setArguments(bundle);
                        } else {
                            frsTabWebFragment = new FrsTabWebFragment();
                            frsTabWebFragment.setArguments(bundle);
                        }
                        this$0.j.add(new zn7(next, frsTabWebFragment));
                    }
                } else {
                    bundle.putLong("forum_id", forumData.f());
                    List<zn7> list2 = this$0.j;
                    FrsFeedFragment frsFeedFragment = new FrsFeedFragment();
                    if (next.getTabId() != forumData.b()) {
                        z = false;
                    }
                    bundle.putBoolean("forum_tab_current_list", z);
                    frsFeedFragment.setArguments(bundle);
                    Unit unit = Unit.INSTANCE;
                    list2.add(new zn7(next, frsFeedFragment));
                }
            }
            int x = this$0.x(this$0.j, forumData.b());
            this$0.n = x;
            CustomViewPager customViewPager = this$0.g;
            CustomViewPager customViewPager2 = null;
            if (customViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager = null;
            }
            FrsTabPageAdapter frsTabPageAdapter = this$0.i;
            if (frsTabPageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter = null;
            }
            customViewPager.setAdapter(frsTabPageAdapter);
            FrsTabPageAdapter frsTabPageAdapter2 = this$0.i;
            if (frsTabPageAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter2 = null;
            }
            frsTabPageAdapter2.c(this$0.j);
            FrsTabPageAdapter frsTabPageAdapter3 = this$0.i;
            if (frsTabPageAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter3 = null;
            }
            frsTabPageAdapter3.notifyDataSetChanged();
            CustomViewPager customViewPager3 = this$0.g;
            if (customViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager3 = null;
            }
            customViewPager3.setOffscreenPageLimit(this$0.j.size());
            CustomViewPager customViewPager4 = this$0.g;
            if (customViewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                customViewPager2 = customViewPager4;
            }
            customViewPager2.setCurrentItem(x);
            zn7 zn7Var = (zn7) ListUtils.getItem(this$0.j, x);
            if (zn7Var != null && (b2 = zn7Var.b()) != null) {
                sm7.a(b2, forumData.f(), 1);
            }
            kk7.d(this$0.b);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            LinearLayout linearLayout = binding.h;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
            this.d = linearLayout;
            ImageView imageView = binding.g;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.contentArrowIcon");
            this.e = imageView;
            DslTabLayout dslTabLayout = binding.s;
            Intrinsics.checkNotNullExpressionValue(dslTabLayout, "binding.tabLayout");
            this.f = dslTabLayout;
            CustomViewPager customViewPager = binding.u;
            Intrinsics.checkNotNullExpressionValue(customViewPager, "binding.viewPager");
            this.g = customViewPager;
            PublishProgressView publishProgressView = binding.i;
            Intrinsics.checkNotNullExpressionValue(publishProgressView, "binding.forumPublishProgressView");
            this.h = publishProgressView;
            FragmentManager supportFragmentManager = this.b.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            this.i = new FrsTabPageAdapter(supportFragmentManager);
            CustomViewPager customViewPager2 = this.g;
            ImageView imageView2 = null;
            if (customViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager2 = null;
            }
            customViewPager2.addOnPageChangeListener(this.p);
            this.b.getLifecycle().addObserver(this.l);
            final DslTabLayout dslTabLayout2 = this.f;
            if (dslTabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                dslTabLayout2 = null;
            }
            ViewPager1Delegate.a aVar = ViewPager1Delegate.d;
            CustomViewPager customViewPager3 = this.g;
            if (customViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager3 = null;
            }
            ViewPager1Delegate.a.b(aVar, customViewPager3, dslTabLayout2, null, 4, null);
            dslTabLayout2.setDrawIndicator(false);
            dslTabLayout2.g(new Function1<DslTabLayoutConfig, Unit>(dslTabLayout2, this) { // from class: com.baidu.tieba.forum.controller.TopController$onCreate$1$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DslTabLayout $this_apply;
                public final /* synthetic */ TopController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dslTabLayout2, this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$this_apply = dslTabLayout2;
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DslTabLayoutConfig dslTabLayoutConfig) {
                    invoke2(dslTabLayoutConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DslTabLayoutConfig configTabLayoutConfig) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configTabLayoutConfig) == null) {
                        Intrinsics.checkNotNullParameter(configTabLayoutConfig, "$this$configTabLayoutConfig");
                        configTabLayoutConfig.h(new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>(this.$this_apply, this.this$0) { // from class: com.baidu.tieba.forum.controller.TopController$onCreate$1$1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ DslTabLayout $this_apply;
                            public final /* synthetic */ TopController this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {r7, r8};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.$this_apply = r7;
                                this.this$0 = r8;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
                                invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i, List<Integer> selectList, boolean z, boolean z2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), selectList, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                                    Intrinsics.checkNotNullParameter(selectList, "selectList");
                                    CustomViewPager customViewPager4 = null;
                                    if (i < 0) {
                                        DslTabLayout dslTabLayout3 = this.$this_apply;
                                        CustomViewPager customViewPager5 = this.this$0.g;
                                        if (customViewPager5 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                        } else {
                                            customViewPager4 = customViewPager5;
                                        }
                                        DslTabLayout.setCurrentItem$default(dslTabLayout3, customViewPager4.getCurrentItem(), false, false, 6, null);
                                    } else if (!z2 || ci7.g(this.this$0.z()).M()) {
                                        CustomViewPager customViewPager6 = this.this$0.g;
                                        if (customViewPager6 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                        } else {
                                            customViewPager4 = customViewPager6;
                                        }
                                        customViewPager4.setCurrentItem(selectList.get(0).intValue());
                                    } else {
                                        CustomViewPager customViewPager7 = this.this$0.g;
                                        if (customViewPager7 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                        } else {
                                            customViewPager4 = customViewPager7;
                                        }
                                        customViewPager4.setCurrentItem(selectList.get(0).intValue(), false);
                                    }
                                    if (z2) {
                                        if (ci7.g(this.this$0.z()).V()) {
                                            ci7.h(this.this$0.z()).u();
                                        }
                                        if (z) {
                                            this.this$0.M();
                                            return;
                                        }
                                        return;
                                    }
                                    kk7.c(this.this$0.z(), selectList.get(0).intValue());
                                }
                            }
                        });
                        configTabLayoutConfig.k(AnonymousClass2.INSTANCE);
                        configTabLayoutConfig.i(new Function4<View, Integer, Boolean, Boolean, Boolean>(this.this$0) { // from class: com.baidu.tieba.forum.controller.TopController$onCreate$1$1.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ TopController this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {r7};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = r7;
                            }

                            public final Boolean invoke(View view2, int i, boolean z, boolean z2) {
                                InterceptResult invokeCommon;
                                boolean z3;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeCommon = interceptable3.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                                    Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                                    Boolean value = ((ForumViewModel) new ViewModelProvider(this.this$0.z()).get(ForumViewModel.class)).h().getValue();
                                    if (value == null) {
                                        value = Boolean.FALSE;
                                    }
                                    if (value.booleanValue()) {
                                        BdUtilHelper.showToast(this.this$0.z(), (int) R.string.obfuscated_res_0x7f0f0452);
                                        z3 = true;
                                    } else {
                                        if (z && z2) {
                                            kk7.c(this.this$0.z(), i);
                                        }
                                        z3 = false;
                                    }
                                    return Boolean.valueOf(z3);
                                }
                                return (Boolean) invokeCommon.objValue;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Boolean invoke(View view2, Integer num, Boolean bool, Boolean bool2) {
                                return invoke(view2, num.intValue(), bool.booleanValue(), bool2.booleanValue());
                            }
                        });
                    }
                }
            });
            DslTabLayout dslTabLayout3 = this.f;
            if (dslTabLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                dslTabLayout3 = null;
            }
            int dimens = BdUtilHelper.getDimens(dslTabLayout3.getContext(), R.dimen.tbds3);
            DslTabLayout dslTabLayout4 = this.f;
            if (dslTabLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                dslTabLayout4 = null;
            }
            dslTabLayout2.setPadding(dimens, 0, BdUtilHelper.getDimens(dslTabLayout4.getContext(), R.dimen.tbds3), 0);
            dslTabLayout2.setClipToPadding(false);
            dslTabLayout2.setClipChildren(false);
            FrsTabPageAdapter frsTabPageAdapter = this.i;
            if (frsTabPageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter = null;
            }
            frsTabPageAdapter.registerDataSetObserver(new a(this));
            View view2 = this.d;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerLayout");
                view2 = null;
            }
            EMManager.from(view2).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0202);
            ImageView imageView3 = this.e;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b66, SkinManager.getColor(R.color.CAM_X0624), WebPManager.ResourceStateType.NORMAL));
            ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().observe(this.b, new Observer() { // from class: com.baidu.tieba.sg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        TopController.J(TopController.this, (si7) obj);
                    }
                }
            });
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(s87.class)), new b(this, s87.class));
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(ak7.class)), new c(this, ak7.class));
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(th5.class)), new d(this, th5.class));
        }
    }

    public final int x(List<zn7> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, list, i)) == null) {
            int intExtra = this.b.getIntent().getIntExtra(FrsActivityConfig.KEY_JUMP_TAB_ID, 1);
            Iterator<T> it = list.iterator();
            int i2 = 0;
            while (true) {
                si7 si7Var = null;
                if (it.hasNext()) {
                    Object next = it.next();
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (((zn7) next).b().getTabId() == intExtra) {
                        TbLog b2 = ForumLog.b.b();
                        String str = this.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("forum ");
                        si7 si7Var2 = this.m;
                        if (si7Var2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("forumData");
                        } else {
                            si7Var = si7Var2;
                        }
                        sb.append(si7Var.g());
                        sb.append(" found target jump tab : ");
                        sb.append(intExtra);
                        b2.i(str, sb.toString());
                        return i2;
                    }
                    i2 = i3;
                } else {
                    int i4 = 0;
                    for (Object obj : list) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        if (((zn7) obj).b().getTabId() == i) {
                            TbLog b3 = ForumLog.b.b();
                            String str2 = this.c;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("forum ");
                            si7 si7Var3 = this.m;
                            if (si7Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("forumData");
                            } else {
                                si7Var = si7Var3;
                            }
                            sb2.append(si7Var.g());
                            sb2.append(" found server default tab : ");
                            sb2.append(i);
                            b3.i(str2, sb2.toString());
                            return i4;
                        }
                        i4 = i5;
                    }
                    int i6 = 0;
                    for (Object obj2 : list) {
                        int i7 = i6 + 1;
                        if (i6 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        if (((zn7) obj2).b().getTabId() == 503) {
                            TbLog b4 = ForumLog.b.b();
                            String str3 = this.c;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("forum ");
                            si7 si7Var4 = this.m;
                            if (si7Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("forumData");
                            } else {
                                si7Var = si7Var4;
                            }
                            sb3.append(si7Var.g());
                            sb3.append(" return reveal new area tab: ");
                            sb3.append(i6);
                            b4.i(str3, sb3.toString());
                            return i6;
                        }
                        i6 = i7;
                    }
                    TbLog b5 = ForumLog.b.b();
                    String str4 = this.c;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("forum ");
                    si7 si7Var5 = this.m;
                    if (si7Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forumData");
                    } else {
                        si7Var = si7Var5;
                    }
                    sb4.append(si7Var.g());
                    sb4.append(" return first tab");
                    b5.i(str4, sb4.toString());
                    return 0;
                }
            }
        } else {
            return invokeLI.intValue;
        }
    }

    public static final void J(TopController this$0, si7 forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, forumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(forumData, "forumData");
            this$0.F(forumData);
        }
    }

    public final void F(final si7 forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, forumData) == null) {
            Intrinsics.checkNotNullParameter(forumData, "forumData");
            this.m = forumData;
            CustomViewPager customViewPager = this.g;
            if (customViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager = null;
            }
            customViewPager.post(new Runnable() { // from class: com.baidu.tieba.nh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TopController.G(si7.this, this);
                    }
                }
            });
        }
    }

    public final Fragment A() {
        InterceptResult invokeV;
        zn7 zn7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CustomViewPager customViewPager = this.g;
            if (customViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager = null;
            }
            int currentItem = customViewPager.getCurrentItem();
            FrsTabPageAdapter frsTabPageAdapter = this.i;
            if (frsTabPageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter = null;
            }
            List<zn7> b2 = frsTabPageAdapter.b();
            if (b2 == null || (zn7Var = b2.get(currentItem)) == null) {
                return null;
            }
            return zn7Var.a();
        }
        return (Fragment) invokeV.objValue;
    }

    public final void M() {
        zn7 zn7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CustomViewPager customViewPager = this.g;
            Fragment fragment = null;
            if (customViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager = null;
            }
            int currentItem = customViewPager.getCurrentItem();
            FrsTabPageAdapter frsTabPageAdapter = this.i;
            if (frsTabPageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter = null;
            }
            List<zn7> b2 = frsTabPageAdapter.b();
            if (b2 != null && (zn7Var = b2.get(currentItem)) != null) {
                fragment = zn7Var.a();
            }
            if (fragment instanceof FrsFeedFragment) {
                ((FrsFeedFragment) fragment).o3();
            }
        }
    }

    public final ForumTabItem B() {
        InterceptResult invokeV;
        List<ForumTabItem> o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomViewPager customViewPager = this.g;
            if (customViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager = null;
            }
            int currentItem = customViewPager.getCurrentItem();
            si7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
            if (value == null || (o = value.o()) == null || o.size() <= currentItem || currentItem < 0) {
                return null;
            }
            return o.get(currentItem);
        }
        return (ForumTabItem) invokeV.objValue;
    }

    public final int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = 0;
            for (Object obj : this.j) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                zn7 zn7Var = (zn7) obj;
                if (zn7Var.b().getTabId() != 1 && zn7Var.b().getTabId() != 503) {
                    i = i2;
                } else {
                    return zn7Var.b().getTabId();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final li7 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (li7) invokeV.objValue;
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.n;
            if (i != 0 && (i == 0 || !this.o)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.l();
            this.k.l();
            this.b.getLifecycle().removeObserver(this.l);
        }
    }

    public final FragmentActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).h().setValue(Boolean.valueOf(z));
            CustomViewPager customViewPager = this.g;
            if (customViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                customViewPager = null;
            }
            customViewPager.setScrollable(!z);
        }
    }

    public final zn7 y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            int i2 = 0;
            for (Object obj : this.j) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                zn7 zn7Var = (zn7) obj;
                if (zn7Var.b().getTabId() == i) {
                    return zn7Var;
                }
                i2 = i3;
            }
            return null;
        }
        return (zn7) invokeI.objValue;
    }

    public final void H(Bundle bundle, ForumTabItem forumTabItem, FragmentActivity fragmentActivity) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, bundle, forumTabItem, fragmentActivity) == null) {
            bundle.putInt("forum_tab_id", forumTabItem.getTabId());
            bundle.putInt("forum_tab_type", forumTabItem.getTabType());
            bundle.putString("forum_tab_name", forumTabItem.getTabName());
            bundle.putString("forum_tab_url", forumTabItem.getTabUrl());
            if (forumTabItem.getTabType() == 100 && UbsABTestHelper.isNewFrsStaggeredVideoTab()) {
                i = 1;
            } else {
                i = 0;
            }
            bundle.putInt("forum_staggered_tab", i);
            bundle.putParcelable("forum_tab_info", forumTabItem);
            Bundle extras = fragmentActivity.getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            bundle.putString("name", extras.getString("name"));
            bundle.putParcelable(IntentConfig.KEY_URI, extras.getParcelable(IntentConfig.KEY_URI));
            bundle.putInt(FrsActivityConfig.FRS_CALL_FROM, extras.getInt(FrsActivityConfig.FRS_CALL_FROM));
            bundle.putLong(FrsActivityConfig.FRS_HOT_THREAD_ID, extras.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID));
            bundle.putString("yuelaou_locate", extras.getString("yuelaou_locate"));
            bundle.putString("from", extras.getString("from"));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0120 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: com.baidu.tieba.forum.view.FrsPicTabView */
    /* JADX WARN: Multi-variable type inference failed */
    public final void K() {
        String str;
        FrsTabView frsTabView;
        FrsBottom e;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            pi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            if (value != null && (e = value.e()) != null && (frsBottomSmartBgColor = e.frs_smart_bg_color) != null) {
                str = frsBottomSmartBgColor.tab_line_color;
            } else {
                str = null;
            }
            int f = uua.f(str);
            DslTabLayout dslTabLayout = this.f;
            if (dslTabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                dslTabLayout = null;
            }
            dslTabLayout.removeAllViews();
            FrsTabPageAdapter frsTabPageAdapter = this.i;
            if (frsTabPageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter = null;
            }
            List<zn7> b2 = frsTabPageAdapter.b();
            if (b2 != null) {
                for (zn7 zn7Var : b2) {
                    if (zn7Var.b().hasTabPic()) {
                        DslTabLayout dslTabLayout2 = this.f;
                        if (dslTabLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                            dslTabLayout2 = null;
                        }
                        Context context = dslTabLayout2.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "tabLayout.context");
                        FrsPicTabView frsPicTabView = new FrsPicTabView(context, null, 0, 6, null);
                        if (zn7Var.b().getTabType() == 102) {
                            si7 si7Var = this.m;
                            if (si7Var == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("forumData");
                                si7Var = null;
                            }
                            frsPicTabView.setIntelligentColorInfo(si7Var.q());
                        }
                        ForumTabPic tabNormalPic = zn7Var.b().getTabNormalPic();
                        Intrinsics.checkNotNull(tabNormalPic);
                        ForumTabPic tabDarkPic = zn7Var.b().getTabDarkPic();
                        Intrinsics.checkNotNull(tabDarkPic);
                        frsPicTabView.g(tabNormalPic, tabDarkPic);
                        if (!uua.e(f)) {
                            frsPicTabView.setIndicatorColor(f);
                            frsTabView = frsPicTabView;
                        } else {
                            frsPicTabView.setIndicatorColorRes(R.color.CAM_X0302);
                            frsTabView = frsPicTabView;
                        }
                    } else {
                        DslTabLayout dslTabLayout3 = this.f;
                        if (dslTabLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                            dslTabLayout3 = null;
                        }
                        Context context2 = dslTabLayout3.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "tabLayout.context");
                        FrsTabView frsTabView2 = new FrsTabView(context2, null, 0, 6, null);
                        frsTabView2.setText(zn7Var.b().getTabName());
                        if (!uua.e(f)) {
                            frsTabView2.setIndicatorColor(f);
                            frsTabView = frsTabView2;
                        } else {
                            frsTabView2.setIndicatorColorRes(R.color.CAM_X0302);
                            frsTabView = frsTabView2;
                        }
                    }
                    DslTabLayout dslTabLayout4 = this.f;
                    if (dslTabLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                        dslTabLayout4 = null;
                    }
                    frsTabView.setLayoutParams(new DslTabLayout.LayoutParams(-2, BdUtilHelper.getDimens(dslTabLayout4.getContext(), R.dimen.tbds104)));
                    DslTabLayout dslTabLayout5 = this.f;
                    if (dslTabLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                        dslTabLayout5 = null;
                    }
                    dslTabLayout5.addView(frsTabView);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.i(i);
            FrsTabPageAdapter frsTabPageAdapter = this.i;
            ImageView imageView = null;
            if (frsTabPageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                frsTabPageAdapter = null;
            }
            List<zn7> b2 = frsTabPageAdapter.b();
            if (b2 != null) {
                for (zn7 zn7Var : b2) {
                    if (zn7Var.a() instanceof lb7) {
                        ((lb7) zn7Var.a()).f();
                    }
                }
            }
            DslTabLayout dslTabLayout = this.f;
            if (dslTabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                dslTabLayout = null;
            }
            dslTabLayout.C();
            PublishProgressView publishProgressView = this.h;
            if (publishProgressView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishProgressView");
                publishProgressView = null;
            }
            publishProgressView.b();
            View view2 = this.d;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerLayout");
                view2 = null;
            }
            EMManager.from(view2).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0202);
            ImageView imageView2 = this.e;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b66, SkinManager.getColor(R.color.CAM_X0624), WebPManager.ResourceStateType.NORMAL));
        }
    }
}
