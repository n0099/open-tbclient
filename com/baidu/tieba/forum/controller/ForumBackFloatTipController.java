package com.baidu.tieba.forum.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.forum.controller.ForumBackFloatTipController;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.view.FrsCopyLinkGuideDialogView;
import com.baidu.tieba.fr6;
import com.baidu.tieba.gu4;
import com.baidu.tieba.hi7;
import com.baidu.tieba.hm7;
import com.baidu.tieba.og7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.zz4;
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
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/forum/controller/ForumBackFloatTipController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "buttonLayout", "Landroid/view/View;", "hideForumFloatTipListener", "com/baidu/tieba/forum/controller/ForumBackFloatTipController$hideForumFloatTipListener$1", "Lcom/baidu/tieba/forum/controller/ForumBackFloatTipController$hideForumFloatTipListener$1;", "view", "Lcom/baidu/tieba/forum/view/ForumBackFloatView;", "buildBackForumBroadcastView", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "buildBackForumDoingsView", "handleGuideDialogShow", "", "key", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "showCopyLinkGuideDialog", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumBackFloatTipController extends og7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public hm7 c;
    public View d;
    public final a e;

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
    public static final class a implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumBackFloatTipController a;

        @Override // com.baidu.tieba.gu4.d
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

        @Override // com.baidu.tieba.gu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                hm7 hm7Var = this.a.c;
                boolean z = true;
                if ((hm7Var == null || !hm7Var.b()) ? false : false) {
                    hi7.a.a();
                    hm7 hm7Var2 = this.a.c;
                    if (hm7Var2 != null) {
                        hm7Var2.c(false);
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
        this.e = new a(this);
    }

    @Override // com.baidu.tieba.og7
    public void i(int i) {
        hm7 hm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (hm7Var = this.c) != null) {
            hm7Var.a();
        }
    }

    public final hm7 r(ActivityForumBinding activityForumBinding) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activityForumBinding)) == null) {
            String string = UtilHelper.getString(R.string.obfuscated_res_0x7f0f0808);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.frs_back_forum_broadcast_tip)");
            return new hm7(string, R.color.CAM_X0305, R.drawable.pic_float_return_broadcast32, 0, null, false, 56, null);
        }
        return (hm7) invokeL.objValue;
    }

    public final hm7 s(ActivityForumBinding activityForumBinding) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activityForumBinding)) == null) {
            String string = UtilHelper.getString(R.string.obfuscated_res_0x7f0f0809);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.frs_back_forum_doings_tip)");
            return new hm7(string, R.color.CAM_X0309, R.drawable.obfuscated_res_0x7f080227, 0, null, false, 56, null);
        }
        return (hm7) invokeL.objValue;
    }

    public final void u(String str) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (i = SharedPrefHelper.getInstance().getInt(str, 0)) < 2) {
            v();
            SharedPrefHelper.getInstance().putInt(str, i + 1);
        }
    }

    public static final void w(zz4 dialog, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialog, view2) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            dialog.dismiss();
        }
    }

    @Override // com.baidu.tieba.og7
    public void k(Bundle bundle, final ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            FrameLayout frameLayout = binding.j;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frsForumButtonLayout");
            this.d = frameLayout;
            String stringExtra = this.b.getIntent().getStringExtra("key_forum_back_tip");
            if (Intrinsics.areEqual(stringExtra, "back_forum_doings")) {
                this.c = s(binding);
                u("key_forum_doings_copy_link_guide_show_number");
            } else if (Intrinsics.areEqual(stringExtra, "back_forum_broadcast")) {
                this.c = r(binding);
                u("key_broadcast_doings_copy_link_guide_show_number");
            }
            final hm7 hm7Var = this.c;
            if (hm7Var != null) {
                FragmentActivity fragmentActivity = this.b;
                if (fragmentActivity instanceof BaseFragmentActivity) {
                    hi7.a.b(hm7Var, (BaseFragmentActivity) fragmentActivity, new Function1<Boolean, Unit>(this, hm7Var, binding) { // from class: com.baidu.tieba.forum.controller.ForumBackFloatTipController$onCreate$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ ActivityForumBinding $binding;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ hm7 $it;
                        public final /* synthetic */ ForumBackFloatTipController this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, hm7Var, binding};
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
                            this.$it = hm7Var;
                            this.$binding = binding;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            View view2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                                if (z) {
                                    view2 = this.this$0.d;
                                    if (view2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
                                        view2 = null;
                                    }
                                    view2.setVisibility(8);
                                    this.$it.c(true);
                                    return;
                                }
                                new BdTopToast(this.this$0.t()).setIcon(false).setContent(UtilHelper.getString(R.string.obfuscated_res_0x7f0f080a)).show(this.$binding.getRoot());
                            }
                        }
                    });
                }
            }
            gu4.b.a().c(this.e);
        }
    }

    @Override // com.baidu.tieba.og7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.l();
            hm7 hm7Var = this.c;
            boolean z = true;
            if ((hm7Var == null || !hm7Var.b()) ? false : false) {
                hi7.a.a();
            }
            gu4.b.a().e(this.e);
        }
    }

    public final FragmentActivity t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            final zz4 zz4Var = new zz4(this.b);
            zz4Var.setContentViewSize(2);
            zz4Var.setCanceledOnTouchOutside(false);
            FrsCopyLinkGuideDialogView frsCopyLinkGuideDialogView = new FrsCopyLinkGuideDialogView(this.b, null, 0, 6, null);
            frsCopyLinkGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.qf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ForumBackFloatTipController.w(zz4.this, view2);
                    }
                }
            });
            zz4Var.setContentView(frsCopyLinkGuideDialogView);
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity instanceof fr6) {
                zz4Var.create(((fr6) fragmentActivity).getPageContext()).show();
            } else if (fragmentActivity instanceof TbPageContextSupport) {
                zz4Var.create(((TbPageContextSupport) fragmentActivity).getPageContext()).show();
            }
        }
    }
}
