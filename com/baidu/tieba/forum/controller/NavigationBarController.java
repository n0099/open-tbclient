package com.baidu.tieba.forum.controller;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.ba5;
import com.baidu.tieba.bs7;
import com.baidu.tieba.eoc;
import com.baidu.tieba.forum.ForumActivity;
import com.baidu.tieba.forum.controller.NavigationBarController;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.databinding.ForumNavBarSecondFloorBinding;
import com.baidu.tieba.forum.view.FrsAutoCarouselImageContainer;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.forum.widget.ViewExtentionsKt;
import com.baidu.tieba.gk7;
import com.baidu.tieba.ii7;
import com.baidu.tieba.loc;
import com.baidu.tieba.ni7;
import com.baidu.tieba.nq6;
import com.baidu.tieba.oi7;
import com.baidu.tieba.sh7;
import com.baidu.tieba.soc;
import com.baidu.tieba.tm7;
import com.baidu.tieba.uua;
import com.baidu.tieba.vi7;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.tieba.wm7;
import com.baidu.tieba.xoc;
import com.baidu.tieba.yi7;
import com.baidu.tieba.yoc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.PrivateForumInfo;
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0017J\b\u00106\u001a\u00020&H\u0016J\u000e\u00107\u001a\u00020&2\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010;\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/baidu/tieba/forum/controller/NavigationBarController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "navBarStat", "Lcom/baidu/tieba/forum/statistic/INavBarStat;", "(Landroidx/fragment/app/FragmentActivity;Lcom/baidu/tieba/forum/statistic/INavBarStat;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "autoCarouselImageContainer", "Lcom/baidu/tieba/forum/view/FrsAutoCarouselImageContainer;", "getAutoCarouselImageContainer", "()Lcom/baidu/tieba/forum/view/FrsAutoCarouselImageContainer;", "autoCarouselImageContainer$delegate", "Lkotlin/Lazy;", TaskUIData.keyBackBtn, "Landroid/widget/ImageView;", "forumIcon", "Lcom/baidu/tbadk/core/view/BarImageView;", "forumInfoLayout", "Landroid/view/View;", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "Lcom/baidu/tieba/view/SymbolEMTextView;", "messageIconController", "Lcom/baidu/tieba/controller/MessageIconController;", "messageSubscription", "Lrx/Subscription;", "getNavBarStat", "()Lcom/baidu/tieba/forum/statistic/INavBarStat;", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "privateForumStatusTextView", "Landroid/widget/TextView;", "searchBtn", "secondFloorIconBinding", "Lcom/baidu/tieba/forum/databinding/ForumNavBarSecondFloorBinding;", "shareBtn", "adjustForumNameWidth", "", "checkIsNotPrivateManager", "", "forumData", "Lcom/baidu/tieba/forum/data/ForumData;", "configAiChatRoomGuideData", "configPrivateForumStatus", "expandSecondFloor", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", MissionEvent.MESSAGE_DESTROY, "setForumInfoAlpha", Key.ALPHA, "", "setNavigationBarCenterArea", "setPrivateForumStatus", "subscribeMessage", "subscribeNavSecondFloorEntranceVisibility", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NavigationBarController extends sh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final wm7 c;
    public NavigationBar d;
    public ImageView e;
    public View f;
    public BarImageView g;
    public SymbolEMTextView h;
    public ForumNavBarSecondFloorBinding i;
    public ImageView j;
    public ImageView k;
    public nq6 l;
    public loc m;
    public TextView n;
    public final Lazy o;

    public NavigationBarController(FragmentActivity activity, wm7 navBarStat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, navBarStat};
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
        Intrinsics.checkNotNullParameter(navBarStat, "navBarStat");
        this.b = activity;
        this.c = navBarStat;
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<FrsAutoCarouselImageContainer>(this) { // from class: com.baidu.tieba.forum.controller.NavigationBarController$autoCarouselImageContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NavigationBarController this$0;

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
            public final FrsAutoCarouselImageContainer invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    FrsAutoCarouselImageContainer frsAutoCarouselImageContainer = new FrsAutoCarouselImageContainer(this.this$0.y(), null, 0, 6, null);
                    frsAutoCarouselImageContainer.setVisibility(8);
                    return frsAutoCarouselImageContainer;
                }
                return (FrsAutoCarouselImageContainer) invokeV.objValue;
            }
        });
    }

    public static final void C(NavigationBarController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (ViewHelper.checkUpIsLogin(this$0.b)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this$0.b)));
                nq6 nq6Var = this$0.l;
                nq6 nq6Var2 = null;
                if (nq6Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                    nq6Var = null;
                }
                nq6Var.e();
                wm7 wm7Var = this$0.c;
                nq6 nq6Var3 = this$0.l;
                if (nq6Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                } else {
                    nq6Var2 = nq6Var3;
                }
                wm7Var.a(nq6Var2.a());
            }
        }
    }

    public static final void D(NavigationBarController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewModel viewModel = new ViewModelProvider(this$0.b).get(ForumViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
            oi7 value = ((ForumViewModel) viewModel).a().getValue();
            if (value != null) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).shareForum(this$0.b, value.a());
            }
            this$0.c.b();
        }
    }

    public static final void M(NavigationBarController this$0, NewsRemindMessage newsRemindMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, this$0, newsRemindMessage) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
            if (!newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            if (TbadkCoreApplication.isLogin()) {
                nq6 nq6Var = this$0.l;
                if (nq6Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                    nq6Var = null;
                }
                nq6Var.g(z, msgCount);
            }
        }
    }

    public static final void u(NavigationBarController this$0, LinearLayout it) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            FrsAutoCarouselImageContainer z = this$0.z();
            int width = it.getWidth();
            ViewGroup.LayoutParams layoutParams = this$0.z().getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = 0;
            if (marginLayoutParams2 != null) {
                i = marginLayoutParams2.leftMargin;
            } else {
                i = 0;
            }
            int i3 = width - i;
            ViewGroup.LayoutParams layoutParams2 = this$0.z().getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams;
            if (marginLayoutParams3 != null) {
                i2 = marginLayoutParams3.rightMargin;
            }
            z.setMaxWidth(i3 - i2);
        }
    }

    public static final void A(NavigationBarController this$0, ni7 forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, forumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SymbolEMTextView symbolEMTextView = this$0.h;
            NavigationBar navigationBar = null;
            if (symbolEMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
                symbolEMTextView = null;
            }
            symbolEMTextView.setText(forumData.f() + (char) 21543);
            BarImageView barImageView = this$0.g;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                barImageView = null;
            }
            boolean z = false;
            barImageView.startLoad(forumData.d(), 45, false);
            String n = forumData.n();
            if (n.length() == 0) {
                z = true;
            }
            if (z) {
                n = "#142354";
            }
            NavigationBar navigationBar2 = this$0.d;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            } else {
                navigationBar = navigationBar2;
            }
            navigationBar.getBarBgView().setBackgroundColor(uua.f(n));
            Intrinsics.checkNotNullExpressionValue(forumData, "forumData");
            this$0.F(forumData);
        }
    }

    public static final void B(NavigationBarController this$0, View view2) {
        String str;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewModel viewModel = new ViewModelProvider(this$0.b).get(ForumViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…rumViewModel::class.java)");
            ForumViewModel forumViewModel = (ForumViewModel) viewModel;
            ni7 value = forumViewModel.c().getValue();
            TbPageContext<?> tbPageContext = null;
            if (value != null) {
                str = value.f();
            } else {
                str = null;
            }
            ni7 value2 = forumViewModel.c().getValue();
            if (value2 != null) {
                l = Long.valueOf(value2.e());
            } else {
                l = null;
            }
            String i = bs7.i("frs", str, String.valueOf(l));
            Intrinsics.checkNotNullExpressionValue(i, "openHybridBarSearchPage(….toString()\n            )");
            BdPageContext<?> a = a5.a(this$0.b);
            if (a instanceof TbPageContext) {
                tbPageContext = (TbPageContext) a;
            }
            if (tbPageContext != null) {
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{i});
            }
            this$0.c.d();
        }
    }

    public static final void G(NavigationBarController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            tm7.a(5);
            this$0.x();
        }
    }

    public static final Pair K(NewsRemindMessage newsRemindMessage, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, newsRemindMessage, bool)) == null) {
            return Pair.create(newsRemindMessage, bool);
        }
        return (Pair) invokeLL.objValue;
    }

    public static final void P(NavigationBarController this$0, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding = this$0.i;
            if (forumNavBarSecondFloorBinding != null) {
                gk7.d(forumNavBarSecondFloorBinding, bool);
            }
        }
    }

    public static final void v(NavigationBarController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.x();
            tm7.a(2);
        }
    }

    public static final void I(NavigationBarController this$0, String urlStr, ni7 forumData, int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{this$0, urlStr, forumData, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(urlStr, "$urlStr");
            Intrinsics.checkNotNullParameter(forumData, "$forumData");
            this$0.c.c(urlStr, forumData.e(), forumData.f(), i);
            UrlManager.getInstance().dealOneLink(new String[]{urlStr});
        }
    }

    public static final NewsRemindMessage L(Pair pair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pair)) == null) {
            return (NewsRemindMessage) pair.first;
        }
        return (NewsRemindMessage) invokeL.objValue;
    }

    public static final Boolean N(NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, newsRemindMessage)) == null) {
            if (newsRemindMessage != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public static final void q(NavigationBarController this$0) {
        FrameLayout frameLayout;
        ViewParent viewParent;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding = this$0.i;
            SymbolEMTextView symbolEMTextView = null;
            if (forumNavBarSecondFloorBinding != null) {
                frameLayout = forumNavBarSecondFloorBinding.getRoot();
            } else {
                frameLayout = null;
            }
            if (frameLayout != null) {
                viewParent = frameLayout.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                i = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
            } else {
                i = 0;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            ImageView imageView = this$0.j;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
                imageView = null;
            }
            imageView.getGlobalVisibleRect(rect);
            ImageView imageView2 = this$0.e;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TaskUIData.keyBackBtn);
                imageView2 = null;
            }
            imageView2.getGlobalVisibleRect(rect2);
            SymbolEMTextView symbolEMTextView2 = this$0.h;
            if (symbolEMTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
            } else {
                symbolEMTextView = symbolEMTextView2;
            }
            symbolEMTextView.setWidth((((rect.left - i) - rect2.right) - dimenPixelSize) - dimenPixelSize2);
        }
    }

    public final void E(float f) {
        boolean z;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            View view2 = this.f;
            TextView textView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumInfoLayout");
                view2 = null;
            }
            ViewExtentionsKt.l(view2, f);
            NavigationBar navigationBar = this.d;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar = null;
            }
            navigationBar.getBarBgView().setAlpha(f);
            TextView textView2 = this.n;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
            } else {
                textView = textView2;
            }
            boolean z2 = true;
            float f3 = 0.0f;
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            textView.setAlpha(f2);
            FrsAutoCarouselImageContainer z3 = z();
            if (i != 0) {
                z2 = false;
            }
            if (z2) {
                f3 = 1.0f;
            }
            z3.setAlpha(f3);
            ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding = this.i;
            if (forumNavBarSecondFloorBinding != null) {
                gk7.e(forumNavBarSecondFloorBinding, z());
            }
        }
    }

    public final void F(ni7 ni7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni7Var) == null) {
            w(ni7Var);
            ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding = this.i;
            NavigationBar navigationBar = this.d;
            TextView textView = null;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar = null;
            }
            TextView textView2 = this.n;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                textView2 = null;
            }
            this.i = gk7.b(forumNavBarSecondFloorBinding, navigationBar, ni7Var, textView2, new View.OnClickListener() { // from class: com.baidu.tieba.ug7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        NavigationBarController.G(NavigationBarController.this, view2);
                    }
                }
            });
            TextView textView3 = this.n;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
            } else {
                textView = textView3;
            }
            if (textView.getVisibility() == 8) {
                t(ni7Var);
            }
            p();
        }
    }

    public final void w(ni7 ni7Var) {
        PrivateForumInfo a;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ni7Var) == null) {
            if (!s(ni7Var)) {
                vi7 k = ni7Var.k();
                boolean z = true;
                if ((k == null || (a = k.a()) == null || (num = a.private_forum_status) == null || num.intValue() != 1) ? false : false) {
                    H(ni7Var);
                    return;
                }
            }
            TextView textView = this.n;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                textView = null;
            }
            textView.setVisibility(8);
        }
    }

    public final void H(final ni7 ni7Var) {
        Integer num;
        int intValue;
        boolean z;
        final String format;
        Integer b;
        PrivateForumInfo a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ni7Var) == null) {
            vi7 k = ni7Var.k();
            TextView textView = null;
            if (k != null && (a = k.a()) != null) {
                num = a.private_forum_audit_status;
            } else {
                num = null;
            }
            int i = -1;
            if (num == null) {
                intValue = -1;
            } else {
                intValue = num.intValue();
            }
            vi7 k2 = ni7Var.k();
            if (k2 != null && (b = k2.b()) != null) {
                i = b.intValue();
            }
            final int i2 = 2;
            if (intValue == 2) {
                TextView textView2 = this.n;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    textView2 = null;
                }
                textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f119e));
                TextView textView3 = this.n;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format(yi7.b(), Arrays.copyOf(new Object[]{Long.valueOf(ni7Var.e())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                if (i >= 0 && i < 101) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    TextView textView4 = this.n;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                        textView4 = null;
                    }
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string = this.b.getString(R.string.obfuscated_res_0x7f0f119f);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…atus_check_task_progress)");
                    String format2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    textView4.setText(format2);
                    TextView textView5 = this.n;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                        textView5 = null;
                    }
                    textView5.setVisibility(0);
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    format = String.format(yi7.a(), Arrays.copyOf(new Object[]{Long.valueOf(ni7Var.e()), ni7Var.f()}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    i2 = 1;
                } else {
                    TextView textView6 = this.n;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    } else {
                        textView = textView6;
                    }
                    textView.setVisibility(8);
                    return;
                }
            }
            TextView textView7 = this.n;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
            } else {
                textView = textView7;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.eg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        NavigationBarController.I(NavigationBarController.this, format, ni7Var, i2, view2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.sh7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.i(i);
            SvgManager svgManager = SvgManager.getInstance();
            ImageView imageView = this.e;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TaskUIData.keyBackBtn);
                imageView = null;
            }
            svgManager.setPureDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SymbolEMTextView symbolEMTextView = this.h;
            if (symbolEMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
                symbolEMTextView = null;
            }
            EMManager.from(symbolEMTextView).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02);
            SvgManager svgManager2 = SvgManager.getInstance();
            ImageView imageView2 = this.k;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
                imageView2 = null;
            }
            svgManager2.setPureDrawableWithDayNightModeAutoChange(imageView2, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            nq6 nq6Var = this.l;
            if (nq6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                nq6Var = null;
            }
            nq6Var.f(i);
            nq6 nq6Var2 = this.l;
            if (nq6Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                nq6Var2 = null;
            }
            nq6Var2.c().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            SvgManager svgManager3 = SvgManager.getInstance();
            ImageView imageView3 = this.j;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
                imageView3 = null;
            }
            svgManager3.setPureDrawableWithDayNightModeAutoChange(imageView3, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = BdUtilHelper.getDimens(this.b, R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            TextView textView2 = this.n;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                textView2 = null;
            }
            textView2.setCompoundDrawables(null, null, drawable, null);
            TextView textView3 = this.n;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
            } else {
                textView = textView3;
            }
            EMManager.from(textView).setCorner(R.string.J_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.white_alpha100).setBackGroundColor(R.color.black_alpha20);
            z().b();
        }
    }

    public final void t(ni7 ni7Var) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ni7Var) == null) {
            ii7 a = ni7Var.a();
            if (a != null && a.g()) {
                z().setVisibility(0);
                ViewGroup.LayoutParams layoutParams = z().getLayoutParams();
                final LinearLayout linearLayout = null;
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.setMargins(BdUtilHelper.getDimens(this.b, R.dimen.M_W_X006), 0, BdUtilHelper.getDimens(this.b, R.dimen.M_W_X006), 0);
                }
                ViewParent parent = z().getParent();
                if (parent instanceof LinearLayout) {
                    linearLayout = (LinearLayout) parent;
                }
                if (linearLayout != null) {
                    linearLayout.setGravity(21);
                    z().post(new Runnable() { // from class: com.baidu.tieba.kh7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                NavigationBarController.u(NavigationBarController.this, linearLayout);
                            }
                        }
                    });
                }
                if (a.e() && a.d() != null) {
                    z().setTipText(a.d().c());
                    z().d(CollectionsKt__CollectionsJVMKt.listOf(a.d().b()));
                    ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding = this.i;
                    if (forumNavBarSecondFloorBinding != null) {
                        gk7.d(forumNavBarSecondFloorBinding, Boolean.TRUE);
                    }
                } else {
                    z().setTipText(a.b().b());
                    z().d(a.b().a());
                    ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding2 = this.i;
                    if (forumNavBarSecondFloorBinding2 != null) {
                        gk7.d(forumNavBarSecondFloorBinding2, Boolean.FALSE);
                    }
                }
                ForumNavBarSecondFloorBinding forumNavBarSecondFloorBinding3 = this.i;
                if (forumNavBarSecondFloorBinding3 != null) {
                    gk7.e(forumNavBarSecondFloorBinding3, z());
                }
                O();
                z().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jg7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            NavigationBarController.v(NavigationBarController.this, view2);
                        }
                    }
                });
                tm7.a(1);
                return;
            }
            z().setVisibility(8);
        }
    }

    public final void J() {
        ba5 ba5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ba5Var = (ba5) ServiceManager.getService(ba5.a)) != null) {
            loc H = eoc.c(ba5Var.g().k(new xoc() { // from class: com.baidu.tieba.yg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.xoc
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? NavigationBarController.N((NewsRemindMessage) obj) : invokeL.objValue;
                }
            }), ba5Var.c(), new yoc() { // from class: com.baidu.tieba.ah7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yoc
                public final Object a(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? NavigationBarController.K((NewsRemindMessage) obj, (Boolean) obj2) : invokeLL.objValue;
                }
            }).p(new xoc() { // from class: com.baidu.tieba.sg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.xoc
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? NavigationBarController.L((Pair) obj) : invokeL.objValue;
                }
            }).H(new soc() { // from class: com.baidu.tieba.ih7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.soc
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        NavigationBarController.M(NavigationBarController.this, (NewsRemindMessage) obj);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(H, "combineLatest<NewsRemind…  }\n                    }");
            this.m = H;
        }
    }

    public final void x() {
        ForumActivity forumActivity;
        LinkageController linkageController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !ViewHelper.checkUpIsLogin(this.b)) {
            return;
        }
        FragmentActivity fragmentActivity = this.b;
        if (fragmentActivity instanceof ForumActivity) {
            forumActivity = (ForumActivity) fragmentActivity;
        } else {
            forumActivity = null;
        }
        if (forumActivity != null && (linkageController = (LinkageController) forumActivity.j2(Reflection.getOrCreateKotlinClass(LinkageController.class))) != null) {
            linkageController.Z();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).e().observe(this.b, new Observer() { // from class: com.baidu.tieba.dh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        NavigationBarController.P(NavigationBarController.this, (Boolean) obj);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.sh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.l();
            loc locVar = this.m;
            if (locVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSubscription");
                locVar = null;
            }
            locVar.unsubscribe();
            this.i = null;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            NavigationBar navigationBar = this.d;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar = null;
            }
            navigationBar.post(new Runnable() { // from class: com.baidu.tieba.ag7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NavigationBarController.q(NavigationBarController.this);
                    }
                }
            });
        }
    }

    public final FragmentActivity y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final FrsAutoCarouselImageContainer z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (FrsAutoCarouselImageContainer) this.o.getValue();
        }
        return (FrsAutoCarouselImageContainer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sh7
    @SuppressLint({"SetTextI18n"})
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            NavigationBar navigationBar = binding.p;
            Intrinsics.checkNotNullExpressionValue(navigationBar, "binding.navBar");
            this.d = navigationBar;
            NavigationBar navigationBar2 = null;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar = null;
            }
            View findViewById = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
            Intrinsics.checkNotNullExpressionValue(findViewById, "backBtnLayout.findViewBy….widget_navi_back_button)");
            this.e = (ImageView) findViewById;
            NavigationBar navigationBar3 = this.d;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar3 = null;
            }
            View addCustomView = navigationBar3.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d031f, (View.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(addCustomView, "navigationBar.addCustomV…fo_layout, null\n        )");
            this.f = addCustomView;
            NavigationBar navigationBar4 = this.d;
            if (navigationBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                navigationBar4 = null;
            }
            View addCustomView2 = navigationBar4.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d03ba, (View.OnClickListener) null);
            if (addCustomView2 != null) {
                TextView textView = (TextView) addCustomView2;
                this.n = textView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privateForumStatusTextView");
                    textView = null;
                }
                textView.setVisibility(8);
                View view2 = this.f;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumInfoLayout");
                    view2 = null;
                }
                View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f09115b);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "forumInfoLayout.findViewById(R.id.img_forum_icon)");
                BarImageView barImageView = (BarImageView) findViewById2;
                this.g = barImageView;
                if (barImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView = null;
                }
                barImageView.setShowOval(true);
                BarImageView barImageView2 = this.g;
                if (barImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView2 = null;
                }
                barImageView2.setAutoChangeStyle(true);
                BarImageView barImageView3 = this.g;
                if (barImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView3 = null;
                }
                barImageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                BarImageView barImageView4 = this.g;
                if (barImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumIcon");
                    barImageView4 = null;
                }
                barImageView4.setPlaceHolder(1);
                View view3 = this.f;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumInfoLayout");
                    view3 = null;
                }
                View findViewById3 = view3.findViewById(R.id.obfuscated_res_0x7f092599);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "forumInfoLayout.findViewById(R.id.text_forum_name)");
                this.h = (SymbolEMTextView) findViewById3;
                ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().observe(this.b, new Observer() { // from class: com.baidu.tieba.ch7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            NavigationBarController.A(NavigationBarController.this, (ni7) obj);
                        }
                    }
                });
                E(0.0f);
                NavigationBar navigationBar5 = this.d;
                if (navigationBar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                    navigationBar5 = null;
                }
                navigationBar5.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, z(), (View.OnClickListener) null);
                NavigationBar navigationBar6 = this.d;
                if (navigationBar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                    navigationBar6 = null;
                }
                View addCustomView3 = navigationBar6.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0321, new View.OnClickListener() { // from class: com.baidu.tieba.fg7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                            NavigationBarController.B(NavigationBarController.this, view4);
                        }
                    }
                });
                if (addCustomView3 != null) {
                    this.j = (ImageView) addCustomView3;
                    this.l = new nq6(this.b);
                    NavigationBar navigationBar7 = this.d;
                    if (navigationBar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                        navigationBar7 = null;
                    }
                    NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
                    nq6 nq6Var = this.l;
                    if (nq6Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                        nq6Var = null;
                    }
                    navigationBar7.addCustomView(controlAlign, nq6Var.d(), new View.OnClickListener() { // from class: com.baidu.tieba.kg7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                                NavigationBarController.C(NavigationBarController.this, view4);
                            }
                        }
                    });
                    NavigationBar navigationBar8 = this.d;
                    if (navigationBar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                        navigationBar8 = null;
                    }
                    View addCustomView4 = navigationBar8.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0323, new View.OnClickListener() { // from class: com.baidu.tieba.og7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                                NavigationBarController.D(NavigationBarController.this, view4);
                            }
                        }
                    });
                    if (addCustomView4 != null) {
                        this.k = (ImageView) addCustomView4;
                        J();
                        nq6 nq6Var2 = this.l;
                        if (nq6Var2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("messageIconController");
                            nq6Var2 = null;
                        }
                        NavigationBar navigationBar9 = this.d;
                        if (navigationBar9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                        } else {
                            navigationBar2 = navigationBar9;
                        }
                        nq6Var2.l(navigationBar2, true);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final boolean s(ni7 ni7Var) {
        InterceptResult invokeL;
        PrivateForumInfo privateForumInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ni7Var)) == null) {
            vi7 k = ni7Var.k();
            if (k != null) {
                privateForumInfo = k.a();
            } else {
                privateForumInfo = null;
            }
            if (privateForumInfo != null) {
                UserData q = ni7Var.q();
                if (q != null && q.getIs_manager() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
