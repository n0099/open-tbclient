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
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.bk7;
import com.baidu.tieba.br6;
import com.baidu.tieba.ci7;
import com.baidu.tieba.feed.log.FeedStat;
import com.baidu.tieba.fk5;
import com.baidu.tieba.forum.ForumLog;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.fp5;
import com.baidu.tieba.hk7;
import com.baidu.tieba.iu7;
import com.baidu.tieba.ll7;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lu4;
import com.baidu.tieba.pi7;
import com.baidu.tieba.sf1;
import com.baidu.tieba.si7;
import com.baidu.tieba.sl7;
import com.baidu.tieba.ut7;
import com.baidu.tieba.vi7;
import com.baidu.tieba.xh7;
import com.baidu.tieba.xoa;
import com.baidu.tieba.y05;
import com.baidu.tieba.zx6;
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
import tbclient.FrsPage.ForumInfo;
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t*\u0001\u001b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0016J\b\u0010\r\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0016J\u001a\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020#H\u0016J\u0006\u0010/\u001a\u00020#J\b\u00100\u001a\u00020#H\u0016J\b\u00101\u001a\u00020#H\u0016J\u0010\u00102\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u00103\u001a\u00020#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 ¨\u00064"}, d2 = {"Lcom/baidu/tieba/forum/controller/MainController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "TAG", "", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", StateManager.KEY_STATE, "Landroid/os/Bundle;", "forceReCreate", "", "forumModel", "Lcom/baidu/tieba/forum/model/ForumModel;", "isFromScheme", "isTopActivity", "loadingView", "Lcom/baidu/tbadk/loading/LoadingView;", "getLoadingView", "()Lcom/baidu/tbadk/loading/LoadingView;", "loadingView$delegate", "Lkotlin/Lazy;", "mForumName", "mHybridRefreshListener", "com/baidu/tieba/forum/controller/MainController$mHybridRefreshListener$1", "Lcom/baidu/tieba/forum/controller/MainController$mHybridRefreshListener$1;", "netRefreshView", "Lcom/baidu/tbadk/loading/NetRefreshView;", "getNetRefreshView", "()Lcom/baidu/tbadk/loading/NetRefreshView;", "netRefreshView$delegate", "attachLoading", "", "attachRefresh", "checkFromScheme", "detachLoading", "detachRefresh", "finish", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", MissionEvent.MESSAGE_DESTROY, "onFrsWebHeightConfirmed", MissionEvent.MESSAGE_PAUSE, "onResume", "startLoad", "updateForumVisitTime", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MainController extends xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final String c;
    public sl7 d;
    public ActivityForumBinding e;
    public Bundle f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final Lazy k;
    public final Lazy l;
    public a m;

    /* loaded from: classes6.dex */
    public static final class a implements lu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainController a;

        @Override // com.baidu.tieba.lu4.d
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

        @Override // com.baidu.tieba.lu4.c
        public void a(String data) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String optString = new JSONObject(data).optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
                if (this.a.g.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && Intrinsics.areEqual(optString, this.a.g)) {
                    if (this.a.i) {
                        this.a.F();
                    } else {
                        this.a.h = true;
                    }
                    TbLog b = ForumLog.b.b();
                    String str = this.a.c;
                    b.i(str, "forum " + this.a.g + " force recreate from hybrid notify");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements sl7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainController a;
        public final /* synthetic */ ll7 b;

        public b(MainController mainController, ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainController, ll7Var};
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
            this.b = ll7Var;
        }

        @Override // com.baidu.tieba.sl7.a
        public void a(vi7 data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                TbLog b = ForumLog.b.b();
                String str = this.a.c;
                b.i(str, "forum " + this.a.g + " request success");
                ViewModel viewModel = new ViewModelProvider(this.a.G()).get(ForumViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
                ForumViewModel forumViewModel = (ForumViewModel) viewModel;
                forumViewModel.c().setValue(data.h());
                forumViewModel.a().setValue(data);
                forumViewModel.g().setValue(data.j());
                ViewModel viewModel2 = new ViewModelProvider(this.a.G()).get(BottomViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(activi…tomViewModel::class.java)");
                ((BottomViewModel) viewModel2).e(data.g());
                this.b.f(data.h().f());
                this.b.g(data.h().g());
            }
        }

        @Override // com.baidu.tieba.sl7.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                TbLog b = ForumLog.b.b();
                String str = this.a.c;
                b.i(str, "forum " + this.a.g + " request error : " + i);
                xoa.a("frs_new", false);
                this.a.D();
                this.a.B();
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
        this.c = "MainController";
        this.g = "";
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<LoadingView>(this) { // from class: com.baidu.tieba.forum.controller.MainController$loadingView$2
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
                    LoadingView loadingView = new LoadingView(this.this$0.G());
                    loadingView.onChangeSkinType();
                    SkinManager.setBackgroundColor(loadingView.getView(), R.color.CAM_X0201);
                    return loadingView;
                }
                return (LoadingView) invokeV.objValue;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new MainController$netRefreshView$2(this));
        this.m = new a(this);
    }

    @Override // com.baidu.tieba.xh7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.i(i);
            if (H().isViewAttached()) {
                H().onChangeSkinType(i);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbLog b2 = ForumLog.b.b();
            String str = this.c;
            b2.i(str, "forum " + this.g + " attach loading view");
            LoadingView H = H();
            ActivityForumBinding activityForumBinding = this.e;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            H.attachView(activityForumBinding.r);
        }
    }

    public final void C() {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                this.j = true;
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbLog b2 = ForumLog.b.b();
            String str = this.c;
            b2.i(str, "forum " + this.g + " detach loading view");
            LoadingView H = H();
            ActivityForumBinding activityForumBinding = this.e;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            H.dettachView(activityForumBinding.r);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbLog b2 = ForumLog.b.b();
            String str = this.c;
            b2.i(str, "forum " + this.g + " detach network refresh view");
            fk5 I = I();
            ActivityForumBinding activityForumBinding = this.e;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            I.dettachView(activityForumBinding.r);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbLog b2 = ForumLog.b.b();
            String str = this.c;
            b2.i(str, "forum " + this.g + " attach network refresh view");
            fk5 I = I();
            ActivityForumBinding activityForumBinding = this.e;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            I.attachView(activityForumBinding.r);
            fp5.a.a(ci7.a(this.b), new Pair<>(PushMessageHelper.ERROR_TYPE, "new_frs_page"), new Pair<>("error_info", "new frs page net error"));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.h) {
                TbLog b2 = ForumLog.b.b();
                String str = this.c;
                b2.i(str, "forum " + this.g + " do force recreate onResume");
                this.h = false;
                this.b.finish();
                Intent intent = this.b.getIntent();
                if (intent != null) {
                    intent.putExtra("key_no_animation", true);
                }
                FragmentActivity fragmentActivity = this.b;
                fragmentActivity.startActivity(fragmentActivity.getIntent());
                this.b.overridePendingTransition(0, 0);
            }
            if (((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).a().getValue() != null) {
                YunDialogManager.onShow(this.b, y05.q);
            }
        }
    }

    public final FragmentActivity G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final LoadingView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (LoadingView) this.k.getValue();
        }
        return (LoadingView) invokeV.objValue;
    }

    public final fk5 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (fk5) this.l.getValue();
        }
        return (fk5) invokeV.objValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            D();
            E();
            br6.b().c(new bk7(true, ci7.a(this.b)));
            L();
        }
    }

    @Override // com.baidu.tieba.xh7
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.e();
            if (this.j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.b).createNormalCfg(2)));
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.m();
            this.i = false;
        }
    }

    @Override // com.baidu.tieba.xh7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.n();
            this.i = true;
            F();
        }
    }

    public final void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            A();
            sl7 sl7Var = this.d;
            if (sl7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumModel");
                sl7Var = null;
            }
            sl7Var.b(bundle);
            TbLog b2 = ForumLog.b.b();
            String str = this.c;
            b2.i(str, "forum " + this.g + " start forum request");
        }
    }

    public final void L() {
        Long l;
        ForumTagInfo forumTagInfo;
        ut7 ut7Var;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            si7 value2 = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
            if (value != null) {
                sf1<ut7> a2 = new iu7().a();
                String str = null;
                if (a2 != null && (ut7Var = a2.get()) != null) {
                    ForumInfo d = value.d();
                    if (d != null) {
                        l2 = d.id;
                    } else {
                        l2 = null;
                    }
                    ut7Var.b(String.valueOf(l2));
                }
                hk7 a3 = hk7.b.a();
                ForumInfo d2 = value.d();
                if (d2 != null) {
                    l = d2.id;
                } else {
                    l = null;
                }
                a3.b(String.valueOf(l), System.currentTimeMillis());
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(value.d());
                zx6 o = zx6.o();
                if (value2 != null) {
                    forumTagInfo = value2.i();
                } else {
                    forumTagInfo = null;
                }
                if (value2 != null) {
                    str = value2.c();
                }
                o.t(forumData, forumTagInfo, str);
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            this.e = binding;
            if (!FeedStat.a.e()) {
                FeedStat.a.h();
            }
            this.d = new sl7(this.b);
            Bundle extras = this.b.getIntent().getExtras();
            if (extras != null) {
                bundle = extras;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f = bundle;
            Bundle bundle2 = null;
            if (bundle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(StateManager.KEY_STATE);
                bundle = null;
            }
            String string = bundle.getString("name");
            if (string == null) {
                string = "";
            }
            this.g = string;
            ForumLog.b.b().i(this.c, "forum " + this.g + " onCreate");
            ll7 ll7Var = new ll7(this.b);
            sl7 sl7Var = this.d;
            if (sl7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumModel");
                sl7Var = null;
            }
            sl7Var.h(new b(this, ll7Var));
            Bundle bundle3 = this.f;
            if (bundle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(StateManager.KEY_STATE);
            } else {
                bundle2 = bundle3;
            }
            K(bundle2);
            C();
            lu4.b.a().c(this.m);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.l();
            TbLog b2 = ForumLog.b.b();
            String str = this.c;
            b2.i(str, "forum " + this.g + " onDestroy");
            sl7 sl7Var = this.d;
            if (sl7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumModel");
                sl7Var = null;
            }
            sl7Var.e();
            lu4.b.a().e(this.m);
        }
    }
}
