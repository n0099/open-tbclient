package com.baidu.tieba.forum.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.dr7;
import com.baidu.tieba.feed.log.FeedStat;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.gu4;
import com.baidu.tieba.kh7;
import com.baidu.tieba.li7;
import com.baidu.tieba.lx6;
import com.baidu.tieba.of1;
import com.baidu.tieba.oj7;
import com.baidu.tieba.pg7;
import com.baidu.tieba.sr7;
import com.baidu.tieba.to5;
import com.baidu.tieba.ug7;
import com.baidu.tieba.vj7;
import com.baidu.tieba.wj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u001a\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0016J\b\u0010\u000b\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\"H\u0016J\u0006\u0010.\u001a\u00020\"J\b\u0010/\u001a\u00020\"H\u0016J\b\u00100\u001a\u00020\"H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/baidu/tieba/forum/controller/MainController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", StateManager.KEY_STATE, "Landroid/os/Bundle;", "forceReCreate", "", "forumModel", "Lcom/baidu/tieba/forum/model/ForumModel;", "isFromScheme", "isTopActivity", "loadingView", "Lcom/baidu/tbadk/loading/LoadingView;", "getLoadingView", "()Lcom/baidu/tbadk/loading/LoadingView;", "loadingView$delegate", "Lkotlin/Lazy;", "mForumName", "", "mHybridRefreshListener", "com/baidu/tieba/forum/controller/MainController$mHybridRefreshListener$1", "Lcom/baidu/tieba/forum/controller/MainController$mHybridRefreshListener$1;", "netRefreshView", "Lcom/baidu/tbadk/loading/NetRefreshView;", "getNetRefreshView", "()Lcom/baidu/tbadk/loading/NetRefreshView;", "netRefreshView$delegate", "attachLoading", "", "attachRefresh", "checkFromScheme", "detachLoading", "detachRefresh", "finish", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", MissionEvent.MESSAGE_DESTROY, "onFrsWebHeightConfirmed", MissionEvent.MESSAGE_PAUSE, "onResume", "startLoad", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MainController extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public vj7 c;
    public ActivityForumBinding d;
    public Bundle e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final Lazy j;
    public final Lazy k;
    public a l;

    /* loaded from: classes6.dex */
    public static final class a implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainController a;

        @Override // com.baidu.tieba.gu4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "frsPage.refreshFrsPage" : (String) invokeV.objValue;
        }

        public a(MainController mainController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainController;
        }

        @Override // com.baidu.tieba.gu4.c
        public void a(String data) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String optString = new JSONObject(data).optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
                if (this.a.f.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && Intrinsics.areEqual(optString, this.a.f)) {
                    if (this.a.h) {
                        this.a.D();
                    } else {
                        this.a.g = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements vj7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainController a;
        public final /* synthetic */ oj7 b;

        public b(MainController mainController, oj7 oj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainController, oj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainController;
            this.b = oj7Var;
        }

        @Override // com.baidu.tieba.vj7.a
        public void a(kh7 data) {
            dr7 dr7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                ViewModel viewModel = new ViewModelProvider(this.a.E()).get(ForumViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
                ForumViewModel forumViewModel = (ForumViewModel) viewModel;
                forumViewModel.c().setValue(data.h());
                forumViewModel.a().setValue(data);
                forumViewModel.e().setValue(data.j());
                ViewModel viewModel2 = new ViewModelProvider(this.a.E()).get(BottomViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(activi…tomViewModel::class.java)");
                ((BottomViewModel) viewModel2).e(data.g());
                this.b.d(data.h().d());
                this.b.e(data.h().e());
                of1<dr7> a = new sr7().a();
                if (a != null && (dr7Var = a.get()) != null) {
                    dr7Var.b(String.valueOf(data.h().d()));
                }
                li7.b.a().b(String.valueOf(data.h().d()), System.currentTimeMillis());
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(data.g().e());
                lx6.o().t(forumData, data.h().f(), data.h().b());
            }
        }

        @Override // com.baidu.tieba.vj7.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.B();
                this.a.z();
            }
        }
    }

    public MainController(FragmentActivity activity) {
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
        this.f = "";
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<LoadingView>(this) { // from class: com.baidu.tieba.forum.controller.MainController$loadingView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MainController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoadingView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    LoadingView loadingView = new LoadingView(this.this$0.E());
                    loadingView.onChangeSkinType();
                    SkinManager.setBackgroundColor(loadingView.getView(), R.color.CAM_X0201);
                    return loadingView;
                }
                return (LoadingView) invokeV.objValue;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new MainController$netRefreshView$2(this));
        this.l = new a(this);
    }

    public final void I(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            y();
            vj7 vj7Var = this.c;
            if (vj7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumModel");
                vj7Var = null;
            }
            vj7Var.b(bundle);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.i(i);
            if (F().isViewAttached()) {
                F().onChangeSkinType(i);
            }
        }
    }

    public final void A() {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = this.b.getIntent();
            String str = null;
            if (intent != null) {
                parcelable = intent.getParcelableExtra(IntentConfig.KEY_URI);
            } else {
                parcelable = null;
            }
            if (parcelable == null) {
                Intent intent2 = this.b.getIntent();
                if (intent2 != null) {
                    str = intent2.getStringExtra(MainTabActivityConfig.PUSH_TID);
                }
                if (str == null) {
                    return;
                }
            }
            if (!BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                this.i = true;
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.g) {
            this.g = false;
            this.b.finish();
            Intent intent = this.b.getIntent();
            if (intent != null) {
                intent.putExtra("key_no_animation", true);
            }
            FragmentActivity fragmentActivity = this.b;
            fragmentActivity.startActivity(fragmentActivity.getIntent());
            this.b.overridePendingTransition(0, 0);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LoadingView F = F();
            ActivityForumBinding activityForumBinding = this.d;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            F.dettachView(activityForumBinding.r);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            wj5 G = G();
            ActivityForumBinding activityForumBinding = this.d;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            G.dettachView(activityForumBinding.r);
        }
    }

    public final FragmentActivity E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final LoadingView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (LoadingView) this.j.getValue();
        }
        return (LoadingView) invokeV.objValue;
    }

    public final wj5 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (wj5) this.k.getValue();
        }
        return (wj5) invokeV.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            B();
            C();
        }
    }

    @Override // com.baidu.tieba.pg7
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.e();
            if (this.i) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.b).createNormalCfg(2)));
            }
        }
    }

    @Override // com.baidu.tieba.pg7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.l();
            vj7 vj7Var = this.c;
            if (vj7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumModel");
                vj7Var = null;
            }
            vj7Var.d();
            gu4.b.a().e(this.l);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.m();
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.pg7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.n();
            this.h = true;
            D();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LoadingView F = F();
            ActivityForumBinding activityForumBinding = this.d;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            F.attachView(activityForumBinding.r);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            this.d = binding;
            if (!FeedStat.a.e()) {
                FeedStat.a.h();
            }
            this.c = new vj7(this.b);
            Bundle extras = this.b.getIntent().getExtras();
            if (extras != null) {
                bundle = extras;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.e = bundle;
            Bundle bundle2 = null;
            if (bundle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(StateManager.KEY_STATE);
                bundle = null;
            }
            String string = bundle.getString("name");
            if (string == null) {
                string = "";
            }
            this.f = string;
            oj7 oj7Var = new oj7(this.b);
            vj7 vj7Var = this.c;
            if (vj7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumModel");
                vj7Var = null;
            }
            vj7Var.g(new b(this, oj7Var));
            Bundle bundle3 = this.e;
            if (bundle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(StateManager.KEY_STATE);
            } else {
                bundle2 = bundle3;
            }
            I(bundle2);
            A();
            gu4.b.a().c(this.l);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            wj5 G = G();
            ActivityForumBinding activityForumBinding = this.d;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            G.attachView(activityForumBinding.r);
            to5.a.a(ug7.a(this.b), new Pair<>(PushMessageHelper.ERROR_TYPE, "new_frs_page"), new Pair<>("error_info", "new frs page net error"));
        }
    }
}
