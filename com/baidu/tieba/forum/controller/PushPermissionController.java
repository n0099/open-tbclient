package com.baidu.tieba.forum.controller;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.cga;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.l68;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.ri7;
import com.baidu.tieba.vb5;
import com.baidu.tieba.wh7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u001a\u0010'\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010(\u001a\u00020\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/baidu/tieba/forum/controller/PushPermissionController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "isPushPermissionDialogShowing", "", "()Z", "mHasShowFollowDialog", "", "", "Ljava/util/Date;", "getMHasShowFollowDialog", "()Ljava/util/Map;", "setMHasShowFollowDialog", "(Ljava/util/Map;)V", "mIsShowFollow", "getMIsShowFollow", "setMIsShowFollow", "(Z)V", "mPushOpenFloatView", "Lcom/baidu/tbadk/coreExtra/util/PushOpenFloatView;", "getMPushOpenFloatView", "()Lcom/baidu/tbadk/coreExtra/util/PushOpenFloatView;", "setMPushOpenFloatView", "(Lcom/baidu/tbadk/coreExtra/util/PushOpenFloatView;)V", "dismissPushPermissionDialog", "", "getTempForumData", "Lcom/baidu/tbadk/core/data/ForumData;", "forumInfo", "Lcom/baidu/tieba/forum/data/ForumData;", "isShowFollowDialog", "fid", MissionEvent.MESSAGE_PAUSE, "onResume", "showPushPermissionDialog", "isNew", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PushPermissionController extends wh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentActivity b;
    public vb5 c;
    public Map<String, Date> d;
    public boolean e;

    public PushPermissionController(FragmentActivity activity) {
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
        this.d = new HashMap();
    }

    public final ForumData t(ri7 ri7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ri7Var)) == null) {
            if (ri7Var == null) {
                return null;
            }
            ForumData forumData = new ForumData();
            forumData.setId(String.valueOf(ri7Var.e()));
            forumData.setName(ri7Var.f());
            forumData.setImage_url(ri7Var.d());
            forumData.setSlogan(ri7Var.g());
            return forumData;
        }
        return (ForumData) invokeL.objValue;
    }

    public static /* synthetic */ void y(PushPermissionController pushPermissionController, ri7 ri7Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        pushPermissionController.x(ri7Var, z);
    }

    @Override // com.baidu.tieba.wh7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.m();
            p();
        }
    }

    public final void p() {
        vb5 vb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (vb5Var = this.c) != null) {
            Intrinsics.checkNotNull(vb5Var);
            vb5Var.o();
        }
    }

    public final Map<String, Date> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (Map) invokeV.objValue;
    }

    public final vb5 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (vb5) invokeV.objValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            vb5 vb5Var = this.c;
            if (vb5Var != null) {
                Intrinsics.checkNotNull(vb5Var);
                if (vb5Var.r()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wh7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.n();
            final ri7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
            if (value == null) {
                return;
            }
            final String f = value.f();
            l68.a.e(f, new Function1<Integer, Unit>(f, this, value) { // from class: com.baidu.tieba.forum.controller.PushPermissionController$onResume$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ri7 $forumData;
                public final /* synthetic */ String $forumName;
                public final /* synthetic */ PushPermissionController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {f, this, value};
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
                    this.$forumName = f;
                    this.this$0 = this;
                    this.$forumData = value;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i > 0) {
                        l68.a.d(this.$forumName);
                        PushPermissionController.y(this.this$0, this.$forumData, false, 2, null);
                    }
                }
            });
        }
    }

    public final Date v(String str) {
        InterceptResult invokeL;
        Map<String, Date> hasShowTip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.d == null) {
                hasShowTip = new HashMap<>();
            } else {
                hasShowTip = TbSingleton.getInstance().getHasShowTip();
            }
            this.d = hasShowTip;
            Date date = new Date(System.currentTimeMillis());
            Map<String, Date> map = this.d;
            if (map != null) {
                Intrinsics.checkNotNull(map);
                if (map.containsKey(str)) {
                    Map<String, Date> map2 = this.d;
                    Intrinsics.checkNotNull(map2);
                    if (TimeHelper.getDayDifference(map2.get(str), date) >= 1) {
                        this.e = true;
                    }
                    return date;
                }
            }
            this.e = true;
            return date;
        }
        return (Date) invokeL.objValue;
    }

    public final void w(vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vb5Var) == null) {
            this.c = vb5Var;
        }
    }

    public final void x(ri7 ri7Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048585, this, ri7Var, z) == null) && (this.b instanceof BaseFragmentActivity) && ri7Var != null) {
            String valueOf = String.valueOf(ri7Var.e());
            Date v = v(valueOf);
            TbPageContext<BaseFragmentActivity> pageContext = ((BaseFragmentActivity) this.b).getPageContext();
            if (pageContext == null) {
                return;
            }
            cga j = PushGuideManager.j("forum_follow");
            if (j != null && this.e) {
                j.e(t(ri7Var));
                j.k(pageContext, new PushPermissionController$showPushPermissionDialog$1(this, pageContext, j, valueOf, v));
            } else if (!z) {
                BdUtilHelper.showToastByTextCenter(TbadkCoreApplication.getInst(), R.string.push_like_tip_msg);
            }
        }
    }
}
