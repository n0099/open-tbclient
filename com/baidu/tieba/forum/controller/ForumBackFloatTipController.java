package com.baidu.tieba.forum.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ek7;
import com.baidu.tieba.forum.ForumActivity;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.lu4;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wo7;
import com.baidu.tieba.xh7;
import com.baidu.tieba.zh7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\f\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/tieba/forum/controller/ForumBackFloatTipController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "buttonLayout", "Landroid/view/View;", "hideForumFloatTipListener", "com/baidu/tieba/forum/controller/ForumBackFloatTipController$hideForumFloatTipListener$1", "Lcom/baidu/tieba/forum/controller/ForumBackFloatTipController$hideForumFloatTipListener$1;", "isCopyLinkDialogShowed", "", "view", "Lcom/baidu/tieba/forum/view/ForumBackFloatView;", "addCopyLinkGuideShowFrequency", "", "Landroid/app/Activity;", "buildBackForumBroadcastView", "buildBackForumDoingsView", "handlerShowForumBackTip", "isNeedShowForumCopyLinkGuide", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumBackFloatTipController extends xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public boolean c;
    public wo7 d;
    public View e;
    public ActivityForumBinding f;
    public final a g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(187191023, "Lcom/baidu/tieba/forum/controller/ForumBackFloatTipController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(187191023, "Lcom/baidu/tieba/forum/controller/ForumBackFloatTipController;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements lu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumBackFloatTipController a;

        @Override // com.baidu.tieba.lu4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "frsPageNa.hideForumBackTip" : (String) invokeV.objValue;
        }

        public a(ForumBackFloatTipController forumBackFloatTipController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumBackFloatTipController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumBackFloatTipController;
        }

        @Override // com.baidu.tieba.lu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                wo7 wo7Var = this.a.d;
                boolean z = true;
                if ((wo7Var == null || !wo7Var.b()) ? false : false) {
                    ek7.a.a();
                    wo7 wo7Var2 = this.a.d;
                    if (wo7Var2 != null) {
                        wo7Var2.c(false);
                    }
                }
            }
        }
    }

    public ForumBackFloatTipController(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.g = new a(this);
    }

    @Override // com.baidu.tieba.xh7
    public void i(int i) {
        wo7 wo7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (wo7Var = this.d) != null) {
            wo7Var.a();
        }
    }

    public final wo7 t(ActivityForumBinding activityForumBinding) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, activityForumBinding)) == null) {
            String string = UtilHelper.getString(R.string.obfuscated_res_0x7f0f0810);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.frs_back_forum_broadcast_tip)");
            return new wo7(string, R.color.CAM_X0305, R.drawable.pic_float_return_broadcast32, 0, null, false, 56, null);
        }
        return (wo7) invokeL.objValue;
    }

    public final wo7 u(ActivityForumBinding activityForumBinding) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activityForumBinding)) == null) {
            String string = UtilHelper.getString(R.string.obfuscated_res_0x7f0f0811);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.frs_back_forum_doings_tip)");
            return new wo7(string, R.color.CAM_X0309, R.drawable.obfuscated_res_0x7f08022a, 0, null, false, 56, null);
        }
        return (wo7) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        ForumActivity forumActivity;
        zh7 zh7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            this.f = binding;
            FrameLayout frameLayout = binding.j;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frsForumButtonLayout");
            this.e = frameLayout;
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity instanceof ForumActivity) {
                forumActivity = (ForumActivity) fragmentActivity;
            } else {
                forumActivity = null;
            }
            boolean z = true;
            if (!((forumActivity == null || (zh7Var = (zh7) forumActivity.j2(Reflection.getOrCreateKotlinClass(zh7.class))) == null || !zh7Var.g0(this.b)) ? false : false)) {
                s0();
            }
            lu4.b.a().c(this.g);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.l();
            wo7 wo7Var = this.d;
            boolean z = true;
            if ((wo7Var == null || !wo7Var.b()) ? false : false) {
                ek7.a.a();
            }
            lu4.b.a().e(this.g);
        }
    }

    public final void q1(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.c = true;
            String stringExtra = activity.getIntent().getStringExtra("key_forum_back_tip");
            if (stringExtra != null) {
                int hashCode = stringExtra.hashCode();
                if (hashCode != -1129864942) {
                    if (hashCode == 760342475 && stringExtra.equals("back_forum_broadcast")) {
                        SharedPrefHelper.getInstance().putInt("key_forum_broadcast_edit_tip_number", SharedPrefHelper.getInstance().getInt("key_forum_broadcast_edit_tip_number", 0) + 1);
                    }
                } else if (stringExtra.equals("back_forum_doings")) {
                    SharedPrefHelper.getInstance().putInt("key_forum_doing_edit_tip_number", SharedPrefHelper.getInstance().getInt("key_forum_doing_edit_tip_number", 0) + 1);
                }
            }
        }
    }

    public final boolean w(Activity activity) {
        InterceptResult invokeL;
        String stringExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (this.c || (stringExtra = activity.getIntent().getStringExtra("key_forum_back_tip")) == null) {
                return false;
            }
            int hashCode = stringExtra.hashCode();
            if (hashCode != -1129864942) {
                if (hashCode != 760342475 || !stringExtra.equals("back_forum_broadcast") || 2 <= SharedPrefHelper.getInstance().getInt("key_forum_broadcast_edit_tip_number", 0)) {
                    return false;
                }
            } else if (!stringExtra.equals("back_forum_doings") || 2 <= SharedPrefHelper.getInstance().getInt("key_forum_doing_edit_tip_number", 0)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String stringExtra = this.b.getIntent().getStringExtra("key_forum_back_tip");
            final wo7 wo7Var = null;
            ActivityForumBinding activityForumBinding = null;
            wo7Var = null;
            wo7Var = null;
            ActivityForumBinding activityForumBinding2 = null;
            wo7Var = null;
            if (stringExtra != null) {
                int hashCode = stringExtra.hashCode();
                if (hashCode != -1129864942) {
                    if (hashCode == 760342475 && stringExtra.equals("back_forum_broadcast")) {
                        ActivityForumBinding activityForumBinding3 = this.f;
                        if (activityForumBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityForumBinding = activityForumBinding3;
                        }
                        wo7Var = t(activityForumBinding);
                    }
                } else if (stringExtra.equals("back_forum_doings")) {
                    ActivityForumBinding activityForumBinding4 = this.f;
                    if (activityForumBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityForumBinding2 = activityForumBinding4;
                    }
                    wo7Var = u(activityForumBinding2);
                }
            }
            this.d = wo7Var;
            if (wo7Var != null) {
                FragmentActivity fragmentActivity = this.b;
                if (fragmentActivity instanceof BaseFragmentActivity) {
                    ek7.a.b(wo7Var, (BaseFragmentActivity) fragmentActivity, new Function1<Boolean, Unit>(this, wo7Var) { // from class: com.baidu.tieba.forum.controller.ForumBackFloatTipController$handlerShowForumBackTip$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ wo7 $it;
                        public final /* synthetic */ ForumBackFloatTipController this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, wo7Var};
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
                            this.this$0 = this;
                            this.$it = wo7Var;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            ActivityForumBinding activityForumBinding5;
                            View view2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                                ActivityForumBinding activityForumBinding6 = null;
                                View view3 = null;
                                if (z) {
                                    view2 = this.this$0.e;
                                    if (view2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
                                    } else {
                                        view3 = view2;
                                    }
                                    view3.setVisibility(8);
                                    this.$it.c(true);
                                    return;
                                }
                                BdTopToast content = new BdTopToast(this.this$0.v()).setIcon(false).setContent(UtilHelper.getString(R.string.obfuscated_res_0x7f0f0812));
                                activityForumBinding5 = this.this$0.f;
                                if (activityForumBinding5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                } else {
                                    activityForumBinding6 = activityForumBinding5;
                                }
                                content.show(activityForumBinding6.getRoot());
                            }
                        }
                    });
                }
            }
        }
    }

    public final FragmentActivity v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }
}
